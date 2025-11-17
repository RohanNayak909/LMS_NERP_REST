package nirmalya.aatithya.restmodule.lms.dao;

import nirmalya.aatithya.restmodule.lms.model.RetakeOrderInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ExamPaymentDao {

  private final JdbcTemplate jdbc;

  public ExamPaymentDao(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public RetakeOrderInfo createRetakeOrder(String userId, String productId, Integer trainingId) {

    StringBuilder sb = new StringBuilder("SET ");
    sb.append("@p_user_id='").append(userId).append("',");
    sb.append("@p_product_id='").append(productId).append("',");
    if (trainingId != null) {
      sb.append("@p_training_id=").append(trainingId);
    } else {
      sb.append("@p_training_id=NULL");
    }

    String actionValue = sb.toString();

    return jdbc.query(
        "CALL lms_exam_routines(?,?)",
        new Object[]{"retakeCreateOrder", actionValue},
        rs -> {
          if (rs.next()) {
            return mapRetakeOrder(rs);
          }
          throw new IllegalStateException("retakeCreateOrder returned no row");
        }
    );
  }

  private RetakeOrderInfo mapRetakeOrder(ResultSet rs) throws SQLException {
    RetakeOrderInfo info = new RetakeOrderInfo();
    info.setOrderCode(rs.getString("order_code"));
    info.setBasePaise(rs.getInt("base_paise"));
    info.setGstPercent(rs.getBigDecimal("gst_percent"));
    info.setGstPaise(rs.getInt("gst_paise"));
    info.setAmountPaise(rs.getInt("amount_paise"));
    info.setCurrency(rs.getString("currency"));
    info.setPurpose(rs.getString("purpose")); // 'RETAKE'
    info.setStatus(rs.getString("status"));   // 'CREATED'
    return info;
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
        "CALL lms_exam_routines(?,?)",
        new Object[]{"retakeGrantCredit", actionValue},
        rs -> null  // just consume
    );
  }
}
