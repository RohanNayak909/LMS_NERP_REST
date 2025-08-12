package nirmalya.aatithya.restmodule.productionplan.dao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class ProductionDashboardDao {

	Logger logger = LoggerFactory.getLogger(ProductionDashboardDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOrganization(String orgName) {
		logger.info("Method : getOrganization starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			System.out.println("organisation===============?"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
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
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getProductInAnalysis(String orgName) {
		logger.info("Method : getProductInAnalysis starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			System.out.println("getProductInAnalysis===============?"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "productListAnlsys").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getProductInAnalysis ends");
		return getCollectionList;
	}

	//oprationalProdctionHeadCount1   
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> oprationalProdctionHeadCount1(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : oprationalProdctionHeadCount1");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values oprationalAssetCount****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "oprProductionCnt1").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : oprationalProdctionHeadCount1 Dao ends" + resp);
		return resp;

	}

	
	//oprationalProdctionHeadCount2
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> oprationalProdctionHeadCount2(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("==============Method : oprationalProdctionHeadCount2==================");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values oprationalAssetCount****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "oprProductionCnt2").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : oprationalProdctionHeadCount2 Dao ends" + resp);
		return resp;

	}
	
	//getAllDataOprtnls
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllDataOprtnls(String id, String fromDate, String toDate, String location,
			String org, String orgDiv) {
		logger.info("Method : getAllDataOprtnls");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "', @p_id='" + id + "',@p_fromDate='"
					+ fromDate + "',@p_toDate='" + toDate + "';";
			logger.info("values*********************getAllDataOprtnls========*******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines").setParameter("actionType", "getAllRecordById").setParameter("actionValue", value).getResultList();
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
	
	//ooeProdctionHeadCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> ooeProdctionHeadCount(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : ooeProdctionHeadCount");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values ooeProdctionHeadCount****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "ooeProdctionCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : ooeProdctionHeadCount Dao ends" + resp);
		return resp;

	}
	
	//getAllMachineSpecializationDtls
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllMachineSpecializationDtls(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : getAllMachineSpecializationDtls");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String div = orgDiv.trim();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values getAllMachineSpecializationDtls****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines").setParameter("actionType", "getAllMachineDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllMachineSpecializationDtls Dao ends" + resp);
		return resp;

	}
	
	//prodctionHeadCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> prodctionHeadCount(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : prodctionHeadCount");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values prodctionHeadCount****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "prodctionHeadCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : prodctionHeadCount Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardAvgMonthlySalesDetails
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardAvgMonthlySalesDetails(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardAvgMonthlySalesDetails");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardAvgMonthlySalesDetails****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "avgMonthlySales").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardAvgMonthlySalesDetails Dao ends" + resp);
		return resp;

	}
	
	//dashboardTopFiveProductRevenue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTopFiveProductRevenue(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTopFiveProductRevenue");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTopFiveProductRevenue****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "topFivePdctByRevenue").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTopFiveProductRevenue Dao ends" + resp);
		return resp;

	}
	
	//dashboardTopFiveProductByProduction
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTopFiveProductByProduction(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTopFiveProductByProduction");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTopFiveProductByProduction****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "topFivePdctByProduction").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTopFiveProductByProduction Dao ends" + resp);
		return resp;

	}
	
	//dashboardMachineBreakdown

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardMachineBreakdown(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardMachineBreakdown");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardMachineBreakdown****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "machineBreakdown").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardMachineBreakdown Dao ends" + resp);
		return resp;

	}
	
	//dashboardReturnByReason
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardReturnByReason(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardReturnByReason");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardReturnByReason****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "returnByReason").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardReturnByReason Dao ends" + resp);
		return resp;

	}
	
	//dashboardReturnByReasonType
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardReturnByReasonType(String fromDate, String toDate, String location, String org,
			String orgDiv, String type) {
		logger.info("Method : dashboardReturnByReasonType");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String overAll = "0";
		String purchase = "1";
		String sales = "2";
		
		if(type.equals(overAll)) {
			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values returnByReasonPurchase****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
						.setParameter("actionType", "returnByReason").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		
		
		if(type.equals(purchase)) {
			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values returnByReasonPurchase****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
						.setParameter("actionType", "returnByReasonPurchase").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		
		if(type.equals(sales)) {
			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values returnByReasonSales****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
						.setParameter("actionType", "returnByReasonSales").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		

		logger.info("Method : dashboardReturnByReasonType Dao ends" + resp);
		return resp;

	}
	
	//dashboardRightFirstTime
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardRightFirstTime(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardRightFirstTime");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardRightFirstTime****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "rightFirstTime").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardRightFirstTime Dao ends" + resp);
		return resp;

	}
	
	//dashboardAvgRightFirstTime
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardAvgRightFirstTime(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardAvgRightFirstTime");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardAvgRightFirstTime****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "avgRightFirstTime").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardAvgRightFirstTime Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardMostCommonDefect
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardMostCommonDefect(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardMostCommonDefect");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardMostCommonDefect****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "mostCommonDefect").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardMostCommonDefect Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardRateOfReturn
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardRateOfReturn(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardRateOfReturn");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardRateOfReturn****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "rateOfReturnAll").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardRateOfReturn Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardRateOfReturnByType
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardRateOfReturnByType(String fromDate, String toDate, String location, String org,
			String orgDiv, String type) {
		logger.info("Method : dashboardRateOfReturnByType");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		

		String overAll = "0";
		String purchase = "1";
		String sales = "2";
		
		if(type.equals(overAll)) {
			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values rateOfReturnOverAll****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
						.setParameter("actionType", "rateOfReturnAll").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		
		
		if(type.equals(purchase)) {
			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values rateOfReturnPurchase****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
						.setParameter("actionType", "rateOfReturnPurchase").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		
		if(type.equals(sales)) {
			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values rateOfReturnSales****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
						.setParameter("actionType", "rateOfReturnSales").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		
		logger.info("Method : dashboardRateOfReturnByType Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardDefectDensity
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardDefectDensity(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardDefectDensity");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardDefectDensity****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "defectDensityOverAll").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardDefectDensity Dao ends" + resp);
		return resp;

	}
	
	//dashboardCostManagementCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardCostManagementCount(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardCostManagementCount");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardCostManagementCount****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "costManagementCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardCostManagementCount Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardCostManagementReturnOnAssets
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardCostManagementReturnOnAssets(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardCostManagementReturnOnAssets");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardCostManagementReturnOnAssets****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "costMngntReturnOnAssets").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardCostManagementReturnOnAssets Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardCostMangmntMaintenenceWithTarget
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardCostMangmntMaintenenceWithTarget(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardCostMangmntMaintenenceWithTarget");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardCostMangmntMaintenenceWithTarget****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "costMngmntMaintnTarget").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardCostMangmntMaintenenceWithTarget Dao ends" + resp);
		return resp;

	}
	//dashboardCostManagementAssetTurnOver
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardCostManagementAssetTurnOver(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardCostManagementAssetTurnOver");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardCostManagementAssetTurnOver****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "costMangtAssetTurnOver").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardCostManagementAssetTurnOver Dao ends" + resp);
		return resp;

	}
	
	//dashboardCostManagementUnitCostTarget
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardCostManagementUnitCostTarget(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardCostManagementUnitCostTarget");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardCostManagementUnitCostTarget****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "costMngmntUnitCstTrget").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardCostManagementUnitCostTarget Dao ends" + resp);
		return resp;

	}
	
	//dashboardKPIEffectiveness
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardKPIEffectiveness(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardKPIEffectiveness");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardKPIEffectiveness****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "KPIEffectiveness").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardKPIEffectiveness Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardKPIQualityPerformance
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardKPIQualityPerformance(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardKPIQualityPerformance");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardKPIQualityPerformance****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "KPIQualityPerformance").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardKPIQualityPerformance Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardKPIProduction
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardKPIProduction(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardKPIProduction");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardKPIProduction****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "KPIProduction").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardKPIProduction Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardKPICostRevenue
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardKPICostRevenue(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardKPICostRevenue");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardKPICostRevenue****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "KPICostRevenue").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardKPICostRevenue Dao ends" + resp);
		return resp;

	}
	
	//dashboardAnalysisHeadCount  //currentMonth currentYear lastMonth lastYear
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardAnalysisHeadCount(String fromDate, String toDate, String location, String org,
			String orgDiv, String productSkuId , String currentMonth,String currentYear,String lastMonth, String lastYear) {
		logger.info("Method : dashboardAnalysisHeadCount");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location 
					+ "',@p_productSkuId='" + productSkuId 
					+ "',@p_toDate='" + toDate 
					+ "',@p_currentMonth='" + currentMonth 
					+ "',@p_currentYear='" + currentYear 
					+ "',@p_lastMonth='" + lastMonth 
					+ "',@p_lastYear='" + lastYear 
					+ "';";
			
			logger.info("values dashboardAnalysisHeadCount****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "countOnProductSku").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardAnalysisHeadCount Dao ends" + resp);
		return resp;

	}
	
	//dashboardAnalysisCountOnProductSKUId  
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardAnalysisCountOnProductSKUId(String fromDate, String toDate, String location, String org,
			String orgDiv, String productSkuId) {
		logger.info("Method : dashboardAnalysisCountOnProductSKUId");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_productSkuId='" + productSkuId + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardAnalysisCountOnProductSKUId****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "countOnProductSku").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardAnalysisCountOnProductSKUId Dao ends" + resp);
		return resp;

	}
	
	//dashboardAnalysisRuntimeDowntime
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardAnalysisRuntimeDowntime(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardAnalysisRuntimeDowntime");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardAnalysisRuntimeDowntime****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "runTimeDwnTimeYTD").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardAnalysisRuntimeDowntime Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardAnalysisProductionCost
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardAnalysisProductionCost(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardAnalysisProductionCost");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardAnalysisProductionCost****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "productionCostYTD").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardAnalysisProductionCost Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardAnalysisAvailablePerformQualityEffect
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardAnalysisAvailablePerformQualityEffect(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardAnalysisAvailablePerformQualityEffect");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardAnalysisAvailablePerformQualityEffect****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "availPerfmQltyOEEPrcnt").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardAnalysisAvailablePerformQualityEffect Dao ends" + resp);
		return resp;

	}
	
	//===============================Control==============================
	//dashboardControlCount1
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardCycleYieldThroughputWorkForceLeadCount(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardCycleYieldThroughputWorkForceLeadCount");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardCycleYieldThroughputWorkForceLeadCount****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "cycleYieldLeadCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardCycleYieldThroughputWorkForceLeadCount Dao ends" + resp);
		return resp;

	}
	
	//dashboardQtyReworkProductionOrderedQtyCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardQtyReworkProductionOrderedQtyCount(String fromDate, String toDate, String location, String org,
			String orgDiv, String currentMonth, String currentYear, String lastMonth, String lastYear) {
		logger.info("Method : dashboardQtyReworkProductionOrderedQtyCount");

		// currentMonth  currentYear    lastMonth    lastYear
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + 
					"',@p_orgDiv='" + div +
					"',@p_fromDate='" + fromDate + 
					"',@p_location='" + location + 
					"',@p_toDate='" + toDate + 
					"',@p_currentMonth='" + currentMonth + 
					"',@p_currentYear='" + currentYear + 
					"',@p_lastMonth='" + lastMonth + 
					"',@p_lastYear='" + lastYear + 					
					"';";
			logger.info("values dashboardQtyReworkProductionOrderedQtyCount****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "qtyReworkPdctnOdrCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardQtyReworkProductionOrderedQtyCount Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardControlOOECapacityFirstScapeCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardControlOOECapacityFirstScapeCount(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardControlOOECapacityFirstScapeCount");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardControlOOECapacityFirstScapeCount****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "ooeCapcityFirstScrapeCnt").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardControlOOECapacityFirstScapeCount Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardControlAvailabilityPerformanceEffectivenessCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardControlAvailabilityPerformanceEffectivenessCount(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardControlAvailabilityPerformanceEffectivenessCount");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardControlAvailabilityPerformanceEffectivenessCount****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "availPerfmQltyOEEPrcnt").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardControlAvailabilityPerformanceEffectivenessCount Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardControlRightFirstTime
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardControlRightFirstTime(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardControlRightFirstTime");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardControlRightFirstTime****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "controlRightFirstTime").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardControlRightFirstTime Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardControlThroughPut
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardControlThroughPut(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardControlThroughPut");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardControlThroughPut****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "controlThroughPut").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardControlThroughPut Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardControlCostAnalysisOverTime
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardControlCostAnalysisOverTime(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardControlCostAnalysisOverTime");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardControlCostAnalysisOverTime****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "costAnalysisOverTime").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardControlCostAnalysisOverTime Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardControlProductionVariance
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardControlProductionVariance(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardControlProductionVariance");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardControlProductionVariance****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "productionCostYTD").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardControlProductionVariance Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardControlTopFiveMachineProduction
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardControlTopFiveMachineProduction(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardControlTopFiveMachineProduction");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardControlTopFiveMachineProduction****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "topFivePdctByProduction").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardControlTopFiveMachineProduction Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardControlProductionEfficiencyRuntimeDowntime
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardControlProductionEfficiencyRuntimeDowntime(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardControlProductionEfficiencyRuntimeDowntime");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardControlProductionEfficiencyRuntimeDowntime****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "runTimeDwnTimeYTD").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardControlProductionEfficiencyRuntimeDowntime Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardControlHoursToProductCompletionByProduct
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardControlHoursToProductCompletionByProduct(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardControlHoursToProductCompletionByProduct");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardControlHoursToProductCompletionByProduct****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "hoursToProductCompltByPdct").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardControlHoursToProductCompletionByProduct Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardControlDefectAnalysisTypeRate
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardControlDefectAnalysisTypeRate(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardControlDefectAnalysisTypeRate");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardControlDefectAnalysisTypeRate****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines")
					.setParameter("actionType", "defectAnalysisTypeRate").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardControlDefectAnalysisTypeRate Dao ends" + resp);
		return resp;

	}
	
	
	//================================TEAM=========================================
	//dashboardTeamSafetyCalender
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamSafetyCalender(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamSafetyCalender");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamSafetyCalender****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamSafetyCalender").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamSafetyCalender Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardTeamQualityCalender
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamQualityCalender(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamQualityCalender");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamQualityCalender****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamQualityCalender").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamQualityCalender Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardTeamDeliveryCalender
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamDeliveryCalender(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamDeliveryCalender");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamDeliveryCalender****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamDeliveryCalender").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamDeliveryCalender Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardTeamCostCalender
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamCostCalender(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamCostCalender");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamCostCalender****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamCostCalender").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamCostCalender Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardTeamNotes
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamNotes(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamNotes");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamNotes****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamNotes").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamNotes Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardTeamSafetySmryMTDCount
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamSafetySmryMTDCount(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamSafetySmryMTDCount");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamSafetySmryMTDCount****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamSmryMTDCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamSafetySmryMTDCount Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardTeamQualityTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamQualityTrend(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamQualityTrend");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamQualityTrend****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamQualityTrend").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamQualityTrend Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardTeamWeeklyScheduledAttainment
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamWeeklyScheduledAttainment(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamWeeklyScheduledAttainment");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamWeeklyScheduledAttainment****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamWeeklyScheduledAttainment").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamWeeklyScheduledAttainment Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardTeamCostTrend
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamCostTrend(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamCostTrend");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamCostTrend****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamCostTrend").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamCostTrend Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardTeamTopSafetyConcerns
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamTopSafetyConcerns(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamTopSafetyConcerns");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamTopSafetyConcerns****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamTopSafetyConcerns").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamTopSafetyConcerns Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardTeamTopDefectCategories
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamTopDefectCategories(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamTopDefectCategories");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamTopDefectCategories****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamTopDefectCategory").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamTopDefectCategories Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardTeamDailyScheduledAttainment
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamDailyScheduledAttainment(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamDailyScheduledAttainment");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamDailyScheduledAttainment****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamDailyScheduleAttainment").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamDailyScheduledAttainment Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardTeamTopLines
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamTopLines(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamTopLines");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamTopLines****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamTopLines").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamTopLines Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardTeamSafetyCorrectiveAction
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamSafetyCorrectiveAction(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamSafetyCorrectiveAction");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamSafetyCorrectiveAction****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamSafetyCorrectiveAction").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamSafetyCorrectiveAction Dao ends" + resp);
		return resp;

	}
	
	
	//dashboardTeamQualityCorrectiveAction
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> dashboardTeamQualityCorrectiveAction(String fromDate, String toDate, String location, String org,
			String orgDiv) {
		logger.info("Method : dashboardTeamQualityCorrectiveAction");

		
		String div = orgDiv.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			logger.info("values dashboardTeamQualityCorrectiveAction****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
					.setParameter("actionType", "teamQualityCorrectiveAction").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : dashboardTeamQualityCorrectiveAction Dao ends" + resp);
		return resp;

	}
	
	//dashboardTeamDeliveryAction
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashboardTeamDeliveryAction(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashboardTeamDeliveryAction");

			
			String div = orgDiv.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values dashboardTeamDeliveryAction****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
						.setParameter("actionType", "teamDeliveryCorrectiveAction").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashboardTeamDeliveryAction Dao ends" + resp);
			return resp;

		}
	
	
	//dashboardTeamCostCorrectiveAction
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> dashboardTeamCostCorrectiveAction(String fromDate, String toDate, String location, String org,
				String orgDiv) {
			logger.info("Method : dashboardTeamCostCorrectiveAction");

			
			String div = orgDiv.trim();
			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
						+ "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
				logger.info("values dashboardTeamCostCorrectiveAction****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("production_dashboard_routines2")
						.setParameter("actionType", "teamCostCorrectiveAction").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : dashboardTeamCostCorrectiveAction Dao ends" + resp);
			return resp;

		}
	
	
	
	
	
	
	
	
	
}
