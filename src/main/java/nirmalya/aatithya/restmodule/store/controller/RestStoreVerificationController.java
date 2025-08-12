package nirmalya.aatithya.restmodule.store.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.store.dao.StoreVerificationDao;

@RestController
@RequestMapping(value = "master")
public class RestStoreVerificationController {
	Logger logger = LoggerFactory.getLogger(RestStoreVerificationController.class);

	@Autowired
	StoreVerificationDao storeVerificationDao;
	
	@RequestMapping(value = "storeZoneListData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> storeZoneListData(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : storeZoneListData starts");
		
		logger.info("Method : storeZoneListData ends");
		return storeVerificationDao.storeZoneListData(id,orgName, orgDivision);
	}
	

	@RequestMapping(value = "rest-getStoreOpenListData", method = { RequestMethod.GET })
	public JsonResponse getStoreOpenListData(@RequestParam  String warehouseId,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :getStoreOpenListData start");

		logger.info("Method :getStoreOpenListData endss");
		return storeVerificationDao.getStoreOpenListData(warehouseId, orgName, orgDivision);

	}
	
	@RequestMapping(value = "storerackListData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> storerackListData(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : storerackListData starts");
		
		logger.info("Method : storerackListData ends");
		return storeVerificationDao.storerackListData(id,orgName, orgDivision);
	}
	
	@RequestMapping(value = "storebinListData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> storebinListData(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : storebinListData starts");
		
		logger.info("Method : storebinListData ends");
		return storeVerificationDao.storebinListData(id,orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-getStoreStockVerificationData", method = { RequestMethod.GET })
	public JsonResponse getStoreStockVerificationData(@RequestParam  String warehouseId,@RequestParam String zoneId,
			@RequestParam String categoryId,@RequestParam String itemName,@RequestParam String rackId,@RequestParam String binId,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :getStoreStockVerificationData start");

		logger.info("Method :getStoreStockVerificationData endss");
		return storeVerificationDao.getStoreStockVerificationData(warehouseId,zoneId,categoryId,itemName,rackId,binId,orgName, orgDivision);

	}
	

	@RequestMapping(value = "rest-viewStorestockdetails", method = { RequestMethod.GET })
	public JsonResponse viewStorestockdetails(@RequestParam  String rmId,@RequestParam String allocateid,@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewStorestockdetails start");

		logger.info("Method :viewStorestockdetails endss");
		return storeVerificationDao.viewStorestockdetails(rmId,allocateid,orgName, orgDivision);

	}
}
