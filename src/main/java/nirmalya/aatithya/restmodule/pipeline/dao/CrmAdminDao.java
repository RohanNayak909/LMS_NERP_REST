package nirmalya.aatithya.restmodule.pipeline.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.mailservice.EmailAttachmentSender;
import nirmalya.aatithya.restmodule.pipeline.model.AdminTaskAssignRestModel;

@Repository
public class CrmAdminDao {

	Logger logger = LoggerFactory.getLogger(CrmAdminDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private String port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;
    
	/**
	 * Add task assign by Admin to Executive
	 * 
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addTask(AdminTaskAssignRestModel task) {

		logger.info("Method : addTask starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = "SET @title='" + task.getTitle() + "', @priority='" + task.getPriority() + "', @executive='"
				+ task.getExecutive() + "', @descp='" + task.getDescription() + "', @createdby='" + task.createdBy
				+ "', @org='" + task.getOrg() + "', @div='" + task.getOrgDiv() + "', @leadFirstName='"
				+ task.getLeadFirstName() + "', " + "@leadLastName='" + task.getLeadLastName() + "',@leadMobile='"
				+ task.getLeadMobile() + "';";
		System.out.println("Data Printed Here: " + value);
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("crm_admin_routines")
					.setParameter("actionType", "add-task").setParameter("actionValue", value).getResultList();
			System.out.println("------------>>>>>>>>>>" + x.get(0).toString());
			if (x.get(0).toString().equals("Success")) {

				List<String> toAddress = new ArrayList<>();
				toAddress.add(task.getExecutiveMail());
				System.out.println("To Mail Address Printed value" + toAddress);

				String subject = task.getTitle();
				System.out.println("Subject Printed value" + subject);

				String desc = task.getDescription();
				String priorityValue = task.getPriority();

				String priority = "";
				String priorityColor = "";
				String priorityFontSize = "16px"; // Adjust the font size as needed

				if (priorityValue.equals("1")) {
					priority = "High";
					priorityColor = "red";
				} else if (priorityValue.equals("2")) {
					priority = "Medium";
					priorityColor = "orange";
				} else if (priorityValue.equals("3")) {
					priority = "Low";
					priorityColor = "green";
				}

				String message1 = "<html><body>" + "<div style='margin-bottom: 20px;'><span style='color: "
						+ priorityColor + "; font-weight: bold; font-size: " + priorityFontSize + ";'>Priority: "
						+ priority + "</span></div>"
						+ "<div style='background: rgba(255, 255, 255, 0.7); padding: 10px; border-radius: 5px; border-radius: 5px;backdrop-filter: blur(5px);'>"
						+ desc + "</div>" + "</body></html>";

				try {
					EmailAttachmentSender.sendEmailWithAttachmentsURLS(host, port,
							username, password, toAddress, null, null, subject, message1,
							null, null);

					resp.setMessage("Task assigned successfully.");
					resp.setCode("Success");
				} catch (Exception e) {
					logger.error("Error sending email with attachments", e);
					resp.setMessage("Error sending email with attachments");
					return resp;
				}

			} else {
				resp.setMessage(x.get(0).toString());
				resp.setCode("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : addTask ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> allTask(String org, String orgDiv, String role, String userId) {
		logger.info("Method : allTask starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @org='" + org + "', @org_div='" + orgDiv + "',@role='" + role + "',@userId='" + userId
				+ "';";
		System.out.println("Value For View------------>"+value);
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("crm_admin_routines")
					.setParameter("actionType", "fetch-all-tasks").setParameter("actionValue", value).getResultList();

			if (x.size() > 0 && x.get(0) != null) {
				resp.setBody(x.get(0));
				resp.setMessage("Tasks fetched successfully.");
				resp.setCode("Success");
			} else {
				resp.setMessage("No data found.");
				resp.setCode("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : allTask ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getUserTask(String userId, String type) {
		logger.info("Method : getUserTask starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("type---------------->>>>>>>>>>" + type);
		try {
			if (type.equals("notification")) {
				System.out.println("INSODE __________________------");
				List<Object> x = em.createNamedStoredProcedureQuery("crm_admin_routines")
						.setParameter("actionType", "fetch-user-tasks-notification").setParameter("actionValue", userId)
						.getResultList();

				if (x.size() > 0 && x.get(0) != null) {
					resp.setBody(x.get(0));
					resp.setMessage("Tasks fetched successfully.");
					resp.setCode("Success");
				} else {
					resp.setMessage("No data found.");
					resp.setCode("Failed");
				}
			} else {
				List<Object> x = em.createNamedStoredProcedureQuery("crm_admin_routines")
						.setParameter("actionType", "fetch-user-tasks").setParameter("actionValue", userId)
						.getResultList();

				if (x.size() > 0 && x.get(0) != null) {
					resp.setBody(x.get(0));
					resp.setMessage("Tasks fetched successfully.");
					resp.setCode("Success");
				} else {
					resp.setMessage("No data found.");
					resp.setCode("Failed");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : getUserTask ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTask(String taskId) {
		logger.info("Method : getTask starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			List<Object> x = em.createNamedStoredProcedureQuery("crm_admin_routines")
					.setParameter("actionType", "fetch-task-by-taskid").setParameter("actionValue", taskId)
					.getResultList();

			if (x.size() > 0 && x.get(0) != null) {
				resp.setBody(x.get(0));
				resp.setMessage("Tasks fetched successfully.");
				resp.setCode("Success");
			} else {
				resp.setMessage("No data found.");
				resp.setCode("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : getTask ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> chnageStatus(String id, String taskId) {
		logger.info("Method : chnageStatus starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @id ='" + id + "', @taskId='" + taskId + "';";

		try {
			List<Object> x = em.createNamedStoredProcedureQuery("crm_admin_routines")
					.setParameter("actionType", "change-status").setParameter("actionValue", value).getResultList();

			if (x.get(0).toString().equals("Success")) {
				resp.setMessage("Status changed successfully.");
				resp.setCode("Success");
			} else {
				resp.setMessage("Something went wrong.");
				resp.setCode("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : chnageStatus ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> rejectedStatus(String id, String taskStatus, String reasons, String assignedMailId,
			String executiveMail) {
		logger.info("Method : rejectedStatus starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @id ='" + id + "', @taskStatus='" + taskStatus + "', @reasons='" + reasons + "';";
		System.out.println(value);

		try {
			List<Object> x = em.createNamedStoredProcedureQuery("crm_admin_routines")
					.setParameter("actionType", "reject-status").setParameter("actionValue", value).getResultList();
			if (x.get(0).toString().equals("Success")) {

				List<String> toAddress = new ArrayList<>();
				toAddress.add(assignedMailId);
				System.out.println("To Mail Address Printed value" + toAddress);

				String subject = "Task Rejected";
				System.out.println("Subject Printed value" + subject);

				List<String> ccAddress = new ArrayList<>();
				ccAddress.add(executiveMail);
				System.out.println("CC Mail Address Printed value" + ccAddress);

				String message1 = reasons;

				try {
					EmailAttachmentSender.sendEmailWithAttachmentsURLS(host, port,
							username,password, toAddress, ccAddress, null, subject,
							message1, null, null);

					resp.setMessage("Task Rejected successfully.");
					resp.setCode("Success");
				} catch (Exception e) {
					logger.error("Error sending email", e);
					resp.setMessage("Error in sending email");
					return resp;
				}

			} else {
				resp.setMessage(x.get(0).toString());
				resp.setCode("Failed");
			}

			if (x.get(0).toString().equals("Success")) {
				resp.setMessage("Status changed successfully.");
				resp.setCode("Success");
			} else {
				resp.setMessage("Something went wrong.");
				resp.setCode("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : rejectedStatus ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> leadTransfer(String leadId, String leadNewOwner, String leadNewOwnerId, String fromDate,
			String toDate, String transferType, String tranExecutiveMailId, String leadOwnerMailId, String adminMailId,
			String leadMailId, String prevLeadsOwner, String transferredBy, String org, String orgDiv) {
		logger.info("Method : leadTransfer Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @leadId ='" + leadId + "', @leadNewOwnerId='" + leadNewOwnerId + "',@fromDate='" + fromDate
				+ "',@toDate='" + toDate + "',@transferType='" + transferType + "',@transferredBy='" + transferredBy
				+ "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
		System.out.println("Printed Value------------->>>>>>>>>>>" + value);
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("crm_admin_routines")
					.setParameter("actionType", "transfer-lead").setParameter("actionValue", value).getResultList();

			if (x.get(0).toString().equals("Success")) {

				List<String> toAddress = new ArrayList<>();
				toAddress.add(tranExecutiveMailId);
				System.out.println("To Mail Address Printed value" + toAddress);

				List<String> ccAddress = (leadOwnerMailId != null && !leadOwnerMailId.isEmpty())
						? Arrays.asList(leadOwnerMailId.split(","))
						: null;

				System.out.println("CC Mail Address Printed value" + leadOwnerMailId);

				List<String> addBcc = new ArrayList<>();
				addBcc.add(adminMailId);
				addBcc.add(leadMailId);
				List<String> bccAddress = (addBcc != null && !addBcc.isEmpty()) ? addBcc : null;

				System.out.println("Bcc Mail Address Printed value" + addBcc);

				String subject = "Lead Transfer Confirmation";
				String message = "";

				if (transferType.equals("Temporary")) {
					message = "<html><body>"
							+ "<div style='margin-bottom: 20px;'><span style='color: #333; font-weight: bold; font-size: 15px;'>Lead Transfer Details</span></div>"
							+ "<div style='background: #f4f4f4; padding: 20px; border-radius: 5px;'>"
							+ "<p style='margin-bottom: 10px;'><strong><span style='color: #007bff;'>Transfer Type:</span></strong> <span style='font-weight: bold;'>Temporary</span></p>"
							+ "<p style='margin-bottom: 10px;'><strong>From Date:</strong> " + fromDate + "</p>"
							+ "<p style='margin-bottom: 10px;'><strong>To Date:</strong> " + toDate + "</p>"
							+ "<p style='margin-bottom: 10px;'><strong>Details:</strong> The lead has been temporarily transferred from <span style='font-weight: bold;text-transform:uppercase;'><strong>"
							+ prevLeadsOwner
							+ "</strong></span> to <span style='font-weight: bold;text-transform:uppercase;'><strong>"
							+ leadNewOwner + "</strong></span> for the specified duration.</p>"
							+ "<p style='margin-bottom: 10px;'><strong>Action Required:</strong> No action is required from your end during this temporary transfer period.</p>"
							+ "<div style='margin-top: 20px; border-top: 1px solid #ccc;'></div>"
							+ "<p style='margin-top: 20px;'><strong>Additional Information:</strong></p>"
							+ "<p style='margin-bottom: 10px;'>During this temporary transfer, the new executive will be responsible for handling all communication with the lead.</p>"
							+ "<p style='margin-bottom: 10px;'>If you have any urgent concerns or questions, please reach out to the new executive directly via their</p>"
							+ "<p>email:<a href='mailto:executive@example.com' style='background: #f4f4f4; color: #007bff; text-decoration: none; padding: 2px 5px; border-radius: 3px; display: inline-block;'>"
							+ tranExecutiveMailId + "</a></p>"
							+ "<p style='margin-bottom: 10px;'>Thank you for your cooperation in ensuring a smooth transition for the lead.</p>"
							+ "</div>" + "</body></html>";
				} else if (transferType.equals("Permanent")) {

					message = "<html><body>"
							+ "<div style='margin-bottom: 20px;'><span style='color: #333; font-weight: bold; font-size: 15px;'>Lead Transfer Details</span></div>"
							+ "<div style='background: #f4f4f4; padding: 20px; border-radius: 5px;'>"
							+ "<p style='margin-bottom: 10px;'><strong><span style='color: #007bff;'>Transfer Type:</span></strong> <span style='font-weight: bold;'>Permanent</span></p>"
							+ "<p style='margin: 10px 0;'><strong>Details:</strong> The lead has been permanently transferred from <span style='font-weight: bold;text-transform:uppercase;'>"
							+ prevLeadsOwner + "</span> to <span style='font-weight: bold;text-transform:uppercase;'>"
							+ leadNewOwner + "</span>.</p>"
							+ "<p style='margin: 0;'><strong>Action Required:</strong> No action is required from your end. The new executive, <span style='font-weight: bold;'>"
							+ leadNewOwner + "</span>, will handle the lead going forward.</p>"
							+ "<div style='margin-top: 20px; border-top: 1px solid #ccc;'></div>"
							+ "<p style='margin-top: 20px;'><strong>Additional Information:</strong></p>"
							+ "<p style='margin-bottom: 10px;'>This is a permanent transfer, and all future communication regarding this lead should be directed to <span style='font-weight: bold;text-transform:uppercase;'>"
							+ leadNewOwner + "</span>.</p>"
							+ "<p style='margin-bottom: 10px;'>For any questions or concerns, please contact <span style='font-weight: bold;text-transform:uppercase;'>"
							+ leadNewOwner + "</span> at their</p>"
							+ "<p>email: <a href='mailto:executive@example.com' style='background: #f4f4f4; color: #007bff; text-decoration: none; padding: 2px 5px; border-radius: 3px; display: inline-block;'>"
							+ tranExecutiveMailId + "</a></p>" + "</div>" + "</body></html>";
				}

				try {
					EmailAttachmentSender.sendEmailWithAttachmentsURLS(host,port,
							username, password, toAddress, ccAddress, bccAddress, subject,
							message, null, null);

					JSONObject json = new JSONObject();
					json.put("newLeadOwnerId", leadNewOwnerId);

					resp.setMessage("Lead Transfered successfully.");
					resp.setCode("Success");
					resp.setBody(json.toString());
				} catch (Exception e) {
					logger.error("Error sending email with attachments", e);
					resp.setMessage("Error sending email with attachments");
				}

			} else {
				resp.setMessage("Something went wrong.");
				resp.setCode("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : leadTransfer Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> leadTransferhHistory(String userId, String id) {
		logger.info("Method : leadTransferhHistory starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_userId ='" + userId + "',@p_id ='" + id + "';";
		System.out.println(value);

		try {
			List<Object> x = em.createNamedStoredProcedureQuery("crm_admin_routines")
					.setParameter("actionType", "transfer-history").setParameter("actionValue", value).getResultList();
			System.out.println("====" + x);

			resp.setBody(x);

			resp.setMessage("Data Fetched successfully.");
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : leadTransferhHistory ends");
		return resp;
	}

	public JsonResponse<Object> adminNotificationDao(String org, String orgDiv, String userId) {
		logger.info("Method : adminNotificationDao");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String val = "SET @userId='" + userId + "',@org='" + org + "', @orgDiv='" + orgDiv + "';";
		System.out.println(val);
		try {
			Object x = em.createNamedStoredProcedureQuery("crm_admin_routines")
					.setParameter("actionType", "admin-notification").setParameter("actionValue", val)
					.getSingleResult();

			resp.setBody(x);

			resp.setMessage("Data Fetched successfully.");
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}
		return resp;
	}

	public JsonResponse<Object> adminApproval(String orgName, String orgDivision, String lead, String status,
			String userId) {
		logger.info("Method : adminApproval");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String val = "SET @org='" + orgName + "', @orgDiv='" + orgDivision + "', @leadId='" + lead + "', @status='"
				+ status + "',@userId='" + userId + "';";

		System.out.println("SYSOUT --->>>> " + val);

		try {
			List<Object> x = em.createNamedStoredProcedureQuery("crm_admin_routines")
					.setParameter("actionType", "admin-approval").setParameter("actionValue", val).getResultList();
			System.out.println("Lead Data Used For Convert The Lead====" + x);

			if (!x.get(0).equals("Success")) {
				resp.setBody(x.get(0));
			}

			resp.setMessage("Data Fetched successfully.");
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}
		return resp;
	}

	// Admin Notification Escalation - Addded By Pankaj Kumar
	public JsonResponse<Object> escalateAdminNotificationDao(String ids) {
		logger.info("Method : Escalate-AdminNotificationDao");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String val = "SET @notificationId='" + ids + "';";
		System.out.println(val);
		try {

			Object x = em.createNamedStoredProcedureQuery("crm_admin_routines")
					.setParameter("actionType", "escalate-admin-notification").setParameter("actionValue", val)
					.execute();

			resp.setBody(x);

			resp.setMessage("Notification Escalated successfully.");
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}
		return resp;
	}

	// All Admins Notifications
	public JsonResponse<Object> getAdminsNotificationDao() {
		logger.info("Method : All-AdminNotificationDao Starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			Object x = em.createNamedStoredProcedureQuery("crm_admin_routines")
					.setParameter("actionType", "getAllAdminNotification").setParameter("actionValue", "")
					.getSingleResult();
			resp.setBody(x);
			resp.setMessage("Notification Fetch Successfully.");
			resp.setCode("Success");
			System.out.println(x);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		logger.info("Method : All-AdminNotificationDao Ends");
		return resp;
	}

	// Get All Leads Activity Remonder 
	public JsonResponse<Object> getLeadReminderData() {
		logger.info("Method : All-LeadReminderData Starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			Object x = em.createNamedStoredProcedureQuery("crm_admin_routines")
					.setParameter("actionType", "fetch-lead-reminder-data").setParameter("actionValue", "")
					.getSingleResult();
			resp.setBody(x);
			resp.setMessage("Reminders Fetch Successfully.");
			resp.setCode("Success");
			System.out.println(x);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		logger.info("Method : All-LeadReminderData Ends");
		return resp;
	}
}
