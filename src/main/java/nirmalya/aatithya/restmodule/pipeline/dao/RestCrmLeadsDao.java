package nirmalya.aatithya.restmodule.pipeline.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCrmLeadDetails;
import nirmalya.aatithya.restmodule.common.utils.GenerateManageCrmLeadParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateemployeemasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateCustomerNewParameter;
import nirmalya.aatithya.restmodule.employee.model.EmployeeDocumentModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.RestCustoomerNewModel;
import nirmalya.aatithya.restmodule.user.dao.UserLoginDao;
import nirmalya.aatithya.restmodule.pipeline.model.AdminTaskAssignRestModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmActivityModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmMeetingModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmProductModel;

@Repository
public class RestCrmLeadsDao {

	Logger logger = LoggerFactory.getLogger(RestCrmLeadsDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * for department list
	 * 
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLeadList() {

		logger.info("Method : getLeadList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getLeadList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLeadList ends" + employmentList);

		return employmentList;
	}

	/**
	 * for department list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getindustrylist() {

		logger.info("Method : getindustrylist starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getindustrylist").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getindustrylist ends" + employmentList);

		return employmentList;
	}

	/**
	 * for department list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRatingList() {

		logger.info("Method : getRatingList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getRatingList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getRatingList ends" + employmentList);

		return employmentList;
	}

	/**
	 * for department list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDocumentList() {

		logger.info("Method : getDocumentList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getDocumentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDocumentList ends" + employmentList);

		return employmentList;
	}

////view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> viewLeadSearchDetails(RestCrmLeadsModel leadDetails) {

		logger.info("Method in Dao: viewLeadSearchDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();
		try {
			String values = GenerateCrmLeadDetails.CrmLeadParam(leadDetails);
			logger.info(values);

			String actionType = null;
			String actionValue = null;

			if (values != null && values != "") {
				actionType = "getDetailsBySearch";
				actionValue = values;
			} else {
				actionType = "getDetails";
				actionValue = "";
			}

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", actionType).setParameter("actionValue", actionValue).getResultList();

			for (Object[] m : x) {
				RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29].toString(), m[30], m[31], m[32], null,
						null, null, null, m[33], m[34], null, null, null, null, null, null, null);
				rs.add(assignSkill);

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

	/**
	 * for department list
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountry() {

		logger.info("Method : getCountry starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getCountry").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountry ends" + employmentList);

		return employmentList;
	}

	// getLeadStatusList
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLeadStatusList() {

		logger.info("Method : getLeadStatusList starts");

		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getLeadStatusList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLeadStatusList ends" + employmentList);

		return employmentList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getcuststateListNew(String id) {

		logger.info("Method : getcuststateListNew starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_country='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getStateList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getcuststateListNew ends");
		return response;
	}

	/*
	 * for add new assignSkill
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> restAddLeadDetails(RestCrmLeadsModel leadDetails) {

		logger.info("Method in Dao: restAddLeadDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();
		System.out.println("Lead Details========>" + leadDetails);

		try {
			String values = GenerateCrmLeadDetails.generateCrmLeadParam(leadDetails);
			if (leadDetails.getStatusUpdatedFrom().equals("leadDetailsPage")) {
				if (leadDetails.getLeadId() != "" && leadDetails.getLeadId() != null
						&& leadDetails.getAdminApprvStatus() && leadDetails.getLeadStatus().equals("TLSM00004")) {
					String sqlVal = "SET @leadId='" + leadDetails.getLeadId() + "', @org='"
							+ leadDetails.getOrganization() + "', @orgDiv='" + leadDetails.getOrgDivision()
							+ "',@p_createdTime='" + dateString + "';";
					System.out.println("LEADDETAILSPAGE========>" + sqlVal);
					em.createNamedStoredProcedureQuery("crmLeads_routines")
							.setParameter("actionType", "adminApprovalRequest").setParameter("actionValue", sqlVal)
							.execute();
					resp.setMessage("Lead Modified Successfully");
					resp.setCode("Success");

				} else {
					em.createNamedStoredProcedureQuery("crmLeads_routines")
							.setParameter("actionType", "updateLeadStatus").setParameter("actionValue", values)
							.execute();
					resp.setMessage("Status Updated Sucessfully");
					resp.setCode("Success");
					System.out.println("Data For Status" + values);
				}
			} else {
				if (leadDetails.getLeadId() == "" || leadDetails.getLeadId() == null) {

					List<Object> result = em.createNamedStoredProcedureQuery("crmLeads_routines")
							.setParameter("actionType", "addLeadData").setParameter("actionValue", values)
							.getResultList();
					resp.setMessage("Lead Added Successfully");
					resp.setCode("Success");
					if (!result.isEmpty()) {
						resp.setBody(result.get(0));
					}

				} else if (leadDetails.getLeadId() != "" && leadDetails.getLeadId() != null
						&& leadDetails.getAdminApprvStatus() && leadDetails.getLeadStatus().equals("TLSM00004")) {
					System.out.println("Calling adminApprovalRequest");
					String sqlVal = "SET @leadId='" + leadDetails.getLeadId() + "', @org='"
							+ leadDetails.getOrganization() + "', @orgDiv='" + leadDetails.getOrgDivision()
							+ "',@p_createdTime='" + dateString + "';";
					em.createNamedStoredProcedureQuery("crmLeads_routines")
							.setParameter("actionType", "adminApprovalRequest").setParameter("actionValue", sqlVal)
							.execute();
					resp.setMessage("Lead Modified Successfully");
					resp.setCode("Success");
				} else {
					System.out.println("Calling modigyLeaddata");
					List<Object> result = em.createNamedStoredProcedureQuery("crmLeads_routines")
							.setParameter("actionType", "modifyLeadData").setParameter("actionValue", values)
							.getResultList();
					resp.setMessage("Lead Modified Successfully");
					resp.setCode("Success");
					if (!result.isEmpty()) {
						resp.setBody(result.get(0));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: restAddLeadDetails ends");

		return response;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse viewLeadDet(String pageno, String userId, String orgName, String orgDivision,String fromDate,String toDate) {
		logger.info("Method : viewLeadDet starts");
		JsonResponse jsonResp = new JsonResponse();

		String value = "SET @p_pageno='" + pageno + "',@p_userId='" + userId + "'," + "@p_orgName='" + orgName
				+ "',@p_orgDivision='" + orgDivision + "',@p_fromDate='"+fromDate+"',@p_todate='"+toDate+"';";
		System.out.println("Value For View Lead======>" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadDetails").setParameter("actionValue", value).getResultList();

			if (x.get(0) == null) {
				jsonResp.setCode("Failed");
				jsonResp.setMessage("No Data Found!");
			} else {
				jsonResp.setBody(x.get(0));
				jsonResp.setCode("Success");
			}

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

		logger.info("Method : viewLeadDet ends");
		return jsonResp;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse checkDuplicate(String email, String phone, String mobile, String org, String orgDiv,
			String leadid) {
		logger.info("Method : checkDuplicate starts");
		JsonResponse jsonResp = new JsonResponse();

		String value = "SET @p_email='" + email + "',@p_phone='" + phone + "'," + "@p_mobile='" + mobile + "',@org='"
				+ org + "', @orgDiv='" + orgDiv + "', @leadid='" + leadid + "';";
		System.out.println("--------&&&&&&&>>>" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadDuplicateCheck").setParameter("actionValue", value)
					.getResultList();

			jsonResp.setBody(x.get(0));
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

		logger.info("Method : checkDuplicate ends");
		return jsonResp;
	}

////edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> editLeadInfo(String id, String org, String orgDiv) {
		logger.info("Method : editLeadInfo starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();

		try {

			String value = "SET @p_leadId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "editLeadInfo").setParameter("actionValue", value).getResultList();
//			for (Object[] row : x) {
//			    System.out.println("Row:");
//			    for (int i = 0; i < row.length; i++) {
//			        System.out.println("  Column[" + i + "]: " + row[i]);
//			    }
//			}

			for (Object[] m : x) {
				RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], m[24], m[25], m[26], m[27], null, null, null, null, m[28], null, null, null, null,
						m[29], m[30], null, m[31], m[32], m[33], m[34], m[35], m[36]);
				System.out.println("Value Fetched For Edit------------->" + assignSkill);
				rs.add(assignSkill);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZ" + response.getBody());

		logger.info("Method : editLeadInfo ends");

		return response;
	}

	/// viewLeadInfo
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewLeadInfo(String id, String org, String orgDiv) {
		logger.info("Method : viewLeadInfo starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();

		try {

			String value = "SET @p_leadId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadDetailInfo").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], m[24], m[25], m[26], m[27], m[28], null, null, null, m[29], null, m[30], m[31],
						m[32], m[33], m[34], m[35], null, null, null, null, null, null);

				rs.add(assignSkill);
				resp.setMessage("Lead View Sucessfully");
				resp.setCode("Success");

			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something went wrong!");
			resp.setCode("Failed");
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewLeadInfo ends");

		return response;
	}

	// viewLeadNoteInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewLeadNoteInfo(String id, String org,
			String orgDiv) {
		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {

			String value = "SET @p_leadId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadNoteInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10].toString(), m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
						m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31], m[32]);
				rs.add(assignSkill);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewLeadNoteInfo ends");

		return response;
	}

	/// viewLeadMailInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewLeadMailInfo(String id, String org,
			String orgDiv) {
		logger.info("Method : viewLeadMailInfo starts");
		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();

		try {

			String value = "SET @p_leadId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadMailInfo").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0].toString(), m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9].toString(), m[10].toString(), m[11], null, null);

				rs.add(assignSkill);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewLeadMailInfo ends");

		return response;
	}

	// viewLeadProductInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewLeadProductInfo(String id, String userId,
			String org, String orgDiv) {
		logger.info("Method : viewLeadProductInfo starts");
		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();

		try {

			String value = "SET @p_id='" + id + "',@p_userId='" + userId + "',@org='" + org + "',@orgDiv='" + orgDiv
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadProductInfo").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0], m[1], m[2], m[3], m[4], m[5].toString());
				rs.add(assignSkill);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewLeadProductInfo ends");

		return response;
	}

	// viewLeadCampaignInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> viewLeadCampaignInfo(String id, String userId,
			String org, String orgDiv) {
		logger.info("Method : viewLeadCampaignInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmCampaignModel>> resp = new JsonResponse<List<RestCrmCampaignModel>>();
		List<RestCrmCampaignModel> rs = new ArrayList<RestCrmCampaignModel>();

		try {

			String value = "SET @p_leadId='" + id + "',@p_userId='" + userId + "',@org='" + org + "',@orgDiv='" + orgDiv
					+ "';";
			logger.info("******Lead List********" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadCampaignInfo").setParameter("actionValue", value)
					.getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				RestCrmCampaignModel assignSkill = new RestCrmCampaignModel(m[0].toString(), m[1], m[2], m[3], m[4],
						m[5].toString(), m[6].toString(), m[7], m[8], m[9], m[10], m[11], m[12], m[13], null);

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

		logger.info("Method : viewLeadCampaignInfo ends");

		return response;
	}

	// viewLeadTaskInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> viewLeadTaskInfo(String id, String org, String orgDiv) {
		logger.info("Method : viewLeadTaskInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmTaskModel>> resp = new JsonResponse<List<RestCrmTaskModel>>();
		List<RestCrmTaskModel> rs = new ArrayList<RestCrmTaskModel>();

		try {

			String value = "SET @p_leadId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";

			logger.info("Task Parameteres------>>>>>>" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadTaskInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				RestCrmTaskModel assignSkill = new RestCrmTaskModel(m[0].toString(), m[1], m[2], m[3], m[4].toString(),
						m[5], m[6], m[7], m[8], null, null, null, null, null, null, null, null, null, null);

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

		logger.info("Method : viewLeadCampaignInfo ends");

		return response;
	}

	// Get Upcoming Task Actions

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> getTaskActions(String id, String org, String orgDiv) {
		logger.info("Method : getTaskActions starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmTaskModel>> resp = new JsonResponse<List<RestCrmTaskModel>>();
		List<RestCrmTaskModel> rs = new ArrayList<RestCrmTaskModel>();

		try {

			String value = "SET @p_Id='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";

			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getTaskActions").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				RestCrmTaskModel assignSkill = new RestCrmTaskModel(m[0], m[1].toString(), m[2]);
				rs.add(assignSkill);

			}
			resp.setMessage("Actions View Sucessfully");
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
			resp.setMessage("Something went wrong!");
			resp.setCode("Failed");
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmTaskModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmTaskModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getTaskActions ends");

		return response;
	}

	// viewLeadCallInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmCallModel>>> viewLeadCallInfo(String id, String org, String orgDiv) {
		logger.info("Method : viewLeadCallInfo starts----------------------------");
		logger.info("call-----------------------------------------------------------------");
		JsonResponse<List<RestCrmCallModel>> resp = new JsonResponse<List<RestCrmCallModel>>();
		List<RestCrmCallModel> rs = new ArrayList<RestCrmCallModel>();

		try {

			String value = "SET @p_leadId='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadCallInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				if (m[1] == null) {
					m[1] = "";
				}
				if (m[2] == null) {
					m[2] = "";
				}
				if (m[3] == null) {
					m[3] = "";
				}
				if (m[4] == null) {
					m[4] = "";
				}
				if (m[5] == null) {
					m[5] = "";
				}
				if (m[6] == null) {
					m[6] = "";
				}
				if (m[7] == null) {
					m[7] = "";
				}
				if (m[8] == null) {
					m[8] = "";
				}
				if (m[9] == null) {
					m[9] = "";
				}
				RestCrmCallModel assignSkill = new RestCrmCallModel(m[0].toString(), m[1], m[2], m[3], m[4], m[5],
						m[6].toString(), m[7], m[8], m[9], m[10], m[11]);

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

		logger.info("Method : viewLeadCallInfo ends");

		return response;
	}

	// viewLeadActivityInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmActivityModel>>> viewLeadActivityInfo(String id, String type,
			String org, String orgDiv) {
		logger.info("Method : viewLeadActivityInfo starts----------------------------");
		JsonResponse<List<RestCrmActivityModel>> resp = new JsonResponse<List<RestCrmActivityModel>>();
		List<RestCrmActivityModel> rs = new ArrayList<RestCrmActivityModel>();

		try {

			String value = "SET @p_id='" + id + "',@p_type='" + type + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			logger.info(value);

			if (type.equals("productTimeline")) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
						.setParameter("actionType", "viewProductsTimeline").setParameter("actionValue", value)
						.getResultList();

				for (Object[] m : x) {

					RestCrmActivityModel assignSkill = new RestCrmActivityModel(m[0].toString(), m[1], m[2], m[3], m[4],
							m[5], m[6].toString(), m[7]);

					rs.add(assignSkill);

				}
			} else if (type.equals("allTimeline")) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
						.setParameter("actionType", "viewLeadActivityInfo").setParameter("actionValue", value)
						.getResultList();

				for (Object[] m : x) {

					RestCrmActivityModel assignSkill = new RestCrmActivityModel(m[0].toString(), m[1], m[2], m[3], m[4],
							m[5], m[6].toString(), m[7], m[8].toString(), m[9], m[10], m[11], m[12].toString(), m[13]);
					rs.add(assignSkill);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmActivityModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmActivityModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewLeadActivityInfo ends");

		return response;
	}

	// viewLeadMeetingInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> viewLeadMeetingInfo(String id, String org,
			String orgDiv) {
		logger.info("Method : viewLeadMeetingInfo starts----------------------------");
		JsonResponse<List<RestCrmMeetingModel>> resp = new JsonResponse<List<RestCrmMeetingModel>>();
		List<RestCrmMeetingModel> rs = new ArrayList<RestCrmMeetingModel>();

		try {
			String value = "SET @p_leadId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			logger.info("value for meeting id------------" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadMeetingInfo").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				String leadId = null;
				if (m[10] != null) {
					leadId = m[10].toString();
				}

				RestCrmMeetingModel assignSkill = new RestCrmMeetingModel(m[0].toString(), m[1], m[2], m[3], m[4],
						m[5].toString(), m[6], m[7].toString(), m[8], m[9], null, m[11]);

				logger.info("data in dao------------" + assignSkill);

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

		logger.info("Method : viewLeadMeetingInfo ends");

		return response;
	}

	// invitedMeetingInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmMeetingModel>>> invitedMeetingInfo(String id, String org,
			String orgDiv) {
		logger.info("Method : invitedMeetingInfo starts----------------------------");
		JsonResponse<List<RestCrmMeetingModel>> resp = new JsonResponse<List<RestCrmMeetingModel>>();
		List<RestCrmMeetingModel> rs = new ArrayList<RestCrmMeetingModel>();

		try {
			String value = "SET @p_pId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			logger.info("value for meeting id------------" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "invitedMeeting").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestCrmMeetingModel assignSkill = new RestCrmMeetingModel(m[0].toString(), m[1], m[2].toString(),
						m[3].toString(), m[4]);

				logger.info("data in dao------------" + assignSkill);

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

		logger.info("Method : invitedMeetingInfo ends");

		return response;
	}

	/*
	 * delete
	 */

	public ResponseEntity<JsonResponse<Object>> deleteDetails(String id, String org, String orgDiv) {
		logger.info("Method : deleteDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		logger.info("ID...." + id);
		if (validity)
			try {

				String[] idsArray = id.split("\\s+");
				String formattedId = "'" + String.join("','", idsArray) + "'";
				String value = "SET @p_leadId = " + formattedId + ";";
				logger.info(value);

				em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "deleteDetails")
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

		logger.info("DELETEE" + response);
		return response;
	}

	// saveleadtask(leadTask);

	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadtask(List<RestCrmLeadsModel> leadTask) {
		logger.info("Method : addPurchaseOrder dao starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> listData = new ArrayList<RestCrmLeadsModel>();

		try {
			String value2 = GenerateCrmLeadDetails.addleadtask(leadTask);
			logger.info("Value----------------" + value2);

			em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "addLeadTask")
					.setParameter("actionValue", value2).execute();

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

		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addLeadTask dao ends");
		return response;
	}
	// saveleadtags

	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadtags(List<RestCrmLeadsModel> leadTags) {
		logger.info("Method : addPurchaseOrder dao starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> listData = new ArrayList<RestCrmLeadsModel>();

		try {

			String value2 = GenerateCrmLeadDetails.addleadtags(leadTags);
			logger.info("Value----------------" + value2);

			em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "addLeadTags")
					.setParameter("actionValue", value2).execute();

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

		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addLeadTags dao ends");
		return response;
	}

	// saveleadMacro

	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadMacro(List<RestCrmLeadsModel> leadMacro) {
		logger.info("Method : saveleadMacro dao starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> listData = new ArrayList<RestCrmLeadsModel>();

		try {

			String value2 = GenerateCrmLeadDetails.addLeadMacro(leadMacro);
			logger.info("Value----------------" + value2);

			em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "addLeadMacro")
					.setParameter("actionValue", value2).execute();

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

		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveleadMacro dao ends");
		return response;
	}

	//// saveleadCampaign

	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadCampaign(
			List<RestCrmLeadsModel> leadCampaign) {
		logger.info("Method : saveleadCampaign dao starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> listData = new ArrayList<RestCrmLeadsModel>();

		try {

			String value2 = GenerateCrmLeadDetails.addLeadCampaign(leadCampaign);
			logger.info("Value----------------" + value2);

			em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "addLeadCampaign")
					.setParameter("actionValue", value2).execute();

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

		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveleadCampaign dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addItemRequisition(RestCrmTaskModel restItemRequisitonModel) {
		logger.info("Method : addItemRequisition starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = GenerateCrmLeadDetails.addleadmacro(restItemRequisitonModel);
			logger.info("values" + value);

			logger.info("in modify");
			em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "addMacroDetails")
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
		logger.info("Method : add item Requisition ends");
		return response;
	}

	/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> restAddMassUpdate(RestCrmLeadsModel leadDetails) {

		logger.info("Method in Dao: restAddMassUpdate starts" + leadDetails);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			if (leadDetails.getLeadId() == "" || leadDetails.getLeadId() == null) {

				em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "addLeadData")
						.setParameter("actionValue", "").execute();

			} else {
				logger.info("in modify" + leadDetails.getLeadId());
				em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "modifyLeadData")
						.setParameter("actionValue", "").execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: restAddMassUpdate ends");

		return response;
	}

	///////////////////////////////////////////////////////////////////

	public ResponseEntity<JsonResponse<Object>> addNoteDoc(EmployeeDocumentModel employeeDocumentModel) {
		logger.info("Method : addNoteDoc starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = GenerateemployeemasterParameter.getLeadNoteDoc(employeeDocumentModel);
			System.out.println("value for adding the note------------->" + value);

			if (employeeDocumentModel.getLeadNoteId() == null || employeeDocumentModel.getLeadNoteId() == "") {
				System.out.println("calling if");
				em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "addNoteDocuments")
						.setParameter("actionValue", value).execute();

				resp.setMessage("Note Added Sucessfully");
				resp.setCode("Success");

			} else {
				System.out.println("calling else");
				em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "editNoteDocuments")
						.setParameter("actionValue", value).execute();
				resp.setMessage("Note Modify Sucessfully");
				resp.setCode("Success");
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
			resp.setMessage("Something went wrong!");
			resp.setCode("Failed");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : add item addNoteDoc ends");
		return response;
	}

	// convertToAccContDeal

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmLeadsModel>> convertToAccContDeal(RestCrmLeadsModel leadModel) {
		Boolean validity = true;
		logger.info("Method : convertLead start");
		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> listData = new ArrayList<RestCrmLeadsModel>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values = GenerateCrmLeadDetails.generateCrmLeadConvertParam(leadModel);
				System.out.println("Value For Convert The Lead======>" + values);

				if (leadModel.getDealName() == null || leadModel.getDealName() == "") {

					List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
							.setParameter("actionType", "convertLead").setParameter("actionValue", values)
							.getResultList();

					try {
						for (Object[] m : x) {
							RestCrmLeadsModel model = new RestCrmLeadsModel(m[0], m[1]);
							listData.add(model);
							System.out.println("-------------------->>>>>>>>>>>>>>>>>>" + model);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {

					em.createNamedStoredProcedureQuery("crmLeads_routines")
							.setParameter("actionType", "convertLeadWithDeal").setParameter("actionValue", values)
							.execute();

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
		resp.setBody(listData);
		logger.info("Method : convertLead ends");
		return resp;
	}

//	viewProductDetailsView

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmProductModel>>> viewProductDetailsView(String id, String id2,
			String pageType, String productCode, String org, String orgDiv) {
		logger.info("Method : viewProductDetailsView starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmProductModel>> resp = new JsonResponse<List<RestCrmProductModel>>();
		List<RestCrmProductModel> rs = new ArrayList<RestCrmProductModel>();

		try {

			logger.info("id2---------------------------------------------" + id2);
			String Yes = "Yes";
			String value = "SET @p_id='" + id + "';";
			String value1 = "SET @p_id=\"" + id + "\",@p_productId=\"" + productCode + "\";";
			String noProduct = "";
			String pageLead = "Lead";
			String pageContact = "Contact";
			String pageAccount = "Account";
			String pageDeal = "Deal";

			if (id2.equals(Yes)) {

				if (productCode.equals(noProduct)) {

					List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
							.setParameter("actionType", "viewPdctNotAsgn").setParameter("actionValue", value)
							.getResultList();
					logger.info("asdfasdf" + x);

					for (Object[] m : x) {

						RestCrmProductModel assignSkill = new RestCrmProductModel(m[0], m[1], m[2], m[3], m[4], m[5],
								m[6], m[7], m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString(),
								m[12].toString(), m[13].toString(), m[14].toString(), m[15].toString(), m[16], m[17],
								m[18], m[19], m[20], m[21], m[22], m[23], m[24].toString());

						rs.add(assignSkill);

					}

				} else {

					if (pageLead.equals(pageType)) {
						logger.info("Leaddddddddddddddddddddddddddddddddddddddddddddddddddd");
						logger.info("value1----------------------------------------" + value1);
						List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
								.setParameter("actionType", "viewPdctNotAsgnL").setParameter("actionValue", value1)
								.getResultList();
						for (Object[] m : x) {

							RestCrmProductModel assignSkill = new RestCrmProductModel(m[0], m[1], m[2], m[3], m[4],
									m[5], m[6], m[7], m[8].toString(), m[9].toString(), m[10].toString(),
									m[11].toString(), m[12].toString(), m[13].toString(), m[14].toString(), m[15],
									m[16], m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24].toString());

							rs.add(assignSkill);

						}

					}

					if (pageContact.equals(pageType)) {
						logger.info("Contacttttttttttttttttttttttttttt");
						List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
								.setParameter("actionType", "viewPdctNotAsgnC").setParameter("actionValue", value1)
								.getResultList();
						for (Object[] m : x) {

							RestCrmProductModel assignSkill = new RestCrmProductModel(m[0], m[1], m[2], m[3], m[4],
									m[5], m[6], m[7], m[8].toString(), m[9].toString(), m[10].toString(),
									m[11].toString(), m[12].toString(), m[13].toString(), m[14].toString(), m[15],
									m[16], m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24].toString());

							rs.add(assignSkill);

						}

					}

					if (pageAccount.equals(pageType)) {
						logger.info("Accountttttttttttttttttttttttttt");
						List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
								.setParameter("actionType", "viewPdctNotAsgnA").setParameter("actionValue", value1)
								.getResultList();
						for (Object[] m : x) {

							RestCrmProductModel assignSkill = new RestCrmProductModel(m[0], m[1], m[2], m[3], m[4],
									m[5], m[6], m[7], m[8].toString(), m[9].toString(), m[10].toString(),
									m[11].toString(), m[12].toString(), m[13].toString(), m[14].toString(), m[15],
									m[16], m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24].toString());

							rs.add(assignSkill);

						}

					}

					if (pageDeal.equals(pageType)) {
						logger.info("Dealllllllllllllllllllllllllllllllllllllll");
						List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
								.setParameter("actionType", "viewPdctNotAsgnD").setParameter("actionValue", value1)
								.getResultList();
						for (Object[] m : x) {

							RestCrmProductModel assignSkill = new RestCrmProductModel(m[0], m[1], m[2], m[3], m[4],
									m[5], m[6], m[7], m[8].toString(), m[9].toString(), m[10].toString(),
									m[11].toString(), m[12].toString(), m[13].toString(), m[14].toString(), m[15],
									m[16], m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24].toString());

							rs.add(assignSkill);

						}

					}

				}

			} else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
						.setParameter("actionType", "viewProductDetails").setParameter("actionValue", value)
						.getResultList();
				logger.info("asdfasdf" + x);

				for (Object[] m : x) {

					RestCrmProductModel assignSkill = new RestCrmProductModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
							m[7], m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString(),
							m[12].toString(), m[13].toString(), m[14].toString(), m[15], m[16], m[17], m[18], m[19],
							m[20], m[21], m[22], m[23], m[24].toString());

					rs.add(assignSkill);

				}

			}

			// viewPdctNotAsgn

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmProductModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmProductModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewProductDetailsView ends");

		return response;
	}

	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveleadmail(List<RestCrmLeadsModel> leadTask) {
		logger.info("Method : saveleadmail dao starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> listData = new ArrayList<RestCrmLeadsModel>();

		try {
			String value2 = GenerateCrmLeadDetails.addleadmail(leadTask);
			logger.info("Value----------------" + value2);

			em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "saveleadmail")
					.setParameter("actionValue", value2).execute();

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

		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveleadmail dao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> saveCRMProductAdd(List<RestCrmLeadsModel> leadTask) {

		logger.info("Method in Dao: saveCRMProductAdd starts");

		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> listData = new ArrayList<RestCrmLeadsModel>();

		/* JsonResponse<Object> resp = new JsonResponse<Object>(); */

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateManageCrmLeadParam.addCRMProduct(leadTask);

			System.out.println("value===========================" + values);
			em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "saveCRMProductAdd")
					.setParameter("actionValue", values).execute();
			resp.setCode("success");
			resp.setMessage("Data saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				resp.setCode("failed");
				resp.setMessage("Something is wrong");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method in Dao: saveCRMProductAdd ends");

		return response;
	}

	// saveCRMProductAdd

	/*
	 * public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>
	 * saveCRMProductAdd(String id, List<RestCrmLeadsModel> leadTags) {
	 * logger.info("Method : saveCRMProductAdd dao starts");
	 * 
	 * JsonResponse<List<RestCrmLeadsModel>> resp = new
	 * JsonResponse<List<RestCrmLeadsModel>>(); List<RestCrmLeadsModel> listData =
	 * new ArrayList<RestCrmLeadsModel>();
	 * 
	 * try {
	 * 
	 * 
	 * String value2 = GenerateCrmLeadDetails.addProductAssigned(leadTags);
	 * logger.info("Value----------------"+value2);
	 * 
	 * 
	 * 
	 * em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter(
	 * "actionType", "saveCRMProductAdd") .setParameter("actionValue",
	 * value2).execute();
	 * 
	 * 
	 * } catch (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
	 * resp.setCode(err[0]); resp.setMessage(err[1]); } catch (Exception e1) {
	 * e1.printStackTrace(); } e.printStackTrace(); }
	 * 
	 * resp.setBody(listData); ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>
	 * response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>( resp,
	 * HttpStatus.CREATED);
	 * 
	 * logger.info("Method : saveCRMProductAdd dao ends"); return response; }
	 */

	/*
	 * //getNameAutoSearchProduct
	 * 
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<DropDownModel>>>
	 * getNameAutoSearchProduct(String id,String leadId,String assigRow) {
	 * logger.info("Method : getNameAutoSearchProduct starts"); List<DropDownModel>
	 * itemNameList = new ArrayList<DropDownModel>();
	 * JsonResponse<List<DropDownModel>> resp = new
	 * JsonResponse<List<DropDownModel>>(); String value = "SET @p_searchValue='" +
	 * id + "';";
	 * 
	 * logger.info("search val--------------------------"+id);
	 * logger.info("search leadId--------------------------"+leadId);
	 * logger.info("search assigRow--------------------------"+assigRow);
	 * 
	 * try { logger.info("VALUE"+value); List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("crmLeads_routines")
	 * .setParameter("actionType", "getSearchProduct").setParameter("actionValue",
	 * value) .getResultList(); for (Object[] m : x) { DropDownModel dropDownModel =
	 * new DropDownModel(m[0], m[1]); itemNameList.add(dropDownModel); }
	 * resp.setBody(itemNameList); } catch (Exception e) { e.printStackTrace(); }
	 * ResponseEntity<JsonResponse<List<DropDownModel>>> response = new
	 * ResponseEntity<JsonResponse<List<DropDownModel>>>( resp, HttpStatus.CREATED);
	 * logger.info("Method : getNameAutoSearchProduct ends");
	 * logger.info("AUTODATAAA" + response); return response; }
	 */

//viewProductSearchView(searchVal,leadId,assigRow);

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> viewProductSearchView(String searchVal, String id,
			String assigRow, String pageType) {
		logger.info("Method : viewProductSearchView starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		List<DropDownModel> rs = new ArrayList<DropDownModel>();

		try {

			logger.info("searchVal---------------------------------------------" + searchVal);
			logger.info("id---------------------------------------------" + id);
			logger.info("assigRow---------------------------------------------" + assigRow);
			// String value = "SET @p_searchValue='" + searchVal + "';";
			String value = "SET @p_id=\"" + id + "\",@p_searchValue=\"" + searchVal + "\";";

			String Yes = "Yes";
			String pageLeadType = "Lead";
			String pageContactType = "Contact";
			String pageAccountType = "Account";
			String pageDealType = "Deal";

			if (assigRow.equals(Yes)) {
				if (pageLeadType.equals(pageType)) {
					List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
							.setParameter("actionType", "getSrchPdctAssignL").setParameter("actionValue", value)
							.getResultList();
					for (Object[] m : x) {
						DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
						rs.add(dropDownModel);
					}
					resp.setBody(rs);
				}

				if (pageContactType.equals(pageType)) {
					List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
							.setParameter("actionType", "getSrchPdctAssignC").setParameter("actionValue", value)
							.getResultList();
					for (Object[] m : x) {
						DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
						rs.add(dropDownModel);
					}
					resp.setBody(rs);
				}

				if (pageAccountType.equals(pageType)) {
					List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
							.setParameter("actionType", "getSrchPdctAssignA").setParameter("actionValue", value)
							.getResultList();
					for (Object[] m : x) {
						DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
						rs.add(dropDownModel);
					}
					resp.setBody(rs);
				}

				if (pageDealType.equals(pageType)) {
					List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
							.setParameter("actionType", "getSrchPdctAssignD").setParameter("actionValue", value)
							.getResultList();
					for (Object[] m : x) {
						DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
						rs.add(dropDownModel);
					}
					resp.setBody(rs);
				}
			} else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
						.setParameter("actionType", "getSearchProduct").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					rs.add(dropDownModel);
				}
				resp.setBody(rs);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewProductSearchView ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse editNoteDet(String id) {
		// TODO Auto-generated method stub
		logger.info("Method : editNoteDet starts");
		JsonResponse jsonResp = new JsonResponse();

		try {

			String value = "SET @p_noteId='" + id + "';";
			System.out.print(value + "value@@@@@");
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "editLeadNote").setParameter("actionValue", value).getResultList();

			// System.out.print(x.toString()+"@@@@@@@@@@@@@@@@@@@");
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

		logger.info("Method : editNoteDet ends");
		return jsonResp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse editNoteDataByNoteId(String id) {
		// TODO Auto-generated method stub
		logger.info("Method : editNoteDataByNoteId starts");
		JsonResponse jsonResp = new JsonResponse();

		try {

			String value = "SET @p_noteId='" + id + "';";
			System.out.print(value + "value@@@@@");
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "editNoteData").setParameter("actionValue", value).getResultList();

			// System.out.print(x.toString()+"@@@@@@@@@@@@@@@@@@@");
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

		logger.info("Method : editNoteDataByNoteId ends");
		return jsonResp;
	}

	public ResponseEntity<JsonResponse<Object>> deleteNoteDao(String id) {
		logger.info("Method : deleteNoteDao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_noteid='" + id + "';";
			System.out.println(value + "@@@@@@@@");
			em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "deleteLeadNote")
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
		logger.info("Method : deleteNoteDao ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse viewNoteDet(String id, String pageno, String filterDate, String filterTitle, String userId,
			String org, String orgDiv) {
		logger.info("Method : viewNoteDet starts");
		JsonResponse jsonResp = new JsonResponse();
		try {

			// String value = "SET @p_noteLead='"+id+"';";
			String value = "SET @p_noteLead=\"" + id + "\",@p_pageno=\"" + pageno + "\",@p_filterDate=\"" + filterDate
					+ "\"," + "@p_filterTitle=\"" + filterTitle + "\",@p_userId=\"" + userId + "\",@org=\"" + org
					+ "\",@orgDiv=\"" + orgDiv + "\";";

			System.out.print("viewwvalue@@@@@" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getLeadNoteDet").setParameter("actionValue", value).getResultList();

			JSONArray array = new JSONArray(x.toString());

			if (array.getJSONObject(0).get("noteList").toString() != "null") {
				jsonResp.setBody(x);
				jsonResp.setMessage("Note fetched Successfully.");
				jsonResp.setCode("Success");
			} else {
				jsonResp.setCode("Failed");
				jsonResp.setMessage("No Data Found");
			}

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

		logger.info("Method : viewNoteDet ends");
		return jsonResp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse viewDraftDet(String id, String org, String orgDiv) {
		logger.info("Method : viewDraftDet starts");
		JsonResponse jsonResp = new JsonResponse();
		try {

			String value = "SET @p_draftLeadId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			System.out.print("viewwvalue@@@@@" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadDraftInfo").setParameter("actionValue", value).getResultList();
			jsonResp.setCode("success");
			jsonResp.setMessage("Drafts Fetched successfully");
			// System.out.print(x.toString()+"@@@@@@@@@@@@@@@@@@@");
			jsonResp.setBody(x);

			System.out.print(jsonResp + "@@@@@@@@@@@@@@@@@@@");
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				jsonResp.setCode(err[0]);
				jsonResp.setMessage(err[1]);
				jsonResp.setCode("failed");
				jsonResp.setMessage("Something is wrong");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		logger.info("Method : viewDraftDet ends");
		return jsonResp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse viewMailDet(String id, String org, String orgDiv) {
		logger.info("Method : viewMailDet starts");
		JsonResponse jsonResp = new JsonResponse();
		try {

			String value = "SET @p_LeadId='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.print("viewwvalue@@@@@" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "viewLeadMail").setParameter("actionValue", value).getResultList();
			jsonResp.setCode("success");
			jsonResp.setMessage("Email Fetched successfully");
			// System.out.print(x.toString()+"@@@@@@@@@@@@@@@@@@@");
			jsonResp.setBody(x);

			System.out.print(jsonResp + "@@@@@@@@@@@@@@@@@@@");
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				jsonResp.setCode(err[0]);
				jsonResp.setMessage(err[1]);
				jsonResp.setCode("failed");
				jsonResp.setMessage("Something is wrong");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		logger.info("Method : viewMailDet ends");
		return jsonResp;
	}

	public ResponseEntity<JsonResponse<Object>> deleteDraftDao(String id, String org, String orgDiv) {
		logger.info("Method : deleteDraftDao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_draftid='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			System.out.println(value + "@@@@@@@@");
			em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "deleteLeadDraft")
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
		logger.info("Method : deleteDraftDao ends");
		return response;

	}

	// edit view email

	@SuppressWarnings("unchecked")
	public JsonResponse<RestCrmLeadsModel> editDraftDet(String id1, String id2, String org, String orgDiv) {
		logger.info("Method : editDraftDet dao starts");

		RestCrmLeadsModel req = new RestCrmLeadsModel();
		JsonResponse<RestCrmLeadsModel> resp = new JsonResponse<RestCrmLeadsModel>();
		/* int ID=Integer.parseInt(id2); */
		try {
			String value = "SET @p_leadId='" + id1 + "',@p_Id='" + id2 + "',@org='" + org + "',@orgDiv='" + orgDiv
					+ "';";
			logger.info("VALUESSS" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "editLeadDraft").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0].toString(), m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9].toString(), m[10].toString(), m[11], m[12], m[13]);
				req = assignSkill;
			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editDraftDet dao ends");
		return resp;
	}

	public ResponseEntity<JsonResponse<Object>> saveleadCSV(List<RestCrmLeadsModel> lead) {
		logger.info("Method : saveleadCSV dao ends");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<RestCrmLeadsModel> listData = new ArrayList<RestCrmLeadsModel>();

		try {

			String sitem = "";
			String s = "";
			for (RestCrmLeadsModel m : lead) {
				sitem = sitem + "(\"" + m.getFirstName() + "\",\"" + m.getLastName() + "\",\"" + m.getPhone() + "\",\""
						+ m.getEmail() + "\",\"" + m.getCompany() + "\",\"" + m.getLeadSource() + "\",\""
						+ m.getCreatedBy() + "\",\"" + m.getTitle() + "\",\"" + m.getMobile() + "\",\"" + m.getFax()
						+ "\",\"" + m.getWebsite() + "\",\"" + m.getLeadStatus() + "\",\"" + m.getIndustry() + "\",\""
						+ m.getNoOfEmp() + "\",\"" + m.getAnnualRevenue() + "\",\"" + m.getRatings() + "\",\""
						+ m.getAddressStreet() + "\",\"" + m.getCity() + "\",\"" + m.getStates() + "\",\""
						+ m.getCountry() + "\",\"" + m.getDescription() + "\",\"" + m.getSkypeId() + "\",\""
						+ m.getEmailOpt() + "\",\"" + m.getSecondaryEmail() + "\",\"" + m.getTwitter() + "\",\""
						+ m.getConvertedToLead() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
						+ "\",\"" + m.getCreatedBy() + "\"),";
			}
			sitem = sitem.substring(0, sitem.length() - 1);
			s = s + "set @p_itemSubQuery='" + sitem + "',";
			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = s + ";";
			}
			System.out.println("sitem@@@@@@@@@@" + s);

			em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "addLeadCSVData")
					.setParameter("actionValue", s).execute();
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

		resp.setBody(listData);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveleadCSV dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> updateTaskStatus(AdminTaskAssignRestModel task) {

		logger.info("Method : updateTaskStatus dao ends");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = "SET @taskId='" + task.getTaskId() + "', @executiveId='" + task.getExecutiveId() + "', @id='"
				+ task.getStatus() + "';";
		System.out.println(value);

		try {
			List<Object> x = em.createNamedStoredProcedureQuery("crm_admin_routines")
					.setParameter("actionType", "change-status").setParameter("actionValue", value).getResultList();
			System.out.println("--------->>>>>>>>>$$$$$ " + x.get(0));
			if (x.get(0).equals("Success")) {
				resp.setCode("Success");
				resp.setMessage("Status Updated Successfully.");
			} else {
				resp.setCode("Failed");
				resp.setMessage("Something went wrong!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getMessage());
		}

		logger.info("Method : updateTaskStatus dao ends");
		return resp;
	}

	/*
	 * Reveiw Note By Admin
	 * 
	 * @Author: Pankaj
	 */

	public ResponseEntity<JsonResponse<Object>> reveiwNote(String id, String desc, String userId) {
		logger.info("Method : reveiwNoteDao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_noteid='" + id + "',@p_desc='" + desc + "',@p_userId='" + userId + "';";
			System.out.println("Pankajjsjsjjj" + value);
			em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "reveiwNoteAdmin")
					.setParameter("actionValue", value).execute();
			resp.setMessage("Review Saved Sucessfully");
			resp.setCode("Success");
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			resp.setMessage("Something went wrong!");
			resp.setCode("Failed");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : reveiwNoteDao ends");
		return response;

	}

	/*
	 * Delete Product from Lead
	 */
	public ResponseEntity<JsonResponse<Object>> deleteProduct(String data, String userId, String org, String orgDiv,
			String id) {

		logger.info("Method : reveiwNoteDao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();

		try {
			String value = "SET @p_prodid='" + data + "', @p_id='" + id + "',@p_userId='" + userId + "',@org='" + org
					+ "',@orgDiv='" + orgDiv + "',@timelineName='" + "Product Deleted" + "',@currentTime='" + dateString
					+ "';";
			System.out.println(value);
			em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "deleteproduct")
					.setParameter("actionValue", value).execute();
			resp.setMessage("Product Deleted Sucessfully");
			resp.setCode("Success");
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			resp.setMessage("Something went wrong!");
			resp.setCode("Failed");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : reveiwNoteDao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> leadStatusTimeline(String id) {
		logger.info("Method : leadStatusTimeline starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_id ='" + id + "';";
		System.out.println(value);

		try {
			List<Object> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "lead-status-timeline").setParameter("actionValue", value)
					.getResultList();
			System.out.println("====" + x);

			resp.setBody(x);

			resp.setMessage("Data Fetched successfully.");
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : leadStatusTimeline ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getProjectAutoSearchList(String org, String orgDiv) {
		logger.info("Method : getProjectAutoSearchList starts");

		List<DropDownModel> getProjectAutoSearchList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		System.out.println("Value For Getting the Project List------->" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("quotationmasterRotines")
					.setParameter("actionType", "getProjectAutoSearchList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getProjectAutoSearchList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getProjectAutoSearchList ends");
		return getProjectAutoSearchList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeLists(String orgName, String orgDivision, String managerId, String userId) {
		logger.info("Method : getEmployeeLists starts");

		List<DropDownModel> emplist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org=\"" + orgName + "\",@p_orgDiv=\"" + orgDivision + "\"" + ",@p_managerId='"
					+ managerId + "',@p_userId='" + userId + "';";
			System.out.println("Value for Employee list------>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2]);
				emplist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeLists ends");
		return emplist;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCustoomerNewModel>> addCustomer(String id, String org, String orgDiv) {
		logger.info("Method : addCustomer starts");

		JsonResponse<List<RestCustoomerNewModel>> resp = new JsonResponse<>();
		List<RestCrmLeadsModel> rs = new ArrayList<>();
		List<RestCustoomerNewModel> newCustomerList = new ArrayList<>();

		try {
			String value = "SET @p_leadId='" + id + "',@org='" + org + "',@orgDiv='" + orgDiv + "';";
			logger.info(value);

			// Fetch Lead Information
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "editLeadInfo").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21],
						m[22], m[23], m[24], m[25], m[26], m[27], null, null, null, null, m[28], null, null, null, null,
						m[29], m[30], null, m[31], m[32], null, null, null, null);
				rs.add(assignSkill);
			}

			for (RestCrmLeadsModel lead : rs) {
				RestCustoomerNewModel customer = new RestCustoomerNewModel();
				customer.setCustomerName(lead.getCompany());
				customer.setCompanyName(lead.getCompany());
				customer.setCustomerDisplayName(lead.getCompany());
				customer.setCusEmail(lead.getEmail());
				customer.setCustMobile(lead.getMobile());
				customer.setCustSkype(lead.getSkypeId());
				customer.setCustDesignation(lead.getTitle());
				customer.setWebSite(lead.getWebsite());
				customer.setStatus("Active");
				customer.setWhatsApp(lead.getPhone());
				customer.setTwitter(lead.getTwitter());
				customer.setCountry(lead.getCountry());
				customer.setStates(lead.getStates());
				customer.setCity(lead.getCity());
				customer.setStreet1(lead.getAddressStreet());
				customer.setZipCode(lead.getZip());
				customer.setLeadId(lead.getLeadId());

				List<Map<String, Object>> shippingDetailsList = new ArrayList<>();
				Map<String, Object> shippingDetails = new HashMap<>();
				shippingDetails.put("fax", "");
				shippingDetails.put("city", lead.getCity());
				shippingDetails.put("phone", lead.getPhone());
				shippingDetails.put("state", lead.getStates());
				shippingDetails.put("country", lead.getCountry());
				shippingDetails.put("delFlag", 0);
				shippingDetails.put("street1", lead.getAddressStreet());
				shippingDetails.put("street2", "");
				shippingDetails.put("zipcode", lead.getZip());
				shippingDetails.put("stateName", lead.getStateName());
				shippingDetails.put("countryName", lead.getCountryName());
				shippingDetails.put("shippingId", UUID.randomUUID().toString());
				shippingDetailsList.add(shippingDetails);

				// Convert List to JSON String
				ObjectMapper objectMapper = new ObjectMapper();
				String shippingDetailsJson = objectMapper.writeValueAsString(shippingDetailsList);
				customer.setShippingDetails(shippingDetailsJson);

				newCustomerList.add(customer);
			}

			// Add Customers via Stored Procedure
			for (RestCustoomerNewModel customer : newCustomerList) {
				String customerParams = GenerateCustomerNewParameter.getAddCustParam(customer);
				System.out.println("Value For Add Customer------->" + customerParams);

				em.createNamedStoredProcedureQuery("customermaster").setParameter("actionType", "addCustomer")
						.setParameter("actionValue", customerParams).execute();
			}

			// Set response
			resp.setBody(newCustomerList);
			resp.setMessage("Lead Processed and Customers Added Successfully");
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Error while processing lead");
			resp.setCode("Failure");
		}

		logger.info("Method : addCustomer ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLeadProductList(String userId, String orgName, String orgDivision) {
		logger.info("Method : getLeadProductList starts");

		List<DropDownModel> emplist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org=\"" + orgName + "\",@p_orgDiv=\"" + orgDivision + "\"" + ",@p_userId='" + userId
					+ "';";

			System.out.println("Value for Employee list------>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "getLeadProductList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				emplist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLeadProductList ends");
		return emplist;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getSkuOnProduct(String orgName, String orgDiv, String userId, String id) {
		logger.info("Method : getSkuOnProduct Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId
					+ "',@p_productId='" + id + "';";
			System.out.println("getSkuOnProduct========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "get-sku-on-product").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getSkuOnProduct Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addProductForLead(Map<String, Object> requestPayload) {
		logger.info("Method : addProductForLead starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		StringBuilder itemSubQuery = new StringBuilder();
		String leadId = "";

		try {
			String orgName = (String) requestPayload.get("orgName");
			String orgDiv = (String) requestPayload.get("orgDiv");
			String userId = (String) requestPayload.get("createdById");

			List<Map<String, Object>> productList = (List<Map<String, Object>>) requestPayload.get("productList");

			if (productList == null || productList.isEmpty()) {
				resp.setCode("Failed");
				resp.setMessage("Product list is empty.");
				return resp;
			}

			for (Map<String, Object> product : productList) {
				leadId = (String) product.get("leadId");
				String productId = (String) product.get("productId");
				String skuId = (String) product.get("skuId");
				String productName = (String) product.get("productName");
				String skuName = (String) product.get("skuName");
				String itemDesc = (String)product.get("itemDesc");

				itemSubQuery.append("('").append(leadId).append("','").append(productId).append("','")
						.append(productName).append("','").append(skuId).append("','").append(skuName).append("',")
						.append("NOW(),").append("CURTIME(),").append("NULL,'").append(userId).append("','")
						.append(orgName).append("','").append(orgDiv).append("','").append(itemDesc).append("'),");

			}

			if (itemSubQuery.length() > 0) {
				itemSubQuery.setLength(itemSubQuery.length() - 1);
			}

			String value = "SET @p_leadId='" + leadId + "', @p_itemSubQuery=\"" + itemSubQuery.toString() + "\";";
			logger.info("Executing Stored Procedure with value: " + value);

			em.createNamedStoredProcedureQuery("crmLeads_routines").setParameter("actionType", "add-product-data")
					.setParameter("actionValue", value).execute();

			resp.setCode("Success");
			resp.setMessage("Products added successfully.");
			// resp.setBody(x);

		} catch (Exception e) {
			logger.error("Error in addProductForLead: ", e);
			resp.setCode("Failed");
			resp.setMessage("Exception occurred while adding lead products.");
		}

		logger.info("Method : addProductForLead ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getProductOnLead(String orgName, String orgDiv, String userId, String leadId) {
		logger.info("Method : getProductOnLead Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId
					+ "',@p_leadId='" + leadId + "';";
			System.out.println("getSkuOnProduct========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "get-product-on-lead").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getProductOnLead Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteLeadProduct(String orgName, String orgDiv, String userId, String leadId,
			String productId, String skuId) {
		logger.info("Method : deleteLeadProduct Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId
					+ "',@p_leadId='" + leadId + "',@p_productId='" + productId + "',@p_skuId='" + skuId + "';";
			System.out.println("getSkuOnProduct========>" + value);
			logger.info("Alert Data Value" + value);
			Object x = em.createNamedStoredProcedureQuery("crmLeads_routines")
					.setParameter("actionType", "delete-lead-product").setParameter("actionValue", value)
					.getSingleResult();
			System.out.println("Result---->"+Integer.parseInt(x.toString()));
			if (Integer.parseInt(x.toString()) > 0) {
				resp.setCode("success");
				resp.setMessage("Product Deleted successfully");
			}
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : deleteLeadProduct Dao ends" + resp);
		return resp;

	}
}
