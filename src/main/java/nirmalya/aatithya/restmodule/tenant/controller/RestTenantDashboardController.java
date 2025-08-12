package nirmalya.aatithya.restmodule.tenant.controller;

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
import nirmalya.aatithya.restmodule.tenant.dao.RestTenantDasboardDao;
import nirmalya.aatithya.restmodule.tenant.model.RestTenantDashboardModel;


@RestController
@RequestMapping("property/")
public class RestTenantDashboardController {
	
	Logger logger = LoggerFactory.getLogger(RestTenantDashboardController.class);
	@Autowired
	RestTenantDasboardDao resttenantdashboardDao;
	
////property type and count each property
	@RequestMapping(value = "tenant-monthlyrentLate-bar", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestTenantDashboardModel>>> getpropertydetails(@RequestParam String userid) {
		logger.info("Method : getpropertydetails starts"+userid);

		logger.info("Method : getpropertydetails ends");
		return resttenantdashboardDao.ViewPropertyType(userid);
	}
	
	
	@RequestMapping(value = "tenant-monthlyOS-point", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestTenantDashboardModel>>> getMonthlyOS(@RequestParam String userid) {
		logger.info("Method : getMonthlyOS starts"+userid);

		logger.info("Method : getMonthlyOS ends");
		return resttenantdashboardDao.ViewMonthlyOS(userid);
	}
	
	@RequestMapping(value = "tenant-dashboard-line", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestTenantDashboardModel>>> dashboardLine(@RequestParam String userid) {
		logger.info("Method : dashboardLine starts"+userid);

		logger.info("Method : dashboardLine ends");
		return resttenantdashboardDao.viewdashboardLine(userid);
	}

}
