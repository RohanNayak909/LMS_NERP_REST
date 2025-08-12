package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.ProductVendorReportDao;
import nirmalya.aatithya.restmodule.master.model.RestProductVendorReportModel;
@RestController
@RequestMapping("master/")
public class RestProductVendorReportController {
Logger logger = LoggerFactory.getLogger(RestProductVendorReportController.class);
	
	@Autowired
	ProductVendorReportDao productVendorReportDao;
	
	//viewProductVendorReport
	@RequestMapping(value = "viewProductVendorReport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestProductVendorReportModel>>> viewProductVendorReport(@RequestParam String org,@RequestParam String orgDiv) {
		logger.info("Method :viewProductVendorReport starts");
		
		logger.info("Method :viewProductVendorReport endss");
		return productVendorReportDao.viewProductVendorReport(org,orgDiv);
	}
}
