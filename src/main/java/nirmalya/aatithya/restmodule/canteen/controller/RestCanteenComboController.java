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

import nirmalya.aatithya.restmodule.canteen.dao.RestCanteenComboDao;

import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@RestController
@RequestMapping("canteen/")
public class RestCanteenComboController {

	Logger logger = LoggerFactory.getLogger(RestCanteenComboController.class);

	@Autowired
	RestCanteenComboDao restCanteenComboDao;

	

	
	  @RequestMapping(value = "getComboCatagory", method = { RequestMethod.GET })
	  public List<DropDownModel> getIncentive() {
	  logger.info("Method : getIncentive starts");
	  
	  logger.info("Method : getIncentive ends"); return restCanteenComboDao.getincentive();
	  
	  }
	  
	  @RequestMapping(value = "getComboSubCatagiry", method = { RequestMethod.GET })
	  public List<DropDownModel> getClubMembers() {
	  logger.info("Method : getClubMembers starts");
	  
	  logger.info("Method : getClubMembers ends"); return
	  restCanteenComboDao.getClubMembers();
	  
	  }
	  
	  @RequestMapping(value = "getCombovariants", method = { RequestMethod.GET }) public
	  List<DropDownModel> getvariants() {
	  logger.info("Method : getvariants starts");
	  
	  logger.info("Method : getvariants ends"); return restCanteenComboDao.getvariants();
	  
	  }
	 
	
	//Add
	@RequestMapping(value="restcomboadd" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addIncentive(@RequestBody  RestMenuModel incentiveDetails) 
	{
		logger.info("Method : addrestcomboadddetails starts");
		
		logger.info("Method : addrestcomboadddetails ends");
		
		return restCanteenComboDao.addIncentiveDetails(incentiveDetails);
	}
	

	//View
		@RequestMapping(value="rest-canteen-item-list" , method = {RequestMethod.GET})
		public ResponseEntity<JsonResponse<List<RestMenuModel>>> restViewShoukeenIncentive( String CatId ,String SubCatId ,String variant ){
			logger.info("Method: restViewCombo View Start");
			
			logger.info("Method: restViewCombo ends");
			return restCanteenComboDao.viewCombo(CatId, SubCatId, variant);
		}
		

		//View
			@RequestMapping(value="restViewAllDetails" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestMenuModel>>> restViewShoukeenIncentive(){
				logger.info("Method: restviewcomboallDetails View Start");
				
				logger.info("Method: restviewcomboallDetails ends");
				return restCanteenComboDao.viewShoukeenIncentive();
			}
			
		//View
			@RequestMapping(value="viewRowdata" , method = {RequestMethod.GET})
			public ResponseEntity<JsonResponse<List<RestMenuModel>>> restviewRowdata( String itemId ){
				logger.info("Method: restviewRowdata View Start");
				
				logger.info("Method: restviewRowdata ends");
				return restCanteenComboDao.viewRowdata(itemId);
			}
			
	
		//Searching
			@GetMapping(value = "getProductSList")
			public ResponseEntity<JsonResponse<List<RestMenuModel>>> getProductSearchList(@RequestParam String id) {
				logger.info("Method : getProductSearchList starts");

				logger.info("Method :getProductSearchList endss");
				return restCanteenComboDao.getProductList(id);
			}
		
			
		//Edit
			@GetMapping(value = "editcanteencombo")
			public ResponseEntity<JsonResponse<List<RestMenuModel>>> editShoukeenincentiveInfo(
					@RequestParam String id) {
				logger.info("Method :editcanteencombo starts");

				logger.info("Method :editcanteencombo ends" + id);
				return restCanteenComboDao.editcanteencombo(id);
				
			}
			
			
		//Delete
			@RequestMapping(value = "deleteComboDetails", method = { RequestMethod.GET })
			public ResponseEntity<JsonResponse<Object>> restdeleteComboDetails(@RequestParam String id) {
				logger.info("Method : restdeleteComboDetails starts"+id);

				logger.info("Method :  deleteComboDetails ends");
				return restCanteenComboDao.deleteComboDetails(id);
			}
	

}
