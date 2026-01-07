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
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmInvoiceDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmInvoiceModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "pipeline")
public class RestCrmInvoiceController {
	Logger logger = LoggerFactory.getLogger(RestCrmInvoiceController.class);
	@Autowired
	RestCrmInvoiceDao restCrmInvoiceDao;

	//addCRMInvoice
	
	@PostMapping(value = "addCRMInvoice")
	public ResponseEntity<JsonResponse<List<RestCrmInvoiceModel>>> addCRMInvoice(@RequestBody List<RestCrmInvoiceModel> restCrmInvoiceModel) {
		logger.info("Method :addCRMInvoice starts");
		logger.info("rest controller--------------------------------addCRMInvoice");
		logger.info("Method :addCRMInvoice endss");
		return restCrmInvoiceDao.addCRMInvoice(restCrmInvoiceModel);
	}	
			
	//viewCRMInvoice
	
	@GetMapping(value = "viewCRMInvoice")
	public JsonResponse<List<RestCrmInvoiceModel>> viewCRMInvoice() {
		logger.info("Method :viewCRMInvoice starts");
		
		
		logger.info("Method :viewCRMInvoice endss");
		return restCrmInvoiceDao.viewCRMInvoice();
		
	}
	
	//viewCRMInvoiceEdit
		@GetMapping(value = "viewCRMInvoiceEdit")
		public List<RestCrmInvoiceModel> viewCRMInvoiceEdit(@RequestParam String id) {
			logger.info("Method : viewCRMInvoiceEdit starts");
			//logger.info(id);
			logger.info("Method : viewCRMInvoiceEdit endss");
			return restCrmInvoiceDao.viewCRMInvoiceEdit(id);
		}
		
		//deleteCRMInvoice
		@PostMapping(value = "deleteCRMInvoice")
		public ResponseEntity<JsonResponse<Object>> deleteCRMInvoice(@RequestBody RestCrmInvoiceModel restCrmInvoiceModel) {
			logger.info("Method : deleteCRMInvoice starts");
			logger.info("Method : deleteCRMInvoice ends");
			return restCrmInvoiceDao.deleteCRMInvoice(restCrmInvoiceModel);
		}
		
		//view-rest-InvoiceInfo
		
		@GetMapping(value = "view-rest-InvoiceInfo")
		public ResponseEntity<JsonResponse<List<RestCrmInvoiceModel>>> viewInvoiceInfo(@RequestParam String id) {
			logger.info("Method :viewInvoiceInfo starts");

			logger.info("Method :viewInvoiceInfo ends"+id);
			return restCrmInvoiceDao.viewInvoiceInfo(id);

		}
		
		//view-rest-InvoiceMailInfo
		
		@GetMapping(value = "view-rest-InvoiceMailInfo")
		public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewInvoiceMailInfo(@RequestParam String id) {
			logger.info("Method :viewInvoiceMailInfo starts");

			logger.info("Method :viewInvoiceMailInfo ends"+id);
			return restCrmInvoiceDao.viewInvoiceMailInfo(id);

		}
		
		//viewCrmPurchaseDetails
		@GetMapping(value = "viewCrmInvoices")
		public JsonResponse viewCrmInvoices(@RequestParam String id) {
			logger.info("Method :viewCrmInvoices starts");

			logger.info("Method :viewCrmInvoices ends");
		return restCrmInvoiceDao.viewCrmInvoices(id);
		}

}
