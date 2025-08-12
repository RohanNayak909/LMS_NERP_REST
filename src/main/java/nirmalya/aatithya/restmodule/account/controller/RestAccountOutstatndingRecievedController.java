package nirmalya.aatithya.restmodule.account.controller;

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

import nirmalya.aatithya.restmodule.account.dao.RestAccountOutstatndingRecievedDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoicePaymentModel;


@RestController
@RequestMapping(value = "account")
public class RestAccountOutstatndingRecievedController {
	Logger logger = LoggerFactory.getLogger(RestAccountOutstatndingRecievedController.class);

	@Autowired
	RestAccountOutstatndingRecievedDao restAccountOutstatndingRecievedDao;
	
	/*
	 * @PostMapping(value = "getAllsalesInvoiceAccount") public
	 * JsonResponse<List<RestSalesInvoicePaymentModel>>
	 * getAllsalesInvoiceAccount(@RequestBody EmpRoleModel empModel) {
	 * logger.info("Method :getAllsalesInvoiceAccount starts"); String userId =
	 * empModel.getUserId(); String organization=empModel.getOrganization(); String
	 * orgDivision=empModel.getOrgDivision();
	 * logger.info("Method :getAllsalesInvoiceAccount endss"); return
	 * restAccountOutstatndingRecievedDao.getAllsalesInvoiceAccount(userId,
	 * organization,orgDivision);
	 * 
	 }*/
	
	@RequestMapping(value = "addPaymentInvoiceAccount", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addPaymentInvoice(@RequestBody RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {
		logger.info("Method : addPaymentInvoice starts"+restSalesInvoicePaymentModel);

		logger.info("Method : addPaymentInvoice ends");
		return restAccountOutstatndingRecievedDao.addPaymentInvoice(restSalesInvoicePaymentModel);
	}
	
	@RequestMapping(value = "getBankAccountList", method = { RequestMethod.GET })
	public List<DropDownModel> getBankAccountList(@RequestParam String org,String orgDiv) {
		logger.info("Method : getBankAccountList starts");
		
		logger.info("Method : getBankAccountList ends");
		return restAccountOutstatndingRecievedDao.getBankAccountList(org, orgDiv);
	}
	
	@GetMapping(value = "recievedScheduleDate")
	public JsonResponse<DropDownModel> recievedScheduleDate(@RequestParam String scheduledDate, String invoiceId) {
		logger.info("Method : recievedScheduleDate starts");

		logger.info("Method : recievedScheduleDate ends");
		return restAccountOutstatndingRecievedDao.recievedScheduleDate(scheduledDate, invoiceId);
	}
	
	@RequestMapping(value = "getAllsalesInvoiceAccount", method = { RequestMethod.GET })
	public JsonResponse<Object> viewOutstandingReceive(@RequestParam String orgName, String orgDivision, String fromDate, String toDate,String modOfSearch,String customerId) {
		logger.info("Method :viewOutstandingReceive start");

		logger.info("Method :viewOutstandingReceive endss");
		return restAccountOutstatndingRecievedDao.viewOutstandingReceive(orgName, orgDivision, fromDate, toDate,modOfSearch,customerId);

	}
	
	@RequestMapping(value = "getVoucherDetailsOutstandingRcv", method = { RequestMethod.GET })
	public JsonResponse<Object> getVoucherDetailsOutstandingRcv(@RequestParam String voucherId, String voucherType ,String orgName,String orgDivision) {
		logger.info("Method :getVoucherDetailsOutstandingRcv start");
		
		logger.info("Method :getVoucherDetailsOutstandingRcv ends");
		return restAccountOutstatndingRecievedDao.getVoucherDetailsOutstandingRcv(voucherId,orgName,orgDivision);
	}
}
