package nirmalya.aatithya.restmodule.pipeline.dao;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateContactParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateemployeemasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.EmployeeDocumentModel;
import nirmalya.aatithya.restmodule.mailservice.EmailAttachmentSender;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmMeetingModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class RestCrmContactDao {
	Logger logger = LoggerFactory.getLogger(RestCrmContactDao.class);
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
	 * DAO Function to add pipeline
	 *
	 */

	public JsonResponse<Object> addContact(RestContactModel contact) {
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values = GenerateContactParameter.getAddContactParam(contact);
				logger.info("Values----------------------" + values);
				if (contact.getPipelineId() == null || contact.getPipelineId() == "") {
					logger.info("add=============");

					em.createNamedStoredProcedureQuery("crm_contact").setParameter("actionType", "addContact")
							.setParameter("actionValue", values).execute();

				} else {
					logger.info("update=============");
					em.createNamedStoredProcedureQuery("crm_contact").setParameter("actionType", "modifyContact")
							.setParameter("actionValue", values).execute();

				}
			} catch

			(Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		logger.info("@@@@@" + resp);

		logger.info("Method : addContact ends");
		return resp;
	}

////view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> viewContactSearchDetails(RestContactModel contactDetails) {

		logger.info("Method in Dao: viewLeadSearchDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		// JsonResponse<Object> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestContactModel> rs = new ArrayList<RestContactModel>();
		try {
			String values = GenerateContactParameter.getContactParam(contactDetails);
			logger.info(values);

			String actionType = null;
			String actionValue = null;

			if (values != null && values != "") {
				actionType = "getContactDetailsBySearch";
				actionValue = values;
			} else {
				actionType = "getContactDetails";
				actionValue = "";
			}

			logger.info("Action Type====" + actionType);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact").setParameter("actionType", actionType)
					.setParameter("actionValue", actionValue).getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				Object birthDate = null;
				if (m[13] != null) {
					birthDate = m[13].toString();
				}
				logger.info("VIEWWWWWWWWWWWW");
				RestContactModel reqEdit = new RestContactModel(null, m[0], m[1], m[2], m[3], null, m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], birthDate, m[14], m[15], m[16], m[17], m[18], m[19],
						m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31],
						m[32].toString(), m[33], m[34], null, null);
				logger.info("VIEWWDATA" + reqEdit);

				rs.add(reqEdit);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : viewLeadInfo ends");
		return response;
	}

	/*
	 * View Pipeline
	 * 
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse viewAllContact(String pageno, String userId, String orgName, String orgDivision) {
		logger.info("Method : viewAllContact starts");
		JsonResponse jsonResp = new JsonResponse();

		// String value = "SET @p_pageno='" + pageno + "';";
		String value = "SET @p_pageno='" + pageno + "',@p_userId='" + userId + "',@org='" + orgName + "',@orgDiv='"
				+ orgDivision + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewAllContact").setParameter("actionValue", value).getResultList();

			jsonResp.setBody(x);
			System.out.print(jsonResp + "@@@@@@@@@@@@@@@@@@@");
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				jsonResp.setCode(err[0]);
				jsonResp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		logger.info("Method : viewAllContact ends");
		return jsonResp;
	}

	// RestContactModel

	/*
	 * Edit Pipeline
	 *
	 *
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<RestContactModel> editContact(String id, String org, String orgDiv) {
		logger.info("Method : editContact starts");

		RestContactModel req = new RestContactModel();
		JsonResponse<RestContactModel> resp = new JsonResponse<RestContactModel>();

		try {

			String value = "SET @p_contactId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			logger.info("value------------" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewEditContact").setParameter("actionValue", value).getResultList();
			logger.info(id);

			for (Object[] m : x) {
				Object createdDate = null;
				if (m[34] != null) {
					createdDate = m[34].toString();
				}

				Object birthDate = null;
				if (m[15] != null) {
					birthDate = m[15].toString();
				}
				RestContactModel reqEdit = new RestContactModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], birthDate, m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31], m[32], m[33], createdDate,
						null, null, m[35], null);

				req = reqEdit;

			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editContact ends");
		logger.info("EDITTTTT=======" + resp);
		return resp;
	}

	// view

	@SuppressWarnings("unchecked")
	public JsonResponse<RestContactModel> viewContact(String id, String org, String orgDiv) {
		logger.info("Method : viewContact starts");

		RestContactModel req = new RestContactModel();
		JsonResponse<RestContactModel> resp = new JsonResponse<RestContactModel>();

		try {

			String value = "SET @p_contactId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			logger.info("value------------" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewContactDetails").setParameter("actionValue", value)
					.getResultList();
			logger.info(id);

			for (Object[] m : x) {
				Object createdDate = null;
				if (m[34] != null) {
					createdDate = m[34].toString();
				}

				Object birthDate = null;
				if (m[15] != null) {
					birthDate = m[15].toString();
				}
				RestContactModel reqEdit = new RestContactModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], birthDate, m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31], m[32], m[33], createdDate,
						null, null, null, m[35], null, m[36],m[37], m[38],m[39],m[40],m[41]);

				req = reqEdit;

			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method :  ends");
		return resp;
	}

	// getLeadSourceList

	/**
	 * for getOwnerList
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLeadSourceList() {

		logger.info("Method : getOwnerList starts");

		List<DropDownModel> leadSourceList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "getLeadSourceList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				leadSourceList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getOwnerList ends" + leadSourceList);

		return leadSourceList;
	}

	// deleteContactDetails
	
	/*
	 * delete
	 */

	
	public ResponseEntity<JsonResponse<Object>> deleteContactDetails(String id, String orgName, String orgDiv) {
		logger.info("Method : deleteContactDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("ID...." + id);
		if (validity)
			try {

				String value = "SET  @p_contactId='(" + id + ")',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

				logger.info("value------------------" + value);

				em.createNamedStoredProcedureQuery("crm_contact").setParameter("actionType", "deleteContactDetails")
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

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method :  deleteContactDetails ends");
		logger.info("DELETE" + response);
		return response;
	}

	/*
	 * cust getAccountNameAutoSearchNewList
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getAccountNameAutoSearchNewList(String id,String userId) {
		logger.info("Method : getAccountNameAutoSearchNewList starts");

		List<RestSaleOrderNewModel> itemNameList = new ArrayList<RestSaleOrderNewModel>();
		JsonResponse<List<RestSaleOrderNewModel>> resp = new JsonResponse<List<RestSaleOrderNewModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_userId='" + userId + "';";
		logger.info("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "getAccountSearchList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				RestSaleOrderNewModel dropDownModel = new RestSaleOrderNewModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>>(
				resp, HttpStatus.CREATED);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : getAccountNameAutoSearchNewList ends");
		return response;
	}

	// viewLeadTaskInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> viewContactTaskInfo(String id, String org,
			String orgDiv) {
		logger.info("Method : viewContactTaskInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmTaskModel>> resp = new JsonResponse<List<RestCrmTaskModel>>();
		List<RestCrmTaskModel> rs = new ArrayList<RestCrmTaskModel>();

		try {

			String value = "SET @p_contactId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewContactTaskInfo").setParameter("actionValue", value)
					.getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				RestCrmTaskModel assignSkill = new RestCrmTaskModel(m[0].toString(), m[1], m[2], m[3], m[4].toString(),
						m[5], m[6], m[7], m[8], null, null, null, null, null, null, null, null, null,null);

				rs.add(assignSkill);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmTaskModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewContactTaskInfo ends");
		return response;
	}

	// viewLeadCallInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmCallModel>>> viewContactCallInfo(String id, String org,
			String orgDiv) {
		logger.info("Method : viewContactCallInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmCallModel>> resp = new JsonResponse<List<RestCrmCallModel>>();
		List<RestCrmCallModel> rs = new ArrayList<RestCrmCallModel>();

		try {

			String value = "SET @p_contactId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewContactCallInfo").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestCrmCallModel assignSkill = new RestCrmCallModel(m[0].toString(), m[1], m[2], m[3], m[4], m[5],
						m[6].toString(), m[7], m[8], m[9],m[10],m[11]);

				rs.add(assignSkill);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmCallModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmCallModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewContactCallInfo ends");
		return response;
	}

	// viewLeadMeetingInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> viewContactMeetingInfo(String id, String org,
			String orgDiv) {
		logger.info("Method : viewLeadMeetingInfo starts----------------------------");
		JsonResponse<List<RestCrmMeetingModel>> resp = new JsonResponse<List<RestCrmMeetingModel>>();
		List<RestCrmMeetingModel> rs = new ArrayList<RestCrmMeetingModel>();

		try {

			String value = "SET @p_contactId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewContactMeetingInfo").setParameter("actionValue", value)
					.getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				RestCrmMeetingModel assignSkill = new RestCrmMeetingModel(m[0].toString(), m[1], m[2], m[3], m[4],
						m[5].toString(), m[6], m[7].toString(), m[8], m[9], m[10], m[11]);

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

		logger.info("Method : viewContactMeetingInfo ends");
		return response;
	}

	// view Contact Deals

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestDealModel>>> restViewDealContact(String id, String org, String orgDiv) {
		logger.info("Method : restViewDealContact ---------->>>>>>>>>>starts");
		List<RestDealModel> respList = new ArrayList<RestDealModel>();

		try {

			String value = "SET @p_dealId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal")
					.setParameter("actionType", "getContactDeals").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestDealModel restPayroll = new RestDealModel(m[0], m[1], m[2], m[3], m[4].toString(), m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15].toString(), null, null, null, null, m[16],
						m[17]);
				respList.add(restPayroll);

			}

			logger.info("VIEW DETAILS FOR DEALS-------" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestDealModel>> resp = new JsonResponse<List<RestDealModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestDealModel>>> response = new ResponseEntity<JsonResponse<List<RestDealModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : restViewDealContact ends");

		logger.info("view response" + respList);
		return response;

	}

	// deals upcoming actions

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestDealModel>>> getDealsActions(String id, String org, String orgDiv) {
		logger.info("Method : getDealsActions ---------->>>>>>>>>>starts");
		List<RestDealModel> respList = new ArrayList<RestDealModel>();

		try {

			String value = "SET @p_Id='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal")
					.setParameter("actionType", "getDealsAction").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestDealModel restPayroll = new RestDealModel(m[0], m[1], m[2], m[3], m[4], null, null, m[7], null,
						null,null);
				respList.add(restPayroll);

			}

			logger.info("VIEW DETAILS FOR DEALS-------" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestDealModel>> resp = new JsonResponse<List<RestDealModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestDealModel>>> response = new ResponseEntity<JsonResponse<List<RestDealModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : getDealsActions ends");

		logger.info("view response" + respList);
		return response;

	}

	// viewLeadCampaignInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> viewContactCampaignInfo(String id, String org,
			String orgDiv) {
		logger.info("Method : viewContactCampaignInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmCampaignModel>> resp = new JsonResponse<List<RestCrmCampaignModel>>();
		List<RestCrmCampaignModel> rs = new ArrayList<RestCrmCampaignModel>();

		try {

			String value = "SET @p_contactId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewContactCampaignInfo").setParameter("actionValue", value)
					.getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				RestCrmCampaignModel assignSkill = new RestCrmCampaignModel(m[0].toString(), m[1], m[2], m[3], m[4],
						m[5].toString(), m[6].toString(), m[7].toString(),m[8].toString(), m[9].toString(), m[10], m[11], m[12], m[13], null);

				rs.add(assignSkill);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewContactCampaignInfo ends");
		return response;
	}

///////////////////////////////////////////////////////////////////

	public ResponseEntity<JsonResponse<Object>> addContactEmailDoc(EmployeeDocumentModel employeeDocumentModel) {
		logger.info("Method : addNoteDoc starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = GenerateemployeemasterParameter.addContactMailDtls(employeeDocumentModel);
			List<String> toAddress = new ArrayList<>();
			toAddress.add(employeeDocumentModel.getToMail());

			String addCc = employeeDocumentModel.getCcMail();
			List<String> ccAddress = (addCc != null && !addCc.isEmpty()) ? Arrays.asList(addCc.split(",")) : null;
			System.out.println("CC Mail"+ccAddress);

			String addBcc = employeeDocumentModel.getBccMail();
			List<String> bccAddress = (addBcc != null && !addBcc.isEmpty()) ? Arrays.asList(addBcc.split(",")) : null;
			System.out.println("CC Mail"+bccAddress);

			String subject = employeeDocumentModel.getMailSubject();
			String message1 = employeeDocumentModel.getCommentck();
			
			String documentAction = null;
			String documentName = null;

			if (employeeDocumentModel.getDocumentList() != null && !employeeDocumentModel.getDocumentList().isEmpty()) {
			    documentAction = employeeDocumentModel.getDocumentList().get(0).getAction();
			    documentName = employeeDocumentModel.getDocumentList().get(0).getDocumnentName();
			}


			try {
				EmailAttachmentSender.sendEmailWithAttachmentsURLS(host,port,username,password, toAddress, ccAddress, bccAddress, subject, message1,documentAction, documentName);

				Boolean status = em.createNamedStoredProcedureQuery("crm_contact")
						.setParameter("actionType", "addContactEmailDoc").setParameter("actionValue", value).execute();
				if (status) {
					resp.setCode("Success");
					resp.setMessage("Email Sent Successfully.");
				}
			} catch (Exception e) {
				logger.error("Error sending email with attachments", e);
				resp.setMessage("Error sending email with attachments");
				resp.setCode("Failed");
			}

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
		logger.info("Method : add item addContactEmailDoc ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addContactDraftDoc(EmployeeDocumentModel employeeDocumentModel) {
		logger.info("Method : addContactDraftDoc starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = GenerateemployeemasterParameter.addContactMailDraftDtls(employeeDocumentModel);
			
			if (employeeDocumentModel.getDraftId() != null && !employeeDocumentModel.getDraftId().isEmpty()) {
			   System.out.println("value for draft--------->"+value);
			    em.createNamedStoredProcedureQuery("crm_contact")
			        .setParameter("actionType", "modifyDraftDoc")
			        .setParameter("actionValue", value)
			        .execute();
			} else {
			    logger.info("Add=============");
			    em.createNamedStoredProcedureQuery("crm_contact")
			        .setParameter("actionType", "addContactDraftDoc")
			        .setParameter("actionValue", value)
			        .execute();
			}


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
		logger.info("Method : add addContactDraftDoc ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductMasterModel>>> getProductSKUListing(String type, String orgName,
			String orgDiv) {
		logger.info("Method : getProductSKUListing starts");

		List<ProductMasterModel> locationList = new ArrayList<ProductMasterModel>();
		JsonResponse<List<ProductMasterModel>> resp = new JsonResponse<List<ProductMasterModel>>();
		String value = "SET @P_type='" + type + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewProductList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object CREATEDON = null;
				if (m[9] != null) {
					CREATEDON = DateFormatter.returnStringDate(m[9]);
				}
				ProductMasterModel dropDownModel = new ProductMasterModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], CREATEDON);
				locationList.add(dropDownModel);
			}
			resp.setBody(locationList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ProductMasterModel>>> response = new ResponseEntity<JsonResponse<List<ProductMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProductSKUListing ends" + response);
		return response;
	}

	@SuppressWarnings("rawtypes")
	public JsonResponse addQuotation(String quotId, String contactId, String org, String orgDiv,String userId) {
		logger.info("Method : addQuotation starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @quotId='" + quotId + "',@contactId='" + contactId + "',@p_orgName='" + org
				+ "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		logger.info("value===" + value);
		try {
			em.createNamedStoredProcedureQuery("crm_contact").setParameter("actionType", "addQuotation")
					.setParameter("actionValue", value).execute();
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
		}

		logger.info("Method : addQuotation ends");
		return resp;
	}

	public JsonResponse addSalesOrder(String salesOrderId, String contactId, String custId, String org, String orgDiv,String userId) {
		logger.info("Method : addSalesOrder starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_salesOrderId='" + salesOrderId + "',@p_custId='" + custId + "',@p_contactId='"
				+ contactId + "',@p_orgName='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		logger.info("value===" + value);
		try {
			em.createNamedStoredProcedureQuery("crm_contact").setParameter("actionType", "addSalesOrder")
					.setParameter("actionValue", value).execute();
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
		}

		logger.info("Method : addSalesOrder ends");
		return resp;
	}

	public JsonResponse addPurchaseOrder(String quotId, String contactId, String org, String orgDiv, String referenceId,
			String poNo, String custId, String orderType,String userId) {
		logger.info("Method : addPurchaseOrder starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @quotId='" + quotId + "', @contactId='" + contactId + "', @p_orgName='" + org
				+ "', @p_orgDiv='" + orgDiv + "', " + "@p_referenceId='" + referenceId + "', @p_poNo='" + poNo
				+ "', @p_custId='" + custId + "', @p_orderType='" + orderType + "',@p_userId='" + userId + "';";

		logger.info("value===" + value);
		try {
			em.createNamedStoredProcedureQuery("crm_contact").setParameter("actionType", "addPurchaseOrder")
					.setParameter("actionValue", value).execute();
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
		}

		logger.info("Method : addPurchaseOrder ends");
		return resp;
	}

	public JsonResponse addInvoice(String saleInvoice, String custId, String invoiceDate, String contactId, String org,
			String orgDiv,String userId) {
		logger.info("Method : addInvoice starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_saleInvoice='" + saleInvoice + "',@p_custId='" + custId + "',@p_invoiceDate='"
				+ invoiceDate + "',@p_contactId='" + contactId + "',@p_orgName='" + org + "',"
						+ "@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			em.createNamedStoredProcedureQuery("crm_contact").setParameter("actionType", "addInvoice")
					.setParameter("actionValue", value).execute();
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
		}

		logger.info("Method : addInvoice ends");
		return resp;
	}

}
