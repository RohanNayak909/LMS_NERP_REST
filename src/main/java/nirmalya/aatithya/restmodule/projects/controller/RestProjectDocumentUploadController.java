package nirmalya.aatithya.restmodule.projects.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.dao.ProjectDocumentUploadDao;
import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModel;

@RestController
@RequestMapping("projects/")
public class RestProjectDocumentUploadController {
	Logger logger = LoggerFactory.getLogger(RestProjectDocumentUploadController.class);

	@Autowired
	ProjectDocumentUploadDao projectDocumentUploadDao;
	
	
	@RequestMapping(value = "rest-project-document-type", method = { RequestMethod.GET })
	public List<DropDownModel> projectdocumenttype(@RequestParam String id) {

		logger.info("Method : projectdocumenttype starts");
		logger.info("Method : projectdocumenttype ends");

		return projectDocumentUploadDao.projectdocumenttypeDao(id);
	}
	
	@RequestMapping(value = "rest-addDocumentTpeUpload", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addDocumentTpeUpload(
			@RequestBody List<ProjectCreationRestModel> documentUploaad) {
		logger.info("Method : addDocumentTpeUpload starts");

		logger.info("Method : addDocumentTpeUpload ends");

		return projectDocumentUploadDao.addDocumentTpeUploadDao(documentUploaad);
	}
	
	@RequestMapping(value = "rest-getAlldocumentView", method = { RequestMethod.GET })

	public JsonResponse<Object> getAlldocumentView(@RequestParam String id,@RequestParam String id2,
			@RequestParam String userid,@RequestParam String org,@RequestParam String div) {
		logger.info("Method :getAlldocumentView start");

		logger.info("Method :getAlldocumentView endss");
		return projectDocumentUploadDao.getAlldocumentView(id,id2,userid,org,div);
	}
	
	/*
	 * @RequestMapping(value = "rest-saveTemplate", method = { RequestMethod.POST })
	 * public ResponseEntity<JsonResponse<Object>> saveTemplate(
	 * 
	 * @RequestBody ProjectCreationRestModel saveTemplate) {
	 * logger.info("Method : saveTemplate starts");
	 * 
	 * logger.info("Method : saveCategory ends"); return
	 * projectDocumentUploadDao.saveTemplateDao(saveTemplate); }
	 */
	@RequestMapping(value = "rest-viewtemplate", method = { RequestMethod.GET })

	public JsonResponse<Object> viewtemplate(@RequestParam String userid, @RequestParam String org,
			@RequestParam String div,@RequestParam String id) {
		logger.info("Method :viewtemplate start");

		logger.info("Method :viewtemplate endss");
		return projectDocumentUploadDao.viewtemplate(userid, org, div,id);
	}
	
	
	@RequestMapping(value = "rest-addTemplateUpload", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addTemplateUpload(
			@RequestBody List<ProjectCreationRestModel> documentUploaad) {
		logger.info("Method : addTemplateUpload starts");

		logger.info("Method : addTemplateUpload ends");

		return projectDocumentUploadDao.addTemplateUploadDao(documentUploaad);
	}
	
	@RequestMapping(value = "rest-getAlltemplateView", method = { RequestMethod.GET })

	public JsonResponse<Object> getAlltemplateView(@RequestParam String id,
			@RequestParam String userid,@RequestParam String org,@RequestParam String div) {
		logger.info("Method :getAlltemplateView start");

		logger.info("Method :getAlltemplateView endss");
		return projectDocumentUploadDao.getAlltemplateView(id,userid,org,div);
	}
	
	

}
