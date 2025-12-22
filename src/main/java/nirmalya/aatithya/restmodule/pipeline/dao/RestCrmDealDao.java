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
import nirmalya.aatithya.restmodule.common.utils.GenerateCallParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateDealParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;

/**
 * @author Nirmalya Labs
 *
 */
@Repository
public class RestCrmDealDao {
	Logger logger = LoggerFactory.getLogger(RestCrmDealDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	// getDealTypeList

	/**
	 * for getOwnerList
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDealTypeList() {

		logger.info("Method : getDealTypeList starts");

		List<DropDownModel> dealtypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal")
					.setParameter("actionType", "getDealTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				dealtypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDealTypeList ends" + dealtypeList);

		return dealtypeList;
	}

	// getDealStageListWONew

	/*
	 * @SuppressWarnings("unchecked") public List<DropDownModel>
	 * getDealStageListWONew() {
	 * 
	 * logger.info("Method : getDealStageListWONew starts");
	 * 
	 * List<DropDownModel> dealtypeList = new ArrayList<DropDownModel>();
	 * 
	 * try { List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal")
	 * .setParameter("actionType", "getDealStageListWONew")
	 * .setParameter("actionValue", "") .getResultList();
	 * 
	 * for (Object[] m : x) { DropDownModel dropDownModel = new DropDownModel(m[0],
	 * m[1]); dealtypeList.add(dropDownModel); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * logger.info("dealtypeList----------------"+dealtypeList);
	 * 
	 * logger.info("Method : getDealStageListWONew  ends");
	 * 
	 * return dealtypeList; }
	 */

	/**
	 * for getStageList
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDealStageList() {

		logger.info("Method : getDealStageList starts");

		List<DropDownModel> stageList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal").setParameter("actionType", "getStageList")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stageList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDealStageList ends" + stageList);

		return stageList;
	}

	// getCampaignList

	/**
	 * for getCampaignList
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDealCampaignList() {

		logger.info("Method : getDealCampaignList starts");

		List<DropDownModel> campaignList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal")
					.setParameter("actionType", "getCampaignList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				campaignList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDealCampaignList ends" + campaignList);

		return campaignList;
	}

	// addDeal

	/**
	 * DAO Function to add pipeline
	 *
	 */

	public JsonResponse<Object> addDeal(RestDealModel deal) {
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values = GenerateDealParameter.getAddDealParam(deal);
				if (deal.getDealId() == null || deal.getDealId() == "") {

					em.createNamedStoredProcedureQuery("crm_deal").setParameter("actionType", "addDeal")
							.setParameter("actionValue", values).execute();
					resp.setCode("Success");

				} else {
					Object x = em.createNamedStoredProcedureQuery("crm_deal").setParameter("actionType", "modifyDeal")
							.setParameter("actionValue", values).getSingleResult();
					System.out.println("PKJ ------------------->>>>>>>>>>>>>>>>>>>> "+x.toString());
					if(!x.toString().equals("200")){
						resp.setCode(HttpStatus.BAD_REQUEST.toString());
						resp.setMessage(x.toString());
					}else {
						resp.setCode("Success");
						resp.setMessage("Deal Updated Successfully.");
					}

				}
			} catch

			(Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		logger.info("@@@@@" + resp);

		logger.info("Method : addDeal ends");
		return resp;
	}

////view

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> viewDealSearchDetails(RestDealModel deal) {

		logger.info("Method in Dao: viewDealSearchDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		// JsonResponse<Object> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestDealModel> rs = new ArrayList<RestDealModel>();
		try {
			String values = GenerateDealParameter.getAddDealParam(deal);
			logger.info(values);

			String actionType = null;
			String actionValue = null;

			if (values != null && values != "") {
				actionType = "getDealDetailsBySearch";
				actionValue = values;
			} else {
				actionType = "getDealDetails";
				actionValue = "";
			}

			logger.info("Action Type====" + actionType);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal").setParameter("actionType", actionType)
					.setParameter("actionValue", actionValue).getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {
				logger.info("VIEWWWWWWWWWWWW");
				RestDealModel restPayroll = new RestDealModel(m[0], m[1], m[2], m[3], m[4].toString(), m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15].toString(), null, null, null, null, m[16],
						m[17]);

				logger.info("VIEWWDATA" + restPayroll);

				rs.add(restPayroll);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : viewDealSearchDetails ends");
		return response;
	}

	//////// restViewDealDetails
/*
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestDealModel>>> restViewDealDetails() {
		logger.info("Method : restViewDealDetails starts");
		List<RestDealModel> respList = new ArrayList<RestDealModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal")
					.setParameter("actionType", "getDealDetails").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestDealModel restPayroll = new RestDealModel(m[0], m[1], m[2], m[3], m[4].toString(), m[5], m[6], m[7],
						m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15].toString(), null, null, null, null, m[16],
						m[17]);
				respList.add(restPayroll);

			}

			logger.info("VIEW DETAILS FOR DEALS-------" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestDealModel>> resp = new JsonResponse<List<RestDealModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestDealModel>>> response = new ResponseEntity<JsonResponse<List<RestDealModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : restViewDealDetails ends");

		logger.info("view response" + respList);
		return response;

	} */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse restViewDealDetails(String pageno,String userId,String orgName,String orgDivision) {
		logger.info("Method : restViewDealDetails starts");
		JsonResponse  jsonResp = new JsonResponse();	
		
		String value = "SET @p_pageno='" + pageno + "',@p_userId='" + userId + "',"
				+ "@org='" + orgName + "',@orgDiv='" + orgDivision + "';";
		try {
		
			/* String value = ""; */
		List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal")
				.setParameter("actionType", "getDealDetails").setParameter("actionValue", value).getResultList();
		
		jsonResp.setBody(x.get(0));	
		System.out.print(value+"@@@@@@@@@@@@@@@@@@@");
		}catch(Exception e){
			try {
				String[] err = serverDao.errorProcedureCall(e);
				jsonResp.setCode(err[0]);
				jsonResp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		logger.info("Method : restViewDealDetails ends");
		return jsonResp;
	}

	/*
	 * delete deleteDealDetails
	 */

	public ResponseEntity<JsonResponse<Object>> deleteDealDetails(String id, String org, String orgDiv) {
		logger.info("Method : deleteDealDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		logger.info("ID...." + id);
		if (validity)
			try {

				String value = "SET @p_dealId='" + id + "', @org='" + org + "', @orgDiv='" + orgDiv + "';";
				logger.info(value);

				em.createNamedStoredProcedureQuery("crm_deal").setParameter("actionType", "deleteDealById")
						.setParameter("actionValue", value).execute();

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

		logger.info("Method :  deleteDealDetails ends");
		logger.info("DELETE" + response);
		return response;
	}

	// editDealInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestDealModel>>> editDealInfo(String id, String org, String orgDiv) {
		logger.info("Method : editDealInfo starts");

		JsonResponse<List<RestDealModel>> resp = new JsonResponse<List<RestDealModel>>();
		List<RestDealModel> rs = new ArrayList<RestDealModel>();

		try {

			String value = "SET @p_dealId='" + id + "', @org='" + org + "', @orgDiv='" + orgDiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal").setParameter("actionType", "editDealInfo")
					.setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {
				RestDealModel deal = new RestDealModel(m[0], m[1], m[2], m[3], m[4].toString(), m[5], m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], m[15].toString(), m[16], m[17], m[18], null, null,
						null);
				rs.add(deal);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestDealModel>>> response = new ResponseEntity<JsonResponse<List<RestDealModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editDealInfo ends");
		return response;
	}

	/// viewDealDetailsPage

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestDealModel>>> viewDealDetailsPage(String id, String org, String orgDiv) {
		logger.info("Method : viewDealDetailsPage starts");

		JsonResponse<List<RestDealModel>> resp = new JsonResponse<List<RestDealModel>>();
		List<RestDealModel> rs = new ArrayList<RestDealModel>();

		try {

			String value = "SET @p_dealId='" + id + "', @org='" + org + "', @orgDiv='" + orgDiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal")
					.setParameter("actionType", "viewDealPageInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {
				RestDealModel deal = new RestDealModel(m[0], m[1], m[2], m[3], m[4].toString(), m[5], m[6], m[7], m[8],
						m[9], m[10], m[11], m[12], m[13], m[14], m[15].toString(), null, null, null, m[16], null, null);
				rs.add(deal);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestDealModel>>> response = new ResponseEntity<JsonResponse<List<RestDealModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewDealDetailsPage ends");
		return response;
	}

	// viewDealStageInfo

	/// viewLeadMailInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestDealModel>>> viewDealStageInfo(String id, String org, String orgDiv) {
		logger.info("Method : viewDealStageInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestDealModel>> resp = new JsonResponse<List<RestDealModel>>();
		List<RestDealModel> rs = new ArrayList<RestDealModel>();

		try {

			String value = "SET @p_dealId='" + id + "', @org='" + org + "', @orgDiv='" + orgDiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal")
					.setParameter("actionType", "viewDealStageInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				RestDealModel assignSkill = new RestDealModel(m[0].toString(), m[1], m[2], m[3], m[4], m[5],
						m[6].toString(), m[7].toString(), m[8].toString(), m[9],m[10]);

				rs.add(assignSkill);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestDealModel>>> response = new ResponseEntity<JsonResponse<List<RestDealModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewDealStageInfo ends");
		return response;
	}

	// AutoSearch

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> autosearchCampaignDetails(String id, String org, String orgDiv) {
		logger.info("Method : autosearchCampaignDetails starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "', @org='" + org + "', @orgDiv='" + orgDiv + "';";

		try {
			logger.info("VALUE" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal")
					.setParameter("actionType", "autosearchCampaignDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : autosearchCampaignDetails ends");
		logger.info("AUTODATAAA" + response);
		return response;
	}

	///////////

	/**
	 * DAO Function to add stage deal
	 *
	 */

	public JsonResponse<Object> addUpdateStageDealDtls(RestDealModel deal) {
		Boolean validity = true;
		logger.info("Method : addUpdateStageDealDtls start");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values = GenerateCallParameter.getAddStageDealParam(deal);
				if (deal.getDealId() != null || deal.getDealId() != "") {
					logger.info("add update stage===========================" + deal.getDealId());

					logger.info("values===========================" + values);

					em.createNamedStoredProcedureQuery("crm_deal").setParameter("actionType", "addStageOnChange")
							.setParameter("actionValue", values).execute();

				}
			} catch

			(Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		logger.info("@@@@@" + resp);

		logger.info("Method : addUpdateStageDealDtls ends");
		return resp;
	}

	/*
	 * deal getDealNameAutoList
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getDealNameAutoList(String id) {
		logger.info("Method : getDealNameAutoList starts");

		List<RestSaleOrderNewModel> itemNameList = new ArrayList<RestSaleOrderNewModel>();
		JsonResponse<List<RestSaleOrderNewModel>> resp = new JsonResponse<List<RestSaleOrderNewModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		logger.info("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal")
					.setParameter("actionType", "getDealNameAutoList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				RestSaleOrderNewModel dropDownModel = new RestSaleOrderNewModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getDealNameAutoList ends");
		return response;
	}

	// getQuoteNameAutoList

	/*
	 * quote getQuoteNameAutoList
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getQuoteNameAutoList(String id) {
		logger.info("Method : getQuoteNameAutoList starts");

		List<RestSaleOrderNewModel> itemNameList = new ArrayList<RestSaleOrderNewModel>();
		JsonResponse<List<RestSaleOrderNewModel>> resp = new JsonResponse<List<RestSaleOrderNewModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		logger.info("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_deal")
					.setParameter("actionType", "getQuoteNameAutoList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				RestSaleOrderNewModel dropDownModel = new RestSaleOrderNewModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getQuoteNameAutoList ends");
		return response;
	}

}
