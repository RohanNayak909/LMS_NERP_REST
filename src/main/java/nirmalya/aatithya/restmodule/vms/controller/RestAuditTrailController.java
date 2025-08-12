package nirmalya.aatithya.restmodule.vms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.vms.dao.RestAuditTrailDao;
import nirmalya.aatithya.restmodule.vms.dao.RestContractLifecycleDao;

@RestController
@RequestMapping(value = { "purchase/" })
public class RestAuditTrailController {

	Logger logger = LoggerFactory.getLogger(RestAuditTrailController.class);

	@Autowired
	RestAuditTrailDao restAuditTrailDao;

	@RequestMapping(value = "rest-audit-type-list", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditTypeList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getAuditTypeList starts");

		logger.info("Method : getAuditTypeList ends");
		return restAuditTrailDao.getAuditTypeList(org, orgDiv);
	}

	// audit-log-data
	@RequestMapping(value = "audit-log-data", method = { RequestMethod.GET })
	public JsonResponse<Object> getAuditLogData(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String type) {

		logger.info("Method :getAuditLogData starts");

		logger.info("Method :getAuditLogData endss");
		return restAuditTrailDao.getAuditLogData(fromDate, toDate, type);
	}

}
