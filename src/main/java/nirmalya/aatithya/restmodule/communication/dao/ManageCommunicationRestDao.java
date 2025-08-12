package nirmalya.aatithya.restmodule.communication.dao;

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

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCommunicationParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.communication.model.CommunicationDocumentRestModel;
import nirmalya.aatithya.restmodule.communication.model.ManageCommunicationRestModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class ManageCommunicationRestDao {

	Logger logger = LoggerFactory.getLogger(ManageCommunicationRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	private EnvironmentVaribles env;

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

			Path path = Paths.get(env.getFileUploadCommDocUrl() + imageName);
			if (imageBytes != null) {
				Files.write(path, imageBytes);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = env.getMobileView() + "document/communication/" + imageName;

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

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryList starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("communicationMasterRoutines")
					.setParameter("actionType", "getCountryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryLists ends");
		return countryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDeptList(String org, String orgDiv) {
		logger.info("Method : getDeptList starts");

		String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

		List<DropDownModel> getDeptList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("communicationMasterRoutines")
					.setParameter("actionType", "getDeptList").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getDeptList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDeptList ends");
		return getDeptList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateList(String id) {
		logger.info("Method : getStateListForLoc starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @P_Country='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("communicationMasterRoutines")
					.setParameter("actionType", "getStateList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}
			resp.setBody(stateList);
			if (stateList.size() > 0) {
				Util.setJsonResponse(resp, stateList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, stateList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getStateListForLoc ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCityList(String id) {
		logger.info("Method : getCityForLocation starts");

		List<DropDownModel> stateList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @P_State='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("communicationMasterRoutines")
					.setParameter("actionType", "getCityList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}
			resp.setBody(stateList);
			if (stateList.size() > 0) {
				Util.setJsonResponse(resp, stateList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, stateList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getCityForLocation ends");
		return response;
	}

	// Add Dispatch Details

	public JsonResponse<Object> addDispatchDetailsDao(ManageCommunicationRestModel data) {
		logger.info("Method : addDispatchDetailsDao dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		JSONObject json = new JSONObject();
		if (data.getDocumentList().size() > 0) {
			for (CommunicationDocumentRestModel a : data.getDocumentList()) {

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

		String value = GenerateCommunicationParam.getAddDispatchDetails(data);
		try {

			if (data.getRegNo() != null && data.getRegNo() != "") {
				em.createNamedStoredProcedureQuery("communicationMasterRoutines")
						.setParameter("actionType", "modifyDispatchData").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Modified Successfully");

			} else {
				em.createNamedStoredProcedureQuery("communicationMasterRoutines")
						.setParameter("actionType", "addDispatchData").setParameter("actionValue", value).execute();
				// resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Saved Successfully");

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

		logger.info("Method : addDispatchDetailsDao dao ends");
		return resp;

	}

	// Add Receive Details

	public JsonResponse<Object> addReceiveDetailsDao(ManageCommunicationRestModel data) {
		logger.info("Method : addReceiveDetailsDao dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		JSONObject json = new JSONObject();

		if (data.getDocumentList().size() > 0) {
			for (CommunicationDocumentRestModel a : data.getDocumentList()) {

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

		String value = GenerateCommunicationParam.addReceiveDetailsDao(data);
		System.out.println("Value >>>>>>> ReC"+value);
		try {

			if (data.getRegNo() != null && data.getRegNo() != "") {

				em.createNamedStoredProcedureQuery("communicationMasterRoutines")
						.setParameter("actionType", "modifyReceiveData").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Modified Successfully");

			} else {
				em.createNamedStoredProcedureQuery("communicationMasterRoutines")
						.setParameter("actionType", "addReceiveData").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Saved Successfully");

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

		logger.info("Method : addReceiveDetailsDao dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllData(String orgName, String orgDivision, String pageno, String type) {
		logger.info("Method : getAllData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_type='" + type
					+ "',@p_pageno='" + pageno + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("communicationMasterRoutines")
					.setParameter("actionType", "viewAllData").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllData Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getDataForEdit(String orgName, String orgDivision, String regNo) {
		logger.info("Method : getDataForEdit Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_regNo='" + regNo + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("communicationMasterRoutines")
					.setParameter("actionType", "viewEditData").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getDataForEdit Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getDataForDispatch(String orgName, String orgDivision, String regNo) {
		logger.info("Method : getDataForDispatch Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_regNo='" + regNo + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("communicationMasterRoutines")
					.setParameter("actionType", "viewEditDataDispatch").setParameter("actionValue", value)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getDataForDispatch Dao ends");
		return resp;

	}

	public ResponseEntity<JsonResponse<Object>> deleteCommunicationData(String id, String organization,
			String orgDivision, String userId) {
		logger.info("Method : deleteCommunicationData starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_regNo='" + id + "', @p_userId='" + userId + "', @p_org='" + organization
						+ "',@p_orgDiv='" + orgDivision + "';";

				em.createNamedStoredProcedureQuery("communicationMasterRoutines")
						.setParameter("actionType", "deleteCommunicationData").setParameter("actionValue", value)
						.execute();

				resp.setMessage("Success");
				resp.setCode("Ok");

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteCommunicationData ends");
		return response;
	}
	
	
	// Attachment View

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> attachemntDaoView(String id, String orgName, String orgDivision) {
			logger.info("Method : attachemntDaoView Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_regNo='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("communicationMasterRoutines")
						.setParameter("actionType", "attachemntView").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setMessage("Data Fetched Succesfully");
				resp.setCode("success");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}

			logger.info("Method : attachemntDaoView Dao ends");
			return resp;
		}

}
