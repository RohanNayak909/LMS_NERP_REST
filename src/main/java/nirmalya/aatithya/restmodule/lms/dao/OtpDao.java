package nirmalya.aatithya.restmodule.lms.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Repository
public class OtpDao {
  private final JdbcTemplate jdbc;

  public OtpDao(JdbcTemplate jdbc) { this.jdbc = jdbc; }

  public static class CreateResult {
    public final long requestId;
    public final String otpPlain;
    public CreateResult(long id, String otp) { this.requestId = id; this.otpPlain = otp; }
  }

  public CreateResult create(final String email,
                             final String purpose,
                             final int ttlMin,
                             final int maxAttempts,
                             final String ip) {
    return jdbc.execute((Connection con) -> {
      CallableStatement cs = con.prepareCall("{CALL sp_otp_request_create(?,?,?,?,?,?,?)}");
      cs.setString(1, email);
      cs.setString(2, purpose);
      cs.setInt(3, ttlMin);
      cs.setInt(4, maxAttempts);
      cs.setString(5, ip);
      cs.registerOutParameter(6, Types.BIGINT);
      cs.registerOutParameter(7, Types.VARCHAR);
      return cs;
    }, (CallableStatement cs) -> {
      cs.execute();
      long id = cs.getLong(6);
      String otp = cs.getString(7);
      return new CreateResult(id, otp);
    });
  }

  public Map<String, Object> verify(final String email,
                                    final String purpose,
                                    final String otpPlain) {
    return jdbc.execute((Connection con) -> {
      CallableStatement cs = con.prepareCall("{CALL sp_otp_verify(?,?,?,?,?)}");
      cs.setString(1, email);
      cs.setString(2, purpose);
      cs.setString(3, otpPlain);
      cs.registerOutParameter(4, Types.TINYINT);
      cs.registerOutParameter(5, Types.VARCHAR);
      return cs;
    }, (CallableStatement cs) -> {
      cs.execute();
      boolean ok = cs.getInt(4) == 1;
      String msg = cs.getString(5);
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("ok", Boolean.valueOf(ok));
      map.put("message", msg);
      return map;
    });
  }
}
