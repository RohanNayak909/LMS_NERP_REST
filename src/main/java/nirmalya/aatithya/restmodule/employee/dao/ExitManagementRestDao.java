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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateExtendExitManagementParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ExitFinancialSettelmentRestModel;
import nirmalya.aatithya.restmodule.employee.model.ExtendExitManagementRestModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ExitManagementRestDao {
	Logger logger = LoggerFactory.getLogger(ExitManagementRestDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * add name list
	 * 
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> namelist() {
		logger.info("Method : namelist Dao starts");

		List<DropDownModel> namelist = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "getEmpNameList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				namelist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : namelist Dao ends");

		return namelist;
	}

	/*
	 * Department list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> deptList(String org, String orDiv) {
		logger.info("Method : deptList Dao starts");

		List<DropDownModel> departmentList = new ArrayList<DropDownModel>();

		String value = "SET @P_organization='" + org + "',@P_orgDivision='" + orDiv + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "getDeptList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : deptList Dao ends");

		return departmentList;
	}

	/*
	 * Clearance Person list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> clrncPersonList() {
		logger.info("Method : clrncPersonList Dao starts");

		List<DropDownModel> clrncPtList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "getclrncPtList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				clrncPtList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : clrncPersonList Dao ends");

		return clrncPtList;
	}

	/*
	 * job list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getDesignationList(String id) {

		logger.info("Method : getDesignationList starts");
		List<DropDownModel> jobList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tGuestName='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "getEmpDeginationList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				jobList.add(dropDownModel);
			}

			resp.setBody(jobList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDesignationList ends");
		return resp;
	}

	/*
	 * View Exit Management
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewExtendExitManagementDtls(String userId, String userRole, String organization,
			String orgDivision,String selftype) {

		logger.info("Method in Dao: viewExtendExitManagementDtls starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = "SET @P_userId='" + userId + "',@P_userRole='" + userRole + "',@P_organization='" + organization
				+ "',@P_orgDivision='" + orgDivision + "', @p_type='" + selftype + "';";

		System.out.println("value>>>>>>." + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "viewExitManagement").setParameter("actionValue", value)
					.getResultList();

			if (x != null) {
				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, "success");
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			System.err.println(err[0]);
			System.err.println(err[1]);
			Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);

		}

		logger.info("Method in Dao: viewExtendExitManagementDtls ends");

		return resp;
	}

	/*
	 * View Clearance
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<ExtendExitManagementRestModel>> viewClrncDtls() {

		logger.info("Method in Dao: viewClrncDtls starts");

		List<ExtendExitManagementRestModel> clrncDtlsList = new ArrayList<ExtendExitManagementRestModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "viewClrncDtls").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				ExtendExitManagementRestModel exitManagementModel = new ExtendExitManagementRestModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null);
				clrncDtlsList.add(exitManagementModel);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<ExtendExitManagementRestModel>> resp = new JsonResponse<List<ExtendExitManagementRestModel>>();
		resp.setBody(clrncDtlsList);

		logger.info("Method in Dao: viewClrncDtls ends");

		return resp;
	}

	/*
	 * Add Exit Management
	 * 
	 */

	public JsonResponse<Object> addExitManagement(ExtendExitManagementRestModel exit) {

		logger.info("Method : addExitManagement starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateExtendExitManagementParameter.getAddExitManagementParam(exit);

			if (exit.getEmployeeExit() == null || exit.getEmployeeExit() == "") {
				em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "addExitManagement")
						.setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "modifyExitManagement")
						.setParameter("actionValue", values).execute();
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info(err.toString());
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		logger.info("Method : addExitManagement ends");
		return resp;
	}

	/*
	 * Add Clearance
	 * 
	 */
	public JsonResponse<Object> addClearanceDetailsDao(ExtendExitManagementRestModel exit) {
		logger.info("Method : addClearanceDetailsDao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateExtendExitManagementParameter.getAddClearanceParam(exit);
			if (exit.getClearanceId() == null || exit.getClearanceId() == "") {
				em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "addClrncDtls")
						.setParameter("actionValue", values).execute();
				resp.setCode("success");
				resp.setMessage("Data saved successfully");
			} else {
				em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "modifyClrncDtls")
						.setParameter("actionValue", values).execute();
				resp.setCode("success");
				resp.setMessage("Data modified successfully");
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				if (err[1].equals("Duplicate entry 'x' for  'tbl_employee_exit_clearance.PRIMARY'")) {
					resp.setCode("failed");
					resp.setMessage("You are already done");
				} else {
					resp.setCode("failed");
					resp.setMessage("Something went wrong");
				}
			} catch (Exception e1) {
				resp.setCode("failed");
				e1.printStackTrace();
				resp.setMessage("Something went wrong");
			}
		}

		logger.info("Method : addClearanceDetailsDao ends");
		return resp;
	}

	/*
	 * Edit Exit Management
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<ExtendExitManagementRestModel> editManagementDetails(String id, String organization,
			String orgDivision) {
		logger.info("Method : editManagementDetails starts");

		ExtendExitManagementRestModel req = new ExtendExitManagementRestModel();
		JsonResponse<ExtendExitManagementRestModel> resp = new JsonResponse<ExtendExitManagementRestModel>();

		try {

			String value = "SET @p_exitMangementId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "editExitManagement").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				Object DATE = null;
				if (m[7] != null) {
					DATE = DateFormatter.returnStringDate(m[7]);
				}
				Object DATER = null;
				if (m[8] != null) {
					DATER = DateFormatter.returnStringDate(m[8]);
				}

				ExtendExitManagementRestModel reqEdit = new ExtendExitManagementRestModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], DATE, DATER, m[9], m[10], m[11], m[12], null, null, null, null, null, null, null,
						null, null, null, null, null, null, null);
				req = reqEdit;

			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : editManagementDetails ends");

		return resp;
	}

	/*
	 * Delete Exit Management Details
	 * 
	 */

	public JsonResponse<ExtendExitManagementRestModel> deleteExitDetails(String deleteId) {
		logger.info("Method : deleteExitDetails starts");

		ExtendExitManagementRestModel req = new ExtendExitManagementRestModel();
		JsonResponse<ExtendExitManagementRestModel> resp = new JsonResponse<ExtendExitManagementRestModel>();

		try {

			String value = "SET @p_exitMangementId='(" + deleteId + ")';";

			em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "deleteExitDetails")
					.setParameter("actionValue", value).execute();

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : deleteExitDetails ends");

		return resp;
	}

	/*
	 * Add Finance Details
	 * 
	 */

	public JsonResponse<Object> addFinanceDetails(ExtendExitManagementRestModel exit) {

		logger.info("Method : addFinanceDetails starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateExtendExitManagementParameter.getAddFinanceDetailsParam(exit);

			if (exit.getFinanceId() == null || exit.getFinanceId() == "") {

				em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "addFinanceDetails")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "modifyFinanceDetails")
						.setParameter("actionValue", values).execute();

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
		logger.info("Method : addFinanceDetails ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> viewdeptClearanceDetails(String userid) {

		logger.info("Method : viewdeptClearanceDetails starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_empId='" + userid + "';";
		logger.info("value==" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "viewDeptClearanceDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}

			resp.setBody(nameList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewdeptClearanceDetails ends");

		logger.info("LISTTTT" + resp);
		return resp;
	}

	/*
	 * View Exit Clearance
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<ExtendExitManagementRestModel>> viewExitClearance(String userId, String exitid,
			String organization, String orgDivision) {

		logger.info("Method in Dao: viewExitClearance starts");

		List<ExtendExitManagementRestModel> exitDtlsList = new ArrayList<ExtendExitManagementRestModel>();
		String value = "SET @P_userId='" + userId + "',@P_exitid='" + exitid + "',@P_organization='" + organization
				+ "',@P_orgDivision='" + orgDivision + "';";
		logger.info("value====" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "viewExitClearance").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				ExtendExitManagementRestModel reqEdit = new ExtendExitManagementRestModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8]);
				exitDtlsList.add(reqEdit);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<ExtendExitManagementRestModel>> resp = new JsonResponse<List<ExtendExitManagementRestModel>>();
		resp.setBody(exitDtlsList);

		logger.info("Method in Dao: viewExitClearance ends");

		return resp;
	}

	/*
	 * Edit Exit Management
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<ExtendExitManagementRestModel> editClearance(String id, String organization,
			String orgDivision) {
		logger.info("Method : editClearance starts");

		ExtendExitManagementRestModel req = new ExtendExitManagementRestModel();
		JsonResponse<ExtendExitManagementRestModel> resp = new JsonResponse<ExtendExitManagementRestModel>();
		try {
			String value = "SET @p_clearanceId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "editClearance").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				ExtendExitManagementRestModel reqEdit = new ExtendExitManagementRestModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8]);
				req = reqEdit;
			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editClearance ends");
		return resp;
	}

	/*
	 * Proceed Notice Details
	 * 
	 */
	public JsonResponse<Object> proceedNotice(ExtendExitManagementRestModel exit) {
		logger.info("Method : proceedNotice starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = "";

		String remarks = exit.getNoticeRemarks().replace("\\", "\\\\") // Escape backslashes
				.replace("'", "''") // Escape single quotes for SQL
				.replace("\"", "\\\"") // Escape double quotes
				.replace("\n", "\\n") // Escape newlines
				.replace(";", "\\;"); // Escape semicolons

		if (exit.getType().equals("INITIATED")) {
			String sitem = "";
			String[] deptLists = exit.getDeptId() != null ? exit.getDeptId().split(",") : new String[0];

			System.out.println("value>>>>>>>>>>>>" + exit.getReleaseDate().toString());
			value = "@p_exitId='" + exit.getEmployeeExit() + "', " + "@p_actualReleaseDt='"
					+ DateFormatter.getStringDate(exit.getReleaseDate().toString()) + "', " + "@p_clearanceDate='"
					+ DateFormatter.getStringDate(exit.getClearanceBefore().toString()) + "', " + "@p_remarks='"
					+ remarks + "', " + "@p_noticePeriod='" + exit.getNoticePeriod() + "', " 
					+ "@p_resignType='"	+ exit.getResignType() + "', " + "@p_type='" + exit.getType() + "', " + "@p_depts='"
					+ exit.getDeptId() + "', " + "@p_createdBy='" + exit.getCreatedBy() + "', " + "@p_org='"
					+ exit.getOrganization() + "', " 
					+ "@p_reasonForAttrition='" + exit.getReasonForResignationAttrition() +   "', " 
					+ "@p_orgDiv='" + exit.getOrgDivision() + "'";

			System.out.println("value>>>>>>>>>>>>" + value);
			if (deptLists.length > 0) {
				for (String m : deptLists) {
					sitem += "(FN_GET_ClearanceID(), @p_exitId, \"" + m + "\", FN_GET_DepartmentHead(\"" + m
							+ "\",@p_org, @p_orgDiv),@p_createdBy, @p_clearanceDate, @p_org, @p_orgDiv),";
				}
				sitem = sitem.substring(0, sitem.length() - 1);
				value += ", @p_itemSubQuery='" + sitem + "'";
			}

			value = "SET " + value + ";";

		} else if (exit.getType().equals("REJECTED")) {
			value = "SET @p_exitId='" + exit.getEmployeeExit() + "',@p_remarks='" + remarks + "',@p_type='"
					+ exit.getType() + "',@p_org='" + exit.getOrganization() + "',@p_orgDiv='" + exit.getOrgDivision()
					+ "';";
		}

		try {

			System.err.println("value for proceedNotice======="+value);
			  em.createNamedStoredProcedureQuery("exitmanagement").setParameter(
			 "actionType", "proceedNotice") .setParameter("actionValue", value).execute();
			 
			Util.setJsonResponse(resp, null, ResponseStatus.success, "Resignation Initiated Successfully");

		} catch (Exception e) {
			try {
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);

				System.err.println("Error Code: " + err[0]);
				System.err.println("Error Message: " + err[1]);

			} catch (Exception e1) {
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		logger.info("Method : proceedNotice ends");
		return resp;
	}

	/*
	 * Get Employee Name for choosen Js(Edit)
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDeptDetails(String id, String organization,
			String orgDivision) {
		logger.info("Method : getDeptDetails starts");

		List<DropDownModel> form = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> deptList = new JsonResponse<List<DropDownModel>>();

		try {

			String values = "SET @p_id='" + id + "',@P_org='" + organization + "',@P_orgDivision='" + orgDivision
					+ "';";

			List<Object[]> x;

			System.err.println(values);

			if (!id.equals(null) && !id.equals("null")) {
				System.out.println("Inside Iffffffffffff");
				x = em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "getDepartmentName")
						.setParameter("actionValue", values).getResultList();
			} else {
				System.out.println("Inside elseeee");
				x = em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "getDepartmentAll")
						.setParameter("actionValue", values).getResultList();
			}

			if (!x.isEmpty()) {
				for (Object[] m : x) {
					DropDownModel sectionMaster = new DropDownModel(m[0], m[1]);
					form.add(sectionMaster);
				}
				deptList.setBody(form);
				Util.setJsonResponse(deptList, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				deptList, HttpStatus.CREATED);
		logger.info("Method : getDeptDetails ends");
		return response;
	}

	/*
	 * Get Employee Clearance Status
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getEmpClearanceStatus(String id, String organization, String orgDivision) {

		logger.info("Method : getEmpClearanceStatus starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @P_id='" + id + "',@P_org='" + organization + "',@P_orgDivision='" + orgDivision
					+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "getClearanceStatus").setParameter("actionValue", values)
					.getResultList();

			Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info(err.toString());
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		logger.info("Method : getEmpClearanceStatus ends");
		return resp;
	}

	/*
	 * View Experience Letter Certificate Details
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewExperienceLetter(String exitId, String organization, String orgDivision) {

		logger.info("Method in Dao: viewExperienceLetter starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = "SET @P_exitId='" + exitId + "',@P_organization='" + organization + "',@P_orgDivision='"
				+ orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "viewExpLetterDetls").setParameter("actionValue", value)
					.getResultList();

			if (x != null) {
				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, "success");
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			System.err.println(err[0]);
			System.err.println(err[1]);
			Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);

		}

		logger.info("Method in Dao: viewExperienceLetter ends");

		return resp;
	}

	/*
	 * No Due Certificate
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> noDuertificate(String exitId, String organization, String orgDivision) {

		logger.info("Method in Dao: noDuertificate starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = "SET @P_exitId='" + exitId + "',@P_organization='" + organization + "',@P_orgDivision='"
				+ orgDivision + "';";

		System.out.println("value>>>>>>>" + value);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "noDueCertificateDetails").setParameter("actionValue", value)
					.getResultList();

			if (x != null) {
				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			System.err.println(err[0]);
			System.err.println(err[1]);
			Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);

		}

		logger.info("Method in Dao: noDuertificate ends");

		return resp;
	}

	// view pay slip for exit
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPaySlipApi(String userId, String organization, String orgDivision, String fromDate,
			String toDate) {

		logger.info("Method : viewPaySlipApi Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_empId=\"" + userId + "\",@p_org=\"" + organization + "\",@p_orgDiv=\"" + orgDivision
					+ "\",@p_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\",@p_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\";";
			System.out.println("allData payslip daooo==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "viewPaySlip").setParameter("actionValue", value).getResultList();

			if (x != null) {
				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			System.err.println(err[0]);
			System.err.println(err[1]);
			Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
		}
		logger.info("Method : viewPaySlipApi Dao ends");
		return resp;
	}

	// View Final Settlement By Employee ID
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getFinalSettlement(String empId, String fromDate, String toDate, String releaseDt,
			String organization, String orgDivision) {

		logger.info("Method : getFinalSettlement Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_empId=\"" + empId + "\",@p_fromDate=\"" + fromDate + "\",@p_toDate=\"" + toDate
					+ "\",@p_releaseDt=\"" + DateFormatter.getStringDate(releaseDt) + "\",@p_org=\"" + organization
					+ "\",@p_orgDiv=\"" + orgDivision + "\";";

			System.out.println("value final settlement>>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "getFinalSettlementDetails").setParameter("actionValue", value)
					.getResultList();

			if (x != null) {
				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			System.err.println(err[0]);
			System.err.println(err[1]);
			Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
		}
		logger.info("Method : getFinalSettlement Dao ends");
		return resp;
	}

	/*
	 * View Final Settlement By settlement Id
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getFinalSettlementByID(String settlementId, String organization, String orgDivision) {

		logger.info("Method : getFinalSettlementByID Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_settlementId=\"" + settlementId + "\",@p_org=\"" + organization + "\",@p_orgDiv=\""
					+ orgDivision + "\";";

			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "getFinalSettlementByID").setParameter("actionValue", value)
					.getResultList();

			if (x != null) {
				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			System.err.println(err[0]);
			System.err.println(err[1]);
			Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
		}
		logger.info("Method : getFinalSettlementByID Dao ends");
		return resp;
	}

	/*
	 * Add Financial Details
	 * 
	 */

	public JsonResponse<Object> saveFinancialSettlement(ExitFinancialSettelmentRestModel exit) {

		logger.info("Method : saveFinancialSettlement starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateExtendExitManagementParameter.addFinalSettlement(exit);

			System.out.println(exit.getSettlementId());
			if (exit.getSettlementId().equals(null) || exit.getSettlementId().equals("")) {
				em.createNamedStoredProcedureQuery("exitmanagement")
						.setParameter("actionType", "addFinalSettlementDetails").setParameter("actionValue", values)
						.execute();

				Util.setJsonResponse(resp, null, ResponseStatus.success, "Final Settlement Saved Successfully");

			} else {
				em.createNamedStoredProcedureQuery("exitmanagement")
						.setParameter("actionType", "modifyFinancialDetails").setParameter("actionValue", values)
						.execute();

				Util.setJsonResponse(resp, null, ResponseStatus.success, "Final Settlement Modified Successfully");
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info(err.toString());
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		logger.info("Method : saveFinancialSettlement ends");
		return resp;
	}

	/*
	 * Update Clearance Employee
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> updateClearanceEmployee(String empId, String clearanceId, String organization,
			String orgDivision) {

		logger.info("Method : updateClearanceEmployee Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_clearanceId=\"" + clearanceId + "\",@p_empId=\"" + empId + "\",@p_org=\""
					+ organization + "\",@p_orgDiv=\"" + orgDivision + "\";";

			System.out.println("value====" + value);

			em.createNamedStoredProcedureQuery("exitmanagement").setParameter("actionType", "updateClearanceEmployee")
					.setParameter("actionValue", value).execute();

			Util.setJsonResponse(resp, null, ResponseStatus.success, "Employee Assigned Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			System.err.println(err[0]);
			System.err.println(err[1]);
			Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
		}
		logger.info("Method : updateClearanceEmployee Dao ends");
		return resp;
	}

	// Employee AutoSearchFor Clearance
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> employeeAutoSearch(String id, String org, String orgDiv) {
		logger.info("Method : employeeAutoSearch starts");
		List<DropDownModel> empNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

		System.out.println("value>>" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("exitmanagement")
					.setParameter("actionType", "getEmpClearnaceSearch").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2], m[3]);
				empNameList.add(dropDownModel);
			}

			if (empNameList.size() > 0) {
				Util.setJsonResponse(resp, empNameList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();

			String[] err = serverDao.errorProcedureCall(e);

			System.err.println(err[0]);
			System.err.println(err[1]);

			Util.setJsonResponse(resp, empNameList, ResponseStatus.failed, err[1]);
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : employeeAutoSearch ends");
		return response;
	}
}