package nirmalya.aatithya.restmodule.warehouse.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateWarehouseGoodsBlockingParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@Repository
public class RestWarehouseGoodsBlockingDao {
	Logger logger = LoggerFactory.getLogger(RestWarehouseGoodsBlockingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	//Save
	public ResponseEntity<JsonResponse<List<WirehouseRomeModel>>> submitBlockDetails(
			List<WirehouseRomeModel> wirehouseRomeModel) {

		logger.info("Method : submitBlockDetails starts");

		JsonResponse<List<WirehouseRomeModel>> resp = new JsonResponse<List<WirehouseRomeModel>>();
		List<WirehouseRomeModel> listData = new ArrayList<WirehouseRomeModel>();

		System.out.println("=====>>>>>" + wirehouseRomeModel);

		try {
			String values = GenerateWarehouseGoodsBlockingParameter.blockParam(wirehouseRomeModel);
System.out.println("values==="+values);
			 em.createNamedStoredProcedureQuery("warehouseGoodsBlockRoutine")
						.setParameter("actionType", "submitBlockDetails").setParameter("actionValue", values)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data Saved Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<WirehouseRomeModel>>> response = new ResponseEntity<JsonResponse<List<WirehouseRomeModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response data is" + response);
		logger.info("Method : submitBlockDetails ends");
		return response;
	}
	
	//getWarehouseBlockData
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getWarehouseBlockData(String orgName,String orgDivision,String pageno,String type) {
		logger.info("Method : getWarehouseBlockData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_pageno='" + pageno + "', @p_type='" + type +"';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseGoodsBlockRoutine")
					.setParameter("actionType", "getWarehouseBlockData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : getWarehouseBlockData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}
	//getWarehouseAllocateDataForBlocking
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getWarehouseAllocateDataForBlocking(String warehouseId,String orgName, String orgDiv) {
		logger.info("Method : getWarehouseAllocateDataForBlocking Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = "SET @p_warehouseId='" + warehouseId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		//	System.out.println("values****************************" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseGoodsBlockRoutine")
					.setParameter("actionType", "getWarehouseAllocateDataForBlocking").setParameter("actionValue", values)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : getWarehouseAllocateDataForBlocking Dao ends");
		//System.out.println("resp****************************" + resp);
		return resp;

	}
	//Get Go button onclick data
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getGoodsAllocatefilterData(String warehouseId,String zoneId,String rackId,String categoryId,
			String itemName,String orgName, String orgDiv) {
		logger.info("Method : getGoodsAllocatefilterData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_warehouseId='" + warehouseId + "',@p_zoneId='" + zoneId + "',@p_rackId='" + rackId + "',@p_categoryId='" + categoryId + "',@p_itemName='" + itemName + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseGoodsBlockRoutine")
					.setParameter("actionType", "getGoodsAllocatefilterData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		System.out.println("resp===="+resp);
		logger.info("Method : getGoodsAllocatefilterData Dao ends");
		return resp;

	}
	//Approve dispatch request
	public JsonResponse<WirehouseRomeModel> assignDispatchRequest(String assignStatus, String blockId,String orgName,String orgDivision) {
		logger.info("Method : assignDispatchRequest starts");

		JsonResponse<WirehouseRomeModel> resp = new JsonResponse<WirehouseRomeModel>();
		try {
			
			String value = "SET @p_assignStatus='" + assignStatus + "',@p_blockId='" + blockId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision +"';";
			System.out.println("value==="+value);
			em.createNamedStoredProcedureQuery("warehouseGoodsBlockRoutine").setParameter("actionType", "assignDispatchRequest")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Goods Dispatch Assigned successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		System.out.println("resp==="+resp);
		logger.info("Method : assignDispatchRequest ends");
		return resp;
	}
	
	// Delete Block data
	

	public JsonResponse<Object> deleteBlockdata(String blockId,String orgName,String orgDivision) {
		logger.info("Method : deleteBlockdata starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_blockId='" + blockId + "',@p_org='" + orgName + "',@p_orgDiv='"+ orgDivision +"';";
			System.out.println("value==="+value);
			em.createNamedStoredProcedureQuery("warehouseGoodsBlockRoutine")
					.setParameter("actionType", "deleteBlockdata").setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Data Deleted successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : deleteBlockdata ends");
		return resp;
	}

	//View block data
			@SuppressWarnings("unchecked")
			public JsonResponse viewblock(String rmId,String orgName, String orgDiv) {
				logger.info("Method : viewblock Dao startssssssssssssssssssssss");

				JsonResponse resp = new JsonResponse();

				try {
					String value = "SET @p_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
					System.out.println("values****************************" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("warehouseGoodsBlockRoutine")
							.setParameter("actionType", "viewblock").setParameter("actionValue", value)
							.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
					} catch (Exception e) {
						resp.setCode("failed");
						resp.setMessage(e.getMessage());
					}
				logger.info("Method : viewblock Dao ends");
				System.out.println("resp****************************" + resp);
				return resp;

			}
	
}
