package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

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
import nirmalya.aatithya.restmodule.master.dao.DemoTreeDao;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.master.model.RestDemoTreeModel;


@RestController
@RequestMapping(value = "master/")
public class RestDemoTreeController {

	Logger logger = LoggerFactory.getLogger(RestDemoTreeController.class);

	@Autowired
	DemoTreeDao DemoTreeDao;
	
	@RequestMapping(value = "saveDemoCategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<RestDemoTreeModel>> saveDemoCategory(@RequestBody RestDemoTreeModel category) {
		logger.info("Method : saveDemoCategory starts");
		
		logger.info("Method : saveDemoCategory ends");
		return DemoTreeDao.saveDemoCategory(category);
	}
	
	@RequestMapping(value = "getAllDemoCategoryList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestDemoTreeModel>>> getAllDemoCategoryList() {
		logger.info("Method : getAllDemoCategoryList starts");
		
		logger.info("Method : getAllDemoCategoryList ends");
		return DemoTreeDao.getAllDemoCategoryList();
	}

	@RequestMapping(value = "saveDemoSubCategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<RestDemoTreeModel>> saveDemoSubCategory(@RequestBody RestDemoTreeModel category) {
		logger.info("Method : saveDemoSubCategory starts");
		
		logger.info("Method : saveDemoSubCategory ends");
		return DemoTreeDao.saveDemoSubCategory(category);
	}
	
	@RequestMapping(value = "editDemoCategoryById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestDemoTreeModel>> editDemoCategoryById(@RequestParam String id) {
		logger.info("Method : editDemoCategoryById starts");
		
		logger.info("Method : editDemoCategoryById ends");
		return DemoTreeDao.editDemoCategoryById(id);
	}
	
	@RequestMapping(value = "deleteDemoCategory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDemoCategory(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteDemoCategory starts");
		
		logger.info("Method : deleteDemoCategory ends");
		return DemoTreeDao.deleteDemoCategory(id,createdBy);
	}

}
