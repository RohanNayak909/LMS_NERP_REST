
package nirmalya.aatithya.restmodule.budget.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.http.HttpStatus;

import nirmalya.aatithya.restmodule.budget.model.RestAssignDeptBudgetModel;
import nirmalya.aatithya.restmodule.budget.model.RestMonitoringBudgetModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@Repository
public class RestMonitoringBudgetDao {

	Logger logger = LoggerFactory.getLogger(RestMonitoringBudgetDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
		//budgetMonitoringIncomeQuarterly
	
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestMonitoringBudgetModel>>> budgetMonitoringIncomeQuarterly(String dept,String fyId,String orgName,String orgDivision) {
			logger.info("Method : budgetMonitoringIncomeQuarterly starts");
			List<RestMonitoringBudgetModel> respList = new ArrayList<RestMonitoringBudgetModel>();

			//String value = "SET @p_deptId='" + dept + "';";
			// System.out.println("===>>>"+value);
			String value = "SET @p_deptId='" + dept + "',@p_fyId='" + fyId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";
			

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("monitoring_budget")
						.setParameter("actionType", "monitoringIncome").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					
					if (m[24] == null || m[24] == "") {
						m[24] = "";
					}

					RestMonitoringBudgetModel restPayroll = new RestMonitoringBudgetModel(m[0], m[1],
							m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11],
							m[12], m[13], m[14], m[15], m[16], m[17],m[18],m[19],m[20],
							m[21], m[22], m[23], m[24], m[25], m[26]);
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<RestMonitoringBudgetModel>> resp = new JsonResponse<List<RestMonitoringBudgetModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestMonitoringBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestMonitoringBudgetModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);

			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : budgetMonitoringIncomeQuarterly ends");
			return response;

		}
		
		//budgetMonitoringExpenseQuarterly

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestMonitoringBudgetModel>>> budgetMonitoringExpenseQuarterly(String dept,String fyId,String orgName,String orgDivision) {
			logger.info("Method : budgetMonitoringExpenseQuarterly starts");
			List<RestMonitoringBudgetModel> respList = new ArrayList<RestMonitoringBudgetModel>();

			//String value = "SET @p_deptId='" + dept + "';";
			// System.out.println("===>>>"+value);
			String value = "SET @p_deptId='" + dept + "',@p_fyId='" + fyId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";
			

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("monitoring_budget")
						.setParameter("actionType", "monitoringExpense").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					
					if (m[24] == null || m[24] == "") {
						m[24] = "";
					}

					RestMonitoringBudgetModel restPayroll = new RestMonitoringBudgetModel(m[0], m[1],
							m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11],
							m[12], m[13], m[14], m[15], m[16], m[17],m[18],m[19],m[20],
							m[21], m[22], m[23], m[24], m[25], m[26]);
					
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<RestMonitoringBudgetModel>> resp = new JsonResponse<List<RestMonitoringBudgetModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestMonitoringBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestMonitoringBudgetModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);

			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : budgetMonitoringExpenseQuarterly ends");
			return response;

		}
		
		//departmentDataInMonitoring
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> departmentDataInMonitoring() {
			logger.info("Method : departmentDataInMonitoring starts");
			List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("monitoring_budget")
						.setParameter("actionType", "deptData").setParameter("actionValue", "").getResultList();
				for (Object[] m : x) {

					RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1]);
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);

			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : departmentDataInMonitoring ends");
			return response;

		}
		
		//departmentDataByIdMonitoring
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> departmentDataByIdMonitoring(String dept) {
			logger.info("Method : departmentDataByIdMonitoring starts");
			List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

			String value = "SET @p_deptId='" + dept + "';";
			// System.out.println("===>>>"+value);

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("monitoring_budget")
						.setParameter("actionType", "deptDataById").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {

					RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1]);
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);

			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : departmentDataByIdMonitoring ends");
			return response;

		}

		//deptByAllDataIncomExpenseMonitoring
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> deptByAllDataIncomExpenseMonitoring(String dept,String fyId,String orgName,String orgDivision) {
			logger.info("Method : deptByAllDataIncomExpenseMonitoring starts");
			List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

			//String value = "SET @p_deptId='" + dept + "';";
			// System.out.println("===>>>"+value);
			String value = "SET @p_deptId='" + dept + "',@p_fyId='" + fyId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";
			
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("monitoring_budget")
						.setParameter("actionType", "deptByAllIncmExpData").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {

					RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0].toString(), m[1].toString(),
							m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(), m[6].toString(),
							m[7].toString(), m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString());
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);

			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : deptByAllDataIncomExpenseMonitoring ends");
			return response;

		}


}
