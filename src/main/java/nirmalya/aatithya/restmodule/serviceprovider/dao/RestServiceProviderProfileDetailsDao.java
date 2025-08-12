package nirmalya.aatithya.restmodule.serviceprovider.dao;

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
import nirmalya.aatithya.restmodule.serviceprovider.model.RestServiceProviderProfileDetailsModel;

@Repository
public class RestServiceProviderProfileDetailsDao {
	Logger logger = LoggerFactory.getLogger(RestServiceProviderProfileDetailsDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestServiceProviderProfileDetailsModel>> viewprofiledetails(String userid) {
		logger.info("Method : editprfileDetails starts");

		RestServiceProviderProfileDetailsModel req = new RestServiceProviderProfileDetailsModel();
		JsonResponse<RestServiceProviderProfileDetailsModel> resp = new JsonResponse<RestServiceProviderProfileDetailsModel>();

		try {

			String value = "SET @p_userid='" + userid + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("profileserviceprovider")
					.setParameter("actionType", "getprofiledetails").setParameter("actionValue", value)
					.getResultList();
			logger.info("############FFFFF" + value);
			for (Object[] m : x) {

				RestServiceProviderProfileDetailsModel reqemp = new RestServiceProviderProfileDetailsModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6]);

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

		ResponseEntity<JsonResponse<RestServiceProviderProfileDetailsModel>> response = new ResponseEntity<JsonResponse<RestServiceProviderProfileDetailsModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editprfileDetails ends");
		return response;
	}


}
