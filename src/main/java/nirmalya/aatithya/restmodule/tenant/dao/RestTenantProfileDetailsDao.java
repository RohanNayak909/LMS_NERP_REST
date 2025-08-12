package nirmalya.aatithya.restmodule.tenant.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.tenant.model.RestTenantProfileDetailsModel;

@Repository
public class RestTenantProfileDetailsDao {
	
	Logger logger = LoggerFactory.getLogger(RestTenantProfileDetailsDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestTenantProfileDetailsModel>> viewprofiledetails(String userid) {
		logger.info("Method : viewprofiledetails starts");

		RestTenantProfileDetailsModel req = new RestTenantProfileDetailsModel();
		JsonResponse<RestTenantProfileDetailsModel> resp = new JsonResponse<RestTenantProfileDetailsModel>();

		try {

			String value = "SET @p_userid='" + userid + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("profiledetails")
					.setParameter("actionType", "getprofiledetails").setParameter("actionValue", value)
					.getResultList();
			logger.info("############FFFFF" + value);
			for (Object[] m : x) {

				RestTenantProfileDetailsModel reqemp = new RestTenantProfileDetailsModel(m[0], m[1], m[2], m[3], m[4],
						m[5]);

				/*
				 * Object insuranceid, Object companyName, Object vehicleNo, Object policyNo,
				 * Object stDate, Object endDate, Object recurringPeriod, Object checkbox2,
				 * Object checkbox1, Object recurringDate, Object remarks, Object charge
				 */
				req = reqemp;

			}

			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<RestTenantProfileDetailsModel>> response = new ResponseEntity<JsonResponse<RestTenantProfileDetailsModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewprofiledetails ends");
		return response;
	}

	

}
