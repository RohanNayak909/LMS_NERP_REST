package nirmalya.aatithya.restmodule.warehouse.controller;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.dao.WarehouseAllocationDao;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@RestController
@RequestMapping(value = "master")
public class RestWarehouseAllocationController {
	Logger logger = LoggerFactory.getLogger(RestWarehouseAllocationController.class);

	@Autowired
	WarehouseAllocationDao warehouseAllocationDao;
	
	/****************************************    Dropdown Section Start    ****************************************************/
	//getwarehouseListApi
	@RequestMapping(value = "getwarehouseList-api", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getwarehouseListApi(@RequestParam String org,String orgDiv) {
		logger.info("Method : getwarehouseListApi starts");
		
		logger.info("Method : getwarehouseListApi ends");
		return warehouseAllocationDao.getwarehouseListApi(org, orgDiv);
	}
	//getzoneList
	@RequestMapping(value = "getzoneList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getzoneList(@RequestParam String warehouseId,String orgName,String orgDivision) {
		logger.info("Method : getzoneList starts");
		
		logger.info("Method : getzoneList ends");
		return warehouseAllocationDao.getzoneList(warehouseId,orgName, orgDivision);
	}
	
	//Get Rack List 
	@RequestMapping(value = "rackLists", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> rackLists(@RequestParam String zoneId, String orgName, String orgDivision) {
		logger.info("Method : rackLists starts");
		
		logger.info("Method : rackLists ends");
		return warehouseAllocationDao.rackLists(zoneId,orgName, orgDivision);
	}
	//getCategoryListApi
	@RequestMapping(value = "getCategoryList-api", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCategoryListApi(@RequestParam String org,String orgDiv) {
		logger.info("Method : getCategoryListApi starts");
		
		logger.info("Method : getCategoryListApi ends");
		return warehouseAllocationDao.getCategoryListApi(org, orgDiv);
	}
	//getitemList
	@RequestMapping(value = "getitemList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getitemList(@RequestParam String categoryId,String orgName, String orgDivision) {
		logger.info("Method : getitemList starts");
		
		logger.info("Method : getitemList ends");
		return warehouseAllocationDao.getitemList(categoryId,orgName, orgDivision);
	}
	//getManufacturePlaceLists
	@RequestMapping(value = "getManufacturePlaceLists", method = { RequestMethod.GET })
	public List<DropDownModel> getManufacturePlaceLists(@RequestParam String org,String orgDiv) {
		logger.info("Method : getManufacturePlaceLists starts");

		logger.info("Method : getManufacturePlaceLists ends");
		return warehouseAllocationDao.getManufacturePlaceLists(org,orgDiv);
	}
	//getManufacturePlaceListsApi
	@RequestMapping(value = "getManufacturePlaceLists-api", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getManufacturePlaceListsApi(@RequestParam String org,String orgDiv) {
		logger.info("Method : getManufacturePlaceListsApi starts");
		
		logger.info("Method : getManufacturePlaceListsApi ends");
		return warehouseAllocationDao.getManufacturePlaceListsApi(org,orgDiv);
	}
	//getBatchGenerateType
	@RequestMapping(value = "getBatchNoLists", method = { RequestMethod.GET })
	public List<DropDownModel> getBatchNoLists(@RequestParam String org,String orgDiv) {
		logger.info("Method : getBatchNoLists starts");

		logger.info("Method : getBatchNoLists ends");
		return warehouseAllocationDao.getBatchNoLists(org,orgDiv);
	}
	//getBatchGenerateTypeApi
	@RequestMapping(value = "getBatchGenerateType-api", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBatchGenerateTypeApi(@RequestParam String org,String orgDiv) {
		logger.info("Method : getBatchGenerateTypeApi starts");
		
		logger.info("Method : getBatchGenerateTypeApi ends");
		return warehouseAllocationDao.getBatchGenerateTypeApi(org,orgDiv);
	}
	//getShiftListsAllocation
	@RequestMapping(value = "getShiftListsAllocation", method = { RequestMethod.GET })
	public List<DropDownModel> getShiftListsAllocation(@RequestParam String org,String orgDiv,String userId) {
		logger.info("Method : getShiftListsAllocation starts");

		logger.info("Method : getShiftListsAllocation ends");
		return warehouseAllocationDao.getShiftListsAllocation(org,orgDiv,userId);
	}
	//getShiftListsAllocationApi
	@RequestMapping(value = "getShiftLists-api", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getShiftListsAllocationApi(@RequestParam String org,String orgDiv,String userId) {
		logger.info("Method : getShiftListsAllocationApi starts");
		
		logger.info("Method : getShiftListsAllocationApi ends");
		return warehouseAllocationDao.getShiftListsAllocationApi(org,orgDiv,userId);
	}
//getLineLists
	@RequestMapping(value = "getLineLists", method = { RequestMethod.GET })
	public List<DropDownModel> getLineLists(@RequestParam String org,String orgDiv) {
		logger.info("Method : getLineLists starts");

		logger.info("Method : getLineLists ends");
		return warehouseAllocationDao.getLineLists(org,orgDiv);
	}
	//getLineListsApi
	@RequestMapping(value = "getLineLists-api", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getLineListsApi(@RequestParam String org,String orgDiv) {
		logger.info("Method : getLineListsApi starts");
		
		logger.info("Method : getLineListsApi ends");
		return warehouseAllocationDao.getLineListsApi(org,orgDiv);
	}
	//getPackingSiteLists
	@RequestMapping(value = "getPackingSiteLists", method = { RequestMethod.GET })
	public List<DropDownModel> getPackingSiteLists(@RequestParam String org,String orgDiv) {
		logger.info("Method : getPackingSiteLists starts");

		logger.info("Method : getPackingSiteLists ends");
		return warehouseAllocationDao.getPackingSiteLists(org,orgDiv);
	}
	//getPackingSiteListsApi
	@RequestMapping(value = "getPackingSiteLists-api", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPackingSiteListsApi(@RequestParam String org,String orgDiv) {
		logger.info("Method : getPackingSiteListsApi starts");
		
		logger.info("Method : getPackingSiteListsApi ends");
		return warehouseAllocationDao.getPackingSiteListsApi(org,orgDiv);
	}
	//getUomListsApi
	@RequestMapping(value = "getUomLists-api", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getUomListsApi() {
		logger.info("Method : getUomListsApi starts");
		
		logger.info("Method : getUomListsApi ends");
		return warehouseAllocationDao.getUomListsApi();
	}
	
	/****************************************    Main Section Start    ****************************************************/
	//rest-getwarehouse
		@RequestMapping(value = "rest-getwarehouse", method = { RequestMethod.GET })
		public JsonResponse<Object> getWarehouseData(@RequestParam  String warehouseId,String orgName,String orgDivision) {
			logger.info("Method :getWarehouseData start");

			logger.info("Method :getWarehouseData endss");
			return warehouseAllocationDao.getWarehouseData(warehouseId, orgName, orgDivision);
		}
//get-warehouse-search-data
	@RequestMapping(value = "get-warehouse-search-data", method = { RequestMethod.GET })
	public JsonResponse<Object> warehouseGetSearchData(@RequestParam  String warehouseId, String zoneId, String rackId,String categoryId, String itemName,
			String orgName, String orgDivision) {
		logger.info("Method :warehouseGetSearchData start");

		logger.info("Method :warehouseGetSearchData endss");
		return warehouseAllocationDao.warehouseGetSearchData(warehouseId,zoneId,rackId,categoryId,itemName, orgName, orgDivision);

	}
	//saveAllocation
	@PostMapping(value = "warehouse-allocation-save")
	public ResponseEntity<JsonResponse<List<WirehouseRomeModel>>> saveAllocation(
			@RequestBody List<WirehouseRomeModel> wirehouseRomeModel) {
		logger.info("Method :saveAllocation starts");
		
		logger.info("Method :saveAllocation endss");
		return warehouseAllocationDao.saveAllocation(wirehouseRomeModel);
	}
	
	@PostMapping(value = "warehouse-allocation-avlbin")
	public ResponseEntity<JsonResponse<Object>> getAvlBinLocBySKU(@RequestBody DropDownModel data) {
		logger.info("Method :saveAllocation starts");
		
		logger.info("Method :saveAllocation endss");
		return warehouseAllocationDao.getAvlBinLocBySKU(data);
	}
	

 //warehouse-allocation-view-details
	@RequestMapping(value = "warehouse-allocation-view-details", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAllocationData(@RequestParam String orgName, String orgDivision,String pageno,String type) {
		logger.info("Method :viewAllocationData start");

		logger.info("Method :viewAllocationData endss");
		return warehouseAllocationDao.viewAllocationData(orgName,orgDivision,pageno,type);
	}
	//Clear Bin data
	@GetMapping(value = "clearBinData")
	public ResponseEntity<JsonResponse<WirehouseRomeModel>> clearBinData(@RequestParam String aiddatas, String bdata, String org, String orgDiv) {
		logger.info("Method : clearBinData starts");
		
		logger.info("Method : clearBinData ends");
		return warehouseAllocationDao.clearBinData(aiddatas,bdata,org, orgDiv);
	}
 //deleteAllocationdata
	@RequestMapping(value = "rest-deleteAllocationdata", method = { RequestMethod.GET })
	public JsonResponse<Object> viewBinAllocationdata(@RequestParam String allocId, String org,String orgDiv) {
		logger.info("Method :deleteAllocationdata start");

		logger.info("Method :deleteAllocationdata endss");
		return warehouseAllocationDao.deleteAllocationdata(allocId,org, orgDiv);
	}
	 //approveAllocationdata
		@RequestMapping(value = "rest-approveAllocationdata", method = { RequestMethod.GET })
		public JsonResponse<Object> approveAllocationdata(@RequestParam String allocId, String org,String orgDiv) {
			logger.info("Method :approveAllocationdata start");

			logger.info("Method :approveAllocationdata endss");
			return warehouseAllocationDao.approveAllocationdata(allocId,org, orgDiv);
		}
		//View allocation data
		@RequestMapping(value = "rest-viewBinAllocationdata", method = { RequestMethod.GET })
		public JsonResponse viewBinAllocationdatas(@RequestParam String rmId, String org,
				 String orgDiv) {
			logger.info("Method :viewBinAllocationdata start");

			logger.info("Method :viewBinAllocationdata endss");
			return warehouseAllocationDao.viewBinAllocationdata(rmId,org, orgDiv);

		}
		//View Bin Data
		@RequestMapping(value = "rest-viewbinconfigdata", method = { RequestMethod.GET })
		public JsonResponse viewbinconfigdata(@RequestParam String rmId, String org,
				 String orgDiv) {
			logger.info("Method :viewbinconfigdata start");

			logger.info("Method :viewbinconfigdata endss");
			return warehouseAllocationDao.viewbinconfigdata(rmId,org, orgDiv);

		}
		//Get batch Data
		@RequestMapping(value = "rest-getBatchData", method = { RequestMethod.GET })
		public JsonResponse getBatchData(@RequestParam String org,
				 String orgDiv) {
			logger.info("Method :getBatchData start");

			logger.info("Method :getBatchData endss");
			return warehouseAllocationDao.getBatchData(org, orgDiv);

		}
		 //holdAllocationdata
		@RequestMapping(value = "rest-holdAllocationdata", method = { RequestMethod.GET })
		public JsonResponse<Object> holdAllocationdata(@RequestParam String rmId, String org,String orgDiv) {
			logger.info("Method :holdAllocationdata start");

			logger.info("Method :holdAllocationdata endss");
			return warehouseAllocationDao.holdAllocationdata(rmId,org, orgDiv);
		}
		 //releaseAllocationdata
		@RequestMapping(value = "rest-releaseAllocationdata", method = { RequestMethod.GET })
		public JsonResponse<Object> releaseAllocationdata(@RequestParam String rmId, String org,String orgDiv) {
			logger.info("Method :releaseAllocationdata start");

			logger.info("Method :releaseAllocationdata endss");
			return warehouseAllocationDao.releaseAllocationdata(rmId,org, orgDiv);
		}
}
