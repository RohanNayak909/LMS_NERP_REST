package nirmalya.aatithya.restmodule.asset.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.asset.model.AssetEquipementRequestRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetPlanningRestModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateAssetEquipementParams;
import nirmalya.aatithya.restmodule.common.utils.asset.GeneratePropertyPlanningParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AssetEquipementExecuteDao {
	Logger logger = LoggerFactory.getLogger(AssetEquipementExecuteDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	private EnvironmentVaribles env;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editRequestExecute(String id, String orgName, String orgDivision) {
		logger.info("Method : editRequestExecute Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_requestId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_execution_request_routines")
					.setParameter("actionType", "editRequestEx").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editRequestExecute Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> showTotalSpare(String cat,String scat, String orgName, String orgDivision) {
		logger.info("Method : showTotalSpare Dao starts");
		String scatList="";
		String[] userIds = scat.split(",");

		for (String a : userIds) {
			scatList = scatList + "\"" + a + "\",";
				}
		scatList = scatList.substring(0, scatList.length() - 1);
		scatList = "(" + scatList + ")";
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_cat='" + cat+ "',@p_scat='" + scatList+ "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("VALUES::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_execution_request_routines")
					.setParameter("actionType", "showTotalSpare").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetching Interupted");
		}
		logger.info("Method : showTotalSpare Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addRequestEx(List<AssetEquipementRequestRestModel> av) {
		logger.info("Method : addRequestEx dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		JSONObject json = new JSONObject();
		String value = GenerateAssetEquipementParams.addPlanProperty(av);
		try {
				em.createNamedStoredProcedureQuery("asset_execution_request_routines")
						.setParameter("actionType", "addRequestEx").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Modified successfully");
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
		logger.info("Method : addRequestEx dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEquipementDetailsEx(String orgName, String orgDivision) {
		logger.info("Method : viewEquipementDetailsEx Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_execution_request_routines")
					.setParameter("actionType", "viewEquipementEx").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewEquipementDetailsEx Dao ends");
		return resp;

	}
}
