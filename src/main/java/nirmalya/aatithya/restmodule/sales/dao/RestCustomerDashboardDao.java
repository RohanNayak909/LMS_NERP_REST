package nirmalya.aatithya.restmodule.sales.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.model.RestCustomerGraphModel;
import nirmalya.aatithya.restmodule.sales.model.RestCustomerStoreGraphModel;
@Repository
public class RestCustomerDashboardDao {
	Logger logger = LoggerFactory.getLogger(RestCustomerDashboardDao.class);
	
	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EntityManager em;
	
	
	//getOrganization
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOrganization(String orgName) {
		logger.info("Method : getOrganization starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			System.out.println("organisation===============?"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
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
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDivision(String orgName) {
		logger.info("Method : getDivision starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			System.out.println("orgDivision===============?"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
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

	
	//getAllSalesCityList
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllSalesCityList(String id) {

			logger.info("Method : getAllSalesCityList starts");
			List<DropDownModel> stateList = new ArrayList<DropDownModel>();

			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			String value = "SET @p_division='" + id + "';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
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
			logger.info("Method : getAllSalesCityList ends");
			return response;
		}
	

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> oprationalHeadData(String fromDate, String toDate, String org, String orgDiv, String loc) {
		logger.info("Method : oprationalHeadData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			
			logger.info("values****************************---------------------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
					.setParameter("actionType", "oprationalHeadData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : oprationalHeadData Dao ends" + resp);
		return resp;

	}

	
	

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllInvoice(String id, String fromDate, String toDate, String org, String orgDiv,String loc) {
		logger.info("Method : getAllInvoice Dao startssssssssssssssssssssss");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate +"',@p_id='" + id + "' , @p_loc ='" + loc + "';";
			
			logger.error("getAllInvoice value****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
					.setParameter("actionType", "getAllInvoice").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllInvoice Dao ends" + resp);
		return resp;

	}
	
	
	
	//performanceHeadCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> performanceHeadCount(String fromDate, String toDate, String org, String orgDiv,	String loc, String searchMode) {
		logger.info("Method : performanceHeadCount Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_searchMode ='" + searchMode + "';";
		System.out.println("performanceHeadCount value------"+value);
		String searchModeValue = "ON";		
		try {
			if(searchModeValue.equalsIgnoreCase(searchMode)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
						.setParameter("actionType", "getPerformCount").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
						.setParameter("actionType", "getPerformCount").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
			
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : performanceHeadCount Dao ends" + resp);
		return resp;

	}
	

	
	//performanceWeeklySalesRevenue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> performanceWeeklySalesRevenue(String fromDate, String toDate, String org, String orgDiv,String loc, String searchMode) {
		logger.info("Method : performanceWeeklySalesRevenue Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_searchMode ='" + searchMode + "';";
		System.out.println("performanceWeeklySalesRevenue value------"+value);
		String searchModeValue = "ON";	
		try {
			if(searchModeValue.equalsIgnoreCase(searchMode)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
						.setParameter("actionType", "weeklySaleRevenue").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
						.setParameter("actionType", "weeklySaleRevenue").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : performanceWeeklySalesRevenue Dao ends" + resp);
		return resp;

	}
	
	
	//stateWiseSalesPerformance
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> stateWiseSalesPerformance(String fromDate, String toDate, String org, String orgDiv,String loc, String searchMode) {
		logger.info("Method : stateWiseSalesPerformance Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_searchMode ='" + searchMode + "';";
		System.out.println("stateWiseSalesPerformance value------"+value);
		String searchModeValue = "ON";	
		try {
			if(searchModeValue.equalsIgnoreCase(searchMode)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
						.setParameter("actionType", "stateSalePercent").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
						.setParameter("actionType", "stateSalePercent").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : stateWiseSalesPerformance Dao ends" + resp);
		return resp;

	}
	
	
	//accumulatedRevenuePerformance
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> accumulatedRevenuePerformance(String fromDate, String toDate, String org, String orgDiv,String loc, String searchMode) {
		logger.info("Method : accumulatedRevenuePerformance Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_searchMode ='" + searchMode + "';";
		System.out.println("accumulatedRevenuePerformance value------"+value);
		String searchModeValue = "ON";	
		try {
			if(searchModeValue.equalsIgnoreCase(searchMode)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
						.setParameter("actionType", "accumulateRevenueByS").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
						.setParameter("actionType", "accumulateRevenueByS").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
		
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : accumulatedRevenuePerformance Dao ends" + resp);
		return resp;

	}
	
	
	//avgRevenuePerOrder
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> avgRevenuePerOrder(String fromDate, String toDate, String org, String orgDiv,String loc, String searchMode) {
		logger.info("Method : avgRevenuePerOrder Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_searchMode ='" + searchMode + "';";
		System.out.println("avgRevenuePerOrder value------"+value);
		String searchModeValue = "ON";	
		try {
			if(searchModeValue.equalsIgnoreCase(searchMode)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
						.setParameter("actionType", "avgRevPerOrderByS").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
						.setParameter("actionType", "avgRevPerOrderByS").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : avgRevenuePerOrder Dao ends" + resp);
		return resp;

	}
	
	
	//customerLifeTimeValue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> customerLifeTimeValue(String fromDate, String toDate, String org, String orgDiv,String loc, String searchMode) {
		logger.info("Method : customerLifeTimeValue Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_searchMode ='" + searchMode + "';";
		System.out.println("customerLifeTimeValue value------"+value);
		String searchModeValue = "ON";	
		try {
			if(searchModeValue.equalsIgnoreCase(searchMode)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
						.setParameter("actionType", "custLifeTimeValueByS").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
						.setParameter("actionType", "custLifeTimeValueByS").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : customerLifeTimeValue Dao ends" + resp);
		return resp;

	}
	
	
	//acquisitionCostPerformance
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> acquisitionCostPerformance(String fromDate, String toDate, String org, String orgDiv,String loc, String searchMode) {
		logger.info("Method : acquisitionCostPerformance Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_searchMode ='" + searchMode + "';";
		System.out.println("acquisitionCostPerformance value------"+value);
		String searchModeValue = "ON";	
		try {
			if(searchModeValue.equalsIgnoreCase(searchMode)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
						.setParameter("actionType", "acquistCostByS").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
						.setParameter("actionType", "acquistCostByS").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : acquisitionCostPerformance Dao ends" + resp);
		return resp;

	}
	
	
	//KPIHeadCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> KPIHeadCount(String fromDate, String toDate, String org, String orgDiv,String loc) {
		logger.info("Method : KPIHeadCount Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
					.setParameter("actionType", "KPIHeadCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : KPIHeadCount Dao ends" + resp);
		return resp;

	}
	
	
	//KPISalesRevenueWithCross
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> KPISalesRevenueWithCross(String fromDate, String toDate, String org, String orgDiv,String loc) {
		logger.info("Method : KPISalesRevenueWithCross Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
					.setParameter("actionType", "KPIRevenueCross").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : KPISalesRevenueWithCross Dao ends" + resp);
		return resp;

	}
	
	
	//KPIAccumulatedSalesRevenue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> KPIAccumulatedSalesRevenue(String fromDate, String toDate, String org, String orgDiv,String loc,String previousFromDate,String previousToDate) {
		logger.info("Method : KPIAccumulatedSalesRevenue Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "',@p_previousFromDate='" + previousFromDate + "' , @p_previousToDate ='" + previousToDate + "';";
			System.out.println("KPIAccumulatedSalesRevenue value---"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
					.setParameter("actionType", "KPIAcumulateRvnue").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : KPIAccumulatedSalesRevenue Dao ends" + resp);
		return resp;

	}
	
	
	//KPIIncrementalSourceRevenue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> KPIIncrementalSourceRevenue(String fromDate, String toDate, String org, String orgDiv,String loc) {
		logger.info("Method : KPIIncrementalSourceRevenue Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
					.setParameter("actionType", "KPIIncrmntlSrcRvn").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : KPIIncrementalSourceRevenue Dao ends" + resp);
		return resp;

	}
	
	//conversionHeadCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> conversionSalesHeadCount(String fromDate, String toDate, String org, String orgDiv,String loc) {
		logger.info("Method : conversionSalesHeadCount Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
					.setParameter("actionType", "cnvrHeadCnt").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : conversionSalesHeadCount Dao ends" + resp);
		return resp;

	}

	//conversionLeadLastMonth
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> conversionLeadLastMonth(String fromDate, String toDate, String org, String orgDiv,String loc) {
		logger.info("Method : conversionLeadLastMonth Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
					.setParameter("actionType", "cnvrsnLastMonth").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : conversionLeadLastMonth Dao ends" + resp);
		return resp;

	}
	
	//cycleAvgSalesLengthMonthly
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> cycleAvgSalesLengthMonthly(String fromDate, String toDate, String org, String orgDiv,String loc) {
		logger.info("Method : cycleAvgSalesLengthMonthly Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
					.setParameter("actionType", "cyclAvgSaleLngMnthly").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : cycleAvgSalesLengthMonthly Dao ends" + resp);
		return resp;

	}
	
	
	//cycleFunnelCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> cycleFunnelCount(String fromDate, String toDate, String org, String orgDiv,String loc) {
		logger.info("Method : cycleFunnelCount Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
					.setParameter("actionType", "cyclFunnlCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : cycleFunnelCount Dao ends" + resp);
		return resp;

	}
	
	
	//cycleAvgSalesLength
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> cycleAvgSalesLength(String fromDate, String toDate, String org, String orgDiv,String loc) {
		logger.info("Method : cycleAvgSalesLength Dao starts");

		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("customerDashBoard")
					.setParameter("actionType", "cyclAvgSaleLgnth").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : cycleAvgSalesLength Dao ends" + resp);
		return resp;

	}
	
	
}
