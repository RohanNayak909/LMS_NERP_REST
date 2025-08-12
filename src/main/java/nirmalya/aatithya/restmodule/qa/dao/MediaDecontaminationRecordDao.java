package nirmalya.aatithya.restmodule.qa.dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.CommonUsed;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateRmPmReleaseStatusParameter;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.LeaveApplyRestModel;
import nirmalya.aatithya.restmodule.qa.model.MediaDecontaminationRecordModel;
import nirmalya.aatithya.restmodule.qa.model.RestRmPmReleaseStatusModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class MediaDecontaminationRecordDao {
	Logger logger = LoggerFactory.getLogger(MediaDecontaminationRecordDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	@Autowired
	private EnvironmentVaribles env;

		@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
		public ResponseEntity<JsonResponse<List<MediaDecontaminationRecordModel>>> addMedia(List<MediaDecontaminationRecordModel> qc) {
			logger.info("Method : addMedia dao starts");
			JsonResponse<List<MediaDecontaminationRecordModel>> resp = new JsonResponse<List<MediaDecontaminationRecordModel>>();
			
			List<MediaDecontaminationRecordModel> listData = new ArrayList<MediaDecontaminationRecordModel>();
			JSONObject json = new JSONObject();
			
			
			
		for (MediaDecontaminationRecordModel m : qc) {
			logger.info("getDocumentFileBase"+m.getDocumentFileBase());
			if (m.getDocumentFileBase() != null && m.getDocumentFileBase() != "") {
				String[] x = m.getFileName().split("\\.");
				String extension = x[x.length - 1];
				try {
					byte[] bytes = Base64.getDecoder().decode(m.getDocumentFileBase());
					json = saveAllMediaDocuments(bytes, extension, m.getCreatedBy());

				} catch (Exception e) {
					e.printStackTrace();
				}
				m.setDocumentURL(json.getString("fileurl"));
				m.setFileName(json.getString("filename"));
			}
			
		}
		
		String value = GenerateRmPmReleaseStatusParameter.getMedia(qc);
		
		try {

			if (qc.get(0).getMediaId() != null && qc.get(0).getMediaId() != "") {

				System.out.println("modifuuuu===" + qc.get(0).getMediaId());
				em.createNamedStoredProcedureQuery(ProcedureNameConstants.MEDIA_DECONTAMINATION_ROUTINES)
				.setParameter("actionType", "modifyMedia").setParameter("actionValue", value).execute();

				
				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				System.out.println("addd===" + qc.get(0).getMediaId());
				em.createNamedStoredProcedureQuery(ProcedureNameConstants.MEDIA_DECONTAMINATION_ROUTINES)
				.setParameter("actionType", "addMedia").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data saved successfully");

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

		ResponseEntity<JsonResponse<List<MediaDecontaminationRecordModel>>> response = new ResponseEntity<JsonResponse<List<MediaDecontaminationRecordModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addMedia dao ends");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewMediaData(String orgName, String orgDivision) {
		logger.info("Method : viewMediaData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.MEDIA_DECONTAMINATION_ROUTINES)
					.setParameter("actionType", "viewMediaData").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewMediaData Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse <Object> editMedia(String mediaId,String orgName, String orgDiv) {
		logger.info("Method : editMedia Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_mediaId='" + mediaId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("VALUE-------------------"+value);
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.MEDIA_DECONTAMINATION_ROUTINES, "editMedia", value, em);
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				/*
				 * resp.setCode("500"); resp.setMessage(e.getMessage());
				 */
				e.printStackTrace();
				CommonUsed.getErrorDetails(resp, e, serverDao);
			}
		logger.info("Method : editMedia Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveMedia(String mediaId,String orgName,String orgDiv) {
		logger.info("Method : approveMedia Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_mediaId='" + mediaId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.MEDIA_DECONTAMINATION_ROUTINES, "approveMedia", value, em);
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Approved successfully");
			} catch (Exception e) {
				resp.setCode("500");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : approveMedia Dao ends");
		return resp;

	}
	

	@SuppressWarnings("unchecked")
	public JsonResponse <Object> deleteMedia(String mediaId,String orgName, String orgDiv) {
		logger.info("Method : deleteMedia Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_mediaId='" + mediaId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value"+value);
			
		 em.createNamedStoredProcedureQuery(ProcedureNameConstants.MEDIA_DECONTAMINATION_ROUTINES).setParameter("actionType", "deleteMedia")
			.setParameter("actionValue", value).execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonUsed.getErrorDetails(resp, e, serverDao);
		}

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("200");
		}
		logger.info("Method : deleteMedia Dao ends");
		return resp;

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

			Path path = Paths.get(env.getFileUploadDocumenttUrl() + imageName);
			if (imageBytes != null) {
				Files.write(path, imageBytes);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = env.getMobileView() + "document/document/" + imageName;

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
	//pdf
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> mediaPdf(String id,String orgName, String orgDivision) {
				logger.info("Method : mediaPdf Dao startsssss" + id );

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_mediaId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					logger.info("values******" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.MEDIA_DECONTAMINATION_ROUTINES)
							.setParameter("actionType", "mediaDocPdf").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
					e.printStackTrace();
				}
				logger.info("resp******" + resp);
				logger.info("Method : mediaPdf Dao ends");
				return resp;

			}
}
