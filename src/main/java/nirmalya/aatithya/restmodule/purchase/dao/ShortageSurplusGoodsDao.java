package nirmalya.aatithya.restmodule.purchase.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class ShortageSurplusGoodsDao {

	Logger logger = LoggerFactory.getLogger(ShortageSurplusGoodsDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// View

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> shortageSurplusGoodsDataView(String orgName, String orgDivision, String pageno) {
		logger.info("Method : shortageSurplusGoodsDataView Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_pageno='" + pageno + "';";
			System.out.println("value>>>-----" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_shortage_surplus_routines")
					.setParameter("actionType", "viewData").setParameter("actionValue", value).getResultList();
			System.out.println("x.get(0)--->>>>>>-----" + x.get(0));
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : shortageSurplusGoodsDataView Dao ends");
		return resp;

	}

	// Add Debit Note

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> shortageSurplusGoodsDataAddDebitNote(String orgName, String orgDivision, String id, String userId) {
		logger.info("Method : shortageSurplusGoodsDataView Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_invId='" + id + "',@p_createdBy='" + userId + "';";
			System.out.println("value>>>-----" + value);

			em.createNamedStoredProcedureQuery("purchase_shortage_surplus_routines")
					.setParameter("actionType", "addDebitNote").setParameter("actionValue", value).execute();

			resp.setCode("success");
			resp.setMessage("Data Saved successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : shortageSurplusGoodsDataView Dao ends");
		return resp;

	}

}
