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
import nirmalya.aatithya.restmodule.warehouse.dao.WarehouseStackingDao;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@RestController
@RequestMapping(value = "master")
public class RestWarehouseStackingController {
	Logger logger = LoggerFactory.getLogger(RestWarehouseStackingController.class);

	@Autowired
	WarehouseStackingDao warehouseStackingDao;

	// viewRequestedStackingGoods
	@RequestMapping(value = "rest-viewRequestedStackingGoods", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRequestedStackingGoods(@RequestParam String orgName, String orgDivision,
			String pageno, String type) {
		logger.info("Method :viewRequestedStackingGoods start");

		logger.info("Method :viewRequestedStackingGoods endss");
		return warehouseStackingDao.viewRequestedStackingGoods(orgName, orgDivision, pageno, type);
	}

	// getStackingDatafor
	@RequestMapping(value = "getAllocationDataforStacking", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllocationDataforStacking(@RequestParam String warehouse, String allocate,
			String orgName, String orgDivision) {
		logger.info("Method :getAllocationDataforStacking start");

		logger.info("Method :getAllocationDataforStacking endss");
		return warehouseStackingDao.getAllocationDataforStacking(warehouse, allocate, orgName, orgDivision);
	}

	// Save
	@PostMapping(value = "modifyStackingData")
	public JsonResponse<Object> modifyStackingData(@RequestBody List<DropDownModel> data) {
		logger.info("Method : modifyStackingData starts");

		logger.info("Method : modifyStackingData ends");
		return warehouseStackingDao.modifyStackingData(data);
	}

	// Get Bin List
	@RequestMapping(value = "binLists", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> binLists(@RequestParam String rackId, String binId,
			String orgName, String orgDivision) {
		logger.info("Method : binLists starts");

		logger.info("Method : binLists ends");
		return warehouseStackingDao.binLists(rackId, binId, orgName, orgDivision);
	}

	@RequestMapping(value = "rest-editData", method = { RequestMethod.GET })
	public JsonResponse editData(@RequestParam String rmId, String org, String orgDiv) {
		logger.info("Method :editData start");

		logger.info("Method :editData endss");
		return warehouseStackingDao.editData(rmId, org, orgDiv);

	}

	@PostMapping(value = "warehouse-saveStackdata")
	public ResponseEntity<JsonResponse<Object>> saveStackdata(
			@RequestBody WirehouseRomeModel wirehouseRomeModel) {
		logger.info("Method :saveStackdata starts");

		logger.info("Method :saveStackdata endss");
		return warehouseStackingDao.saveStackdata(wirehouseRomeModel);
	}
}
