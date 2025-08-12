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
import nirmalya.aatithya.restmodule.serviceprovider.model.RestServiceProviderBillModel;

@Repository
public class RestServiceProviderBillDao {
	Logger logger = LoggerFactory.getLogger(RestServiceProviderBillDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	// edit Property Details
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestServiceProviderBillModel>>> viewbilldues(String userid, String fromDate, String toDate) {
			logger.info("Method : editpropertyDetails starts"+userid+fromDate+toDate);

			List<RestServiceProviderBillModel> req = new ArrayList<RestServiceProviderBillModel>();
			JsonResponse<List<RestServiceProviderBillModel>> resp = new JsonResponse<List<RestServiceProviderBillModel>>();

			try {

				//String value = "SET @p_propertyno='" + userid + "';";
				String value=	 "SET @p_userid='" + userid + "',@p_fromDate='" + fromDate +"',@p_toDate='" + toDate + "';";
				logger.info(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("serviceBillDues")
						.setParameter("actionType", "billreview").setParameter("actionValue", value)
						.getResultList();
				logger.info("############FFFFF" + value);
				for (Object[] m : x) {

					RestServiceProviderBillModel reqemp = new RestServiceProviderBillModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6].toString());

					/*
					 * Object insuranceid, Object companyName, Object vehicleNo, Object policyNo,
					 * Object stDate, Object endDate, Object recurringPeriod, Object checkbox2,
					 * Object checkbox1, Object recurringDate, Object remarks, Object charge
					 */
					req.add(reqemp);

				}

				resp.setBody(req);
			} catch (Exception e) {
				e.printStackTrace();
			}

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<List<RestServiceProviderBillModel>>> response = new ResponseEntity<JsonResponse<List<RestServiceProviderBillModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);

			logger.info("Method : editpropertyDetails ends");
			return response;
		}

}
