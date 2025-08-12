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
import nirmalya.aatithya.restmodule.property.stakeholder.dao.RestStackholderMaintenanceExpensesDao;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStackholderMaintenanceExpensesModel;

@RestController
@RequestMapping("property/")
public class RestStackholderMaintenanceExpensesController {

	Logger logger = LoggerFactory.getLogger(RestStackholderMaintenanceExpensesController.class);
	@Autowired
	RestStackholderMaintenanceExpensesDao restManageMaintainenceDescriptionDao;
	
////add
	@RequestMapping(value = "expenses-add-Maintainence-Description", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveMaintainenceDescription(@RequestBody RestStackholderMaintenanceExpensesModel maintainencedescription) {
		logger.info("$$$$"+maintainencedescription);
		logger.info("Method : saveMaintainenceDescription starts");
		logger.info("restPayroll");
		logger.info("Method : saveMaintainenceDescription ends");
		return restManageMaintainenceDescriptionDao.saveMaintainenceDescription(maintainencedescription);
	}
////view
	@RequestMapping(value = "expenses-viewMaintainenceDescription", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestStackholderMaintenanceExpensesModel>>> ViewMaintainenceDescription(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : ViewMaintainenceDescription starts");

		logger.info("Method : ViewMaintainenceDescription ends");
		return restManageMaintainenceDescriptionDao.ViewMaintainenceDescription(userid,fromDate,toDate);
	}
	///edit
			@GetMapping(value = "expenses-editMaintainenceDescription")
			public ResponseEntity<JsonResponse<List<RestStackholderMaintenanceExpensesModel>>> editMaintainenceDescription(@RequestParam String id) {
				logger.info("Method : editMaintainenceDescription starts");

				logger.info("Method :editMaintainenceDescription ends"+id);
				return restManageMaintainenceDescriptionDao.editMaintainenceDescription(id);

				}
		////delete
						@RequestMapping(value = "expenses-delete-MaintainenceDescription", method = { RequestMethod.GET })
						public ResponseEntity<JsonResponse<Object>> deleteMaintainenceDescription(@RequestParam String id) {
							logger.info("Method :  deleteMaintainenceDescription starts"+id);

							logger.info("Method :  deleteMaintainenceDescription ends");
							return restManageMaintainenceDescriptionDao. deleteMaintainenceDescription(id);
						}

}
