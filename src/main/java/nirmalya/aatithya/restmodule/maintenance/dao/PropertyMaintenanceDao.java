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
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class PropertyMaintenanceDao {
	Logger logger = LoggerFactory.getLogger(PropertyMaintenanceDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;


	@SuppressWarnings("unchecked") 
	public JsonResponse<Object> viewPropertyMaintenancePolicy(String orgName, String orgDivision,String userId) {
		logger.info("Method : viewPropertyMaintenancePolicy Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_mstr_policy_routines")
					.setParameter("actionType", "viewPropertyPolicy").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPropertyMaintenancePolicy Dao ends"+resp);
		return resp;

	}
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPropertyMaintenance(String orgName, String orgDivision) {
		logger.info("Method : viewPropertyMaintenance Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "viewAllotedProperty").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPropertyMaintenance Dao ends");

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
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,HttpStatus.CREATED);
		logger.info("Method : deletePolicyAlloc ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getGroupListforProperty(String org,String orgDiv,String userId) {
		logger.info("Method : getGroupListforProperty starts");

		List<DropDownModel> getGroupList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId +"';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "getPGroupList").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getGroupList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getGroupListforProperty ends");
		return getGroupList;
	}
	
	
	public ResponseEntity<JsonResponse<Object>> allocatePropertyPolicy(String policyId,
			String assetList,String assetemp,String assigndate,String assetcat,String assetGrp, String orgName, String orgDivision, String userId, String type) {
		logger.info("Method : allocatePropertyPolicy starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		Date currentTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        String formattedTime = sdf.format(currentTime);
		if (validity)
			try {

				String value = "SET @p_policyId='" + policyId+ "',"
						+ "@p_assetList='" + assetList+ "',@p_assetemp='" + assetemp+ "',@p_assigndate='" + assigndate+ "',"
						+ "@p_assetcat='" + assetcat+ "',@p_assetGrp='" + assetGrp+ "',@p_org='" + orgName + "',@p_time='" + formattedTime + "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId+ "',@p_type='" + type + "';";
				System.out.println("valuevaluevalue------"+value);
				em.createNamedStoredProcedureQuery("asset_maintenance_routines")
						.setParameter("actionType", "allocatePolicy").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Allocated successfully");
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
		logger.info("Method : allocatePropertyPolicy ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGroupListforPropertyAPI(String org, String orgDiv,
			String userId) {
		logger.info("Method : getGroupListforPropertyAPI starts");

		List<DropDownModel> getEmployeeList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "getPGroupList").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : getGroupListforPropertyAPI ends");
		return response;
	}
}
