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
import nirmalya.aatithya.restmodule.common.utils.GenerateAppraisalKeyFactorParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateNoiseMonitorReportParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.grc.model.noiseMonitorReportModel;
import nirmalya.aatithya.restmodule.master.model.AppraisalKeyFactorRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AppraisalKeyFactorDao {

	Logger logger = LoggerFactory.getLogger(AppraisalKeyFactorDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAppraisalData(String orgName, String orgDivision) {
		logger.info("Method : getAppraisalData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("master_appraisalkeyfactorroutines")
					.setParameter("actionType", "getAppraisalData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAppraisalData Dao ends" + resp);
		return resp;

	}
	
	public ResponseEntity<JsonResponse<List<AppraisalKeyFactorRestModel>>> appraisalKeyfactorAdd(List<AppraisalKeyFactorRestModel> av) {
		logger.info("Method : activityAdd dao starts");
		JsonResponse<List<AppraisalKeyFactorRestModel>> resp = new JsonResponse<List<AppraisalKeyFactorRestModel>>();

		String value = GenerateAppraisalKeyFactorParameter.getAppraisalKeyFactorsParameters(av);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + value);
		try {

			if (av.get(0).getCategoryId() != null && av.get(0).getCategoryId() != "") {

				em.createNamedStoredProcedureQuery("master_appraisalkeyfactorroutines")
						.setParameter("actionType", "modifyAppraisalData").setParameter("actionValue", value).execute();

				resp.setCode("200");
				resp.setMessage("Data modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("master_appraisalkeyfactorroutines")
						.setParameter("actionType", "appraisalAdd").setParameter("actionValue", value).execute();

				resp.setCode("201");
				resp.setMessage("Data saved successfully");

			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
				resp.setCode(err[0]);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<AppraisalKeyFactorRestModel>>> response = new ResponseEntity<JsonResponse<List<AppraisalKeyFactorRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : activityAdd dao ends");
		return response;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAppraisalData(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewAppraisalData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("master_appraisalkeyfactorroutines")
					.setParameter("actionType", "viewAppraisalData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAppraisalData Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editAppraisalData(String orgName, String orgDivision, String id) {
		logger.info("Method : editAppraisalData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_categoryid='" + id + "';";
			logger.info("value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("master_appraisalkeyfactorroutines")
					.setParameter("actionType", "editAppraisalData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editAppraisalData Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveAppraisal(String orgName, String orgDivision, String id) {
		logger.info("Method : approveAppraisal Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_categoryid='" + id + "';";
			logger.info("value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("master_appraisalkeyfactorroutines")
					.setParameter("actionType", "approveAppraisal").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Approve successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : approveAppraisal Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAssignEmployeeList(String orgName, String orgDivision,String id) {
		logger.info("Method : getAssignEmployeeList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_staffId='" + id + "';";
			
			logger.info("value-->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("master_appraisalkeyfactorroutines")
					.setParameter("actionType", "assignEmployeeList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAssignEmployeeList Dao ends" + resp);
		return resp;

	}
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> employeeAssign(String orgName, String orgDivision,String categoryId,String staffId,String userId) {
		logger.info("Method : employeeAssign Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_category='" + categoryId + "',@p_staffId='" + staffId + "',@p_userId='" + userId + "';";
			
			logger.info("value--@@>" + value);
			/*
			 * List<Object[]> x =
			 * em.createNamedStoredProcedureQuery("master_appraisalkeyfactorroutines")
			 * .setParameter("actionType", "employeeAssign").setParameter("actionValue",
			 * value) .getResultList();
			 */
			em.createNamedStoredProcedureQuery("master_appraisalkeyfactorroutines")
			.setParameter("actionType", "employeeAssign").setParameter("actionValue", value).execute();
			
		
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : employeeAssign Dao ends" + resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assignEmployeeView(String orgName, String orgDivision,String categoryId) {
		logger.info("Method : assignEmployeeView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + categoryId + "';";
			System.out.println("assignEmployeeView value================= "+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("master_appraisalkeyfactorroutines")
					.setParameter("actionType", "assignViewData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : assignEmployeeView Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> apprisalDelete(String orgName, String orgDivision, String id) {
		logger.info("Method : apprisalDelete Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_categoryid='" + id + "';";
			logger.info("value" + value);
			 em.createNamedStoredProcedureQuery("master_appraisalkeyfactorroutines")
	          .setParameter("actionType", "apprisalDelete")
	          .setParameter("actionValue", value)
	          .execute(); 
		        resp.setCode("success");
		        resp.setMessage("Appraisal Deleted Successfully");
		    } catch (Exception e) {
		        e.printStackTrace();
		        resp.setCode("error");
		        resp.setMessage("Error occurred while deleting");
		    }
		logger.info("Method : apprisalDelete Dao ends" + resp);
		return resp;

	}
}
