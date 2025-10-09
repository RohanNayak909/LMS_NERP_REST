package nirmalya.aatithya.restmodule.lms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.lms.dao.EnquiryFormRestDao;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping(value = { "master" })
public class EnquiryFormRestController {

	@Autowired
	EnquiryFormRestDao enquiryFormRestDao;

	Logger logger = LoggerFactory.getLogger(EnquiryFormRestController.class);

	@PostMapping(value = "save-enquiry-data")
	public ResponseEntity<JsonResponse<Object>> saveEnquiryData(@RequestBody String data, @RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveEnquiryData starts");
		logger.info("Method :saveEnquiryData endss");
		return enquiryFormRestDao.saveEnquiryData(data, userId, org, orgDiv);
	}

	@RequestMapping(value = "getEnquiryData", method = { RequestMethod.GET })
	public JsonResponse<Object> getEnquiryData(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId) {

		logger.info("Method :getEnquiryData For Vendor starts");

		logger.info("Method :getEnquiryData For Vendor endss");
		return enquiryFormRestDao.getEnquiryData(org, orgDiv, userId);
	}
	
	@RequestMapping(value = "getEditEnquiryData", method = { RequestMethod.GET })
	public JsonResponse<Object> getEditEnquiryData(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId,@RequestParam String id) {

		logger.info("Method :getEditEnquiryData For Vendor starts");

		logger.info("Method :getEditEnquiryData For Vendor endss");
		return enquiryFormRestDao.getEditEnquiryData(org, orgDiv, userId,id);
	}
	
	@RequestMapping(value = "deleteEnquiryData", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteEnquiryData(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userId,@RequestParam String id) {

		logger.info("Method :deleteEnquiryData For Vendor starts");

		logger.info("Method :deleteEnquiryData For Vendor endss");
		return enquiryFormRestDao.deleteEnquiryData(org, orgDiv, userId,id);
	}

}
