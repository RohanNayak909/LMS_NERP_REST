package nirmalya.aatithya.restmodule.asset.dao;

import java.util.ArrayList;
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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateAssetPolicyParams;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class PropertyGroupingRestDao {
	Logger logger = LoggerFactory.getLogger(PropertyGroupingRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;



	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPropertyInGrouping(String orgName, String orgDivision ,String pid,String fid) {
		logger.info("Method : viewPropertyInGrouping Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_pid='" + pid + "',@p_fid='" + fid + "';";
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_property_grouping_routines")
					.setParameter("actionType", "PropertyInGrouping").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPropertyInGrouping Dao ends"+resp);
		return resp;

	}
	
	
	public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addPropertyGroup(List<AssetPoilcyRestModel> av) {
		logger.info("Method : addPropertyGroup dao starts");
		JsonResponse<List<AssetPoilcyRestModel>> resp = new JsonResponse<List<AssetPoilcyRestModel>>();

		String value = GenerateAssetPolicyParams.getAddPropertyGrouping(av);
		System.out.println("@@@@@----------"+av.get(0).getGroupid());
		try {

			if (av.get(0).getGroupid() != null && av.get(0).getGroupid() != "") {

				em.createNamedStoredProcedureQuery("asset_property_grouping_routines")
						.setParameter("actionType", "modifyGroup").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("asset_property_grouping_routines").setParameter("actionType", "addGroup")
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
		logger.info("Method : addPropertyGroup dao ends"+response);
		return response;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPropertyGroup(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewPropertyGroup Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId + "';";
			System.out.println("PARAMETERS OF GROUP:::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_property_grouping_routines")
					.setParameter("actionType", "PropertyGroupView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPropertyGroup Dao ends");
		return resp;

	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editGrouping(String id, String orgName, String orgDivision) {
		logger.info("Method : editGrouping Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_groupId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_property_grouping_routines")
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
	public ResponseEntity<JsonResponse<Object>> approvePropertyGroup(String id, String orgName, String orgDivision) {
		logger.info("Method : approvePropertyGroup starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_groupId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("----------------"+value);
				em.createNamedStoredProcedureQuery("asset_property_grouping_routines")
						.setParameter("actionType", "approvePropertyGroup").setParameter("actionValue", value).execute();
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
		logger.info("Method : approvePropertyGroup ends");
		return response;
	}
	public ResponseEntity<JsonResponse<Object>> deletePropertyGroup(String id, String orgName, String orgDivision) {
		logger.info("Method : deletePropertyGroup starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_groupId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("-------@@@@-------"+value);
				em.createNamedStoredProcedureQuery("asset_property_grouping_routines")
						.setParameter("actionType", "deletePropertyGroup").setParameter("actionValue", value).execute();
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

		logger.info("Method : deletePropertyGroup ends");
		return response;
	}
//
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPropertyList(String org, String orgDiv, String userId) {
		logger.info("Method : getPropertyList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		System.out.println("@@@@@-----------------"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_property_grouping_routines")
					.setParameter("actionType", "getPropertyList1").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPropertyList ends"+getCollectionList);
		return getCollectionList;
	}
//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getFloor(String id, String orgName, String orgDivision) {
		logger.info("Method : getFloor Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_propertyId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_property_grouping_routines")
					.setParameter("actionType", "getFloor").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getFloor Dao ends");
		return resp;
	}
}
