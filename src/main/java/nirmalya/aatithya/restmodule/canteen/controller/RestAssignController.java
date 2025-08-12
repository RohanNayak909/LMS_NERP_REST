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

import nirmalya.aatithya.restmodule.canteen.dao.AssignDao;
import nirmalya.aatithya.restmodule.canteen.dao.RestMenuDao;
import nirmalya.aatithya.restmodule.canteen.model.RestAssignComboModel;
import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.model.HISBedMasterRestModel;

@RestController
@RequestMapping("canteen/")
public class RestAssignController {

	Logger logger = LoggerFactory.getLogger(RestMenuController.class);

	@Autowired
	AssignDao assignDao;

	@RequestMapping(value = "getAssignCatagory", method = { RequestMethod.GET })
	public List<DropDownModel> getIncentive() {
		logger.info("Method : getIncentive starts");

		logger.info("Method : getIncentive ends");
		return assignDao.getincentive();

	}

	@RequestMapping(value = "getAssignSubCatagiry", method = { RequestMethod.GET })
	public List<DropDownModel> getClubMembers() {
		logger.info("Method : getClubMembers starts");

		logger.info("Method : getClubMembers ends");
		return assignDao.getClubMembers();

	}

	@RequestMapping(value = "getAssignvariants", method = { RequestMethod.GET })
	public List<DropDownModel> getvariants() {
		logger.info("Method : getvariants starts");

		logger.info("Method : getvariants ends");
		return assignDao.getvariants();

	}

	@RequestMapping(value = "getAssigncomboDetails", method = { RequestMethod.GET })
	public List<DropDownModel> getcombo() {
		logger.info("Method : getcombo starts");

		logger.info("Method : getcombo ends");
		return assignDao.getcombo();

	}

	// View
	@RequestMapping(value = "rest-assign-item-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestMenuModel>>> restViewShoukeenIncentive(String CatId, String SubCatId,
			String variant, String combo) {
		logger.info("Method: restViewCombo View Start");

		logger.info("Method: restViewCombo ends");
		return assignDao.viewAssign(CatId, SubCatId, variant, combo);
	}
	
	// View
		@RequestMapping(value = "rest-assign-combo-list", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<RestMenuModel>>> restViewShoukeenIncentive(String comboId
				) {
			logger.info("Method: restViewCombo View Start");

			logger.info("Method: restViewCombo ends");
			return assignDao.viewAssignCombo(comboId);
		}


	// View
	/*
	 * @RequestMapping(value = "restViewAssignDetails", method = { RequestMethod.GET
	 * }) public ResponseEntity<JsonResponse<List<RestMenuModel>>>
	 * restViewShoukeenIncentive() {
	 * logger.info("Method: restViewincentivesdetails View Start");
	 * 
	 * logger.info("Method: restViewincentivesdetails ends"); return
	 * assignDao.viewShoukeenIncentive(); }
	 */

	// Searching
	@GetMapping(value = "getProductSassign")
	public ResponseEntity<JsonResponse<List<RestMenuModel>>> getProductSearchList(@RequestParam String id) {
		logger.info("Method : getProductSearchList starts");

		logger.info("Method :getProductSearchList endss");
		return assignDao.getProductList(id);
	}

	// Searching
	@GetMapping(value = "getComboAssign")
	public ResponseEntity<JsonResponse<List<RestMenuModel>>> getComboSearchList(@RequestParam String id) {
		logger.info("Method : getComboSearchList starts");

		logger.info("Method :getComboSearchList endss");
		return assignDao.getComboList(id);
	}
	
	
	//Add
		@RequestMapping(value="restassign-add" , method={RequestMethod.POST})
		public ResponseEntity<JsonResponse<Object>> restaddassign(@RequestBody RestAssignComboModel restAssignComboModel ) 
		{
			logger.info("Method : addrestAssignComboModel starts");
			
			logger.info("Method : addrestAssignComboModel ends");
			
			return assignDao.addAssignComboModel(restAssignComboModel);
		}
		
		//view
		@RequestMapping(value = "rest-viewAssign", method = { RequestMethod.GET })
		public JsonResponse<Object> viewAssign(@RequestParam String orgName, String orgDivision) {
			logger.info("Method :viewAssign start");

			logger.info("Method :viewAssign endss");
			return assignDao.viewAssign(orgName, orgDivision);
		}
		
		// edit
				@RequestMapping(value = "rest-assign-edit-dtls", method = { RequestMethod.GET })
				public JsonResponse<Object> editAssign(@RequestParam String id, String orgName, String orgDivision) {
					logger.info("Method :editAssign start");

					logger.info("Method :editAssign endss");
					return assignDao.editAssign(id, orgName, orgDivision);
				}
				
				//Delete
				@RequestMapping(value = "rest-deleteAssign", method = { RequestMethod.GET })
				public ResponseEntity<JsonResponse<Object>> deleteAssign(@RequestParam String id, String orgName, String orgDivision) {
				    logger.info("Method : deleteAssign starts in controller");

				    logger.info("Method : deleteAssign ends in controller");
				    return assignDao.deleteAssign(id,orgName,orgDivision);
				    
				}
}
