package nirmalya.aatithya.restmodule.store.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.store.dao.StoreGoodsBlockingDao;
import nirmalya.aatithya.restmodule.store.model.StoreRomeModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@RestController
@RequestMapping(value = "master")
public class RestStoreGoodsBlockingController {
	Logger logger = LoggerFactory.getLogger(RestStoreGoodsBlockingController.class);

	@Autowired
	StoreGoodsBlockingDao storeGoodsBlockingDao;
	
	//getWarehouseBlockData 
		@RequestMapping(value = "rest-viewStoreBlockData", method = { RequestMethod.GET })
		public JsonResponse<Object> viewStoreBlockData(@RequestParam String orgName, String orgDivision) {
			logger.info("Method :viewStoreBlockData start");

			logger.info("Method :viewStoreBlockData endss");
			return storeGoodsBlockingDao.viewStoreBlockData(orgName, orgDivision);
		}
		
		//getWarehouseAllocateDataForBlocking
		@RequestMapping(value = "getStoreAllocateDataForBlocking", method = { RequestMethod.GET })
		public JsonResponse<Object> getStoreAllocateDataForBlocking(@RequestParam  String warehouseId,String orgName, String orgDivision) {
			logger.info("Method :getStoreAllocateDataForBlocking start");

			logger.info("Method :getStoreAllocateDataForBlocking endss");
			return storeGoodsBlockingDao.getStoreAllocateDataForBlocking(warehouseId, orgName, orgDivision);
		}
		
		//Get Go button onclick data
		@RequestMapping(value = "getStoreBlockStockData", method = { RequestMethod.GET })
		public JsonResponse<Object> getStoreBlockStockData(@RequestParam  String warehouseId,String zoneId,String rackId,
				 String categoryId,String itemName,String orgName,String orgDivision) {
			logger.info("Method :getStoreBlockStockData start");

			logger.info("Method :getStoreBlockStockData endss");
			return storeGoodsBlockingDao.getStoreBlockStockData(warehouseId,zoneId,rackId,categoryId,itemName,orgName, orgDivision);
		}
		
		//Save
		@PostMapping(value = "submitStoreBlockDetails")
		public ResponseEntity<JsonResponse<List<StoreRomeModel>>> submitStoreBlockDetails(
				@RequestBody List<StoreRomeModel> storeRomeModel) {
			logger.info("Method :submitStoreBlockDetails starts");
			
			logger.info("Method :submitStoreBlockDetails endss");
			return storeGoodsBlockingDao.submitStoreBlockDetails(storeRomeModel);
		}
		
		//Assign Dispatch request
		  @GetMapping(value="assignStoreDispatchRequest")
		 	public JsonResponse<StoreRomeModel> assignStoreDispatchRequest(@RequestParam String assignStatus,
		 			String blockId,String orgName,String orgDivision){
		 		logger.info("Method : assignStoreDispatchRequest starts");
		 		
		 		logger.info("Method : assignStoreDispatchRequest ends");
		 	return storeGoodsBlockingDao.assignStoreDispatchRequest(assignStatus, blockId,orgName, orgDivision);
		 	}
		  
			//delete Block Data
		  @GetMapping(value = "deleteStoreBlockdata")
			public JsonResponse<Object> deleteStoreBlockdata(@RequestParam String blockId,String orgName,String orgDivision) {
				logger.info("Method : deleteStoreBlockdata starts");
				logger.info("Method : deleteStoreBlockdata ends");
				return storeGoodsBlockingDao.deleteStoreBlockdata(blockId,orgName, orgDivision);
			}
		  
			//View Bin Data
			@RequestMapping(value = "rest-viewStoreblock", method = { RequestMethod.GET })
			public JsonResponse viewStoreblock(@RequestParam String rmId, String org,
					 String orgDiv) {
				logger.info("Method :viewStoreblock start");

				logger.info("Method :viewStoreblock endss");
				return storeGoodsBlockingDao.viewStoreblock(rmId,org, orgDiv);

			}
			
			@RequestMapping(value = "rest-viewStoreBinBlockdata", method = { RequestMethod.GET })
			public JsonResponse viewStoreBinBlockdata(@RequestParam String rmId, String org,
					 String orgDiv) {
				logger.info("Method :viewStoreBinBlockdata start");

				logger.info("Method :viewStoreBinBlockdata endss");
				return storeGoodsBlockingDao.viewStoreBinBlockdata(rmId,org, orgDiv);

			}
}
