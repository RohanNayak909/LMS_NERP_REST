package nirmalya.aatithya.restmodule.qa.controller;

import java.util.List;

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
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.qa.dao.RestQaPcroChecklistDao;
import nirmalya.aatithya.restmodule.qa.model.QaPcroRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestPcroCheckListModel;

@RestController
@RequestMapping(value = { "production/" })
public class RestQaPcroCheckListController {

	Logger logger = LoggerFactory.getLogger(RestQaPcroCheckListController.class);

	@Autowired
	RestQaPcroChecklistDao restQaPcroChecklistDao;

	// for sl no
	@RequestMapping(value = "rest-pcro-checklist-slno", method = { RequestMethod.GET })
	public JsonResponse<Object> getPcroSlNo(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getShiftSlno start");

		logger.info("Method :getShiftSlno endss");
		return restQaPcroChecklistDao.getPcroSlNo(orgName, orgDivision);
	}

	// add

	@PostMapping(value = "rest-pcro-check-list-addPcroCheckList")
	public ResponseEntity<JsonResponse<List<RestPcroCheckListModel>>> addPcroCheckList(

			@RequestBody List<RestPcroCheckListModel> qaPcroRestModel) {
		logger.info("Method : addPcroCheckList starts");
		logger.info("Method : addPcroCheckList ends");
		return restQaPcroChecklistDao.addPcroCheckList(qaPcroRestModel);
	}

	// getTotalCrqsView
	@RequestMapping(value = "rest-pcro-check-list-view", method = { RequestMethod.GET })
	public JsonResponse<Object> getTotalPcroCheckListView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getTotalPcroCheckListView start");

		logger.info("Method :getTotalPcroCheckListView endss");
		return restQaPcroChecklistDao.getTotalPcroCheckListView(orgName, orgDivision);
	}

	// editPCROView
	@RequestMapping(value = "rest-pcro-check-list-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editCodePcroCheckList(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editPCRO start");

		logger.info("Method :editPCRO endss");
		return restQaPcroChecklistDao.editCodePcroCheckList(id, orgName, orgDivision);
	}
	
	
	// deletePcro
			@RequestMapping(value = "rest-pcro-check-list-delete", method = { RequestMethod.GET })
			public ResponseEntity<JsonResponse<Object>> deletePcroCheckList(@RequestParam String id, String org, String div) {
				logger.info("Method : deletePcroCheckList starts");

				logger.info("Method : deletePcroCheckList ends");
				return restQaPcroChecklistDao.deletePcroCheckList(id, org, div);

			}
}
