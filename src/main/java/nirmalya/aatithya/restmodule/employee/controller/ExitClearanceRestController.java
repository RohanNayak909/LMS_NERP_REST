package nirmalya.aatithya.restmodule.employee.controller;

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
import nirmalya.aatithya.restmodule.employee.dao.ExitClearanceRestDao;
import nirmalya.aatithya.restmodule.employee.model.ExitFinancialSettelmentRestModel;

@RestController
@RequestMapping("employee/")
public class ExitClearanceRestController {

	Logger logger = LoggerFactory.getLogger(ExtendExitManagementRestController.class);

	@Autowired
	ExitClearanceRestDao exitClearanceDao;
	
	/*
	 * View Exit Clearance
	 * 
	 */
	@GetMapping(value = "view-exit-clearance-details")
	public JsonResponse<Object> viewExitClearance(@RequestParam String userId,String organization,String orgDivision) {
		logger.info("Method : viewExitClearance starts");

		logger.info("Method : viewExitClearance ends");

		return exitClearanceDao.viewExitClearance(userId,organization,orgDivision);
	}
	
	/*
	 * Update clearance (Department wise)
	 * 
	 */

	@PostMapping(value = "update-exit-clearance")
	public JsonResponse<Object> updateExitClearance(@RequestBody ExitFinancialSettelmentRestModel exit) {
		logger.info("Method : updateExitClearance starts");

		logger.info("Method : updateExitClearance ends");
		return exitClearanceDao.updateExitClearances(exit);
	}

	

	
}
