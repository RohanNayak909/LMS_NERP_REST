package nirmalya.aatithya.restmodule.asset.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetDashboardDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "asset/")
public class AssetDashboardRestController1 {

	Logger logger = LoggerFactory.getLogger(AssetDashboardRestController1.class);

	/*
	 * @Autowired AssetPolicyDao assetPolicyDao;
	 */

	@Autowired
	AssetDashboardDao assetDashboardDao;

	// getEmployeeListforAsset

	/*
	 * @RequestMapping(value = "getCategoryListforAsset", method = {
	 * RequestMethod.GET }) public List<DropDownModel>
	 * getCategoryListforAsset(@RequestParam String org, String orgDiv, String
	 * userId) { logger.info("Method : getCategoryListforAsset starts");
	 * 
	 * logger.info("Method : getCategoryListforAsset ends"); return
	 * assetDashboardDaoHelper.getCategoryListforAsset(org, orgDiv, userId); }
	 */

	///////////////////////////////////////////////// Start maintainance

	// maintainancemonthlybackloganalysis
	@RequestMapping(value = "monthlybackloganalysis", method = { RequestMethod.GET })
	public JsonResponse<Object> maintainancemonthlybackloganalysis(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :maintainancemonthlybackloganalysis start");
		logger.info("Method :maintainancemonthlybackloganalysis endss");
		return assetDashboardDao.monthlybackloganalysis(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "maintainancescheduledassigned", method = { RequestMethod.GET })
	public JsonResponse<Object> maintainancescheduledassigned(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :maintainancescheduledassigned start");
		logger.info("Method :maintainancescheduledassigned endss");
		return assetDashboardDao.maintainancescheduledassigned(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "maintainancepreventivemaintainance", method = { RequestMethod.GET })
	public JsonResponse<Object> maintainancepreventivemaintainance(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :maintainancepreventivemaintainance start");
		logger.info("Method :maintainancepreventivemaintainance endss");
		return assetDashboardDao.maintainancepreventivemaintainance(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "maintainanceplannedmaintainancepercentage", method = { RequestMethod.GET })
	public JsonResponse<Object> maintainanceplannedmaintainancepercentage(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :maintainanceplannedmaintainancepercentage start");
		logger.info("Method :maintainanceplannedmaintainancepercentage endss");
		return assetDashboardDao.maintainanceplannedmaintainancepercentage(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "maintainanceassetgroupassets", method = { RequestMethod.GET })
	public JsonResponse<Object> maintainanceassetgroupassets(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :maintainanceassetgroupassets start");
		logger.info("Method :maintainanceassetgroupassets endss");
		return assetDashboardDao.maintainanceassetgroupassets(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "departmentsassetscriticality", method = { RequestMethod.GET })
	public JsonResponse<Object> departmentsassetscriticality(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :departmentsassetscriticality start");
		logger.info("Method :departmentsassetscriticality endss");
		return assetDashboardDao.departmentsassetscriticality(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "workorderoverview", method = { RequestMethod.GET })
	public JsonResponse<Object> workorderoverview(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :workorderoverview start");
		logger.info("Method :workorderoverview endss");
		return assetDashboardDao.workorderoverview(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "workorderstype", method = { RequestMethod.GET })
	public JsonResponse<Object> workorderstype(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :workorderstype start");
		logger.info("Method :workorderstype endss");
		return assetDashboardDao.workorderstype(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "unplannedlaborhours", method = { RequestMethod.GET })
	public JsonResponse<Object> unplannedlaborhours(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :unplannedlaborhours start");
		logger.info("Method :unplannedlaborhours endss");
		return assetDashboardDao.unplannedlaborhours(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "workordersstatus", method = { RequestMethod.GET })
	public JsonResponse<Object> workordersstatus(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :workordersstatus start");
		logger.info("Method :workordersstatus endss");
		return assetDashboardDao.workordersstatus(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "workOrderactualestimatedcosts", method = { RequestMethod.GET })
	public JsonResponse<Object> workOrderactualestimatedcosts(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :workOrderactualestimatedcosts start");
		logger.info("Method :workOrderactualestimatedcosts endss");
		return assetDashboardDao.workOrderactualestimatedcosts(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "countpercentageunsolvedtickets", method = { RequestMethod.GET })
	public JsonResponse<Object> countpercentageunsolvedtickets(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :countpercentageunsolvedtickets start");
		logger.info("Method :countpercentageunsolvedtickets endss");
		return assetDashboardDao.countpercentageunsolvedtickets(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "meantimerepair", method = { RequestMethod.GET })
	public JsonResponse<Object> meantimerepair(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :meantimerepair start");
		logger.info("Method :meantimerepair endss");
		return assetDashboardDao.meantimerepair(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "meantimedetect", method = { RequestMethod.GET })
	public JsonResponse<Object> meantimedetect(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :meantimedetect start");
		logger.info("Method :meantimedetect endss");
		return assetDashboardDao.meantimedetect(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "reopenedtickets", method = { RequestMethod.GET })
	public JsonResponse<Object> reopenedtickets(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :reopenedtickets start");
		logger.info("Method :reopenedtickets endss");
		return assetDashboardDao.reopenedtickets(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "totalratiopercentage", method = { RequestMethod.GET })
	public JsonResponse<Object> totalratiopercentage(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :totalratiopercentage start");
		logger.info("Method :totalratiopercentage endss");
		return assetDashboardDao.totalratiopercentage(orgName, orgDivision, fromDate, toDate);
	}

	@RequestMapping(value = "totatratioperyear", method = { RequestMethod.GET })
	public JsonResponse<Object> totatratioperyear(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String userid, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :totatratioperyear start");
		logger.info("Method :totatratioperyear endss");
		return assetDashboardDao.totatratioperyear(orgName, orgDivision, userid, fromDate, toDate);
	}

	///////////////////////////////////////// End maintainance

///////////////////////////////////////////////// Start Asset

//assetcountbycategory  
	@RequestMapping(value = "assetcountbycategory", method = { RequestMethod.GET })
	public JsonResponse<Object> assetcountbycategory(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :assetcountbycategory start");
		logger.info("Method :assetcountbycategory endss");
		return assetDashboardDao.assetcountbycategory(orgName, orgDivision, fromDate, toDate);
	}

// countbyLifestate  
	@RequestMapping(value = "countbyLifestate", method = { RequestMethod.GET })
	public JsonResponse<Object> countbyLifestate(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :countbyLifestate start");
		logger.info("Method :countbyLifestate endss");
		return assetDashboardDao.countbyLifestate(orgName, orgDivision, fromDate, toDate);
	}

// valuebycategory  
	@RequestMapping(value = "valuebycategory", method = { RequestMethod.GET })
	public JsonResponse<Object> valuebycategory(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :valuebycategory start");
		logger.info("Method :valuebycategory endss");
		return assetDashboardDao.valuebycategory(orgName, orgDivision, fromDate, toDate);
	}

// countbylocation  
	@RequestMapping(value = "countbylocation", method = { RequestMethod.GET })
	public JsonResponse<Object> countbylocation(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :countbylocation start");
		logger.info("Method :countbylocation endss");
		return assetDashboardDao.countbylocation(orgName, orgDivision, fromDate, toDate);
	}

// assetfulfillmenttime  
	@RequestMapping(value = "assetfulfillmenttime", method = { RequestMethod.GET })
	public JsonResponse<Object> assetfulfillmenttime(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :assetfulfillmenttime start");
		logger.info("Method :assetfulfillmenttime endss");
		return assetDashboardDao.assetfulfillmenttime(orgName, orgDivision, fromDate, toDate);
	}

// totalspend  
	@RequestMapping(value = "totalspend", method = { RequestMethod.GET })
	public JsonResponse<Object> totalspend(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :totalspend start");
		logger.info("Method :totalspend endss");
		return assetDashboardDao.totalspend(orgName, orgDivision, fromDate, toDate);
	}

// assetstatus  
	@RequestMapping(value = "assetstatus", method = { RequestMethod.GET })
	public JsonResponse<Object> assetstatus(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :assetstatus start");
		logger.info("Method :assetstatus endss");
		return assetDashboardDao.assetstatus(orgName, orgDivision, fromDate, toDate);
	}

// endlifenextdays  
	@RequestMapping(value = "endlifenextdays", method = { RequestMethod.GET })
	public JsonResponse<Object> endlifenextdays(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :endlifenextdays start");
		logger.info("Method :endlifenextdays endss");
		return assetDashboardDao.endlifenextdays(orgName, orgDivision, fromDate, toDate);
	}

// assetspulledfrompoolnetnewpurchase  
	@RequestMapping(value = "assetspulledfrompoolnetnewpurchase", method = { RequestMethod.GET })
	public JsonResponse<Object> assetspulledfrompoolnetnewpurchase(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :assetspulledfrompoolnetnewpurchase start");
		logger.info("Method :assetspulledfrompoolnetnewpurchase endss");
		return assetDashboardDao.assetspulledfrompoolnetnewpurchase(orgName, orgDivision, fromDate, toDate);
	}

// verificationstatus  
	@RequestMapping(value = "verificationstatus", method = { RequestMethod.GET })
	public JsonResponse<Object> verificationstatus(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :verificationstatus start");
		logger.info("Method :verificationstatus endss");
		return assetDashboardDao.verificationstatus(orgName, orgDivision, fromDate, toDate);
	}

///////////////////////////////////////////////// End Asset

////////////////////////////////////////////////////////Start Performance

// topmeantimerepairapril  
	@RequestMapping(value = "topmeantimerepairapril", method = { RequestMethod.GET })
	public JsonResponse<Object> topmeantimerepairapril(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :topmeantimerepairapril start");
		logger.info("Method :topmeantimerepairapril endss");
		return assetDashboardDao.topmeantimerepairapril(orgName, orgDivision, fromDate, toDate);
	}

// maintexpensessinceapril  
	@RequestMapping(value = "maintexpensessinceapril", method = { RequestMethod.GET })
	public JsonResponse<Object> maintexpensessinceapril(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :maintexpensessinceapril start");
		logger.info("Method :maintexpensessinceapril endss");
		return assetDashboardDao.maintexpensessinceapril(orgName, orgDivision, fromDate, toDate);
	}

// incidentresolutionresponsetime  
	@RequestMapping(value = "incidentresolutionresponsetime", method = { RequestMethod.GET })
	public JsonResponse<Object> incidentresolutionresponsetime(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :incidentresolutionresponsetime start");
		logger.info("Method :incidentresolutionresponsetime endss");
		return assetDashboardDao.incidentresolutionresponsetime(orgName, orgDivision, fromDate, toDate);
	}

// assetutilizationsinceapril  
	@RequestMapping(value = "assetutilizationsinceapril", method = { RequestMethod.GET })
	public JsonResponse<Object> assetutilizationsinceapril(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :assetutilizationsinceapril start");
		logger.info("Method :assetutilizationsinceapril endss");
		return assetDashboardDao.assetutilizationsinceapril(orgName, orgDivision, fromDate, toDate);
	}

// topmeantimefailuresinceapril  
	@RequestMapping(value = "topmeantimefailuresinceapril", method = { RequestMethod.GET })
	public JsonResponse<Object> topmeantimefailuresinceapril(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :topmeantimefailuresinceapril start");
		logger.info("Method :topmeantimefailuresinceapril endss");
		return assetDashboardDao.topmeantimefailuresinceapril(orgName, orgDivision, fromDate, toDate);
	}

// topassetlaborsinceapril  
	@RequestMapping(value = "topassetlaborsinceapril", method = { RequestMethod.GET })
	public JsonResponse<Object> topassetlaborsinceapril(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :topassetlaborsinceapril start");
		logger.info("Method :topassetlaborsinceapril endss");
		return assetDashboardDao.topassetlaborsinceapril(orgName, orgDivision, fromDate, toDate);
	}

// topassetdowntimesinceapril  
	@RequestMapping(value = "topassetdowntimesinceapril", method = { RequestMethod.GET })
	public JsonResponse<Object> topassetdowntimesinceapril(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :topassetdowntimesinceapril start");
		logger.info("Method :topassetdowntimesinceapril endss");
		return assetDashboardDao.topassetdowntimesinceapril(orgName, orgDivision, fromDate, toDate);
	}

////////////////////////////////////////////////////////End Performance

	//////////////////////////////////////////////////////// Start valueassets

	// valueassets
	@RequestMapping(value = "valueassets", method = { RequestMethod.GET })
	public JsonResponse<Object> valueassets(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :valueassets start");
		logger.info("Method :valueassets endss");
		return assetDashboardDao.valueassets(orgName, orgDivision, fromDate, toDate);
	}

	// netassetvalue
	@RequestMapping(value = "netassetvalue", method = { RequestMethod.GET })
	public JsonResponse<Object> netassetvalue(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :netassetvalue start");
		logger.info("Method :netassetvalue endss");
		return assetDashboardDao.netassetvalue(orgName, orgDivision, fromDate, toDate);
	}

	// netpurchasevalue
	@RequestMapping(value = "netpurchasevalue", method = { RequestMethod.GET })
	public JsonResponse<Object> netpurchasevalue(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :netpurchasevalue start");
		logger.info("Method :netpurchasevalue endss");
		return assetDashboardDao.netpurchasevalue(orgName, orgDivision, fromDate, toDate);
	}

	// netscrapvalue
	@RequestMapping(value = "netscrapvalue", method = { RequestMethod.GET })
	public JsonResponse<Object> netscrapvalue(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :netscrapvalue start");
		logger.info("Method :netscrapvalue endss");
		return assetDashboardDao.netscrapvalue(orgName, orgDivision, fromDate, toDate);
	}

	// assetdepriciationvalue
	@RequestMapping(value = "assetdepriciationvalue", method = { RequestMethod.GET })
	public JsonResponse<Object> assetdepriciationvalue(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :assetdepriciationvalue start");
		logger.info("Method :assetdepriciationvalue endss");
		return assetDashboardDao.assetdepriciationvalue(orgName, orgDivision, fromDate, toDate);
	}

	// scrapvalue
	@RequestMapping(value = "scrapvalueMonthWise", method = { RequestMethod.GET })
	public JsonResponse<Object> scrapvalueMonthWise(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :scrapvalueMonthWise start");
		logger.info("Method :scrapvalueMonthWise endss");
		return assetDashboardDao.scrapvalueMonthWise(orgName, orgDivision, fromDate, toDate);
	}

	// scrapvalue
	@RequestMapping(value = "netassetvaluesMonthtWise", method = { RequestMethod.GET })
	public JsonResponse<Object> netassetvaluesMonthtWise(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :netassetvaluesMonthtWise start");
		logger.info("Method :netassetvaluesMonthtWise endss");
		return assetDashboardDao.netassetvaluesMonthtWise(orgName, orgDivision, fromDate, toDate);
	}

//////////////////////////////////////////////////////// End valueassets

////////////////////////////////////////////////////////Start analytics_reports		

// incompleteassets  
	@RequestMapping(value = "incompleteassets", method = { RequestMethod.GET })
	public JsonResponse<Object> incompleteassets(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :incompleteassets start");
		logger.info("Method :incompleteassets endss");
		return assetDashboardDao.incompleteassets(orgName, orgDivision, fromDate, toDate);
	}

	// tableincompleteassets
	@RequestMapping(value = "tableincompleteassets", method = { RequestMethod.GET })
	public JsonResponse<Object> tableincompleteassets(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :tableincompleteassets start");
		logger.info("Method :tableincompleteassets endss");
		return assetDashboardDao.tableincompleteassets(orgName, orgDivision, fromDate, toDate);
	}

	// eligibleforrefreshassets
	@RequestMapping(value = "eligibleforrefreshassets", method = { RequestMethod.GET })
	public JsonResponse<Object> eligibleforrefreshassets(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :eligibleforrefreshassets start");
		logger.info("Method :eligibleforrefreshassets endss");
		return assetDashboardDao.eligibleforrefreshassets(orgName, orgDivision, fromDate, toDate);
	}

	// tableeligibleforrefreshassets
	@RequestMapping(value = "tableeligibleforrefreshassets", method = { RequestMethod.GET })
	public JsonResponse<Object> tableeligibleforrefreshassets(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :tableeligibleforrefreshassets start");
		logger.info("Method :tableeligibleforrefreshassets endss");
		return assetDashboardDao.tableeligibleforrefreshassets(orgName, orgDivision, fromDate, toDate);
	}

	// activeassetsnotdiscovered
	@RequestMapping(value = "activeassetsnotdiscovered", method = { RequestMethod.GET })
	public JsonResponse<Object> activeassetsnotdiscovered(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :activeassetsnotdiscovered start");
		logger.info("Method :activeassetsnotdiscovered endss");
		return assetDashboardDao.activeassetsnotdiscovered(orgName, orgDivision, fromDate, toDate);
	}

	// tableactiveassetsnotdiscovered
	@RequestMapping(value = "tableactiveassetsnotdiscovered", method = { RequestMethod.GET })
	public JsonResponse<Object> tableactiveassetsnotdiscovered(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :tableactiveassetsnotdiscovered start");
		logger.info("Method :tableactiveassetsnotdiscovered endss");
		return assetDashboardDao.tableactiveassetsnotdiscovered(orgName, orgDivision, fromDate, toDate);
	}

	// assetincidentfrequency
	@RequestMapping(value = "assetincidentfrequency", method = { RequestMethod.GET })
	public JsonResponse<Object> assetincidentfrequency(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :assetincidentfrequency start");
		logger.info("Method :assetincidentfrequency endss");
		return assetDashboardDao.assetincidentfrequency(orgName, orgDivision, fromDate, toDate);
	}

	// tableassetincidentfrequency
	@RequestMapping(value = "tableassetincidentfrequency", method = { RequestMethod.GET })
	public JsonResponse<Object> tableassetincidentfrequency(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :tableassetincidentfrequency start");
		logger.info("Method :tableassetincidentfrequency endss");
		return assetDashboardDao.tableassetincidentfrequency(orgName, orgDivision, fromDate, toDate);
	}

	// lifecycleoverview
	@RequestMapping(value = "lifecycleoverview", method = { RequestMethod.GET })
	public JsonResponse<Object> lifecycleoverview(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :lifecycleoverview start");
		logger.info("Method :lifecycleoverview endss");
		return assetDashboardDao.lifecycleoverview(orgName, orgDivision, fromDate, toDate);
	}

	// tablelifecycleoverview
	@RequestMapping(value = "tablelifecycleoverview", method = { RequestMethod.GET })
	public JsonResponse<Object> tablelifecycleoverview(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :tablelifecycleoverview start");
		logger.info("Method :tablelifecycleoverview endss");
		return assetDashboardDao.tablelifecycleoverview(orgName, orgDivision, fromDate, toDate);
	}

	// tableassetdisposalstatus
	@RequestMapping(value = "tableassetdisposalstatus", method = { RequestMethod.GET })
	public JsonResponse<Object> tableassetdisposalstatus(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :tableassetdisposalstatus start");
		logger.info("Method :tableassetdisposalstatus endss");
		return assetDashboardDao.tableassetdisposalstatus(orgName, orgDivision, fromDate, toDate);
	}

	// tableendlifemethod
	@RequestMapping(value = "tableendlifemethod", method = { RequestMethod.GET })
	public JsonResponse<Object> tableendlifemethod(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :tableendlifemethod start");
		logger.info("Method :tableendlifemethod endss");
		return assetDashboardDao.tableendlifemethod(orgName, orgDivision, fromDate, toDate);
	}

	// tableeligiblerefreshassets
	@RequestMapping(value = "tableeligiblerefreshassets", method = { RequestMethod.GET })
	public JsonResponse<Object> tableeligiblerefreshassets(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :tableeligiblerefreshassets start");
		logger.info("Method :tableeligiblerefreshassets endss");
		return assetDashboardDao.tableeligiblerefreshassets(orgName, orgDivision, fromDate, toDate);
	}

	//////////////////////////////////////////////////////// End analytics_reports

	// oprationalAssetCount
	@RequestMapping(value = "oprationalAssetCount", method = { RequestMethod.GET })
	public JsonResponse<Object> oprationalAssetCount(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String activity) {
		logger.info("Method :oprationalAssetCount start");
		logger.info("Method :oprationalAssetCount endss");
		return assetDashboardDao.oprationalAssetCount(orgName, orgDivision, fromDate, toDate, activity);
	}

	// oprationalAssetCount2
	@RequestMapping(value = "oprationalAssetCount2", method = { RequestMethod.GET })
	public JsonResponse<Object> oprationalAssetCount2(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String activity) {
		logger.info("Method :oprationalAssetCount2 start");
		logger.info("Method :oprationalAssetCount2 endss");
		return assetDashboardDao.oprationalAssetCount2(orgName, orgDivision, fromDate, toDate, activity);
	}

	// getAllData11
	@RequestMapping(value = "dashboard-getAllData", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllData11(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String id, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :getAllData11 start");
		logger.info("Method :getAllData11 endss");
		return assetDashboardDao.getAllData(orgName, orgDivision, id, fromDate, toDate);
	}

	// organisation
	@RequestMapping(value = "getOrganization", method = { RequestMethod.GET })
	public List<DropDownModel> getOrganizationDivision(@RequestParam String orgName) {
		logger.info("Method : getOrganizationDivision starts");

		logger.info("Method : getOrganizationDivision ends");
		return assetDashboardDao.getOrganization(orgName);
	}

	// organisationDivision
	@RequestMapping(value = "getDivision", method = { RequestMethod.GET })
	public List<DropDownModel> getDivision(@RequestParam String orgName) {
		logger.info("Method : getDivision starts");

		logger.info("Method : getDivision ends");
		return assetDashboardDao.getDivision(orgName);
	}
}
