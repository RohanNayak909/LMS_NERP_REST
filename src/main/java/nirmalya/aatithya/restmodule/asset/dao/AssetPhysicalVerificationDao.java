package nirmalya.aatithya.restmodule.asset.dao;

import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.asset.model.AssetDocumentRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateAssetViewMaster;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AssetPhysicalVerificationDao {
	Logger logger = LoggerFactory.getLogger(AssetPhysicalVerificationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// viewAssetProfile
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> allotedVerificationView(String orgName, String orgDivision,String userId, String userRole) {
		logger.info("Method : allotedVerificationView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "',@p_userRole='" + userRole + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_verification_routines")
					.setParameter("actionType", "allotVerifyView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			resp.setCode("unsuccess");
			resp.setMessage("Data Could Not Fetched");
			e.printStackTrace();
		}
		logger.info("Method : allotedVerificationView Dao ends");
		return resp;

	}
	
	// viewAssetProfile
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addVerifyDetails(String id,String orgName, String orgDivision,String userId, String userRole) {
		logger.info("Method : addVerifyDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_assetId='" + id+ "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "',@p_userRole='" + userRole + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_verification_routines")
					.setParameter("actionType", "addVerifyDetail").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			resp.setCode("unsuccess");
			resp.setMessage("Data Could Not Fetched");
			e.printStackTrace();
		}
		logger.info("Method : addVerifyDetails Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetVerifySubmit(List<AssetViewMasterRestModel> av) {
		logger.info("Method : assetVerifySubmit dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = GenerateAssetViewMaster.verifyParams(av);
		try {

				em.createNamedStoredProcedureQuery("asset_verification_routines")
						.setParameter("actionType", "verifyParams").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Asset Verified Successfully");

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


		logger.info("Method : assetVerifySubmit dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewVerifyDetails(String id,String orgName, String orgDivision,String userId, String userRole) {
		logger.info("Method : viewVerifyDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_activeId='" + id+ "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "',@p_userRole='" + userRole + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_verification_routines")
					.setParameter("actionType", "viewVerifyDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			resp.setCode("unsuccess");
			resp.setMessage("Data Could Not Fetched");
			e.printStackTrace();
		}
		logger.info("Method : viewVerifyDetails Dao ends");
		return resp;

	}
}
