package nirmalya.aatithya.restmodule.qa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.qa.dao.RestSampleRequestDao;

@RestController
@RequestMapping(value = "production/")
public class RestSampleRequestController {
	
	
	Logger logger = LoggerFactory.getLogger(RestSampleRequestController.class);

	@Autowired
	RestSampleRequestDao restSampleRequestDao;

	@RequestMapping(value = "rest-viewSampleRequestData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewSampleRequestData(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewSampleRequestData start");

		logger.info("Method :viewSampleRequestData endss");
		return restSampleRequestDao.viewSampleRequestData(orgName, orgDivision);

	}
	
	
	// add sampleAmt.
		@GetMapping(value = "rest-add-sampleAmt")
		public ResponseEntity<JsonResponse<Object>> sampleAmt(@RequestParam String id,String sampleAmt, String reqId, String QrCode, String orgName, String orgDivision) {
			logger.info("Method : sampleAmt starts");
			logger.info("Method : sampleAmt ends");
			return restSampleRequestDao.sampleAmt(id, sampleAmt, reqId, QrCode, orgName, orgDivision);
		}
	
	

}
