package nirmalya.aatithya.restmodule.purchase.cotroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.dao.RestPurchaseDashboardKpiDao;

@RestController
@RequestMapping(value = { "purchase" })
public class RestPurchaseDashboardKpiController {

	Logger logger = LoggerFactory.getLogger(RestPurchaseDashboardKpiController.class);

	@Autowired
	RestPurchaseDashboardKpiDao restPurchaseDashboardKpiDao;

	// kpi-cost-saving
	@RequestMapping(value = "kpi-cost-saving", method = { RequestMethod.GET })
	public JsonResponse<Object> kpiCostSaving1(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String loc) {
		logger.info("Method :kpiCostSaving1 start");

		logger.info("Method :kpiCostSaving1 endss");
		return restPurchaseDashboardKpiDao.kpiCostSaving1(orgName,orgDivision,fromDate,toDate,loc);
	}

	// department-kpis
	@RequestMapping(value = "department-kpis", method = { RequestMethod.GET })
	public JsonResponse<Object> departmentKpis(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :departmentKpis start");

		logger.info("Method :departmentKpis endss");
		return restPurchaseDashboardKpiDao.departmentKpis(orgName, orgDivision, fromDate, toDate, loc);
	}

	// supplier-performance
	@RequestMapping(value = "supplier-performance", method = { RequestMethod.GET })
	public JsonResponse<Object> supplierPerformance(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :supplierPerformance start");

		logger.info("Method :supplierPerformance endss");
		return restPurchaseDashboardKpiDao.supplierPerformance(orgName, orgDivision, fromDate, toDate, loc);
	}

	// kpi-operational
	@RequestMapping(value = "kpi-operational", method = { RequestMethod.GET })
	public JsonResponse<Object> operationalKPIs(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :operationalKPIs start");

		logger.info("Method :operationalKPIs endss");
		return restPurchaseDashboardKpiDao.operationalKPIs(orgName, orgDivision, fromDate, toDate, loc);
	}

	// kpi-spend-under-management
	@RequestMapping(value = "kpi-spend-under-management", method = { RequestMethod.GET })
	public JsonResponse<Object> spendUnderManagement(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :spendUnderManagement start");

		logger.info("Method :spendUnderManagement endss");
		return restPurchaseDashboardKpiDao.spendUnderManagement(orgName, orgDivision, fromDate, toDate, loc);
	}

	// kpi-maverick
	@RequestMapping(value = "kpi-maverick", method = { RequestMethod.GET })
	public JsonResponse<Object> kpiMaverick(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String orgName, @RequestParam String orgDivision, @RequestParam String loc) {
		logger.info("Method :kpiMaverick start");

		logger.info("Method :kpiMaverick endss");
		return restPurchaseDashboardKpiDao.kpiMaverick(orgName, orgDivision, fromDate, toDate, loc);
	}
}
