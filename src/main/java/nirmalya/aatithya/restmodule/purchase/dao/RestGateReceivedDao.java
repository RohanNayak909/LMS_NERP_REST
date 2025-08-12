package nirmalya.aatithya.restmodule.purchase.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestGateReceivedDao {

	Logger logger = LoggerFactory.getLogger(RestGateReceivedDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> gateReceivedDataView(String orgName, String orgDivision, String id, String pageno) {
		logger.info("Method : gateReceivedDataView Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_rqstType='" + id
					+ "',@p_pageno='" + pageno + "';";
			System.out.println("value>>>-----" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_received_routines")
					.setParameter("actionType", "viewGateReceivedData").setParameter("actionValue", value)
					.getResultList();
			System.out.println("x.get(0)--->>>>>>-----" + x.get(0));
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : gateReceivedDataView Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> gateReceivedDtls(String id, String po, String orgName, String orgDivision) {
		logger.info("Method : gateReceivedDtls Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET  @p_gatePId='" + id + "',@p_poNo='" + po + "',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_received_routines")
					.setParameter("actionType", "gateReceiveChildDtls").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("Success");
			resp.setMessage("Data Ok");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : gateReceivedDtls Dao ends");
		return resp;

	}

	// Search

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> gateReceivedDataViewSearch(String orgName, String orgDivision, String id,
			String searchValue) {
		logger.info("Method : gateReceivedDataViewSearch Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_rqstType='" + id
					+ "',@p_Svalue='" + searchValue + "';";
			System.out.println("value>>>-----" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_received_routines")
					.setParameter("actionType", "viewGateReceivedDataSearch").setParameter("actionValue", value)
					.getResultList();
			System.out.println("x.get(0)--->>>>>>-----" + x.get(0));
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : gateReceivedDataViewSearch Dao ends");
		return resp;

	}

	/*
	 * -----------------------------------------------------------------------------
	 * -----------------------------------------------------------------------------
	 * ------------------------------------------------------------
	 * ----------------------------------------------------ORI - FOOD GATE RECEIVED
	 * -----------------------------------------------------------------------------
	 * --------------------------------------------------------------
	 * -----------------------------------------------------------------------------
	 * -----------------------------------------------------------------------------
	 * ------------------------------------------------------------
	 */

	// Qa Request For Ori Food

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse qaRequestForOf(String sku, String gatePass, String orgName, String orgDiv, String challanNo,
			String challanDt) {
		logger.info("Method : getGRNdata starts");
		JsonResponse resp = new JsonResponse();

		try {

			String values = "SET @p_sku='" + sku + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_gatePass='"
					+ gatePass + "',@p_challanNo='" + challanNo + "',@p_challanDt='" + challanDt + "';";
			System.out.println("values>>>>----" + values);
			 em.createNamedStoredProcedureQuery("gate_received_routines")
					.setParameter("actionType", "qaRequestForOf").setParameter("actionValue", values)
					.execute();

			 resp.setCode("success");
			resp.setMessage("Qa Requested.");

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getGRNdata ends");
		return resp;
	}
	
	// Child View
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> gateReceivedDtlsOf(String id, String po, String orgName, String orgDivision) {
		logger.info("Method : gateReceivedDtlsOf Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET  @p_gatePId='" + id + "',@p_poNo='" + po + "',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_received_routines")
					.setParameter("actionType", "gateReceivedDtlsOf").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("Success");
			resp.setMessage("Data Ok");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : gateReceivedDtlsOf Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> gateFilteredReceivedDataView(String orgName, String orgDivision, String id, 
			String fromDate,String toDate,String searchData) {
		logger.info("Method : gateFilteredReceivedDataView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String fromDt = DateFormatter.getStringDate(fromDate);
			String toDt = DateFormatter.getStringDate(toDate);
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_rqstType='" + id
					+ "',@fromDate='" + fromDt + "',@toDate='" + toDt + "',@searchData='" + searchData + "';";
			logger.info("Values are: {}",value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("gate_received_routines")
					.setParameter("actionType", "filterGateReceivedData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : gateFilteredReceivedDataView Dao ends");
		return resp;

	}

}
