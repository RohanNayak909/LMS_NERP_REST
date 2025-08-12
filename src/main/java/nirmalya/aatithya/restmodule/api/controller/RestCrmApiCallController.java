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

import nirmalya.aatithya.restmodule.api.dao.RestCrmApiCallDao;
import nirmalya.aatithya.restmodule.api.model.RestCrmApiCallModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.util.DocumentUpload;

@RestController
@RequestMapping(value = "api")
public class RestCrmApiCallController {

	@Autowired
	RestCrmApiCallDao restCrmApiCallDao;

	@Autowired
	EnvironmentVaribles env;

	@Autowired
	DocumentUpload documentUpload;

	Logger logger = LoggerFactory.getLogger(RestCrmApiCallController.class);
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
	
	// add call
	@RequestMapping(value = "addCrmCallMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addCrmCallMaster(@RequestBody RestCrmApiCallModel call) {
		logger.info("Method : addCrmCallMaster starts");

		logger.info("Method : addCrmCallMaster ends");
		return restCrmApiCallDao.addCrmCallMaster(call);
	}

	// view 
	@GetMapping(value = "viewCrmCallMaster")
	public JsonResponse<List<RestCrmApiCallModel>> viewCrmCallMaster(@RequestParam String createdBy,String organization, String orgDivision) {
		logger.info("Method : viewCrmCallMaster");

		logger.info("Method : viewCrmCallMaster ends");
		return restCrmApiCallDao.viewCrmCallMaster(createdBy,organization,orgDivision);
	}

	// add check in

	@PostMapping(value = "checkInCrmCallMaster-api", headers = "content-type=multipart/*", consumes = { "application/*" })
	public ResponseEntity<JsonResponse<Object>> checkInCrmCallMasterApi(RestCrmApiCallModel call) {
		logger.info("Method : checkInCrmCallMasterApi starts");

		MultipartFile x = call.getMulFile();
		String fileName = null;
		if (x != null && !call.getExtension().equals("") && !call.getExtension().equals("null") && !call.getExtension().equals(null)) {
			byte[] bytes = null;
			try {
				bytes = x.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileName = saveAllDocuments(bytes, call.getExtension(), call.getCallCreatedBy());
		}
		call.setCheckImg(fileName);
		logger.info("Method : checkInCrmCallMasterApi ends");
		return restCrmApiCallDao.checkInCrmCallMaster(call);
	}
	
	@RequestMapping(value = "checkInCrmCallMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> checkInCrmCallMaster(@RequestBody RestCrmApiCallModel call) {
		logger.info("Method : checkInCrmCallMaster starts");

		logger.info("Method : checkInCrmCallMaster ends");
		return restCrmApiCallDao.checkInCrmCallMaster(call);
	}
	
	//visit History
	
	@GetMapping(value = "viewCrmCall-visitHistory")
	public JsonResponse<List<RestCrmApiCallModel>> viewCrmCallvisitHistory(@RequestParam String createdBy,String organization, String orgDivision) {
		logger.info("Method : viewCrmCallvisitHistory");
		
		logger.info("Method : viewCrmCallvisitHistory ends");
		return restCrmApiCallDao.viewCrmCallvisitHistory(createdBy,organization,orgDivision);
	}
	//visit History Report
	
	@GetMapping(value = "viewCrmCall-visitHistoryReport")
	public JsonResponse<List<RestCrmApiCallModel>> viewCrmCallvisitHistoryReport(@RequestParam String userId,String organization, String orgDivision,
																String fromDate,String toDate){
		logger.info("Method : viewCrmCallvisitHistoryReport");
		
		logger.info("Method : viewCrmCallvisitHistoryReport ends");
		return restCrmApiCallDao.viewCrmCallvisitHistoryReport(userId,organization,orgDivision,fromDate,toDate);
	}
	//visit History Report Search
	
	@GetMapping(value = "viewCrmCall-visitHistoryReportSearch")
	public JsonResponse<List<RestCrmApiCallModel>> viewCrmCallvisitHistoryReportSearch(@RequestParam String userId,String organization, String orgDivision,
			String fromDate,String toDate,String customer,String saleTeam){
		logger.info("Method : viewCrmCallvisitHistoryReportSearch");
		
		logger.info("Method : viewCrmCallvisitHistoryReportSearch ends");
		return restCrmApiCallDao.viewCrmCallvisitHistoryReportSearch(userId,organization,orgDivision,fromDate,toDate,customer,saleTeam);
	}
	//delete call
	@GetMapping(value = "delete-crmCallMaster")
	public ResponseEntity<JsonResponse<Object>> deleteCrmCallMaster(@RequestParam String callid,String organization, String orgDivision) {
		logger.info("Method : deleteCrmCallMaster starts");
		
		logger.info("Method : deleteCrmCallMaster ends");
		return restCrmApiCallDao.deleteCrmCallMaster(callid, organization, orgDivision);
	}
}
