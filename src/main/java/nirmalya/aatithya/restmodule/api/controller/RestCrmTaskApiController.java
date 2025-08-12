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

import nirmalya.aatithya.restmodule.api.dao.RestApiCrmTaskDao;
import nirmalya.aatithya.restmodule.api.model.RestCrmApiTaskModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.util.DocumentUpload;

@RestController
@RequestMapping(value = "api")
public class RestCrmTaskApiController {

	@Autowired
	RestApiCrmTaskDao restApiCrmTaskDao;

	@Autowired
	EnvironmentVaribles env;

	@Autowired
	DocumentUpload documentUpload;

	Logger logger = LoggerFactory.getLogger(RestCrmTaskApiController.class);

	// Get Lead list
	@RequestMapping(value = "/getLeadList", method = { RequestMethod.GET })
	public List<DropDownModel> getLeadList(@RequestParam String organization, String orgDivision) {
		logger.info("Method : getLeadList starts");

		logger.info("Method : getLeadList end");
		return restApiCrmTaskDao.getLeadList(organization, orgDivision);
	}

	// Get Decision maker
	@RequestMapping(value = "/getDecisionMakerList", method = { RequestMethod.GET })
	public List<DropDownModel> getDecisionMakerList(@RequestParam String leadId, String organization,
			String orgDivision) {
		logger.info("Method : getDecisionMakerList starts");

		logger.info("Method : getDecisionMakerList end");
		return restApiCrmTaskDao.getDecisionMakerList(leadId, organization, orgDivision);
	}
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
	
	// add

	@RequestMapping(value = "addCrmTaskMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addCrmTaskMaster(@RequestBody RestCrmApiTaskModel restPayroll) {
		logger.info("Method : addCrmTaskMaster starts");

		logger.info("Method : addCrmTaskMaster ends");
		return restApiCrmTaskDao.addCrmTaskMaster(restPayroll);
	}

	// view
	@GetMapping(value = "viewCrmTaskMaster")
	public JsonResponse<List<RestCrmApiTaskModel>> viewCrmTaskMaster(@RequestParam String createdBy,String organization, String orgDivision) {
		logger.info("Method : viewCrmTaskMaster");

		logger.info("Method : viewCrmTaskMaster ends");
		return restApiCrmTaskDao.viewCrmTaskMaster(createdBy,organization,orgDivision);
	}

	// add check in
	@PostMapping(value = "checkInCrmTaskMaster-api", headers = "content-type=multipart/*", consumes = { "application/*" })
	public ResponseEntity<JsonResponse<Object>> checkInCrmTaskMasterApi(RestCrmApiTaskModel task) {
		logger.info("Method : checkInCrmTaskMasterApi starts");

		MultipartFile x = task.getMulFile();
		String fileName = null;
		if (x != null && !task.getExtension().equals("") && !task.getExtension().equals("null") && !task.getExtension().equals(null)) {
			byte[] bytes = null;
			try {
				bytes = x.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileName = saveAllDocuments(bytes, task.getExtension(), task.getTaskCreatedBy());
		}
		task.setCheckImg(fileName);
		logger.info("Method : checkInCrmTaskMasterApi ends");
		return restApiCrmTaskDao.checkInCrmTaskMaster(task);
	}
	@RequestMapping(value = "checkInCrmTaskMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> checkInCrmTaskMaster(@RequestBody RestCrmApiTaskModel taskmaster) {
		logger.info("Method : checkInCrmTaskMaster starts");

		logger.info("Method : checkInCrmTaskMaster ends");
		return restApiCrmTaskDao.checkInCrmTaskMaster(taskmaster);
	}
	// view visit histry
	@GetMapping(value = "viewCrmTask-visitHistory")
	public JsonResponse<List<RestCrmApiTaskModel>> viewCrmTaskvisitHistory(@RequestParam String createdBy,String organization, String orgDivision) {
		logger.info("Method : viewCrmTaskvisitHistory");
		
		logger.info("Method : viewCrmTaskvisitHistory ends");
		return restApiCrmTaskDao.viewCrmTaskvisitHistory(createdBy,organization,orgDivision);
	}
	//check in history report
	@GetMapping(value = "viewCrmTask-visitHistoryReport")
	public JsonResponse<List<RestCrmApiTaskModel>> viewCrmTaskvisitHistoryReport(@RequestParam String userId,String organization, String orgDivision,
			String fromDate,String toDate){
		logger.info("Method : viewCrmTaskvisitHistoryReport");
		
		logger.info("Method : viewCrmTaskvisitHistoryReport ends");
		return restApiCrmTaskDao.viewCrmTaskvisitHistoryReport(userId,organization,orgDivision,fromDate,toDate);
	}
	//check in history report search
	@GetMapping(value = "viewCrmTask-visitHistoryReportSearch")
	public JsonResponse<List<RestCrmApiTaskModel>> viewCrmTaskvisitHistoryReportSearch(@RequestParam String userId,String organization, String orgDivision,
			String fromDate,String toDate,String customer,String saleTeam){
		logger.info("Method : viewCrmTaskvisitHistoryReportSearch");
		
		logger.info("Method : viewCrmTaskvisitHistoryReportSearch ends");
		return restApiCrmTaskDao.viewCrmTaskvisitHistoryReportSearch(userId,organization,orgDivision,fromDate,toDate,customer,saleTeam);
	}
	//delete task
	@GetMapping(value = "delete-crmTaskMaster")
	public ResponseEntity<JsonResponse<Object>> deleteCrmTaskMaster(@RequestParam String taskid,String organization, String orgDivision) {
		logger.info("Method : deleteCrmTaskMaster starts");
		
		logger.info("Method : deleteCrmTaskMaster ends");
		return restApiCrmTaskDao.deleteCrmTaskMaster(taskid, organization, orgDivision);
	}
	
	
	@RequestMapping(value = "deal-reportcategorise-bar", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestCrmApiTaskModel>>> getDistrictPropertycategory(@RequestParam String salesTeam,@RequestParam String fdate,@RequestParam String tdate,
			@RequestParam String orgname,@RequestParam String orgdiv) {
		logger.info("Method : getDistrictPropertycategory starts"+salesTeam+fdate+tdate);

		logger.info("Method : getDistrictPropertycategory ends");
		return restApiCrmTaskDao.viewDealGraph(salesTeam,fdate,tdate,orgname,orgdiv);
	}
	
	
	@RequestMapping(value = "viewhistory-reportcategorise-bar", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestCrmApiTaskModel>>> viewHistory(@RequestParam String salesTeam,@RequestParam String fdate,@RequestParam String tdate,
			@RequestParam String orgname,@RequestParam String orgdiv) {
		logger.info("Method : viewHistory starts"+salesTeam+fdate+tdate);

		logger.info("Method : viewHistory ends");
		return restApiCrmTaskDao.viewHistory(salesTeam,fdate,tdate,orgname,orgdiv);
	}
	
	
}
