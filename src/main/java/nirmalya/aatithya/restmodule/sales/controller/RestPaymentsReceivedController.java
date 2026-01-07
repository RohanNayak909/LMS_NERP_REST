package nirmalya.aatithya.restmodule.sales.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.dao.RestPaymentsReceivedDao;
import nirmalya.aatithya.restmodule.sales.model.RestPaymentsReceivedModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoicePaymentModel;

@RestController
@RequestMapping("sales/")
public class RestPaymentsReceivedController {
Logger logger = LoggerFactory.getLogger(RestPaymentsReceivedController.class);
	
	@Autowired
	
	RestPaymentsReceivedDao restPaymentsReceivedDao;
	
	@GetMapping(value = "getAccountsByAutoSearch")
	public ResponseEntity<JsonResponse<List<RestPaymentsReceivedModel>>> getAccountsByAutoSearch(
			@RequestParam String id) {
		logger.info("Method :getAccountsByAutoSearch starts");

		logger.info("Method :getSalesPersonListByAutoSearch endss");
		return restPaymentsReceivedDao.getAccountsByAutoSearch(id);
	}
	
	@RequestMapping(value = "getSalesInvoiceList1", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesInvoiceList1(@RequestParam String id,String type) {
		logger.info("Method : getSalesInvoiceList1 starts");
		logger.info("Method : getSalesInvoiceList1 ends");
		return restPaymentsReceivedDao.getSalesInvoiceList1(id,type);
	}
	/*
	 * add
	 */
	@PostMapping(value = "addpaymentsreceived")
	public ResponseEntity<JsonResponse<List<RestPaymentsReceivedModel>>> addpaymentsreceived(@RequestBody List<RestPaymentsReceivedModel> restPaymentsReceivedModel) {
		logger.info("Method :addpaymentsreceived starts");
		
		logger.info("Method :addpaymentsreceived endss");
		return restPaymentsReceivedDao.addpaymentsreceived(restPaymentsReceivedModel);
	}
	
	@RequestMapping(value = "rest-viewsalespaymentsreceived", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestSalesInvoicePaymentModel>>> viewsalespaymentsreceived(@RequestParam String orgName,@RequestParam String orgDiv,@RequestParam String fromdate,@RequestParam String todate) {

		logger.info("Method :viewsalespaymentsreceived startssssssssssssssssss");

		logger.info("Method :viewsalespaymentsreceived endss");
		return restPaymentsReceivedDao.viewsalespaymentsreceived(orgName,orgDiv,fromdate,todate);

	}
	
	@GetMapping(value = "viewPaymentReceivedEdit")
	public List<RestPaymentsReceivedModel> viewPaymentReceivedEdit(@RequestParam String id) {
		logger.info("Method : viewPaymentReceivedEdit starts");
		//logger.info(id);
		logger.info("Method : viewPaymentReceivedEdit endss");
		return restPaymentsReceivedDao.viewPaymentReceivedEdit(id);
	}
	
	@GetMapping(value = "getpayment")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getpayment() {
		logger.info("Method : getpayment starts");

		logger.info("Method : getpayment endss");
		return restPaymentsReceivedDao.getpayment();
	}
	
	
 	@RequestMapping(value = "/deletPayment", method = { RequestMethod.GET})
	 public ResponseEntity<JsonResponse<Object>> deletPayment(@RequestParam String id) {
		logger.info("Method : deletPayment starts");

		logger.info("Method : deletPayment ends");
		return restPaymentsReceivedDao.deletPayment(id); 
	}
 	
 	@GetMapping(value = "getPaymentInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPaymentInsertedId() {
		logger.info("Method : getPaymentInsertedId starts");

		logger.info("Method : getPaymentInsertedId endss");
		return restPaymentsReceivedDao.getPaymentInsertedId();
	}
 	
 	@GetMapping(value = "saveBulkPayment")
	public JsonResponse<RestSalesInvoicePaymentModel> saveBulkPayment(@RequestParam String userId, String bulkAmount, String orgName, String orgDivision) {
		logger.info("Method : saveBulkPayment starts");

		logger.info("Method : saveBulkPayment ends");
		return restPaymentsReceivedDao.saveBulkPayment(userId, bulkAmount, orgName, orgDivision);
	}
 	
	@RequestMapping(value = "getReceiveDetailsModal", method = { RequestMethod.GET })
	public JsonResponse<Object> getReceiveDetailsModal(@RequestParam String paymentId,@RequestParam String orgName , @RequestParam String orgDivision) {
		logger.info("Method :getReceiveDetailsModal start");

		logger.info("Method :getReceiveDetailsModal endss");
		return restPaymentsReceivedDao.getReceiveDetailsModal(paymentId,orgName,orgDivision);

	}
}
