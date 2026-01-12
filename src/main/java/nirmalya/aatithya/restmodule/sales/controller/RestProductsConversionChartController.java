package nirmalya.aatithya.restmodule.sales.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.dao.RestProductsConversionChartDao;
import nirmalya.aatithya.restmodule.sales.model.RestProductsConversionChartModel;


@RestController
@RequestMapping(value = "sales")
public class RestProductsConversionChartController {
	
	Logger logger = LoggerFactory.getLogger(RestProductsConversionChartController.class);
	
	@Autowired
	RestProductsConversionChartDao restProductsConversionChartDao;
	
	@RequestMapping(value = "getProductConversionList", method = { RequestMethod.GET })
	public List<RestProductsConversionChartModel> getProductConversionList(@RequestParam String orgName, String orgDiv) {
		logger.info("Method : getProductConversionList starts");
		
		logger.info("Method : getProductConversionList");
		return restProductsConversionChartDao.getProductConversionList(orgName, orgDiv);
	}
	
	@RequestMapping(value="restAddProductConversion" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddProductConversion(@RequestBody RestProductsConversionChartModel restProductsConversionChartModel) {
		logger.info("Method : restAddProductConversion starts");
		
		logger.info("Method : restAddProductConversion ends");
		return restProductsConversionChartDao.restAddProductConversion(restProductsConversionChartModel);
	}
	
	@RequestMapping(value = "restViewProductConversionChart", method = { RequestMethod.GET })
	public JsonResponse<Object> restViewProductConversionChart(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :restViewProductConversionChart start");
		
		logger.info("Method :restViewProductConversionChart endss");
		return restProductsConversionChartDao.restViewProductConversionChart(orgName, orgDivision);

	}
	
	@RequestMapping(value = "restEditProductConversionChart", method = { RequestMethod.GET })
	public JsonResponse<Object> restEditProductConversionChart(@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String id) {
		logger.info("Method :restEditProductConversionChart start");
		
		logger.info("Method :restEditProductConversionChart endss");
		return restProductsConversionChartDao.restEditProductConversionChart(orgName, orgDivision, id);

	}
}
