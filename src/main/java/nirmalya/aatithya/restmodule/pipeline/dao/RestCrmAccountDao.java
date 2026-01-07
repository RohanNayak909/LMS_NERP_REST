package nirmalya.aatithya.restmodule.pipeline.dao;

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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAccountParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmAccountsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;

@Repository
public class RestCrmAccountDao {

	Logger logger = LoggerFactory.getLogger(RestCrmAccountDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	/**
	 * for department list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAccountTypeList() {
		
		logger.info("Method : getAccountTypeList starts");
		
		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmAccounts_routines")
					.setParameter("actionType", "getAccountTypelist")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAccountTypeList ends"+employmentList);
		
		return employmentList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAccountNameList(String userId,
			String org,String orgDiv) {
		
		logger.info("Method : getAccountNameList starts");
		
		String value = "SET @p_userId='" + userId + "',"
				+ "@org='" + org + "',@orgDiv='" + orgDiv + "';";
		
		System.out.println("getAccountNameList============> "+value);
		
		List<DropDownModel> accountList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmAccounts_routines")
					.setParameter("actionType", "getAccountNameList")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				accountList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAccountNameList ends"+accountList);
		
		return accountList;
	}
	
	
	
	/**
	 * for department list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOwnershipList() {
		
		logger.info("Method : getOwnershipList starts");
		
		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmAccounts_routines")
					.setParameter("actionType", "getOwnershiplist")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getOwnershipList ends"+employmentList);
		
		return employmentList;
	}
	
	
	/**
	 * DAO Function to add addAccount
	 *
	 */

	public JsonResponse<Object> addAccount(RestCrmAccountsModel account) {
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values = GenerateAccountParameter.getAddAccountParam(account);
				logger.info("Values Account----------------------"+values);
				if (account.getAccountId() == null || account.getAccountId() == "") {
					logger.info("add Account=============");

					em.createNamedStoredProcedureQuery("crmAccounts_routines").setParameter("actionType", "addAccount")
							.setParameter("actionValue", values).execute();

				} else {
					logger.info("update Account=============");
					em.createNamedStoredProcedureQuery("crmAccounts_routines").setParameter("actionType", "modifyAccount")
							.setParameter("actionValue", values).execute();

				}
			} catch

			(Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					logger.info(err.toString());
					resp.setCode(err[0]);
					resp.setMessage(err[1]);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		logger.info("@@@@@" + resp);

		logger.info("Method : addAccount ends");
		return resp;
	}
	
	///restViewAccountdetails
	
	
////view
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> viewAccountSearchDetails(RestCrmAccountsModel accountDetails) {

		logger.info("Method in Dao: viewAccountSearchDetails starts");
		
		
        JsonResponse<Object> resp = new JsonResponse<Object>();
		  resp.setMessage(""); resp.setCode("");
		 
		//JsonResponse<Object> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmAccountsModel> rs = new ArrayList<RestCrmAccountsModel>();
			try {
				String values = GenerateAccountParameter.getAddAccountParam(accountDetails);
				logger.info(values);
				
				String actionType = null;
				String actionValue = null;
				
				if(values != null && values != "") {
					actionType = "getDetailsBySearch";
					actionValue = values;
				} else {
					actionType = "getAccountDetails";
					actionValue = "";
				}

				logger.info("Action Type===="+actionType);
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmAccounts_routines")
						.setParameter("actionType", actionType).setParameter("actionValue", actionValue)
						.getResultList();
				logger.info("asdfasdf"+x);
	           
				for (Object[] m : x) {
					logger.info("VIEWWWWWWWWWWWW");
					RestCrmAccountsModel restPayroll = new RestCrmAccountsModel(m[0], m[1], m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],
							m[11],m[12],m[13],m[14],m[15],m[16],m[17],m[18],m[19],m[20], m[21],
							m[22],m[23],m[24],m[25],m[26],m[27],m[28],m[29],m[30].toString(),m[31],m[32],m[33],null);
					rs.add(restPayroll);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
        resp.setBody(rs);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
			logger.info("Method : viewAccountSearchDetails ends");
			return response;
	}
	

////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmAccountsModel>>> restViewAccountdetails(String pageno,String userId,
			String orgName,String orgDivision) {
		logger.info("Method : view Account Data starts");
		List<RestCrmAccountsModel> respList = new ArrayList<RestCrmAccountsModel>();
		JsonResponse<List<RestCrmAccountsModel>> resp = new JsonResponse<List<RestCrmAccountsModel>>();
		
	
		String value = "SET @p_pageno='" + pageno + "',@p_userId='" + userId + "',"
				+ "@org='" + orgName + "',@orgDiv='" + orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmAccounts_routines").setParameter("actionType", "getAccountDetails")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
	

				RestCrmAccountsModel restPayroll = new RestCrmAccountsModel(m[0], m[1], m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],
						m[11],m[12],m[13],m[14],m[15],m[16],m[17],m[18],m[19],m[20], m[21],
						m[22],m[23],m[24],m[25],m[26],m[27],m[28],m[29],m[30].toString(),m[31],m[32],m[33],m[34].toString(),m[35].toString());
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);
			resp.setMessage("Account Added Sucessfully");
			resp.setCode("Success");

		} catch (Exception e) {

			e.printStackTrace();

		}

		/*
		 * JsonResponse<List<RestCrmAccountsModel>> resp = new
		 * JsonResponse<List<RestCrmAccountsModel>>();
		 */
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCrmAccountsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmAccountsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : view Account Data  ends");

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}
	
	//////////////////
	
	/*
	 * delete
	 */

	public ResponseEntity<JsonResponse<Object>> deleteAccountDetails(String id, String org, String orgDiv) {
		logger.info("Method : deleteAccountDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		logger.info("ID...."+id);
		if (validity)
			try {

				String value = "SET @p_accountId='" + id  + "', @org='" + org + "', @orgDiv='" + orgDiv + "';";
				logger.info(value);

				em.createNamedStoredProcedureQuery("crmAccounts_routines")
						.setParameter("actionType", "deleteAccountDetails").setParameter("actionValue", value).execute();

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

		logger.info("Method :  deleteAccountDetails ends");
		logger.info("DELETE" + response);
		return response;
	}
	
	
	///editAccountInfo   
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmAccountsModel>>>editAccountInfo(String id, String org, String orgDiv) {
		logger.info("Method : editAccountInfo starts");

		JsonResponse<List<RestCrmAccountsModel>> resp = new JsonResponse<List<RestCrmAccountsModel>>();
		List<RestCrmAccountsModel> rs = new ArrayList<RestCrmAccountsModel>();

		try {

			String value = "SET @p_accountId='" + id + "', @org='" + org + "', @orgDiv='" + orgDiv +"';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmAccounts_routines")
					.setParameter("actionType", "editAccountInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf"+x);
           
			for (Object[] m : x) {
				RestCrmAccountsModel assignSkill = new RestCrmAccountsModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],
						m[11],m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], 
						m[25], m[26],m[27],m[28],m[29],null,null,null,m[30],null);
				
				rs.add(assignSkill);
				
			}
			resp.setBody(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmAccountsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmAccountsModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : editAccountInfo ends");
		return response;
	}
	
	
	//viewAccountDetailsPage
	

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmAccountsModel>>>viewAccountDetailsPage(String id, String org, String orgDiv) {
		logger.info("Method : viewAccountDetailsPage daoo starts");

		JsonResponse<List<RestCrmAccountsModel>> resp = new JsonResponse<List<RestCrmAccountsModel>>();
		List<RestCrmAccountsModel> rs = new ArrayList<RestCrmAccountsModel>();

		try {

			String value = "SET @p_accountId='" + id + "', @org='" + org + "', @orgDiv='" + orgDiv +"';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmAccounts_routines")
					.setParameter("actionType", "viewAcntDetails").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf"+x);
           
			for (Object[] m : x) {
				RestCrmAccountsModel deal = new RestCrmAccountsModel(m[0], m[1], m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],
						m[11],m[12],m[13],m[14],m[15],m[16],m[17],m[18],m[19],m[20], m[21],
						m[22],m[23],m[24],m[25],m[26],m[27],m[28],m[29],m[30],m[31],m[32],m[33]);
				rs.add(deal);
				
			}
			System.out.println("Printed Account Data"+rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmAccountsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmAccountsModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : viewAccountDetailsPage dao ends");
		return response;
	}
	

}
