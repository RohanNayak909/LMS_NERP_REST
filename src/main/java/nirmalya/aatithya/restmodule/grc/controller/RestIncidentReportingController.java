package nirmalya.aatithya.restmodule.grc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.dao.RestIncidentReportingDao;
import nirmalya.aatithya.restmodule.grc.model.RestIncidentReportingModel;

@RestController
@RequestMapping(value = "grc/")
public class RestIncidentReportingController {
	
	Logger logger = LoggerFactory.getLogger(RestIncidentReportingController.class);

	@Autowired
	RestIncidentReportingDao restIncidentReportingDao;
	
	/* add */
	
	@RequestMapping(value = "incident-reporting-rest-add", method = {RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addMaster(@RequestBody RestIncidentReportingModel restData){
		logger.info("Method : addMaster starts"/* +restData */); 
			
		logger.info("Method : addMaster ends");
		return restIncidentReportingDao.addReportingMasterDao(restData);
	}
	
	/* get type list */
	
	@RequestMapping(value = "rest-getType", method = { RequestMethod.GET })
	public List<DropDownModel> getTypeList() {
		logger.info("Method : getTypeList starts");

		logger.info("Method : getTypeList ends");
		return restIncidentReportingDao.getType();

	} 
	
	/* view */

	@GetMapping(value = "incident-reporting-rest-view")
	public JsonResponse<List<RestIncidentReportingModel>> viewReportingMaster(@RequestParam String uId, 
			String orgName,String orgDivision) {
		logger.info("Method : viewReportingMaster starts");

		logger.info("Method : viewReportingMaster ends");
		return restIncidentReportingDao.viewReportingDao(uId,orgName,orgDivision);
	}

	/* edit */

	@RequestMapping(value = "incident-reporting-rest-edit", method = { RequestMethod.GET })
	public JsonResponse<RestIncidentReportingModel> editReportingMaster(@RequestParam String id, String uId, String orgName,
			String orgDivision) {
			
		logger.info("Method : editReporting rest starts");

		logger.info("Method :editReporting rest ends");
		return restIncidentReportingDao.editReportingDao(id, uId, orgName, orgDivision);
	}

	/* delete */

	@RequestMapping(value = "incident-reporting-rest-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteReporting(@RequestParam String id, String uId, String orgName,
			String orgDivision) {
		logger.info("Method : deleteReporting starts");

		logger.info("Method : deleteReporting ends");
		return restIncidentReportingDao.deleteReportingDao(id, uId, orgName, orgDivision);
	}
}
