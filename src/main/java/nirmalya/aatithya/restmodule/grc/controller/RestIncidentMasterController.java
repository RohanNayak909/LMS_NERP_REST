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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.dao.RestIncidentMasterDao;
import nirmalya.aatithya.restmodule.grc.model.RestIncidentMasterModel;

@RestController
@RequestMapping(value = "grc/")
public class RestIncidentMasterController {
	
	Logger logger = LoggerFactory.getLogger(RestIncidentMasterController.class);

	@Autowired
	RestIncidentMasterDao restIncidentMasterDao;
	
	/* add */
	
	@RequestMapping(value = "incident-master-rest-add", method = {RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addMaster(@RequestBody RestIncidentMasterModel restData){
		logger.info("Method : addMaster starts"/* +restData */); 
			
		logger.info("Method : addMaster ends");
		return restIncidentMasterDao.addMasterDao(restData);
	}
	
	/* view */
	
	@GetMapping(value = "incident-master-rest-view")
	public JsonResponse<List<RestIncidentMasterModel>> viewMaster() {
		logger.info("Method : viewMaster starts");
		
		logger.info("Method : viewMaster ends");
		return restIncidentMasterDao.viewMasterDao();
	}

	
    /* edit */
	
	@RequestMapping(value = "incident-master-rest-edit", method = { RequestMethod.GET })
	public JsonResponse<RestIncidentMasterModel> editMaster(@RequestParam String id,
			String orgName, String orgDivision, String uId) {
		logger.info("Method : editMaster rest starts");

		logger.info("Method :editMaster rest ends");
		return restIncidentMasterDao.editMasterDao(id,orgName, orgDivision, uId);
	}
	
    /* delete */
	
	@RequestMapping(value = "incident-master-rest-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteMaster(@RequestParam String id) {
		logger.info("Method : deleteMaster starts");

		logger.info("Method : deleteMaster ends");
		return restIncidentMasterDao.deleteMasterDao(id);
	}
	
}
