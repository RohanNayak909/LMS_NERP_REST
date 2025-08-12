package nirmalya.aatithya.restmodule.asset.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class MaintenanceReportDao {
	
	Logger logger = LoggerFactory.getLogger(MaintenanceReportDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	
	// getSanitaryCleanData
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getSanitaryCleanData(String fromDate,String toDate, String orgName, String orgDiv) {
		logger.info("Method : getSanitaryCleanData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
			System.out.println("getSanitaryCleanData=====>"+value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("maintenance_report_routines")
					.setParameter("actionType", "getSanitaryData").setParameter("actionValue", value)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getSanitaryCleanData Dao ends" + resp);
		return resp;
	}
	
	// getChangeRoomData
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getChangeRoomData(String fromDate,String toDate, String orgName, String orgDiv) {
			logger.info("Method : getChangeRoomData Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
				System.out.println("getChangeRoomData=====>"+value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("maintenance_report_routines")
						.setParameter("actionType", "getChangeRoomData").setParameter("actionValue", value)
						.getResultList();

				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getChangeRoomData Dao ends" + resp);
			return resp;
		}

}
