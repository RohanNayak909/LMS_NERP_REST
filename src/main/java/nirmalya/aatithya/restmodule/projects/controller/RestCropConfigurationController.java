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
import nirmalya.aatithya.restmodule.projects.dao.CropConfigurationDao;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCropModel;

@RestController
@RequestMapping(value = "projects/")
public class RestCropConfigurationController {

	Logger logger = LoggerFactory.getLogger(RestCropConfigurationController.class);

	@Autowired
	CropConfigurationDao cropConfigurationDao;

	// for Crop View
	@RequestMapping(value = "rest-viewCrop", method = { RequestMethod.GET })

	public JsonResponse<Object> restviewCrop(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div) {
		logger.info("Method :restviewCrop start");

		logger.info("Method :restviewCrop endss");
		return cropConfigurationDao.restviewCropDao(userid, org, div);
	}

	@RequestMapping(value = "rest-saveCrop", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveCrop(@RequestBody RestProjectCropModel saveCrop) {
		logger.info("Method : saveCrop starts");

		logger.info("Method : saveCrop ends");
		return cropConfigurationDao.saveCropDao(saveCrop);
	}

	// FOR DELETE
	@RequestMapping(value = "rest-deleteCrop", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCrop(@RequestParam String id) {
		logger.info("Method : deleteCrop starts" + id);

		logger.info("Method : deleteCrop ends");
		return cropConfigurationDao.deleteCropDao(id);
	}

	// for Crop Process View
	@RequestMapping(value = "rest-cropProcessView", method = { RequestMethod.GET })
	public JsonResponse<Object> cropProcessView(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div, @RequestParam String id) {
		logger.info("Method :cropProcessView start");

		logger.info("Method :cropProcessView endss");
		return cropConfigurationDao.cropProcessViewDao(userid, org, div, id);
	}

	@RequestMapping(value = "rest-saveCropProcess", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveCropProcess(@RequestBody RestProjectCropModel saveCropProcess) {
		logger.info("Method : saveCropProcess starts");

		logger.info("Method : saveCropProcess ends");
		return cropConfigurationDao.saveCropProcessDao(saveCropProcess);
	}
	
	// FOR CropProcess DELETE 
		@RequestMapping(value = "rest-deleteCropProcess", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteCropProcess(@RequestParam String id) {
			logger.info("Method : deleteCropProcess starts" + id);

			logger.info("Method : deleteCropProcess ends");
			return cropConfigurationDao.deleteCropProcessDao(id);
		}
}
