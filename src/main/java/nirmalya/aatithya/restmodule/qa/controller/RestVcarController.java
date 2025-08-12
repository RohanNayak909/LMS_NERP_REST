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
import nirmalya.aatithya.restmodule.qa.dao.RestVcarDao;
import nirmalya.aatithya.restmodule.qa.model.RestVbarModel;

@RestController
@RequestMapping(value = { "qa/" })
public class RestVcarController {
	Logger logger = LoggerFactory.getLogger(RestVcarController.class);

	@Autowired
	RestVcarDao restVcarDao;
	
	@PostMapping(value = "saveVcarData")
	public ResponseEntity<JsonResponse<List<RestVbarModel>>> saveVcarData(
			@RequestBody List<RestVbarModel> restVbarModel) {
		logger.info("Method :saveVcarData starts");

		logger.info("Method :saveVcarData endss");
		return restVcarDao.saveVcarData(restVbarModel);
	}
	
	@RequestMapping(value = "viewVcarData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewVcarData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewVcarData start");

		logger.info("Method :viewVcarData endss");
		return restVcarDao.viewVcarData(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-editVcarData", method = { RequestMethod.GET })
	public JsonResponse <Object> editVcarData(@RequestParam String vbcarId, String org,
			 String orgDiv) {
		logger.info("Method :editVcarData start");

		logger.info("Method :editVcarData endss");
		return restVcarDao.editVcarData(vbcarId,org, orgDiv);

	}
	
	@RequestMapping(value = "rest-approvevcardata", method = { RequestMethod.GET })
	public JsonResponse<Object> approvevcardata(@RequestParam String vbcarId, String org,String orgDiv) {
		logger.info("Method :approvevcardata start");

		logger.info("Method :approvevcardata endss");
		return restVcarDao.approvevcardata(vbcarId,org, orgDiv);
	}
	
	@RequestMapping(value = "rest-deletevcardata", method = { RequestMethod.GET })
	public JsonResponse<Object> deletevcardata(@RequestParam String vbcarId, String org,String orgDiv) {
		logger.info("Method :deletevcardata start");

		logger.info("Method :deletevcardata endss");
		return restVcarDao.deletevcardata(vbcarId,org, orgDiv);
	}
//PDF
	@RequestMapping(value = "rest-vitaminCPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> viewVitaminCPdf(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :viewVitaminCPdf start");

		logger.info("Method :viewVitaminCPdf endss");
		return restVcarDao.viewVitaminCPdf(id,orgName,orgDivision);

	}
	
}
