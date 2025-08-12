package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAdvanceManagementParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.PushNotification;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestAdvanceManagementDao {
	Logger logger = LoggerFactory.getLogger(RestAdvanceManagementDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	PushNotification pushNotification = new PushNotification();

	// get Advance PolicyList;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAdvancePolicyList(String userId, String org, String orgDiv) {
		logger.info("Method : getAdvancePolicyList starts");

		List<DropDownModel> advancePolicyList = new ArrayList<DropDownModel>();
		String value = "SET @p_userId='" + userId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
					.setParameter("actionType", "getAdvancePolicyList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				advancePolicyList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAdvancePolicyList ends");

		return advancePolicyList;
	}

	// Employee list

	@SuppressWarnings("unchecked")
	public List<DropDownModel> employeeList(String userId, String organization, String orgDivision) {
		logger.info("Method : employeeList Dao starts");

		List<DropDownModel> employeelist = new ArrayList<DropDownModel>();
		String value = "SET @p_empid='" + userId + "',@p_organization='" + organization + "',@p_orgDivision='"
				+ orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
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

	// get Advance PolicyListapi;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAdvancePolicyListApi(String userId) {
		logger.info("Method : getAdvancePolicyListApi starts");

		List<DropDownModel> advancePolicyList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_userId='" + userId + "';";
		logger.info("value===" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
					.setParameter("actionType", "getAdvancePolicyList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				advancePolicyList.add(dropDownModel);

			}
			if (advancePolicyList.size() > 0) {
				Util.setJsonResponse(resp, advancePolicyList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, advancePolicyList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getAdvancePolicyListApi ends");
		return response;
	}

	// get advance policy details by policyid

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>> getPolicyDetails(String reqPolicyId) {
		logger.info("Method : getPolicyDetails starts");

		DropDownModel policydetails = new DropDownModel();
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();

		try {
			// String value = "SET @p_empId=\"" + userId + "\",@p_userRole='(" + userRole +
			// ")';";
			String value = "SET @p_reqPolicyId='" + reqPolicyId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
					.setParameter("actionType", "getPolicyDetailsById").setParameter("actionValue", value)
					.getResultList();
			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.failed, ApiResponseMessage.NO_DATA_FOUND);
			}
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString(), m[2].toString());
				policydetails = dropDownModel;
				if (dropDownModel.equals("")) {
					resp.setBody(dropDownModel);
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setBody(dropDownModel);
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			resp.setBody(policydetails);
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("viewReimbursement: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(policydetails);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
				responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getPolicyDetails ends");
		return response;
	}

	// Save Advance apply
	public ResponseEntity<JsonResponse<Object>> saveAdvanceDetailsApply(RestAdvanceManagementModel advance) {
		logger.info("Method : saveAdvanceDetailsApply starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("advance===" + advance);
		try {

			String value = GenerateAdvanceManagementParam.getAdvManageParam(advance);

			if (advance.getAdvanceId() == null || advance.getAdvanceId() == "") {
				em.createNamedStoredProcedureQuery("hrmsadvanceroutines").setParameter("actionType", "addAdvanceApply")
						.setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Advance Saved Successfully");

//				List<DropDownModel> managerByUesr = checkDuplicateDao.getManagerByUser(advance.getEmpID());
//				for (DropDownModel m : managerByUesr) {
//					String msg = m.getName() + " apply for Advance";
//					try {
//						String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);
//
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
			} else {
				em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
						.setParameter("actionType", "modifyAdvanceApply").setParameter("actionValue", value).execute();
				// Util.setJsonResponse(resp, null, ResponseStatus.success,"Information updated
				// scuccessfully.");

				resp.setCode("success");
				resp.setMessage("Advance Modified Successfully");
			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);

				resp.setCode("failed");
				resp.setMessage("Something went wrong");

			} catch (Exception e1) {
				e1.printStackTrace();
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
			}

		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("response===" + response);
		logger.info("Method : saveAdvanceDetailsApply ends");

		return response;
	}

	// view advance Apply
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestAdvanceManagementModel>> viewAdvanceApply(String userId, String userRole,
			String organization, String orgDivision, String selftype) {
		logger.info("Method : viewAdvanceApply starts");
		JsonResponse<List<RestAdvanceManagementModel>> resp = new JsonResponse<List<RestAdvanceManagementModel>>();
		List<RestAdvanceManagementModel> advapply = new ArrayList<RestAdvanceManagementModel>();
		try {
			String value = "SET @p_empId=\"" + userId + "\",@p_type=\"" + selftype + "\",@p_userRole='(" + userRole
					+ ")', @p_org=\"" + organization + "\", @p_orgDiv=\"" + orgDivision + "\";";
			logger.info("value====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
					.setParameter("actionType", "viewAdvanceApply").setParameter("actionValue", value).getResultList();
			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
			for (Object[] m : x) {
				Object DATE = null;
				if (m[6] != null) {
					DATE = m[6].toString();
				}
				Object CREATEDON = null;
				if (m[7] != null) {
					CREATEDON = m[7].toString();
				}
				Object ApproveDate = null;
				if (m[12] != null) {
					ApproveDate = m[12].toString();
				}
				RestAdvanceManagementModel adv = new RestAdvanceManagementModel(m[0], m[1], m[2], m[3], m[4], m[5],
						DATE, CREATEDON, m[8], m[9], m[10], m[11], ApproveDate, m[13], m[14], m[15]);
				advapply.add(adv);
			}
			if (advapply.size() > 0) {
				resp.setBody(advapply);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(advapply);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("viewReimbursement: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(advapply);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(advapply);
		logger.info("Method : viewAdvanceApply ends");
		return resp;
	}

	// edit Advance apply
	@SuppressWarnings("unchecked")
	public JsonResponse<RestAdvanceManagementModel> editAdvanceApply(String id) {
		logger.info("Method : editAdvanceApply dao starts");

		RestAdvanceManagementModel req = new RestAdvanceManagementModel();
		JsonResponse<RestAdvanceManagementModel> resp = new JsonResponse<RestAdvanceManagementModel>();
		try {
			String value = "SET @p_approveId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
					.setParameter("actionType", "editAdvanceApply").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestAdvanceManagementModel reqEdit = new RestAdvanceManagementModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9].toString(), m[10].toString());
				req = reqEdit;
			}
			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("unsuccess");
			resp.setMessage("Data not found");
		}

		logger.info("Method : editAdvanceApply dao ends");
		return resp;
	}

	// delete advance apply details

	public JsonResponse<RestAdvanceManagementModel> deleteAdvanceApply(String id) {
		logger.info("Method : deleteAdvanceApply dao starts");
		JsonResponse<RestAdvanceManagementModel> resp = new JsonResponse<RestAdvanceManagementModel>();
		try {
			String value = "SET @p_advanceId='(" + id + ")';";
			em.createNamedStoredProcedureQuery("hrmsadvanceroutines").setParameter("actionType", "deleteAdvanceApply")
					.setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, "Advance deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		logger.info("Method : deleteAdvanceApply dao ends " + resp);
		return resp;
	}

	// approve advance
	public JsonResponse<RestAdvanceManagementModel> approveAdvanceApply(String id, String name, String comment,
			String roleid) {
		logger.info("Method : approveAdvanceApply starts");

		RestAdvanceManagementModel req = new RestAdvanceManagementModel();
		JsonResponse<RestAdvanceManagementModel> resp = new JsonResponse<RestAdvanceManagementModel>();

		try {

			String value = "SET @p_requisitionId='" + id + "',@p_approveBy='" + name + "',@p_comment='" + comment
					+ "',@p_userRole='(" + roleid + ")';";

			em.createNamedStoredProcedureQuery("hrmsadvanceroutines").setParameter("actionType", "approveAdvanceApply")
					.setParameter("actionValue", value).execute();
			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Advance Approved Successfully");
			List<DropDownModel> managerByUesr = checkDuplicateDao.getUserByRequisitionId(id, name);
			for (DropDownModel m : managerByUesr) {
				String msg = m.getName() + " approved your Advance";
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
					resp.setMessage("You have already advance approved");
				} else {
					resp.setCode("failed");
					resp.setMessage("Something went wrong");
				}
				// resp.setMessage(err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
			logger.error("approveAdvanceApply: " + e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : approveAdvanceApply ends");
		return resp;
	}

	// reject advance
	public JsonResponse<RestAdvanceManagementModel> rejectAdvanceApply(String id, String name, String comment) {
		logger.info("Method : rejectAdvanceApply starts");

		RestAdvanceManagementModel req = new RestAdvanceManagementModel();
		JsonResponse<RestAdvanceManagementModel> resp = new JsonResponse<RestAdvanceManagementModel>();
		try {
			String value = "SET @p_requisitionId='" + id + "',@p_rejectBy='" + name + "',@p_comment='" + comment + "';";
			em.createNamedStoredProcedureQuery("hrmsadvanceroutines").setParameter("actionType", "rejectAdvanceApply")
					.setParameter("actionValue", value).execute();
			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Advance rejected successfully");
			List<DropDownModel> managerByUesr = checkDuplicateDao.getUserByRequisitionId(id, name);
			for (DropDownModel m : managerByUesr) {
				String msg = m.getName() + " rejected your Advance";
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
					resp.setMessage("You are already advance rejected");
				} else {
					resp.setCode("failed");
					resp.setMessage("Something went wrong");
				}
				// resp.setMessage(err[1]);
			} catch (Exception e1) {
				resp.setCode("failed");
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
			logger.error("rejectAdvanceApply: " + e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : rejectAdvanceApply ends");
		return resp;
	}

	// view advance Process
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAdvanceManagementModel>>> viewAdvanceProcess(String advanceId) {
		logger.info("Method : viewAdvanceProcess starts");
		List<RestAdvanceManagementModel> advprocess = new ArrayList<RestAdvanceManagementModel>();
		try {
			String value = "SET @p_requisitionId='" + advanceId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
					.setParameter("actionType", "viewAdvanceProcess").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				RestAdvanceManagementModel adv = new RestAdvanceManagementModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], null);
				advprocess.add(adv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestAdvanceManagementModel>> resp = new JsonResponse<List<RestAdvanceManagementModel>>();
		resp.setBody(advprocess);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestAdvanceManagementModel>>> response = new ResponseEntity<JsonResponse<List<RestAdvanceManagementModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewAdvanceProcess ends");
		return response;
	}

	// Save Advance process approve
	public ResponseEntity<JsonResponse<Object>> saveAdvanceProcessApprove(RestAdvanceManagementModel advance) {
		logger.info("Method : saveAdvanceProcessApprove starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = GenerateAdvanceManagementParam.getProcessApproveParam(advance);
			System.err.println("value=====================================================" + value);
			em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
					.setParameter("actionType", "addAdvanceProcessApprove").setParameter("actionValue", value)
					.execute();
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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveAdvanceProcessApprove ends");
		return response;
	}

	// view EMI Details
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> viewEmiDetails(String advanceId, String empId) {
		logger.info("Method : viewEmiDetails starts");
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		List<DropDownModel> emidetails = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_requisitionId='" + advanceId + "',@p_empId='" + empId + "';";
			System.err.println("value==" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
					.setParameter("actionType", "viewEmiDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object DATE = null;
				if (m[1] != null) {
					DATE = m[1].toString();
				}

				DropDownModel emi = new DropDownModel(m[0], DATE, m[2].toString());
				emidetails.add(emi);
				System.err.println("emi==" + emi);
			}
			Util.setJsonResponse(resp, emidetails, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, emidetails, ResponseStatus.success, ApiResponseMessage.DATA_FECTH_FAILED);
		}

		resp.setBody(emidetails);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewEmiDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAdvanceManagementModel>>> viewEmiDetailss(String advanceId,
			String empId) {
		logger.info("Method : viewEmiDetails starts");
		JsonResponse<List<RestAdvanceManagementModel>> resp = new JsonResponse<List<RestAdvanceManagementModel>>();
		List<RestAdvanceManagementModel> emidetails = new ArrayList<RestAdvanceManagementModel>();
		try {
			String value = "SET @p_requisitionId='" + advanceId + "',@p_empId='" + empId + "';";

			System.err.println("value==" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
					.setParameter("actionType", "viewEmiDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestAdvanceManagementModel emi = new RestAdvanceManagementModel(m[0], m[1], m[2], m[3], m[4]);
				emidetails.add(emi);
				System.err.println("emi==" + emi);
			}
			Util.setJsonResponse(resp, emidetails, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, emidetails, ResponseStatus.success, ApiResponseMessage.DATA_FECTH_FAILED);
		}

		resp.setBody(emidetails);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestAdvanceManagementModel>>> response = new ResponseEntity<JsonResponse<List<RestAdvanceManagementModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewEmiDetails ends");
		return response;
	}

	// view advance Apply Api
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestAdvanceManagementModel>> viewAdvanceApplyApi(String userId, String organization,
			String orgDivision) {
		logger.info("Method : viewAdvanceApplyApi starts");
		JsonResponse<List<RestAdvanceManagementModel>> resp = new JsonResponse<List<RestAdvanceManagementModel>>();
		List<RestAdvanceManagementModel> advapply = new ArrayList<RestAdvanceManagementModel>();
		try {
			String value = "SET @p_empId=\"" + userId + "\", @p_org=\"" + organization + "\", @p_orgDiv=\""
					+ orgDivision + "\";";
			logger.info("value====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
					.setParameter("actionType", "viewAdvanceApplyApi").setParameter("actionValue", value)
					.getResultList();
			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
			for (Object[] m : x) {
				Object DATE = null;
				if (m[6] != null) {
					DATE = m[6].toString();
				}
				Object CREATEDON = null;
				if (m[7] != null) {
					CREATEDON = m[7].toString();
				}
				Object ApproveDate = null;
				if (m[12] != null) {
					ApproveDate = m[12].toString();
				}
				RestAdvanceManagementModel adv = new RestAdvanceManagementModel(m[0], m[1], m[2], m[3], m[4], m[5],
						DATE, CREATEDON, m[8], m[9], m[10], m[11], ApproveDate, m[13], null, null);
				advapply.add(adv);
			}
			if (advapply.size() > 0) {
				resp.setBody(advapply);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(advapply);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("viewAdvanceApplyApi: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(advapply);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(advapply);
		logger.info("Method : viewAdvanceApplyApi ends");
		return resp;
	}

	// Edit Emi
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editEmiData(String id, String date, String orgName, String orgDivision) {
		logger.info("Method : editEmiData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_id='" + id + "',@p_date='" + date + "',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsadvanceroutines")
					.setParameter("actionType", "editEmiData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editEmiData Dao ends");
		logger.info("resp**************EDIT**************" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> modifyemi(String advanceId, String dueDate, String dueDateNew, String empId,
			String orgName, String orgDiv) {
		logger.info("Method : modifyemi Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		// String dueDate1 =DateFormatter.getStringDate(dueDate);
		String dueDateN = DateFormatter.getStringDate(dueDateNew);

		try {
			String value = "SET @p_advanceId='" + advanceId + "',@p_dueDate='" + dueDate + "',@p_dueDateN='" + dueDateN
					+ "',@p_empId='" + empId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("values****************************" + value);
			em.createNamedStoredProcedureQuery("hrmsadvanceroutines").setParameter("actionType", "modifyemi")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Saved Successfully");
			// resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : modifyemi Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	public ResponseEntity<JsonResponse<Object>> saveAdvanceEMI(List<RestAdvanceManagementModel> advance) {
		logger.info("Method : saveAdvanceEMI starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = GenerateAdvanceManagementParam.getPreCloseAdvanceEMI(advance);
			System.err.println(
					"value  getPreCloseAdvanceEMI=====================================================" + value);
			em.createNamedStoredProcedureQuery("hrmsadvanceroutines").setParameter("actionType", "saveAdvanceEMI")
					.setParameter("actionValue", value).execute();
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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveAdvanceEMI ends");
		return response;
	}
}
