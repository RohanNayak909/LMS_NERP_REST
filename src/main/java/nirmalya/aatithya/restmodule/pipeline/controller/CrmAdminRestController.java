package nirmalya.aatithya.restmodule.pipeline.controller;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.dao.CrmAdminDao;
import nirmalya.aatithya.restmodule.pipeline.model.AdminTaskAssignRestModel;

@RestController
@RequestMapping(value = "pipeline")
public class CrmAdminRestController {

	Logger logger = LoggerFactory.getLogger(CrmAdminRestController.class);

	CrmAdminDao crmAdminDao;

	@Autowired
	CrmAdminRestController(CrmAdminDao crmAdminDao) {
		this.crmAdminDao = crmAdminDao;
	}

	@RequestMapping(value = "add-task", method = { RequestMethod.POST })
	public JsonResponse<Object> addTask(@RequestBody AdminTaskAssignRestModel task) {

		logger.info("Method : addTask starts");
		logger.info("Method : addTask ends");

		return crmAdminDao.addTask(task);
	}

	@RequestMapping(value = "all-tasks", method = { RequestMethod.GET })
	public JsonResponse<Object> allTask(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String role, @RequestParam String userId) {

		logger.info("Method : allTask starts");
		logger.info("Method : allTask ends");

		return crmAdminDao.allTask(org, orgDiv, role, userId);
	}

	@RequestMapping(value = "user-tasks", method = { RequestMethod.GET })
	public JsonResponse<Object> getUserTask(@RequestParam String userId, @RequestParam String type) {

		logger.info("Method : getUserTask starts");
		logger.info("Method : getUserTask ends");

		return crmAdminDao.getUserTask(userId, type);
	}

	@RequestMapping(value = "fetch-task", method = { RequestMethod.GET })
	public JsonResponse<Object> getTask(@RequestParam String taskId) {

		logger.info("Method : getUserTask starts");
		logger.info("Method : getUserTask ends");

		return crmAdminDao.getTask(taskId);
	}

	@RequestMapping(value = "chnage-status", method = { RequestMethod.GET })
	public JsonResponse<Object> chnageStatus(@RequestParam String id, @RequestParam String taskId) {

		logger.info("Method : chnageStatus starts");
		logger.info("Method : chnageStatus ends");

		return crmAdminDao.chnageStatus(id, taskId);
	}

	@RequestMapping(value = "reject-status", method = { RequestMethod.GET })
	public JsonResponse<Object> rejectedStatus(@RequestParam String id, @RequestParam String taskStatus,
			@RequestParam String reasons, @RequestParam String assignedMailId, @RequestParam String executiveMail) {

		logger.info("Method : rejectedStatus starts");
		logger.info("Method : rejectedStatus ends");

		return crmAdminDao.rejectedStatus(id, taskStatus, reasons, assignedMailId, executiveMail);
	}

	@RequestMapping(value = "lead-transfer", method = { RequestMethod.GET })
	public JsonResponse<Object> leadTransfer(@RequestParam String leadId, String leadNewOwner, String leadNewOwnerId,
			String fromDate, String toDate, String transferType, String tranExecutiveMailId, String leadOwnerMailId,
			String adminMailId, String leadMailId, String prevLeadsOwner, String transferredBy, String org,
			String orgDiv) {

		logger.info("Method : leadTransfer starts");
		logger.info("Method : leadTransfer ends");

		return crmAdminDao.leadTransfer(leadId, leadNewOwner, leadNewOwnerId, fromDate, toDate, transferType,
				tranExecutiveMailId, leadOwnerMailId, adminMailId, leadMailId, prevLeadsOwner, transferredBy, org,
				orgDiv);
	}

	@RequestMapping(value = "lead-transfer-history", method = { RequestMethod.GET })
	public JsonResponse<Object> leadTransferhHistory(@RequestParam String userId, @RequestParam String id) {

		logger.info("Method : leadTransferhHistory starts");
		logger.info("Method : leadTransferhHistory ends");

		return crmAdminDao.leadTransferhHistory(userId, id);
	}

	@RequestMapping(value = "admin-notification", method = { RequestMethod.GET })
	public JsonResponse<Object> adminNotification(@RequestParam String org, String orgDiv, String userId) {

		logger.info("Method : leadTransferhHistory");

		return crmAdminDao.adminNotificationDao(org, orgDiv, userId);
	}

	@RequestMapping(value = "admin-approval", method = { RequestMethod.GET })
	public JsonResponse<Object> adminApproval(@RequestParam String orgName,@RequestParam String orgDivision, @RequestParam String lead,@RequestParam String status,
			String userId) {

		logger.info("Method : adminApproval");

		/*
		 * byte[] decodedBytes = Base64.getDecoder().decode(lead); String decodedString
		 * = new String(decodedBytes);
		 */

		return crmAdminDao.adminApproval(orgName, orgDivision, lead, status, userId);
	}

	// Admin Notification Escalation
	@RequestMapping(value = "admin-notification-escalate", method = { RequestMethod.GET })
	public JsonResponse<Object> escalateAdminNotifications(@RequestParam String ids) {

		logger.info("Method : Escalate Admin Notifications");

		return crmAdminDao.escalateAdminNotificationDao(ids);
	}

	// Get All Admin Notifications without Logins
	@RequestMapping(value = "getAllAdminNotifications", method = { RequestMethod.GET })
	public JsonResponse<Object> getAdminsNotificationApi() {
		logger.info("Method : All Admin Notifications");
		return crmAdminDao.getAdminsNotificationDao();

	}

	// Get All Leads Activity Remonder 
	@RequestMapping(value = "getLeadReminderData", method = { RequestMethod.GET })
	public JsonResponse<Object> getLeadReminderData() {
		logger.info("Method : All LeadReminderData");
		return crmAdminDao.getLeadReminderData();

	}

}
