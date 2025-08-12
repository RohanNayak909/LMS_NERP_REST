package nirmalya.aatithya.restmodule.grc.dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateAuditMasterParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.grc.model.ScheduledAuditPlanRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AuditRecordRestDao {

	Logger logger = LoggerFactory.getLogger(AuditRecordRestDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EnvironmentVaribles env;

	  
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewScheduledAudit(@RequestParam String orgName, String orgDivision,String userId,String type,String date) {
		logger.info("Method : viewScheduledAudit Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "', @p_orgDiv='" + orgDivision +"', @p_userId='" + userId +"', @p_date='" + date +"', @p_type='" + type +"';";
			
			logger.info("values-->" + value);           
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "viewScheduledAudit").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewScheduledAudit Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getScheduledAuditDetails(@RequestParam String scheduledId,String auditInstId, String orgName, String orgDivision) {
		logger.info("Method : getScheduledAuditDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_auditInstId='" + auditInstId + "', @p_scheduledId='" + scheduledId + "', @p_org='" + orgName + "', @p_orgDiv='" + orgDivision + "';";
            
			logger.info("value-->"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getScheduleDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getScheduledAuditDetails Dao ends");
		return resp;

	}
	
	public ResponseEntity<JsonResponse<List<ScheduledAuditPlanRestModel>>> addScheduledAuditProgress( List<ScheduledAuditPlanRestModel> sap) {
		logger.info("Method : addScheduledAuditProgress dao starts");
		JsonResponse<List<ScheduledAuditPlanRestModel>> resp = new JsonResponse<List<ScheduledAuditPlanRestModel>>();
		JSONObject json = new JSONObject();
		
 
		for (ScheduledAuditPlanRestModel model : sap) {
		    String fileName = model.getFileName();
		    String base64Image = model.getBase64Image();

		    if (fileName != null && base64Image != null) {
		        String[] parts = base64Image.split(",");
		        if (parts.length == 2) {
		            base64Image = parts[1];  
		        }
		        base64Image = base64Image.replaceAll("\\s", "");
		        try {
		            byte[] bytes = Base64.getDecoder().decode(base64Image);

		             json = saveAllMediaDocuments(bytes, "jpeg", model.getCreatedBy());

		            if (json.has("fileurl")) {
		                model.setDocumentUrl(json.getString("fileurl"));
		            }
		            
		        } catch (IllegalArgumentException e) {
		            System.err.println("Invalid Base64 input: " + base64Image);
		            e.printStackTrace();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}


		String value = GenerateAuditMasterParam.getScheduleAuditProgressList(sap);
		System.out.println("VALUE :::: "+value);
		try {

			if (sap.get(0).getScheduledId() != null && sap.get(0).getScheduledId() != "") {

				em.createNamedStoredProcedureQuery("auditmaster_routines")
						.setParameter("actionType", "modifyAuditPro").setParameter("actionValue", value)
						.execute();

				resp.setCode("success");
				resp.setMessage("Details Recorded Successfully");

			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ScheduledAuditPlanRestModel>>> response = new ResponseEntity<JsonResponse<List<ScheduledAuditPlanRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addScheduledAuditProgress dao ends");
		return response;

	}
	public JSONObject saveAllMediaDocuments(byte[] imageBytes, String ext, String user_id) {
		logger.info("Method : saveAllMedicalDocuments starts");

		String imageName = null;
		try {

			if (imageBytes != null) {
				long nowTime = new Date().getTime();

				if (ext.contentEquals("jpeg")) {
					imageName = user_id + "_" + nowTime + ".jpg";
				} else {
					imageName = user_id + "_" + nowTime + "." + ext;
				}
			}

			Path path = Paths.get(env.getGrcDocUrl() + imageName);
			if (imageBytes != null) {
				Files.write(path, imageBytes);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = env.getMobileView() + "document/grcDocUrl/" + imageName;

		JSONObject json = new JSONObject();

		try {
			json.put("filename", imageName);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			json.put("fileurl", url);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("Method : saveAllMediaDocuments ends");
		return json;
	}
	
}
