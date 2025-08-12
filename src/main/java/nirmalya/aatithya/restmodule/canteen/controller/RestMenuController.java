package nirmalya.aatithya.restmodule.canteen.controller;

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

import nirmalya.aatithya.restmodule.canteen.dao.RestMenuDao;
import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@RestController
@RequestMapping("canteen/")
public class RestMenuController {
	

	Logger logger = LoggerFactory.getLogger(RestMenuController.class);

	@Autowired
	RestMenuDao restMenuDao;

	

	@RequestMapping(value = "getIncentive", method = { RequestMethod.GET })
	public List<DropDownModel> getIncentive() {
		logger.info("Method : getIncentive starts");

		logger.info("Method : getIncentive ends");
		return restMenuDao.getincentive();

	}
	
	@RequestMapping(value = "getClubMembers", method = { RequestMethod.GET })
	public List<DropDownModel> getClubMembers() {
		logger.info("Method : getClubMembers starts");

		logger.info("Method : getClubMembers ends");
		return restMenuDao.getClubMembers();

	}
	
	
	@RequestMapping(value = "getvariants", method = { RequestMethod.GET })
	public List<DropDownModel> getvariants() {
		logger.info("Method : getvariants starts");

		logger.info("Method : getvariants ends");
		return restMenuDao.getvariants();

	}
	
	
	//Add
	@RequestMapping(value="restmenuadd" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addIncentive(@RequestBody RestMenuModel incentiveDetails , String orgName, String orgDivision) 
	{
		logger.info("Method : addrestaddincentivesdetails starts");
		
		logger.info("Method : addrestaddincentivesdetails ends");
		
		return restMenuDao.addIncentiveDetails(incentiveDetails , orgName, orgDivision);
	}
	

	//View
		@RequestMapping(value="restViewIncentiveDetails" , method = {RequestMethod.GET})
		
		public ResponseEntity<JsonResponse<List<RestMenuModel>>> restViewIncentiveDetails(){
			logger.info("Method: restViewincentivesdetails View Start");
			
			logger.info("Method: restViewincentivesdetails ends");
			return restMenuDao.restViewIncentiveDetails();
		}
		
		
	//Edit
		@GetMapping(value = "editincentivedetailInfo")
		public ResponseEntity<JsonResponse<List<RestMenuModel>>> editincentivedetailInfo(
				@RequestParam String id) {
			logger.info("Method :editincentivedetailInfo starts");

			logger.info("Method :editincentivedetailInfo ends" + id);
			return restMenuDao.editincentivedetailInfo(id);		
		}
		
		
		
		//Delete
		@RequestMapping(value = "delete-inceDetails", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteIncentiveDetails(@RequestParam String id) {
			logger.info("Method : deleteincentiveDetails starts"+id);

			logger.info("Method :  deleteincentiveDetails ends");
			return restMenuDao.deleteIncentiveDetails(id);
		}
		
	

}
