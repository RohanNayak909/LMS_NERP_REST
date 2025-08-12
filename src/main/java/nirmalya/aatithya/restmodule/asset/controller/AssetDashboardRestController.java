package nirmalya.aatithya.restmodule.asset.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetDashboardDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "gatepass/")
public class AssetDashboardRestController {

	Logger logger = LoggerFactory.getLogger(AssetDashboardRestController.class);

	@Autowired
	AssetDashboardDao assetDashboardDao;

	/*@RequestMapping(value = "assetdashboard-getAllData", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllData(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id, @RequestParam String month, @RequestParam String year) {
		logger.info("Method :getAllData start");

		logger.info("Method :getAllData endss");
		return assetDashboardDao.getAllData(orgName, orgDivision, id, month, year);

	}*/

	/*@RequestMapping(value = "dashboard-oprationalHeadData", method = { RequestMethod.GET })
	public JsonResponse<Object> oprationalHeadData(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String month, @RequestParam String year) {
		logger.info("Method :oprationalHeadData start");

		logger.info("Method :oprationalHeadData endss");
		return assetDashboardDao.oprationalHeadData(orgName, orgDivision, month, year);

	}*/

	@RequestMapping(value = "assetcategorydashboard", method = { RequestMethod.GET })
	public JsonResponse<Object> salesstateperformance(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :salesstateperformance start");

		logger.info("Method :salesstateperformance endss");
		return assetDashboardDao.salesstateperformance(orgName, orgDivision);

	}

	@RequestMapping(value = "assetEndOfLife-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> assetEndOfLife(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :assetEndOfLife start");

		logger.info("Method :assetEndOfLife endss");
		return assetDashboardDao.assetEndOfLife(orgName, orgDivision);

	}

	@RequestMapping(value = "assetVerificationStatus-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> assetVerificationStatus(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :assetVerificationStatus start");

		logger.info("Method :assetVerificationStatus endss");
		return assetDashboardDao.assetVerificationStatus(orgName, orgDivision);

	}

	@RequestMapping(value = "assetTotalSpend-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> assetTotalSpend(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :assetTotalSpend start");

		logger.info("Method :assetTotalSpend endss");
		return assetDashboardDao.assetTotalSpend(orgName, orgDivision);

	}

	@RequestMapping(value = "assetBreakupHardwareAssets-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> assetBreakupHardwareAssets(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :assetBreakupHardwareAssets start");

		logger.info("Method :assetBreakupHardwareAssets endss");
		return assetDashboardDao.assetBreakupHardwareAssets(orgName, orgDivision);

	}

	@RequestMapping(value = "assetAssetCountByLocation-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> assetAssetCountByLocation(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :assetAssetCountByLocation start");

		logger.info("Method :assetAssetCountByLocation endss");
		return assetDashboardDao.assetAssetCountByLocation(orgName, orgDivision);

	}

	@RequestMapping(value = "assetAssetCountByLifeState-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> assetAssetCountByLifeState(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :assetAssetCountByLifeState start");

		logger.info("Method :assetAssetCountByLifeState endss");
		return assetDashboardDao.assetAssetCountByLifeState(orgName, orgDivision);

	}

	@RequestMapping(value = "assetAssetValueByCategory-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> assetAssetValueByCategory(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :assetAssetValueByCategory start");

		logger.info("Method :assetAssetValueByCategory endss");
		return assetDashboardDao.assetAssetValueByCategory(orgName, orgDivision);

	}

	@RequestMapping(value = "assetAssetsPulledFromPool-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> assetAssetsPulledFromPool(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :assetAssetsPulledFromPool start and end");
		return assetDashboardDao.assetAssetsPulledFromPool(orgName, orgDivision);
	}

	@RequestMapping(value = "assetAssetFulfillmentTime-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> assetAssetFulfillmentTime(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :assetAssetFulfillmentTime start and end");
		return assetDashboardDao.assetAssetFulfillmentTime(orgName, orgDivision);
	}

	@RequestMapping(value = "assetValuation-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> assetValuation(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :assetValuation start and end");
		return assetDashboardDao.assetValuation(orgName, orgDivision);
	}

	@RequestMapping(value = "scrapedValuation-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> scrapedValuation(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :scrapedValuation start and end");
		return assetDashboardDao.scrapedValuation(orgName, orgDivision);
	}

	@RequestMapping(value = "netAssetValuation-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> netAssetValuation(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :netAssetValuation start and end");
		return assetDashboardDao.netAssetValuation(orgName, orgDivision);
	}

	@RequestMapping(value = "maenTimeToRepair-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> maenTimeToRepair(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :maenTimeToRepair start and end");
		return assetDashboardDao.maenTimeToRepair(orgName, orgDivision);
	}
}
