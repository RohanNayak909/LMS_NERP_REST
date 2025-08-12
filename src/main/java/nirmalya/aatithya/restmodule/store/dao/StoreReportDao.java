package nirmalya.aatithya.restmodule.store.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class StoreReportDao {
	Logger logger = LoggerFactory.getLogger(StoreReportDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewStoreReportData(String orgName, String orgDivision, String state) {
		logger.info("Method : viewStoreReportData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_state='" + state + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("store_report_routines")
					.setParameter("actionType", "viewStoreReportData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewStoreReportData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewStoreReportFilterData(String orgName, String orgDivision, String slno) {
		logger.info("Method : viewStoreReportFilterData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_slno='" + slno + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("store_report_routines")
					.setParameter("actionType", "viewStoreReportFilterData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewStoreReportFilterData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
}
