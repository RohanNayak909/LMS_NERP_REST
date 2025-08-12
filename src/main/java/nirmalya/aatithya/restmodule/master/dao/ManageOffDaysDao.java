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
import nirmalya.aatithya.restmodule.common.utils.GenerateParamOffDays;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.RestOFFManageModel;
import nirmalya.aatithya.restmodule.master.model.RestOFFManageModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ManageOffDaysDao {
	Logger logger = LoggerFactory.getLogger(ManageOffDaysDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	 EntityManager entityManager;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestOFFManageModel>> addOffDays(RestOFFManageModel offDay) {
		logger.info("Method : addEarnedLeave starts");

		JsonResponse<RestOFFManageModel> resp = new JsonResponse<RestOFFManageModel>();
		//List<RestOFFManageModel> listData = new ArrayList<RestOFFManageModel>();
		String values = GenerateParamOffDays.getOffDaysParam(offDay);
		logger.info("valuess to add ----"+values);
		try {

			System.out.println("values add >>>>>>>" + values);
			if (offDay.getOffId() == "" || offDay.getOffId() == null) {
				entityManager.createNamedStoredProcedureQuery("hrms_off_days_routines")
						.setParameter("actionType", "addOffDays").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			}
			else {
				System.out.println("values edit >>>>>>>" + values);
				entityManager.createNamedStoredProcedureQuery("hrms_off_days_routines")
				.setParameter("actionType", "modifyOffDays").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
				
			}

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}
		ResponseEntity<JsonResponse<RestOFFManageModel>> response = new ResponseEntity<JsonResponse<RestOFFManageModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addEarnedLeave ends"+response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewOffDays( String org, String orgDiv) {
		logger.info("Method : viewOffDays Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			// String value = "SET @p_searchValue='" + id + "';";
			String value = "SET  @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("hrms_off_days_routines")
					.setParameter("actionType", "viewOffDays").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewOffDays Dao ends"+resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editOffDays(String id, String org, String orgDiv) {
		logger.info("Method : editOffDays Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			// String value = "SET @p_searchValue='" + id + "';";
			String value = "SET  @p_offID='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("hrms_off_days_routines")
					.setParameter("actionType", "editOffDays").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editOffDays Dao ends"+resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveOffDays(String id, String org, String orgDiv, String userId) {
		logger.info("Method : approveOffDays Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_offID='" +id +  "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
			System.out.println("values>>>>>>>" + value);
			entityManager.createNamedStoredProcedureQuery("hrms_off_days_routines")
			.setParameter("actionType", "approveOffDays").setParameter("actionValue", value).execute();
			//resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Approved successfully");
			} catch (Exception e) {
				resp.setCode("unsuccess");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : approveOffDays Dao ends"+resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteOffDays(String id, String org, String orgDiv) {
		logger.info("Method : deleteOffDays Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_offID='" +id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values>>>>>>>" + value);
			entityManager.createNamedStoredProcedureQuery("hrms_off_days_routines")
			.setParameter("actionType", "deleteOffDays").setParameter("actionValue", value).execute();
				//resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Deleted successfully");
			} catch (Exception e) {
				resp.setCode("unsuccess");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : deleteOffDays Dao ends"+resp);
		return resp;
	}

}
