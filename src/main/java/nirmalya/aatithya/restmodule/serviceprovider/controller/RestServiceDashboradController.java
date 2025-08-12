package nirmalya.aatithya.restmodule.serviceprovider.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.stakeholder.controller.RestStakeholderDashboardController;
import nirmalya.aatithya.restmodule.serviceprovider.dao.RestServiceProviderDashboardDao;
import nirmalya.aatithya.restmodule.serviceprovider.model.RestServiceProviderDashboardModel;
import nirmalya.aatithya.restmodule.tenant.model.RestTenantDashboardModel;

@RestController
@RequestMapping("property/")
public class RestServiceDashboradController {
	
	Logger logger = LoggerFactory.getLogger(RestStakeholderDashboardController.class);
	@Autowired
	RestServiceProviderDashboardDao restdashboardDao;
	
	
////property type and count each property
	@RequestMapping(value = "service-dashboard-property-categorise-bar", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestServiceProviderDashboardModel>>> getpropertydetails(@RequestParam String userid) {
		logger.info("Method : getpropertydetails starts"+userid);

		logger.info("Method : getpropertydetails ends");
		return restdashboardDao.ViewPropertyType(userid);
	}
	// view total os
	@RequestMapping(value = "service-dashboard-monthly-os", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestServiceProviderDashboardModel>>> getMonthlyOS(@RequestParam String userid) {
		logger.info("Method : getMonthlyOS starts"+userid);

		logger.info("Method : getMonthlyOS ends");
		return restdashboardDao.ViewserviceOS(userid);
	}
	
	@RequestMapping(value = "service-dashboard-line", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestServiceProviderDashboardModel>>> dashboardLine(@RequestParam String userid) {
		logger.info("Method : dashboardLine starts"+userid);

		logger.info("Method : dashboardLine ends");
		return restdashboardDao.viewdashboardLine(userid);
	}

}
