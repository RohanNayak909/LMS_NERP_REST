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
import nirmalya.aatithya.restmodule.hotel.dao.HotelConfigurationDao;

@RestController
@RequestMapping(value = { "hotel" })
public class RestHotelConfigurationController {
	Logger logger = LoggerFactory.getLogger(RestFrontdeskController.class);

	@Autowired
	HotelConfigurationDao hotelConfigurationDao;

	@RequestMapping(value = "rest-save-ratetype-details", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveRatetypesDataDetails(@RequestBody String hotelData) {
		logger.info("Method :saveRatetypesData starts");

		logger.info("Method :saveRatetypesData endss");
		return hotelConfigurationDao.saveRatetypesData(hotelData);
	}

	// edit
	@RequestMapping(value = "rest-ratetype-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editRatetype(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editRatetype start");
		logger.info("Method :editRatetype endss");
		return hotelConfigurationDao.editRatetype(id, orgName, orgDivision);
	}

	@RequestMapping(value = "rest-get-room-type-data", method = { RequestMethod.GET })
	public JsonResponse<Object> getRoomTypeData(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :getRoomTypeData start");
		logger.info("Method :getRoomTypeData endss");
		return hotelConfigurationDao.getRoomTypeData(id, orgName, orgDivision);
	}

	@RequestMapping(value = "rest-get-bed-data", method = { RequestMethod.GET })
	public JsonResponse<Object> getBedData(@RequestParam String id, String orgName, String orgDivision,
			String propertyId) {
		logger.info("Method :getBedData start");
		logger.info("Method :getBedData endss");
		return hotelConfigurationDao.getBedData(id, orgName, orgDivision, propertyId);
	}

	// view-Application
	@RequestMapping(value = "rest-ratetypes-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRatetype(@RequestParam String orgName, String orgDivision, String id) {
		logger.info("Method : viewRatetype starts");
		JsonResponse<Object> response = hotelConfigurationDao.viewRatetype(orgName, orgDivision, id);
		logger.info("Method : viewRatetype ends");
		return response;
	}

	@RequestMapping(value = "rest-save-hotel-details", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveService(@RequestBody String studentData) {
		logger.info("Method :saveService starts");

		logger.info("Method :saveService endss");
		return hotelConfigurationDao.saveService(studentData);
	}

	// edit
	@RequestMapping(value = "rest-servicetype-details-edit", method = RequestMethod.GET)
	public JsonResponse<Object> editServiceType(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editServiceType start");
		return hotelConfigurationDao.editServiceType(id, orgName, orgDivision);
	}

	// view
	@RequestMapping(value = "rest-servicetype-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewService(@RequestParam String orgName, String orgDivision, String id) {
		logger.info("Method :viewService start");
		logger.info("Method :viewService endss");
		return hotelConfigurationDao.viewService(orgName, orgDivision, id);
	}
	// =====================Taxtype details=================

	// Save
	@RequestMapping(value = "rest-save-taxtype-details", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveTaxDetails(@RequestBody String studentData) {
		logger.info("Method :saveTaxDetails starts");

		logger.info("Method :saveTaxDetails endss");
		return hotelConfigurationDao.saveTaxDetails(studentData);
	}

	// edit
	@RequestMapping(value = "rest-taxtype-details-edit", method = RequestMethod.GET)
	public JsonResponse<Object> editTaxType(@RequestParam String taxtypeId, String orgName, String orgDivision) {
		logger.info("Method :editTaxType start");
		return hotelConfigurationDao.editTaxType(taxtypeId, orgName, orgDivision);
	}

	// view
	@RequestMapping(value = "rest-property-taxtype-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewTaxtype(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewTaxtype start");
		logger.info("Method :viewTaxtype endss");
		return hotelConfigurationDao.viewTaxtype(orgName, orgDivision);
	}

	//get catagory
	@GetMapping(value = "getProductCategoryList")
	public List<DropDownModel> getProductCategoryList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getProductCategoryList starts");

		logger.info("Method : getProductCategoryList ends");
		return hotelConfigurationDao.getProductCategoryList(org,orgDiv);
	}
	
	//get Subcategory -------->>>>>>>>>>>>>>>
	@RequestMapping(value = "subcategory", method = RequestMethod.GET)
	public ResponseEntity<JsonResponse<List<DropDownModel>>> subcategory(@RequestParam String org,
			@RequestParam String orgDiv, @RequestParam String id) {
		logger.info("Method : subcategory starts");
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = hotelConfigurationDao.subcategory(org, orgDiv, id);
		logger.info("Method : subcategory ends");
		return response;
	}

	// SaveFood detail----------- 
					@RequestMapping(value = "rest-save-restaurant-food-details", method = { RequestMethod.GET, RequestMethod.POST })
					public ResponseEntity<JsonResponse<Object>> saveRestaurantFoodDetails(@RequestBody String resturantFoodLists) {
						logger.info("Method :saveRestaurantFoodDetails starts");

						logger.info("Method :saveRestaurantFoodDetails endss");
						return hotelConfigurationDao.saveRestaurantFoodDetails(resturantFoodLists);
					}
					//editFood detail-----------
					@RequestMapping(value = "rest-hotel-restaurantfood-edit", method = RequestMethod.GET)
					public JsonResponse<Object> editRestaurantFoodDetails(@RequestParam String item_Code, String orgName, String orgDivision) {
					    logger.info("Method :editRestaurantFoodDetails start");
					    return hotelConfigurationDao.editRestaurantFoodDetails(item_Code, orgName, orgDivision);
					}
					//viewFood detail-----------
							@RequestMapping(value = "rest-hotel-restaurant-food-view", method = { RequestMethod.GET })
							public JsonResponse<Object> viewRestaurantFoodDetails(@RequestParam String orgName, String orgDivision) {
							logger.info("Method :viewRestaurantFoodDetails start");
							logger.info("Method :viewRestaurantFoodDetails endss");
							return hotelConfigurationDao.viewRestaurantFoodDetails(orgName, orgDivision);
							}	
			//==============================Restaurant Food Time====================
							// SaveFoodTime detail----------- 
							@RequestMapping(value = "rest-save-restaurant-food-time-details", method = { RequestMethod.GET, RequestMethod.POST })
							public ResponseEntity<JsonResponse<Object>> saveRestaurantFoodTime(@RequestBody String resturantFoodTimeLists) {
								logger.info("Method :saveRestaurantFoodTime starts");

								logger.info("Method :saveRestaurantFoodTime endss");
								return hotelConfigurationDao.saveRestaurantFoodTime(resturantFoodTimeLists);
							}
							
							//viewFoodTime detail-----------
									@RequestMapping(value = "rest-hotel-restaurant-food-time-view", method = { RequestMethod.GET })
									public JsonResponse<Object> viewRestaurantFoodTime(@RequestParam String orgName, String orgDivision) {
									logger.info("Method :viewRestaurantFoodTime start");
									logger.info("Method :viewRestaurantFoodTime endss");
									return hotelConfigurationDao.viewRestaurantFoodTime(orgName, orgDivision);
									}	
									//editTime detail-----------
									@RequestMapping(value = "rest-hotel-restauranttime-edit", method = RequestMethod.GET)
									public JsonResponse<Object> editRestaurantTimeDetails(@RequestParam String tableId, String orgName, String orgDivision) {
									    logger.info("Method :editRestaurantTimeDetails start");
									    return hotelConfigurationDao.editRestaurantTimeDetails(tableId, orgName, orgDivision);
									}

}
