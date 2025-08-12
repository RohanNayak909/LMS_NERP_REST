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
import nirmalya.aatithya.restmodule.qa.dao.HorlicksAnalysisRecordRestDao;
import nirmalya.aatithya.restmodule.qa.dao.RmPmReleaseStatusDao;
import nirmalya.aatithya.restmodule.qa.model.HorlicksAnalysisRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestRmPmReleaseStatusModel;


	@RestController
	@RequestMapping(value = { "qa/" })
	public class HorlicksAnalysisRecordRestController {
		Logger logger = LoggerFactory.getLogger(HorlicksAnalysisRecordRestController.class);

		@Autowired
		HorlicksAnalysisRecordRestDao horlicksAnalysisRecordRestDao;
		
		@RequestMapping(value = "horlicksAnalysisView", method = { RequestMethod.GET })
		public JsonResponse<Object> horlicksAnalysisView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :horlicksAnalysisView start");

		logger.info("Method :horlicksAnalysisView endss");
		return horlicksAnalysisRecordRestDao.horlicksAnalysisView(orgName, orgDivision);

	}
//ADD
		@PostMapping(value = "rest-addhorlicksAnalysis")
		public ResponseEntity<JsonResponse<List<HorlicksAnalysisRestModel>>> addhorlicks(

				@RequestBody List<HorlicksAnalysisRestModel> horlicksAnalysisRestModel) {
			logger.info("Method : addhorlicks starts"+horlicksAnalysisRestModel);
			logger.info("Method : addhorlicks ends");
			return horlicksAnalysisRecordRestDao.addhorlicks(horlicksAnalysisRestModel);
		}
//EDIT
		@RequestMapping(value = "rest-editHorlicks", method = { RequestMethod.GET })
		public JsonResponse <Object> editHorlicks(@RequestParam String horlicksId, String org,
				 String orgDiv) {
			logger.info("Method :editHorlicks start");

			logger.info("Method :editHorlicks endss");
			return horlicksAnalysisRecordRestDao.editHorlicks(horlicksId,org, orgDiv);

		}
//Delete
		@RequestMapping(value = "rest-deleteHorlicks", method = { RequestMethod.GET })
		public JsonResponse<Object> deleteHorlicks(@RequestParam String id, String org,String orgDiv) {
			logger.info("Method :deleteHorlicks start");

			logger.info("Method :deleteHorlicks endss");
			return horlicksAnalysisRecordRestDao.deleteHorlicks(id,org, orgDiv);
		}
//Approve
		@RequestMapping(value = "rest-approveHorlicksData", method = { RequestMethod.GET })
		public JsonResponse<Object> approveHorlicksData(@RequestParam String id, String org,String orgDiv) {
			logger.info("Method :approveHorlicksData start");

			logger.info("Method :approveHorlicksData endss");
			return horlicksAnalysisRecordRestDao.approveHorlicksData(id,org, orgDiv);
		}
//
		@RequestMapping(value = "rest-horlicsAnalysisPdf", method = { RequestMethod.GET })
		public JsonResponse<Object> horlicsAnalysisPdf(@RequestParam String id,String orgName, String orgDivision) {
			logger.info("Method :horlicsAnalysisPdf start");

			logger.info("Method :horlicsAnalysisPdf endss");
			return horlicksAnalysisRecordRestDao.horlicsAnalysisPdf(id,orgName,orgDivision);

		}
}
