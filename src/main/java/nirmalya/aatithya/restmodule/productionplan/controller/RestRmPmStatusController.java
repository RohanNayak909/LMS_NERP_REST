package nirmalya.aatithya.restmodule.productionplan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.productionplan.dao.RmPmStatusDao;

@RestController
@RequestMapping(value = "production/")
public class RestRmPmStatusController {
	Logger logger = LoggerFactory.getLogger(RestRmPmStatusController.class);

	@Autowired
	RmPmStatusDao rmPmStatusDao;
	
	
	@RequestMapping(value = "rest-statusView", method = { RequestMethod.GET })
	public JsonResponse<Object> statusView(@RequestParam String orgName,String orgDivision,String state,String shift,String date) {
		logger.info("Method :statusView start");

		logger.info("Method :statusView endss");
		return rmPmStatusDao.statusView(orgName, orgDivision, state,shift, date);

	}

}
