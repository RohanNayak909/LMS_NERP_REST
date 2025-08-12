package nirmalya.aatithya.restmodule.projects.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.projects.dao.ProjectCreationDao;
import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModel;

@RestController
@RequestMapping(value = "projects")

public class ProjectCreationRestController {

	Logger logger = LoggerFactory.getLogger(ProjectCreationRestController.class);

	@Autowired
	ProjectCreationDao projectCreationDao;

	// FOR ADD

	@RequestMapping(value = "rest-addPrjCreation", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restaddPrjCreation(
			@RequestBody List<ProjectCreationRestModel> prjCreation) {
		logger.info("Method : restaddPrjCreation starts");

		logger.info("Method : restaddPrjCreation ends");

		return projectCreationDao.restaddPrjCreationDao(prjCreation);
	}

	// FOR Creation VIEW

	@RequestMapping(value = "rest-view-project-creation", method = { RequestMethod.GET })

	public JsonResponse<Object> viewProject(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div) {
		logger.info("Method :viewProject start");

		logger.info("Method :viewProject endss");
		return projectCreationDao.viewProject(userid, org, div);
	}

	// FOR EDIT
	@GetMapping(value = "edit-projectscreation")
	public ResponseEntity<JsonResponse<ProjectCreationRestModel>> editProject(@RequestParam String id) {
		logger.info("Method :editProject starts");

		// Log the received id
		logger.info("Received id: {}", id);

		ResponseEntity<JsonResponse<ProjectCreationRestModel>> responseEntity = projectCreationDao.editProject(id);

		// Log the response data
		logger.info("Edit response data: {}", responseEntity.getBody());

		logger.info("Method :editProject ends" + id);
		return projectCreationDao.editProject(id);
	}

	// FOR DELETE
	@RequestMapping(value = "deleteProjectCreation", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteProjectCreation(@RequestParam String id) {
		logger.info("Method : deleteProjectCreation starts" + id);

		logger.info("Method : deleteProjectCreation ends");
		return projectCreationDao.deleteProjectCreation(id);
	}

	/* rest billing country drop down */

	@RequestMapping(value = "rest-project-billing-country-list", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryListForBilling() {
		logger.info("Method : getCountryListForBilling starts");

		logger.info("Method : getCountryListForBilling ends");
		return projectCreationDao.getCountryListForBillingDao();
	}

	/* rest billing state drop down */

	@RequestMapping(value = "rest-project-billing-state-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateNameForBilling(@RequestParam String id) {
		logger.info("Method : getStateNameForBidding starts");

		logger.info("Method : getStateNameForBidding ends");
		return projectCreationDao.getStateNameForBillingDao(id);
	}

	/* rest shipping country drop down */

	@RequestMapping(value = "rest-project-shipping-country-list", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryListForShipping() {
		logger.info("Method : getCountryListForShipping starts");

		logger.info("Method : getCountryListForShipping ends");
		return projectCreationDao.getCountryListForShippingDao();
	}

	/* rest shipping state drop down */

	@RequestMapping(value = "rest-project-shipping-state-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateNameForShipping(@RequestParam String id) {
		logger.info("Method : getStateNameForShipping starts");

		logger.info("Method : getStateNameForShipping ends");
		return projectCreationDao.getStateNameForShippingDao(id);
	}

	/* rest project country drop down */

	@RequestMapping(value = "rest-project-country-list", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryListForProject() {
		logger.info("Method : getCountryListForProject starts");

		logger.info("Method : getCountryListForProject ends");
		return projectCreationDao.getCountryListForProjectDao();
	}

	/* rest project state drop down */

	@RequestMapping(value = "rest-project-state-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateNameForProject(@RequestParam String id) {
		logger.info("Method : getStateNameForProject starts");

		logger.info("Method : getStateNameForProject ends");
		return projectCreationDao.getStateNameForProjectDao(id);
	}

	/* rest project state list drop down on edit */
	@RequestMapping(value = "rest-getProjectStateList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getProjectStateList(@RequestParam String id) {
		logger.info("Method : rest getProjectStateList starts");

		logger.info("Method : rest getProjectStateList ends");
		return projectCreationDao.getProjectStateListDao(id);
	}

	/* rest billing state list drop down on edit */
	@RequestMapping(value = "rest-getBillingStateList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBillingStateList(@RequestParam String id) {
		logger.info("Method : rest getBillingStateList starts");

		// Print data to the console
		System.out.println("Printing data to console: " + id);

		logger.info("Method : rest getBillingStateList ends");
		return projectCreationDao.getBillingStateListDao(id);
	}

	/* rest billing state list drop down on edit */
	@RequestMapping(value = "rest-getShippingStateList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getShippingStateList(@RequestParam String id) {
		logger.info("Method : rest getBillingStateList starts");

		// Print data to the console
		System.out.println("Printing data to console: " + id);

		logger.info("Method : rest getBillingStateList ends");
		return projectCreationDao.getShippingStateListDao(id);
	}

	// FOR Req VIEW

	@RequestMapping(value = "rest-viewProjectRequision", method = { RequestMethod.GET })

	public JsonResponse<Object> viewProjectRequision(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div, @RequestParam String id) {
		logger.info("Method :viewProjectRequision start");

		logger.info("Method :viewProjectRequision endss");
		return projectCreationDao.viewProjectRequision(userid, org, div, id);
	}

	// FOR PO VIEW

	@RequestMapping(value = "rest-viewProjectPo", method = { RequestMethod.GET })

	public JsonResponse<Object> viewProjectPo(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div, @RequestParam String id) {
		logger.info("Method :viewProjectPo start");

		logger.info("Method :viewProjectPo endss");
		return projectCreationDao.viewProjectPo(userid, org, div, id);
	}
	
	
	// FOR MaterialIssue VIEW

		@RequestMapping(value = "rest-viewProjectMaterialIssue", method = { RequestMethod.GET })

		public JsonResponse<Object> viewProjectMaterialIssue(@RequestParam String userid, @RequestParam String org,
				@RequestParam String div, @RequestParam String id) {
			logger.info("Method :viewProjectMaterialIssue start");

			logger.info("Method :viewProjectMaterialIssue endss");
			return projectCreationDao.viewProjectMaterialIssue(userid, org, div, id);
		}
		
	// for product sku listing
		@RequestMapping(value = "getProjectProductSKUListing", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<ProductMasterModel>>> getProjectProductSKUListing(@RequestParam String type,String orgName,String orgDiv) {
			logger.info("Method : getProjectProductSKUListing starts");
			
			logger.info("Method : getProjectProductSKUListing ends");
			return projectCreationDao.getProjectProductSKUListing(type,orgName,orgDiv);
		}
		
/**  Product edit **/
		
		@RequestMapping(value = "rest-project-product-edit", method = { RequestMethod.GET })

		public JsonResponse<Object> editProjectProduct(@RequestParam String id,@RequestParam String userid, @RequestParam String org,
				@RequestParam String div) {
			logger.info("Method :viewProductSku start");

			logger.info("Method :viewProductSku endss");
			return projectCreationDao.editProjectProduct(id,userid, org, div);
		}
		
		@RequestMapping(value = "rest-saveproductsku", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> saveproductsku(
				@RequestBody ProjectCreationRestModel prjCreation) {
			logger.info("Method : saveproductsku starts");

			logger.info("Method : saveproductsku ends");

			return projectCreationDao.saveproductskuDao(prjCreation);
		}

		@RequestMapping(value = "rest-viewProductSku", method = { RequestMethod.GET })

		public JsonResponse<Object> viewProductSku(@RequestParam String userid, @RequestParam String org,
				@RequestParam String div) {
			logger.info("Method :viewProductSku start");

			logger.info("Method :viewProductSku endss");
			return projectCreationDao.viewProductSku(userid, org, div);
		}
		
		/** project Type drop down **/	
		@RequestMapping(value = "rest-project-type-list", method = { RequestMethod.GET })
		public List<DropDownModel> getProjectTypeList(@RequestParam String type) {
			logger.info("Method : getProjectTypeList starts"+type);

			logger.info("Method : getProjectTypeList ends");
			return projectCreationDao.getProjectTypeList(type);
		}	
		
		

}
