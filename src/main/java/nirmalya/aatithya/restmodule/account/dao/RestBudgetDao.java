
package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.http.HttpStatus;

import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.account.model.RestBudgetModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateManageBudgetParameter;

import org.springframework.http.HttpHeaders;

@Repository
public class RestBudgetDao {
	
	Logger logger = LoggerFactory.getLogger(RestBudgetDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	

	/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> addBudget(RestBudgetModel restBudgetModel) {

		logger.info("Method in Dao: addBudget starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		//resp.setMessage("");
		//resp.setCode("");
			try {
				//String values ="";// 
				String values = GenerateManageBudgetParameter.getAddBudgetParam(restBudgetModel);
				System.out.println(values);
				if (restBudgetModel.getBudgetId() =="" || restBudgetModel.getBudgetId() ==null) {
			
					em.createNamedStoredProcedureQuery("account_budget_routines").setParameter("actionType", "addBudget")
							.setParameter("actionValue", values).execute();
					
				} else {
					em.createNamedStoredProcedureQuery("account_budget_routines").setParameter("actionType", "modifyBudget")
							.setParameter("actionValue", values).execute();
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

		logger.info("Method in Dao: addBudget ends");

		return response;
	}
	
	//restViewBudgetDetails
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestBudgetModel>>> restViewBudgetDetails() {
		logger.info("Method : restViewBudgetDetails starts");
		
		System.out.println("rest bank Account-------------2222222222");
		List<RestBudgetModel> respList = new ArrayList<RestBudgetModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_budget_routines").setParameter("actionType", "getBudgetDetails")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				
				
				RestBudgetModel restPayroll = new RestBudgetModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10],
						m[11], m[12], m[13], m[14], m[15].toString());
				respList.add(restPayroll); 

			}

			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestBudgetModel>> resp = new JsonResponse<List<RestBudgetModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestBudgetModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : restViewBudgetDetails ends");
		
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}
	
	
	//deleteBudgetDetails
	
	public ResponseEntity<JsonResponse<Object>> deleteBudgetDetails(String id) {
		logger.info("Method : deleteBudgetDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ID...."+id);
		if (validity)
			try {
				
				String value = "SET  @p_budgetId='(" + id + ")';";
				
				System.out.println("value------------------"+value);
				

				em.createNamedStoredProcedureQuery("account_budget_routines")
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

		logger.info("Method :  deleteBudgetDetails ends");
		System.out.println("DELETE" + response);
		return response;
	}
	
	//editBudgetInfo
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestBudgetModel>>>editBudgetInfo(String id) {
		logger.info("Method : editAccountInfo starts");

		JsonResponse<List<RestBudgetModel>> resp = new JsonResponse<List<RestBudgetModel>>();
		List<RestBudgetModel> rs = new ArrayList<RestBudgetModel>();

		try {

			String value = "SET @p_budgetId='" + id +"';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_budget_routines")
					.setParameter("actionType", "editBudgetInfo").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf"+x);
           
			for (Object[] m : x) {
				
				RestBudgetModel restPayroll = new RestBudgetModel(m[0], m[1], m[2], m[3],	m[4], m[5], m[6],
						m[7], m[8], m[9], m[10],m[11],m[12],m[13],m[14],m[15].toString());
				rs.add(restPayroll);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestBudgetModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : editBranchInfo ends");
		
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		
		System.out.println(response);
		return response;
	}
	
	

}

