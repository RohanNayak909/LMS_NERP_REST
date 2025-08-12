package nirmalya.aatithya.restmodule.maintenance.dao;

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
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAllotedPolicyProgress;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.maintenance.model.AllotedMaintenanceRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AllotedMaintenanceDao {
	Logger logger = LoggerFactory.getLogger(AllotedMaintenanceDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAssetMaintenance(String orgName, String orgDivision,String userId) {
		logger.info("Method : viewAssetMaintenance Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "viewAlloted").setParameter("actionValue", value).getResultList();
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
	public JsonResponse<Object> getPolList(String aid, String pid, String orgName, String orgDivision, String shift) {
		logger.info("Method : getPolList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String Date = DateFormatter.getStringDate(pid);
		try {
			String value = "SET @p_allotId='" + aid + "',@p_date='" + Date + "',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDivision + "',@p_shift='"+ shift+ "';";
			System.out.println("VALUE::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "getPolList").setParameter("actionValue", value).getResultList();
			Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getPolList Dao ends"+resp);
		return resp;
	}
 
	public ResponseEntity<JsonResponse<List<AllotedMaintenanceRestModel>>> addPolicyProgress(
			List<AllotedMaintenanceRestModel> av) {
		logger.info("Method : addPolicyProgress dao starts");
		JsonResponse<List<AllotedMaintenanceRestModel>> resp = new JsonResponse<List<AllotedMaintenanceRestModel>>();

		String value = GenerateAllotedPolicyProgress.getPolicyProgressList(av);
		try {

			if (av.get(0).getAllocid() != null && av.get(0).getAllocid() != "") {

				em.createNamedStoredProcedureQuery("asset_maintenance_routines")
						.setParameter("actionType", "modifyPolicyProgress").setParameter("actionValue", value)
						.execute();

				resp.setCode("success");
				resp.setMessage("Result uploaded successfully");

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

		ResponseEntity<JsonResponse<List<AllotedMaintenanceRestModel>>> response = new ResponseEntity<JsonResponse<List<AllotedMaintenanceRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addPolicyProgress dao ends");
		return response;

	}

	// Search

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assetAllotedViewSearch(String orgName, String orgDivision, String searchValue) {
		logger.info("Method : assetAllotedViewSearch Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_Svalue='" + searchValue
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "AllotedSearch").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : assetAllotedViewSearch Dao ends");
		return resp;

	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewTicket(String orgName, String orgDivision, String allotedId) {
		logger.info("Method : viewTicket Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_allotedId='" + allotedId+"';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "viewTicket").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewTicket Dao ends"+resp);

		return resp;

	}
	//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> showTotalAsset(String cat,String scat, String orgName, String orgDivision) {
		logger.info("Method : showTotalAsset Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_cat='" + cat+ "',@p_scat='" + scat+ "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("VALUES::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "showTotalAsset").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetching Interupted");
		}
		logger.info("Method : showTotalAsset Dao ends");
		return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPolListForUpload(String aid, String pid, String orgName, String orgDivision, String shift) {
		logger.info("Method : getPolListForUpload Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String Date = DateFormatter.getStringDate(pid);
		try {
			String value = "SET @p_allotId='" + aid + "',@p_date='" + Date + "',@p_org='" + orgName + "',@p_orgDiv='"+ orgDivision+ "',@p_shift='"+ shift + "';";
			System.out.println("VALUE::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "getPolList").setParameter("actionValue", value).getResultList();
			Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getPolListForUpload Dao ends"+resp);
		return resp;
	}
	
//
	@SuppressWarnings("unchecked")
	public List<DropDownModel> assetListapi(String cat, String scat,String orgName,String orgDivision,String userId) {
		logger.info("Method : assetListapi starts");

		List<DropDownModel> getAssetList = new ArrayList<DropDownModel>();
		String value = "SET @p_cat='" + cat + "',@p_scat='" + scat+ "',@p_orgName='" + orgName+ "',@p_orgDivision='" + orgDivision+ "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "assetListapi").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAssetList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : assetListapi ends");
		return getAssetList;
	}
//
	@SuppressWarnings("unchecked")
	public List<DropDownModel> groupListapi(String cat, String scat,String orgName,String orgDivision,String userId) {
		logger.info("Method : groupListapi starts");

		List<DropDownModel> groupListapi = new ArrayList<DropDownModel>();
		String value = "SET @p_cat='" + cat + "',@p_scat='" + scat+ "',@p_orgName='" + orgName+ "',@p_orgDivision='" + orgDivision+ "',@p_userId='" + userId + "';";
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "groupListapi").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				groupListapi.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : groupListapi ends");
		return groupListapi;
	}
}
