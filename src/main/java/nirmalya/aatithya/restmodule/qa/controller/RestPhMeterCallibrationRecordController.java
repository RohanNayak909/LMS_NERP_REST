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
import nirmalya.aatithya.restmodule.qa.dao.PhMeterCallibrationRecordDao;
import nirmalya.aatithya.restmodule.qa.model.RestPhMeterCallibrationRecordModel;
import nirmalya.aatithya.restmodule.qa.model.RestRmPmReleaseStatusModel;

@RestController
@RequestMapping(value = { "qa/" })
public class RestPhMeterCallibrationRecordController {
	Logger logger = LoggerFactory.getLogger(RestPhMeterCallibrationRecordController.class);

	@Autowired
	PhMeterCallibrationRecordDao phMeterCallibrationRecordDao;
	
	@PostMapping(value = "rest-addPhDetails")
	public ResponseEntity<JsonResponse<List<RestPhMeterCallibrationRecordModel>>> addPhDetails(

			@RequestBody List<RestPhMeterCallibrationRecordModel> restPhMeterCallibrationRecordModel) {
		logger.info("Method : addPhDetails starts");
		logger.info("Method : addPhDetails ends");
		return phMeterCallibrationRecordDao.addPhDetails(restPhMeterCallibrationRecordModel);
	}
	
	@RequestMapping(value = "viewPhData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPhData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewPhData start");

		logger.info("Method :viewPhData endss");
		return phMeterCallibrationRecordDao.viewPhData(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-editPhData", method = { RequestMethod.GET })
	public JsonResponse <Object> editPhData(@RequestParam String phId, String org,
			 String orgDiv) {
		logger.info("Method :editPhData start");

		logger.info("Method :editPhData endss");
		return phMeterCallibrationRecordDao.editPhData(phId,org, orgDiv);

	}
	@RequestMapping(value = "rest-approvePhdata", method = { RequestMethod.GET })
	public JsonResponse<Object> approvePhdata(@RequestParam String phId, String org,String orgDiv) {
		logger.info("Method :approvePhdata start");

		logger.info("Method :approvePhdata endss");
		return phMeterCallibrationRecordDao.approvePhdata(phId,org, orgDiv);
	}
	
	@RequestMapping(value = "rest-deletePhReport", method = { RequestMethod.GET })
	public JsonResponse<Object> deletePhReport(@RequestParam String phId, String org,String orgDiv) {
		logger.info("Method :deletePhReport start");

		logger.info("Method :deletePhReport endss");
		return phMeterCallibrationRecordDao.deletePhReport(phId,org, orgDiv);
	}
	//PDF
		@RequestMapping(value = "rest-phMeterPdf", method = { RequestMethod.GET })
		public JsonResponse<Object> phMeterPdf(@RequestParam String id,String orgName, String orgDivision) {
			logger.info("Method :phMeterPdf start");

			logger.info("Method :phMeterPdf endss");
			return phMeterCallibrationRecordDao.phMeterPdf(id,orgName,orgDivision);

		}
}
