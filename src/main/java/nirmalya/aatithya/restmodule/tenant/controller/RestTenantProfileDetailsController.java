package nirmalya.aatithya.restmodule.tenant.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.tenant.dao.RestTenantProfileDetailsDao;
import nirmalya.aatithya.restmodule.tenant.model.RestTenantProfileDetailsModel;

@RestController
@RequestMapping(value = { "property" })
public class RestTenantProfileDetailsController {
	Logger logger = LoggerFactory.getLogger(RestTenantProfileDetailsController.class);

	@Autowired
	RestTenantProfileDetailsDao profiledao;
	
	
	@RequestMapping(value = "profile-details-edit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestTenantProfileDetailsModel>> viewprofiledetail(@RequestParam String userid){

		logger.info("Method : viewprofiledetail starts");

		logger.info("Method : viewprofiledetail ends");
		return profiledao.viewprofiledetails(userid);
	}
	

}
