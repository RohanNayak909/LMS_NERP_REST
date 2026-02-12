package nirmalya.aatithya.restmodule.mailservice;

import nirmalya.aatithya.restmodule.lms.dao.EmailDao;
import nirmalya.aatithya.restmodule.lms.utils.TemplateUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GraphEmailService {

  private final EmailDao dao;
  private final GraphMailClient graph;

  public GraphEmailService(EmailDao dao, GraphMailClient graph) {
    this.dao = dao;
    this.graph = graph;
  }

  public Map<String, String> preview(String templateCode,
                                     String locale,
                                     Integer version,
                                     Map<String, Object> payload) {
    Map<String, String> tpl = resolveTemplate(templateCode, locale, version);
    Map<String, String> out = new HashMap<>();
    out.put("subject", TemplateUtil.render(tpl.get("subject"), payload));
    out.put("html", TemplateUtil.render(tpl.get("html"), payload));
    out.put("text", TemplateUtil.render(tpl.get("text"), payload));
    // optional: expose cc for preview/debug
    out.put("cc", tpl.get("cc"));
    return out;
  }

  /** Send immediately via Graph (NO DB enqueue, NO queue processor) */
  public void sendTemplateNow(String templateCode,
                              String locale,
                              Integer version,
                              String toEmail,
                              String toName,
                              Map<String, Object> payload) {

    Map<String, String> tpl = resolveTemplate(templateCode, locale, version);

    String subject = TemplateUtil.render(tpl.get("subject"), payload);
    String html = TemplateUtil.render(tpl.get("html"), payload);
    String text = TemplateUtil.render(tpl.get("text"), payload);

    // ✅ CC comes from DB template cc_list
    String ccList = tpl.get("cc");

    graph.sendMail(toEmail, toName, ccList, subject, html, text);
  }

  private Map<String, String> resolveTemplate(String templateCode, String locale, Integer version) {
    String loc = (locale == null || locale.trim().isEmpty()) ? "en-IN" : locale.trim();

    if (version != null) {
      Map<String, String> exact = dao.findExactTemplate(templateCode, loc, version);
      if (exact != null) return exact;
    }

    Map<String, String> localDefault = dao.findDefaultForLocale(templateCode, loc);
    if (localDefault != null) return localDefault;

    Map<String, String> fallbackEn = dao.findDefaultEnglish(templateCode);
    if (fallbackEn != null) return fallbackEn;

    throw new IllegalStateException("No active template for code=" + templateCode + ", locale=" + loc);
  }
}
