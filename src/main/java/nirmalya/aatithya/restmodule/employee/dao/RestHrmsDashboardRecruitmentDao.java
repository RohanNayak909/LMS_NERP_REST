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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsDashboardModel;

@Repository
public class RestHrmsDashboardRecruitmentDao {
	Logger logger = LoggerFactory.getLogger(RestHrmsDashboardRecruitmentDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;
	
	//hrmsRecruitmentHeadCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> hrmsRecruitmentHeadCount(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : hrmsRecruitmentHeadCount");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************hrmsRecruitmentHeadCount in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsDashRecruitRoutine").
					setParameter("actionType", "recuitHeadCnt").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : hrmsRecruitmentHeadCount Dao ends" );
		return resp;

	}
	
	
	
	
	
	//hrmsRecruitmentAvgCostHiringBySeniorityLevel
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> hrmsRecruitmentAvgCostHiringBySeniorityLevel(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : hrmsRecruitmentAvgCostHiringBySeniorityLevel");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************hrmsRecruitmentAvgCostHiringBySeniorityLevel in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsDashRecruitRoutine").
					setParameter("actionType", "rectAvgHrCstBySnr").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : hrmsRecruitmentAvgCostHiringBySeniorityLevel Dao ends" );
		return resp;

	}
	
	
	
	
	
	//hrmsRecruitmentFunnel
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> hrmsRecruitmentFunnel(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : hrmsRecruitmentFunnel");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************hrmsRecruitmentFunnel in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsDashRecruitRoutine").
					setParameter("actionType", "recuitFunnel").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : hrmsRecruitmentFunnel Dao ends" );
		return resp;

	}
	
	
	//hrmsRecruitmentAvgDeptByFullfillInDays
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> hrmsRecruitmentAvgDeptByFullfillInDays(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : hrmsRecruitmentAvgDeptByFullfillInDays");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************hrmsRecruitmentAvgDeptByFullfillInDays in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsDashRecruitRoutine").
					setParameter("actionType", "rcutAvgDptfillDay").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : hrmsRecruitmentAvgDeptByFullfillInDays Dao ends" );
		return resp;

	}
	
	
	
	//hrmsRecruitmentHiredBySource
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> hrmsRecruitmentHiredBySource(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : hrmsRecruitmentHiredBySource");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************hrmsRecruitmentHiredBySource in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsDashRecruitRoutine").
					setParameter("actionType", "recuitHireBySource").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : hrmsRecruitmentHiredBySource Dao ends" );
		return resp;

	}
	
	
	//hrmsRecruitmentProgressDistribution
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> hrmsRecruitmentProgressDistribution(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : hrmsRecruitmentProgressDistribution");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************hrmsRecruitmentProgressDistribution in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsDashRecruitRoutine").
					setParameter("actionType", "recuitProgressDist").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : hrmsRecruitmentProgressDistribution Dao ends" );
		return resp;

	}
	
	
	//hrmsRecruitmentAcceptanceRejectionDistribution
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> hrmsRecruitmentAcceptanceRejectionDistribution(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : hrmsRecruitmentAcceptanceRejectionDistribution");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************hrmsRecruitmentAcceptanceRejectionDistribution in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsDashRecruitRoutine").
					setParameter("actionType", "recuitActRejectDist").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : hrmsRecruitmentAcceptanceRejectionDistribution Dao ends" );
		return resp;

	}
	
	
	//hrmsRecruitmentOfferDeclineReason
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> hrmsRecruitmentOfferDeclineReason(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : hrmsRecruitmentOfferDeclineReason");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************hrmsRecruitmentOfferDeclineReason in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsDashRecruitRoutine").
					setParameter("actionType", "rcuitOfrDcleRson").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : hrmsRecruitmentOfferDeclineReason Dao ends" );
		return resp;

	}
	
	
	//hrmsRecruitmentHiringVacancyTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> hrmsRecruitmentHiringVacancyTrend(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : hrmsRecruitmentHiringVacancyTrend");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************hrmsRecruitmentHiringVacancyTrend in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsDashRecruitRoutine").
					setParameter("actionType", "rcutHirVcncyTrnd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : hrmsRecruitmentHiringVacancyTrend Dao ends" );
		return resp;

	}
	
	
	//hrmsRecruitmentHiredByJobsRole
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> hrmsRecruitmentHiredByJobsRole(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : hrmsRecruitmentHiredByJobsRole");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************hrmsRecruitmentHiredByJobsRole in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsDashRecruitRoutine").
					setParameter("actionType", "recuitHireByJobsRole").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : hrmsRecruitmentHiredByJobsRole Dao ends" );
		return resp;

	}
	
	
	//hrmsRecruitmentHiredByProject
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> hrmsRecruitmentHiredByDepartment(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : hrmsRecruitmentHiredByDepartment");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************hrmsRecruitmentHiredByDepartment in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsDashRecruitRoutine").
					setParameter("actionType", "recuitHirByDept").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : hrmsRecruitmentHiredByDepartment Dao ends" );
		return resp;

	}
	
	
	//hrmsRecruitmentSalaryDistByExpHiresEmp
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> hrmsRecruitmentSalaryDistByExpHiresEmp(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : hrmsRecruitmentSalaryDistByExpHiresEmp");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************hrmsRecruitmentSalaryDistByExpHiresEmp in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsDashRecruitRoutine").
					setParameter("actionType", "rcutSlryDistByExpEmp").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : hrmsRecruitmentSalaryDistByExpHiresEmp Dao ends" );
		return resp;

	}
	
	
	//hrmsRecruitmentHiredByAgeBrackets

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> hrmsRecruitmentHiredByAgeBrackets(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : hrmsRecruitmentHiredByAgeBrackets");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************hrmsRecruitmentHiredByAgeBrackets in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsDashRecruitRoutine").
					setParameter("actionType", "rcutHirByAgeBrkt").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : hrmsRecruitmentHiredByAgeBrackets Dao ends" );
		return resp;

	}
	
	
	
	//hrmsRecruitmentConversionRateByHr
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsRecruitmentConversionRateByHr(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsRecruitmentConversionRateByHr");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsRecruitmentConversionRateByHr in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsDashRecruitRoutine").
						setParameter("actionType", "recuitConverRateByHr").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsRecruitmentConversionRateByHr Dao ends" );
			return resp;

		}
	
}
