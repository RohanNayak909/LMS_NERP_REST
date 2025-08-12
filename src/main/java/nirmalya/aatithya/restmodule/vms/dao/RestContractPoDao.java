package nirmalya.aatithya.restmodule.vms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestContractPoDao {

	Logger logger = LoggerFactory.getLogger(RestContractPoDao.class);
	@Autowired
	ServerDao serverDao;
	@PersistenceContext
	private EntityManager em;

	// getContractDetails
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getContractDetails(String org, String orgDiv, String userId) {
		logger.info("Method : getContractDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @org='" + org + "', @org_div='" + orgDiv + "',@userId='" + userId + "';";
		System.out.println("value is coming=============> " + value);
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("vms_contract_routines")
					.setParameter("actionType", "getVendorContract").setParameter("actionValue", value).getResultList();

			if (x.size() > 0 && x.get(0) != null) {
				resp.setBody(x.get(0));
				resp.setMessage("Tenders fetched successfully.");
				resp.setCode("Success");
			} else {
				resp.setMessage("No data found.");
				resp.setCode("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : getContractDetails Dao ends");
		return resp;
	}

	// saveResponseData
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveResponseData(String userId, String org, String orgDiv,
			String parsedData) {
		logger.info("Method : saveResponseData Dao starts, Parsed Data: {}", parsedData);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			Gson gson = new Gson();

			JsonArray jsonArray = JsonParser.parseString(parsedData).getAsJsonArray();
			JsonObject firstObject = jsonArray.get(0).getAsJsonObject();

			String remark = firstObject.has("remark") ? firstObject.get("remark").getAsString() : "";

			String encodedRemark = remark.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'")
					.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t").replace("\b", "\\b")
					.replace("\f", "\\f");
			firstObject.addProperty("remark", encodedRemark);

			String updatedParsedData = gson.toJson(jsonArray);

			String value = "SET @userId='" + userId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "', @parsedData='"
					+ updatedParsedData + "';";
			logger.info("Generated value: {}", value);

			em.createNamedStoredProcedureQuery("vms_contract_routines").setParameter("actionType", "saveResponseData")
					.setParameter("actionValue", value).execute();

			resp.setBody(value);
			resp.setMessage("Response Saved successfully.");
			resp.setCode("Success");

		} catch (Exception e) {
			logger.error("Exception in saveResponseData Dao: {}", e.getMessage());
			resp.setMessage("An error occurred while saving the workflow order.");
			resp.setCode("Failed");
			e.printStackTrace();
		}

		logger.info("Method : saveResponseData Dao ends");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewResponseData(String contractId, String tenderId, String userId) {
		logger.info("Method : viewResponseData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @contractId='" + contractId + "',@tenderId='" + tenderId + "',@userId='" + userId + "';";
		logger.info("Value is coming For viewResponseData============> " + value);
		try {
			List<Object> x = em.createNamedStoredProcedureQuery("vms_contract_routines")
					.setParameter("actionType", "viewResponseData").setParameter("actionValue", value).getResultList();

			if (x.size() > 0 && x.get(0) != null) {
				resp.setBody(x.get(0));
				resp.setMessage("Data Fetched Successfully.");
				resp.setCode("Success");
			} else {
				resp.setMessage("No data found.");
				resp.setCode("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage(e.getMessage());
			resp.setCode("Failed");
		}

		logger.info("Method : viewResponseData Dao ends");
		return resp;
	}

	// saveAdminComment
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveAdminComment(String userId, String org, String orgDiv,
			String parsedData) {
		logger.info("Method : saveAdminComment Dao starts, Parsed Data: {}", parsedData);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			Gson gson = new Gson();

			JsonArray jsonArray = JsonParser.parseString(parsedData).getAsJsonArray();
			JsonObject firstObject = jsonArray.get(0).getAsJsonObject();

			String remark = firstObject.has("adminRemark") ? firstObject.get("adminRemark").getAsString() : "";

			String encodedRemark = remark.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'")
					.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t").replace("\b", "\\b")
					.replace("\f", "\\f");
			firstObject.addProperty("adminRemark", encodedRemark);
			String updatedParsedData = gson.toJson(jsonArray);

			String value = "SET @userId='" + userId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "', @parsedData='"
					+ updatedParsedData + "';";
			logger.info("Generated value: {}", value);

			em.createNamedStoredProcedureQuery("vms_contract_routines").setParameter("actionType", "saveAdminComment")
					.setParameter("actionValue", value).execute();
			resp.setBody(value);
			resp.setMessage("Comment Saved successfully.");
			resp.setCode("Success");

		} catch (Exception e) {
			logger.error("Exception in saveAdminComment Dao: {}", e.getMessage());
			resp.setMessage("An error occurred while saving the Admin Comment.");
			resp.setCode("Failed");
			e.printStackTrace();
		}

		logger.info("Method : saveAdminComment Dao ends");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

}
