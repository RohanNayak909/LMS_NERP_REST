package nirmalya.aatithya.restmodule.warehouse.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@Repository
public class RestWarehouseGoodsDispatchDao {
	Logger logger = LoggerFactory.getLogger(RestWarehouseGoodsDispatchDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	// viewRequestedDispatchGoods

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRequestedDispatchGoods(String orgName, String orgDivision, String pageno,
			String type) {
		logger.info("Method : viewBlockData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_pageno='" + pageno
					+ "', @p_type='" + type + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseGoodsDispatchRoutine")
					.setParameter("actionType", "viewRequestedDispatchGoods").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : viewBlockData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}

	// getBlockingDataforDispatch
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getBlockingDataforDispatch(String warehouse, String block, String orgName,
			String orgDiv) {
		logger.info("Method : getBlockingDataforDispatch Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_warehouseId='" + warehouse + "',@p_blockId='" + block + "',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseGoodsDispatchRoutine")
					.setParameter("actionType", "getBlockingDataforDispatch").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : getBlockingDataforDispatch Dao ends");
		return resp;

	}
//
//	// Save
//	public JsonResponse<WirehouseRomeModel> modifyDispatchData(String warehouseId, String blockId, String bdata,
//			String orgName, String orgDivision) {
//		logger.info("Method : modifyDispatchData starts");
//
//		JsonResponse<WirehouseRomeModel> resp = new JsonResponse<WirehouseRomeModel>();
//		try {
//
//			String value = "SET @p_warehouseId='" + warehouseId + "',@p_blockId='" + blockId + "',@p_bdata='(" + bdata
//					+ ")',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
//			System.out.println("value===" + value);
//			em.createNamedStoredProcedureQuery("warehouseGoodsDispatchRoutine")
//					.setParameter("actionType", "modifyDispatchData").setParameter("actionValue", value).execute();
//			resp.setCode("success");
//			resp.setMessage("Goods Dispatched successfully");
//		} catch (Exception e) {
//			resp.setCode("failed");
//			resp.setMessage(e.getMessage());
//		}
//		System.out.println("resp===" + resp);
//		logger.info("Method : modifyDispatchData ends");
//		return resp;
//	}

	public JsonResponse<Object> modifyDispatchData(List<DropDownModel> data) {
		logger.info("Method : modifyDispatchData starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String bdata = "";
		if (data.size() > 0) {
			for (DropDownModel m : data) {
				bdata = bdata + "\"" + m.getCode() + "\",";
			}
			if (bdata != "" && bdata != null) {
				bdata = bdata.substring(0, bdata.length() - 1);
			}
		}

		try {
			String value = "SET @p_warehouseId='" + data.get(0).getKey() + "',@p_blockId='" + data.get(0).getName()
					+ "',@p_bdata='(" + bdata + ")',@p_org='" + data.get(0).getOrgName() + "',@p_orgDiv='"
					+ data.get(0).getOrgDivision() + "',@p_blockedBy='" + data.get(0).getCreatedBy() + "';";
			System.out.println("value===" + value);
			em.createNamedStoredProcedureQuery("warehouseGoodsDispatchRoutine")
					.setParameter("actionType", "modifyDispatchData").setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Dispatched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}

		logger.info("Method : modifyDispatchData ends");
		return resp;
	}
}
