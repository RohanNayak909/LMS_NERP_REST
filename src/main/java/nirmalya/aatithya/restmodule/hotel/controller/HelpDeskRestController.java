package nirmalya.aatithya.restmodule.hotel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.hotel.dao.HelpDeskDao;



@RestController
@RequestMapping(value = { "hotel" })
public class HelpDeskRestController {
	Logger logger = LoggerFactory.getLogger(HelpDeskRestController.class);
	
	@Autowired
	HelpDeskDao helpDeskDao;
	
	@GetMapping(value = "getAllUserLists")
	public List<DropDownModel> getAllUserLists(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getAllUserLists starts");

		logger.info("Method : getAllUserLists ends");
		return helpDeskDao.getAllUserLists(org, orgDiv);
	}
	/* rest-view-ticket */
	 @GetMapping(value = "rest-view-ticket")
		public JsonResponse<Object> viewAllTicketById(@RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String userid, @RequestParam String id) {
			logger.info("Method :viewAllTicketById start");

			logger.info("Method :viewAllTicketById ends");
			return helpDeskDao.viewAllTicketById(org, orgDiv, userid, id);

		}
	 
	 @RequestMapping(value = "getAllHotelsRoomDetails", method = { RequestMethod.GET })
		public List<DropDownModel> getAllHotelsRoomDetails(@RequestParam String org,String orgDiv,String userId) {
			logger.info("Method : getAllHotelsRoomDetails starts");

			logger.info("Method : getAllHotelsRoomDetails ends");
			return helpDeskDao.getAllHotelsRoomDetails(org,orgDiv,userId);
		}
	 
	 
	 @GetMapping(value = "getAllRoomDetails")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllRoomDetails(@RequestParam String org,
				@RequestParam String orgDiv) {
			logger.info("Method : getAllRoomDetails starts");

			logger.info("Method : getAllRoomDetails ends");
			return helpDeskDao.getAllRoomDetails( org, orgDiv);

		}
	 
	 @RequestMapping(value = "getAllServiceCategory", method = { RequestMethod.GET })
		public List<DropDownModel> getAllServiceCategory(@RequestParam String org,String orgDiv) {
			logger.info("Method : getAllServiceCategory starts");

			logger.info("Method : getAllServiceCategory ends");
			return helpDeskDao.getAllServiceCategory(org,orgDiv);
		}
	 
	 
	 @RequestMapping(value = "getAllServiceCategoryAme", method = { RequestMethod.GET })
		public List<DropDownModel> getAllServiceCategoryAme(@RequestParam String org,String orgDiv) {
			logger.info("Method : getAllServiceCategoryAme starts");

			logger.info("Method : getAllServiceCategoryAme ends");
			return helpDeskDao.getAllServiceCategoryAme(org,orgDiv);
		}
	 
	 
		@RequestMapping(value = "getAllItemList", method = { RequestMethod.GET })
		public List<DropDownModel> getAllItemList(@RequestParam String org, String orgDiv,@RequestParam String id) {
			logger.info("Method : getAllItemList starts");

			logger.info("Method : getAllItemList ends");
			return helpDeskDao.getAllItemList(org, orgDiv,id);
		}
		
		/* rest-save-hotel-services */
		@RequestMapping(value = "rest-save-hotel-services", method = { RequestMethod.POST })
		public JsonResponse<Object> saveHotelService(@RequestParam String orgName, String orgDivision, String userId,
				@RequestBody String data) {
			logger.info("Method :saveHotelService start");

			logger.info("Method :saveHotelService endss");
			return helpDeskDao.saveHotelService(orgName, orgDivision, userId, data);
		}
		
		/* rest-view-ticket */
		 @GetMapping(value = "rest-view-services-types")
			public JsonResponse<Object> viewAllServicesTypes(@RequestParam String org, @RequestParam String orgDiv,
					@RequestParam String userid, @RequestParam String id,@RequestParam String tabId) {
				logger.info("Method :viewAllServicesTypes start");

				logger.info("Method :viewAllServicesTypes ends");
				return helpDeskDao.viewAllServicesTypes(org, orgDiv, userid, id,tabId);

			}
		 
		 /* rest-view-ticket */
		 @GetMapping(value = "rest-view-services-by-id")
			public JsonResponse<Object> viewAllServicesTypesById(@RequestParam String org, @RequestParam String orgDiv,
					@RequestParam String userid, @RequestParam String id) {
				logger.info("Method :viewAllServicesTypesById start");

				logger.info("Method :viewAllServicesTypesById ends");
				return helpDeskDao.viewAllServicesTypesById(org, orgDiv, userid, id);

			}
}
