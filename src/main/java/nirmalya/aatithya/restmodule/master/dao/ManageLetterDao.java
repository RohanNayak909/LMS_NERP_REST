package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateNoticePolicyParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.ManageNoticeRestModel;
import nirmalya.aatithya.restmodule.master.model.NoticeDocumentUploadRestController;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ManageLetterDao {

	Logger logger = LoggerFactory.getLogger(ManageLetterDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;

	@Autowired
	private EnvironmentVaribles env;

	// All Employee List

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getEmployeeList(String orgName, String orgDivision, String userId, String type) {
		logger.info("Method : getEmployeeList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "', @p_type='" + type + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
					.setParameter("actionType", "getEligbleEmp").setParameter("actionValue", value).getResultList();
			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeList Dao ends");

		return resp;

	}

	// get all notice type
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getNoticeType(String organization, String orgDivision) {
		logger.info("Method : getNoticeType Dao starts");

		List<DropDownModel> noticeType = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "';";

			System.out.println("value getNoticeType::" +value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
					.setParameter("actionType", "getNoticeType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				noticeType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getNoticeType Dao ends");

		return noticeType;
	}
	// Auto Search Employee

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> employeeAutoSearch(String id, String org, String orgDiv) {
		logger.info("Method : employeeAutoSearch Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_searchValue='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
					.setParameter("actionType", "employeeAutoSearch").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetched Failed");
		}
		logger.info("Method : employeeAutoSearch Dao ends");
		return resp;

	}

	// get all notice content
	public JsonResponse<Object> getNoticeContent(String organization, String orgDivision, String id) {
		logger.info("Method : getNoticeContent Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_organization='" + organization + "',@p_orgDivision='" + orgDivision + "',@p_type='"
					+ id + "';";

			Object x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
					.setParameter("actionType", "getNoticeTypeContent").setParameter("actionValue", value)
					.getResultList();
			// resp.setBody(x);

			if (x != null) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, "success");
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getNoticeContent Dao ends");

		return resp;
	}

	// Add Notice
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ManageNoticeRestModel>> saveNoticeDetails(ManageNoticeRestModel data) {
		logger.info("Method : saveNoticeDetails starts");

		Boolean validity = true;
		JsonResponse<ManageNoticeRestModel> resp = new JsonResponse<ManageNoticeRestModel>();

		List<ManageNoticeRestModel> description = new ArrayList<ManageNoticeRestModel>();

		resp.setMessage("");
		resp.setCode("");

		String values = GenerateNoticePolicyParameter.saveNoticeDetails(data);

		System.out.println("values***" + values);
		if (validity)
			try {
				if (data.getNoticeId() != null && data.getNoticeId() != "") {
					List<Object[]> x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
							.setParameter("actionType", "modifyNoticeDtls").setParameter("actionValue", values)
							.getResultList();

					Util.setJsonResponse(resp, null, ResponseStatus.success, "Letter Modified Successfully");

					for (Object[] m : x) {
						ManageNoticeRestModel manageNoticeRestModel = new ManageNoticeRestModel(m[0], m[1]);
						description.add(manageNoticeRestModel);
					}
				} else {
					System.out.println("addNoticeDetails::"+values);
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("hrmManagePolicy")
							.setParameter("actionType", "addNoticeDetails").setParameter("actionValue", values)
							.getResultList();

					Util.setJsonResponse(resp, null, ResponseStatus.success, "Letter Saved Successfully");

					for (Object[] m : x1) {
						ManageNoticeRestModel manageNoticeRestModel = new ManageNoticeRestModel(m[0], m[1]);
						description.add(manageNoticeRestModel);
					}

				}

			} catch (Exception e) {

				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
					Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();

			}
		ResponseEntity<JsonResponse<ManageNoticeRestModel>> response = new ResponseEntity<JsonResponse<ManageNoticeRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveNoticeDetails ends"+response);
		return response;
	}

	// get all notice content
	public JsonResponse<Object> getNoticeEdit(String organization, String orgDivision, String id) {
		logger.info("Method : getNoticeEdit Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_organization='" + organization + "',@p_orgDivision='" + orgDivision
					+ "',@p_noticeId='" + id + "';";
			
			System.out.println("Edit Notice>>"+value);

			Object x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
					.setParameter("actionType", "getNoticeEditData").setParameter("actionValue", value).getResultList();
			// resp.setBody(x);

			if (x != null) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, "success");
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getNoticeEdit Dao ends");

		return resp;
	}

	// Fetch pdf Details

	@SuppressWarnings("unused")
	public JsonResponse<Object> getNoticePdfDetails(String id, String organization, String orgDivision, String userId) {
		logger.info("Method : getNoticePdfDetails starts");
		ManageNoticeRestModel noticeDetails = new ManageNoticeRestModel();

		JsonResponse<Object> resp = new JsonResponse<>();
		try {

			String value = "SET @p_noticeId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "',@p_userId='" + userId + "';";

			System.out.println("value pdf>>>"+value);
			Object x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
					.setParameter("actionType", "getNoticePDFDetails").setParameter("actionValue", value)
					.getResultList();

			Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		logger.info("Method : getNoticePdfDetails ends");

		return resp;
	}

	// Send Mail and Save Details
	public JsonResponse<Object> sendEmailNotice(String noticeId, String emailTo, String emailCc, String emailBody,
			String organization, String orgDivision, String userId) {
		logger.info("Method : sendEmailNotice starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		emailBody = emailBody
				.replace("'", "''")     
				.replace("\"", "\\\""); 
		
		try {

			String value = "SET @p_noticeId='" + noticeId + "',@p_emailTo='" + emailTo + "'," + "@p_emailCC='" + emailCc
					+ "',@p_emailBody='" + emailBody + "',@p_organization='" + organization + "',@p_orgDivision='"
					+ orgDivision + "',@p_userId='" + userId + "';";

			Object x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
					.setParameter("actionType", "sendEmailNotice").setParameter("actionValue", value).getResultList();

			Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);

		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			e.printStackTrace();
		}

		logger.info("Method : sendEmailNotice ends");
		return resp;
	}

	//update offline status
	public JsonResponse<Object> sendOfflineNotice(String org, String orgDiv, String userId, String id) {
		logger.info("Method : sendOfflineNotice starts");

		JsonResponse<Object> resp = new JsonResponse<>();

		try {

			String value = "SET @p_noticeId='" + id + "',@p_organization='" + org + "',@p_orgDivision='" + orgDiv
					+ "',@p_userId='" + userId + "';";

			em.createNamedStoredProcedureQuery("hrmManagePolicy").setParameter("actionType", "updateOfflineNotice")
					.setParameter("actionValue", value).execute();

			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);

		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			e.printStackTrace();
		}

		logger.info("Method : sendOfflineNotice ends");
		return resp;
	}
	
	//Delete Letter 
	public JsonResponse<Object> deleteLetter(String org, String orgDiv, String userId, String id) {
		logger.info("Method : deleteLetter starts");
		
		JsonResponse<Object> resp = new JsonResponse<>();
		
		try {
			
			String value = "SET @p_noticeId='" + id + "',@p_organization='" + org + "',@p_orgDivision='" + orgDiv
					+ "',@p_userId='" + userId + "';";
			
			System.out.println("value" + value);
			
			em.createNamedStoredProcedureQuery("hrmManagePolicy").setParameter("actionType", "deleteLetter")
			.setParameter("actionValue", value).execute();
			
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
			
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			e.printStackTrace();
		}
		
		logger.info("Method : deleteLetter ends");
		return resp;
	}

	// add employee response HR
	public ResponseEntity<JsonResponse<ManageNoticeRestModel>> uploadEmployeeResponse(ManageNoticeRestModel data) {
		logger.info("Method : uploadEmployeeResponse dao starts");
		JsonResponse<ManageNoticeRestModel> resp = new JsonResponse<ManageNoticeRestModel>();
		JSONObject json = new JSONObject();

		if (data.getDocumentList().size() > 0) {
			for (NoticeDocumentUploadRestController a : data.getDocumentList()) {

				String[] x = a.getFileName().split("\\.");
				String extension = x[x.length - 1];
				for (String s1 : a.getDocumentFile()) {
					if (s1 != null) {
						try {
							byte[] bytes = Base64.getDecoder().decode(s1);
							json = saveAllMediaDocuments(bytes, extension, data.getCreatedBy());

						} catch (Exception e) {
							e.printStackTrace();
						}
						a.setDocumentURL(json.getString("fileurl"));
					}
				}
			}
		}

		String value = GenerateNoticePolicyParameter.uploadResponse(data);

		try {

			if (data.getNoticeId() != null && data.getNoticeId() != "") {
				System.out.println("value value ::::" + value);
				em.createNamedStoredProcedureQuery("hrmManagePolicy").setParameter("actionType", "uploadResponse")
						.setParameter("actionValue", value).execute();

				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);

			} else {
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.ID_NOT_FOUND);

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

		ResponseEntity<JsonResponse<ManageNoticeRestModel>> response = new ResponseEntity<JsonResponse<ManageNoticeRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : uploadEmployeeResponse dao ends");
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

			Path path = Paths.get(env.getFileUploadnoticeUrl() + imageName);
			if (imageBytes != null) {
				Files.write(path, imageBytes);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = env.getMobileView() + "document/notice/" + imageName;

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

	// get all employee uploaded attachment
	public JsonResponse<Object> attachmentView(String organization, String orgDivision, String userId, String id) {
		logger.info("Method : getNoticeContent Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_organization='" + organization + "',@p_orgDivision='" + orgDivision
					+ "',@p_notice_id='" + id + "';";

			Object x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
					.setParameter("actionType", "getEmployeeAttachment").setParameter("actionValue", value)
					.getResultList();

			if (x != null) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, "success");
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getNoticeContent Dao ends");

		return resp;
	}

	public JsonResponse<Object> viewAllNoticeLetter(String org, String orgDiv, String userId ) {
		logger.info("Method : getNoticeContent Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv
				+ "',@p_userId='" + userId + "';";
		
		System.out.println("value data is======="+value);
		try {
		Object x = em.createNamedStoredProcedureQuery("hrmManagePolicy")
				.setParameter("actionType", "viewAllNoticeLetter").setParameter("actionValue", value)
				.getResultList();

		if (x != null) {
			Util.setJsonResponse(resp, x, ResponseStatus.success, "success");
		} else {
			Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
		}

	} catch (Exception e) {
		Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		resp.setMessage(e.getMessage());
		e.printStackTrace();
	}

		System.err.println("resp is======="+resp);
	logger.info("Method : getNoticeContent Dao ends");

	return resp;
	}
}
