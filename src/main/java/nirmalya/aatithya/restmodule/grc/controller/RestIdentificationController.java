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
import nirmalya.aatithya.restmodule.grc.dao.IdentificationDao;
import nirmalya.aatithya.restmodule.grc.model.RiskIdentifictionRestModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseIndentModel;

@RestController
@RequestMapping("grc/")
public class RestIdentificationController {
	Logger logger = LoggerFactory.getLogger(RestIdentificationController.class);

	@Autowired

	IdentificationDao identificationDao;

	@RequestMapping(value = "viewIdentification", method = { RequestMethod.GET })
	public JsonResponse<Object> viewIdentification(@RequestParam String orgName, String orgDivision, String userId) {
		logger.info("Method :viewIdentification start");

		logger.info("Method :viewIdentification endss");
		return identificationDao.viewIdentification(orgName, orgDivision, userId);

	}

	// editPlan data
	@RequestMapping(value = "rest-editIdentificationData", method = { RequestMethod.GET })
	public JsonResponse<Object> editIdentificationData(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editIdentificationData start");

		logger.info("Method :editIdentificationData endss");
		return identificationDao.editIdentificationData(id, orgName, orgDivision);
	}

	/*
	 * add
	 */
	@PostMapping(value = "addIdentificationDetails")
	public ResponseEntity<JsonResponse<List<RiskIdentifictionRestModel>>> addIdentificationDetails(
			@RequestBody List<RiskIdentifictionRestModel> riskIdentifictionRestModel) {
		logger.info("Method :addIdentificationDetails starts");

		logger.info("Method :addIdentificationDetails endss");
		return identificationDao.addIdentificationDetails(riskIdentifictionRestModel);
	}

	/*
	 * view
	 */
	@RequestMapping(value = "viewIdentificationProjectDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> viewIdentificationProjectDetails(@RequestParam String orgName, String orgDivision,
			String userId) {
		logger.info("Method :viewIdentificationProjectDetails start");

		logger.info("Method :viewIdentificationProjectDetails endss");
		return identificationDao.viewIdentificationProjectDetails(orgName, orgDivision, userId);

	}

	/*
	 * delete
	 * 
	 */
	@RequestMapping(value = "deleteIdentificationDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteIdentificationDetails(@RequestParam String id) {
		logger.info("Method : deleteIdentificationDetails starts");

		logger.info("Method : deleteIdentificationDetails ends");
		return identificationDao.deleteIdentificationDetails(id);
	}

	@GetMapping(value = "approveIdentificationDetails")
	public JsonResponse<DropDownModel> approveIdentificationDetails(@RequestParam String approveStatus, String identificationId,
			String orgName, String orgDivision) {
		logger.info("Method : approveIdentificationDetails starts");

		logger.info("Method : approveIdentificationDetails ends");
		return identificationDao.approveIdentificationDetails(approveStatus, identificationId, orgName, orgDivision);
	}
}
