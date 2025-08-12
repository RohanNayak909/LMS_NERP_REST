package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.RestEmployeeWorkLocationDao;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeWorkLocationModel;

@RestController
@RequestMapping(value = "master/")
public class RestEmployeeWorkLocationController {

	Logger logger = LoggerFactory.getLogger(RestEmployeeWorkLocationController.class);

	@Autowired
	RestEmployeeWorkLocationDao restEmployeeWorkLocationDao;

	@GetMapping(value = "get-employee-List")
	public List<DropDownModel> getemployeeList() {
		logger.info("Method : getemployeeList starts");

		logger.info("Method : getemployeeList ends");
		return restEmployeeWorkLocationDao.getemployeeList();
	}
	// get employee list 

	@GetMapping(value = "get-getEmployeeList")
	public JsonResponse<List<DropDownModel>> getEmployeeList(@RequestParam String type,String orgName,String orgDivision) {
		logger.info("Method : getEmployeeList starts");

		logger.info("Method : getEmployeeList ends");
		return restEmployeeWorkLocationDao.getEmployeeList(type,orgName,orgDivision);
	}
	// name list

	@GetMapping(value = "get-nameList")
	public JsonResponse<List<DropDownModel>> getnameList(@RequestParam String id) {
		logger.info("Method : getnameList starts");

		logger.info("Method : getnameList ends");
		return restEmployeeWorkLocationDao.getnameList(id);
	}

	// add

	@RequestMapping(value = "rest-addnew-worklocation", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addworkLocation(
			@RequestBody RestEmployeeWorkLocationModel restPayroll) {
		logger.info("Method : addworkLocation starts");

		logger.info("Method : addworkLocation ends");
		return restEmployeeWorkLocationDao.addworkLocation(restPayroll);
	}

	@RequestMapping(value = "EmployeeWorkLocation", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestEmployeeWorkLocationModel>>> EmployeeWorkLocation(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : EmployeeWorkLocation starts");

		logger.info("Method : EmployeeWorkLocation ends");
		return restEmployeeWorkLocationDao.EmployeeWorkLocation(org,orgDiv);
	}

	/*
	 *
	 * Edit rest
	 *
	 */
	@RequestMapping(value = "rest-EmployeeWorkLocation-edit", method = { RequestMethod.GET })
	public JsonResponse<RestEmployeeWorkLocationModel> editEmployeeWorkLocation(@RequestParam String id) {
		logger.info("Method : editEmployeeWorkLocation rest starts");

		logger.info("Method :editEmployeeWorkLocation rest ends");
		return restEmployeeWorkLocationDao.editEmployeeWorkLocation(id);
	}

	// delete

	@RequestMapping(value = "rest-EmployeeWorkLocation-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteEmployeeWorkLocation(@RequestParam String id) {
		logger.info("Method : deleteEmployeeWorkLocation starts");

		logger.info("Method : deleteEmployeeWorkLocation ends");
		return restEmployeeWorkLocationDao.deleteEmployeeWorkLocation(id);
	}
}
