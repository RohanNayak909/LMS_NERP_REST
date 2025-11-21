package nirmalya.aatithya.restmodule.lms.controller;

import com.razorpay.Order;
import nirmalya.aatithya.restmodule.lms.dao.ExamPaymentDao;
import nirmalya.aatithya.restmodule.lms.services.RazorpayService;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/master/payment")
@CrossOrigin(origins = "*")
public class paymentController {

  private final ExamPaymentDao paymentDao;
  private final RazorpayService razorpayService;

  public paymentController(ExamPaymentDao paymentDao, RazorpayService razorpayService) {
    this.paymentDao = paymentDao;
    this.razorpayService = razorpayService;
  }

  /* ==================== DTOs ==================== */

  public static class RetakeCreateRequest {
    public String userId;
    public String productId;
    public Integer trainingId;
    public String quizCode;   // 🔹 NEW: retake per mock (Mock1 / Mock2)
  }

  public static class RetakeConfirmRequest {
    public String userId;
    public String productId;
    public Integer trainingId;

    public String orderCode;
    public String razorpayOrderId;
    public String razorpayPaymentId;
    public String razorpaySignature;
  }

  /* ========== Create Razorpay order for retake ========== */

  @PostMapping("/retake/create")
  public ResponseEntity<Map<String, Object>> createRetake(@RequestBody RetakeCreateRequest req) {
    Map<String, Object> body = new HashMap<>();
    try {
      // 1) Internal order via SP (returns one row as Map<String,Object>)
      Map<String, Object> spRow = paymentDao.createRetakeOrder(
          req.userId,
          req.productId,
          req.trainingId,
          req.quizCode          // 🔹 pass quizCode down
      );

      
      String code = (String) spRow.get("code");
      String message = (String) spRow.get("message");

      // Case 1: SP says you already have a PAID retake that is not consumed yet
      if ("RETAKE_NOT_CONSUMED_YET".equals(code)) {
        body.put("status", "GATE");
        body.put("code", code);
        body.put("message", message);
        // Optional price info if SP returned it
        if (spRow.containsKey("amount_paise")) {
          body.put("amountPaise", ((Number) spRow.get("amount_paise")).intValue());
        }
        if (spRow.containsKey("currency")) {
          body.put("currency", spRow.get("currency"));
        }
        return ResponseEntity.ok(body);
      }

      // For ORDER_ALREADY_CREATED we still proceed to create a RZP order using the same order_code
      String orderCode = (String) spRow.get("order_code");
      if (orderCode == null || orderCode.isEmpty()) {
        throw new IllegalStateException("SP did not return order_code for retakeCreateOrder");
      }

      int amountPaise = ((Number) spRow.get("amount_paise")).intValue();
      String currency = spRow.get("currency") != null ? spRow.get("currency").toString() : "INR";

      // 2) Razorpay order
      JSONObject notes = new JSONObject();
      notes.put("userId", req.userId);
      notes.put("productId", req.productId);
      if (req.trainingId != null) {
        notes.put("trainingId", req.trainingId);
      }
      if (req.quizCode != null && !req.quizCode.isEmpty()) {
        notes.put("quizCode", req.quizCode);   // 🔹 include in notes for traceability
      }
      notes.put("purpose", "RETAKE");

      Order rzpOrder = razorpayService.createOrder(
          amountPaise,
          currency,
          orderCode,   // receipt
          notes
      );

      // 3) Store gateway info in lms_payment_order.gateway_payload
      JSONObject gw = new JSONObject();
      String rzpOrderId = rzpOrder.get("id").toString();
      Number rzpAmountNum = (Number) rzpOrder.get("amount");
      int rzpAmount = rzpAmountNum.intValue();
      String rzpCurrency = rzpOrder.get("currency").toString();
      Object rzpNotesObj = rzpOrder.get("notes");

      gw.put("razorpay_order_id", rzpOrderId);
      gw.put("amount", rzpAmount);
      gw.put("currency", rzpCurrency);
      gw.put("notes", rzpNotesObj);

      paymentDao.updateGatewayPayloadForOrder(orderCode, gw.toString());

      // 4) Response for frontend
      body.put("status", "OK");
      body.put("keyId", razorpayService.getKeyId());
      body.put("orderCode", orderCode);
      body.put("amountPaise", amountPaise);
      body.put("currency", currency);
      body.put("razorpayOrderId", rzpOrder.get("id"));
      // If SP returned any code/message like ORDER_ALREADY_CREATED, pass them too (optional)
      if (code != null) body.put("code", code);
      if (message != null) body.put("message", message);

      return ResponseEntity.ok(body);

    } catch (Exception ex) {
      ex.printStackTrace();
      body.put("status", "ERROR");
      body.put("message", ex.getMessage());
      return ResponseEntity.status(500).body(body);
    }
  }

  /* ========== Confirm Razorpay payment for retake ========== */

  @PostMapping("/retake/confirm")
  public ResponseEntity<Map<String, Object>> confirmRetake(@RequestBody RetakeConfirmRequest req) {
    Map<String, Object> body = new HashMap<>();
    try {
      boolean valid = razorpayService.verifySignature(
          req.razorpayOrderId,
          req.razorpayPaymentId,
          req.razorpaySignature
      );

      if (!valid) {
        body.put("status", "FAILED");
        body.put("message", "Signature verification failed");
        return ResponseEntity.badRequest().body(body);
      }

      // Save payment details to gateway_payload
      JSONObject payDetails = new JSONObject();
      payDetails.put("razorpay_order_id", req.razorpayOrderId);
      payDetails.put("razorpay_payment_id", req.razorpayPaymentId);
      payDetails.put("razorpay_signature", req.razorpaySignature);

      paymentDao.updateGatewayPayloadForOrder(req.orderCode, payDetails.toString());

      // Mark order PAID + grant retake credit in DB
      paymentDao.markRetakePaid(req.orderCode, req.userId, req.productId, req.trainingId);

      body.put("status", "OK");
      body.put("message", "Payment verified and retake credit granted.");
      return ResponseEntity.ok(body);

    } catch (Exception ex) {
      ex.printStackTrace();
      body.put("status", "ERROR");
      body.put("message", ex.getMessage());
      return ResponseEntity.status(500).body(body);
    }
  }
}
