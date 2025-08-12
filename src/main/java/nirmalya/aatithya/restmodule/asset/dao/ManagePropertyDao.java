package nirmalya.aatithya.restmodule.asset.dao;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import nirmalya.aatithya.restmodule.asset.model.AssetDocumentRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetPropertyRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetProprtyOwnerRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAssetPropertyParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateAssetViewMaster;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.LocationRoomModel;
import nirmalya.aatithya.restmodule.training.model.ManageTrainingRestDocumentModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;


@Repository
public class ManagePropertyDao {

	Logger logger = LoggerFactory.getLogger(ManagePropertyDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	private EnvironmentVaribles env;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveLocationMaster(AssetPropertyRestModel location) {
		logger.info("Method : saveLocationMaster starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		JSONObject json = new JSONObject();
		if (location.getLocationName() == null || location.getLocationName() == "") {
			resp.setMessage("Location Name Required");
			validity = false;
		} else if (location.getLocationCode() == null || location.getLocationCode() == "") {
			resp.setMessage("Location Code Required");
			validity = false;
		} else if (location.getLocationType() == null || location.getLocationType() == "") {
			resp.setMessage("Location Type Required");
			validity = false;
		} else if (location.getLocCountry() == null || location.getLocCountry() == "") {
			resp.setMessage("Country Required");
			validity = false;
		} else if (location.getLocState() == null || location.getLocState() == "") {
			resp.setMessage("State Required");
			validity = false;
		} else if (location.getLocCity() == null || location.getLocCity() == "") {
			resp.setMessage("City Required");
			validity = false;
		} else if (location.getLocStreet() == null || location.getLocStreet() == "") {
			resp.setMessage("Street Required");
			validity = false;
		}
		if (location.getDocumentList().size() > 0) {
			for (AssetDocumentRestModel a : location.getDocumentList()) {

				String[] x = a.getFileName().split("\\.");
				String extension = x[x.length - 1];
				for (String s1 : a.getDocumentFile()) {
					if (s1 != null) {
						try {
							byte[] bytes = Base64.getDecoder().decode(s1);
							json = saveAllMediaDocuments(bytes, extension, location.getCreatedBy());

						} catch (Exception e) {
							e.printStackTrace();
						}
						a.setDocumentURL(json.getString("fileurl"));
					}
				}
			}
		}
		if (validity)
			try {
				String values = GenerateAssetPropertyParam.saveLocation(location);
				System.err.println("values=========="+values);
				if (location.getLocationId() != null && location.getLocationId() != "") {
					List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
							.setParameter("actionType", "modifyProperty").setParameter("actionValue", values)
							.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data modified successfully");
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
							.setParameter("actionType", "addProperty").setParameter("actionValue", values)
							.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data added successfully");

				}

				
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


		logger.info("Method : saveLocationMaster ends"+resp);
		return resp;
	}
	

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAssetProperty(String orgName, String orgDivision, String type) {
		logger.info("Method : viewAssetProperty Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_type='" + type + "';";
			System.err.println("value===="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "viewProperty").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAssetProperty Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editAssetProperty(String id, String orgName, String orgDivision) {
		logger.info("Method : editAssetProperty Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_locId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "editAssetProperty").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editAssetProperty Dao ends"+resp);
		return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> savePropertyFloor(AssetPropertyRestModel location) {
		logger.info("Method : savePropertyFloor starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (location.getLocationName() == null || location.getLocationName() == "") {
			resp.setMessage("Floor Name Required");
			validity = false;
		} else if (location.getLocationCode() == null || location.getLocationCode() == "") {
			resp.setMessage("Floor Id Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateAssetPropertyParam.saveLocation(location);
				System.out.println("GenerateAssetPropertyParam::::"+values);
				if (location.getFloorId() != null && location.getFloorId() != "") {

					List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
							.setParameter("actionType", "modifyFloor").setParameter("actionValue", values)
							.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data modified successfully");

				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
							.setParameter("actionType", "addFloor").setParameter("actionValue", values).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data added successfully");

				}

			} catch (Exception e) {
				e.printStackTrace();
			}


		logger.info("Method : savePropertyFloor ends");
		return resp;
	}

	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPropertyRoomDetails(List<String> id) {
		logger.info("Method : getPropertyRoomDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = GenerateAssetPropertyParam.getSectionIdList(id);
		System.out.println("VALUES::::"+value);
		if (id.size() > 0) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
						.setParameter("actionType", "getPropertyRoomDetails").setParameter("actionValue", value)
						.getResultList();

				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		logger.info("Method : getPropertyRoomDetails ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveRoomForAssetProperty(LocationRoomModel location) {
		logger.info("Method : saveRoomForAssetProperty starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (location.getRoomCode() == null || location.getRoomCode() == "") {
			resp.setMessage("Room Code Required");
			validity = false;
		} else if (location.getRoomName() == null || location.getRoomName() == "") {
			resp.setMessage("Room Name Required");
			validity = false;
		} else if (location.getRoomType() == null || location.getRoomType() == "") {
			resp.setMessage("Room Type Required");
			validity = false;
		} else if (location.getFloorId() == null || location.getFloorId() == "") {
			resp.setMessage("Floor Id Required");
			validity = false;
		} else if (location.getVariationType() == null || location.getVariationType() == "") {
			resp.setMessage("Variation Required");
			validity = false;
		}
		if (validity)
			try {
				String values = GenerateAssetPropertyParam.saveRoom(location);
				if (location.getRoomId() != null && location.getRoomId() != "") {

					List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
							.setParameter("actionType", "modifyRoom").setParameter("actionValue", values)
							.getResultList();
					
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data modified successfully");
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
							.setParameter("actionType", "addRoom").setParameter("actionValue", values).getResultList();
					
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data added successfully");
				}
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


		logger.info("Method : saveRoomForAssetProperty ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getLocationFloorDetails(String id) {
		logger.info("Method : getLocationFloorDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = "SET @P_LocationId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "getLocationFloorDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}


		logger.info("Method : getLocationFloorDetails ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteFloorForAsset(String id, String createdBy) {
		logger.info("Method : deleteFloorForAsset starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @P_ModifiedBy='" + createdBy + "', @P_Floor='" + id + "';";

				em.createNamedStoredProcedureQuery("assetPropertyRoutines").setParameter("actionType", "deleteFloor")
						.setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data deleted successfully");

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
		logger.info("Method : deleteFloorForAsset ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteRoomForAsset(String id, String createdBy) {
		logger.info("Method : deleteRoomForAsset starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @P_ModifiedBy='" + createdBy + "', @P_Room='" + id + "';";
				em.createNamedStoredProcedureQuery("assetPropertyRoutines").setParameter("actionType", "deleteRoom")
						.setParameter("actionValue", value).execute();
				
				resp.setCode("success");
				resp.setMessage("Data deleted successfully");
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
		logger.info("Method : deleteRoomForAsset ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteLocationForAsset(List<DropDownModel> id) {
		logger.info("Method : deleteLocationForAsset starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String value = GenerateAssetPropertyParam.getLocationIdList(id);
				em.createNamedStoredProcedureQuery("assetPropertyRoutines")
						.setParameter("actionType", "deleteLocation").setParameter("actionValue", value).execute();
				
				resp.setCode("success");
				resp.setMessage("Data deleted successfully");
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
		logger.info("Method : deleteLocationForAsset ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteLocatioinForAsset(String id, String org, String orgDiv, String userId) {
		logger.info("Method : deleteLocatioinDetails starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {				
				String value = "SET @p_locationId='" + id + "',@p_userId='" + userId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
				System.err.println("deleteFunc===="+value);
				em.createNamedStoredProcedureQuery("assetPropertyRoutines")
						.setParameter("actionType", "deleteLocationMaster").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data deleted successfully");
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

		logger.info("Method :  deleteLocatioinDetails ends");
		logger.info("DELETE" + response);
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteLocationFile(String id, String createdBy) {
		logger.info("Method : deleteLocationFile starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @P_ModifiedBy='" + createdBy + "', @P_Location='" + id + "';";
				System.out.println("VALUE:::::"+value);
				em.createNamedStoredProcedureQuery("assetPropertyRoutines")
						.setParameter("actionType", "deleteLocationFile").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("File deleted successfully");
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

		logger.info("Method : deleteLocationFile ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> showTotalAsset(String type,String cat,String scat, String orgName, String orgDivision,String userId) {
		logger.info("Method : showTotalAsset Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_assetType='" + type + "',@p_cat='" + cat+ "',@p_scat='" + scat+ "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId + "';";
			System.out.println("VALUES::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "showTotalAsset").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data fetching interupted");
		}
		logger.info("Method : showTotalAsset Dao ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> assignAsset(String id, String locid, String loctype,String date, String orgName, String orgDivision, String userId) {
		logger.info("Method : assignAsset starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String value = "";
		String values = "";
		String litem = "";
		String ticket = "";
		String[] parts = id.split(",");
        for (String part : parts) {
            value = value + "(FN_GET_ASSIGNID(),\"" + part + "\",\""+ loctype + "\",\"" + locid + "\",\""+ date +"\",\""+orgName+"\",\""+orgDivision+"\"),";
            ticket= ticket + "(FN_GET_TICKETID(),\"" + userId + "\",@userName,\"" + DateFormatter.getStringDate(date) + "\",@deptId,\"TTYPE004\",\"TCAT007\",\"TSCAT006\",\"1\",\"Following Asset Should Be Assigned To Mentioned Location\",\"Property\",\"\",\"\",\""+ locid + "\",\""+ userId +"\",now(),\""+orgName+"\",\""+orgDivision+"\",1,\"COMPLETED\",\""+part+"\"),";
        }
        for (String a : parts) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		
        value = value.substring(0, value.length() - 1);
        ticket = ticket.substring(0, ticket.length() - 1);
        values = values + "SET @p_itemSubQuery='" + value + "',"+ "@p_assetId='" + litem+ "',"+ "@p_ticket='" + ticket+ "',"+ "@p_orgName='" + orgName+ "',"+ "@p_orgDivision='" + orgDivision+ "',"+ "@p_userId='" + userId + "';";
        System.out.println(values);
		if (validity)
			
		try {
			em.createNamedStoredProcedureQuery("assetPropertyRoutines").setParameter("actionType", "assignAsset")
					.setParameter("actionValue", values).execute();
			resp.setMessage("Asset assigned successfully");
			resp.setCode("success");
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

		logger.info("Method : assignAsset ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> showReportTotal(String type,String id, String orgName, String orgDivision) {
		logger.info("Method : showReportTotal Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_assetType='" + type + "',@p_id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("Value::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "showAssignedTotal").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : showReportTotal Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> showReportTotalAssign(String type,String id, String orgName, String orgDivision) {
		logger.info("Method : showReportTotalAssign Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_assetType='" + type + "',@p_id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("Value::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "showReportTotalAssign").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : showReportTotalAssign Dao ends");
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

			Path path = Paths.get(env.getAssetDocUrl() + imageName);
			if (imageBytes != null) {
				Files.write(path, imageBytes);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = env.getMobileView() + "document/assetDocUrl/" + imageName;

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
	public ResponseEntity<JsonResponse<List<AssetProprtyOwnerRestModel>>> addPropertyOwner(List<AssetProprtyOwnerRestModel> av) {
		logger.info("Method : addPropertyOwner dao starts");
		JsonResponse<List<AssetProprtyOwnerRestModel>> resp = new JsonResponse<List<AssetProprtyOwnerRestModel>>();
		JSONObject json = new JSONObject();
		logger.info("av===" + av);
		if (av.get(0).getDocumentList().size() > 0) {
			for (AssetDocumentRestModel a : av.get(0).getDocumentList()) {

				String[] x = a.getFileName().split("\\.");
				String extension = x[x.length - 1];
				for (String s1 : a.getDocumentFile()) {
					if (s1 != null) {
						try {
							byte[] bytes = Base64.getDecoder().decode(s1);
							json = saveAllMediaDocuments(bytes, extension, av.get(0).getCreatedBy());

						} catch (Exception e) {
							e.printStackTrace();
						}
						a.setDocumentURL(json.getString("fileurl"));
					}
				}
			}
		}
		String value = GenerateAssetPropertyParam.getAddOwnerDetails(av);
		try {
			System.out.println("VALUES TO BE INSERTED:::::"+value);
			if (av.get(0).getOwnerId() != null && av.get(0).getOwnerId() != "") {

				em.createNamedStoredProcedureQuery("assetPropertyRoutines")
						.setParameter("actionType", "modifyOwnerDetails").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("assetPropertyRoutines").setParameter("actionType", "addOwnerDetails")
						.setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<List<AssetProprtyOwnerRestModel>>> response = new ResponseEntity<JsonResponse<List<AssetProprtyOwnerRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addPropertyOwner dao ends");
		return response;

	}
	
	public ResponseEntity<JsonResponse<Object>> deletePropertyOwner(String id, String orgName, String orgDivision) {
		logger.info("Method : deletePropertyOwner starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {

				String value = "SET @p_deleteId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("assetPropertyRoutines")
						.setParameter("actionType", "deletePropertyOwner").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Record deleted successfully");
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

		logger.info("Method : deletePropertyOwner ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAttachmentOwner(String id, String orgName, String orgDivision) {
		logger.info("Method : getAttachmentOwner Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_propertyId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "getAttachmentOwner").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAttachmentOwner Dao ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<List<AssetProprtyOwnerRestModel>>> addDocsOfProperty(List<AssetProprtyOwnerRestModel> av) {
		logger.info("Method : addDocsOfProperty dao starts");
		JsonResponse<List<AssetProprtyOwnerRestModel>> resp = new JsonResponse<List<AssetProprtyOwnerRestModel>>();
		JSONObject json = new JSONObject();
		logger.info("av===" + av);
		if (av.get(0).getDocumentList().size() > 0) {
			for (AssetDocumentRestModel a : av.get(0).getDocumentList()) {

				String[] x = a.getFileName().split("\\.");
				String extension = x[x.length - 1];
				for (String s1 : a.getDocumentFile()) {
					if (s1 != null) {
						try {
							byte[] bytes = Base64.getDecoder().decode(s1);
							json = saveAllMediaDocuments(bytes, extension, av.get(0).getCreatedBy());

						} catch (Exception e) {
							e.printStackTrace();
						}
						a.setDocumentURL(json.getString("fileurl"));
					}
				}
			}
		}
		String value = GenerateAssetPropertyParam.getAddDocsDetails(av);
		try {
			System.err.println("VALUES TO BE addDocsOfProperty :::::"+value);
			em.createNamedStoredProcedureQuery("assetPropertyRoutines")
			.setParameter("actionType", "addDocsOfProperty").setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Document added successfully");

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

		ResponseEntity<JsonResponse<List<AssetProprtyOwnerRestModel>>> response = new ResponseEntity<JsonResponse<List<AssetProprtyOwnerRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addDocsOfProperty dao ends==="+response);
		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getDocsOfProperty(String id, String orgName, String orgDivision) {
		logger.info("Method : getDocsOfProperty Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_propertyId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("Value To Get the Doc-->"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "getDocsOfProperty").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDocsOfProperty Dao ends");
		return resp;
	}
	

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewBuildingFloor(String orgName, String orgDivision) {
		logger.info("Method : viewBuildingFloor Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.err.println("value===="+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "viewBuildingFloor").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewBuildingFloor Dao ends");
		return resp;
	}

	public ResponseEntity<JsonResponse<Object>> deleteDocuments(String id, String org, String orgDiv) {
		logger.info("Method : deleteLocatioinDetails starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {				
				String value = "SET @p_docId='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
				System.err.println("deleteFunc===="+value);
				em.createNamedStoredProcedureQuery("assetPropertyRoutines")
						.setParameter("actionType", "deleteDocuments").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data deleted successfully");
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

		logger.info("Method :  deleteLocatioinDetails ends");
		logger.info("DELETE" + response);
		return response;
}

	public ResponseEntity<JsonResponse<Object>> deleteFloors(String id, String org, String orgDiv) {
			logger.info("Method : deleteFloors starts");
			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			if (validity)
				try {				
					String value = "SET @P_Floor='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
					System.err.println("deleteFunc===="+value);
					em.createNamedStoredProcedureQuery("assetPropertyRoutines")
							.setParameter("actionType", "deleteFloor").setParameter("actionValue", value).execute();

					resp.setCode("success");
					resp.setMessage("Data deleted successfully");
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

			logger.info("Method :  deleteFloors ends");
			logger.info("DELETE" + response);
			return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewFloorRooms(String floorId, String orgName, String orgDivision) {
		logger.info("Method : viewBuildingFloor Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_floorId='" + floorId + "';";
			System.err.println("value===="+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "viewFloorRooms").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewFloorRooms Dao ends");
		return resp;
	}
	public ResponseEntity<JsonResponse<Object>> deleteRoom(String id, String org, String orgDiv) {
		logger.info("Method : deleteRoom starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {				
				String value = "SET @P_Room='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
				System.err.println("deleteFunc===="+value);
				em.createNamedStoredProcedureQuery("assetPropertyRoutines")
						.setParameter("actionType", "deleteRoom").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data deleted successfully");
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

		logger.info("Method :  deleteRoom ends");
		logger.info("DELETE" + response);
		return response;
}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveFloorDetails(LocationRoomModel location) {
		logger.info("Method : saveFloorDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String values = GenerateAssetPropertyParam.saveFloorDetails(location);
				if (location.getDetailId() != null && location.getDetailId() != "") {

					em.createNamedStoredProcedureQuery("assetPropertyRoutines")
							.setParameter("actionType", "modifyFloorDets").setParameter("actionValue", values)
							.execute();
					
					resp.setCode("success");
					resp.setMessage("Data modified successfully");
				} else {

					em.createNamedStoredProcedureQuery("assetPropertyRoutines")
							.setParameter("actionType", "addFloorDets").setParameter("actionValue", values)
							.execute();
					
					resp.setCode("success");
					resp.setMessage("Data added successfully");
				}
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


		logger.info("Method : saveFloorDetails ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewFloorDets(String floorId, String orgName, String orgDivision) {
		logger.info("Method : viewFloorDets Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_floorId='" + floorId + "';";
			System.err.println("value===="+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "viewFloorDets").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewFloorDets Dao ends");
		return resp;
	}

	public ResponseEntity<JsonResponse<Object>> deleteFloorDetails(String id, String org, String orgDiv) {
		logger.info("Method : deleteRoom starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {				
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_detId='" + id + "';";
				System.err.println("deleteFunc===="+value);
				em.createNamedStoredProcedureQuery("assetPropertyRoutines")
						.setParameter("actionType", "deleteFloorDets").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data deleted successfully");
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

		logger.info("Method :  deleteRoom ends");
		logger.info("DELETE" + response);
		return response;
}
}
