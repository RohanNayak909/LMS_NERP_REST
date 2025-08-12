package nirmalya.aatithya.restmodule.asset.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class AssetProfileDao {
	Logger logger = LoggerFactory.getLogger(AssetProfileDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// viewAssetProfile
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAssetProfile(String orgName, String orgDivision,String userId) {
		logger.info("Method : viewAssetProfile Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_profile_routines")
					.setParameter("actionType", "viewAssetProfile").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			resp.setCode("unsuccess");
			resp.setMessage("Data Could Not Fetched");
			e.printStackTrace();
		}
		logger.info("Method : viewAssetProfile Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> showAssetDetails(String id, String orgName, String orgDivision) {
		logger.info("Method : showAssetDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_assetId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_profile_routines")
					.setParameter("actionType", "showAssetDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			resp.setCode("unsuccess");
			resp.setMessage("Data Could Not Fetched");
			e.printStackTrace();
		}
		logger.info("Method : showAssetDetails Dao ends");
		return resp;
	}
}
