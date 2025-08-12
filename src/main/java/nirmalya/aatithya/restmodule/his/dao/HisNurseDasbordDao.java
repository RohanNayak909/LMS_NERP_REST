package nirmalya.aatithya.restmodule.his.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateIpdVitalParameter;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

@Repository
public class HisNurseDasbordDao {


	Logger logger = LoggerFactory.getLogger(HisNurseDasbordDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	
	//patient view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewNurseIpd(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewNurseIpd Dao starts" + userId);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";

			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_nurse_routines")
					.setParameter("actionType", "viewIPD").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewNurseIpd Dao ends" + resp);
		return resp;
	}
	
}
