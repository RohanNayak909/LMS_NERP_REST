package nirmalya.aatithya.restmodule.asset.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.asset.model.AssetPoilcyRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateAssetPolicyParams;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AssetGroupingRestDao {
	Logger logger = LoggerFactory.getLogger(AssetGroupingRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;



	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAssetInGrouping(String orgName, String orgDivision, String cat, String subcat) {
		logger.info("Method : viewAssetInGrouping Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_cat='" + cat+ "',@p_subcat='" + subcat + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "assetInGrouping").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAssetInGrouping Dao ends");
		return resp;

	}
	
	
	public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addAssetGroup(List<AssetPoilcyRestModel> av) {
		logger.info("Method : addAssetGroup dao starts");
		JsonResponse<List<AssetPoilcyRestModel>> resp = new JsonResponse<List<AssetPoilcyRestModel>>();

		String value = GenerateAssetPolicyParams.getAddAssetGrouping(av);
		System.out.println("@@@@@----------"+av.get(0).getGroupid());
		try {

			if (av.get(0).getGroupid() != null && av.get(0).getGroupid() != "") {

				em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
						.setParameter("actionType", "modifyGroup").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("asset_mstr_policy_routines").setParameter("actionType", "addGroup")
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

		ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> response = new ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addAssetGroup dao ends"+response);
		return response;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAssetGroup(String orgName, String orgDivision,String userId) {
		logger.info("Method : viewAssetGroup Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId+ "';";
			System.out.println("VALUE::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "assetGroupView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAssetGroup Dao ends");
		return resp;

	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editGrouping(String id, String orgName, String orgDivision) {
		logger.info("Method : editGrouping Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_groupId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "editGrouping").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editGrouping Dao ends");
		return resp;
	}
	public ResponseEntity<JsonResponse<Object>> approveAssetGroup(String id, String orgName, String orgDivision) {
		logger.info("Method : approveAssetGroup starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_groupId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("----------------"+value);
				em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
						.setParameter("actionType", "approveAssetGroup").setParameter("actionValue", value).execute();
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
		logger.info("Method : approveAssetGroup ends");
		return response;
	}
	public ResponseEntity<JsonResponse<Object>> deleteAssetGroup(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteAssetGroup starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_groupId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("-------@@@@-------"+value);
				em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
						.setParameter("actionType", "deleteAssetGroup").setParameter("actionValue", value).execute();
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

		logger.info("Method : deleteAssetGroup ends");
		return response;
	}
}
