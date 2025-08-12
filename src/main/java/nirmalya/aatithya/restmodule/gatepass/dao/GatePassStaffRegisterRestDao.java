package nirmalya.aatithya.restmodule.gatepass.dao;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateGatePassEntryPAram;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ticket.GenerateTicketAddManagementParm;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.gatepass.model.EmployeeAttendance;
import nirmalya.aatithya.restmodule.gatepass.model.GatePassStaffRegisterModel;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;
import nirmalya.aatithya.restmodule.ticket.model.TicketRestDocumentManagementModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@SuppressWarnings("unused")
@Repository
public class GatePassStaffRegisterRestDao {

	Logger logger = LoggerFactory.getLogger(GatePassStaffRegisterRestDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList(String org, String orgDiv) {
		logger.info("Method : getDepartmentList starts");

		List<DropDownModel> getDeptList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("gatepass_staff_register_routines")
					.setParameter("actionType", "getDepartmentList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getDeptList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentList ends");
		return getDeptList;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewGatePassStaffRegister(String orgName, String orgDivision, String dept,
			String fromdate, String todate, String pageno) {
		logger.info("Method : viewGatePassStaffRegister Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String FormDate = DateFormatter.getStringDate(fromdate);
		String ToDate = DateFormatter.getStringDate(todate);
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_dept='" + dept
					+ "',@p_fromdate='" + FormDate + "',@p_todate='" + ToDate + "',@p_pageno='" + pageno + "';";
			System.out.println("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatepass_staff_register_routines")
					.setParameter("actionType", "viewStaffRegData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewGatePassStaffRegister Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllEmployee(String orgName, String orgDivision) {
		logger.info("Method : viewGatePassStaffRegister Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("gatepass_staff_register_routines")
					.setParameter("actionType", "view-all-employee").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewGatePassStaffRegister Dao ends");
		return resp;

	}

	// getDepartmentList Api.

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDepartmentListApi(String org, String orgDiv) {
		logger.info("Method : getDepartmentListApi starts");

		List<DropDownModel> getDeptList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("gatepass_staff_register_routines")
					.setParameter("actionType", "getDepartmentList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getDeptList.add(dropDownModel);
			}
			if (getDeptList.size() > 0) {
				Util.setJsonResponse(resp, getDeptList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, getDeptList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getDepartmentListApi ends");
		return response;
	}

	public JsonResponse<Object> updateAttendance(String orgName, String orgDivision, String userId,
			EmployeeAttendance employeeData) {
		logger.info("Method : updateAttendance Dao starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_dept='"
					+ employeeData.getDepartment() + "',@p_empId='" + employeeData.getEmployeeID() + "', @p_date='"
					+ employeeData.getMysqlDate() + "', @p_mysqlDatetime='" + employeeData.getMysqlDatetime()
					+ "', @p_createdBy='" + userId + "';";

			logger.info("updateAttendance value {}", value);
			Object singleResult = em.createNamedStoredProcedureQuery("gatepass_staff_register_routines")
					.setParameter("actionType", "updateAttendance").setParameter("actionValue", value)
					.getSingleResult();
			resp.setCode("200");
			resp.setMessage(singleResult.toString());
		} catch (Exception e) {
			resp.setCode("500");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : updateAttendance Dao ends, {}");
		return resp;

	}

	// Add Ticket.

	public ResponseEntity<JsonResponse<GatePassStaffRegisterModel>> saveOfflineDetails(
			List<GatePassStaffRegisterModel> category) {
		logger.info("Method : saveOfflineDetails starts");

		Boolean validity = true;
		JsonResponse<GatePassStaffRegisterModel> resp = new JsonResponse<GatePassStaffRegisterModel>();
		resp.setMessage("");
		resp.setCode("");
		JSONObject json = new JSONObject();

		String values = GenerateGatePassEntryPAram.saveOfflineDetails(category);

		System.out.println("***offline**********"+values);
		try {

			if (category.get(0).getEmpId() != null && category.get(0).getEmpId() != "") {
				em.createNamedStoredProcedureQuery("gatepass_staff_register_routines")
						.setParameter("actionType", "addOfflineGatePassData").setParameter("actionValue", values)
						.execute();

				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);

			} else {
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.ID_NOT_FOUND);
			}

		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		ResponseEntity<JsonResponse<GatePassStaffRegisterModel>> response = new ResponseEntity<JsonResponse<GatePassStaffRegisterModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response>>>>-------" + response);
		logger.info("Method : saveOfflineDetails ends");
		return response;
	}

}
