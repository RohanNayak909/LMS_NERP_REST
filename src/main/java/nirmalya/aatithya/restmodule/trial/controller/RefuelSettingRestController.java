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


import nirmalya.aatithya.restmodule.trial.controller.RefuelSettingRestController;
import nirmalya.aatithya.restmodule.trial.model.RefuelSettingRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.trial.dao.RefuelSettingDao;

@RestController
@RequestMapping(value = "trial/")

public class RefuelSettingRestController {
	
	Logger logger = LoggerFactory.getLogger(RefuelSettingRestController.class);

	@Autowired
	RefuelSettingDao refuelSettingDao;
	
	// vehicle reg dropdown
		@RequestMapping(value = "get-vgreg-list", method = { RequestMethod.GET })
		public List<DropDownModel> fetchvehiclereglist (){
			logger.info("Method : getIssueList starts");

			logger.info("Method : getIssueList ends");
			return refuelSettingDao.fetchvehiclereglist();
		}
		
		
		// fuel type dropdown
		
		@RequestMapping(value = "get-ftype-list", method = { RequestMethod.GET })
		public List<DropDownModel> fetchfueltypelist (){
			logger.info("Method : getVehicleList starts");

			logger.info("Method : getVehicleList ends");
			return refuelSettingDao.fetchfueltypelist();
		}
	
	// add data
	
		@RequestMapping(value = "addRefuel-Details", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> addrefueldetails(@RequestBody RefuelSettingRestModel restPayroll) {
			logger.info("Method : addvehicleDetails starts");
			logger.info("Method : addvehicleDetails ends");
			return refuelSettingDao.addrefueldetails(restPayroll);
		} 
		
		// view data
		
		@RequestMapping(value= "viewRefuel-Details",method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<RefuelSettingRestModel>>> viewrefueldetails() {
			logger.info("Method : viewIssueDetails starts");
			logger.info("Method : viewIssueDetails ends");
			return refuelSettingDao.viewrefueldetails();
		}
		
		// edit data
		
		@RequestMapping(value = "editRefuel-Details", method= { RequestMethod.GET })	
		
		public ResponseEntity<JsonResponse<List<RefuelSettingRestModel>>> editrefueldetails(@RequestParam String id) { 
			logger.info("Method : editissue starts");

			logger.info("Method :editissue ends");
			return refuelSettingDao.editrefueldetails(id);
		}
		
		// delete data
		
		@RequestMapping(value = "deleteRefuel-Details", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleterefueldetails(@RequestParam String id) {
			logger.info("Method : deleteIssue starts");
			logger.info("Method : deleteIssue ends");
				
			return refuelSettingDao.deleterefueldetails(id);
								
			}

}
