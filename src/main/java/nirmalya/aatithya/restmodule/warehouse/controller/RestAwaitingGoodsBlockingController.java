package nirmalya.aatithya.restmodule.warehouse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.dao.RestAwaitingGoodsBlockingDao;

@RestController
@RequestMapping(value = "master")
public class RestAwaitingGoodsBlockingController {
	Logger logger = LoggerFactory.getLogger(RestAwaitingGoodsBlockingController.class);

	@Autowired
	RestAwaitingGoodsBlockingDao restAwaitingGoodsBlockingDao;

	@RequestMapping(value = "view-awaiting-blocking", method = { RequestMethod.GET })
	public JsonResponse<Object> awaitingBlockingView(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :awaitingBlockingView start");

		logger.info("Method :awaitingBlockingView endss");
		return restAwaitingGoodsBlockingDao.awaitingBlockingView(orgName, orgDivision);

	}
}
