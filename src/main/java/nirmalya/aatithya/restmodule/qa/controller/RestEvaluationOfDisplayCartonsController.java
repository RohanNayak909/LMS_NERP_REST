package nirmalya.aatithya.restmodule.qa.controller;

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
import nirmalya.aatithya.restmodule.qa.dao.EvaluationOfDisplayControllerDao;
import nirmalya.aatithya.restmodule.qa.model.RestEvaluationOfDisplayCartonsModel;

import nirmalya.aatithya.restmodule.qa.dao.EvaluationOfPolylinerDao;

@RestController
@RequestMapping(value = { "qa/" })
public class RestEvaluationOfDisplayCartonsController {

	Logger logger = LoggerFactory.getLogger(RestEvaluationOfDisplayCartonsController.class);

	@Autowired
	EvaluationOfDisplayControllerDao evaluationOfDisplayControllerDao;

	// add.

	@PostMapping(value = "rest-addDispCartons")
	public ResponseEntity<JsonResponse<RestEvaluationOfDisplayCartonsModel>> addDispCartons(

			@RequestBody RestEvaluationOfDisplayCartonsModel restEvaluationOfDisplayCartonsModel) {
		logger.info("Method : addDispCartons starts");
		logger.info("Method : addDispCartons ends");
		return evaluationOfDisplayControllerDao.addDispCartons(restEvaluationOfDisplayCartonsModel);
	}

	// View

	@RequestMapping(value = "rest-getDispCartonsView", method = { RequestMethod.GET })
	public JsonResponse<Object> getDispCartonsView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getDispCartonsView start");

		logger.info("Method :getDispCartonsView endss");
		return evaluationOfDisplayControllerDao.getDispCartonsView(orgName, orgDivision);
	}

	// Edit.

	@RequestMapping(value = "rest-editDispCartons", method = { RequestMethod.GET })
	public JsonResponse<Object> editLaminates(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editLaminates start");

		logger.info("Method :editLaminates endss");
		return evaluationOfDisplayControllerDao.editDispCartons(id, orgName, orgDivision);
	}

	// Delete.

	@RequestMapping(value = "rest-deleteDispCartons", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteLaminates(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :deleteLaminates start");

		logger.info("Method :deleteLaminates endss");
		return evaluationOfDisplayControllerDao.deleteDispCartons(id, orgName, orgDivision);
	}

	// Approve.

	@RequestMapping(value = "rest-approveDispCartons", method = { RequestMethod.GET })
	public JsonResponse<Object> approveLaminates(@RequestParam String id, String orgName, String orgDivision,
			String approvedBy) {
		logger.info("Method :approveLaminates start");

		logger.info("Method :approveLaminates endss");
		return evaluationOfDisplayControllerDao.approveDispCartons(id, orgName, orgDivision, approvedBy);
	}
	

	// getAggridData
	@RequestMapping(value = "rest-getAggridDispCartonsDatas", method = { RequestMethod.GET })
	public JsonResponse<Object> getAggridDispCartonsDatas(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getAggridDispCartonsDatas start");

		logger.info("Method :getAggridDispCartonsDatas endss");
		return evaluationOfDisplayControllerDao.getAggridDispCartonsDatas(orgName, orgDivision);
	}
	
	//Pdf
	
	@RequestMapping(value = "rest-viewPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPdf(@RequestParam String id) {
		logger.info("Method :viewPdf start");

		logger.info("Method :viewPdf endss");
		return evaluationOfDisplayControllerDao.viewPdf(id);

	}

}
