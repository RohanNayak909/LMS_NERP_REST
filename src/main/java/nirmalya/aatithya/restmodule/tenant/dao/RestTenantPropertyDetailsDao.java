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
import nirmalya.aatithya.restmodule.tenant.model.RestTenantPropertyDetailsModel;

@Repository
public class RestTenantPropertyDetailsDao {
	Logger logger = LoggerFactory.getLogger(RestTenantPropertyDetailsDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestTenantPropertyDetailsModel>>> viewpropertydetails(String userId) {
		// TODO Auto-generated method stub
		logger.info("Method : viewEducationDetails Dao starts"+userId);

		List<RestTenantPropertyDetailsModel> workList = new ArrayList<RestTenantPropertyDetailsModel>();

		try {
			String value = "SET @p_userid='" + userId + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("propertydetails")
					.setParameter("actionType", "viewpropertydetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestTenantPropertyDetailsModel dropDownModel = new RestTenantPropertyDetailsModel(m[0], m[1], m[2],
						m[3], m[4]);
				workList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestTenantPropertyDetailsModel>> resp = new JsonResponse<List<RestTenantPropertyDetailsModel>>();
		resp.setBody(workList);
		ResponseEntity<JsonResponse<List<RestTenantPropertyDetailsModel>>> response = new ResponseEntity<JsonResponse<List<RestTenantPropertyDetailsModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("RRRRRRRRRRRR===" + response);

		logger.info("Method : vieweducationDetails Dao ends");

		return response;

	}

	// edit Property Details
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestTenantPropertyDetailsModel>> editpropertyDetails(String propertyno) {
		logger.info("Method : editpropertyDetails starts");

		RestTenantPropertyDetailsModel req = new RestTenantPropertyDetailsModel();
		JsonResponse<RestTenantPropertyDetailsModel> resp = new JsonResponse<RestTenantPropertyDetailsModel>();

		try {

			String value = "SET @p_propertyno='" + propertyno + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("propertydetails")
					.setParameter("actionType", "editpropertyDetails").setParameter("actionValue", value)
					.getResultList();
			logger.info("############FFFFF" + value);
			for (Object[] m : x) {

				RestTenantPropertyDetailsModel reqemp = new RestTenantPropertyDetailsModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13]);

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

		ResponseEntity<JsonResponse<RestTenantPropertyDetailsModel>> response = new ResponseEntity<JsonResponse<RestTenantPropertyDetailsModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editpropertyDetails ends");
		return response;
	}

}
