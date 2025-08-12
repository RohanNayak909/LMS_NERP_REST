package nirmalya.aatithya.restmodule.his.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

@Repository
public class HISEmergencyDao {
	Logger logger = LoggerFactory.getLogger(HISEmergencyDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getemErgencyDetails(String orgName, String orgDivision, String fromdate,
			String todate) {
		logger.info("Method : getemErgencyDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromdate='" + fromdate
					+ "',@p_todate='" + todate + "' ;";

			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "getEmergency").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("hhhhhhhhhhhhhhhhh" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getemErgencyDetails Dao ends");
		return resp;

	}

	public JsonResponse<HISPatientRestModel> emergencyStatus(String approval, String emerId, String approvedBy) {
		logger.info("Method : emergencyStatus starts");

		HISPatientRestModel req = new HISPatientRestModel();
		JsonResponse<HISPatientRestModel> resp = new JsonResponse<HISPatientRestModel>();
		try {

			String value = "SET @p_approval='" + approval + "',@p_emerId='" + emerId + "',@p_approvedBy='" + approvedBy
					+ "';";
			System.out.println("value===" + value);
			em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "emergencyStatus")
					.setParameter("actionValue", value).execute();
			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Status changed successfully");

		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("resp===" + resp);
		logger.info("Method : emergencyStatus ends");
		return resp;
	}

}
