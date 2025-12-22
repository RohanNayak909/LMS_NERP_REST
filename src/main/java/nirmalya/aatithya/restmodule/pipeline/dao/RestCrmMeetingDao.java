package nirmalya.aatithya.restmodule.pipeline.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.apache.commons.math3.random.ISAACRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateMeetingParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.mailservice.EmailAttachmentSender;
import nirmalya.aatithya.restmodule.mailservice.EmailCalendarEvent;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmMeetingModel;

@Repository
public class RestCrmMeetingDao {

	Logger logger = LoggerFactory.getLogger(RestCrmDealDao.class);
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
    
	public List<Object> getAdminMail() {

		@SuppressWarnings("unchecked")
		List<Object> obj = em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType", "adminEmail")
				.setParameter("actionValue", "").getResultList();

		return obj;
	}

	// addTask

	/**
	 * DAO Function to addMeeting
	 *
	 */

	/*
	 * Use Uid to uniquely identify calendar email for modify and cancel purpose
	 */
	private static final String uid = UUID.randomUUID().toString();
	StringBuilder str = new StringBuilder();

	public JsonResponse<Object> addMeeting(RestCrmMeetingModel task) {
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (getAdminMail() != null && !getAdminMail().isEmpty() && getAdminMail().get(0) != null
				&& !getAdminMail().get(0).toString().isEmpty()) {
			task.setCcMail(task.getCcMail() == null || task.getCcMail().isEmpty() ? getAdminMail().get(0).toString()
					: task.getCcMail().concat("," + getAdminMail().get(0).toString()));
		}

		try {
			String values = GenerateMeetingParameter.getMeetingParam(task, uid);
			System.out.println("Vaues For Add Meeting======>" + values);
			if (task.getMeetingId() == null || task.getMeetingId() == "") {

				String meetingTypeContact = "Contact";
				String meetingTypeLead = "Lead";
				String pageTypeAccount = "Account";
				String pageTypeMeeting = "Meeting";
				String pageTypeDeal = "Deal";

				/*
				 * String pageTypeQuote="Quote"; String pageTypeSO="SalesOrder"; String
				 * pageTypePO="PurchaseOrder"; String pageTypeInvoice="Invoice";
				 */

				String meetingType = task.getMeetingType();

				/*
				 * if(meetingType.equals(pageTypeQuote)) {
				 * em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType",
				 * "addMeetingQuote") .setParameter("actionValue", values).execute(); }
				 * 
				 * if(meetingType.equals(pageTypeSO)) {
				 * em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType",
				 * "addMeetingSO") .setParameter("actionValue", values).execute(); }
				 * 
				 * if(meetingType.equals(pageTypePO)) {
				 * em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType",
				 * "addMeetingPO") .setParameter("actionValue", values).execute(); }
				 * 
				 * if(meetingType.equals(pageTypeInvoice)) {
				 * em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType",
				 * "addMeetingInvoice") .setParameter("actionValue", values).execute(); }
				 */

				try {

					resp = meetingsMail(task, resp, uid, "create");

					if (resp.getCode().equals("Success")) {
						try {
							if (meetingType.equals(meetingTypeLead)) {
								System.out.println("Calling Lead Action Type");
								em.createNamedStoredProcedureQuery("crm_meeting")
										.setParameter("actionType", "addMeetingLeadPage")
										.setParameter("actionValue", values).execute();
							}

							if (meetingType.equals(meetingTypeContact)) {
								System.out.println("Calling Contact Action Type");
								em.createNamedStoredProcedureQuery("crm_meeting")
										.setParameter("actionType", "addMeetingContactPage")
										.setParameter("actionValue", values).execute();
							}

							if (meetingType.equals(pageTypeAccount)) {
								em.createNamedStoredProcedureQuery("crm_meeting")
										.setParameter("actionType", "addMeetingAccountPage")
										.setParameter("actionValue", values).execute();
							}

							if (meetingType.equals(pageTypeDeal)) {
								em.createNamedStoredProcedureQuery("crm_meeting")
										.setParameter("actionType", "addMeetingDealPage")
										.setParameter("actionValue", values).execute();
							}

							if (meetingType.equals(pageTypeMeeting)) {

								em.createNamedStoredProcedureQuery("crm_meeting")
										.setParameter("actionType", "addMeeting").setParameter("actionValue", values)
										.execute();
							}

						} catch (Exception e) {
							resp.setCode("Failed");
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				str.setLength(0);
				str.append(GenerateMeetingParameter.getMeetingParam(task, ""));

				try {
					resp = meetingsMail(task, resp, uid, "update");

					if (resp.getCode().equals("Success")) {
						em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType", "modifyMeeting")
								.setParameter("actionValue", str.toString()).execute();
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
				}

			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		logger.info("Method : addMeeting ends");
		return resp;
	}

	public JsonResponse<Object> meetingsMail(RestCrmMeetingModel task, JsonResponse<Object> resp, String uid,
			String type) throws Exception {

		String toMail = task.getToMail();
		List<String> toAddress = (toMail != null && !toMail.isEmpty()) ? Arrays.asList(toMail.split(",")) : null;

		String addCc = task.getCcMail();
		List<String> ccAddress = (addCc != null && !addCc.isEmpty()) ? Arrays.asList(addCc.split(",")) : null;

		String addBcc = task.getExcutiveMail();
		List<String> bccAddress = (addBcc != null && !addBcc.isEmpty()) ? Arrays.asList(addBcc.split(",")) : null;

		String subject = task.getMeetingTitle();

		String location = task.getMeetingLocation();

		String desc = task.getDescription();

		String fromDateTime = task.getMeetingFromDate() + " " + task.getMeetingFromTime() + ":00";

		String toDateTime = task.getMeetingToDate() + " " + task.getMeetingToTime() + ":00";

		EmailCalendarEvent emailEvent = new EmailCalendarEvent();

		String summary = task.getSummary();
		String senderName = task.getMeetingHostName();
		try {
			if (type.equals("create")) {
				emailEvent.send(subject, username, password, toAddress, host, port, location, subject, desc,
						fromDateTime, toDateTime, ccAddress, bccAddress, uid);
			} else {
				System.out.println("Update");
				if (task.getMeetingStatus().equals("Deferred")) {
					String deferredSubject = "Meeting Rescheduled - " + subject;
					emailEvent.send(deferredSubject, username, password, toAddress, host, port, location,
							deferredSubject, desc, fromDateTime, toDateTime, ccAddress, bccAddress, uid);
				} else if (task.getMeetingStatus().equals("Completed")) {
					StringBuilder messageBody = new StringBuilder();
					messageBody.append("<html><body>");
					messageBody.append("<p>Dear All,</p>");
					messageBody.append("<p>The following meeting has been successfully completed:</p>");
					messageBody.append("<p><strong>Meeting Location:</strong> ").append(location).append("</p>");
					messageBody.append("<p><strong>Scheduled Time:</strong> ").append(fromDateTime).append(" to ")
							.append(toDateTime).append("</p>");
					messageBody.append("<p><strong>Summary of the meeting:</strong></p>");
					messageBody.append("<p>").append(summary).append("</p>");
					messageBody.append("<p>Thank you for your attention to this matter.</p>");
					messageBody.append("<p>Best regards,<br>").append(senderName).append("</p>");
					messageBody.append("</body></html>");
					EmailAttachmentSender.sendEmailWithAttachmentsURLS(host, port, username, password, toAddress,
							ccAddress, bccAddress, subject, messageBody.toString(), "", "");
				}
			}

			resp.setCode("Success");
		} catch (Exception e) {
			logger.error("Error sending email event", e.getMessage());
			resp.setMessage("Error sending email event");
			resp.setCode("Failed");
		}

		return resp;
	}
	/// restViewTaskdetails

////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> restViewMeetingDetails(String pageno, String userId,
			String orgName, String orgDivision) {
		logger.info("Method : restViewMeetingDetails starts");
		List<RestCrmMeetingModel> respList = new ArrayList<RestCrmMeetingModel>();

		String value = "SET @p_pageno='" + pageno + "',@p_userId='" + userId + "'," + "@org='" + orgName + "',@orgDiv='"
				+ orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_meeting")
					.setParameter("actionType", "getMeetingDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				if (m[10] == null) {
					m[10] = "";
				}
				if (m[15] == null) {
					m[15] = "";
				}
				if (m[16] == null) {
					m[16] = "";
				}
				if (m[17] == null) {
					m[17] = "";
				}
				if (m[18] == null) {
					m[18] = "";
				}
				if (m[19] == null) {
					m[19] = "";
				}

				RestCrmMeetingModel restPayroll = new RestCrmMeetingModel(m[0].toString(), m[1], m[2], m[3], m[4],
						m[5].toString(), m[6].toString(), m[7].toString(), m[8], m[9], m[10], m[11], m[12].toString(),
						m[13], m[14], m[15].toString(), m[16], m[17].toString(), m[18], m[19].toString(), null, null,
						null, m[20], null, m[21], null, m[22].toString(), m[23].toString(), null, null, m[24],null);
				respList.add(restPayroll);

			}

			logger.info("VIEW response-----------------------" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestCrmMeetingModel>> resp = new JsonResponse<List<RestCrmMeetingModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>>(
				resp, HttpStatus.CREATED);
		// logger.info("response meeting--------" + response);
		logger.info("Method : restViewMeetingDetails ends");

		// logger.info("VIEWWWWWWWW" + respList);
		return response;

	}

	// getLeadNameList

	/// editAccountInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> editMeetingInfo(String id) {
		logger.info("Method : editMeetingInfo starts");

		JsonResponse<List<RestCrmMeetingModel>> resp = new JsonResponse<List<RestCrmMeetingModel>>();
		List<RestCrmMeetingModel> rs = new ArrayList<RestCrmMeetingModel>();

		try {

			String value = "SET @p_meetingId='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_meeting")
					.setParameter("actionType", "editMeetingInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf" + x.toString());

			for (Object[] m : x) {
				for (int i = 0; i < m.length; i++) {
					if (m[i] == null) {
						m[i] = "";
					}
				}
				List<Map<String, String>> attendeesList = new ArrayList<>();
				List<Map<String, String>> discussionPointsList = new ArrayList<>();

				try {
					if (!m[10].toString().isEmpty()) {
						attendeesList = new ObjectMapper().readValue(m[10].toString(),
								new TypeReference<List<Map<String, String>>>() {
								});
					}
					if (!m[22].toString().isEmpty()) {
						discussionPointsList = new ObjectMapper().readValue(m[22].toString(),
								new TypeReference<List<Map<String, String>>>() {
								});
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
                  
				RestCrmMeetingModel assignSkill = new RestCrmMeetingModel(m[0].toString(), m[1], m[2], m[3], m[4],
						m[5].toString(), m[6], m[7].toString(), m[8], m[9], attendeesList, m[11], m[12], m[13], m[14],
						m[15], null, null, null, m[19].toString(), m[20], m[21], discussionPointsList, m[23], m[24],
						m[25], m[26], null, null, m[27], m[28], null,m[30]);

				rs.add(assignSkill);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editMeetingInfo ends");
		return response;
	}

	// deleteTaskDetails

	/*
	 * delete
	 */

	public ResponseEntity<JsonResponse<Object>> deleteMeetingDetails(String id) {
		logger.info("Method : deleteMeetingDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		logger.info("ID...." + id);
		if (validity)
			try {

				// String value = "SET @p_taskId='" + id + "';";
				String value = "SET  @p_meetingId='(" + id + ")';";
				logger.info(value);

				em.createNamedStoredProcedureQuery("crm_meeting").setParameter("actionType", "deleteMeetingDetails")
						.setParameter("actionValue", value).execute();

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :  deleteMeetingDetails ends");
		logger.info("DELETE" + response);
		return response;
	}

}
