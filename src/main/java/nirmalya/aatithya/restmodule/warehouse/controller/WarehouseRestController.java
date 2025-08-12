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
import nirmalya.aatithya.restmodule.warehouse.dao.WarehouseDao;
import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;
import nirmalya.aatithya.restmodule.master.model.LocationRoomModel;
import nirmalya.aatithya.restmodule.master.model.LocationSectionModel;
import nirmalya.aatithya.restmodule.sales.model.RestQuotationNewModel;
import nirmalya.aatithya.restmodule.warehouse.model.WareHouseModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;
import nirmalya.aatithya.restmodule.warehouse.model.ZoneMasterModel;
import nirmalya.aatithya.restmodule.warehouse.model.ZoneRackModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master")
public class WarehouseRestController {
	Logger logger = LoggerFactory.getLogger(WarehouseRestController.class);

	@Autowired
	WarehouseDao warehouseDao;
	
	@RequestMapping(value = "rest-get-locationDeatils", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getLocationDetails(@RequestParam String id,String type,String org,@RequestParam String orgDiv) {
		logger.info("Method : getLocationDetails starts");
		logger.info("Method : getLocationDetails ends");
		return warehouseDao.getLocationDetails(id,type,org,orgDiv);
	}
	 
	@RequestMapping(value = "rest-get-itemconfig", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getlocationDetailAgainstId(@RequestParam String id,@RequestParam String org,@RequestParam String orgDiv) {
		logger.info("Method : getlocationDetailAgainstId starts");
		logger.info("Method : getlocationDetailAgainstId ends");
		return warehouseDao.getlocationDetailAgainstId(id,org,orgDiv);
	}
	
	@RequestMapping(value = "rest-get-bindetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getBinDetails(@RequestParam String id,@RequestParam String org,@RequestParam String orgDiv) {
		logger.info("Method : getBinDetails starts");
		logger.info("Method : getBinDetails ends");
		return warehouseDao.getBinDetails(id,org,orgDiv);
	}
	
	@RequestMapping(value = "getWarehouseLocationList", method = { RequestMethod.GET })
	public List<DropDownModel> getWarehouseLocationList(@RequestParam String org,String orgDiv,String type) {
		logger.info("Method : getWarehouseLocationList starts");
		
		logger.info("Method : getWarehouseLocationList ends");
		return warehouseDao.getWarehouseLocationList(org,orgDiv,type);
	}
	@RequestMapping(value = "getWarehouseItemCategoryList", method = { RequestMethod.GET })
	public List<DropDownModel> getWarehouseItemCategoryList(@RequestParam String org,String orgDiv) {
		logger.info("Method : getWarehouseItemCategoryList starts");
		
		logger.info("Method : getWarehouseItemCategoryList ends");
		return warehouseDao.getWarehouseItemCategoryList(org,orgDiv);
	}
	@RequestMapping(value = "getWarehouseTypeWiseItemCategoryList", method = { RequestMethod.GET })
	public List<DropDownModel> getWarehouseTypeWiseItemCategoryList(@RequestParam String org,String orgDiv,String type) {
		logger.info("Method : getWarehouseTypeWiseItemCategoryList starts");
		
		logger.info("Method : getWarehouseTypeWiseItemCategoryList ends");
		return warehouseDao.getWarehouseTypeWiseItemCategoryList(org,orgDiv,type);
	}
	@RequestMapping(value = "rest-getWhItemName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getWhItemName(@RequestParam("category") String category,String org,String orgDiv) {
		logger.info("Method : getWhItemName starts");

		logger.info("Method : getWhItemName ends");
	return warehouseDao.getWhItemName(category,org,orgDiv);
	}
	@RequestMapping(value = "saveZoneMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ZoneMasterModel>> saveZoneMaster(@RequestBody ZoneMasterModel zoneMasterModel) {
		logger.info("Method : saveZoneMaster starts");
		System.out.println("zoneMasterModel"+zoneMasterModel);
		logger.info("Method : saveZoneMaster ends");
		return warehouseDao.saveZoneMaster(zoneMasterModel);
	}
	
	@RequestMapping(value = "getZoneDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ZoneMasterModel>>> getZoneDetails(@RequestParam String id) {
		logger.info("Method : getZoneDetails starts");
		logger.info("Method : getZoneDetails ends");
		return warehouseDao.getZoneDetails(id);
	}
	
	
	@RequestMapping(value = "editZoneMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<ZoneMasterModel>> editZoneMaster(@RequestParam String id) {
		logger.info("Method : editZoneMaster starts");
		
		logger.info("Method : editZoneMaster ends");
		return warehouseDao.editZoneMaster(id);
	}
	
	@RequestMapping(value = "deleteZoneMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteZoneMaster(@RequestParam String id, @RequestParam String createdBy, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : deleteZoneMaster starts");
		
		logger.info("Method : deleteZoneMaster ends");
		return warehouseDao.deleteZoneMaster(id,createdBy,org,orgDiv);
	}
	
	@RequestMapping(value = "deleteItemConfig", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteItemConfig(@RequestParam String binid, @RequestParam String createdBy, @RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String skuid) {
		logger.info("Method : deleteItemConfig starts");
		logger.info("Method : deleteItemConfig ends");
		return warehouseDao.deleteItemConfig(binid,createdBy,org,orgDiv,skuid);
	}
	
	@RequestMapping(value = "viewRackListByZone", method = { RequestMethod.GET })
	public List<ZoneRackModel> viewRackListByZone(@RequestParam String id) {
		logger.info("Method : viewRackListByZone starts");
		
		logger.info("Method : viewRackListByZone ends");
		return warehouseDao.viewRackListByZone(id);
	}
	
	@RequestMapping(value = "saveRackMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ZoneRackModel>> saveRackMaster(@RequestBody ZoneRackModel zoneRackModel) {
		logger.info("Method : saveRackMaster starts");
		
		logger.info("Method : saveRackMaster ends");
		return warehouseDao.saveRackMaster(zoneRackModel);
	}
	@RequestMapping(value = "editRackMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<ZoneRackModel>> editRackMaster(@RequestParam String id) {
		logger.info("Method : editRackMaster starts");
		
		logger.info("Method : editRackMaster ends");
		return warehouseDao.editRackMaster(id);
	}
	
	@RequestMapping(value = "deleteRackMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteRackMaster(@RequestParam String id, @RequestParam String createdBy, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : deleteRackMaster starts");
		
		logger.info("Method : deleteRackMaster ends");
		return warehouseDao.deleteRackMaster(id,createdBy,org,orgDiv);
	}
	
	@RequestMapping(value = "getwarehouseRoomDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<WirehouseRomeModel>>> getwarehouseRoomDetails(@RequestBody List<String> id) {
		logger.info("Method : getwarehouseRoomDetails starts");
		
		logger.info("Method : getwarehouseRoomDetails ends");
		return warehouseDao.getwarehouseRoomDetails(id);
	}
	
	@RequestMapping(value = "countZoneWiseRoom", method = { RequestMethod.POST })
	public List<DropDownModel> countZoneWiseRoom(@RequestBody List<String> id) {
		logger.info("Method : countZoneWiseRoom starts");
		
		logger.info("Method : countZoneWiseRoom ends");
		return warehouseDao.countZoneWiseRoom(id);
	}
	
	@RequestMapping(value = "viewRoomListByRack", method = { RequestMethod.GET })
	public List<WirehouseRomeModel> viewRoomListByRack(@RequestParam String id) {
		logger.info("Method : viewRoomListByRack starts");

		logger.info("Method : viewRoomListByRack ends");
		return warehouseDao.viewRoomListByRack(id);
	}
	
	@RequestMapping(value = "saveBinMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<WirehouseRomeModel>> saveBinMaster(@RequestBody WirehouseRomeModel location) {
		logger.info("Method : saveBinMaster starts");
		
		logger.info("Method : saveBinMaster ends");
		return warehouseDao.saveBinMaster(location);
	} 
	
	@RequestMapping(value = "saveItemConfig", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveItemConfig(@RequestBody DropDownModel data) {
		logger.info("Method : saveItemConfig starts");
		
		logger.info("Method : saveItemConfig ends");
		return warehouseDao.saveItemConfig(data);
	} 
	
	@RequestMapping(value = "deleteBinMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteBinMaster(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteBinMaster starts");
		
		logger.info("Method : deleteBinMaster ends");
		return warehouseDao.deleteBinMaster(id,createdBy);
	}
	@RequestMapping(value = "saveBinConfiguration", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<WirehouseRomeModel>> saveBinConfiguration(@RequestBody WirehouseRomeModel config) {
		logger.info("Method : saveBinConfiguration starts");
		
		logger.info("Method : saveBinConfiguration ends");
		return warehouseDao.saveBinConfiguration(config);
	} 
	
	@GetMapping(value = "viewBindata")
	public ResponseEntity<JsonResponse<WirehouseRomeModel>> viewBindata(@RequestParam String rmId,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewBindata starts");
		
		logger.info("Method : viewBindata ends");
		return warehouseDao.viewBindata(rmId,org, orgDiv);
	}
	

	
	
	@GetMapping(value = "deleteBin")
	public ResponseEntity<JsonResponse<WirehouseRomeModel>> deleteBin(@RequestParam String binlist,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : deleteBin starts");
		
		logger.info("Method : deleteBin ends");
		return warehouseDao.deleteBin(binlist,org, orgDiv);
	}
	
	@GetMapping(value = "deleteRoom")
	public ResponseEntity<JsonResponse<WirehouseRomeModel>> deleteRoom(@RequestParam String binlist,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : deleteRoom starts");
		
		logger.info("Method : deleteRoom ends");
		return warehouseDao.deleteRoom(binlist,org, orgDiv);
	}

	
}
