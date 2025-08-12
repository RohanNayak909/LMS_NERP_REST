package nirmalya.aatithya.restmodule.employee.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateParamAttandanceByDeptData;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.RestEmployeeCCRModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AttendanceByDepartmentDao {
	Logger logger = LoggerFactory.getLogger(AttendanceByDepartmentDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	 EntityManager entityManager;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	public JsonResponse<Object> viewAttandance(String org, String orgDiv) {
		logger.info("Method : viewAttandance Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			// String value = "SET @p_searchValue='" + id + "';";
			String value = "SET  @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------"+value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("hrms_attandance_by_dept_routines")
					.setParameter("actionType", "viewAttandance").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAttandance Dao ends"+resp);
		return resp;
	}
	
	
	public ResponseEntity<JsonResponse<Map<String, String>>> addEmployeeReview(Map<String, String> vitamin) {
		logger.info("Method : addEmployeeReview starts");

		JsonResponse<Map<String, String>> resp = new JsonResponse<Map<String, String>>();
		//List<RestEmployeeCCRModel> listData = new ArrayList<RestEmployeeCCRModel>();
		String values = GenerateParamAttandanceByDeptData.getAttandanceByDeptParam(vitamin);
		try {
			logger.info("Method : addEmployeeReview values---------"+values);

			System.out.println("values add >>>>>>>" + values);/*
			if (vitamin.getReviewId() == "" || vitamin.getReviewId() == null) {*/
				entityManager.createNamedStoredProcedureQuery("hrms_attandance_by_dept_routines")
						.setParameter("actionType", "addData").setParameter("actionValue", values).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
				
				resp.setCode("Success");
				resp.setMessage("CCR Added Successfully");
//			}
//			else {
//				System.out.println("values edit >>>>>>>" + values);
//				entityManager.createNamedStoredProcedureQuery("hrms_ccr_routines")
//				.setParameter("actionType", "modifyReview").setParameter("actionValue", values).execute();
//				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);
				
//			}

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}
		ResponseEntity<JsonResponse<Map<String, String>>> response = new ResponseEntity<JsonResponse<Map<String, String>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addEmployeeReview ends"+response);
		return response;
	}

}
