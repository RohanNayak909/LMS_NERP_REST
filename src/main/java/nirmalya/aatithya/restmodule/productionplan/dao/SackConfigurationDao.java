package nirmalya.aatithya.restmodule.productionplan.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.productionplan.GenerateLmrLogParams;
import nirmalya.aatithya.restmodule.common.utils.productionplan.GenerateSackConfigurationParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.productionplan.model.LmrLogRestModel;
import nirmalya.aatithya.restmodule.productionplan.model.SackConfigurationRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class SackConfigurationDao {
	
	Logger logger = LoggerFactory.getLogger(SackConfigurationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	

	// view

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewSackConfiguration(String org, String orgDiv) {
		logger.info("Method : viewSackConfiguration Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_sackConfiguration_routines")
					.setParameter("actionType", "viewSackConfiguration").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewSackConfiguration Dao ends" + resp);
		return resp;
	}
	

	// Add

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addSackConfiguration(SackConfigurationRestModel offDay) {

		logger.info("Method : addSackConfiguration starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String values = GenerateSackConfigurationParam.getSackConfigurationParam(offDay);

		logger.info("valuess to add ----" + values);
		try {

			System.out.println("values add >>>>>>>" + values);
			if (offDay.getSackId() == "" || offDay.getSackId() == null) {
				 em.createNamedStoredProcedureQuery("production_plan_sackConfiguration_routines")
						.setParameter("actionType", "addSackConfiguration").setParameter("actionValue", values).execute();

				Util.setJsonResponse(resp, "", ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			}else {
				 em.createNamedStoredProcedureQuery("production_plan_sackConfiguration_routines")
						.setParameter("actionType", "modifySackConfiguration").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, "", ResponseStatus.success, ApiResponseMessage.MODIFIED_SUCCESSFULLY);
			}

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}
		/*
		 * ResponseEntity<JsonResponse<LmrLogRestModel>> response = new
		 * ResponseEntity<JsonResponse<LmrLogRestModel>>(resp, HttpStatus.CREATED);
		 */

		logger.info("Method : addSackConfiguration ends" + resp);
		return resp;
	}
	

	// delete

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteSackConfig(String id, String org, String orgDiv) {
		logger.info("Method : deleteSackConfig Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_sackId='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------" + value);
			em.createNamedStoredProcedureQuery("production_plan_sackConfiguration_routines")
					.setParameter("actionType", "deleteSackConfig").setParameter("actionValue", value).execute();

			resp.setCode("success");
			resp.setMessage("Data Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UNsuccess");
			resp.setMessage("Data Deleted failed");
		}
		logger.info("Method : deleteSackConfig Dao ends" + resp);
		return resp;
	}

}
