package nirmalya.aatithya.restmodule.lms.controller;

import nirmalya.aatithya.restmodule.mailservice.EmailService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/master/mail")
public class MailController {
  private final EmailService emailService;
  public MailController(EmailService emailService) { this.emailService = emailService; }

  @PostMapping("/send")
  public Map<String, Object> send(@Valid @RequestBody SendMailRequest req) {
    long id = emailService.enqueue(
        req.getTemplateCode(), req.getLocale(), req.getVersion(),
        req.getTo().getEmail(), req.getTo().getName(), req.getPayload());
    return java.util.Collections.unmodifiableMap(new java.util.HashMap<String,Object>() {{
      put("status","OK"); put("message","Queued"); put("id", id);
    }});
  }

  @PostMapping("/send-bulk")
  public Map<String, Object> sendBulk(@Valid @RequestBody BulkSendMailRequest req) {
    int n = 0;
    for (SendMailRequest it : req.getItems()) {
      emailService.enqueue(
          it.getTemplateCode(), it.getLocale(), it.getVersion(),
          it.getTo().getEmail(), it.getTo().getName(), it.getPayload());
      n++;
    }
    final int queued = n;
    final String batch = req.getBatchCode();
    return java.util.Collections.unmodifiableMap(new java.util.HashMap<String,Object>() {{
      put("status","OK"); put("queued", queued); put("batchCode", batch);
    }});
  }

  @PostMapping("/preview")
  public Map<String, String> preview(@Valid @RequestBody PreviewRequest req) {
    return emailService.preview(req.getTemplateCode(), req.getLocale(), req.getVersion(), req.getPayload());
  }

  /* ---------- DTOs ---------- */
  public static class SendMailRequest {
    @NotBlank private String templateCode;
    private String locale;
    private Integer version;
    @Valid private Recipient to;
    private Map<String,Object> payload;

    public String getTemplateCode() { return templateCode; }
    public void setTemplateCode(String templateCode) { this.templateCode = templateCode; }
    public String getLocale() { return locale; }
    public void setLocale(String locale) { this.locale = locale; }
    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
    public Recipient getTo() { return to; }
    public void setTo(Recipient to) { this.to = to; }
    public Map<String, Object> getPayload() { return payload; }
    public void setPayload(Map<String, Object> payload) { this.payload = payload; }

    public static class Recipient {
      @Email @NotBlank private String email;
      private String name;
      public String getEmail() { return email; }
      public void setEmail(String email) { this.email = email; }
      public String getName() { return name; }
      public void setName(String name) { this.name = name; }
    }
  }

  public static class BulkSendMailRequest {
    @NotBlank private String batchCode;
    @Valid private List<SendMailRequest> items;
    public String getBatchCode() { return batchCode; }
    public void setBatchCode(String batchCode) { this.batchCode = batchCode; }
    public List<SendMailRequest> getItems() { return items; }
    public void setItems(List<SendMailRequest> items) { this.items = items; }
  }

  public static class PreviewRequest {
    @NotBlank private String templateCode;
    private String locale;
    private Integer version;
    private Map<String,Object> payload;
    public String getTemplateCode() { return templateCode; }
    public void setTemplateCode(String templateCode) { this.templateCode = templateCode; }
    public String getLocale() { return locale; }
    public void setLocale(String locale) { this.locale = locale; }
    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
    public Map<String, Object> getPayload() { return payload; }
    public void setPayload(Map<String, Object> payload) { this.payload = payload; }
  }
}
