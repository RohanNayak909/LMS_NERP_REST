package nirmalya.aatithya.restmodule.budget.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@Repository
public class RestDepartmentBudgetDao {
	
	Logger logger = LoggerFactory.getLogger(RestAssigeDeptDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	// viewQc
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewBudget(String id,String orgName, String orgDivision) {
			logger.info("Method : viewBudget Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				
				System.out.println("values****************************" + value);
				
				List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
						.setParameter("actionType", "viewBudget").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewBudget Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> addBudget(String dept_id,String group_id,String financialYear,
				String budgetAmount,String incmRemak) {
			logger.info("Method : addBudgetAmount Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_dept_id='" + dept_id + "',@p_group_id='" + group_id + "',@p_financialYear='" + financialYear +
						"',@p_budgetAmount='" + budgetAmount + "',@p_incmRemak='" + incmRemak + "';";
						
				System.out.println("values****************************" + value);
				em.createNamedStoredProcedureQuery("assign_dept_budget")
						.setParameter("actionType", "updateBudgetAmnt").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Budget Added Successfully");
				// resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : addBudgetAmount Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> addActualBudget(String dept_id,String group_id,String financialYear,
				String actualBudgetAmount,String actualIncmRemak) {
			logger.info("Method : addActualBudget Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_dept_id='" + dept_id + "',@p_group_id='" + group_id + "',@p_financialYear='" + financialYear +
						"',@p_actualBudgetAmount='" + actualBudgetAmount + "',@p_actualIncmRemak='" + actualIncmRemak + "';";
						
				System.out.println("values****************************" + value);
				em.createNamedStoredProcedureQuery("assign_dept_budget")
						.setParameter("actionType", "updateActualBudgetAmnt").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Budget Added Successfully");
				// resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : addActualBudget Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		// viewQc
				@SuppressWarnings("unchecked")
				public JsonResponse<Object> viewExpense(String id,String orgName, String orgDivision) {
					logger.info("Method : viewBudget Dao starts");

					JsonResponse<Object> resp = new JsonResponse<Object>();

					try {
						String value = "SET @p_id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
						
						System.out.println("values****************************" + value);
						
						List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
								.setParameter("actionType", "viewExpenseBudget").setParameter("actionValue", value).getResultList();
						resp.setBody(x);
					} catch (Exception e) {
						e.printStackTrace();
					}
					logger.info("Method : viewBudget Dao ends");
					System.out.println("resp****************************" + resp);
					return resp;

				}
				
				@SuppressWarnings("unchecked")
				public JsonResponse<Object> addExpenseAmt(String dept_id,String group_id,String financialYear,
						String budgetAmount,String incmRemak) {
					logger.info("Method : addBudgetAmount Dao starts");
					JsonResponse<Object> resp = new JsonResponse<Object>();
					try {
						String value = "SET @p_dept_id='" + dept_id + "',@p_group_id='" + group_id + "',@p_financialYear='" + financialYear +
								"',@p_budgetAmount='" + budgetAmount + "',@p_incmRemak='" + incmRemak + "';";
								
						System.out.println("values****************************" + value);
						em.createNamedStoredProcedureQuery("assign_dept_budget")
								.setParameter("actionType", "updateExpenseAmnt").setParameter("actionValue", value).execute();
						resp.setCode("success");
						resp.setMessage("Budget Added Successfully");
						// resp.setBody(x);
					} catch (Exception e) {
						e.printStackTrace();
					}
					logger.info("Method : addBudgetAmount Dao ends");
					System.out.println("resp****************************" + resp);
					return resp;

				}
				@SuppressWarnings("unchecked")
				public JsonResponse<Object> addActualExpnsBudget(String dept_id,String group_id,String financialYear,
						String actualBudgetAmount,String actualExpnsRemak) {
					logger.info("Method : addActualExpnsBudget Dao starts");
					JsonResponse<Object> resp = new JsonResponse<Object>();
					try {
						String value = "SET @p_dept_id='" + dept_id + "',@p_group_id='" + group_id + "',@p_financialYear='" + financialYear +
								"',@p_actualBudgetAmount='" + actualBudgetAmount + "',@p_actualExpnsRemak='" + actualExpnsRemak + "';";
								
						System.out.println("values****************************" + value);
						em.createNamedStoredProcedureQuery("assign_dept_budget")
								.setParameter("actionType", "updateActualExpnsBudgetAmnt").setParameter("actionValue", value).execute();
						resp.setCode("success");
						resp.setMessage("Budget Added Successfully");
						// resp.setBody(x);
					} catch (Exception e) {
						e.printStackTrace();
					}
					logger.info("Method : addActualExpnsBudget Dao ends");
					System.out.println("resp****************************" + resp);
					return resp;

				}
}
