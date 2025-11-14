/*
 * package nirmalya.aatithya.restmodule.apprasial.controller;
 * 
 * import java.util.List;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import nirmalya.aatithya.restmodule.apprasial.dao.AppraisalReviewDao; import
 * nirmalya.aatithya.restmodule.apprasial.dao.SelfAppraisalRestDao; import
 * nirmalya.aatithya.restmodule.common.MailService; import
 * nirmalya.aatithya.restmodule.common.utils.DropDownModel; import
 * nirmalya.aatithya.restmodule.common.utils.JsonResponse;
 * 
 * 
 * @RestController
 * 
 * @RequestMapping(value = { "appraisal/" }) public class ReviewRestController {
 * 
 * Logger logger = LoggerFactory.getLogger(SelfAppraisalRestController.class);
 * 
 * 
 * @Autowired AppraisalReviewDao reviewDao;
 * 
 * @Autowired MailService mailService;
 * 
 * get-all-360-employee-list
 * 
 * @RequestMapping(value = "rest-get-all-feedback-employee", method = {
 * RequestMethod.GET }) public JsonResponse<Object>
 * getAllFeedbackEmployee(@RequestParam String orgName, @RequestParam String
 * orgDivision,@RequestParam String id,@RequestParam String finYear) {
 * logger.info("Method :getAllFeedbackEmployee start");
 * logger.info("Method :getAllFeedbackEmployee endss"); return
 * reviewDao.getAllFeedbackEmployee(orgName, orgDivision,id,finYear); }
 * 
 * @RequestMapping(value = "get-all-employee-list", method = { RequestMethod.GET
 * }) public List<DropDownModel> getAllEmployee() {
 * logger.info("Method : getAllEmployee starts");
 * 
 * logger.info("Method : getAllEmployee ends"); return
 * reviewDao.getAllEmployee(); }
 * 
 * rest-savemanager-details
 * 
 * @PostMapping(value = "rest-savemanager-details") public
 * ResponseEntity<JsonResponse<Object>> savemanageRemarks(@RequestBody String
 * managerRemarksData,
 * 
 * @RequestParam String userId, @RequestParam String org, @RequestParam String
 * orgDiv,@RequestParam String baseUrl) {
 * logger.info("Method :savemanageRemarks starts");
 * logger.info("Method :savemanageRemarks endss"); return
 * reviewDao.savemanageRemarks(managerRemarksData, userId, org, orgDiv,baseUrl);
 * }
 * 
 * 
 * @RequestMapping(value = "rest-get-review-byId", method = { RequestMethod.GET
 * }) public JsonResponse<Object> getAllReviewById(@RequestParam String
 * orgName, @RequestParam String orgDivision,
 * 
 * @RequestParam String id,@RequestParam String email) {
 * logger.info("Method :getAllReviewById start");
 * logger.info("Method :getAllReviewById endss"); return
 * reviewDao.getAllReviewById(orgName, orgDivision, id,email); }
 * 
 * rest-get-kra-lists
 * 
 * @RequestMapping(value = "rest-get-kra-lists", method = { RequestMethod.GET })
 * public JsonResponse<Object> getAllKraLists(@RequestParam String
 * orgName, @RequestParam String orgDivision,
 * 
 * @RequestParam String id) { logger.info("Method :getAllKraLists start");
 * logger.info("Method :getAllKraLists endss"); return
 * reviewDao.getAllKraLists(orgName, orgDivision, id); }
 * 
 * 
 * rest-savemanager-details
 * 
 * @PostMapping(value = "rest-save-feedback") public
 * ResponseEntity<JsonResponse<Object>> saveFeedback(@RequestBody String
 * responseData,
 * 
 * @RequestParam String userId, @RequestParam String org, @RequestParam String
 * orgDiv,@RequestParam String baseUrl) {
 * logger.info("Method :saveFeedback starts");
 * logger.info("Method :saveFeedback endss"); return
 * reviewDao.saveFeedback(responseData, userId, org, orgDiv,baseUrl); }
 * 
 * rest-get-feedback-details
 * 
 * @RequestMapping(value = "rest-get-feedback-details", method = {
 * RequestMethod.GET }) public JsonResponse<Object>
 * getAllFeedbackDetails(@RequestParam String orgName, @RequestParam String
 * orgDivision,
 * 
 * @RequestParam String id,@RequestParam String finYear) {
 * logger.info("Method :getAllFeedbackDetails start");
 * logger.info("Method :getAllFeedbackDetails endss"); return
 * reviewDao.getAllFeedbackDetails(orgName, orgDivision, id,finYear); }
 * 
 * }
 */