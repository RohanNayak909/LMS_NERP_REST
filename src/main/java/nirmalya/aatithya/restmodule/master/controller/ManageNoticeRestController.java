package nirmalya.aatithya.restmodule.master.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.ManageNoticeDao;
import nirmalya.aatithya.restmodule.master.model.ManageNoticeRestModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master/")
public class ManageNoticeRestController {

	Logger logger = LoggerFactory.getLogger(ManageNoticeRestController.class);

	@Autowired
	ManageNoticeDao manageNoticeDao;

	// Publish Notice By Type

	@PostMapping(value = "rest-publish-notice-dtls")
	public ResponseEntity<JsonResponse<Object>> publishNotice(@RequestBody ManageNoticeRestModel data) {
		logger.info("Method : publishNotice starts");

		logger.info("Method : publishNotice ends");
		return manageNoticeDao.publishNotice(data);
	}

	@GetMapping(value = "rest-get-all-notice")
	public JsonResponse<Object> getAllNotice(@RequestParam String userId, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getAllNotice starts");

		logger.info("Method : getAllNotice ends");
		return manageNoticeDao.getAllNotice(org, orgDiv, userId);
	}

	@GetMapping(value = "rest-notice-edit")
	public JsonResponse<Object> getPublishNoticeEdit(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String id) {
		logger.info("Method : getPublishNoticeEdit starts");

		logger.info("Method : getPublishNoticeEdit ends");
		return manageNoticeDao.getPublishNoticeEdit(org, orgDiv, id);
	}

	// Delete Notice
	@GetMapping(value = "rest-delete-notice")
	public JsonResponse<Object> deleteNotice(@RequestParam String org, String orgDiv, String userId, String id) {
		logger.info("Method : deleteNotice starts");

		logger.info("Method : deleteNotice ends");
		return manageNoticeDao.deleteNotice(org, orgDiv, userId, id);
	}
	
	@GetMapping(value = "get-pdf-details-notice")
	public JsonResponse<Object> fetchPdfDetails(@RequestParam String id,String organization,String orgDivision,String userId) {
		logger.info("Method : fetchPdfDetails starts");

		logger.info("Method : fetchPdfDetails ends");
		return manageNoticeDao.fetchPdfDetails(id, organization, orgDivision,userId);
	}
	
}
