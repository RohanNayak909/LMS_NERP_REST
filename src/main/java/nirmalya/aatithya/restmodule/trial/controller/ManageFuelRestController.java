package nirmalya.aatithya.restmodule.trial.controller;

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
import java.util.List;


import nirmalya.aatithya.restmodule.trial.controller.ManageFuelRestController;
import nirmalya.aatithya.restmodule.trial.model.ManageFuelRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.trial.dao.ManageFuelDao;


@RestController
@RequestMapping(value = "trial/")

public class ManageFuelRestController {
	
	Logger logger = LoggerFactory.getLogger(ManageFuelRestController .class);

	@Autowired
	ManageFuelDao fuelHistoryDao;
	
	@RequestMapping(value = "addfuel-Details", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addfuelDetails(@RequestBody ManageFuelRestModel restPayroll) {
		logger.info("Method : addfuelDetails starts");
		logger.info("Method : addfuelDetails ends");
		return fuelHistoryDao.addfuelDetails(restPayroll);
	} 
	
	@RequestMapping(value= "viewfuel-Details",method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ManageFuelRestModel>>> viewfueldetails() {
		logger.info("Method : viewIssueDetails starts");
		logger.info("Method : viewIssueDetails ends");
		return fuelHistoryDao.viewfueldetails();
	}
	
	@RequestMapping(value = "editfuel-Details", method= { RequestMethod.GET })	
	
	public ResponseEntity<JsonResponse<List<ManageFuelRestModel>>> editfueldetails(@RequestParam String id) { 
		logger.info("Method : editissue starts");

		logger.info("Method :editissue ends");
		return fuelHistoryDao.editfueldetails(id);
	}
	
	@RequestMapping(value = "deletefuel-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletefueldetails(@RequestParam String id) {
		logger.info("Method : deleteIssue starts");
		logger.info("Method : deleteIssue ends");
			
		return fuelHistoryDao.deletefueldetails(id);
							
		}
	
	// vehice reg dropdown
		@RequestMapping(value = "get-vehiclereg-list", method = { RequestMethod.GET })
		public List<DropDownModel> getreglist (){
			logger.info("Method : getIssueList starts");

			logger.info("Method : getIssueList ends");
			return fuelHistoryDao.getreglist();
		}
		
		
		// fuel type dropdown
		
		@RequestMapping(value = "get-fuel-list", method = { RequestMethod.GET })
		public List<DropDownModel> getfuellist (){
			logger.info("Method : getVehicleList starts");

			logger.info("Method : getVehicleList ends");
			return fuelHistoryDao.getfuellist();
		}

}
