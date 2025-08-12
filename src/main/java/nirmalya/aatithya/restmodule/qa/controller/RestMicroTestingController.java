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
import nirmalya.aatithya.restmodule.qa.dao.MicroTestingDao;
import nirmalya.aatithya.restmodule.qa.model.MicroTestingModel;
import nirmalya.aatithya.restmodule.sales.model.RestQuotationNewModel;

@RestController
@RequestMapping(value = { "qa/" })
public class RestMicroTestingController {
	Logger logger = LoggerFactory.getLogger(RestMicroTestingController.class);

	@Autowired
	MicroTestingDao microTestingDao;
	
	@PostMapping(value = "saveAllMtData")
	public ResponseEntity<JsonResponse<List<MicroTestingModel>>> saveAllMtData(
			@RequestBody List<MicroTestingModel> microTestingModel) {
		logger.info("Method :saveAllMtData starts");

		logger.info("Method :saveAllMtData endss");
		return microTestingDao.saveAllMtData(microTestingModel);
	}
	
	@RequestMapping(value = "viewMtData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewMtData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewMtData start");

		logger.info("Method :viewMtData endss");
		return microTestingDao.viewMtData(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-editMtData", method = { RequestMethod.GET })
	public JsonResponse <Object> editMtData(@RequestParam String mictotestingId, String org,
			 String orgDiv) {
		logger.info("Method :editMtData start");

		logger.info("Method :editMtData endss");
		return microTestingDao.editMtData(mictotestingId,org, orgDiv);

	}
	
	@RequestMapping(value = "rest-deleteMtdata", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteMtdata(@RequestParam String mictotestingId, String org,String orgDiv) {
		logger.info("Method :deleteMtdata start");

		logger.info("Method :deleteMtdata endss");
		return microTestingDao.deleteMtdata(mictotestingId,org, orgDiv);
	}
	
	@RequestMapping(value = "rest-approveMtdata", method = { RequestMethod.GET })
	public JsonResponse<Object> approveMtdata(@RequestParam String mictotestingId, String org,String orgDiv) {
		logger.info("Method :approveMtdata start");

		logger.info("Method :approveMtdata endss");
		return microTestingDao.approveMtdata(mictotestingId,org, orgDiv);
	}
//PDF
	@RequestMapping(value = "rest-mtPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> mtPdf(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :mtPdf start");

		logger.info("Method :mtPdf endss");
		return microTestingDao.mtPdf(id,orgName,orgDivision);

	}
}
