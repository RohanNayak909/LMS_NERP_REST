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

import nirmalya.aatithya.restmodule.account.dao.RestAccountSendAmountDao;
import nirmalya.aatithya.restmodule.account.model.RestManageSendAmountModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@RestController
@RequestMapping("account/")
public class RestAccountSendAmountController {
	Logger logger = LoggerFactory.getLogger(RestAccountSendAmountController.class);
	@Autowired
	RestAccountSendAmountDao restAccountSendAmountDao;
	
	//view
	@RequestMapping(value = "rest-viewSendAmount", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestManageSendAmountModel>>> restViewSendAmount(@RequestParam String orgName , @RequestParam String orgDivision,@RequestParam String fromdate,@RequestParam String todate) {
		logger.info("Method: restViewSendAmount View Start");

		logger.info("Method: restViewSendAmount ends");
		return restAccountSendAmountDao.restViewSendAmount(orgName,orgDivision,fromdate,todate);
	}
	
	@RequestMapping(value = "getGrnList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGrnList(@RequestParam String id) {
		logger.info("Method : getGrnList starts");
		
		logger.info("Method : getGrnList ends");
		return restAccountSendAmountDao.getGrnList(id);
	}
	
	@RequestMapping(value = "restAddPaymentGrn", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddPaymentGrn(@RequestBody RestManageSendAmountModel restManageSendAmountModel) {
		logger.info("Method : restAddPaymentGrn starts"+restManageSendAmountModel);

		logger.info("Method : restAddPaymentGrn  ends");

		return restAccountSendAmountDao.restAddPaymentGrn(restManageSendAmountModel);
	}
	
	@GetMapping(value = "restEditSendAmount")
	public ResponseEntity<JsonResponse<List<RestManageSendAmountModel>>> restEditSendAmount(@RequestParam String id) {
		logger.info("Method :restEditSendAmount starts");

		logger.info("Method :restEditSendAmount ends" + id);
		return restAccountSendAmountDao.restEditSendAmount(id);
	}
	
	@RequestMapping(value = "rest-deletePaymentDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePaymentDetails(@RequestParam String id) {
		logger.info("Method : deletePaymentDetails starts" + id);

		logger.info("Method : deletePaymentDetails ends");
		return restAccountSendAmountDao.deletePaymentDetails(id);
	}
	
	@GetMapping(value = "paymentApprovalAmount")
	public JsonResponse<RestManageSendAmountModel> paymentApprovalAmount(@RequestParam String paymentId, String userId) {
		logger.info("Method : paymentApprovalAmount starts");
		
		logger.info("Method : paymentApprovalAmount ends");
		return restAccountSendAmountDao.paymentApprovalAmount(paymentId, userId);
	}
	
	@RequestMapping(value = "getPaymentDetailsModal", method = { RequestMethod.GET })
	public JsonResponse<Object> getPaymentDetailsModal(@RequestParam String paymentId,@RequestParam String orgName , @RequestParam String orgDivision) {
		logger.info("Method :getPaymentDetailsModal start");

		logger.info("Method :getPaymentDetailsModal endss");
		return restAccountSendAmountDao.getPaymentDetailsModal(paymentId,orgName,orgDivision);

	}
}
