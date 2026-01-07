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
import nirmalya.aatithya.restmodule.sales.dao.RestSalesReplacementDao;
import nirmalya.aatithya.restmodule.sales.model.RestSalesReplacementModel;

@RestController
@RequestMapping("sales/")
public class RestSalesReplacementController {
	Logger logger = LoggerFactory.getLogger(RestSalesReplacementController.class);

	@Autowired

	RestSalesReplacementDao restSalesReplacementDao;
	
	@RequestMapping(value = "getSalesorderListR", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesorderListR(@RequestParam String id,String type) {
		logger.info("Method : getSalesorderListt starts");
		logger.info("Method : getSalesorderListt ends");
		return restSalesReplacementDao.getSalesorderListR(id,type);
	}
	@GetMapping(value = "getreplacementInsertedId")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getreplacementInsertedId() {
		logger.info("Method : getreplacementInsertedId starts");

		logger.info("Method : getreplacementInsertedId endss");
		return restSalesReplacementDao.getreplacementInsertedId();
	}
	@PostMapping(value = "addreplacementnew")
	public ResponseEntity<JsonResponse<List<RestSalesReplacementModel>>> addreplacementnew(@RequestBody List<RestSalesReplacementModel> restSalesReplacementModel) {
		logger.info("Method :addreplacementnew starts");
		logger.info(restSalesReplacementModel.toString());
		logger.info("Method :addreplacementnew endss");
		return restSalesReplacementDao.addreplacementnew(restSalesReplacementModel);
	}
	
	@RequestMapping(value = "rest-viewsalesReplacement", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestSalesReplacementModel>>> viewsalesReplacement() {

		logger.info("Method :viewsalesReplacement startssssssssssssssssss");

		logger.info("Method :viewsalesReplacement endss");
		return restSalesReplacementDao.viewsalesReplacement();
	}
		
		@GetMapping(value = "viewReplacementEdit")
		public List<RestSalesReplacementModel> viewReplacementEdit(@RequestParam String id) {
			logger.info("Method : viewReplacementEdit starts");
			//logger.info(id);
			logger.info("Method : viewReplacementEdit endss");
			return restSalesReplacementDao.viewReplacementEdit(id);
		}
		@RequestMapping(value = "/deletReplacement", method = { RequestMethod.GET})
		 public ResponseEntity<JsonResponse<Object>> deletReplacement(@RequestParam String id) {
			logger.info("Method : deletReplacement starts");

			logger.info("Method : deletReplacement ends");
			return restSalesReplacementDao.deletReplacement(id); 
		}
	
}
