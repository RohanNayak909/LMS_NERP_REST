package nirmalya.aatithya.restmodule.productionplan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.productionplan.dao.DailyRosterDao;
import nirmalya.aatithya.restmodule.productionplan.dao.ProductionDashboardDao;
import nirmalya.aatithya.restmodule.productionplan.model.RestPlanningProductionParentModel;
import nirmalya.aatithya.restmodule.productionplan.model.RestProductionPlanningProductList;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;

@RestController
@RequestMapping(value = { "production/" })
public class ProductionDashboardController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	ProductionDashboardDao productionDashboardDao;


	// organisation
	@RequestMapping(value = "getOrganization", method = { RequestMethod.GET })
	public List<DropDownModel> getOrganizationDivision(@RequestParam String orgName) {
		logger.info("Method : getOrganizationDivision starts");

		logger.info("Method : getOrganizationDivision ends");
		return productionDashboardDao.getOrganization(orgName);
	}

	// organisationDivision
	@RequestMapping(value = "getDivision", method = { RequestMethod.GET })
	public List<DropDownModel> getDivision(@RequestParam String orgName) {
		logger.info("Method : getDivision starts");

		logger.info("Method : getDivision ends");
		return productionDashboardDao.getDivision(orgName);
	}
	
	
	@RequestMapping(value = "getProductInAnalysis", method = { RequestMethod.GET })
	public List<DropDownModel> getProductInAnalysis(@RequestParam String orgName) {
		logger.info("Method : getProductInAnalysis starts");

		logger.info("Method : getProductInAnalysis ends");
		return productionDashboardDao.getProductInAnalysis(orgName);
	}
	
	
	
	//oprationalProdctionHeadCount1
	@RequestMapping(value = "oprationalProdctionHeadCount1", method = { RequestMethod.GET })
	public JsonResponse<Object> oprationalProdctionHeadCount1(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :oprationalProdctionHeadCount1 start");
		logger.info("Method :oprationalProdctionHeadCount1 endss");
		return productionDashboardDao.oprationalProdctionHeadCount1(fromDate, toDate, location, org, orgDiv);
	}
	
	//oprationalProdctionHeadCount2
	@RequestMapping(value = "oprationalProdctionHeadCount2", method = { RequestMethod.GET })
	public JsonResponse<Object> oprationalProdctionHeadCount2(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :oprationalProdctionHeadCount2 start");
		logger.info("Method :oprationalProdctionHeadCount2 endss");
		return productionDashboardDao.oprationalProdctionHeadCount2(fromDate, toDate, location, org, orgDiv);
	}
	
	
	
	
	@RequestMapping(value = "dashboard-getAllData-oprtnl", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllDataOprtnls(@RequestParam String id,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String location
			, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getAllDataOprtnls start");
		logger.info("Method :getAllDataOprtnls endss");
		return productionDashboardDao.getAllDataOprtnls(id, fromDate, toDate, location, org, orgDiv);
	}

	//ooeProdctionHeadCount
	@RequestMapping(value = "ooeProdctionHeadCount", method = { RequestMethod.GET })
	public JsonResponse<Object> ooeProdctionHeadCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :ooeProdctionHeadCount start");
		logger.info("Method :ooeProdctionHeadCount endss");
		return productionDashboardDao.ooeProdctionHeadCount(fromDate, toDate, location, org, orgDiv);
	}
	
	//getAllMachineSpecializationDtls
	@RequestMapping(value = "getAllMachineSpecializationDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllMachineSpecializationDtls(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getAllMachineSpecializationDtls start");
		logger.info("Method :getAllMachineSpecializationDtls endss");
		return productionDashboardDao.getAllMachineSpecializationDtls(fromDate, toDate, location, org, orgDiv);
	}
	
	//prodctionHeadCount
	@RequestMapping(value = "prodctionHeadCount", method = { RequestMethod.GET })
	public JsonResponse<Object> prodctionHeadCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :prodctionHeadCount start");
		logger.info("Method :prodctionHeadCount endss");
		return productionDashboardDao.prodctionHeadCount(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardAvgMonthlySalesDetails
	@RequestMapping(value = "dashboardAvgMonthlySalesDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardAvgMonthlySalesDetails(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardAvgMonthlySalesDetails start");
		logger.info("Method :dashboardAvgMonthlySalesDetails endss");
		return productionDashboardDao.dashboardAvgMonthlySalesDetails(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardTopFiveProductRevenue
	@RequestMapping(value = "dashboardTopFiveProductRevenue", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTopFiveProductRevenue(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTopFiveProductRevenue start");
		logger.info("Method :dashboardTopFiveProductRevenue endss");
		return productionDashboardDao.dashboardTopFiveProductRevenue(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardTopFiveProductByProduction
	@RequestMapping(value = "dashboardTopFiveProductByProduction", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTopFiveProductByProduction(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTopFiveProductByProduction start");
		logger.info("Method :dashboardTopFiveProductByProduction endss");
		return productionDashboardDao.dashboardTopFiveProductByProduction(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardMachineBreakdown
	@RequestMapping(value = "dashboardMachineBreakdown", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardMachineBreakdown(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardMachineBreakdown start");
		logger.info("Method :dashboardMachineBreakdown endss");
		return productionDashboardDao.dashboardMachineBreakdown(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardReturnByReason
	@RequestMapping(value = "dashboardReturnByReason", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardReturnByReason(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardReturnByReason start");
		logger.info("Method :dashboardReturnByReason endss");
		return productionDashboardDao.dashboardReturnByReason(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardReturnByReasonType
	@RequestMapping(value = "dashboardReturnByReasonType", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardReturnByReasonType(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv, @RequestParam String type) {
		logger.info("Method :dashboardReturnByReasonType start");
		logger.info("Method :dashboardReturnByReasonType endss");
		return productionDashboardDao.dashboardReturnByReasonType(fromDate, toDate, location, org, orgDiv, type);
	}
	
	//dashboardRightFirstTime
	@RequestMapping(value = "dashboardRightFirstTime", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardRightFirstTime(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardRightFirstTime start");
		logger.info("Method :dashboardRightFirstTime endss");
		return productionDashboardDao.dashboardRightFirstTime(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardAvgRightFirstTime
	@RequestMapping(value = "dashboardAvgRightFirstTime", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardAvgRightFirstTime(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardAvgRightFirstTime start");
		logger.info("Method :dashboardAvgRightFirstTime endss");
		return productionDashboardDao.dashboardAvgRightFirstTime(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardMostCommonDefect
	@RequestMapping(value = "dashboardMostCommonDefect", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardMostCommonDefect(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardMostCommonDefect start");
		logger.info("Method :dashboardMostCommonDefect endss");
		return productionDashboardDao.dashboardMostCommonDefect(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardRateOfReturn
	@RequestMapping(value = "dashboardRateOfReturn", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardRateOfReturn(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardRateOfReturn start");
		logger.info("Method :dashboardRateOfReturn endss");
		return productionDashboardDao.dashboardRateOfReturn(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardRateOfReturnByType
	
	@RequestMapping(value = "dashboardRateOfReturnByType", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardRateOfReturnByType(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String type) {
		logger.info("Method :dashboardRateOfReturnByType start");
		logger.info("Method :dashboardRateOfReturnByType endss");
		return productionDashboardDao.dashboardRateOfReturnByType(fromDate, toDate, location, org, orgDiv, type);
	}
	
	//dashboardDefectDensity
	@RequestMapping(value = "dashboardDefectDensity", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardDefectDensity(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardDefectDensity start");
		logger.info("Method :dashboardDefectDensity endss");
		return productionDashboardDao.dashboardDefectDensity(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardCostManagementCount
	@RequestMapping(value = "dashboardCostManagementCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardCostManagementCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardCostManagementCount start");
		logger.info("Method :dashboardCostManagementCount endss");
		return productionDashboardDao.dashboardCostManagementCount(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardCostManagementReturnOnAssets
	@RequestMapping(value = "dashboardCostManagementReturnOnAssets", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardCostManagementReturnOnAssets(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardCostManagementReturnOnAssets start");
		logger.info("Method :dashboardCostManagementReturnOnAssets endss");
		return productionDashboardDao.dashboardCostManagementReturnOnAssets(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardCostMangmntMaintenenceWithTarget
	@RequestMapping(value = "dashboardCostMangmntMaintenenceWithTarget", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardCostMangmntMaintenenceWithTarget(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardCostMangmntMaintenenceWithTarget start");
		logger.info("Method :dashboardCostMangmntMaintenenceWithTarget endss");
		return productionDashboardDao.dashboardCostMangmntMaintenenceWithTarget(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardCostManagementAssetTurnOver
	@RequestMapping(value = "dashboardCostManagementAssetTurnOver", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardCostManagementAssetTurnOver(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardCostManagementAssetTurnOver start");
		logger.info("Method :dashboardCostManagementAssetTurnOver endss");
		return productionDashboardDao.dashboardCostManagementAssetTurnOver(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardCostManagementUnitCostTarget
	@RequestMapping(value = "dashboardCostManagementUnitCostTarget", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardCostManagementUnitCostTarget(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardCostManagementUnitCostTarget start");
		logger.info("Method :dashboardCostManagementUnitCostTarget endss");
		return productionDashboardDao.dashboardCostManagementUnitCostTarget(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardKPIEffectiveness
	@RequestMapping(value = "dashboardKPIEffectiveness", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardKPIEffectiveness(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardKPIEffectiveness start");
		logger.info("Method :dashboardKPIEffectiveness endss");
		return productionDashboardDao.dashboardKPIEffectiveness(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardKPIQualityPerformance
	@RequestMapping(value = "dashboardKPIQualityPerformance", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardKPIQualityPerformance(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardKPIQualityPerformance start");
		logger.info("Method :dashboardKPIQualityPerformance endss");
		return productionDashboardDao.dashboardKPIQualityPerformance(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardKPIProduction
	@RequestMapping(value = "dashboardKPIProduction", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardKPIProduction(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardKPIProduction start");
		logger.info("Method :dashboardKPIProduction endss");
		return productionDashboardDao.dashboardKPIProduction(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardKPICostRevenue
	@RequestMapping(value = "dashboardKPICostRevenue", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardKPICostRevenue(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardKPICostRevenue start");
		logger.info("Method :dashboardKPICostRevenue endss");
		return productionDashboardDao.dashboardKPICostRevenue(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardAnalysisHeadCount   
	@RequestMapping(value = "dashboardAnalysisHeadCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardAnalysisHeadCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,@RequestParam String productSkuId,
			@RequestParam String currentMonth, @RequestParam String currentYear, @RequestParam String lastMonth,@RequestParam String lastYear) {
		logger.info("Method :dashboardAnalysisHeadCount start");
		logger.info("Method :dashboardAnalysisHeadCount endss");
		return productionDashboardDao.dashboardAnalysisHeadCount(fromDate, toDate, location, org, orgDiv, productSkuId,
				currentMonth, currentYear, lastMonth, lastYear);
	}
	
	//dashboardAnalysisCountOnProductSKUId  
	@RequestMapping(value = "dashboardAnalysisCountOnProductSKUId", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardAnalysisCountOnProductSKUId(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv, @RequestParam String productSkuId) {
		logger.info("Method :dashboardAnalysisCountOnProductSKUId start");
		logger.info("Method :dashboardAnalysisCountOnProductSKUId endss");
		return productionDashboardDao.dashboardAnalysisCountOnProductSKUId(fromDate, toDate, location, org, orgDiv, productSkuId);
	}
	
	//dashboardAnalysisRuntimeDowntime
	@RequestMapping(value = "dashboardAnalysisRuntimeDowntime", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardAnalysisRuntimeDowntime(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardAnalysisRuntimeDowntime start");
		logger.info("Method :dashboardAnalysisRuntimeDowntime endss");
		return productionDashboardDao.dashboardAnalysisRuntimeDowntime(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardAnalysisProductionCost
	@RequestMapping(value = "dashboardAnalysisProductionCost", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardAnalysisProductionCost(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardAnalysisProductionCost start");
		logger.info("Method :dashboardAnalysisProductionCost endss");
		return productionDashboardDao.dashboardAnalysisProductionCost(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardAnalysisAvailablePerformQualityEffect
	@RequestMapping(value = "dashboardAnalysisAvailablePerformQualityEffect", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardAnalysisAvailablePerformQualityEffect(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardAnalysisAvailablePerformQualityEffect start");
		logger.info("Method :dashboardAnalysisAvailablePerformQualityEffect endss");
		return productionDashboardDao.dashboardAnalysisAvailablePerformQualityEffect(fromDate, toDate, location, org, orgDiv);
	}

	/* =======================================Control=========================== */
	//dashboardControlCount1
	@RequestMapping(value = "dashboardCycleYieldThroughputWorkForceLeadCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardCycleYieldThroughputWorkForceLeadCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardCycleYieldThroughputWorkForceLeadCount start");
		logger.info("Method :dashboardCycleYieldThroughputWorkForceLeadCount endss");
		return productionDashboardDao.dashboardCycleYieldThroughputWorkForceLeadCount(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardQtyReworkProductionOrderedQtyCount
	@RequestMapping(value = "dashboardQtyReworkProductionOrderedQtyCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardQtyReworkProductionOrderedQtyCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String currentMonth,@RequestParam String currentYear,@RequestParam String lastMonth,
			@RequestParam String lastYear) {
		logger.info("Method :dashboardQtyReworkProductionOrderedQtyCount start");
		logger.info("Method :dashboardQtyReworkProductionOrderedQtyCount endss");
		return productionDashboardDao.dashboardQtyReworkProductionOrderedQtyCount(fromDate, toDate, location, org, orgDiv, currentMonth, currentYear, lastMonth, lastYear);
	}
	
	
	//dashboardControlOOECapacityFirstScapeCount
	@RequestMapping(value = "dashboardControlOOECapacityFirstScapeCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardControlOOECapacityFirstScapeCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardControlOOECapacityFirstScapeCount start");
		logger.info("Method :dashboardControlOOECapacityFirstScapeCount endss");
		return productionDashboardDao.dashboardControlOOECapacityFirstScapeCount(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardControlAvailabilityPerformanceEffectivenessCount
	@RequestMapping(value = "dashboardControlAvailabilityPerformanceEffectivenessCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardControlAvailabilityPerformanceEffectivenessCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardControlAvailabilityPerformanceEffectivenessCount start");
		logger.info("Method :dashboardControlAvailabilityPerformanceEffectivenessCount endss");
		return productionDashboardDao.dashboardControlAvailabilityPerformanceEffectivenessCount(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardControlRightFirstTime
	@RequestMapping(value = "dashboardControlRightFirstTime", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardControlRightFirstTime(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardControlRightFirstTime start");
		logger.info("Method :dashboardControlRightFirstTime endss");
		return productionDashboardDao.dashboardControlRightFirstTime(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardControlThroughPut
	@RequestMapping(value = "dashboardControlThroughPut", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardControlThroughPut(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardControlThroughPut start");
		logger.info("Method :dashboardControlThroughPut endss");
		return productionDashboardDao.dashboardControlThroughPut(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardControlCostAnalysisOverTime
	@RequestMapping(value = "dashboardControlCostAnalysisOverTime", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardControlCostAnalysisOverTime(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardControlCostAnalysisOverTime start");
		logger.info("Method :dashboardControlCostAnalysisOverTime endss");
		return productionDashboardDao.dashboardControlCostAnalysisOverTime(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardControlProductionVariance
	@RequestMapping(value = "dashboardControlProductionVariance", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardControlProductionVariance(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardControlProductionVariance start");
		logger.info("Method :dashboardControlProductionVariance endss");
		return productionDashboardDao.dashboardControlProductionVariance(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardControlTopFiveMachineProduction
	@RequestMapping(value = "dashboardControlTopFiveMachineProduction", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardControlTopFiveMachineProduction(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardControlTopFiveMachineProduction start");
		logger.info("Method :dashboardControlTopFiveMachineProduction endss");
		return productionDashboardDao.dashboardControlTopFiveMachineProduction(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardControlProductionEfficiencyRuntimeDowntime
	@RequestMapping(value = "dashboardControlProductionEfficiencyRuntimeDowntime", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardControlProductionEfficiencyRuntimeDowntime(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardControlProductionEfficiencyRuntimeDowntime start");
		logger.info("Method :dashboardControlProductionEfficiencyRuntimeDowntime endss");
		return productionDashboardDao.dashboardControlProductionEfficiencyRuntimeDowntime(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardControlHoursToProductCompletionByProduct
	@RequestMapping(value = "dashboardControlHoursToProductCompletionByProduct", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardControlHoursToProductCompletionByProduct(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardControlHoursToProductCompletionByProduct start");
		logger.info("Method :dashboardControlHoursToProductCompletionByProduct endss");
		return productionDashboardDao.dashboardControlHoursToProductCompletionByProduct(fromDate, toDate, location, org, orgDiv);
	}
	
	//dashboardControlDefectAnalysisTypeRate
	@RequestMapping(value = "dashboardControlDefectAnalysisTypeRate", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardControlDefectAnalysisTypeRate(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardControlDefectAnalysisTypeRate start");
		logger.info("Method :dashboardControlDefectAnalysisTypeRate endss");
		return productionDashboardDao.dashboardControlDefectAnalysisTypeRate(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//============================TEAM=======================
	//dashboardTeamSafetyCalender
	@RequestMapping(value = "dashboardTeamSafetyCalender", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamSafetyCalender(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamSafetyCalender start");
		logger.info("Method :dashboardTeamSafetyCalender endss");
		return productionDashboardDao.dashboardTeamSafetyCalender(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamQualityCalender
	@RequestMapping(value = "dashboardTeamQualityCalender", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamQualityCalender(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamQualityCalender start");
		logger.info("Method :dashboardTeamQualityCalender endss");
		return productionDashboardDao.dashboardTeamQualityCalender(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamDeliveryCalender
	@RequestMapping(value = "dashboardTeamDeliveryCalender", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamDeliveryCalender(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamDeliveryCalender start");
		logger.info("Method :dashboardTeamDeliveryCalender endss");
		return productionDashboardDao.dashboardTeamDeliveryCalender(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamCostCalender
	@RequestMapping(value = "dashboardTeamCostCalender", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamCostCalender(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamCostCalender start");
		logger.info("Method :dashboardTeamCostCalender endss");
		return productionDashboardDao.dashboardTeamCostCalender(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamNotes
	@RequestMapping(value = "dashboardTeamNotes", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamNotes(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamNotes start");
		logger.info("Method :dashboardTeamNotes endss");
		return productionDashboardDao.dashboardTeamNotes(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamSafetySmryMTDCount
	@RequestMapping(value = "dashboardTeamSafetySmryMTDCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamSafetySmryMTDCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamSafetySmryMTDCount start");
		logger.info("Method :dashboardTeamSafetySmryMTDCount endss");
		return productionDashboardDao.dashboardTeamSafetySmryMTDCount(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamQualityTrend
	@RequestMapping(value = "dashboardTeamQualityTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamQualityTrend(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamQualityTrend start");
		logger.info("Method :dashboardTeamQualityTrend endss");
		return productionDashboardDao.dashboardTeamQualityTrend(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamWeeklyScheduledAttainment
	@RequestMapping(value = "dashboardTeamWeeklyScheduledAttainment", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamWeeklyScheduledAttainment(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamWeeklyScheduledAttainment start");
		logger.info("Method :dashboardTeamWeeklyScheduledAttainment endss");
		return productionDashboardDao.dashboardTeamWeeklyScheduledAttainment(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamCostTrend
	@RequestMapping(value = "dashboardTeamCostTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamCostTrend(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamCostTrend start");
		logger.info("Method :dashboardTeamCostTrend endss");
		return productionDashboardDao.dashboardTeamCostTrend(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamTopSafetyConcerns
	@RequestMapping(value = "dashboardTeamTopSafetyConcerns", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamTopSafetyConcerns(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamTopSafetyConcerns start");
		logger.info("Method :dashboardTeamTopSafetyConcerns endss");
		return productionDashboardDao.dashboardTeamTopSafetyConcerns(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamTopDefectCategories
	@RequestMapping(value = "dashboardTeamTopDefectCategories", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamTopDefectCategories(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamTopDefectCategories start");
		logger.info("Method :dashboardTeamTopDefectCategories endss");
		return productionDashboardDao.dashboardTeamTopDefectCategories(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamDailyScheduledAttainment
	@RequestMapping(value = "dashboardTeamDailyScheduledAttainment", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamDailyScheduledAttainment(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamDailyScheduledAttainment start");
		logger.info("Method :dashboardTeamDailyScheduledAttainment endss");
		return productionDashboardDao.dashboardTeamDailyScheduledAttainment(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamTopLines
	@RequestMapping(value = "dashboardTeamTopLines", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamTopLines(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamTopLines start");
		logger.info("Method :dashboardTeamTopLines endss");
		return productionDashboardDao.dashboardTeamTopLines(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamSafetyCorrectiveAction
	@RequestMapping(value = "dashboardTeamSafetyCorrectiveAction", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamSafetyCorrectiveAction(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamSafetyCorrectiveAction start");
		logger.info("Method :dashboardControlDefectAnalysisTypeRate endss");
		return productionDashboardDao.dashboardTeamSafetyCorrectiveAction(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamQualityCorrectiveAction
	@RequestMapping(value = "dashboardTeamQualityCorrectiveAction", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamQualityCorrectiveAction(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamQualityCorrectiveAction start");
		logger.info("Method :dashboardTeamQualityCorrectiveAction endss");
		return productionDashboardDao.dashboardTeamQualityCorrectiveAction(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamDeliveryAction
	@RequestMapping(value = "dashboardTeamDeliveryAction", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamDeliveryAction(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamDeliveryAction start");
		logger.info("Method :dashboardTeamDeliveryAction endss");
		return productionDashboardDao.dashboardTeamDeliveryAction(fromDate, toDate, location, org, orgDiv);
	}
	
	
	//dashboardTeamCostCorrectiveAction
	@RequestMapping(value = "dashboardTeamCostCorrectiveAction", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTeamCostCorrectiveAction(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String location, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :dashboardTeamCostCorrectiveAction start");
		logger.info("Method :dashboardTeamCostCorrectiveAction endss");
		return productionDashboardDao.dashboardTeamCostCorrectiveAction(fromDate, toDate, location, org, orgDiv);
	}
	
	
}
