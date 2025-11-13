package nirmalya.aatithya.restmodule.mailservice;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sun.media.jfxmedia.logging.Logger;

import nirmalya.aatithya.restmodule.lms.utils.TemplateUtil;
import nirmalya.aatithya.restmodule.lms.controller.OtpController;
import nirmalya.aatithya.restmodule.lms.dao.EmailDao;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import nirmalya.aatithya.restmodule.common.MailService;

@Service
public class EmailService {

  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmailService.class);

  private final EmailDao dao;
  private final JavaMailSender mailSender;
  private final String from;
  private final String fromName;

  @Autowired
  private nirmalya.aatithya.restmodule.common.MailService emailService;

  public EmailService(EmailDao dao, JavaMailSender mailSender, Environment env) {
    this.dao = dao;
    this.mailSender = mailSender;
    this.from = "info@ducisgroup.com";
    // env.getProperty("app.mail.from", "info@ducisgroup.com");
    this.fromName = env.getProperty("app.mail.fromName", "Ducis Group");
  }

  public long enqueue(String templateCode, String locale, Integer version,
                      String toEmail, String toName, Map<String, Object> payload) {
    return dao.enqueue(templateCode, locale, version, toEmail, toName, payload);
  }

  private Map<String, String> resolveTemplate(String templateCode, String locale, Integer version) {
    String loc = (locale == null || locale.trim().isEmpty()) ? "en-IN" : locale;
    if (version != null) {
      Map<String,String> r = dao.findExactTemplate(templateCode, loc, version);
      if (r != null) return r;
    }
    Map<String,String> r2 = dao.findDefaultForLocale(templateCode, loc);
    if (r2 != null) return r2;
    Map<String,String> r3 = dao.findDefaultEnglish(templateCode);
    if (r3 != null) return r3;
    throw new IllegalStateException("No active template for code=" + templateCode + ", locale=" + loc);
  }

  @Scheduled(fixedDelay = 15000, initialDelay = 5000)
  public void processQueue() {
    logger.info("processing email queue");
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
        logger.info("sending email from queue " + (String)row.get("to"));
        sendNow((String)row.get("to"), (String)row.get("name"), subject, html, text);
        dao.markSent(id);
      } catch (Exception ex) {
        dao.markError(id, ex.getMessage());
      }
    }
  }

  private void sendNow(String toEmail, String toName, String subject, String html, String text) throws Exception {
    MimeMessage mm = mailSender.createMimeMessage();
    MimeMessageHelper h = new MimeMessageHelper(
        mm, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
    h.setFrom(String.format("%s <%s>", fromName, from));
    h.setTo(toEmail);
    h.setSubject(subject);
    logger.info("From Email:"+from);
    if (html != null && !html.trim().isEmpty()) h.setText(text == null ? "" : text, html);
    else h.setText(text == null ? "" : text, false);
    //emailService.sendHtmlEmail(toEmail, subject, html, from);
    mailSender.send(mm);
  }

  public Map<String,String> preview(String templateCode, String locale, Integer version, Map<String,Object> payload) {
    Map<String,String> tpl = resolveTemplate(templateCode, locale, version);
    return new java.util.HashMap<String,String>() {{
      put("subject", TemplateUtil.render(tpl.get("subject"), payload));
      put("html",    TemplateUtil.render(tpl.get("html"), payload));
      put("text",    TemplateUtil.render(tpl.get("text"), payload));
    }};
  }
}
