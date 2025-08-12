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


import nirmalya.aatithya.restmodule.trial.controller.IssueHistoryRestController;
import nirmalya.aatithya.restmodule.trial.model.IssueHistoryRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.trial.dao.IssueHistoryDao;

@RestController
@RequestMapping(value = "trial/")

public class IssueHistoryRestController {
	
	Logger logger = LoggerFactory.getLogger(IssueHistoryRestController .class);

	@Autowired
	IssueHistoryDao issueHistoryDao;
	
	// issue dropdown
	@RequestMapping(value = "get-issue-list", method = { RequestMethod.GET })
	public List<DropDownModel> getissuelist (){
		logger.info("Method : getIssueList starts");

		logger.info("Method : getIssueList ends");
		return issueHistoryDao.getissuelist();
	}
	
	
	// vehicle list dropdown
	
	@RequestMapping(value = "get-vehicle-list", method = { RequestMethod.GET })
	public List<DropDownModel> getvehiclelist (){
		logger.info("Method : getVehicleList starts");

		logger.info("Method : getVehicleList ends");
		return issueHistoryDao.getvehiclelist();
	}
	
	// vendor dropdown
	
	@RequestMapping(value = "get-vendor-list", method = { RequestMethod.GET })
	public List<DropDownModel> getvendorlist (){
		logger.info("Method : getVendorList starts");

		logger.info("Method : getVendorList ends");
		return issueHistoryDao.getvendorlist();
	}
	
	// add data
	
	@RequestMapping(value = "addvehicle-Details", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addvehicleDetails(@RequestBody IssueHistoryRestModel restPayroll) {
		logger.info("Method : addvehicleDetails starts");
		logger.info("Method : addvehicleDetails ends");
		return issueHistoryDao.addvehicleDetails(restPayroll);
	} 
	
	// view data
	
	@RequestMapping(value= "viewvehicle-Details",method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<IssueHistoryRestModel>>> viewissuedetails() {
		logger.info("Method : viewIssueDetails starts");
		logger.info("Method : viewIssueDetails ends");
		return issueHistoryDao.viewissuedetails();
	}
	
	// edit data
	
	@RequestMapping(value = "editIssue-Details", method= { RequestMethod.GET })	
	
	public ResponseEntity<JsonResponse<List<IssueHistoryRestModel>>> editissue(@RequestParam String id) { 
		logger.info("Method : editissue starts");

		logger.info("Method :editissue ends");
		return issueHistoryDao.editissue(id);
	}
	
	// delete data
	
	@RequestMapping(value = "deleteIssue-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteissue(@RequestParam String id) {
		logger.info("Method : deleteIssue starts");
		logger.info("Method : deleteIssue ends");
			
		return issueHistoryDao.deleteissue(id);
							
		}

}
