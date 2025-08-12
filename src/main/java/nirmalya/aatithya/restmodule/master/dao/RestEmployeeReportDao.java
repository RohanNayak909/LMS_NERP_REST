package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ExtendExitManagementRestModel;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeReportsModel;
@Repository
public class RestEmployeeReportDao {
	Logger logger = LoggerFactory.getLogger(RestEmployeeReportDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	// view

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEmployeeReportsModel>> viewEmployeeReportDetails(String userId,String organization,String orgDivision,String fromDate,String toDate) {

		logger.info("Method in Dao: viewEmployeeReportDetails dao starts");

		List<RestEmployeeReportsModel> reportDetails = new ArrayList<RestEmployeeReportsModel>();
		String value = "SET @P_userId='" + userId + "',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "',@p_fromDate='"+DateFormatter.getStringDate(fromDate)+"',@p_toDate='"+DateFormatter.getStringDate(toDate)+"';";
		logger.info("value===="+value);
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "viewEmployeeDetails").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				Object dob = null;
				if (m[3] != null) {
					dob = DateFormatter.returnStringDate(m[3]);
				}
				RestEmployeeReportsModel report = new RestEmployeeReportsModel(m[0],m[1],m[2],dob,m[4],m[5],m[6],
						m[7],m[8],m[9],m[10],m[11],null,null,m[12],m[13],m[14],m[15],m[16],m[17],m[18],m[19]);
				reportDetails.add(report);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestEmployeeReportsModel>> resp = new JsonResponse<List<RestEmployeeReportsModel>>();
		resp.setBody(reportDetails);
		logger.info("resp===="+resp);
		logger.info("Method in Dao: viewEmployeeReportDetails dao ends");

		return resp;
	}
	// view Employee Attendance Reports
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEmployeeAttendanceReports( String userId,String organization,String orgDivision,String fromDate,String toDate) {

		logger.info("Method : viewEmployeeAttendanceReports Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @P_userId='" + userId + "',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "',@p_fromDate='"+DateFormatter.getStringDate(fromDate)+"',@p_toDate='"+DateFormatter.getStringDate(toDate)+"';";
			logger.info("value===="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "viewEmployeeAttendanceReports").setParameter("actionValue",value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewEmployeeAttendanceReports Dao ends"+resp);
		return resp;
	}
	
	
	// view Employee Attendance Reports
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEmployeeResignationReports(String userId,String userRole,String organization,String orgDivision, String fromDate, String toDate) {
		
		logger.info("Method in Dao: viewEmployeeResignationReports dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @P_userId='" + userId + "',@P_userRole='" + userRole + "',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "',@p_fromDate='"+DateFormatter.getStringDate(fromDate)+"',@p_toDate='"+DateFormatter.getStringDate(toDate)+"';";
		logger.info("value===="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "viewEmployeeResignationReports").setParameter("actionValue",value).getResultList();
			
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method in Dao: viewEmployeeResignationReports dao ends");
		return resp;
	}
	// view Employee Attendance Reports dept wise
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> empAttendanceDetailsDepartmentWise(String dept,String subDept,String fromDate,String toDate,String organization,String orgDivision) {
		
		logger.info("Method in Dao: empAttendanceDetailsDepartmentWise dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
				try {
					String value = "SET @p_dept='" + dept + "',@p_subDept='"+subDept+"',@p_fromDate='"+DateFormatter.getStringDate(fromDate)+"',@p_toDate='"+DateFormatter.getStringDate(toDate)+"',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "';";
					logger.info("value===="+value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
							.setParameter("actionType", "empAttendanceDetailsDepartmentWise").setParameter("actionValue",value).getResultList();
					
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : viewEmployeeLeaveReports Dao ends"+resp);
				return resp;
	}
	// view Employee Attendance Reports by status
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> empAttendanceDetailsStatusWise(String dept,String subDept,String attndate,String organization,String orgDivision,String status) {
		
		logger.info("Method in Dao: empAttendanceDetailsStatusWise dao starts");

		JsonResponse<Object> resp = new JsonResponse <Object>();
		String value = "SET @p_dept='" + dept + "',@p_subDept='"+subDept+"',@p_attndate='"+DateFormatter.getStringDate(attndate)+"',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "',@p_status='"+status+"';";
		logger.info("value===="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
					.setParameter("actionType", "empAttendanceDetailsStatusWise").setParameter("actionValue",value).getResultList();
			
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	//	resp.setBody(reportDetails);
		logger.info("resp===="+resp);
		logger.info("Method in Dao: empAttendanceDetailsStatusWise dao ends");
		
		return resp;
	}
	// view Employee Attendance Reports
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewEmployeeLeaveReports( String userId,String organization,String orgDivision,String fromDate,String toDate) {

			logger.info("Method : viewEmployeeAttendanceReports Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @P_userId='" + userId + "',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "',@p_fromdate='"+DateFormatter.getStringDate(fromDate)+"',@p_todate='"+DateFormatter.getStringDate(toDate)+"';";
				logger.info("value===="+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
						.setParameter("actionType", "viewLeaveReport").setParameter("actionValue",value).getResultList();

				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewEmployeeLeaveReports Dao ends"+resp);
			return resp;
		}

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> empLeaveDepartmentWise(String dept,String subDept,String fromDate,String toDate,String organization,String orgDivision) {
			
			logger.info("Method in Dao: empLeaveDepartmentWise dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
					try {
						String value = "SET @p_dept='" + dept + "',@p_subDept='"+subDept+"',@p_fromDate='"+DateFormatter.getStringDate(fromDate)+"',@p_toDate='"+DateFormatter.getStringDate(toDate)+"',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "';";
						logger.info("value===="+value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
								.setParameter("actionType", "empLeaveDepartmentWise").setParameter("actionValue",value).getResultList();
						
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
					} catch (Exception e) {
						e.printStackTrace();
					}
					logger.info("Method : empLeaveDepartmentWise Dao ends"+resp);
					return resp;
		}
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> resginDepartmentWise(String dept, String subDept, String fromDate, String toDate,
				String organization, String orgDivision) {
			logger.info("Method in Dao: resginDepartmentWise dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
					try {
						String value = "SET @p_dept='" + dept + "',@p_subDept='"+subDept+"',@p_fromDate='"+DateFormatter.getStringDate(fromDate)+"',@p_toDate='"+DateFormatter.getStringDate(toDate)+"',@p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "';";
						logger.info("value===="+value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("viewEmployeeReports")
								.setParameter("actionType", "resginDepartmentWise").setParameter("actionValue",value).getResultList();
						
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
					} catch (Exception e) {
						e.printStackTrace();
					}
					logger.info("Method : resginDepartmentWise Dao ends"+resp);
					return resp;
		}
}
