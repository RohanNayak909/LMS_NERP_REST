package nirmalya.aatithya.restmodule.pipeline.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmDailyWorkDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmDashboardControllerDao;

@RestController
@RequestMapping(value = "pipeline")
public class RestCrmDashboardController {
	
	Logger logger = LoggerFactory.getLogger(RestCrmDashboardController.class);
	@Autowired
	RestCrmDashboardControllerDao restCrmDashboardControllerDao;
	
	
	// organisation
	@RequestMapping(value = "getOrganization", method = { RequestMethod.GET })
	public List<DropDownModel> getOrganizationDivision(@RequestParam String orgName) {
		logger.info("Method : getOrganizationDivision starts");

		logger.info("Method : getOrganizationDivision ends");
		return restCrmDashboardControllerDao.getOrganization(orgName);
	}

	// organisationDivision
	@RequestMapping(value = "getDivision", method = { RequestMethod.GET })
	public List<DropDownModel> getDivision(@RequestParam String orgName) {
		logger.info("Method : getDivision starts");

		logger.info("Method : getDivision ends");
		return restCrmDashboardControllerDao.getDivision(orgName);
	}
	
	

	// getAllRecordOperational
			@RequestMapping(value = "getAllRecordOperational", method = { RequestMethod.GET })
			public JsonResponse<Object> getAllRecordOperational(@RequestParam String fromDate,
					@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String id,@RequestParam String loc,@RequestParam String allKeyRoles) {
				logger.info("Method :getAllRecordOperational start");

				logger.info("Method :getAllRecordOperational endss");
				return restCrmDashboardControllerDao.getAllRecordOperational(orgName, orgDivision, fromDate, toDate, id, loc, allKeyRoles);

			}
			
			//getAllRecordOperationalExecutive
			@RequestMapping(value = "getAllRecordOperationalExecutive", method = { RequestMethod.GET })
			public JsonResponse<Object> getAllRecordOperationalExecutive(@RequestParam String fromDate,
					@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String id,
					@RequestParam String loc, @RequestParam String executive) {
				logger.info("Method :getAllRecordOperationalExecutive start");

				logger.info("Method :getAllRecordOperationalExecutive endss");
				return restCrmDashboardControllerDao.getAllRecordOperationalExecutive(orgName,orgDivision,fromDate,toDate,id,loc,executive);

			}

			
			//getAllCRMHeadCount

			
		@RequestMapping(value = "getAllCRMHeadCount", method = { RequestMethod.GET })
		public JsonResponse<Object> getAllCRMHeadCount(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,
				@RequestParam String loc, @RequestParam String allKeyRoles) {
			logger.info("Method :getAllCRMHeadCount start");

			logger.info("Method :getAllCRMHeadCount endss");
			return restCrmDashboardControllerDao.getAllCRMHeadCount(orgName,orgDivision,fromDate,toDate,loc, allKeyRoles);

		}
		
		
		
		//getAllCRMCityList
		@RequestMapping(value = "getAllCRMCityList", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllCRMCityList(@RequestParam String id) {
			logger.info("Method : getAllCRMCityList starts");
			logger.info("Method : getAllCRMCityList ends");
			return restCrmDashboardControllerDao.getAllCRMCityList(id);
		}
		
		//getAllCRMHeadCountExecutive
		
		@RequestMapping(value = "getAllCRMHeadCountExecutive", method = { RequestMethod.GET })
		public JsonResponse<Object> getAllCRMHeadCountExecutive(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,
				@RequestParam String loc, @RequestParam String executive) {
			logger.info("Method :getAllCRMHeadCountExecutive start");

			logger.info("Method :getAllCRMHeadCountExecutive endss");
			return restCrmDashboardControllerDao.getAllCRMHeadCountExecutive(orgName,orgDivision,fromDate,toDate,loc,executive);

		}
		
		//getTop5SalesExecutive
		@RequestMapping(value = "getTop5SalesExecutive", method = { RequestMethod.GET })
		public JsonResponse<Object> getTop5SalesExecutive(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,
				@RequestParam String loc,@RequestParam String  executive,@RequestParam String allKeyRoles) {
			logger.info("Method :getTop5SalesExecutive start");

			logger.info("Method :getTop5SalesExecutive endss");
			return restCrmDashboardControllerDao.getTop5SalesExecutive(orgName,orgDivision,fromDate,toDate,loc,executive,allKeyRoles);

		}
		
		//getAllCountForLeadRatios
		@RequestMapping(value = "getAllCountForLeadRatios", method = { RequestMethod.GET })
		public JsonResponse<Object> getAllCountForLeadRatios(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,
				@RequestParam String loc, @RequestParam String executive,@RequestParam String allKeyRoles) {
			logger.info("Method :getAllCountForLeadRatios start");

			logger.info("Method :getAllCountForLeadRatios endss");
			return restCrmDashboardControllerDao.getAllCountForLeadRatios(orgName,orgDivision,fromDate,toDate,loc,executive,allKeyRoles);

		}
		
		//getCRMSalesTargetLength
		@RequestMapping(value = "getCRMSalesTargetLength", method = { RequestMethod.GET })
		public JsonResponse<Object> getCRMSalesTargetLength(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,
				@RequestParam String loc, @RequestParam String executive, @RequestParam String allKeyRoles) {
			logger.info("Method :getCRMSalesTargetLength start");

			logger.info("Method :getCRMSalesTargetLength endss");
			return restCrmDashboardControllerDao.getCRMSalesTargetLength(orgName,orgDivision,fromDate,toDate,loc,executive,allKeyRoles);

		}
		
		//getAllConvertedLeadCountInLast30Days
		@RequestMapping(value = "getAllConvertedLeadCountInLast30Days", method = { RequestMethod.GET })
		public JsonResponse<Object> getAllConvertedLeadCountInLast30Days(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,
				@RequestParam String loc, @RequestParam String executive,@RequestParam String allKeyRoles) {
			logger.info("Method :getAllConvertedLeadCountInLast30Days start");

			logger.info("Method :getAllConvertedLeadCountInLast30Days endss");
			return restCrmDashboardControllerDao.getAllConvertedLeadCountInLast30Days(orgName,orgDivision,fromDate,toDate,loc,executive,allKeyRoles);

		}
		
		//getAllConvertedCountFunnelAndAvgDays
		@RequestMapping(value = "getAllConvertedCountFunnelAndAvgDays", method = { RequestMethod.GET })
		public JsonResponse<Object> getAllConvertedCountFunnelAndAvgDays(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,
				@RequestParam String loc, @RequestParam String executive, @RequestParam String allKeyRoles) {
			logger.info("Method :getAllConvertedCountFunnelAndAvgDays start");

			logger.info("Method :getAllConvertedCountFunnelAndAvgDays endss");
			return restCrmDashboardControllerDao.getAllConvertedCountFunnelAndAvgDays(orgName,orgDivision,fromDate,toDate,loc,executive,allKeyRoles);

		}

		//getActivitiesCountHead
		@RequestMapping(value = "getActivitiesCountHead", method = { RequestMethod.GET })
		public JsonResponse<Object> getActivitiesCountHead(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,
				@RequestParam String loc, @RequestParam String executive, @RequestParam String allKeyRoles) {
			logger.info("Method :getActivitiesCountHead start");

			logger.info("Method :getActivitiesCountHead endss");
			return restCrmDashboardControllerDao.getActivitiesCountHead(orgName,orgDivision,fromDate,toDate,loc,executive,allKeyRoles);

		}
		
		
		//getActivitiesLeadCalls
		@RequestMapping(value = "getActivitiesLeadCalls", method = { RequestMethod.GET })
		public JsonResponse<Object> getActivitiesLeadCalls(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,
				@RequestParam String loc, @RequestParam String executive, @RequestParam String allKeyRoles) {
			logger.info("Method :getActivitiesLeadCalls start");

			logger.info("Method :getActivitiesLeadCalls endss");
			return restCrmDashboardControllerDao.getActivitiesLeadCalls(orgName,orgDivision,fromDate,toDate,loc,executive, allKeyRoles);

		}
		
		
		//getActivitiesLeadMeetings
		@RequestMapping(value = "getActivitiesLeadMeetings", method = { RequestMethod.GET })
		public JsonResponse<Object> getActivitiesLeadMeetings(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,
				@RequestParam String loc, @RequestParam String executive, @RequestParam String allKeyRoles) {
			logger.info("Method :getActivitiesLeadMeetings start");

			logger.info("Method :getActivitiesLeadMeetings endss");
			return restCrmDashboardControllerDao.getActivitiesLeadMeetings(orgName,orgDivision,fromDate,toDate,loc,executive, allKeyRoles);

		}
		
		
		//getActivitiesLeadTasks
		@RequestMapping(value = "getActivitiesLeadTasks", method = { RequestMethod.GET })
		public JsonResponse<Object> getActivitiesLeadTasks(@RequestParam String fromDate,
				@RequestParam String toDate,@RequestParam String orgName ,@RequestParam String orgDivision,
				@RequestParam String loc, @RequestParam String executive, @RequestParam String allKeyRoles) {
			logger.info("Method :getActivitiesLeadTasks start");

			logger.info("Method :getActivitiesLeadTasks endss");
			return restCrmDashboardControllerDao.getActivitiesLeadTasks(orgName,orgDivision,fromDate,toDate,loc,executive, allKeyRoles);

		}
		
}
