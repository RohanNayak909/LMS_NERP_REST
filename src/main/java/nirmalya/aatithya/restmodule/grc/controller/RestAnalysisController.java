package nirmalya.aatithya.restmodule.grc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.dao.AnalysisDao;
import nirmalya.aatithya.restmodule.grc.dao.IdentificationDao;
import nirmalya.aatithya.restmodule.grc.model.RestAnalysisModel;
import nirmalya.aatithya.restmodule.grc.model.RiskIdentifictionRestModel;
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;

@RestController
@RequestMapping("grc/")
public class RestAnalysisController {
	Logger logger = LoggerFactory.getLogger(RestAnalysisController.class);

	@Autowired

	AnalysisDao analysisDao;

	/*
	 * add main
	 */
	@PostMapping(value = "addAnalysisDetails")
	public ResponseEntity<JsonResponse<List<RestAnalysisModel>>> addIdentificationDetails(
			@RequestBody List<RestAnalysisModel> restAnalysisModel) {
		logger.info("Method :addAnalysisDetails starts");

		logger.info("Method :addAnalysisDetails endss");
		return analysisDao.addAnalysisDetails(restAnalysisModel);
	}
// view main 

	@RequestMapping(value = "viewaAllDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> viewaAllDetails(@RequestParam String orgName, String orgDivision, String userId) {
		logger.info("Method :viewaAllDetails start");

		logger.info("Method :viewaAllDetails endss");
		return analysisDao.viewaAllDetails(orgName, orgDivision, userId);

	}

	// add
	@PostMapping(value = "saveRiskdetails")
	public ResponseEntity<JsonResponse<Object>> saveRiskdetails(@RequestBody RestAnalysisModel model) {
		logger.info("Method : saveRiskdetails starts");

		logger.info("Method : saveRiskdetails ends");
		return analysisDao.saveRiskdetails(model);
	}

	// add
	@PostMapping(value = "saveImpactDetails")
	public ResponseEntity<JsonResponse<Object>> saveImpactDetails(@RequestBody RestAnalysisModel model) {
		logger.info("Method : saveImpactDetails starts");

		logger.info("Method : saveImpactDetails ends");
		return analysisDao.saveImpactDetails(model);
	}

	@RequestMapping(value = "viewRiskDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRiskDetails(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :viewRiskDetails start");

		logger.info("Method :viewRiskDetails endss");
		return analysisDao.viewRiskDetails(id, orgName, orgDivision);

	}

	@RequestMapping(value = "viewImpactDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> viewImpactDetails(@RequestParam String orgName, String orgDivision, String riskId) {
		logger.info("Method :viewImpactDetails start");

		logger.info("Method :viewImpactDetails endss");
		return analysisDao.viewImpactDetails(orgName, orgDivision, riskId);

	}

	// edit main data
	@RequestMapping(value = "rest-editAnalysisData", method = { RequestMethod.GET })
	public JsonResponse<Object> editAnalysisData(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editAnalysisData start");

		logger.info("Method :editAnalysisData endss");
		return analysisDao.editAnalysisData(id, orgName, orgDivision);
	}

	// edit data
	@RequestMapping(value = "rest-editImpactData", method = { RequestMethod.GET })
	public JsonResponse<Object> editImpactData(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editImpactData start");

		logger.info("Method :editImpactData endss");
		return analysisDao.editImpactData(id, orgName, orgDivision);
	}

	// getImpactAndRiskData
	@RequestMapping(value = "rest-getImpactAndRiskData", method = { RequestMethod.GET })
	public JsonResponse<Object> getImpactAndRiskData(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :getImpactAndRiskData start");

		logger.info("Method :getImpactAndRiskData endss");
		return analysisDao.getImpactAndRiskData(id, orgName, orgDivision);
	}

	/*
	 * delete
	 * 
	 */
	@RequestMapping(value = "deleteAnalysisDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAnalysisDetails(@RequestParam String id) {
		logger.info("Method : deleteAnalysisDetails starts");

		logger.info("Method : deleteAnalysisDetails ends");
		return analysisDao.deleteAnalysisDetails(id);
	}

	@GetMapping(value = "approveAnalysisDetails")
	public JsonResponse<DropDownModel> approveAnalysisDetails(@RequestParam String approveStatus,
			String analysisId, String orgName, String orgDivision) {
		logger.info("Method : approveAnalysisDetails starts");

		logger.info("Method : approveAnalysisDetails ends");
		return analysisDao.approveAnalysisDetails(approveStatus, analysisId, orgName, orgDivision);
	}
}
