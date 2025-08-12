package nirmalya.aatithya.restmodule.weight.controller;

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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.gatepass.model.RestGatePassDetailsModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.weight.dao.ManageGateInWeightRestDao;
import nirmalya.aatithya.restmodule.weight.model.RestWeightBridgeModel;

@RestController
@RequestMapping("weight/")
public class ManageGateInWeightRestController {
	
	Logger logger = LoggerFactory.getLogger(ManageGateInWeightRestController.class);

	@Autowired
	ManageGateInWeightRestDao manageGateInWeightRestDao;

//	@PostMapping(value = "viewGatePassInWeight")
//	public ResponseEntity<JsonResponse<List<RestGatePassDetailsModel>>> viewGatePassInWeight(
//			@RequestBody EmpRoleModel empModel) {
//		logger.info("Method : viewGatePassInWeight starts");
//
//		String userId = empModel.getUserId();
//		String organization = empModel.getOrganization();
//		String orgDivision = empModel.getOrgDivision();
//
//		logger.info("Method : viewGatePassInWeight ends");
//		return manageGateInWeightRestDao.viewGatePassInWeight(userId, organization, orgDivision);
//	}
	
	//view gate in weight
	@GetMapping(value = "viewGatePassInWeight")
	public JsonResponse<Object> viewGatePassInWeight(@RequestParam String pageno, String orgName, String orgDiv) {
		logger.info("Method :viewGatePassInWeight starts");

		logger.info("Method :viewGatePassInWeight endss");
		return manageGateInWeightRestDao.viewGatePassInWeight(pageno,orgName,orgDiv);

	}
	
	//add gate in weight
	@RequestMapping(value = "addWeightBridgeGateIn", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addWeightBridgeGateIn(@RequestBody RestWeightBridgeModel restWeightBridgeModel) {
		logger.info("Method : addWeightBridgeGateIn starts");

		logger.info("Method : addWeightBridgeGateIn ends"+restWeightBridgeModel);
		return manageGateInWeightRestDao.addWeightBridgeGateIn(restWeightBridgeModel);
	}
	
	//view gate out weight
	@GetMapping(value = "viewGatePassOutWeight")
	public JsonResponse<List<RestWeightBridgeModel>> viewGatePassOutWeight(@RequestParam String pageno, String orgName, String orgDiv) {
		logger.info("Method :viewGatePassOutWeight starts");

		logger.info("Method :viewGatePassOutWeight endss");
		return manageGateInWeightRestDao.viewGatePassOutWeight(pageno,orgName,orgDiv);

	}
	
	//add gate out weight
	@RequestMapping(value = "addWeightBridgeGateOut", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addWeightBridgeGateOut(@RequestBody RestWeightBridgeModel restWeightBridgeModel) {
		logger.info("Method : addWeightBridgeGateOut starts");

		logger.info("Method : addWeightBridgeGateOut ends"+restWeightBridgeModel);
		return manageGateInWeightRestDao.addWeightBridgeGateOut(restWeightBridgeModel);
	}
	
	@GetMapping(value = "entryApproval")
	public JsonResponse<RestWeightBridgeModel> entryApproval(@RequestParam String entryId, String userId) {
		logger.info("Method : entryApproval starts");
		
		logger.info("Method : entryApproval ends");
		return manageGateInWeightRestDao.entryApproval(entryId, userId);
	}
	
	@GetMapping(value = "exitApproval")
	public JsonResponse<RestWeightBridgeModel> exitApproval(@RequestParam String registerId, String userId) {
		logger.info("Method : exitApproval starts");
		
		logger.info("Method : exitApproval ends");
		return manageGateInWeightRestDao.exitApproval(registerId, userId);
	}
	
	//view gate total weight
	@GetMapping(value = "viewGatePassTotalWeight")
	public JsonResponse<List<RestWeightBridgeModel>> viewGatePassTotalWeight(@RequestParam String pageno, String orgName, String orgDiv) {
		logger.info("Method :viewGatePassTotalWeight starts");

		logger.info("Method :viewGatePassTotalWeight endss");
		return manageGateInWeightRestDao.viewGatePassTotalWeight(pageno,orgName,orgDiv);
	}
	
	//view gate report
	@GetMapping(value = "viewGatePassReport")
	public JsonResponse<Object> viewGatePassReport(@RequestParam String orgName, String orgDivision, String fromdate, String todate , String type) {
		logger.info("Method :viewGatePassReport starts");

		logger.info("Method :viewGatePassReport endss");
		return manageGateInWeightRestDao.viewGatePassReport(orgName, orgDivision , fromdate , todate, type);
	}
	
	//Download Slip
	
	@RequestMapping(value = "rest-slip-pdf-downloads", method = { RequestMethod.GET })
	public JsonResponse<Object> downloadSlip(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :downloadSlip start");

		logger.info("Method :downloadSlip endss");
		return manageGateInWeightRestDao.downloadSlip(id, orgName, orgDivision);
}
	
	// weighIn Delete.
	@GetMapping(value = "rest-weighInDelete")
	public ResponseEntity<JsonResponse<Object>> weighInDelete(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method : weighInDelete starts");
		logger.info("Method : weighInDelete ends");
		return manageGateInWeightRestDao.weighInDelete(id ,orgName, orgDivision);
	}
	// weightOut Delete.
	@GetMapping(value = "rest-weighOutDelete")
	public ResponseEntity<JsonResponse<Object>> weighOutDelete(@RequestParam String id,String orgName, String orgDivision) {
		logger.info("Method : weighOutDelete starts");
		logger.info("Method : weighOutDelete ends");
		return manageGateInWeightRestDao.weighOutDelete(id ,orgName, orgDivision);
	}
	// Search
	@GetMapping(value = "rest-gatePassInWeightSearch")
	public JsonResponse<Object> gatePassInWeightSearch(@RequestParam String sValue, String orgName, String orgDiv) {
		logger.info("Method :gatePassInWeightSearch starts");

		logger.info("Method :gatePassInWeightSearch endss");
		return manageGateInWeightRestDao.gatePassInWeightSearch(sValue,orgName,orgDiv);

	}
	@GetMapping(value = "rest-gatePassOutWeightSearch")
	public JsonResponse<List<RestWeightBridgeModel>> gatePassOutWeightSearch(@RequestParam String sValue, String orgName, String orgDiv) {
		logger.info("Method :gatePassOutWeightSearch starts");

		logger.info("Method :gatePassOutWeightSearch endss");
		return manageGateInWeightRestDao.gatePassOutWeightSearch(sValue,orgName,orgDiv);

	}
	@GetMapping(value = "rest-gatePassTotalWeightSearch")
	public JsonResponse<List<RestWeightBridgeModel>> gatePassTotalWeightSearch(@RequestParam String sValue, String orgName, String orgDiv) {
		logger.info("Method :gatePassTotalWeightSearch starts");

		logger.info("Method :gatePassTotalWeightSearch endss");
		return manageGateInWeightRestDao.gatePassTotalWeightSearch(sValue,orgName,orgDiv);
	}
}
