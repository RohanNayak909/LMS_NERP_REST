package nirmalya.aatithya.restmodule.maintenance.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateAssetViewMaster;

@Repository
public class AssetMaintenanceDao {
	Logger logger = LoggerFactory.getLogger(AssetMaintenanceDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;



	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAssetMaintenance(String orgName, String orgDivision) {
		logger.info("Method : viewAssetMaintenance Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "viewAsset").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAssetMaintenance Dao ends");
		return resp;

	}
	
	
	

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getThirdPartyList(String org,String orgDiv,String userId) {
		logger.info("Method : getThirdPartyList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId +"';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "getVendorList").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getThirdPartyList ends");
		return getCollectionList;
	}
	
	

	/*
	 * public ResponseEntity<JsonResponse<Object>> allocatePolicy(String cat, String
	 * subCat, String policyId, String assetList, String assetemp, String
	 * assigndate, String assetcat, String assetGrp, String orgName, String
	 * orgDivision, String userId, String type) {
	 * logger.info("Method : allocatePolicy starts");
	 * 
	 * Boolean validity = true; JsonResponse<Object> resp = new
	 * JsonResponse<Object>(); resp.setMessage(""); resp.setCode(""); Date
	 * currentTime = new Date(); SimpleDateFormat sdf = new
	 * SimpleDateFormat("h:mm a"); String formattedTime = sdf.format(currentTime);
	 * if (validity) try {
	 * 
	 * String value = "SET @p_catId='" + cat + "',@p_subCatid='" + subCat +
	 * "',@p_policyId='" + policyId + "'," + "@p_assetList='" + assetList +
	 * "',@p_assetemp='" + assetemp + "',@p_assigndate='" + assigndate + "'," +
	 * "@p_assetcat='" + assetcat + "',@p_assetGrp='" + assetGrp + "',@p_org='" +
	 * orgName + "',@p_time='" + formattedTime + "',@p_orgDiv='" + orgDivision +
	 * "',@p_userId='" + userId + "',@p_type='" + type + "';";
	 * System.out.println("value------------" + value);
	 * em.createNamedStoredProcedureQuery("asset_maintenance_routines")
	 * .setParameter("actionType", "allocatePolicy").setParameter("actionValue",
	 * value).execute(); resp.setCode("success");
	 * resp.setMessage("Data Allocated successfully"); } catch (Exception e) { try {
	 * String[] err = serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); }
	 * e.printStackTrace(); }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : allocatePolicy ends");
	 * 
	 * return response; }
	 */
	 
	public ResponseEntity<JsonResponse<List<AssetViewMasterRestModel>>> allocatePolicy(
			List<AssetViewMasterRestModel> allocatePolicy) {

		logger.info("Method : allocatePolicy starts");

		JsonResponse<List<AssetViewMasterRestModel>> resp = new JsonResponse<List<AssetViewMasterRestModel>>();
		List<AssetViewMasterRestModel> listData = new ArrayList<AssetViewMasterRestModel>();
		String values = GenerateAssetViewMaster.getAddassetPolicy(allocatePolicy);
		System.out.println(values);
		try {

			if (allocatePolicy.get(0).getAllocationId()== null || allocatePolicy.get(0).getAllocationId() == "") {
				em.createNamedStoredProcedureQuery("asset_maintenance_routines").setParameter("actionType", "allocatePolicy")
						.setParameter("actionValue", values).execute();

			}
			resp.setCode("success");
			resp.setMessage("Data Allocated successfully");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<AssetViewMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<AssetViewMasterRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : allocatePolicy ends"+response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCategoryListforAsset(String org,String orgDiv,String userId) {
		logger.info("Method : getEmployeeListforAsset starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId +"';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "getCatList").setParameter("actionValue",value).getResultList();

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


	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPriorityList(String org,String orgDiv,String userId) {
		logger.info("Method : getPriorityList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId +"';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "getPriorityList").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPriorityList ends");
		return getCollectionList;
	}


	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getEmgList(String type,String cat,String subcat, String orgName, String orgDivision) {
		logger.info("Method : getEmgList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_assetType='" + type + "',@p_assetCat='" + cat + "',@p_assetSubcat='" + subcat + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "getEmgList").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEmgList Dao ends");
		return resp;
	}



	public ResponseEntity<JsonResponse<Object>> deletePolicyAlloc(String id, String orgName, String orgDivision) {
		logger.info("Method : deletePolicyAlloc starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_allocId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("asset_maintenance_routines")
						.setParameter("actionType", "deletePolicyAlloc").setParameter("actionValue", value).execute();
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

		logger.info("Method : deletePolicyAlloc ends");
		return response;
	}


	// Search
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetMaintenanceViewSearch(String orgName, String orgDivision, String searchValue) {
		logger.info("Method : assetMaintenanceViewSearch Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_Svalue='" + searchValue + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "MaintenanceSearch").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : assetMaintenanceViewSearch Dao ends");
		return resp;

	}
	@SuppressWarnings("unchecked") 
	public JsonResponse<Object> viewAssetMaintenancePolicy(String orgName, String orgDivision,String cat,String subcat) {
		logger.info("Method : viewAssetMaintenancePolicy Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_cat='" + cat + "',@p_subCat='" + subcat + "';";
			System.out.println("value-------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "viewPolicy").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAssetMaintenancePolicy Dao ends"+resp);
		return resp;

	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getGroupListforAsset(String org,String orgDiv,String userId) {
		logger.info("Method : getGroupListforAsset starts");

		List<DropDownModel> getGroupList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId +"';";
		System.out.println("@@@@@@--------"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "getGroupListforAsset").setParameter("actionValue",value).getResultList();
			System.out.println("@@@@@@--------@@@@@@@@@@@@@@@");
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getGroupList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getGroupListforAsset ends"+getGroupList);
		return getGroupList;
	}
	
	
	public ResponseEntity<JsonResponse<Object>> closeTicketAction(String id,String operation, String orgName, String orgDivision) {
		logger.info("Method : closeTicketAction starts"+id + operation + orgName + orgDivision);

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {

				String value = "SET @p_ticketId='(" + id+ ")',@p_operation='" + operation + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("valuevaluevalue------"+value);
				em.createNamedStoredProcedureQuery("asset_maintenance_routines")
						.setParameter("actionType", "closeTicketAction").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Ticket Closed Successfully");
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

		logger.info("Method : closeTicketAction ends");

		return response;
	}
}
