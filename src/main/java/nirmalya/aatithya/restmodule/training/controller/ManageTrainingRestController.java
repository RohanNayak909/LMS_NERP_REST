package nirmalya.aatithya.restmodule.training.controller;

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
import nirmalya.aatithya.restmodule.training.dao.ManageTrainingDetailsDao;
import nirmalya.aatithya.restmodule.training.model.ManageTrainingRestModel;

@RestController
@RequestMapping(value = "training/")
public class ManageTrainingRestController {

	Logger logger = LoggerFactory.getLogger(ManageTrainingRestController.class);

	@Autowired
	ManageTrainingDetailsDao manageTrainingDao;

	@PostMapping(value = "save-training-category")
	public ResponseEntity<JsonResponse<ManageTrainingRestModel>> saveTrainingCategory(@RequestBody ManageTrainingRestModel category) {
		logger.info("Method : saveTrainingCategory starts");

		logger.info("Method : saveTrainingCategory ends");
		return manageTrainingDao.saveTrainingCategoryDao(category);
	}

	// get Training category list
	@GetMapping(value = "get-training-category-dataListModal")
	public ResponseEntity<JsonResponse<List<ManageTrainingRestModel>>> getTrainingCategoryDataListModal(@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : getTrainingCategoryDataListModal starts");

		
		logger.info("Method : getTrainingCategoryDataListModal ends");
		return manageTrainingDao.getTrainingCategoryDataListModal(organization,orgDivision);
	}

	@PostMapping(value = "save-training-subcategory")
	public ResponseEntity<JsonResponse<ManageTrainingRestModel>> saveTrainingSubCategory(@RequestBody ManageTrainingRestModel category) {
		logger.info("Method : saveTrainingSubCategory starts");

		logger.info("Method : saveTrainingSubCategory ends");
		return manageTrainingDao.saveTrainingSubCategory(category);
	}
	
	@GetMapping(value = "delete-training-category")
	public ResponseEntity<JsonResponse<Object>> deleteCategory(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : deleteCategory starts");
		
		logger.info("Method : deleteCategory ends");
		return manageTrainingDao.deleteTrainingCategory(id,createdBy);
	}
	
	@GetMapping(value = "get-training-categoryById")
	public ResponseEntity<JsonResponse<ManageTrainingRestModel>> getProductCategoryById(@RequestParam String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : getProductCategoryById starts");
		
		logger.info("Method : getProductCategoryById ends");
		return manageTrainingDao.getTrainingCategoryById(id,organization,orgDivision);
	}
	
	//this method is used to save training material details
	@PostMapping(value = "save-training-studymaterial")
	public ResponseEntity<JsonResponse<ManageTrainingRestModel>> saveTrainingStudyMaterial(@RequestBody List<ManageTrainingRestModel> category) {
		logger.info("Method : saveTrainingSubCategory starts");

		logger.info("Method : saveTrainingSubCategory ends");
		return manageTrainingDao.saveTrainingStudyMaterial(category);
	}
	
}
