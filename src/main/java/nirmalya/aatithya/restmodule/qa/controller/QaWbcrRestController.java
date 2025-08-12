package nirmalya.aatithya.restmodule.qa.controller;

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
import nirmalya.aatithya.restmodule.qa.dao.QaWbcrDao;
import nirmalya.aatithya.restmodule.qa.model.RestQaWbcrModel;


@RestController
@RequestMapping(value = { "production/" })
public class QaWbcrRestController {
	
	Logger logger = LoggerFactory.getLogger(QaWbcrRestController.class);
	
	@Autowired
	QaWbcrDao qaWbcrDao;
	
	
	@RequestMapping(value = "rest-getWbcrAgGridView", method = { RequestMethod.GET })
	public JsonResponse<Object> getAgGridView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getAgGridView start");

		logger.info("Method :getAgGridView endss");
		return qaWbcrDao.getAgGridView(orgName, orgDivision);
	}
	

	// add

	@PostMapping(value = "rest-addWbcr")
	public ResponseEntity<JsonResponse<RestQaWbcrModel>> addWbcr(

			@RequestBody RestQaWbcrModel restQaWbcrModel) {
		logger.info("Method : addWbcr starts");
		logger.info("Method : addWbcr ends");
		return qaWbcrDao.addWbcr(restQaWbcrModel);
	}
	
	// View

	@RequestMapping(value = "rest-getWbcrView", method = { RequestMethod.GET })
	public JsonResponse<Object> getWbcrView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :getWbcrView start");

		logger.info("Method :getWbcrView endss");
		return qaWbcrDao.getWbcrView(orgName, orgDivision);
	}
	

	// Edit

	@RequestMapping(value = "rest-editWbcr", method = { RequestMethod.GET })
	public JsonResponse<Object> editWbcr(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editWbcr start");

		logger.info("Method :editWbcr endss");
		return qaWbcrDao.editWbcr(id, orgName, orgDivision);
	}
	

	// Delete.

	@RequestMapping(value = "rest-deleteWbcr", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteWbcr(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :deleteWbcr start");

		logger.info("Method :deleteWbcr endss");
		return qaWbcrDao.deleteWbcr(id, orgName, orgDivision);
	}

	// Approve.

	@RequestMapping(value = "rest-approveWbcr", method = { RequestMethod.GET })
	public JsonResponse<Object> approveWbcr(@RequestParam String id, String orgName, String orgDivision,
			String approvedBy) {
		logger.info("Method :rest-approveWbcr start");

		logger.info("Method :approveWbcr endss");
		return qaWbcrDao.approveWbcr(id, orgName, orgDivision, approvedBy);
	}
	
	
	//Download Pdf WBCR
	@RequestMapping(value = "rest-downloadWbcrPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> downloadWbcrPdf(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :downloadWbcrPdf start");

		logger.info("Method :downloadWbcrPdf endss");
		return qaWbcrDao.downloadWbcrPdf(id, orgName, orgDivision);
	}

	

}
