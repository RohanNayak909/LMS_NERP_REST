package nirmalya.aatithya.restmodule.productionplan.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.productionplan.dao.RmPmRequisitionDao;
import nirmalya.aatithya.restmodule.productionplan.model.RmPmRequisitionRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestEvaluationOfLaminatesModel;

@RestController
@RequestMapping(value = "production/")
public class RmPmRequisitionRestController {

	Logger logger = LoggerFactory.getLogger(RmPmRequisitionRestController.class);

	@Autowired
	RmPmRequisitionDao rmPmRequisitionDao;

	@GetMapping(value = "rest-getRmPmListForRequisition")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getRmPmListForRequisition(
			@RequestParam String id, String type, String org, String orgDiv) {
		logger.info("Method : getRmPmListForRequisition starts");

		logger.info("Method :getRmPmListForRequisition endss");
		return rmPmRequisitionDao.getRmPmListForRequisition(id, type, org, orgDiv);
	}

	// view

	@RequestMapping(value = "rest-viewRmPmRequisition", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRmPmRequisition(@RequestParam String org, String orgDiv) {
		logger.info("Method :viewRmPmRequisition start");

		logger.info("Method :viewRmPmRequisition endss");
		return rmPmRequisitionDao.viewRmPmRequisition(org, orgDiv);
	}

	// add.

	@PostMapping(value = "rest-addRmPmRequisition")
	public ResponseEntity<JsonResponse<RmPmRequisitionRestModel>> addRmPmRequisition(
			@RequestBody RmPmRequisitionRestModel rmPmRequisitionRestModel) {
		logger.info("Method : addRmPmRequisition starts");
		logger.info("Method : addRmPmRequisition ends");
		return rmPmRequisitionDao.addRmPmRequisition(rmPmRequisitionRestModel);
	}

	// Edit.

	@RequestMapping(value = "rest-editRmPmRequisition", method = { RequestMethod.GET })
	public JsonResponse<Object> editRmPmRequisition(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editRmPmRequisition start");

		logger.info("Method :editRmPmRequisition endss");
		return rmPmRequisitionDao.editRmPmRequisition(id, orgName, orgDivision);
	}

	// Delete.

	@RequestMapping(value = "rest-deleteRmPmRequisition", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteRmPmRequisition(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :deleteRmPmRequisition start");

		logger.info("Method :deleteRmPmRequisition endss");
		return rmPmRequisitionDao.deleteRmPmRequisition(id, orgName, orgDivision);
	}

	// Approve.

	@RequestMapping(value = "rest-approveRmPmRequsition", method = { RequestMethod.GET })
	public JsonResponse<Object> approveRmPmRequsition(@RequestParam String id, String orgName, String orgDivision,
			String approvedBy) {
		logger.info("Method :approveRmPmRequsition start");

		logger.info("Method :approveRmPmRequsition endss");
		return rmPmRequisitionDao.approveRmPmRequsition(id, orgName, orgDivision, approvedBy);
	}

	// view RmPm View Requisition For Inventory.

	@RequestMapping(value = "rest-viewRmPmRequisitionInInventory", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRmPmRequisitionInInventory(@RequestParam String org, String orgDiv) {
		logger.info("Method :viewRmPmRequisitionInInventory start");

		logger.info("Method :viewRmPmRequisitionInInventory endss");
		return rmPmRequisitionDao.viewRmPmRequisitionInInventory(org, orgDiv);
	}

	// Get Material Issue Data

	@RequestMapping(value = "rest-getDataForIssue", method = { RequestMethod.GET })
	public JsonResponse<Object> getDataForIssue(@RequestParam String id, String orgName, String orgDivision,
			String skuId) {
		logger.info("Method :getDataForIssue start");

		logger.info("Method :getDataForIssue endss");
		return rmPmRequisitionDao.getDataForIssue(id, orgName, orgDivision, skuId);
	}

	// Edit RMPM View.

	@RequestMapping(value = "rest-editRmPmRequisitionForInventory", method = { RequestMethod.GET })
	public JsonResponse<Object> editRmPmRequisitionForInventory(@RequestParam String id, String orgName,
			String orgDivision) {
		logger.info("Method :editRmPmRequisitionForInventory start");

		logger.info("Method :editRmPmRequisitionForInventory endss");
		return rmPmRequisitionDao.editRmPmRequisitionForInventory(id, orgName, orgDivision);
	}

	@RequestMapping(value = "productionPlanningList", method = { RequestMethod.GET })
	public List<DropDownModel> productionPlanningList(@RequestParam String organization, String orgDivision) {
		logger.info("Method : productionPlanningList starts");

		logger.info("Method : productionPlanningList ends");
		return rmPmRequisitionDao.productionPlanningList(organization, orgDivision);
	}

	// view

	@RequestMapping(value = "rest-getRawMaterialList", method = { RequestMethod.GET })
	public JsonResponse<Object> getRawMaterialList(@RequestParam String planId, String org, String orgDiv) {
		logger.info("Method :getRawMaterialList start");

		logger.info("Method :getRawMaterialList endss");
		return rmPmRequisitionDao.getRawMaterialList(planId, org, orgDiv);
	}

}
