package nirmalya.aatithya.restmodule.lms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.lms.dao.RestExamDao;

@RestController
@RequestMapping(value = { "master" }) // avoids double slash when gateway adds context
@CrossOrigin(origins = "*")
public class RestExamController {

  private static final Logger logger = LoggerFactory.getLogger(RestExamController.class);

  @Autowired
  RestExamDao dao;

  /* ======================= RUNTIME ======================= */

  @GetMapping("rest-exam-eligibilitys")
  public JsonResponse<Object> eligibility(
      @RequestParam String userId,
      @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "MOCK") String mode) {
    logger.info("rest-exam-eligibilitys user='{}' product='{}' trainingId='{}' mode='{}'",
        userId, productId, trainingId, mode);
    return dao.eligibility(userId, productId, trainingId, mode);
  }

  @PostMapping("rest-exam-start")
  public ResponseEntity<JsonResponse<Object>> start(
      @RequestParam String orgName,
      @RequestParam String orgDivision,
      @RequestParam String userId,
      @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false) String mode,
      @RequestParam(required = false) Integer seed,
      @RequestParam(required = false) String metaJson
  ) {
    logger.info("rest-exam-start org='{}' div='{}' user='{}' product='{}' trainingId='{}' mode='{}'",
        orgName, orgDivision, userId, productId, trainingId, mode);
    JsonResponse<Object> res = dao.productStart(
        orgName, orgDivision, userId, productId, trainingId, mode, seed, metaJson);

    if ("ATTEMPT_LIMIT".equalsIgnoreCase(res.getCode())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(res); // 409
    }
    if ("PAYMENT_REQUIRED".equalsIgnoreCase(res.getCode())) {
      return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(res); // 402
    }
    if ("failed".equalsIgnoreCase(res.getCode())) {
      return ResponseEntity.badRequest().body(res); // 400
    }
    return ResponseEntity.ok(res); // 200
  }

  @GetMapping("rest-exam-get-question")
  public JsonResponse<Object> getQuestion(
      @RequestParam String userId,
      @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam Integer qno) {
    return dao.productGetQuestion(userId, productId, trainingId, qno);
  }

  @PostMapping("rest-exam-answer")
  public JsonResponse<Object> answer(
      @RequestParam String userId,
      @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam Integer qno,
      @RequestParam(required = false) String selected,
      @RequestParam(required = false) String subjective,
      @RequestParam(required = false) Integer timeSpentSec) {
    return dao.productAnswer(userId, productId, trainingId, qno, selected, subjective, timeSpentSec);
  }

  @PostMapping("rest-exam-flag")
  public JsonResponse<Object> flag(
      @RequestParam String userId,
      @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam Integer qno,
      @RequestParam(required = false, defaultValue = "1") Integer flagged) {
    return dao.productFlag(userId, productId, trainingId, qno, flagged);
  }

  @PostMapping("rest-exam-submit")
  public JsonResponse<Object> submit(
      @RequestParam String userId,
      @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId) {
    return dao.productSubmit(userId, productId, trainingId);
  }

  @GetMapping("rest-exam-palette")
  public JsonResponse<Object> palette(
      @RequestParam String userId,
      @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId) {
    return dao.productPalette(userId, productId, trainingId);
  }

  @GetMapping("rest-exam-attempt-summary")
  public JsonResponse<Object> attemptSummary(
      @RequestParam String userId,
      @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId) {
    return dao.productAttemptSummary(userId, productId, trainingId);
  }

  @GetMapping("rest-exam-result-header")
  public JsonResponse<Object> resultHeader(
      @RequestParam String userId,
      @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId) {
    return dao.resultHeader(userId, productId, trainingId);
  }

  @GetMapping("rest-exam-result-breakdown")
  public JsonResponse<Object> resultBreakdown(
      @RequestParam String userId,
      @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId) {
    return dao.resultBreakdown(userId, productId, trainingId);
  }

  @GetMapping("rest-exam-result-answers")
  public JsonResponse<Object> resultAnswers(
      @RequestParam String userId,
      @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId) {
    return dao.resultAnswers(userId, productId, trainingId);
  }

  @PostMapping("rest-exam-abort")
  public JsonResponse<Object> abort(
      @RequestParam String userId,
      @RequestParam String productId,
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

  /* ======================= MARKETPLACE + RETAKES ======================= */

  @GetMapping("rest-marketplace-mock-list")
  public JsonResponse<Object> mockMarketplaceList(
      @RequestParam String userId,
      @RequestParam(required = false) String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false, defaultValue = "50") Integer limit) {
    return dao.mockMarketplaceList(userId, productId, trainingId, limit);
  }

  @PostMapping("rest-exam-retake-create-order")
  public JsonResponse<Object> retakeCreateOrder(
      @RequestParam String userId,
      @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam(required = false) String gatewayPayloadJson) {
    return dao.retakeCreateOrder(userId, productId, trainingId, gatewayPayloadJson);
  }

  @PostMapping("rest-exam-retake-grant-credit")
  public JsonResponse<Object> retakeGrantCredit(
      @RequestParam String userId,
      @RequestParam String productId,
      @RequestParam(required = false) Integer trainingId,
      @RequestParam String orderCode) {
    return dao.retakeGrantCredit(userId, productId, trainingId, orderCode);
  }

  /* ======================= REPORTS (RESTORED) ======================= */

  @GetMapping("rest-report-attempts-30d")
  public JsonResponse<Object> attempts30d() {
    return dao.attempts30d();
  }

  @GetMapping("rest-report-user-history")
  public JsonResponse<Object> userHistory(@RequestParam String userId) {
    return dao.userHistory(userId);
  }

  @GetMapping("rest-report-leaderboard")
  public JsonResponse<Object> leaderboard(
      @RequestParam String productId,
      @RequestParam(required = false) Integer limit) {
    return dao.leaderboard(productId, limit);
  }

  /* ============== ADMIN / PUBLISH / MAPPING / QUESTIONS ============== */

  @PostMapping("rest-quiz-upsert")
  public JsonResponse<Object> quizUpsert(
      @RequestParam String quizCode,
      @RequestParam String quizTitle,
      @RequestParam(required = false) String quizDescription,
      @RequestParam(required = false) String authorName,
      @RequestParam(required = false) Integer durationSec,
      @RequestParam(required = false) String totalMarks,
      @RequestParam(required = false) Integer maxAttempts,
      @RequestParam(required = false) String status) {
    return dao.quizUpsert(quizCode, quizTitle, quizDescription, authorName, durationSec, totalMarks, maxAttempts, status);
  }

  @PostMapping("rest-quiz-publish")
  public JsonResponse<Object> quizPublish(
      @RequestParam String quizCode,
      @RequestParam(required = false) String productId,
      @RequestParam(required = false) Integer isPrimary,
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

  @PostMapping("rest-map-add")
  public JsonResponse<Object> mapAdd(
      @RequestParam String productId,
      @RequestParam String quizCode,
      @RequestParam(required = false) Integer isPrimary,
      @RequestParam(required = false) String status) {
    return dao.mapAdd(productId, quizCode, isPrimary, status);
  }

  @PostMapping("rest-map-remove")
  public JsonResponse<Object> mapRemove(
      @RequestParam String productId,
      @RequestParam String quizCode) {
    return dao.mapRemove(productId, quizCode);
  }

  @PostMapping("rest-map-set-primary")
  public JsonResponse<Object> mapPrimary(
      @RequestParam String productId,
      @RequestParam String quizCode,
      @RequestParam(required = false) String status) {
    return dao.mapSetPrimary(productId, quizCode, status);
  }

  @PostMapping("rest-map-bulk-status")
  public JsonResponse<Object> mapBulkStatus(
      @RequestParam String productId,
      @RequestParam String status) {
    return dao.mapBulkStatus(productId, status);
  }

  @GetMapping("rest-quiz-list")
  public JsonResponse<Object> quizList(@RequestParam(required = false) String status) {
    return dao.quizList(status);
  }

  @GetMapping("rest-product-quizzes")
  public JsonResponse<Object> productQuizzes(@RequestParam String productId) {
    return dao.productQuizzes(productId);
  }

  /* ===== ADMIN: QUIZ CONFIG VIEW/EDIT ===== */

  @PostMapping("rest-quiz-config-add")
  public ResponseEntity<JsonResponse<Object>> saveQuiz(
      @RequestBody String quizData,
      @RequestParam String userId,
      @RequestParam String org,
      @RequestParam String orgDiv) {
    logger.info("rest-quiz-config-add user='{}' org='{}' div='{}'", userId, org, orgDiv);
    return dao.saveQuiz(quizData, userId, org, orgDiv);
  }

  @GetMapping("rest-viewQuizConfig")
  public JsonResponse<Object> viewQuizConfig(@RequestParam String orgName, @RequestParam String orgDivision) {
    return dao.viewQuizConfig(orgName, orgDivision);
  }

  @GetMapping("rest-editQuizConfig")
  public JsonResponse<Object> editQuizConfig(@RequestParam String id,
                                             @RequestParam Integer id2,
                                             @RequestParam String organization,
                                             @RequestParam String orgDivision) {
    return dao.editQuizConfig(id, id2, organization, orgDivision);
  }
}
