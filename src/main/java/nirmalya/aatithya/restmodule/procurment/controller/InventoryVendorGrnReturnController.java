package nirmalya.aatithya.restmodule.procurment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.procurment.dao.InventoryVendorGrnReturnDao;
import nirmalya.aatithya.restmodule.procurment.model.InventoryGoodsReturnModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory/" })
public class InventoryVendorGrnReturnController {

	Logger logger = LoggerFactory.getLogger(InventoryVendorGrnReturnController.class);

	@Autowired
	InventoryVendorGrnReturnDao inventoryVendorGrnReturnDao;

	/**
	 * get all vendor grn return list
	 */
	@GetMapping(value = "get-vendor-grn-return-view-list")
	public List<InventoryGoodsReturnModel> getVendoeGrnReturnViewList(@RequestParam String userId,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getVendoeGrnReturnViewList starts");
		logger.info("Method : getVendoeGrnReturnViewList endss");
		return inventoryVendorGrnReturnDao.getVendoeGrnReturnViewList(userId,org,orgDiv);
	}

}
