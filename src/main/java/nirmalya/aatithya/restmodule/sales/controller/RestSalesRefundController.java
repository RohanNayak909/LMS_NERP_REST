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
import nirmalya.aatithya.restmodule.sales.dao.RestSalesRefundDao;
import nirmalya.aatithya.restmodule.sales.model.RestSalesRefundModel;

@RestController
@RequestMapping("sales/")
public class RestSalesRefundController {
	Logger logger = LoggerFactory.getLogger(RestSalesRefundController.class);

	@Autowired

	RestSalesRefundDao restSalesRefundDao;
	
	@RequestMapping(value = "getSalesorderListt", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesorderListt(@RequestParam String id,String type) {
		logger.info("Method : getSalesorderListt starts");
		logger.info("Method : getSalesorderListt ends");
		return restSalesRefundDao.getSalesorderListt(id,type);
	}
	
	@RequestMapping(value = "getPaymentModeLists", method = { RequestMethod.GET })
	public List<DropDownModel> getPaymentModeLists() {
		logger.info("Method : getPaymentModeLists starts");

		logger.info("Method : getPaymentModeLists ends");
		return restSalesRefundDao.getPaymentModeLists();
	}
	

	@GetMapping(value = "getRefundInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRefundInsertedId() {
		logger.info("Method : getRefundInsertedId starts");

		logger.info("Method : getRefundInsertedId endss");
		return restSalesRefundDao.getRefundInsertedId();
	}
	
	@PostMapping(value = "addrefundnew")
	public ResponseEntity<JsonResponse<List<RestSalesRefundModel>>> addrefundnew(@RequestBody List<RestSalesRefundModel> restSalesRefundModel) {
		logger.info("Method :addrefundnew starts");
		logger.info(restSalesRefundModel.toString());
		logger.info("Method :addrefundnew endss");
		return restSalesRefundDao.addrefundnew(restSalesRefundModel);
	}
	
	@RequestMapping(value = "rest-viewsalesRefund", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestSalesRefundModel>>> viewsalesRefund() {

		logger.info("Method :viewsalesRefund startssssssssssssssssss");

		logger.info("Method :viewsalesRefund endss");
		return restSalesRefundDao.viewsalesRefund();

	}
	
	@GetMapping(value = "viewRefundEdit")
	public List<RestSalesRefundModel> viewRefundEdit(@RequestParam String id) {
		logger.info("Method : viewRefundEdit starts");
		//logger.info(id);
		logger.info("Method : viewRefundEdit endss");
		return restSalesRefundDao.viewRefundEdit(id);
	}
	
	@RequestMapping(value = "/deletRefund", method = { RequestMethod.GET})
	 public ResponseEntity<JsonResponse<Object>> deletRefund(@RequestParam String id) {
		logger.info("Method : deletRefund starts");

		logger.info("Method : deletRefund ends");
		return restSalesRefundDao.deletRefund(id); 
	}
}
