package nirmalya.aatithya.restmodule.his.dao;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class HisIpdBillingDao {
	Logger logger = LoggerFactory.getLogger(HisIpdBillingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewIpdDetails(String orgName, String orgDivision, String fromdate, String todate) {
		logger.info("Method : viewIpdDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromdate='" + fromdate
					+ "',@p_todate='" + todate + "' ;";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("his_billing_routines")
					.setParameter("actionType", "viewipdData").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("hhhhhhhhhhhhhhhhh" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewIpdDetails Dao ends");
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editIpd(String Id, String organization, String orgDivision) {
		logger.info("Method : editIpd Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_patientId='" + Id + "';";
			
			logger.info("vvvv"+value);	
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_billing_routines")
					.setParameter("actionType", "editipdDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : editIpd Dao ends" + resp);
		return resp;

	}
}
