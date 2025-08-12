package nirmalya.aatithya.restmodule.samudyamproduction.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.samudyamproduction.dao.ProductionOrderDao;
import nirmalya.aatithya.restmodule.samudyamproduction.model.RestProductionOrderModel;

@RestController
@RequestMapping("production")
public class RestProductionOrderController {
	Logger logger = LoggerFactory.getLogger(RestProductionOrderController.class);
	@Autowired
	ProductionOrderDao productionOrderDao;
	//getProductionOrder
	@RequestMapping(value = "getProductionOrder", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestProductionOrderModel>>> getProductionOrder(@RequestParam String org,String orgDiv) {
		logger.info("Method : getProductionOrder starts");

		logger.info("Method : getProductionOrder ends");
		return productionOrderDao.getProductionOrder(org,orgDiv);
	}
	//getOrderItemDetails
	@RequestMapping(value = "getOrderItemDetails", method = { RequestMethod.GET })
	public List<RestProductionOrderModel> getOrderItemDetails(@RequestParam String orderId,String org,String orgDiv) {
		logger.info("Method : getOrderItemDetails starts");
		
		logger.info("Method : getOrderItemDetails ends");
		return productionOrderDao.getOrderItemDetails(orderId,org,orgDiv);
	}
}
