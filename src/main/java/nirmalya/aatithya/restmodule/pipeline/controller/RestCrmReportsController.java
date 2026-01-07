package nirmalya.aatithya.restmodule.pipeline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.dao.CrmReportDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmLeadsDao;

@RestController
@RequestMapping(value = "pipeline")
public class RestCrmReportsController {
	Logger logger = LoggerFactory.getLogger(RestCrmReportsController.class);
	@Autowired
	CrmReportDao crmReportDao;
	
	@PostMapping(value = "getLeadsData")
	public @ResponseBody JsonResponse getLeadData(@RequestBody String filterObj,
			@RequestParam String userId,@RequestParam String orgName, @RequestParam String orgDivision,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :getLeadData starts");

		logger.info("Method :getLeadData ends");
		return crmReportDao.getLeadData(userId,orgName, orgDivision,fromDate,toDate,filterObj);
	}


}
