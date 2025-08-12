package nirmalya.aatithya.restmodule.edms.controller;

import nirmalya.aatithya.restmodule.edms.dao.RestDocumentControlDao;
import nirmalya.aatithya.restmodule.edms.model.RestDocumentControlModel;
import nirmalya.aatithya.restmodule.edms.model.RestWorkFlowModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

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
public class RestDocumentControlController {

	Logger logger = LoggerFactory.getLogger(RestDocumentControlController.class);

	@Autowired
	RestDocumentControlDao restDocumentControlDao;  

	@PostMapping(value = "add-documentcontrol")
	public ResponseEntity<JsonResponse<List<RestDocumentControlModel>>> addDocController(
			@RequestBody List<RestDocumentControlModel> restDocumentControlModel) {
		logger.info("Method :addDocController starts");

		logger.info("Method :addDocController endss");
		return restDocumentControlDao.addDocDAO(restDocumentControlModel);
	}

	// Document Control View
	@RequestMapping(value = "rest-documentControlView", method = { RequestMethod.GET })
	public JsonResponse<Object> documentControlView(@RequestParam String userId, @RequestParam String organization,
			@RequestParam String orgDivision, @RequestParam String pageno) {
		logger.info("Method :documentControlView start");

		logger.info("Method :documentControlView endss");
		return restDocumentControlDao.documentControlView(userId, organization, orgDivision, pageno);
	}

// Document Control edit
	@RequestMapping(value = "rest-editDocumentControl", method = { RequestMethod.GET })
	public JsonResponse<Object> editDocumentControl(@RequestParam String id, @RequestParam String userId,
			@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method :editDocumentControl start");

		logger.info("Method :editDocumentControl endss");
		return restDocumentControlDao.editDocumentControl(id, userId, organization, orgDivision);
	}

	@PostMapping(value = "rest-uploadfolder")
	public ResponseEntity<JsonResponse<RestDocumentControlModel>> uploadFolderController(
			@RequestBody RestDocumentControlModel restDocumentControlModel) {
		logger.info("Method :uploadFolderController starts");

		logger.info("Method :uploadFolderController endss");
		return restDocumentControlDao.uploadFolderDAO(restDocumentControlModel);
	}

	@RequestMapping(value = "rest-editUploadFolder", method = { RequestMethod.GET })
	public JsonResponse<Object> editUploadFolder(@RequestParam String id) {
		logger.info("Method :editUploadFolder start");

		logger.info("Method :editUploadFolder endss");
		return restDocumentControlDao.editUploadFolder(id);
	}

	@PostMapping(value = "rest-deletefolderfiles")
	public ResponseEntity<JsonResponse<RestDocumentControlModel>> deleteFolderFiles(
			@RequestBody RestDocumentControlModel restDocumentControlModel) {
		logger.info("Method :deleteFolderFiles starts");

		logger.info("Method :deleteFolderFiles endss");
		return restDocumentControlDao.deleteFolderFiles(restDocumentControlModel);
	}

	@PostMapping(value = "rest-addLink")
	public ResponseEntity<JsonResponse<RestDocumentControlModel>> addLinks(
			@RequestBody RestDocumentControlModel restDocumentControlModel) {
		logger.info("Method :addLinks starts");

		logger.info("Method :addLinks endss");
		return restDocumentControlDao.addLinks(restDocumentControlModel);
	}

	@RequestMapping(value = "rest-editLink", method = { RequestMethod.GET })
	public JsonResponse<Object> editLink(@RequestParam String id) {
		logger.info("Method :editLink start");

		logger.info("Method :editLink endss");
		return restDocumentControlDao.editLink(id);
	}

	@GetMapping(value = "rest-deleteControl")
	public ResponseEntity<JsonResponse<Object>> deleteDocumentControl(@RequestParam String id) {
		logger.info("Method : deleteDocumentControl starts");

		logger.info("Method : deleteDocumentControl ends");
		return restDocumentControlDao.deleteDocumentControl(id);
	}

	// Document Control View
	@RequestMapping(value = "rest-viewDocumentDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> viewDocumentDetails(@RequestParam String userId, @RequestParam String organization,
			@RequestParam String orgDivision, @RequestParam String docId) {
		logger.info("Method :viewDocumentDetails start");

		logger.info("Method :viewDocumentDetails endss");
		return restDocumentControlDao.viewDocumentDetails(userId, organization, orgDivision, docId);
	}

	// Document Control Access
		@RequestMapping(value = "rest-documentAccessView", method = { RequestMethod.GET })
		public JsonResponse<Object> documentAccessView(@RequestParam String id,@RequestParam String userId, @RequestParam String organization,
				@RequestParam String orgDivision) {
			logger.info("Method :documentAccessView start");

			logger.info("Method :documentAccessView endss");
			return restDocumentControlDao.documentAccessView(id,userId, organization, orgDivision);
		}
		
		@PostMapping(value = "rest-uploadDocumentModify")
		public ResponseEntity<JsonResponse<List<RestDocumentControlModel>>> uploadDocumentModify(
				@RequestBody List<RestDocumentControlModel> restDocumentControlModel) {
			logger.info("Method :uploadDocumentModify starts");

			logger.info("Method :uploadDocumentModify endss");
			return restDocumentControlDao.uploadDocumentModify(restDocumentControlModel);
		}
		
		@PostMapping(value = "rest-uploadfolderModify")
		public ResponseEntity<JsonResponse<RestDocumentControlModel>> uploadfolderModify(
				@RequestBody RestDocumentControlModel restDocumentControlModel) {
			logger.info("Method :uploadfolderModify starts");

			logger.info("Method :uploadfolderModify endss");
			return restDocumentControlDao.uploadfolderModify(restDocumentControlModel);
		}
		
		// Document Control View
		@RequestMapping(value = "rest-documentControlViewHistory", method = { RequestMethod.GET })
		public JsonResponse<Object> documentControlViewHistory(@RequestParam String userId, @RequestParam String organization,
				@RequestParam String orgDivision, @RequestParam String docId) {
			logger.info("Method :documentControlViewHistory start");

			logger.info("Method :documentControlViewHistory endss");
			return restDocumentControlDao.documentControlViewHistory(userId, organization, orgDivision, docId);
		}
		// Document Control Workflow View
		@RequestMapping(value = "rest-documentControlViewworkFlow", method = { RequestMethod.GET })
		public JsonResponse<Object> documentControlViewworkFlow(@RequestParam String userId, @RequestParam String organization,
				@RequestParam String orgDivision, @RequestParam String docId) {
			logger.info("Method :documentControlViewworkFlow start");
			
			logger.info("Method :documentControlViewworkFlow endss");
			return restDocumentControlDao.documentControlViewworkFlow(userId, organization, orgDivision, docId);
		}
		
		@PostMapping(value = "rest-addWorkFlow")
		public ResponseEntity<JsonResponse<RestWorkFlowModel>> addWorkFlow(
				@RequestBody RestWorkFlowModel restWorkFlowModel) {
			logger.info("Method :addWorkFlow starts");

			logger.info("Method :addWorkFlow endss");
			return restDocumentControlDao.addWorkFlow(restWorkFlowModel);
		}


	@GetMapping(value = "getAlluserEmailId")
	public List<RestDocumentControlModel> getAlluserEmailId(@RequestParam String userid, String docid, String org,
			String orgDiv) {
		logger.info("Method : getAlluserEmailId starts");
		logger.info("Method : getAlluserEmailId endss");
		return restDocumentControlDao.getAlluserEmailId(userid, docid, org, orgDiv);
	}
	
	//
	@GetMapping(value = "sendMailToAllAccessor")
	public ResponseEntity<JsonResponse<List<RestDocumentControlModel>>> sendMailToAllAccessor(@RequestParam String userid,
			String mailDate,String subject,String messages, String emailId, 
			String empId,String empName, String docid, String fileName,  String groupId, String documentUrl, String orgName,String orgDivision) {
		logger.info("Method : sendMailToAllAccessor starts");

		logger.info("Method : sendMailToAllAccessor ends");
		return restDocumentControlDao.sendMailToAllAccessor(userid, mailDate,subject, messages, emailId,
				 empId, empName,docid,fileName, groupId,documentUrl,orgName,orgDivision);
	}
	
	// Email Reminder 
	@RequestMapping(value = "getAllEMailData",method = {RequestMethod.GET})
	public JsonResponse<Object> getAllEMailData() {
		logger.info("Method : getAllEMailData");
		return restDocumentControlDao.getAllEMailData();
		
	}
	

	@PostMapping(value = "rest-documentFolderModify")
	public ResponseEntity<JsonResponse<List<RestDocumentControlModel>>> documentFolderModify(
			@RequestBody List<RestDocumentControlModel> restDocumentControlModel) {
		logger.info("Method :documentFolderModify starts");

		logger.info("Method :documentFolderModify endss"); 
		return restDocumentControlDao.documentFolderModify(restDocumentControlModel);
	}
	
	// Document Control Version View
	@RequestMapping(value = "rest-viewDocumentControlVersion", method = { RequestMethod.GET })
	public JsonResponse<Object> viewDocumentControlVersion(@RequestParam String userId, @RequestParam String organization,
			@RequestParam String orgDivision, @RequestParam String docId) {
		logger.info("Method :viewDocumentControlVersion start");

		logger.info("Method :viewDocumentControlVersion endss");
		return restDocumentControlDao.viewDocumentControlVersion(userId, organization, orgDivision, docId);
	}
	
	//Folder Dropdown
	@RequestMapping(value = "rest-folderList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> folderList(@RequestParam String id,@RequestParam String userId, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : folderList starts");
		
		logger.info("Method : folderList ends");
		return restDocumentControlDao.folderList(id,userId,organization,orgDivision);
	}
	
	// Work Flow Document
		@RequestMapping(value = "rest-getAllWorkFlowDocument",method = {RequestMethod.GET})
		public JsonResponse<Object> getAllWorkFlowDocument() {
			logger.info("Method : getAllWorkFlowDocument");
			return restDocumentControlDao.getAllWorkFlowDocument();
			
		}
		//Lock File
		@PostMapping(value = "rest-lockFile")
		public ResponseEntity<JsonResponse<RestDocumentControlModel>> lockFile(@RequestBody RestDocumentControlModel restDocumentControlModel) {
			logger.info("Method : lockFile starts");
			logger.info("Method : lockFile ends");
			return restDocumentControlDao.lockFile(restDocumentControlModel);
		}
		
		//Get Notification
		@RequestMapping(value = "rest-getDocumentNotification", method = { RequestMethod.GET })
		public JsonResponse<Object> getDocumentNotification(@RequestParam String userId, @RequestParam String type) {

			logger.info("Method : getDocumentNotification starts");
			logger.info("Method : getDocumentNotification ends");

			return restDocumentControlDao.getDocumentNotification(userId, type);
		}
		
		// Notification Update
		@RequestMapping(value = "rest-notificationUpdate", method = { RequestMethod.GET })
		public JsonResponse<Object> notificationUpdate(@RequestParam String id, @RequestParam String userId,
				@RequestParam String organization, @RequestParam String orgDivision) {
			logger.info("Method :notificationUpdate start");

			logger.info("Method :notificationUpdate endss");
			return restDocumentControlDao.notificationUpdate(id, userId, organization, orgDivision);
		}
}
