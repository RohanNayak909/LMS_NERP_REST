package nirmalya.aatithya.restmodule.lms.controller;

import nirmalya.aatithya.restmodule.mailservice.GraphEmailService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@RestController
@RequestMapping("/master/mail")
public class MailController {

  private final GraphEmailService graphEmailService;

  public MailController(GraphEmailService graphEmailService) {
    this.graphEmailService = graphEmailService;
  }

  /**
   * Graph DIRECT send (NO DB enqueue, NO scheduler involvement)
   */
  @PostMapping("/send")
  public Map<String, Object> send(@Valid @RequestBody SendMailRequest req) {

    graphEmailService.sendTemplateNow(
        req.getTemplateCode(),
        req.getLocale(),
        req.getVersion(),
        req.getTo().getEmail(),
        req.getTo().getName(),
        req.getPayload()
    );

    Map<String, Object> out = new LinkedHashMap<>();
    out.put("status", "OK");
    out.put("message", "Sent via Graph (direct)");
    out.put("queued", Boolean.FALSE);
    return Collections.unmodifiableMap(out);
  }

  /**
   * Graph DIRECT bulk send (NO enqueue). Continues sending even if some items fail.
   * Returns PARTIAL if any failed.
   */
  @PostMapping("/send-bulk")
  public Map<String, Object> sendBulk(@Valid @RequestBody BulkSendMailRequest req) {

    int sent = 0;
    List<Map<String, Object>> errors = new ArrayList<>();

    List<SendMailRequest> items = req.getItems();
    for (int i = 0; i < items.size(); i++) {
      SendMailRequest it = items.get(i);
      try {
        graphEmailService.sendTemplateNow(
            it.getTemplateCode(),
            it.getLocale(),
            it.getVersion(),
            it.getTo().getEmail(),
            it.getTo().getName(),
            it.getPayload()
        );
        sent++;
      } catch (Exception ex) {
        Map<String, Object> err = new LinkedHashMap<>();
        err.put("index", i);
        err.put("templateCode", safe(it.getTemplateCode()));
        err.put("toEmail", it.getTo() == null ? null : safe(it.getTo().getEmail()));
        err.put("error", ex.getMessage());
        errors.add(err);
      }
    }

    Map<String, Object> out = new LinkedHashMap<>();
    out.put("status", errors.isEmpty() ? "OK" : "PARTIAL");
    out.put("batchCode", req.getBatchCode());
    out.put("sent", sent);
    out.put("failed", errors.size());
    out.put("queued", Boolean.FALSE);
    if (!errors.isEmpty()) out.put("errors", errors);

    return Collections.unmodifiableMap(out);
  }

  /**
   * Preview uses the SAME template rendering logic (TemplateUtil) via GraphEmailService.preview(...)
   */
  @PostMapping("/preview")
  public Map<String, String> preview(@Valid @RequestBody PreviewRequest req) {
    return graphEmailService.preview(req.getTemplateCode(), req.getLocale(), req.getVersion(), req.getPayload());
  }

  private static String safe(String s) {
    return s == null ? null : s.trim();
  }

  /* ---------- DTOs ---------- */
  public static class SendMailRequest {
    @NotBlank private String templateCode;
    private String locale;
    private Integer version;

    @NotNull @Valid private Recipient to;
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
    @NotNull @Valid private List<SendMailRequest> items;

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
