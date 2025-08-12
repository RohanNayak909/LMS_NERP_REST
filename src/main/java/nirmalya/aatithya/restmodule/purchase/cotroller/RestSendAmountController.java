package nirmalya.aatithya.restmodule.purchase.cotroller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.dao.RestSendAmountDao;
import nirmalya.aatithya.restmodule.purchase.model.RestManageSendAmountModel;

@RestController
@RequestMapping("purchase/")
public class RestSendAmountController {
	Logger logger = LoggerFactory.getLogger(RestSendAmountController.class);
	@Autowired
	RestSendAmountDao restSendAmountDao;
	
	//view
	@RequestMapping(value = "rest-viewSendAmount", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestManageSendAmountModel>>> restViewSendAmount() {
		logger.info("Method: restViewSendAmount View Start");

		logger.info("Method: restViewSendAmount ends");
		return restSendAmountDao.restViewSendAmount();
	}
	
	@RequestMapping(value = "getGrnList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGrnList(@RequestParam String id) {
		logger.info("Method : getGrnList starts");
		
		logger.info("Method : getGrnList ends");
		return restSendAmountDao.getGrnList(id);
	}
	
	@RequestMapping(value = "restAddPaymentGrn", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddPaymentGrn(@RequestBody RestManageSendAmountModel restManageSendAmountModel) {
		logger.info("Method : restAddPaymentGrn starts"+restManageSendAmountModel);

		logger.info("Method : restAddPaymentGrn  ends");

		return restSendAmountDao.restAddPaymentGrn(restManageSendAmountModel);
	}
	
	@GetMapping(value = "restEditSendAmount")
	public ResponseEntity<JsonResponse<List<RestManageSendAmountModel>>> restEditSendAmount(@RequestParam String id) {
		logger.info("Method :restEditSendAmount starts");

		logger.info("Method :restEditSendAmount ends" + id);
		return restSendAmountDao.restEditSendAmount(id);
	}
	
	@RequestMapping(value = "rest-deletePaymentDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePaymentDetails(@RequestParam String id) {
		logger.info("Method : deletePaymentDetails starts" + id);

		logger.info("Method : deletePaymentDetails ends");
		return restSendAmountDao.deletePaymentDetails(id);
	}
	
	@GetMapping(value = "paymentApprovalAmount")
	public JsonResponse<RestManageSendAmountModel> paymentApprovalAmount(@RequestParam String paymentId, String userId) {
		logger.info("Method : paymentApprovalAmount starts");
		
		logger.info("Method : paymentApprovalAmount ends");
		return restSendAmountDao.paymentApprovalAmount(paymentId, userId);
	}
}
