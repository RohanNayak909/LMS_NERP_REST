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

import nirmalya.aatithya.restmodule.asset.dao.AssetViewMasterDao;
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
public class AssetViewMasterRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AssetViewMasterDao assetViewMasterDao;

 
	// addAsset
	@PostMapping(value = "rest-asset-add")
	public JsonResponse<Object> addAsset(@RequestBody List<AssetViewMasterRestModel> assetMasterModel) {
		logger.info("Method : addAsset starts");
		logger.info("Method : addAsset ends");
		return assetViewMasterDao.addAsset(assetMasterModel);
	}
	
	@PostMapping(value = "rest-asset-management-add")
	public JsonResponse<Object> addAssetDetails(

			@RequestBody AssetViewMasterRestModel assetMasterModel) {
		logger.info("Method : addAssetDetails starts");
		logger.info("Method : addAssetDetails ends");
		return assetViewMasterDao.addAssetDetails(assetMasterModel);
	}

	// viewAsset
	@RequestMapping(value = "rest-view-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAsset(@RequestParam String orgName, String orgDivision, String type, String userId) {
		logger.info("Method :viewAsset start");

		logger.info("Method :viewAsset endss");
		return assetViewMasterDao.viewAsset(orgName, orgDivision,type,userId);
	}

	// editAsset
	@RequestMapping(value = "rest-edit-asset", method = { RequestMethod.GET })
	public JsonResponse<Object> editAsset(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editAsset start");

		logger.info("Method :editAsset endss");
		return assetViewMasterDao.editAsset(id, orgName, orgDivision);
	}

	// deleteAsset
	@RequestMapping(value = "rest-delete-asset", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAsset(@RequestParam String id, String org, String div) {
		logger.info("Method : deleteAsset starts");

		logger.info("Method : deleteAsset ends");
		return assetViewMasterDao.deleteAsset(id, org, div);

	}

	// deleteAsset
	@RequestMapping(value = "rest-delete-asset-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAssetDetails(@RequestParam String id, String type, String assetId, String org, String orgDiv) {
		logger.info("Method : deleteAssetDetails starts");

		logger.info("Method : deleteAssetDetails ends");
		return assetViewMasterDao.deleteAssetDetails(id, type, assetId, org, orgDiv);

	}
	// scrapAsset
	@RequestMapping(value = "rest-asset-code-scrap", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> scarpAsset(@RequestParam String id,String status, String org, String div,String assetDescsts) {
		logger.info("Method : scarpAsset starts");

		logger.info("Method : scarpAsset ends");
		return assetViewMasterDao.scarpAsset(id,status, org, div,assetDescsts);

	}

	// approveAsset
	@RequestMapping(value = "rest-approve-asset", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveAsset(@RequestParam String id,String pdate,String assetname,String purchaseno,String assettype, String org, String orgDiv) {
		logger.info("Method : approveAsset starts");

		logger.info("Method : approveAsset ends");
		return assetViewMasterDao.approveAsset(id,pdate,assetname, purchaseno, assettype, org, orgDiv);

	}
	
	//getEmployeeListforAsset
	@RequestMapping(value = "getEmployeeListforAsset", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeListforAsset(@RequestParam String org,String orgDiv,String userId) {
		logger.info("Method : getEmployeeListforAsset starts");

		logger.info("Method : getEmployeeListforAsset ends");
		return assetViewMasterDao.getEmployeeListforAsset(org,orgDiv,userId);
	}
	
	//getLocationListforAsset
	@RequestMapping(value = "getLocationListforAsset", method = { RequestMethod.GET })
	public List<DropDownModel> getLocationListforAsset(@RequestParam String org,String orgDiv,String userId) {
		logger.info("Method : getLocationListforAsset starts");

		logger.info("Method : getLocationListforAsset ends");
		return assetViewMasterDao.getLocationListforAsset(org,orgDiv,userId);
	}
	// assignAsset
	@RequestMapping(value = "rest-asset-master-code-assign", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> assignAsset(@RequestParam String id,String assetcat,String assetemp,String assigndate, String org, String orgDiv) {
		logger.info("Method : assignAsset starts");

		logger.info("Method : assignAsset ends");
		return assetViewMasterDao.assignAsset(id,assetcat,assetemp,assigndate, org, orgDiv);

	}
	// sparepartAsset
	@RequestMapping(value = "rest-sparepart-master-code-assign", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> sparepartAsset(@RequestParam String id,String assetcat,String assetemp,String assigndate,String qty, String org, String orgDiv) {
		logger.info("Method : sparepartAsset starts");

		logger.info("Method : sparepartAsset ends");
		return assetViewMasterDao.sparepartAsset(id,assetcat,assetemp,assigndate,qty, org, orgDiv);

	}
	
	// assetHistory
	@RequestMapping(value = "rest-asset-master-history", method = { RequestMethod.GET })
	public JsonResponse<Object> historyAsset(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :historyAsset start");

		logger.info("Method :historyAsset endss");
		return assetViewMasterDao.historyAsset(id, orgName, orgDivision);
	}
	
	
	//getEmployeeListforAssetAPI
	@RequestMapping(value = "getEmployeeListforAssetApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeListforAssetApi(@RequestParam String org,String orgDiv,String userId) {
		logger.info("Method : getEmployeeListforAsset starts");

		logger.info("Method : getEmployeeListforAsset ends");
		return assetViewMasterDao.getEmployeeListforAssetApi(org,orgDiv,userId);
	}
	

	//getLocationListforAssetApi
	@RequestMapping(value = "getLocationListforAssetApi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getLocationListforAssetApi(@RequestParam String org,String orgDiv,String userId) {
		logger.info("Method : getLocationListforAsset starts");

		logger.info("Method : getLocationListforAsset ends");
		return assetViewMasterDao.getLocationListforAssetApi(org,orgDiv,userId);
	}

	// Search
	@RequestMapping(value = "rest-AssetViewSearch", method = { RequestMethod.GET })
	public JsonResponse<Object> assetViewSearch(@RequestParam String orgName, @RequestParam String orgDivision, String searchValue,@RequestParam String type) {
		logger.info("Method :assetViewSearch start");

		logger.info("Method :assetViewSearch endss");
		return assetViewMasterDao.assetViewSearch(orgName, orgDivision, searchValue,type);

	}
	
	@RequestMapping(value = "rest-asset-code-dispose", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> disposeAsset(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : disposeAsset starts");

		logger.info("Method : disposeAsset ends");
		return assetViewMasterDao.disposeAsset(id, org, orgDiv);

	}
}
