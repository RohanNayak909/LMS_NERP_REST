package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.RestAdvanceManagementDaoNew;
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModelNew;

@RestController
@RequestMapping(value = "master/")
public class RestAdvanceManagementControllerNew {
	Logger logger = LoggerFactory.getLogger(RestAdvanceManagementControllerNew.class);

	@Autowired
	RestAdvanceManagementDaoNew restAdvanceManagementDao;

	@GetMapping(value = "get-requisition-list")
	public List<DropDownModel> getRequisitionList() {
		logger.info("Method : getRequisitionList starts");

		logger.info("Method : getRequisitionList ends");
		return restAdvanceManagementDao.getRequisitionList();
	}

	@PostMapping(value = "rest-addAdvManagement")
	public ResponseEntity<JsonResponse<Object>> addAdvManagement(@RequestBody RestAdvanceManagementModelNew employee) {
		logger.info("Method : addAdvManagement starts");

		logger.info("Method : addAdvManagement ends");
		return restAdvanceManagementDao.addAdvManagement(employee);
	}

	// Post mapping foe view Adv Management

	@GetMapping(value = "rest-advManagement-view")
	public JsonResponse<List<RestAdvanceManagementModelNew>> viewAdvManagement(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : viewAdvManagement");

		logger.info("Method : viewAdvManagement ends");
		return restAdvanceManagementDao.viewAdvManagement(org, orgDiv);
	}

	@RequestMapping(value = "rest-advManagement-edit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestAdvanceManagementModelNew>>> editPolicy(@RequestParam String id) {
		logger.info("Method : edit starts");
		logger.info("IDDDDDD" + id);
		logger.info("Method : edit ends");
		return restAdvanceManagementDao.editPolicy(id);

	}

	@RequestMapping(value = "rest-advManagement-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePolicy(@RequestParam String id) {
		logger.info("Method : deletePolicy starts");

		logger.info("Method : deletePolicy ends");
		return restAdvanceManagementDao.deletePolicy(id);
	}

}
