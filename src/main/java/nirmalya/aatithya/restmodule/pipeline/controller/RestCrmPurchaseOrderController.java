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
import nirmalya.aatithya.restmodule.pipeline.dao.RestPurchaseOrderDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmPurchaseOrderModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "pipeline")
public class RestCrmPurchaseOrderController {
	Logger logger = LoggerFactory.getLogger(RestCrmPurchaseOrderController.class);
	@Autowired
	RestPurchaseOrderDao restPurchaseOrderDao;

	//addCRMPurchaseOrder
	
	@PostMapping(value = "addCRMPurchaseOrder")
	public ResponseEntity<JsonResponse<List<RestCrmPurchaseOrderModel>>> addCRMPurchaseOrder(@RequestBody List<RestCrmPurchaseOrderModel> restCrmPurchaseOrderModel) {
		logger.info("Method :addCRMPurchaseOrder starts");
		logger.info("rest controller--------------------------------addCRMPurchaseOrder");
		logger.info("Method :addCRMPurchaseOrder endss");
		return restPurchaseOrderDao.addCRMPurchaseOrder(restCrmPurchaseOrderModel);
	}
	
	//viewCRMPurchaseOrder
	@GetMapping(value = "viewCRMPurchaseOrder")
	public JsonResponse<List<RestCrmPurchaseOrderModel>> viewCRMPurchaseOrder() {
		logger.info("Method :viewCRMPurchaseOrder starts");
		
		
		logger.info("Method :viewCRMPurchaseOrder endss");
		return restPurchaseOrderDao.viewCRMPurchaseOrder();
		
	}
	
	//deleteCRMPurchaseOrder

	@PostMapping(value = "deleteCRMPurchaseOrder")
	public ResponseEntity<JsonResponse<Object>> deleteCRMPurchaseOrder(@RequestBody RestCrmPurchaseOrderModel restCrmPurchaseOrderModel) {
		logger.info("Method : deleteCRMPurchaseOrder starts");
		logger.info("Method : deleteCRMPurchaseOrder ends");
		return restPurchaseOrderDao.deleteCRMPurchaseOrder(restCrmPurchaseOrderModel);
	}
	
	
	//viewCRMProductOrderEdit
	@GetMapping(value = "viewCRMProductOrderEdit")
	public List<RestCrmPurchaseOrderModel> viewCRMProductOrderEdit(@RequestParam String id) {
		logger.info("Method : viewCRMProductOrderEdit starts");
		//logger.info(id);
		logger.info("Method : viewCRMProductOrderEdit endss");
		return restPurchaseOrderDao.viewCRMProductOrderEdit(id);
	}
	
	//view-rest-POInfo
	@GetMapping(value = "view-rest-POInfo")
	public ResponseEntity<JsonResponse<List<RestCrmPurchaseOrderModel>>> viewPOInfo(@RequestParam String id) {
		logger.info("Method :viewPOInfo starts");

		logger.info("Method :viewPOInfo ends"+id);
		return restPurchaseOrderDao.viewPOInfo(id);

	}
	
	//view-rest-POMailInfo
	@GetMapping(value = "view-rest-POMailInfo")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewPOMailInfo(@RequestParam String id) {
		logger.info("Method :viewPOMailInfo starts");

		logger.info("Method :viewPOMailInfo ends"+id);
		return restPurchaseOrderDao.viewPOMailInfo(id);

	}
	
	//viewCrmPurchaseDetails
	@GetMapping(value = "viewCrmPurchaseDetails")
	public JsonResponse viewCrmPoDetails(@RequestParam String id) {
		logger.info("Method :viewCrmPoDetails starts");

		logger.info("Method :viewCrmPoDetails ends");
	return restPurchaseOrderDao.viewCrmPoDetails(id);
	}

	
			
}
