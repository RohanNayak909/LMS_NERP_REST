package nirmalya.aatithya.restmodule.warehouse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.dao.AwaitingWarehouseAllocationRestDao;

@RestController
@RequestMapping(value = "master/")
public class AwaitingWarehouseAllocationRestController {

	Logger logger = LoggerFactory.getLogger(AwaitingWarehouseAllocationRestController.class);

	@Autowired
	AwaitingWarehouseAllocationRestDao awaitingWarehouseAllocationRestDao;

	@RequestMapping(value = "view-awaiting-allocation", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAllocationData(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewAllocationData start");

		logger.info("Method :viewAllocationData endss");
		return awaitingWarehouseAllocationRestDao.viewAllocationData(orgName, orgDivision);

	}

}
