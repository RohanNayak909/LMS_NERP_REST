package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateParamELManage;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.RestELManageModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ELManageDao {
	Logger logger = LoggerFactory.getLogger(ELManageDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	 EntityManager entityManager;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestELManageModel>> addEarnedLeave(RestELManageModel vitamin) {
		logger.info("Method : addEarnedLeave starts");

		JsonResponse<RestELManageModel> resp = new JsonResponse<RestELManageModel>();
		//List<RestELManageModel> listData = new ArrayList<RestELManageModel>();
		String values = GenerateParamELManage.getELManageParam(vitamin);
		logger.info("valuess to add ----"+values);
		try {

			System.out.println("values add >>>>>>>" + values);
			if (vitamin.getEarnLeaveID() == "" || vitamin.getEarnLeaveID() == null) {
				entityManager.createNamedStoredProcedureQuery("hrms_el_manage_routines")
						.setParameter("actionType", "addEL").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			}
			else {
				System.out.println("values edit >>>>>>>" + values);
				entityManager.createNamedStoredProcedureQuery("hrms_el_manage_routines")
				.setParameter("actionType", "modifyEL").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
				
			}

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}
		ResponseEntity<JsonResponse<RestELManageModel>> response = new ResponseEntity<JsonResponse<RestELManageModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addEarnedLeave ends"+response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEarnedLeave( String org, String orgDiv) {
		logger.info("Method : viewEarnedLeave Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			// String value = "SET @p_searchValue='" + id + "';";
			String value = "SET  @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("hrms_el_manage_routines")
					.setParameter("actionType", "viewEL").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewEarnedLeave Dao ends"+resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editEarnedLeave(String id, String org, String orgDiv) {
		logger.info("Method : editEarnedLeave Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			// String value = "SET @p_searchValue='" + id + "';";
			String value = "SET  @p_earnedID='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("hrms_el_manage_routines")
					.setParameter("actionType", "editEL").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editEarnedLeave Dao ends"+resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveEarnedLeave(String id, String empId, String org, String orgDiv, String userId) {
		logger.info("Method : approveEarnedLeave Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_earnedID='" +id + "',@p_empId='" + empId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
			System.out.println("values>>>>>>>" + value);
			entityManager.createNamedStoredProcedureQuery("hrms_el_manage_routines")
			.setParameter("actionType", "approveEL").setParameter("actionValue", value).execute();
			//resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Approved successfully");
			} catch (Exception e) {
				resp.setCode("unsuccess");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : approveEarnedLeave Dao ends"+resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteEarnedLeave(String id, String empId, String org, String orgDiv) {
		logger.info("Method : deleteEarnedLeave Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_earnedID='" +id + "',@p_empId='" + empId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values>>>>>>>" + value);
			entityManager.createNamedStoredProcedureQuery("hrms_el_manage_routines")
			.setParameter("actionType", "deleteEL").setParameter("actionValue", value).execute();
			//resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Deleted successfully");
			} catch (Exception e) {
				resp.setCode("unsuccess");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : deleteEarnedLeave Dao ends"+resp);
		return resp;
	}

}
