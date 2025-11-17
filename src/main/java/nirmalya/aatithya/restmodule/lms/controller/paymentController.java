package nirmalya.aatithya.restmodule.lms.controller;

import com.razorpay.Order; // ✅ IMPORTANT: add this
import nirmalya.aatithya.restmodule.lms.dao.ExamPaymentDao;
import nirmalya.aatithya.restmodule.lms.model.RetakeOrderInfo;
import nirmalya.aatithya.restmodule.lms.services.RazorpayService;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/master/payment")
@CrossOrigin(origins = "*")
public class paymentController {  // ✅ Capital P (Java convention)

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
    Map<String, Object> body = new HashMap<String, Object>();
    try {
      // 1) Internal order via SP
      RetakeOrderInfo info = paymentDao.createRetakeOrder(req.userId, req.productId, req.trainingId);

      // 2) Razorpay order
      String receipt = info.getOrderCode();
      JSONObject notes = new JSONObject();
      notes.put("userId", req.userId);
      notes.put("productId", req.productId);
      if (req.trainingId != null) {
        notes.put("trainingId", req.trainingId);
      }
      notes.put("purpose", "RETAKE");

      Order rzpOrder = razorpayService.createOrder(
          info.getAmountPaise(),
          info.getCurrency(),
          receipt,
          notes
      );

      // 3) Store gateway info
      JSONObject gw = new JSONObject();

      String rzpOrderId   = rzpOrder.get("id").toString();
      Number rzpAmountNum = (Number) rzpOrder.get("amount");   // Razorpay sends Number
      int    rzpAmount    = rzpAmountNum.intValue();
      String rzpCurrency  = rzpOrder.get("currency").toString();
      
      // notes may already be a JSONObject or Map inside the Order
      Object rzpNotesObj = rzpOrder.get("notes");
      
      gw.put("razorpay_order_id", rzpOrderId);   // String
      gw.put("amount", rzpAmount);               // int
      gw.put("currency", rzpCurrency);           // String
      gw.put("notes", rzpNotesObj);              // Object (keeps it as JSON)
      

      paymentDao.updateGatewayPayloadForOrder(info.getOrderCode(), gw.toString());

      // 4) Response for frontend
      body.put("status", "OK");
      body.put("keyId", razorpayService.getKeyId());
      body.put("orderCode", info.getOrderCode());
      body.put("amountPaise", info.getAmountPaise());
      body.put("currency", info.getCurrency());
      body.put("razorpayOrderId", rzpOrder.get("id"));
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
    Map<String, Object> body = new HashMap<String, Object>();
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

      // Save payment details
      JSONObject payDetails = new JSONObject();
      payDetails.put("razorpay_order_id", req.razorpayOrderId);
      payDetails.put("razorpay_payment_id", req.razorpayPaymentId);
      payDetails.put("razorpay_signature", req.razorpaySignature);

      paymentDao.updateGatewayPayloadForOrder(req.orderCode, payDetails.toString());

      // Mark order PAID + grant retake credit
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
