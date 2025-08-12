package nirmalya.aatithya.restmodule.productionplan.controller;

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
import nirmalya.aatithya.restmodule.productionplan.dao.ManufactureProcessDao;
import nirmalya.aatithya.restmodule.productionplan.model.RestManufactureProcessModel;


@RestController
@RequestMapping(value = "production/")
public class RestManufactureProcessController {
	
	Logger logger = LoggerFactory.getLogger(RestManufactureProcessController.class);

	@Autowired
	ManufactureProcessDao manufactureProcessDao;
	
	
	@RequestMapping(value = "rest-procrssingPlan", method = { RequestMethod.GET })
	public JsonResponse<Object> procrssingPlan(@RequestParam String orgName, @RequestParam String orgDivision, String shift,String date) {
		logger.info("Method :procrssingPlan start");

		logger.info("Method :procrssingPlan endss");
		return manufactureProcessDao.procrssingPlan(orgName, orgDivision,shift,date);

	}
	
	@PostMapping(value = "rest-addProcessingPlan")
	public ResponseEntity<JsonResponse<List<RestManufactureProcessModel>>> addProcessingPlan(@RequestBody List<RestManufactureProcessModel> addProcessingPlan) {
		logger.info("Method : addPlan starts");
		logger.info("Method : addPlan ends");
		return manufactureProcessDao.addProcessingPlan(addProcessingPlan);
	}
	
	@RequestMapping(value = "rest-viewMfgProcessingData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewMfgProcessingData(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewMfgProcessingData start");

		logger.info("Method :viewMfgProcessingData endss");
		return manufactureProcessDao.viewMfgProcessingData(orgName, orgDivision);

	}
	
	@GetMapping(value = "rest-processingDataApprove")
	public ResponseEntity<JsonResponse<Object>> processingDataApprove(@RequestParam String id, String userId ,String orgName, String orgDivision) {
		logger.info("Method : processingDataApprove starts");
		logger.info("Method : processingDataApprove ends");
		return manufactureProcessDao.processingDataApprove(id, userId ,orgName, orgDivision);
	}
	
	@GetMapping(value = "rest-processingDataDelete")
	public ResponseEntity<JsonResponse<Object>> processingDataDelete(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method : processingDataDelete starts");
		logger.info("Method : processingDataDelete ends");
		return manufactureProcessDao.processingDataDelete(id ,orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-procrssingPlanEdit", method = { RequestMethod.GET })
	public JsonResponse<Object> procrssingPlanEdit(@RequestParam String id , String orgName, @RequestParam String orgDivision) {
		logger.info("Method :procrssingPlanEdit start");

		logger.info("Method :procrssingPlanEdit endss");
		return manufactureProcessDao.procrssingPlanEdit(id,orgName, orgDivision);

	}
	
	@RequestMapping(value = "getShiftListForProduction", method = { RequestMethod.GET })
	public List<DropDownModel> getShiftListForProduction(@RequestParam String org, String orgDiv,
			String userId) {
		logger.info("Method : getShiftListForProduction starts");

		logger.info("Method : getShiftListForProduction ends");
		return manufactureProcessDao.getShiftListForProduction(org, orgDiv, userId);
	}
	
	
	// Shift list api.

		@RequestMapping(value = "getShiftListForProduction-api", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getShiftListForProductionApi(@RequestParam String orgName,
				String orgDivision, String userId) {
			logger.info("Method : getShiftListForProductionApi starts");
			logger.info("Method : getShiftListForProductionApi endss");
			return manufactureProcessDao.getShiftListForProductionApi(orgName, orgDivision, userId);
		}


}
