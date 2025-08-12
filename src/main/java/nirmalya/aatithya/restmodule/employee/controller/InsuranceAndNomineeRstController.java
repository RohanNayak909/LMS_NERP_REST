package nirmalya.aatithya.restmodule.employee.controller;

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
import nirmalya.aatithya.restmodule.employee.dao.InsuranceAndNomineeDao;
import nirmalya.aatithya.restmodule.employee.model.InsuranceAndNomineeRestModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;

@RestController
@RequestMapping(value = "employee/")
public class InsuranceAndNomineeRstController {
	
Logger logger = LoggerFactory.getLogger(InsuranceAndNomineeRstController.class);
	
	@Autowired
	InsuranceAndNomineeDao insuranceAndNomineeDao;
	
	
	
	@PostMapping(value = "viewInsuranceAndNominee")
	public ResponseEntity<JsonResponse<List<InsuranceAndNomineeRestModel>>> viewInsuranceAndNominee(@RequestBody EmpRoleModel empModel) {
		logger.info("Method : viewInsuranceAndNominee starts");

		String userId = empModel.getUserId();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		
		logger.info("User Id = "+userId);
		logger.info("Method : viewEventManagement ends");
		return insuranceAndNomineeDao.viewInsuranceAndNominee(userId,organization,orgDivision);
	}
	
	@GetMapping(value = "viewEmpDetails")
	public JsonResponse<List<InsuranceAndNomineeRestModel>> viewEmpDetails(@RequestParam String userid) {
		logger.info("Method : viewEmpDetails starts");

		logger.info("Method : viewEmpDetails ends");
		return insuranceAndNomineeDao.viewEmpDetails(userid);
	}

	@RequestMapping(value = "saveEmployeeDtls", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<InsuranceAndNomineeRestModel>> saveEmployeeDtls(
			@RequestBody InsuranceAndNomineeRestModel employeee) {
		logger.info("Method : saveEmployeeDtls starts");

		logger.info("Method : saveEmployeeDtls ends");
		return insuranceAndNomineeDao.saveEmployeeDtls(employeee);
	}
	
	@PostMapping(value = "viewInsuranceDeclaration")
	public ResponseEntity<JsonResponse<List<InsuranceAndNomineeRestModel>>> viewInsuranceDeclaration(@RequestBody EmpRoleModel empModel) {
		logger.info("Method : viewInsuranceAndNominee starts");

		String userId = empModel.getUserId();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		
		logger.info("User Id = "+userId);
		logger.info("Method : viewInsuranceDeclaration ends");
		return insuranceAndNomineeDao.viewInsuranceDeclaration(userId,organization,orgDivision);
	}
	
	@RequestMapping(value = "nameList", method = { RequestMethod.GET })
	public List<DropDownModel> nameList(@RequestParam String userId) {
		logger.info("Method : nameList starts");

		logger.info("Method : nameList ends");
		return insuranceAndNomineeDao.nameList(userId);
	}
	
	@GetMapping(value = "get-viewDobRelation")
	public JsonResponse<List<DropDownModel>> viewDobRelation(@RequestParam String id) {
		logger.info("Method : viewDobRelation starts");

		logger.info("Method : viewDobRelation ends");
		return insuranceAndNomineeDao.viewDobRelation(id);
	}

	@RequestMapping(value = "saveNomineeDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<InsuranceAndNomineeRestModel>> saveNomineeDetails(
			@RequestBody InsuranceAndNomineeRestModel employeee) {
		logger.info("Method : saveNomineeDetails starts");

		logger.info("Method : saveNomineeDetails ends");
		return insuranceAndNomineeDao.saveNomineeDetails(employeee);
	}
	
	@PostMapping(value = "viewInsuranceNomineeDetails")
	public ResponseEntity<JsonResponse<List<InsuranceAndNomineeRestModel>>> viewInsuranceNomineeDetails(@RequestBody EmpRoleModel empModel) {
		logger.info("Method : viewInsuranceNomineeDetails starts");

		String userId = empModel.getUserId();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		
		logger.info("User Id = "+userId);
		logger.info("Method : viewInsuranceNomineeDetails ends");
		return insuranceAndNomineeDao.viewInsuranceNomineeDetails(userId,organization,orgDivision);
	}
	
	@RequestMapping(value = "deleteDeclaration", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDeclaration(@RequestParam String id) {
		logger.info("Method : deleteDeclaration starts");

		logger.info("Method : deleteDeclaration ends");
		return insuranceAndNomineeDao.deleteDeclaration(id);
	}
	
	@RequestMapping(value = "deleteNominee", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteNominee(@RequestParam String id) {
		logger.info("Method : deleteNominee starts");

		logger.info("Method : deleteEventManagement ends");
		return insuranceAndNomineeDao.deleteNominee(id);
	}
	
	@RequestMapping(value = "rest-editDeclaration", method = { RequestMethod.GET })
	public JsonResponse<InsuranceAndNomineeRestModel> editDeclaration(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : editDeclaration rest starts");

		logger.info("Method :editDeclaration rest ends");
		return insuranceAndNomineeDao.editDeclaration(id,organization,orgDivision);
	}
	
	@RequestMapping(value = "rest-editNominee", method = { RequestMethod.GET })
	public JsonResponse<InsuranceAndNomineeRestModel> editNominee(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : editNominee rest starts");

		logger.info("Method :editNominee rest ends");
		return insuranceAndNomineeDao.editNominee(id,organization,orgDivision);
	}
	//check new Available
	@GetMapping(value = "/rest-checkNewAvailable")
	public ResponseEntity<JsonResponse<DropDownModel>> checkNewAvailable(@RequestParam String userId,String financialYear, String organization, String orgDivision){
		logger.info("Method : checkNewAvailable starts");

		logger.info("Method : checkNewAvailable ends");
		return insuranceAndNomineeDao.checkNewAvailable(userId,financialYear,organization,orgDivision);
	}
	// getDeclareName

	@GetMapping(value = "getDeclareName")
	public JsonResponse<List<DropDownModel>> getDeclareName(@RequestParam String insuId,String orgName,String orgDivision) {
		logger.info("Method : getDeclareName starts");

		logger.info("Method : getDeclareName ends");
		return insuranceAndNomineeDao.getDeclareName(insuId,orgName,orgDivision);
	}

}
