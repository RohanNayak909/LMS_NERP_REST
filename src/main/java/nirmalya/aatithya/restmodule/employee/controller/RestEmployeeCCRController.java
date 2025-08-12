package nirmalya.aatithya.restmodule.employee.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.RestEmployeeCCRDao;
import nirmalya.aatithya.restmodule.employee.model.RestEmployeeCCRModel;
import nirmalya.aatithya.restmodule.qa.model.RestVitAModel;

@RestController
@RequestMapping("employee/")
public class RestEmployeeCCRController {
	Logger logger = LoggerFactory.getLogger(RestEmployeeCCRController.class);

	@Autowired
	RestEmployeeCCRDao ccrDao;
	
	@Autowired
	EnvironmentVaribles env;
	@RequestMapping(value = "viewEmpolyee", method = { RequestMethod.GET })
	public JsonResponse<Object> viewEmpolyee(@RequestParam String org, String orgDiv) {
		logger.info("Method :viewEmpolyee start");

		logger.info("Method :viewEmpolyee endss");
		return ccrDao.viewEmpolyee( org, orgDiv);
	}
	@RequestMapping(value = "editEmpolyee", method = { RequestMethod.GET })
	public JsonResponse<Object> editEmpolyee(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :editEmpolyee start");

		logger.info("Method :editEmpolyee endss");
		return ccrDao.editEmpolyee(id, org, orgDiv);
	}
	@GetMapping(value = "getEmployeeListbyId")
	public JsonResponse<List<DropDownModel>> getEmployeeList(@RequestParam String id,String orgName,String orgDivision) {
		logger.info("Method : getEmployeeList starts");

		logger.info("Method : getEmployeeList ends");
		return ccrDao.getEmployeeList(id,orgName,orgDivision);
	}
	@PostMapping(value = "addEmployeeReview")
	public ResponseEntity<JsonResponse<RestEmployeeCCRModel>> addEmployeeReview(
			@RequestBody RestEmployeeCCRModel vitamin) {
		logger.info("Method :addEmployeeReview starts");

		logger.info("Method :addEmployeeReview endss");
		return ccrDao.addEmployeeReview(vitamin);
	}
	@RequestMapping(value = "editEmpolyeeReview", method = { RequestMethod.GET })
	public JsonResponse<Object> editEmpolyeeReview(@RequestParam String id, String empId, String org, String orgDiv) {
		logger.info("Method :editEmpolyeeReview start");

		logger.info("Method :editEmpolyeeReview endss");
		return ccrDao.editEmpolyeeReview(id,empId, org, orgDiv);
	}
	@RequestMapping(value = "deleteEmpolyeeReview", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteEmpolyeeReview(@RequestParam String id, String empId, String org,String orgDiv) {
		logger.info("Method :deleteEmpolyeeReview start");

		logger.info("Method :deleteEmpolyeeReview endss");
		return ccrDao.deleteEmpolyeeReview(id,empId, org, orgDiv);
	}
	@RequestMapping(value = "rejectEmpolyeeReview", method = { RequestMethod.GET })
	public JsonResponse<Object> rejectEmpolyeeReview(@RequestParam String id, String empId, String org,String orgDiv) {
		logger.info("Method :rejectEmpolyeeReview start");

		logger.info("Method :rejectEmpolyeeReview endss");
		return ccrDao.rejectEmpolyeeReview(id,empId, org, orgDiv);
	}
	@RequestMapping(value = "approveEmpolyeeReview", method = { RequestMethod.GET })
	public JsonResponse<Object> approveEmpolyeeReview(@RequestParam String id, String empId, String org,String orgDiv) {
		logger.info("Method :approveEmpolyeeReview start");

		logger.info("Method :approveEmpolyeeReview endss");
		return ccrDao.approveEmpolyeeReview(id,empId, org, orgDiv);
	}
	@GetMapping(value = "getTypeListCCR")
	public JsonResponse<List<DropDownModel>> getTypeList(@RequestParam String orgName,String orgDivision) {
		logger.info("Method : getTypeList starts");

		logger.info("Method : getTypeList ends");
		return ccrDao.getTypeList(orgName,orgDivision);
	}
}
