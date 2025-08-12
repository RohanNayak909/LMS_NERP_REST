package nirmalya.aatithya.restmodule.qa.controller;

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
import nirmalya.aatithya.restmodule.qa.dao.QaRequestedOfDao;
import nirmalya.aatithya.restmodule.qa.model.RestQaRequestModel;

@RestController
@RequestMapping(value = { "qa/" })
public class RestQaRequestedOfController {
	
	Logger logger = LoggerFactory.getLogger(RestQaRequestedOfController.class);

	@Autowired
	QaRequestedOfDao qaRequestedOfDao;
	
	// view
	
	@RequestMapping(value = "rest-getQaRequstForOfView", method = { RequestMethod.GET })
	public JsonResponse<Object> getQaRequstForOfView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getQaRequstForOfView start");

		logger.info("Method :getQaRequstForOfView endss");
		return qaRequestedOfDao.getQaRequstForOfView(orgName, orgDivision);
	}
	
	// Add
	
	@PostMapping(value = "rest-addOfQaData")
	public ResponseEntity<JsonResponse<RestQaRequestModel>> addOfQaData(

			@RequestBody RestQaRequestModel restQaRequestModel) {
		logger.info("Method : addOfQaData starts");
		logger.info("Method : addOfQaData ends");
		return qaRequestedOfDao.addOfQaData(restQaRequestModel);
	}

}
