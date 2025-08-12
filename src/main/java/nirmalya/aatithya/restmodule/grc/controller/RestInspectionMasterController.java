package nirmalya.aatithya.restmodule.grc.controller;

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
import org.springframework.web.client.RestTemplate;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.dao.AuditMasterRestDao;
import nirmalya.aatithya.restmodule.grc.dao.RestInspectionMasterDao;
import nirmalya.aatithya.restmodule.grc.model.AuditMasterRestModel;

@RestController
@RequestMapping(value = "grc/")
public class RestInspectionMasterController {

	Logger logger = LoggerFactory.getLogger(RestInspectionMasterController.class);

	@Autowired
	RestInspectionMasterDao restInspectionMasterDao;

	@RequestMapping(value = "getInspectionType", method = { RequestMethod.GET })
	public List<DropDownModel> getInspectionType(@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : getInspectionType starts");

		logger.info("Method : getInspectionType end");
		return restInspectionMasterDao.getInspectionType(organization, orgDivision);
	}

	@GetMapping(value = "viewInternalInspectionData")
	public JsonResponse<List<AuditMasterRestModel>> viewInternalInspectionData(@RequestParam String organization,
			String orgDivision) {
		logger.info("Method : viewInternalInspectionData starts");

		logger.info("Method : viewInternalInspectionData ends");
		return restInspectionMasterDao.viewInternalInspectionData(organization, orgDivision);
	}

	@PostMapping(value = "rest-addInspectionData")
	public ResponseEntity<JsonResponse<Object>> addInspectionData(@RequestBody AuditMasterRestModel model) {
		logger.info("Method :addInspectionData starts");
		logger.info("Method :addInspectionData endss");
		return restInspectionMasterDao.addInspectionData(model);
	}

	@GetMapping(value = "viewInspectionCategory")
	public JsonResponse<List<AuditMasterRestModel>> viewInspectionCategory(@RequestParam String organization,
			String orgDivision) {
		logger.info("Method : viewInspectionCategory starts");

		logger.info("Method : viewInspectionCategory ends");
		return restInspectionMasterDao.viewInspectionCategory(organization, orgDivision);
	}

	@GetMapping(value = "viewExternalInspectionData")
	public JsonResponse<List<AuditMasterRestModel>> viewExternalInspectionData(@RequestParam String organization,
			String orgDivision) {
		logger.info("Method : viewExternalInspectionData starts");

		logger.info("Method : viewExternalInspectionData ends");
		return restInspectionMasterDao.viewExternalInspectionData(organization, orgDivision);
	}

	@PostMapping(value = "addInspectCategorySavedata")
	public ResponseEntity<JsonResponse<Object>> addInspectCategorySavedata(@RequestBody AuditMasterRestModel model) {
		logger.info("Method :addInspectCategorySavedata starts");
		logger.info("Method :addInspectCategorySavedata endss");
		return restInspectionMasterDao.addInspectCategorySavedata(model);
	}

	@RequestMapping(value = "editInspectionMasterCategory", method = { RequestMethod.GET })
	public JsonResponse<AuditMasterRestModel> editInspectionMasterCategory(@RequestParam String id, String orgName,
			String orgDivision, String uId) {
		logger.info("Method : editInspectionMasterCategory rest starts");

		logger.info("Method :editInspectionMasterCategory rest ends");
		return restInspectionMasterDao.editInspectionMasterCategory(id, orgName, orgDivision, uId);
	}

	@RequestMapping(value = "editInspectionMaster", method = { RequestMethod.GET })
	public JsonResponse<AuditMasterRestModel> editInspectionMaster(@RequestParam String id, String orgName,
			String orgDivision, String uId) {
		logger.info("Method : editInspectionMaster rest starts");

		logger.info("Method :editInspectionMaster rest ends");
		return restInspectionMasterDao.editInspectionMaster(id, orgName, orgDivision, uId);
	}

	/* delete */

	@RequestMapping(value = "deleteIncCatMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteIncCatMaster(@RequestParam String id) {
		logger.info("Method : deleteIncCatMaster starts");

		logger.info("Method : deleteIncCatMaster ends");
		return restInspectionMasterDao.deleteIncCatMaster(id);
	}

	@RequestMapping(value = "deleteIncInternalDelete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteIncInternalDelete(@RequestParam String id) {
		logger.info("Method : deleteIncInternalDelete starts");

		logger.info("Method : deleteIncInternalDelete ends");
		return restInspectionMasterDao.deleteIncInternalDelete(id);
	}

	@RequestMapping(value = "deleteIncExternalDelete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteIncExternalDelete(@RequestParam String id) {
		logger.info("Method : deleteIncExternalDelete starts");

		logger.info("Method : deleteIncExternalDelete ends");
		return restInspectionMasterDao.deleteIncExternalDelete(id);
	}
}
