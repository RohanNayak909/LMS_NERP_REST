package nirmalya.aatithya.restmodule.edms.controller;

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
import nirmalya.aatithya.restmodule.edms.dao.RestWorkspaceDao;
import nirmalya.aatithya.restmodule.edms.dao.RestWorkspaceNewDao;

@RestController
@RequestMapping(value = "edms/")
public class RestWorkspaceNewController {

	Logger logger = LoggerFactory.getLogger(RestWorkspaceNewController.class);

	@Autowired
	RestWorkspaceNewDao restWorkspaceNewDao;

	// get Folder Details
	@RequestMapping(value = "rest-getFolderDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> getFolderDetails(@RequestParam String userId, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :getFolderDetails start");

		logger.info("Method :editDocumentControl endss");
		return restWorkspaceNewDao.getFolderDetails(userId, organization, orgDivision);
	}
	
	// Add Workspace
		@PostMapping(value = "rest-addWorkspaceNew")
		public ResponseEntity<JsonResponse<Object>> addWorkspaceNew(@RequestBody String itm,
				@RequestParam String workSpaceId,@RequestParam String parentFolder,String parentId) {
			logger.info("Method : addWorkspaceNew starts");
			logger.info("Method : addWorkspaceNew ends");
			return restWorkspaceNewDao.addWorkspaceNew(itm, workSpaceId,parentFolder,parentId);
		}
		

		// get Parent Folder Details
		@RequestMapping(value = "rest-getParentFolder", method = { RequestMethod.GET })
		public JsonResponse<Object> getParentFolder(@RequestParam String userId, @RequestParam String organization,
				@RequestParam String orgDivision,@RequestParam String path) {
			logger.info("Method :getParentFolder start");

			logger.info("Method :getParentFolder endss");
			return restWorkspaceNewDao.getParentFolder(userId, organization, orgDivision,path);
		}
		
		@RequestMapping(value = "rest-getAccesDetails", method = { RequestMethod.GET })
		public JsonResponse<Object> getAccesDetails(@RequestParam String orgName, @RequestParam String orgDivision,
				@RequestParam String id) {
			logger.info("Method :rest getAccesDetails start");
			logger.info("Method :rest getAccesDetails endss");
			return restWorkspaceNewDao.getAccesDetails(orgName, orgDivision, id);
		}
}
