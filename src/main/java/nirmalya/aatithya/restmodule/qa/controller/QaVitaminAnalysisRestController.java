package nirmalya.aatithya.restmodule.qa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.qa.dao.VitaminAnalysisDao;
import nirmalya.aatithya.restmodule.qa.model.RestVitAModel;

@RestController
@RequestMapping(value = { "qa/" })
public class QaVitaminAnalysisRestController {
	Logger logger = LoggerFactory.getLogger(RestVbarController.class);

	@Autowired
	VitaminAnalysisDao restVitADao;
	
	@PostMapping(value = "rest-saveVitAData")
	public ResponseEntity<JsonResponse<List<RestVitAModel>>> saveVitAData(
			@RequestBody List<RestVitAModel> vitamin) {
		logger.info("Method :saveVitAData starts");

		logger.info("Method :saveVitAData endss");
		return restVitADao.saveVitAData(vitamin);
	}
	@RequestMapping(value = "rest-viewVitAData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewVitAData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewVitAData start");

		logger.info("Method : endss");
		return restVitADao.viewVitAData(orgName, orgDivision);

	}
	@RequestMapping(value = "rest-editVitAData", method = { RequestMethod.GET })
	public JsonResponse<Object> editVitAData(@RequestParam String id, @RequestParam String orgName, String orgDivision) {
		logger.info("Method :editVitAData start");

		logger.info("Method : editVitAData endss");
		return restVitADao.editVitAData(id, orgName, orgDivision);

	}
	@RequestMapping(value = "rest-approvevitAata", method = { RequestMethod.GET })
	public JsonResponse<Object> approvevitAata(@RequestParam String vitAData, String org,String orgDiv) {
		logger.info("Method :approvevitAata start");

		logger.info("Method :approvevitAata endss");
		return restVitADao.approvevitAata(vitAData,org, orgDiv);
	}
	@RequestMapping(value = "rest-deleteVitAData", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteVitAData(@RequestParam String vitAData, String org,String orgDiv) {
		logger.info("Method :deleteVitAData start");

		logger.info("Method :deleteVitAData endss");
		return restVitADao.deleteVitAData(vitAData,org, orgDiv);
	}
//
	//PDF
		@RequestMapping(value = "rest-vitAanalysisRecordPdf", method = { RequestMethod.GET })
		public JsonResponse<Object> vitAanalysisRecordPdf(@RequestParam String id,String orgName, String orgDivision) {
			logger.info("Method :vitAanalysisRecordPdf start");

			logger.info("Method :vitAanalysisRecordPdf endss");
			return restVitADao.vitAanalysisRecordPdf(id,orgName,orgDivision);

		}
}
