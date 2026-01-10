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

  public void sendMail(String toEmail, String toName, String subject, String html, String text) {
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

    Map<String, Object> emailAddress = new HashMap<>();
    emailAddress.put("address", toEmail);
    if (toName != null && !toName.trim().isEmpty()) {
      emailAddress.put("name", toName.trim());
    }

    Map<String, Object> toRecipient = new HashMap<>();
    toRecipient.put("emailAddress", emailAddress);

    Map<String, Object> message = new HashMap<>();
    message.put("subject", safeSubject);
    message.put("body", bodyObj);
    message.put("toRecipients", Collections.singletonList(toRecipient));

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

      logger.info("Graph sendMail OK (status={}) sender={} saveToSentItems={}",
          resp.getStatusCodeValue(), senderUpn, saveToSentItems);

    } catch (HttpStatusCodeException e) {
      throw new RuntimeException("Graph sendMail HTTP " + e.getStatusCode().value()
          + " body=" + e.getResponseBodyAsString(), e);
    }
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
