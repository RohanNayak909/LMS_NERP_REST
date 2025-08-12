package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.RestAccountOutstandingPaymentDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.account.model.RestSalesInvoicePaymentModel;

@RestController
@RequestMapping(value = "account")
public class RestAccountOutstandingPaymentController {
	
	Logger logger = LoggerFactory.getLogger(RestAccountOutstandingPaymentController.class);

	@Autowired
	RestAccountOutstandingPaymentDao restAccountOutstandingPaymentDao;
	
	@RequestMapping(value = "rest-viewOutstandingPayment", method = { RequestMethod.GET })
	public JsonResponse<Object> viewOutstandingPayment(@RequestParam String orgName, String orgDivision,String fromDate , String toDate,String modOfSearch , String customerId) {
		logger.info("Method :viewOutstandingPayment start");

		logger.info("Method :viewOutstandingPayment endss");
		return restAccountOutstandingPaymentDao.viewOutstandingPayment(orgName, orgDivision,fromDate,toDate,modOfSearch,customerId);
	}
	
	@RequestMapping(value = "addSendPaymentAccount", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addSendPaymentAccount(@RequestBody RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {
		logger.info("Method : addSendPaymentAccount starts"+restSalesInvoicePaymentModel);

		logger.info("Method : addSendPaymentAccount ends");
		return restAccountOutstandingPaymentDao.addSendPaymentAccount(restSalesInvoicePaymentModel);
	}
	
	@GetMapping(value = "paymentScheduleDate")
	public JsonResponse<DropDownModel> paymentScheduleDate(@RequestParam String scheduledDate, String invoiceId) {
		logger.info("Method : paymentScheduleDate starts");

		logger.info("Method : paymentScheduleDate ends");
		return restAccountOutstandingPaymentDao.paymentScheduleDate(scheduledDate, invoiceId);
	}
	
	@RequestMapping(value = "getVoucherPaymentVoucherDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> getVoucherPaymentVoucherDetails(@RequestParam String voucherId ,String orgName,String orgDivision) {
		logger.info("Method :getVoucherPaymentVoucherDetails start");
		
		logger.info("Method :getVoucherPaymentVoucherDetails ends");
		return restAccountOutstandingPaymentDao.getVoucherPaymentVoucherDetails(voucherId,orgName,orgDivision);
	}
	
	
	/*
	 * @GetMapping(value = "getDebitNoteList") public
	 * ResponseEntity<JsonResponse<List<RestSalesInvoicePaymentModel>>>
	 * getDebitNoteList(@RequestParam String id) {
	 * logger.info("Method :getDebitNoteList starts");
	 * 
	 * logger.info("Method :getDebitNoteList endss"); return
	 * restAccountOutstandingPaymentDao.getDebitNoteList(id);
	 * 
	 * }
	 */
	
}
