package nirmalya.aatithya.restmodule.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateEstimateBudgetParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.model.BudgetEstimationRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestExtraExpenseModel;

@Repository
public class RestJobCardDao {

	Logger logger = LoggerFactory.getLogger(RestJobCardDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	
//
	public ResponseEntity<JsonResponse<Object>> jobcardAddDao(BudgetEstimationRestModel employee) {

		logger.info("Method in Dao: jobcardAddDao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		// resp.setMessage("");
		// resp.setCode("");
		try {
			// String values ="";
			String values = GenerateEstimateBudgetParam.getAddBudgetParam(employee);
			System.out.println("Data in Daooooo===================>>>>>>>>>" + values);
			if (employee.getBudgetId() == "" || employee.getBudgetId() == null) {

				em.createNamedStoredProcedureQuery("jobcard_estimation_routines").setParameter("actionType", "addbudget")
						.setParameter("actionValue", values).execute();
			} else {
				System.out.println("Modify---------------------------------------budget" + values);
				em.createNamedStoredProcedureQuery("jobcard_estimation_routines")
						.setParameter("actionType", "modifybudget").setParameter("actionValue", values).execute();
			}
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		if (resp.getMessage() == null) {
			resp.setMessage("Saved successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method in Dao: jobcardAddDao ends");

		return response;
	}

	// view budget

	@SuppressWarnings("unchecked")

	public JsonResponse<Object> jobcardViewDao(String userid, String org,
			String div,String id) {

		logger.info("Method : jobcardViewDao Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "' ,@p_pid='" + id
					+ "' ;";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("jobcard_estimation_routines")
					.setParameter("actionType", "viewProjectBudget").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : jobcardViewDao Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	
	
	// edit estimateBudget
	@SuppressWarnings("unchecked")

	public JsonResponse<Object> jobcardEditDao(String userid, String org,
			String div,String id) {

		logger.info("Method : jobcardEditDao Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "' ,@p_id='" + id
					+ "' ;";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("jobcard_estimation_routines")
					.setParameter("actionType", "editbudget").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : jobcardEditDao Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	// delete estimateBudget

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> jobcardDeleteDao(String id) {
		logger.info("Method : jobcardDeleteDao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ID...." + id);
		if (validity)
			try {

				String value = "SET @p_budgetId='" + id + "';";

				System.out.println("value------------------" + value);
				em.createNamedStoredProcedureQuery("jobcard_estimation_routines")
						.setParameter("actionType", "deleteBudget").setParameter("actionValue", value).execute();

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

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method :  jobcardDeleteDao ends");
		System.out.println("DELETE" + response);
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> estimateSink(String id) {
		logger.info("Method : estimateSink Dao starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_prjId='" + id + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("jobcard_estimation_routines")
						.setParameter("actionType", "estimateSink").setParameter("actionValue", value).execute();

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

		logger.info("Method : estimateSink Dao ends"+response);
		return response;
	}	

	
	
}
