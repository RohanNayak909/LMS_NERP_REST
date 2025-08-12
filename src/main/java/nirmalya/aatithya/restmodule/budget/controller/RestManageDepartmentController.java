package nirmalya.aatithya.restmodule.budget.controller;

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

import nirmalya.aatithya.restmodule.budget.dao.RestManageDepartmentDao;
import nirmalya.aatithya.restmodule.budget.model.RestManageDepartmentModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
	

	@RestController
	@RequestMapping(value = "budget/")
	public class RestManageDepartmentController {
		
		Logger logger = LoggerFactory.getLogger(RestManageDepartmentController.class);

		@Autowired
		RestManageDepartmentDao restManageDepartmentDao ;
		
		
		//Add Department
		@RequestMapping(value = "restAddDepartmentInfo", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> restAddDepartmentInfo(@RequestBody RestManageDepartmentModel restManageDepartmentModel) {
			logger.info("Method : restAddDepartmentInfo starts");
			System.out.println("restAddDepartmentInfo=====>>>>>"+restManageDepartmentModel);
			logger.info("Method : restAddDepartmentInfo  ends");
			return restManageDepartmentDao.addDepartmentInfo(restManageDepartmentModel);
		}
		
		// viewDepartment
				@RequestMapping(value = "rest-viewDept", method = { RequestMethod.GET })
				public JsonResponse<Object> viewDepatment(@RequestParam String orgName, String orgDivision) {
					logger.info("Method :viewDepartment start");

					logger.info("Method :viewDepartment endss");
					return restManageDepartmentDao.viewDepatment(orgName, orgDivision);
				}
	

		@GetMapping(value = "manage-department-edit")
		public ResponseEntity<JsonResponse<List<RestManageDepartmentModel>>> restEditShoukeenDepartment(
				@RequestParam String departmentId) {
			logger.info("Method :restEditShoukeenDepartment starts");

			logger.info("Method :restEditShoukeenDepartment ends" + departmentId);
			return restManageDepartmentDao.editDepartmentInfo(departmentId);

		}
		
		@RequestMapping(value = "manage-department-delete", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> restDeleteShoukeenDepartment(@RequestParam String departmentId) {
			logger.info("Method : restDeleteShoukeenDepartment starts---------------------"+departmentId);

			logger.info("Method :  restDeleteShoukeenDepartment ends");
			return restManageDepartmentDao.deleteDepartmentInfo(departmentId);
		}
	} 



