package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.RestAccountDAshboardDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;


@RestController
@RequestMapping(value = { "account/" })
public class RestAccountDashboardController {
	Logger logger = LoggerFactory.getLogger(RestAccountDashboardController.class);

	@Autowired
	RestAccountDAshboardDao restAccountDAshboardDao;
	

	@RequestMapping(value = "getAllCounts", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllCounts(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :getAllCounts start");

		logger.info("Method :getAllCounts endss");
		return restAccountDAshboardDao.getAllCounts(orgName, orgDivision, fromDate, toDate);

	}

	@RequestMapping(value = "dashboard-account-getAllReport", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllReport(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id, @RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String loc) {
		logger.info("Method :getAllReport start");

		logger.info("Method :getAllReport endss");
		return restAccountDAshboardDao.getAllReport(orgName, orgDivision, id, fromDate, toDate, loc);

	}

	@RequestMapping(value = "dashboard-currentWorkingCapital", method = { RequestMethod.GET })
	public JsonResponse<Object> currentWorkingCapital(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :currentWorkingCapital start");

		logger.info("Method :currentWorkingCapital endss");
		return restAccountDAshboardDao.currentWorkingCapital(orgName, orgDivision, fromDate, toDate, loc);
	}

	// liquidityRatioDataCount
	@RequestMapping(value = "liquidityRatioDataCount", method = { RequestMethod.GET })
	public JsonResponse<Object> liquidityRatioDataCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :liquidityRatioDataCount start");

		logger.info("Method :liquidityRatioDataCount endss");
		return restAccountDAshboardDao.liquidityRatioDataCount(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardWorkingRatiosCount

	@RequestMapping(value = "dashboardWorkingRatiosCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardWorkingRatiosCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardWorkingRatiosCount start");

		logger.info("Method :dashboardWorkingRatiosCount endss");
		return restAccountDAshboardDao.dashboardWorkingRatiosCount(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardRiskRatiosCount
	@RequestMapping(value = "dashboardRiskRatiosCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardRiskRatiosCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardRiskRatiosCount start");

		logger.info("Method :dashboardRiskRatiosCount endss");
		return restAccountDAshboardDao.dashboardRiskRatiosCount(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardProfitabilityRatioCount
	@RequestMapping(value = "dashboardProfitabilityRatioCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardProfitabilityRatioCount(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardProfitabilityRatioCount start");

		logger.info("Method :dashboardProfitabilityRatioCount endss");
		return restAccountDAshboardDao.dashboardProfitabilityRatioCount(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardBalaceSheetPayableTabCount
	@RequestMapping(value = "dashboardBalaceSheetPayableTabCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalaceSheetPayableTabCount(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalaceSheetPayableTabCount start");

		logger.info("Method :dashboardBalaceSheetPayableTabCount endss");
		return restAccountDAshboardDao.dashboardBalaceSheetPayableTabCount(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardBalaceSheetReceivableTabCount
	@RequestMapping(value = "dashboardBalaceSheetReceivableTabCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalaceSheetReceivableTabCount(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalaceSheetReceivableTabCount start");

		logger.info("Method :dashboardBalaceSheetReceivableTabCount endss");
		return restAccountDAshboardDao.dashboardBalaceSheetReceivableTabCount(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalaceSheetFixedAssetsTabCount
	@RequestMapping(value = "dashboardBalaceSheetFixedAssetsTabCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalaceSheetFixedAssetsTabCount(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalaceSheetFixedAssetsTabCount start");

		logger.info("Method :dashboardBalaceSheetFixedAssetsTabCount endss");
		return restAccountDAshboardDao.dashboardBalaceSheetFixedAssetsTabCount(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalaceWorkingCapitalTabCount
	@RequestMapping(value = "dashboardBalaceWorkingCapitalTabCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalaceWorkingCapitalTabCount(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalaceWorkingCapitalTabCount start");

		logger.info("Method :dashboardBalaceWorkingCapitalTabCount endss");
		return restAccountDAshboardDao.dashboardBalaceWorkingCapitalTabCount(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardSubscriptionCount
	@RequestMapping(value = "dashboardSubscriptionCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardSubscriptionCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardSubscriptionCount start");

		logger.info("Method :dashboardSubscriptionCount endss");
		return restAccountDAshboardDao.dashboardSubscriptionCount(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardOutstandingRevenueExpenseCount
	@RequestMapping(value = "dashboardOutstandingRevenueExpenseCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardOutstandingRevenueExpenseCount(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String thisYear, @RequestParam String lastYear, @RequestParam String loc) {
		logger.info("Method :dashboardOutstandingRevenueExpenseCount start");

		logger.info("Method :dashboardOutstandingRevenueExpenseCount endss");
		return restAccountDAshboardDao.dashboardOutstandingRevenueExpenseCount(orgName, orgDivision, fromDate, toDate,
				thisYear, lastYear, loc);
	}

	// dashboardMainDsoDioDpoCount
	@RequestMapping(value = "dashboardMainDsoDioDpoCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardMainDsoDioDpoCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardMainDsoDioDpoCount start");

		logger.info("Method :dashboardMainDsoDioDpoCount endss");
		return restAccountDAshboardDao.dashboardMainDsoDioDpoCount(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardBalaceSheetDaysOrOthersCount
	@RequestMapping(value = "dashboardBalaceSheetDaysOrOthersCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalaceSheetDaysOrOthersCount(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalaceSheetDaysOrOthersCount start");

		logger.info("Method :dashboardBalaceSheetDaysOrOthersCount endss");
		return restAccountDAshboardDao.dashboardBalaceSheetDaysOrOthersCount(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardRatioComparisionCount
	@RequestMapping(value = "dashboardRatioComparisionCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardRatioComparisionCount(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardRatioComparisionCount start");

		logger.info("Method :dashboardRatioComparisionCount endss");
		return restAccountDAshboardDao.dashboardRatioComparisionCount(orgName, orgDivision, fromDate, toDate, loc);
	}

	@RequestMapping(value = "dashboard-currentBudgetVarience", method = { RequestMethod.GET })
	public JsonResponse<Object> currentBudgetVarience(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :currentBudgetVarience start");

		logger.info("Method :currentBudgetVarience endss");
		return restAccountDAshboardDao.currentBudgetVarience(orgName, orgDivision, fromDate, toDate, loc);
	}

	@RequestMapping(value = "dashboard-vendorpaymenterrorrate", method = { RequestMethod.GET })
	public JsonResponse<Object> vendorpaymenterrorrate(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :vendorpaymenterrorrate start");
		logger.info("Method :vendorpaymenterrorrate endss");
		return restAccountDAshboardDao.vendorpaymenterrorrate(orgName, orgDivision, fromDate, toDate, loc);
	}

	@RequestMapping(value = "dashboard-cashmanagementWorkingCap", method = { RequestMethod.GET })
	public JsonResponse<Object> cashmanagementWorkingCap(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :cashmanagementWorkingCap start");

		logger.info("Method :cashmanagementWorkingCap endss");
		return restAccountDAshboardDao.cashmanagementWorkingCap(orgName, orgDivision, fromDate, toDate, loc);
	}

	@RequestMapping(value = "dashboard-cashbalance", method = { RequestMethod.GET })
	public JsonResponse<Object> cashbalance(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :cashbalance start");
		logger.info("Method :cashbalance endss");
		return restAccountDAshboardDao.cashbalance(orgName, orgDivision, fromDate, toDate, loc);
	}

	// cashRatioTrend
	@RequestMapping(value = "cashRatioTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> cashRatioTrend(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :cashRatioTrend start");
		logger.info("Method :cashRatioTrend endss");
		return restAccountDAshboardDao.cashRatioTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	// quickRatioTrend
	@RequestMapping(value = "quickRatioTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> quickRatioTrend(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :quickRatioTrend start");
		logger.info("Method :quickRatioTrend endss");
		return restAccountDAshboardDao.quickRatioTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	// currentRatioTrend
	@RequestMapping(value = "currentRatioTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> currentRatioTrend(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :currentRatioTrend start");
		logger.info("Method :currentRatioTrend endss");
		return restAccountDAshboardDao.currentRatioTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	/// absoluteLiquidRatioTrend

	@RequestMapping(value = "absoluteLiquidRatioTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> absoluteLiquidRatioTrend(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :absoluteLiquidRatioTrend start");
		logger.info("Method :absoluteLiquidRatioTrend endss");
		return restAccountDAshboardDao.absoluteLiquidRatioTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	/// workingReceivableRatioTrend

	@RequestMapping(value = "workingReceivableRatioTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> workingReceivableRatioTrend(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :workingReceivableRatioTrend start");
		logger.info("Method :workingReceivableRatioTrend endss");
		return restAccountDAshboardDao.workingReceivableRatioTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	/// workingCashConversionRatioTrend

	@RequestMapping(value = "workingCashConversionRatioTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> workingCashConversionRatioTrend(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :workingCashConversionRatioTrend start");
		logger.info("Method :workingCashConversionRatioTrend endss");
		return restAccountDAshboardDao.workingCashConversionRatioTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	/// dashboardWorkingDebatorsRatioTrend

	@RequestMapping(value = "dashboardWorkingDebatorsRatioTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardWorkingDebatorsRatioTrend(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardWorkingDebatorsRatioTrend start");
		logger.info("Method :dashboardWorkingDebatorsRatioTrend endss");
		return restAccountDAshboardDao.dashboardWorkingDebatorsRatioTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	/// dashboardCreditorsRatioTrend
	@RequestMapping(value = "dashboardCreditorsRatioTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardCreditorsRatioTrend(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardCreditorsRatioTrend start");
		logger.info("Method :dashboardCreditorsRatioTrend endss");
		return restAccountDAshboardDao.dashboardCreditorsRatioTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	//////////////////////////////////////////////////
	// dashboardOperatingLeverageTrend

	@RequestMapping(value = "dashboardOperatingLeverageTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardOperatingLeverageTrend(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardOperatingLeverageTrend start");
		logger.info("Method :dashboardOperatingLeverageTrend endss");
		return restAccountDAshboardDao.dashboardOperatingLeverageTrend(orgName, orgDivision, fromDate, toDate, loc);
	}
	// dashboardFinancialLeverageTrend

	@RequestMapping(value = "dashboardFinancialLeverageTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardFinancialLeverageTrend(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardFinancialLeverageTrend start");
		logger.info("Method :dashboardFinancialLeverageTrend endss");
		return restAccountDAshboardDao.dashboardFinancialLeverageTrend(orgName, orgDivision, fromDate, toDate, loc);
	}
	// dashboardDebtToEquityTrend

	@RequestMapping(value = "dashboardDebtToEquityTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardDebtToEquityTrend(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardDebtToEquityTrend start");
		logger.info("Method :dashboardDebtToEquityTrend endss");
		return restAccountDAshboardDao.dashboardDebtToEquityTrend(orgName, orgDivision, fromDate, toDate, loc);
	}
	// dashboardInterestCoverageTrend

	@RequestMapping(value = "dashboardInterestCoverageTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardInterestCoverageTrend(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardInterestCoverageTrend start");
		logger.info("Method :dashboardInterestCoverageTrend endss");
		return restAccountDAshboardDao.dashboardInterestCoverageTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardEarningMarginTrend
	@RequestMapping(value = "dashboardEarningMarginTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardEarningMarginTrend(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardEarningMarginTrend start");
		logger.info("Method :dashboardEarningMarginTrend endss");
		return restAccountDAshboardDao.dashboardEarningMarginTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	/////////////////////////////////////////////////
	// dashboardReturnOnEquityTrend
	@RequestMapping(value = "dashboardReturnOnEquityTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardReturnOnEquityTrend(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardReturnOnEquityTrend start");
		logger.info("Method :dashboardReturnOnEquityTrend endss");
		return restAccountDAshboardDao.dashboardReturnOnEquityTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	/////////////////////////////////////////////////
	// dashboardReturnOnInvestmentTrend
	@RequestMapping(value = "dashboardReturnOnInvestmentTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardReturnOnInvestmentTrend(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardReturnOnInvestmentTrend start");
		logger.info("Method :dashboardReturnOnInvestmentTrend endss");
		return restAccountDAshboardDao.dashboardReturnOnInvestmentTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	/////////////////////////////////////////////////
	// dashboardEarnignPerShareTrend
	@RequestMapping(value = "dashboardEarnignPerShareTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardEarnignPerShareTrend(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardEarnignPerShareTrend start");
		logger.info("Method :dashboardEarnignPerShareTrend endss");
		return restAccountDAshboardDao.dashboardEarnignPerShareTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardBalanceSheetOverAllCashByYear
	@RequestMapping(value = "dashboardBalanceSheetOverAllCashByYear", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetOverAllCashByYear(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetOverAllCashByYear start");
		logger.info("Method :dashboardBalanceSheetOverAllCashByYear endss");
		return restAccountDAshboardDao.dashboardBalanceSheetOverAllCashByYear(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalanceSheetDebtRatios
	@RequestMapping(value = "dashboardBalanceSheetDebtRatios", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetDebtRatios(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetDebtRatios start");
		logger.info("Method :dashboardBalanceSheetDebtRatios endss");
		return restAccountDAshboardDao.dashboardBalanceSheetDebtRatios(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardBalanceSheetReceivablePayableTurnOver
	@RequestMapping(value = "dashboardBalanceSheetReceivablePayableTurnOver", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetReceivablePayableTurnOver(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetReceivablePayableTurnOver start");
		logger.info("Method :dashboardBalanceSheetReceivablePayableTurnOver endss");
		return restAccountDAshboardDao.dashboardBalanceSheetReceivablePayableTurnOver(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardBalanceSheetOverAllFinancialStatment
	@RequestMapping(value = "dashboardBalanceSheetOverAllFinancialStatment", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetOverAllFinancialStatment(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetOverAllFinancialStatment start");
		logger.info("Method :dashboardBalanceSheetOverAllFinancialStatment endss");
		return restAccountDAshboardDao.dashboardBalanceSheetOverAllFinancialStatment(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardBalanceSheetDataTable
	@RequestMapping(value = "dashboardBalanceSheetDataTable", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetDataTable(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetDataTable start");
		logger.info("Method :dashboardBalanceSheetDataTable endss");
		return restAccountDAshboardDao.dashboardBalanceSheetDataTable(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardBalanceSheetOverDueInvoiceDetailsTable
	@RequestMapping(value = "dashboardBalanceSheetOverDueInvoiceDetailsTable", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetOverDueInvoiceDetailsTable(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetOverDueInvoiceDetailsTable start");
		logger.info("Method :dashboardBalanceSheetOverDueInvoiceDetailsTable endss");
		return restAccountDAshboardDao.dashboardBalanceSheetOverDueInvoiceDetailsTable(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardBalanceSheetUpcomingPaymentDtlsTable
	@RequestMapping(value = "dashboardBalanceSheetUpcomingPaymentDtlsTable", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetUpcomingPaymentDtlsTable(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetUpcomingPaymentDtlsTable start");
		logger.info("Method :dashboardBalanceSheetUpcomingPaymentDtlsTable endss");
		return restAccountDAshboardDao.dashboardBalanceSheetUpcomingPaymentDtlsTable(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardBalanceSheetOverDueDtlsReceivableTable
	@RequestMapping(value = "dashboardBalanceSheetOverDueDtlsReceivableTable", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetOverDueDtlsReceivableTable(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetOverDueDtlsReceivableTable start");
		logger.info("Method :dashboardBalanceSheetOverDueDtlsReceivableTable endss");
		return restAccountDAshboardDao.dashboardBalanceSheetOverDueDtlsReceivableTable(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardBalanceSheetUpcomingPaymentDtlsReceivableTable
	@RequestMapping(value = "dashboardBalanceSheetUpcomingPaymentDtlsReceivableTable", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetUpcomingPaymentDtlsReceivableTable(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetUpcomingPaymentDtlsReceivableTable start");
		logger.info("Method :dashboardBalanceSheetUpcomingPaymentDtlsReceivableTable endss");
		return restAccountDAshboardDao.dashboardBalanceSheetUpcomingPaymentDtlsReceivableTable(orgName, orgDivision,
				fromDate, toDate, loc);
	}

	// dashboardBalanceSheetAssetsTurnOverRatioTrendTable
	@RequestMapping(value = "dashboardBalanceSheetAssetsTurnOverRatioTrendTable", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetAssetsTurnOverRatioTrendTable(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetAssetsTurnOverRatioTrendTable start");
		logger.info("Method :dashboardBalanceSheetAssetsTurnOverRatioTrendTable endss");
		return restAccountDAshboardDao.dashboardBalanceSheetAssetsTurnOverRatioTrendTable(orgName, orgDivision,
				fromDate, toDate, loc);
	}

	// dashboardBalanceSheetCountVolumeVsAge
	@RequestMapping(value = "dashboardBalanceSheetCountVolumeVsAge", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetCountVolumeVsAge(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetCountVolumeVsAge start");
		logger.info("Method :dashboardBalanceSheetCountVolumeVsAge endss");
		return restAccountDAshboardDao.dashboardBalanceSheetCountVolumeVsAge(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalanceSheetPayableParVsDiscount
	@RequestMapping(value = "dashboardBalanceSheetPayableParVsDiscount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetPayableParVsDiscount(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetPayableParVsDiscount start");
		logger.info("Method :dashboardBalanceSheetPayableParVsDiscount endss");
		return restAccountDAshboardDao.dashboardBalanceSheetPayableParVsDiscount(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalanceSheetDepartmentWiseOutstanding
	@RequestMapping(value = "dashboardBalanceSheetDepartmentWiseOutstanding", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetDepartmentWiseOutstanding(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetDepartmentWiseOutstanding start");
		logger.info("Method :dashboardBalanceSheetDepartmentWiseOutstanding endss");
		return restAccountDAshboardDao.dashboardBalanceSheetDepartmentWiseOutstanding(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardBalanceSheetTopVendorWiseDue
	@RequestMapping(value = "dashboardBalanceSheetTopVendorWiseDue", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetTopVendorWiseDue(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetTopVendorWiseDue start");
		logger.info("Method :dashboardBalanceSheetTopVendorWiseDue endss");
		return restAccountDAshboardDao.dashboardBalanceSheetTopVendorWiseDue(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalanceSheetUpcomingPayment
	@RequestMapping(value = "dashboardBalanceSheetUpcomingPayment", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetUpcomingPayment(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetUpcomingPayment start");
		logger.info("Method :dashboardBalanceSheetUpcomingPayment endss");
		return restAccountDAshboardDao.dashboardBalanceSheetUpcomingPayment(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalanceSheetPurchasePayableVsPayable
	@RequestMapping(value = "dashboardBalanceSheetPurchasePayableVsPayable", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetPurchasePayableVsPayable(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetPurchasePayableVsPayable start");
		logger.info("Method :dashboardBalanceSheetPurchasePayableVsPayable endss");
		return restAccountDAshboardDao.dashboardBalanceSheetPurchasePayableVsPayable(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardBalanceSheetExpenseTypeWiseOutstanding
	@RequestMapping(value = "dashboardBalanceSheetExpenseTypeWiseOutstanding", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetExpenseTypeWiseOutstanding(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetExpenseTypeWiseOutstanding start");
		logger.info("Method :dashboardBalanceSheetExpenseTypeWiseOutstanding endss");
		return restAccountDAshboardDao.dashboardBalanceSheetExpenseTypeWiseOutstanding(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardBalanceSheetYtdAmountPaid
	@RequestMapping(value = "dashboardBalanceSheetYtdAmountPaid", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetYtdAmountPaid(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetYtdAmountPaid start");
		logger.info("Method :dashboardBalanceSheetYtdAmountPaid endss");
		return restAccountDAshboardDao.dashboardBalanceSheetYtdAmountPaid(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardBalanceSheetAvgPaymentAge
	@RequestMapping(value = "dashboardBalanceSheetAvgPaymentAge", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetAvgPaymentAge(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetAvgPaymentAge start");
		logger.info("Method :dashboardBalanceSheetAvgPaymentAge endss");
		return restAccountDAshboardDao.dashboardBalanceSheetAvgPaymentAge(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardBalanceSheeRcvblePaymentAgeCount
	@RequestMapping(value = "dashboardBalanceSheeRcvblePaymentAgeCount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheeRcvblePaymentAgeCount(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheeRcvblePaymentAgeCount start");
		logger.info("Method :dashboardBalanceSheeRcvblePaymentAgeCount endss");
		return restAccountDAshboardDao.dashboardBalanceSheeRcvblePaymentAgeCount(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalanceSheetInvoiceCategoryBreakdown
	@RequestMapping(value = "dashboardBalanceSheetInvoiceCategoryBreakdown", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetInvoiceCategoryBreakdown(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetInvoiceCategoryBreakdown start");
		logger.info("Method :dashboardBalanceSheetInvoiceCategoryBreakdown endss");
		return restAccountDAshboardDao.dashboardBalanceSheetInvoiceCategoryBreakdown(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardBalanceSheetTopCustomerByDue
	@RequestMapping(value = "dashboardBalanceSheetTopCustomerByDue", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetTopCustomerByDue(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetTopCustomerByDue start");
		logger.info("Method :dashboardBalanceSheetTopCustomerByDue endss");
		return restAccountDAshboardDao.dashboardBalanceSheetTopCustomerByDue(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalanceSheetAvgRecvblePaymentAge
	@RequestMapping(value = "dashboardBalanceSheetAvgRecvblePaymentAge", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetAvgRecvblePaymentAge(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetAvgRecvblePaymentAge start");
		logger.info("Method :dashboardBalanceSheetAvgRecvblePaymentAge endss");
		return restAccountDAshboardDao.dashboardBalanceSheetAvgRecvblePaymentAge(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalanceSheetUpcomingReceivable
	@RequestMapping(value = "dashboardBalanceSheetUpcomingReceivable", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetUpcomingReceivable(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetUpcomingReceivable start");
		logger.info("Method :dashboardBalanceSheetUpcomingReceivable endss");
		return restAccountDAshboardDao.dashboardBalanceSheetUpcomingReceivable(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalanceSheetAccountReceivableVstime
	@RequestMapping(value = "dashboardBalanceSheetAccountReceivableVstime", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetAccountReceivableVstime(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetAccountReceivableVstime start");
		logger.info("Method :dashboardBalanceSheetAccountReceivableVstime endss");
		return restAccountDAshboardDao.dashboardBalanceSheetAccountReceivableVstime(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardBalanceSheetFixedAssetsTrend
	@RequestMapping(value = "dashboardBalanceSheetFixedAssetsTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetFixedAssetsTrend(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetFixedAssetsTrend start");
		logger.info("Method :dashboardBalanceSheetFixedAssetsTrend endss");
		return restAccountDAshboardDao.dashboardBalanceSheetFixedAssetsTrend(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalanceSheetAssetsTurnOverRatioTrend
	@RequestMapping(value = "dashboardBalanceSheetAssetsTurnOverRatioTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetAssetsTurnOverRatioTrend(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetAssetsTurnOverRatioTrend start");
		logger.info("Method :dashboardBalanceSheetAssetsTurnOverRatioTrend endss");
		return restAccountDAshboardDao.dashboardBalanceSheetAssetsTurnOverRatioTrend(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardBalanceSheetFixedAssetsMovementByMonth
	@RequestMapping(value = "dashboardBalanceSheetFixedAssetsMovementByMonth", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetFixedAssetsMovementByMonth(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetFixedAssetsMovementByMonth start");
		logger.info("Method :dashboardBalanceSheetFixedAssetsMovementByMonth endss");
		return restAccountDAshboardDao.dashboardBalanceSheetFixedAssetsMovementByMonth(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardBalanceSheetCurrRatioMomTrend
	@RequestMapping(value = "dashboardBalanceSheetCurrRatioMomTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetCurrRatioMomTrend(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetCurrRatioMomTrend start");
		logger.info("Method :dashboardBalanceSheetCurrRatioMomTrend endss");
		return restAccountDAshboardDao.dashboardBalanceSheetCurrRatioMomTrend(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalanceSheetNetWorkingCapByMonth
	@RequestMapping(value = "dashboardBalanceSheetNetWorkingCapByMonth", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetNetWorkingCapByMonth(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetNetWorkingCapByMonth start");
		logger.info("Method :dashboardBalanceSheetNetWorkingCapByMonth endss");
		return restAccountDAshboardDao.dashboardBalanceSheetNetWorkingCapByMonth(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalanceSheetQuickRatioMomTrend
	@RequestMapping(value = "dashboardBalanceSheetQuickRatioMomTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetQuickRatioMomTrend(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetQuickRatioMomTrend start");
		logger.info("Method :dashboardBalanceSheetQuickRatioMomTrend endss");
		return restAccountDAshboardDao.dashboardBalanceSheetQuickRatioMomTrend(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalanceSheetAssetsVsLiabilities
	@RequestMapping(value = "dashboardBalanceSheetAssetsVsLiabilities", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetAssetsVsLiabilities(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetAssetsVsLiabilities start");
		logger.info("Method :dashboardBalanceSheetAssetsVsLiabilities endss");
		return restAccountDAshboardDao.dashboardBalanceSheetAssetsVsLiabilities(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardBalanceSheetInvntTurnOvrRatioMomTrnd
	@RequestMapping(value = "dashboardBalanceSheetInvntTurnOvrRatioMomTrnd", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetInvntTurnOvrRatioMomTrnd(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetInvntTurnOvrRatioMomTrnd start");
		logger.info("Method :dashboardBalanceSheetInvntTurnOvrRatioMomTrnd endss");
		return restAccountDAshboardDao.dashboardBalanceSheetInvntTurnOvrRatioMomTrnd(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardBalanceSheetBaseLineVsComparisionTbl
	@RequestMapping(value = "dashboardBalanceSheetBaseLineVsComparisionTbl", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetBaseLineVsComparisionTbl(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetBaseLineVsComparisionTbl start");
		logger.info("Method :dashboardBalanceSheetBaseLineVsComparisionTbl endss");
		return restAccountDAshboardDao.dashboardBalanceSheetBaseLineVsComparisionTbl(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardBalanceSheetBaseLineVsComparisionGraph
	@RequestMapping(value = "dashboardBalanceSheetBaseLineVsComparisionGraph", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardBalanceSheetBaseLineVsComparisionGraph(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardBalanceSheetBaseLineVsComparisionGraph start");
		logger.info("Method :dashboardBalanceSheetBaseLineVsComparisionGraph endss");
		return restAccountDAshboardDao.dashboardBalanceSheetBaseLineVsComparisionGraph(orgName, orgDivision, fromDate,
				toDate, loc);
	}

	// dashboardMonthlyRecurringRevenue
	@RequestMapping(value = "dashboardMonthlyRecurringRevenue", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardMonthlyRecurringRevenue(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardMonthlyRecurringRevenue start");
		logger.info("Method :dashboardMonthlyRecurringRevenue endss");
		return restAccountDAshboardDao.dashboardMonthlyRecurringRevenue(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardTopCustByMonthlyRecurRevenue
	@RequestMapping(value = "dashboardTopCustByMonthlyRecurRevenue", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTopCustByMonthlyRecurRevenue(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardTopCustByMonthlyRecurRevenue start");
		logger.info("Method :dashboardTopCustByMonthlyRecurRevenue endss");
		return restAccountDAshboardDao.dashboardTopCustByMonthlyRecurRevenue(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardTopCustCustByRevenue
	@RequestMapping(value = "dashboardTopCustCustByRevenue", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTopCustCustByRevenue(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardTopCustCustByRevenue start");
		logger.info("Method :dashboardTopCustCustByRevenue endss");
		return restAccountDAshboardDao.dashboardTopCustCustByRevenue(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardTopCompanyMonthlyRecurRevenue
	@RequestMapping(value = "dashboardTopCompanyMonthlyRecurRevenue", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTopCompanyMonthlyRecurRevenue(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardTopCompanyMonthlyRecurRevenue start");
		logger.info("Method :dashboardTopCompanyMonthlyRecurRevenue endss");
		return restAccountDAshboardDao.dashboardTopCompanyMonthlyRecurRevenue(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardCustAccountStatusBreakdown
	@RequestMapping(value = "dashboardCustAccountStatusBreakdown", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardCustAccountStatusBreakdown(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardCustAccountStatusBreakdown start");
		logger.info("Method :dashboardCustAccountStatusBreakdown endss");
		return restAccountDAshboardDao.dashboardCustAccountStatusBreakdown(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPaymentMonthBreakdown
	@RequestMapping(value = "dashboardPaymentMonthBreakdown", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPaymentMonthBreakdown(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardPaymentMonthBreakdown start");
		logger.info("Method :dashboardPaymentMonthBreakdown endss");
		return restAccountDAshboardDao.dashboardPaymentMonthBreakdown(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardCustSubscriptionByStatus
	@RequestMapping(value = "dashboardCustSubscriptionByStatus", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardCustSubscriptionByStatus(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardCustSubscriptionByStatus start");
		logger.info("Method :dashboardCustSubscriptionByStatus endss");
		return restAccountDAshboardDao.dashboardCustSubscriptionByStatus(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardSubscriptionByPlanStatus
	@RequestMapping(value = "dashboardSubscriptionByPlanStatus", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardSubscriptionByPlanStatus(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardSubscriptionByPlanStatus start");
		logger.info("Method :dashboardSubscriptionByPlanStatus endss");
		return restAccountDAshboardDao.dashboardSubscriptionByPlanStatus(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardAccountReceivableByPayTarget
	@RequestMapping(value = "dashboardAccountReceivableByPayTarget", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardAccountReceivableByPayTarget(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardAccountReceivableByPayTarget start");
		logger.info("Method :dashboardAccountReceivableByPayTarget endss");
		return restAccountDAshboardDao.dashboardAccountReceivableByPayTarget(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardPaymentByMonth
	@RequestMapping(value = "dashboardPaymentByMonth", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPaymentByMonth(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardPaymentByMonth start");
		logger.info("Method :dashboardPaymentByMonth endss");
		return restAccountDAshboardDao.dashboardPaymentByMonth(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardTransactionCountByMonthType
	@RequestMapping(value = "dashboardTransactionCountByMonthType", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardTransactionCountByMonthType(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardTransactionCountByMonthType start");
		logger.info("Method :dashboardTransactionCountByMonthType endss");
		return restAccountDAshboardDao.dashboardTransactionCountByMonthType(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardMonthlyRevenueTrendAnalysis
	@RequestMapping(value = "dashboardMonthlyRevenueTrendAnalysis", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardMonthlyRevenueTrendAnalysis(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardMonthlyRevenueTrendAnalysis start");
		logger.info("Method :dashboardMonthlyRevenueTrendAnalysis endss");
		return restAccountDAshboardDao.dashboardMonthlyRevenueTrendAnalysis(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardAnnualRunRateTrendAnalysis
	@RequestMapping(value = "dashboardAnnualRunRateTrendAnalysis", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardAnnualRunRateTrendAnalysis(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardAnnualRunRateTrendAnalysis start");
		logger.info("Method :dashboardAnnualRunRateTrendAnalysis endss");
		return restAccountDAshboardDao.dashboardAnnualRunRateTrendAnalysis(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardMonthlyRecurringRevenueChurn
	@RequestMapping(value = "dashboardMonthlyRecurringRevenueChurn", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardMonthlyRecurringRevenueChurn(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardMonthlyRecurringRevenueChurn start");
		logger.info("Method :dashboardMonthlyRecurringRevenueChurn endss");
		return restAccountDAshboardDao.dashboardMonthlyRecurringRevenueChurn(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardCustomerChurnRateTrendAnalysis
	@RequestMapping(value = "dashboardCustomerChurnRateTrendAnalysis", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardCustomerChurnRateTrendAnalysis(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardCustomerChurnRateTrendAnalysis start");
		logger.info("Method :dashboardCustomerChurnRateTrendAnalysis endss");
		return restAccountDAshboardDao.dashboardCustomerChurnRateTrendAnalysis(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardAvgRevenuePerAccount
	@RequestMapping(value = "dashboardAvgRevenuePerAccount", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardAvgRevenuePerAccount(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardAvgRevenuePerAccount start");
		logger.info("Method :dashboardAvgRevenuePerAccount endss");
		return restAccountDAshboardDao.dashboardAvgRevenuePerAccount(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardInvoiceSummaryDetails
	@RequestMapping(value = "dashboardInvoiceSummaryDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardInvoiceSummaryDetails(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardInvoiceSummaryDetails start");
		logger.info("Method :dashboardInvoiceSummaryDetails endss");
		return restAccountDAshboardDao.dashboardInvoiceSummaryDetails(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardInvoiceSummaryDetailsTbl
	@RequestMapping(value = "dashboardInvoiceSummaryDetailsTbl", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardInvoiceSummaryDetailsTbl(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardInvoiceSummaryDetailsTbl start");
		logger.info("Method :dashboardInvoiceSummaryDetailsTbl endss");
		return restAccountDAshboardDao.dashboardInvoiceSummaryDetailsTbl(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPlOpexMomYtd
	@RequestMapping(value = "dashboardPlOpexMomYtd", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPlOpexMomYtd(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardPlOpexMomYtd start");
		logger.info("Method :dashboardPlOpexMomYtd endss");
		return restAccountDAshboardDao.dashboardPlOpexMomYtd(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPlPaymentStatus
	@RequestMapping(value = "dashboardPlPaymentStatus", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPlPaymentStatus(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardPlPaymentStatus start");
		logger.info("Method :dashboardPlPaymentStatus endss");
		return restAccountDAshboardDao.dashboardPlPaymentStatus(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPlGrossProfitMargin
	@RequestMapping(value = "dashboardPlGrossProfitMargin", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPlGrossProfitMargin(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardPlGrossProfitMargin start");
		logger.info("Method :dashboardPlGrossProfitMargin endss");
		return restAccountDAshboardDao.dashboardPlGrossProfitMargin(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPlNetProfitMargin
	@RequestMapping(value = "dashboardPlNetProfitMargin", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPlNetProfitMargin(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :dashboardPlNetProfitMargin start");
		logger.info("Method :dashboardPlNetProfitMargin endss");
		return restAccountDAshboardDao.dashboardPlNetProfitMargin(orgName, orgDivision, fromDate, toDate);
	}

	// dashboardPlTopExpbyCatPrcnt
	@RequestMapping(value = "dashboardPlTopExpbyCatPrcnt", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPlTopExpbyCatPrcnt(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardPlTopExpbyCatPrcnt start");
		logger.info("Method :dashboardPlTopExpbyCatPrcnt endss");
		return restAccountDAshboardDao.dashboardPlTopExpbyCatPrcnt(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPlRevTrend
	@RequestMapping(value = "dashboardPlRevTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPlRevTrend(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardPlRevTrend start");
		logger.info("Method :dashboardPlRevTrend endss");
		return restAccountDAshboardDao.dashboardPlRevTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPlCustGrowth
	@RequestMapping(value = "dashboardPlCustGrowth", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPlCustGrowth(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardPlCustGrowth start");
		logger.info("Method :dashboardPlCustGrowth endss");
		return restAccountDAshboardDao.dashboardPlCustGrowth(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPlToRevnGenerateCont
	@RequestMapping(value = "dashboardPlToRevnGenerateCont", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPlToRevnGenerateCont(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardPlToRevnGenerateCont start");
		logger.info("Method :dashboardPlToRevnGenerateCont endss");
		return restAccountDAshboardDao.dashboardPlToRevnGenerateCont(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPlIncmExpnByCatPrcnt
	@RequestMapping(value = "dashboardPlIncmExpnByCatPrcnt", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPlIncmExpnByCatPrcnt(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardPlIncmExpnByCatPrcnt start");
		logger.info("Method :dashboardPlIncmExpnByCatPrcnt endss");
		return restAccountDAshboardDao.dashboardPlIncmExpnByCatPrcnt(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPlProfitAndLossReport
	@RequestMapping(value = "dashboardPlProfitAndLossReport", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPlProfitAndLossReport(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardPlProfitAndLossReport start");
		logger.info("Method :dashboardPlProfitAndLossReport endss");
		return restAccountDAshboardDao.dashboardPlProfitAndLossReport(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPerReturnOnAssets
	@RequestMapping(value = "dashboardPerReturnOnAssets", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPerReturnOnAssets(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardPerReturnOnAssets start");
		logger.info("Method :dashboardPerReturnOnAssets endss");
		return restAccountDAshboardDao.dashboardPerReturnOnAssets(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPerWorkingCaptlRatio
	@RequestMapping(value = "dashboardPerWorkingCaptlRatio", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPerWorkingCaptlRatio(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardPerWorkingCaptlRatio start");
		logger.info("Method :dashboardPerWorkingCaptlRatio endss");
		return restAccountDAshboardDao.dashboardPerWorkingCaptlRatio(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPerReturnOnEquity
	@RequestMapping(value = "dashboardPerReturnOnEquity", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPerReturnOnEquity(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardPerReturnOnEquity start");
		logger.info("Method :dashboardPerReturnOnEquity endss");
		return restAccountDAshboardDao.dashboardPerReturnOnEquity(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPerDebtEquityRatio
	@RequestMapping(value = "dashboardPerDebtEquityRatio", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPerDebtEquityRatio(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardPerDebtEquityRatio start");
		logger.info("Method :dashboardPerDebtEquityRatio endss");
		return restAccountDAshboardDao.dashboardPerDebtEquityRatio(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPerBalanceSheetCountList
	@RequestMapping(value = "dashboardPerBalanceSheetCountList", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPerBalanceSheetCountList(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardPerBalanceSheetCountList start");
		logger.info("Method :dashboardPerBalanceSheetCountList endss");
		return restAccountDAshboardDao.dashboardPerBalanceSheetCountList(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPerProfitLossSmry
	@RequestMapping(value = "dashboardPerProfitLossSmry", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPerProfitLossSmry(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardPerProfitLossSmry start");
		logger.info("Method :dashboardPerProfitLossSmry endss");
		return restAccountDAshboardDao.dashboardPerProfitLossSmry(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPerNetGrossWorkingCapital
	@RequestMapping(value = "dashboardPerNetGrossWorkingCapital", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPerNetGrossWorkingCapital(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardPerNetGrossWorkingCapital start");
		logger.info("Method :dashboardPerNetGrossWorkingCapital endss");
		return restAccountDAshboardDao.dashboardPerNetGrossWorkingCapital(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPerAccReceivablePayableTurnOver
	@RequestMapping(value = "dashboardPerAccReceivablePayableTurnOver", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPerAccReceivablePayableTurnOver(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardPerAccReceivablePayableTurnOver start");
		logger.info("Method :dashboardPerAccReceivablePayableTurnOver endss");
		return restAccountDAshboardDao.dashboardPerAccReceivablePayableTurnOver(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardPerInvoiceDetails
	@RequestMapping(value = "dashboardPerInvoiceDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPerInvoiceDetails(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :dashboardPerInvoiceDetails start");
		logger.info("Method :dashboardPerInvoiceDetails endss");
		return restAccountDAshboardDao.dashboardPerInvoiceDetails(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPerAccPayableByPayTarget
	@RequestMapping(value = "dashboardPerAccPayableByPayTarget", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPerAccPayableByPayTarget(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardPerAccPayableByPayTarget start");
		logger.info("Method :dashboardPerAccPayableByPayTarget endss");
		return restAccountDAshboardDao.dashboardPerAccPayableByPayTarget(orgName, orgDivision, fromDate, toDate, loc);
	}

	// dashboardPerExpensesListCountList
	@RequestMapping(value = "dashboardPerExpensesListCountList", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPerExpensesListCountList(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :dashboardPerExpensesListCountList start");
		logger.info("Method :dashboardPerExpensesListCountList endss");
		return restAccountDAshboardDao.dashboardPerExpensesListCountList(orgName, orgDivision, fromDate, toDate);
	}

	// dashboardPerInvoiceDueDtlsByCusTable
	@RequestMapping(value = "dashboardPerInvoiceDueDtlsByCusTable", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPerInvoiceDueDtlsByCusTable(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardPerInvoiceDueDtlsByCusTable start");
		logger.info("Method :dashboardPerInvoiceDueDtlsByCusTable endss");
		return restAccountDAshboardDao.dashboardPerInvoiceDueDtlsByCusTable(orgName, orgDivision, fromDate, toDate,
				loc);
	}

	// dashboardPerProfitLossSummryTable
	@RequestMapping(value = "dashboardPerProfitLossSummryTable", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPerProfitLossSummryTable(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardPerProfitLossSummryTable start");
		logger.info("Method :dashboardPerProfitLossSummryTable endss");
		return restAccountDAshboardDao.dashboardPerProfitLossSummryTable(orgName, orgDivision, fromDate, toDate, loc);
	}
	// dashboardPerExecutiveSummryTbl

	@RequestMapping(value = "dashboardPerExecutiveSummryTbl", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardPerExecutiveSummryTbl(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardPerExecutiveSummryTbl start");
		logger.info("Method :dashboardPerExecutiveSummryTbl endss");
		return restAccountDAshboardDao.dashboardPerExecutiveSummryTbl(orgName, orgDivision, fromDate, toDate, loc);
	}

	/////////////////////////////////////////////////
	// dashboardRatioRetunOnEquityTrend
	@RequestMapping(value = "dashboardRatioRetunOnEquityTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardRatioRetunOnEquityTrend(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardRatioRetunOnEquityTrend start");
		logger.info("Method :dashboardRatioRetunOnEquityTrend endss");
		return restAccountDAshboardDao.dashboardRatioRetunOnEquityTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	/////////////////////////////////////////////////
	// dashboardRatioEarnignMarginTrend
	@RequestMapping(value = "dashboardRatioEarnignMarginTrend", method = { RequestMethod.GET })
	public JsonResponse<Object> dashboardRatioEarnignMarginTrend(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :dashboardRatioEarnignMarginTrend start");
		logger.info("Method :dashboardRatioEarnignMarginTrend endss");
		return restAccountDAshboardDao.dashboardRatioEarnignMarginTrend(orgName, orgDivision, fromDate, toDate, loc);
	}

	//////////////////////////////////////////////////

	@RequestMapping(value = "dashboard-cminventory", method = { RequestMethod.GET })
	public JsonResponse<Object> cminventory(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :cminventory start");
		logger.info("Method :cminventory endss");
		return restAccountDAshboardDao.cminventory(orgName, orgDivision, fromDate, toDate, loc);
	}

	@RequestMapping(value = "dashboard-cm-payable-vs-receivable", method = { RequestMethod.GET })
	public JsonResponse<Object> cmPayableVsReceivable(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :cmPayableVsReceivable start");
		logger.info("Method :cmPayableVsReceivable endss");
		return restAccountDAshboardDao.cmPayableVsReceivable(orgName, orgDivision, fromDate, toDate, loc);
	}

	@RequestMapping(value = "dashboard-cm-payable-count", method = { RequestMethod.GET })
	public JsonResponse<Object> cmPayableCount(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :cmPayableCount start");
		logger.info("Method :cmPayableCount endss");
		return restAccountDAshboardDao.cmPayableCount(orgName, orgDivision, fromDate, toDate, loc);
	}

	@RequestMapping(value = "dashboard-actualForcastIndicators", method = { RequestMethod.GET })
	public JsonResponse<Object> actualForcastIndicators(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :actualForcastIndicators start");
		logger.info("Method :actualForcastIndicators endss");
		return restAccountDAshboardDao.actualForcastIndicators(orgName, orgDivision);
	}

	@RequestMapping(value = "dashboard-actualForcastHighCharts", method = { RequestMethod.GET })
	public JsonResponse<Object> actualForcastHighCharts(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :actualForcastHighCharts start");
		logger.info("Method :actualForcastHighCharts endss");
		return restAccountDAshboardDao.actualForcastHighCharts(orgName, orgDivision);
	}

	@RequestMapping(value = "profitLossCostStatement", method = { RequestMethod.GET })
	public JsonResponse<Object> profitLossCostStatement(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :profitLossCostStatement start");
		logger.info("Method :profitLossCostStatement endss");
		return restAccountDAshboardDao.profitLossCostStatement(orgName, orgDivision, fromDate, toDate, loc);
	}

	@RequestMapping(value = "revenuecogslist", method = { RequestMethod.GET })
	public JsonResponse<Object> revenuecogslist(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :revenuecogslist start");
		logger.info("Method :revenuecogslist endss");
		return restAccountDAshboardDao.revenuecogslist(orgName, orgDivision, fromDate, toDate, loc);
	}

	@RequestMapping(value = "opexYearToDate", method = { RequestMethod.GET })
	public JsonResponse<Object> opexYearToDate(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :opexYearToDate start");
		logger.info("Method :opexYearToDate endss");
		return restAccountDAshboardDao.opexYearToDate(orgName, orgDivision, fromDate, toDate, loc);
	}

	// earningBeforeTaxes

	@RequestMapping(value = "earningBeforeInterestTaxes", method = { RequestMethod.GET })
	public JsonResponse<Object> earningBeforeInterestTaxes(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :earningBeforeInterestTaxes start");
		logger.info("Method :earningBeforeInterestTaxes endss");
		return restAccountDAshboardDao.earningBeforeInterestTaxes(orgName, orgDivision, fromDate, toDate, loc);
	}

	@RequestMapping(value = "opexYearWise", method = { RequestMethod.GET })
	public JsonResponse<Object> opexYearWise(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :opexYearWise start");
		logger.info("Method :opexYearWise endss");
		return restAccountDAshboardDao.opexYearWise(orgName, orgDivision);
	}

	@RequestMapping(value = "grossProfitLossMarginPrcnt", method = { RequestMethod.GET })
	public JsonResponse<Object> grossProfitLossMarginPrcnt(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :grossProfitLossMarginPrcnt start");
		logger.info("Method :grossProfitLossMarginPrcnt endss");
		return restAccountDAshboardDao.grossProfitLossMarginPrcnt(orgName, orgDivision, fromDate, toDate, loc);
	}

	@RequestMapping(value = "grossOpexRatioPrcnt", method = { RequestMethod.GET })
	public JsonResponse<Object> grossOpexRatioPrcnt(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :grossOpexRatioPrcnt start");
		logger.info("Method :grossOpexRatioPrcnt endss");
		return restAccountDAshboardDao.grossOpexRatioPrcnt(orgName, orgDivision, fromDate, toDate, loc);
	}

	@RequestMapping(value = "operatingProfitPrcnt", method = { RequestMethod.GET })
	public JsonResponse<Object> operatingProfitPrcnt(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :operatingProfitPrcnt start");
		logger.info("Method :operatingProfitPrcnt endss");
		return restAccountDAshboardDao.operatingProfitPrcnt(orgName, orgDivision, fromDate, toDate, loc);
	}

	@RequestMapping(value = "netProfitMarginPrcnt", method = { RequestMethod.GET })
	public JsonResponse<Object> netProfitMarginPrcnt(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :netProfitMarginPrcnt start");
		logger.info("Method :netProfitMarginPrcnt endss");
		return restAccountDAshboardDao.netProfitMarginPrcnt(orgName, orgDivision, fromDate, toDate, loc);
	}

///////////////////////////////////////////Start
// actualforecastrevenue
	@RequestMapping(value = "actualforecastrevenue", method = { RequestMethod.GET })
	public JsonResponse<Object> actualforecastrevenue(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :actualforecastrevenue start");
		logger.info("Method :actualforecastrevenue endss");
		return restAccountDAshboardDao.actualforecastrevenue(orgName, orgDivision, fromDate, toDate, loc);
	}

// actualforecastcogs
	@RequestMapping(value = "actualforecastcogs", method = { RequestMethod.GET })
	public JsonResponse<Object> actualforecastcogs(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :actualforecastcogs start");
		logger.info("Method :actualforecastcogs endss");
		return restAccountDAshboardDao.actualforecastcogs(orgName, orgDivision, fromDate, toDate, loc);
	}

// actualforecastcosts
	@RequestMapping(value = "actualforecastcosts", method = { RequestMethod.GET })
	public JsonResponse<Object> actualforecastcosts(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :actualforecastcosts start");
		logger.info("Method :actualforecastcosts endss");
		return restAccountDAshboardDao.actualforecastcosts(orgName, orgDivision, fromDate, toDate, loc);
	}

// actualforecasttaxes
	@RequestMapping(value = "actualforecasttaxes", method = { RequestMethod.GET })
	public JsonResponse<Object> actualforecasttaxes(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :actualforecasttaxes start");
		logger.info("Method :actualforecasttaxes endss");
		return restAccountDAshboardDao.actualforecasttaxes(orgName, orgDivision, fromDate, toDate, loc);
	}

// actualforecastrevenues
	@RequestMapping(value = "actualforecastrevenues", method = { RequestMethod.GET })
	public JsonResponse<Object> actualforecastrevenues(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :actualforecastrevenues start");
		logger.info("Method :actualforecastrevenues endss");
		return restAccountDAshboardDao.actualforecastrevenues(orgName, orgDivision, fromDate, toDate, loc);
	}

// actualforecastbreakdownOfcosts
	@RequestMapping(value = "actualforecastbreakdownOfcosts", method = { RequestMethod.GET })
	public JsonResponse<Object> actualforecastbreakdownOfcosts(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :actualforecastbreakdownOfcosts start");
		logger.info("Method :actualforecastbreakdownOfcosts endss");
		return restAccountDAshboardDao.actualforecastbreakdownOfcosts(orgName, orgDivision, fromDate, toDate, loc);
	}

// actualforecastincomebudget
	@RequestMapping(value = "actualforecastincomebudget", method = { RequestMethod.GET })
	public JsonResponse<Object> actualforecastincomebudget(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :actualforecastincomebudget start");
		logger.info("Method :actualforecastincomebudget endss");
		return restAccountDAshboardDao.actualforecastincomebudget(orgName, orgDivision, fromDate, toDate, loc);
	}

// actualforecastexpensesbudget
	@RequestMapping(value = "actualforecastexpensesbudget", method = { RequestMethod.GET })
	public JsonResponse<Object> actualforecastexpensesbudget(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :actualforecastexpensesbudget start");
		logger.info("Method :actualforecastexpensesbudget endss");
		return restAccountDAshboardDao.actualforecastexpensesbudget(orgName, orgDivision, fromDate, toDate, loc);
	}

// actualforecastactualincome
	@RequestMapping(value = "actualforecastactualincome", method = { RequestMethod.GET })
	public JsonResponse<Object> actualforecastactualincome(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :actualforecastactualincome start");
		logger.info("Method :actualforecastactualincome endss");
		return restAccountDAshboardDao.actualforecastactualincome(orgName, orgDivision, fromDate, toDate, loc);
	}

// actualforecastactualexpenses
	@RequestMapping(value = "actualforecastactualexpenses", method = { RequestMethod.GET })
	public JsonResponse<Object> actualforecastactualexpenses(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :actualforecastactualexpenses start");
		logger.info("Method :actualforecastactualexpenses endss");
		return restAccountDAshboardDao.actualforecastactualexpenses(orgName, orgDivision, fromDate, toDate, loc);
	}

// actualforecastbudgetactualincome
	@RequestMapping(value = "actualforecastbudgetactualincome", method = { RequestMethod.GET })
	public JsonResponse<Object> actualforecastbudgetactualincome(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :actualforecastbudgetactualincome start");
		logger.info("Method :actualforecastbudgetactualincome endss");
		return restAccountDAshboardDao.actualforecastbudgetactualincome(orgName, orgDivision, fromDate, toDate, loc);
	}

// actualforecastbudgetactualexpense
	@RequestMapping(value = "actualforecastbudgetactualexpense", method = { RequestMethod.GET })
	public JsonResponse<Object> actualforecastbudgetactualexpense(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String loc) {
		logger.info("Method :actualforecastbudgetactualexpense start");
		logger.info("Method :actualforecastbudgetactualexpense endss");
		return restAccountDAshboardDao.actualforecastbudgetactualexpense(orgName, orgDivision, fromDate, toDate, loc);
	}

// actualforecastfinancecosts
	@RequestMapping(value = "actualforecastfinancecosts", method = { RequestMethod.GET })
	public JsonResponse<Object> actualforecastfinancecosts(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :actualforecastfinancecosts start");
		logger.info("Method :actualforecastfinancecosts endss");
		return restAccountDAshboardDao.actualforecastfinancecosts(orgName, orgDivision, fromDate, toDate, loc);
	}

// actualforecastnetprofit
	@RequestMapping(value = "actualforecastnetprofit", method = { RequestMethod.GET })
	public JsonResponse<Object> actualforecastnetprofit(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :actualforecastnetprofit start");
		logger.info("Method :actualforecastnetprofit endss");
		return restAccountDAshboardDao.actualforecastnetprofit(orgName, orgDivision, fromDate, toDate, loc);
	}

	// organisation
	@RequestMapping(value = "getOrganization", method = { RequestMethod.GET })
	public List<DropDownModel> getOrganizationDivision(@RequestParam String orgName) {
		logger.info("Method : getOrganizationDivision starts");

		logger.info("Method : getOrganizationDivision ends");
		return restAccountDAshboardDao.getOrganization(orgName);
	}

	// organisationDivision
	@RequestMapping(value = "getDivision", method = { RequestMethod.GET })
	public List<DropDownModel> getDivision(@RequestParam String orgName) {
		logger.info("Method : getDivision starts");

		logger.info("Method : getDivision ends");
		return restAccountDAshboardDao.getDivision(orgName);
	}

	/*
	@RequestMapping(value = "getAllCounts", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllCounts(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :getAllCounts start");

		logger.info("Method :getAllCounts endss");
		return restAccountDAshboardDao.getAllCounts(orgName, orgDivision);

	}

	@RequestMapping(value = "dashboard-account-getAllReport", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllReport(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id) {
		logger.info("Method :getAllReport start");

		logger.info("Method :getAllReport endss");
		return restAccountDAshboardDao.getAllReport(orgName, orgDivision, id);

	}

	@RequestMapping(value = "dashboard-currentWorkingCapital", method = { RequestMethod.GET })
	public JsonResponse<Object> currentWorkingCapital(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :currentWorkingCapital start");

		logger.info("Method :currentWorkingCapital endss");
		return restAccountDAshboardDao.currentWorkingCapital(orgName, orgDivision);
	}

	@RequestMapping(value = "dashboard-currentBudgetVarience", method = { RequestMethod.GET })
	public JsonResponse<Object> currentBudgetVarience(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :currentBudgetVarience start");

		logger.info("Method :currentBudgetVarience endss");
		return restAccountDAshboardDao.currentBudgetVarience(orgName, orgDivision);
	}

	@RequestMapping(value = "dashboard-vendorpaymenterrorrate", method = { RequestMethod.GET })
	public JsonResponse<Object> vendorpaymenterrorrate(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :vendorpaymenterrorrate start");
		logger.info("Method :vendorpaymenterrorrate endss");
		return restAccountDAshboardDao.vendorpaymenterrorrate(orgName, orgDivision);
	}

	@RequestMapping(value = "dashboard-cashmanagementWorkingCap", method = { RequestMethod.GET })
	public JsonResponse<Object> cashmanagementWorkingCap(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :cashmanagementWorkingCap start");

		logger.info("Method :cashmanagementWorkingCap endss");
		return restAccountDAshboardDao.cashmanagementWorkingCap(orgName, orgDivision);
	}

	@RequestMapping(value = "dashboard-cashbalance", method = { RequestMethod.GET })
	public JsonResponse<Object> cashbalance(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :cashbalance start");
		logger.info("Method :cashbalance endss");
		return restAccountDAshboardDao.cashbalance(orgName, orgDivision);
	}

	@RequestMapping(value = "dashboard-cminventory", method = { RequestMethod.GET })
	public JsonResponse<Object> cminventory(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :cminventory start");
		logger.info("Method :cminventory endss");
		return restAccountDAshboardDao.cminventory(orgName, orgDivision);
	}

	@RequestMapping(value = "dashboard-performanceBalanceSheet", method = { RequestMethod.GET })
	public JsonResponse<Object> performanceBalanceSheet(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :performanceBalanceSheet start");
		logger.info("Method :performanceBalanceSheet endss");
		return restAccountDAshboardDao.performanceBalanceSheet(orgName, orgDivision);
	}

	@RequestMapping(value = "dashboard-returnonequity", method = { RequestMethod.GET })
	public JsonResponse<Object> returnonequity(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :returnonequity start");
		logger.info("Method :returnonequity endss");
		return restAccountDAshboardDao.returnonequity(orgName, orgDivision);
	}

	@RequestMapping(value = "dashboard-actualForcastIndicators", method = { RequestMethod.GET })
	public JsonResponse<Object> actualForcastIndicators(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :actualForcastIndicators start");
		logger.info("Method :actualForcastIndicators endss");
		return restAccountDAshboardDao.actualForcastIndicators(orgName, orgDivision);
	}

	@RequestMapping(value = "dashboard-actualForcastHighCharts", method = { RequestMethod.GET })
	public JsonResponse<Object> actualForcastHighCharts(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :actualForcastHighCharts start");
		logger.info("Method :actualForcastHighCharts endss");
		return restAccountDAshboardDao.actualForcastHighCharts(orgName, orgDivision);
	}

	@RequestMapping(value = "dashboard-profitLossSheet", method = { RequestMethod.GET })
	public JsonResponse<Object> profitLossSheet(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :profitLossSheet start");
		logger.info("Method :profitLossSheet endss");
		return restAccountDAshboardDao.profitLossSheet(orgName, orgDivision);
	}

	@RequestMapping(value = "dashboard-revenuecogsRate", method = { RequestMethod.GET })
	public JsonResponse<Object> revenuecogsRate(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :revenuecogsRate start");
		logger.info("Method :revenuecogsRate endss");
		return restAccountDAshboardDao.revenuecogsRate(orgName, orgDivision);
	}

	@RequestMapping(value = "dashboard-opexSheetSheet", method = { RequestMethod.GET })
	public JsonResponse<Object> opexSheet(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :opexSheet start");
		logger.info("Method :opexSheet endss");
		return restAccountDAshboardDao.opexSheet(orgName, orgDivision);
	}

	// earningBeforeTaxes

	@RequestMapping(value = "earningBeforeTaxes", method = { RequestMethod.GET })
	public JsonResponse<Object> earningBeforeTaxes(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :earningBeforeTaxes start");
		logger.info("Method :earningBeforeTaxes endss");
		return restAccountDAshboardDao.earningBeforeTaxes(orgName, orgDivision);
	}

	@RequestMapping(value = "opexYearWise", method = { RequestMethod.GET })
	public JsonResponse<Object> opexYearWise(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :opexYearWise start");
		logger.info("Method :opexYearWise endss");
		return restAccountDAshboardDao.opexYearWise(orgName, orgDivision);
	}
	
	@RequestMapping(value = "grossProfitLoss", method = { RequestMethod.GET })
	public JsonResponse<Object> grossProfitLoss(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :grossProfitLoss start");
		logger.info("Method :grossProfitLoss endss");
		return restAccountDAshboardDao.grossProfitLoss(orgName, orgDivision);
	}
	
	@RequestMapping(value = "grossOpexRatio", method = { RequestMethod.GET })
	public JsonResponse<Object> grossOpexRatio(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :grossOpexRatio start");
		logger.info("Method :grossOpexRatio endss");
		return restAccountDAshboardDao.grossOpexRatio(orgName, orgDivision);
	}
	
	@RequestMapping(value = "operatingProfit", method = { RequestMethod.GET })
	public JsonResponse<Object> operatingProfit(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :operatingProfit start");
		logger.info("Method :operatingProfit endss");
		return restAccountDAshboardDao.operatingProfit(orgName, orgDivision);
	}
	
	@RequestMapping(value = "netProfit", method = { RequestMethod.GET })
	public JsonResponse<Object> netProfit(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :netProfit start");
		logger.info("Method :netProfit endss");
		return restAccountDAshboardDao.netProfit(orgName, orgDivision);
	}*/
	
	

}