package nirmalya.aatithya.restmodule.recruitment.dao;

import java.math.BigInteger;
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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateJobParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.model.JobTitleRestModel;

@Repository
public class RecuitmentDashboardDao {
	Logger logger = LoggerFactory.getLogger(RecuitmentDashboardDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

		
	//recruitmentDashHeadCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashHeadCount(String fromDate, String toDate, String location, String org,
			String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashHeadCount");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashHeadCount in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "recuitHeadCnt").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashHeadCount Dao ends" );
		return resp;

	}

	
	//recruitmentDashAvgCostHiringBySeniorityLevel
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashAvgCostHiringBySeniorityLevel(String fromDate, String toDate, String location,
			String org,	String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashAvgCostHiringBySeniorityLevel");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashAvgCostHiringBySeniorityLevel in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "rectAvgHrCstBySnr").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashAvgCostHiringBySeniorityLevel Dao ends" );
		return resp;

	}
	
	//getAllRctmntCityList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllRctmntCityList(String id) {

		logger.info("Method : getAllRctmntCityList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_division='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines")
					.setParameter("actionType", "getAllCityList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllRctmntCityList ends");
		return response;
	}

	
	//recruitmentDashFunnelCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashFunnelCount(String fromDate, String toDate, String location,
			String org,	String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashFunnelCount");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashFunnelCount in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "recuitFunnel").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashFunnelCount Dao ends" );
		return resp;

	}

	
	//recruitmentDashTurnOverRateByAge
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashTurnOverRateByAge(String fromDate, String toDate, String location,
			String org,	String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashTurnOverRateByAge");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashTurnOverRateByAge in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "recuiTrnOvrRteByAge").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashTurnOverRateByAge Dao ends" );
		return resp;

	}

	
	//recruitmentDashHiredBySource
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashHiredBySource(String fromDate, String toDate, String location,
			String org,	String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashHiredBySource");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashHiredBySource in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "recuitHireBySource").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashHiredBySource Dao ends" );
		return resp;

	}

	
	
	//recruitmentDashHiringVacancyTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashHiringVacancyTrend(String fromDate, String toDate, String location,
			String org,	String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashHiringVacancyTrend");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashHiringVacancyTrend in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "rcutHirVcncyTrnd").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashHiringVacancyTrend Dao ends" );
		return resp;

	}

	
	//recruitmentDashHiringByJobsRole
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashHiringByJobsRole(String fromDate, String toDate, String location,
			String org,	String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashHiringByJobsRole");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashHiringByJobsRole in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "recuitHireByJobsRole").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashHiringByJobsRole Dao ends" );
		return resp;

	}

	
	//recruitmentDashAvgDeptByfullfillInDay
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashAvgDeptByfullfillInDay(String fromDate, String toDate, String location,
			String org,	String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashAvgDeptByfullfillInDay");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashAvgDeptByfullfillInDay in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "rcutAvgDptfillDay").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashAvgDeptByfullfillInDay Dao ends" );
		return resp;

	}

	
	//recruitmentDashHiredByDepartment
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashHiredByDepartment(String fromDate, String toDate, String location,
			String org,	String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashHiredByDepartment");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashHiredByDepartment in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "recuitHirByDept").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashHiredByDepartment Dao ends" );
		return resp;

	}

	
	//recruitmentDashSalaryDistByExpHiredEmp
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashSalaryDistByExpHiredEmp(String fromDate, String toDate, String location,
			String org,	String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashSalaryDistByExpHiredEmp");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashSalaryDistByExpHiredEmp in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "rcutSlryDistByExpEmp").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashSalaryDistByExpHiredEmp Dao ends" );
		return resp;

	}

	
	
	
	//recruitmentDashHiredByAgeBrackets
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashHiredByAgeBrackets(String fromDate, String toDate, String location,
			String org,	String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashHiredByAgeBrackets");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashHiredByAgeBrackets in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "rcutHirByAgeBrkt").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashHiredByAgeBrackets Dao ends" );
		return resp;

	}

	
	//recruitmentDashOfferDeclineReason
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashOfferDeclineReason(String fromDate, String toDate, String location,
			String org,	String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashOfferDeclineReason");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashOfferDeclineReason in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "rcuitOfrDcleRson").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashOfferDeclineReason Dao ends" );
		return resp;

	}

	
	//recruitmentDashProgressDistribution
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashProgressDistribution(String fromDate, String toDate, String location,
			String org,	String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashProgressDistribution");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashProgressDistribution in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "recuitProgressDist").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashProgressDistribution Dao ends" );
		return resp;

	}

	
	//recruitmentDashAcceptRejectionDistribution
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashAcceptRejectionDistribution(String fromDate, String toDate, String location,
			String org,	String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashAcceptRejectionDistribution");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashAcceptRejectionDistribution in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "recuitActRejectDist").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashAcceptRejectionDistribution Dao ends" );
		return resp;

	}

	
	//recruitmentDashConversionRateByHr
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> recruitmentDashConversionRateByHr(String fromDate, String toDate, String location,
			String org,	String orgDiv, String department, String jobRole, String recuiter, String type) {
		logger.info("Method : recruitmentDashConversionRateByHr");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("************recruitmentDashConversionRateByHr in hrms dashboard========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("recuitmentDashboardRoutines").
					setParameter("actionType", "recuitConverRateByHr").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : recruitmentDashConversionRateByHr Dao ends" );
		return resp;

	}

	

}