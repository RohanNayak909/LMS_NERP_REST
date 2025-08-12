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
import nirmalya.aatithya.restmodule.qa.dao.MediaDecontaminationRecordDao;
import nirmalya.aatithya.restmodule.qa.dao.RmPmReleaseStatusDao;
import nirmalya.aatithya.restmodule.qa.model.MediaDecontaminationRecordModel;
import nirmalya.aatithya.restmodule.qa.model.RestRmPmReleaseStatusModel;


@RestController
@RequestMapping(value = { "qa/" })
public class RestMediaDecontaminationRecordController {
	Logger logger = LoggerFactory.getLogger(RestMediaDecontaminationRecordController.class);

	@Autowired
	MediaDecontaminationRecordDao mediaDecontaminationRecordDao;
	
	@PostMapping(value = "rest-addMedia")
	public ResponseEntity<JsonResponse<List<MediaDecontaminationRecordModel>>> addMedia(

			@RequestBody List<MediaDecontaminationRecordModel> mediaDecontaminationRecordModel) {
		logger.info("Method : addMedia starts");
		logger.info("Method : addMedia ends");
		return mediaDecontaminationRecordDao.addMedia(mediaDecontaminationRecordModel);
	}
	@RequestMapping(value = "viewMediaData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewMediaData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewMediaData start");

		logger.info("Method :viewMediaData endss");
		return mediaDecontaminationRecordDao.viewMediaData(orgName, orgDivision);

	}
	
	@RequestMapping(value = "rest-editMedia", method = { RequestMethod.GET })
	public JsonResponse <Object> editMedia(@RequestParam String mediaId, String org,
			 String orgDiv) {
		logger.info("Method :editMedia start");

		logger.info("Method :editMedia endss");
		return mediaDecontaminationRecordDao.editMedia(mediaId,org, orgDiv);

	}
	
	
	@RequestMapping(value = "rest-approveMedia", method = { RequestMethod.GET })
	public JsonResponse<Object> approveMedia(@RequestParam String mediaId, String org,String orgDiv) {
		logger.info("Method :approveMedia start");

		logger.info("Method :approveMedia endss");
		return mediaDecontaminationRecordDao.approveMedia(mediaId,org, orgDiv);
	}
	
	@RequestMapping(value = "rest-deleteMedia", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteMedia(@RequestParam String mediaId, String org,String orgDiv) {
		logger.info("Method :deleteMedia start");

		logger.info("Method :deleteMedia endss");
		return mediaDecontaminationRecordDao.deleteMedia(mediaId,org, orgDiv);
	}
	//PDF
	@RequestMapping(value = "rest-mediaPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> mediaPdf(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method :mediaPdf start");

		logger.info("Method :mediaPdf endss");
		return mediaDecontaminationRecordDao.mediaPdf(id,orgName,orgDivision);

	}	
}
