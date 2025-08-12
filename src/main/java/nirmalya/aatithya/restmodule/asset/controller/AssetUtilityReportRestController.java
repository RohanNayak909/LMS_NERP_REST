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

import nirmalya.aatithya.restmodule.asset.dao.AssetUtilityReportDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = { "asset/" })
public class AssetUtilityReportRestController {

	Logger logger = LoggerFactory.getLogger(AssetUtilityReportRestController.class);

	@Autowired
	AssetUtilityReportDao assetUtilityReportDao;

	@GetMapping("rest-filter-air-compreessor")
	public JsonResponse<Object> getAirCompreessor(@RequestParam String month, @RequestParam String assetId,
			@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method :getAirCompreessor start");

		logger.info("Method :getAirCompreessor ends");
		return assetUtilityReportDao.getAirCompreessor(month, assetId, orgName, orgDiv);
	}

	// view Hvac Monitoring
	@RequestMapping(value = "rest-viewHvacMonitoring", method = { RequestMethod.GET })
	public JsonResponse<Object> viewHvacMonitoring(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String policyId) {
		logger.info("Method :viewHvacMonitoring start");

		logger.info("Method :viewHvacMonitoring endss");
		return assetUtilityReportDao.viewHvacMonitoring(orgName, orgDivision, userId, fromDate, toDate, policyId);
	}

	@RequestMapping(value = "rest-asset-assign-get-annexture-filter", method = { RequestMethod.GET })
	public JsonResponse<Object> getAnnextureFilterData(@RequestParam String yearName, @RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName, @RequestParam String orgDiv) {
		logger.info("Method :getAnnextureFilterData start");

		logger.info("Method :getAnnextureFilterData endss");
		return assetUtilityReportDao.getAnnextureFilterData(yearName, fromDate,toDate, orgName, orgDiv);
	}

	@GetMapping("rest-filter-cleaning-checklist")
	public JsonResponse<Object> getfilterCleaningView(@RequestParam String month, @RequestParam String assetId,
			@RequestParam String orgName, @RequestParam String orgDiv, @RequestParam String policyId) {
		logger.info("Method :getfilterCleaningView start");

		logger.info("Method :getfilterCleaningView ends");
		return assetUtilityReportDao.getfilterCleaningView(month, assetId, orgName, orgDiv, policyId);
	}

	// view Ahu Dut Cleaning
	@RequestMapping(value = "rest-viewAhuDutCleaning", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAhuDutCleaning(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String month, @RequestParam String currentYear) {
		logger.info("Method :viewAhuDutCleaning start");

		logger.info("Method :viewAhuDutCleaning endss");
		return assetUtilityReportDao.viewAhuDutCleaning(orgName, orgDivision, userId, month, currentYear);
	}

	// view Chiller1
	@RequestMapping(value = "rest-viewChiller1", method = { RequestMethod.GET })
	public JsonResponse<Object> viewChiller1(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String date) {
		logger.info("Method :viewChiller1 start");

		logger.info("Method :viewChiller1 endss");
		return assetUtilityReportDao.viewChiller1(orgName, orgDivision, userId, date);
	}

	// rest-getAirCompTypList
	@RequestMapping(value = "rest-getAirCompTypList", method = { RequestMethod.GET })
	public List<DropDownModel> getAirCompDryTpyeList(@RequestParam String userId, @RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String policyId) {
		logger.info("Method : getAirCompDryTpyeList starts");

		logger.info("Method : getAssetList ends");
		return assetUtilityReportDao.getAirCompDryTpyeList(userId, orgName, orgDivision, policyId);
	}

	// rest-view-aircomDry
	@RequestMapping(value = "rest-view-aircomDry", method = { RequestMethod.GET })
	public JsonResponse<Object> vewAirCompDryData(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String date, @RequestParam String type, @RequestParam String policyId) {
		logger.info("Method :vewAirCompDryData start");

		logger.info("Method :vewAirCompDryData endss");
		return assetUtilityReportDao.vewAirCompDryData(orgName, orgDivision, userId, date, type, policyId);
	}

	// rest-view-rhTemp

	@RequestMapping(value = "rest-view-rhTemp", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRhTempData(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String date, @RequestParam String type, @RequestParam String policyId) {
		logger.info("Method :viewRhTempData start");

		logger.info("Method :viewRhTempData endss");
		return assetUtilityReportDao.viewRhTempData(orgName, orgDivision, userId, date, type, policyId);
	}

}
