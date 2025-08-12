package nirmalya.aatithya.restmodule.pos.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmProductModel;
import nirmalya.aatithya.restmodule.pos.dao.POSOrderDao;
import nirmalya.aatithya.restmodule.pos.model.POSCustomerDetailsRestModel;
import nirmalya.aatithya.restmodule.pos.model.PosInvoiceRestModel;

@RestController
@RequestMapping(value = "shoukeen")
public class PosOrderRestController {
	Logger logger = LoggerFactory.getLogger(PosOrderRestController.class);
	@Autowired
	POSOrderDao pOSOrderDao;
	/*
	 * for view
	 */
	@RequestMapping(value="restViewposOrder" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<POSCustomerDetailsRestModel>>> viewPosOrder(@RequestParam String id,String pageno){
		logger.info("Method: viewPosOrder View Start");
		
		logger.info("Method: viewPosOrder ends");
		return pOSOrderDao.viewPosOrder(id,pageno);
	}
	
	
	@GetMapping(value = "restViewInvoice")
	public ResponseEntity<JsonResponse<POSCustomerDetailsRestModel>> restViewInvoice(@RequestParam String id) {
		logger.info("Method :restViewInvoice starts");

		logger.info("Method :restViewInvoice ends"+id);
		return pOSOrderDao.restViewInvoice(id);

	}
	
	
	
	@GetMapping(value = "restViewInvoicePdf")
	public ResponseEntity<JsonResponse<List<PosInvoiceRestModel>>> restViewInvoicePdf(@RequestParam String id) {
		logger.info("Method :restViewInvoicePdf starts");

		logger.info("Method :restViewInvoicePdf ends" + id);
		return pOSOrderDao.restViewInvoicePdf(id);

	}
	
	

}
