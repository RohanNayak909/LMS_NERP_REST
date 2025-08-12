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
import nirmalya.aatithya.restmodule.qa.dao.LtmrRecordDao;
import nirmalya.aatithya.restmodule.qa.dao.RtmrRecordDao;
import nirmalya.aatithya.restmodule.qa.model.LtmrRecordModel;

@RestController
@RequestMapping(value = { "qa/" })
public class RestLtmrRecordController {
	Logger logger = LoggerFactory.getLogger(RestLtmrRecordController.class);

	@Autowired
	LtmrRecordDao ltmrRecordDao;
	
	@PostMapping(value = "saveLtmrData")
	public ResponseEntity<JsonResponse<List<LtmrRecordModel>>> saveRtmrData(
			@RequestBody List<LtmrRecordModel> ltmrRecordModel) {
		logger.info("Method :saveLtmrData starts");

		logger.info("Method :saveLtmrData endss");
		return ltmrRecordDao.saveLtmrData(ltmrRecordModel);
	}
	
	@RequestMapping(value = "viewLtmrData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewLtmrData(@RequestParam String orgName, String orgDivision, String type) {
		logger.info("Method :viewLtmrData start");

		logger.info("Method :viewLtmrData endss");
		return ltmrRecordDao.viewLtmrData(orgName, orgDivision, type);

	}
	
	@RequestMapping(value = "rest-editLtmrData", method = { RequestMethod.GET })
	public JsonResponse <Object> editLtmrData(@RequestParam String ltmrId, String org,
			 String orgDiv) {
		logger.info("Method :editLtmrData start");

		logger.info("Method :editLtmrData endss");
		return ltmrRecordDao.editLtmrData(ltmrId,org, orgDiv);

	}
	@RequestMapping(value = "rest-deleteLtmrdata", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteLtmrdata(@RequestParam String ltmrId, String org,String orgDiv) {
		logger.info("Method :deleteLtmrdata start");

		logger.info("Method :deleteLtmrdata endss");
		return ltmrRecordDao.deleteLtmrdata(ltmrId,org, orgDiv);
	}
	
	
	@RequestMapping(value = "rest-approveLtmrdata", method = { RequestMethod.GET })
	public JsonResponse<Object> approveLtmrdata(@RequestParam String ltmrId, String org,String orgDiv) {
		logger.info("Method :approveLtmrdata start");

		logger.info("Method :approveLtmrdata endss");
		return ltmrRecordDao.approveLtmrdata(ltmrId,org, orgDiv);
	}
	
	
	// Pdf
	
	
	@RequestMapping(value = "rest-pdfLtmrPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> pdfLtmrPdf(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :pdfLtmrPdf start");

		logger.info("Method :pdfLtmrPdf endss");
		return ltmrRecordDao.pdfLtmrPdf(id, orgName, orgDivision);
	}
}
