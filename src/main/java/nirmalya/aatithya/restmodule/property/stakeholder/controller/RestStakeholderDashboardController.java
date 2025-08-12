package nirmalya.aatithya.restmodule.property.stakeholder.controller;

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
import nirmalya.aatithya.restmodule.property.stakeholder.dao.RestStakeholderDashboardDao;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStakeholderDashboardModel;
import nirmalya.aatithya.restmodule.serviceprovider.model.RestServiceProviderDashboardModel;

@RestController
@RequestMapping("property/")
public class RestStakeholderDashboardController {
	
	Logger logger = LoggerFactory.getLogger(RestStakeholderDashboardController.class);
	@Autowired
	RestStakeholderDashboardDao restManagePropertiesDao;
	
////property type and count each property
	@RequestMapping(value = "dashboard-property-categorise-bar", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>> getpropertydetails(@RequestParam String userid) {
		logger.info("Method : getpropertydetails starts"+userid);

		logger.info("Method : getpropertydetails ends");
		return restManagePropertiesDao.ViewPropertyType(userid);
	}
	
//// Find district with property type and count each property.
	@RequestMapping(value = "dashboard-district-property-categorise-bar", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>> getDistrictPropertycategory(@RequestParam String userid) {
		logger.info("Method : getDistrictPropertycategory starts"+userid);

		logger.info("Method : getDistrictPropertycategory ends");
		return restManagePropertiesDao.viewDistrictPropertyType(userid);
	}
//// Find property Categorise return.
	@RequestMapping(value = "categorise-property-pie", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>> propertyCategoriseReturnPie(@RequestParam String userid) {
		logger.info("Method : propertyCategoriseReturnPie starts"+userid);

		logger.info("Method : propertyCategoriseReturnPie ends");
		return restManagePropertiesDao.propertyCategoriseReturnPie(userid);
	}
//// Find Return OS.
	@RequestMapping(value = "returnos-bar", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>> categoryWiseReturnOS(@RequestParam String userid) {
		logger.info("Method : categoryWiseReturnOS starts"+userid);

		logger.info("Method : categoryWiseReturnOS ends");
		return restManagePropertiesDao.categoryWiseReturnOS(userid);
	}
//// Find maintainance Bar.
	@RequestMapping(value = "maintainance-bar", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>> categoryWiseMaintainanceBar(@RequestParam String userid) {
		logger.info("Method : categoryWiseMaintainanceBar starts"+userid);

		logger.info("Method : categoryWiseMaintainanceBar ends");
		return restManagePropertiesDao.categoryWiseMaintainanceBar(userid);
	}
////Find category Wise Late FeeBar.
	@RequestMapping(value = "latefee-bar", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>> categoryWiseLateFeeBar(@RequestParam String userid) {
		logger.info("Method : categoryWiseLateFeeBar starts"+userid);

		logger.info("Method : categoryWiseLateFeeBar ends");
		return restManagePropertiesDao.categoryWiseLateFeeBar(userid);
	}
	
	@RequestMapping(value = "dashboard-line-data", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>> dashboardLine(@RequestParam String userid) {
		logger.info("Method : dashboardLine starts"+userid);

		logger.info("Method : dashboardLine ends");
		return restManagePropertiesDao.viewdashboardLine(userid);
	}
	

}
