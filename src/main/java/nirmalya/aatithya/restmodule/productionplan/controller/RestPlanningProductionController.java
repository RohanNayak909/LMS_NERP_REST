package nirmalya.aatithya.restmodule.productionplan.controller;

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
import nirmalya.aatithya.restmodule.productionplan.dao.PlanningProductionDao;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionParentModel;

@RestController
@RequestMapping("production/")
public class RestPlanningProductionController {
	@Autowired
	PlanningProductionDao PlanningProductionDao;
	Logger logger = LoggerFactory.getLogger(RestPlanningProductionController.class);

	@GetMapping(value = "rest-getplan-list")
	public List<DropDownModel> getplan(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getBrandList starts");

		logger.info("Method : getBrandList ends");
		return PlanningProductionDao.getplan(org, orgDiv);
	}

	@GetMapping(value = "rest-getplant-list")
	public List<DropDownModel> getPlantList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getPlantList starts");

		logger.info("Method : getPlantList ends");
		return PlanningProductionDao.getPlantList(org, orgDiv);
	}

	@RequestMapping(value = "rest-getunit-list", method = { RequestMethod.GET })
	public List<DropDownModel> getUomList() {
		logger.info("Method : getUomList starts");

		logger.info("Method : getUomList ends");
		return PlanningProductionDao.getUomList();
	}

	@PostMapping(value = "rest-getmachine-list")
	public ResponseEntity<JsonResponse<List<RestPlanningProductionModel>>> getMachineList(
			@RequestBody RestPlanningProductionModel RestPlanningProductionModel) {
		logger.info("Method : getMachineList starts");

		logger.info("Method : getMachineList ends");
		return PlanningProductionDao.getMachineList(RestPlanningProductionModel);
	}

	@RequestMapping(value = "getShiftListForProductionPlan", method = { RequestMethod.GET })
	public JsonResponse<List<DropDownModel>> getShiftListsAllocation(@RequestParam String org, String orgDiv,
			String userId) {
		logger.info("Method : getShiftListsAllocation starts");

		logger.info("Method : getShiftListsAllocation ends");
		return PlanningProductionDao.getShiftListsAllocation(org, orgDiv, userId);
	}

	@PostMapping(value = "rest-manpower-list")
	public JsonResponse<RestPlanningProductionModel> getManPowerList(
			@RequestBody RestPlanningProductionModel RestPlanningProductionModel) {
		logger.info("Method : getManPowerList starts");

		logger.info("Method : getManPowerList ends");
		return PlanningProductionDao.getManPowerList(RestPlanningProductionModel);
	}

	@GetMapping(value = "rest-getvariant-list")
	public JsonResponse<List<RestPlanningProductionModel>> getProductVariantList(@RequestParam String id,
			@RequestParam String planid, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getProductVariantList starts");

		logger.info("Method : getProductVariantList ends");
		return PlanningProductionDao.getProductVariantList(id, planid, org, orgDiv);
	}

	@GetMapping(value = "rest-getbrandname-list")
	public JsonResponse<List<RestPlanningProductionModel>> getProductBrandList(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getProductBrandList starts");

		logger.info("Method : getProductBrandList ends");
		return PlanningProductionDao.getProductBrandList(id, org, orgDiv);
	}

	@PostMapping(value = "rest-rawmaterial-list")
	public JsonResponse<List<RestPlanningProductionModel>> getRawMaterialList(
			@RequestBody RestPlanningProductionModel RestPlanningProductionModel) {
		logger.info("Method : getRawMaterialList starts");

		logger.info("Method : getRawMaterialList ends");
		return PlanningProductionDao.getRawMaterialList(RestPlanningProductionModel);
	}

	@GetMapping(value = "rest-unitDropdown-list")
	public JsonResponse<List<RestPlanningProductionModel>> getVarUnitDropdownList(@RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getVarUnitDropdownList starts");

		logger.info("Method : getVarUnitDropdownList ends");
		return PlanningProductionDao.getVarUnitDropdownList(org, orgDiv);
	}

	@PostMapping(value = "saveplanning-Details")
	public ResponseEntity<JsonResponse<Object>> savePlanningDetails(
			@RequestBody RestPlanningProductionParentModel savePlanningmodel) {
		logger.info("Method : savePlanningDetails starts");

		logger.info("Method : savePlanningDetails ends");
		return PlanningProductionDao.savePlanningDetails(savePlanningmodel);
	}

	@GetMapping(value = "rest-viewproductionplanning")
	public ResponseEntity<JsonResponse<List<RestPlanningProductionParentModel>>> viewPlanning(
			@RequestParam String userid, String org,String orgDiv) {
		logger.info("Method : viewPlanning starts");

		logger.info("Method : viewPlanning ends");
		return PlanningProductionDao.viewplanning(userid,org,orgDiv);
	}

	@PostMapping(value = "rest-delete-production-planning")
	public ResponseEntity<JsonResponse<Object>> deletePlanningProduction(
			@RequestBody RestPlanningProductionParentModel RestPlanningProductionParentModel) {
		logger.info("Method : deletePlanningProduction starts");

		logger.info("Method : deletePlanningProduction ends");
		return PlanningProductionDao.deletePlanningProduction(RestPlanningProductionParentModel);
	}

	@GetMapping(value = "rest-edit-production-planning")
	public JsonResponse<RestPlanningProductionParentModel> editPlanningProduction(@RequestParam String id) {
		logger.info("Method : editPlanningProduction starts");

		logger.info("Method : editPlanningProduction ends");
		return PlanningProductionDao.editPlanningProduction(id);
	}

	@PostMapping(value = "rest-approve-production-planning")
	public ResponseEntity<JsonResponse<Object>> approvePlanningProduction(
			@RequestBody RestPlanningProductionParentModel RestPlanningProductionParentModel) {
		logger.info("Method : approvePlanningProduction starts");

		logger.info("Method : approvePlanningProduction ends");
		return PlanningProductionDao.approvePlanningProduction(RestPlanningProductionParentModel);
	}

	@GetMapping(value = "rest-schedule-production-planning")
	public JsonResponse<RestPlanningProductionParentModel> schedulePlanningProduction(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : schedulePlanningProduction starts");

		logger.info("Method : schedulePlanningProduction ends");
		return PlanningProductionDao.schedulePlanningProduction(id, org, orgDiv);
	}
	
	@PostMapping(value = "setschedule-Details")
	public ResponseEntity<JsonResponse<Object>> setScheduleDetails(
			@RequestBody RestPlanningProductionParentModel scheduleModel) {
		logger.info("Method : setScheduleDetails starts");

		logger.info("Method : setScheduleDetails ends");
		return PlanningProductionDao.setScheduleDetails(scheduleModel);
	}
	
	@GetMapping(value = "rest-schedule-edit-production-planning")
	public JsonResponse<RestPlanningProductionParentModel> editSchedulePage(@RequestParam String id) {
		logger.info("Method : editSchedulePage starts");

		logger.info("Method : editSchedulePage ends");
		return PlanningProductionDao.editSchedulePage(id);
	}
	@GetMapping(value = "rest-getResouceOnItem-list")
	public ResponseEntity<JsonResponse<List<RestPlanningProductionModel>>> getResouceOnItem(
			@RequestParam String item, String type, String org, String orgDiv) {
		logger.info("Method : getResouceOnItem starts");

		logger.info("Method : getResouceOnItem ends");
		return PlanningProductionDao.getResouceOnItem(item,type,org,orgDiv);
	}
}
