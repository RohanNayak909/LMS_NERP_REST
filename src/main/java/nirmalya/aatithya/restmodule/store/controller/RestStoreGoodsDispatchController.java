package nirmalya.aatithya.restmodule.store.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.store.dao.StoreGoodsDispatchDao;
import nirmalya.aatithya.restmodule.store.model.StoreRomeModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@RestController
@RequestMapping(value = "master")
public class RestStoreGoodsDispatchController {
	Logger logger = LoggerFactory.getLogger(RestStoreGoodsDispatchController.class);

	@Autowired
	StoreGoodsDispatchDao storeGoodsDispatchDao;
	
	//viewRequestedDispatchGoods
		@RequestMapping(value = "rest-viewStoreRequestedDispatchGoods", method = { RequestMethod.GET })
		public JsonResponse<Object> viewStoreRequestedDispatchGoods(@RequestParam String orgName, String orgDivision) {
			logger.info("Method :viewStoreRequestedDispatchGoods start");

			logger.info("Method :viewStoreRequestedDispatchGoods endss");
			return storeGoodsDispatchDao.viewStoreRequestedDispatchGoods(orgName, orgDivision);
		}


		//getBlockingDataforDispatch
		@RequestMapping(value = "getStoreBlockingDataforDispatch", method = { RequestMethod.GET })
		public JsonResponse<Object> getStoreBlockingDataforDispatch(@RequestParam  String warehouse,String block,String orgName,String orgDivision) {
			logger.info("Method :getStoreBlockingDataforDispatch start");

			logger.info("Method :getStoreBlockingDataforDispatch endss");
			return storeGoodsDispatchDao.getStoreBlockingDataforDispatch(warehouse,block,orgName, orgDivision);
		}
		
		//Save
		  @GetMapping(value="modifyStoreDispatchData")
		 	public JsonResponse<StoreRomeModel> modifyStoreDispatchData(@RequestParam String warehouseId,
		 			String blockId,String bdata,String orgName,String orgDivision){
		 		logger.info("Method : modifyStoreDispatchData starts");
		 		
		 		logger.info("Method : modifyStoreDispatchData ends");
		 	return storeGoodsDispatchDao.modifyStoreDispatchData(warehouseId, blockId,bdata,orgName, orgDivision);
		 	}
		  
		  @RequestMapping(value = "rest-viewStoreblockDispatch", method = { RequestMethod.GET })
			public JsonResponse viewStoreblockDispatch(@RequestParam String rmId,String blockId, String org,
					 String orgDiv) {
				logger.info("Method :viewStoreblockDispatch start");

				logger.info("Method :viewStoreblockDispatch endss");
				return storeGoodsDispatchDao.viewStoreblockDispatch(rmId,blockId,org, orgDiv);

			}
			
}
