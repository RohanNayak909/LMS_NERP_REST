package nirmalya.aatithya.restmodule.asset.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetPolicyDao;
import nirmalya.aatithya.restmodule.asset.dao.AssetViewMasterDao;
import nirmalya.aatithya.restmodule.asset.model.AssetPoilcyRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.employee.dao.TravelRequsitionRestDao;
import nirmalya.aatithya.restmodule.employee.model.TravelRequisitionRestModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.qa.dao.QcMasterDao;

@RestController
@RequestMapping(value = { "asset/" })
public class AssetPolicyRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AssetPolicyDao assetPolicyDao;

	// getEmployeeListforAsset

	@RequestMapping(value = "getCategoryListforAsset", method = { RequestMethod.GET })
	public List<DropDownModel> getCategoryListforAsset(@RequestParam String org, String orgDiv, String userId) {
		logger.info("Method : getCategoryListforAsset starts");

		logger.info("Method : getCategoryListforAsset ends");
		return assetPolicyDao.getCategoryListforAsset(org, orgDiv, userId);
	}
	
	@RequestMapping(value = "getCategoryListforSparePart", method = { RequestMethod.GET })
	public List<DropDownModel> getCategoryListforSparePart(@RequestParam String org, String orgDiv, String userId) {
		logger.info("Method : getCategoryListforSparePart starts");

		logger.info("Method : getCategoryListforSparePart ends");
		return assetPolicyDao.getCategoryListforSparePart(org, orgDiv, userId);
	}

	// getEmployeeListforAsset

	@RequestMapping(value = "getPriorityListforAsset", method = { RequestMethod.GET })
	public List<DropDownModel> getPriorityList(@RequestParam String org, String orgDiv, String userId) {
		logger.info("Method : getPriorityList starts");

		logger.info("Method : getPriorityList ends");
		return assetPolicyDao.getPriorityList(org, orgDiv, userId);
	}
	
	@RequestMapping(value = "getUOMListforAsset", method = { RequestMethod.GET })
	public List<DropDownModel> getUOMList(@RequestParam String org, String orgDiv, String userId) {
		logger.info("Method : getUOMList starts");

		logger.info("Method : getUOMList ends");
		return assetPolicyDao.getUOMList(org, orgDiv, userId);
	}

	// getSubCategory
	@RequestMapping(value = "rest-asset-policy-subcategory", method = { RequestMethod.GET })
	public JsonResponse<Object> getSubCategory(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :getSubCategory start");

		logger.info("Method :getSubCategory endss");
		return assetPolicyDao.getSubCategory(id, orgName, orgDivision);
	}
	
	// getSubCategory
	@RequestMapping(value = "rest-spare-part-subcategory", method = { RequestMethod.GET })
	public JsonResponse<Object> getSubCategoryForSpare(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :getSubCategoryForSpare start");

		logger.info("Method :getSubCategoryForSpare endss");
		return assetPolicyDao.getSubCategoryForSpare(id, orgName, orgDivision);
	}

	// addAssetPolicy
	@PostMapping(value = "rest-asset-policy-add")
	public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addAssetPolicy(

			@RequestBody List<AssetPoilcyRestModel> assetPolicyModel) {
		logger.info("Method : addAssetPolicy starts");
		logger.info("Method : addAssetPolicy ends");
		return assetPolicyDao.addAssetPolicy(assetPolicyModel);
	}

	// viewAssetPolicy
	@RequestMapping(value = "rest-asset-policy-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAssetPolicy(@RequestParam String orgName, String orgDivision,String userId) {
		logger.info("Method :viewAssetPolicy start");

		logger.info("Method :viewAssetPolicy endss");
		return assetPolicyDao.viewAssetPolicy(orgName, orgDivision,userId);
	}

	// editPolicy
	@RequestMapping(value = "rest-asset-policy-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editAssetPolicy(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editAssetPolicy start");

		logger.info("Method :editAssetPolicy endss");
		return assetPolicyDao.editAssetPolicy(id, orgName, orgDivision);
	}

	// deleteQc
	@RequestMapping(value = "rest-asset-policy-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAssetPolicy(@RequestParam String id, String org, String div) {
		logger.info("Method : deleteAssetPolicy starts");

		logger.info("Method : deleteAssetPolicy ends");
		return assetPolicyDao.deleteAssetPolicy(id, org, div);

	}

	// approveQc
	@RequestMapping(value = "rest-asset-policy-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveAssetPolicy(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveAssetPolicy starts");

		logger.info("Method : approveAssetPolicy ends");
		return assetPolicyDao.approveAssetPolicy(id, org, orgDiv);

	}

	// getCategoryListforAssetApi

	@RequestMapping(value = "getCategoryListforAssetApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCategoryListforAssetApi(@RequestParam String org, String orgDiv, String userId) {
		logger.info("Method : getCategoryListforAsset starts");

		logger.info("Method : getCategoryListforAsset ends");
		return assetPolicyDao.getCategoryListforAssetApi(org, orgDiv, userId);
	}
	
	
	// getSubCategoryListforAssetApi

	@RequestMapping(value = "getSubCategoryListforAssetApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubCategoryListforAssetApi(@RequestParam String catid,String org, String orgDiv, String userId) {
		logger.info("Method : getSubCategoryListforAssetApi starts");

		logger.info("Method : getSubCategoryListforAssetApi ends");
		return assetPolicyDao.getSubCategoryListforAssetApi(catid,org, orgDiv, userId);
	}

	// getEmployeeListforAssetApi

	@RequestMapping(value = "getPriorityListforAssetApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPriorityListApi(@RequestParam String org, String orgDiv, String userId) {
		logger.info("Method : getPriorityList starts");

		logger.info("Method : getPriorityList ends");
		return assetPolicyDao.getPriorityListApi(org, orgDiv, userId);
	}
	
	// Search
	@RequestMapping(value = "rest-AssetPolicyViewSearch", method = { RequestMethod.GET })
	public JsonResponse<Object> assetPolicyViewSearch(@RequestParam String orgName, @RequestParam String orgDivision, String searchValue) {
		logger.info("Method :assetPolicyViewSearch start");

		logger.info("Method :assetPolicyViewSearch endss");
		return assetPolicyDao.assetPolicyViewSearch(orgName, orgDivision, searchValue);

	}

	// viewPropertyPolicy
		@RequestMapping(value = "rest-property-preventive-view", method = { RequestMethod.GET })
		public JsonResponse<Object> viewPropertyPolicy(@RequestParam String orgName, String orgDivision,String userId) {
			logger.info("Method :viewPropertyPolicy start");

			logger.info("Method :viewPropertyPolicy endss");
			return assetPolicyDao.viewPropertyPolicy(orgName, orgDivision,userId);
		}
//
		@RequestMapping(value = "rest-spare-part-subcategory-api", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubCategoryListApi(@RequestParam String id, String orgName, String orgDivision) {
			logger.info("Method : getSubCategoryListApi starts");

			logger.info("Method : getSubCategoryListApi ends");
			return assetPolicyDao.getSubCategoryListApi(id, orgName, orgDivision);
		}
		@RequestMapping(value = "getEmployeeListforAssetAssign", method = { RequestMethod.GET })
		public List<DropDownModel> getEmployeeListforJobview(@RequestParam String org,String orgDiv,String userId) {
			logger.info("Method : getEmployeeListforAssentAssign starts");

			logger.info("Method : getEmployeeListforAssentAssign ends");
			return assetPolicyDao.getEmployeeListforAssentAssign(org,orgDiv,userId);
		}
		// addAssetPolicy
		@PostMapping(value = "rest-main-policy-add")
		public ResponseEntity<JsonResponse<AssetPoilcyRestModel>> addAssetPolicyData(@RequestBody AssetPoilcyRestModel assetPolicyModel) {
			logger.info("Method : addAssetPolicyData starts");
			logger.info("Method : addAssetPolicyData ends");
			return assetPolicyDao.addAssetPolicyData(assetPolicyModel);
		}
		// addAssetPolicy
		@PostMapping(value = "rest-add-policy-checkList")
		public ResponseEntity<JsonResponse<AssetPoilcyRestModel>> addPolicyCheckList(@RequestBody AssetPoilcyRestModel assetPolicyModel) {
			logger.info("Method : addPolicyCheckList starts");
			logger.info("Method : addPolicyCheckList ends");
			return assetPolicyDao.addPolicyCheckList(assetPolicyModel);
		}
		// deleteQc
		@RequestMapping(value = "rest-policy-checkList-delete", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deletePolicyCheckList(@RequestParam String id, String org, String div) {
			logger.info("Method : deletePolicyCheckList starts");

			logger.info("Method : deletePolicyCheckList ends");
			return assetPolicyDao.deletePolicyCheckList(id, org, div);

		}
}
