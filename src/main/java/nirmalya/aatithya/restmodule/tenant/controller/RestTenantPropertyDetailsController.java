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
import nirmalya.aatithya.restmodule.tenant.dao.RestTenantPropertyDetailsDao;
import nirmalya.aatithya.restmodule.tenant.model.RestTenantPropertyDetailsModel;

@RestController
@RequestMapping(value = { "property/" })
public class RestTenantPropertyDetailsController {
	Logger logger = LoggerFactory.getLogger(RestTenantPropertyDetailsController.class);

	@Autowired
	RestTenantPropertyDetailsDao propertydetailsdao;
	
	@RequestMapping(value = "property-view-throughAjax", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestTenantPropertyDetailsModel>>> viewpropertydetail(@RequestParam String userid){

		logger.info("Method : viewpropertydetail starts"+userid);

		logger.info("Method : viewpropertydetail ends");
		return propertydetailsdao.viewpropertydetails(userid);
	}
	
	@RequestMapping(value = "property-details-edit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestTenantPropertyDetailsModel>> editpropertyDetails(@RequestParam String propertyno) {
		logger.info("Method : editpropertyDetails starts");

		logger.info("Method :editpropertyDetails ends");
		return propertydetailsdao.editpropertyDetails(propertyno);
	}
	

}
	