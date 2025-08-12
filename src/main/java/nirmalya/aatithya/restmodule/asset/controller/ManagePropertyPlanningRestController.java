package nirmalya.aatithya.restmodule.asset.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetViewMasterDao;
import nirmalya.aatithya.restmodule.asset.dao.ManagePropertyPlanningDao;
import nirmalya.aatithya.restmodule.asset.model.AssetPlanningRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;

@RestController
@RequestMapping(value = { "asset/" })
public class ManagePropertyPlanningRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	ManagePropertyPlanningDao managePropertyPlanningDao;

 
	@PostMapping(value = "rest-manage-property-planning-add")
	public JsonResponse<Object> addPropertyPlanning(@RequestBody List<AssetPlanningRestModel> assetPlanningRestModel) {
		logger.info("Method : addPropertyPlanning starts");
		logger.info("Method : addPropertyPlanning ends");
		return managePropertyPlanningDao.addPropertyPlanning(assetPlanningRestModel);
	}
	
	@RequestMapping(value = "rest-manage-property-planning-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPropertyPlan(@RequestParam String orgName, String orgDivision, String id) {
		logger.info("Method :viewPropertyPlan start");

		logger.info("Method :viewPropertyPlan endss");
		return managePropertyPlanningDao.viewPropertyPlan(id,orgName, orgDivision);
	}
	@RequestMapping(value = "rest-manage-property-planning-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePlanning(@RequestParam String id, String org, String div) {
		logger.info("Method : deletePlanning starts");

		logger.info("Method : deletePlanning ends");
		return managePropertyPlanningDao.deletePlanning(id, org, div);

	}
	@RequestMapping(value = "rest-manage-property-planning-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editPropertyPlan(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editPropertyPlan start");

		logger.info("Method :editPropertyPlan endss");
		return managePropertyPlanningDao.editPropertyPlan(id, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-manage-property-approve-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPropertyApproved(@RequestParam String orgName, String orgDivision,String property,String floor,String space) {
		logger.info("Method :viewPropertyApproved start");

		logger.info("Method :viewPropertyApproved endss");
		return managePropertyPlanningDao.viewPropertyApproved(orgName, orgDivision,property,floor,space);
	}
	
	@RequestMapping(value = "rest-manage-property-approve-reject", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> rejectPlanning(@RequestParam String id, String org, String div) {
		logger.info("Method : rejectPlanning starts");

		logger.info("Method : rejectPlanning ends");
		return managePropertyPlanningDao.rejectPlanning(id, org, div);

	}
}
