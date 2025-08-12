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
import nirmalya.aatithya.restmodule.qa.dao.RtmrRecordDao;
import nirmalya.aatithya.restmodule.qa.model.RtmrRecordModel;

@RestController
@RequestMapping(value = { "qa/" })
public class RestRtmrRecordController {
	Logger logger = LoggerFactory.getLogger(RestRtmrRecordController.class);

	@Autowired
	RtmrRecordDao rtmrRecordDao;
	
	@PostMapping(value = "saveRtmrData")
	public ResponseEntity<JsonResponse<List<RtmrRecordModel>>> saveRtmrData(
			@RequestBody List<RtmrRecordModel> rtmrRecordModel) {
		logger.info("Method :saveRtmrData starts");

		logger.info("Method :saveRtmrData endss");
		return rtmrRecordDao.saveRtmrData(rtmrRecordModel);
	}
	
	@RequestMapping(value = "viewRtmrData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRtmrData(@RequestParam String orgName, String orgDivision, String type) {
		logger.info("Method :viewRtmrData start");

		logger.info("Method :viewRtmrData endss");
		return rtmrRecordDao.viewRtmrData(orgName, orgDivision, type);

	}
	@RequestMapping(value = "rest-editRtmrData", method = { RequestMethod.GET })
	public JsonResponse <Object> editRtmrData(@RequestParam String rtmrId, String org,
			 String orgDiv) {
		logger.info("Method :editRtmrData start");

		logger.info("Method :editRtmrData endss");
		return rtmrRecordDao.editRtmrData(rtmrId,org, orgDiv);

	}
	
	@RequestMapping(value = "rest-deleteRtmrdata", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteRtmrdata(@RequestParam String rtmrId, String org,String orgDiv) {
		logger.info("Method :deleteRtmrdata start");

		logger.info("Method :deleteRtmrdata endss");
		return rtmrRecordDao.deleteRtmrdata(rtmrId,org, orgDiv);
	}
	
	@RequestMapping(value = "rest-approveRtmrdata", method = { RequestMethod.GET })
	public JsonResponse<Object> approveRtmrdata(@RequestParam String rtmrId, String org,String orgDiv) {
		logger.info("Method :approveRtmrdata start");

		logger.info("Method :approveRtmrdata endss");
		return rtmrRecordDao.approveRtmrdata(rtmrId,org, orgDiv);
	}
	
	
	// Pdf
	
	
	@RequestMapping(value = "rest-pdfRtmrPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> pdfRtmrPdf(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :pdfRtmrPdf start");

		logger.info("Method :pdfRtmrPdf endss");
		return rtmrRecordDao.pdfRtmrPdf(id, orgName, orgDivision);
	}

}
