package nirmalya.aatithya.restmodule.lms.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.lms.dao.RestExamDao;

@RestController
@RequestMapping(value = { "master" })
@CrossOrigin(origins = "*")
public class RestExamController {

  private static final Logger logger = LoggerFactory.getLogger(RestExamController.class);

  @Autowired private RestExamDao dao;

  /* ======================= HEALTH ======================= */

  @GetMapping("rest-exam-ping")
  public JsonResponse<Object> ping() {
    return dao.ping();
  }

  /* ======================= RUNTIME ======================= */

  // Legacy alias (kept)
  @GetMapping("rest-exam-eligibilitys")
  public JsonResponse<Object> eligibilityLegacy(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode) {
    return dao.eligibility(userId, productId, trainingId, mode);
  }

  @GetMapping("rest-exam-eligibility")
  public JsonResponse<Object> eligibility(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode) {
    return dao.eligibility(userId, productId, trainingId, mode);
  }

  /** Check if there is an open (STARTED) attempt. (Direct SQL; no SP action needed) */
  @GetMapping("rest-exam-has-open")
  public JsonResponse<Object> hasOpenAttempt(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode) {
    return dao.hasOpenAttempt(userId, productId, trainingId, mode);
  }

  @GetMapping("rest-exam-retake-status")
  public JsonResponse<Object> retakeStatus(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode) {
    return dao.retakeStatus(userId, productId, trainingId, mode);
  }

  @PostMapping("rest-exam-start")
  public ResponseEntity<JsonResponse<Object>> start(
      @RequestParam String orgName, @RequestParam String orgDivision,
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode,
      @RequestParam(required = false) Integer seed,
      @RequestParam(required = false) String metaJson) {
    return dao.productStart(orgName, orgDivision, userId, productId, trainingId, mode, seed, metaJson);
  }

  @GetMapping("rest-exam-get-question")
  public JsonResponse<Object> getQuestion(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode,
      @RequestParam Integer qno) {
    return dao.productGetQuestion(userId, productId, trainingId, mode, qno);
  }

  @PostMapping("rest-exam-answer")
  public JsonResponse<Object> answer(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode,
      @RequestParam Integer qno,
      @RequestParam(required = false) String selected,
      @RequestParam(required = false) String subjective,
      @RequestParam(required = false) Integer timeSpentSec) {
    return dao.productAnswer(userId, productId, trainingId, mode, qno, selected, subjective, timeSpentSec);
  }

  @PostMapping("rest-exam-flag")
  public JsonResponse<Object> flag(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode,
      @RequestParam Integer qno,
      @RequestParam(required = false, defaultValue = "1") Integer flagged) {
    return dao.productFlag(userId, productId, trainingId, mode, qno, flagged);
  }

  @PostMapping("rest-exam-submit")
  public JsonResponse<Object> submit(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode) {
    return dao.productSubmit(userId, productId, trainingId, mode);
  }

  @GetMapping("rest-exam-palette")
  public JsonResponse<Object> palette(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode) {
    return dao.productPalette(userId, productId, trainingId, mode);
  }

  @GetMapping("rest-exam-attempt-summary")
  public JsonResponse<Object> attemptSummary(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode) {
    return dao.productAttemptSummary(userId, productId, trainingId, mode);
  }

  @GetMapping("rest-exam-result-header")
  public JsonResponse<Object> resultHeader(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode) {
    return dao.resultHeader(userId, productId, trainingId, mode);
  }

  /** Includes rationale_* and analysis_text from SP. */
  @GetMapping("rest-exam-result-answers")
  public JsonResponse<Object> resultAnswers(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode) {
    return dao.resultAnswers(userId, productId, trainingId, mode);
  }

  @PostMapping("rest-exam-abort")
  public JsonResponse<Object> abort(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode) {
    return dao.productAbort(userId, productId, trainingId, mode);
  }

  /* ======================= PRODUCT OUTLINE / QUESTIONS ======================= */

  @GetMapping("rest-product-outline")
  public JsonResponse<Object> outline(@RequestParam String productId) {
    return dao.outline(productId);
  }

  @GetMapping("rest-product-questions")
  public JsonResponse<Object> questions(@RequestParam String productId) {
    return dao.questionList(productId);
  }

  /* ======================= REPORTS ======================= */

  @GetMapping("rest-report-user-history")
  public JsonResponse<Object> reportHistory(@RequestParam String userId) {
    return dao.reportUserHistory(userId);
  }

  @GetMapping("rest-report-leaderboard")
  public JsonResponse<Object> reportLeaderboard(
      @RequestParam String productId,
      @RequestParam(required = false, defaultValue = "100") Integer limit) {
    return dao.reportLeaderboard(productId, limit);
  }

  /* ======================= RETAKES ======================= */

  @PostMapping("rest-exam-retake-create-order")
  public JsonResponse<Object> retakeCreateOrder(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode,
      @RequestParam(required = false) String gatewayPayloadJson) {
    return dao.retakeCreateOrder(userId, productId, trainingId, gatewayPayloadJson, mode);
  }

  @PostMapping("rest-exam-retake-grant-credit")
  public JsonResponse<Object> retakeGrantCredit(
      @RequestParam String userId, @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode,
      @RequestParam String orderCode) {
    return dao.retakeGrantCredit(userId, productId, trainingId, mode, orderCode);
  }

  /* ======================= ADMIN: QUIZ & MAPPING ======================= */

  @PostMapping("rest-quiz-upsert")
  public JsonResponse<Object> quizUpsert(
      @RequestParam String quizCode,
      @RequestParam String quizTitle,
      @RequestParam(required = false, defaultValue = "") String quizDescription,
      @RequestParam(required = false, defaultValue = "") String authorName,
      @RequestParam(required = false) Integer durationSec,
      @RequestParam(required = false) Integer totalMarks,
      @RequestParam(required = false) Integer maxAttempts,
      @RequestParam(required = false) String status) {
    return dao.quizUpsert(quizCode, quizTitle, quizDescription, authorName, durationSec, totalMarks, maxAttempts, status);
  }

  @PostMapping("rest-quiz-publish")
  public JsonResponse<Object> quizPublish(
      @RequestParam String quizCode,
      @RequestParam(required = false) String productId,
      @RequestParam(required = false, defaultValue = "1") Integer isPrimary,
      @RequestParam(required = false) String mapStatus) {
    return dao.quizPublish(quizCode, productId, isPrimary, mapStatus);
  }

  @PostMapping("rest-quiz-archive")
  public JsonResponse<Object> quizArchive(@RequestParam String quizCode) {
    return dao.quizArchive(quizCode);
  }

  @PostMapping("rest-quiz-restore")
  public JsonResponse<Object> quizRestore(
      @RequestParam String quizCode,
      @RequestParam(required = false) String toStatus) {
    return dao.quizRestore(quizCode, toStatus);
  }

  @PostMapping("rest-quiz-map-add")
  public JsonResponse<Object> mapAdd(
      @RequestParam String quizCode,
      @RequestParam String productId,
      @RequestParam(required = false, defaultValue = "0") Integer isPrimary,
      @RequestParam(required = false) String status) {
    return dao.mapAdd(quizCode, productId, isPrimary, status);
  }

  @PostMapping("rest-quiz-map-remove")
  public JsonResponse<Object> mapRemove(
      @RequestParam String quizCode,
      @RequestParam String productId) {
    return dao.mapRemove(quizCode, productId);
  }

  @PostMapping("rest-quiz-map-primary")
  public JsonResponse<Object> mapSetPrimary(
      @RequestParam String productId,
      @RequestParam String quizCode,
      @RequestParam(required = false) String status) {
    return dao.mapSetPrimary(productId, quizCode, status);
  }

  @PostMapping("rest-quiz-map-bulk-status")
  public JsonResponse<Object> mapBulkStatus(
      @RequestParam String productId,
      @RequestParam String status) {
    return dao.mapBulkStatus(productId, status);
  }

  /* ====== Admin: JSON quiz config (save/view/edit) ====== */

  /** SP needs only @quizData. org/orgDiv kept for compatibility, ignored in SP. */
  @PostMapping("rest-quiz-config-add")
  public ResponseEntity<JsonResponse<Object>> saveQuiz(@RequestBody Map<String,Object> bodyToSend) {
      logger.info("REST ▶️ rest-quiz-config-add called with payload length={} chars");
      return dao.saveQuiz(bodyToSend);
  }

  /** SP returns a single JSON aggregate. */
  @GetMapping("rest-viewQuizConfig")
  public JsonResponse<Object> viewQuizConfig(
      @RequestParam(required = false) String orgName,
      @RequestParam(required = false) String orgDivision) {
    return dao.viewQuizConfig(orgName, orgDivision);
  }

  /** Uses SP params: @p_quizId and @pid2 (NOT @p_id2). */
  @GetMapping("rest-editQuizConfig")
  public JsonResponse<Object> editQuizConfig(
      @RequestParam("id") String quizId,
      @RequestParam("id2") Integer sNo,
      @RequestParam(required = false) String organization,
      @RequestParam(required = false) String orgDivision) {
    return dao.editQuizConfig(quizId, sNo, organization, orgDivision);
  }
}
