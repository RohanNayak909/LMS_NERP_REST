package nirmalya.aatithya.restmodule.lms.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.*;

@Repository
public class EmailDao {
  private final JdbcTemplate jdbc;
  private final ObjectMapper om = new ObjectMapper();

  // Set to false if you used LONGTEXT payload instead of JSON in DB
  private final boolean payloadIsJson = true;

  public EmailDao(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public long enqueue(String code, String locale, Integer version,
                      String toEmail, String toName, Map<String, Object> payload) {
    String json;
    try { json = om.writeValueAsString(payload == null ? Collections.emptyMap() : payload); }
    catch (Exception e) { throw new RuntimeException("Payload JSON error", e); }

    if (payloadIsJson) {
      jdbc.update(
          "INSERT INTO email_queue (template_code, locale, version, to_email, to_name, payload_json) " +
          "VALUES (?,?,?,?,?,CAST(? AS JSON))",
          code, locale, version, toEmail, toName, json);
    } else {
      jdbc.update(
          "INSERT INTO email_queue (template_code, locale, version, to_email, to_name, payload_json) " +
          "VALUES (?,?,?,?,?,?)",
          code, locale, version, toEmail, toName, json);
    }
    return jdbc.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
  }

  public List<Map<String, Object>> fetchPendingBatch(int limit) {
    return jdbc.query(
      "SELECT id, template_code, locale, version, to_email, to_name, payload_json, try_count " +
      "FROM email_queue WHERE status='PENDING' ORDER BY created_at ASC LIMIT ?",
      (ResultSet rs, int i) -> {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id", rs.getLong("id"));
        map.put("code", rs.getString("template_code"));
        String loc = rs.getString("locale");
        map.put("locale", (loc == null || loc.trim().isEmpty()) ? "en-IN" : loc);
        Object verObj = rs.getObject("version");
        map.put("version", verObj == null ? null : (Integer) verObj);
        map.put("to", rs.getString("to_email"));
        map.put("name", rs.getString("to_name"));
        try {
          map.put("payload", om.readValue(rs.getString("payload_json"), Map.class));
        } catch (Exception e) {
          map.put("payload", Collections.emptyMap());
        }
        map.put("tryCount", rs.getInt("try_count"));
        return map;
      },
      limit
    );
  }

  public int markSending(long id) {
    return jdbc.update("UPDATE email_queue SET status='SENDING', try_count=try_count+1 WHERE id=?", id);
  }

  public int markSent(long id) {
    return jdbc.update("UPDATE email_queue SET status='SENT', sent_at=NOW() WHERE id=?", id);
  }

  public int markError(long id, String err) {
    return jdbc.update(
      "UPDATE email_queue SET status=IF(try_count>=max_retries,'FAILED','PENDING'), " +
      "last_error=?, updated_at=NOW() WHERE id=?",
      truncate(err, 1500), id
    );
  }

  private String truncate(String s, int max) {
    if (s == null) return null;
    return s.length() > max ? s.substring(0, max) : s;
  }

  /* ---------- Template lookups (type-safe) ---------- */

  public Map<String, String> findExactTemplate(String code, String locale, Integer version) {
    List<Map<String, String>> list = jdbc.query(
      "SELECT subject, body_html, body_text FROM email_template_ver " +
      "WHERE template_code=? AND is_active=1 AND locale=? AND version=? LIMIT 1",
      (rs, i) -> {
        Map<String, String> m = new HashMap<String, String>();
        m.put("subject", rs.getString("subject"));
        m.put("html", rs.getString("body_html"));
        m.put("text", rs.getString("body_text"));
        return m;
      },
      code, locale, version
    );
    return list.isEmpty() ? null : list.get(0);
  }

  public Map<String, String> findDefaultForLocale(String code, String locale) {
    List<Map<String, String>> list = jdbc.query(
      "SELECT subject, body_html, body_text FROM email_template_ver " +
      "WHERE template_code=? AND is_active=1 AND locale=? AND is_default=1 " +
      "ORDER BY version DESC LIMIT 1",
      (rs, i) -> {
        Map<String, String> m = new HashMap<String, String>();
        m.put("subject", rs.getString("subject"));
        m.put("html", rs.getString("body_html"));
        m.put("text", rs.getString("body_text"));
        return m;
      },
      code, locale
    );
    return list.isEmpty() ? null : list.get(0);
  }

  public Map<String, String> findDefaultEnglish(String code) {
    List<Map<String, String>> list = jdbc.query(
      "SELECT subject, body_html, body_text FROM email_template_ver " +
      "WHERE template_code=? AND is_active=1 AND locale='en' AND is_default=1 " +
      "ORDER BY version DESC LIMIT 1",
      (rs, i) -> {
        Map<String, String> m = new HashMap<String, String>();
        m.put("subject", rs.getString("subject"));
        m.put("html", rs.getString("body_html"));
        m.put("text", rs.getString("body_text"));
        return m;
      },
      code
    );
    return list.isEmpty() ? null : list.get(0);
  }
}
