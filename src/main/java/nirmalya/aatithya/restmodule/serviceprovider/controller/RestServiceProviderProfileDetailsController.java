package nirmalya.aatithya.restmodule.serviceprovider.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.serviceprovider.dao.RestServiceProviderProfileDetailsDao;
import nirmalya.aatithya.restmodule.serviceprovider.model.RestServiceProviderProfileDetailsModel;


@RestController
@RequestMapping(value = { "property" })
public class RestServiceProviderProfileDetailsController {
	Logger logger = LoggerFactory.getLogger(RestServiceProviderProfileDetailsController.class);

	@Autowired
	RestServiceProviderProfileDetailsDao profiledao;
	
	@RequestMapping(value = "serviceprovider-profile-edit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestServiceProviderProfileDetailsModel>> viewprofiledetail(@RequestParam String userid){

		logger.info("Method : viewprofiledetail starts");

		logger.info("Method : viewprofiledetail ends"+userid);
		return profiledao.viewprofiledetails(userid);
	}

}
