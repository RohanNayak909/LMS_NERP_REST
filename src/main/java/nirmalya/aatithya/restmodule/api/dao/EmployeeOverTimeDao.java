package nirmalya.aatithya.restmodule.api.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.model.EmployeeOverTimeLocationModel;
import nirmalya.aatithya.restmodule.api.model.EmployeeOverTimeModel;
import nirmalya.aatithya.restmodule.api.model.OvertimePunchinDetaillsModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeOverTimeAssignParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateovertimePunchInParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.PushNotification;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class EmployeeOverTimeDao {
	Logger logger = LoggerFactory.getLogger(EmployeeOverTimeDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager entityManager;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	PushNotification pushNotification = new PushNotification();

	// Department List Api
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getDepartmentListApi(String organization, String orgDivision) {
		logger.info("Method : getDepartmentListApi  Dao starts");

		List<DropDownModel> depList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String value = "SET @p_org=\"" + organization + "\",@p_orgDiv=\"" + orgDivision + "\";";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
					.setParameter("actionType", "getDepartmentList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				depList.add(dropDownModel);
			}
			if (depList.size() > 0) {
				resp.setBody(depList);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(depList);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("getDepartmentListApi: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(depList);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(depList);
		logger.info("REEESSSPPP===" + resp);
		logger.info("Method : getDepartmentListApi  Dao ends");
		return resp;
	}

	// sub-Department List Api
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getSubDepartmentListApi(String organization, String orgDivision,
			String deptId) {
		logger.info("Method : getSubDepartmentListApi  Dao starts");

		List<DropDownModel> subdepList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String values = "SET @p_departmentId='" + deptId + "',@p_organization='" + organization + "',@p_orgDivision='"
				+ orgDivision + "';";
		logger.info("values===" + values);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getSubdepartmentList").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel item = new DropDownModel(m[0], m[1]);
				subdepList.add(item);
			}
			if (subdepList.size() > 0) {
				resp.setBody(subdepList);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(subdepList);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("getSubDepartmentListApi: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(subdepList);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(subdepList);
		logger.info("REEESSSPPP===" + resp);
		logger.info("Method : getSubDepartmentListApi  Dao ends");
		return resp;
	}

	// Function for viewEmployeeOverTimeAssignDetails
	@SuppressWarnings("unchecked")
	public JsonResponse<List<EmployeeOverTimeModel>> viewEmployeeOverTimeAssignDetails(String date, String userId,
			String dept, String subDept, String organization, String orgDivision) {
		logger.info("Method : viewEmployeeOverTimeAssignDetails starts");

		List<EmployeeOverTimeModel> otEmpList = new ArrayList<EmployeeOverTimeModel>();
		JsonResponse<List<EmployeeOverTimeModel>> resp = new JsonResponse<List<EmployeeOverTimeModel>>();

		String value = "SET @P_date=\"" + DateFormatter.getStringDate(date) + "\",@P_userId=\"" + userId
				+ "\",@P_dept=\"" + dept + "\",@P_subDept=\"" + subDept + "\"," + "@p_org=\"" + organization
				+ "\",@p_orgDiv=\"" + orgDivision + "\";";
		logger.info("VALUE viewEmployeeOverTimeDetails  =====" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_employee_overtimeRoutines")
					.setParameter("actionType", "viewEmployeeOverTimeAssignDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				/*
				 * Object otDate = null; if (m[5] != null) { otDate =
				 * DateFormatter.returnStringDate(m[5]); }
				 */
				EmployeeOverTimeModel dropDownModel = new EmployeeOverTimeModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], null, null, null, m[7].toString(), null, null, null);
				otEmpList.add(dropDownModel);
			}
			if (otEmpList.size() > 0) {
				resp.setBody(otEmpList);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(otEmpList);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.error("viewEmployeeOverTimeAssignDetails: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("viewEmployeeOverTimeAssignDetails" + resp);
		logger.info("Method : viewEmployeeOverTimeAssignDetails ends");
		return resp;
	}

	// assign Over Time
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<EmployeeOverTimeModel>>> assignEmployeeOverTime(
			List<EmployeeOverTimeModel> overTimeModel) {
		logger.info("Method : assignEmployeeOverTime dao starts");
		logger.info("aaa===" + overTimeModel);
		JsonResponse<List<EmployeeOverTimeModel>> resp = new JsonResponse<List<EmployeeOverTimeModel>>();
		String value = GenerateEmployeeOverTimeAssignParam.getOverTimeParam(overTimeModel);
		logger.info("value===" + value);
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("hrms_employee_overtimeRoutines")
					.setParameter("actionType", "assignEmployeeOverTime").setParameter("actionValue", value)
					.getResultList();
			if (x.get(0)[0].toString() == null || x.get(0)[0].toString() == "" || x.get(0)[0].toString().equals(null)
					|| x.get(0)[0].toString().equals("")) {
				resp.setCode("success");
				resp.setMessage("Data saved successfully");
				for (EmployeeOverTimeModel m : overTimeModel) {
					String msg = "Hi " + m.getEmployeeName() + " You have assigned for over time work by "
							+ m.getAssignedByName();
					try {
						String msgId = pushNotification.pushFCMNotificationForOverTime(m.getEmployee(), msg);
						logger.info("msgId===="+msgId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				resp.setCode("failed");
				resp.setMessage("You have already assigned over time for this date. Please choose a different date.");
			}
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
		ResponseEntity<JsonResponse<List<EmployeeOverTimeModel>>> response = new ResponseEntity<JsonResponse<List<EmployeeOverTimeModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response===" + response);
		logger.info("Method : assignEmployeeOverTime dao ends");
		return response;
	}

	// Function for viewEmployeeOverTimeDetails
	@SuppressWarnings("unchecked")
	public JsonResponse<EmployeeOverTimeModel> viewEmployeeOverTimeDetails(String date, String userId,
			String organization, String orgDivision) {
		logger.info("Method : viewEmployeeOverTimeDetails starts");

		EmployeeOverTimeModel otEmpList = new EmployeeOverTimeModel();
		JsonResponse<EmployeeOverTimeModel> resp = new JsonResponse<EmployeeOverTimeModel>();

		String value = "SET @P_date=\"" + DateFormatter.getStringDate(date) + "\",@P_userId=\"" + userId
				+ "\",@p_org=\"" + organization + "\",@p_orgDiv=\"" + orgDivision + "\";";
		logger.info("VALUE viewEmployeeOverTimeDetails  =====" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_employee_overtimeRoutines")
					.setParameter("actionType", "viewEmployeeOverTimeDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Object otDate = null;
				if (m[6] != null) {
					otDate = DateFormatter.returnStringDate(m[6]);
				}
				Object otStart = null;
				if (m[7] != null) {
					otStart = DateFormatter.returnStringTostringDateTime(m[7].toString());
				}
				Object otEnd = null;
				if (m[8] != null) {
					otEnd = DateFormatter.returnStringTostringDateTime(m[8].toString());
				}
				EmployeeOverTimeModel dropDownModel = new EmployeeOverTimeModel(m[0], m[1], null, m[2], m[3], m[4],
						m[5], otDate, otStart, otEnd, null, m[9], null, null);
				otEmpList = dropDownModel;
			}
			if (otEmpList.equals("") || otEmpList.equals(null)) {
				resp.setBody(otEmpList);
				resp.setCode("success");
				resp.setMessage("Data not found");

			} else {
				resp.setBody(otEmpList);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.error("viewEmployeeOverTimeDetails: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("viewEmployeeOverTimeDetails" + resp);
		logger.info("Method : viewEmployeeOverTimeDetails ends");
		return resp;
	}

	/*
	 * offAssignEmployeeOverTime
	 */
	public ResponseEntity<JsonResponse<Object>> offAssignEmployeeOverTime(String date, String userId,
			String organization, String orgDivision) {
		logger.info("Method : offAssignEmployeeOverTime starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		String value = "SET @P_date=\"" + DateFormatter.getStringDate(date) + "\",@P_userId=\"" + userId
				+ "\",@p_org=\"" + organization + "\",@p_orgDiv=\"" + orgDivision + "\";";
		logger.info("VALUE viewEmployeeOverTimeDetails  =====" + value);
		try {
			em.createNamedStoredProcedureQuery("hrms_employee_overtimeRoutines")
					.setParameter("actionType", "offAssignEmployeeOverTime").setParameter("actionValue", value)
					.execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, "Over Time Off Assign successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : offAssignEmployeeOverTime dao ends" + response);

		return response;
	}

	/************************************************
	 * USER SECTION
	 ***************************************************/
	// Function for getOverTimeEmployeeWise
	@SuppressWarnings("unchecked")
	public JsonResponse<List<EmployeeOverTimeModel>> getOverTimeEmployeeWise(String date,String userId, String organization,
			String orgDivision) {
		logger.info("Method : viewEmployeeOverTimeDetails starts");
		List<EmployeeOverTimeModel> otEmpList = new ArrayList<EmployeeOverTimeModel>();
		JsonResponse<List<EmployeeOverTimeModel>> resp = new JsonResponse<List<EmployeeOverTimeModel>>();

		String value = "SET @P_date=\"" + DateFormatter.getStringDate(date) + "\",@P_userId=\"" + userId + "\",@p_org=\"" + organization + "\",@p_orgDiv=\"" + orgDivision
				+ "\";";
		logger.info("VALUE viewEmployeeOverTimeDetails  =====" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_employee_overtimeRoutines")
					.setParameter("actionType", "getOverTimeEmployeeWise").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Object otDate = null;
				if (m[6] != null) {
					otDate = DateFormatter.returnStringDate(m[6]);
				}
				Object otStart = null;
				if (m[7] != null) {
					otStart = DateFormatter.returnStringTostringDateTime(m[7].toString());
				}
				Object otEnd = null;
				if (m[8] != null) {
					otEnd = DateFormatter.returnStringTostringDateTime(m[8].toString());
				}
				Boolean boolean1 = false;
				if (m[10].toString() != null) {
					String data = m[10].toString();
					if (data.contentEquals("1")) {
						boolean1 = true;
					} else {
						boolean1 = false;
					}
				}
				Boolean boolean2 = false;
				if (m[11].toString() != null) {
					String data = m[11].toString();
					if (data.contentEquals("1")) {
						boolean2 = true;
					} else {
						boolean2 = false;
					}
				}
				EmployeeOverTimeModel dropDownModel = new EmployeeOverTimeModel(m[0], m[1], null, m[2], m[3], m[4],
						m[5], otDate, otStart, otEnd, null, m[9], boolean1, boolean2);
				otEmpList.add(dropDownModel);
			}
			if (otEmpList.size() > 0) {
				resp.setBody(otEmpList);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(otEmpList);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.error("getOverTimeEmployeeWise: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("getOverTimeEmployeeWise" + resp);
		logger.info("Method : getOverTimeEmployeeWise ends");
		return resp;
	}

	public ResponseEntity<JsonResponse<List<OvertimePunchinDetaillsModel>>> overtimePunchInDetailsData(
			OvertimePunchinDetaillsModel overTimeModel) {
		logger.info("Method : overtimePunchInDetailsData dao starts");
		logger.info("aaa===" + overTimeModel);
		JsonResponse<List<OvertimePunchinDetaillsModel>> resp = new JsonResponse<List<OvertimePunchinDetaillsModel>>();
		String value = GenerateovertimePunchInParam.getOvertimePunchInParams(overTimeModel);
		logger.info("value===" + value);
		try {
			entityManager.createNamedStoredProcedureQuery("hrms_employee_overtimeRoutines")
					.setParameter("actionType", "OvertimeCheckin").setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Data Saved Successfully");

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
		ResponseEntity<JsonResponse<List<OvertimePunchinDetaillsModel>>> response = new ResponseEntity<JsonResponse<List<OvertimePunchinDetaillsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response===" + response);
		logger.info("Method : overtimePunchInDetailsData dao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<List<OvertimePunchinDetaillsModel>>> overtimePunchOutDetailsData(
			OvertimePunchinDetaillsModel overTimeModel) {
		logger.info("Method : overtimePunchOutDetailsData dao starts");
		logger.info("aaa===" + overTimeModel);
		JsonResponse<List<OvertimePunchinDetaillsModel>> resp = new JsonResponse<List<OvertimePunchinDetaillsModel>>();
		String value = GenerateovertimePunchInParam.getOvertimePunchInParams(overTimeModel);
		logger.info("value===" + value);
		try {
			entityManager.createNamedStoredProcedureQuery("hrms_employee_overtimeRoutines")
					.setParameter("actionType", "OvertimeCheckout").setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Data Saved Successfully");
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
		ResponseEntity<JsonResponse<List<OvertimePunchinDetaillsModel>>> response = new ResponseEntity<JsonResponse<List<OvertimePunchinDetaillsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response===" + response);
		logger.info("Method : overtimePunchOutDetailsData dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<OvertimePunchinDetaillsModel>> getOvertimeAttendanceDetails(String userId, String fromdate,
			String todate, String organization, String orgDivision) {
		logger.info("Method : getOvertimeAttendanceDetails starts");
		List<OvertimePunchinDetaillsModel> otEmpList = new ArrayList<OvertimePunchinDetaillsModel>();
		JsonResponse<List<OvertimePunchinDetaillsModel>> resp = new JsonResponse<List<OvertimePunchinDetaillsModel>>();

		String value = "SET @P_userId=\"" + userId + "\",@p_fromdate=\"" + DateFormatter.getStringDate(fromdate)
				+ "\",@p_todate=\"" + DateFormatter.getStringDate(todate) + "\",@p_org=\"" + organization
				+ "\",@p_orgDiv=\"" + orgDivision + "\";";
		logger.info("VALUE viewEmployeeOverTimeDetails  =====" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_employee_overtimeRoutines")
					.setParameter("actionType", "getOvertimeAttendanceDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				
				Object date = null;
				if (m[1] != null) {
					date = DateFormatter.returnStringDate(m[1]);
				}

				Object otStart = null;
				if (m[2] != null) {
					otStart = DateFormatter.returnStringTostringDateTime(m[2].toString());
				}
				Object ndtime = null;
				if (m[6] != null) {
					ndtime = DateFormatter.returnStringTostringDateTime(m[6].toString());
				}

				OvertimePunchinDetaillsModel dropDownModel = new OvertimePunchinDetaillsModel(m[0], date, otStart, m[3],
						m[4], m[5], ndtime, m[7], m[8], m[9]);
				otEmpList.add(dropDownModel);
			}
			if (otEmpList.size() > 0) {
				resp.setBody(otEmpList);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(otEmpList);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.error("getOvertimeAttendanceDetails: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("getOvertimeAttendanceDetails" + resp);
		logger.info("Method : getOvertimeAttendanceDetails ends");
		return resp;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<EmployeeOverTimeLocationModel>> getEmpOverTimeLocation(String userid,String date,String organization, String orgDivision) {
		logger.info("Method : getEmpOverTimeLocation Dao starts");

		EmployeeOverTimeLocationModel attendanceList = new EmployeeOverTimeLocationModel();
		JsonResponse<EmployeeOverTimeLocationModel> jsonResponse = new JsonResponse<EmployeeOverTimeLocationModel>();
		try {

			String value = "SET @p_userName='" + userid + "',@p_date='" + DateFormatter.getStringDate(date) + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_employee_overtimeRoutines")
					.setParameter("actionType", "getEmpOverTimeLocation").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Boolean boolean1 = false;
				if (m[5].toString() != null) {
					String data = m[5].toString();
					if (data.contentEquals("1")) {
						boolean1 = true;
					} else {
						boolean1 = false;
					}
				}

				Boolean boolean2 = false;
				if (m[6].toString() != null) {
					String data = m[6].toString();
					if (data.contentEquals("1")) {
						boolean2 = true;
					} else {
						boolean2 = false;
					}
				}
				EmployeeOverTimeLocationModel dropDownModel = new EmployeeOverTimeLocationModel(m[0], m[1], m[2], m[3],m[4],boolean1,boolean2);
			attendanceList=dropDownModel;
			jsonResponse.setCode("success");
			jsonResponse.setMessage(ApiResponseMessage.DATA_FETCH_SUCCESS);
			}
			if (!attendanceList.equals("") && !attendanceList.equals(null)) {
				jsonResponse.setCode("success");
				jsonResponse.setMessage(ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				jsonResponse.setBody(attendanceList);
				jsonResponse.setCode("success");
				jsonResponse.setMessage("No Data Found");
			}
			jsonResponse.setBody(attendanceList);
		} catch (Exception e) {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<EmployeeOverTimeLocationModel>> response = new ResponseEntity<JsonResponse<EmployeeOverTimeLocationModel>>(
				jsonResponse, HttpStatus.OK);

		logger.info("Method : getEmpOverTimeLocation Dao ends");
		logger.info("rereee" + response);
		return response;
	}
}
