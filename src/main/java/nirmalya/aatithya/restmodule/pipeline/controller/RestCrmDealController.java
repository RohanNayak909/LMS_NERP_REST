package nirmalya.aatithya.restmodule.pipeline.controller;

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
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmDealDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "pipeline")
public class RestCrmDealController {
	Logger logger = LoggerFactory.getLogger(RestCrmDealController.class);
	@Autowired
	RestCrmDealDao restCrmDealDao;

	
	//getDealTypeList
	
		@RequestMapping(value = "getDealTypeList", method = { RequestMethod.GET })
		public List<DropDownModel> getDealTypeList() {
			
			logger.info("Method : getDealTypeList starts");
			logger.info("Method : getDealTypeList ends");
			
			return restCrmDealDao.getDealTypeList();
		}
		
		//getDealStageList
		
	/*	@RequestMapping(value = "getDealStageListWONew", method = { RequestMethod.GET })
		public List<DropDownModel> getDealStageListWONew() {
			
			logger.info("Method : getDealStageListWONew starts");
			logger.info("Method : getDealStageListWONew ends");
			
			return restCrmDealDao.getDealStageListWONew();
		}
		*/
		
		//getStageList
		
		@RequestMapping(value = "getDealStageList", method = { RequestMethod.GET })
		public List<DropDownModel> getDealStageList() {
			
			logger.info("Method : getDealStageList starts");
			logger.info("Method : getDealStageList ends");
			
			return restCrmDealDao.getDealStageList();
		}
		
		//getCampaignList
		
		@RequestMapping(value = "getDealCampaignList", method = { RequestMethod.GET })
		public List<DropDownModel> getDealCampaignList() {
			
			logger.info("Method : getDealCampaignList starts");
			logger.info("Method : getDealCampaignList ends");
			
			return restCrmDealDao.getDealCampaignList();
		}

		//addDeal
		
		/**
		 * Post Mapping to Add new addDeal
		 *
		 */
		// add

		@PostMapping(value = "/addDeal")
		public JsonResponse<Object> addDeal(@RequestBody RestDealModel deal) {
			logger.info("Method : addDeal starts");

			logger.info("Method : addDeal ends");
			return restCrmDealDao.addDeal(deal);
		}
		
		//restViewDealDetails
		
		

				@RequestMapping(value = "viewDealSearchDetails", method = { RequestMethod.POST })
				public ResponseEntity<JsonResponse<Object>> viewDealSearchDetails(
						@RequestBody RestDealModel searchDealModel) {
					logger.info("Method : viewDealSearchDetails starts");
			        logger.info("VIEWWW"+searchDealModel);
					logger.info("Method : viewDealSearchDetails ends");

					return restCrmDealDao.viewDealSearchDetails(searchDealModel);
				}
		
		
	/*
	 * for view restViewDealDetails
	 */
	/*@RequestMapping(value="restViewDealDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestDealModel>>> restViewDealDetails(){
		logger.info("Method: restViewDealDetails View Start");
		
		logger.info("Method: restViewDealDetails ends");
		return restCrmDealDao.restViewDealDetails();
	}*/
				
	@GetMapping(value = "restViewDealDetails")
	public JsonResponse restViewDealDetails(@RequestParam String pageno,
			@RequestParam String userId,@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method :restViewDealDetails starts");

		logger.info("Method :restViewDealDetails ends");
	return restCrmDealDao.restViewDealDetails(pageno,userId,orgName,orgDivision);
	}
	
	
	//delete-deal-Details
	@RequestMapping(value = "delete-deal-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDealDetails(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :  deleteDealDetails starts"+id);

		logger.info("Method :  deleteDealDetails ends");
		return restCrmDealDao.deleteDealDetails(id, org, orgDiv);
	}
	
	//editDealInfo
	@GetMapping(value = "editDealInfo")
	public ResponseEntity<JsonResponse<List<RestDealModel>>> editDealInfo(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :editDealInfo starts");

		logger.info("Method :editDealInfo ends"+id);
		return restCrmDealDao.editDealInfo(id, org, orgDiv);

	}
	
	
	@GetMapping(value = "viewDealDetailsPage")
	public ResponseEntity<JsonResponse<List<RestDealModel>>> viewDealDetailsPage(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewDealDetailsPage starts");

		logger.info("Method :viewDealDetailsPage ends"+id);
		return restCrmDealDao.viewDealDetailsPage(id, org, orgDiv);

	}
	//view-rest-dealStageInfo
	

@GetMapping(value = "view-rest-dealStageInfo")
		public ResponseEntity<JsonResponse<List<RestDealModel>>> viewDealStageInfo(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :viewDealStageInfo starts");

			logger.info("Method :viewDealStageInfo ends"+id);
			return restCrmDealDao.viewDealStageInfo(id, org, orgDiv);

		}

/*
 * auto search 
 */

@GetMapping(value = "getCampaignDetailsSearchList")
public ResponseEntity<JsonResponse<List<DropDownModel>>> autosearchCampaignDetails(@RequestParam String id, @RequestParam String org, @RequestParam String orgDiv) {
	logger.info("Method : autosearchCampaignDetails starts");

	logger.info("Method :autosearchCampaignDetails endss");
	return restCrmDealDao.autosearchCampaignDetails(id, org, orgDiv);
}



/**
	 * Post Mapping to Add new stage   
	 *
	 */
	// add

	@PostMapping(value = "/addUpdateStageDealDtls")
	public JsonResponse<Object> addUpdateStageDealDtls(@RequestBody RestDealModel deal) {
		logger.info("Method : addUpdateStageDealDtls starts");

		logger.info("Method : addUpdateStageDealDtls ends");
		return restCrmDealDao.addUpdateStageDealDtls(deal);
	}
	
	//getDealNameAutoList
	

	/*
	 * getDealNameAutoList auto search
	 */
	@GetMapping(value = "getDealNameAutoList")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getDealNameAutoList(
			@RequestParam String id) {
		logger.info("Method : getDealNameAutoList starts");

		logger.info("Method :getDealNameAutoList endss");
		return restCrmDealDao.getDealNameAutoList(id);
	}
	
	//getQuoteNameAutoList
	
	
	@GetMapping(value = "getQuoteNameAutoList")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getQuoteNameAutoList(
			@RequestParam String id) {
		logger.info("Method : getQuoteNameAutoList starts");

		logger.info("Method :getQuoteNameAutoList endss");
		return restCrmDealDao.getQuoteNameAutoList(id);
	}
}
