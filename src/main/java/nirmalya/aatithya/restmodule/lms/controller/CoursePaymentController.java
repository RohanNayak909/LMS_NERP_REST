package nirmalya.aatithya.restmodule.lms.controller;

import nirmalya.aatithya.restmodule.lms.dao.CoursePaymentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("master/payment")
@CrossOrigin(origins = "*")
public class CoursePaymentController {

  private static final Logger logger = LoggerFactory.getLogger(CoursePaymentController.class);

  private final CoursePaymentDao coursePaymentDao;

  public CoursePaymentController(CoursePaymentDao coursePaymentDao) {
    this.coursePaymentDao = coursePaymentDao;
  }

  /**
   * Create Razorpay order + lms_payment_order rows for course purchase.
   *
   * POST /master/payment/course/create
   *
   * Body (JSON):
   * {
   *   "userId": "TCM00000077",
   *   "productIds": ["PRD000045","PRD000123"],
   *   "trainingId": "PRD000045_tr001-Books,PRD000045_tr002-LMS",
   *   "amountPaise": 118000,
   *   "paymentMethod": "upi" | "card" | "netbanking" | "cod",
   *   "email": "...",
   *   "address": "...",
   *   "city": "...",
   *   "zip": "..."
   * }
   */
  @PostMapping("/course/create")
  public Map<String, Object> createCourseOrder(@RequestBody Map<String, Object> body) {
    logger.info("createCourseOrder start body={}", body);

    Map<String, Object> res = new HashMap<String, Object>();
    try {
      return coursePaymentDao.createCourseOrder(body);
    } catch (Exception e) {
      logger.error("createCourseOrder error", e);
      res.put("status", "ERROR");
      res.put("message", e.getMessage());
      return res;
    }
  }

  /**
   * Confirm Razorpay payment for course purchase.
   *
   * POST /master/payment/course/confirm
   *
   * Body:
   * {
   *   "userId": "TCM00000077",
   *   "orderCode": "COURSE-...timestamp...",
   *   "razorpayOrderId": "order_xxx",
   *   "razorpayPaymentId": "pay_xxx",
   *   "razorpaySignature": "..."
   * }
   */
  @PostMapping("/course/confirm")
  public Map<String, Object> confirmCoursePayment(@RequestBody Map<String, Object> body) {
    logger.info("confirmCoursePayment start body={}", body);

    Map<String, Object> res = new HashMap<String, Object>();
    try {
      coursePaymentDao.confirmCoursePayment(body);
      res.put("status", "OK");
      res.put("message", "Payment confirmed");
      return res;
    } catch (IllegalArgumentException ex) {
      logger.warn("Invalid payment signature: {}", ex.getMessage());
      res.put("status", "ERROR");
      res.put("message", "Invalid payment signature");
      return res;
    } catch (Exception e) {
      logger.error("confirmCoursePayment error", e);
      res.put("status", "ERROR");
      res.put("message", e.getMessage());
      return res;
    }
  }
}
