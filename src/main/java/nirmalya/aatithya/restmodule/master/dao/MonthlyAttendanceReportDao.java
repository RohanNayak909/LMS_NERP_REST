package nirmalya.aatithya.restmodule.master.dao;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GeneratePaySlipAttendanceParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.AttendanceDateRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class MonthlyAttendanceReportDao {

	Logger logger = LoggerFactory.getLogger(MonthlyAttendanceReportDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/* Function for getBandMasterAttendance */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBandMasterAttendance(String organization,String orgDivision) {
		logger.info("Method : getBandMasterAttendance starts");

		List<DropDownModel> bandlist = new ArrayList<DropDownModel>();
		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("payslip_attendance_routines")
					.setParameter("actionType", "getBandMasterAttendance").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bandlist.add(dropDownModel);
			}
		} catch (Exception e) {
			logger.error("getBandMasterAttendance: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getBandMasterAttendance ends");
		return bandlist;
	}

	/* Function for getStartDayForAttendance */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStartDayForAttendances(String organization,String orgDivision) {
		logger.info("Method : getStartDayForAttendance starts");

		List<DropDownModel> bandlist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("payslip_attendance_routines")
					.setParameter("actionType", "getStartDayForAttendance").setParameter("actionValue",value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bandlist.add(dropDownModel);
			}

		} catch (Exception e) {

			logger.error("getStartDayForAttendance: " + e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getStartDayForAttendance ends");
		return bandlist;
	}

	/* Function for getAttendanceDate */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAttendanceDates(String month, String lyear,String organization,String orgDivision) {
		logger.info("Method : getAttendanceDate starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @P_Month='" + month + "', @P_LYear=" + lyear + ",@P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
		logger.info("value process =====" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("payslip_attendance_routines")
					.setParameter("actionType", "getDate").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				stateList.add(dropDownModel);
			}
			resp.setBody(stateList);

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.error("getAttendanceDate: " + e.getMessage());
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAttendanceDate ends");
		return response;
	}
 
	// Function for view Employee Attendance
	@SuppressWarnings("unchecked")
	public JsonResponse<List<AttendanceDateRestModel>> getEmployeeAttendanceLists(String fromDate, String toDate,
			String attendanceType, String userId,String organization,String orgDivision,String stafftype) {
		logger.info("Method : getEmployeeAttendanceList starts");

		List<AttendanceDateRestModel> stateList = new ArrayList<AttendanceDateRestModel>();
		JsonResponse<List<AttendanceDateRestModel>> resp = new JsonResponse<List<AttendanceDateRestModel>>();

		String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
				+ DateFormatter.getStringDate(toDate) + "\", @P_AttendanceType=\"" + attendanceType + "\", @P_stafftype=\"" + stafftype + "\", @P_userId=\"" + userId + "\", @P_org=\"" + organization + "\", @P_orgDiv=\"" + orgDivision +"\";";
		logger.info("value a=====" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("monthly_attendanceReport_routines")
					.setParameter("actionType", "getMonthlyAttndList").setParameter("actionValue", value)

					.getResultList();

			for (Object[] m : x) {
				Object leave = null;
				if (m[34] != null) {
					leave = m[34];
				} else {
					leave = 0;
				}
				Object holiday = null;
				if (m[36] != null) {
					holiday = m[36];
				} else {
					holiday = '0';
				}
				System.out.println("a=="+m[38].toString());
				AttendanceDateRestModel dropDownModel = new AttendanceDateRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
						m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31], m[32],
						m[33].toString(), leave.toString(), m[35].toString(), holiday, m[37].toString(), m[38].toString(),
						m[39], m[40].toString(),m[41],m[42],m[43],m[44],m[45].toString(),m[46].toString(),m[47].toString(),
						m[48].toString(),null,null,null,null);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				logger.error("getEmployeeAttendanceList: " + e.getMessage());
				e1.printStackTrace();
			}
			logger.error("getEmployeeAttendanceList: " + e.getMessage());
			e.printStackTrace();
		}
 
		logger.info("Method : getEmployeeAttendanceList ends");
		return resp;
	}

	/* Function for getEmployeeLeaveList */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AttendanceDateRestModel>>> getEmployeeLeaveLists(String fromDate,
			String toDate, String band, String userId,String organization,String orgDivision) {
		logger.info("Method : getEmployeeLeaveList starts");

		List<AttendanceDateRestModel> stateList = new ArrayList<AttendanceDateRestModel>();
		JsonResponse<List<AttendanceDateRestModel>> resp = new JsonResponse<List<AttendanceDateRestModel>>();

		String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
				+ DateFormatter.getStringDate(toDate) + "\", @P_Band=\"" + band + "\",@P_userId=\"" + userId + "\", @P_org=\"" + organization + "\", @P_orgDiv=\"" + orgDivision +"\";";

		logger.info("value=========" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("payslip_attendance_routines")
					.setParameter("actionType", "getLeaveListEmpWise").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				AttendanceDateRestModel dropDownModel = new AttendanceDateRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19],
						m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31], m[32], null,
						null, null, null, null, null, null, null,m[33],m[34],m[35],m[36],null,null,null,null,null,null,null,null);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				logger.error("getEmployeeLeaveList: " + e.getMessage());
				e1.printStackTrace();
			}
			logger.error("getEmployeeLeaveList: " + e.getMessage());
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<AttendanceDateRestModel>>> response = new ResponseEntity<JsonResponse<List<AttendanceDateRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("getEmployeeLeaveList=========" + response);
		logger.info("Method : getEmployeeLeaveList ends");
		return response;
	}

	// AutoSearch

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAttndTypeAutoSearchLists(String id) {
		logger.info("Method : getAttndTypeAutoSearchList starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("payslip_attendance_routines")
					.setParameter("actionType", "getAttndAutoSearchList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			logger.error("getAttndTypeAutoSearchList: " + e.getMessage());
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAttndTypeAutoSearchList ends");
		return response;
	}

	//function for attendanceTypeDao

	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> attendanceTypeDaos(String organization,String orgDivision) {
		logger.info("Method : attendanceType  Dao starts");

		List<DropDownModel> attenList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("payslip_attendance_routines")
					.setParameter("actionType", "attendanceType").setParameter("actionValue",value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel shift = new DropDownModel(m[0].toString(), m[1].toString(), m[2].toString());
				attenList.add(shift);
			}

			if (attenList.size() > 0) {
				resp.setBody(attenList);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(attenList);
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();

			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("attendanceType: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(attenList);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}

		resp.setBody(attenList);
		logger.info("Method : attendanceType  Dao ends");
		return resp;
	}

	/* Function for approveEmployeeAttendance */

	public JsonResponse<List<AttendanceDateRestModel>> approveEmployeeAttendances(
			List<AttendanceDateRestModel> assignAttend) {
		logger.info("Method : assignShiftDetailsDao starts");

		JsonResponse<List<AttendanceDateRestModel>> resp = new JsonResponse<List<AttendanceDateRestModel>>();
		List<AttendanceDateRestModel> listData = new ArrayList<AttendanceDateRestModel>();

		try {
			String value = GeneratePaySlipAttendanceParam.getPaySlipAttendanceParam(assignAttend);
			logger.info("value==="+value);
			em.createNamedStoredProcedureQuery("payslip_attendance_routines")
					.setParameter("actionType", "approveEmployeeAttendance").setParameter("actionValue", value)
					.execute();

		} catch (Exception e) {
			resp.setCode("Failed");
			resp.setMessage(e.getLocalizedMessage());
			logger.error("approveEmployeeAttendance: " + e.getMessage());
			e.printStackTrace();
		}
		resp.setBody(listData);
		logger.info("Method : approveEmployeeAttendance ends");
		return resp;
	}
	
	// get getApproverStatus
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<DropDownModel>> getApproverStatuss(String fromDate, String process,
				String userId,String organization,String orgDivision) {
			logger.info("Method : getApproverStatus starts");

			DropDownModel policydetails = new DropDownModel();
			JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();

			try {
				String value = "SET @p_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\",@p_process=\"" + process
						+ "\",@p_userId=\"" + userId + "\",@P_organization=\"" + organization + "\",@P_orgDivision=\"" + orgDivision + "\";";
				logger.info("value status =====" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
						.setParameter("actionType", "getApproverStatus").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
					policydetails = dropDownModel;
				}
				resp.setBody(policydetails);
			} catch (Exception e) {
				e.printStackTrace();
			}
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
					responseHeaders, HttpStatus.CREATED);
			logger.info("Method : getApproverStatus ends");

			return response;
		}
//
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewMonthlyAttReportPdf(String[] empId,String fromDate,String toDate) {
			logger.info("Method : viewMonthlyAttReportPdf Dao startssssssssssssssssssssss" + fromDate + toDate);

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				//String empIdString = "(" + String.join(",", empId)
                //.replaceAll("\\[|\\]|'", "")
                //.replaceAll(",", "','") + ")";
				String[] cleanedEmpIds = Arrays.stream(empId)
				        .map(id -> id.replaceAll("\\[|\\]|\\s", ""))
				        .toArray(String[]::new);

				// Convert each cleaned element to a quoted string
				String[] quotedEmpIds = Arrays.stream(cleanedEmpIds)
				        .map(id -> "\"" + id + "\"")
				        .toArray(String[]::new);

				// Join the quoted strings with commas
				String empIdString = "(" + String.join(", ", quotedEmpIds) + ")";
				 
				String value = "SET @p_employeeId='" + empIdString +"',@P_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@P_toDate='" +DateFormatter.getStringDate(toDate)+ "';";
				
				logger.info("values******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("monthly_attendanceReport_routines")
						.setParameter("actionType", "viewMonthlyAttReportPdf").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("resp******" + resp);
			logger.info("Method : viewMonthlyAttReportPdf Dao ends");
			return resp;

		}
}
