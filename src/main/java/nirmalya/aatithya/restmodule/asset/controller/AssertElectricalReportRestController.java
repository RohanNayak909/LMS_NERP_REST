package nirmalya.aatithya.restmodule.asset.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetElectricalReportDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@RestController
@RequestMapping(value = { "asset/" })
public class AssertElectricalReportRestController {

	Logger logger = LoggerFactory.getLogger(AssertElectricalReportRestController.class);

	@Autowired
	AssetElectricalReportDao assetElectricalReportDao;
	
	@RequestMapping(value = "rest-asset-assign-get-emergrncy-light", method = { RequestMethod.GET })
	public JsonResponse<Object> getEmergencyLightData(@RequestParam String selectedMonth,
			@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method :getEmergencyLightData start");

		logger.info("Method :getEmergencyLightData endss");
		return assetElectricalReportDao.getEmergencyLightData(selectedMonth,orgName, orgDiv);
	}
	@RequestMapping(value = "rest-asset-assign-get-earthing-checklist", method = { RequestMethod.GET })
	public JsonResponse<Object> getEarthingChecklistData(@RequestParam String selectedMonth, 
			@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method :getEarthingChecklistData start");

		logger.info("Method :getEarthingChecklistData endss");
		return assetElectricalReportDao.getEarthingChecklistData(selectedMonth,orgName, orgDiv);
	}
	
	@RequestMapping(value = "rest-asset-assign-get-control-area", method = { RequestMethod.GET })
	public JsonResponse<Object> getControlAreaData(@RequestParam String fromDate,@RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method :getControlAreaData start");

		logger.info("Method :getControlAreaData endss");
		return assetElectricalReportDao.getControlAreaData(fromDate,toDate,orgName, orgDiv);
	}
	
	@RequestMapping(value = "rest-getAssetLists", method = { RequestMethod.GET })
    public List<DropDownModel> getAssetList(@RequestParam String userId,
    		@RequestParam String orgName,@RequestParam String orgDivision,@RequestParam String policyId) {
        logger.info("Method : getAssetList starts");

        logger.info("Method : getAssetList ends");
        return assetElectricalReportDao.getAssetList(userId,orgName,orgDivision,policyId);
    }

	@RequestMapping(value = "rest-reports-gen", method = { RequestMethod.GET })
	public JsonResponse<Object> transformerCheckPonit(@RequestParam String mon, @RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String assetId) {
		logger.info("Method :transformerCheckPonit start");

		logger.info("Method :transformerCheckPonit endss");
		return assetElectricalReportDao.transforerReport(orgName, orgDivision, mon, assetId);
	}

	// reports-disel-gen
	@RequestMapping(value = "reports-disel-gen", method = { RequestMethod.GET })
	public JsonResponse<Object> diselGenerator(@RequestParam String mon, @RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String assetId) {
		logger.info("Method :diselGenerator start");

		logger.info("Method :diselGenerator endss");
		return assetElectricalReportDao.diselGenerator(orgName, orgDivision, mon, assetId);
	}

	// rest-reports-apfc
	@RequestMapping(value = "rest-reports-apfc", method = { RequestMethod.GET })
	public JsonResponse<Object> viewApfcReports(@RequestParam String mon, @RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String assetId) {
		logger.info("Method :viewApfcReports start");

		logger.info("Method :viewApfcReports endss");
		return assetElectricalReportDao.viewApfcReports(orgName, orgDivision, mon, assetId);
	}
//	
//	@RequestMapping(value = "rest-getAssetLists", method = { RequestMethod.GET })
//    public List<DropDownModel> getAssetList(@RequestParam String userId,
//    		@RequestParam String orgName,@RequestParam String orgDivision,@RequestParam String policyId) {
//        logger.info("Method : getAssetList starts");
//
//        logger.info("Method : getAssetList ends");
//        return assetElectricalReportDao.getAssetList(userId,orgName,orgDivision,policyId);
//    }
	 
		@GetMapping("rest-filter-policy-data")
		public JsonResponse<Object> getPolicyFilterData(@RequestParam String month,
			  @RequestParam String orgName,@RequestParam String orgDiv) {
			logger.info("Method :getPolicyFilterData start");

			logger.info("Method :getPolicyFilterData ends");
			return assetElectricalReportDao.getPolicyFilterData(month, orgName, orgDiv);
		}
		@GetMapping("rest-filter-portal-data")
		public JsonResponse<Object> getPortalToolReport(@RequestParam String month ,@RequestParam String orgName,@RequestParam String orgDiv) {
			logger.info("Method :getPortalToolReport start");

			logger.info("Method :getPortalToolReport ends");
			return assetElectricalReportDao.getPortalToolReport(month,orgName, orgDiv);
		}
		
		@GetMapping("rest-filter-panel-report")
		public JsonResponse<Object> getPanelCheckRecord(@RequestParam String selectedMonth,
				@RequestParam String orgName, @RequestParam String orgDiv) {
			logger.info("Method :getPanelCheckRecord start");

			logger.info("Method :getPanelCheckRecord ends");
			return assetElectricalReportDao.getPanelCheckRecord(selectedMonth,orgName, orgDiv);
		}
}
