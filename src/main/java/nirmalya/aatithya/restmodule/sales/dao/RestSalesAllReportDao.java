package nirmalya.aatithya.restmodule.sales.dao;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;



	@Repository
	public class RestSalesAllReportDao {
		Logger logger = LoggerFactory.getLogger(RestDeliveryChallanDao.class);

		@Autowired
		EntityManager em;

		@Autowired
		ServerDao serverDao;

		@Autowired
		EnvironmentVaribles env;
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewReportList(String orgName, String orgDivision) {
		logger.info("Method : viewReportList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("value view--------->" +value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("sales_AllReport_routines")
					.setParameter("actionType", "viewReportList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewReportList Dao ends");
		return resp;

	}
	
//
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewsalesReport(String orgName, String orgDivision, String fDate, String tDate, String empId) {
		logger.info("Method : viewsalesReport Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fDate='" + fDate 
					+ "',@p_tDate='" + tDate + "',@p_empId='" + empId + "';";
			System.out.println("valueview--------->" +value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("sales_AllReport_routines")
					.setParameter("actionType", "viewsalesReport").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewsalesReport Dao ends");
		return resp;

	}
//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewsalesPOReport(String orgName, String orgDivision, String fDate, String tDate, String empId) {
		logger.info("Method : viewsalesPOReport Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fDate='" + fDate 
					+ "',@p_tDate='" + tDate + "',@p_empId='" + empId + "';";
			System.out.println("valueview--------->" +value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("sales_AllReport_routines")
					.setParameter("actionType", "viewsalesPOReport").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewsalesPOReport Dao ends");
		return resp;

	}
//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewsalesSOReport(String orgName, String orgDivision, String fDate, String tDate, String empId) {
		logger.info("Method : viewsalesSOReport Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fDate='" + fDate + "',"
					+ "@p_tDate='" + tDate + "',@p_empId='" + empId + "';";
			System.out.println("valueview--------->" +value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("sales_AllReport_routines")
					.setParameter("actionType", "viewsalesSOReport").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewsalesSOReport Dao ends");
		return resp;

	}
//
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSaleExecutivesList(String org,String orgDiv) {
		logger.info("Method in Dao: getSaleExecutivesList starts");
		List<DropDownModel> getSaleExecutivesList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("sales_AllReport_routines")
					.setParameter("actionType", "getSaleExecutivesList").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getSaleExecutivesList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method in Dao: getSaleExecutivesList ends");
		return getSaleExecutivesList;
	}
}
