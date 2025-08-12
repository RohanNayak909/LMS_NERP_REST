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
import nirmalya.aatithya.restmodule.qa.dao.EvaluationOfOuterCartonsDao;
import nirmalya.aatithya.restmodule.qa.model.ReatEvaluationOfOuterCartonsModel;

@RestController
@RequestMapping(value = { "qa/" })
public class RestEvaluationOfOuterCartonsController {

	Logger logger = LoggerFactory.getLogger(RestEvaluationOfOuterCartonsController.class);

	@Autowired
	EvaluationOfOuterCartonsDao evaluationOfOuterCartonsDao;
	
	
	// Get Item List Only For Cartons.
	
	@GetMapping(value = "qa-of-get-Item-lists-cartons")
	public List<DropDownModel> getitemListsForCartons(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : getitemListsForCartons starts");

		logger.info("Method : getitemListsForCartons ends");
		return evaluationOfOuterCartonsDao.getitemListsForCartons(org, orgDiv);
	}

	// add

	@PostMapping(value = "rest-addOuterCartons")
	public ResponseEntity<JsonResponse<ReatEvaluationOfOuterCartonsModel>> addLaminates(

			@RequestBody ReatEvaluationOfOuterCartonsModel reatEvaluationOfOuterCartonsModel) {
		logger.info("Method : addOuterCartons starts");
		logger.info("Method : addOuterCartons ends");
		return evaluationOfOuterCartonsDao.addOuterCartons(reatEvaluationOfOuterCartonsModel);
	}

	// view

	@RequestMapping(value = "rest-getOuterCartonsView", method = { RequestMethod.GET })
	public JsonResponse<Object> getOuterCartonsView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getOuterCartonsView start");

		logger.info("Method :getOuterCartonsView endss");
		return evaluationOfOuterCartonsDao.getOuterCartonsView(orgName, orgDivision);
	}

	// Edit

	@RequestMapping(value = "rest-editOuterCartons", method = { RequestMethod.GET })
	public JsonResponse<Object> editOuterCartons(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editOuterCartons start");

		logger.info("Method :editOuterCartons endss");
		return evaluationOfOuterCartonsDao.editOuterCartons(id, orgName, orgDivision);
	}

	// Delete.

	@RequestMapping(value = "rest-deleteOuterCartons", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteOuterCartons(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :deleteOuterCartons start");

		logger.info("Method :deleteOuterCartons endss");
		return evaluationOfOuterCartonsDao.deleteOuterCartons(id, orgName, orgDivision);
	}

	// Approve.

	@RequestMapping(value = "rest-approveOuterCartons", method = { RequestMethod.GET })
	public JsonResponse<Object> approveOuterCartons(@RequestParam String id, String orgName, String orgDivision,
			String approvedBy) {
		logger.info("Method :approveOuterCartons start");

		logger.info("Method :approveOuterCartons endss");
		return evaluationOfOuterCartonsDao.approveOuterCartons(id, orgName, orgDivision, approvedBy);
	}
	

	// getAggridData
	@RequestMapping(value = "rest-getAggridOuterCartonsDatas", method = { RequestMethod.GET })
	public JsonResponse<Object> getAggridOuterCartonsDatas(@RequestParam String orgName, String orgDivision, String sku) {
		logger.info("Method :getAggridOuterCartonsDatas start");

		logger.info("Method :getAggridOuterCartonsDatas endss");
		return evaluationOfOuterCartonsDao.getAggridOuterCartonsDatas(orgName, orgDivision, sku);
	}
//
	@RequestMapping(value = "rest-outerCartonPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> outerCartonPdf(@RequestParam String id) {
		logger.info("Method :outerCartonPdf start");

		logger.info("Method :outerCartonPdf endss");
		return evaluationOfOuterCartonsDao.outerCartonPdf(id);

	}

}
