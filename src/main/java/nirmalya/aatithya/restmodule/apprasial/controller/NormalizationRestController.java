package nirmalya.aatithya.restmodule.apprasial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.apprasial.dao.AppraisalGoalRestDao;
import nirmalya.aatithya.restmodule.apprasial.dao.NormalizationRestDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = { "appraisal/" })
public class NormalizationRestController {

	Logger logger = LoggerFactory.getLogger(NormalizationRestController.class);

	@Autowired
	NormalizationRestDao normalizationDao;
	
	@RequestMapping(value = "rest-get-all-reviewed-employee", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllReviewedEmployee(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :getAllReviewedEmployee start");
		logger.info("Method :getAllReviewedEmployee endss");
		return normalizationDao.getAllReviewedEmployee(orgName, orgDivision);
	}



}
