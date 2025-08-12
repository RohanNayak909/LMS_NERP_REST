package nirmalya.aatithya.restmodule.employee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

import nirmalya.aatithya.restmodule.common.utils.GenerateReimbrusementPaymentParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateReimbursementParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ReimbrusementPaymentModel;
import nirmalya.aatithya.restmodule.employee.model.ReimbursementModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.PushNotification;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ReimbursementRestDao {

	Logger logger = LoggerFactory.getLogger(ReimbursementRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@Autowired
	EnvironmentVaribles env;
	
	PushNotification pushNotification = new PushNotification();

	/**
	 * DAO DROPDOWN reimbursement type
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getReimbursementTypeList() {
		logger.info("Method : getReimbursementTypeList starts");
		List<DropDownModel> getReimbursementTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "getReimbTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getReimbursementTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDepartment ends");
		return getReimbursementTypeList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeList(String userId) {
		logger.info("Method : getEmployeeList starts");

		List<DropDownModel> getEmployeeList = new ArrayList<DropDownModel>();
		String value = "SET @P_userId='" +userId + "';";
		System.out.println("qqqqqqqqq"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2]);
				getEmployeeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeList ends"+getEmployeeList);
		return getEmployeeList;
	}

	/**
	 * DAO DROPDOWN policy type
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPolicyTypeList() {
		logger.info("Method : getPolicyTypeList starts");
		List<DropDownModel> getPolicyTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "getPolicyType").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getPolicyTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPolicyTypeList ends");
		return getPolicyTypeList;
	}

	/*
	 * View Reimbursement
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<ReimbursementModel>> viewReimbursement(String userId, String userRole, String organization,
			String orgDivision, String type, String selfType) {

		logger.info("Method : viewReimbursement Dao starts");
		List<ReimbursementModel> viewReimbursement = new ArrayList<ReimbursementModel>();
		JsonResponse<List<ReimbursementModel>> resp = new JsonResponse<List<ReimbursementModel>>();
		try {

			String value = "SET @p_empId=\"" + userId + "\",@p_userRole='(" + userRole + ")',@p_org=\"" + organization
					+ "\",@p_orgDiv=\"" + orgDivision + "\",@p_type=\"" + type + "\",@p_selfType=\"" + selfType + "\";";
			logger.info("value===" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "viewAllReimDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object aDATE = null;
				if (m[2] != null) {
					aDATE = DateFormatter.returnStringDate(m[2]);
				}
				Object exDATE = null;
				if (m[4] != null) {
					exDATE = DateFormatter.returnStringDate(m[4]);
				}
				String imgName = null;
				if (m[17] != null && m[17] != "" && m[17] != " " && !m[17].toString().equals(" ")
						&& !m[17].toString().equals(null) && !m[17].toString().equals("")) {
					imgName = env.getMobileView() + "document/document/" + m[17].toString();
				} else {
					imgName = "";
				}

				ReimbursementModel reim = new ReimbursementModel(m[0].toString(), m[1], aDATE, m[3], exDATE,
						m[5], m[6].toString(), m[7].toString(), m[8].toString(), m[9].toString(),
						m[10].toString(),
						m[11].toString(),
						m[12].toString(),
						m[13].toString()
						, m[14].toString(),
						m[15].toString(),m[16],imgName,m[18]);

				logger.info("VIEWWW" + reim);
				viewReimbursement.add(reim);
			}

			if (viewReimbursement.size() > 0) {
				resp.setBody(viewReimbursement);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(viewReimbursement);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			logger.error("viewReimbursement: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(viewReimbursement);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : viewReimbursement Dao ends");
		logger.info("VIEWWW" + resp);
		return resp;
	}

	// For add reimbersement
	public ResponseEntity<JsonResponse<Object>> addReimbursementRestDao(ReimbursementModel req) {
		logger.info("Method : addReimbursementRestDao starts");
		logger.info("req===" + req);
		JsonResponse<Object> resp = new JsonResponse<Object>();

		logger.info("req.getFromDate before" + req.getFromDate());
		if (req.getFromDate() != "" && req.getFromDate() != null) {
			req.setFromDate(DateFormatter.getStringDate(req.getFromDate()));
		}
		logger.info("req.getFromDate" + req.getToDate());
		if (req.getToDate() != "" && req.getToDate() != null) {
			req.setToDate(DateFormatter.getStringDate(req.getToDate()));
		}
		if (req.getApplyDate() != "" && req.getApplyDate() != null) {
			req.setApplyDate(DateFormatter.getStringDate(req.getApplyDate()));
		}
		if (req.getExpenseDate1() != "" && req.getExpenseDate1() != null) {
			req.setExpenseDate1(DateFormatter.getStringDate(req.getExpenseDate1()));
		}
		try {
			String values = GenerateReimbursementParam.getReimbursementParam(req);
			logger.info(values);

			if (req.getReimbursementReqId() == null || req.getReimbursementReqId() == "") {
				em.createNamedStoredProcedureQuery("reimbursementRoutine")
						.setParameter("actionType", "addReimbursementDlts").setParameter("actionValue", values)
						.execute();
				//resp.setCode("success");
				//resp.setMessage("Data added successfully");
				Util.setJsonResponse(resp, null , ResponseStatus.success, "Reimbursement Added Successfully");

				List<DropDownModel> managerByUesr = checkDuplicateDao.getManagerByUser(req.getEmpId());

				for (DropDownModel m : managerByUesr) {
					String msg = m.getName() + " apply for Reimbursement";
					try {
						String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} else {
				logger.info("MODIFYYY" + req.getReimbursementReqId());
				em.createNamedStoredProcedureQuery("reimbursementRoutine")
						.setParameter("actionType", "modifyReimbruseiment").setParameter("actionValue", values)
						.execute();
				//resp.setCode("success");
				//resp.setMessage("Data modified successfully");
				Util.setJsonResponse(resp, null , ResponseStatus.success, "Reimbursement Modified Successfully");
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
		logger.info("respfvbnm" + resp);

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addReimbursementRestDao ends");
		return response;
	}

	// Edit Reimbursement

	@SuppressWarnings("unchecked")
	public JsonResponse<ReimbursementModel> editReimbursement(String id) {
		logger.info("Method : editReimbursement dao starts");

		ReimbursementModel req = new ReimbursementModel();
		JsonResponse<ReimbursementModel> resp = new JsonResponse<ReimbursementModel>();

		try {

			String value = "SET @p_reimbursementReqId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "editReimById").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				Object aDATE = null;
				if (m[2] != null) {
					aDATE = DateFormatter.returnStringDate(m[2]);
				}
				Object exDATE = null;
				if (m[4] != null) {
					exDATE = DateFormatter.returnStringDate(m[4]);
				}

				ReimbursementModel reqEdit = new ReimbursementModel(m[0].toString(), m[1], aDATE, m[3], exDATE, m[5],
						m[6].toString(), m[7], m[8], m[9].toString(), m[10].toString(), m[11].toString(),m[12], m[13]);

				req = reqEdit;

			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editReimbursement dao ends");
		logger.info("EDIT@@@@" + resp);
		return resp;
	}
	/*
	 * Delete Reimbursement
	 */

	public ResponseEntity<JsonResponse<Object>> deleteReimbursement(String id) {
		logger.info("Method : DeleteReimbursementdao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String value = "SET @p_reimbursementReqId='" + id + "';";

				em.createNamedStoredProcedureQuery("reimbursementRoutine")
						.setParameter("actionType", "deleteReimbursement").setParameter("actionValue", value).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);

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

		logger.info("Method : DeleteReimbursementdao ends");
		logger.info("DELETEE" + response);
		return response;
	}

	/*
	 * Add ReimbursementRest Dao
	 */

	public ResponseEntity<JsonResponse<Object>> addReimbursementTravelDetails(ReimbursementModel reimbursementModel) {
		logger.info("Method : Rest Add addReimbursementTravelDetails Type Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String values = GenerateReimbursementParam.getReimbursementParamTravel(reimbursementModel);
				logger.info("idddddddddddd" + reimbursementModel);
				if (reimbursementModel.getSlNo() != null && reimbursementModel.getSlNo() != "") {
					em.createNamedStoredProcedureQuery("reimbursementRoutine")
							.setParameter("actionType", "modifyReimbruseimentTravel")
							.setParameter("actionValue", values).execute();
					logger.info("Modify" + values);
				} else {
					em.createNamedStoredProcedureQuery("reimbursementRoutine")
							.setParameter("actionType", "addReimbursementTravel").setParameter("actionValue", values)
							.execute();
					logger.info("ADDDD" + values);
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
		logger.info("REMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM" + resp);
		logger.info("Method : Rest Add addReimbursementTravelDetails Type Dao ends");

		return response;
	}
	// View Reimbursement

	@SuppressWarnings("unchecked")
	public JsonResponse<List<ReimbursementModel>> viewReimbursementTravels() {
		logger.info("Method : viewReimbursementTravels Dao starts");

		List<ReimbursementModel> viewReimbursementTravels = new ArrayList<ReimbursementModel>();

		// logger.info("viewEmployeeDetails"+viewEmployeeDetails);
		JsonResponse<List<ReimbursementModel>> resp = new JsonResponse<List<ReimbursementModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "viewAllReimDetailsTreavels").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {

				Object DATE = null;
				if (m[4] != null) {

					DATE = m[4].toString();
				}

				ReimbursementModel restStudentModel = new ReimbursementModel(m[0], m[1], null, null, null, null, null,
						null, null, null, null, null, m[2], m[3], DATE, m[5].toString(), (Double) m[6], m[7], m[8],
						m[9], null, null, null, null, null, null, null, null, null, null, null, null);

				viewReimbursementTravels.add(restStudentModel);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("esdrftgyhujikfghj" + resp);
		resp.setBody(viewReimbursementTravels);
		logger.info("Method : viewNewEmployeeAttendances Dao ends");
		return resp;
	}

	/*
	 * Delete Reimbursement
	 * 
	 */

	public JsonResponse<ReimbursementModel> deleteReimbursementTravels(String id) {
		logger.info("Method : DeleteReimbursement dao starts");
		logger.info("idddddd" + id);
		ReimbursementModel req = new ReimbursementModel();
		JsonResponse<ReimbursementModel> resp = new JsonResponse<ReimbursementModel>();

		try {

			String value = "SET @p_reimbursementReqIdss='(" + id + ")';";
			logger.info(value);
			em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "deleteReimbursementTravels").setParameter("actionValue", value)
					.execute();

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : deleteReimbursementTravels dao ends");
		return resp;
	}

	/*
	 * Edit Reimbursement
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<ReimbursementModel> editReimbursementTravel(String id) {
		logger.info("Method : editReimbursementTravel dao starts");

		ReimbursementModel req = new ReimbursementModel();
		JsonResponse<ReimbursementModel> resp = new JsonResponse<ReimbursementModel>();

		try {

			String value = "SET @p_reimbursementReqIdss='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "editReimbruseimentTravel").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				Object EXPDATE = null;
				if (m[4] != null) {

					EXPDATE = m[4].toString();
				}

				ReimbursementModel reqEdit = new ReimbursementModel(m[0], m[1], null, null, null, null, null, null,
						null, null, null, null, m[2], m[3], EXPDATE, m[5], (Double) m[6], m[7], m[8], m[9], null, null,
						null, null, null, null, null, null, null, null, null, null);
				req = reqEdit;

			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editReimbursementTravel dao ends");
		logger.info("EDIT@@@@" + resp);
		return resp;
	}

	// Return gender
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRequisitionList() {
		logger.info("Method : getRequisitionList Dao starts");

		List<DropDownModel> getRequisitionList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "getRequisitionList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getRequisitionList Dao ends");

		return getRequisitionList;
	}

	/*
	 * drop down for payment Modes
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPaymentMode() {

		logger.info("Method in Dao: getPaymentMode starts");

		List<DropDownModel> payModeList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "getPaymentMode").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				payModeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getPaymentMode ends");

		return payModeList;
	}

	/*
	 * drop down for bank names
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBankNamesPay() {

		logger.info("Method in Dao: getBankNamesPay starts");

		List<DropDownModel> bankList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "getBankNamesPay").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bankList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method in Dao: getBankNamesPay ends");

		return bankList;
	}

	/*
	 * Add ReimbursementRest Dao
	 * 
	 */
	public JsonResponse<Object> addReimbursementPayment(ReimbrusementPaymentModel reimbursementModel) {

		logger.info("Method : addReimbursementPayment dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateReimbrusementPaymentParam.getReimbursementParamPayment(reimbursementModel);

			if (reimbursementModel.getPaymentId() != null && reimbursementModel.getPaymentId() != "") {
				logger.info("ADD" + values);
				em.createNamedStoredProcedureQuery("reimbursementRoutine")
						.setParameter("actionType", "addReimbursement").setParameter("actionValue", values).execute();

			} else {
				logger.info("M" + values);
				em.createNamedStoredProcedureQuery("reimbursementRoutine")
						.setParameter("actionType", "addReimbursementPayment").setParameter("actionValue", values)
						.execute();

			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info(err.toString());
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		logger.info("Method : addReimbursementPayment dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<ActivitylogModel> getActivityLog(String id) {
		logger.info("id" + id);
		logger.info("Method : getActivityLog starts");
		List<ActivitylogModel> activitylogModelList = new ArrayList<ActivitylogModel>();
		try {
			String value = "SET @p_reimbursementReqId='" + id + "'";
			logger.info("actvity vendor" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "getActivityLogReimbrusement").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object oa = null;
				if (m[6] != null) {
					oa = m[6].toString();
				}
				ActivitylogModel activitylogModel = new ActivitylogModel(m[0], m[1], m[2], m[3], m[4], m[5], oa);
				activitylogModelList.add(activitylogModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getActivityLog ends");
		return activitylogModelList;
	}

	// approve apply

	public JsonResponse<ReimbursementModel> approveReimbursementApply(String id, String name, String comment,
			String roleid) {
		logger.info("Method : approveReimbursementApply starts");
		if (comment != null) {
	        comment = comment.replace("'", "\\'");
	    }
		ReimbursementModel req = new ReimbursementModel();
		JsonResponse<ReimbursementModel> resp = new JsonResponse<ReimbursementModel>();
		try {

			String value = "SET @p_requisitionId='" + id + "',@p_approveBy='" + name + "',@p_comment='" + comment
					+ "',@p_userRole=\'(" + roleid + ")\';";
			logger.info("value=====" + value);
			em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "approveReimbursementApply").setParameter("actionValue", value)
					.execute();

			resp.setBody(req);
			//resp.setCode("success");
			//resp.setMessage("Reimbursement approved successfully");
			Util.setJsonResponse(resp, null , ResponseStatus.success, "Reimbursement Approved Successfully");
			List<DropDownModel> managerByUesr = checkDuplicateDao.getUserByRequisitionId(id, name);
			for (DropDownModel m : managerByUesr) {
				String msg = m.getName() + " approved your Reimbursement";
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
					resp.setMessage("You are already reimbursement approved");
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
			logger.error("approveReimbursementApply: " + e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : approveReimbursementApply ends");
		return resp;
	}

	// reject apply

	public JsonResponse<ReimbursementModel> rejectReimbursementApply(String id, String name, String comment) {
		logger.info("Method : rejectReimbursementApply starts");

		ReimbursementModel req = new ReimbursementModel();
		JsonResponse<ReimbursementModel> resp = new JsonResponse<ReimbursementModel>();

		try {

			String sanitizedComment = comment.replace("'", "''").replace("\"", "\\\"");

			String value = "SET @p_requisitionId='" + id + "',@p_rejectBy='" + name + "',@p_comment='" + sanitizedComment + "';";


			logger.info(value);
			em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "rejectReimbursementApply").setParameter("actionValue", value)
					.execute();

			resp.setBody(req);
			//resp.setCode("success");
			//resp.setMessage("Reimbursement rejected successfully");
			Util.setJsonResponse(resp, null , ResponseStatus.success, "Reimbursement Rejected Successfully");

			List<DropDownModel> managerByUesr = checkDuplicateDao.getUserByRequisitionId(id, name);
			for (DropDownModel m : managerByUesr) {
				String msg = m.getName() + " rejected your Reimbursement";
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
					resp.setMessage("You have already rejected this reimbursement");
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
			logger.error("rejectReimbursementApply: " + e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : rejectReimbursementApply ends");
		return resp;
	}

	@SuppressWarnings({ "unused" })
	public ResponseEntity<JsonResponse<Object>> reimbursementDataUpload(ReimbursementModel data) {
		logger.info("Method : reimbursementDataUpload Dao starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		if (data.getAdvanceAmount() == null || data.getAdvanceAmount() == "" || data.getAdvanceAmount().equals("")
				|| data.getAdvanceAmount().equals(null)) {
			data.setAdvanceAmount(null);
		}
		if (data.getApplyDate() != "" && data.getApplyDate() != null) {
			data.setApplyDate(DateFormatter.getStringDate(data.getApplyDate()));
		}
		if (data.getExpenseDate1() != "" && data.getExpenseDate1() != null) {
			data.setExpenseDate1(DateFormatter.getStringDate(data.getExpenseDate1()));
		}
		try {
			String values = GenerateReimbursementParam.getReimbursementParam(data);
			logger.info(values);

			if (data.getReimbursementReqId() == null || data.getReimbursementReqId() == ""
					|| data.getReimbursementReqId().equals("") || data.getReimbursementReqId().equals(null)) {
				em.createNamedStoredProcedureQuery("reimbursementRoutine")
						.setParameter("actionType", "addReimbursementDlts").setParameter("actionValue", values)
						.execute();
				jsonResponse.setCode("success");
				jsonResponse.setMessage("Reimbursement details added successfully.");

			} else {
				logger.info("MODIFYYY" + data.getReimbursementReqId());
				em.createNamedStoredProcedureQuery("reimbursementRoutine")
						.setParameter("actionType", "modifyReimbruseiment").setParameter("actionValue", values)
						.execute();
				jsonResponse.setCode("success");
				jsonResponse.setMessage("Reimbursement details updated successfully.");

			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);

				jsonResponse.setCode("failed");
				jsonResponse.setMessage("Something went wrong");

			} catch (Exception e1) {
				e1.printStackTrace();
				jsonResponse.setCode("failed");
				jsonResponse.setMessage("Something went wrong");
			}
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(jsonResponse,
				HttpStatus.OK);
		logger.info("Method : reimbursementDataUpload Dao ends");
		return response;
	}
	/*
	 * View Reimbursement
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<ReimbursementModel>> viewReimbursementApi(String userId, String organization,
			String orgDivision) {

		logger.info("Method : viewReimbursementApi Dao starts");
		List<ReimbursementModel> viewReimbursement = new ArrayList<ReimbursementModel>();
		JsonResponse<List<ReimbursementModel>> resp = new JsonResponse<List<ReimbursementModel>>();
		try {

			String value = "SET @p_empId=\"" + userId + "\",@p_org=\"" + organization + "\",@p_orgDiv=\"" + orgDivision
					+ "\";";
			logger.info("value===" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "viewAllReimDetailsApi").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object aDATE = null;
				if (m[2] != null) {
					aDATE = DateFormatter.returnStringDate(m[2]);
				}
				Object exDATE = null;
				if (m[4] != null) {
					exDATE = DateFormatter.returnStringDate(m[4]);

				}
				String imgName = null;
				if (m[16] != null && m[16] != "" && m[16] != " " && !m[16].toString().equals(" ")
						&& !m[16].toString().equals(null) && !m[16].toString().equals("")) {
					imgName = env.getMobileView() + "document/document/" + m[16].toString();
				} else {
					imgName = "";
				}
				//logger.info("m[6]==" + imgName);
				ReimbursementModel reim = new ReimbursementModel(m[0].toString(), m[1], aDATE, m[3], exDATE,
						m[5].toString(), m[6].toString(), m[7].toString(), m[8].toString(), m[9].toString(),
						m[10].toString(), m[11].toString(), m[12].toString(), m[13].toString(), m[14].toString(),
						m[15].toString(),null,imgName,m[17]);
				viewReimbursement.add(reim);
			}

			if (viewReimbursement.size() > 0) {
				resp.setBody(viewReimbursement);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(viewReimbursement);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			logger.error("viewReimbursementApi: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(viewReimbursement);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : viewReimbursementApi Dao ends");
		logger.info("VIEWWW" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<DropDownModel> getEmpData(String id) {
		
		logger.info("Method : getEmpData dao starts");
		DropDownModel req = new DropDownModel();
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		
		String value = "SET @p_empId='" +id + "';";
		System.out.println("@@@@@@@@@@@@"+value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "getEmpData").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel restaddress = new DropDownModel(m[0], m[1], m[2],m[3]);
				req = restaddress;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEmpData dao ends"+resp);
		return resp;
	}

}