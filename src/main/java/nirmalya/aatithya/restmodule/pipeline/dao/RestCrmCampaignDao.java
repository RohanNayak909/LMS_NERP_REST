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
import nirmalya.aatithya.restmodule.common.utils.GenerateCampaignParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;

@Repository
public class RestCrmCampaignDao {
	
	Logger logger = LoggerFactory.getLogger(RestCrmDealDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	//addTask
	
	/**
	 * DAO Function to add pipeline
	 *
	 */

	public JsonResponse<Object> addCampaign(RestCrmCampaignModel campaign) {
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values =GenerateCampaignParameter.getAddCampaignParam(campaign);
				logger.info("Values for add Campaign----------------------"+values);
				if (campaign.getCampaignId() == null || campaign.getCampaignId() == "") {
					logger.info("add============="+campaign.getCampaignId());

					String pageTypeAccount="Account";
					String pageTypeContact="Contact";
					String pageTypeLead="Lead";
					String pageTypeCampaign="Campaign";
					String pageType=campaign.getPageType();
					
					if(pageType.equals(pageTypeLead)) {
					   logger.info("actionType-------addCampaignL");
						em.createNamedStoredProcedureQuery("crm_campaign").setParameter("actionType", "addCampaignL")
						.setParameter("actionValue", values).execute();
				
				
					}
					
					if(pageType.equals(pageTypeContact)) {
						logger.info("actionType------addCampaignC");
						em.createNamedStoredProcedureQuery("crm_campaign").setParameter("actionType", "addCampaignC")
						.setParameter("actionValue", values).execute();
				
				
					}
					

					if(pageType.equals(pageTypeAccount)) {
						logger.info("actionType------addCampaignA");
						em.createNamedStoredProcedureQuery("crm_campaign").setParameter("actionType", "addCampaignA")
						.setParameter("actionValue", values).execute();
					}
					
					if(pageType.equals(pageTypeCampaign)) {
						logger.info("actionType------addCampaign");
						em.createNamedStoredProcedureQuery("crm_campaign").setParameter("actionType", "addCampaign")
						.setParameter("actionValue", values).execute();
					}

				} else {
					logger.info("update============="+campaign.getCampaignId());
					em.createNamedStoredProcedureQuery("crm_campaign").setParameter("actionType", "modifyCampaign")
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
		logger.info("ADDDDD@@@@@" + resp);

		logger.info("Method : addCampaign ends");
		return resp;
	}
	
	
	///restViewTaskdetails
	


////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> restViewCampaignDetails(String pageno,String userId,String orgName,String orgDivision ) {
		logger.info("Method : restViewCampaignDetails starts");
		List<RestCrmCampaignModel> respList = new ArrayList<RestCrmCampaignModel>();
		
		String value = "SET @p_pageno='" + pageno + "',@p_userId='" + userId + "',"
				+ "@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_campaign").setParameter("actionType", "getCampaignDetails")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
	

			//	RestCrmCampaignModel restPayroll = new RestCrmCampaignModel(m[0].toString(), m[1], m[2],m[3],
				//		m[4],m[5].toString(),m[6].toString(),m[7],m[8],m[9],m[10],m[11],m[12],m[13],m[14].toString());
				
				RestCrmCampaignModel restPayroll = new RestCrmCampaignModel(m[0].toString(), m[1], m[2], m[3],
						m[4], m[5].toString(), m[6].toString(), m[7], m[8], m[9], m[10], m[11], m[12], m[13], 
						null,m[15].toString(),m[16].toString());
				respList.add(restPayroll); 

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestCrmCampaignModel>> resp = new JsonResponse<List<RestCrmCampaignModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : restViewCampaignDetails ends");

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}
	
	//getLeadNameList
	
	
	/**
	 * for getLeadNameList list
	 * @return
	 */
/*	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLeadNameList() {
		
		logger.info("Method : getLeadNameList starts");
		
		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_task")
					.setParameter("actionType", "getLeadNameList")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLeadNameList ends"+employmentList);
		
		return employmentList;
	}*/
	

	///editCampaignsInfo   
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>>editCampaignsInfo(String id) {
			logger.info("Method : editCampaignsInfo starts");

			JsonResponse<List<RestCrmCampaignModel>> resp = new JsonResponse<List<RestCrmCampaignModel>>();
			List<RestCrmCampaignModel> rs = new ArrayList<RestCrmCampaignModel>();

			try {

				String value = "SET @p_campaignId='" + id +"';";
				logger.info(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_campaign")
						.setParameter("actionType", "editCampaignInfo").setParameter("actionValue", value).getResultList();
				logger.info("asdfasdf"+x);
	           
				for (Object[] m : x) {
					RestCrmCampaignModel restPayroll = new RestCrmCampaignModel(m[0].toString(), m[1], m[2], m[3],
							m[4], m[5].toString(), m[6].toString(), m[7], m[8], m[9], m[10], m[11], m[12], m[13], null,null,null);
					
					
					rs.add(restPayroll);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	resp.setBody(rs);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmCampaignModel>>>(resp,responseHeaders,
					HttpStatus.CREATED);

			logger.info("Method : editCampaignsInfo ends");
			return response;
		}

	//deleteCampaignDetails
		
		/*
		 * delete
		 */

	public ResponseEntity<JsonResponse<Object>> deleteCampaignDetails(String id) {
			logger.info("Method : deleteCampaignDetails starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			logger.info("ID...."+id);
			if (validity)
				try {

					//String value = "SET @p_taskId='" + id + "';";
					String value = "SET  @p_campaignId='(" + id + ")';";
					logger.info("value for set campaign-------------------------"+value);

					em.createNamedStoredProcedureQuery("crm_campaign")
							.setParameter("actionType", "deleteCampaignDetails").setParameter("actionValue", value).execute();

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

			logger.info("Method :  deleteCampaignDetails ends");
			logger.info("DELETE" + response);
			return response;
		}
		

}
