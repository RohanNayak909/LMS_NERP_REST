package nirmalya.aatithya.restmodule.warehouse.dao;

import javax.persistence.EntityManager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestWarehouseReportDao {

	Logger logger = LoggerFactory.getLogger(RestWarehouseReportDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewWarehouseReportData(String orgName, String orgDivision, String state) {
		logger.info("Method : viewWarehouseReportData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_state='" + state + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouse_report_routines")
					.setParameter("actionType", "viewReportData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewWarehouseReportData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewWarehouseReportFilterData(String orgName, String orgDivision, String slno) {
		logger.info("Method : viewWarehouseReportFilterData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_slno='" + slno + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouse_report_routines")
					.setParameter("actionType", "viewReportFilterData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewWarehouseReportFilterData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewWarehouseReportForItemWiseStock(String orgName, String orgDivision) {
		logger.info("Method : viewWarehouseReportData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouse_report_routines")
					.setParameter("actionType", "viewReportDataItemWise").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewWarehouseReportData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewWarehouseReportForStockRegister(String orgName, String orgDivision) {
		logger.info("Method : viewWarehouseReportForStockRegister Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouse_report_routines")
					.setParameter("actionType", "viewStockRegisterData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewWarehouseReportForStockRegister Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
}
