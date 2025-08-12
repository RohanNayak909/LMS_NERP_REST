package nirmalya.aatithya.restmodule.qa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.qa.dao.RestQaMicroLabDao;
import nirmalya.aatithya.restmodule.qa.model.RestMicrobiologyLabratoryModel;
import nirmalya.aatithya.restmodule.qa.model.RestPcroCheckListModel;

@RestController
@RequestMapping(value = { "production/" })
public class QaMicroBiologyLabController {
	
	Logger logger = LoggerFactory.getLogger(QaMicroBiologyLabController.class);

	@Autowired
	RestQaMicroLabDao restQaMicroLabDao;
	
	// for sl no
	@RequestMapping(value = "rest-micro-lab-slno", method = { RequestMethod.GET })
	public JsonResponse<Object> getMicroLabSlno(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getMicroLabSlno start");

		logger.info("Method :getMicroLabSlno endss");
		return restQaMicroLabDao.getMicroLabSlno(orgName, orgDivision);
	}
	
	@RequestMapping(value = "Rest-micro-lab-getID", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestMicrobiologyLabratoryModel>>> labTestID(@RequestParam String orgName, String orgDivision) {
		logger.info("Method: labTestID Start");

		logger.info("Method: labTestID ends");
		return restQaMicroLabDao.labTestID(orgName, orgDivision);
	}
	
	// add

	@PostMapping(value = "rest-micro-lab-add-day-one")
	public JsonResponse<Object> saveDataOne(

			@RequestBody List<RestMicrobiologyLabratoryModel> restMicrobiologyLabratoryModel) {
		logger.info("Method : saveDataOne starts");
		logger.info("Method : saveDataOne ends");
		return restQaMicroLabDao.saveDataOne(restMicrobiologyLabratoryModel);
	}
	
	
	// getView
	@RequestMapping(value = "rest-micro-lab-add-view", method = { RequestMethod.GET })
	public JsonResponse<Object> getLabTestView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getLabTestView start");

		logger.info("Method :getLabTestView endss");
		return restQaMicroLabDao.getLabTestView(orgName, orgDivision);
	}


	// editLabTestView
		@RequestMapping(value = "rest-micro-lab-edit", method = { RequestMethod.GET })
		public JsonResponse<Object> editLabTest(@RequestParam String id, String orgName, String orgDivision) {
			logger.info("Method :editLabTest start");

			logger.info("Method :editLabTest endss");
			return restQaMicroLabDao.editLabTest(id, orgName, orgDivision);
		}
		
		
		// deleteLabTest
					@RequestMapping(value = "rest-micro-lab-delete", method = { RequestMethod.GET })
					public ResponseEntity<JsonResponse<Object>> deleteLabtest(@RequestParam String id, String org, String div) {
						logger.info("Method : deleteLabtest starts");

						logger.info("Method : deleteLabtest ends");
						return restQaMicroLabDao.deleteLabtest(id, org, div);

					}
	
//
					@RequestMapping(value = "rest-microLabPdfDetaills", method = { RequestMethod.GET })
					public JsonResponse<Object> microLabPdf(@RequestParam String id,String orgName,String orgDivision) {
						logger.info("Method :microLabPdf start");

						logger.info("Method :microLabPdf endss");
						return restQaMicroLabDao.microLabPdf(id,orgName,orgDivision);

					}
}
