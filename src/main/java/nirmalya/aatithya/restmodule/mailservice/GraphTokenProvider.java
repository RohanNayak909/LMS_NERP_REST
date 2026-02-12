package nirmalya.aatithya.restmodule.mailservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class GraphTokenProvider {

  private static final Logger logger = LoggerFactory.getLogger(GraphTokenProvider.class);

  private final Environment env;
  private final RestTemplate rest = new RestTemplate();

  private volatile String cachedToken;
  private volatile long tokenExpEpochMs;

  public GraphTokenProvider(Environment env) {
    this.env = env;
  }

  public String getAccessToken() {
    long now = System.currentTimeMillis();
    if (cachedToken != null && now < (tokenExpEpochMs - 60_000L)) {
      return cachedToken;
    }

    String tenantId = must(env.getProperty("o365.tenantId"), "o365.tenantId");
    String clientId = must(env.getProperty("o365.clientId"), "o365.clientId");
    String clientSecret = must(env.getProperty("o365.clientSecret"), "o365.clientSecret");

    String scope = env.getProperty("o365.scope");
    if (scope == null || scope.trim().isEmpty()) {
      scope = "https://graph.microsoft.com/.default";
    } else {
      scope = scope.trim();
    }

    String tokenUrl = "https://login.microsoftonline.com/" + tenantId + "/oauth2/v2.0/token";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
    form.add("client_id", clientId);
    form.add("client_secret", clientSecret);
    form.add("scope", scope);
    form.add("grant_type", "client_credentials");

    try {
      ResponseEntity<Map> resp = rest.exchange(
          tokenUrl,
          HttpMethod.POST,
          new HttpEntity<>(form, headers),
          Map.class
      );

      if (!resp.getStatusCode().is2xxSuccessful() || resp.getBody() == null) {
        throw new RuntimeException("Graph token failed: " + resp.getStatusCode());
      }

      Map body = resp.getBody();
      String token = String.valueOf(body.get("access_token"));
      int expiresIn = Integer.parseInt(String.valueOf(body.get("expires_in")));

      cachedToken = token;
      tokenExpEpochMs = System.currentTimeMillis() + (expiresIn * 1000L);

      logger.info("Graph token OK (expires_in={}s, scope={})", expiresIn, scope);
      return token;

    } catch (HttpStatusCodeException e) {
      throw new RuntimeException("Graph token HTTP " + e.getStatusCode().value()
          + " body=" + e.getResponseBodyAsString(), e);
    }
  }

  private static String must(String v, String key) {
    if (v == null || v.trim().isEmpty()) {
      throw new IllegalStateException("Missing required property: " + key);
    }
    return v.trim();
  }
}
