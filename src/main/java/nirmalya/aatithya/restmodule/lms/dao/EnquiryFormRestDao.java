package nirmalya.aatithya.restmodule.lms.dao;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class EnquiryFormRestDao {

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(EnquiryFormRestDao.class);

	@Transactional
	public ResponseEntity<JsonResponse<Object>> saveEnquiryData(String data, String userId, String org, String orgDiv) {
		logger.info("method: saveEnquiryData Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @enquiryData='" + data + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";

			logger.info("value " + value);
			Gson gson = new Gson();
			Type type = new TypeToken<Map<String, Object>>() {
			}.getType();
			Map<String, Object> jsonData = gson.fromJson(data, type);
			String EnquiryId = (String) jsonData.get("id");
			System.out.println("EnquiryId--" + EnquiryId);
			if (EnquiryId == null || EnquiryId.trim().isEmpty()) {
				em.createNamedStoredProcedureQuery("lms_enquiry_form_routine")
						.setParameter("actionType", "saveEnquiryFormData").setParameter("actionValue", value).execute();
				resp.setMessage("Enquiry Data saved successfully!");
				resp.setCode("Success");
			} else {
				em.createNamedStoredProcedureQuery("lms_enquiry_form_routine")
						.setParameter("actionType", "updateEnquiryData").setParameter("actionValue", value).execute();
				resp.setMessage("Enquiry Modified successfully!");
				resp.setCode("Success");
			}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
			} catch (Exception nestedException) {
				logger.error("Error while handling exception: ", nestedException);
				resp.setCode("Failed");
				resp.setMessage("Oops! Something went wrong during error handling");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: saveEnquiryData Ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getEnquiryData(String org, String orgDiv, String userId) {
		logger.info("Method : enquiryFormRestDao Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_orgName='" + org + "', @p_OrgDiv='" + orgDiv + "',@userId='" + userId + "';";

		logger.info("values is --->" + value);
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("lms_enquiry_form_routine")
					.setParameter("actionType", "getEnquiryData").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setMessage("Data Fetch Successfully!");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : enquiryFormRestDao Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getEditEnquiryData(String org, String orgDiv, String userId, String id) {
		logger.info("Method : getEditEnquiryData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_orgName='" + org + "', @p_OrgDiv='" + orgDiv + "',@userId='" + userId + "',@id='" + id
				+ "';";

		logger.info("values is --->" + value);
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("lms_enquiry_form_routine")
					.setParameter("actionType", "getEditEnquiryData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setMessage("Data Fetch Successfully!");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : getEditEnquiryData Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteEnquiryData(String org, String orgDiv, String userId, String id) {
		logger.info("Method : deleteEnquiryData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_orgName='" + org + "', @p_OrgDiv='" + orgDiv + "',@userId='" + userId + "',@id='" + id
				+ "';";

		logger.info("values is --->" + value);
		try {
			 em.createNamedStoredProcedureQuery("lms_enquiry_form_routine")
					.setParameter("actionType", "deleteEnquiryData").setParameter("actionValue", value)
					.execute();
			resp.setMessage("Data Delete Successfully!");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : deleteEnquiryData Dao ends");
		return resp;
	}

}
