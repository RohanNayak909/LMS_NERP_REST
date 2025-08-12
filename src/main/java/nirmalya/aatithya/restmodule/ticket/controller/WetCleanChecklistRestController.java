package nirmalya.aatithya.restmodule.ticket.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.ticket.dao.JobViewDao;
import nirmalya.aatithya.restmodule.ticket.dao.WetCleanChecklistDao;
@RestController
@RequestMapping("ticket/")
public class WetCleanChecklistRestController {
	Logger logger = LoggerFactory.getLogger(WetCleanChecklistRestController.class);
	
	@Autowired
	WetCleanChecklistDao wetCleanChecklistDao;
	
	@Autowired
	JobViewDao jobViewDao;
	
	@GetMapping("rest-wet-clean-master-data")
	public JsonResponse<Object> getWetCleanChecklistMasterData( @RequestParam String orgName,
			@RequestParam String orgDiv,@RequestParam String selectedPhase) {
		logger.info("Method :getWetCleanChecklistMasterData start");

		logger.info("Method :getWetCleanChecklistMasterData ends");
		return wetCleanChecklistDao.getWetCleanChecklistMasterData(orgName,orgDiv,selectedPhase);
	}
	
	@PostMapping("rest-add-wet-checklist")
	public JsonResponse<Object> addWetCleanChecklistData(@RequestBody Map<String, Object> checklistJsonData) {
	    logger.info("Method : addWetCleanChecklistData starts");

	    logger.info("Method : addWetCleanChecklistData ends");
	    return wetCleanChecklistDao.addWetCleanChecklistData(checklistJsonData);
	}
	
	@GetMapping("rest-view-wet-clean-data")
	public JsonResponse<Object> viewWetCleanChecklist( @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :viewWetCleanChecklist start");

		logger.info("Method :viewWetCleanChecklist ends");
		return wetCleanChecklistDao.viewWetCleanChecklist(orgName,orgDiv);
	}
	
	@GetMapping("rest-wet-clean-data-edit")
	public JsonResponse<Object> wetCleanChecklistEdit( @RequestParam String orgName,
			@RequestParam String orgDiv,@RequestParam String phaseStatus,@RequestParam String checklistId) {
		logger.info("Method :wetCleanChecklistEdit start");

		logger.info("Method :wetCleanChecklistEdit ends");
		return wetCleanChecklistDao.wetCleanChecklistEdit(orgName,orgDiv,phaseStatus,checklistId);
	}
	
	@GetMapping("rest-delete-wet-checklist-data")
	public JsonResponse<Object> deleteWetCleanChecklist(@RequestParam String checklistId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :deleteWetCleanChecklist start");

		logger.info("Method :deleteWetCleanChecklist ends");
		return wetCleanChecklistDao.deleteWetCleanChecklist(checklistId, orgName, orgDiv);
	}
	
	@GetMapping("rest-approve-wet-checklist-data")
	public JsonResponse<Object> approveWetCleanChecklist(@RequestParam String checklistId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :approveWetCleanChecklist start");

		logger.info("Method :approveWetCleanChecklist ends");
		return wetCleanChecklistDao.approveWetCleanChecklist(checklistId, orgName, orgDiv);
	}
	
	@GetMapping(value = "getEmployeeListforJob")
	public JsonResponse<Object> getEmployeeListforJob(@RequestParam String org,String orgDiv,String userId) {
		logger.info("Method :getEmployeeListforJob start");

		logger.info("Method :getEmployeeListforJob ends");
		return wetCleanChecklistDao.getEmployeeListforJob(org,orgDiv,userId);

	}
	
	@GetMapping(value = "rest-wet-checklist-pdf-data")
	public JsonResponse<Object> generatePdfForWetChecklisr(@RequestParam String orgName,String orgDivision,
			@RequestParam String checklistId,@RequestParam String phaseStatus) {
		logger.info("Method :generatePdfForWetChecklisr starts");
		
		logger.info("Method :generatePdfForWetChecklisr ends");
		return wetCleanChecklistDao.generatePdfForWetChecklisr(orgName,orgDivision,checklistId,phaseStatus);
	}
}
