package nirmalya.aatithya.restmodule.his.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import nirmalya.aatithya.restmodule.his.dao.HISOPDDao;
import nirmalya.aatithya.restmodule.his.model.HISBedMasterRestModel;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

@RestController
@RequestMapping(value = "his/")
public class HISOPDRestController {

	Logger logger = LoggerFactory.getLogger(HISOPDRestController.class);

	@Autowired
	HISOPDDao opdDao;

	@RequestMapping(value = "getCategoryWiseItemList", method = { RequestMethod.GET })
	public List<DropDownModel> getCategoryWiseItemList(@RequestParam String org,String orgDiv,String type) {
		logger.info("Method : getCategoryWiseItemList starts");
		
		logger.info("Method : getCategoryWiseItemList ends");
		return opdDao.getCategoryWiseItemList(org,orgDiv,type);
	}

	// rest-viewOpdDetails
	@RequestMapping(value = "rest-viewOpdDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> viewOpdDetqails(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromdate, @RequestParam String todate) {
		logger.info("Method :viewOpdDetqails start");
		logger.info("Method :viewOpdDetqails endss");
		return opdDao.viewOpdDetails(orgName, orgDivision, fromdate, todate);
	}

	@GetMapping(value = "approvalStatus")
	public JsonResponse<HISPatientRestModel> approvalStatus(@RequestParam String approval, String opdId,
			String approvedBy) {
		logger.info("Method : approvalStatus starts");

		logger.info("Method : approvalStatus ends");
		return opdDao.approvalStatus(approval, opdId, approvedBy);
	}

	@RequestMapping(value = "rest-viewOpdTimeSlots", method = { RequestMethod.GET })
	public JsonResponse<Object> viewOpdTimes(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :viewOpdTimes start...");
		logger.info("Method :viewOpdTimes ends...");
		return opdDao.viewOpdTimeSlots(orgName, orgDivision, userId, fromDate, toDate);
	}

	/* add */

	@RequestMapping(value = "rest-opd-time-add", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addOpdTime(@RequestBody HISPatientRestModel restData) {
		logger.info("Method : addOpdTime starts"/* +restData */);

		logger.info("Method : addOpdTime ends");
		return opdDao.addOpdTime(restData);
	}
	
	//rest-his-opd-vital-details

	@PostMapping(value = "rest-his-opd-vital-details")
	public ResponseEntity<JsonResponse<Object>> saveVitalDetails(@RequestBody String vitalData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveVitalDetails starts");
		logger.info("Method :saveVitalDetails endss");
		return opdDao.saveOpdVitalDetails(vitalData, userId, org, orgDiv);
	}
	

	// rest-view-types
	@RequestMapping(value = "rest-view-types", method = { RequestMethod.GET })
	public JsonResponse<Object> viewTypeDetails(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String types, @RequestParam String opdId) {
		logger.info("Method :viewTypeDetails start");
		logger.info("Method :viewTypeDetails endss");
		return opdDao.viewTypeDetails(orgName, orgDivision, types, opdId);
	}
	
	
	//rest-edit-vital
	@RequestMapping(value = "rest-edit-vital", method = { RequestMethod.GET })
	public JsonResponse<Object> editVital(@RequestParam String orgName,String orgDivision,String vitalId,String vitalIdSlNo) {
		logger.info("Method :editVital start");
		logger.info("Method :editVital endss");
		return opdDao.editVital(orgName, orgDivision, vitalId,vitalIdSlNo);
	}

	// rest-treatment-details
	@PostMapping(value = "rest-treatment-details")
	public ResponseEntity<JsonResponse<Object>> saveTreatmentDetails(@RequestBody List<Map<String, Object>> treatmentDataList,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveTreatmentDetails starts");
		logger.info("Method :saveTreatmentDetails endss");
		return opdDao.saveTreatmentDetails(treatmentDataList, userId, org, orgDiv);
	}
	
	//rest-add-test-details
	@PostMapping(value = "rest-test-details")
	public ResponseEntity<JsonResponse<Object>> saveTestDetails(@RequestBody List<Map<String, Object>> testDataList,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveTestDetails starts");
		logger.info("Method :saveTestDetails endss");
		return opdDao.saveTestDetails(testDataList, userId, org, orgDiv);
	}
	//rest-opd-diet-details
	@PostMapping(value = "rest-opd-diet-details")
	public ResponseEntity<JsonResponse<Object>> saveOpdDiet(@RequestBody String dietData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveOpdDiet starts");
		logger.info("Method :saveOpdDiet endss");
		return opdDao.saveOpdDiet(dietData, userId, org, orgDiv);
	}
	
	//rest-edit-opd-diet
	@RequestMapping(value = "rest-edit-opd-diet", method = { RequestMethod.GET })
	public JsonResponse<Object> editOpdDiet(@RequestParam String orgName,String orgDivision, String dietId,String dietSlNo) {
		logger.info("Method :rest editOpdDiet start");
		logger.info("Method :rest editOpdDiet endss");
		return opdDao.editOpdDiet(orgName, orgDivision, dietId,dietSlNo);
	}
	
	//rest-delelte-opd-diet
	@RequestMapping(value = "rest-delelte-opd-diet", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteOpdDiet(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String dietId) {
		logger.info("Method :deleteOpdDiet start");
		logger.info("Method :deleteOpdDiet endss");
		return opdDao.deleteOpdDiet(orgName, orgDivision, dietId);
	}
	
	//rest-opd-notes-details
	@PostMapping(value = "rest-opd-notes-details")
	public ResponseEntity<JsonResponse<Object>> saveOpdNotes(@RequestBody String notesData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveOpdNotes starts");
		logger.info("Method :saveOpdNotes endss");
		return opdDao.saveOpdNotes(notesData, userId, org, orgDiv);
	}
	
	//rest-edit-opd-notes
	@RequestMapping(value = "rest-edit-opd-notes", method = { RequestMethod.GET })
	public JsonResponse<Object> editOpdNotes(@RequestParam String orgName,String orgDivision, String noteId,String notesIdSlNo) {
		logger.info("Method :rest editOpdNotes start");
		logger.info("Method :rest editOpdNotes endss");
		return opdDao.editOpdNotes(orgName, orgDivision, noteId,notesIdSlNo);
	}
	
	//rest-delelte-opd-note
	@RequestMapping(value = "rest-delelte-opd-note", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteOpdNote(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String noteId) {
		logger.info("Method :deleteOpdNote start");
		logger.info("Method :deleteOpdNote endss");
		return opdDao.deleteOpdNote(orgName, orgDivision, noteId);
	}
	
	
	//rest-opd-ot-details
		@PostMapping(value = "rest-opd-ot-details")
		public ResponseEntity<JsonResponse<Object>> saveOpdOt(@RequestBody String otData,
				@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :saveOpdOt starts");
			logger.info("Method :saveOpdOt endss");
			return opdDao.saveOpdOt(otData, userId, org, orgDiv);
		}
		
		//rest-edit-opd-ot
		@RequestMapping(value = "rest-edit-opd-ot", method = { RequestMethod.GET })
		public JsonResponse<Object> editOpdOt(@RequestParam String orgName,String orgDivision,String opd,String pat) {
			logger.info("Method :rest editOpdOt start");
			logger.info("Method :rest editOpdOt endss");
			return opdDao.editOpdOt(orgName, orgDivision, opd,pat);
		}
		
		/* rest-view-treatment-his */
		@RequestMapping(value = "rest-view-treatment-his", method = { RequestMethod.GET })
		public JsonResponse<Object> viewTreatmentHistory(@RequestParam String orgName, @RequestParam String orgDivision,
				@RequestParam String types, @RequestParam String patId,@RequestParam String bookingId) {
			logger.info("Method :viewTreatmentHistory start");
			logger.info("Method :viewTreatmentHistory endss");
			return opdDao.viewTreatmentHistory(orgName, orgDivision, types, patId, bookingId);
		}
		
		/* rest-view-test-his */
		@RequestMapping(value = "rest-view-test-his", method = { RequestMethod.GET })
		public JsonResponse<Object> viewTestHistory(@RequestParam String orgName, @RequestParam String orgDivision,
				@RequestParam String types, @RequestParam String patId) {
			logger.info("Method :viewTestHistory start");
			logger.info("Method :viewTestHistory endss");
			return opdDao.viewTestHistory(orgName, orgDivision, types, patId);
		}
		
		/* rest-view-diet-his */
		@RequestMapping(value = "rest-view-diet-his", method = { RequestMethod.GET })
		public JsonResponse<Object> viewDietHistory(@RequestParam String orgName, @RequestParam String orgDivision,
				@RequestParam String types, @RequestParam String patId) {
			logger.info("Method :viewDietHistory start");
			logger.info("Method :viewDietHistory endss");
			return opdDao.viewDietHistory(orgName, orgDivision, types, patId);
		}
		
		
		
		//rest-save-opd-symp-details

		@PostMapping(value = "rest-save-opd-symp-details")
		public ResponseEntity<JsonResponse<Object>> saveSympsDetail(@RequestBody String sympData,
				@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
			logger.info("Method :saveSympsDetail starts");
			logger.info("Method :saveSympsDetail endss");
			return opdDao.saveSympsDetail(sympData, userId, org, orgDiv);
		}
		
		//rest-opd-manage-edit-sympt
		@RequestMapping(value = "rest-opd-manage-edit-sympt", method = { RequestMethod.GET })
		public JsonResponse<Object> editSympt(@RequestParam String orgName,String orgDivision, String symptomsId) {
			logger.info("Method :rest editSympt start");
			logger.info("Method :rest editSympt endss");
			return opdDao.editSympt(orgName, orgDivision, symptomsId);
		}
		
}



