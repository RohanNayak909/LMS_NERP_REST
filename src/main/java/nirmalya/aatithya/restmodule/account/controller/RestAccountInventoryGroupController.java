package nirmalya.aatithya.restmodule.account.controller;

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

import nirmalya.aatithya.restmodule.account.dao.RestAccountBankDao;
import nirmalya.aatithya.restmodule.account.dao.RestAccountBranchDao;
import nirmalya.aatithya.restmodule.account.dao.RestAccountGroupDao;
import nirmalya.aatithya.restmodule.account.dao.RestAccountInventoryGroupDao;
import nirmalya.aatithya.restmodule.account.model.DataSetAccountTree;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestOrganizationMasterModel;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmContactDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCustomerDao;
import nirmalya.aatithya.restmodule.pipeline.dao.PipelineDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCallDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCampaignDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmDealDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmTaskDao;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmVendorDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestContactModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCallModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCampaignModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCustomerModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmTaskModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmVendorModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestDealModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineActivityModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineLogModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineMeetingModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestPipelineSmsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestStagesDetailModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account")
public class RestAccountInventoryGroupController {
	Logger logger = LoggerFactory.getLogger(RestAccountInventoryGroupController.class);
	@Autowired
	RestAccountInventoryGroupDao restAccountInventoryGroupDao;

	// getAccountTreeDetails
	/*
	 * 
	 * getAccountTree
	 * 
	 */
	@RequestMapping(value = "getAccountInventoryTreeDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DataSetAccountTree>>> getAccountInventoryTreeDetails(
			String getAccountInventoryTreeDetails, String orgName, String orgDiv) {
		logger.info("Method : getAccountInventoryTreeDetails starts");

		logger.info("Method : getAccountInventoryTreeDetails ends");
		return restAccountInventoryGroupDao.getAccountInventoryTreeDetails("getAccountInventoryTreeDetails", orgName,
				orgDiv);
	}

	// restAddParent

	/*
	 * Post Mapping to Add Parent
	 *
	 */

	@RequestMapping(value = "restAddParentforInvntory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddParentforInvntory(@RequestBody DataSetAccountTree table) {
		logger.info("Method : restAddParentforInvntory starts");

		logger.info("Method : restAddParentforInvntory ends");
		return restAccountInventoryGroupDao.restAddParentforInvntory(table);
	}

	// restAddChild

	// Post Mapping to Add Child

	@RequestMapping(value = "restAddChildForInventory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddChildForInventory(@RequestBody DataSetAccountTree table) {
		logger.info("Method : restAddChildForInventory starts");

		logger.info("Method : restAddChildForInventory ends");
		return restAccountInventoryGroupDao.restAddChildForInventory(table);
	}

	@RequestMapping(value = "modifyHeaderNameForInventory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> modifyHeaderNameForInventory(@RequestParam String id, String nameGroup,
			String orgName, String orgDiv) {
		logger.info("Method :  modifyHeaderNameForInventory starts");

		logger.info("Method :  modifyHeaderNameForInventory ends");
		return restAccountInventoryGroupDao.modifyHeaderNameForInventory(id, nameGroup, orgName, orgDiv);
	}

	@RequestMapping(value = "modifyHeaderNameParentForInventory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> modifyHeaderNameParentForInventory(@RequestParam String id, String nameGroup,
			String natureGrp, String orgName, String orgDiv) {
		logger.info("Method :  modifyHeaderNameParentForInventory starts");

		logger.info("Method :  modifyHeaderNameParentForInventory ends");
		return restAccountInventoryGroupDao.modifyHeaderNameParentForInventory(id, nameGroup, natureGrp, orgName, orgDiv);
	}

}
