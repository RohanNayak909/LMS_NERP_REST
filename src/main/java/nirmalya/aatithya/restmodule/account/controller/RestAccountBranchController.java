package nirmalya.aatithya.restmodule.account.controller;

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

import nirmalya.aatithya.restmodule.account.dao.RestAccountBranchDao;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account")
public class RestAccountBranchController {
	Logger logger = LoggerFactory.getLogger(RestAccountBranchController.class);
	@Autowired
	RestAccountBranchDao restAccountBranchDao;

	/*
	 * for Add Bank
	 */
	@RequestMapping(value="addBranch" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addBranch(@RequestBody RestAccountBranchModel branchModel){
		logger.info("Method : branchModel starts");
		
		logger.info("Method : addBranch ends");
		return restAccountBranchDao.addBranch(branchModel);
	}
	

	
	
	
	
	//restViewVendorDetails
	
	/*
	 * for view
	 */
	@RequestMapping(value="restViewBranchDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestAccountBranchModel>>> restViewBranchDetails(@RequestParam String orgName, String orgDiv){
		logger.info("Method: restViewBranchDetails View Start");

		logger.info("Method: restViewBranchDetails ends");
		return restAccountBranchDao.restViewBranchDetails(orgName, orgDiv);
	}
	
	//editBankInfo
	@GetMapping(value = "editBranchInfo")
	public ResponseEntity<JsonResponse<List<RestAccountBranchModel>>> editBranchInfo(@RequestParam String id, String orgName, String orgDiv) {
		logger.info("Method :editBranchInfo starts");

		logger.info("Method :editBranchInfo ends");
		return restAccountBranchDao.editBranchInfo(id, orgName, orgDiv);
	}
	
	//delete-vendor-Details
	
	@RequestMapping(value = "deleteBranchDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteBranchDetails(@RequestParam String id, String orgName, String orgDiv) {
		logger.info("Method :  deleteBranchDetails starts"+id);

		logger.info("Method :  deleteBranchDetails ends");
		return restAccountBranchDao.deleteBranchDetails(id, orgName, orgDiv);
	}
	
	@RequestMapping(value = "getBankList", method = { RequestMethod.GET })
	public List<DropDownModel> getBankList() {
		
		logger.info("Method : getBankList starts");
		logger.info("Method : getBankListends");
		
		return restAccountBranchDao.getBankList();
	}
	
	@RequestMapping(value = "headTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> headTypeList() {
		
		logger.info("Method : headTypeList starts");
		logger.info("Method : headTypeList");
		
		return restAccountBranchDao.headTypeList();
	}
	
	//getVendorNameAutoSearch
	/*@GetMapping(value = "getVendorNameAutoSearch")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorNameAutoSearch(
			@RequestParam String id) {
		logger.info("Method : getVendorNameAutoSearch starts");

		logger.info("Method :getVendorNameAutoSearch endss");
		return restCrmVendorDao.getVendorNameAutoSearch(id);
	}*/
	
	
	@RequestMapping(value = "getBankListname",method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getbranchlist(@RequestParam String orgName,@RequestParam String orgDivision) {
		logger.info("Method : getStateLists1 starts");
		logger.info("Method : getStateLists1 ends");
		return restAccountBranchDao.getBankListname(orgName,orgDivision);
	}
}

