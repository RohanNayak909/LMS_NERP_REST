package nirmalya.aatithya.restmodule.employee.controller;
import java.util.List;
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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.RestHrmsEventDashboardDao;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsEventDashboardModel;
@RestController
@RequestMapping("employee/")
public class RestHrmsEventDashboardController {
	Logger logger = LoggerFactory.getLogger(RestHrmsEventDashboardController.class);

	@Autowired

	RestHrmsEventDashboardDao restHrmsDemoDao;
	
	
	 
	  @GetMapping(value = "rest-viewAboutOrganization")
		public JsonResponse<List<RestHrmsEventDashboardModel>> viewAboutOrganization(@RequestParam String organization,String orgDivision) {
			logger.info("Method :viewAboutOrganization starts");
			
			
			logger.info("Method :viewAboutOrganization endss");
			return restHrmsDemoDao.viewAboutOrganization(organization,orgDivision);
			
		}
		
	
	@GetMapping(value = "rest-getTotalBirthday")
	public JsonResponse<List<RestHrmsEventDashboardModel>> getTotalBirthday(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getTotalBirthday starts");
		
		logger.info("Method : getTotalBirthday ends");
		return restHrmsDemoDao. getTotalBirthdayDao(organization,orgDivision);
	}
	@GetMapping(value = "rest-getTotalMrgAnniversary")
	public JsonResponse<List<RestHrmsEventDashboardModel>> getTotalMrgAnniversary(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getTotalMrgAnniversary starts");
		
		logger.info("Method : getTotalMrgAnniversary ends");
		return restHrmsDemoDao. getTotalMrgAnniversary(organization,orgDivision);
	}
	
	@GetMapping(value = "rest-getTotalServiceAnniversary")
	public JsonResponse<List<RestHrmsEventDashboardModel>> getTotalServiceAnniversary(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getTotalServiceAnniversary starts");
		
		logger.info("Method : getTotalServiceAnniversary ends");
		return restHrmsDemoDao. getTotalServiceAnniversary(organization,orgDivision);
	}
	
	@GetMapping(value = "rest-getTotalAnnouncement")
	public JsonResponse<List<RestHrmsEventDashboardModel>> getTotalAnnouncement(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getTotalAnnouncement starts");
		
		logger.info("Method : getTotalAnnouncement ends");
		return restHrmsDemoDao. getTotalAnnouncement(organization,orgDivision);
	}
	@GetMapping(value = "rest-getTotalPublicHoliday")
	public JsonResponse<List<RestHrmsEventDashboardModel>> getTotalPublicHoliday(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getTotalPublicHoliday starts");
		
		logger.info("Method : getTotalPublicHoliday ends");
		return restHrmsDemoDao. getTotalPublicHoliday(organization,orgDivision);
	}
	
		@GetMapping(value = "rest-getOpenPositionList")
		public JsonResponse<List<RestHrmsEventDashboardModel>> getOpenPositionList(@RequestParam String organization,String orgDivision) {
			logger.info("Method : getOpenPositionList starts");
			
			logger.info("Method : getOpenPositionList ends");
			return restHrmsDemoDao. getOpenPositionListDao(organization,orgDivision);
		}
		@GetMapping(value = "rest-getLeavePolicyList")
		public JsonResponse<List<RestHrmsEventDashboardModel>> getLeavePolicyList(@RequestParam String organization,String orgDivision) {
			logger.info("Method : getLeavePolicyList starts");
			
			logger.info("Method : getLeavePolicyList ends");
			return restHrmsDemoDao. getLeavePolicyListDao(organization,orgDivision);
		}

}
