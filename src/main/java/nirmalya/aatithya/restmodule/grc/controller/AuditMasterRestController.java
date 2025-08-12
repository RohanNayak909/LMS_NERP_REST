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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.dao.AuditMasterRestDao;
import nirmalya.aatithya.restmodule.grc.model.AuditMasterRestModel;

@RestController
@RequestMapping(value = "grc/")
public class AuditMasterRestController {
	
	Logger logger = LoggerFactory.getLogger(AuditMasterRestController.class);
	
	@Autowired
	AuditMasterRestDao auditMasterRestDao;
	
	@RequestMapping(value = "/getAuditType", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditType(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getAuditType starts");

		logger.info("Method : getAuditType end"); 
		return auditMasterRestDao.getAuditType(organization, orgDivision);
	}
	
	@RequestMapping(value = "/getAgencyList", method = { RequestMethod.GET })
	public List<DropDownModel> getAgencyList(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getAgencyList starts");

		logger.info("Method : getAgencyList end"); 
		return auditMasterRestDao.getAgencyList(organization, orgDivision);
	}
	@RequestMapping(value = "/getAuditorList", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditorList(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getAuditorList starts");

		logger.info("Method : getAuditorList end"); 
		return auditMasterRestDao.getAuditorList(organization, orgDivision);
	}
	@RequestMapping(value = "/getInternalAuditorListing", method = { RequestMethod.GET })
	public List<DropDownModel> getIAuditorList(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getIAuditorList starts");

		logger.info("Method : getIAuditorList end"); 
		return auditMasterRestDao.getIAuditorList(organization, orgDivision);
	}
	@RequestMapping(value = "/getExternalAuditorListing", method = { RequestMethod.GET })
	public List<DropDownModel> getEAuditorList(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getEAuditorList starts");

		logger.info("Method : getEAuditorList end"); 
		return auditMasterRestDao.getEAuditorList(organization, orgDivision);
	}
	@RequestMapping(value = "/getAuditorSpecialisationList", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditorSpecialisationList(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getAuditorSpecialisationList starts");

		logger.info("Method : getAuditorSpecialisationList end"); 
		return auditMasterRestDao.getAuditorSpecialisationList(organization, orgDivision);
	}
	//auditMasterAdd
	@PostMapping(value = "rest-addAuditMasterData")
	public ResponseEntity<JsonResponse<Object>> addAuditMasterData(
			@RequestBody AuditMasterRestModel model) {
		logger.info("Method :addAuditMasterData starts");
		logger.info("Method :addAuditMasterData endss");
		return auditMasterRestDao.addAuditMasterData(model);
	}

	@GetMapping(value = "rest-getInternalAuditorData")
	public JsonResponse<List<AuditMasterRestModel>> getInternalAuditorData(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getInternalAuditorData starts");
		
		logger.info("Method : getInternalAuditorData ends");
		return auditMasterRestDao.getInternalAuditorData(organization,orgDivision);
	}
	
	@GetMapping(value = "rest-getExternalAuditorData")
	public JsonResponse<List<AuditMasterRestModel>> getExternalAuditorData(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getExternalAuditorData starts");
		
		logger.info("Method : getExternalAuditorData ends");
		return auditMasterRestDao.getExternalAuditorData(organization,orgDivision);
	}
	
	//auditMasterAdd
	@PostMapping(value = "rest-addAuditCategorySavedata")
	public ResponseEntity<JsonResponse<Object>> addAuditCategorySavedata(
			@RequestBody AuditMasterRestModel model) {
		logger.info("Method :addAuditCategorySavedata starts");
		logger.info("Method :addAuditCategorySavedata endss");
		return auditMasterRestDao.addAuditCategorySavedata(model);
	}

	@GetMapping(value = "rest-getViewAuditCategoryData")
	public JsonResponse<List<AuditMasterRestModel>> getViewAuditCategoryData(@RequestParam String organization,String orgDivision) {
		logger.info("Method : getViewAuditCategoryData starts");
		
		logger.info("Method : getViewAuditCategoryData ends");
		return auditMasterRestDao.getViewAuditCategoryData(organization,orgDivision);
	}
	
   /* delete */
	
	@RequestMapping(value = "audit-category-master-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAuditCategoryMasterRecord(@RequestParam String id) {
		logger.info("Method : deleteAuditCategoryMasterRecord starts");

		logger.info("Method : deleteAuditCategoryMasterRecord ends"); 
		return auditMasterRestDao.deleteAuditCategoryMasterRecord(id);
	}
	
	@RequestMapping(value = "audit-internal-master-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAuditInternalMasterDelete(@RequestParam String id) {
		logger.info("Method : deleteAuditInternalMasterDelete starts");

		logger.info("Method : deleteAuditInternalMasterDelete ends"); 
		return auditMasterRestDao.deleteAuditInternalMasterDelete(id);
	}
	
	@RequestMapping(value = "audit-external-master-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAuditExternalMasterDelete(@RequestParam String id) {
		logger.info("Method : deleteAuditExternalMasterDelete starts");

		logger.info("Method : deleteAuditExternalMasterDelete ends"); 
		return auditMasterRestDao.deleteAuditExternalMasterDelete(id);
	}
	
	@RequestMapping(value = "rest-audit-master-categoryedit", method = { RequestMethod.GET })
	public JsonResponse<AuditMasterRestModel> auditMasterCategoryedit(@RequestParam String id,
			String orgName, String orgDivision, String uId) {
		logger.info("Method : auditMasterCategoryedit rest starts");

		logger.info("Method :auditMasterCategoryedit rest ends");
		return auditMasterRestDao.editAuditMasterCategoryData(id,orgName, orgDivision, uId);
	}
	
	@RequestMapping(value = "rest-audit-master-edit", method = { RequestMethod.GET })
	public JsonResponse<AuditMasterRestModel> auditMasterEdit(@RequestParam String id,
			String orgName, String orgDivision, String uId) {
		logger.info("Method : auditMasterEdit rest starts");

		logger.info("Method :auditMasterEdit rest ends");
		return auditMasterRestDao.editAuditMasterData(id,orgName, orgDivision, uId);
	}
	
	
}
