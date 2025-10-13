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

  private List<?> callProc(String actionType, String actionValue) {
    Query q = em.createNativeQuery("CALL lms_exam_routines(:actionType, :actionValue)");
    q.setParameter("actionType", actionType);
    q.setParameter("actionValue", actionValue == null ? "" : actionValue);
    return q.getResultList();
  }

  /* ======================= RUNTIME ======================= */

  public JsonResponse<Object> eligibility(String userId, String productId, String mode) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_mode='").append(esc(mode == null ? "MOCK" : mode)).append("';")
        .toString();

      List<?> rows = callProc("eligibility", value);
      resp.setBody(rows);
      resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      if (sx != null && "45000".equals(sx.getSQLState())) {
        resp.setCode("failed"); resp.setMessage(sx.getMessage());
      } else {
        resp.setCode("failed"); resp.setMessage(e.getMessage());
      }
      logger.error("eligibility error", e);
    }
    return resp;
  }

  public JsonResponse<Object> productStart(String orgName, String orgDivision, String userId,
                                           String productId, String mode, Integer seed, String metaJson) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_org='").append(esc(orgName)).append("',")
        .append("@p_orgDiv='").append(esc(orgDivision)).append("',")
        .append("@p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_mode=").append(mode == null ? "'MOCK'" : "'" + esc(mode) + "'").append(",")
        .append("@p_seed=").append(seed == null ? "NULL" : seed).append(",")
        .append("@p_meta_json=").append(metaJson == null ? "NULL" : "'" + esc(metaJson) + "'")
        .append(";").toString();

      List<?> rows = callProc("productStart", value);
      Object r0 = firstRow(rows);

      /* Detect ATTEMPT_LIMIT shape coming from SP */
      if (r0 instanceof Object[]) {
        Object[] arr = (Object[]) r0;
        // tuple expected: code, message, attempts_allowed, attempts_used, product_id, quiz_code
        String code = arr.length > 0 && arr[0] != null ? String.valueOf(arr[0]) : null;
        if ("ATTEMPT_LIMIT".equalsIgnoreCase(code)) {
          resp.setCode("ATTEMPT_LIMIT");
          resp.setMessage(arr.length > 1 && arr[1] != null ? String.valueOf(arr[1]) : "Attempt limit reached");
          resp.setBody(rows);
          return resp;
        }
      }

      /* Otherwise, treat as success with attemptId in first cell */
      Object idCell = firstCell(rows);
      Object attemptId;
      if (idCell instanceof BigInteger) attemptId = ((BigInteger) idCell).longValue();
      else if (idCell instanceof Number) attemptId = ((Number) idCell).longValue();
      else attemptId = idCell;

      resp.setCode("success");
      resp.setMessage("Attempt started");
      resp.setBody(new AttemptIdBody(attemptId));

    } catch (Exception e) {
      SQLException sqlx = unwrapSqlException(e);
      if (sqlx != null && "45000".equals(sqlx.getSQLState())) {
        resp.setCode("failed");
        resp.setMessage(sqlx.getMessage());
        resp.setBody(null);
      } else {
        resp.setCode("failed");
        resp.setMessage("Could not start the test. Please try again.");
        resp.setBody(null);
      }
      logger.error("productStart error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> productGetQuestion(String userId, String productId, Integer qno) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_user_id='" + esc(userId) + "',@p_product_id='" + esc(productId) + "',@p_qno="
          + (qno == null ? 1 : qno) + ";";
      List<Object[]> rows = (List<Object[]>) callProc("productGetQuestion", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productGetQuestion error", e);
    }
    return resp;
  }

  public JsonResponse<Object> productAnswer(String userId, String productId, Integer qno,
                                            String selectedJson, String subjective, Integer timeSpentSec) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
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

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> productFlag(String userId, String productId, Integer qno, Integer flagged) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_qno=").append(qno == null ? 1 : qno).append(",")
        .append("@p_flagged=").append(flagged == null ? 1 : flagged)
        .append(";").toString();

      List<Object[]> rows = (List<Object[]>) callProc("productFlag", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("Flag updated");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productFlag error", e);
    }
    return resp;
  }

  public JsonResponse<Object> productSubmit(String userId, String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_user_id='" + esc(userId) + "',@p_product_id='" + esc(productId) + "';";
      List<?> rows = callProc("productSubmit", value);
      resp.setBody(firstCell(rows)); resp.setCode("success"); resp.setMessage("Submitted");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productSubmit error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> productPalette(String userId, String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_user_id='" + esc(userId) + "',@p_product_id='" + esc(productId) + "';";
      List<Object[]> rows = (List<Object[]>) callProc("productPalette", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productPalette error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> productAttemptSummary(String userId, String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_user_id='" + esc(userId) + "',@p_product_id='" + esc(productId) + "';";
      List<Object[]> rows = (List<Object[]>) callProc("productAttemptSummary", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productAttemptSummary error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> resultHeader(String userId, String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_user_id='" + esc(userId) + "',@p_product_id='" + esc(productId) + "';";
      List<Object[]> rows = (List<Object[]>) callProc("resultHeader", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("resultHeader error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> resultBreakdown(String userId, String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_user_id='" + esc(userId) + "',@p_product_id='" + esc(productId) + "';";
      List<Object[]> rows = (List<Object[]>) callProc("resultBreakdown", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("resultBreakdown error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> resultAnswers(String userId, String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_user_id='" + esc(userId) + "',@p_product_id='" + esc(productId) + "';";
      List<Object[]> rows = (List<Object[]>) callProc("resultAnswers", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("resultAnswers error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> outline(String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "';";
      List<Object[]> rows = (List<Object[]>) callProc("outline", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("outline error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> questionList(String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "';";
      List<Object[]> rows = (List<Object[]>) callProc("questionList", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("questionList error", e);
    }
    return resp;
  }

  /* ======================= REPORTS ======================= */

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> attempts30d() {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      List<Object[]> rows = (List<Object[]>) callProc("reportAttempts30d", "");
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("attempts30d error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> userHistory(String userId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_user_id='" + esc(userId) + "';";
      List<Object[]> rows = (List<Object[]>) callProc("reportUserHistory", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("userHistory error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> leaderboard(String productId, Integer limit) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "',@p_limit=" + (limit == null ? 100 : limit) + ";";
      List<Object[]> rows = (List<Object[]>) callProc("reportLeaderboard", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("leaderboard error", e);
    }
    return resp;
  }

  /* ============== ADMIN / PUBLISH / MAPPING / QUESTIONS ============== */

  @SuppressWarnings("unchecked")
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

      List<Object[]> rows = (List<Object[]>) callProc("quizUpsert", value);
      resp.setBody(rows != null && !rows.isEmpty() ? rows.get(0) : null);
      resp.setCode("success"); resp.setMessage("Quiz upserted");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("quizUpsert error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> quizPublish(String quizCode, String productId, Integer isPrimary, String mapStatus) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_quiz_code='").append(esc(quizCode)).append("',")
        .append("@p_product_id=").append(productId == null ? "NULL" : "'" + esc(productId) + "'").append(",")
        .append("@p_is_primary=").append(isPrimary == null ? 1 : isPrimary).append(",")
        .append("@p_map_status=").append(mapStatus == null ? "'ACTIVE'" : "'" + esc(mapStatus) + "'")
        .append(";").toString();

      List<Object[]> rows = (List<Object[]>) callProc("quizPublish", value);
      resp.setBody(rows != null && !rows.isEmpty() ? rows.get(0) : null);
      resp.setCode("success"); resp.setMessage("Quiz published");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("quizPublish error", e);
    }
    return resp;
  }

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

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> quizRestore(String quizCode, String toStatus) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_quiz_code='" + esc(quizCode) + "',@p_to_status='" + esc(toStatus == null ? "DRAFT" : toStatus) + "';";
      List<Object[]> rows = (List<Object[]>) callProc("quizRestore", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("Restored");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("quizRestore error", e);
    }
    return resp;
  }

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

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> mapBulkStatus(String productId, String status) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "',@p_status='" + esc(status) + "';";
      List<Object[]> rows = (List<Object[]>) callProc("mapBulkStatus", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("Bulk status updated");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("mapBulkStatus error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> quizList(String status) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = status == null ? "" : "SET @p_status='" + esc(status) + "';";
      List<Object[]> rows = (List<Object[]>) callProc("quizList", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("quizList error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> productQuizzes(String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "';";
      List<Object[]> rows = (List<Object[]>) callProc("productQuizzes", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productQuizzes error", e);
    }
    return resp;
  }

  /* ============== ADMIN: QUESTIONS ============== */

  public JsonResponse<Object> questionUpsertSimple(String quizCode, String sectionTitle, Integer sNo,
                                                   String questionText, String a, String b, String c, String d,
                                                   String rightAnswer, String ra, String rb, String rc, String rd) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_quiz_code='").append(esc(quizCode)).append("',")
        .append("@p_section_title=").append(sectionTitle == null ? "NULL" : "'" + esc(sectionTitle) + "'").append(",")
        .append("@p_s_no=").append(sNo == null ? "NULL" : sNo).append(",")
        .append("@p_question_text='").append(esc(questionText)).append("',")
        .append("@p_option_a='").append(esc(a)).append("',")
        .append("@p_option_b='").append(esc(b)).append("',")
        .append("@p_option_c='").append(esc(c)).append("',")
        .append("@p_option_d='").append(esc(d)).append("',")
        .append("@p_right_answer='").append(esc(rightAnswer)).append("',")
        .append("@p_rationale_a=").append(ra == null ? "NULL" : "'" + esc(ra) + "'").append(",")
        .append("@p_rationale_b=").append(rb == null ? "NULL" : "'" + esc(rb) + "'").append(",")
        .append("@p_rationale_c=").append(rc == null ? "NULL" : "'" + esc(rc) + "'").append(",")
        .append("@p_rationale_d=").append(rd == null ? "NULL" : "'" + esc(rd) + "'")
        .append(";").toString();
      callProc("questionUpsertSimple", value);
      resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("questionUpsertSimple error", e);
    }
    return resp;
  }

  public JsonResponse<Object> questionBulkImportSimple(String bulkJson) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_bulk_json='" + esc(bulkJson) + "';";
      List<?> rows = callProc("questionBulkImportSimple", value);
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("Imported");
    } catch (Exception e) {
      SQLException sx = unwrapSqlException(e);
      if (sx != null && "45000".equals(sx.getSQLState())) {
        resp.setCode("failed"); resp.setMessage(sx.getMessage());
      } else {
        resp.setCode("failed"); resp.setMessage(e.getMessage());
      }
      logger.error("questionBulkImportSimple error", e);
    }
    return resp;
  }

  /* ---- tiny holder ---- */
  private static final class AttemptIdBody {
    public final Object attemptId;
    AttemptIdBody(Object id) { this.attemptId = id; }
  }
  
  
//DAO Method
@SuppressWarnings("unchecked")
public ResponseEntity<JsonResponse<Object>> saveQuiz(String quizData, String userId, String org, String orgDiv) {
   logger.info("method: saveQuiz Starts");

   JsonResponse<Object> resp = new JsonResponse<>();
   try {
       // Validate and clean JSON data
       ObjectMapper mapper = new ObjectMapper();
       ObjectNode jsonNode = (ObjectNode) mapper.readTree(quizData);
       
       // Clean text fields if necessary (e.g., for excessive escapes in text areas)
       String[] textFields = {"question_text", "option_a", "option_b", "option_c", "option_d", 
                              "rationale_a", "rationale_b", "rationale_c", "rationale_d", "syllabus_ref"};
       for (String field : textFields) {
           if (jsonNode.has(field)) {
               String fieldValue = jsonNode.get(field).asText();
               logger.info("Raw {}: {}", field, fieldValue);
               // Clean excessive backslashes and escape sequences
               fieldValue = fieldValue.replaceAll("\\\\{2,}", "").replaceAll("\\\\n", "").replaceAll("\\\\t", "");
               logger.info("Cleaned {}: {}", field, fieldValue);
               jsonNode.put(field, fieldValue);
           }
       }
       
       // Extract quizId early using Jackson for reliability
       String quizId = "";
       if (jsonNode.has("quizId") && !jsonNode.get("quizId").isNull()) {
           quizId = jsonNode.get("quizId").asText();
           logger.info("Extracted quizId from JSON: " + quizId);
       } else {
           logger.info("No quizId found in JSON or quizId is null");
       }

       // Serialize to JSON with proper escaping
       String safeQuizData = mapper.writeValueAsString(jsonNode);
       logger.info("Serialized safeQuizData: " + safeQuizData);
       // Escape single quotes for MySQL (avoid excessive backslash escaping)
       safeQuizData = safeQuizData.replace("'", "''");

       String value = "SET @quizData='" + safeQuizData + "', @p_userId='" + userId + "', @p_org='" + org
               + "', @p_orgDiv='" + orgDiv + "';";
       logger.info("Constructed actionValue: " + value);

       // Execute saveQuiz or modifyQuiz based on quizId
       if (quizId == null || quizId.trim().isEmpty()) {
           logger.info("Creating new quiz (quizId is null or empty)");
           em.createNamedStoredProcedureQuery("lms_exam_routines").setParameter("actionType", "saveQuiz")
                   .setParameter("actionValue", value).execute();
           resp.setMessage("Quiz created successfully!");
           resp.setCode("Success");
       } else {
           logger.info("Modifying existing quiz with quizId: " + quizId);
           em.createNamedStoredProcedureQuery("lms_exam_routines")
                   .setParameter("actionType", "modifyQuiz").setParameter("actionValue", value).execute();
           resp.setMessage("Quiz modified successfully!");
           resp.setCode("Success");
       }
        
   } catch (Exception e) {
       logger.error("Error in saveQuiz: " + e.getMessage());
       try {
           String[] err = serverDao.errorProcedureCall(e);
           resp.setCode("Failed");
           resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
       } catch (Exception nestedException) {
           logger.error("Error while handling exception: " + nestedException.getMessage());
           resp.setCode("Failed");
           resp.setMessage("Oops! Something went wrong during error handling");
       }
   }

   ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
   logger.info("method: saveQuiz Ends: " + response);
   return response;
}
}
