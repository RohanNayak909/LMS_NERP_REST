package nirmalya.aatithya.restmodule.procurment.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.model.InventoryStockDailyReportFinalModel;
import nirmalya.aatithya.restmodule.procurment.dao.InventoryStockDao;
import nirmalya.aatithya.restmodule.procurment.model.InventoryStockModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "purchase" })
public class InventoryStockController {

	Logger logger = LoggerFactory.getLogger(InventoryStockController.class);
	@Autowired
	InventoryStockDao inventoryStockDao;

	/**
	 *  
	 */
	@RequestMapping(value = "get-stock-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<InventoryStockModel>>> getAllStockDetails(
			@RequestParam String userid,@RequestParam String orgName,
			@RequestParam String orgDiv,String type) {
		logger.info("Method : getAllStockDetails starts");

		logger.info("Method : getAllStockDetails ends");
		return inventoryStockDao.getAllStockDetails(userid,orgName, orgDiv,type);
	}

	@GetMapping(value = "view-stock-daily-report")
	public ResponseEntity<JsonResponse< InventoryStockDailyReportFinalModel>> restDailyStockReport(@RequestParam String id ,@RequestParam String empId) {
		logger.info("Method : restDailyStockReport starts");
	 
		logger.info("Method : restDailyStockReport ends");
		return inventoryStockDao.restDailyStockReport(id ,empId);
	}

}
