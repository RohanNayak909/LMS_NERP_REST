package nirmalya.aatithya.restmodule.employee.dao;

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
import nirmalya.aatithya.restmodule.common.CommonUsed;
import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateParamCCRData;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateMicroTestingParameter;
import nirmalya.aatithya.restmodule.employee.controller.ManageEmployeeEducationRestModel;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeRestModel;
import nirmalya.aatithya.restmodule.employee.model.RestEmployeeCCRModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.gatepass.dao.GatePassDao;
import nirmalya.aatithya.restmodule.qa.model.RestVitAModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestEmployeeCCRDao {
	Logger logger = LoggerFactory.getLogger(RestEmployeeCCRDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	 EntityManager entityManager;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEmpolyee( String org, String orgDiv) {
		logger.info("Method : viewEmpolyee Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			// String value = "SET @p_searchValue='" + id + "';";
			String value = "SET  @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("hrms_ccr_routines")
					.setParameter("actionType", "viewEmpolyee").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewEmpolyee Dao ends"+resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editEmpolyee(String id, String org, String orgDiv) {
		logger.info("Method : editEmpolyee Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			// String value = "SET @p_searchValue='" + id + "';";
			String value = "SET @p_id='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("hrms_ccr_routines")
					.setParameter("actionType", "editEmpolyee").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editEmpolyee Dao ends"+resp);
		return resp;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getEmployeeList(String id, String orgName, String orgDivision) {
		logger.info("Method : getEmployeeList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_id='" +id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info(value);
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("hrms_ccr_routines")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}
			resp.setBody(nameList);
			if (nameList.size() > 0) {
				Util.setJsonResponse(resp, nameList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, nameList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		logger.info("Method : getQualifyEduList ends"+resp);
		return resp;
	}
	
	public ResponseEntity<JsonResponse<RestEmployeeCCRModel>> addEmployeeReview(RestEmployeeCCRModel vitamin) {
		logger.info("Method : addEmployeeReview starts");

		JsonResponse<RestEmployeeCCRModel> resp = new JsonResponse<RestEmployeeCCRModel>();
		//List<RestEmployeeCCRModel> listData = new ArrayList<RestEmployeeCCRModel>();
		String values = GenerateParamCCRData.getCCRParam(vitamin);
		try {

			if (vitamin.getReviewId() == "" || vitamin.getReviewId() == null) {
				System.out.println("values add >>>>>>>" + values);
				entityManager.createNamedStoredProcedureQuery("hrms_ccr_routines")
						.setParameter("actionType", "addReview").setParameter("actionValue", values).execute();
				//Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
				
				resp.setMessage("CCR Saved Successfully");
				resp.setCode("Success");
				}
			else {
				System.out.println("values edit >>>>>>>" + values);
				entityManager.createNamedStoredProcedureQuery("hrms_ccr_routines")
				.setParameter("actionType", "modifyReview").setParameter("actionValue", values).execute();
				//Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
				
				resp.setMessage("CCR Updated Successfully");
				resp.setCode("Success");
				
			}

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}
		ResponseEntity<JsonResponse<RestEmployeeCCRModel>> response = new ResponseEntity<JsonResponse<RestEmployeeCCRModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addEmployeeReview ends"+response);
		return response;
	}

	public JsonResponse<Object> editEmpolyeeReview(String id, String empId, String org, String orgDiv) {
		logger.info("Method : editEmpolyeeReview Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			// String value = "SET @p_searchValue='" + id + "';";
			String value = "SET @p_reviewId='" +id + "',@p_empId='" + empId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("hrms_ccr_routines")
					.setParameter("actionType", "editEmpolyeeReview").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editEmpolyeeReview Dao ends"+resp);
		return resp;
	}

	public JsonResponse<Object> deleteEmpolyeeReview(String id, String empId, String org, String orgDiv) {
		logger.info("Method : deleteEmpolyeeReview Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_reviewId='" +id + "',@p_empId='" + empId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values>>>>>>>" + value);
			entityManager.createNamedStoredProcedureQuery("hrms_ccr_routines")
			.setParameter("actionType", "deleteEmpolyeeReview").setParameter("actionValue", value).execute();
			//resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Deleted successfully");
			} catch (Exception e) {
				resp.setCode("unsuccess");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : deleteEmpolyeeReview Dao ends"+resp);
		return resp;
	}

	public JsonResponse<Object> rejectEmpolyeeReview(String id, String empId, String org, String orgDiv) {
		logger.info("Method : rejectEmpolyeeReview Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_reviewId='" +id + "',@p_empId='" + empId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values>>>>>>>" + value);
			entityManager.createNamedStoredProcedureQuery("hrms_ccr_routines")
			.setParameter("actionType", "rejectEmpolyeeReview").setParameter("actionValue", value).execute();
			//resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Rejected successfully");
			} catch (Exception e) {
				resp.setCode("unsuccess");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : rejectEmpolyeeReview Dao ends"+resp);
		return resp;
	}
	public JsonResponse<Object> approveEmpolyeeReview(String id, String empId, String org, String orgDiv) {
		logger.info("Method : approveEmpolyeeReview Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_reviewId='" +id + "',@p_empId='" + empId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values>>>>>>>" + value);
			entityManager.createNamedStoredProcedureQuery("hrms_ccr_routines")
			.setParameter("actionType", "approveEmpolyeeReview").setParameter("actionValue", value).execute();
			//resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Rejected successfully");
			} catch (Exception e) {
				resp.setCode("unsuccess");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : approveEmpolyeeReview Dao ends"+resp);
		return resp;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getTypeList( String orgName, String orgDivision) {
		logger.info("Method : getTypeList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info(value);
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("hrms_ccr_routines")
					.setParameter("actionType", "getTypeList").setParameter("actionValue", value )
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				nameList.add(dropDownModel);
			}
			resp.setBody(nameList);
			if (nameList.size() > 0) {
				Util.setJsonResponse(resp, nameList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, nameList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		logger.info("Method : getQualifyEduList ends"+resp);
		return resp;
	}
	
}
