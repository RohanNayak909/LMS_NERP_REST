package nirmalya.aatithya.restmodule.procurment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.procurment.dao.InventoryRfqActionDao;
import nirmalya.aatithya.restmodule.procurment.model.InventoryActionRfqModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory/" })
public class InventoryActionRfqController {
	Logger logger = LoggerFactory.getLogger(InventoryActionRfqController.class);

	@Autowired
	InventoryRfqActionDao inventoryRfqActionDao;

	/*
	 * get all requisition for view
	 */
	@GetMapping(value = "get-action-rfq-view-list")
	public List<InventoryActionRfqModel> getActionRfqViewList(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getActionRfqViewList starts");
		logger.info("Method : getActionRfqViewList endss");
		return inventoryRfqActionDao.getActionRfqViewList(org,orgDiv);
	}
	/*
	 * 
	 * Get mapping for edit Rfq
	 * 
	 * 
	 */
	@GetMapping(value = "get-action-rfq-edit")
	public List<InventoryActionRfqModel> getRfqEdit(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getRfqEdit starts");
		logger.info("Method : getRfqEdit endss");
		return inventoryRfqActionDao.getActionRfqEdit(id,org,orgDiv);
	}
}
