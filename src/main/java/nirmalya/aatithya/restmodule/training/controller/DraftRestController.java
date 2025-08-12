package nirmalya.aatithya.restmodule.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.training.dao.DraftDao;

@RestController
@RequestMapping(value = { "training/" })
public class DraftRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	DraftDao draftDao;

	
	
	// viewAssetPolicy
	@RequestMapping(value = "rest-draft-training-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAssetPolicy(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewAssetPolicy start");

		logger.info("Method :viewAssetPolicy endss");
		return draftDao.viewDraft(orgName, orgDivision);
	}
	
	// deleteQc
	@RequestMapping(value = "rest-draft-training-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAssign(@RequestParam String id,String categoryName, String org, String div) {
		logger.info("Method : deleteAssign starts");

		logger.info("Method : deleteAssign ends");
		return draftDao.deleteDraft(id,categoryName, org, div);

	}
	
	// deleteQc
	@RequestMapping(value = "rest-draft-training-deleteSc", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSchedule(@RequestParam String id, String org, String div) {
		logger.info("Method : deleteSchedule starts");

		logger.info("Method : deleteSchedule ends");
		return draftDao.deleteDraftSc(id, org, div);

	}


}
