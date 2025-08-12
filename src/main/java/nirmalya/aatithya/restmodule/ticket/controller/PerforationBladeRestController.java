package nirmalya.aatithya.restmodule.ticket.controller;

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
import nirmalya.aatithya.restmodule.ticket.dao.PerforationBladeRecordDao;

@RestController
@RequestMapping("ticket/")
public class PerforationBladeRestController {
	Logger logger = LoggerFactory.getLogger(PerforationBladeRestController.class);
	@Autowired
	PerforationBladeRecordDao perforationBladeRecordDao;
	 
	@PostMapping("rest-add-perforation-data")
	public JsonResponse<Object> addPerforationBladeRecord(@RequestBody Map<String, Object> perforationJsonData) {
	    logger.info("Method : addPerforationBladeRecord starts");

	    logger.info("Method : addPerforationBladeRecord ends");
	    return perforationBladeRecordDao.addPerforationBladeRecord(perforationJsonData);
	}
	
	@GetMapping("rest-view-perforation-data")
	public JsonResponse<Object> viewPerforationRecord( @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :viewPerforationRecord start");

		logger.info("Method :viewPerforationRecord ends");
		return perforationBladeRecordDao.viewPerforationRecord(orgName, orgDiv);
	}
	
	@GetMapping("rest-edit-perforation-data")
	public JsonResponse<Object> editPerforationRecordData( @RequestParam String orgName,
			@RequestParam String orgDiv,@RequestParam String recordId) {
		logger.info("Method :editPerforationRecordData start");

		logger.info("Method :editPerforationRecordData ends");
		return perforationBladeRecordDao.editPerforationRecordData(orgName,orgDiv,recordId);
	}
	
	@GetMapping("rest-delete-perforation-data")
	public JsonResponse<Object> deletPerforationRecord(@RequestParam String recordId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :deletPerforationRecord start");

		logger.info("Method :deletPerforationRecord ends");
		return perforationBladeRecordDao.deletPerforationRecord(recordId, orgName, orgDiv);
	}
	
	@GetMapping(value = "rest-pdf-data")
	public JsonResponse<Object> generatePdfForPerforationRecord(@RequestParam String orgName,String orgDivision,
			@RequestParam String recordId) {
		logger.info("Method :generatePdfForPerforationRecord starts");
		
		logger.info("Method :generatePdfForPerforationRecord ends");
		return perforationBladeRecordDao.generatePdfForPerforationRecord(orgName,orgDivision,recordId);
	}
	@GetMapping("rest-approve-perforation-data")
	public JsonResponse<Object> approvePerforationRecord(@RequestParam String recordId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :approvePerforationRecord start");

		logger.info("Method :approvePerforationRecord ends");
		return perforationBladeRecordDao.approvePerforationRecord(recordId, orgName, orgDiv);
	}
}
