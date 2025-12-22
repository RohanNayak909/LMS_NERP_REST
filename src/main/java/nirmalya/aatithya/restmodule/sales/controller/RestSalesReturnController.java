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
import nirmalya.aatithya.restmodule.sales.dao.RestSalesReturnDao;
import nirmalya.aatithya.restmodule.sales.model.RestSalesReturnModel;

@RestController
@RequestMapping("customer/")
public class RestSalesReturnController {

	Logger logger = LoggerFactory.getLogger(RestSalesReturnController.class);

	@Autowired

	RestSalesReturnDao restSalesReturnDao;
	
	
	
	@RequestMapping(value = "getReturnList", method = { RequestMethod.GET })
	public List<DropDownModel> getReturnList() {
		logger.info("Method : getReturnList starts");

		logger.info("Method : getReturnList ends");
		return restSalesReturnDao.getReturnList();
	}
	
	@RequestMapping(value = "getSalesorderList1",method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesorderList1(@RequestParam String id,String type) {
		logger.info("Method : getSalesorderList1 starts");
		logger.info("Method : getSalesorderList1 ends");
		return restSalesReturnDao.getSalesorderList1(id,type);
	}
	
	/*
	 * add
	 */
	@PostMapping(value = "addsaleReturn")
	public ResponseEntity<JsonResponse<List<RestSalesReturnModel>>> addsaleReturn(@RequestBody List<RestSalesReturnModel> restSalesReturnModel) {
		logger.info("Method :addsaleReturn starts");
		
		logger.info("Method :addsaleReturn endss");
		return restSalesReturnDao.addsaleReturn(restSalesReturnModel);
	}
	
	@RequestMapping(value = "rest-viewsalesreturn", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestSalesReturnModel>>> viewsalesreturn() {

		logger.info("Method :viewsalesreturn startssssssssssssssssss");

		logger.info("Method :viewsalesreturn endss");
		return restSalesReturnDao.viewsalesreturn();

	}
	
	/*
	 * edit
	 */ @GetMapping(value = "viewSalesreturnEdit")
	public List<RestSalesReturnModel> viewSalesreturnEdit(@RequestParam String id) {
		logger.info("Method : viewSalesreturnEdit starts");
		// logger.info(id);
		logger.info("Method : viewSalesreturnEdit endss");
		return restSalesReturnDao.viewSalesreturnEdit(id);
	}
	 

	 /*delete
	  * 	 
	  */
		@RequestMapping(value = "rest-deleteSalesReturn", method = { RequestMethod.GET })
		public JsonResponse<Object> deleteSalesReturn(@RequestParam String id, String org,String orgDiv) {
			logger.info("Method :deleteSalesReturn start");

			logger.info("Method :deleteSalesReturn endss");
			return restSalesReturnDao.deleteSalesReturn(id,org, orgDiv);
		}
	 	 
	 	@GetMapping(value = "getSalesReturntInsertedId")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesReturntInsertedId() {
			logger.info("Method : getSalesReturntInsertedId starts");

			logger.info("Method : getSalesReturntInsertedId endss");
			return restSalesReturnDao.getSalesReturntInsertedId();
		}
	 	
		/*
		 * approveSalesReturn
		 */

		@PostMapping(value = "approveSalesReturn")
		public ResponseEntity<JsonResponse<Object>> approveSalesReturn(@RequestBody RestSalesReturnModel restSalesReturnModel) {
			logger.info("Method : approveSalesReturn starts");

			logger.info("Method : approveSalesReturn ends");
			return restSalesReturnDao.approveSalesReturn(restSalesReturnModel);
		}
}
