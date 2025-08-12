package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import nirmalya.aatithya.restmodule.account.dao.RestAccountReportsDao;
import nirmalya.aatithya.restmodule.account.dao.RestProductReportsDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;

@RestController
@RequestMapping(value = "account")
public class AccountProductReportRestController {
	Logger logger = LoggerFactory.getLogger(AccountProductReportRestController.class);
	@Autowired
	RestProductReportsDao restProductReportDao;
	
	@RequestMapping(value = "/purchaseTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> purchaseTypeList(@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method : purchaseTypeList starts");

		logger.info("Method : purchaseTypeList end");
		return restProductReportDao.purchaseTypeList(orgName,orgDiv);
	}
	
	@GetMapping(value = "rest-manage-getPurchaseData")
	public JsonResponse<Object> getPurchaseData(@RequestParam String fromDate,String toDate,String purchaseTypeId,String orgName,String orgDivision) {
		logger.info("Method : getPurchaseData starts");
		logger.info("Method :getPurchaseData endss");
		return restProductReportDao.getPurchaseData(fromDate,toDate,purchaseTypeId,orgName,orgDivision);
	}
	
	@GetMapping(value = "rest-manage-getSalesData")
	public JsonResponse<Object> getSalesData(@RequestParam String fromDate,String toDate,String salesTypeId ,String orgName,String orgDiv) {
		logger.info("Method : getSalesData starts");
		logger.info("Method :getSalesData endss");
		return restProductReportDao.getSalesData(fromDate,toDate,salesTypeId,orgName,orgDiv);
	}
	
	@GetMapping(value = "rest-manage-getFilterData")
	public JsonResponse<Object> getFilterData(@RequestParam String type,String fromDate,String todate,String purchaseTypeId ,String salesTypeId) {
		logger.info("Method : getFilterData starts");
		logger.info("Method :getFilterData endss");
		return restProductReportDao.getFilterData(type,fromDate,todate,purchaseTypeId,salesTypeId);
	}
	
	@GetMapping(value = "getProductCategory")
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategory() {
		logger.info("Method : getProductCategory starts");

		logger.info("Method : getProductCategory ends");
		return restProductReportDao.getProductCategory();
	}


}
