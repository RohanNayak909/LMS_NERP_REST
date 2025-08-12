package nirmalya.aatithya.restmodule.training.controller;

import java.util.List;

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
import nirmalya.aatithya.restmodule.training.dao.ViewStudyMaterialsDao;
import nirmalya.aatithya.restmodule.training.model.ViewStudyMaterialsRestModel;

@RestController
@RequestMapping(value = "training/")
public class ViewStudyMaterialsRestController {

	Logger logger = LoggerFactory.getLogger(ViewStudyMaterialsRestController.class);

	@Autowired
	ViewStudyMaterialsDao viewStudyDao;

	/*
	 * get all employee list
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "view-employee-list")
	public JsonResponse getEmployeeList(
			@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : getEmployeeList starts");

		logger.info("Method : getEmployeeList ends");
		return viewStudyDao.getEmployeeListDao(organization, orgDivision);
	}

	/*
	 * get Training By Category id
	 * 
	 */
	@GetMapping(value = "getStudyMaterialByCategory")
	public ResponseEntity<JsonResponse<List<ViewStudyMaterialsRestModel>>> getMaterialsByCat(
			@RequestParam String organization, @RequestParam String orgDivision, @RequestParam String id) {
		logger.info("Method in rest: getMaterialsByCat starts");

		logger.info("Method in rest: getMaterialsByCat ends");
		return viewStudyDao.getStudyMaterialByCat(id, organization, orgDivision);
	}

	/*
	 * get employee list by their joining date
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "view-employee-list-bydt")
	public JsonResponse getEmployeeDetailsList(
			@RequestParam String date1, @RequestParam String date2, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method in rest: getEmployeeDetailsList starts");

		logger.info("Method in rest: getEmployeeDetailsList ends");
		return viewStudyDao.getEmployeeDetailsList(date1, date2, organization, orgDivision);
	}
	/*
	 * get employee list by their joining date
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "get-assigned-emp-list")
	public JsonResponse getAssignedEmployeeDetails(String organization,@RequestParam String orgDivision) {
		logger.info("Method in rest: getAssignedEmployeeDetails starts");

		logger.info("Method in rest: getAssignedEmployeeDetails ends");
		return viewStudyDao.getAssignedEmployeeDetails(organization, orgDivision);
	}
	

	/*
	 * This method is used to assign training material
	 * 
	 */
	@PostMapping(value = "rest-save-emp-training")
	public ResponseEntity<JsonResponse<ViewStudyMaterialsRestModel>> assignStudyMaterialToEmp(
			@RequestBody List<ViewStudyMaterialsRestModel> allData) {
		logger.info("Method : assignStudyMaterialToEmp starts");

		logger.info("Method : assignStudyMaterialToEmp ends");
		return viewStudyDao.assignStudyMaterialToEmpDao(allData);
	}
	

	/*
	 * This method is used to schedule training material
	 * 
	 */
	@PostMapping(value = "rest-schedule-emp-training")
	public ResponseEntity<JsonResponse<ViewStudyMaterialsRestModel>> scheduleStudyMaterialToEmp(
			@RequestBody List<ViewStudyMaterialsRestModel> allData) {
		logger.info("Method : scheduleStudyMaterialToEmp starts");

		logger.info("Method : scheduleStudyMaterialToEmp ends");
		return viewStudyDao.scheduleStudyMaterialToEmpDao(allData);
	}
}
