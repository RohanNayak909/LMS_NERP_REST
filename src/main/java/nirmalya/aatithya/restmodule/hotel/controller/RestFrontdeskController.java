package nirmalya.aatithya.restmodule.hotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.hotel.dao.FrontdeskDao;

@RestController
@RequestMapping(value = { "hotel" })
public class RestFrontdeskController {
	Logger logger = LoggerFactory.getLogger(RestFrontdeskController.class);

	@Autowired
	FrontdeskDao frontdeskDao;

	@PostMapping(value = "rest-save-corporate-details")
	public ResponseEntity<JsonResponse<Object>> saveCorporateData(@RequestBody String corporateData) {
		logger.info("Method :rest-save-corporate-details starts");

		logger.info("Method :rest-save-corporate-details ends");
		return frontdeskDao.saveCorporateData(corporateData);
	}

	// countryList
	@RequestMapping(value = "getUserCountryDemo", method = { RequestMethod.GET })
	public List<DropDownModel> countryList() {

		logger.info("Method : countryList starts");
		logger.info("Method : countryList ends");

		return frontdeskDao.countryList();
	}

	// countryList
	@RequestMapping(value = "getUserRooms", method = { RequestMethod.GET })
	public List<DropDownModel> getUserRooms() {

		logger.info("Method : getUserRooms starts");
		logger.info("Method : getUserRooms ends");

		return frontdeskDao.roomList();
	}

	// view-CorporateDetails
	@RequestMapping(value = "rest-corporatedetails-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewCorporate(@RequestParam String orgName, String orgDivision, String type) {
		logger.info("Method :viewCorporate start");

		logger.info("Method :viewCorporate ends");
		return frontdeskDao.viewCorporate(orgName, orgDivision, type);
	}

	// edit-CorporateDetails -->>>>
	@RequestMapping(value = "rest-corporateDetails-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editCorporateDetails(@RequestParam String id) {
		logger.info("Method : editCorporateDetails starts");

		logger.info("Method : editCorporateDetails ends");
		return frontdeskDao.editCorporateDetails(id);
	}

	// Reservation Data Handle Here ---->
	// Application-Data Save
	@RequestMapping(value = "rest-savehotel-reservation-details", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveReservation(@RequestBody String reservationdata) {
		logger.info("Method :saveReservation starts");

		logger.info("Method :saveReservation endss");
		return frontdeskDao.saveReservation(reservationdata);
	}

	// view-Application
	@RequestMapping(value = "rest-get-hotel-reservation-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewReservation(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewReservation start");

		logger.info("Method :viewReservation endss");

		return frontdeskDao.viewReservation(orgName, orgDivision);
	}

	// edit-Application

	@RequestMapping(value = "rest-hotel-reservation-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editReservation(@RequestParam String bookingId) {
		logger.info("Method : editReservation starts");

		logger.info("Method : editReservation ends");
		return frontdeskDao.editReservation(bookingId);
	}

	// Check-in Tabs Handle Here --->>>
	// save Check-in Hotel
	@RequestMapping(value = "rest-savehotel-checkin-details", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveCheckinHotel(@RequestBody String checkinData) {
		logger.info("Method :saveCheckinHotel starts");

		logger.info("Method :saveCheckinHotel endss");
		return frontdeskDao.saveCheckinHotel(checkinData);
	}

	// RoomNumber List
	@RequestMapping(value = "getroomNumberLists", method = { RequestMethod.GET })
	public List<DropDownModel> getroomNumberOfLists() {
		logger.info("Method : getroomNumberOfLists starts");

		logger.info("Method : getroomNumberOfLists ends");
		return frontdeskDao.getroomNumberOfLists();
	}

}
