package nirmalya.aatithya.restmodule.grc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class MonitoringDao {
	Logger logger = LoggerFactory.getLogger(MonitoringDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * view risk details
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRiskdetailsForMonitoring(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewRiskdetailsForMonitoring Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_monitoring_Routines")
					.setParameter("actionType", "viewRiskdetailsForMonitoring").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewRiskdetailsForMonitoring Dao ends");
		return resp;

	}
}
