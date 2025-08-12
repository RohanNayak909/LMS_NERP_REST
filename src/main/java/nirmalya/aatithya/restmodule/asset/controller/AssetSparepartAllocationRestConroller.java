package nirmalya.aatithya.restmodule.asset.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetSparepartAllocationDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;

@RestController
@RequestMapping(value = { "asset/" })
public class AssetSparepartAllocationRestConroller {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AssetSparepartAllocationDao assetSparepartAllocationDao;



	// View Assigned Asset
	@RequestMapping(value = "rest-sparepart-assign-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewSpareAssign(@RequestParam String orgName, String orgDivision, String id,String userId) {
		logger.info("Method :viewSpareAssign start");

		logger.info("Method :viewSpareAssign endss");
		return assetSparepartAllocationDao.viewSpareAssign(id,orgName, orgDivision,userId);
	}
	
	@RequestMapping(value = "rest-asset-sparepart-dissociate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> dissociateSpare(@RequestParam String assignid,String assetid, String org,String spareAQty, String div,String dreason) {
		logger.info("Method : dissociateSpare starts");

		logger.info("Method : dissociateSpare ends");
		return assetSparepartAllocationDao.dissociateSpare(assignid,assetid, org, div,dreason,spareAQty);

	}
}
