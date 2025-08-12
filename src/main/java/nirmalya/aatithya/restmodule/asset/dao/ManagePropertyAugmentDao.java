package nirmalya.aatithya.restmodule.asset.dao;

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
import nirmalya.aatithya.restmodule.asset.model.AssetDocumentRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateAssetViewMaster;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ManagePropertyAugmentDao {
	Logger logger = LoggerFactory.getLogger(ManagePropertyAugmentDao.class);

	@Autowired
	EntityManager em;
	
	@Autowired
	private EnvironmentVaribles env;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// viewAsset
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPropertyAugment(String orgName, String orgDivision,String property,String floor,String space) {
		logger.info("Method : viewPropertyAugment Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_property='" + property + "',@p_floor='" + floor + "',@p_space='" + space + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "viewPropertyAugment").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPropertyAugment Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPropertyList(String org, String orgDiv, String userId) {
		logger.info("Method : getPropertyList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "getPropertyList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPropertyList ends");
		return getCollectionList;
	}

	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getFloorFromProperty(String orgName, String orgDivision,String property) {
		logger.info("Method : viewPropertyAugment Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_property='" + property + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "getFloorFromProperty").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getFloorFromProperty Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addAsset(List<AssetViewMasterRestModel> av) {
		logger.info("Method : addAsset dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
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

		if (av.get(0).getWarrantyList().size() > 0) {
			for (AssetViewMasterRestModel a : av.get(0).getWarrantyList()) {

				String delimiters = "\\.";
				if (a.getDocumentFileBase() != null && a.getDocumentFileBase() != "") {
					String[] y = a.getFileName().split(delimiters);
					String extensionW = y[y.length - 1];
					try {
						byte[] bytes = Base64.getDecoder().decode(a.getDocumentFileBase());
						json = saveAllMediaDocuments(bytes, extensionW, av.get(0).getCreatedBy());

					} catch (Exception e) {
						e.printStackTrace();
					}
					a.setDocumentURL(json.getString("fileurl"));
				}
			}
		}
		if (av.get(0).getInsuranceList().size() > 0) {
			for (AssetViewMasterRestModel a : av.get(0).getInsuranceList()) {

				String delimiters = "\\.";
				if (a.getDocumentFileBase() != null && a.getDocumentFileBase() != "") {
					String[] z = a.getFileName().split(delimiters);
					String extensionY = z[z.length - 1];
					try {
						byte[] bytes = Base64.getDecoder().decode(a.getDocumentFileBase());
						json = saveAllMediaDocuments(bytes, extensionY, av.get(0).getCreatedBy());

					} catch (Exception e) {
						e.printStackTrace();
					}
					a.setDocumentURL(json.getString("fileurl"));
				}
			}
		}
		String value = GenerateAssetViewMaster.getAddasset(av);
		try {

			if (av.get(0).getAssetId() != null && av.get(0).getAssetId() != "") {

				List<Object[]> x =em.createNamedStoredProcedureQuery("asset_view_master_routines")
						.setParameter("actionType", "modifyAugmentAsset").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				List<Object[]> x =em.createNamedStoredProcedureQuery("asset_view_master_routines").setParameter("actionType", "addAugmentAsset")
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
}
