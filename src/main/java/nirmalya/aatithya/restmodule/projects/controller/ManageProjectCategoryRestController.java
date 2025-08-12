package nirmalya.aatithya.restmodule.projects.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.dao.ManageProjectCategoryDao;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;
@RestController
@RequestMapping(value = "projects")

public class ManageProjectCategoryRestController {

	Logger logger = LoggerFactory.getLogger(ManageProjectCategoryRestController.class);

	@Autowired
	ManageProjectCategoryDao manageprojectCategoryDao;

	@RequestMapping(value = "rest-saveCategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveCategory(
			@RequestBody RestProjectCategoryModel saveCategory) {
		logger.info("Method : saveCategory starts");

		logger.info("Method : saveCategory ends");
		return manageprojectCategoryDao.saveCategoryDao(saveCategory);
	}
//for category View	
	@RequestMapping(value = "rest-viewCategory", method = { RequestMethod.GET })

	public JsonResponse<Object> viewCategory(@RequestParam String userid,@RequestParam String org,@RequestParam String div) {
		logger.info("Method :viewCategory start");

		logger.info("Method :viewCategory endss");
		return manageprojectCategoryDao.viewCategoryDao(userid,org,div);
	}
	
//FOR DELETE
		@RequestMapping(value = "rest-deleteCategory", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteCategory(@RequestParam String id) {
			logger.info("Method : deleteCategory starts"+id);

			logger.info("Method : deleteCategory ends");
			return manageprojectCategoryDao.deleteCategoryDao(id);
		}
		
		@RequestMapping(value = "rest-savesubcategory", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> savesubcategory(
				@RequestBody RestProjectCategoryModel saveCategory) {
			logger.info("Method : savesubcategory starts");

			logger.info("Method : savesubcategory ends");
			return manageprojectCategoryDao.savesubcategoryDao(saveCategory);
		}
		
		//for category View	
		@RequestMapping(value = "rest-viewsubcategory", method = { RequestMethod.GET })

		public JsonResponse<Object> viewsubcategory(@RequestParam String userid,@RequestParam String org,@RequestParam String div,@RequestParam String cdId) {
			logger.info("Method :viewsubcategory start");

			logger.info("Method :viewsubcategory endss");
			return manageprojectCategoryDao.viewsubcategoryDao(userid,org,div,cdId);
		}
		
		//FOR DELETE
				@RequestMapping(value = "rest-deleteSubCategory", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<Object>> deleteSubCategory(@RequestParam String id) {
					logger.info("Method : deleteSubCategory starts"+id);

					logger.info("Method : deleteSubCategory ends");
					return manageprojectCategoryDao.deleteSubCategoryDao(id);
				}		
				
}
