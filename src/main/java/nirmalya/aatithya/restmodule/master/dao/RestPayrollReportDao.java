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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestPayrollReportDao {

	Logger logger = LoggerFactory.getLogger(RestPayrollReportDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewReport(String fromDate, String toDate, String staff, String employedBy,
			String userId, String organization, String orgDivision) {
		logger.info("Method : viewReport Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Staff=\"" + staff + "\",@P_employedBy=\""
					+ employedBy + "\",  @P_userId=\"" + userId + "\", @P_organization=\"" + organization
					+ "\", @P_orgDivision=\"" + orgDivision + "\";";
			System.out.println("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "viewReport").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewReport Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getYearLists(String organization, String orgDivision) {
		logger.info("Method : getYearLists starts");

		List<DropDownModel> yearlist = new ArrayList<DropDownModel>();
		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "getYearLists").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				yearlist.add(dropDownModel);
			}
		} catch (Exception e) {
			logger.error("getYearLists: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getYearLists ends");
		return yearlist;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getStaffType(String organization, String orgDivision) {
		logger.info("Method : getStaffType starts");

		List<DropDownModel> yearlist = new ArrayList<DropDownModel>();
		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "getStaffType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				yearlist.add(dropDownModel);
			}
		} catch (Exception e) {
			logger.error("getStaffType: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getStaffType ends");
		return yearlist;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> reportPivot(String fromDate, String toDate, String staff, String employedBy,
			String userId, String organization, String orgDivision) {
		logger.info("Method : reportPivot Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Staff=\"" + staff + "\",@P_employedBy=\""
					+ employedBy + "\", @P_userId=\"" + userId + "\", @P_organization=\"" + organization
					+ "\", @P_orgDivision=\"" + orgDivision + "\";";
			System.out.println("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "viewPivotReport").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : reportPivot Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> reportSummary(String fromDate, String toDate, String staff, String employedBy,
			String userId, String organization, String orgDivision) {
		logger.info("Method : reportSummary Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Staff=\"" + staff + "\",@P_employedBy=\""
					+ employedBy + "\", @P_userId=\"" + userId + "\", @P_organization=\"" + organization
					+ "\", @P_orgDivision=\"" + orgDivision + "\";";
			System.out.println("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "viewSummaryReport").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : reportSummary Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> reportAttendance(String fromDate, String toDate, String staff, String employedBy,
			String userId, String organization, String orgDivision) {
		logger.info("Method : reportAttendance Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Staff=\"" + staff + "\",@P_employedBy=\""
					+ employedBy + "\",@P_userId=\"" + userId + "\", @P_organization=\"" + organization
					+ "\", @P_orgDivision=\"" + orgDivision + "\";";
			System.out.println("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "reportAttendance").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : reportAttendance Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> reportLeave(String fromDate, String toDate, String staff, String employedBy,
			String userId, String organization, String orgDivision) {
		logger.info("Method : reportLeave Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Staff=\"" + staff + "\",@P_employedBy=\""
					+ employedBy + "\",@P_userId=\"" + userId + "\", @P_organization=\"" + organization
					+ "\", @P_orgDivision=\"" + orgDivision + "\";";
			System.out.println("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "reportLeave").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : reportLeave Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> reportAdvance(String fromDate, String toDate, String staff, String employedBy,
			String userId, String organization, String orgDivision) {
		logger.info("Method : reportAdvance Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Staff=\"" + staff + "\",@P_employedBy=\""
					+ employedBy + "\",@P_userId=\"" + userId + "\", @P_organization=\"" + organization
					+ "\", @P_orgDivision=\"" + orgDivision + "\";";
			System.out.println("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "reportAdvance").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : reportAdvance Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> emiAllDetails(String empId) {
		logger.info("Method : emiAllDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_empId='" + empId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "emiAllDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : emiAllDetails Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> reportAttendanceView(String fromDate, String toDate, String staff, String employedBy,
			String userId, String organization, String orgDivision) {
		logger.info("Method : reportAdvance Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Staff=\"" + staff + "\",@P_employedBy=\""
					+ employedBy + "\",@P_userId=\"" + userId + "\", @P_organization=\"" + organization
					+ "\", @P_orgDivision=\"" + orgDivision + "\";";
			System.out.println("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "reportAttendanceView").setParameter("actionValue", value)
					.getResultList();
			System.err.println("dataaa===" + x.get(0));
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : reportAttendanceView Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> reportLicView(String fromDate, String toDate, String staff, String employedBy,
			String userId, String organization, String orgDivision) {
		logger.info("Method : reportLicView Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @P_fromDate=\"" + DateFormatter.getStringDate(fromDate) + "\", @P_toDate=\""
					+ DateFormatter.getStringDate(toDate) + "\", @P_Staff=\"" + staff + "\",@P_employedBy=\""
					+ employedBy + "\",@P_userId=\"" + userId + "\", @P_organization=\"" + organization
					+ "\", @P_orgDivision=\"" + orgDivision + "\";";
			System.err.println("reportLicView====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "reportLicView").setParameter("actionValue", value).getResultList();
			System.err.println("dataaa===" + x.get(0));
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : reportLicView Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> reportLeaveEmpData(String organization, String orgDivision) {
		logger.info("Method : reportLeaveEmpData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_org=\"" + organization + "\", @p_orgDiv=\"" + orgDivision + "\";";
			System.err.println("reportLicView====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "reportLeaveEmpData").setParameter("actionValue", value)
					.getResultList();
			System.err.println("dataaa===" + x);
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : reportLeaveEmpData Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> reportLeaveWagesData(String id,String organization, String orgDivision) {
		logger.info("Method : reportLeaveWagesData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_empId=\"" + id + "\", @p_org=\"" + organization + "\", @p_orgDiv=\"" + orgDivision + "\";";
			System.err.println("reportLicView====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
					.setParameter("actionType", "reportLeaveWagesData").setParameter("actionValue", value)
					.getResultList();
			System.err.println("dataaa===" + x.get(0));
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : reportLeaveWagesData Dao ends"+resp);
		return resp;
	}
	
	// view
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getEmployeeList(String orgName, String orgDivision, String userId) {
			logger.info("Method : getEmployeeList Dao starts");
			
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
				System.out.println("value==============="+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("payrollRoutines")
						.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			logger.info("Method : getEmployeeList Dao ends" + resp );
			return resp;
		}
}
