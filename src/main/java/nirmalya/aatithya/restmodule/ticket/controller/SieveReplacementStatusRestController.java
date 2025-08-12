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
import nirmalya.aatithya.restmodule.ticket.dao.SieveReplacementStatusDao;

@RestController
@RequestMapping("ticket/")
public class SieveReplacementStatusRestController {
	Logger logger = LoggerFactory.getLogger(SieveReplacementStatusRestController.class);
	@Autowired
	SieveReplacementStatusDao sieveReplacementStatusDao;
	
	@PostMapping("rest-add-sieve-status")
	public JsonResponse<Object> addSieveStatusData(@RequestBody Map<String, Object> sieveStatusJsonData) {
	    logger.info("Method : addSieveStatusData starts");

	    logger.info("Method : addSieveStatusData ends");
	    return sieveReplacementStatusDao.addSieveStatusData(sieveStatusJsonData);
	}
	
	@GetMapping("rest-view-sieve-status")
	public JsonResponse<Object> sieveStatusView( @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :sieveStatusView start");

		logger.info("Method :sieveStatusView ends");
		return sieveReplacementStatusDao.sieveStatusView(orgName, orgDiv);
	}
	
	@GetMapping("rest-edit-sieve-status")
	public JsonResponse<Object> editSieveStatus( @RequestParam String orgName,
			@RequestParam String orgDiv,@RequestParam String slNo) {
		logger.info("Method :editSieveStatus start");

		logger.info("Method :editSieveStatus ends");
		return sieveReplacementStatusDao.editSieveStatus(orgName,orgDiv,slNo);
	}
	@GetMapping("rest-delete-sieve-status")
	public JsonResponse<Object> deleteSieveStatus(@RequestParam String serialNo, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :deleteSieveStatus start");

		logger.info("Method :deleteSieveStatus ends");
		return sieveReplacementStatusDao.deleteSieveStatus(serialNo, orgName, orgDiv);
	}
	@GetMapping("rest-approve-sieve-status")
	public JsonResponse<Object> approveSieveStatus(@RequestParam String serialNo, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :approveSieveStatus start");

		logger.info("Method :approveSieveStatus ends");
		return sieveReplacementStatusDao.approveSieveStatus(serialNo, orgName, orgDiv);
	}
}
