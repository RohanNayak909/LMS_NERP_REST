package nirmalya.aatithya.restmodule.sales.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.dao.RestInvoiceDao;
@RestController
@RequestMapping("sales/")
public class RestInvoiceController {
	Logger logger = LoggerFactory.getLogger(RestInvoiceController.class);

	@Autowired

	RestInvoiceDao restInvoiceDao;
	
	
	@GetMapping(value = "getInvoiceNewInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceNewInsertedId() {
		logger.info("Method : getInvoiceNewInsertedId starts");

		logger.info("Method : getInvoiceNewInsertedId endss");
		return restInvoiceDao.getInvoiceNewInsertedId();
}
	
	@RequestMapping(value = "rest-getChildData", method = { RequestMethod.GET })
	public JsonResponse getChildData(@RequestParam String org, String orgDiv) {
		logger.info("Method :getChildData start");

		logger.info("Method :getChildData endss");
		return restInvoiceDao.getChildData(org, orgDiv);

	}
}
