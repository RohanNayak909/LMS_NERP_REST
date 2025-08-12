package nirmalya.aatithya.restmodule.property.stakeholder.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.stakeholder.dao.RestStakeholderManagePropertyDao;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestManagePropertyModel;

@RestController
@RequestMapping("property/")
public class RestStakeholderManagePropertyController {
	
	Logger logger = LoggerFactory.getLogger(RestStakeholderManagePropertyController.class);
	@Autowired
	RestStakeholderManagePropertyDao restManagePropertiesDao;
	
	@RequestMapping(value = "getstackCityList", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryList starts");

		logger.info("Method : getCountryList ends");
		return restManagePropertiesDao.getAreaList();

	}
	
	@RequestMapping(value = "getproperty-type-List", method = { RequestMethod.GET })
	public List<DropDownModel> getpropertyList() {
		logger.info("Method : getpropertyList starts");

		logger.info("Method : getpropertyList ends");
		return restManagePropertiesDao.getpropertyList();

	}
	
////add
	@RequestMapping(value = "manage-property-add-propertiesdetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveProperty(@RequestBody RestManagePropertyModel property) {
		logger.info("$$$$"+property);
		logger.info("Method : saveProperty starts");
		logger.info("restPayroll");
		logger.info("Method : saveProperty ends");
		return restManagePropertiesDao.saveProperty(property);
	}
	
////view
	@RequestMapping(value = "manage-property-viewProperty", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestManagePropertyModel>>> ViewSac(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : ViewProperty starts");

		logger.info("Method : ViewProperty ends");
		return restManagePropertiesDao.ViewProperty(userid, fromDate, toDate);
	}
	///edit
		@GetMapping(value = "editProperty")
		public ResponseEntity<JsonResponse<List<RestManagePropertyModel>>> editSac(@RequestParam String id) {
			logger.info("Method : editProperty starts");

			logger.info("Method :editProperty ends"+id);
			return restManagePropertiesDao.editProperty(id);

			}
	////delete
			@RequestMapping(value = "manage-property-delete-PropertyDetails", method = { RequestMethod.GET })
			public ResponseEntity<JsonResponse<Object>> deleteSac(@RequestParam String id) {
				logger.info("Method :  deleteProperty starts"+id);

				logger.info("Method :  deleteProperty ends");
				return restManagePropertiesDao. deleteProperty(id);
			}


}
