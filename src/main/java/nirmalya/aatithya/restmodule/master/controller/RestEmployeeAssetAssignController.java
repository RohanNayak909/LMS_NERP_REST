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
import nirmalya.aatithya.restmodule.master.dao.RestEmployeeAssetAssignDao;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeAssetAssignModel;

@RestController
@RequestMapping(value = { "master" })
public class RestEmployeeAssetAssignController {
	Logger logger = LoggerFactory.getLogger(RestSalaryRevisionController.class);

	@Autowired
	RestEmployeeAssetAssignDao empassetassgindao;

// designation list

	@RequestMapping(value = "rest-getassetlist", method = { RequestMethod.GET })
	public List<DropDownModel> getDesignationDropDown(){

		logger.info("Method : getDesignationDropDown starts");

		logger.info("Method : getDesignationDropDown end");
		return empassetassgindao.getAssetList();
	}

	@PostMapping(value = "employee-asset-assign-savedata-master")
	public ResponseEntity<JsonResponse<Object>> addFuel(@RequestBody RestEmployeeAssetAssignModel assetassign) {
		logger.info("Method :restAdd starts");
		
		logger.info("Method :restAdd endss");
		return empassetassgindao.addAssetDetails(assetassign);

	}

	@RequestMapping(value = "employee-asset-assign-view", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestEmployeeAssetAssignModel>>> viewaseetassign(@RequestParam String userid ,@RequestParam String roleid,String organization,String orgDivision){

		logger.info("Method : viewEducation starts");

		logger.info("Method : viewEducation ends");
		return empassetassgindao.viewAssetAssign(userid ,roleid,organization,orgDivision);
	}

	@RequestMapping(value = "employee-asset-assign-edit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestEmployeeAssetAssignModel>> editAssetAssign(@RequestParam String empAssetId) {
		logger.info("Method : editFuel starts");

		logger.info("Method :editFuel ends");
		return empassetassgindao.editAssetAssign(empAssetId);
	}

	@RequestMapping(value = "employee-asset-assign-delete", method = { RequestMethod.GET })
	public JsonResponse<RestEmployeeAssetAssignModel> deleteFuel(@RequestParam String deleteId) {
		logger.info("Method : deleteFuel starts");

		logger.info("Method : deleteFuel ends");
		return empassetassgindao.deleteAssetAssign(deleteId);
	}
	
	
	
	
	@GetMapping(value = "get-EmployeeId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeId(@RequestParam String subDeptId,String orgName,String orgDivision) {
		logger.info("Method : get-EmployeeId starts");

		logger.info("Method : get-EmployeeId ends");
		return empassetassgindao.getEmployeeId(subDeptId,orgName,orgDivision);
	}
	

}
