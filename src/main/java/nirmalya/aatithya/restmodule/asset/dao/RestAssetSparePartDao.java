package nirmalya.aatithya.restmodule.asset.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;


@Repository
public class RestAssetSparePartDao {
	
	Logger logger = LoggerFactory.getLogger(RestAssetSparePartDao.class);
	
	@Autowired
	EntityManager em;

	@SuppressWarnings("unused")
	@Autowired
	private EnvironmentVaribles env;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewSparePartList(String orgName, String orgDivision) {
		logger.info("Method : viewSparePartList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision  + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "getSparePartsDetails").setParameter("actionValue", value)
					.getResultList();

			Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : viewSparePartList Dao ends");

		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewSparePartListSearch(String orgName, String orgDivision,String searchVal) {
		logger.info("Method : viewSparePartListSearch Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision  + "',@search='" + searchVal  + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "getSparePartsSearch").setParameter("actionValue", value)
					.getResultList();

			Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : viewSparePartListSearch Dao ends");

		return resp;

	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAssetList(String org, String orgDiv,String userId) {
		logger.info("Method : getAssetList starts");

		List<DropDownModel> getAssetList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv+ "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_view_master_routines")
					.setParameter("actionType", "getAssetList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAssetList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAssetList ends");
		return getAssetList;
	}

}
