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
public class RestHrmsDashboardDao {
	Logger logger = LoggerFactory.getLogger(RestHrmsDashboardDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOrganization(String orgName) {
		logger.info("Method : getOrganization starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			System.out.println("organisation===============?"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "getOrganization").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getOrganization ends");
		return getCollectionList;
	}

	//Division

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDivision(String orgName) {
		logger.info("Method : getDivision starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			System.out.println("orgDivision===============?"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "orgDivision").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : orgDivision ends");
		return getCollectionList;
	}
	
	
	
	//getAllDataOprtnls
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getHRMSAllDataOprtnls(String id, String fromDate, String toDate, String location,
				String org, String orgDiv) {
			logger.info("Method : getAllDataOprtnls");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "', @p_id='" + id + "',@p_fromDate='"
						+ fromDate + "',@p_toDate='" + toDate + "';";
				logger.info("************getAllDataOprtnls in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness").setParameter("actionType", "getAllRecordById").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getAllDataOprtnls Dao ends" );
			return resp;

		}
		
		//hrmsDashboardCount1
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsDashboardCount1(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsDashboardCount1");

			
			String div = orgDiv.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values hrmsDashCountHeadCount****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
						.setParameter("actionType", "hrmsDashCountHead").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsDashboardCount1 Dao ends" + resp);
			return resp;

		}

		//hrmsDashboardCount2
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsDashboardCount2(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsDashboardCount2");

			
			String div = orgDiv.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values oprationalAssetCount****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
						.setParameter("actionType", "hrmsDashCountTbl").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsDashboardCount2 Dao ends" + resp);
			return resp;

		}

		
		//hrmsDashboardAttritionHeadCount		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsDashboardAttritionHeadCount(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsDashboardAttritionHeadCount");

			
			String div = orgDiv.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values oprationalAssetCount****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
						.setParameter("actionType", "hrmsDashAttrCountHead").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsDashboardAttritionHeadCount Dao ends" + resp);
			return resp;

		}
		
		//getAllHRMSCityList
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllHRMSCityList(String id) {

			logger.info("Method : getAllHRMSCityList starts");
			List<DropDownModel> stateList = new ArrayList<DropDownModel>();

			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			String value = "SET @p_division='" + id + "';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
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
			logger.info("Method : getAllHRMSCityList ends");
			return response;
		}
		
		//hrmsDashboardAttnInvoluntaryVoluntary		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsDashboardAttnInvoluntaryVoluntary(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsDashboardAttnInvoluntaryVoluntary");

			
			String div = orgDiv.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values hrmsDashboardAttnInvoluntaryVoluntary****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
						.setParameter("actionType", "hrmsDashInvolntryvolntry").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsDashboardAttnInvoluntaryVoluntary Dao ends" + resp);
			return resp;

		}
		
		//hrmsDashboardAttnEmpTenure
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsDashboardAttnEmpTenure(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsDashboardAttnEmpTenure");

			
			String div = orgDiv.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values hrmsDashboardAttnEmpTenure****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
						.setParameter("actionType", "hrmsDashEmpTenure").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsDashboardAttnEmpTenure Dao ends" + resp);
			return resp;

		}
		
		//dashhrmsAttRatio
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsAttRatio(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsAttRatio");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************getAllDataOprtnls in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness").
						setParameter("actionType", "hrmsAttritionRatio").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsAttRatio Dao ends" );
			return resp;

		}
		
		//dashhrmsAttDeptWise
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsAttDeptWise(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsAttDeptWise");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsAttDeptWise in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness").
						setParameter("actionType", "hrmsAttrDeptWise").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsAttDeptWise Dao ends" );
			return resp;

		}
		
		
		//dashhrmsAttVoluntaryWise
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsAttVoluntaryWise(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsAttVoluntaryWise");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsAttVoluntaryWise in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness").
						setParameter("actionType", "hrmsAttrVoluntaryWise").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsAttVoluntaryWise Dao ends" );
			return resp;

		}
		
		//dashhrmsAttReasonDistribution		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsAttReasonDistribution(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsAttReasonDistribution");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsAttReasonDistribution in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness").
						setParameter("actionType", "hrmsAttrReasonDistn").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsAttReasonDistribution Dao ends" );
			return resp;

		}
		
		//dashhrmsAttritionByTenure
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsAttritionByTenureSalary(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsAttritionByTenureSalary");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsAttritionByTenureSalary in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness").
						setParameter("actionType", "hrmsAttrByTenureSalary").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsAttritionByTenureSalary Dao ends" );
			return resp;

		}
		
		
		//dashhrmsAttritionByJobRole
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsAttritionByJobRole(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsAttritionByJobRole");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsAttritionByJobRole in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness").
						setParameter("actionType", "hrmsAttrByJobRole").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsAttritionByJobRole Dao ends" );
			return resp;

		}
		
		//dashhrmsAttritionByTenure
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsAttritionByTenure(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsAttritionByTenure");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsAttritionByTenure in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness").
						setParameter("actionType", "hrmsAttrByTenure").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsAttritionByTenure Dao ends" );
			return resp;

		}
		


		//hrmsDashboardCompensationHeadCount
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsDashboardCompensationHeadCount(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsDashboardCompensationHeadCount");

			
			String div = orgDiv.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values hrmsDashboardCompensationHeadCount****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
						.setParameter("actionType", "hrmsDashCmpnCountHead").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsDashboardCompensationHeadCount Dao ends" + resp);
			return resp;

		}
		//hrmsDashboardCompensationSalaryDistributionDept
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsDashboardCompensationSalaryDistributionDept(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsDashboardCompensationSalaryDistributionDept");

			
			String div = orgDiv.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values hrmsDashboardCompensationSalaryDistributionDept****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
						.setParameter("actionType", "hrmsDashCmpnDistDept").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsDashboardCompensationSalaryDistributionDept Dao ends" + resp);
			return resp;

		}
		//hrmsDashboardCompensationSalaryRange
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsDashboardCompensationEmpCountSalaryRange(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsDashboardCompensationEmpCountSalaryRange");

			
			String div = orgDiv.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values hrmsDashboardCompensationEmpCountSalaryRange****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
						.setParameter("actionType", "hrmsEmpCntSlryRange").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsDashboardCompensationEmpCountSalaryRange Dao ends" + resp);
			return resp;

		}
		//dashhrmsCompensationJoiningLeavingTrend
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsCompensationJoiningLeavingTrend(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsCompensationJoiningLeavingTrend");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsCompensationJoiningLeavingTrend in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness").
						setParameter("actionType", "hrmsCmpnJoinLeaveTrend").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsCompensationJoiningLeavingTrend Dao ends" );
			return resp;

		}
		//dashhrmsCompensationSalaryByPerformance
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsCompensationSalaryByPerformance(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsCompensationSalaryByPerformance");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsCompensationSalaryByPerformance in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness").
						setParameter("actionType", "hrmsCmpnSlryByPerform").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsCompensationSalaryByPerformance Dao ends" );
			return resp;

		}
		//dashhrmsAttritionCompensationAvgSalryYearRangeBy
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsAttritionCompensationAvgSalryYearRangeBy(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsAttritionCompensationAvgSalryYearRangeBy");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsAttritionCompensationAvgSalryYearRangeBy in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness").
						setParameter("actionType", "hrmsCmpnAvgSalaryRngBy").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsAttritionCompensationAvgSalryYearRangeBy Dao ends" );
			return resp;

		}
		
		
		//////////////////////////Performance Start/////////////////////////////////////
		//dashhrmsPerformHeadCount
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsPerformHeadCount(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsPerformHeadCount");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsPerformHeadCount in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsPerfrmHeadCnt").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsPerformHeadCount Dao ends" );
			return resp;

		}
		
		
		//dashhrmsPerformanceEmpRatingDistriByDept
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsPerformanceEmpRatingDistriByDept(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsPerformanceEmpRatingDistriByDept");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsPerformanceEmpRatingDistriByDept in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsPrfrmEmpRatingDist").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsPerformanceEmpRatingDistriByDept Dao ends" );
			return resp;

		}
		
		
		//dashhrmsPerformanceEmpTenureWithLastYear
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsPerformanceEmpTenureWithLastYear(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsPerformanceEmpTenureWithLastYear");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsPerformanceEmpTenureWithLastYear in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsPrfrmEmpTnrLstYr").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsPerformanceEmpTenureWithLastYear Dao ends" );
			return resp;

		}
		
		
		//dashhrmsPerformanceOvertimebyAgeGroup
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsPerformanceOvertimebyAgeGroup(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsPerformanceOvertimebyAgeGroup");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsPerformanceOvertimebyAgeGroup in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsPrfrmOvrTmByAgeGroup").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsPerformanceOvertimebyAgeGroup Dao ends" );
			return resp;

		}
		
		
		//dashhrmsPerformanceAbsenteeismRate
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsPerformanceAbsenteeismRate(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsPerformanceAbsenteeismRate");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsPerformanceAbsenteeismRate in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsPrfrmAbstsmRate").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsPerformanceAbsenteeismRate Dao ends" );
			return resp;

		}
		
		
		//dashhrmsPerformanceEmpCountByRating
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsPerformanceEmpCountByRating(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsPerformanceEmpCountByRating");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsPerformanceEmpCountByRating in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsPrfrmEmpCntByRatng").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsPerformanceEmpCountByRating Dao ends" );
			return resp;

		}
		
		
		//dashhrmsPerformanceAvgSalaryYearRangeBy
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashhrmsPerformanceAvgSalaryYearRangeBy(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashhrmsPerformanceAvgSalaryYearRangeBy");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************dashhrmsPerformanceAvgSalaryYearRangeBy in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsPrfrmAvgSlryTnrBy").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashhrmsPerformanceAvgSalaryYearRangeBy Dao ends" );
			return resp;

		}
		
//////////////////////////////////Management Start//////////////////////////////////
		//hrmsManagementHeadCount
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsManagementHeadCount(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsManagementHeadCount");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsManagementHeadCount in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsManagmntHeadCnt").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsManagementHeadCount Dao ends" );
			return resp;

		}
		//hrmsManagementEmpCntByDept
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsManagementEmpCntByDept(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsManagementEmpCntByDept");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsManagementEmpCntByDept in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsManagmntEmpByDept").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsManagementEmpCntByDept Dao ends" );
			return resp;

		}
		//hrmsManagementEmpCntByAge
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsManagementEmpCntByAge(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsManagementEmpCntByAge");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsManagementEmpCntByAge in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsManagmntEmpByAge").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsManagementEmpCntByAge Dao ends" );
			return resp;

		}
		//hrmsManagementEmpCntByDeptExp
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsManagementEmpCntByDeptExp(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsManagementEmpCntByDeptExp");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsManagementEmpCntByDeptExp in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsManagmntEmpByDptExp").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsManagementEmpCntByDeptExp Dao ends" );
			return resp;

		}
		//hrmsManagementHeadCountDevlpmnt
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsManagementHeadCountDevlpmnt(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsManagementHeadCountDevlpmnt");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsManagementHeadCountDevlpmnt in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsMngmntHeadCntDev").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsManagementHeadCountDevlpmnt Dao ends" );
			return resp;

		}
		//hrmsManagementEmpPayByDept
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsManagementEmpPayByDept(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsManagementEmpPayByDept");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsManagementEmpPayByDept in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsMngmntEmpPayByDept").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsManagementEmpPayByDept Dao ends" );
			return resp;

		}
		//hrmsManagementHireByEmpType
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsManagementHireByEmpType(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsManagementHireByEmpType");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsManagementHireByEmpType in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsMngmntHireByEmp").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsManagementHireByEmpType Dao ends" );
			return resp;

		}
		//hrmsManagementSalaryByAgeGroup
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsManagementSalaryByAgeGroup(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsManagementSalaryByAgeGroup");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsManagementSalaryByAgeGroup in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsMngmntSlyByAgeGroup").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsManagementSalaryByAgeGroup Dao ends" );
			return resp;

		}
		//hrmsManagementEmpByGender
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsManagementEmpByGender(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsManagementEmpByGender");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsManagementEmpByGender in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsMngmntEmpByGender").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsManagementEmpByGender Dao ends" );
			return resp;

		}
		//hrmsManagementEmpCountByCity
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsManagementEmpCountByCity(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsManagementEmpCountByCity");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsManagementEmpCountByCity in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsMngmntEmpCntByCity").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsManagementEmpCountByCity Dao ends" );
			return resp;

		}
		//hrmsManagementEmpByExperience
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsManagementEmpByExperience(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsManagementEmpByExperience");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsManagementEmpByExperience in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsMngmntEmpByExper").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsManagementEmpByExperience Dao ends" );
			return resp;

		}
		//hrmsManagementCostPerEmp	
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsManagementCostPerEmp(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsManagementCostPerEmp");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsManagementCostPerEmp in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsMngmntCostPerEmp").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsManagementCostPerEmp Dao ends" );
			return resp;

		}
//////////////////////////////////Management End////////////////////////////////////
		
//////////////////////////////////Talent Start////////////////////////////////////
		//hrmsTalentHeadCount
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsTalentHeadCount(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsTalentHeadCount");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsTalentHeadCount in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsTalentHeadCnt").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsTalentHeadCount Dao ends" );
			return resp;

		}
		
		//hrmsTalentTurnoverRate
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsTalentTurnoverRate(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsTalentTurnoverRate");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsTalentTurnoverRate in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsTalentTurnOver").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsTalentTurnoverRate Dao ends" );
			return resp;

		}
		
		//hrmsTalentFiredByEmploymentByPeriod
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsTalentFiredByEmploymentByPeriod(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsTalentFiredByEmploymentByPeriod");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsTalentFiredByEmploymentByPeriod in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsTalentfiredByEmp").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsTalentFiredByEmploymentByPeriod Dao ends" );
			return resp;

		}
		
		//hrmsTalentSatisfactionMonthWise
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsTalentSatisfactionMonthWise(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsTalentSatisfactionMonthWise");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsTalentSatisfactionMonthWise in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsTalentSatsfMnthWise").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsTalentSatisfactionMonthWise Dao ends" );
			return resp;

		}
		
		//hrmsTalentTrendWiseYearCount
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsTalentTrendWiseYearCount(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsTalentTrendWiseYearCount");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsTalentTrendWiseYearCount in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsTlentTrndWisYrCnt").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsTalentTrendWiseYearCount Dao ends" );
			return resp;

		}
		
		//hrmsTalentRatingMonthWise
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsTalentRatingMonthWise(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsTalentRatingMonthWise");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsTalentRatingMonthWise in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsTlentRatngMnthWise").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsTalentRatingMonthWise Dao ends" );
			return resp;

		}
		
		//hrmsTalentByRatingByPercent
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsTalentByRatingByPercent(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsTalentByRatingByPercent");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsTalentByRatingByPercent in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "hrmsTlentRatngByPercent").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsTalentByRatingByPercent Dao ends" );
			return resp;

		}
		
		//hrmsTalentLastSixMonthCategoriesWise
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsTalentLastSixMonthCategoriesWise(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsTalentLastSixMonthCategoriesWise");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsTalentLastSixMonthCategoriesWise in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "talentLstSixMnthCatWisCnt").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsTalentLastSixMonthCategoriesWise Dao ends" );
			return resp;

		}
		
		//hrmsTalentLastOneYearCategoriesWise
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsTalentLastOneYearCategoriesWise(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsTalentLastOneYearCategoriesWise");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsTalentLastOneYearCategoriesWise in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "talentLstOneYrCatWisCnt").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsTalentLastOneYearCategoriesWise Dao ends" );
			return resp;

		}
		
		//hrmsTalentLastTwoYearCategoriesWise
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsTalentLastTwoYearCategoriesWise(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsTalentLastTwoYearCategoriesWise");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsTalentLastTwoYearCategoriesWise in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "talentLstTwoYrCatWisCnt").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsTalentLastTwoYearCategoriesWise Dao ends" );
			return resp;

		}
		
		//hrmsTalentLastThreeYearCategoriesWise	
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> hrmsTalentLastThreeYearCategoriesWise(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : hrmsTalentLastThreeYearCategoriesWise");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			String div = orgDiv.trim();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("************hrmsTalentLastThreeYearCategoriesWise in hrms dashboard========*******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness2").
						setParameter("actionType", "talentLstThreeYrCatWisCnt").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : hrmsTalentLastThreeYearCategoriesWise Dao ends" );
			return resp;

		}
		

		
//////////////////////////////////Talent End//////////////////////////////////////
		

	/*
	// Total Monthly Attendance
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getTotalMonthlyAttendance(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getTotalMonthlyAttendance starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";
			logger.info("Method : getTotalMonthlyAttendance startsssssssssssssssssssssssss" + values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "monthlyattendance").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), m[2].toString());
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTotalMonthlyAttendance ends" + resp);
		return resp;
	}

	// totalMonthlyAttendance aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalMonthlyAttendanceAggrid(String userId, String value1,
			String orgName, String orgDiv, String currentYear, String month) {

		logger.info("Method : getTotalMonthlyAttendanceAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "',@p_month='" + month + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "monthlyAttendanceAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, m[0], m[1], m[2].toString(),
						m[3], null, null, null);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalMonthlyAttendanceAggrid ends");

		return resp;
	}

	// Total Monthly Reimbursement
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getTotalMonthlyReimbursement(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getTotalMonthlyReimbursement starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "monthlyreimbursement").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), m[2].toString());
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTotalMonthlyReimbursement ends" + resp);

		return resp;
	}

	// TotalMonthlyReimbursement Aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalMonthlyReimbursementAggrid(String userId, String value1,
			String orgName, String orgDiv, String currentYear, String month) {
		logger.info("Method : getTotalMonthlyReimbursementAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "',@p_month='" + month + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "monthlyReimbursementAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, m[0],
						m[1], m[2], m[3].toString(), m[4].toString(), m[5], null, null, null, null, null);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalMonthlyReimbursementAggrid ends");

		return resp;
	}

	// Total Leave
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getTotalLeave(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getTotalLeave starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "totalLeave").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), null);
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTotalLeave ends" + resp);
		return resp;
	}

	// leave aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalLeaveAggrid(String userId, String value1, String orgName,
			String orgDiv, String currentYear) {
		logger.info("Method : getTotalLeaveAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "';";
logger.info("values===="+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "leaveAggrid").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				Object DATE = null;
				if (m[4] != null) {
					DATE = DateFormatter.returnStringDate(m[4]);
				}
				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(m[0].toString(), m[1].toString(),
						m[2].toString(), m[3].toString(), DATE);
				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalLeaveAggrid ends");

		return resp;
	}

	// Total Monthly event
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getTotalMonthlyEvent(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getTotalMonthlyEvent starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "monthlyEvent").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), m[2].toString());
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTotalMonthlyEvent ends" + resp);

		return resp;
	}

	// Total Monthly event Aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalMonthlyEventAggrid(String userId, String value1,
			String orgName, String orgDiv, String currentYear, String month) {
		logger.info("Method : getTotalMonthlyEventAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "',@p_month='" + month + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "monthlyEventAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, m[0].toString(), m[1].toString(), m[2].toString(),
						m[3].toString(), m[4].toString());

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalMonthlyEventAggrid ends");

		return resp;
	}

	// Count Details
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getCountDetails(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getCountDetails starts");
		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();
		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";
logger.info("count values==="+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "totalCountDetails").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(m[0].toString(), m[1].toString(),
						m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(), null, null, null, null,
						null, null, null, null);
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountDetails ends" + resp);

		return resp;
	}

	// Manager Count Deatails
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getManagerCountDetails(String userId, String orgName,
			String orgDiv, String currentYear) {
		logger.info("Method : getManagerCountDetails starts");
		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();
		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "totalManagerCountDetails").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, m[0].toString(), m[1].toString(), m[2].toString(), m[3].toString());

				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getManagerCountDetails ends" + resp);

		return resp;
	}

	// Leave Approve
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getLeaveApprove(String userId, String orgName, String orgDiv,
			String fromdate, String todate) {
		logger.info("Method : getLeaveApprove starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_fromdate='" + DateFormatter.getStringDate(fromdate) + "', @p_todate='" + DateFormatter.getStringDate(todate) + "';";
			logger.info("Method : getLeaveApprove startssssssssssssssssssss" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "leaveApprove").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), null);
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLeaveApprove ends" + resp);
		return resp;
	}

	// leave approve aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getLeaveApprovedAggrid(String userId, String value1,
			String orgName, String orgDiv, String fromdate, String todate) {
		logger.info("Method : getLeaveApprovedAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_fromdate='" + DateFormatter.getStringDate(fromdate)  + "',@p_todate='"+DateFormatter.getStringDate(todate) +"';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "leaveApproveAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object applyDATE = null;
				if (m[2] != null) {
					applyDATE = DateFormatter.returnStringDate(m[2]);
				}
				Object approveDATE = null;
				if (m[4] != null) {
					approveDATE = DateFormatter.returnStringDate(m[4]);
				}
				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(m[0], m[1], applyDATE, m[3], approveDATE);
				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getLeaveApprovedAggrid ends");

		return resp;
	}

	// Total Reimbursement Approved
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getReimbursementApproved(String userId, String orgName, String orgDiv,
			String fromdate,String todate) {
		logger.info("Method : getReimbursementApproved starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_fromdate='" + DateFormatter.getStringDate(fromdate)  + "',@p_todate='"+DateFormatter.getStringDate(todate) +"';";
			logger.info("values_____________"+values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "reimbursementApproved").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), m[2].toString());
				req.add(reqemp);
			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getReimbursementApproved ends" + resp);

		return resp;
	}

	// Total ReimbursementApproved Aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getReimbursementApprovedAggrid(String userId, String value1,
			String orgName, String orgDiv, String month,String fromdate,String todate) {
		logger.info("Method : getReimbursementApprovedAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_month='" + month + "',@p_fromdate='" + DateFormatter.getStringDate(fromdate)  + "',@p_todate='"+DateFormatter.getStringDate(todate) +"';";
logger.info("values==="+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "reimbursementApprovedAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, m[0],
						m[1], m[2], m[3].toString(), m[4].toString(), m[5], null, null, null, null, null);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getReimbursementApprovedAggrid ends");

		return resp;
	}

	// PayRoll Process
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getPayrollProcess(String userId, String orgName, String orgDiv,
			String fromdate, String todate) {
		logger.info("Method : getPayrollProcess starts");
		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();
		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_fromdate='" + DateFormatter.getStringDate(fromdate) + "', @p_todate='"+DateFormatter.getStringDate(todate)+"';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "payrollProcess").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, m[0].toString(),
						null, m[1].toString(), null, null, m[2].toString());
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPayrollProcess ends" + resp);

		return resp;
	}

	// Payroll Process Aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getPayrollProcessAggrid(String userId, String value,
			String orgName, String orgDiv, String fromdate, String todate) {
		logger.info("Method : getPayrollProcessAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value='" + value + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_fromdate='" + DateFormatter.getStringDate(fromdate) + "',@p_todate='"+DateFormatter.getStringDate(todate)+"';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "payrollProcessAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, m[0], m[1],
						m[2], m[3], null);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPayrollProcessAggrid ends");

		return resp;
	}

	// RatingwiseAppresal
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getRatingWise(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getRatingWise starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "ratingwiseAppresal").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), null);
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getRatingWise ends" + resp);

		return resp;
	}

	// Ratingwise Appresal Aggrid

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getRatingWiseAggrid(String userId, String value1, String orgName,
			String orgDiv, String currentYear) {
		logger.info("Method : getRatingWiseAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "ratingwiseAppresalAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, m[0].toString(), m[1].toString(),
						null, null, null, m[2].toString(), m[3].toString());
				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRatingWiseAggrid ends");

		return resp;
	}

	// HR Count Deatails
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getHrCountDetails(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getHrCountDetails starts");
		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();
		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "totalHrCountDetails").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(m[0].toString(), m[1].toString(),
						m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(), null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getHrCountDetails ends" + resp);

		return resp;
	}

	// Designation By Requisition
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getDesignationByRequisition(String userId, String orgName,
			String orgDiv, String currentYear) {
		logger.info("Method : getDesignationByRequisition starts");
		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();
		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "designationByRequisition").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, m[0].toString(), m[1].toString(), m[2].toString(),
						m[3].toString(), null, null, null, null, null, null, null, null, null);
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDesignationByRequisition ends" + resp);

		return resp;
	}
	// Designation By Requisition Aggrid

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getDesignationByRequisitionAggrid(String userId, String value1,
			String orgName, String orgDiv, String currentYear, String value) {
		logger.info("Method : getDesignationByRequisitionAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "',@p_value='" + value + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "designationByRequisitionAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, m[0], m[1], m[2], m[3], m[4],
						null, null);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDesignationByRequisitionAggrid ends");

		return resp;
	}

	// Requisition Status
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getRequisitionStatus(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getRequisitionStatus starts");
		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();
		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "requisitionStatus").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, m[0].toString(), m[1].toString(), null,
						null, null, null, null, null, null);

				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getRequisitionStatus ends" + resp);

		return resp;
	}

	// Requisition Status Aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getRequisitionStatusAggrid(String userId, String value,
			String orgName, String orgDiv, String currentYear) {
		logger.info("Method : getRequisitionStatusAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value='" + value + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "requisitionStatusAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, m[0], m[1].toString(), m[2],
						m[3].toString(), null, null, null);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRequisitionStatusAggrid ends");

		return resp;
	}

	//// Gender Wise Candidate
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getGendereWiseCandidate(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getGendereWiseCandidate starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "gendereWiseCandidate").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString());

				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getGendereWiseCandidate ends" + resp);

		return resp;
	}

	// Gender Wise Candidate Aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getGendereWiseCandidateAggrid(String userId, String value1,
			String orgName, String orgDiv, String currentYear) {
		logger.info("Method : getGendereWiseCandidateAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "gendereWiseCandidateAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, m[0].toString(),
						m[1].toString(), null, null, m[2].toString(), m[3].toString());

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getGendereWiseCandidateAggrid ends");

		return resp;
	}
	// Yearly Event

	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getYearlyEvent(String userId, String orgName, String orgDiv,
			String currentYear) {
		logger.info("Method : getYearlyEvent starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_currentYear='" + currentYear + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "yearlyEvent").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {

				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), m[2].toString());
				req.add(reqemp);

			}
			resp.setBody(req);

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getYearlyEvent ends" + resp);

		return resp;
	}

	// Yearly Selection Aggrid
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getYearlyEventAggrid(String userId, String value1, String orgName,
			String orgDiv, String currentYear, String month) {
		logger.info("Method : getYearlyEventAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_currentYear='" + currentYear + "',@p_month='" + month + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "yearlyEventAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, null, null, null, null, null,
						null, null, null, null, null, m[0], m[1].toString(), m[2].toString(), m[3], m[4]);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getYearlyEventAggrid ends");

		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestHrmsDashboardModel>>> viewYearSelectionData(String currentYear,
			String orgname, String orgdiv) {
		logger.info("Method : viewYearSelectionData starts");

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();
		List<RestHrmsDashboardModel> rs = new ArrayList<RestHrmsDashboardModel>();

		try {

			String value = "SET @p_currentYear='" + currentYear + "', @p_orgname='" + orgname + "', @p_orgdiv='"
					+ orgdiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "viewyearselection").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(m[0], m[1].toString(), null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null);
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestHrmsDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestHrmsDashboardModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : viewYearSelectionData ends");
		logger.info("sssssssssssssssssssssssss" + response);
		return response;
	}

	// getAttendanceReports
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getAttendanceReports(String userId, String orgName, String orgDiv,
			String fromdate, String todate) {
		logger.info("Method : getAttendanceReports starts");
		List<DropDownModel> req = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String values = "SET @p_empId='" + userId + "', @p_orgNames='" + orgName + "',@p_orgDivs='" + orgDiv
					+ "',@p_fromdate='" + DateFormatter.getStringDate(fromdate) + "', @p_todate='"
					+ DateFormatter.getStringDate(todate) + "';";
			logger.info("===============" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "attendanceReports").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel reqemp = new DropDownModel(m[0].toString(), m[1].toString(), m[2]);
				req.add(reqemp);
			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAttendanceReports ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsDashboardModel>> getTotalEmployeeAttendanceAggrid(String userId, String value1,
			String orgName, String orgDiv, String fromdate, String todate, String shift) {

		logger.info("Method : getTotalEmployeeAttendanceAggrid starts");

		List<RestHrmsDashboardModel> req = new ArrayList<RestHrmsDashboardModel>();

		JsonResponse<List<RestHrmsDashboardModel>> resp = new JsonResponse<List<RestHrmsDashboardModel>>();

		try {
			String values = "SET @p_empId='" + userId + "',@p_value1='" + value1 + "',@p_orgNames='" + orgName
					+ "',@p_orgDivs='" + orgDiv + "',@p_fromdate='" + DateFormatter.getStringDate(fromdate)
					+ "',@p_todate='" + DateFormatter.getStringDate(todate) + "',@p_shift='" + shift + "';";
			logger.info("value----------------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsdashboardRoutiness")
					.setParameter("actionType", "employeeAttendanceAggrid").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsDashboardModel reqemp = new RestHrmsDashboardModel(null, null, m[0], m[1], m[2].toString(),
						m[3], null, null, m[4]);

				req.add(reqemp);
				resp.setBody(req);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalEmployeeAttendanceAggrid ends");

		return resp;
	}
	
	*/
}
