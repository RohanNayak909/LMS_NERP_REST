package nirmalya.aatithya.restmodule.ticket.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class WorkOrderDao {

	Logger logger = LoggerFactory.getLogger(WorkOrderDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;

	// All work order List

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllWorkOrder(String orgName, String orgDivision, String userid, String pageno,
			String activity, String fromDate, String toDate) {
		logger.info("Method : getAllWorkOrder Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userid='" + userid
					+ "',@p_pageno='" + pageno + "',@p_activity='"+activity+"',@p_toDate='" + toDate
					+ "',@p_fromDate='" + fromDate + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "allWorkOrder").setParameter("actionValue", value).getResultList();
			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllWorkOrder Dao ends");

		return resp;

	}
	// All work order List-search

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllWorkOrderSearch(String orgName, String orgDivision, String userid, String pageno,
			String activity, String fromDate, String toDate, String search) {

		logger.info("Method : getAllWorkOrderSearch Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userid='" + userid
					+ "',@p_pageno='" + pageno + "',@p_activity='" + activity + "',@p_toDate='" + toDate
					+ "',@p_fromDate='" + fromDate + "',@p_Svalue='" + search + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "allWorkOrder-search").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllWorkOrderSearch Dao ends");

		return resp;

	}

}
