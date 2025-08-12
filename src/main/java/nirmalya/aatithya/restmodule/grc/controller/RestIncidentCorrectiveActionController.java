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
import nirmalya.aatithya.restmodule.grc.dao.RestIncidentCorrectiveActionDao;
import nirmalya.aatithya.restmodule.grc.model.RestIncidentCorrectiveActionModel;

@RestController
@RequestMapping(value = "grc/")
public class RestIncidentCorrectiveActionController {

	Logger logger = LoggerFactory.getLogger(RestIncidentCorrectiveActionController.class);

	@Autowired
	RestIncidentCorrectiveActionDao restIncidentCorrectiveActionDao;
	
	
	/* view */

	@GetMapping(value = "rest-view-corrective-action")
	public JsonResponse<List<RestIncidentCorrectiveActionModel>> viewCorrectiveAction(@RequestParam String uId, 
			String orgName,String orgDivision) {
		logger.info("Method : viewCasualAnalysis starts");

		logger.info("Method : viewCasualAnalysis ends");
		return restIncidentCorrectiveActionDao.viewCorrectiveActionDao(uId,orgName,orgDivision);
	}
	
	/* edit */

	@RequestMapping(value = "rest-edit-corrective-action", method = { RequestMethod.GET })
	public JsonResponse<RestIncidentCorrectiveActionModel> editCorrectiveAction(@RequestParam String id, String uId, String orgName,
			String orgDivision) {
			
		logger.info("Method : editCasualAnalysis rest starts");

		logger.info("Method :editCasualAnalysis rest ends");
		return restIncidentCorrectiveActionDao.editCorrectiveActionDao(id, uId, orgName, orgDivision);
	}
	
	/* add */

	@RequestMapping(value = "rest-add-corrective-action", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addCorrectiveAction(@RequestBody RestIncidentCorrectiveActionModel restData) {
		logger.info("Method : addManage starts"/* +restData */);

		logger.info("Method : addManag ends");
		return restIncidentCorrectiveActionDao.addCorrectiveActionDao(restData);
	}
}
