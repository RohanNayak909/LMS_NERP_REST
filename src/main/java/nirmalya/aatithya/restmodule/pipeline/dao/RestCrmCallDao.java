package nirmalya.aatithya.restmodule.pipeline.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCallParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.mailservice.EmailCalendarEvent;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;

@Repository
public class RestCrmCallDao {

	Logger logger = LoggerFactory.getLogger(RestCrmCallDao.class);
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
    
	// addTask

	/**
	 * DAO Function to add pipeline
	 *
	 */
	/*
	 * Use Uid to uniquely identify calendar email for modify and cancel purpose
	 */
	private static final String uid = UUID.randomUUID().toString();

	public JsonResponse<Object> addCall(RestCrmCallModel call) {
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values = GenerateCallParameter.getAddCallParam(call);
				logger.info("Values for add task----------------------" + values);
				if (call.getCallId() == null || call.getCallId() == "") {
					logger.info("add=============" + call.getCallId());

					String pageTypeContact = "Contact";
					String pageTypeLead = "Lead"; 
					String pageTypeAccount = "Account";
					String pageTypeDeal = "Deal";
					String pageTypeCall = "Call";

					String pageTypeQuote = "Quote";
					String pageTypeSO = "SalesOrder";
					String pageTypePO = "PurchaseOrder";
					String pageTypeInvoice = "Invoice";

					String pageType = call.getPageType();
   
					logger.info("llllllllll"+pageType);	
					
					if (pageType.equals(pageTypeCall)) {

						if (call.getLeadId() == null || call.getLeadId() == "") {

							logger.info("Executing actionType: addCallContactType");
							em.createNamedStoredProcedureQuery("crm_call")
									.setParameter("actionType", "addCallContactType")
									.setParameter("actionValue", values).execute();
						} else {
							logger.info("Executing actionType-----: addLeadType");
							em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadType")
									.setParameter("actionValue", values).execute();
						}

					}

					if (pageType.equals(pageTypeLead)) {
						if (call.getLeadId() == null || call.getLeadId() == "") {
							logger.info("Executing actionType: addCallContactTypeL");
							em.createNamedStoredProcedureQuery("crm_call")
									.setParameter("actionType", "addCallContactTypeL")
									.setParameter("actionValue", values).execute();
						} else {
							logger.info("Executing actionType------: addCallContactTypeL");
							em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeL")
									.setParameter("actionValue", values).execute();
						}
					}

					if (pageType.equals(pageTypeContact)) {
						logger.info("valuee"+values);
						if (call.getLeadId() == null || call.getLeadId() == "") {
							logger.info("Executing actionType: addCallContactTypeC");
							em.createNamedStoredProcedureQuery("crm_call")
									.setParameter("actionType", "addCallContactTypeC")
									.setParameter("actionValue", values).execute();
						} else {
							logger.info("Executing actionType------: addLeadTypeC");
							em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeC")
									.setParameter("actionValue", values).execute();
						}
					}

					if (pageType.equals(pageTypeAccount)) {
						if (call.getLeadId() == null || call.getLeadId() == "") {
							logger.info("Executing actionType: addCallContactTypeA");
							em.createNamedStoredProcedureQuery("crm_call")
									.setParameter("actionType", "addCallContactTypeA")
									.setParameter("actionValue", values).execute();
						} else {
							logger.info("Executing actionType--------: addCallContactTypeA");
							em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeA")
									.setParameter("actionValue", values).execute();
						}
					}

					if (pageType.equals(pageTypeDeal)) {
						if (call.getLeadId() == null || call.getLeadId() == "") {
							logger.info("Executing actionType: addCallContactTypeD");
							em.createNamedStoredProcedureQuery("crm_call")
									.setParameter("actionType", "addCallContactTypeD")
									.setParameter("actionValue", values).execute();
						} else {
							logger.info("Executing actionType---------: addCallContactTypeD");
							em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeD")
									.setParameter("actionValue", values).execute();
						}
					}

					if (pageType.equals(pageTypeQuote)) {
						if (call.getLeadId() == null || call.getLeadId() == "") {
							logger.info("Executing actionType: addCallContactTypeQ");
							em.createNamedStoredProcedureQuery("crm_call")
									.setParameter("actionType", "addCallContactTypeQ")
									.setParameter("actionValue", values).execute();
						} else {
							logger.info("Executing actionType----------: addCallContactTypeQ");
							em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeQ")
									.setParameter("actionValue", values).execute();
						}
					}

					if (pageType.equals(pageTypeSO)) {
						if (call.getLeadId() == null || call.getLeadId() == "") {
							logger.info("Executing actionType: addCallContactTypeS");
							em.createNamedStoredProcedureQuery("crm_call")
									.setParameter("actionType", "addCallContactTypeS")
									.setParameter("actionValue", values).execute();
						} else {
							logger.info("Executing actionType---------: addCallContactTypeS");
							em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeS")
									.setParameter("actionValue", values).execute();
						}
					}

					if (pageType.equals(pageTypePO)) {
						if (call.getLeadId() == null || call.getLeadId() == "") {
							logger.info("Executing actionType: addCallContactTypeP");
							em.createNamedStoredProcedureQuery("crm_call")
									.setParameter("actionType", "addCallContactTypeP")
									.setParameter("actionValue", values).execute();
						} else {
							logger.info("Executing actionType------: addCallContactTypeP");
							em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeP")
									.setParameter("actionValue", values).execute();
						}
					}

					if (pageType.equals(pageTypeInvoice)) {
						if (call.getLeadId() == null || call.getLeadId() == "") {
							logger.info("Executing actionType: addCallContactTypeI");
							em.createNamedStoredProcedureQuery("crm_call")
									.setParameter("actionType", "addCallContactTypeI")
									.setParameter("actionValue", values).execute();
						} else {
							logger.info("Executing actionType-----: addCallContactTypeI");
							em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "addLeadTypeI")
									.setParameter("actionValue", values).execute();
						}
					}
				//	callsMail(call,resp, uid);
					
				}

				else {
					logger.info("modify=========================================modifyCallDetails");
					em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "modifyCallDetails")
							.setParameter("actionValue", values).execute();
					
					callsMail(call,resp, "");
				}
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode("Failed");
					resp.setMessage(err[1]);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		logger.info("@@@@@" + resp);

		logger.info("Method : addCallDao ends");
		return resp;
	}
	
	public JsonResponse<Object> callsMail(RestCrmCallModel call, JsonResponse<Object> resp, String uid) {
	    
	    String addTomail = call.getToMail();
	    List<String> toAddress = (addTomail != null && !addTomail.isEmpty()) ? Arrays.asList(addTomail.split(",")) : null;
	    System.out.println("TO Mail Address Printed value" + addTomail);

	    String addCc = call.getCcMail();
	    List<String> ccAddress = (addCc != null && !addCc.isEmpty()) ? Arrays.asList(addCc.split(",")) : null;
	    System.out.println("CC Mail Address Printed value" + addCc);

	    String addBcc = call.getExcutiveMail();
	    List<String> bccAddress = (addBcc != null && !addBcc.isEmpty()) ? Arrays.asList(addBcc.split(",")) : null;
	    System.out.println("Bcc Mail Address Printed value" + addBcc);

	    String subject = call.getCallSubject();
	    
	    //String location = callModel.getMeetingLocation();

	    String desc = call.getCallAgenda();

	   
	    
	    String fromDateTime = call.getCallStartDate() + " "
				+ call.getCallStartTime() + ":00";
	    
	    String toDateTime = call.getCallStartDate() + " "
				+ call.getCallEndTime() + ":00";
	 
        
	   EmailCalendarEvent emailEvent = new EmailCalendarEvent();
		/*
		 * logger.info("subject"+subject); logger.info("username"+username);
		 * logger.info("password"+password); logger.info("toAddress"+toAddress);
		 * logger.info("host"+host); logger.info("port"+port);
		 * logger.info("Bhubaneswar"); logger.info("subject"+subject);
		 * logger.info("desc"+desc); logger.info("fromDateTime"+fromDateTime);
		 * logger.info("toDateTime"+toDateTime); logger.info("ccAddress"+ccAddress);
		 * logger.info("bccAddress"+bccAddress); logger.info("uid"+uid);
		 */
	
	
		try {
			emailEvent.send(subject, username, password, toAddress, host, port, "Bhubaneswar",
					subject, desc, fromDateTime, toDateTime,ccAddress,bccAddress, uid);
			
		
			resp.setMessage("Success");
		    resp.setCode("Success");
		} catch (Exception e) {
		    logger.error("Error sending email with attachments", e);
		    resp.setMessage("Error sending email with attachments");
		    resp.setCode("Failed");
		}
        
        return resp;
	}

	/// restViewTaskdetails

////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmCallModel>>> restViewCallDetails(String pageno,String userId,String orgName,String orgDivision) {
		logger.info("Method : restViewCallDetails starts");
		List<RestCrmCallModel> respList = new ArrayList<RestCrmCallModel>();

		String value = "SET @p_pageno='" + pageno + "',@p_userId='" + userId + "',"
				+ "@org='" + orgName + "',@orgDiv='" + orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call")
					.setParameter("actionType", "getCallDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				if (m[8] == null) {
					m[8] = "";
				}

				if (m[9] == null) {
					m[9] = "";
				}

				if (m[10] == null) {
					m[10] = "";
				}

				RestCrmCallModel restPayroll = new RestCrmCallModel(m[0].toString(), m[1], m[2], m[3], m[4], m[5], m[6],
						m[7].toString(), m[8].toString(), m[9], m[10], m[11], m[12].toString(), m[13].toString(),m[14].toString());
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestCrmCallModel>> resp = new JsonResponse<List<RestCrmCallModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCrmCallModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmCallModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewLeadData ends");

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}

	

	/// editAccountInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmCallModel>>> editCallInfo(String id) {
		logger.info("Method : editTaskInfo starts");

		JsonResponse<List<RestCrmCallModel>> resp = new JsonResponse<List<RestCrmCallModel>>();
		List<RestCrmCallModel> rs = new ArrayList<RestCrmCallModel>();

		try {

			String value = "SET @p_callId='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "editCallInfo")
					.setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {
				RestCrmCallModel restPayroll = new RestCrmCallModel(m[0].toString(), m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9].toString(), m[10], m[11].toString(), m[12].toString(), m[13].toString(),
						m[14].toString(), m[15].toString(), m[16].toString(), m[17].toString(), m[18],
						m[19].toString(),m[20],m[21],m[22],m[23],m[24]);

				rs.add(restPayroll);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmCallModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmCallModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editCallInfo ends");
		return response;
	}

	// deleteTaskDetails

	/*
	 * delete
	 */

	public ResponseEntity<JsonResponse<Object>> deleteCallDetails(String id) {
		logger.info("Method : deleteCallDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		logger.info("ID...." + id);
		if (validity)
			try {

				// String value = "SET @p_taskId='" + id + "';";
				String value = "SET  @p_callId='(" + id + ")';";
				logger.info(value);

				em.createNamedStoredProcedureQuery("crm_call").setParameter("actionType", "deleteCallDetails")
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

		logger.info("Method :  deleteCallDetails ends");
		logger.info("DELETE" + response);
		return response;
	}

	// AutoSearch

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getNameAutoSearchList(String id,String userId) {
		logger.info("Method : getNameAutoSearchList starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_userId='" + userId + "';";

		try {
			logger.info("VALUE" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call")
					.setParameter("actionType", "autosearchCall").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method : getNameAutoSearchList ends");
		logger.info("AUTODATAAA" + response);
		return response;
	}

	// AutoSearch

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getNameAutoSearchListContact(String id,String userId) {
		logger.info("Method : getNameAutoSearchListContact starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_userId='" + userId + "'";

		try {
			logger.info("VALUE" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call")
					.setParameter("actionType", "getNameAutoSearchListContact").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method : getNameAutoSearchListContact ends");
		logger.info("AUTODATAAA" + response);
		return response;
	}
	
	//get account data from contact onchange
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAccountData(String id) {
		logger.info("Method : getAccountData starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_Id=\"" + id + "\";";

		try {
			logger.info("VALUE" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call")
					.setParameter("actionType", "getAccountOnContact").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : getAccountData ends");
		logger.info("AUTODATAAA" + response);
		return response;
	}

	// AutoSearch

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getNameAutoSearchDetailsRelated(String searchValue,
			String id) {
		logger.info("Method : getNameAutoSearchDetailsRelated starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue=\"" + searchValue + "\", @p_Id=\"" + id + "\";";

		try {
			logger.info("VALUE" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call")
					.setParameter("actionType", "getNameAutoSearchDetailsRelated").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getNameAutoSearchDetailsRelated ends");
		logger.info("AUTODATAAA" + response);
		return response;
	}

	// AutoSearch For Both Lead and Contact

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAutosearchData(String id, String searchId,
			String type) {
		logger.info("Method : getAutosearchData starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		
		String value = "SET @p_searchValue=\"" + id + "\",@p_searchId=\"" + searchId + "\",@p_type=\"" + type + "\";";

		System.out.println(value + "MY TYPE---------------");
		if (type.equals("Lead1")) {
			try {
				System.out.println(value + "---------------");

				logger.info("VALUE" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call")
						.setParameter("actionType", "getNameAutoSearchList").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2]);
					itemNameList.add(dropDownModel);
				}
				resp.setBody(itemNameList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (type.equals("Contact1")) {
			try {
				System.out.println(value + "---------------");
				logger.info("VALUE" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call")
						.setParameter("actionType", "getNameAutoSearchListContact").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2]);
					itemNameList.add(dropDownModel);
				}
				resp.setBody(itemNameList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (type.equals("excutive")) {
			try {
				System.out.println(value + "---------------");
				logger.info("VALUE" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call")
						.setParameter("actionType", "getSearchListExecutive").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2]);
					itemNameList.add(dropDownModel);
				}
				resp.setBody(itemNameList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method : getAutosearchData ends");
		logger.info("AUTODATAAA" + response);
		return response;
	}
	
	/**
	 * Autosearching for mail
	 * **/
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getMailAutoSeaarch(String id) {
		logger.info("Method : getMailAutoSeaarch starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		
		String value = "SET @p_searchValue=\"" + id + "\";";

		System.out.println(value + "MY TYPE---------------");
		
			try {
				System.out.println(value + "---------------");

				logger.info("VALUE" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call")
						.setParameter("actionType", "getMailAutoSeaarch").setParameter("actionValue", value)
						.getResultList();
				
				System.out.println(x.size() + "---------------");
				for (Object m : x) {
					System.out.println("----------------------->>>>>>>>>>>"+m.toString());
					
					DropDownModel dropDownModel = new DropDownModel(m);
					itemNameList.add(dropDownModel);
				}
				resp.setBody(itemNameList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method : getMailAutoSeaarch ends");
		logger.info("AUTODATAAA" + response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllAttendees(String hostId,String orgName, String orgDiv) {
		logger.info("Method : getAllAttendees Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_hostId='" + hostId+ "';";
			System.out.println("getAllAttendees========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_call")
					.setParameter("actionType", "getAllAttendees").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllAttendees Dao ends" + resp);
		return resp;

	}

}
