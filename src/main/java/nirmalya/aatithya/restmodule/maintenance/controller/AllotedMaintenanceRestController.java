package nirmalya.aatithya.restmodule.maintenance.controller;

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

import nirmalya.aatithya.restmodule.maintenance.dao.AllotedMaintenanceDao;
import nirmalya.aatithya.restmodule.maintenance.dao.AssetMaintenanceDao;
import nirmalya.aatithya.restmodule.maintenance.model.AllotedMaintenanceRestModel;
import nirmalya.aatithya.restmodule.asset.dao.AssetViewMasterDao;
import nirmalya.aatithya.restmodule.asset.model.AssetPoilcyRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.employee.dao.TravelRequsitionRestDao;
import nirmalya.aatithya.restmodule.employee.model.TravelRequisitionRestModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.qa.dao.QcMasterDao;

@RestController
@RequestMapping(value = { "maintenance/" })
public class AllotedMaintenanceRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AllotedMaintenanceDao allotedMaintenanceDao;

	@RequestMapping(value = "rest-alloted-maintenance-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAssetMaintenance(@RequestParam String orgName, String orgDivision,String userId) {
		logger.info("Method :viewAssetMaintenance start");

		logger.info("Method :viewAssetMaintenance endss");
		return allotedMaintenanceDao.viewAssetMaintenance(orgName, orgDivision,userId);
	}

	@PostMapping(value = "rest-asset-maintenance-progress")
	public ResponseEntity<JsonResponse<List<AllotedMaintenanceRestModel>>> addPolicyProgress(

			@RequestBody List<AllotedMaintenanceRestModel> allotedModel) {
		logger.info("Method : addPolicyProgress starts");
		logger.info("Method : addPolicyProgress ends");
		return allotedMaintenanceDao.addPolicyProgress(allotedModel);
	}

	@RequestMapping(value = "rest-asset-maintenance-policylist", method = { RequestMethod.GET })
	public JsonResponse<Object> getPolList(@RequestParam String aid, String pid, String orgName, String orgDivision, String shift) {
		logger.info("Method :getPolList start");

		logger.info("Method :getPolList endss");
		return allotedMaintenanceDao.getPolList(aid, pid, orgName, orgDivision,shift);
	}
	
	// Search
	@RequestMapping(value = "rest-AllotedViewSearch", method = { RequestMethod.GET })
	public JsonResponse<Object> assetAllotedViewSearch(@RequestParam String orgName, @RequestParam String orgDivision, String searchValue) {
		logger.info("Method :assetAllotedViewSearch start");

		logger.info("Method :assetAllotedViewSearch endss");
		return allotedMaintenanceDao.assetAllotedViewSearch(orgName, orgDivision, searchValue);

	}
	@RequestMapping(value = "rest-viewTicket", method = { RequestMethod.GET })
	public JsonResponse<Object> viewTicket(@RequestParam String orgName, String orgDivision , String allotedId) {
		logger.info("Method :viewTicket start");

		logger.info("Method :viewTicket endss");
		return allotedMaintenanceDao.viewTicket(orgName, orgDivision , allotedId);
	}
	@RequestMapping(value = "rest-manage-asset-list", method = { RequestMethod.GET })
	public JsonResponse<Object> showTotalAsset(@RequestParam String cat,String scat, String orgName, String orgDivision) {
		logger.info("Method :showTotalAsset start");

		logger.info("Method :showTotalAsset endss");
		return allotedMaintenanceDao.showTotalAsset(cat,scat,orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-asset-maintenance-policylist-upload", method = { RequestMethod.GET })
	public JsonResponse<Object> getPolListForUpload(@RequestParam String aid, String pid, String orgName, String orgDivision, String shift) {
		logger.info("Method :getPolListForUpload start");

		logger.info("Method :getPolListForUpload endss");
		return allotedMaintenanceDao.getPolListForUpload(aid, pid, orgName, orgDivision,shift);
	}
//ASSET LIST API
	
	@GetMapping(value = "rest-manage-asset-list-api")
	public List<DropDownModel> assetListapi(@RequestParam String cat,String scat, String orgName, String orgDivision ,String userId) {
		logger.info("Method : assetListapi starts");

		logger.info("Method : assetListapi ends");
		return allotedMaintenanceDao.assetListapi(cat,scat,orgName, orgDivision,userId);
	}
//Group List Api

	@GetMapping(value = "rest-manage-group-list-api")
	public List<DropDownModel> groupListapi(@RequestParam String cat,String scat, String orgName, String orgDivision ,String userId) {
		logger.info("Method : groupListapi starts");

		logger.info("Method : groupListapi ends");
		return allotedMaintenanceDao.groupListapi(cat,scat,orgName, orgDivision,userId);
	}
}
