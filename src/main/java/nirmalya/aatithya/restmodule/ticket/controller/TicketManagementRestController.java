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
import nirmalya.aatithya.restmodule.ticket.dao.TicketManagementDao;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;

@RestController
@RequestMapping(value = "ticket/")
public class TicketManagementRestController {
	Logger logger = LoggerFactory.getLogger(TicketManagementRestController.class);

	@Autowired
	TicketManagementDao ticketManagementDao;

	// Ticket Type List.

	@GetMapping(value = "getTicketTypeList")
	public List<DropDownModel> getTicketTypeList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getTicketTypeList starts");

		logger.info("Method : getTicketTypeList ends");
		return ticketManagementDao.getTicketTypeList(org, orgDiv);
	}
	@GetMapping(value = "getEmployeeList")
	public List<DropDownModel> getEmployeeList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getEmployeeList starts");
		
		logger.info("Method : getEmployeeList ends");
		return ticketManagementDao.getEmployeeList(org, orgDiv);
	}
	
	// Ticket Type List.

	@GetMapping(value = "getAssetList")
	public List<DropDownModel> getAssetList(@RequestParam String org, @RequestParam String orgDiv, @RequestParam String userId) {
		logger.info("Method : getAssetList starts");

		logger.info("Method : getAssetList ends");
		return ticketManagementDao.getAssetList(org, orgDiv,userId);
	}

	// Ticket Category List
	@GetMapping(value = "rest-category-dtls")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getTicketCategory(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getTicketCategory starts");

		logger.info("Method : getTicketCategory ends");
		return ticketManagementDao.getTicketCategoryDao(id, org, orgDiv);

	}

	// Ticket Sub Category List
	@GetMapping(value = "rest-subcategory-dtls")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubTicketCategory(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getSubTicketCategory starts");

		logger.info("Method : getSubTicketCategory ends");
		return ticketManagementDao.getTicketSubCategoryDao(id, org, orgDiv);

	}

	// Ticket Priority List.

	@RequestMapping(value = "getPriorityList", method = { RequestMethod.GET })
	public List<DropDownModel> getPriorityList(@RequestParam String org, String orgDiv) {
		logger.info("Method : getPriorityList starts");

		logger.info("Method : getPriorityList ends");
		return ticketManagementDao.getPriorityList(org, orgDiv);
	}
	
	@RequestMapping(value = "getSourceListForTicket", method = { RequestMethod.GET })
	public List<DropDownModel> getSourceList(@RequestParam String org, String orgDiv) {
		logger.info("Method : getSourceList starts");

		logger.info("Method : getSourceList ends");
		return ticketManagementDao.getSourceList(org, orgDiv);
	}

	/*
	 * get all employee list
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "get-employee-list")
	public JsonResponse getEmployeeList(@RequestParam String organization, @RequestParam String orgDivision,
			@RequestParam String userId) {
		logger.info("Method : view-assigned-employee-list starts");

		logger.info("Method : view-assigned-employee-list ends");
		return ticketManagementDao.getEmpListDao(organization, orgDivision, userId);
	}

	// Add Ticket.

	@PostMapping(value = "rest-add-ticket-dtls")
	public ResponseEntity<JsonResponse<TicketManagementRestModel>> saveTicketDtls(
			@RequestBody List<TicketManagementRestModel> category) {
		logger.info("Method : saveTicketDtls starts");

		logger.info("Method : saveTicketDtls ends");
		return ticketManagementDao.saveTicketDtls(category);
	}

	// View Ticket.

	@GetMapping(value = "rest-view-ticket-data")
	public JsonResponse<Object> viewTicketData(@RequestParam String orgName, @RequestParam String orgDivision, String userId, String pageno) {
		logger.info("Method :viewTicketData start");

		logger.info("Method :viewTicketData endss");
		return ticketManagementDao.viewTicketData(orgName, orgDivision, userId, pageno);
	}
	
	// View Ticket search
	@GetMapping(value = "rest-view-ticket-search")
	public JsonResponse<Object> viewTicketDataSearch(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String userId, @RequestParam String searchValue) {
		logger.info("Method :viewTicketDataSearch start");
		
		logger.info("Method :viewTicketDataSearch endss");
		return ticketManagementDao.viewTicketDataSearch(orgName, orgDivision, userId, searchValue);
	}

	// Edit Ticket.

	@RequestMapping(value = "rest-ticket-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editTicket(@RequestParam String id, @RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :editTicket start");

		logger.info("Method :editTicket endss");
		return ticketManagementDao.editTicket(id, orgName, orgDivision);
	}

	// Delete Ticket.

	@GetMapping(value = "rest-ticket-delete")
	public ResponseEntity<JsonResponse<Object>> deleteTicket(@RequestParam String id, @RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : deleteTicket starts");

		logger.info("Method : deleteTicket ends");
		return ticketManagementDao.deleteTicket(id, userId, org, orgDiv);

	}

	// Ticket Sub Category List
	@GetMapping(value = "rest-curr-dept")
	public JsonResponse<List<DropDownModel>> getCurrentDepartment(@RequestParam String userid, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getCurrentDepartment starts");

		logger.info("Method : getCurrentDepartment ends");
		return ticketManagementDao.getCurrentDepartmentDao(userid, org, orgDiv);

	}

	// Attachemnt View

	@GetMapping(value = "rest-view-agentTicket-attachment")
	public JsonResponse<Object> attachemntView(@RequestParam String id, @RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :attachemntView start");

		

		
		logger.info("Method :attachemntView endss");
		return ticketManagementDao.attachemntDaoView(id, orgName, orgDivision);
	}

	/// API SECTION

	
	//getTicketTypeListApi
	
	@GetMapping(value = "getTicketTypeListApi")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getTicketTypeListApi(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getTicketTypeList starts");

		logger.info("Method : getTicketTypeList ends");
		return ticketManagementDao.getTicketTypeListApi(org, orgDiv);
	}
	
	//getPriorityListApi
	
	@RequestMapping(value = "getPriorityListApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPriorityListApi(@RequestParam String org, String orgDiv) {
		logger.info("Method : getPriorityListApi starts");

		logger.info("Method : getPriorityListApi ends");
		return ticketManagementDao.getPriorityListApi(org, orgDiv);
	}

	@PostMapping(value = "rest-view-agentTicket-feedback-save")
	public JsonResponse<Object> saveTicketChatDtls(
			@RequestBody List<TicketManagementRestModel> category) {
		logger.info("Method : saveTicketChatDtls starts");

		logger.info("Method : saveTicketChatDtls ends");
		return ticketManagementDao.saveTicketChatDtls(category);
	}
	
	@GetMapping(value = "rest-view-agentTicket-chat-view")
	public JsonResponse<Object> viewChatDatas(@RequestParam String id, @RequestParam String orgName,
			@RequestParam String orgDivision,@RequestParam String type) {
		logger.info("Method :viewChatData start");

		logger.info("Method :viewChatData endss");
		return ticketManagementDao.viewChatData(id, orgName, orgDivision,type);
	}

	@GetMapping(value = "rest-view-agentTicket-rate-save")
	public ResponseEntity<JsonResponse<Object>> saveRateDetails(@RequestParam String id, @RequestParam String userId,@RequestParam String rate,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : saveRateDetails starts");

		logger.info("Method : saveRateDetails ends");
		return ticketManagementDao.saveRateDetails(id,rate, userId, org, orgDiv);

	}
}
