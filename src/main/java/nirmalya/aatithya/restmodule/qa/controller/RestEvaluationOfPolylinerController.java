package nirmalya.aatithya.restmodule.qa.controller;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.qa.dao.EvaluationOfPolylinerDao;
import nirmalya.aatithya.restmodule.qa.model.RestEvaluationOfLaminatesModel;
import nirmalya.aatithya.restmodule.qa.model.RestEvaluationOfPolylinerModel;

@RestController
@RequestMapping(value = { "qa/" })
public class RestEvaluationOfPolylinerController {

	Logger logger = LoggerFactory.getLogger(RestEvaluationOfPolylinerController.class);

	@Autowired
	EvaluationOfPolylinerDao evaluationOfPolylinerDao;

	// add.

	@PostMapping(value = "rest-addPolyliner")
	public ResponseEntity<JsonResponse<RestEvaluationOfPolylinerModel>> addPolyliner(

			@RequestBody RestEvaluationOfPolylinerModel restEvaluationOfPolylinerModel) {
		logger.info("Method : addPolyliner starts");
		logger.info("Method : addPolyliner ends");
		return evaluationOfPolylinerDao.addPolyliner(restEvaluationOfPolylinerModel);
	}

	// View

	@RequestMapping(value = "rest-getPolylinerView", method = { RequestMethod.GET })
	public JsonResponse<Object> getPolylinerView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getPolylinerView start");

		logger.info("Method :getPolylinerView endss");
		return evaluationOfPolylinerDao.getPolylinerView(orgName, orgDivision);
	}

	// Edit.

	@RequestMapping(value = "rest-editPolyliner", method = { RequestMethod.GET })
	public JsonResponse<Object> editPolyliner(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editPolyliner start");

		logger.info("Method :editPolyliner endss");
		return evaluationOfPolylinerDao.editPolyliner(id, orgName, orgDivision);
	}

	// Delete.

	@RequestMapping(value = "rest-deletePolyliner", method = { RequestMethod.GET })
	public JsonResponse<Object> deletePolyliner(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :deletePolyliner start");

		logger.info("Method :deletePolyliner endss");
		return evaluationOfPolylinerDao.deletePolyliner(id, orgName, orgDivision);
	}

	// Approve.

	@RequestMapping(value = "rest-approvePolyliner", method = { RequestMethod.GET })
	public JsonResponse<Object> approvePolyliner(@RequestParam String id, String orgName, String orgDivision,
			String approvedBy) {
		logger.info("Method :approvePolyliner start");

		logger.info("Method :approvePolyliner endss");
		return evaluationOfPolylinerDao.approvePolyliner(id, orgName, orgDivision, approvedBy);
	}
	
	
	// Pdf
	
	
	@RequestMapping(value = "rest-pdfPolyliner", method = { RequestMethod.GET })
	public JsonResponse<Object> pdfPolyliner(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :pdfPolyliner start");

		logger.info("Method :pdfPolyliner endss");
		return evaluationOfPolylinerDao.pdfPolyliner(id, orgName, orgDivision);
	}
	

	// getAggridData
	@RequestMapping(value = "rest-getAggridPolylinerDatas", method = { RequestMethod.GET })
	public JsonResponse<Object> getAggridPolylinerDatas(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getAggridPolylinerDatas start");

		logger.info("Method :getAggridPolylinerDatas endss");
		return evaluationOfPolylinerDao.getAggridPolylinerDatas(orgName, orgDivision);
	}

}
