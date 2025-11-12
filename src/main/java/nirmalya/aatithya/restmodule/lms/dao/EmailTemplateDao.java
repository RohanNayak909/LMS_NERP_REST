package nirmalya.aatithya.restmodule.lms.dao;

import java.sql.CallableStatement;

import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmailTemplateDao {

  private final JdbcTemplate jdbc;

  public EmailTemplateDao(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  /**
   * Upsert a template version and optionally make it default for (code, locale).
   * Mirrors: CALL sp_email_template_upsert(?,?,?,?,?,?,?)
   */
  public void upsertVersion(String code,
                            String locale,
                            int version,
                            String subject,
                            String html,
                            String text,
                            boolean makeDefault) {

    jdbc.execute((ConnectionCallback<Void>) conn -> {
      try (CallableStatement cs = conn.prepareCall("{CALL sp_email_template_upsert(?,?,?,?,?,?,?)}")) {
        cs.setString(1, code);
        cs.setString(2, locale);
        cs.setInt(3, version);
        cs.setString(4, subject);
        cs.setString(5, html);
        cs.setString(6, text);
        cs.setInt(7, makeDefault ? 1 : 0);
        cs.execute();
        return null;
      }
    });
  }
}
