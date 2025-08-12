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
import nirmalya.aatithya.restmodule.qa.dao.QaWcrDao;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaWcrRestModel;


@RestController
@RequestMapping(value = { "production/" })
public class QaWcrRestController {
	
	Logger logger = LoggerFactory.getLogger(QaWcrRestController.class);

	@Autowired
	QaWcrDao qaWcrDao;
	
	// view WCR
		@RequestMapping(value = "rest-wcr-shift-slno", method = { RequestMethod.GET })
		public JsonResponse<Object> getShiftSlno(@RequestParam String orgName, String orgDivision) {
			logger.info("Method :getShiftSlno start");

			logger.info("Method :getShiftSlno endss");
			return qaWcrDao.getShiftSlno(orgName, orgDivision);
		}
		
		// add WCR
		@PostMapping(value = "rest-wcr-details-add")
		public ResponseEntity<JsonResponse<List<QaWcrRestModel>>> addWcr(

				@RequestBody List<QaWcrRestModel> qaWcrRestModel) {
			logger.info("Method : addWcr starts");
			logger.info("Method : addWcr ends");
			return qaWcrDao.addWcr(qaWcrRestModel);
		}
	
		// viewMain
				@RequestMapping(value = "rest-wcr-details-view", method = { RequestMethod.GET })
				public JsonResponse<Object> wcrView(@RequestParam String orgName, String orgDivision) {
					logger.info("Method :wcrView start");

					logger.info("Method :wcrView endss");
					return qaWcrDao.wcrView(orgName, orgDivision);
				}
		// editWcr
			@RequestMapping(value = "rest-wcr-reqst-edit", method = { RequestMethod.GET })
				public JsonResponse<Object> editWCR(@RequestParam String id, String orgName, String orgDivision) {
					logger.info("Method :editWCR start");

					logger.info("Method :editWCR endss");
					return qaWcrDao.editWCR(id, orgName, orgDivision);
				}
			
			
			// approveWcr
			@GetMapping(value = "rest-wcr-approve-data")
			public ResponseEntity<JsonResponse<Object>> approveWcr(@RequestParam String id, String userId , String org, String orgDiv) {
				logger.info("Method : approveWcr starts");

				logger.info("Method : approveWcr ends");
				return qaWcrDao.approveWcr(id, userId, org, orgDiv);

			}
			
			// Delete Wcr
			@GetMapping(value = "rest-wcr-detls-delete")
			public ResponseEntity<JsonResponse<Object>> deleteWcr(@RequestParam String id, String userId , String org, String orgDiv) {
				logger.info("Method : deleteWcr starts");

				logger.info("Method : deleteWcr ends");
				return qaWcrDao.deleteWcr(id, userId, org, orgDiv);

			}
			
			// downloadWcr
			@RequestMapping(value = "rest-wcr-reqst-download", method = { RequestMethod.GET })
				public JsonResponse<Object> downloadWcr(@RequestParam String id, String orgName, String orgDivision) {
					logger.info("Method :downloadWcr start");

					logger.info("Method :downloadWcr endss");
					return qaWcrDao.downloadWcr(id, orgName, orgDivision);
			}
}
