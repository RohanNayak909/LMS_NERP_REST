package nirmalya.aatithya.restmodule.asset.dao;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateAssetViewMaster;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AssetViewMasterDao {
	Logger logger = LoggerFactory.getLogger(AssetViewMasterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	private EnvironmentVaribles env;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// addAsset 
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addAsset(List<AssetViewMasterRestModel> av) {
		logger.info("Method : addAsset dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		JSONObject json = new JSONObject();
		logger.info("av===" + av);
		
		String value = GenerateAssetViewMaster.getAddasset(av);
		try {

			if (av.get(0).getAssetId() != null && av.get(0).getAssetId() != "") {

				List<Object[]> x =em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "modifyAsset").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				List<Object[]> x =em.createNamedStoredProcedureQuery("asset_view_master_routines").setParameter("actionType", "addAsset")
						.setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
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


		logger.info("Method : addAsset dao ends");
		return resp;

	}

	// viewAsset
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAsset(String orgName, String orgDivision, String Type, String userId) {
		logger.info("Method : viewAsset Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_Type='" + Type+ "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId + "';";
			System.out.println("ASSET VALUE:::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "viewAsset").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAsset Dao ends");
		return resp;

	}

	// editAsset
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editAsset(String id, String orgName, String orgDivision) {
		logger.info("Method : editAsset Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_assetId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("valuee======"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "editAsset").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editAsset Dao ends");
		return resp;
	}

	// deleteAsset
	public ResponseEntity<JsonResponse<Object>> deleteAsset(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteAsset starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assetId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "deleteAsset").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
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

		logger.info("Method : deleteAsset ends");
		return response;
	}

	// scarpAsset
	public ResponseEntity<JsonResponse<Object>> scarpAsset(String id,String status, String orgName, String orgDivision,String assetDescsts) {
		logger.info("Method : scarpAsset starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assetId='" + id + "',@p_status='" + status+ "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_assetDescsts='" +assetDescsts+ "';";
				System.out.println("value======="+value);
				em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "scarpAsset").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Scrapped Successfully");
				
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

		logger.info("Method : scarpAsset ends");
		return response;
	}

	// approveAsset
	@SuppressWarnings("deprecation")
	public ResponseEntity<JsonResponse<Object>> approveAsset(String id, String pdate, String assetname,
			String purchaseno, String assettype, String orgName, String orgDivision) {
		logger.info("Method : approveAsset starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		String Qrfile = "QR" + new Date().getTime() + ".png";

		JSONObject jsonQr = new JSONObject();
		jsonQr.put("ID", id);
		jsonQr.put("Name", assetname);
		jsonQr.put("Type", assettype);
		jsonQr.put("Organization", orgName);
		jsonQr.put("Division", orgDivision);

		String qrdata = jsonQr.toString();
		
		if (validity)
			try {
				String qrCodeData = qrdata;
				String filePath = env.getAssetDocUrl() + Qrfile;

				String charset = "UTF-8";

				Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();

				hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
				BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),
						BarcodeFormat.QR_CODE, 200, 200, hintMap);
				MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1),
						new File(filePath));

				logger.info("Method : qrcode function Ends");

			} catch (Exception e) {
			}
		try {
			String value = "SET @p_assetId='" + id + "',@p_QrCode='" + Qrfile + "',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDivision + "';";
			em.createNamedStoredProcedureQuery("asset_view_master_routines").setParameter("actionType", "approveAsset")
					.setParameter("actionValue", value).execute();
			resp.setMessage("Data Approved Successfully");
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

		logger.info("Method : approveAsset ends");
		return response;
	}

	// getShiftListsAllocation
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeListforAsset(String org, String orgDiv, String userId) {
		logger.info("Method : getEmployeeListforAsset starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "getEmpList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeListforAsset ends");
		return getCollectionList;
	}

	// getLocationListforAsset
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLocationListforAsset(String org, String orgDiv, String userId) {
		logger.info("Method : getLocationListforAsset starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "getLocList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLocationListforAsset ends");
		return getCollectionList;
	}

	// assignAsset
	public ResponseEntity<JsonResponse<Object>> assignAsset(String id, String assetcat, String assetemp,
			String assigndate, String orgName, String orgDivision) {
		logger.info("Method : assignAsset starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assetId='" + id + "',@p_assetcat='" + assetcat + "',@p_assetemp='" + assetemp
						+ "',@p_assigndate='" + assigndate + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
						+ "';";
				em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "assignAsset").setParameter("actionValue", value).execute();
				resp.setMessage("Data Assigned Successfully");
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
	
	// sparepartAsset
	public ResponseEntity<JsonResponse<Object>> sparepartAsset(String id, String assetcat, String assetemp,
			String assigndate,String Quantity, String orgName, String orgDivision) {
		logger.info("Method : sparepartAsset starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assetId='" + id + "',@p_assetcat='" + assetcat + "',@p_assetemp='" + assetemp
						+ "',@p_assigndate='" + assigndate + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_Quantity='" + Quantity
						+ "';";
				em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "sparepartAssign").setParameter("actionValue", value).execute();
				resp.setMessage("Data Assigned Successfully");
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

		logger.info("Method : sparepartAsset ends");

		return response;
	}

	// historyAsset
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> historyAsset(String id, String orgName, String orgDivision) {
		logger.info("Method : historyAsset Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_assetId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "historyAsset").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : historyAsset Dao ends");
		return resp;
	}

	// Parameter List Api.

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getparameterListsApi(String org, String orgDiv) {
		logger.info("Method : getparameterLists Dao starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "getparameterlists").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}

			if (itemList.size() > 0) {
				Util.setJsonResponse(resp, itemList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, itemList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getparameterLists Dao ends");
		return response;
	}

	// getShiftListsAllocation
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeListforAssetApi(String org, String orgDiv,
			String userId) {
		logger.info("Method : getEmployeeListforAsset starts");

		List<DropDownModel> getEmployeeList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "getEmpList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getEmployeeList.add(dropDownModel);
			}
			if (getEmployeeList.size() > 0) {
				Util.setJsonResponse(resp, getEmployeeList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, getEmployeeList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getEmployeeListforAsset ends");
		return response;
	}

	// getLocationListforAssetApi
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getLocationListforAssetApi(String org, String orgDiv,
			String userId) {
		logger.info("Method : getLocationListforAsset starts");

		List<DropDownModel> getLocationList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "getLocList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getLocationList.add(dropDownModel);
			}
			if (getLocationList.size() > 0) {
				Util.setJsonResponse(resp, getLocationList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, getLocationList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getLocationListforAsset ends");
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

		logger.info("Method : saveAllMediaDocuments ends---"+json);
		return json;
	}

	// Search

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetViewSearch(String orgName, String orgDivision, String searchValue, String type) {
		logger.info("Method : assetViewSearch Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_Svalue='" + searchValue+ "',@p_type='" + type
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "assetViewSearch").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : assetViewSearch Dao ends");
		return resp;

	}

	public ResponseEntity<JsonResponse<Object>> disposeAsset(String id, String orgName, String orgDivision) {
		logger.info("Method : disposeAsset starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assetId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("DISPOSE::::"+value);
				em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "disposeAsset").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Asset Disposed Successfully");
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,HttpStatus.CREATED);

		logger.info("Method : disposeAsset ends");
		return response;
	}
	
	public JsonResponse<Object> addAssetDetails(AssetViewMasterRestModel av) {
		logger.info("Method : addAsset dao starts");
		System.err.println(av.getFileName()+"----"+av.getDocumentFileBase());
		JsonResponse<Object> resp = new JsonResponse<Object>();
		JSONObject json = new JSONObject();

		if(av.getFileName() != null && av.getFileName() != "") {
			String[] x = av.getFileName().split("\\.");
			String extension = x[x.length - 1];
				if (av.getDocumentFileBase() != null) {
					try {
						byte[] bytes = Base64.getDecoder().decode(av.getDocumentFileBase());
						json = saveAllMediaDocuments(bytes, extension, av.getCreatedBy());

					} catch (Exception e) {
						e.printStackTrace();
					}
					av.setDocumentURL(json.getString("fileurl"));
				}
		}
		
		String value = GenerateAssetViewMaster.getAddAssetDetails(av);
		System.err.println(av.getDocumentURL()+" ---- values----------"+value);
		try {
				em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "addAssetDetails") 
					.setParameter("actionValue",value).execute();
		
				if ("Warenty".equals(av.getCategory())) {
					resp.setMessage("Warenty Details saved successfully");
				}
				if ("Insurance".equals(av.getCategory())) {
					resp.setMessage("Insurance Details saved successfully");
				}
				if ("Compliance".equals(av.getCategory())) {
					resp.setMessage("Documentation saved successfully");
				}
				resp.setCode("success");

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


		logger.info("Method : addAsset dao ends");
		logger.info("add detss daoooo resp======="+resp);
		return resp;

	}

	// deleteAsset
	public ResponseEntity<JsonResponse<Object>> deleteAssetDetails(String id, String type, String assetId, String orgName, String orgDivision) {
		logger.info("Method : deleteAsset starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String value = "SET @p_id='" + id + "',@p_type='" + type + "',@p_assetId='" + assetId+ "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.err.println("value===="+value);
				em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "deleteAssetDetails").setParameter("actionValue", value).execute();
				resp.setCode("success");
				if ("Warenty".equals(type)) {
					resp.setMessage("Warenty Details Deleted successfully");
				}
				if ("Insurance".equals(type)) {
					resp.setMessage("Insurance Deleted successfully");
				}
				if ("Compliance".equals(type)) {
					resp.setMessage("Documentation Deleted successfully");
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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteAsset ends");
		return response;
	}

}
