package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.WarehouseItemConfigurationDao;

@RestController
@RequestMapping(value = { "master" })
public class WarehouseItemConfigurationRestController {
	Logger logger = LoggerFactory.getLogger(WarehouseItemConfigurationRestController.class);

	@Autowired
	WarehouseItemConfigurationDao warehouseItemConfigurationDao;
	
	//getItemListForWarehouseConfig
	@RequestMapping(value = "getItemListForWarehouseAllocationConfig", method = { RequestMethod.GET })
	public List<DropDownModel> getItemListForWarehouseAllocationConfig(@RequestParam String org,String orgDiv,String type) {
		logger.info("Method : getItemListForWarehouseAllocationConfig starts");
		
		logger.info("Method : getItemListForWarehouseAllocationConfig ends");
		return warehouseItemConfigurationDao.getItemListForWarehouseAllocationConfig(org,orgDiv,type);
	}
	
	//viewWarehouseDetails
	@RequestMapping(value = "warehouse-item-configuration-view-warehouse", method = { RequestMethod.GET })
	public JsonResponse<Object> viewWarehouseDetails(@RequestParam String orgName, String orgDivision,String userId, @RequestParam String type) {
		logger.info("Method :viewWarehouseDetails start");

		logger.info("Method :viewWarehouseDetails endss");
		return warehouseItemConfigurationDao.viewWarehouseDetails(orgName, orgDivision,userId, type);
	}
	//viewAllocateItems
	@RequestMapping(value = "warehouse-item-configuration-view-allocate-item", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAllocateItems(@RequestParam String orgName, String orgDivision,String whid,String type) {
		logger.info("Method :viewAllocateItems start");
		
		logger.info("Method :viewAllocateItems endss");
		return warehouseItemConfigurationDao.viewAllocateItems(orgName, orgDivision,whid,type);
	}
	//saveAllocateItems
	@RequestMapping(value = "warehouse-item-configuration-save-allocate-item", method = { RequestMethod.GET })
	public JsonResponse<Object> saveAllocateItems(@RequestParam String orgName, String orgDivision,String userId,String sku,String whid,String minQty,String edit) {
		logger.info("Method :saveAllocateItems start");
		
		logger.info("Method :saveAllocateItems endss");
		return warehouseItemConfigurationDao.saveAllocateItems(orgName,orgDivision,userId,sku,whid,minQty,edit);
	}
	//deleteAllocateItems
	@RequestMapping(value = "warehouse-item-configuration-delete-allocate-item", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteAllocateItems(@RequestParam String orgName, String orgDivision,String userId,String sku,String whid) {
		logger.info("Method :deleteAllocateItems start");
		
		logger.info("Method :deleteAllocateItems endss");
		return warehouseItemConfigurationDao.deleteAllocateItems(orgName,orgDivision,userId,sku,whid);
	}
}
