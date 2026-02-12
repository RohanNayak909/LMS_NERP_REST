package nirmalya.aatithya.restmodule.mailservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Component
public class GraphMailClient {

  private static final Logger logger = LoggerFactory.getLogger(GraphMailClient.class);

  private final Environment env;
  private final GraphTokenProvider tokenProvider;
  private final RestTemplate rest = new RestTemplate();

  public GraphMailClient(Environment env, GraphTokenProvider tokenProvider) {
    this.env = env;
    this.tokenProvider = tokenProvider;
  }

  /**
   * ccList supports comma/semicolon separated emails:
   * "a@x.com,b@y.com" or "a@x.com; b@y.com"
   */
  public void sendMail(String toEmail, String toName, String ccList, String subject, String html, String text) {
    String senderUpn = must(env.getProperty("o365.graph.senderUpn"), "o365.graph.senderUpn");
    String token = tokenProvider.getAccessToken();

    boolean saveToSentItems = bool(env.getProperty("o365.graph.saveToSentItems"), false);

    String url = UriComponentsBuilder
        .fromHttpUrl("https://graph.microsoft.com/v1.0/users/{sender}/sendMail")
        .buildAndExpand(senderUpn)
        .toUriString();

    String safeSubject = subject == null ? "" : subject;

    boolean hasHtml = html != null && !html.trim().isEmpty();
    String bodyContent = hasHtml ? html : (text == null ? "" : text);

    Map<String, Object> bodyObj = new HashMap<>();
    bodyObj.put("contentType", hasHtml ? "HTML" : "Text");
    bodyObj.put("content", bodyContent);

    // ---- TO recipient
    Map<String, Object> toRecipient = wrapRecipient(toEmail, toName);

    // ---- CC recipients (from template cc_list)
    List<Map<String, Object>> ccRecipients = buildRecipientsFromList(ccList, toEmail);

    Map<String, Object> message = new HashMap<>();
    message.put("subject", safeSubject);
    message.put("body", bodyObj);
    message.put("toRecipients", Collections.singletonList(toRecipient));

    // ✅ Only add ccRecipients when non-empty
    if (!ccRecipients.isEmpty()) {
      message.put("ccRecipients", ccRecipients);
    }

    Map<String, Object> req = new HashMap<>();
    req.put("message", message);
    req.put("saveToSentItems", Boolean.valueOf(saveToSentItems));

    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(token);
    headers.setContentType(MediaType.APPLICATION_JSON);

    try {
      ResponseEntity<String> resp = rest.exchange(
          url,
          HttpMethod.POST,
          new HttpEntity<>(req, headers),
          String.class
      );

      if (!(resp.getStatusCode() == HttpStatus.ACCEPTED || resp.getStatusCode().is2xxSuccessful())) {
        throw new RuntimeException("Graph sendMail failed: " + resp.getStatusCode() + " body=" + resp.getBody());
      }

      logger.info("Graph sendMail OK (status={}) sender={} saveToSentItems={} ccCount={}",
          resp.getStatusCodeValue(), senderUpn, saveToSentItems, ccRecipients.size());

    } catch (HttpStatusCodeException e) {
      throw new RuntimeException("Graph sendMail HTTP " + e.getStatusCode().value()
          + " body=" + e.getResponseBodyAsString(), e);
    }
  }

  private static Map<String, Object> wrapRecipient(String email, String name) {
    Map<String, Object> emailAddress = new HashMap<>();
    emailAddress.put("address", email);
    if (name != null && !name.trim().isEmpty()) {
      emailAddress.put("name", name.trim());
    }
    Map<String, Object> recipient = new HashMap<>();
    recipient.put("emailAddress", emailAddress);
    return recipient;
  }

  /**
   * Splits ccList by comma/semicolon. Removes blanks and duplicates.
   * Also removes CC entries equal to the TO email to avoid duplication.
   */
  private static List<Map<String, Object>> buildRecipientsFromList(String ccList, String toEmail) {
    if (ccList == null) return Collections.emptyList();
    String raw = ccList.trim();
    if (raw.isEmpty()) return Collections.emptyList();

    String toNorm = normEmail(toEmail);

    Set<String> unique = new LinkedHashSet<>();
    for (String part : raw.split("[,;]")) {
      String e = normEmail(part);
      if (e.isEmpty()) continue;
      if (!toNorm.isEmpty() && e.equals(toNorm)) continue;
      unique.add(e);
    }

    if (unique.isEmpty()) return Collections.emptyList();

    List<Map<String, Object>> out = new ArrayList<>();
    for (String e : unique) {
      out.add(wrapRecipient(e, null));
    }
    return out;
  }

  private static String normEmail(String s) {
    return s == null ? "" : s.trim().toLowerCase();
  }

  private static boolean bool(String v, boolean def) {
    if (v == null) return def;
    String s = v.trim().toLowerCase();
    if (s.isEmpty()) return def;
    return s.equals("true") || s.equals("1") || s.equals("yes") || s.equals("y");
  }

  private static String must(String v, String key) {
    if (v == null || v.trim().isEmpty()) {
      throw new IllegalStateException("Missing required property: " + key);
    }
    return v.trim();
  }
}
