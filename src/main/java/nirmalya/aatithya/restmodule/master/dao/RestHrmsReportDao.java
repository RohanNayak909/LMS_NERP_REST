package nirmalya.aatithya.restmodule.master.dao;

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

	@Repository
	public class RestHrmsReportDao {

		Logger logger = LoggerFactory.getLogger(RestHrmsReportDao.class);

		@Autowired
		EntityManager em;

		@Autowired
		ServerDao serverDao;
		
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getData(String org, String orgDiv) {
		logger.info("Method : getData  starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_report_Routines")
					.setParameter("actionType", "getData").setParameter("actionValue", values).getResultList();

			if (x.size() > 0) {
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getData ends");
		return response;
	}
//
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getAttendanceReport(String org, String orgDiv,String fromDate, String toDate) {
		logger.info("Method : getData  starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
System.out.println("values====================="+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_report_Routines")
					.setParameter("actionType", "getAttendanceReport").setParameter("actionValue", values).getResultList();

			if (x.size() > 0) {
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getAttendanceReport ends");
		return response;
	}
	
	 @SuppressWarnings("unchecked")
		public JsonResponse<Object> attendancePDF(String orgName, String orgDiv,String fromDate,String toDate) {
			logger.info("Method : attendancePDF Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
				System.out.println("attendancePDF========>" + value);
				logger.info("Alert Data Value" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_report_Routines")
						.setParameter("actionType", "attendancePDF").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : attendancePDF Dao ends"+resp);
			return resp;

		}
}
