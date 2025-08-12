package nirmalya.aatithya.restmodule.api.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.api.model.AttendanceModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.MailService;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAttendanceManagementParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.MailConfigRestModel;
import nirmalya.aatithya.restmodule.util.PushNotification;

@Repository
public class SchedulerAPIDao {
	Logger logger = LoggerFactory.getLogger(SchedulerAPIDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	@Autowired
	MailService mailService;
    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private String port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;
    
	PushNotification pushNotification = new PushNotification();

	@SuppressWarnings("unchecked")
	public JsonResponse<DropDownModel> leadFollowUpReminder(String date) {
		logger.info("Method : leadFollowUpReminder starts");
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_date='" + DateFormatter.getStringDate(date) + "';";
			logger.info("value===" + value);
			List<String> x = em.createNamedStoredProcedureQuery("scheduler_API_Routines")
					.setParameter("actionType", "leadFollowUpReminder").setParameter("actionValue", value)
					.getResultList();
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> resultMap = mapper.readValue(x.get(0), Map.class);

			List<Map<String, Object>> dataList = (List<Map<String, Object>>) resultMap.get("data_list");
			JSONObject jsonObj = new JSONObject(x.get(0));
			JSONArray ccAdr = jsonObj.getJSONArray("ccAddress");
			List<MailConfigRestModel> cc_list = mapper.readValue(ccAdr.toString(),
					new TypeReference<List<MailConfigRestModel>>() {
					});
			List<String> ccAddress = cc_list.stream().map(x3 -> x3.getPersonalMail()).collect(Collectors.toList());
			for (Map<String, Object> lead : dataList) {
				if(lead.get("Executive_Email") != null) {
					String userid = lead.get("Executive_Id").toString();
					String username = lead.get("Executive_Name").toString();
					String clientId = lead.get("Lead_Id").toString();
					String clientName = lead.get("Lead_Name").toString();
					String clientCreatedOn = lead.get("Lead_CreatedOn").toString();
					String clientStatus = lead.get("Lead_Status").toString();
 
			        List<String> toAddress = new ArrayList<>();
			        toAddress.add(lead.get("Executive_Email").toString());
 
					if(lead.get("Lead_Created_days").toString()=="3" || lead.get("Lead_Created_days").toString().equals("3")) {
						
						String sub = "Pending Lead Follow-up Reminder – Action Required";
						String msg = "<html>" +
							      "<body style='font-family: Arial, sans-serif; font-size: 14px; color: #000000;'>" +
							      "Dear " + username + ",<br><br>" +

							      "This is a gentle reminder that the following lead has remained unattended for 3 days:<br><br>" +

							      "<ul style='margin-top: 0; padding-left: 20px;'>" +
							      "<li><b>Lead Name/ID:</b> " + clientName + " (" + clientId + ")</li>"+
							      "<li><b>Created On:</b> " + clientCreatedOn + "</li>" +
							      "<li><b>Lead Executive:</b> " + username + " (" + userid + ")</li>"+
							      "<li><b>Current Status:</b> " + clientStatus + "</li>" +
							      "</ul><br>" +

							      "No quotation or action has been recorded against this lead. Please review and take the necessary steps to either update the lead status or generate a quotation.<br>" +
							      "If this lead no longer requires follow-up, you may choose to suppress further alerts using the " +
							      "<b>\"Mark as Low Priority\"</b> option in the NERP system.<br><br>" +

							      "Thank you,<br>" +
							      "Team APIL" +
							      "</body>" +
							      "</html>";

						MailService.sendEmailOnlyText(host, port, username, password, toAddress, null,sub, msg, null, null);
					}else if(lead.get("Lead_Created_days").toString()=="5" || lead.get("Lead_Created_days").toString().equals("5")) {
						String sub = "Escalation: Lead Unattended for 5 Days – Immediate Action Required";
						String msg = "<html>" +
							      "<body style='font-family: Arial, sans-serif; font-size: 14px; color: #000000;'>" +
							      "Dear " + username + ",<br><br>" +

							      "This is an escalation notice regarding the following lead, which has remained inactive for 5 days:<br><br>" +

							      "<ul style='margin-top: 0; padding-left: 20px;'>" +
							      "<li><b>Lead Name/ID:</b> " + clientName + " (" + clientId + ")</li>"+
							      "<li><b>Created On:</b> " + clientCreatedOn + "</li>" +
							      "<li><b>Assigned To:</b> " + username + " (" + userid + ")</li>"+
							      "<li><b>Current Status:</b> " + clientStatus + "</li>" +
							      "<li><b>Days Since Last Action:</b> 5</li>" +
							      "</ul><br>" +

							      "As per our follow-up protocol, this escalation is being sent to you with supervisory CCs to ensure visibility and appropriate action.<br><br>" +

							      "Kindly log into NERP and update the lead status or generate a quotation at the earliest. You may suppress future alerts manually, but the lead will continue to appear as " +
							      "<b>&lsquo;Incomplete&rsquo;</b> until closed.<br><br>"+

							      "Best regards,<br>" +
							      "Team APIL" +
							      "</body>" +
							      "</html>";
						MailService.sendEmailOnlyText(host, port, username, password, toAddress, ccAddress,sub, msg, null, null);
					}
						
				}

			}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
				logger.error("leadFollowUpReminder: " + err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				logger.error("leadFollowUpReminder: " + e.getMessage());
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
			e.printStackTrace();
		}
		logger.info("Method : leadFollowUpReminder ends");
		return resp;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<DropDownModel> attendanceReminder(String date) {
		logger.info("Method : attendanceReminder dao starts");
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_date='" + DateFormatter.getStringDate(date) + "';";
			logger.info("value===" + value);
			List<String> x = em.createNamedStoredProcedureQuery("scheduler_API_Routines")
				    .setParameter("actionType", "attendanceReminder")
				    .setParameter("actionValue", value)
				    .getResultList();

				if (!x.isEmpty()) {
				    String title = "No Punch-In Detected";
				    String msg = "You have not punched in.";
				    logger.info("Notification message: " + msg);

				    for (String recipient : x) {
				        try {
				        	System.out.println("recipient=="+recipient);
				            String msgId = pushNotification.pushFCMNotificationForAll(recipient, msg, title);
				            logger.info("Notification sent to: " + recipient + ", msgId: " + msgId);
				        } catch (Exception e) {
				            logger.error("Failed to send notification to: " + recipient, e);
				        }
				    }
				}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
			} catch (Exception e1) {
				resp.setCode("failed");
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
			e.printStackTrace();
		}
		logger.info("Method : attendanceReminder ends");
		return resp;
		 
	}
}
