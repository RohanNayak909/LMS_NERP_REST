package nirmalya.aatithya.restmodule.master.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateEmpShiftdetails;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeGroupSchedulingModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestEmployeeGroupSchedulingDao {
	
	Logger logger = LoggerFactory.getLogger(RestEmployeeGroupSchedulingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager entityManager;


	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewGroupSchedulingData(String orgName, String orgDivision, String sec) {
		logger.info("Method : viewGroupSchedulingData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_group='" + sec + "';";
			System.err.println("view for valuess===== "+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_employee_group_scheduling")
					.setParameter("actionType", "viewGroupData").setParameter("actionValue", value).getResultList();
			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : viewGroupSchedulingData Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewGroupSchedulingAllData(String orgName, String orgDivision, String sec) {
		logger.info("Method : viewGroupSchedulingaAllData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_group='" + sec + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_employee_group_scheduling")
					.setParameter("actionType", "viewGroupAllData").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : viewGroupSchedulingaAllData Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAllEmp(String orgName, String orgDivision) {
		logger.info("Method : viewAllEmp Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrms_employee_group_scheduling")
					.setParameter("actionType", "viewAllEmployee").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : viewAllEmp Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addRevisedGroup(
			List<RestEmployeeGroupSchedulingModel> model) {
		logger.info("Method : Rest addRevisedGroup  Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {
				String values = GenerateEmpShiftdetails.getAddRevisedGroupParam(model);	
				System.err.println("addRevisedGroup======="+values);
				
				em.createNamedStoredProcedureQuery("hrms_employee_group_scheduling")
						.setParameter("actionType", "addRevisedGroup").setParameter("actionValue", values).execute();	
				
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			} catch (Exception e) {
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
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
		logger.info("Method : addRevisedGroup  Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveGroup(String slNo, String flag, String orgName, String orgDivision,
			String userId) {
		logger.info("Method : approveGroup Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		if("APPROVE".equals(flag)) {
			
			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId + "',@p_slNo='" + slNo + "';";
				System.out.println("APPROVE   value>>"+value);
				em.createNamedStoredProcedureQuery("hrms_employee_group_scheduling")
						.setParameter("actionType", "approveGroup").setParameter("actionValue", value).execute();
				
				resp.setCode("success");
				resp.setMessage("Data Approved Successfully");
			} catch (Exception e) {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setMessage(err[1]);
				resp.setCode("failed");
				e.printStackTrace();
			}
		}else {
			System.out.println("Inside Delete");
			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId + "',@p_slNo='" + slNo + "';";
				System.out.println("Delete   value>>"+value);
				em.createNamedStoredProcedureQuery("hrms_employee_group_scheduling")
						.setParameter("actionType", "deleteGroup").setParameter("actionValue", value).execute();
				
				resp.setCode("success");
				resp.setMessage("Data Deleted Successfully");
			} catch (Exception e) {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setMessage(err[1]);
				resp.setCode("failed");
				e.printStackTrace();
			}
		}
		
		logger.info("Method : approveGroup Dao ends");
		return resp;
	}

}
