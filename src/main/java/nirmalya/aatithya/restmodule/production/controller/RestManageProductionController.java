package nirmalya.aatithya.restmodule.production.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.dao.ManageProductionDao;

@RestController
@RequestMapping(value = { "production/" })
public class RestManageProductionController {
	Logger logger = LoggerFactory.getLogger(RestManageProductionController.class);

	@Autowired
	ManageProductionDao manageProductionDao;
	
	@RequestMapping(value = "rest-getSalesOrderData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getSalesOrderData(@RequestParam String org,String orgDiv) {
		logger.info("Method : rest getSalesOrderData starts");
		
		logger.info("Method : rest getSalesOrderData ends");
		return manageProductionDao.getSalesOrderData(org, orgDiv);
	}
	@RequestMapping(value = "getBomDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> getBomDetails(@RequestParam String id, @RequestParam String sku,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getBomDetails start");

		logger.info("Method :getBomDetails endss");
		return manageProductionDao.getBomDetails(id, sku, org, orgDiv);

	}
}
