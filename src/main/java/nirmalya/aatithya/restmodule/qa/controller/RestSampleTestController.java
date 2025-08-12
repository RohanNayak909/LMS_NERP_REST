package nirmalya.aatithya.restmodule.qa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.qa.dao.RestSampleTestDao;
import nirmalya.aatithya.restmodule.qa.model.RestSampleTestModel;

@RestController
@RequestMapping(value = "production/")
public class RestSampleTestController {
	
	
	Logger logger = LoggerFactory.getLogger(RestSampleTestController.class);

	@Autowired
	RestSampleTestDao restSampleTestDao;
	
	@RequestMapping(value = "rest-qaTestDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> qaRequestDtls(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :qaTestDtls start");

		logger.info("Method :qaTestDtls endss");
		return restSampleTestDao.qaTestDtls(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-qaChildDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> qaChildDtls(@RequestParam String rid,@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :qaChildDtls start");

		logger.info("Method :qaChildDtls endss");
		return restSampleTestDao.qaRequestDtls(rid,id, orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-testResultSubmit", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> testResultSubmit(@RequestBody RestSampleTestModel data) {
		logger.info("Method :testResultSubmittttt start");
		
		logger.info("Method :testResultSubmit endss");
		return restSampleTestDao.testResultSubmit(data);
	}
	
	@RequestMapping(value = "rest-testApprove", method = { RequestMethod.GET })
	public JsonResponse<Object> testApproveSet(@RequestParam String id, String sku) {
		logger.info("Method :testResultSubmittttt start",id);
		System.out.println(id);
		logger.info("Method :testResultSubmit endss");
		return restSampleTestDao.testApproveSet(id , sku);

	}
	
	

}
