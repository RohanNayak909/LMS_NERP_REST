package nirmalya.aatithya.restmodule.lms.controller;

import nirmalya.aatithya.restmodule.lms.dao.OtpDao;
import nirmalya.aatithya.restmodule.mailservice.GraphEmailService;
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
  private final GraphEmailService graphEmailService;

  @Value("${app.otp.ttlMinutes:10}")
  private int ttlMinutes;

  @Value("${app.otp.maxAttempts:5}")
  private int maxAttempts;

  @Value("${app.org.name:Nirmalya Labs Private Limited}")
  private String orgName;

  public OtpController(OtpDao dao, GraphEmailService graphEmailService) {
    this.dao = dao;
    this.graphEmailService = graphEmailService;
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

  private static String normEmail(String s) {
    return s == null ? "" : s.trim().toLowerCase();
  }

  private static String normPurpose(String s) {
    String p = (s == null) ? "" : s.trim();
    return p.isEmpty() ? "SIGNUP" : p.toUpperCase();
  }

  private static String resolveTemplateCode(String purposeUpper) {
    // ✅ use your DB template codes
    if ("FORGOT_PASSWORD".equals(purposeUpper)) return "FORGOT_PASSWORD_OTP";
    if ("SIGNUP".equals(purposeUpper)) return "SIGNUP_OTP";

    // fallback (safe)
    return "SIGNUP_OTP";
  }

  @PostMapping("/request")
  public Map<String, Object> request(@RequestBody OtpRequestPayload body, HttpServletRequest req) {
    final String ip = req != null ? req.getRemoteAddr() : "unknown";

    final String email = normEmail(body.email);
    final String purpose = normPurpose(body.purpose);
    final String tplCode = resolveTemplateCode(purpose);

    logger.info("OTP request email={} purpose={} template={} ip={}", email, purpose, tplCode, ip);

    Map<String, Object> resp = new HashMap<>();
    try {
      final OtpDao.CreateResult res = dao.create(email, purpose, ttlMinutes, maxAttempts, ip);

      Map<String, Object> payload = new HashMap<>();
      payload.put("name", displayName(body.name));
      payload.put("otp", res.otpPlain);

      // ✅ provide all keys so template never breaks
      payload.put("ttlMin", ttlMinutes);
      payload.put("ttlMinutes", ttlMinutes);
      payload.put("minutes", ttlMinutes);

      payload.put("orgName", orgName);
      payload.put("email", email);
      payload.put("purpose", purpose);

      graphEmailService.sendTemplateNow(
          tplCode,
          "en-IN",
          1,
          email,
          displayName(body.name),
          payload
      );

      resp.put("ok", Boolean.TRUE);
      resp.put("requestId", res.requestId);
      resp.put("ttlMinutes", ttlMinutes);

      logger.info("OTP generated & mailed email={} purpose={} template={} requestId={}",
          email, purpose, tplCode, res.requestId);

    } catch (Exception e) {
      logger.error("OTP request failed email={} purpose={} err={}", email, purpose, e.getMessage(), e);
      resp.put("ok", Boolean.FALSE);
      resp.put("error", "Failed to generate OTP. Please try again later.");
    }
    return resp;
  }

  @PostMapping("/verify")
  public Map<String, Object> verify(@RequestBody OtpVerifyPayload body) {
    final String email = normEmail(body.email);
    final String purpose = normPurpose(body.purpose);

    logger.info("OTP verify email={} purpose={}", email, purpose);

    Map<String, Object> resp = new HashMap<>();
    try {
      final Map<String, Object> r = dao.verify(email, purpose, body.otp);
      final boolean ok = Boolean.TRUE.equals(r.get("ok"));
      final String message = String.valueOf(r.get("message"));

      resp.put("ok", ok);
      resp.put("message", message);

      if (ok) logger.info("OTP verified email={} purpose={}", email, purpose);
      else logger.warn("OTP verify failed email={} purpose={} message={}", email, purpose, message);

    } catch (Exception e) {
      logger.error("OTP verify error email={} purpose={} err={}", email, purpose, e.getMessage(), e);
      resp.put("ok", Boolean.FALSE);
      resp.put("message", "Error verifying OTP. Please try again.");
    }
    return resp;
  }
}
