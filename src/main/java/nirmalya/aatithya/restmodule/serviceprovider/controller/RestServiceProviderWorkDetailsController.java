package nirmalya.aatithya.restmodule.serviceprovider.controller;

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
import nirmalya.aatithya.restmodule.serviceprovider.dao.RestServiceProviderWorkDetailsDao;
import nirmalya.aatithya.restmodule.serviceprovider.model.RestServiceProviderWorkDetailsModel;
import nirmalya.aatithya.restmodule.tenant.model.RestTenantPropertyDetailsModel;

@RestController
@RequestMapping(value = { "property" })
public class RestServiceProviderWorkDetailsController {
	Logger logger = LoggerFactory.getLogger(RestServiceProviderWorkDetailsController.class);

	@Autowired
	RestServiceProviderWorkDetailsDao workdetailsdao;
	
	
	@RequestMapping(value = "work-details-view", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestServiceProviderWorkDetailsModel>>> getworkdetail(@RequestParam String userid){

		logger.info("Method : getworkdetail starts");

		logger.info("Method : getworkdetail ends"+userid);
		return workdetailsdao.viewWorkDetails(userid);
	}
	
	@RequestMapping(value = "work-details-edit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestServiceProviderWorkDetailsModel>> editworkDetails(@RequestParam String workid) {
		logger.info("Method : editworkDetails starts");

		logger.info("Method :editworkDetails ends");
		return workdetailsdao.editworkDetails(workid);
	}
	

}
