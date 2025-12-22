package nirmalya.aatithya.restmodule.pipeline.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.dao.RestQuoteDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmQuoteModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "pipeline")
public class RestCrmQuoteController {
	Logger logger = LoggerFactory.getLogger(RestCrmQuoteController.class);
	@Autowired
	RestQuoteDao restQuoteDao;

	
	
	
	//getItemNameList
	
	@GetMapping(value = "getItemQuoteAutoSearchList")
	public ResponseEntity<JsonResponse<List<RestCrmQuoteModel>>> getItemQuoteAutoSearchList(
			@RequestParam String id) {
		logger.info("Method : getItemQuoteAutoSearchList starts");

		logger.info("Method :getItemQuoteAutoSearchList endss");
		return restQuoteDao.getItemQuoteAutoSearchList(id);
	}
	
	
	//getAllCRMQuotation
	
	@GetMapping(value = "getAllCRMQuotation")
	public JsonResponse<List<RestCrmQuoteModel>> getAllCRMQuotation() {
		logger.info("Method :getAllCRMQuotation starts");
		
		
		logger.info("Method :getAllCRMQuotation endss");
		return restQuoteDao.getAllCRMQuotation();
		
	}
	
	//deleteCRMItemQuotation
	

		@PostMapping(value = "deleteCRMItemQuotation")
		public ResponseEntity<JsonResponse<Object>> deleteCRMItemQuotation(

				@RequestBody RestCrmQuoteModel restCrmQuoteModel) {
			logger.info("Method : deleteCRMItemQuotation starts");
			logger.info("Method : deleteCRMItemQuotation ends");
			return restQuoteDao.deleteCRMItemQuotation(restCrmQuoteModel);
		}
		
		
		//viewCRMQuotationEdit
		

		@GetMapping(value = "viewCRMQuotationEdit")
		public List<RestCrmQuoteModel> viewCRMQuotationEdit(@RequestParam String id) {
			logger.info("Method : viewCRMQuotationEdit starts");
			//logger.info(id);
			logger.info("Method : viewCRMQuotationEdit endss");
			return restQuoteDao.viewCRMQuotationEdit(id);
		}
		
		//addCRMQuotation
		
		@PostMapping(value = "addCRMQuotation")
		public ResponseEntity<JsonResponse<List<RestCrmQuoteModel>>> addCRMQuotation(@RequestBody List<RestCrmQuoteModel> restCrmQuoteModel) {
			logger.info("Method :addCRMQuotation starts");
			logger.info("rest controller--------------------------------addCRMQuotation");
			logger.info("Method :addCRMQuotation endss");
			return restQuoteDao.addCRMQuotation(restCrmQuoteModel);
		}

		//view-rest-QuoteInfo
		@GetMapping(value = "view-rest-QuoteInfo")
		public ResponseEntity<JsonResponse<List<RestCrmQuoteModel>>> viewQuoteInfo(@RequestParam String id) {
			logger.info("Method :viewQuoteInfo starts");

			logger.info("Method :viewQuoteInfo ends"+id);
			return restQuoteDao.viewQuoteInfo(id);

		}
		
		
		//view-rest-QuoteMailInfo
		
		@GetMapping(value = "view-rest-QuoteMailInfo")
		public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> viewQuoteMailInfo(@RequestParam String id) {
			logger.info("Method :viewQuoteMailInfo starts");

			logger.info("Method :viewQuoteMailInfo ends"+id);
			return restQuoteDao.viewQuoteMailInfo(id);

		}
		
		@GetMapping(value = "viewQuotes")
		public JsonResponse<ArrayList> viewLeadDet(@RequestParam String id) {
			logger.info("Method :viewQuotes starts");

			logger.info("Method :viewQuotes ends");
		return restQuoteDao.viewQuotes(id);
		}
}
