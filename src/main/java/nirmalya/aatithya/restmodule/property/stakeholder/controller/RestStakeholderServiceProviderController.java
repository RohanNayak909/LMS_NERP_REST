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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.stakeholder.dao.RestStakeholderServiceProviderDao;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStakeholderServiceProviderModel;


@RestController
@RequestMapping("property")
public class RestStakeholderServiceProviderController {
	Logger logger = LoggerFactory.getLogger(RestStakeholderServiceProviderController.class);
	@Autowired
	RestStakeholderServiceProviderDao restManageServiceProvidersDao;
	
////add
	@RequestMapping(value = "service-provider-add-RentLedger", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveServiceProviders(@RequestBody RestStakeholderServiceProviderModel serviceproviders) {
		logger.info("$$$$"+serviceproviders);
		logger.info("Method : saveServiceProviders starts");
		logger.info("restPayroll");
		logger.info("Method : saveServiceProviders ends");
		return restManageServiceProvidersDao.saveServiceProviders(serviceproviders);
	}
////view
	@RequestMapping(value = "viewServiceProviders", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStakeholderServiceProviderModel>>> ViewServiceProviders(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : ViewServiceProviders starts");

		logger.info("Method : ViewServiceProviders ends");
		return restManageServiceProvidersDao.ViewServiceProviders(userid,fromDate,toDate);
	}
	///edit
		@GetMapping(value = "service-editRentLedger")
		public ResponseEntity<JsonResponse<List<RestStakeholderServiceProviderModel>>> editServiceProviders(@RequestParam String id) {
			logger.info("Method : editServiceProviders starts");

			logger.info("Method :editServiceProviders ends"+id);
			return restManageServiceProvidersDao.editServiceProviders(id);

			}
	////delete
				@RequestMapping(value = "service-providers-delete-Service-Providers", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<Object>> deleteServiceProviders(@RequestParam String id) {
					logger.info("Method :  deleteServiceProviders starts"+id);

					logger.info("Method :  deleteServiceProviders ends");
					return restManageServiceProvidersDao. deleteServiceProviders(id);
				}

}
