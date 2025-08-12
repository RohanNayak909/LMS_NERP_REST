package nirmalya.aatithya.restmodule.edms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import nirmalya.aatithya.restmodule.util.Util;

import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.StringUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.edms.model.RestDocumentControlModel;
import nirmalya.aatithya.restmodule.edms.model.RestWorkFlowModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;

@Repository
public class RestDocumentControlDao {

	Logger logger = LoggerFactory.getLogger(RestDocumentControlDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// add document control

	public ResponseEntity<JsonResponse<List<RestDocumentControlModel>>> addDocDAO(
			List<RestDocumentControlModel> restDocumentControlModel) {

		logger.info("Method : addDocDAO starts");

		JsonResponse<List<RestDocumentControlModel>> resp = new JsonResponse<List<RestDocumentControlModel>>();
		Gson gson = new Gson();
		String jsonString = gson.toJson(restDocumentControlModel);
		System.out.println("Json String === " + jsonString);
		JsonArray jsonArray = JsonParser.parseString(jsonString).getAsJsonArray();
		String docid = "";

		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
			docid = jsonObject.get("docid").getAsString();
			System.out.println("docid: " + docid);
			System.out.println("jsonObject" + jsonObject);
			System.out.println("jsonArray: " + jsonArray);
		}
		// String docId = (String) jsonString.get("docid");

		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
			docid = jsonObject.get("docid").getAsString();
		}
		try {
			if (StringUtil.isNull(docid)) {
				String value = "SET @datas='" + jsonString + "';";
				System.out.println("Document Value" + value);
				em.createNamedStoredProcedureQuery("documentControlRoutines")
						.setParameter("actionType", "addDocuControl").setParameter("actionValue", jsonString).execute();

				// System.out.println(value);
			}

			else {
				String value = "SET @jsonString='" + jsonString + "',@docid='" + docid + "';";
				System.out.println("value" + value);
				em.createNamedStoredProcedureQuery("documentControlRoutines")
						.setParameter("actionType", "modifyDocumentControl").setParameter("actionValue", value)
						.execute();
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<List<RestDocumentControlModel>>> response = new ResponseEntity<JsonResponse<List<RestDocumentControlModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addDocDAO ends");

		return response;

	}

	// view Document Control Details
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> documentControlView(String userId, String organization, String orgDivision,
			String pageno) {
		logger.info("Method : documentControlView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @userId='" + userId + "',@organization='" + organization + "',@orgDivision='"
					+ orgDivision + "',@p_pageno='" + pageno + "';";
			System.out.println(" documentControlView values=>" + value);

			Object x = em.createNamedStoredProcedureQuery("documentControlRoutines")
					.setParameter("actionType", "viewDocumentControl").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully.");
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
		logger.info("Method : documentControlView Dao ends" + resp);
		return resp;

	}

	// Document Control Edit
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editDocumentControl(String id, String userId, String organization, String orgDivision) {
		logger.info("Method : editDocumentControl Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_docId='" + id + "',@p_userId='" + userId + "',@p_organization='" + organization
					+ "',@p_orgDivision='" + orgDivision + "';";
			System.out.println("valueDOCUMENT" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("documentControlRoutines")
					.setParameter("actionType", "editDocumentControl").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editDocumentControl Dao ends" + resp);
		return resp;
	}

	public ResponseEntity<JsonResponse<RestDocumentControlModel>> uploadFolderDAO(
			RestDocumentControlModel restDocumentControlModel) {

		logger.info("Method : uploadFolderDAO starts" + restDocumentControlModel);

		JsonResponse<RestDocumentControlModel> resp = new JsonResponse<RestDocumentControlModel>();
		Gson gson = new Gson();
		String jsonString = gson.toJson(restDocumentControlModel);

		try {
			if (StringUtil.isNull(restDocumentControlModel.getDocid())) {
				System.out.println("Json String === " + jsonString);
				em.createNamedStoredProcedureQuery("documentControlRoutines")
						.setParameter("actionType", "addUploadFolder").setParameter("actionValue", jsonString)
						.execute();
			} else {

				String value = "SET @p_jsonString='" + jsonString + "',@p_docid='" + restDocumentControlModel.getDocid()
						+ "';";
				System.out.println("value FOLDER MODIFY=== " + value);
				em.createNamedStoredProcedureQuery("documentControlRoutines")
						.setParameter("actionType", "modifyUploadFolder").setParameter("actionValue", value).execute();
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<RestDocumentControlModel>> response = new ResponseEntity<JsonResponse<RestDocumentControlModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response====" + resp);
		logger.info("Method : uploadFolderDAO ends");

		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editUploadFolder(String id) {
		logger.info("Method : editUploadFolder Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_docId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("documentControlRoutines")
					.setParameter("actionType", "editDocumentControl").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editUploadFolder Dao ends" + resp);
		return resp;
	}

	public ResponseEntity<JsonResponse<RestDocumentControlModel>> deleteFolderFiles(
			RestDocumentControlModel restDocumentControlModel) {
		logger.info("Method : deleteFolderFiles starts");

		JsonResponse<RestDocumentControlModel> resp = new JsonResponse<RestDocumentControlModel>();
		Gson gson = new Gson();
		String jsonString = gson.toJson(restDocumentControlModel);

		String value = "SET @jsonString='" + jsonString + "',@docid='" + restDocumentControlModel.getDocid() + "';";
		System.out.println("value" + value);
		try {
			em.createNamedStoredProcedureQuery("documentControlRoutines")
					.setParameter("actionType", "deleteFolderFiles").setParameter("actionValue", value).execute();
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

		ResponseEntity<JsonResponse<RestDocumentControlModel>> response = new ResponseEntity<JsonResponse<RestDocumentControlModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response====" + resp);
		logger.info("Method : deleteFolderFiles ends");

		return response;
	}

	public ResponseEntity<JsonResponse<RestDocumentControlModel>> addLinks(
			RestDocumentControlModel restDocumentControlModel) {
		logger.info("Method : addLinks starts");

		JsonResponse<RestDocumentControlModel> resp = new JsonResponse<RestDocumentControlModel>();
		Gson gson = new Gson();
		String jsonString = gson.toJson(restDocumentControlModel);
		System.out.println("jsonString===" + jsonString);
		// String value = "SET @jsonString='" + jsonString +
		// "',@docid='"+restDocumentControlModel.getDocid()+"';";

		try {
			if (restDocumentControlModel.getDocid() == null || restDocumentControlModel.getDocid() == "") {

				em.createNamedStoredProcedureQuery("documentControlRoutines").setParameter("actionType", "addLink")
						.setParameter("actionValue", jsonString).execute();
			} else {
				String value = "SET @jsonString='" + jsonString + "',@docid='" + restDocumentControlModel.getDocid()
						+ "';";
				em.createNamedStoredProcedureQuery("documentControlRoutines").setParameter("actionType", "modifyLink")
						.setParameter("actionValue", value).execute();
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
		ResponseEntity<JsonResponse<RestDocumentControlModel>> response = new ResponseEntity<JsonResponse<RestDocumentControlModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response====" + resp);
		logger.info("Method : addLinks ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editLink(String id) {
		logger.info("Method : editLink Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_docId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("documentControlRoutines")
					.setParameter("actionType", "editLink").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editLink Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> deleteDocumentControl(String docId) {
		logger.info("Method : deleteDocumentControl Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String value = "SET @p_docId='" + docId + "';";
		System.out.println(value);
		try {

			em.createNamedStoredProcedureQuery("documentControlRoutines").setParameter("actionType", "deleteDocument")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		System.out.println("=====>>>resp" + response);
		logger.info("Method : deleteDocumentControl Dao ends");
		return response;

	}

	// view Document Control Details
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewDocumentDetails(String userId, String organization, String orgDivision,
			String docId) {
		logger.info("Method : viewDocumentDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @userId='" + userId + "',@org='" + organization + "',@orgDivision='" + orgDivision
					+ "',@doc_Id='" + docId + "';";
			System.out.println("docId values=>" + value);

			Object x = em.createNamedStoredProcedureQuery("documentControlRoutines")
					.setParameter("actionType", "viewDocumentDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully.");
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
		logger.info("Method : viewDocumentDetails Dao ends" + resp);
		return resp;

	}

// Document Control Access View
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> documentAccessView(String id, String userId, String organization, String orgDivision) {
		logger.info("Method : documentAccessView Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_docId='" + id + "',@p_userId='" + userId + "',@p_organization='" + organization
					+ "',@p_orgDivision='" + orgDivision + "';";
			System.out.println("value" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("documentControlRoutines")
					.setParameter("actionType", "documentAccessView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : documentAccessView Dao ends" + resp);
		return resp;
	}

	// Modify document control

	public ResponseEntity<JsonResponse<List<RestDocumentControlModel>>> uploadDocumentModify(
			List<RestDocumentControlModel> restDocumentControlModel) {

		logger.info("Method : uploadDocumentModify starts");

		JsonResponse<List<RestDocumentControlModel>> resp = new JsonResponse<List<RestDocumentControlModel>>();
		Gson gson = new Gson();
		String jsonString = gson.toJson(restDocumentControlModel);
		System.out.println("Json String === " + jsonString);
		JsonArray jsonArray = JsonParser.parseString(jsonString).getAsJsonArray();
		String docid = "";
		String organization = "";
		String orgDivision = "";

		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
			docid = jsonObject.get("docid").getAsString();
			organization = jsonObject.get("organization").getAsString();
			orgDivision = jsonObject.get("orgDivision").getAsString();
			System.out.println("docid: " + docid + " " + organization + " " + orgDivision);
			System.out.println("jsonObject" + jsonObject);
			System.out.println("jsonArray: " + jsonArray);
		}

		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
			docid = jsonObject.get("docid").getAsString();
			System.out.println("jsonObject" + jsonObject);
		}
		try {
			String value = "SET @p_docId='" + docid + "',jsonString='" + jsonString + "',@p_organization='"
					+ organization + "',@p_orgDivision='" + orgDivision + "';";
			System.out.println("MODIFY" + value);
			em.createNamedStoredProcedureQuery("documentControlRoutines").setParameter("actionType", "documentModify")
					.setParameter("actionValue", jsonString).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<List<RestDocumentControlModel>>> response = new ResponseEntity<JsonResponse<List<RestDocumentControlModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : uploadDocumentModify ends");

		return response;

	}

	public ResponseEntity<JsonResponse<RestDocumentControlModel>> uploadfolderModify(
			RestDocumentControlModel restDocumentControlModel) {

		logger.info("Method : uploadfolderModify starts");

		JsonResponse<RestDocumentControlModel> resp = new JsonResponse<RestDocumentControlModel>();
		Gson gson = new Gson();
		String jsonString = gson.toJson(restDocumentControlModel);

		try {
			em.createNamedStoredProcedureQuery("documentControlRoutines")
					.setParameter("actionType", "uploadfolderModify").setParameter("actionValue", jsonString).execute();

		}

		catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<RestDocumentControlModel>> response = new ResponseEntity<JsonResponse<RestDocumentControlModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response====" + resp);
		logger.info("Method : uploadfolderModify ends");

		return response;

	}

	// view Document Control Details
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> documentControlViewHistory(String userId, String organization, String orgDivision,
			String docId) {
		logger.info("Method : documentControlViewHistory Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @userId='" + userId + "',@organization='" + organization + "',@orgDivision='"
					+ orgDivision + "',@p_docId='" + docId + "';";
			System.out.println("values=>" + value);

			Object x = em.createNamedStoredProcedureQuery("documentControlRoutines")
					.setParameter("actionType", "viewDocumentControlHistory").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully.");
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
		logger.info("Method : documentControlViewHistory Dao ends" + resp);
		return resp;

	}

	// view Document Workflow Details
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> documentControlViewworkFlow(String userId, String organization, String orgDivision,
			String docId) {
		logger.info("Method : documentControlViewworkFlow Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @userId='" + userId + "',@organization='" + organization + "',@orgDivision='"
					+ orgDivision + "',@p_docId='" + docId + "';";
			System.out.println("values=>" + value);
			Object x = em.createNamedStoredProcedureQuery("documentControlRoutines")
					.setParameter("actionType", "documentControlViewworkFlow").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully.");
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
		logger.info("Method : documentControlViewworkFlow Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<RestDocumentControlModel> getAlluserEmailId(String userid, String docid, String orgName,
			String orgDiv) {
		logger.info("Method : getAlluserEmailId starts");

		List<RestDocumentControlModel> getList = new ArrayList<RestDocumentControlModel>();

		try {
			String values = "SET @p_userid='" + userid + "', @p_docid='" + docid + "', @p_org='" + orgName
					+ "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("documentControlRoutines")
					.setParameter("actionType", "getAlluserEmailId").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

					RestDocumentControlModel dropDownModel = new RestDocumentControlModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7]);

					getList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("Method : getAlluserEmailId ends" + getList);
		return getList;
	}

	public ResponseEntity<JsonResponse<List<RestDocumentControlModel>>> sendMailToAllAccessor(String userid,
			String mailDate, String subject, String messages, String emailId, String empId, String empName,
			String docid, String fileName, String groupId, String documentUrl, String orgName, String orgDivision) {
		logger.info("Method : sendMailToAllAccessor starts");

		JsonResponse<List<RestDocumentControlModel>> resp = new JsonResponse<List<RestDocumentControlModel>>();
		List<RestDocumentControlModel> rs = new ArrayList<RestDocumentControlModel>();

		// List<InventoryVendorDocumentModel> docListt = new
		// ArrayList<InventoryVendorDocumentModel>();

		try {

			String value = "SET @p_userid='" + userid + "',@p_mailDate='" + mailDate + "'," + "@p_subject='" + subject
					+ "',@p_messages='" + messages + "'," + "@p_emailId='" + emailId + "',@p_empId='" + empId
					+ "',@p_empName='" + empName + "'," + "@p_docid='" + docid + "',@p_fileName='" + fileName
					+ "',@p_groupId='" + groupId + "' ,@p_documentUrl='" + documentUrl + "', @p_orgName='" + orgName
					+ "',@p_orgDivision='" + orgDivision + "';";

			logger.info("value===========" + value);
			try {
				@SuppressWarnings("unchecked")
				List<Object[]> x = em.createNamedStoredProcedureQuery("documentControlRoutines")
						.setParameter("actionType", "addSendMailToAllAccessor").setParameter("actionValue", value)
						.getResultList();

				for (Object[] m : x) {
					RestDocumentControlModel dropDownModel = new RestDocumentControlModel(m[0], m[1], m[2], m[3], null,
							null, null, null);
					rs.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			resp.setBody(rs);
			resp.setCode("success");
		} catch (Exception e) {

			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestDocumentControlModel>>> response = new ResponseEntity<JsonResponse<List<RestDocumentControlModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("resp===" + resp);
		logger.info("Method : sendMailToAllAccessor ends");
		return response;
	}

	// Email Reminder

	public JsonResponse<Object> getAllEMailData() {
		logger.info("Method : getAllEMailData DAO Starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			Object x = em.createNamedStoredProcedureQuery("documentControlRoutines")
					.setParameter("actionType", "getAllEMailData").setParameter("actionValue", "").getSingleResult();
			resp.setBody(x);
			resp.setMessage("Email Data Fetch Successfully.");
			resp.setCode("Success");
			System.out.println(x);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		logger.info("Method : getAllEMailData Dao Ends");
		return resp;
	}

	public ResponseEntity<JsonResponse<RestWorkFlowModel>> addWorkFlow(RestWorkFlowModel restWorkFlowModel) {

		logger.info("Method : addWorkFlow starts" + restWorkFlowModel);

		JsonResponse<RestWorkFlowModel> resp = new JsonResponse<RestWorkFlowModel>();
		Gson gson = new Gson();
		String jsonString = gson.toJson(restWorkFlowModel);
		String documentId = restWorkFlowModel.getDocId();
		String workFlowId = restWorkFlowModel.getWorkFlowId();
		try {
			String value = "SET @datas='" + jsonString + "',@p_documentId='" + documentId + "'" + ",@p_workFlowId='"
					+ workFlowId + "';";
			if (StringUtil.isNull(restWorkFlowModel.getWorkFlowId())) {
				System.out.println("Json String === " + value);
				em.createNamedStoredProcedureQuery("documentControlRoutines").setParameter("actionType", "addWorkFlow")
						.setParameter("actionValue", value).execute();
			} else {

				System.out.println("value === " + value);
				em.createNamedStoredProcedureQuery("documentControlRoutines")
						.setParameter("actionType", "modifyWorkFlow").setParameter("actionValue", value).execute();
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<RestWorkFlowModel>> response = new ResponseEntity<JsonResponse<RestWorkFlowModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response====" + resp);
		logger.info("Method : addWorkFlow ends");

		return response;
	}

	public ResponseEntity<JsonResponse<List<RestDocumentControlModel>>> documentFolderModify(
			List<RestDocumentControlModel> restDocumentControlModel) {

		logger.info("Method : documentFolderModify starts");
		JsonResponse<List<RestDocumentControlModel>> resp = new JsonResponse<List<RestDocumentControlModel>>();
		Gson gson = new Gson();
		String jsonString = gson.toJson(restDocumentControlModel);
		System.out.println("Json String === " + jsonString);
		JsonArray jsonArray = JsonParser.parseString(jsonString).getAsJsonArray();
		String docid = "";

		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
			docid = jsonObject.get("docid").getAsString();
			System.out.println("docid: " + docid);
			System.out.println("jsonObject" + jsonObject);
			System.out.println("jsonArray: " + jsonArray);
		}
		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
			docid = jsonObject.get("docid").getAsString();
		}
		try {
				String value = "SET @datas='" + jsonString + "',@p_docId='"+docid+"';";
				System.out.println("Document Value" + value);
				em.createNamedStoredProcedureQuery("documentControlRoutines")
						.setParameter("actionType", "documentFolderModify").setParameter("actionValue", jsonString).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		ResponseEntity<JsonResponse<List<RestDocumentControlModel>>> response = new ResponseEntity<JsonResponse<List<RestDocumentControlModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : documentFolderModify ends");
		return response;
	}
	
	// view Document Control Version Details
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewDocumentControlVersion(String userId, String organization, String orgDivision,
				String docId) {
			logger.info("Method : viewDocumentControlVersion Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @userId='" + userId + "',@org='" + organization + "',@orgDivision='" + orgDivision
						+ "',@doc_Id='" + docId + "';";
				System.out.println("docId values=>" + value);

				Object x = em.createNamedStoredProcedureQuery("documentControlRoutines")
						.setParameter("actionType", "viewDocumentVersion").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x);
				resp.setCode("Success");
				resp.setMessage("Data Fetched Successfully.");
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
			logger.info("Method : viewDocumentControlVersion Dao ends" + resp);
			return resp;

		}
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> folderList(String id,String userId,String organization,String orgDivision) {
			logger.info("Method : folderList starts");

			List<DropDownModel> folderList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			String value = "SET @p_status='" + id + "',@p_userId='"+userId+"'"
					+ ",@p_organization='"+organization+"',@p_orgDivision='"+orgDivision+"';";

			logger.info("########" + value);

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("documentControlRoutines")
						.setParameter("actionType", "getFolderListWorkflowWise").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					folderList.add(dropDownModel);
				}
				resp.setBody(folderList);
				if (folderList.size() > 0) {
					Util.setJsonResponse(resp, folderList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
				} else {
					Util.setJsonResponse(resp, folderList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error " + e.getMessage());
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}

			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : folderList ends"+response);
			return response;
		}
		
		// Email Reminder

		public JsonResponse<Object> getAllWorkFlowDocument() {
			logger.info("Method : getAllEMailData DAO Starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				Object x = em.createNamedStoredProcedureQuery("documentControlRoutines")
						.setParameter("actionType", "getAllDocumentWorkFlow").setParameter("actionValue", "").getSingleResult();
				resp.setBody(x);
				resp.setMessage("WorkFlow Document Fetch Successfully.");
				resp.setCode("Success");
				System.out.println(x);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			logger.info("Method : getAllWorkFlowDocument Dao Ends");
			return resp;
		}
		
		
		//Lock File
		public ResponseEntity<JsonResponse<RestDocumentControlModel>> lockFile(
				RestDocumentControlModel restDocumentControlModel) {
			logger.info("Method : lockFile dao starts" + restDocumentControlModel);
			JsonResponse<RestDocumentControlModel> resp = new JsonResponse<RestDocumentControlModel>();
			try {
				String value = "SET @p_docId='" + restDocumentControlModel.getDocid() + "'" + ",@p_organization='"
						+ restDocumentControlModel.getOrganization() + "'" + ",@p_orgDivision='"
						+ restDocumentControlModel.getOrgDivision() + "',@p_createdBy='"+restDocumentControlModel.getCreatedBy()+"';";

				em.createNamedStoredProcedureQuery("documentControlRoutines")
						.setParameter("actionType", "lockFile").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("File WIll be Locked");

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					e.printStackTrace();
					Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
					e.printStackTrace();
					Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				}
				e.printStackTrace();
			}

			ResponseEntity<JsonResponse<RestDocumentControlModel>> response = new ResponseEntity<JsonResponse<RestDocumentControlModel>>(
					resp, HttpStatus.CREATED);
			System.out.println("response===" + response);
			logger.info("Method : lockFile dao ends");
			return response;

		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getDocumentNotification(String userId, String type) {
			logger.info("Method : getDocumentNotification starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();
			System.out.println("type---------------->>>>>>>>>>" + type);
			try {
					List<Object> x = em.createNamedStoredProcedureQuery("documentControlRoutines")
							.setParameter("actionType", "dmsNotification").setParameter("actionValue", userId)
							.getResultList();

					if (x.size() > 0 && x.get(0) != null) {
						resp.setBody(x.get(0));
						resp.setMessage("Notifications fetched successfully.");
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

			logger.info("Method : getDocumentNotification ends");
			return resp;
		}
		
		// Notification Update
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> notificationUpdate(String id, String userId, String organization, String orgDivision) {
			logger.info("Method : notificationUpdate Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_notificationId='" + id + "',@p_userId='" + userId + "',@p_organization='" + organization
						+ "',@p_orgDivision='" + orgDivision + "';";
				System.out.println("valueDOCUMENT" + value);
				List<Object[]> x = 
						em.createNamedStoredProcedureQuery("documentControlRoutines")
						.setParameter("actionType", "notificationUpdate").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : notificationUpdate Dao ends" + resp);
			return resp;
		}
}
