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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.store.dao.StoreStackingDao;
import nirmalya.aatithya.restmodule.store.model.StoreRomeModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@RestController
@RequestMapping(value = "master")
public class RestStoreStackingController {
	Logger logger = LoggerFactory.getLogger(RestStoreStackingController.class);

	@Autowired
	StoreStackingDao storeStackingDao;
	
	//viewRequestedStackingGoods
	@RequestMapping(value = "rest-viewStoreRequestedStacking", method = { RequestMethod.GET })
	public JsonResponse<Object> viewStoreRequestedStacking(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewStoreRequestedStacking start");

		logger.info("Method :viewStoreRequestedStacking endss");
		return storeStackingDao.viewStoreRequestedStacking(orgName, orgDivision);
	}
	
	//getStackingDatafor
	@RequestMapping(value = "getStoreAllocationDataforStacking", method = { RequestMethod.GET })
	public JsonResponse<Object> getStoreAllocationDataforStacking(@RequestParam  String warehouse,String allocate,String orgName,String orgDivision) {
		logger.info("Method :getStoreAllocationDataforStacking start");

		logger.info("Method :getStoreAllocationDataforStacking endss");
		return storeStackingDao.getStoreAllocationDataforStacking(warehouse,allocate,orgName, orgDivision);
	}
	

	//Save
	  @GetMapping(value="modifyStoreStackingData")
	 	public JsonResponse<StoreRomeModel> modifyStoreStackingData(@RequestParam String warehouseId,
	 			String allocateId,String bdata,String orgName,String orgDivision){
	 		logger.info("Method : modifyStoreStackingData starts");
	 		
	 		logger.info("Method : modifyStoreStackingData ends");
	 	return storeStackingDao.modifyStoreStackingData(warehouseId, allocateId,bdata,orgName, orgDivision);
	 	}
	  
	//Get Bin List 
			@RequestMapping(value = "binStoreLists", method = { RequestMethod.GET })
			public ResponseEntity<JsonResponse<List<DropDownModel>>> binStoreLists(@RequestParam String rackId,String binId,String orgName, String orgDivision) {
				logger.info("Method : binStoreLists starts");
				
				logger.info("Method : binStoreLists ends");
				return storeStackingDao.binStoreLists(rackId,binId,orgName, orgDivision);
			}
			
			
			@RequestMapping(value = "rest-editStoreData", method = { RequestMethod.GET })
			public JsonResponse editStoreData(@RequestParam String rmId, String org,
					 String orgDiv) {
				logger.info("Method :editStoreData start");

				logger.info("Method :editStoreData endss");
				return storeStackingDao.editStoreData(rmId,org, orgDiv);

			}
			
			@PostMapping(value = "saveStoreStackdata")
			public ResponseEntity<JsonResponse<List<StoreRomeModel>>> saveStoreStackdata(
					@RequestBody List<StoreRomeModel> storeRomeModel) {
				logger.info("Method :saveStoreStackdata starts");
				
				logger.info("Method :saveStoreStackdata endss");
				return storeStackingDao.saveStoreStackdata(storeRomeModel);
			}
			
			//View allocation data
			@RequestMapping(value = "rest-viewStackBinAllocationdata", method = { RequestMethod.GET })
			public JsonResponse viewStackBinAllocationdata(@RequestParam String rmId,String allocateId, String org,
					 String orgDiv) {
				logger.info("Method :viewStackBinAllocationdata start");

				logger.info("Method :viewStackBinAllocationdata endss");
				return storeStackingDao.viewStackBinAllocationdata(rmId,allocateId,org, orgDiv);

			}
}
