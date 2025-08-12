package nirmalya.aatithya.restmodule.store.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.store.dao.AwaitingStoreAllocationDao;

@RestController
@RequestMapping(value = "master/")
public class RestAwaitingStoreAllocationController {
	Logger logger = LoggerFactory.getLogger(RestAwaitingStoreAllocationController.class);

	@Autowired
	AwaitingStoreAllocationDao awaitingStockAllocationDao;
	@RequestMapping(value = "view-awaitingstock-allocation", method = { RequestMethod.GET })
	public JsonResponse<Object> awaitingStockAllocationView(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :awaitingStockAllocationView start");

		logger.info("Method :awaitingStockAllocationView endss");
		return awaitingStockAllocationDao.awaitingStockAllocationView(orgName, orgDivision);

	}
}
