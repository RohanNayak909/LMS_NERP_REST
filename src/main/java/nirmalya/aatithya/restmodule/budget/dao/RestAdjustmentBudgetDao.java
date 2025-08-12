package nirmalya.aatithya.restmodule.budget.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import nirmalya.aatithya.restmodule.budget.model.RestAssignDeptBudgetModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


	@RestController
	@RequestMapping(value = { "budget" })
	public class RestAdjustmentBudgetDao {
		Logger logger = LoggerFactory.getLogger(RestAdjustmentBudgetDao.class);
		@Autowired
		EntityManager em;
		@Autowired
		ServerDao serverDao;

		
		//updateIncomeBdgtAmnt
		
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> updateIncomeBdgtAmnt(String deptId,String groupId,String financialYear,
				String oldBudgetAmnt,String updatedBudgetAmnt,String createdBy,String orgName,String orgDivision) {
			logger.info("Method : updateIncomeBdgtAmnt Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_deptId='" + deptId + "',@p_groupId='" + groupId + "',@p_financialYear='" + financialYear +
						"',@p_oldBudgetAmnt='" + oldBudgetAmnt + "',@p_updatedBudgetAmnt='" + updatedBudgetAmnt + 
						"',@p_createdBy='" + createdBy + "',@p_orgName='" + orgName + 
						"',@p_orgDivision='" + orgDivision +  "';";
						
				System.out.println("values****************************" + value);
				em.createNamedStoredProcedureQuery("assign_dept_budget")
						.setParameter("actionType", "updtIncmAdjst").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Budget Added Successfully");
				// resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : updateIncomeBdgtAmnt Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		//updateIncomeActualAmnt
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> updateIncomeActualAmnt(String deptId,String groupId,String financialYear,
				String oldBudgetAmnt,String updatedBudgetAmnt,String createdBy,String orgName,String  orgDivision) {
			logger.info("Method : updateIncomeActualAmnt Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_deptId='" + deptId + "',@p_groupId='" + groupId + "',@p_financialYear='" + financialYear +
						"',@p_oldBudgetAmnt='" + oldBudgetAmnt + "',@p_updatedBudgetAmnt='" + updatedBudgetAmnt + 
						"',@p_createdBy='" + createdBy + "',@p_orgName='" + orgName + 
						"',@p_orgDivision='" + orgDivision + "';";
						
				System.out.println("values****************************" + value);
				em.createNamedStoredProcedureQuery("assign_dept_budget")
						.setParameter("actionType", "updtIncmActual").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Budget Added Successfully");
				// resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : updateIncomeActualAmnt Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		//updateExpenseActualAmnt
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> updateExpenseActualAmnt(String deptId,String groupId,String financialYear,
				String oldBudgetAmnt,String updatedBudgetAmnt,String createdBy,String orgName,String  orgDivision) {
			logger.info("Method : updateExpenseActualAmnt Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_deptId='" + deptId + "',@p_groupId='" + groupId + "',@p_financialYear='" + financialYear +
						"',@p_oldBudgetAmnt='" + oldBudgetAmnt + "',@p_updatedBudgetAmnt='" + updatedBudgetAmnt + 
						"',@p_createdBy='" + createdBy + "',@p_orgName='" + orgName + 
						"',@p_orgDivision='" + orgDivision + "';";
						
				System.out.println("values****************************" + value);
				em.createNamedStoredProcedureQuery("assign_dept_budget")
						.setParameter("actionType", "updtExpnsActual").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Budget Added Successfully");
				// resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : updateExpenseActualAmnt Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		//updateExpenseBdgtAmnt
		
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> updateExpenseBdgtAmnt(String deptId,String groupId,String financialYear,
				String oldBudgetAmnt,String updatedBudgetAmnt, String createdBy, String orgName, String orgDivision) {
			logger.info("Method : updateExpenseBdgtAmnt Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
		
			try {
				String value = "SET @p_deptId='" + deptId + "',@p_groupId='" + groupId + "',@p_financialYear='" + financialYear +
						"',@p_oldBudgetAmnt='" + oldBudgetAmnt + "',@p_updatedBudgetAmnt='" + updatedBudgetAmnt +
						"',@p_createdBy='" + createdBy + "',@p_orgName='" + orgName +
						"',@p_orgDivision='" + orgDivision + "';";
						
				System.out.println("values****************************" + value);
				em.createNamedStoredProcedureQuery("assign_dept_budget")
						.setParameter("actionType", "updtExpnBudgt").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Budget Added Successfully");
				// resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : updateExpenseBdgtAmnt Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		//adjustmentIncomeHistory
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> adjustmentBudgetIncomeHistory(String deptId, String groupId, String financialYear) {
			logger.info("Method : adjustmentBudgetIncomeHistory starts");
			List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

		
			String value = "SET @p_deptId='" + deptId + "',@p_groupId='" + groupId + "',@p_financialYear='" + financialYear +
					"';";
			
			 System.out.println("value==============================================>>>"+value);

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
						.setParameter("actionType", "bdgtIncmHstry").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {

					RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1],m[2],m[3],m[4],m[5],m[6].toString(),m[7].toString(),m[8].toString());
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
			logger.info("Method : adjustmentBudgetIncomeHistory ends");
			return response;

		}
		
		
		
		//adjustmentActualIncomeHistory
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> adjustmentActualIncomeHistory(String deptId, String groupId, String financialYear) {
			logger.info("Method : adjustmentActualIncomeHistory starts");
			List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

		
			String value = "SET @p_deptId='" + deptId + "',@p_groupId='" + groupId + "',@p_financialYear='" + financialYear +
					"';";
			
			 System.out.println("value==============================================>>>"+value);

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
						.setParameter("actionType", "actualIncmHstry").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {

					RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1],m[2],m[3],m[4],m[5],m[6].toString(),m[7].toString(),m[8].toString());
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
			logger.info("Method : adjustmentActualIncomeHistory ends");
			return response;

		}
		
		//adjustmentActualExpenseHistory
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> adjustmentActualExpenseHistory(String deptId, String groupId, String financialYear) {
			logger.info("Method : adjustmentActualExpenseHistory starts");
			List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

		
			String value = "SET @p_deptId='" + deptId + "',@p_groupId='" + groupId + "',@p_financialYear='" + financialYear +
					"';";
			
			 System.out.println("value==============================================>>>"+value);

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
						.setParameter("actionType", "actualExpnsHstry").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {

					RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1],m[2],m[3],m[4],m[5],m[6].toString(),m[7].toString(),m[8].toString());
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
			logger.info("Method : adjustmentActualExpenseHistory ends");
			return response;

		}
		
		//adjustmentExpenseHistory
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> adjustmentBudgetExpenseHistory(String deptId, String groupId, String financialYear) {
			logger.info("Method : adjustmentBudgetExpenseHistory starts");
			List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

		
			String value = "SET @p_deptId='" + deptId + "',@p_groupId='" + groupId + "',@p_financialYear='" + financialYear +
					"';";
			
			 System.out.println("value==============================================>>>"+value);

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
						.setParameter("actionType", "budgetExpHstry").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {

					RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1],m[2],m[3],m[4],m[5],m[6].toString(),m[7].toString(),m[8].toString());
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
			logger.info("Method : adjustmentBudgetExpenseHistory ends");
			return response;

		}
}



