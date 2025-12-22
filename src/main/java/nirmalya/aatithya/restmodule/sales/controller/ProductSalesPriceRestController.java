package nirmalya.aatithya.restmodule.sales.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.dao.ProductSalesPriceDao;

@RestController
@RequestMapping(value = "sales/")
public class ProductSalesPriceRestController {
	Logger logger = LoggerFactory.getLogger(RestCustomerDashBoardController.class);

	@Autowired
	ProductSalesPriceDao productSalesDao;

	@GetMapping("rest-get-product-details")
	public JsonResponse<Object> getProductDetais(@RequestParam String orgName, @RequestParam String orgDiv,
			@RequestParam String skuId) {
		logger.info("Method :getProductDetais start");

		logger.info("Method :getProductDetais ends");
		return productSalesDao.getProductDetais(orgName, orgDiv, skuId);
	}

	@PostMapping("rest-save-sales-price")
	public JsonResponse<Object> saveSalesPrice(@RequestBody List<Map<String, Object>> dataset,
			@RequestParam String organization, @RequestParam String orgDivision, @RequestParam String createdById) {
		logger.info("Method : saveSalesPrice starts");

		logger.info("Method : saveSalesPrice ends");
		return productSalesDao.saveSalesPrice(dataset,organization,orgDivision,createdById);
	}
	
	@GetMapping("rest-delete-sales-item")
	public JsonResponse<Object> deleteSlaesItem(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String slNo) {
		logger.info("Method :deleteSlaesItem start");

		logger.info("Method :deleteSlaesItem ends");
		return productSalesDao.deleteSlaesItem(orgName,orgDivision,slNo);
	}
	
	@GetMapping("get-grn-data")
	public JsonResponse<Object> getGRNDataRest(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String pageno) {
		logger.info("Method :getGRNDataRest start");
		
		logger.info("Method :getGRNDataRest ends");
		return productSalesDao.getGRNDataRest(org,orgDiv,pageno);
	}
	
	@GetMapping("get-sales-price-data")
	public JsonResponse<Object> getSalesPriceDataRest(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String pageno) {
		logger.info("Method :getSalesPriceDataRest start");
		
		logger.info("Method :getSalesPriceDataRest ends");
		return productSalesDao.getSalesPriceDataRest(org,orgDiv,pageno);
	}
}
