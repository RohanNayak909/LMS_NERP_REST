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
import nirmalya.aatithya.restmodule.property.stakeholder.dao.RestStakeholderTenantDao;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStakeholderTenantModel;

@RestController
@RequestMapping("property/")
public class RestStakeholderTenantController {

	Logger logger = LoggerFactory.getLogger(RestStakeholderTenantController.class);
	@Autowired
	RestStakeholderTenantDao restManageTenantDao;

////add
	@RequestMapping(value = "manage-tenant-add-tenantdetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveTenant(@RequestBody RestStakeholderTenantModel tenant) {
		logger.info("$$$$" + tenant);
		logger.info("Method : saveTenant starts");
		logger.info("restPayroll");
		logger.info("Method : saveTenant ends");
		return restManageTenantDao.saveTenant(tenant);
	}

////view
	@RequestMapping(value = "manage-tenant-viewTenant", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStakeholderTenantModel>>> ViewTenant(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : ViewTenant starts");

		logger.info("Method : ViewTenant ends");
		return restManageTenantDao.ViewTenant(userid, fromDate, toDate);
	}
	//auto search property list
	@GetMapping(value = "getPropertyListByAutoSearch")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyByAutoSearch(
			@RequestParam String id) {
		logger.info("Method : getPropertyByAutoSearch starts");

		logger.info("Method :getPropertyByAutoSearch ends");
		return restManageTenantDao.getPropertyByAutoSearch(id);
	}

	/// edit
	@GetMapping(value = "editTenant")
	public ResponseEntity<JsonResponse<List<RestStakeholderTenantModel>>> editTenant(@RequestParam String id) {
		logger.info("Method : editTenant starts");

		logger.info("Method :editTenant ends" + id);
		return restManageTenantDao.editTenant(id);

	}

	//// delete
	@RequestMapping(value = "tenant-delete-TenantDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteTenant(@RequestParam String id) {
		logger.info("Method :  deleteTenant starts" + id);

		logger.info("Method :  deleteTenant ends");
		return restManageTenantDao.deleteTenant(id);
	}

	@RequestMapping(value = "Rest-manage-tenant-Tenant", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStakeholderTenantModel>>> viewtenantdetails(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {

		logger.info("Method : viewtenantdetails starts");

		logger.info("Method : viewtenantdetails ends" + userid + fromDate + toDate);
		return restManageTenantDao.viewtenantdetails(userid, fromDate, toDate);
	}
	
	//tenant name and mail autocomplete
		@GetMapping(value = "gettenantnamemail-autocomplete")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyAutocomplete(
				@RequestParam String id) {
			logger.info("Method : getPropertyAutocomplete starts");

			logger.info("Method :getPropertyAutocomplete ends");
			return restManageTenantDao.getPropertyAutocomplete(id);
		}

}
