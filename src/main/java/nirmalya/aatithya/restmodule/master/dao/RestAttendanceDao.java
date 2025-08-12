
package nirmalya.aatithya.restmodule.master.dao;

import java.math.BigInteger;
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
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameterAttendance;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestAttendanceModel;

@Repository
public class RestAttendanceDao {
	Logger logger = LoggerFactory.getLogger(RestAttendanceDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	/*
	 * for Search Emp Name using Ajax
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>> getPunchDao(String empId, String date,String org,String orgDiv) {
		logger.info("Method : getPunchDao  starts");

		DropDownModel EmployeeNameList = new DropDownModel();
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();

		DateFormatter.getStringDate(date);
		try {
			String values = "SET @p_empId='" + empId + "',@p_date='" + date + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("values====" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("attendenceEmployeeRoutines")
					.setParameter("actionType", "getDetailsPunchout").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1].toString(), m[2].toString());
				EmployeeNameList = dropDownModel;
			}

			resp.setBody(EmployeeNameList);

		} catch (Exception e) {
			logger.error("getPunchDao: " + e.getMessage());
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
				HttpStatus.CREATED);
		logger.info("response====" + response);
		logger.info("Method : getPunchDao ends");
		return response;
	}

	// For add employee
	public ResponseEntity<JsonResponse<Object>> addEmployeeAttendances(RestAttendanceModel req) {
		logger.info("Method : addEmployeeAttendances starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateParameterAttendance.getAddempParam(req);

			if (req.getIsOut() == null || req.getIsOut() == "") {
				em.createNamedStoredProcedureQuery("attendenceEmployeeRoutines")
						.setParameter("actionType", "addAttendance").setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("attendenceEmployeeRoutines")
						.setParameter("actionType", "modifyEmployee").setParameter("actionValue", values).execute();

			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				logger.error("addEmployeeAttendances: " + e.getMessage());
				e1.printStackTrace();
			}

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addEmployeeAttendances ends");
		return response;
	}

	// View employee

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestAttendanceModel>> viewNewEmployeeAttendances(String userId, String isHr,
			String organization, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : viewNewEmployeeAttendances Dao starts");

		List<RestAttendanceModel> viewEmployeeDetails = new ArrayList<RestAttendanceModel>();

		JsonResponse<List<RestAttendanceModel>> resp = new JsonResponse<List<RestAttendanceModel>>();
		try {
			String value = "SET @p_empId='" + userId + "',@p_isHr='" + isHr + "',@p_org='" + organization
					+ "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate)
					+ "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "';";
			logger.info("value==" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("attendenceEmployeeRoutines")
					.setParameter("actionType", "viewAttendance").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object DATE = null;
				if (m[2] != null) {

					DATE = DateFormatter.returnStringDate(m[2]);
				}
				Object InTime = null;
				if (m[3] != null) {

					InTime = m[3].toString();
				}

				Object OutTime = null;
				if (m[4] != null) {

					OutTime = m[4].toString();
				}

				RestAttendanceModel restStudentModel = new RestAttendanceModel(m[0], m[1], DATE, InTime, OutTime,m[5],m[6],m[7],null);
				viewEmployeeDetails.add(restStudentModel);

			}

		} catch (Exception e) {
			logger.error("viewNewEmployeeAttendances: " + e.getMessage());
			e.printStackTrace();
		}
		resp.setBody(viewEmployeeDetails);
		logger.info("Method : viewNewEmployeeAttendances Dao ends");
		return resp;
	}

	/*
	 * DAO Function to get punchIn time
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDetailsPunchout(String empId, String date) {
		logger.info("Method : getDetailsPunchout starts");
		List<DropDownModel> details = new ArrayList<DropDownModel>(); // String date1 =
		DateFormatter.getStringDate(date);
		try {
			String values = "SET @p_empId='" + empId + "',@p_date='" + date + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("attendenceEmployeeRoutines")
					.setParameter("actionType", "getDetailsPunchout").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel properties = new DropDownModel(m[0], m[1].toString(), m[2].toString());
				details.add(properties);
			}

		} catch (Exception e) {
			logger.error("getDetailsPunchout: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getDetailsPunchout ends");

		return details;
	}

	/*
	 * DAO Function to View all attendence details
	 */

	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<RestAttendanceModel>>> viewAttendencePunchoutThroughAjax(
			DataTableRequest request) {
		logger.info("Method : getAllAttendence starts");
		if (request.getParam1() != "") {
			String param1 = request.getParam1();
			String data = DateFormatter.getStringDate(param1);
			request.setParam1(data);

		}
		List<RestAttendanceModel> form = new ArrayList<RestAttendanceModel>();
		String values = GenerateParameter.getSearchParam(request);

		Integer total = 0;

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("attendenceEmployeeRoutines")
					.setParameter("actionType", "viewAttendencePunchoutThroughAjax").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				Object punchinDate = null;
				if (m[1] != null) {
					punchinDate = DateFormatter.returnStringDate(m[1]);
				}

				Object punchinTime = null;
				if (m[2] != null) {
					punchinTime = DateFormatter.returnStringDateTime(m[2]);
				}
				Object punchOutTime = null;
				if (m[5] != null) {
					punchOutTime = DateFormatter.returnStringDateTime(m[5]);
				}
				RestAttendanceModel properties = new RestAttendanceModel(m[0], punchinDate, punchinTime, m[3], m[4],
						punchOutTime, m[6], m[7]);
				form.add(properties);
			}

			if (x.get(0).length > 8) {
				BigInteger t = (BigInteger) x.get(0)[8];

				total = Integer.parseInt((t.toString()));
			}

		} catch (Exception e) {
			logger.error("viewAttendencePunchoutThroughAjax: " + e.getMessage());
			e.printStackTrace();
		}

		JsonResponse<List<RestAttendanceModel>> resp = new JsonResponse<List<RestAttendanceModel>>();
		resp.setBody(form);
		resp.setTotal(total);

		ResponseEntity<JsonResponse<List<RestAttendanceModel>>> response = new ResponseEntity<JsonResponse<List<RestAttendanceModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewAttendencePunchoutThroughAjax ends");

		return response;
	}

	// Add Punch out

	public ResponseEntity<JsonResponse<Object>> addEmployeeAttendancePunchOut(RestAttendanceModel req) {
		logger.info("Method : addEmployeeAttendancePunchOut starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateParameterAttendance.getAddempParam(req);
			logger.info("values===" + values);
			if (req.getIsOut() == null || req.getIsOut() == "") {
				em.createNamedStoredProcedureQuery("attendenceEmployeeRoutines")
						.setParameter("actionType", "modifyAttendencePuncchOut").setParameter("actionValue", values)
						.execute();

			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				logger.error("addEmployeeAttendancePunchOut: " + e.getMessage());
				e1.printStackTrace();
			}

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addEmployeeAttendancePunchOut ends");
		return response;
	}

	// View Attendance location
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestAttendanceModel>> viewEmployeeLocation(String userId) {
		logger.info("Method : viewEmployeeLocation Dao starts");

		List<RestAttendanceModel> viewEmployeeDetails = new ArrayList<RestAttendanceModel>();

		JsonResponse<List<RestAttendanceModel>> resp = new JsonResponse<List<RestAttendanceModel>>();
		try {
			String value = "SET @p_empId='" + userId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("attendenceEmployeeRoutines")
					.setParameter("actionType", "viewLocation").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestAttendanceModel restStudentModel = new RestAttendanceModel(m[0], m[1], m[2]);
				viewEmployeeDetails.add(restStudentModel);

			}

		} catch (Exception e) {
			logger.error("viewEmployeeLocation: " + e.getMessage());
			e.printStackTrace();
		}
		resp.setBody(viewEmployeeDetails);
		logger.info("Method : viewEmployeeLocation Dao ends");
		return resp;
	}

	// For add Uloaded Attendance Data
	public ResponseEntity<JsonResponse<Object>> addUloadedAttendanceData(List<RestAttendanceModel> attendance) {
		logger.info("Method : addUloadedAttendanceData dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateParameterAttendance.getAddUloadedAttendanceDataParam(attendance);
			logger.info("values===" + values);
			if (values != null || values != "") {
				em.createNamedStoredProcedureQuery("attendenceEmployeeRoutines")
						.setParameter("actionType", "addUloadedAttendanceData").setParameter("actionValue", values)
						.execute();

			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				logger.error("addEmployeeAttendances: " + e.getMessage());
				e1.printStackTrace();
			}

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addUloadedAttendanceData Dao ends");
		return response;
	}
//EmployeeAutoSearchForAttendance
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> EmployeeAutoSearchForAttendance(String id,String org,String orgDiv) {
		logger.info("Method : EmployeeAutoSearchForAttendance starts");
		List<DropDownModel> empNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("SRCHVALUE"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("attendenceEmployeeRoutines")
					.setParameter("actionType", "getEmpListForAttendance").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				empNameList.add(dropDownModel);
			}
			resp.setBody(empNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : EmployeeAutoSearchForAttendance ends");
		return response;
	}
}
