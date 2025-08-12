package nirmalya.aatithya.restmodule.warehouse.controller;

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
import nirmalya.aatithya.restmodule.warehouse.dao.StockTransferDao;
import nirmalya.aatithya.restmodule.warehouse.model.RestStockTransferModel;
import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

@RestController
@RequestMapping(value = "master/")
public class RestStockTransferController {

	Logger logger = LoggerFactory.getLogger(RestStockTransferController.class);

	@Autowired
	StockTransferDao stockTransferDao;

	@RequestMapping(value = "rest-getStockTransferStackData", method = { RequestMethod.GET })
	public JsonResponse<Object> getStockTransferStackData(@RequestParam String warehouseId, String orgName,
			String orgDivision) {
		logger.info("Method :getStockTransferStackData start");

		logger.info("Method :getStockTransferStackData endss");
		return stockTransferDao.getStockTransferStackData(warehouseId, orgName, orgDivision);
	}

	// add.
	@PostMapping(value = "rest-addStockTransfer")
	public ResponseEntity<JsonResponse<RestStockTransferModel>> addStockTransfer(

			@RequestBody RestStockTransferModel restStockTransferModel) {
		logger.info("Method : addStockTransfer starts");
		logger.info("Method : addStockTransfer ends");
		return stockTransferDao.addStockTransfer(restStockTransferModel);
	}

	@PostMapping("rest-getStockTransferStackDataFilter")
	public JsonResponse<Object> getStockTransferStackDataFilter(@RequestBody DropDownModel data) {
		logger.info("Method :getStockTransferStackDataFilter start");

		logger.info("Method :getStockTransferStackDataFilter endss");
		return stockTransferDao.getStockTransferStackDataFilter(data);
	}

	@PostMapping(value = "stock-transfer-save")
	public ResponseEntity<JsonResponse<List<WirehouseRomeModel>>> saveAllocation(
			@RequestBody List<WirehouseRomeModel> wirehouseRomeModel) {
		logger.info("Method :saveAllocation starts");
		
		logger.info("Method :saveAllocation endss");
		return stockTransferDao.saveAllocation(wirehouseRomeModel);
	}
}
