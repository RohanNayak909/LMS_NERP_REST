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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.dao.ProjectPlanningSchedulingDao;
import nirmalya.aatithya.restmodule.projects.dao.RestProjectPlanningDao;
import nirmalya.aatithya.restmodule.projects.model.ProjectPlanningSchedulingRestModel;

@RestController
@RequestMapping(value = "projects")
public class RestProjectPlanningController {
	

	Logger logger = LoggerFactory.getLogger(RestProjectPlanningController.class);

	@Autowired
	RestProjectPlanningDao restProjectPlanningDao;

	@RequestMapping(value = "rest-getfirstProjectName-Details-new", method = { RequestMethod.GET })

	public JsonResponse<Object> getFirstProjectNmDetails(@RequestParam String id,@RequestParam String userid,@RequestParam String org,@RequestParam String div) {
		logger.info("Method :getFirstProjectNmDetails start");

		logger.info("Method :getFirstProjectNmDetails endss");
		return restProjectPlanningDao.getFirstProjectNmDetail(id,userid,org,div);
	}
	
	@PostMapping(value = "save-parentPlanningData")
	public ResponseEntity<JsonResponse<Object>> parentPlanningData(@RequestBody List<ProjectPlanningSchedulingRestModel> eventModel) {
		logger.info("Method : parentPlanningData starts");
		logger.info("Method : parentPlanningData ends");
		return restProjectPlanningDao.parentPlanningData(eventModel);
	}
	 
	

	//
	@RequestMapping(value = "rest-getParentDataDtls", method = { RequestMethod.GET })

	public JsonResponse<Object> getParentDataDtls(@RequestParam String id,
			@RequestParam String userid,@RequestParam String org,@RequestParam String div) {
		logger.info("Method :getParentDataDtls start");

		logger.info("Method :getParentDataDtls endss");
		return restProjectPlanningDao.getParentDataDtls(id,userid,org,div);
	}
	//
	
	@RequestMapping(value = "rest-getParentEditDatas", method = { RequestMethod.GET })

	public JsonResponse<Object> getParentEdits(@RequestParam String id,
			@RequestParam String userid,@RequestParam String org,@RequestParam String div) {
		logger.info("Method :getParentEdits start");

		logger.info("Method :getParentEdits endss");
		return restProjectPlanningDao.getParentEdits(id,userid,org,div);
	}
	
	
	
	@PostMapping(value = "save-childDataPlanning")
	public ResponseEntity<JsonResponse<Object>> childDataPlanning(@RequestBody List<ProjectPlanningSchedulingRestModel> eventModel) {
		logger.info("Method : childDataPlanning starts");
		logger.info("Method : childDataPlanning ends");
		return restProjectPlanningDao.childDataPlanning(eventModel);
	}
	
	@RequestMapping(value = "rest-editChildPlanning", method = { RequestMethod.GET })

	public JsonResponse<Object> editChildPlanning(@RequestParam String id,
			@RequestParam String userid,@RequestParam String org,@RequestParam String div) {
		logger.info("Method :editChildPlanning start");

		logger.info("Method :editChildPlanning endss");
		return restProjectPlanningDao.editChildPlanning(id,userid,org,div);
	}
	

	// Drop down Project Name
	@GetMapping(value = "get-projectPriority-list")
	public JsonResponse<List<DropDownModel>> getProjectPriority(@RequestParam String userId,@RequestParam String org,@RequestParam String div) {
		logger.info("Method : getProjectPriority starts"+userId);

		logger.info("Method : getProjectPriority ends");
		return restProjectPlanningDao.getProjectPriority(userId,org,div);
	}
	
	@PostMapping(value = "save-saveMasterDataPlanning")
	public ResponseEntity<JsonResponse<Object>> saveMasterDataPlanning(@RequestBody ProjectPlanningSchedulingRestModel eventModel) {
		logger.info("Method : saveMasterDataPlanning starts");
		logger.info("Method : saveMasterDataPlanning ends");
		return restProjectPlanningDao.saveMasterDataPlanning(eventModel);
	}
	
	@GetMapping(value = "rest-getcategoryDataPlanning")
	public ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>> getcategoryDataPlanning(@RequestParam String id) {
		logger.info("Method : getcategoryDataPlanning starts"+id);

		logger.info("Method :getcategoryDataPlanning endss");
		return restProjectPlanningDao.getcategoryDataPlanning(id);
			}
	
	// Drop down Planning Status Name
		@GetMapping(value = "get-planningStatus-list")
		public JsonResponse<List<DropDownModel>> getPlanningStatus(@RequestParam String userId,@RequestParam String org,@RequestParam String div) {
			logger.info("Method : getPlanningStatus starts");

			logger.info("Method : getPlanningStatus ends");
			return restProjectPlanningDao.getPlanningStatus(userId,org,div);
		}
		
		@RequestMapping(value = "rest-getcalculationdatetime", method = { RequestMethod.GET })

		public JsonResponse<Object> calculationdatetime(@RequestParam String startDt,
				@RequestParam String endDt) {
			logger.info("Method :calculationdatetime start");

			logger.info("Method :calculationdatetime endss");
			return restProjectPlanningDao.calculationdatetimeDAo(startDt,endDt);
		}
		
		// Drop down Category Name
		@RequestMapping(value = "get-planningCategoryList", method = { RequestMethod.GET })

		public JsonResponse<Object> planningCategoryList(@RequestParam String userid) {
			logger.info("Method :planningCategoryList start");

			logger.info("Method :planningCategoryList endss");
			return restProjectPlanningDao.planningCategoryListDao(userid);
		}
		
		@RequestMapping(value = "rest-get-palnningSubCategoryList", method = { RequestMethod.GET })

		public JsonResponse<Object> palnningSubCategoryList(@RequestParam String id,@RequestParam String pjId) {
			logger.info("Method :palnningSubCategoryList start");

			logger.info("Method :palnningSubCategoryList endss");
			return restProjectPlanningDao.palnningSubCategoryListDao(id,pjId);
		}
		
		
		@RequestMapping(value = "rest-SubCategoryListEdit", method = { RequestMethod.GET })

		public JsonResponse<Object> SubCategoryListEdit(@RequestParam String id,@RequestParam String planIdd) {
			logger.info("Method :SubCategoryListEdit start");

			logger.info("Method :SubCategoryListEdit endss");
			return restProjectPlanningDao.SubCategoryListEditDao(id,planIdd);
		}
		
		@GetMapping(value = "rest-getPrecedAutoSearchList-planning")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getPrecedAutoSearchListPlanning(@RequestParam String id,
				String projectId,@RequestParam String userId,@RequestParam String org,@RequestParam String div) {
			logger.info("Method : getPrecedAutoSearchListPlanning starts");

			logger.info("Method :getPrecedAutoSearchListPlanning endss");
			return restProjectPlanningDao.getPrecedAutoSearchListPlanning(id, projectId,userId,org,div);
		}
}
