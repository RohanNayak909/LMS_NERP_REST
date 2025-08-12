package nirmalya.aatithya.restmodule.employee.controller;
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
import nirmalya.aatithya.restmodule.employee.dao.HrmInsuranceDao;
import nirmalya.aatithya.restmodule.employee.model.RestEmployeeNomineModel;

@RestController
@RequestMapping(value = "employee/")
public class RestHrmImsuranceController {
	Logger logger = LoggerFactory.getLogger(RestHrmImsuranceController.class);

	@Autowired
	HrmInsuranceDao hrmInsuranceDao;

	
	//view
	@RequestMapping(value = "rest-insurance-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewEmployee(@RequestParam String orgName, String orgDivision, String type, String userId) {
		logger.info("Method :viewEmployee start");

		logger.info("Method :viewEmployee endss");
		return hrmInsuranceDao.viewEmployee(orgName, orgDivision, type, userId);
	}
	
	//edit 
	@RequestMapping(value = "rest-edit-insurance", method = { RequestMethod.GET })
	public JsonResponse<Object> editInsurance(@RequestParam String Id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :editInsurance start");
		logger.info("Method :editInsurance endss");
		return hrmInsuranceDao.editInsurance(Id, organization, orgDivision);
	}
	
	// save nomine
		@RequestMapping(value = "/rest-insurance-nominee-details", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> saveNomine(
				@RequestBody RestEmployeeNomineModel restEmployeeNomineModel) {
			logger.info("Method : saveNomine starts");

			logger.info("Method : saveNomine ends");
			return hrmInsuranceDao.saveNomine(restEmployeeNomineModel);
		}
		
		// view nomine
		@RequestMapping(value = "rest-view-Nomine", method = { RequestMethod.GET })
		public JsonResponse<Object> viewNomine(@RequestParam String orgName, String orgDivision, String userId,
				String employeeId) {
			logger.info("Method :viewNomine start");

			logger.info("Method :viewNomine endss");
			return hrmInsuranceDao.viewNomine(orgName, orgDivision, userId, employeeId);
		}
		
		// edit nomine
		@RequestMapping(value = "rest-hrms-insurance-details-edit", method = { RequestMethod.GET })
		public JsonResponse<Object> editNomine(@RequestParam String id, @RequestParam String organization,
				@RequestParam String orgDivision) {
			logger.info("Method :editNomine start");

			logger.info("Method :editNomine endss");
			return hrmInsuranceDao.editNomine(id, organization, orgDivision);
		}
		
		
		@RequestMapping(value = "rest-view-insurance", method = { RequestMethod.GET })
		public JsonResponse<Object> viewInsurance(@RequestParam String orgName, String orgDivision, String userId,
				String id) {
			logger.info("Method :viewInsurance start");

			logger.info("Method :viewInsurance endss");
			return hrmInsuranceDao.viewInsurance(orgName, orgDivision, userId, id);
		}
		
		
		  @RequestMapping(value = "/rest-insurance-details-add", method = {
		  RequestMethod.POST }) public ResponseEntity<JsonResponse<Object>>
		  addInsurance(
		  
		 @RequestBody RestEmployeeNomineModel restEmployeeNomineModel) {
		  logger.info("Method : addInsurance starts");
		  
		  logger.info("Method : addInsurance ends"); return
		  hrmInsuranceDao.addInsurance(restEmployeeNomineModel); }
		  
		  
			// Delete nomine
			@GetMapping(value = "rest-insurance-nomine-details-delete")
			public JsonResponse<Object> deleteNomine(@RequestParam String org, String orgDiv, String userId, String id) {
				logger.info("Method : deleteNomine starts");

				logger.info("Method : deleteNomine ends");
				return hrmInsuranceDao.deleteNomine(org, orgDiv, userId, id);
			}
}
