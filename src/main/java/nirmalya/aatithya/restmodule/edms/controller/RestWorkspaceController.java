package nirmalya.aatithya.restmodule.edms.controller;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.edms.dao.RestWorkspaceDao;
import nirmalya.aatithya.restmodule.edms.model.RestWorkSpaceModel;

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

@RestController
@RequestMapping(value = "edms/")
public class RestWorkspaceController {
	Logger logger = LoggerFactory.getLogger(RestWorkspaceController.class);

	@Autowired
	RestWorkspaceDao RestWorkspaceDao;

	@RequestMapping(value = "rest-fileaccess-type", method = { RequestMethod.GET })
	public List<DropDownModel> fileAccessType() {
		logger.info("Method : fileAccessType starts");

		logger.info("Method : fileAccessType ends");
		return RestWorkspaceDao.fileAccessType();
	}

	@RequestMapping(value = "rest-fileoperation-type", method = { RequestMethod.GET })
	public List<DropDownModel> fileOperationType() {
		logger.info("Method : fileOperationType starts");

		logger.info("Method : fileOperationType ends");
		return RestWorkspaceDao.fileOperationType();
	}

	@PostMapping(value = "save-workspacemodel")
	public ResponseEntity<JsonResponse<Object>> saveEventsRest(@RequestBody RestWorkSpaceModel eventModel) {
		logger.info("Method : saveEventsRest starts");
		logger.info("Method : saveEventsRest ends");
		return RestWorkspaceDao.saveWorkspaceModel(eventModel);
	}

	@RequestMapping(value = "rest-workSpace", method = { RequestMethod.GET })
	public JsonResponse<Object> viewWorkSpace(@RequestParam String userId, @RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method :viewWorkSpace start");

		logger.info("Method :viewWorkSpace endss ");
		return RestWorkspaceDao.viewWorkSpace(userId, orgName, orgDivision);

	}

	@RequestMapping(value = "rest-workSpace-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editWorkSpace(@RequestParam String workSpaceId, @RequestParam String userId,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :editWorkSpace start");

		logger.info("Method :editWorkSpace endss ");
		return RestWorkspaceDao.editWorkSpace(workSpaceId, userId, orgName, orgDivision);
	}

	@GetMapping(value = "rest-deleteworksapce")
	public ResponseEntity<JsonResponse<Object>> deleteWorksapce(@RequestParam String id,@RequestParam String userId,
			@RequestParam String orgName, @RequestParam String orgDivision ) {
		logger.info("Method : deleteWorksapce starts");

		logger.info("Method : deleteWorksapce ends");
		return RestWorkspaceDao.deleteWorksapce(id, userId, orgName, orgDivision);
	}

	// Parent Folder Dropdown
	@RequestMapping(value = "rest-parentFolder", method = { RequestMethod.GET })
	public List<DropDownModel> parentFolder() {
		logger.info("Method : parentFolder starts");

		logger.info("Method : parentFolder ends");
		return RestWorkspaceDao.parentFolder();
	}

	// Add Workspace
	@PostMapping(value = "rest-getNew-workspace-add")
	public ResponseEntity<JsonResponse<Object>> getWorkspaceAdd(@RequestBody String itm,
			@RequestParam String workSpaceId) {
		logger.info("Method : getWorkspaceAdd starts");
		logger.info("Method : getWorkspaceAdd ends");
		return RestWorkspaceDao.getWorkspaceAdd(itm, workSpaceId);
	}

	// Folder Type Dropdown
	@RequestMapping(value = "rest-chooseFolderType", method = { RequestMethod.GET })
	public List<DropDownModel> chooseFolderType() {
		logger.info("Method : chooseFolderType starts");

		logger.info("Method : chooseFolderType ends");
		return RestWorkspaceDao.chooseFolderType();
	}

	@GetMapping(value = "rest-userAutoSearch")
	public ResponseEntity<JsonResponse<Object>> getUserAutoSearch(@RequestParam String id
			,@RequestParam String type) {
		logger.info("Method : getUserAutoSearch starts");

		logger.info("Method :getUserAutoSearch endss");
		return RestWorkspaceDao.getUserAutoSearch(id,type);
	}
	
	@RequestMapping(value = "rest-getUserList", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeList(@RequestParam String orgName, String orgDivision,String userId) {
		logger.info("Method : getEmployeeList starts");
		
		logger.info("Method : getEmployeeList ends");
		return RestWorkspaceDao.getEmployeeList(orgName,orgDivision,userId);
	}
	
	@GetMapping(value = "rest-getAutosearchUser")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAutosearchUser(
			@RequestParam String id,@RequestParam String userId,@RequestParam String orgName,@RequestParam String orgDiv) {
		logger.info("Method : getAutosearchUser starts");

		logger.info("Method :getAutosearchUser endss");
		return RestWorkspaceDao.getAutosearchUser(id,userId,orgName,orgDiv);
	}
	
	@GetMapping(value = "rest-getAutosearchGroup")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAutosearchGroup(
			@RequestParam String id,@RequestParam String userId) {
		logger.info("Method : getAutosearchGroup starts");

		logger.info("Method :getAutosearchGroup endss");
		return RestWorkspaceDao.getAutosearchGroup(id,userId);
	}
}
