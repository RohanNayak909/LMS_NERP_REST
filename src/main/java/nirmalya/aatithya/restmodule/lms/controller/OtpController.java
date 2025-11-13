package nirmalya.aatithya.restmodule.lms.controller;

import nirmalya.aatithya.restmodule.lms.dao.OtpDao;
import nirmalya.aatithya.restmodule.mailservice.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("otp")
@CrossOrigin(origins = "*")
public class OtpController {

  private static final Logger logger = LoggerFactory.getLogger(OtpController.class);

  private final OtpDao dao;
  private final EmailService emailService;

  @Value("${app.otp.ttlMinutes:10}")
  private int ttlMinutes;

  @Value("${app.otp.maxAttempts:5}")
  private int maxAttempts;

  @Value("${app.org.name:Nirmalya Labs Private Limited}")
  private String orgName;

  public OtpController(OtpDao dao, EmailService emailService) {
    this.dao = dao;
    this.emailService = emailService;
  }

  public static class OtpRequestPayload {
    @Email @NotBlank public String email;
    public String name;
    public String purpose = "SIGNUP";
  }

  public static class OtpVerifyPayload {
    @Email @NotBlank public String email;
    @NotBlank public String purpose;
    @NotBlank public String otp;
  }

  private static boolean isBlank(String s) {
    return s == null || s.trim().isEmpty();
  }

  private static String displayName(String name) {
    return isBlank(name) ? "User" : name.trim();
  }

  @PostMapping("/request")
  public Map<String, Object> request(@RequestBody OtpRequestPayload body, HttpServletRequest req) {
    final String ip = req != null ? req.getRemoteAddr() : "unknown";
    logger.info("Received OTP request for email={} purpose={} from IP={}", body.email, body.purpose, ip);

    Map<String, Object> resp = new HashMap<>();
    try {
      final OtpDao.CreateResult res = dao.create(body.email, body.purpose, ttlMinutes, maxAttempts, ip);

      Map<String, Object> payload = new HashMap<>();
      payload.put("name", displayName(body.name));
      payload.put("otp", res.otpPlain);
      payload.put("minutes", ttlMinutes);
      payload.put("orgName", orgName);

      emailService.enqueue(
          "SIGNUP_OTP",
          "en-IN",
          1,
          body.email,
          displayName(body.name),
          payload
      );

      resp.put("ok", Boolean.TRUE);
      resp.put("requestId", res.requestId);
      resp.put("ttlMinutes", ttlMinutes);

      logger.info("OTP successfully generated for email={} (requestId={})", body.email, res.requestId);
    } catch (Exception e) {
      logger.error("Error while processing OTP request for email={}: {}", body.email, e.getMessage(), e);
      resp.put("ok", Boolean.FALSE);
      resp.put("error", "Failed to generate OTP. Please try again later.");
    }
    return resp;
  }

  @PostMapping("/verify")
  public Map<String, Object> verify(@RequestBody OtpVerifyPayload body) {
    logger.info("Verifying OTP for email={} purpose={}", body.email, body.purpose);
    Map<String, Object> resp = new HashMap<>();

    try {
      final Map<String, Object> r = dao.verify(body.email, body.purpose, body.otp);
      final boolean ok = Boolean.TRUE.equals(r.get("ok"));
      final String message = String.valueOf(r.get("message"));

      resp.put("ok", ok);
      resp.put("message", message);

      if (ok) {
        logger.info("OTP verification successful for email={} purpose={}", body.email, body.purpose);
      } else {
        logger.warn("OTP verification failed for email={} purpose={} message={}", body.email, body.purpose, message);
      }
    } catch (Exception e) {
      logger.error("Error verifying OTP for email={}: {}", body.email, e.getMessage(), e);
      resp.put("ok", Boolean.FALSE);
      resp.put("message", "Error verifying OTP. Please try again.");
    }

    return resp;
  }
}
