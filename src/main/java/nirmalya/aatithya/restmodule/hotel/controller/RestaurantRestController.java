package nirmalya.aatithya.restmodule.hotel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.hotel.dao.HelpDeskDao;
import nirmalya.aatithya.restmodule.hotel.dao.RestaurantDao;

	
	@RestController
	@RequestMapping(value = { "hotel" })
	public class RestaurantRestController {
		Logger logger = LoggerFactory.getLogger(RestaurantRestController.class);
		
		@Autowired
		RestaurantDao restaurantDao;
		
		@RequestMapping(value = "rest-get-all-restaurant-item", method = { RequestMethod.GET })
		public List<DropDownModel> getAllRestauranttItem(@RequestParam String org, String orgDiv) {
			logger.info("Method : getAllRestauranttItem starts");

			logger.info("Method : getAllRestauranttItem ends");
			return restaurantDao.getAllRestauranttItem(org, orgDiv);
		}
		
		@RequestMapping(value = "rest-save-restro-orders", method = { RequestMethod.POST })
		public JsonResponse<Object> saveAllRestOrders(@RequestParam String orgName, String orgDivision, String userId,
				@RequestBody String data) {
			logger.info("Method :saveAllRestOrders start");

			logger.info("Method :saveAllRestOrders endss");
			return restaurantDao.saveAllRestOrders(orgName, orgDivision, userId, data);
		}

}
