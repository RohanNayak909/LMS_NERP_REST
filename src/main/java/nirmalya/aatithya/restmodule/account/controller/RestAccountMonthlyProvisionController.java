package nirmalya.aatithya.restmodule.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.RestAccountMonthlyProvisionDao;
import nirmalya.aatithya.restmodule.account.model.RestMonthlyProvisionModel;

@RestController
@RequestMapping(value = "account")
public class RestAccountMonthlyProvisionController {
	Logger logger = LoggerFactory.getLogger(RestAccountMonthlyProvisionController.class);

	@Autowired
	RestAccountMonthlyProvisionDao restAccountMonthlyProvisionDao;
	
	  //drop down of event manage page starts here 
		
		 /* @RequestMapping(value = "rest-getYearList", method = { RequestMethod.GET })
		  public List<DropDownModel> getYearList() {
		  logger.info("Method : getYearList starts");
		  
		  logger.info("Method : getYearList ends"); return
		 restAccountMonthlyProvisionDao.getYearListDao(); 
		  }*/
		 
	
	
	@RequestMapping(value = "getCategoryAutoSearchList", method = { RequestMethod.GET })
	public JsonResponse<Object> getCategoryAutoSearchList(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method :getCategoryAutoSearchList start");

		logger.info("Method :getCategoryAutoSearchList endss");
		return restAccountMonthlyProvisionDao.getCategoryAutoSearchList(id, org, orgDiv);
	}
	    // add

		@RequestMapping(value = "rest-addmonthlyprovisionMasterdetails", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> addmonthlyprovisionMaster(@RequestBody RestMonthlyProvisionModel restProvision) {
			logger.info("Method : addmonthlyprovisionMaster starts");
			logger.info("Method : addmonthlyprovisionMaster ends");
			return restAccountMonthlyProvisionDao.addmonthlyprovisionMasterdetails(restProvision);
		}
		
		///view
		
		@GetMapping(value = "rest-viewMonthlyprovision")
		public JsonResponse<List<RestMonthlyProvisionModel>> restviewMonthlyprovision(@RequestParam String year,@RequestParam String month) {
			logger.info("Method : restviewMonthlyprovision");

			logger.info("Method : restviewMonthlyprovision ends");
			return restAccountMonthlyProvisionDao.restviewMonthlyprovision(year,month);
		}
		
		//edit
		@RequestMapping(value = "editmonthlyprovision", method = { RequestMethod.GET })
		public JsonResponse<RestMonthlyProvisionModel> editmonthlyprovision(@RequestParam String id) {
			logger.info("Method : editmonthlyprovision rest starts");

			logger.info("Method :editmonthlyprovision rest ends");
			return restAccountMonthlyProvisionDao.editmonthlyprovision(id);
		}
		
		// delete

		@RequestMapping(value = "rest-monthlyprovision-delete", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deletemonthlyprovision(@RequestParam String id) {
			logger.info("Method : deletemonthlyprovision starts");

			logger.info("Method : deletemonthlyprovision ends");
			return restAccountMonthlyProvisionDao.deletemonthlyprovision(id);
		}
      
}



