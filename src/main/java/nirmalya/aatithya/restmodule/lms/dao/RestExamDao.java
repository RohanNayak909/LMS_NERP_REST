package nirmalya.aatithya.restmodule.lms.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestExamDao {

  private static final Logger logger = LoggerFactory.getLogger(RestExamDao.class);

  @Autowired
  EntityManager em;

  @Autowired
  ServerDao serverDao;

  /* ======================= helpers ======================= */

  private static String esc(String v) {
    if (v == null) return null;
    return v.replace("'", "''");
  }

  private static SQLException unwrapSqlException(Throwable t) {
    Throwable cur = t;
    while (cur != null) {
      if (cur instanceof SQLException) return (SQLException) cur;
      cur = cur.getCause();
    }
    return null;
  }

  private static Object firstRow(List<?> rows) {
    if (rows == null || rows.isEmpty()) return null;
    return rows.get(0);
  }

  private static Object firstCell(List<?> rows) {
    if (rows == null || rows.isEmpty()) return null;
    Object r0 = rows.get(0);
    if (r0 instanceof Object[]) {
      Object[] arr = (Object[]) r0;
      return arr.length > 0 ? arr[0] : null;
    }
    return r0;
  }

  @SuppressWarnings("unchecked")
  private List<Object[]> callProc(String actionType, String actionValue) {
    Query q = em.createNativeQuery("CALL lms_exam_routines(:actionType, :actionValue)");
    q.setParameter("actionType", actionType);
    q.setParameter("actionValue", actionValue == null ? "" : actionValue);
    return (List<Object[]>) q.getResultList();
  }

  /* ======================= RUNTIME ======================= */

  public JsonResponse<Object> eligibility(String userId, String productId, Integer trainingId, String mode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId).append(",")
        .append("@p_mode='").append(esc(mode == null ? "MOCK" : mode)).append("';")
        .toString();

      List<?> rows = callProc("eligibility", value);
      resp.setBody(rows);
      resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
      logger.error("eligibility error", e);
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> productStart(String orgName, String orgDivision, String userId,
                                           String productId, Integer trainingId, String mode,
                                           Integer seed, String metaJson) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_org='").append(esc(orgName)).append("',")
        .append("@p_orgDiv='").append(esc(orgDivision)).append("',")
        .append("@p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId).append(",")
        .append("@p_mode=").append(mode == null ? "'MOCK'" : "'" + esc(mode) + "'").append(",")
        .append("@p_seed=").append(seed == null ? "NULL" : seed).append(",")
        .append("@p_meta_json=").append(metaJson == null ? "NULL" : "'" + esc(metaJson) + "'")
        .append(";").toString();

      List<Object[]> rows = callProc("productStart", value);
      Object r0 = firstRow(rows);

      // ATTEMPT_LIMIT / PAYMENT_REQUIRED path from SP (first col code)
      if (r0 instanceof Object[]) {
        Object[] arr = (Object[]) r0;
        String code = arr.length > 0 && arr[0] != null ? String.valueOf(arr[0]) : null;
        if ("ATTEMPT_LIMIT".equalsIgnoreCase(code)) {
          resp.setCode("ATTEMPT_LIMIT");
          resp.setMessage(arr.length > 1 && arr[1] != null ? String.valueOf(arr[1]) : "Attempt limit reached");
          resp.setBody(rows);
          return resp;
        }
        if ("PAYMENT_REQUIRED".equalsIgnoreCase(code)) {
          resp.setCode("PAYMENT_REQUIRED");
          resp.setMessage(arr.length > 1 && arr[1] != null ? String.valueOf(arr[1]) : "Retake requires payment");
          resp.setBody(rows);
          return resp;
        }
      }

      // Success path: SP returns single column attemptId
      Object idCell = firstCell(rows);
      Object attemptId;
      if (idCell instanceof BigInteger) attemptId = ((BigInteger) idCell).longValue();
      else if (idCell instanceof Number) attemptId = ((Number) idCell).longValue();
      else attemptId = idCell;

      resp.setCode("success");
      resp.setMessage("Attempt started/resumed");
      resp.setBody(new AttemptIdBody(attemptId));

    } catch (Exception e) {
      SQLException sqlx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sqlx != null && "45000".equals(sqlx.getSQLState())
          ? sqlx.getMessage()
          : "Could not start the test. Please try again.");
      resp.setBody(null);
      logger.error("productStart error", e);
    }
    return resp;
  }

  public JsonResponse<Object> productGetQuestion(String userId, String productId, Integer trainingId, Integer qno) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId).append(",")
        .append("@p_qno=").append(qno == null ? 1 : qno)
        .append(";").toString();
      List<?> rows = callProc("productGetQuestion", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productGetQuestion error", e);
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> productAnswer(String userId, String productId, Integer trainingId, Integer qno,
                                            String selectedJson, String subjective, Integer timeSpentSec) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId).append(",")
        .append("@p_qno=").append(qno == null ? 1 : qno).append(",")
        .append("@p_selected=").append(selectedJson == null ? "NULL" : "'" + esc(selectedJson) + "'").append(",")
        .append("@p_subjective=").append(subjective == null ? "NULL" : "'" + esc(subjective) + "'").append(",")
        .append("@p_time_spent_sec=").append(timeSpentSec == null ? 0 : timeSpentSec)
        .append(";").toString();

      callProc("productAnswer", value);
      resp.setCode("success"); resp.setMessage("Saved");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productAnswer error", e);
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> productFlag(String userId, String productId, Integer trainingId, Integer qno, Integer flagged) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId).append(",")
        .append("@p_qno=").append(qno == null ? 1 : qno).append(",")
        .append("@p_flagged=").append(flagged == null ? 1 : flagged)
        .append(";").toString();

      List<?> rows = callProc("productFlag", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("Flag updated");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productFlag error", e);
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> productSubmit(String userId, String productId, Integer trainingId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId)
        .append(";").toString();
      List<?> rows = callProc("productSubmit", value);
      resp.setBody(firstRow(rows));
      resp.setCode("success"); resp.setMessage("Submitted");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productSubmit error", e);
    }
    return resp;
  }

  public JsonResponse<Object> productPalette(String userId, String productId, Integer trainingId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId)
        .append(";").toString();
      List<?> rows = callProc("productPalette", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productPalette error", e);
    }
    return resp;
  }

  public JsonResponse<Object> productAttemptSummary(String userId, String productId, Integer trainingId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId)
        .append(";").toString();
      List<?> rows = callProc("productAttemptSummary", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productAttemptSummary error", e);
    }
    return resp;
  }

  public JsonResponse<Object> resultHeader(String userId, String productId, Integer trainingId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId)
        .append(";").toString();
      List<?> rows = callProc("resultHeader", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("resultHeader error", e);
    }
    return resp;
  }

  public JsonResponse<Object> resultBreakdown(String userId, String productId, Integer trainingId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId)
        .append(";").toString();
      List<?> rows = callProc("resultBreakdown", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("resultBreakdown error", e);
    }
    return resp;
  }

  public JsonResponse<Object> resultAnswers(String userId, String productId, Integer trainingId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId)
        .append(";").toString();
      List<?> rows = callProc("resultAnswers", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("resultAnswers error", e);
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> productAbort(String userId, String productId, Integer trainingId, String mode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
          .append("SET @p_user_id='").append(esc(userId)).append("',")
          .append("@p_product_id='").append(esc(productId)).append("',")
          .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId).append(",")
          .append("@p_mode='").append(esc(mode == null ? "MOCK" : mode)).append("';")
          .toString();
      List<?> rows = callProc("productAbort", value);
      resp.setBody(firstCell(rows)); // SP returns single JSON column
      resp.setCode("success");
      resp.setMessage("Aborted if active");
    } catch (Exception e) {
      resp.setCode("failed");
      resp.setMessage(e.getMessage());
      logger.error("productAbort error", e);
    }
    return resp;
  }

  /* ======================= PRODUCT OUTLINE / QUESTIONS ======================= */

  public JsonResponse<Object> outline(String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "';";
      List<?> rows = callProc("outline", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("outline error", e);
    }
    return resp;
  }

  public JsonResponse<Object> questionList(String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "';";
      List<?> rows = callProc("questionList", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("questionList error", e);
    }
    return resp;
  }

  /* ======================= MARKETPLACE + RETAKES ======================= */

  public JsonResponse<Object> mockMarketplaceList(String userId, String productId, Integer trainingId, Integer limit) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
          .append("SET @p_user_id='").append(esc(userId)).append("',")
          .append("@p_product_id=").append(productId == null ? "NULL" : "'" + esc(productId) + "'").append(",")
          .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId).append(",")
          .append("@p_limit=").append(limit == null ? 50 : limit).append(";")
          .toString();
      List<?> rows = callProc("mockMarketplaceList", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("mockMarketplaceList error", e);
    }
    return resp;
  }

  public JsonResponse<Object> retakeCreateOrder(String userId, String productId, Integer trainingId, String gatewayPayloadJson) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
          .append("SET @p_user_id='").append(esc(userId)).append("',")
          .append("@p_product_id='").append(esc(productId)).append("',")
          .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId).append(",")
          .append("@p_gateway_payload=").append(gatewayPayloadJson == null ? "NULL" : "'" + esc(gatewayPayloadJson) + "';")
          .toString();
      List<?> rows = callProc("retakeCreateOrder", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("Order created");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("retakeCreateOrder error", e);
    }
    return resp;
  }

  public JsonResponse<Object> retakeGrantCredit(String userId, String productId, Integer trainingId, String orderCode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
          .append("SET @p_user_id='").append(esc(userId)).append("',")
          .append("@p_product_id='").append(esc(productId)).append("',")
          .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId).append(",")
          .append("@p_order_code='").append(esc(orderCode)).append("';")
          .toString();
      List<?> rows = callProc("retakeGrantCredit", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("Credit granted");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("retakeGrantCredit error", e);
    }
    return resp;
  }

  /* ======================= REPORTS ======================= */

  public JsonResponse<Object> attempts30d() {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      List<?> rows = callProc("reportAttempts30d", "");
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("attempts30d error", e);
    }
    return resp;
  }

  public JsonResponse<Object> userHistory(String userId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_user_id='" + esc(userId) + "';";
      List<?> rows = callProc("reportUserHistory", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("userHistory error", e);
    }
    return resp;
  }

  public JsonResponse<Object> leaderboard(String productId, Integer limit) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "',@p_limit=" + (limit == null ? 100 : limit) + ";";
      List<?> rows = callProc("reportLeaderboard", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("leaderboard error", e);
    }
    return resp;
  }

  /* ============== ADMIN / PUBLISH / MAPPING / QUESTIONS ============== */

  @Transactional
  public JsonResponse<Object> quizUpsert(String quizCode, String quizTitle, String quizDescription,
                                         String author, Integer durationSec, String totalMarks,
                                         Integer maxAttempts, String status) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_quiz_code='").append(esc(quizCode)).append("',")
        .append("@p_quiz_title='").append(esc(quizTitle)).append("',")
        .append("@p_quiz_description=").append(quizDescription == null ? "NULL" : "'" + esc(quizDescription) + "'").append(",")
        .append("@p_author_name=").append(author == null ? "NULL" : "'" + esc(author) + "'").append(",")
        .append("@p_duration_sec=").append(durationSec == null ? "NULL" : durationSec).append(",")
        .append("@p_total_marks=").append(totalMarks == null ? "NULL" : "'" + esc(totalMarks) + "'").append(",")
        .append("@p_max_attempts=").append(maxAttempts == null ? "NULL" : maxAttempts).append(",")
        .append("@p_status=").append(status == null ? "NULL" : "'" + esc(status) + "'")
        .append(";").toString();

      List<?> rows = callProc("quizUpsert", value);
      resp.setBody(rows != null && !rows.isEmpty() ? rows.get(0) : null);
      resp.setCode("success"); resp.setMessage("Quiz upserted");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("quizUpsert error", e);
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> quizPublish(String quizCode, String productId, Integer isPrimary, String mapStatus) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_quiz_code='").append(esc(quizCode)).append("',")
        .append("@p_product_id=").append(productId == null ? "NULL" : "'" + esc(productId) + "'").append(",")
        .append("@p_is_primary=").append(isPrimary == null ? 1 : isPrimary).append(",")
        .append("@p_map_status=").append(mapStatus == null ? "'ACTIVE'" : "'" + esc(mapStatus) + "'")
        .append(";").toString();

      List<?> rows = callProc("quizPublish", value);
      resp.setBody(rows != null && !rows.isEmpty() ? rows.get(0) : null);
      resp.setCode("success"); resp.setMessage("Quiz published");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("quizPublish error", e);
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> quizArchive(String quizCode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_quiz_code='" + esc(quizCode) + "';";
      callProc("quizArchive", value);
      resp.setCode("success"); resp.setMessage("Archived");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("quizArchive error", e);
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> quizRestore(String quizCode, String toStatus) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_quiz_code='" + esc(quizCode) + "',@p_to_status='" + esc(toStatus == null ? "DRAFT" : toStatus) + "';";
      List<?> rows = callProc("quizRestore", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("Restored");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("quizRestore error", e);
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> mapAdd(String productId, String quizCode, Integer isPrimary, String status) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "',@p_quiz_code='" + esc(quizCode) + "',@p_is_primary=" + (isPrimary == null ? 0 : isPrimary) + ",@p_status='" + esc(status == null ? "ACTIVE" : status) + "';";
      callProc("mapAdd", value);
      resp.setCode("success"); resp.setMessage("Mapped");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("mapAdd error", e);
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> mapRemove(String productId, String quizCode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "',@p_quiz_code='" + esc(quizCode) + "';";
      callProc("mapRemove", value);
      resp.setCode("success"); resp.setMessage("Removed");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("mapRemove error", e);
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> mapSetPrimary(String productId, String quizCode, String status) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "',@p_quiz_code='" + esc(quizCode) + "',@p_status='" + esc(status == null ? "ACTIVE" : status) + "';";
      callProc("mapSetPrimary", value);
      resp.setCode("success"); resp.setMessage("Primary set");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("mapSetPrimary error", e);
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> mapBulkStatus(String productId, String status) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "',@p_status='" + esc(status) + "';";
      List<?> rows = callProc("mapBulkStatus", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("Bulk status updated");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("mapBulkStatus error", e);
    }
    return resp;
  }

  public JsonResponse<Object> quizList(String status) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = status == null ? "" : "SET @p_status='" + esc(status) + "';";
      List<?> rows = callProc("quizList", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("quizList error", e);
    }
    return resp;
  }

  public JsonResponse<Object> productQuizzes(String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "';";
      List<?> rows = callProc("productQuizzes", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productQuizzes error", e);
    }
    return resp;
  }

  /* ---- tiny holder ---- */
  private static final class AttemptIdBody {
    public final Object attemptId;
    AttemptIdBody(Object id) { this.attemptId = id; }
  }

  /* ===== QUIZ CONFIG VIEW/EDIT ===== */
  @Transactional
  @SuppressWarnings("unchecked")
  public ResponseEntity<JsonResponse<Object>> saveQuiz(Map<String, Object> quizData) {
      logger.info("Method : saveQuiz Starts");
      System.out.println("Value Of the Quiz Data------------->" + quizData);

      JsonResponse<Object> resp = new JsonResponse<>();

      try {
          String userId = (String) quizData.get("userId");
          String org = (String) quizData.get("org");
          String orgDiv = (String) quizData.get("orgDiv");
          List<Map<String, Object>> quizList = (List<Map<String, Object>>) quizData.get("quizzes");

          if (quizList == null || quizList.isEmpty()) {
              resp.setCode("Failed");
              resp.setMessage("❌ No quiz data found in request.");
              return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
          }

          logger.info("🧩 Received {} quiz question(s) (userId={}, org={}, orgDiv={})",
                  quizList.size(), userId, org, orgDiv);

          int counter = 1;
          List<Object> savedResults = new ArrayList<>();
          Set<String> processedSections = new HashSet<>();

          for (Map<String, Object> quizNode : quizList) {

              String quizCode = (String) quizNode.getOrDefault("quiz_code", "");
              String sectionTitle = (String) quizNode.getOrDefault("section_title", "");

              // ✅ Delete old data only once per quiz_code + section_title
              if (!quizCode.isEmpty() && !sectionTitle.isEmpty()) {
                  String key = quizCode + "|" + sectionTitle;
                  if (!processedSections.contains(key)) {
                      String deleteValue = String.format(
                              "SET @quiz_code='%s', @section_title='%s';",
                              quizCode.replace("'", "\\'"),
                              sectionTitle.replace("'", "\\'")
                      );
                      System.out.println("Delete Value Of The Quiz---->"+deleteValue);
                      em.createNativeQuery("CALL lms_quiz_routines(:actionType, :actionValue)")
                              .setParameter("actionType", "deleteOldQuizData")
                              .setParameter("actionValue", deleteValue)
                              .executeUpdate();
                      logger.info("🧹 Deleted old data for quiz='{}' section='{}'", quizCode, sectionTitle);
                      processedSections.add(key);
                  }
              }

              // ✅ Extract options and rationales
              List<Map<String, Object>> options = (List<Map<String, Object>>) quizNode.get("options");
              Map<String, String> optMap = new HashMap<>();
              Map<String, String> ratMap = new HashMap<>();

              if (options != null) {
                  for (Map<String, Object> opt : options) {
                      String label = opt.get("option").toString(); // A/B/C/D
                      String text = opt.get("text") != null ? opt.get("text").toString() : "";
                      String rationale = opt.get("rationale") != null ? opt.get("rationale").toString() : "";
                      optMap.put(label, text);
                      ratMap.put(label, rationale);
                  }
              }

              // ✅ Prepare SQL variable assignment string
              String actionValue = String.format(
                      "SET @quiz_code='%s', @section_title='%s', @question_text='%s', " +
                      "@option_a='%s', @option_b='%s', @option_c='%s', @option_d='%s', " +
                      "@rationale_a='%s', @rationale_b='%s', @rationale_c='%s', @rationale_d='%s', " +
                      "@right_answer='%s', @syllabus_ref='%s';",
                      safeStr(quizNode.get("quiz_code")),
                      safeStr(quizNode.get("section_title")),
                      safeStr(quizNode.get("question_text")),
                      safeStr(optMap.get("A")),
                      safeStr(optMap.get("B")),
                      safeStr(optMap.get("C")),
                      safeStr(optMap.get("D")),
                      safeStr(ratMap.get("A")),
                      safeStr(ratMap.get("B")),
                      safeStr(ratMap.get("C")),
                      safeStr(ratMap.get("D")),
                      safeStr(quizNode.get("right_answer")),
                      safeStr(quizNode.get("syllabus_ref"))
              );

              logger.info("🧠 [Record {}] Executing saveQuiz for quiz='{}' section='{}'", counter, quizCode, sectionTitle);
              System.out.println("Value for SQL ---> " + actionValue);

              // ✅ Call stored procedure
              Object result = em.createNativeQuery("CALL lms_quiz_routines(:actionType, :actionValue)")
                      .setParameter("actionType", "saveQuiz")
                      .setParameter("actionValue", actionValue)
                      .executeUpdate();

              savedResults.add(result);
              logger.info("✅ [Record {}] Quiz saved successfully", counter);

              counter++;
          }

          resp.setBody(savedResults);
          resp.setCode("success");
          resp.setMessage("✅ " + quizList.size() + " quiz question(s) saved successfully.");

      } catch (Exception e) {
          logger.error("❌ Error in saveQuiz: ", e);
          resp.setCode("Failed");
          resp.setMessage("Error while saving quiz: " + e.getMessage());
      }

      logger.info("Method : saveQuiz Ends");
      return new ResponseEntity<>(resp, HttpStatus.CREATED);
  }

  private String safeStr(Object val) {
      return val == null ? "" : val.toString().replace("'", "\\'");
  }


  /**
   * Fetches a value using multiple possible key names (handles camelCase / snake_case).
   */
  private String getVal(Map<String, Object> map, String... keys) {
      for (String key : keys) {
          Object val = map.get(key);
          if (val != null) return val.toString().trim();
      }
      return "";
  }



  public JsonResponse<Object> viewQuizConfig(String orgName, String orgDivision) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_org='" + esc(orgName) + "',@p_orgDiv='" + esc(orgDivision) + "';";
      List<?> list = callProc("viewQuizConfig", value);
      resp.setBody(list);
      resp.setMessage("Data fetched successfully");
      resp.setCode("success");
    } catch (Exception e) {
      resp.setMessage("Something went wrong!");
      resp.setCode("failed");
    }
    return resp;
  }

  public JsonResponse<Object> editQuizConfig(String quizId, Integer id2, String orgName, String orgDivision) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_quizId='" + esc(quizId) + "', @pid2=" + id2 + ";";
      List<?> list = callProc("editQuizConfig", value);
      resp.setBody(list);
      resp.setMessage("Data fetched successfully");
      resp.setCode("success");
    } catch (Exception e) {
      resp.setMessage("Something went wrong!");
      resp.setCode("failed");
    }
    return resp;
  }
}
