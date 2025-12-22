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


import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmContactDao;
import nirmalya.aatithya.restmodule.pipeline.dao.PipelineDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCallDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCampaignDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmDealDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmProductDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmTaskDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmVendorDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmProductModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmVendorModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineActivityModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineLogModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineMeetingModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineSmsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestStagesDetailModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "pipeline")
public class RestCrmProductController {
	Logger logger = LoggerFactory.getLogger(RestCrmProductController.class);
	@Autowired
	RestCrmProductDao restCrmProductDao;

	
	//addVendorCRM
	/*
	 * for All  Add vendor
	 */
	@RequestMapping(value="addProductCRM" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addProductCRM(@RequestBody RestCrmProductModel assignSkill) 
	{
		logger.info("Method : addProductCRM starts");
		
		logger.info("Method : addProductCRM ends");
		
		return restCrmProductDao.addProductCRM(assignSkill);
	}
	
	
	//restViewCrmProducts
	
	
	/*
	 * for view
	 */
	@RequestMapping(value="restViewCrmProducts" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestCrmProductModel>>> restViewCrmProducts(){
		logger.info("Method: restViewCrmProducts View Start");
		
		logger.info("Method: restViewCrmProducts ends");
		return restCrmProductDao.restViewCrmProducts();
	}
	
	//delete-product-Details
	@RequestMapping(value = "delete-product-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteProductDetails(@RequestParam String id) {
		logger.info("Method :  deleteProductDetails starts"+id);

		logger.info("Method :  deleteProductDetails ends");
		return restCrmProductDao.deleteProductDetails(id);
	}
	
	//editProductInfo
	
	@GetMapping(value = "editProductInfo")
	public ResponseEntity<JsonResponse<List<RestCrmProductModel>>> editProductInfo(@RequestParam String id) {
		logger.info("Method :editProductInfo starts");

		logger.info("Method :editProductInfo ends"+id);
		return restCrmProductDao.editProductInfo(id);

	}
	
}
