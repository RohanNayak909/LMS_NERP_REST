package nirmalya.aatithya.restmodule.store.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.store.dao.StoreAllocationDao;
import nirmalya.aatithya.restmodule.store.model.StoreRomeModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@RestController
@RequestMapping(value = "master")
public class RestStoreAllocationController {
	Logger logger = LoggerFactory.getLogger(RestStoreAllocationController.class);

	@Autowired
	StoreAllocationDao storekAllocationDao;
	
	//getManufacturePlaceLists
	@RequestMapping(value = "getStoreManufacturePlaceLists", method = { RequestMethod.GET })
	public List<DropDownModel> getStoreManufacturePlaceLists(@RequestParam String org,String orgDiv) {
		logger.info("Method : getStoreManufacturePlaceLists starts");

		logger.info("Method : getStoreManufacturePlaceLists ends");
		return storekAllocationDao.getStoreManufacturePlaceLists(org,orgDiv);
	}
	
	//getBatchGenerateType
	@RequestMapping(value = "getStoreBatchNoLists", method = { RequestMethod.GET })
	public List<DropDownModel> getStoreBatchNoLists(@RequestParam String org,String orgDiv) {
		logger.info("Method : getStoreBatchNoLists starts");

		logger.info("Method : getStoreBatchNoLists ends");
		return storekAllocationDao.getStoreBatchNoLists(org,orgDiv);
	}
	
	//getShiftListsAllocation
		@RequestMapping(value = "getStoreShiftListsAllocation", method = { RequestMethod.GET })
		public List<DropDownModel> getStoreShiftListsAllocation(@RequestParam String org,String orgDiv,String userId) {
			logger.info("Method : getStoreShiftListsAllocation starts");

			logger.info("Method : getStoreShiftListsAllocation ends");
			return storekAllocationDao.getStoreShiftListsAllocation(org,orgDiv,userId);
		}
		
		//getLineLists
		@RequestMapping(value = "getStoreLineLists", method = { RequestMethod.GET })
		public List<DropDownModel> getStoreLineLists(@RequestParam String org,String orgDiv) {
			logger.info("Method : getStoreLineLists starts");

			logger.info("Method : getStoreLineLists ends");
			return storekAllocationDao.getStoreLineLists(org,orgDiv);
		}
		
		//getPackingSiteLists
		@RequestMapping(value = "getStorePackingSiteLists", method = { RequestMethod.GET })
		public List<DropDownModel> getStorePackingSiteLists(@RequestParam String org,String orgDiv) {
			logger.info("Method : getStorePackingSiteLists starts");

			logger.info("Method : getStorePackingSiteLists ends");
			return storekAllocationDao.getStorePackingSiteLists(org,orgDiv);
		}
		
		//getzoneList
		@RequestMapping(value = "getStorezoneList", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getStorezoneList(@RequestParam String warehouseId,String orgName,String orgDivision) {
			logger.info("Method : getStorezoneList starts");
			
			logger.info("Method : getStorezoneList ends");
			return storekAllocationDao.getStorezoneList(warehouseId,orgName, orgDivision);
		}
		

		//Get Rack List 
		@RequestMapping(value = "rackStoreLists", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<DropDownModel>>> rackStoreLists(@RequestParam String zoneId, String orgName, String orgDivision) {
			logger.info("Method : rackStoreLists starts");
			
			logger.info("Method : rackStoreLists ends");
			return storekAllocationDao.rackStoreLists(zoneId,orgName, orgDivision);
		}
		
		//getitemList
		@RequestMapping(value = "getstoreitemList", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getstoreitemList(@RequestParam String categoryId,String orgName, String orgDivision) {
			logger.info("Method : getstoreitemList starts");
			
			logger.info("Method : getstoreitemList ends");
			return storekAllocationDao.getstoreitemList(categoryId,orgName, orgDivision);
		}
		
		//rest-getwarehouse
				@RequestMapping(value = "rest-getStoreData", method = { RequestMethod.GET })
				public JsonResponse<Object> getStoreData(@RequestParam  String warehouseId,String orgName,String orgDivision) {
					logger.info("Method :getStoreData start");

					logger.info("Method :getStoreData endss");
					return storekAllocationDao.getStoreData(warehouseId, orgName, orgDivision);
				}
				
				//get-warehouse-search-data
				@RequestMapping(value = "storeGetAllData", method = { RequestMethod.GET })
				public JsonResponse<Object> storeGetAllData(@RequestParam  String warehouseId, String zoneId, String rackId,String categoryId, String itemName,
						String orgName, String orgDivision) {
					logger.info("Method :storeGetAllData start");

					logger.info("Method :storeGetAllData endss");
					return storekAllocationDao.storeGetAllData(warehouseId,zoneId,rackId,categoryId,itemName, orgName, orgDivision);

				}
				
				//saveAllocation
				@PostMapping(value = "saveStoreAllocation")
				public ResponseEntity<JsonResponse<List<StoreRomeModel>>> saveStoreAllocation(
						@RequestBody List<StoreRomeModel> storeRomeModel) {
					logger.info("Method :saveStoreAllocation starts");
					
					logger.info("Method :saveStoreAllocation endss");
					return storekAllocationDao.saveStoreAllocation(storeRomeModel);
				}
				 //warehouse-allocation-view-details
				@RequestMapping(value = "viewStoreAllocationData", method = { RequestMethod.GET })
				public JsonResponse<Object> viewStoreAllocationData(@RequestParam String orgName, String orgDivision) {
					logger.info("Method :viewStoreAllocationData start");

					logger.info("Method :viewStoreAllocationData endss");
					return storekAllocationDao.viewStoreAllocationData(orgName, orgDivision);

				}	
				
				//View allocation data
				@RequestMapping(value = "rest-viewStoreBinAllocationdata", method = { RequestMethod.GET })
				public JsonResponse viewStoreBinAllocationdata(@RequestParam String rmId, String org,
						 String orgDiv) {
					logger.info("Method :viewStoreBinAllocationdata start");

					logger.info("Method :viewStoreBinAllocationdata endss");
					return storekAllocationDao.viewStoreBinAllocationdata(rmId,org, orgDiv);

				}
				
				//View Bin Data
				@RequestMapping(value = "rest-viewStorebinconfigdata", method = { RequestMethod.GET })
				public JsonResponse viewStorebinconfigdata(@RequestParam String rmId, String org,
						 String orgDiv) {
					logger.info("Method :viewStorebinconfigdata start");

					logger.info("Method :viewStorebinconfigdata endss");
					return storekAllocationDao.viewStorebinconfigdata(rmId,org, orgDiv);

				}
				
				//deleteAllocationdata
				@RequestMapping(value = "rest-deleteStoreAllocationdata", method = { RequestMethod.GET })
				public JsonResponse<Object> deleteStoreAllocationdata(@RequestParam String allocId, String org,String orgDiv) {
					logger.info("Method :deleteStoreAllocationdata start");

					logger.info("Method :deleteStoreAllocationdata endss");
					return storekAllocationDao.deleteStoreAllocationdata(allocId,org, orgDiv);
				}
				
				//approveAllocationdata
				@RequestMapping(value = "rest-approveStoreAllocationdata", method = { RequestMethod.GET })
				public JsonResponse<Object> approveStoreAllocationdata(@RequestParam String allocId, String org,String orgDiv) {
					logger.info("Method :approveStoreAllocationdata start");

					logger.info("Method :approveStoreAllocationdata endss");
					return storekAllocationDao.approveStoreAllocationdata(allocId,org, orgDiv);
				}
				
				 //holdAllocationdata
				@RequestMapping(value = "rest-holdStoreAllocationdata", method = { RequestMethod.GET })
				public JsonResponse<Object> holdStoreAllocationdata(@RequestParam String rmId, String org,String orgDiv) {
					logger.info("Method :holdStoreAllocationdata start");

					logger.info("Method :holdStoreAllocationdata endss");
					return storekAllocationDao.holdStoreAllocationdata(rmId,org, orgDiv);
				}
				 //releaseAllocationdata
				@RequestMapping(value = "rest-releaseStoreAllocationdata", method = { RequestMethod.GET })
				public JsonResponse<Object> releaseStoreAllocationdata(@RequestParam String rmId, String org,String orgDiv) {
					logger.info("Method :releaseStoreAllocationdata start");

					logger.info("Method :releaseStoreAllocationdata endss");
					return storekAllocationDao.releaseStoreAllocationdata(rmId,org, orgDiv);
				}
			
}
