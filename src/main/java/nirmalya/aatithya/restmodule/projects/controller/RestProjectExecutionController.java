package nirmalya.aatithya.restmodule.projects.controller;

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

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.projects.dao.RestProjectExecutionDao;
import nirmalya.aatithya.restmodule.projects.model.ProjectMessageModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectExecutionModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseQuotationModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;

@RestController
@RequestMapping(value = "projects/")
public class RestProjectExecutionController {
	Logger logger = LoggerFactory.getLogger(RestProjectExecutionController.class);

	@Autowired
	RestProjectExecutionDao projectExecutionDao;

	@Autowired
	EnvironmentVaribles env;

	// tree table structure

	@RequestMapping(value = "getAllProjectCategoryList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> getAllProjectCategoryList(
			@RequestParam String id) {
		logger.info("Method : getAllProjectCategoryList starts");

		logger.info("Method : getAllProjectCategoryList ends");
		return projectExecutionDao.getAllProjectCategoryList(id);
	}

	@PostMapping(value = "rest-saveProjectCategory")
	public ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>> addPurchaseQuotation(
			@RequestBody List<RestProjectExecutionModel> category) {
		logger.info("Method :saveProjectCategory starts");

		logger.info("Method :saveProjectCategory endss");
		return projectExecutionDao.saveProductCategory(category);
	}
//view

	@RequestMapping(value = "rest-getAllProjectExecutionDetails", method = { RequestMethod.GET })

	public JsonResponse<Object> getAllProjectExecutionDetails(@RequestParam String id, @RequestParam String userid,
			@RequestParam String org, @RequestParam String div) {
		logger.info("Method :getAllProjectExecutionDetails start");

		logger.info("Method :getAllProjectExecutionDetails endss");
		return projectExecutionDao.getAllProjectExecutionDetails(id, userid, org, div);
	}

	// Add tasks
	@RequestMapping(value = "rest-saveProjectExecutions", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>> saveProjectExecutions(
			@RequestBody List<RestProjectExecutionModel> execution) {
		logger.info("Method : saveProjectExecutions starts");

		logger.info("Method : saveProjectExecutions ends");
		return projectExecutionDao.saveProjectExecutionsDao(execution);
	}

	// Add main tasks
	@RequestMapping(value = "rest-saveParentCategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>> saveParentCategory(
			@RequestBody List<RestProjectExecutionModel> execution) {
		logger.info("Method : rest-saveParentCategory starts");

		logger.info("Method : rest-saveParentCategory ends");
		return projectExecutionDao.saveParentCategoryDao(execution);
	}
	// edit PaRENT

	@RequestMapping(value = "rest-getProjectParentEdit", method = { RequestMethod.GET })

	public JsonResponse<Object> getProjectParentEdit(@RequestParam String id, @RequestParam String exeId,
			@RequestParam String userid, @RequestParam String org, @RequestParam String div) {
		logger.info("Method :getProjectParentEdit start");

		logger.info("Method :getProjectParentEdit endss");
		return projectExecutionDao.getProjectParentEditDao(id, exeId, userid, org, div);
	}

	// edit child

	@RequestMapping(value = "rest-getProjectChildEdit", method = { RequestMethod.GET })

	public JsonResponse<Object> getProjectChildEdit(@RequestParam String id, @RequestParam String exeId,
			@RequestParam String userid, @RequestParam String org, @RequestParam String div) {
		logger.info("Method :getProjectChildEdit start");

		logger.info("Method :getProjectChildEdit endss");
		return projectExecutionDao.getProjectChildEditDao(id, exeId, userid, org, div);
	}

	@RequestMapping(value = "rest-gettaskdetail", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestProjectExecutionModel>> gettaskdetail(@RequestParam String id,
			@RequestParam String pid) {
		logger.info("Method : gettaskdetail starts");
		logger.info("Method : gettaskdetail ends");
		return projectExecutionDao.gettaskdetail(id, pid);
	}

//
	// Add tasks details
	@RequestMapping(value = "rest-saveTaskDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveTaskDetails(
			@RequestBody List<RestProjectExecutionModel> execution) {
		logger.info("Method : saveTaskDetails starts");

		logger.info("Method : saveTaskDetails ends");
		return projectExecutionDao.saveTaskDetails(execution);
	}

	// view tasks details

	@RequestMapping(value = "rest-viewProjectTaskDetails", method = { RequestMethod.GET })

	public JsonResponse<Object> getProjectTaskDetails(@RequestParam String id, @RequestParam String userid,
			@RequestParam String org, @RequestParam String div) {
		logger.info("Method :getProjectTaskDetails start");

		logger.info("Method :getProjectTaskDetails endss");
		return projectExecutionDao.getProjectTaskDetailsDao(id, userid, org, div);
	}

	// edit tasks details

	/*
	 * @RequestMapping(value = "rest-editTaskDetails", method = { RequestMethod.GET
	 * }) public ResponseEntity<JsonResponse<RestProjectExecutionModel>>
	 * editTaskDetails(@RequestParam String id) {
	 * logger.info("Method : editTaskDetails starts");
	 * logger.info("Method : editTaskDetails ends"); return
	 * projectExecutionDao.editTaskDetails(id); }
	 */

	@RequestMapping(value = "rest-editTaskDetails", method = { RequestMethod.GET })

	public JsonResponse<Object> editTaskDetails(@RequestParam String id, @RequestParam String id2,
			@RequestParam String userid, @RequestParam String org, @RequestParam String div) {
		logger.info("Method :editTaskDetails start");

		logger.info("Method :editTaskDetails endss");
		return projectExecutionDao.editTaskDetails(id, id2, userid, org, div);
	}

	// delete tasks details

	@RequestMapping(value = "rest-deleteTaskDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteTaskDetails(@RequestParam String id) {

		logger.info("Method : deleteTaskDetails starts");
		logger.info("Method : deleteTaskDetails ends");
		return projectExecutionDao.deleteTaskDetails(id);
	}
	// rest auto search

	@GetMapping(value = "rest-getPrecedAutoSearchList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPrecedAutoSearchList(@RequestParam String id,
			String projectId) {
		logger.info("Method : getPrecedAutoSearchList starts");

		logger.info("Method :getPrecedAutoSearchList endss");
		return projectExecutionDao.getPrecedAutoSearchList(id, projectId);
	}

	// rest auto search assigned to

	@GetMapping(value = "rest-getAssignedToAutoSearchList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAssignedToAutoSearchList(@RequestParam String id) {
		logger.info("Method : getAssignedToAutoSearchList starts");

		logger.info("Method :getAssignedToAutoSearchList endss");
		return projectExecutionDao.getAssignedToAutoSearchList(id);
	}

	@GetMapping(value = "rest-getPrecedDates")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPrecedDates(@RequestParam String id) {
		logger.info("Method : getPrecedDates starts");

		logger.info("Method :getPrecedDates endss");
		return projectExecutionDao.getPrecedDates(id);
	}

	/*
	 * @RequestMapping(value = "rest-getFromPlanning", method = { RequestMethod.GET
	 * }) public ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>>
	 * getFromPlanning(@RequestParam String id) {
	 * logger.info("Method : getFromPlanning starts");
	 * 
	 * logger.info("Method : getFromPlanning ends"); return
	 * projectExecutionDao.getFromPlanning(id); }
	 */

	@RequestMapping(value = "rest-getFromPlanning", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getFromPlanning(@RequestParam String id, @RequestParam String userId,
			@RequestParam String org, @RequestParam String div) {
		logger.info("Method :  getFromPlanning starts");

		logger.info("Method :  getFromPlanning ends");
		return projectExecutionDao.getFromPlanning(id, userId, org, div);
	}

	/////////////////////////////////////////////// API////////////////////////////////////////////////////////

	@GetMapping(value = "/rest-getexectuionParentchildData")
	public JsonResponse<List<RestProjectExecutionModel>> getexectuionParentchildData(@RequestParam String id,
			@RequestParam String userId, @RequestParam String org, @RequestParam String div) {
		logger.info("Method : getexectuionParentchildData starts");

		logger.info("Method : getexectuionParentchildData endss");
		return projectExecutionDao.getexectuionParentchildData(id, userId, org, div);
	}

	/*
	 * // Add tasks Api
	 * 
	 * @PostMapping(value = "/rest-saveexecutionApi", headers =
	 * "content-type=multipart/*", consumes = { "application/*" }) public
	 * ResponseEntity<JsonResponse<List<RestProjectExecutionModel>>>
	 * saveexecutionApi(
	 * 
	 * @RequestBody List<RestProjectExecutionModel> execution) {
	 * logger.info("Method : saveexecutionApi starts");
	 * 
	 * MultipartFile x = execution.get(0).getMulFile(); String fileName = null; if
	 * (x != null) { byte[] bytes = null; try { bytes = x.getBytes(); } catch
	 * (IOException e) { e.printStackTrace(); } fileName = saveAllDocuments(bytes,
	 * execution.get(0).getExtension()); } execution.get(0).setFileAttach(fileName);
	 * logger.info("Method : saveexecutionApi ends"); return
	 * projectExecutionDao.saveexecutionApi(execution); }
	 */

	// image name
	private String saveAllDocuments(byte[] imageBytes, String ext) {
		logger.info("Method : saveAllImage starts");

		String imageName = null;
		try {
			if (imageBytes != null) {
				long nowTime = new Date().getTime();
				if (ext.contentEquals("png") || ext.contentEquals("jpg") || ext.contentEquals("jpeg")) {
					imageName = nowTime + ".jpg";
				} else {
					imageName = nowTime + "." + ext;
				}
			}
			Path path = Paths.get(env.getFileUploadDocumenttUrl() + imageName);
			if (imageBytes != null) {
				Files.write(path, imageBytes);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("saveAllImage: " + e.getMessage());
		}
		logger.info("Method : saveAllImage ends");
		return imageName;
	}

	// post ex Api
	@PostMapping(value = "/rest-saveexecutionApi" ,headers = "content-type=multipart/*", consumes = {"application/*" })
	public ResponseEntity<JsonResponse<Object>> saveexecutionApi(RestProjectExecutionModel drAppointmentBookApiModel) {

		logger.info("Method : saveexecutionApi starts");

		MultipartFile x = drAppointmentBookApiModel.getMulFile();
		String fileName = null;
		if (x != null && !drAppointmentBookApiModel.getExtension().equals("")
				&& !drAppointmentBookApiModel.getExtension().equals("null")
				&& !drAppointmentBookApiModel.getExtension().equals(null)) {
			byte[] bytes = null;
			try {
				bytes = x.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileName = saveAllDocuments(bytes, drAppointmentBookApiModel.getExtension());
		}
		drAppointmentBookApiModel.setFileAttach(fileName);
		logger.info("Method : saveexecutionApi ends");
		return projectExecutionDao.saveexecutionApi(drAppointmentBookApiModel);
	}

	// get Reuisition list

	@RequestMapping(value = "get-requisitionData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> requisitionData(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : requisitionData starts");

		logger.info("Method : requisitionData ends");
		return projectExecutionDao.requisitionData(id, org, orgDiv);
	}
	/*
	 * @GetMapping(value = "rest-getReqisition") public List<RestPurchaseOrderModel>
	 * requisitionDataProject(@RequestParam String id) {
	 * logger.info("Method : requisitionDataProject starts");
	 * logger.info("Method : requisitionDataProject endss"); return
	 * projectExecutionDao.requisitionDataProject(id); }
	 */

	@RequestMapping(value = "rest-getplanningList", method = { RequestMethod.GET })

	public JsonResponse<Object> getplanningList(@RequestParam String id, @RequestParam String userid,
			@RequestParam String org, @RequestParam String div) {
		logger.info("Method :getplanningList start");

		logger.info("Method :getplanningList endss");
		return projectExecutionDao.getplanningList(id, userid, org, div);
	}
	// For monitoring view

	@RequestMapping(value = "rest-monitoringView", method = { RequestMethod.GET })

	public JsonResponse<Object> monitoringView(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div, @RequestParam String id) {
		logger.info("Method :monitoringView start");

		logger.info("Method :monitoringView endss");
		return projectExecutionDao.monitoringViewDao(userid, org, div, id);
	}

	// FOR Req VIEW

	@RequestMapping(value = "rest-viewProjectRequisions", method = { RequestMethod.GET })

	public JsonResponse<Object> viewProjectRequision(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div, @RequestParam String id) {
		logger.info("Method :viewProjectRequision start");

		logger.info("Method :viewProjectRequision endss");
		return projectExecutionDao.viewProjectRequision(userid, org, div, id);
	}

	// FOR Po VIEW

	@RequestMapping(value = "rest-viewProjectPos", method = { RequestMethod.GET })

	public JsonResponse<Object> viewProjectPo(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div, @RequestParam String id) {
		logger.info("Method :viewProjectPo start");

		logger.info("Method :viewProjectPo endss");
		return projectExecutionDao.viewProjectPoDao(userid, org, div, id);
	}

	// FOR Grn VIEW

	@RequestMapping(value = "rest-viewProjectGrn", method = { RequestMethod.GET })

	public JsonResponse<Object> viewProjectGrn(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div, @RequestParam String id) {
		logger.info("Method :viewProjectGrn start");

		logger.info("Method :viewProjectGrn endss");
		return projectExecutionDao.viewProjectGrnDao(userid, org, div, id);
	}
	

	@RequestMapping(value = "rest-ganttChartList", method = { RequestMethod.GET })

	public JsonResponse<Object> ganttChartList(@RequestParam String id, @RequestParam String userid,
			@RequestParam String org, @RequestParam String orgDivision) {
		logger.info("Method :ganttChartList start");

		logger.info("Method :ganttChartList endss");
		return projectExecutionDao.ganttChartList(id, userid, org, orgDivision);
	}
	
	@RequestMapping(value = "rest-saveTaskComments", method = { RequestMethod.POST })
	public JsonResponse<Object> saveTaskComments(@RequestBody ProjectMessageModel data) {
		logger.info("Method :saveTaskComments start");
		
		logger.info("Method :saveTaskComments endss");
		return projectExecutionDao.saveTaskComments(data);
	}
	

	@RequestMapping(value = "rest-getProjectBillPdfView", method = { RequestMethod.GET })
	public JsonResponse<Object> getProjectBillPdfView(@RequestParam String id, @RequestParam String userid, @RequestParam String orgName,
			@RequestParam String div) {
		logger.info("Method :getProjectBillPdfView start");

		logger.info("Method :getProjectBillPdfView endss");
		return projectExecutionDao.getProjectBillPdfView(id, userid, orgName,div);

	}

}
