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
import nirmalya.aatithya.restmodule.employee.dao.TravelRequsitionRestDao;
import nirmalya.aatithya.restmodule.employee.model.TravelClaimRestModel;
import nirmalya.aatithya.restmodule.employee.model.TravelRequisitionRestModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;

@RestController
@RequestMapping(value = { "employee/" })
public class TravelRequisitionRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	TravelRequsitionRestDao travelRequsitionRestDao;
 
//
	@PostMapping(value = "travel-requisition-employee")
	public JsonResponse<List<TravelRequisitionRestModel>> viewTravelRequisition(@RequestBody EmpRoleModel empModel) {
		logger.info("Method : viewTravelRequisition starts");

		String userId = empModel.getUserId();
		String organization = empModel.getOrganization();
		String orgDivision = empModel.getOrgDivision();
		String type = empModel.getType();
		List<String> roleList = empModel.getUserRole();

		String userRole = "";
		if (roleList.size() > 0) {
			for (String m : roleList) {
				if (empModel.getType().equals("WEB")) {
					userRole = userRole + m + ",";
				} else {
					userRole = userRole + "\"" + m + "\",";
				}
			}
		}

		if (userRole != null && userRole != "") {
			userRole = userRole.substring(0, userRole.length() - 1);
		}

		logger.info("User Id = " + userId + " *** userRole=====" + userRole);
		logger.info("Method : viewTravelRequisition ends");
		return travelRequsitionRestDao.viewTravelRequisition(userId, userRole,organization,orgDivision,type,empModel.getSelfType());
	}

	// add travel
	@PostMapping(value = "rest-add-travel")
	public ResponseEntity<JsonResponse<List<TravelRequisitionRestModel>>> restAddTravel(
			@RequestBody TravelRequisitionRestModel travelModel) {
		logger.info("Method : restAddTravel starts");
		logger.info("Method : restAddTravel ends");
		return travelRequsitionRestDao.addTravel(travelModel);
	}

//	@GetMapping(value = "get-travel-edit")
//	public JsonResponse<List<TravelRequisitionRestModel>> travelEdit(@RequestParam String id) {
//		logger.info("Method : travelEdit starts");
//		logger.info("Method : travelEdit endss");
//		return travelRequsitionRestDao.getTravelEdit(id);
//	}
	
	@GetMapping(value = "get-travel-edit")
	public ResponseEntity<JsonResponse<TravelRequisitionRestModel>> travelEdit(@RequestParam String id) {
		logger.info("Method :travelEdit starts");

		logger.info("Method :travelEdit ends" + id);
		return travelRequsitionRestDao.getTravelEdit(id);

	}
	//

	// delete travel

	@PostMapping(value = "rest-delete-travel")
	public ResponseEntity<JsonResponse<Object>> restDeleteTravel(

			@RequestBody TravelRequisitionRestModel travelModel) {
		logger.info("Method : restDeleteTravel starts");
		logger.info("Method : restDeleteTravel ends");
		return travelRequsitionRestDao.deleteTravel(travelModel);
	}

	// approve Requisition 

	@GetMapping(value = "approveRequisition")
	public JsonResponse<TravelRequisitionRestModel> approveRequisition(@RequestParam String id, String name,
			String comment, @RequestParam String roleid) {
		logger.info("Method : approveRequisition starts"+roleid);

		logger.info("Method : approveRequisition ends");
		return travelRequsitionRestDao.approveRequisition(id, name, comment, roleid);
	}
	//approve Travel details api
	@PostMapping(value="approveRequisition-api")
	public JsonResponse<TravelRequisitionRestModel> approveRequisitionApi(@RequestBody EmpRoleModel empModel){
		logger.info("Method : approveRequisitionApi starts"+empModel);
		logger.info("empModel===="+empModel);
		String id = empModel.getRequisitionName();
		String name = empModel.getUserId();
		String comment = empModel.getComment();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		List<String> roleList = empModel.getUserRole();
		String userRole = "";
		if(roleList.size() > 0) {
			for(String m : roleList) {
				if(empModel.getType().equals("WEB")) {
					userRole = userRole + m + ",";
				} else {
					userRole = userRole +"\"" + m + "\",";
				}
			}
		}
		if(userRole != null && userRole != "") {
			userRole = userRole.substring(0, userRole.length() - 1);
		}
		logger.info("User Id = "+id+ " *** userRole====="+userRole);
		logger.info("Method : approveRequisitionApi ends"+empModel);
		return travelRequsitionRestDao.approveRequisition(id, name, comment, userRole);
	}
	// rejectRequisition

	@GetMapping(value = "rejectRequisition")
	public JsonResponse<TravelRequisitionRestModel> rejectRequisition(@RequestParam String id, String name,
			String comment, @RequestParam String roleid) {
		logger.info("Method : rejectRequisition starts");

		logger.info("Method : rejectRequisition ends");
		return travelRequsitionRestDao.rejectRequisition(id, name, comment, roleid);
	}
	//reject Travel details api
	@PostMapping(value="rejectRequisition-api")
	public JsonResponse<TravelRequisitionRestModel> rejectRequisitionApi(@RequestBody EmpRoleModel empModel){
		logger.info("Method : rejectRequisitionApi starts");
		logger.info("empModel===="+empModel);
		String id = empModel.getRequisitionName();
		String name = empModel.getUserId();
		String comment = empModel.getComment();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		List<String> roleList = empModel.getUserRole();
		String userRole = "";
		if(roleList.size() > 0) {
			for(String m : roleList) {
				if(empModel.getType().equals("WEB")) {
					userRole = userRole + m + ",";
				} else {
					userRole = userRole +"\"" + m + "\",";
				}
			}
		}
		if(userRole != null && userRole != "") {
			userRole = userRole.substring(0, userRole.length() - 1);
		}
		logger.info("User Id = "+id+ " *** userRole====="+userRole);
		logger.info("Method : rejectRequisitionApi ends"+empModel);
		return travelRequsitionRestDao.rejectRequisition(id, name, comment, userRole);
	}
	//travel requisition api
	@GetMapping(value = "travel-requisition-employee-api")
	public JsonResponse<List<TravelRequisitionRestModel>> viewTravelRequisitionApi(@RequestParam String userId,String organization,String orgDivision) {
		logger.info("Method : viewTravelRequisitionApi starts");
 
		logger.info("Method : viewTravelRequisitionApi ends");
		return travelRequsitionRestDao.viewTravelRequisitionApi(userId,organization,orgDivision);
	}
	
	//Purpose Dropdown
	@RequestMapping(value = "getPurposeList", method = { RequestMethod.GET })
	public List<DropDownModel> purposeList() {
		logger.info("Method : purposeList starts");

		logger.info("Method : purposeList ends");
		return travelRequsitionRestDao.purposeList();
	}
	
	
	//Service Dropdown
	
	@RequestMapping(value = "getServiceList", method = { RequestMethod.GET })
	public List<DropDownModel> serviceList() {
		logger.info("Method : serviceList starts");

		logger.info("Method : serviceList ends");
		return travelRequsitionRestDao.serviceList();
	}
//Employee Data
	@RequestMapping(value = "rest-getEmpData", method = { RequestMethod.GET })
	public JsonResponse<DropDownModel> getEmpData(@RequestParam String id) {
		logger.info("Method : getEmpData rest starts");

		logger.info("Method :getEmpData rest ends");
		return travelRequsitionRestDao.getEmpData(id);
	}
	//Employee dropdown
		@RequestMapping(value = "getEmployeeListData", method = { RequestMethod.GET })
		public List<DropDownModel> getEmployeeList(@RequestParam String userId) {
			logger.info("Method : getEmployeeList starts");

			logger.info("Method : getEmployeeList ends");
			return travelRequsitionRestDao.getEmployeeList(userId);
		}
//Purpose Dropdown api
		@GetMapping(value = "get-purposeDropdown-api")
		public JsonResponse<List<DropDownModel>> getPurposeListApi() {
			logger.info("Method : getPurposeListApi starts");

			logger.info("Method : getPurposeListApi ends");
			return travelRequsitionRestDao.getPurposeListApi();
		}
//serviceList Dropdown api
		@GetMapping(value = "get-serviceDropdown-api")
		public JsonResponse<List<DropDownModel>> getServiceListApi() {
		logger.info("Method : getServiceListApi starts");

		logger.info("Method : getServiceListApi ends");
		return travelRequsitionRestDao.getServiceListApi();
	}
//Employeelist dropdown api
		@GetMapping(value = "get-empDropdown-api")
		public JsonResponse<List<DropDownModel>> getempListApi(@RequestParam String userId) {
		logger.info("Method : getempListApi starts");

		logger.info("Method : getempListApi ends");
		return travelRequsitionRestDao.getempListApi(userId);
	}
//EmpData api
		@GetMapping(value = "get-empData-api")
		public JsonResponse<List<DropDownModel>> getempDataApi(@RequestParam String id) {
		logger.info("Method : getempDataApi starts");

		logger.info("Method : getempDataApi ends");
		return travelRequsitionRestDao.getempDataApi(id);
	}
//
		@RequestMapping(value = "get-req-service-other", method = { RequestMethod.GET })
		JsonResponse<List<TravelRequisitionRestModel>> viewTravelReqServiceOther(@RequestParam String id) {
			logger.info("Method : viewTravelReqServiceOther start");

			logger.info("Method : viewTravelReqServiceOther ends");
			return travelRequsitionRestDao.viewTravelReqServiceOther(id);
		}
//
		
		//EmployeeAutoSearchForTravel
				@GetMapping(value = "employee-autosearch-forTravel")
				public ResponseEntity<JsonResponse<List<DropDownModel>>> EmployeeAutoSearchForTravel(
						@RequestParam String id,String org,String orgDiv) {
					logger.info("Method : EmployeeAutoSearchForTravel starts");

					logger.info("Method :EmployeeAutoSearchForTravel endss");
					return travelRequsitionRestDao.EmployeeAutoSearchForTravel(id,org,orgDiv);
				}
		
}