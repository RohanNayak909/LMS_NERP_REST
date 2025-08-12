package nirmalya.aatithya.restmodule.master.dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateLeaveParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.LeaveApplyRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.PushNotification;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class LeaveApplyDao {

	Logger logger = LoggerFactory.getLogger(LeaveApplyDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	@Autowired
	private EnvironmentVaribles env;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	PushNotification pushNotification = new PushNotification();

	// view leave Apply
	@SuppressWarnings("unchecked")
	public JsonResponse<List<LeaveApplyRestModel>> viewLeaveApply(String userId, String userRole, String organization,
			String orgDivision, String selftype) {

		logger.info("Method : viewLeaveApply Dao starts");
		List<LeaveApplyRestModel> viewleaveapply = new ArrayList<LeaveApplyRestModel>();
		JsonResponse<List<LeaveApplyRestModel>> resp = new JsonResponse<List<LeaveApplyRestModel>>();
		try {
			String value = "SET @p_empId=\"" + userId + "\",@p_userRole='(" + userRole + ")',@p_org=\"" + organization
					+ "\",@p_orgDiv=\"" + orgDivision + "\",@p_type=\"" + selftype + "\";";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("LeaveApply")
					.setParameter("actionType", "viewLeaveApply").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object DATE = null;
				if (m[3] != null) {
					DATE = DateFormatter.returnStringDate(m[3]);
				}
				Object CREATEDON = null;
				if (m[4] != null) {
					CREATEDON = DateFormatter.returnStringDate(m[4]);
				}
				Object fromdate = null;
				if (m[9] != null) {
					fromdate = DateFormatter.returnStringDate(m[9]);
				}
				Object todate = null;
				if (m[10] != null) {
					todate = DateFormatter.returnStringDate(m[10]);
				}

				LeaveApplyRestModel leave = new LeaveApplyRestModel(m[0], m[1], m[2], DATE, CREATEDON, m[5], m[6], m[7],
						m[8], fromdate, todate, m[11], m[12], m[13], null, m[14]);

				viewleaveapply.add(leave);

			}

			if (viewleaveapply.size() > 0) {
				resp.setBody(viewleaveapply);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");

			} else {
				resp.setBody(viewleaveapply);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			logger.error("viewLeaveApply: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(viewleaveapply);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		// logger.info("resp===" + resp);
		logger.info("Method : viewLeaveApply Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<LeaveApplyRestModel>> viewLeaveApplynew(String userid, String org, String orgDiv) {
		logger.info("Method : viewLeaveApplynew  Dao starts");

		List<LeaveApplyRestModel> viewleaveapply = new ArrayList<LeaveApplyRestModel>();

		JsonResponse<List<LeaveApplyRestModel>> resp = new JsonResponse<List<LeaveApplyRestModel>>();
		try {
			String value = "SET @P_Emp_Id='" + userid + "', @P_Org='" + org + "', @P_Org_Div='" + orgDiv + "';";
			System.err.println("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("LeaveApply")
					.setParameter("actionType", "viewLeaveApplynew").setParameter("actionValue", value).getResultList();
			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
			for (Object[] m : x) {
				System.out.println(m[0] + " " + m[1] + " " + m[2]);
				LeaveApplyRestModel leave = new LeaveApplyRestModel(m[0].toString(), m[1].toString(), m[2].toString());

				viewleaveapply.add(leave);
			}
			if (viewleaveapply.size() > 0) {
				resp.setBody(viewleaveapply);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(viewleaveapply);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("viewLeaveApply: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(viewleaveapply);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());

		}

		resp.setBody(viewleaveapply);
		logger.error("REEESSSPPP===" + resp);
		logger.info("Method : viewLeaveApplynew  Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<LeaveApplyRestModel>> editLeaveApplynew(String userid, String leaveId) {

		logger.info("Method : editLeaveApplynew  Dao starts");

		List<LeaveApplyRestModel> editleaveapply = new ArrayList<LeaveApplyRestModel>();

		JsonResponse<List<LeaveApplyRestModel>> resp = new JsonResponse<List<LeaveApplyRestModel>>();
		try {
			String value = "SET @p_empid='" + userid + "', @p_leaveId='" + leaveId + "';";
			System.err.println("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("LeaveApply")
					.setParameter("actionType", "editLeaveApplynew").setParameter("actionValue", value).getResultList();
			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
			for (Object[] m : x) {

				LeaveApplyRestModel leave = new LeaveApplyRestModel(m[0].toString(), m[1].toString(), m[2].toString());

				editleaveapply.add(leave);
			}
			if (editleaveapply.size() > 0) {
				resp.setBody(editleaveapply);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(editleaveapply);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("editLeaveApply: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(editleaveapply);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());

		}

		resp.setBody(editleaveapply);
		logger.error("REEESSSPPP===" + resp);
		logger.info("Method : editLeaveApplynew  Dao ends");
		return resp;
	}
	// leave type list

	@SuppressWarnings("unchecked")
	public List<DropDownModel> leaveTypeList(String userId, String organization, String orgDivision) {
		logger.info("Method : leaveTypeList Dao starts");

		List<DropDownModel> leaveList = new ArrayList<DropDownModel>();
		String value = "SET @p_empid='" + userId + "',@p_organization='" + organization + "',@p_orgDivision='"
				+ orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("LeaveApply")
					.setParameter("actionType", "leaveTypeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2].toString());
				leaveList.add(dropDownModel);
			}

		} catch (Exception e) {
			logger.error("leaveTypeList: " + e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : leaveTypeList Dao ends");
		System.err.println("leaveList====" + leaveList);
		return leaveList;
	}

	// Employee list

	@SuppressWarnings("unchecked")
	public List<DropDownModel> employeeList(String userId, String organization, String orgDivision) {
		logger.info("Method : employeeList Dao starts");

		List<DropDownModel> employeelist = new ArrayList<DropDownModel>();
		String value = "SET @p_empid='" + userId + "',@p_organization='" + organization + "',@p_orgDivision='"
				+ orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("LeaveApply")
					.setParameter("actionType", "employeeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employeelist.add(dropDownModel);
			}

		} catch (Exception e) {
			logger.error("employeeList: " + e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : employeeList Dao ends");
		return employeelist;
	}

	// Save leave apply  
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	public ResponseEntity<JsonResponse<List<LeaveApplyRestModel>>> addLeaveApply(List<LeaveApplyRestModel> leaveModel) {
		logger.info("Method : addLeaveApply dao starts");
		JsonResponse<List<LeaveApplyRestModel>> resp = new JsonResponse<List<LeaveApplyRestModel>>();
		List<LeaveApplyRestModel> listData = new ArrayList<LeaveApplyRestModel>();
		JSONObject json = new JSONObject();
		for (LeaveApplyRestModel m : leaveModel) {
			if (m.getDocumentFileBase() != null && m.getDocumentFileBase() != "") {
				String[] x = m.getFileName().split("\\.");
				String extension = x[x.length - 1];
				try {
					byte[] bytes = Base64.getDecoder().decode(m.getDocumentFileBase());
					json = saveAllMediaDocuments(bytes, extension, m.getCreatedBy());

				} catch (Exception e) {
					e.printStackTrace();
				}
				m.setDocumentURL(json.getString("fileurl"));
				m.setFileName(json.getString("filename"));
			}

			if (m.getLeaveApplyDate() != "" && m.getLeaveApplyDate() != null) {
				m.setLeaveApplyDate(DateFormatter.getStringDate(m.getLeaveApplyDate()));
			}
			if (m.getFromDate() != "" && m.getFromDate() != null) {
				m.setFromDate(DateFormatter.getStringDate(m.getFromDate()));
			}
			if (m.getToDate() != "" && m.getToDate() != null) {
				m.setToDate(DateFormatter.getStringDate(m.getToDate()));
			}
		}

		String value = GenerateLeaveParameter.addLeaveApply(leaveModel);
		logger.info("value======" + value);
		try {

			if (leaveModel.get(0).getLeaveId() == null || leaveModel.get(0).getLeaveId() == ""
					|| leaveModel.get(0).getLeaveId() == " " || leaveModel.get(0).getLeaveId().equals("null")
					|| leaveModel.get(0).equals("") || leaveModel.get(0).equals(" ")) {

				List<Object[]> x = em.createNamedStoredProcedureQuery("LeaveApply")
						.setParameter("actionType", "addLeaveApply").setParameter("actionValue", value).getResultList();

				if (x.get(0)[0].toString() == null || x.get(0)[0].toString() == "" || x.get(0)[0].toString().equals("0")
						|| x.get(0)[0].toString().equals(null) || x.get(0)[0].toString().equals("")) {
					resp.setCode("success");
					resp.setMessage("Leave Applied Successfully");

					List<DropDownModel> managerByUesr = checkDuplicateDao
							.getManagerByUser(leaveModel.get(0).getEmpID());
					for (DropDownModel m : managerByUesr) {
						String msg = m.getName() + " apply for Leave";
						try {
							String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else {
					resp.setCode("failed");
					resp.setMessage("You have already applied leave for this date. Please choose a different date.");
				}
			} else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("LeaveApply")
						.setParameter("actionType", "modifyLeaveApply").setParameter("actionValue", value)
						.getResultList();
				if (x.get(0)[0].toString() == null || x.get(0)[0].toString() == "" || x.get(0)[0].toString().equals("0")
						|| x.get(0)[0].toString().equals(null) || x.get(0)[0].toString().equals("")) {
					resp.setCode("success");
					resp.setMessage("Leave Modified Successfully");

				} else {
					resp.setCode("failed");
					resp.setMessage("You have already applied leave for this date. Please choose a different date.");
				}

			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
				logger.info(err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				logger.error("addLeaveApply: " + e.getMessage());
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
			e.printStackTrace();
		}

		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<LeaveApplyRestModel>>> response = new ResponseEntity<JsonResponse<List<LeaveApplyRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response===" + response);
		logger.info("Method : addLeaveApply dao ends");
		return response;
	}

	// edit leave apply

	@SuppressWarnings("unchecked")
	public JsonResponse<List<LeaveApplyRestModel>> editLeaveApply(String id) {

		logger.info("Method : editLeaveApply Dao starts");

		List<LeaveApplyRestModel> viewleaveapply = new ArrayList<LeaveApplyRestModel>();
		JsonResponse<List<LeaveApplyRestModel>> resp = new JsonResponse<List<LeaveApplyRestModel>>();

		try {

			String value = "SET @p_leaveId='" + id + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("LeaveApply")
					.setParameter("actionType", "editLeaveApply").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object FROMDATE = null;
				if (m[6] != null) {
					FROMDATE = DateFormatter.returnStringDate(m[6]);
				}
				Object TODATE = null;
				if (m[7] != null) {
					TODATE = DateFormatter.returnStringDate(m[7]);
				}
				Object DATE = null;
				if (m[2] != null) {
					DATE = DateFormatter.returnStringDate(m[2]);
				}
				Object CREATED = null;
				if (m[10] != null) {
					CREATED = DateFormatter.returnStringDate(m[10]);
				}
				Object APPROVE = null;
				if (m[11] != null) {
					APPROVE = DateFormatter.returnStringDate(m[11]);
				}
				Object REJECT = null;
				if (m[12] != null) {
					REJECT = DateFormatter.returnStringDate(m[12]);
				}
				LeaveApplyRestModel leave = new LeaveApplyRestModel(null, m[0], m[1], DATE, m[3], m[4], m[5], FROMDATE,
						TODATE, m[8], m[9], null, null, CREATED, APPROVE, REJECT, m[13], m[14], m[15].toString(),m[16]);

				viewleaveapply.add(leave);
			}
			if (viewleaveapply.size() > 0) {
				Util.setJsonResponse(resp, viewleaveapply, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, viewleaveapply, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			logger.error("editLeaveApply: " + e.getMessage());
			String[] err = serverDao.errorProcedureCall(e);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}
		resp.setBody(viewleaveapply);
		logger.info("resp===" + resp);
		logger.info("Method : editLeaveApply Dao ends");
		return resp;

	}

	// delete leave apply details

	public ResponseEntity<JsonResponse<Object>> deleteLeaveApply(String leaveId, String organization,
			String orgDivision) {
		logger.info("Method : deleteLeaveApply starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_leaveId='" + leaveId + "',@p_organization='" + organization
						+ "',@p_orgDivision='" + orgDivision + "';";
				logger.info("value==" + value);
				em.createNamedStoredProcedureQuery("LeaveApply").setParameter("actionType", "deleteLeaveApply")
						.setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Leave deleted successfully");
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode("failed");
					resp.setMessage("Something went wrong");
				} catch (Exception e1) {
					resp.setCode("failed");
					logger.error("deleteLeaveApply: " + e.getMessage());
					e1.printStackTrace();
					resp.setMessage("Something went wrong");
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteLeaveApply ends");
		logger.info("DELETEE" + response);
		return response;
	}
	// approve leave apply

	public JsonResponse<LeaveApplyRestModel> approveLeaveApply(String id, String name, String comment, String userRole,
			String dateid) {
		logger.info("Method : approveLeaveApply starts");
		String litem = "";
		String[] userIds = dateid.split(",");
		for (String a : userIds) {
			litem = litem + a + ",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		LeaveApplyRestModel req = new LeaveApplyRestModel();
		JsonResponse<LeaveApplyRestModel> resp = new JsonResponse<LeaveApplyRestModel>();
		try {
			String replacedcomment = comment.replace("'", "\\'");
			String value = "SET @p_requisitionId='" + id + "',@p_dateid='" + litem + "',@p_approveBy='" + name
					+ "',@p_comment='" + replacedcomment + "',@p_userRole='(" + userRole + ")';";
			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("LeaveApply").setParameter("actionType", "approveLeaveApply")
					.setParameter("actionValue", value).execute();
			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Leave approved successfully");

			List<DropDownModel> managerByUesr = checkDuplicateDao.getUserByRequisitionId(id, name);
			for (DropDownModel m : managerByUesr) {
				String msg = m.getName() + " approved your Leave";
				try {
					String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				if (err[1].equals("Duplicate entry 'x' for  'tbl_approval_history.PRIMARY'")) {
					resp.setCode("failed");
					resp.setMessage("You are already leave approved");
				} else {
					resp.setCode("failed");
					resp.setMessage("Something went wrong");
				}
				logger.error("approveLeaveApply: " + err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				logger.error("approveLeaveApply: " + e.getMessage());
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
			e.printStackTrace();
		}
		logger.info("resp===" + resp);
		logger.info("Method : approveLeaveApply ends");
		return resp;
	}

	// reject leave apply

	public JsonResponse<LeaveApplyRestModel> rejectLeaveApply(String id, String name, String comment) {
		logger.info("Method : rejectLeaveApply starts");

		LeaveApplyRestModel req = new LeaveApplyRestModel();
		JsonResponse<LeaveApplyRestModel> resp = new JsonResponse<LeaveApplyRestModel>();

		try {
			String replacedcomment = comment.replace("'", "\\'");
			String value = "SET @p_requisitionId='" + id + "',@p_rejectBy='" + name + "',@p_comment='" + replacedcomment + "';";

			em.createNamedStoredProcedureQuery("LeaveApply").setParameter("actionType", "rejectLeaveApply")
					.setParameter("actionValue", value).execute();

			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Leave rejected successfully");

			List<DropDownModel> managerByUesr = checkDuplicateDao.getUserByRequisitionId(id, name);
			for (DropDownModel m : managerByUesr) {
				String msg = m.getName() + " rejected your Leave";
				try {
					String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				if (err[1].equals("Duplicate entry 'x' for  'tbl_approval_history.PRIMARY'")) {
					resp.setCode("failed");
					resp.setMessage("You are already leave rejected");
				} else {
					resp.setCode("failed");
					resp.setMessage("Something went wrong");
				}
				// resp.setMessage(err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				logger.error("rejectLeaveApply: " + e.getMessage());
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
			e.printStackTrace();
		}
		logger.info("resp===" + resp);
		logger.info("Method : rejectLeaveApply ends");
		return resp;
	}

	// drop down for leave dropdown for api
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> leaveTypeListApiDao(String empid, String organization,
			String orgDivision) {
		logger.info("Method : leaveTypeListApiDao starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_empid='" + empid + "',@p_organization='" + organization + "',@p_orgDivision='"
					+ orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("LeaveApply")
					.setParameter("actionType", "leaveTypeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2].toString());
				countryList.add(dropDownModel);
			}
			if (countryList.size() > 0) {
				Util.setJsonResponse(resp, countryList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, countryList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("response===" + response);
		logger.info("Method : leaveTypeListApiDao ends");
		return response;
	}

	// view leave Apply Api
	@SuppressWarnings("unchecked")
	public JsonResponse<List<LeaveApplyRestModel>> viewLeaveApplyApi(String userId, String organization,
			String orgDivision) {

		logger.info("Method : viewLeaveApplyApi Dao starts");
		List<LeaveApplyRestModel> viewleaveapply = new ArrayList<LeaveApplyRestModel>();
		JsonResponse<List<LeaveApplyRestModel>> resp = new JsonResponse<List<LeaveApplyRestModel>>();
		try {
			String value = "SET @p_empId=\"" + userId + "\",@p_org=\"" + organization + "\",@p_orgDiv=\"" + orgDivision
					+ "\";";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("LeaveApply")
					.setParameter("actionType", "viewLeaveApplyApi").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object DATE = null;
				if (m[3] != null) {
					DATE = DateFormatter.returnStringDate(m[3]);
				}
				Object CREATEDON = null;
				if (m[4] != null) {
					CREATEDON = DateFormatter.returnStringDate(m[4]);
				}
				Object fromdate = null;
				if (m[9] != null) {
					fromdate = DateFormatter.returnStringDate(m[9]);
				}
				Object todate = null;
				if (m[10] != null) {
					todate = DateFormatter.returnStringDate(m[10]);
				}

				LeaveApplyRestModel leave = new LeaveApplyRestModel(m[0], m[1], m[2], DATE, CREATEDON, m[5], m[6], m[7],
						m[8], fromdate, todate, m[11], m[12], m[13], m[14], null);
				viewleaveapply.add(leave);
			}
			if (viewleaveapply.size() > 0) {
				resp.setBody(viewleaveapply);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(viewleaveapply);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			logger.error("viewLeaveApply: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(viewleaveapply);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("resp===" + resp);
		logger.info("Method : viewLeaveApplyApi Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getLeaveApproveDates(String id, String orgName, String orgDivision) {
		logger.info("Method : getLeaveApproveDates Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_leaveId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("LeaveApply")
					.setParameter("actionType", "getLeaveApproveDates").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getLeaveApproveDates Dao ends");
		return resp;
	}

	public JSONObject saveAllMediaDocuments(byte[] imageBytes, String ext, String user_id) {
		logger.info("Method : saveAllMedicalDocuments starts");

		String imageName = null;
		try {

			if (imageBytes != null) {
				long nowTime = new Date().getTime();

				if (ext.contentEquals("jpeg")) {
					imageName = user_id + "_" + nowTime + ".jpg";
				} else {
					imageName = user_id + "_" + nowTime + "." + ext;
				}
			}

			Path path = Paths.get(env.getFileUploadDocumenttUrl() + imageName);
			if (imageBytes != null) {
				Files.write(path, imageBytes);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = env.getMobileView() + "document/document/" + imageName;

		JSONObject json = new JSONObject();

		try {
			json.put("filename", imageName);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			json.put("fileurl", url);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("Method : saveAllMediaDocuments ends");
		return json;
	}

}
