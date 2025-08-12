package nirmalya.aatithya.restmodule.store.dao;

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
import nirmalya.aatithya.restmodule.common.utils.store.GenerateStoreGoodsBlockingParameter;
import nirmalya.aatithya.restmodule.store.model.StoreRomeModel;
import nirmalya.aatithya.restmodule.warehouse.dao.RestWarehouseGoodsBlockingDao;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;
@Repository
public class StoreGoodsBlockingDao {
	Logger logger = LoggerFactory.getLogger(StoreGoodsBlockingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	//getWarehouseBlockData
	
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewStoreBlockData(String orgName, String orgDivision) {
			logger.info("Method : viewStoreBlockData Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeGoodsBlockRoutine")
						.setParameter("actionType", "viewStoreBlockData").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
				}
			logger.info("Method : viewStoreBlockData Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;
		}
		
		//getWarehouseAllocateDataForBlocking
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getStoreAllocateDataForBlocking(String warehouseId,String orgName, String orgDiv) {
			logger.info("Method : getStoreAllocateDataForBlocking Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String values = "SET @p_warehouseId='" + warehouseId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			//	System.out.println("values****************************" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeGoodsBlockRoutine")
						.setParameter("actionType", "getStoreAllocateDataForBlocking").setParameter("actionValue", values)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
				}
			logger.info("Method : getStoreAllocateDataForBlocking Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		
		//Get Go button onclick data
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getStoreBlockStockData(String warehouseId,String zoneId,String rackId,String categoryId,
				String itemName,String orgName, String orgDiv) {
			logger.info("Method : getStoreBlockStockData Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_warehouseId='" + warehouseId + "',@p_zoneId='" + zoneId + "',@p_rackId='" + rackId + "',@p_categoryId='" + categoryId + "',@p_itemName='" + itemName + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("storeGoodsBlockRoutine")
						.setParameter("actionType", "getStoreGoodsAllocatefilterData").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
				}
			System.out.println("resp===="+resp);
			logger.info("Method : getStoreBlockStockData Dao ends");
			return resp;

		}
		
		//Save
		public ResponseEntity<JsonResponse<List<StoreRomeModel>>> submitStoreBlockDetails(
				List<StoreRomeModel> storeRomeModel) {

			logger.info("Method : submitStoreBlockDetails starts");

			JsonResponse<List<StoreRomeModel>> resp = new JsonResponse<List<StoreRomeModel>>();
			List<StoreRomeModel> listData = new ArrayList<StoreRomeModel>();

			System.out.println("=====>>>>>" + storeRomeModel);

			try {
				String values = GenerateStoreGoodsBlockingParameter.storeBlockParam(storeRomeModel);
	System.out.println("values==="+values);
				 em.createNamedStoredProcedureQuery("storeGoodsBlockRoutine")
							.setParameter("actionType", "submitStoreBlockDetails").setParameter("actionValue", values)
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
			ResponseEntity<JsonResponse<List<StoreRomeModel>>> response = new ResponseEntity<JsonResponse<List<StoreRomeModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response data is" + response);
			logger.info("Method : submitStoreBlockDetails ends");
			return response;
		}
		
		//Approve dispatch request
		public JsonResponse<StoreRomeModel> assignStoreDispatchRequest(String assignStatus, String blockId,String orgName,String orgDivision) {
			logger.info("Method : assignStoreDispatchRequest starts");

			JsonResponse<StoreRomeModel> resp = new JsonResponse<StoreRomeModel>();
			try {
				
				String value = "SET @p_assignStatus='" + assignStatus + "',@p_blockId='" + blockId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision +"';";
				System.out.println("value==="+value);
				em.createNamedStoredProcedureQuery("storeGoodsBlockRoutine").setParameter("actionType", "assignStoreDispatchRequest")
						.setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Approved successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
				}
			System.out.println("resp==="+resp);
			logger.info("Method : assignStoreDispatchRequest ends");
			return resp;
		}
		
		// Delete Block data
		

		public JsonResponse<Object> deleteStoreBlockdata(String blockId,String orgName,String orgDivision) {
			logger.info("Method : deleteStoreBlockdata starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			try {
				String value = "SET @p_blockId='" + blockId + "',@p_org='" + orgName + "',@p_orgDiv='"+ orgDivision +"';";
				System.out.println("value==="+value);
				em.createNamedStoredProcedureQuery("storeGoodsBlockRoutine")
						.setParameter("actionType", "deleteStoreBlockdata").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
				}
			logger.info("Method : deleteStoreBlockdata ends");
			return resp;
		}

		//View block data
				@SuppressWarnings("unchecked")
				public JsonResponse viewStoreblock(String rmId,String orgName, String orgDiv) {
					logger.info("Method : viewStoreblock Dao startssssssssssssssssssssss");

					JsonResponse resp = new JsonResponse();

					try {
						String value = "SET @p_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
						System.out.println("values****************************" + value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("storeGoodsBlockRoutine")
								.setParameter("actionType", "viewStoreblock").setParameter("actionValue", value)
								.getResultList();
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
						} catch (Exception e) {
							resp.setCode("failed");
							resp.setMessage(e.getMessage());
						}
					logger.info("Method : viewStoreblock Dao ends");
					System.out.println("resp****************************" + resp);
					return resp;

				}
				@SuppressWarnings("unchecked")
				public JsonResponse viewStoreBinBlockdata(String rmId,String orgName, String orgDiv) {
					logger.info("Method : viewStoreBinBlockdata Dao startssssssssssssssssssssss");

					JsonResponse resp = new JsonResponse();

					try {
						String value = "SET @p_rmId='" + rmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
						System.out.println("values****************************" + value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("storeGoodsBlockRoutine")
								.setParameter("actionType", "viewStoreBindata").setParameter("actionValue", value)
								.getResultList();
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
						} catch (Exception e) {
							resp.setCode("failed");
							resp.setMessage(e.getMessage());
						}
					logger.info("Method : viewStoreBinBlockdata Dao ends");
					System.out.println("resp****************************" + resp);
					return resp;

				}
				
		
		
}
