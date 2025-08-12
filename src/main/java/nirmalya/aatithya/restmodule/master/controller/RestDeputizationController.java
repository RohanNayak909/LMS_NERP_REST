package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.master.dao.DeputizationRestDao;

import nirmalya.aatithya.restmodule.master.model.RestDeputizationModel;


@RestController
@RequestMapping(value = { "master" })

public class RestDeputizationController {
	
	Logger logger = LoggerFactory.getLogger(RestDeputizationController.class);

	@Autowired
	DeputizationRestDao deputizationRestDao;


	@RequestMapping(value = "/getFinancialYrForDeputization", method = { RequestMethod.GET })
	public List<DropDownModel> getFinancialYrForDeputization() {
		logger.info("Method : getFinancialYrForDeputization starts");

		logger.info("Method : getFinancialYrForDeputization end");
		return deputizationRestDao.getFinancialYrForDeputization();
	}

// employeeId list
	
	@GetMapping(value = "get-employee-listDeputization")
	public List<DropDownModel> getDeputization() {
		logger.info("Method : getDeputizationEmployeeList starts");

		logger.info("Method : getDeputizationEmployeeList ends");
		return deputizationRestDao.getDeputizationEmployeeList();
	}

// date list

	@GetMapping(value = "get-dateListDeputization")
	public JsonResponse<List<DropDownModel>> getDateListDeputization(@RequestParam String id) {
		logger.info("Method : getDateListDeputization starts");

		logger.info("Method : getDateListDeputization ends");
		return deputizationRestDao.getDateListDeputization(id);
	}



// add
	
	@RequestMapping(value = "rest-addnew-deputization", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> adddeputization(@RequestBody RestDeputizationModel restPayroll) {
		logger.info("Method : adddeputization starts");

		logger.info("Method : adddeputization ends");
		return deputizationRestDao.adddeputization(restPayroll);
	}
	
// view

	@RequestMapping(value = "viewdeputization", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestDeputizationModel>>> viewdeputization() {
		logger.info("Method : viewdeputization starts");

		logger.info("Method : viewdeputization ends");
		return deputizationRestDao.viewdeputization();
	}

	/*
	 *
	 * Edit  rest
	 *
	 */
	@RequestMapping(value = "rest-editDeputization-edit", method = { RequestMethod.GET })
	public JsonResponse<RestDeputizationModel> editDeputization(@RequestParam String id) {
		logger.info("Method : editDeputization rest starts");

		logger.info("Method :editDeputization rest ends");
		return deputizationRestDao.editDeputization(id);
	}
	
	// name and designation list

		@GetMapping(value = "get-nameandDesignationListDeputization")
		public JsonResponse<List<DropDownModel>> getnameAndDesignationListDeputization(@RequestParam String id) {
			logger.info("Method : getnameAndDesignationListDeputization starts");

			logger.info("Method : getnameAndDesignationListDeputization ends");
			return deputizationRestDao.getnameAndDesignationListDeputization(id);
		}

// delete 
	
	@RequestMapping(value = "rest-Deputization-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDeputization(@RequestParam String id) {
		logger.info("Method : deleteDeputization starts");

		logger.info("Method : deleteDeputization ends");
		return deputizationRestDao.deleteDeputization(id);
	}
	
	

}
