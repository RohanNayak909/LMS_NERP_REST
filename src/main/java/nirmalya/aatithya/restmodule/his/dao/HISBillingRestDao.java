package nirmalya.aatithya.restmodule.his.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import nirmalya.aatithya.restmodule.enums.ResponseStatus;

import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class HISBillingRestDao {
	Logger logger = LoggerFactory.getLogger(HISBillingRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> billingView(String orgName, String orgDivision) {
		logger.info("Method : billingView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "billingView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : billingView Dao ends");
		return resp;

	}
//
	//pdf
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> billingPdf(String id,String orgName, String orgDivision) {
		logger.info("Method : billingPdf Dao startsssss" + id );

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_pId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "billingPdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("resp******" + resp);
		logger.info("Method : billingPdf Dao ends");
		return resp;

	}
}