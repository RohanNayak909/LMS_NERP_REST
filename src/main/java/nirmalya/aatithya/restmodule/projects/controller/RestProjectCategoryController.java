package nirmalya.aatithya.restmodule.projects.controller;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.controller.LocationMasterRestController;
import nirmalya.aatithya.restmodule.projects.dao.ProjectCategoryDao;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;

@RestController
@RequestMapping(value = "projects/")
public class RestProjectCategoryController {
	Logger logger = LoggerFactory.getLogger(RestProjectCategoryController.class);

	@Autowired
	ProjectCategoryDao ProjectCategoryDao;
	
	@RequestMapping(value = "saveProjectCategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<RestProjectCategoryModel>> saveProjectCategory(@RequestBody RestProjectCategoryModel category) {
		logger.info("Method : saveProjectCategory starts");
		
		logger.info("Method : saveProjectCategory ends");
		return ProjectCategoryDao.saveProjectCategory(category);
	}
	
	@RequestMapping(value = "saveProjectSubCategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<RestProjectCategoryModel>> saveProjectSubCategory(@RequestBody RestProjectCategoryModel category) {
		logger.info("Method : saveProjectSubCategory starts");
		
		logger.info("Method : saveProjectSubCategory ends");
		return ProjectCategoryDao.saveProjectSubCategory(category);
	}
	
	@RequestMapping(value = "getAllProjectCategoryList1", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> getAllProjectCategoryList() {
		logger.info("Method : getAllProjectCategoryList starts");
		
		logger.info("Method : getAllProjectCategoryList ends");
		return ProjectCategoryDao.getAllProjectCategoryList();
	}
	
	@RequestMapping(value = "getProjectCategoryListById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> getProjectCategoryListById(@RequestParam String id) {
		logger.info("Method : getProjectCategoryListById starts");
		
		logger.info("Method : getProjectCategoryListById ends");
		return ProjectCategoryDao.getProjectCategoryListById(id);
	}
	
	@RequestMapping(value = "getProjectCategoryById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestProjectCategoryModel>> getProjectCategoryById(@RequestParam String id) {
		logger.info("Method : getProjectCategoryById starts");
		
		logger.info("Method : getProjectCategoryById ends");
		return ProjectCategoryDao.getProjectCategoryById(id);
	}
	
	@RequestMapping(value = "deleteCategory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCategory(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteCategory starts");
		
		logger.info("Method : deleteCategory ends");
		return ProjectCategoryDao.deleteCategory(id,createdBy);
	}
	@GetMapping(value = "getProductCategoryDataListModallist")
	public ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> getProjectCategoryDataListModal() {
		logger.info("Method : getProjectCategoryDataListModal starts");

		logger.info("Method : getProjectCategoryDataListModal ends");
		return ProjectCategoryDao.getProjectCategoryDataListModal();
	}
}
