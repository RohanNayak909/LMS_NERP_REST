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
import nirmalya.aatithya.restmodule.tenant.model.RestTenantRentLedgerModel;
@Repository
public class RestTenantRentLedgerDao {
	Logger logger = LoggerFactory.getLogger(RestTenantRentLedgerDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	// edit Property Details
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestTenantRentLedgerModel>>> viewrentledgerdetails(String userid, String fromDate, String toDate) {
			logger.info("Method : editpropertyDetails starts"+userid+fromDate+toDate);

			List<RestTenantRentLedgerModel> req = new ArrayList<RestTenantRentLedgerModel>();
			JsonResponse<List<RestTenantRentLedgerModel>> resp = new JsonResponse<List<RestTenantRentLedgerModel>>();

			try {

				//String value = "SET @p_propertyno='" + userid + "';";
				String value=	 "SET @p_userid='" + userid + "',@p_fromDate='" + fromDate +"',@p_toDate='" + toDate + "';";
				logger.info(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("rentledger")
						.setParameter("actionType", "getrentledger").setParameter("actionValue", value)
						.getResultList();
				logger.info("############FFFFF" + value);
				for (Object[] m : x) {

					RestTenantRentLedgerModel reqemp = new RestTenantRentLedgerModel(m[0], m[1], m[2], m[3], m[4], m[5]);

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

			ResponseEntity<JsonResponse<List<RestTenantRentLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestTenantRentLedgerModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);

			logger.info("Method : editpropertyDetails ends");
			return response;
		}

}
