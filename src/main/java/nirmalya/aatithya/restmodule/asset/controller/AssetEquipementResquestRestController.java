package nirmalya.aatithya.restmodule.asset.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetEquipementRequestDao;
import nirmalya.aatithya.restmodule.asset.dao.AssetPolicyDao;
import nirmalya.aatithya.restmodule.asset.model.AssetEquipementRequestRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetStockRequestRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;

@RestController
@RequestMapping(value = { "asset/" })
public class AssetEquipementResquestRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AssetEquipementRequestDao assetEquipementRequestDao;


	// viewAssetPolicy
	@RequestMapping(value = "rest-equipement-request-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewEquipementDetails(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewEquipementDetails start");

		logger.info("Method :viewEquipementDetails endss");
		return assetEquipementRequestDao.viewEquipementDetails(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-equipement-request-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editEquipementDetails(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editEquipementDetails start");

		logger.info("Method :editEquipementDetails endss");
		return assetEquipementRequestDao.editEquipementDetails(id, orgName, orgDivision);
	}
	
	@PostMapping(value = "rest-equipement-request-approve-add")
	public JsonResponse<Object> addApprovedEquipement(@RequestBody List<AssetEquipementRequestRestModel> assetMasterModel) {
		logger.info("Method : addApprovedEquipement starts");
		logger.info("Method : addApprovedEquipement ends");
		return assetEquipementRequestDao.addApprovedEquipement(assetMasterModel);
	}
	
	@RequestMapping(value = "rest-equipement-request-approve-reject", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> rejectEquipementRequest(@RequestParam String id,String assetcat,String assetemp,String assigndate, String org, String orgDiv) {
		logger.info("Method : assignAsset starts");

		logger.info("Method : assignAsset ends");
		return assetEquipementRequestDao.rejectEquipementRequest(id, org, orgDiv);

	}
}
