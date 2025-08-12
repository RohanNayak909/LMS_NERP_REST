package nirmalya.aatithya.restmodule.asset.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetEquipementExecuteDao;
import nirmalya.aatithya.restmodule.asset.model.AssetEquipementRequestRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetPlanningRestModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;

@RestController
@RequestMapping(value = { "asset/" })
public class AssetEquipementExecuteRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AssetEquipementExecuteDao assetEquipementExecuteDao;

	
	@RequestMapping(value = "rest-asset-execute-request-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editRequestExecute(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editRequestExecute start");

		logger.info("Method :editRequestExecute endss");
		return assetEquipementExecuteDao.editRequestExecute(id, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-asset-execute-request-spare-list", method = { RequestMethod.GET })
	public JsonResponse<Object> showTotalSpare(@RequestParam String cat,String scat, String orgName, String orgDivision) {
		logger.info("Method :showTotalSpare start");

		logger.info("Method :showTotalSpare endss");
		return assetEquipementExecuteDao.showTotalSpare(cat,scat,orgName, orgDivision);
	}
	
	@PostMapping(value = "rest-asset-execute-request-add")
	public JsonResponse<Object> addRequestEx(@RequestBody List<AssetEquipementRequestRestModel> assetEquipementRequestRestModel) {
		logger.info("Method : addRequestEx starts");
		logger.info("Method : addRequestEx ends");
		return assetEquipementExecuteDao.addRequestEx(assetEquipementRequestRestModel);
	}
	@RequestMapping(value = "rest-equipement-exrequest-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewEquipementDetails(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewEquipementDetailsEx start");

		logger.info("Method :viewEquipementDetailsEx endss");
		return assetEquipementExecuteDao.viewEquipementDetailsEx(orgName, orgDivision);
	}
}
