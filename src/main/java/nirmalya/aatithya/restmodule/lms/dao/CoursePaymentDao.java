package nirmalya.aatithya.restmodule.lms.dao;

import com.razorpay.Order;
import nirmalya.aatithya.restmodule.lms.services.RazorpayService;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class CoursePaymentDao {

  private final JdbcTemplate jdbc;
  private final RazorpayService razorpayService;

  public CoursePaymentDao(JdbcTemplate jdbc, RazorpayService razorpayService) {
    this.jdbc = jdbc;
    this.razorpayService = razorpayService;
  }

  /**
   * Generate a unique order code for COURSE_BUY.
   * Uses timestamp + random suffix and verifies against DB.
   */
  private String generateUniqueOrderCode() {
    int attempts = 0;
    while (attempts < 5) {
      attempts++;
      long ts = System.currentTimeMillis();
      int rnd = ThreadLocalRandom.current().nextInt(1000, 9999);
      String code = "COURSE-" + ts + "-" + rnd;

      Integer cnt = jdbc.queryForObject(
          "SELECT COUNT(*) FROM lms_payment_order WHERE order_code = ?",
          Integer.class,
          code
      );
      if (cnt == null || cnt == 0) {
        return code;
      }
      // else: try again
    }
    throw new IllegalStateException("Unable to generate unique order code for COURSE_BUY");
  }

  /**
   * Create Razorpay order + lms_payment_order rows for COURSE_BUY.
   *
   * Input body (from controller):
   * {
   *   "userId": "TCM00000077",
   *   "productIds": ["PRD000045","PRD000123"],
   *   "trainingId": "PRD000045_tr001-Books,PRD000045_tr002-LMS", // optional CSV
   *   "amountPaise": 118000,
   *   "paymentMethod": "upi" | "card" | "netbanking" | "cod",
   *   "email": "...",
   *   "address": "...",
   *   "city": "...",
   *   "zip": "..."
   * }
   */
  @SuppressWarnings("unchecked")
  public Map<String, Object> createCourseOrder(Map<String, Object> body) throws Exception {

    Map<String, Object> out = new HashMap<String, Object>();
    out.put("status", "ERROR");

    String userId = asString(body.get("userId"));
    Object pidsObj = body.get("productIds");
    List<String> productIds = null;
    if (pidsObj instanceof List<?>) {
      productIds = (List<String>) pidsObj;
    }

    String trainingIdCsv = asString(body.get("trainingId")); // CSV of trainings (can be null)
    Integer amountPaiseInt = asInteger(body.get("amountPaise"));
    String paymentMethod = asString(body.get("paymentMethod"));

    String email = asString(body.get("email"));
    String address = asString(body.get("address"));
    String city = asString(body.get("city"));
    String zip = asString(body.get("zip"));

    if (userId == null || userId.trim().isEmpty()) {
      out.put("message", "userId required");
      return out;
    }
    if (productIds == null || productIds.isEmpty()) {
      out.put("message", "productIds required");
      return out;
    }
    if (amountPaiseInt == null || amountPaiseInt <= 0) {
      out.put("message", "amountPaise must be > 0");
      return out;
    }

    long amountPaise = amountPaiseInt.longValue();
    final String currency = "INR";

    // 🔴 OLD (problematic):
    // final String orderCode = "COURSE-" + System.currentTimeMillis();

    // ✅ NEW: guaranteed-unique order code
    final String orderCode = generateUniqueOrderCode();

    // 1) Call your RazorpayService to create the order
    JSONObject notes = new JSONObject();
    notes.put("source", "COURSE_CHECKOUT");
    notes.put("userId", userId);
    notes.put("productIds", productIds);
    if (trainingIdCsv != null) {
      notes.put("trainingId", trainingIdCsv);
    }
    if (paymentMethod != null) {
      notes.put("paymentMethod", paymentMethod);
    }
    if (email != null) {
      notes.put("email", email);
    }

    Order order = razorpayService.createOrder(amountPaise, currency, orderCode, notes);
    String razorpayOrderId = order.get("id");

    // 2) Build gateway_payload JSON for lms_payment_order
    JSONObject gw = new JSONObject();
    gw.put("source", "COURSE_CHECKOUT");
    gw.put("userId", userId);
    gw.put("productIds", productIds);
    gw.put("trainingId", trainingIdCsv);
    gw.put("amountPaise", amountPaise);
    gw.put("paymentMethod", paymentMethod);
    gw.put("currency", currency);
    gw.put("razorpayOrderId", razorpayOrderId);
    if (email != null) gw.put("email", email);
    if (address != null) gw.put("address", address);
    if (city != null) gw.put("city", city);
    if (zip != null) gw.put("zip", zip);

    String payloadStr = gw.toString();

    // 3) Insert into lms_payment_order (one row per product)
    int n = productIds.size();
    int basePerItem = amountPaiseInt / n;
    int remainder = amountPaiseInt - (basePerItem * n);

    for (int i = 0; i < n; i++) {
      String productId = productIds.get(i);
      int itemAmount = basePerItem + (i == 0 ? remainder : 0);

      jdbc.update(
          "INSERT INTO lms_payment_order " +
              "(order_code, user_id, product_id, training_id, amount_paise, currency, purpose, status, gateway_payload, created_at, paid_at) " +
              "VALUES (?,?,?,?,?,?, 'COURSE_BUY', 'CREATED', CAST(? AS JSON), NOW(), NULL)",
          orderCode,
          userId,
          productId,
          null,           // training_id (optional; we already have trainingIdCsv in gateway_payload)
          itemAmount,
          currency,
          payloadStr
      );
    }

    out.put("status", "OK");
    out.put("message", "Order created");
    out.put("keyId", razorpayService.getKeyId());
    out.put("orderCode", orderCode);
    out.put("amountPaise", amountPaiseInt);
    out.put("currency", currency);
    out.put("razorpayOrderId", razorpayOrderId);

    return out;
  }

  /**
   * Confirm Razorpay payment for course purchase.
   * Expects body:
   * {
   *   "userId": "TCM00000077",
   *   "orderCode": "COURSE-...-1234",
   *   "razorpayOrderId": "order_xxx",
   *   "razorpayPaymentId": "pay_xxx",
   *   "razorpaySignature": "..."
   * }
   */
  public void confirmCoursePayment(Map<String, Object> body) throws Exception {

    String orderCode = asString(body.get("orderCode"));
    String razorpayOrderId = asString(body.get("razorpayOrderId"));
    String razorpayPaymentId = asString(body.get("razorpayPaymentId"));
    String razorpaySignature = asString(body.get("razorpaySignature"));

    if (orderCode == null || razorpayOrderId == null || razorpayPaymentId == null || razorpaySignature == null) {
      throw new IllegalArgumentException("Missing payment parameters");
    }

    boolean valid = razorpayService.verifySignature(
        razorpayOrderId,
        razorpayPaymentId,
        razorpaySignature
    );

    if (!valid) {
      throw new IllegalArgumentException("Invalid Razorpay signature");
    }

    // Mark all rows for this orderCode as PAID
    jdbc.update(
        "UPDATE lms_payment_order " +
            "SET status = 'PAID', " +
            "    paid_at = NOW(), " +
            "    gateway_payload = JSON_SET(" +
            "        COALESCE(gateway_payload, JSON_OBJECT()), " +
            "        '$.razorpayPaymentId', ?, " +
            "        '$.razorpaySignature', ?, " +
            "        '$.signatureVerified', TRUE" +
            "    ) " +
            "WHERE order_code = ?",
        razorpayPaymentId,
        razorpaySignature,
        orderCode
    );
  }


  
  /* ------------ helpers ------------ */

  private String asString(Object o) {
    return (o == null ? null : String.valueOf(o));
  }

  private Integer asInteger(Object o) {
    if (o == null) return null;
    if (o instanceof Number) return Integer.valueOf(((Number) o).intValue());
    try {
      return Integer.valueOf(Integer.parseInt(String.valueOf(o)));
    } catch (NumberFormatException ex) {
      return null;
    }
  }
}
