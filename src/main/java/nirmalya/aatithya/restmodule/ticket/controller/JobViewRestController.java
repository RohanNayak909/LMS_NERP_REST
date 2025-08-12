package nirmalya.aatithya.restmodule.ticket.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
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

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.ticket.dao.JobViewDao;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;
import nirmalya.aatithya.restmodule.ticket.model.TicketRestDocumentManagementModel;

@RestController
@RequestMapping("ticket/")
public class JobViewRestController {
	Logger logger = LoggerFactory.getLogger(DepartmentViewRestController.class);

	@Autowired
	JobViewDao jobViewDao;

	@Autowired
	EnvironmentVaribles env;
	
	// Job list

	@GetMapping(value = "rest-jobview-all-data")
	public JsonResponse<Object> jobList(@RequestParam String userid, @RequestParam String org,
			@RequestParam String orgDiv, @RequestParam String pageno, @RequestParam String option) {
		logger.info("Method :jobList start");

		logger.info("Method :jobList ends");
		return jobViewDao.jobList(org, orgDiv, userid, pageno,option);

	}
	
	// Job list search
	
	@GetMapping(value = "rest-jobview-all-data-search")
	public JsonResponse<Object> jobListSearch(@RequestParam String userid, @RequestParam String org,
			@RequestParam String orgDiv ,@RequestParam String search , @RequestParam String option, @RequestParam String date) {
		logger.info("Method :jobListSearch start");
		
		logger.info("Method :jobListSearch ends");
		return jobViewDao.jobListSearch(org, orgDiv, userid, search, option,date);
		
	}

	// Ticket Type List.

	@GetMapping(value = "get-result-status")
	public List<DropDownModel> getResultStatus(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getResultStatus starts");

		logger.info("Method : getResultStatus ends");
		return jobViewDao.getResultStatus(org, orgDiv);
	}
	
	// Ticket Type List.

	@GetMapping(value = "get-sparepart-list")
	public List<DropDownModel> getSparePart(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getSparePart starts");

		logger.info("Method : getSparePart ends");
		return jobViewDao.getSparePartList(org, orgDiv);
	}
	// Ticket Type List(Mobile)
	
	@GetMapping(value = "get-resultstatus")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getResultStatusMobile(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getResultStatusMobile starts");
		
		logger.info("Method : getResultStatusMobile ends");
		return jobViewDao.getResultStatusMobile(org, orgDiv);
	}

	//Save result

	@PostMapping(value = "rest-add-job-result")
	public ResponseEntity<JsonResponse<TicketManagementRestModel>> saveResultUpload(
			@RequestBody TicketManagementRestModel category) {
		logger.info("Method : saveResultUpload starts");
		JSONObject json = new JSONObject();

		if (category.getDocumentList().size() > 0) {
			for (TicketRestDocumentManagementModel a : category.getDocumentList()) {
				String delimiters = "\\.";
				String[] x = a.getFileName().split(delimiters);
				String extensionW = x[x.length - 1];
				for (String s1 : a.getDocumentFile()) {
					if (s1 != null) {
						try {
							byte[] bytes = Base64.getDecoder().decode(s1);
							json = saveAllMediaDocuments(bytes, extensionW.toString(), category.getCreatedBy());
							a.setFileName(json.getString("imageName"));
							a.setDocumentURL(json.getString("fileurl"));
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}
			}

		}

		logger.info("Method : saveResultUpload ends");
		return jobViewDao.saveResultUpload(category);
	}

	public JSONObject saveAllMediaDocuments(byte[] imageBytes, String ext, String user_id) {
		logger.info("Method : saveAllMedicalDocuments starts");

		String imageName = null;
		try {
			if (imageBytes != null) {
				long nowTime = new Date().getTime();

				/*
				 * if (filetype.equals("Video")) { ext = "mp4"; }
				 */
				if (ext.contentEquals("flv") || ext.contentEquals("avi") || ext.contentEquals("3gp")
						|| ext.contentEquals("mov") || ext.contentEquals("cda") || ext.contentEquals("wav")
						|| ext.contentEquals("mkv") || ext.contentEquals("wma") || ext.contentEquals("wpl")) {
					ext = "mp4";
				}
				if (ext.contentEquals("jpeg")) {
					imageName = user_id + "_" + nowTime + ".jpg";
				} else {
					imageName = user_id + "_" + nowTime + "." + ext;
				}
			}

			Path path = Paths.get(env.getFileUploadticketUrl() + imageName);
			if (imageBytes != null) {
				Files.write(path, imageBytes);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = env.getMobileView() + "document/ticketDocs/" + imageName;

		JSONObject json = new JSONObject();

		try {
			json.put("imageName", imageName);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			json.put("fileurl", url);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("Method : saveAllMediaDocuments ends");
		return json;
	}
	
	// acceptOperation
	@RequestMapping(value = "rest-jobview-save-accept", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> acceptOperation(@RequestParam String id,String operation,String expectedDate,String expectedTime,String expectedCost, String org, String orgDiv) {
		logger.info("Method : acceptOperation starts");

		logger.info("Method : acceptOperation ends");
		return jobViewDao.acceptOperation(id,operation, org, orgDiv,expectedDate,expectedTime,expectedCost);

	}
	
	@GetMapping(value = "rest-jobview-result-view")
	public JsonResponse<Object> getResultView(@RequestParam String id, @RequestParam String org,
			@RequestParam String orgDiv) {
		logger.info("Method : getResultView starts");

		logger.info("Method : getResultView ends");
		return jobViewDao.getResultView(id, org, orgDiv);
	}

	@RequestMapping(value = "rest-jobview-spare-subcategory", method = { RequestMethod.GET })
	public JsonResponse<Object> getSubCategory(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :getSubCategory start");

		logger.info("Method :getSubCategory endss");
		return jobViewDao.getSubCategory(id, orgName, orgDivision);
	}
	
	@GetMapping(value = "rest-jobview-all-type-btn")
	public JsonResponse<Object> JobTypeList(@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String userId) {
		logger.info("Method :JobTypeList start");

		logger.info("Method :JobTypeList ends");
		return jobViewDao.JobTypeList(orgName, orgDivision, userId);

	}
	
	@GetMapping(value = "rest-jobview-all-policywise-view")
	public JsonResponse<Object> getJobsPolicyWise(@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String userid, @RequestParam String id, @RequestParam String date) {
		logger.info("Method :getJobsPolicyWise start");

		logger.info("Method :getJobsPolicyWise ends");
		return jobViewDao.getJobsPolicyWise(org, orgDiv, userid, id,date);

	}
	
	@RequestMapping(value = "getEmployeeListforJobview", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeListforJobview(@RequestParam String org,String orgDiv,String userId) {
		logger.info("Method : getEmployeeListforJobview starts");

		logger.info("Method : getEmployeeListforJobview ends");
		return jobViewDao.getEmployeeListforJobview(org,orgDiv,userId);
	}
}
