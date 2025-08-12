package nirmalya.aatithya.restmodule.his.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HisPatientDischargeDao;

@RestController
@RequestMapping("his")
public class HisPatientDischargeRestController {
	Logger logger = LoggerFactory.getLogger(HisPatientDischargeRestController.class);
	@Autowired
	HisPatientDischargeDao hisPatientDao;
	
	//Discharge Type Drop Down
	@RequestMapping(value = "get-discharge-type-list", method = { RequestMethod.GET })
	public List<DropDownModel> getDischargeTypeList(@RequestParam String org,String orgDiv) {
		logger.info("Method : getDischargeTypeList starts");
		
		logger.info("Method : getDischargeTypeList ends");
		return hisPatientDao.getDischargeTypeList(org,orgDiv);
	}
	
	//GET THE PATIENT DETAILS FOR DISCHARGE
	@GetMapping("rest-get-discharge-patient-details")
	public JsonResponse<Object> getPatientDetails(@RequestParam String orgName, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestParam String bookingId) {
		logger.info("Method :getPatientDetails start");

		logger.info("Method :getPatientDetails ends");
		return hisPatientDao.getPatientDetails(orgName, orgDiv, userId, bookingId);
	}
	//ADD DISCHARGE DATA
	@PostMapping("rest-add-discharge-data")
	public JsonResponse<Object> addPatientDischargeData(@RequestBody Map<String, Object> dischargeJsonData) {
		logger.info("Method : addPatientDischargeData starts");

		logger.info("Method : addPatientDischargeData ends");
		return hisPatientDao.addPatientDischargeData(dischargeJsonData);
	}
	//GET THE PATIENT DETAILS FOR DISCHARGE PDF
		@GetMapping("rest-get-discharge-patient-details-for-pdf")
		public JsonResponse<Object> getPatientDetailsForPdf(@RequestParam String orgName, @RequestParam String orgDiv,
				@RequestParam String userId, @RequestParam String bookingId) {
			logger.info("Method :getPatientDetailsForPdf start");

			logger.info("Method :getPatientDetailsForPdf ends");
			return hisPatientDao.getPatientDetailsForPdf(orgName, orgDiv, userId, bookingId);
		}
	//Delete Discharge Data
	@GetMapping("rest-delete-discharge-data")
	public JsonResponse<Object>deleteDischargeData(@RequestParam String bookingId, String orgName,String orgDiv){
		logger.info("Method :deleteDischargeData start");
		
		logger.info("Method :deleteDischargeData End");
		return hisPatientDao.deleteDischargeData(bookingId,orgName,orgDiv);
	}
}
