package nirmalya.aatithya.restmodule.sales.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestSalesInvoiceReportDao {
	
	Logger logger = LoggerFactory.getLogger(RestSalesInvoiceReportDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	@Autowired
	EnvironmentVaribles env;
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewSalesInvoiceReportData(String orgName, String orgDivision, String sec,
			String fromdate, String todate) {
		logger.info("Method : viewSalesInvoiceReportData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String FormDate = DateFormatter.getStringDate(fromdate);
		String ToDate = DateFormatter.getStringDate(todate);
		//String FormDate = "2023-06-28";
		//String ToDate = "2023-06-28";

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_sec='" + sec + "',@p_fromdate='" + FormDate + "',@p_todate='" + ToDate + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
					.setParameter("actionType", "viewSalesInvoiceReportData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewSalesInvoiceReportData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewSalesReportDtls(String orgName, String orgDivision, String id
			) {
		logger.info("Method : viewSalesReportDtls Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_invId='" + id  + "';";
			System.out.println("values****************************" + value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
					.setParameter("actionType", "viewSalesReportDtls").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewSalesReportDtls Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

}
