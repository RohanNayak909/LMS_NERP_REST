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
import nirmalya.aatithya.restmodule.qa.dao.EvaluationOfLaminatesDao;
import nirmalya.aatithya.restmodule.qa.model.RestEvaluationOfLaminatesModel;


@RestController
@RequestMapping(value = { "qa/" })
public class RestEvaluationOfLaminatesController {
	Logger logger = LoggerFactory.getLogger(RestEvaluationOfLaminatesController.class);

	@Autowired
	EvaluationOfLaminatesDao evaluationOfLaminatesDao;
	
	@GetMapping(value = "qa-of-get-Item-lists")
	public List<DropDownModel> getitemLists(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : getitemLists starts");

		logger.info("Method : getitemLists ends");
		return evaluationOfLaminatesDao.getitemLists(org, orgDiv);
	}
	
	
	// Get Item List Only For Laminates.
	
	@GetMapping(value = "qa-of-get-Item-lists-laminate")
	public List<DropDownModel> getitemListsForLami(@RequestParam String org, @RequestParam String orgDiv) {

		logger.info("Method : getitemListsForLami starts");

		logger.info("Method : getitemListsForLami ends");
		return evaluationOfLaminatesDao.getitemListsForLami(org, orgDiv);
	}
	
	// add.
	
	@PostMapping(value = "rest-evaluation-of-laminates-add")
	public ResponseEntity<JsonResponse<RestEvaluationOfLaminatesModel>> addLaminates(

			@RequestBody RestEvaluationOfLaminatesModel restEvaluationOfLaminatesModel) {
		logger.info("Method : addLaminates starts");
		logger.info("Method : addLaminates ends");
		return evaluationOfLaminatesDao.addLaminates(restEvaluationOfLaminatesModel);
	}
	
	// View
	@RequestMapping(value = "rest-evaluation-of-laminates-view", method = { RequestMethod.GET })
	public JsonResponse<Object> getLaminateView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getLaminateView start");

		logger.info("Method :getLaminateView endss");
		return evaluationOfLaminatesDao.getLaminateView(orgName, orgDivision);
	}
	
	//Edit.
	
	@RequestMapping(value = "rest-evaluation-of-laminates-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editLaminates(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editLaminates start");

		logger.info("Method :editLaminates endss");
		return evaluationOfLaminatesDao.editLaminates(id, orgName, orgDivision);
	}
	
	// Delete.
	
	@RequestMapping(value = "rest-deleteLaminates", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteLaminates(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :deleteLaminates start");

		logger.info("Method :deleteLaminates endss");
		return evaluationOfLaminatesDao.deleteLaminates(id, orgName, orgDivision);
	}
	
	// Approve.
	
	@RequestMapping(value = "rest-approveLaminates", method = { RequestMethod.GET })
	public JsonResponse<Object> approveLaminates(@RequestParam String id, String orgName, String orgDivision, String approvedBy) {
		logger.info("Method :approveLaminates start");

		logger.info("Method :approveLaminates endss");
		return evaluationOfLaminatesDao.approveLaminates(id, orgName, orgDivision, approvedBy);
	}
	// pdf 
	@RequestMapping(value = "rest-getLaminatePdf", method = { RequestMethod.GET })
	public JsonResponse<Object> getLaminatePdf(@RequestParam String id, String orgName,
			String orgDivision) {
		logger.info("Method :getLaminatePdf start");

		logger.info("Method :getLaminatePdf endss");
		return evaluationOfLaminatesDao.getLaminatePdf(id, orgName, orgDivision);
	}
	

	// getAggridData
	@RequestMapping(value = "rest-getAggridDatas", method = { RequestMethod.GET })
	public JsonResponse<Object> getAggridDatas(@RequestParam String orgName, String orgDivision, String sku) {
		logger.info("Method :getAggridDatas start");

		logger.info("Method :getAggridDatas endss");
		return evaluationOfLaminatesDao.getAggridDatas(orgName, orgDivision,sku);
	}
}
