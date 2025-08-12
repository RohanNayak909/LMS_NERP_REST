package nirmalya.aatithya.restmodule.his.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HisNurseDasbordDao;
import nirmalya.aatithya.restmodule.his.dao.RestHISIPDDao;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

@RestController
@RequestMapping(value = "his/")
public class RestHisNurseDasbordController {
	
	Logger logger = LoggerFactory.getLogger(RestHisNurseDasbordController.class);

	@Autowired
	HisNurseDasbordDao hisNurseDasbordDao;

	//patient view
	@RequestMapping(value = "his-nurse-ipd-viewIpd", method = { RequestMethod.GET })
	public JsonResponse<Object> viewNurseIpd(@RequestParam String orgName, String orgDivision, String userId) {
		logger.info("Method :viewNurseIpd start");

		logger.info("Method :viewNurseIpd endss");
		return hisNurseDasbordDao.viewNurseIpd(orgName, orgDivision, userId);
	}
}
