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
import nirmalya.aatithya.restmodule.qa.dao.RestVb2arDao;
import nirmalya.aatithya.restmodule.qa.model.RestVbarModel;

@RestController
@RequestMapping(value = { "qa/" })
public class RestVb2arController {
	Logger logger = LoggerFactory.getLogger(RestVb2arController.class);

	@Autowired
	RestVb2arDao restVb2arDao;
	
	@PostMapping(value = "saveVb2arData")
	public ResponseEntity<JsonResponse<List<RestVbarModel>>> saveVb2arData(
			@RequestBody List<RestVbarModel> restVbarModel) {
		logger.info("Method :saveVb2arData starts");

		logger.info("Method :saveVb2arData endss");
		return restVb2arDao.saveVb2arData(restVbarModel);
	}
	
	@RequestMapping(value = "viewVb2arData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewVb2arData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewVb2arData start");

		logger.info("Method :viewVb2arData endss");
		return restVb2arDao.viewVb2arData(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-editVb2arData", method = { RequestMethod.GET })
	public JsonResponse <Object> editVb2arData(@RequestParam String vb1arId, String org,
			 String orgDiv) {
		logger.info("Method :editVb2arData start");

		logger.info("Method :editVb2arData endss");
		return restVb2arDao.editVb2arData(vb1arId,org, orgDiv);

	}
	
	@RequestMapping(value = "rest-approvevb2ardata", method = { RequestMethod.GET })
	public JsonResponse<Object> approvevb2ardata(@RequestParam String vb1arId, String org,String orgDiv) {
		logger.info("Method :approvevb2ardata start");

		logger.info("Method :approvevb2ardata endss");
		return restVb2arDao.approvevb2ardata(vb1arId,org, orgDiv);
	}
	
	@RequestMapping(value = "rest-deletevb2ardata", method = { RequestMethod.GET })
	public JsonResponse<Object> deletevb2ardata(@RequestParam String vb1arId, String org,String orgDiv) {
		logger.info("Method :deletevb2ardata start");

		logger.info("Method :deletevb2ardata endss");
		return restVb2arDao.deletevb2ardata(vb1arId,org, orgDiv);
	}
//
	@RequestMapping(value = "rest-vitaminB2Pdf", method = { RequestMethod.GET })
	public JsonResponse<Object> vitaminB2Pdf(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :vitaminB2Pdf start");

		logger.info("Method :vitaminB2Pdf endss");
		return restVb2arDao.vitaminB2Pdf(id,orgName,orgDivision);

	}
}
