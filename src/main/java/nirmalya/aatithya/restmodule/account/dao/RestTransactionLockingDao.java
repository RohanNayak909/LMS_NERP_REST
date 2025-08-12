
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
import nirmalya.aatithya.restmodule.account.model.RestTransactionLockingModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateManageTransactionParameter;

import org.springframework.http.HttpHeaders;

@Repository
public class RestTransactionLockingDao {
	
	Logger logger = LoggerFactory.getLogger(RestTransactionLockingDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	

	/*
	 * for add new lock sales
	 */
	public ResponseEntity<JsonResponse<Object>> addTransactionSaleLock(RestTransactionLockingModel restTransactionLockingModel) {

		logger.info("Method in Dao: addTransactionSaleLock starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		//resp.setMessage("");
		//resp.setCode("");
			try {
				//String values ="";// 
				String values = GenerateManageTransactionParameter.getAddTransactionParam(restTransactionLockingModel);
				System.out.println(values);
			
					em.createNamedStoredProcedureQuery("account_trans_routines").setParameter("actionType", "updateLockSales")
							.setParameter("actionValue", values).execute();
				
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

		logger.info("Method in Dao: addTransactionSaleLock ends");

		return response;
	}
	
	//addTransactionPurchaseLock
	
	/*
	 * for add new purchase sales
	 */
	public ResponseEntity<JsonResponse<Object>> addTransactionPurchaseLock(RestTransactionLockingModel restTransactionLockingModel) {

		logger.info("Method in Dao: addTransactionPurchaseLock starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		//resp.setMessage("");
		//resp.setCode("");
			try {
				//String values ="";// 
				String values = GenerateManageTransactionParameter.getAddTransactionParam(restTransactionLockingModel);
				System.out.println(values);
			
					em.createNamedStoredProcedureQuery("account_trans_routines").setParameter("actionType", "updateLockPurchase")
							.setParameter("actionValue", values).execute();
				
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

		logger.info("Method in Dao: addTransactionPurchaseLock ends");

		return response;
	}
	//addTransactionBankingLock
	
		/*
		 * for add new lock banking
		 */
		public ResponseEntity<JsonResponse<Object>> addTransactionBankingLock(RestTransactionLockingModel restTransactionLockingModel) {

			logger.info("Method in Dao: addTransactionBankingLock starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();
			//resp.setMessage("");
			//resp.setCode("");
				try {
					//String values ="";// 
					String values = GenerateManageTransactionParameter.getAddTransactionParam(restTransactionLockingModel);
					System.out.println(values);
				
						em.createNamedStoredProcedureQuery("account_trans_routines").setParameter("actionType", "updateLockBanking")
								.setParameter("actionValue", values).execute();
					
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

			logger.info("Method in Dao: addTransactionBankingLock ends");

			return response;
		}
		
		//addTransactionAccountLock
		
		/*
		 * for add new lock accountant
		 */
		public ResponseEntity<JsonResponse<Object>> addTransactionAccountLock(RestTransactionLockingModel restTransactionLockingModel) {

			logger.info("Method in Dao: addTransactionAccountLock starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();
			//resp.setMessage("");
			//resp.setCode("");
				try {
					//String values ="";// 
					String values = GenerateManageTransactionParameter.getAddTransactionParam(restTransactionLockingModel);
					System.out.println(values);
				
						em.createNamedStoredProcedureQuery("account_trans_routines").setParameter("actionType", "updateLockAccount")
								.setParameter("actionValue", values).execute();
					
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

			logger.info("Method in Dao: addTransactionAccountLock ends");

			return response;
		}
	
	//addTransactionSaleUnlock
	
	/*
	 * for add new unlock sales
	 */
	public ResponseEntity<JsonResponse<Object>> addTransactionSaleUnlock(RestTransactionLockingModel restTransactionLockingModel) {

		logger.info("Method in Dao: addTransactionSaleLock starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		//resp.setMessage("");
		//resp.setCode("");
			try {
				//String values ="";// 
				String values = GenerateManageTransactionParameter.getAddTransactionParam(restTransactionLockingModel);
				System.out.println(values);
			
					em.createNamedStoredProcedureQuery("account_trans_routines").setParameter("actionType", "updateUnlockSales")
							.setParameter("actionValue", values).execute();
				
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

		logger.info("Method in Dao: addTransactionSaleUnlock ends");

		return response;
	}
	//addTransactionPurchaseUnlock
	
	/*
	 * for add new unlock purchase
	 */
	public ResponseEntity<JsonResponse<Object>> addTransactionPurchaseUnlock(RestTransactionLockingModel restTransactionLockingModel) {

		logger.info("Method in Dao: addTransactionPurchaseUnlock starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		//resp.setMessage("");
		//resp.setCode("");
			try {
				//String values ="";// 
				String values = GenerateManageTransactionParameter.getAddTransactionParam(restTransactionLockingModel);
				System.out.println(values);
			
					em.createNamedStoredProcedureQuery("account_trans_routines").setParameter("actionType", "updateUnlockPurchase")
							.setParameter("actionValue", values).execute();
				
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

		logger.info("Method in Dao: addTransactionPurchaseUnlock ends");

		return response;
	}
	
	//addTransactionBankingUnlock
	

	/*
	 * for add new unlock sales
	 */
	public ResponseEntity<JsonResponse<Object>> addTransactionBankingUnlock(RestTransactionLockingModel restTransactionLockingModel) {

		logger.info("Method in Dao: addTransactionBankingUnlock starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		//resp.setMessage("");
		//resp.setCode("");
			try {
				//String values ="";// 
				String values = GenerateManageTransactionParameter.getAddTransactionParam(restTransactionLockingModel);
				System.out.println(values);
			
					em.createNamedStoredProcedureQuery("account_trans_routines").setParameter("actionType", "updateUnlockBanking")
							.setParameter("actionValue", values).execute();
				
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

		logger.info("Method in Dao: addTransactionBankingUnlock ends");

		return response;
	}
	
	//addTransactionAccountUnlock
	
	/*
	 * for add new unlock accountant
	 */
	public ResponseEntity<JsonResponse<Object>> addTransactionAccountUnlock(RestTransactionLockingModel restTransactionLockingModel) {

		logger.info("Method in Dao: addTransactionAccountUnlock starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		//resp.setMessage("");
		//resp.setCode("");
			try {
				//String values ="";// 
				String values = GenerateManageTransactionParameter.getAddTransactionParam(restTransactionLockingModel);
				System.out.println(values);
			
					em.createNamedStoredProcedureQuery("account_trans_routines").setParameter("actionType", "updateUnlockAccount")
							.setParameter("actionValue", values).execute();
				
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

		logger.info("Method in Dao: addTransactionAccountUnlock ends");

		return response;
	}
	
	//restViewBudgetDetails
	
	/*@SuppressWarnings("unchecked")
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

	}*/
	
	
	//deleteBudgetDetails
	
/*	public ResponseEntity<JsonResponse<Object>> deleteBudgetDetails(String id) {
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
	}*/
	
	//getTransactionData
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>>getTransactionData(String id) {
		logger.info("Method : getTransactionData starts");

		JsonResponse<List<RestTransactionLockingModel>> resp = new JsonResponse<List<RestTransactionLockingModel>>();
		List<RestTransactionLockingModel> rs = new ArrayList<RestTransactionLockingModel>();

		try {

			String value = "SET @p_budgetId='" + id +"';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_trans_routines")
					.setParameter("actionType", "getTransactionData").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf"+x);
           
			for (Object[] m : x) {
				
				String salesLockDate = null;
				if (m[2] != null) {
					salesLockDate = m[2].toString();
				}
				
				String purchaseLockDate = null;
				if (m[6] != null) {
					purchaseLockDate = m[6].toString();
				}
				
				String bankingLockDate = null;
				if (m[10] != null) {
					bankingLockDate = m[10].toString();
				}
				
				String AccountLockDate = null;
				if (m[14] != null) {
					AccountLockDate = m[14].toString();
				}
				
				RestTransactionLockingModel restPayroll = new RestTransactionLockingModel(m[0].toString(), m[1], salesLockDate, m[3], m[4], m[5],
						purchaseLockDate, m[7], m[8], m[9], bankingLockDate, m[11], m[12], m[13], AccountLockDate, m[15], m[16], m[17], m[18].toString());
				rs.add(restPayroll);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>> response = new ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : getTransactionData ends");
		
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		
		System.out.println(response);
		return response;
	}
	
	
	//getTransactionSalesData
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>>getTransactionSalesData(String id) {
		logger.info("Method : getTransactionSalesData starts");

		JsonResponse<List<RestTransactionLockingModel>> resp = new JsonResponse<List<RestTransactionLockingModel>>();
		List<RestTransactionLockingModel> rs = new ArrayList<RestTransactionLockingModel>();

		try {

			String value = "SET @p_id='" + id +"';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_trans_routines")
					.setParameter("actionType", "getTransactionSale").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf"+x);
           
			for (Object[] m : x) {
				
				String salesLockDate = null;
				if (m[0] != null) {
					salesLockDate = m[0].toString();
				}
								
				RestTransactionLockingModel restPayroll = new RestTransactionLockingModel(null,null, salesLockDate,  m[1], null,null,
						null,null,null,null, null, null, null, null, null, null, null, null, m[2].toString());
				rs.add(restPayroll);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>> response = new ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : getTransactionSalesData ends");
		
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		
		System.out.println(response);
		return response;
	}
	
	
	//getTransactionPurchaseData
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>>getTransactionPurchaseData(String id) {
		logger.info("Method : getTransactionPurchaseData starts");

		JsonResponse<List<RestTransactionLockingModel>> resp = new JsonResponse<List<RestTransactionLockingModel>>();
		List<RestTransactionLockingModel> rs = new ArrayList<RestTransactionLockingModel>();

		try {

			String value = "SET @p_id='" + id +"';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_trans_routines")
					.setParameter("actionType", "getTransactionPurchase").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf"+x);
           
			for (Object[] m : x) {
				
				String purchaseLockDate = null;
				if (m[0] != null) {
					purchaseLockDate = m[0].toString();
				}
								
				RestTransactionLockingModel restPayroll = new RestTransactionLockingModel(null,null, null, null, null,null,
						purchaseLockDate,  m[1],null,null, null, null, null, null, null, null, null, null, m[2].toString());
				rs.add(restPayroll);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>> response = new ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : getTransactionPurchaseData ends");
		
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		
		System.out.println(response);
		return response;
	}
	
	
	//getTransactionBankingData
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>>getTransactionBankingData(String id) {
		logger.info("Method : getTransactionBankingData starts");

		JsonResponse<List<RestTransactionLockingModel>> resp = new JsonResponse<List<RestTransactionLockingModel>>();
		List<RestTransactionLockingModel> rs = new ArrayList<RestTransactionLockingModel>();

		try {

			String value = "SET @p_id='" + id +"';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_trans_routines")
					.setParameter("actionType", "getTransactionBanking").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf"+x);
           
			for (Object[] m : x) {
				
				String bankingLockDate = null;
				if (m[0] != null) {
					bankingLockDate = m[0].toString();
				}
								
				RestTransactionLockingModel restPayroll = new RestTransactionLockingModel(null,null, null, null, null,null,
						null,  null,null,null, bankingLockDate, m[1], null, null, null, null, null, null, m[2].toString());
				rs.add(restPayroll);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>> response = new ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : getTransactionBankingData ends");
		
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		
		System.out.println(response);
		return response;
	}
	
	
	//getTransactionAccountData
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>>getTransactionAccountData(String id) {
		logger.info("Method : getTransactionAccountData starts");

		JsonResponse<List<RestTransactionLockingModel>> resp = new JsonResponse<List<RestTransactionLockingModel>>();
		List<RestTransactionLockingModel> rs = new ArrayList<RestTransactionLockingModel>();

		try {

			String value = "SET @p_id='" + id +"';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_trans_routines")
					.setParameter("actionType", "getTransactionAccount").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf"+x);
           
			for (Object[] m : x) {
				
				String AccountLockDate = null;
				if (m[0] != null) {
					AccountLockDate = m[0].toString();
				}
								
				RestTransactionLockingModel restPayroll = new RestTransactionLockingModel(null,null, null, null, null,null,
						null,  null,null,null, null, null, null, null, AccountLockDate, m[1], null, null, m[2].toString());
				rs.add(restPayroll);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>> response = new ResponseEntity<JsonResponse<List<RestTransactionLockingModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : getTransactionAccountData ends");
		
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

