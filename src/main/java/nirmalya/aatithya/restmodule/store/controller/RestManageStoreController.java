package nirmalya.aatithya.restmodule.store.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.store.dao.ManageStoreDao;
import nirmalya.aatithya.restmodule.store.model.StoreModel;
import nirmalya.aatithya.restmodule.store.model.StoreRomeModel;
import nirmalya.aatithya.restmodule.store.model.StoreZoneMasterModel;
import nirmalya.aatithya.restmodule.store.model.StoreZoneRackModel;
import nirmalya.aatithya.restmodule.warehouse.model.WareHouseModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;
import nirmalya.aatithya.restmodule.warehouse.model.ZoneMasterModel;
import nirmalya.aatithya.restmodule.warehouse.model.ZoneRackModel;

@RestController
@RequestMapping(value = "master")
public class RestManageStoreController {
	Logger logger = LoggerFactory.getLogger(RestManageStoreController.class);

	@Autowired
	ManageStoreDao manageStockDao;
	@RequestMapping(value = "getStocklocationDeatils", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<StoreModel>>> getStocklocationDeatils(@RequestParam String id) {
		logger.info("Method : getStocklocationDeatils starts");
		logger.info("Method : getStocklocationDeatils ends");
		return manageStockDao.getStocklocationDeatils(id);
	}
	
	@RequestMapping(value = "getStockItemCategoryList", method = { RequestMethod.GET })
	public List<DropDownModel> getStockItemCategoryList(@RequestParam String org,String orgDiv) {
		logger.info("Method : getStockItemCategoryList starts");
		
		logger.info("Method : getStockItemCategoryList ends");
		return manageStockDao.getStockItemCategoryList(org,orgDiv);
	}
	@RequestMapping(value = "getStockLocationList", method = { RequestMethod.GET })
	public List<DropDownModel> getStockLocationList(@RequestParam String org,String orgDiv) {
		logger.info("Method : getStockLocationList starts");
		
		logger.info("Method : getStockLocationList ends");
		return manageStockDao.getStockLocationList(org,orgDiv);
	}
	
	@RequestMapping(value = "rest-getstockItemName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getstockItemName(@RequestParam("category") String category,String org,String orgDiv) {
		logger.info("Method : getstockItemName starts");

		logger.info("Method : getstockItemName ends");
	return manageStockDao.getstockItemName(category,org,orgDiv);
	}
	@RequestMapping(value = "saveStockZoneMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<StoreZoneMasterModel>> saveStockZoneMaster(@RequestBody StoreZoneMasterModel stockZoneMasterModel) {
		logger.info("Method : saveStockZoneMaster starts");
		
		logger.info("Method : saveStockZoneMaster ends");
		return manageStockDao.saveStockZoneMaster(stockZoneMasterModel);
	}
	
	@RequestMapping(value = "getZoneDetailss", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ZoneMasterModel>>> getZoneDetailss(@RequestParam String id) {
		logger.info("Method : getZoneDetailss starts");
		logger.info("Method : getZoneDetailss ends");
		return manageStockDao.getZoneDetailss(id);
	}
	
	
	@RequestMapping(value = "editStockZoneMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<StoreZoneMasterModel>> editStockZoneMaster(@RequestParam String id) {
		logger.info("Method : editStockZoneMaster starts");
		
		logger.info("Method : editStockZoneMaster ends");
		return manageStockDao.editStockZoneMaster(id);
	}
	
	@RequestMapping(value = "deleteStockZoneMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteStockZoneMaster(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteStockZoneMaster starts");
		
		logger.info("Method : deleteStockZoneMaster ends");
		return manageStockDao.deleteStockZoneMaster(id,createdBy);
	}
	
	@RequestMapping(value = "viewRackListByZonee", method = { RequestMethod.GET })
	public List<StoreZoneRackModel> viewRackListByZonee(@RequestParam String id) {
		logger.info("Method : viewRackListByZonee starts");
		
		logger.info("Method : viewRackListByZonee ends");
		return manageStockDao.viewRackListByZonee(id);
	}
	
	@RequestMapping(value = "saveStockRackMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<StoreZoneRackModel>> saveStockRackMaster(@RequestBody StoreZoneRackModel stockZoneRackModel) {
		logger.info("Method : saveStockRackMaster starts");
		
		logger.info("Method : saveStockRackMaster ends");
		return manageStockDao.saveStockRackMaster(stockZoneRackModel);
	}
	@RequestMapping(value = "editStockRackMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<StoreZoneRackModel>> editStockRackMaster(@RequestParam String id) {
		logger.info("Method : editStockRackMaster starts");
		
		logger.info("Method : editStockRackMaster ends");
		return manageStockDao.editStockRackMaster(id);
	}
	
	@RequestMapping(value = "deleteStockRackMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteStockRackMaster(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteStockRackMaster starts");
		
		logger.info("Method : deleteStockRackMaster ends");
		return manageStockDao.deleteStockRackMaster(id,createdBy);
	}
	
	@RequestMapping(value = "getStockRoomDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<StoreRomeModel>>> getStockRoomDetails(@RequestBody List<String> id) {
		logger.info("Method : getStockRoomDetails starts");
		
		logger.info("Method : getStockRoomDetails ends");
		return manageStockDao.getStockRoomDetails(id);
	}
	
	@RequestMapping(value = "countStockZoneWiseRoom", method = { RequestMethod.POST })
	public List<DropDownModel> countStockZoneWiseRoom(@RequestBody List<String> id) {
		logger.info("Method : countStockZoneWiseRoom starts");
		
		logger.info("Method : countStockZoneWiseRoom ends");
		return manageStockDao.countStockZoneWiseRoom(id);
	}
	
	@RequestMapping(value = "viewStockRoomListByRack", method = { RequestMethod.GET })
	public List<StoreRomeModel> viewStockRoomListByRack(@RequestParam String id) {
		logger.info("Method : viewStockRoomListByRack starts");

		logger.info("Method : viewStockRoomListByRack ends");
		return manageStockDao.viewStockRoomListByRack(id);
	}
	
	@RequestMapping(value = "saveStockBinMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<StoreRomeModel>> saveStockBinMaster(@RequestBody StoreRomeModel location) {
		logger.info("Method : saveStockBinMaster starts");
		
		logger.info("Method : saveStockBinMaster ends");
		return manageStockDao.saveStockBinMaster(location);
	} 
	
	/*
	 * @RequestMapping(value = "deleteBinMaster", method = { RequestMethod.GET })
	 * public ResponseEntity<JsonResponse<Object>> deleteBinMaster(@RequestParam
	 * String id, @RequestParam String createdBy) {
	 * logger.info("Method : deleteBinMaster starts");
	 * 
	 * logger.info("Method : deleteBinMaster ends"); return
	 * manageStockDao.deleteBinMaster(id,createdBy); }
	 */
	@RequestMapping(value = "saveStockBinConfiguration", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<StoreRomeModel>> saveStockBinConfiguration(@RequestBody StoreRomeModel config) {
		logger.info("Method : saveStockBinConfiguration starts");
		
		logger.info("Method : saveStockBinConfiguration ends");
		return manageStockDao.saveStockBinConfiguration(config);
	} 
	
	@GetMapping(value = "viewStockBindata")
	public ResponseEntity<JsonResponse<StoreRomeModel>> viewStockBindata(@RequestParam String rmId,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewStockBindata starts");
		
		logger.info("Method : viewStockBindata ends");
		return manageStockDao.viewStockBindata(rmId,org, orgDiv);
	}
	

	@GetMapping(value = "deleteStockBin")
	public ResponseEntity<JsonResponse<StoreRomeModel>> deleteStockBin(@RequestParam String binlist,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : deleteStockBin starts");
		
		logger.info("Method : deleteStockBin ends");
		return manageStockDao.deleteStockBin(binlist,org, orgDiv);
	}
	
	@GetMapping(value = "deleteStockRoom")
	public ResponseEntity<JsonResponse<StoreRomeModel>> deleteStockRoom(@RequestParam String binlist,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : deleteStockRoom starts");
		
		logger.info("Method : deleteStockRoom ends");
		return manageStockDao.deleteStockRoom(binlist,org, orgDiv);
	}

	
	@RequestMapping(value = "viewBinItemList", method = { RequestMethod.GET })
	public JsonResponse<Object> viewBinItemList(@RequestParam String bindatas, String orgName, String orgDivision) {
		logger.info("Method :viewBinItemList start");

		logger.info("Method :viewBinItemList endss");
		return manageStockDao.viewBinItemList(bindatas,orgName, orgDivision);

	}	
	
	//deleteAllocationdata
	@RequestMapping(value = "rest-deleteConfigItemdata", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteConfigItemdata(@RequestParam String id, String org,String orgDiv) {
		logger.info("Method :deleteConfigItemdata start");

		logger.info("Method :deleteConfigItemdata endss");
		return manageStockDao.deleteConfigItemdata(id,org, orgDiv);
	}
	
}
