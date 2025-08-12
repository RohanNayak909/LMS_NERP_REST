package nirmalya.aatithya.restmodule.pipeline.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.dao.RestSalesOrderDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmSalesOrderModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "pipeline")
public class RestCrmSalesOrderController {
	Logger logger = LoggerFactory.getLogger(RestCrmSalesOrderController.class);
	@Autowired
	RestSalesOrderDao restSalesOrderDao;

	//addCRMQuotation
	
			@PostMapping(value = "addCRMSalesOrder")
			public ResponseEntity<JsonResponse<List<RestCrmSalesOrderModel>>> addCRMSalesOrder(@RequestBody List<RestCrmSalesOrderModel> restCrmSalesOrderModel) {
				logger.info("Method :addCRMSalesOrder starts");
				logger.info("rest controller--------------------------------addCRMSalesOrder");
				logger.info("Method :addCRMSalesOrder endss");
				return restSalesOrderDao.addCRMSalesOrder(restCrmSalesOrderModel);
			}
			
			//getAllCRMSalesOrder
			@GetMapping(value = "getAllCRMSalesOrder")
			public JsonResponse<List<RestCrmSalesOrderModel>> getAllCRMSalesOrder() {
				logger.info("Method :getAllCRMSalesOrder starts");
				
				
				logger.info("Method :getAllCRMSalesOrder endss");
				return restSalesOrderDao.getAllCRMSalesOrder();
				
			}
			
			
			//viewCRMSalesOrderEdit
			@GetMapping(value = "viewCRMSalesOrderEdit")
			public List<RestCrmSalesOrderModel> viewCRMSalesOrderEdit(@RequestParam String id) {
				logger.info("Method : viewCRMSalesOrderEdit starts");
				//logger.info(id);
				logger.info("Method : viewCRMSalesOrderEdit endss");
				return restSalesOrderDao.viewCRMSalesOrderEdit(id);
			}
			
			
			//deleteCRMSalesOrder

			@PostMapping(value = "deleteCRMSalesOrder")
			public ResponseEntity<JsonResponse<Object>> deleteCRMSalesOrder(@RequestBody RestCrmSalesOrderModel restCrmSalesOrderModel) {
				logger.info("Method : deleteCRMSalesOrder starts");
				logger.info("data model in rest controller---------------------"+restCrmSalesOrderModel);
				logger.info("Method : deleteCRMSalesOrder ends");
				return restSalesOrderDao.deleteCRMSalesOrder(restCrmSalesOrderModel);
			}
	
			//view-rest-SOInfo
			
			@GetMapping(value = "view-rest-SOInfo")
			public ResponseEntity<JsonResponse<List<RestCrmSalesOrderModel>>> viewSOInfo(@RequestParam String id) {
				logger.info("Method :viewSOInfo starts");

				logger.info("Method :viewSOInfo ends"+id);
				return restSalesOrderDao.viewSOInfo(id);

			}
			
			//view-rest-SOMailInfo
			
			@GetMapping(value = "view-rest-SOMailInfo")
			public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewSOMailInfo(@RequestParam String id) {
				logger.info("Method :viewSOMailInfo starts");

				logger.info("Method :viewSOMailInfo ends"+id);
				return restSalesOrderDao.viewSOMailInfo(id);

			}
			
			//viewCrmPurchaseDetails
			@GetMapping(value = "viewCrmSalesOrderDetails")
			public JsonResponse viewCrmSalesOrderDetails(@RequestParam String id) {
				logger.info("Method :viewCrmSalesOrderDetails starts");

				logger.info("Method :viewCrmSalesOrderDetails ends");
			return restSalesOrderDao.viewCrmSalesOrderDetails(id);
			}

			
}
