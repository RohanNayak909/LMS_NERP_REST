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
import nirmalya.aatithya.restmodule.sales.dao.RestPoOrWoDao;
import nirmalya.aatithya.restmodule.sales.model.RestPoOrWoModel;



@RestController
@RequestMapping("sales/")
public class RestPoOrWoController {
	Logger logger = LoggerFactory.getLogger(RestPoOrWoController.class);

	@Autowired

	RestPoOrWoDao RestPoOrWoDao;
	
	
	
	/*
	 * add
	 */
	@PostMapping(value = "addSalesPo")
	public ResponseEntity<JsonResponse<List<RestPoOrWoModel>>> addSalesPo(
			@RequestBody List<RestPoOrWoModel> restPoOrWoModel) {
		logger.info("Method :addSalesPo starts");
		logger.info(restPoOrWoModel.toString());
		logger.info("Method :addSalesPo endss");
		return RestPoOrWoDao.addSalesPo(restPoOrWoModel);
	}
	
	/*
	 * view
	 * 
	 */
	@RequestMapping(value = "rest-viewsalesPo", method = { RequestMethod.GET })
	public JsonResponse<Object> viewsalesPo(@RequestParam String orgName, @RequestParam String orgDivision,String pageno,String userId, String fDate, String tDate) {
		logger.info("Method :viewsalesPo start");

		logger.info("Method :viewsalesPo endss");
		return RestPoOrWoDao.viewsalesPo(orgName, orgDivision, pageno,userId,fDate,tDate);

	}
	
	
	/*
	 * edit
	 */
	@GetMapping(value = "viewsalesPoEdit")
	public List<RestPoOrWoModel> viewsalesPoEdit(@RequestParam String id,@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : viewsalesPoEdit starts");
		
		logger.info("Method : viewsalesPoEdit endss");
		return RestPoOrWoDao.viewsalesPoEdit(id,org,orgDiv);
	}
	
	 /*delete
	  * 	 
	  */
	 	 @PostMapping(value = "deleteSalesPo")
	 		public ResponseEntity<JsonResponse<Object>> deleteSalesPo(
	 				@RequestBody RestPoOrWoModel restPoOrWoModel) {
	 			logger.info("Method : deletePo starts");
	 			//logger.info(restSalesInvoiceNewModel);
	 			logger.info("Method : deletePo ends");
	 			return RestPoOrWoDao.deleteSalesPo(restPoOrWoModel);
	 }
	 	 
	 	@GetMapping(value = "getSoData")
		public List<RestPoOrWoModel> getSoData(@RequestParam String id,String skuid, String org,String orgDiv) {
			logger.info("Method : getSoData starts");
			logger.info("Method : getSoData endss");
			return RestPoOrWoDao.getSoData(id,skuid,org,orgDiv);
		}
	 	
	 // Block Order
		/*
		 * @GetMapping(value="blockSaleOrder") public JsonResponse<RestPoOrWoModel>
		 * blockSaleOrder(@RequestParam String blockeOrder, String referenceId,String
		 * sku){ logger.info("Method : blockSaleOrder starts");
		 * 
		 * logger.info("Method : blockSaleOrder ends"); return
		 * RestPoOrWoDao.blockSaleOrder(blockeOrder, referenceId,sku); }
		 */
	 	@GetMapping(value = "viewsalesCreateversionEdit")
		public List<RestPoOrWoModel> viewsalesCreateversionEdit(@RequestParam String id,@RequestParam String org,
				@RequestParam String orgDiv) {
			logger.info("Method : viewsalesCreateversionEdit starts");
			
			logger.info("Method : viewsalesCreateversionEdit endss");
			return RestPoOrWoDao.viewsalesCreateversionEdit(id,org,orgDiv);
		}
	 	
	 	@GetMapping("rest-get-quotation")
		public JsonResponse<Object> getQuotationOnselectedCustomer(@RequestParam String custId, @RequestParam String orgName,
				@RequestParam String orgDiv) {
			logger.info("Method :getQuotationOnselectedCustomer start");

			logger.info("Method :getQuotationOnselectedCustomer ends");
			return RestPoOrWoDao.getQuotationOnselectedCustomer(custId,orgName,orgDiv);
		}
	 	
	 	@GetMapping("rest-get-quotation-details")
		public JsonResponse<Object> getQuotationDetails(@RequestParam String quotationId, @RequestParam String orgName,
				@RequestParam String orgDiv) {
			logger.info("Method :getQuotationDetails start");

			logger.info("Method :getQuotationDetails ends");
			return RestPoOrWoDao.getQuotationDetails(quotationId,orgName,orgDiv);
		}
	 	
	 	@RequestMapping(value = "rest-approvePoWodata", method = { RequestMethod.GET })
		public JsonResponse<Object> approvePoWodata(@RequestParam String poId, String org,String orgDiv,String poRef) {
			logger.info("Method :approvePoWodata start");

			logger.info("Method :approvePoWodata endss");
			return RestPoOrWoDao.approvePoWodata(poId,org,orgDiv,poRef);
		}
//
	 	@PostMapping(value = "add-shipping-addressPO")
		public JsonResponse<Object> addShippingAddressRestPO(@RequestBody DropDownModel data) {
			logger.info("Method : addShippingAddressRestPO starts");
			
			logger.info("Method : addShippingAddressRestPO ends");
			return RestPoOrWoDao.addShippingAddressDaoPO(data);
		}
}
