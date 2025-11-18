package nirmalya.aatithya.restmodule.mailservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import nirmalya.aatithya.restmodule.lms.dao.EmailDao;
import nirmalya.aatithya.restmodule.lms.utils.TemplateUtil;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Service
public class EmailService {

  private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

  private final EmailDao dao;
  private final JavaMailSender mailSender;
  private final String from;
  private final String fromName;

  public EmailService(EmailDao dao, JavaMailSender mailSender, Environment env) {
    this.dao = dao;
    this.mailSender = mailSender;

    // ALWAYS read from application.properties
    this.from = "info@ducisgroup.com";
    		//env.getProperty("app.mail.from", "info@ducisgroup.com");
    this.fromName = env.getProperty("app.mail.fromName", "Ducis Group");

    logger.info("EmailService initialized with from='{}' fromName='{}'", this.from, this.fromName);
  }

  /* ===================== PUBLIC API ===================== */

  public long enqueue(String templateCode,
                      String locale,
                      Integer version,
                      String toEmail,
                      String toName,
                      Map<String, Object> payload) {
    return dao.enqueue(templateCode, locale, version, toEmail, toName, payload);
  }

  public Map<String,String> preview(String templateCode,
                                    String locale,
                                    Integer version,
                                    Map<String,Object> payload) {
    Map<String,String> tpl = resolveTemplate(templateCode, locale, version);
    return new java.util.HashMap<String,String>() {{
      put("subject", TemplateUtil.render(tpl.get("subject"), payload));
      put("html",    TemplateUtil.render(tpl.get("html"), payload));
      put("text",    TemplateUtil.render(tpl.get("text"), payload));
    }};
  }

  
  /* ===================== QUEUE PROCESSOR ===================== */

  @Scheduled(fixedDelay = 15000, initialDelay = 5000)
  public void processQueue() {
 //   logger.info("Processing email queue...");
    List<Map<String, Object>> rows = dao.fetchPendingBatch(25);
    for (Map<String, Object> row : rows) {
      long id = (Long) row.get("id");
      try {
        dao.markSending(id);

        Map<String,String> tpl = resolveTemplate(
            (String) row.get("code"),
            (String) row.get("locale"),
            (Integer) row.get("version")
        );

        @SuppressWarnings("unchecked")
        Map<String,Object> payload = (Map<String,Object>) row.get("payload");

        String subject = TemplateUtil.render(tpl.get("subject"), payload);
        String html    = TemplateUtil.render(tpl.get("html"), payload);
        String text    = TemplateUtil.render(tpl.get("text"), payload);

        String toEmail = (String) row.get("to");
        String toName  = (String) row.get("name");

        logger.info("Sending mail id={} to={} subject='{}' via JavaMailSender", id, toEmail, subject);
        sendNow(toEmail, toName, subject, html, text);

        dao.markSent(id);
      } catch (Exception ex) {
        logger.error("Error sending mail id={}: {}", id, ex.getMessage(), ex);
        dao.markError(id, ex.getMessage());
      }
    }
  }

  /* ===================== INTERNAL HELPERS ===================== */

  private Map<String, String> resolveTemplate(String templateCode,
                                              String locale,
                                              Integer version) {
    String loc = (locale == null || locale.trim().isEmpty()) ? "en-IN" : locale.trim();

    if (version != null) {
      Map<String,String> exact = dao.findExactTemplate(templateCode, loc, version);
      if (exact != null) return exact;
    }

    Map<String,String> localDefault = dao.findDefaultForLocale(templateCode, loc);
    if (localDefault != null) return localDefault;

    Map<String,String> fallbackEn = dao.findDefaultEnglish(templateCode);
    if (fallbackEn != null) return fallbackEn;

    throw new IllegalStateException(
        "No active template for code=" + templateCode + ", locale=" + loc
    );
  }

  private void sendNow(String toEmail,
                       String toName,
                       String subject,
                       String html,
                       String text) throws Exception {

    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(
        message,
        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
        StandardCharsets.UTF_8.name()
    );

    // From set from properties (Office365 identity)
    helper.setFrom(from);
    helper.setTo(toEmail);
    helper.setSubject(subject);

    if (html != null && !html.trim().isEmpty()) {
      helper.setText(text == null ? "" : text, html);
    } else {
      helper.setText(text == null ? "" : text, false);
    }

    logger.info("Using from='{}' (configured in app.mail.from)", from);
    mailSender.send(message);
  }
}
