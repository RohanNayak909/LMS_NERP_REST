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
import nirmalya.aatithya.restmodule.qa.dao.RestVbarDao;
import nirmalya.aatithya.restmodule.qa.model.LtmrRecordModel;
import nirmalya.aatithya.restmodule.qa.model.RestVbarModel;

@RestController
@RequestMapping(value = { "qa/" })
public class RestVbarController {
	Logger logger = LoggerFactory.getLogger(RestVbarController.class);

	@Autowired
	RestVbarDao restVbarDao;
	
	@PostMapping(value = "saveVb1arData")
	public ResponseEntity<JsonResponse<List<RestVbarModel>>> saveVb1arData(
			@RequestBody List<RestVbarModel> restVbarModel) {
		logger.info("Method :saveVb1arData starts");

		logger.info("Method :saveVb1arData endss");
		return restVbarDao.saveVb1arData(restVbarModel);
	}
	
	@RequestMapping(value = "viewVb1arData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewVb1arData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewVb1arData start");

		logger.info("Method :viewVb1arData endss");
		return restVbarDao.viewVb1arData(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-editVb1arData", method = { RequestMethod.GET })
	public JsonResponse <Object> editVb1arData(@RequestParam String vb1arId, String org,
			 String orgDiv) {
		logger.info("Method :editVb1arData start");

		logger.info("Method :editVb1arData endss");
		return restVbarDao.editVb1arData(vb1arId,org, orgDiv);

	}
	
	@RequestMapping(value = "rest-approvevb1ardata", method = { RequestMethod.GET })
	public JsonResponse<Object> approvevb1ardata(@RequestParam String vb1arId, String org,String orgDiv) {
		logger.info("Method :approvevb1ardata start");

		logger.info("Method :approvevb1ardata endss");
		return restVbarDao.approvevb1ardata(vb1arId,org, orgDiv);
	}
	
	@RequestMapping(value = "rest-deletevb1ardata", method = { RequestMethod.GET })
	public JsonResponse<Object> deletevb1ardata(@RequestParam String vb1arId, String org,String orgDiv) {
		logger.info("Method :deletevb1ardata start");

		logger.info("Method :deletevb1ardata endss");
		return restVbarDao.deletevb1ardata(vb1arId,org, orgDiv);
	}
//PDF
	
	@RequestMapping(value = "rest-vitaminB1Pdf", method = { RequestMethod.GET })
	public JsonResponse<Object> viewVitaminb1Pdf(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :viewVitaminb1Pdf start");

		logger.info("Method :viewVitaminb1Pdf endss");
		return restVbarDao.viewVitaminb1Pdf(id,orgName,orgDivision);

	}
	
	@RequestMapping(value = "rest-productList", method = { RequestMethod.GET })
	public JsonResponse<Object> productList(@RequestParam String type, String orgName, String orgDivision) {
		logger.info("Method :productList start");

		logger.info("Method :productList endss");
		return restVbarDao.productList(type, orgName, orgDivision);
	}
}
