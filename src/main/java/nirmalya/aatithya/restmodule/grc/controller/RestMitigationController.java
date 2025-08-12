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
import nirmalya.aatithya.restmodule.grc.dao.MitigationDao;
import nirmalya.aatithya.restmodule.grc.model.RestMitigationModel;

@RestController
@RequestMapping("grc/")
public class RestMitigationController {
	Logger logger = LoggerFactory.getLogger(RestMitigationController.class);

	@Autowired

	MitigationDao mitigationDao;

	/*
	 * add main
	 */
	@PostMapping(value = "addMitigationDetails")
	public ResponseEntity<JsonResponse<List<RestMitigationModel>>> addIdentificationDetails(
			@RequestBody List<RestMitigationModel> RestMitigationModel) {
		logger.info("Method :addMitigationDetails starts");

		logger.info("Method :addMitigationDetails endss");
		return mitigationDao.addMitigationDetails(RestMitigationModel);
	}
// view main 

	@RequestMapping(value = "viewaAllDetailsForMitigation", method = { RequestMethod.GET })
	public JsonResponse<Object> viewaAllDetailsForMitigation(@RequestParam String orgName, String orgDivision, String userId) {
		logger.info("Method :viewaAllDetailsForMitigation start");

		logger.info("Method :viewaAllDetailsForMitigation endss");
		return mitigationDao.viewaAllDetailsForMitigation(orgName, orgDivision, userId);

	}

	// add
	@PostMapping(value = "saveRiskdetailsForMitigation")
	public ResponseEntity<JsonResponse<Object>> saveRiskdetailsForMitigation(@RequestBody RestMitigationModel model) {
		logger.info("Method : saveRiskdetailsForMitigation starts");

		logger.info("Method : saveRiskdetailsForMitigation ends");
		return mitigationDao.saveRiskdetailsForMitigation(model);
	}

	// add
	@PostMapping(value = "saveImpactDetailsForMitigation")
	public ResponseEntity<JsonResponse<Object>> saveImpactDetailsForMitigation(@RequestBody RestMitigationModel model) {
		logger.info("Method : saveImpactDetailsForMitigation starts");

		logger.info("Method : saveImpactDetailsForMitigation ends");
		return mitigationDao.saveImpactDetailsForMitigation(model);
	}

	@RequestMapping(value = "viewRiskDetailsForMitigation", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRiskDetailsForMitigation(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :viewRiskDetailsForMitigation start");

		logger.info("Method :viewRiskDetailsForMitigation endss");
		return mitigationDao.viewRiskDetailsForMitigation(id, orgName, orgDivision);

	}

	@RequestMapping(value = "viewImpactDetailsForMitigation", method = { RequestMethod.GET })
	public JsonResponse<Object> viewImpactDetailsForMitigation(@RequestParam String orgName, String orgDivision, String riskId) {
		logger.info("Method :viewImpactDetailsForMitigation start");

		logger.info("Method :viewImpactDetailsForMitigation endss");
		return mitigationDao.viewImpactDetailsForMitigation(orgName, orgDivision, riskId);

	}

	// edit main data
	@RequestMapping(value = "rest-editMitigationData", method = { RequestMethod.GET })
	public JsonResponse<Object> editMitigationData(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editMitigationData start");

		logger.info("Method :editMitigationData endss");
		return mitigationDao.editMitigationData(id, orgName, orgDivision);
	}

	// edit data
	@RequestMapping(value = "rest-editImpactDataForMitigation", method = { RequestMethod.GET })
	public JsonResponse<Object> editImpactDataForMitigation(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editImpactDataForMitigation start");

		logger.info("Method :editImpactDataForMitigation endss");
		return mitigationDao.editImpactDataForMitigation(id, orgName, orgDivision);
	}

	// getImpactAndRiskDataForMitigation
	@RequestMapping(value = "rest-getImpactAndRiskDataForMitigation", method = { RequestMethod.GET })
	public JsonResponse<Object> getImpactAndRiskDataForMitigation(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :getImpactAndRiskDataForMitigation start");

		logger.info("Method :getImpactAndRiskDataForMitigation endss");
		return mitigationDao.getImpactAndRiskDataForMitigation(id, orgName, orgDivision);
	}

	/*
	 * delete
	 * 
	 */
	@RequestMapping(value = "deleteMitigationsDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteMitigationsDetails(@RequestParam String id) {
		logger.info("Method : deleteMitigationsDetails starts");

		logger.info("Method : deleteMitigationsDetails ends");
		return mitigationDao.deleteMitigationsDetails(id);
	}

	@GetMapping(value = "approveMitigationDetails")
	public JsonResponse<DropDownModel> approveMitigationDetails(@RequestParam String approveStatus,
			String mitigationId, String orgName, String orgDivision) {
		logger.info("Method : approveMitigationDetails starts");

		logger.info("Method : approveMitigationDetails ends");
		return mitigationDao.approveMitigationDetails(approveStatus, mitigationId, orgName, orgDivision);
	}
}
