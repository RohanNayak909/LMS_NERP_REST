package nirmalya.aatithya.restmodule.his.controller;
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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HISBedMasterDao;
import nirmalya.aatithya.restmodule.his.dao.HisBookingAmbulanceDao;
import nirmalya.aatithya.restmodule.his.model.HISBedMasterRestModel;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;
import nirmalya.aatithya.restmodule.his.model.RestHisBookingAmbulanceModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseQuotationModel;

@RestController
@RequestMapping(value = { "his" })
public class RestHisBookingAmbulanceController {

	Logger logger = LoggerFactory.getLogger(RestHisBookingAmbulanceController.class);

	@Autowired
	HisBookingAmbulanceDao hisBookingAmbulanceDao;

	//view
	
	@RequestMapping(value = "rest-booking-ambulance-list-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAmbulanceList(@RequestParam String orgName, String orgDivision,String userId) {
		logger.info("Method :viewAmbulanceList start");

		logger.info("Method :viewAmbulanceList endss");
		return hisBookingAmbulanceDao.viewAmbulanceList(orgName, orgDivision,userId);
	}
	
	@PostMapping(value = "rest-addBookingAmbulance")
	public ResponseEntity<JsonResponse<Object>> addBookingAmbulance(
			@RequestBody RestHisBookingAmbulanceModel addBookingAmbulance) {
		logger.info("Method :addBookingAmbulance starts");
		logger.info("Method :addBookingAmbulance endss");
		return hisBookingAmbulanceDao.addBookingAmbulance(addBookingAmbulance);
	}
	
	@RequestMapping(value = "rest-viewAmbulanceBookingList", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAmbulanceBookingList(@RequestParam String orgName, String orgDivision,String userId) {
		logger.info("Method :viewAmbulanceBookingList start");

		logger.info("Method :viewAmbulanceBookingList endss");
		return hisBookingAmbulanceDao.viewAmbulanceBookingList(orgName, orgDivision,userId);
	}
	
	//delete
		@RequestMapping(value = "rest-deleteAmbulance", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteAmbulance(@RequestParam String id) {
			logger.info("Method : deleteAmbulance starts");

			logger.info("Method : deleteAmbulance ends");
			return hisBookingAmbulanceDao.deleteAmbulance(id);
		}
		
		@GetMapping(value = "approvalStatusAmbulance")
		public JsonResponse<RestHisBookingAmbulanceModel> approvalStatus(@RequestParam String approval, String bookingId) {
			logger.info("Method : approvalStatus starts");

			logger.info("Method : approvalStatus ends");
			return hisBookingAmbulanceDao.approvalStatus(approval, bookingId);
		}
		
		@RequestMapping(value = "getAmbulanceTypeList", method = { RequestMethod.GET })
		public List<DropDownModel> getAmbulanceTypeList() {

			logger.info("Method : getAmbulanceTypeList starts");
			logger.info("Method : getAmbulanceTypeList ends");

			return hisBookingAmbulanceDao.getAmbulanceTypeList();
		}
		
		@RequestMapping(value = "getAmbulanceRequirement", method = { RequestMethod.GET })
		public List<DropDownModel> getAmbulanceRequirement() {

			logger.info("Method : getAmbulanceRequirement starts");
			logger.info("Method : getAmbulanceRequirement ends");

			return hisBookingAmbulanceDao.getAmbulanceRequirement();
		}
		
		// cityList
		@RequestMapping(value = "rest-CityList", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<DropDownModel>>> cityList(@RequestParam String id) {
			logger.info("Method : cityList starts");
			logger.info("Method : cityList ends");
			return hisBookingAmbulanceDao.cityList(id);
		}
		@GetMapping(value = "approvePatientSts")
		public JsonResponse<RestHisBookingAmbulanceModel> approvePatientSts(@RequestParam String approval, String bookingId) {
			logger.info("Method : approvePatientSts starts");

			logger.info("Method : approvePatientSts ends");
			return hisBookingAmbulanceDao.approvePatientSts(approval, bookingId);
		}
		
		//rest-view-paymnet-details
		@RequestMapping(value = "rest-view-paymnet-details", method = { RequestMethod.GET })
		public JsonResponse<Object> viewPaymentDetails(@RequestParam String orgName, @RequestParam String orgDivision,
				@RequestParam String id) {
			logger.info("Method :viewPaymentDetails start");
			logger.info("Method :viewPaymentDetails endss");
			return hisBookingAmbulanceDao.viewPaymentDetails(orgName, orgDivision, id);
		}
		//getAllPatientList
		@RequestMapping(value = "getAllPatientList", method = { RequestMethod.GET })
		public List<DropDownModel> getAllPatientList(@RequestParam String orgName,String orgDivision) {
			logger.info("Method : getAllPatientList starts");
			logger.info("Method : getAllPatientList ends");
			return hisBookingAmbulanceDao.getAllPatientList(orgName,orgDivision);
		}
		//getPatientDetailsById
		@RequestMapping(value = "getPatientDetailsById", method = { RequestMethod.GET })
		public JsonResponse<Object> getPatientDetailsById(@RequestParam String orgName,String orgDivision,String id) {
			logger.info("Method :getPatientDetailsById start");
			logger.info("Method :getPatientDetailsById endss");
			return hisBookingAmbulanceDao.getPatientDetailsById(orgName, orgDivision, id);
		}
}
