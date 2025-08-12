package nirmalya.aatithya.restmodule.grc.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.dao.FeChecklistDao;

@RestController
@RequestMapping("grc/")
public class FeChecklistRestController {
	Logger logger = LoggerFactory.getLogger(FeChecklistRestController.class);
	@Autowired
	FeChecklistDao feChecklistDao;
	
	@GetMapping("rest-checklist-master-data")
	public JsonResponse<Object> getAllMasterData( @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :getAllMasterData start");

		logger.info("Method :getAllMasterData ends");
		return feChecklistDao.getAllMasterData(orgName, orgDiv);
	}
	
	@PostMapping("rest-add-checklist")
	public JsonResponse<Object> addChecklistData(@RequestBody Map<String, Object> checklistJsonData) {
	    logger.info("Method : addChecklistData starts");

	    logger.info("Method : addChecklistData ends");
	    return feChecklistDao.addChecklistData(checklistJsonData);
	}
	
	@GetMapping("rest-view-checklist-data")
	public JsonResponse<Object> viewChecklistData( @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :viewChecklistData start");

		logger.info("Method :viewChecklistData ends");
		return feChecklistDao.viewChecklistData(orgName, orgDiv);
	}
	
	@GetMapping("rest-edit-checklist-data")
	public JsonResponse<Object> editChecklistData( @RequestParam String orgName,
			@RequestParam String orgDiv,@RequestParam String checklistId) {
		logger.info("Method :editChecklistData start");

		logger.info("Method :editChecklistData ends");
		return feChecklistDao.editChecklistData(orgName,orgDiv,checklistId);
	}
	
	@GetMapping(value = "rest-pdf-data")
	public JsonResponse<Object> generatePdfForChecklist(@RequestParam String orgName,String orgDivision,
			@RequestParam String checklistId) {
		logger.info("Method :generatePdfForChecklist starts");
		
		logger.info("Method :generatePdfForChecklist ends");
		return feChecklistDao.generatePdfForChecklist(orgName,orgDivision,checklistId);
	}
	
	@GetMapping("rest-delete-checklist-data")
	public JsonResponse<Object> deleteChecklist(@RequestParam String checklistId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :deleteChecklist start");

		logger.info("Method :deleteChecklist ends");
		return feChecklistDao.deleteChecklist(checklistId, orgName, orgDiv);
	}
	
	@GetMapping("rest-approve-checklist-data")
	public JsonResponse<Object> approveChecklist(@RequestParam String checklistId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :approveChecklist start");

		logger.info("Method :approveChecklist ends");
		return feChecklistDao.approveChecklist(checklistId, orgName, orgDiv);
	}
}
