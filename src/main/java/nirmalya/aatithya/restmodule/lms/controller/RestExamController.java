package nirmalya.aatithya.restmodule.lms.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.storage.v2.Object;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.lms.dao.RestExamDao;

@RestController

@RequestMapping(value = { "master/" })
@CrossOrigin(origins = "*")
public class RestExamController {

  private static final Logger logger = LoggerFactory.getLogger(RestExamController.class);

  @Autowired
  private RestExamDao dao;

  /* ======================= RUNTIME ======================= */

  @RequestMapping(value = "rest-exam-start", method = { RequestMethod.POST })
  public JsonResponse<Object> start(@RequestParam String orgName,
                                    @RequestParam String orgDivision,
                                    @RequestParam String userId,
                                    @RequestParam String productId,
                                    @RequestParam(required = false) String mode,
                                    @RequestBody(required = false) String metaJson) {
    logger.info("rest-exam-start");
    return dao.productStart(orgName, orgDivision, userId, productId, mode, null, metaJson);
  }

  @RequestMapping(value = "rest-exam-get-question", method = { RequestMethod.GET })
  public JsonResponse<Object> getQuestion(@RequestParam String userId,
                                          @RequestParam String productId,
                                          @RequestParam Integer qno) {
    return dao.productGetQuestion(userId, productId, qno);
  }

  @RequestMapping(value = "rest-exam-answer", method = { RequestMethod.POST })
  public JsonResponse<Object> answer(@RequestParam String userId,
                                     @RequestParam String productId,
                                     @RequestParam Integer qno,
                                     @RequestParam(required = false) String selected,
                                     @RequestParam(required = false) String subjective,
                                     @RequestParam(required = false) Integer timeSpentSec) {
    return dao.productAnswer(userId, productId, qno, selected, subjective, timeSpentSec);
  }

  @RequestMapping(value = "rest-exam-submit", method = { RequestMethod.POST })
  public JsonResponse<Object> submit(@RequestParam String userId, @RequestParam String productId) {
    return dao.productSubmit(userId, productId);
  }

  @RequestMapping(value = "rest-exam-result-header", method = { RequestMethod.GET })
  public JsonResponse<Object> resultHeader(@RequestParam String userId, @RequestParam String productId) {
    return dao.resultHeader(userId, productId);
  }

  @RequestMapping(value = "rest-exam-result-breakdown", method = { RequestMethod.GET })
  public JsonResponse<Object> resultBreakdown(@RequestParam String userId, @RequestParam String productId) {
    return dao.resultBreakdown(userId, productId);
  }

  @RequestMapping(value = "rest-product-outline", method = { RequestMethod.GET })
  public JsonResponse<Object> outline(@RequestParam String productId) {
    return dao.outline(productId);
  }

  @RequestMapping(value = "rest-product-questions", method = { RequestMethod.GET })
  public JsonResponse<Object> questions(@RequestParam String productId) {
    return dao.questionList(productId);
  }

  /* ======================= REPORTS ======================= */

  @RequestMapping(value = "rest-report-attempts-30d", method = { RequestMethod.GET })
  public JsonResponse<Object> attempts30d() {
    return dao.attempts30d();
  }

  @RequestMapping(value = "rest-report-user-history", method = { RequestMethod.GET })
  public JsonResponse<Object> userHistory(@RequestParam String userId) {
    return dao.userHistory(userId);
  }

  @RequestMapping(value = "rest-report-leaderboard", method = { RequestMethod.GET })
  public JsonResponse<Object> leaderboard(@RequestParam String productId,
                                          @RequestParam(required = false) Integer limit) {
    return dao.leaderboard(productId, limit);
  }

  /* ============== ADMIN / PUBLISH / MAPPING / QUESTIONS ============== */

  @RequestMapping(value = "rest-quiz-upsert", method = { RequestMethod.POST })
  public JsonResponse<Object> quizUpsert(@RequestParam String quizCode,
                                         @RequestParam String quizTitle,
                                         @RequestParam(required = false) String quizDescription,
                                         @RequestParam(required = false) String authorName,
                                         @RequestParam(required = false) Integer durationSec,
                                         @RequestParam(required = false) String totalMarks,
                                         @RequestParam(required = false) Integer maxAttempts,
                                         @RequestParam(required = false) String status) {
    return dao.quizUpsert(quizCode, quizTitle, quizDescription, authorName, durationSec, totalMarks, maxAttempts, status);
  }

  @RequestMapping(value = "rest-quiz-publish", method = { RequestMethod.POST })
  public JsonResponse<Object> quizPublish(@RequestParam String quizCode,
                                          @RequestParam(required = false) String productId,
                                          @RequestParam(required = false) Integer isPrimary,
                                          @RequestParam(required = false) String mapStatus) {
    return dao.quizPublish(quizCode, productId, isPrimary, mapStatus);
  }

  @RequestMapping(value = "rest-quiz-archive", method = { RequestMethod.POST })
  public JsonResponse<Object> quizArchive(@RequestParam String quizCode) {
    return dao.quizArchive(quizCode);
  }

  @RequestMapping(value = "rest-quiz-restore", method = { RequestMethod.POST })
  public JsonResponse<Object> quizRestore(@RequestParam String quizCode,
                                          @RequestParam(required = false) String toStatus) {
    return dao.quizRestore(quizCode, toStatus);
  }

  @RequestMapping(value = "rest-map-add", method = { RequestMethod.POST })
  public JsonResponse<Object> mapAdd(@RequestParam String productId,
                                     @RequestParam String quizCode,
                                     @RequestParam(required = false) Integer isPrimary,
                                     @RequestParam(required = false) String status) {
    return dao.mapAdd(productId, quizCode, isPrimary, status);
  }

  @RequestMapping(value = "rest-map-remove", method = { RequestMethod.POST })
  public JsonResponse<Object> mapRemove(@RequestParam String productId, @RequestParam String quizCode) {
    return dao.mapRemove(productId, quizCode);
  }

  @RequestMapping(value = "rest-map-set-primary", method = { RequestMethod.POST })
  public JsonResponse<Object> mapPrimary(@RequestParam String productId,
                                         @RequestParam String quizCode,
                                         @RequestParam(required = false) String status) {
    return dao.mapSetPrimary(productId, quizCode, status);
  }

  @RequestMapping(value = "rest-map-bulk-status", method = { RequestMethod.POST })
  public JsonResponse<Object> mapBulkStatus(@RequestParam String productId, @RequestParam String status) {
    return dao.mapBulkStatus(productId, status);
  }

  @RequestMapping(value = "rest-quiz-sanity", method = { RequestMethod.GET })
  public JsonResponse<Object> quizSanity(@RequestParam String quizCode) {
    return dao.quizSanityCheck(quizCode);
  }

  @RequestMapping(value = "rest-quiz-list", method = { RequestMethod.GET })
  public JsonResponse<Object> quizList(@RequestParam(required = false) String status) {
    return dao.quizList(status);
  }

  @RequestMapping(value = "rest-product-quizzes", method = { RequestMethod.GET })
  public JsonResponse<Object> productQuizzes(@RequestParam String productId) {

    logger.info("rest-exam-start");

    return dao.productQuizzes(productId);
  }
}