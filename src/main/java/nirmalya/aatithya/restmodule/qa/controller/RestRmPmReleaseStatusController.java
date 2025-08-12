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
import nirmalya.aatithya.restmodule.qa.dao.RmPmReleaseStatusDao;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestRmPmReleaseStatusModel;

@RestController
@RequestMapping(value = { "qa/" })
public class RestRmPmReleaseStatusController {
	Logger logger = LoggerFactory.getLogger(RestRmPmReleaseStatusController.class);

	@Autowired
	RmPmReleaseStatusDao rmPmReleaseStatusDao;
	
	@PostMapping(value = "rest-addrmpm")
	public ResponseEntity<JsonResponse<List<RestRmPmReleaseStatusModel>>> addrmpm(

			@RequestBody List<RestRmPmReleaseStatusModel> restRmPmReleaseStatusModel) {
		logger.info("Method : addrmpm starts"+restRmPmReleaseStatusModel);
		logger.info("Method : addrmpm ends");
		return rmPmReleaseStatusDao.addrmpm(restRmPmReleaseStatusModel);
	}
	
	@RequestMapping(value = "viewRmpmData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRmpmData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewRmpmData start");

		logger.info("Method :viewRmpmData endss");
		return rmPmReleaseStatusDao.viewRmpmData(orgName, orgDivision);

	}
	

	@RequestMapping(value = "rest-editRmpmData", method = { RequestMethod.GET })
	public JsonResponse <Object> editRmpmData(@RequestParam String rmPmId, String org,
			 String orgDiv) {
		logger.info("Method :editRmpmData start");

		logger.info("Method :editRmpmData endss");
		return rmPmReleaseStatusDao.editRmpmData(rmPmId,org, orgDiv);

	}
	
	@RequestMapping(value = "rest-approveRmpmdata", method = { RequestMethod.GET })
	public JsonResponse<Object> approveRmpmdata(@RequestParam String rmPmId, String org,String orgDiv) {
		logger.info("Method :approveRmpmdata start");

		logger.info("Method :approveRmpmdata endss");
		return rmPmReleaseStatusDao.approveRmpmdata(rmPmId,org, orgDiv);
	}
	
	@RequestMapping(value = "rest-deleteRmpmdata", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteRmpmdata(@RequestParam String rmPmId, String org,String orgDiv) {
		logger.info("Method :deleteRmpmdata start");

		logger.info("Method :deleteRmpmdata endss");
		return rmPmReleaseStatusDao.deleteRmpmdata(rmPmId,org, orgDiv);
	}
//PDF
	@RequestMapping(value = "rest-rmpmPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> rmpmPdf(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :rmpmPdf start");

		logger.info("Method :rmpmPdf endss");
		return rmPmReleaseStatusDao.rmpmPdf(id,orgName,orgDivision);

	}
}
