package nirmalya.aatithya.restmodule.serviceprovider.dao;

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
import nirmalya.aatithya.restmodule.serviceprovider.model.RestServiceProviderWorkDetailsModel;
import nirmalya.aatithya.restmodule.tenant.dao.RestTenantPropertyDetailsDao;

@Repository
public class RestServiceProviderWorkDetailsDao {
	Logger logger = LoggerFactory.getLogger(RestTenantPropertyDetailsDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestServiceProviderWorkDetailsModel>>> viewWorkDetails(String userId) {
		// TODO Auto-generated method stub
		logger.info("Method : viewWorkDetails Dao starts");

		List<RestServiceProviderWorkDetailsModel> workList = new ArrayList<RestServiceProviderWorkDetailsModel>();

		try {
			String value = "SET @p_userid='" + userId + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("workdetails")
					.setParameter("actionType", "getworkdetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestServiceProviderWorkDetailsModel dropDownModel = new RestServiceProviderWorkDetailsModel(m[0], m[1], m[2],
						m[3], m[4], m[5]);
				workList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestServiceProviderWorkDetailsModel>> resp = new JsonResponse<List<RestServiceProviderWorkDetailsModel>>();
		resp.setBody(workList);
		ResponseEntity<JsonResponse<List<RestServiceProviderWorkDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestServiceProviderWorkDetailsModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("RRRRRRRRRRRR===" + response);

		logger.info("Method : viewWorkDetails Dao ends");

		return response;

	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestServiceProviderWorkDetailsModel>> editworkDetails(String workid) {
		logger.info("Method : editpropertyDetails starts");

		RestServiceProviderWorkDetailsModel req = new RestServiceProviderWorkDetailsModel();
		JsonResponse<RestServiceProviderWorkDetailsModel> resp = new JsonResponse<RestServiceProviderWorkDetailsModel>();

		try {

			String value = "SET @p_workid='" + workid + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("workdetails")
					.setParameter("actionType", "editworkDetails").setParameter("actionValue", value)
					.getResultList();
			logger.info("############FFFFF" + value);
			for (Object[] m : x) {

				RestServiceProviderWorkDetailsModel reqemp = new RestServiceProviderWorkDetailsModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);

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

		ResponseEntity<JsonResponse<RestServiceProviderWorkDetailsModel>> response = new ResponseEntity<JsonResponse<RestServiceProviderWorkDetailsModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editpropertyDetails ends");
		return response;
	}


}
