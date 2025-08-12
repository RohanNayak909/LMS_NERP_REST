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
import nirmalya.aatithya.restmodule.qa.dao.QcMasterDao;
import nirmalya.aatithya.restmodule.qa.dao.RestIncidentRegisterDao;
import nirmalya.aatithya.restmodule.qa.model.QcMasterRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestIncidentRegisterModel;
import nirmalya.aatithya.restmodule.store.model.MaterialIssueDetailsRestModel;



@RestController
@RequestMapping(value = "qa/")
public class RestIncidentRegisterController {
	
	Logger logger = LoggerFactory.getLogger(RestIncidentRegisterController.class);

	@Autowired
	RestIncidentRegisterDao restIncidentRegisterDao;
	
	
	@RequestMapping(value = "rest-d-incidentregister-add", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestIncidentRegisterModel>>> addIncident(
			@RequestBody List<RestIncidentRegisterModel> restIncidentRegisterModel) {
		logger.info("Method : addIncident starts");
		logger.info("Method : addIncident ends");
		return restIncidentRegisterDao.addIncident(restIncidentRegisterModel);
	}
	
	
	@RequestMapping(value = "rest-d-incidentregister-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewIncident(@RequestParam String org, String orgDiv) {
		logger.info("Method: viewIncident Start");

		logger.info("Method: viewIncident ends");
		return restIncidentRegisterDao.viewIncident(org, orgDiv);
	}
	
	
	@RequestMapping(value = "rest-d-incidentregister-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editIncident(@RequestParam String incidentId, String orgName, String orgDivision) {
		logger.info("Method :editIncident start");

		logger.info("Method :editIncident endss");
		return restIncidentRegisterDao.editIncident(incidentId, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-deleteIncident", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteIncident(@RequestParam String id, String org, String orgDivision) {
		logger.info("Method : deleteIncident starts");

		logger.info("Method : deleteIncident ends");
		return restIncidentRegisterDao.deleteIncident(id, org, orgDivision);

	}

	
	@RequestMapping(value = "rest-approveIncident", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveIncident(@RequestParam String id, String org, String orgDiv,String userId) {
		logger.info("Method : approveIncident starts");
		
		logger.info("Method : approveIncident endsssssssssssss"+userId);
		return restIncidentRegisterDao.approveIncident(id, org, orgDiv, userId);

	}
	
	//rest-incedientRegisterPdf
	@RequestMapping(value = "rest-incedientRegisterPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> incedientRegisterPdf(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :incedientRegisterPdf start");

		logger.info("Method :incedientRegisterPdf endss");
		return restIncidentRegisterDao.incedientRegisterPdf(id, orgName, orgDivision);
	}

}
 
