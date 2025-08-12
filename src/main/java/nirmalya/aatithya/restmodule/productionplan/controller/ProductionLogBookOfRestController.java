package nirmalya.aatithya.restmodule.productionplan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.productionplan.dao.ProductionLogBookOfDao;
import nirmalya.aatithya.restmodule.productionplan.model.ProductionLogBookOfRestModel;




@RestController
@RequestMapping(value = { "production/" })
public class ProductionLogBookOfRestController {
	
Logger logger = LoggerFactory.getLogger(ProductionLogBookOfRestController.class);
	
	@Autowired
	ProductionLogBookOfDao productionLogBookOfDao;
	
	
	

	// getAggridData
	@RequestMapping(value = "rest-getProductionLogOfAggridDatas", method = { RequestMethod.GET })
	public JsonResponse<Object> getProductionLogOfAggridDatas(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getProductionLogOfAggridDatas start");

		logger.info("Method :getProductionLogOfAggridDatas endss");
		return productionLogBookOfDao.getProductionLogOfAggridDatas(orgName, orgDivision);
	}
	
	// add.
	
	@PostMapping(value = "rest-addProductionLogBookOf")
	public ResponseEntity<JsonResponse<ProductionLogBookOfRestModel>> addProductionLogBookOf(

			@RequestBody ProductionLogBookOfRestModel productionLogBookOfRestModel) {
		logger.info("Method : addProductionLogBookOf starts");
		logger.info("Method : addProductionLogBookOf ends");
		return productionLogBookOfDao.addProductionLogBookOf(productionLogBookOfRestModel);
	}
	
	
	// View
	@RequestMapping(value = "rest-getProductionLogOfView", method = { RequestMethod.GET })
	public JsonResponse<Object> getProductionLogOfView(@RequestParam String orgName, String orgDivision, String pageno) {
		logger.info("Method :getProductionLogOfView start");

		logger.info("Method :getProductionLogOfView endss");
		return productionLogBookOfDao.getProductionLogOfView(orgName, orgDivision, pageno);
	}
	
	//Edit.
	
	@RequestMapping(value = "rest-editProductionLogOf", method = { RequestMethod.GET })
	public JsonResponse<Object> editProductionLogOf(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editProductionLogOf start");

		logger.info("Method :editProductionLogOf endss");
		return productionLogBookOfDao.editProductionLogOf(id, orgName, orgDivision);
	}
	
	// Delete.
	
	@RequestMapping(value = "rest-deleteProductionLogOf", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteProductionLogOf(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :deleteProductionLogOf start");

		logger.info("Method :deleteProductionLogOf endss");
		return productionLogBookOfDao.deleteProductionLogOf(id, orgName, orgDivision);
	}
	
	// Approve.
	
		@RequestMapping(value = "rest-approveProductionLogOf", method = { RequestMethod.GET })
		public JsonResponse<Object> approveProductionLogOf(@RequestParam String id, String orgName, String orgDivision, String userId) {
			logger.info("Method :approveProductionLogOf start");

			logger.info("Method :approveProductionLogOf endss");
			return productionLogBookOfDao.approveProductionLogOf(id, orgName, orgDivision, userId);
		}
	
	
	
	
	// Pdf.
	
	@RequestMapping(value = "rest-getProductionLogOfPdfDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> getProductionLogOfPdfDtls(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :getProductionLogOfPdfDtls start");

		logger.info("Method :getProductionLogOfPdfDtls endss");
		return productionLogBookOfDao.getProductionLogOfPdfDtls(id, orgName, orgDivision);
	}
	
	// View
		@RequestMapping(value = "rest-searchProductionLogOfView", method = { RequestMethod.GET })
		public JsonResponse<Object> searchProductionLogOfView(@RequestParam String orgName, String orgDivision, String value) {
			logger.info("Method :searchProductionLogOfView start");

			logger.info("Method :searchProductionLogOfView endss");
			return productionLogBookOfDao.searchProductionLogOfView(orgName, orgDivision, value);
		}

}
