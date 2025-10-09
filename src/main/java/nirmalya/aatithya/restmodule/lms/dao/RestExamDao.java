package nirmalya.aatithya.restmodule.lms.dao;

import java.util.List;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestExamDao {

  private static final Logger logger = LoggerFactory.getLogger(RestExamDao.class);

  @Autowired
  private EntityManager em;

  private static String esc(String v) {
    return v == null ? null : v.replace("'", "\\'");
  }

  /* ======================= RUNTIME ======================= */

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> productStart(String orgName, String orgDivision, String userId,
                                           String productId, String mode, Integer seed, String metaJson) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = new StringBuilder()
        .append("SET @p_org='").append(esc(orgName)).append("',")
        .append("@p_orgDiv='").append(esc(orgDivision)).append("',")
        .append("@p_user_id='").append(esc(userId)).append("',")
        .append("@p_product_id='").append(esc(productId)).append("',")
        .append("@p_mode='").append(mode == null ? "MOCK" : esc(mode)).append("',")
        .append("@p_seed=").append(seed == null ? "NULL" : seed).append(",")
        .append("@p_meta_json=").append(metaJson == null ? "NULL" : "'" + esc(metaJson) + "'")
        .append(";").toString();

      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
          .setParameter("actionType", "productStart")
          .setParameter("actionValue", value)
          .getResultList();

      resp.setBody(rows != null && !rows.isEmpty() ? rows.get(0) : null);
      resp.setCode("success"); resp.setMessage("Attempt started");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productStart error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> productGetQuestion(String userId, String productId, Integer qno) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_user_id='" + esc(userId) + "',@p_product_id='" + esc(productId) + "',@p_qno=" + (qno == null ? 1 : qno) + ";";
      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
          .setParameter("actionType", "productGetQuestion")
          .setParameter("actionValue", value)
          .getResultList();
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

      em.createNamedStoredProcedureQuery("lms_exam_routines")
        .setParameter("actionType", "productAnswer")
        .setParameter("actionValue", value)
        .getResultList();

      resp.setCode("success"); resp.setMessage("Saved");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productAnswer error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> productSubmit(String userId, String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_user_id='" + esc(userId) + "',@p_product_id='" + esc(productId) + "';";
      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
          .setParameter("actionType", "productSubmit")
          .setParameter("actionValue", value)
          .getResultList();
      resp.setBody(rows != null && !rows.isEmpty() ? rows.get(0) : null);
      resp.setCode("success"); resp.setMessage("Submitted");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productSubmit error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> resultHeader(String userId, String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_user_id='" + esc(userId) + "',@p_product_id='" + esc(productId) + "';";
      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
          .setParameter("actionType", "resultHeader")
          .setParameter("actionValue", value)
          .getResultList();
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
      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
          .setParameter("actionType", "resultBreakdown")
          .setParameter("actionValue", value)
          .getResultList();
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("resultBreakdown error", e);
    }
    return resp;
  }

  @SuppressWarnings("unchecked")
  public JsonResponse<Object> outline(String productId) {
    JsonResponse<Object> resp = new JsonResponse<>();
    try {
      String value = "SET @p_product_id='" + esc(productId) + "';";
      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
          .setParameter("actionType", "outline")
          .setParameter("actionValue", value)
          .getResultList();
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
      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
          .setParameter("actionType", "questionList")
          .setParameter("actionValue", value)
          .getResultList();
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
      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
          .setParameter("actionType", "reportAttempts30d")
          .setParameter("actionValue", "")
          .getResultList();
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
      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
          .setParameter("actionType", "reportUserHistory")
          .setParameter("actionValue", value)
          .getResultList();
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
      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
          .setParameter("actionType", "reportLeaderboard")
          .setParameter("actionValue", value)
          .getResultList();
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
        .append("@p_total_marks=").append(totalMarks == null ? "NULL" : esc(totalMarks)).append(",")
        .append("@p_max_attempts=").append(maxAttempts == null ? "NULL" : maxAttempts).append(",")
        .append("@p_status=").append(status == null ? "NULL" : "'" + esc(status) + "'")
        .append(";").toString();

      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
          .setParameter("actionType", "quizUpsert")
          .setParameter("actionValue", value)
          .getResultList();
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

      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
          .setParameter("actionType", "quizPublish")
          .setParameter("actionValue", value)
          .getResultList();
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
      em.createNamedStoredProcedureQuery("lms_exam_routines")
        .setParameter("actionType", "quizArchive")
        .setParameter("actionValue", value)
        .getResultList();
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
      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
        .setParameter("actionType", "quizRestore")
        .setParameter("actionValue", value)
        .getResultList();
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
      em.createNamedStoredProcedureQuery("lms_exam_routines")
        .setParameter("actionType", "mapAdd")
        .setParameter("actionValue", value)
        .getResultList();
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
      em.createNamedStoredProcedureQuery("lms_exam_routines")
        .setParameter("actionType", "mapRemove")
        .setParameter("actionValue", value)
        .getResultList();
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
      em.createNamedStoredProcedureQuery("lms_exam_routines")
        .setParameter("actionType", "mapSetPrimary")
        .setParameter("actionValue", value)
        .getResultList();
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
      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
        .setParameter("actionType", "mapBulkStatus")
        .setParameter("actionValue", value)
        .getResultList();
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
      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
        .setParameter("actionType", "quizList")
        .setParameter("actionValue", value)
        .getResultList();
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
      List<Object[]> rows = em.createNamedStoredProcedureQuery("lms_exam_routines")
        .setParameter("actionType", "productQuizzes")
        .setParameter("actionValue", value)
        .getResultList();
      resp.setBody(rows); resp.setCode("success"); resp.setMessage("OK");
    } catch (Exception e) {
      resp.setCode("failed"); resp.setMessage(e.getMessage());
      logger.error("productQuizzes error", e);
    }
    return resp;
  }
}
