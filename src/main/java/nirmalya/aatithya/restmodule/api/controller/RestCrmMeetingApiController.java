package nirmalya.aatithya.restmodule.api.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;

import nirmalya.aatithya.restmodule.api.dao.RestCrmApiMeetingDao;
import nirmalya.aatithya.restmodule.api.model.RestCrmApiMeetingModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.util.DocumentUpload;

@RestController
@RequestMapping(value = "api")
public class RestCrmMeetingApiController {

	@Autowired
	RestCrmApiMeetingDao restCrmApiMeetingDao;

	@Autowired
	EnvironmentVaribles env;

	@Autowired
	DocumentUpload documentUpload;

	Logger logger = LoggerFactory.getLogger(RestCrmMeetingApiController.class);

	//saveAllDocuments
	public String saveAllDocuments(byte[] imageBytes, String ext, String pId) {
		logger.info("Method : saveAllDocuments starts");

		String imageName = null;
		logger.info("ext===" + ext);
		try {

			if (imageBytes != null) {
				long nowTime = new Date().getTime();

				if (ext.contentEquals("jpeg") || ext.contentEquals("jpg")) {
					imageName = pId + "_" + nowTime + ".jpg";
				} else if (ext.contentEquals("png")) {
					imageName = pId + "_" + nowTime + ".png";
				} else {
					imageName = pId + "_" + nowTime + "." + ext;
				}
			}

			Path path = Paths.get(env.getFileUploadCRM() + imageName);
			if (imageBytes != null) {
				if (pId != null && pId != "") {
					Files.write(path, imageBytes);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : saveAllDocuments ends");
		return imageName;
	}
	
	@RequestMapping(value = "/getLeadContactList", method = { RequestMethod.GET })
	public List<DropDownModel> getLeadContactList() {
		logger.info("Method : getLeadContactList starts");

		logger.info("Method : getLeadContactList end");
		return restCrmApiMeetingDao.getLeadContactList();
	}

	// add

	@RequestMapping(value = "addCrmMeetingMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addCrmMeetingMaster(@RequestBody RestCrmApiMeetingModel meeting) {
		logger.info("Method : addCrmMeetingMaster starts");

		logger.info("Method : addCrmMeetingMaster ends");
		return restCrmApiMeetingDao.addCrmMeetingMaster(meeting);
	}

	//view

	@GetMapping(value = "viewCrmMeetingMaster")
	public JsonResponse<List<RestCrmApiMeetingModel>> viewCrmMeetingMaster(@RequestParam String createdBy,String organization, String orgDivision) {
		logger.info("Method : viewCrmMeetingMaster");

		logger.info("Method : viewCrmMeetingMaster ends");
		return restCrmApiMeetingDao.viewCrmMeetingMaster(createdBy,organization,orgDivision);
	}
 
	// add check in
	@PostMapping(value = "checkInCrmMeetingMaster-api", headers = "content-type=multipart/*", consumes = { "application/*" })
	public ResponseEntity<JsonResponse<Object>> checkInCrmMeetingMasterApi(RestCrmApiMeetingModel meeting) {
		logger.info("Method : checkInCrmMeetingMasterApi starts");

		MultipartFile x = meeting.getMulFile();
		String fileName = null;
		if (x != null && !meeting.getExtension().equals("") && !meeting.getExtension().equals("null") && !meeting.getExtension().equals(null)) {
			byte[] bytes = null;
			try {
				bytes = x.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileName = saveAllDocuments(bytes, meeting.getExtension(), meeting.getMeetingCreatedBy());
		}
		meeting.setCheckImg(fileName);
		logger.info("Method : checkInCrmMeetingMasterApi ends");
		return restCrmApiMeetingDao.checkInCrmMeetingMaster(meeting);
	}
	
	@RequestMapping(value = "checkInCrmMeetingMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> checkInCrmMeetingMaster(
			@RequestBody RestCrmApiMeetingModel meeting) {
		logger.info("Method : checkInCrmMeetingMaster starts");

		logger.info("Method : checkInCrmMeetingMaster ends");
		return restCrmApiMeetingDao.checkInCrmMeetingMaster(meeting);
	}
	//check in history
	@GetMapping(value = "viewCrmMeeting-visitHistory")
	public JsonResponse<List<RestCrmApiMeetingModel>> viewCrmMeetingvisitHistory(@RequestParam String createdBy,String organization, String orgDivision) {
		logger.info("Method : viewCrmMeetingvisitHistory");

		logger.info("Method : viewCrmMeetingvisitHistory ends");
		return restCrmApiMeetingDao.viewCrmMeetingvisitHistory(createdBy,organization,orgDivision);
	}
	//check in history report
	@GetMapping(value = "viewCrmMeeting-visitHistoryReport")
	public JsonResponse<List<RestCrmApiMeetingModel>> viewCrmMeetingvisitHistoryReport(@RequestParam String userId,String organization, String orgDivision,
			String fromDate,String toDate){
		logger.info("Method : viewCrmMeetingvisitHistoryReport");
		
		logger.info("Method : viewCrmMeetingvisitHistoryReport ends");
		return restCrmApiMeetingDao.viewCrmMeetingvisitHistoryReport(userId,organization,orgDivision,fromDate,toDate);
	}
	//check in history report search
	@GetMapping(value = "viewCrmMeeting-visitHistoryReportSearch")
	public JsonResponse<List<RestCrmApiMeetingModel>> viewCrmMeetingvisitHistoryReportSearch(@RequestParam String userId,String organization, String orgDivision,
			String fromDate,String toDate,String customer,String saleTeam){
		logger.info("Method : viewCrmMeetingvisitHistoryReportSearch");
		
		logger.info("Method : viewCrmMeetingvisitHistoryReportSearch ends");
		return restCrmApiMeetingDao.viewCrmMeetingvisitHistoryReportSearch(userId,organization,orgDivision,fromDate,toDate,customer,saleTeam);
	}
	//delete meeting
	@GetMapping(value = "delete-crmMeetingMaster")
	public ResponseEntity<JsonResponse<Object>> deleteCrmMeetingMaster(@RequestParam String meetingid,String organization, String orgDivision) {
		logger.info("Method : deleteCrmMeetingMaster starts");
		
		logger.info("Method : deleteCrmMeetingMaster ends");
		return restCrmApiMeetingDao.deleteCrmMeetingMaster(meetingid, organization, orgDivision);
	}

}
