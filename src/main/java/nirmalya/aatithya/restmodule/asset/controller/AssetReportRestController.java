package nirmalya.aatithya.restmodule.asset.controller;

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

import nirmalya.aatithya.restmodule.asset.dao.AssetAssignDao;
import nirmalya.aatithya.restmodule.asset.dao.AssetReportDao;
import nirmalya.aatithya.restmodule.asset.dao.AssetViewMasterDao;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;

@RestController
@RequestMapping(value = { "asset/" })
public class AssetReportRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AssetReportDao assetReportDao;



	// View Assigned Asset
	@RequestMapping(value = "rest-asset-report-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAssetReport(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewAssetReport start");

		logger.info("Method :viewAssetReport endss");
		return assetReportDao.viewAssetReport(orgName, orgDivision);
	}
	// Report List
	@RequestMapping(value = "asset-report-list", method = { RequestMethod.GET })
	public JsonResponse<Object> showTotal(@RequestParam String type,String cat,String scat,String action, String orgName, String orgDivision) {
		logger.info("Method :showTotal start");

		logger.info("Method :showTotal endss");
		return assetReportDao.showTotal(type,cat,scat,action, orgName, orgDivision);
	}

}
