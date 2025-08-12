package nirmalya.aatithya.restmodule.master.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.ManageGatePassDao;
import nirmalya.aatithya.restmodule.master.model.ManagePassRestModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master/")
public class ManagePassRestController {

	Logger logger = LoggerFactory.getLogger(ManagePassRestController.class);

	@Autowired
	ManageGatePassDao managePassDao;

	// Auto Search Employee.

	@GetMapping(value = "get-all-employee-autosearch")
	public JsonResponse<Object> employeeAutoSearch(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : EmployeeAutoSearch starts");

		logger.info("Method :EmployeeAutoSearch endss");
		return managePassDao.employeeAutoSearch(id, org, orgDiv);
	}

	// employee response upload by HR
	@PostMapping(value = "rest-add-pass")
	public ResponseEntity<JsonResponse<ManagePassRestModel>> uploadEmployeeResponse(

			@RequestBody ManagePassRestModel data) {
		logger.info("Method : uploadEmployeeResponse starts");

		logger.info("Method : uploadEmployeeResponse ends");
		return managePassDao.restAddPass(data);
	}

	// get All entry pass
	@GetMapping(value = "rest-get-entries")
	public JsonResponse<Object> getAllEntries(@RequestParam String org, String orgDiv, String userId, String module,String type) {
		logger.info("Method : getAllEntries starts");

		logger.info("Method : getAllEntries ends");
		return managePassDao.getAllEntries(org, orgDiv, userId,module,type);
	}

	// Get Entry Pass By ID
	@GetMapping(value = "rest-get-entry-byId")
	public JsonResponse<Object> getEntryByID(@RequestParam String org, String orgDiv, String userId, String id) {
		logger.info("Method : getEntryByID starts");

		logger.info("Method : getEntryByID ends");
		return managePassDao.getEntryByID(org, orgDiv, userId, id);
	}

	// update pass status
	@GetMapping(value = "rest-update-pass")
	public JsonResponse<Object> updatePass(@RequestParam String org, String orgDiv, String userId, String id) {
		logger.info("Method : updatePass starts");

		logger.info("Method : updatePass ends");
		return managePassDao.updatePass(org, orgDiv, userId, id);
	}

	// update pass status
	@GetMapping(value = "rest-allow-pass")
	public JsonResponse<Object> allowPass(@RequestParam String org, String orgDiv, String userId, String id) {
		logger.info("Method : allowPass starts");

		logger.info("Method : allowPass ends");
		return managePassDao.allowPass(org, orgDiv, userId, id);
	}

	// Delete pass status
	@GetMapping(value = "rest-delete-pass")
	public JsonResponse<Object> deletePass(@RequestParam String org, String orgDiv, String userId, String id) {
		logger.info("Method : deletePass starts");

		logger.info("Method : deletePass ends");
		return managePassDao.deletePass(org, orgDiv, userId, id);
	}

}
