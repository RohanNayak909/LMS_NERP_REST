package nirmalya.aatithya.restmodule.store.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.store.dao.StoreAwaitingGoodsBlockingDao;
import nirmalya.aatithya.restmodule.warehouse.controller.RestAwaitingGoodsBlockingController;
import nirmalya.aatithya.restmodule.warehouse.dao.RestAwaitingGoodsBlockingDao;

@RestController
@RequestMapping(value = "master")
public class RestStoreAwaitingGoodsBlockingController {
	Logger logger = LoggerFactory.getLogger(RestStoreAwaitingGoodsBlockingController.class);

	@Autowired
	StoreAwaitingGoodsBlockingDao storeAwaitingGoodsBlockingDao;

	@RequestMapping(value = "awaitingStoreBlockingView", method = { RequestMethod.GET })
	public JsonResponse<Object> awaitingStoreBlockingView(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :awaitingStoreBlockingView start");

		logger.info("Method :awaitingStoreBlockingView endss");
		return storeAwaitingGoodsBlockingDao.awaitingStoreBlockingView(orgName, orgDivision);

	}
}
