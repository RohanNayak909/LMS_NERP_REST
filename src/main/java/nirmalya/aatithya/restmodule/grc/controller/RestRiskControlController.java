package nirmalya.aatithya.restmodule.grc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.dao.AnalysisDao;
import nirmalya.aatithya.restmodule.grc.dao.RiskControlDao;
import nirmalya.aatithya.restmodule.grc.model.RestRiskControlModel;

@RestController
@RequestMapping("grc/")
public class RestRiskControlController {
	Logger logger = LoggerFactory.getLogger(RestRiskControlController.class);

	@Autowired

	RiskControlDao riskControlDao;

	@RequestMapping(value = "viewRiskdetailsForControl", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRiskdetailsForControl(@RequestParam String orgName, String orgDivision,
			String userId) {
		logger.info("Method :viewRiskdetailsForControl start");

		logger.info("Method :viewRiskdetailsForControl endss");
		return riskControlDao.viewRiskdetailsForControl(orgName, orgDivision, userId);

	}

	// add

	@PostMapping(value = "saveControlDetails")
	public ResponseEntity<JsonResponse<Object>> saveControlDetails(@RequestBody RestRiskControlModel model) {
		logger.info("Method : saveControlDetails starts");

		logger.info("Method : saveControlDetails ends");
		return riskControlDao.saveControlDetails(model);
	}

	// edit data
	@RequestMapping(value = "rest-editControlData", method = { RequestMethod.GET })
	public JsonResponse<Object> editControlData(@RequestParam String id,String impactMitigationId,String riskIdentificationId, String orgName, String orgDivision) {
		logger.info("Method :editControlData start");

		logger.info("Method :editControlData endss");
		return riskControlDao.editControlData(id,impactMitigationId,riskIdentificationId,orgName, orgDivision);
	}

	@RequestMapping(value = "RequisitionList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> RequisitionList(@RequestParam String id,@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method : RequisitionList starts");

		logger.info("Method : RequisitionList ends");
		return riskControlDao.RequisitionList(id,orgName, orgDivision);
	}
}
