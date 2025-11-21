package nirmalya.aatithya.restmodule.lms.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ExamPaymentDao {

  private final JdbcTemplate jdbc;

  public ExamPaymentDao(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  /**
   * Calls lms_exam_routines('retakeCreateOrder', ...) and returns a Map<String,Object>
   * with whatever columns the SP returns:
   * - Normal: order_code, base_paise, gst_percent, gst_paise, amount_paise, currency, purpose, status
   * - ORDER_ALREADY_CREATED: order_code, code, message, base_paise, gst_percent, gst_paise, amount_paise, currency
   * - RETAKE_NOT_CONSUMED_YET: code, message (no order_code / purpose / status)
   *
   * Using metadata so we don't get "Column 'purpose' not found" when SP omits it.
   */
  public Map<String, Object> createRetakeOrder(
      String userId,
      String productId,
      Integer trainingId,
      String quizCode   // 🔹 NEW: quiz-wise retake
  ) {

    StringBuilder sb = new StringBuilder("SET ");
    sb.append("@p_user_id='").append(userId).append("',");
    sb.append("@p_product_id='").append(productId).append("',");
    if (trainingId != null) {
      sb.append("@p_training_id=").append(trainingId).append(",");
    } else {
      sb.append("@p_training_id=NULL,");
    }
    if (quizCode != null && !quizCode.isEmpty()) {
      sb.append("@p_quiz_code='").append(quizCode.replace("'", "''")).append("'");
    } else {
      sb.append("@p_quiz_code=NULL");
    }

    String actionValue = sb.toString();

    return jdbc.query(
        "CALL lms_exam_routines(?, ?)",
        new Object[]{"retakeCreateOrder", actionValue},
        rs -> {
          if (!rs.next()) {
            throw new IllegalStateException("retakeCreateOrder returned no row");
          }
          return mapRowToMap(rs);
        }
    );
  }

  private Map<String, Object> mapRowToMap(ResultSet rs) throws SQLException {
    Map<String, Object> row = new HashMap<>();
    ResultSetMetaData meta = rs.getMetaData();
    int colCount = meta.getColumnCount();
    for (int i = 1; i <= colCount; i++) {
      String label = meta.getColumnLabel(i); // respects aliases like 'order_code'
      Object value = rs.getObject(i);
      row.put(label, value);
    }
    return row;
  }

  public void updateGatewayPayloadForOrder(String orderCode, String gatewayPayloadJson) {
    jdbc.update(
        "UPDATE lms_payment_order SET gateway_payload = ? WHERE order_code = ?",
        gatewayPayloadJson,
        orderCode
    );
  }

  public void markRetakePaid(String orderCode, String userId, String productId, Integer trainingId) {
    StringBuilder sb = new StringBuilder("SET ");
    sb.append("@p_user_id='").append(userId).append("',");
    sb.append("@p_product_id='").append(productId).append("',");
    if (trainingId != null) {
      sb.append("@p_training_id=").append(trainingId).append(",");
    } else {
      sb.append("@p_training_id=NULL,");
    }
    sb.append("@p_order_code='").append(orderCode).append("'");

    String actionValue = sb.toString();

    jdbc.query(
        "CALL lms_exam_routines(?, ?)",
        new Object[]{"retakeGrantCredit", actionValue},
        rs -> null // just consume result
    );
  }
}
