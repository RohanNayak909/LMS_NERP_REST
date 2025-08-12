package nirmalya.aatithya.restmodule.productionplan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetReportDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.productionplan.dao.ProductionPlanRestDao;

@RestController
@RequestMapping(value = { "production/" })
public class ProductionLogRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	ProductionPlanRestDao productionPlanRestDao;


	@RequestMapping(value = "rest-production-log-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewProductionLog(@RequestParam String orgName, String orgDivision, String floorId) {
		logger.info("Method :viewProductionLog start");

		logger.info("Method :viewProductionLog endss");
		return productionPlanRestDao.viewProductionLog(orgName, orgDivision,floorId);
	}
}
