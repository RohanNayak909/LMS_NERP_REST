package nirmalya.aatithya.restmodule.warehouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.dao.RestWarehouseGoodsDispatchDao;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@RestController
@RequestMapping(value = "master")
public class RestWarehouseGoodsDispatchController {
	Logger logger = LoggerFactory.getLogger(RestWarehouseGoodsDispatchController.class);

	@Autowired
	RestWarehouseGoodsDispatchDao restWarehouseGoodsDispatchDao;

	// viewRequestedDispatchGoods
	@RequestMapping(value = "rest-viewRequestedDispatchGoods", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRequestedDispatchGoods(@RequestParam String orgName, String orgDivision,
			String pageno, String type) {
		logger.info("Method :viewRequestedDispatchGoods start");

		logger.info("Method :viewRequestedDispatchGoods endss");
		return restWarehouseGoodsDispatchDao.viewRequestedDispatchGoods(orgName, orgDivision, pageno, type);
	}

	// getBlockingDataforDispatch
	@RequestMapping(value = "getBlockingDataforDispatch", method = { RequestMethod.GET })
	public JsonResponse<Object> getBlockingDataforDispatch(@RequestParam String warehouse, String block, String orgName,
			String orgDivision) {
		logger.info("Method :getBlockingDataforDispatch start");

		logger.info("Method :getBlockingDataforDispatch endss");
		return restWarehouseGoodsDispatchDao.getBlockingDataforDispatch(warehouse, block, orgName, orgDivision);
	}

	
	@PostMapping(value = "modifyDispatchData")
	public JsonResponse<Object> modifyDispatchData(@RequestBody List<DropDownModel> data) {
		logger.info("Method : modifyDispatchData starts");

		logger.info("Method : modifyStackingData ends");
		return restWarehouseGoodsDispatchDao.modifyDispatchData(data);
	}
}
