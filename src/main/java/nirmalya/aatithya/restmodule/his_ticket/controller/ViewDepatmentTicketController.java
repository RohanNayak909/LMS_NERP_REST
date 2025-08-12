package nirmalya.aatithya.restmodule.his_ticket.controller;


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
import nirmalya.aatithya.restmodule.his_ticket.dao.ViewDepatmentTicketDao;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;

@RestController
@RequestMapping("ticket-system/")
public class ViewDepatmentTicketController {


		Logger logger = LoggerFactory.getLogger(ViewDepatmentTicketController.class);

		@Autowired
		ViewDepatmentTicketDao dao;

		// priority List

		@GetMapping(value = "deptViewPriorityList")
		public JsonResponse<Object> deptViewPriorityList(@RequestParam String orgName, @RequestParam String orgDivision,
				@RequestParam String userId, @RequestParam String modName) {
			logger.info("Method :deptViewPriorityList start");

			logger.info("Method :deptViewPriorityList ends");
			return dao.deptViewPriorityList(orgName, orgDivision, userId, modName);

		}

		// Get all department Type List (FOR MOBILE)

		/*
		 * @GetMapping(value = "get-departmentlist") public
		 * ResponseEntity<JsonResponse<List<DropDownModel>>>
		 * getAllDeptListMobile(@RequestParam String org, String orgDiv) {
		 * logger.info("Method : getAllDeptListMobile starts");
		 * 
		 * logger.info("Method : getAllDeptListMobile ends"); return
		 * dao.getAllDeptListMobile(org, orgDiv); }
		 */
		// Get all department Type List

		@GetMapping(value = "get-department-list-his")
		public List<DropDownModel> getAllDeptList(@RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method : getAllDeptList starts");

			logger.info("Method : getAllDeptList ends");
			return dao.getAllDeptList(org, orgDiv);
		}

		@GetMapping(value = "deptViewTicketList")
		public JsonResponse<Object> deptViewTicketList(@RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String userid, @RequestParam String id, @RequestParam String pageno, @RequestParam String activity) {
			logger.info("Method :deptViewTicketList start");

			logger.info("Method :deptViewTicketList ends");
			return dao.deptViewTicketList(org, orgDiv, userid, id, pageno,activity);

		}
		@GetMapping(value = "deptViewTicketList-search")
		public JsonResponse<Object> deptViewTicketListSerach(@RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String userid, @RequestParam String id, @RequestParam String search, @RequestParam String activity) {
			logger.info("Method :deptViewTicketListSerach start");
			
			logger.info("Method :deptViewTicketListSerach ends");
			return dao.deptViewTicketListSerach(org, orgDiv, userid, id, search,activity);
			
		}
		// Get department wise employee details

		@GetMapping(value = "employee-dtls")
		public JsonResponse<List<DropDownModel>> getAllEmployeeList(@RequestParam String deptid, @RequestParam String org,
				@RequestParam String orgDiv) {
			logger.info("Method : getAllDeptList starts");

			logger.info("Method : getAllDeptList ends");
			return dao.getAllEmployeeList(deptid, org, orgDiv);
		}

		// Add Agent details(INSPECTION)

		@PostMapping(value = "add-agent-dtls")
		public ResponseEntity<JsonResponse<TicketManagementRestModel>> saveAgentDtls(
				@RequestBody TicketManagementRestModel category) {
			logger.info("Method : saveAgentDtls starts");

			logger.info("Method : saveAgentDtls ends");
			return dao.saveAgentDtls(category);
		}


		// Add Agent details(ACTION)

		@PostMapping(value = "add-agent-action-dtls")
		public ResponseEntity<JsonResponse<TicketManagementRestModel>> saveAgentActionDtls(
				@RequestBody TicketManagementRestModel category) {
			logger.info("Method : saveAgentActionDtls starts");

			logger.info("Method : saveAgentActionDtls ends");
			return dao.saveAgentActionDtls(category);
		}

		// Get all vendor Type List(MOBILE)

//		@GetMapping(value = "get-vendorlist")
//		public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllVendorListMobile(@RequestParam String org,
//				@RequestParam String orgDiv) {
//			logger.info("Method : getAllVendorListMobile starts");
//
//			logger.info("Method : getAllVendorListMobile ends");
//			return dao.getAllVendorListMobile(org, orgDiv);
//		}

		@GetMapping(value = "getHISAssetList")
		public List<DropDownModel> getHISAssetList(@RequestParam String org, @RequestParam String orgDiv, @RequestParam String userId) {
			logger.info("Method : getHISAssetList starts");

			logger.info("Method : getHISAssetList ends");
			return dao.getHISAssetList(org, orgDiv,userId);
		}
		
		// Get all vendor Type List

		@GetMapping(value = "get-vendor-list")
		public List<DropDownModel> getAllVendorList(@RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method : getAllVendorList starts");

			logger.info("Method : getAllVendorList ends");
			return dao.getAllVendorListDao(org, orgDiv);
		}

		// History
		@RequestMapping(value = "departmentview-assigned-result", method = { RequestMethod.GET })
		public JsonResponse<Object> historyAssigned(@RequestParam String id, String userId, String orgName,
				String orgDivision) {
			logger.info("Method :historyAssigned start");

			logger.info("Method :historyAssigned endss");
			return dao.historyAssigned(id, orgName, orgDivision, userId);
		}
		

		@GetMapping(value = "ticket-history")
		public JsonResponse<Object> getTicketHistory(@RequestParam String id, @RequestParam String org,
				@RequestParam String orgDiv) {
			logger.info("Method : getTicketHistory starts");

			logger.info("Method : getTicketHistory ends");
			return dao.getTicketHistoryDao(id, org, orgDiv);
		}
		
		
		@GetMapping(value = "close-ticket")
		public JsonResponse<Object> closeTicketByAdmin(@RequestParam String ticketId, @RequestParam String orgName,
				@RequestParam String orgDivision, @RequestParam String userId) {
			logger.info("Method : closeTicketByAdmin starts");
			
			logger.info("Method : closeTicketByAdmin ends");
			return dao.closeTicketByAdmin(ticketId, orgName, orgDivision, userId);
		}
		// Delete Ticket.

		@GetMapping(value = "rest-ticket-delete")
		public ResponseEntity<JsonResponse<Object>> deleteTicket(@RequestParam String id, @RequestParam String userId,
				@RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method : deleteTicket starts");

			logger.info("Method : deleteTicket ends");
			return dao.deleteTicket(id, userId, org, orgDiv);

		}
		// reopen Ticket.
		
		@GetMapping(value = "rest-ticket-reopen")
		public ResponseEntity<JsonResponse<Object>> reopenTicket(@RequestParam String id, @RequestParam String userId,
				@RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method : reopenTicket starts");
			
			logger.info("Method : reopenTicket ends");
			return dao.reopenTicket(id, userId, org, orgDiv);
			
		}
}
