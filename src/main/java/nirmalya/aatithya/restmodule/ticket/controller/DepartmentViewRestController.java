package nirmalya.aatithya.restmodule.ticket.controller;

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
import nirmalya.aatithya.restmodule.ticket.dao.DepartmentViewDao;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;

@RestController
@RequestMapping("ticket/")
public class DepartmentViewRestController {

	Logger logger = LoggerFactory.getLogger(DepartmentViewRestController.class);

	@Autowired
	DepartmentViewDao departmentViewDao;

	// priority List

	@GetMapping(value = "rest-deptViewPriorityList")
	public JsonResponse<Object> deptViewPriorityList(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String userId, @RequestParam String modName) {
		logger.info("Method :deptViewPriorityList start");

		logger.info("Method :deptViewPriorityList ends");
		return departmentViewDao.deptViewPriorityList(orgName, orgDivision, userId, modName);

	}

	// Get all department Type List (FOR MOBILE)

	@GetMapping(value = "get-departmentlist")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllDeptListMobile(@RequestParam String org,
			String orgDiv) {
		logger.info("Method : getAllDeptListMobile starts");

		logger.info("Method : getAllDeptListMobile ends");
		return departmentViewDao.getAllDeptListMobile(org, orgDiv);
	}
	// Get all department Type List

	@GetMapping(value = "get-department-list")
	public List<DropDownModel> getAllDeptList(@RequestParam String org, @RequestParam String orgDiv, @RequestParam String userId) {
		logger.info("Method : getAllDeptList starts");

		logger.info("Method : getAllDeptList ends");
		return departmentViewDao.getAllDeptList(org, orgDiv,userId);
	}

	@GetMapping(value = "rest-deptViewTicketList")
	public JsonResponse<Object> deptViewTicketList(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userid, @RequestParam String id, @RequestParam String pageno, @RequestParam String activity) {
		logger.info("Method :deptViewTicketList start");

		logger.info("Method :deptViewTicketList ends");
		return departmentViewDao.deptViewTicketList(org, orgDiv, userid, id, pageno,activity);

	}
	@GetMapping(value = "rest-deptViewTicketList-search")
	public JsonResponse<Object> deptViewTicketListSerach(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userid, @RequestParam String id, @RequestParam String search, @RequestParam String activity, @RequestParam String date) {
		logger.info("Method :deptViewTicketListSerach start");
		
		logger.info("Method :deptViewTicketListSerach ends");
		return departmentViewDao.deptViewTicketListSerach(org, orgDiv, userid, id, search,activity,date);
		
	}
	// Get department wise employee details

	@GetMapping(value = "rest-employee-dtls")
	public JsonResponse<List<DropDownModel>> getAllEmployeeList(@RequestParam String deptid, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getAllDeptList starts");

		logger.info("Method : getAllDeptList ends");
		return departmentViewDao.getAllEmployeeList(deptid, org, orgDiv);
	}

	// Add Agent details(INSPECTION)

	@PostMapping(value = "rest-add-agent-dtls")
	public ResponseEntity<JsonResponse<TicketManagementRestModel>> saveAgentDtls(
			@RequestBody TicketManagementRestModel category) {
		logger.info("Method : saveAgentDtls starts");

		logger.info("Method : saveAgentDtls ends");
		return departmentViewDao.saveAgentDtls(category);
	}


	// Add Agent details(ACTION)

	@PostMapping(value = "rest-add-agent-action-dtls")
	public ResponseEntity<JsonResponse<TicketManagementRestModel>> saveAgentActionDtls(
			@RequestBody TicketManagementRestModel category) {
		logger.info("Method : saveAgentActionDtls starts");

		logger.info("Method : saveAgentActionDtls ends");
		return departmentViewDao.saveAgentActionDtls(category);
	}

	// Get all vendor Type List(MOBILE)

	@GetMapping(value = "get-vendorlist")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllVendorListMobile(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getAllVendorListMobile starts");

		logger.info("Method : getAllVendorListMobile ends");
		return departmentViewDao.getAllVendorListMobile(org, orgDiv);
	}

	// Get all vendor Type List

	@GetMapping(value = "get-vendor-list")
	public List<DropDownModel> getAllVendorList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getAllVendorList starts");

		logger.info("Method : getAllVendorList ends");
		return departmentViewDao.getAllVendorListDao(org, orgDiv);
	}

	// History
	@RequestMapping(value = "rest-departmentview-assigned-result", method = { RequestMethod.GET })
	public JsonResponse<Object> historyAssigned(@RequestParam String id, String userId, String orgName,
			String orgDivision) {
		logger.info("Method :historyAssigned start");

		logger.info("Method :historyAssigned endss");
		return departmentViewDao.historyAssigned(id, orgName, orgDivision, userId);
	}
	

	@GetMapping(value = "rest-ticket-history")
	public JsonResponse<Object> getTicketHistory(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getTicketHistory starts");

		logger.info("Method : getTicketHistory ends");
		return departmentViewDao.getTicketHistoryDao(id, org, orgDiv);
	}
	 
	
	@GetMapping(value = "rest-close-ticket")
	public JsonResponse<Object> closeTicketByAdmin(@RequestParam String ticketId, @RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String userId) {
		logger.info("Method : closeTicketByAdmin starts");
		
		logger.info("Method : closeTicketByAdmin ends");
		return departmentViewDao.closeTicketByAdmin(ticketId, orgName, orgDivision, userId);
	}
	
	@GetMapping(value = "rest-departmentview-ticket-hold")
	public JsonResponse<Object> holdTicketByAdmin(@RequestParam String ticketId, @RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String userId) {
		logger.info("Method : holdTicketByAdmin starts");
		
		logger.info("Method : holdTicketByAdmin ends");
		return departmentViewDao.holdTicketByAdmin(ticketId, orgName, orgDivision, userId);
	}
	
	@GetMapping(value = "rest-departmentview-ticket-release")
	public JsonResponse<Object> releaseTicketByAdmin(@RequestParam String ticketId, @RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String userId) {
		logger.info("Method : releaseTicketByAdmin starts");
		
		logger.info("Method : releaseTicketByAdmin ends");
		return departmentViewDao.releaseTicketByAdmin(ticketId, orgName, orgDivision, userId);
	}
		
	@GetMapping(value = "get-vendor-service-list")
	public List<DropDownModel> getVendorServices(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getVendorServices starts");

		logger.info("Method : getVendorServices ends");
		return departmentViewDao.getVendorServices(org, orgDiv);
	}

	@GetMapping(value = "rest-getVendorListOnService")
	public JsonResponse<List<DropDownModel>> getVendorDetailsOnService(@RequestParam String serviceId, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getVendorDetailsOnService starts");

		logger.info("Method : getVendorDetailsOnService ends");
		return departmentViewDao.getVendorDetailsOnService(serviceId, org, orgDiv);
	}
	@GetMapping(value = "get-policy-list")
	public List<DropDownModel> getPolicyList(@RequestParam String org, @RequestParam String orgDiv, @RequestParam String userId) {
		logger.info("Method : getPolicyList starts");

		logger.info("Method : getPolicyList ends");
		return departmentViewDao.getPolicyList(org, orgDiv,userId);
	}
	@GetMapping(value = "rest-view-agentTicket-policywise-view")
	public JsonResponse<Object> getTicketPolicyWise(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userid, @RequestParam String id) {
		logger.info("Method :getTicketPolicyWise start");

		logger.info("Method :getTicketPolicyWise ends");
		return departmentViewDao.getTicketPolicyWise(org, orgDiv, userid, id);

	}
	@RequestMapping(value = "rest-departmentview-maintenance-policylist", method = { RequestMethod.GET })
	public JsonResponse<Object> getPolList(@RequestParam String aid, String pid, String orgName, String orgDivision, String shift) {
		logger.info("Method :getPolList start");

		logger.info("Method :getPolList endss");
		return departmentViewDao.getPolListDateWise(aid, pid, orgName, orgDivision,shift);
	}
}
