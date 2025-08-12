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
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.AppraisalKeyFactorRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;
@Repository
public class RestManagerAppraisalDao {
	
	Logger logger = LoggerFactory.getLogger(RestManagerAppraisalDao.class);
	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewManagerAppraisal(String orgName, String orgDivision,String userid) {
		logger.info("Method : viewManagerAppraisal Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_empId='" + userid + "';";
			logger.info("value-->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("master_appraisalkeyfactorroutines")
					.setParameter("actionType", "viewManagerDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewManagerAppraisal Dao ends" + resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editManagerAppraisalData(String orgName, String orgDivision, String id,String assignid) {
		logger.info("Method : editManagerAppraisalData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_empId='" + id + "',@p_assignId='" + assignid + "';";
			logger.info("value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("master_appraisalkeyfactorroutines")
					.setParameter("actionType", "editManagerAppraisalData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editManagerAppraisalData Dao ends" + resp);
		return resp;

	}
	
	
	public ResponseEntity<JsonResponse<List<AppraisalKeyFactorRestModel>>> managerAppraisalAdd(List<AppraisalKeyFactorRestModel> av) {
		logger.info("Method : managerAppraisalAdd dao starts");
		JsonResponse<List<AppraisalKeyFactorRestModel>> resp = new JsonResponse<List<AppraisalKeyFactorRestModel>>();

		String value = GenerateAppraisalKeyFactorParameter.getManagerAppraisalDetails(av);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + value);
		try {

			
			em.createNamedStoredProcedureQuery("master_appraisalkeyfactorroutines")
			.setParameter("actionType", "modifySelfAppraisalData__").setParameter("actionValue", value).execute();

			resp.setCode("200");
			resp.setMessage("Data Modified successfully");
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

		ResponseEntity<JsonResponse<List<AppraisalKeyFactorRestModel>>> response = new ResponseEntity<JsonResponse<List<AppraisalKeyFactorRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : managerAppraisalAdd dao ends");
		return response;

	}
}
