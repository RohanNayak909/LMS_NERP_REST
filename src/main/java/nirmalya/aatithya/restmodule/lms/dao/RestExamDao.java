package nirmalya.aatithya.restmodule.lms.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestExamDao {

  private static final Logger logger = LoggerFactory.getLogger(RestExamDao.class);

  @Autowired private EntityManager em;
  @Autowired private ServerDao serverDao;

  /* ---------------- helpers ---------------- */

  private static String esc(String v) { return v == null ? null : v.replace("'", "''"); }

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

  private static String ok(JsonResponse<Object> r, Object body) {
    r.setCode("success"); r.setMessage("OK"); r.setBody(body); return "OK";
  }

  /* ======================= HEALTH ======================= */

  public JsonResponse<Object> ping() {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      List<?> rows = callProc("ping", "");
      ok(resp, rows);
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
    }
    return resp;
  }

  /* ======================= RUNTIME ======================= */

  public JsonResponse<Object> eligibility(String userId, String productId, Integer trainingId, String mode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_user_id='" + esc(userId) + "'," +
          "@p_product_id='" + esc(productId) + "'," +
          "@p_training_id=" + (trainingId == null ? "NULL" : trainingId) + "," +
          "@p_mode='" + esc(mode == null ? "MOCK" : mode) + "';";
      List<?> rows = callProc("eligibility", value);
      ok(resp, rows);
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  /** Direct SQL — there is no SP action for hasOpenAttempt. */
  public JsonResponse<Object> hasOpenAttempt(String userId, String productId, Integer trainingId, String mode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      Query q = em.createNativeQuery(
          "SELECT id FROM lms_quiz_attempt " +
          "WHERE user_id=? AND product_id=? AND mode=? AND status='STARTED' " +
          "ORDER BY id DESC LIMIT 1");
      q.setParameter(1, userId);
      q.setParameter(2, productId);
      q.setParameter(3, mode == null ? "MOCK" : mode);
      @SuppressWarnings("unchecked")
      List<Object> rows = q.getResultList();

      Object id = rows.isEmpty() ? null : rows.get(0);
      Object attemptId;
      if (id instanceof BigInteger) attemptId = ((BigInteger) id).longValue();
      else if (id instanceof Number) attemptId = ((Number) id).longValue();
      else attemptId = id;

      resp.setCode("success");
      resp.setMessage("OK");
      resp.setBody(new HasOpenBody(attemptId != null ? 1 : 0, attemptId));
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
    }
    return resp;
  }

  public JsonResponse<Object> retakeStatus(String userId, String productId, Integer trainingId, String mode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_user_id='" + esc(userId) + "'," +
          "@p_product_id='" + esc(productId) + "'," +
          "@p_training_id=" + (trainingId == null ? "NULL" : trainingId) + "," +
          "@p_mode='" + esc(mode == null ? "MOCK" : mode) + "';";
      List<?> rows = callProc("retakeStatus", value);
      ok(resp, rows);
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  @Transactional
  public ResponseEntity<JsonResponse<Object>> productStart(
      String orgName, String orgDivision, String userId, String productId,
      Integer trainingId, String mode, Integer seed, String metaJson) {

    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_org=").append(orgName == null ? "NULL" : "'" + esc(orgName) + "'").append(",")
        .append("@p_orgDiv=").append(orgDivision == null ? "NULL" : "'" + esc(orgDivision) + "'").append(",")
        .append("@p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_training_id=").append(trainingId == null ? "NULL" : trainingId).append(",")
        .append("@p_mode=").append(mode == null ? "'MOCK'" : "'" + esc(mode) + "'").append(",")
        .append("@p_seed=").append(seed == null ? "NULL" : seed).append(",")
        .append("@p_meta_json=").append(metaJson == null ? "NULL" : "'" + esc(metaJson) + "'")
        .append(";")
        .toString();

      List<Object[]> rows = callProc("productStart", value);
      Object first = firstRow(rows);

      // Robust PAYMENT_REQUIRED detection (the SP returns a row with a 'code' column)
      boolean paymentRequired = false;
      if (first instanceof Object[]) {
        for (Object c : (Object[]) first) {
          if (c != null && "PAYMENT_REQUIRED".equalsIgnoreCase(String.valueOf(c))) {
            paymentRequired = true; break;
          }
        }
      } else if (first != null && "PAYMENT_REQUIRED".equalsIgnoreCase(String.valueOf(first))) {
        paymentRequired = true;
      }

      if (paymentRequired) {
        resp.setCode("PAYMENT_REQUIRED");
        resp.setMessage("Retake payment required");
        resp.setBody(rows); // includes price & metadata fields from SP
        return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(resp);
      }

      Object idCell = firstCell(rows);
      Object attemptId;
      if (idCell instanceof BigInteger) attemptId = ((BigInteger) idCell).longValue();
      else if (idCell instanceof Number) attemptId = ((Number) idCell).longValue();
      else attemptId = idCell;

      resp.setCode("success");
      resp.setMessage("Attempt started/resumed");
      resp.setBody(new AttemptIdBody(attemptId));
      return ResponseEntity.ok(resp);

    } catch (Exception e) {
      SQLException sqlx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sqlx != null && "45000".equals(sqlx.getSQLState())
          ? sqlx.getMessage()
          : "Could not start the test. Please try again.");
      resp.setBody(null);
      return ResponseEntity.badRequest().body(resp);
    }
  }

  public JsonResponse<Object> productGetQuestion(
      String userId, String productId, Integer trainingId, String mode, Integer qno) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_user_id='" + esc(userId) + "'," +
          "@p_product_id='" + esc(productId) + "'," +
          "@p_training_id=" + (trainingId == null ? "NULL" : trainingId) + "," +
          "@p_mode='" + esc(mode == null ? "MOCK" : mode) + "'," +
          "@p_qno=" + (qno == null ? 1 : qno) + ";";
      List<?> rows = callProc("productGetQuestion", value);
      ok(resp, rows);
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> productAnswer(
      String userId, String productId, Integer trainingId, String mode,
      Integer qno, String selectedJson, String subjective, Integer timeSpentSec) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_user_id='" + esc(userId) + "'," +
          "@p_product_id='" + esc(productId) + "'," +
          "@p_training_id=" + (trainingId == null ? "NULL" : trainingId) + "," +
          "@p_mode='" + esc(mode == null ? "MOCK" : mode) + "'," +
          "@p_qno=" + (qno == null ? 1 : qno) + "," +
          "@p_selected=" + (selectedJson == null ? "NULL" : "'" + esc(selectedJson) + "'") + "," +
          "@p_subjective=" + (subjective == null ? "NULL" : "'" + esc(subjective) + "'") + "," +
          "@p_time_spent_sec=" + (timeSpentSec == null ? 0 : timeSpentSec) + ";";
      callProc("productAnswer", value);
      resp.setCode("success"); resp.setMessage("Saved");
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> productFlag(
      String userId, String productId, Integer trainingId, String mode, Integer qno, Integer flagged) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_user_id='" + esc(userId) + "'," +
          "@p_product_id='" + esc(productId) + "'," +
          "@p_training_id=" + (trainingId == null ? "NULL" : trainingId) + "," +
          "@p_mode='" + esc(mode == null ? "MOCK" : mode) + "'," +
          "@p_qno=" + (qno == null ? 1 : qno) + "," +
          "@p_flagged=" + (flagged == null ? 1 : flagged) + ";";
      List<?> rows = callProc("productFlag", value);
      ok(resp, rows);
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> productSubmit(String userId, String productId, Integer trainingId, String mode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_user_id='" + esc(userId) + "'," +
          "@p_product_id='" + esc(productId) + "'," +
          "@p_training_id=" + (trainingId == null ? "NULL" : trainingId) + "," +
          "@p_mode='" + esc(mode == null ? "MOCK" : mode) + "';";
      List<?> rows = callProc("productSubmit", value);
      resp.setBody(firstRow(rows)); resp.setCode("success"); resp.setMessage("Submitted");
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  public JsonResponse<Object> productPalette(String userId, String productId, Integer trainingId, String mode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_user_id='" + esc(userId) + "'," +
          "@p_product_id='" + esc(productId) + "'," +
          "@p_training_id=" + (trainingId == null ? "NULL" : trainingId) + "," +
          "@p_mode='" + esc(mode == null ? "MOCK" : mode) + "';";
      List<?> rows = callProc("productPalette", value);
      ok(resp, rows);
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  public JsonResponse<Object> productAttemptSummary(String userId, String productId, Integer trainingId, String mode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_user_id='" + esc(userId) + "'," +
          "@p_product_id='" + esc(productId) + "'," +
          "@p_training_id=" + (trainingId == null ? "NULL" : trainingId) + "," +
          "@p_mode='" + esc(mode == null ? "MOCK" : mode) + "';";
      List<?> rows = callProc("productAttemptSummary", value);
      ok(resp, rows);
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  public JsonResponse<Object> resultHeader(String userId, String productId, Integer trainingId, String mode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_user_id='" + esc(userId) + "'," +
          "@p_product_id='" + esc(productId) + "'," +
          "@p_training_id=" + (trainingId == null ? "NULL" : trainingId) + "," +
          "@p_mode='" + esc(mode == null ? "MOCK" : mode) + "';";
      List<?> rows = callProc("resultHeader", value);
      ok(resp, rows);
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  /** Includes rationale_a/b/c/d, rationale_map_json, analysis_text from SP. */
  public JsonResponse<Object> resultAnswers(String userId, String productId, Integer trainingId, String mode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_user_id='" + esc(userId) + "'," +
          "@p_product_id='" + esc(productId) + "'," +
          "@p_training_id=" + (trainingId == null ? "NULL" : trainingId) + "," +
          "@p_mode='" + esc(mode == null ? "MOCK" : mode) + "';";
      List<?> rows = callProc("resultAnswers", value);
      ok(resp, rows);
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  @Transactional
  public JsonResponse<Object> productAbort(String userId, String productId, Integer trainingId, String mode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_user_id='" + esc(userId) + "'," +
          "@p_product_id='" + esc(productId) + "'," +
          "@p_training_id=" + (trainingId == null ? "NULL" : trainingId) + "," +
          "@p_mode='" + esc(mode == null ? "MOCK" : mode) + "';";
      List<?> rows = callProc("productAbort", value);
      resp.setBody(firstCell(rows)); resp.setCode("success"); resp.setMessage("Aborted if active");
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  /* ======================= PRODUCT OUTLINE / QUESTIONS ======================= */

  public JsonResponse<Object> outline(String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      // SP returns first result-set = quiz header (second set is sections). We keep questions in a separate endpoint.
      String value = "SET @p_product_id='" + esc(productId) + "';";
      List<?> rows = callProc("outline", value);
      ok(resp, rows);
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
    }
    return resp;
  }

  public JsonResponse<Object> questionList(String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "';";
      List<?> rows = callProc("questionList", value);
      ok(resp, rows);
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
    }
    return resp;
  }

  /* ======================= RETAKES (lms_payment_order) ======================= */

  public JsonResponse<Object> retakeCreateOrder(
      String userId, String productId, Integer trainingId, String gatewayPayloadJson, String mode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_user_id='" + esc(userId) + "'," +
          "@p_product_id='" + esc(productId) + "'," +
          "@p_training_id=" + (trainingId == null ? "NULL" : trainingId) + "," +
          "@p_mode='" + esc(mode == null ? "MOCK" : mode) + "'," +
          "@p_gateway_payload=" + (gatewayPayloadJson == null ? "NULL" : "'" + esc(gatewayPayloadJson) + "'") + ";";
      List<?> rows = callProc("retakeCreateOrder", value);
      ok(resp, rows);
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  public JsonResponse<Object> retakeGrantCredit(
      String userId, String productId, Integer trainingId, String mode, String orderCode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_user_id='" + esc(userId) + "'," +
          "@p_product_id='" + esc(productId) + "'," +
          "@p_training_id=" + (trainingId == null ? "NULL" : trainingId) + "," +
          "@p_mode='" + esc(mode == null ? "MOCK" : mode) + "'," +
          "@p_order_code='" + esc(orderCode) + "';";
      List<?> rows = callProc("retakeGrantCredit", value);
      ok(resp, rows);
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  /* ======================= REPORTS ======================= */

  public JsonResponse<Object> reportUserHistory(String userId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_user_id='" + esc(userId) + "';";
      List<?> rows = callProc("reportUserHistory", value);
      ok(resp, rows);
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
    }
    return resp;
  }

  public JsonResponse<Object> reportLeaderboard(String productId, Integer limit) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_product_id='" + esc(productId) + "',@p_limit=" + (limit == null ? 100 : limit) + ";";
      List<?> rows = callProc("reportLeaderboard", value);
      ok(resp, rows);
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
    }
    return resp;
  }

  /* ======================= ADMIN: QUIZ & MAPPING ======================= */

  public JsonResponse<Object> quizUpsert(
      String quizCode, String quizTitle, String quizDescription, String authorName,
      Integer durationSec, Integer totalMarks, Integer maxAttempts, String status) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_quiz_code='" + esc(quizCode) + "'," +
          "@p_quiz_title='" + esc(quizTitle) + "'," +
          "@p_quiz_description='" + esc(quizDescription) + "'," +
          "@p_author_name='" + esc(authorName) + "'," +
          "@p_duration_sec=" + (durationSec == null ? "NULL" : durationSec) + "," +
          "@p_total_marks=" + (totalMarks == null ? "NULL" : totalMarks) + "," +
          "@p_max_attempts=" + (maxAttempts == null ? "NULL" : maxAttempts) + "," +
          "@p_status=" + (status == null ? "NULL" : "'" + esc(status) + "'") + ";";
      List<?> rows = callProc("quizUpsert", value);
      ok(resp, rows);
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
    }
    return resp;
  }

  public JsonResponse<Object> quizPublish(String quizCode, String productId, Integer isPrimary, String mapStatus) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_quiz_code='" + esc(quizCode) + "'," +
          "@p_product_id=" + (productId == null ? "NULL" : "'" + esc(productId) + "'") + "," +
          "@p_is_primary=" + (isPrimary == null ? "1" : isPrimary) + "," +
          "@p_map_status=" + (mapStatus == null ? "NULL" : "'" + esc(mapStatus) + "'") + ";";
      List<?> rows = callProc("quizPublish", value);
      ok(resp, rows);
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
    }
    return resp;
  }

  public JsonResponse<Object> quizArchive(String quizCode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_quiz_code='" + esc(quizCode) + "';";
      List<?> rows = callProc("quizArchive", value);
      ok(resp, rows);
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
    }
    return resp;
  }

  public JsonResponse<Object> quizRestore(String quizCode, String toStatus) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_quiz_code='" + esc(quizCode) + "',@p_to_status=" +
          (toStatus == null ? "NULL" : "'" + esc(toStatus) + "'") + ";";
      List<?> rows = callProc("quizRestore", value);
      ok(resp, rows);
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
    }
    return resp;
  }

  public JsonResponse<Object> mapAdd(String quizCode, String productId, Integer isPrimary, String status) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_quiz_code='" + esc(quizCode) + "'," +
          "@p_product_id='" + esc(productId) + "'," +
          "@p_is_primary=" + (isPrimary == null ? 0 : isPrimary) + "," +
          "@p_status=" + (status == null ? "NULL" : "'" + esc(status) + "'") + ";";
      List<?> rows = callProc("mapAdd", value);
      ok(resp, rows);
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
    }
    return resp;
  }

  public JsonResponse<Object> mapRemove(String quizCode, String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_quiz_code='" + esc(quizCode) + "',@p_product_id='" + esc(productId) + "';";
      List<?> rows = callProc("mapRemove", value);
      ok(resp, rows);
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
    }
    return resp;
  }

  public JsonResponse<Object> mapSetPrimary(String productId, String quizCode, String status) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_product_id='" + esc(productId) + "'," +
          "@p_quiz_code='" + esc(quizCode) + "'," +
          "@p_status=" + (status == null ? "NULL" : "'" + esc(status) + "'") + ";";
      List<?> rows = callProc("mapSetPrimary", value);
      ok(resp, rows);
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
    }
    return resp;
  }

  public JsonResponse<Object> mapBulkStatus(String productId, String status) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_product_id='" + esc(productId) + "',@p_status='" + esc(status) + "';";
      List<?> rows = callProc("mapBulkStatus", value);
      ok(resp, rows);
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
    }
    return resp;
  }

  /* ===== Admin: JSON quiz config (save/view/edit) ===== */

  @Transactional
  public ResponseEntity<JsonResponse<Object>> saveQuiz(String quizDataJson, String userId, String org, String orgDiv) {
    // SP needs only @quizData — extra params are ignored (kept for compatibility)
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @quizData=" + (quizDataJson == null ? "NULL" : "'" + esc(quizDataJson) + "'") + ";";
      List<?> rows = callProc("saveQuiz", value);
      resp.setCode("success"); resp.setMessage("Saved"); resp.setBody(firstRow(rows));
      return ResponseEntity.ok(resp);
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
      return ResponseEntity.badRequest().body(resp);
    }
  }

  /** SP returns one JSON aggregate row. org args are ignored by SP; kept in signature for compatibility. */
  public JsonResponse<Object> viewQuizConfig(String orgName, String orgDivision) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      List<?> rows = callProc("viewQuizConfig", "");
      resp.setCode("success"); resp.setMessage("OK"); resp.setBody(firstRow(rows));
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  /** Uses @p_quizId and @pid2 (exact names required by SP). */
  public JsonResponse<Object> editQuizConfig(String quizId, Integer sNo, String org, String orgDiv) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value =
          "SET @p_quizId='" + esc(quizId) + "'," +
          "@pid2=" + (sNo == null ? "NULL" : sNo) + ";";
      List<?> rows = callProc("editQuizConfig", value);
      resp.setCode("success"); resp.setMessage("OK"); resp.setBody(firstRow(rows));
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      resp.setCode("failed");
      resp.setMessage(sx != null && "45000".equals(sx.getSQLState()) ? sx.getMessage() : e.getMessage());
    }
    return resp;
  }

  /* tiny holders */
  private static final class AttemptIdBody {
    public final Object attemptId;
    AttemptIdBody(Object id){ this.attemptId = id; }
  }

  private static final class HasOpenBody {
    public final int hasOpen;
    public final Object attemptId;
    HasOpenBody(int hasOpen, Object attemptId) {
      this.hasOpen = hasOpen;
      this.attemptId = attemptId;
    }
  }
}
