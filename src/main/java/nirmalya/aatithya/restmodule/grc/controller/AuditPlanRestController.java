package nirmalya.aatithya.restmodule.grc.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.grc.dao.AuditPlanRestDao;
import nirmalya.aatithya.restmodule.grc.model.AuditPlanRestModel;

@RestController
@RequestMapping(value = "grc/")
public class AuditPlanRestController {
	
Logger logger = LoggerFactory.getLogger(AuditPlanRestController.class);
	
	@Autowired
	AuditPlanRestDao auditPlanRestDao;
	
	@RequestMapping(value = "/getAuditProjectList", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditProjectList(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getAuditProjectList starts");

		logger.info("Method : getAuditProjectList end"); 
		return auditPlanRestDao.getAuditProjectList(organization, orgDivision);
	}
	
	@RequestMapping(value = "/getAuditTypeWiseAuditCategory", method = { RequestMethod.GET })
	public List<DropDownModel> getAuditTypeWiseAuditCategory(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getAuditTypeWiseAuditCategory starts");

		logger.info("Method : getAuditTypeWiseAuditCategory end"); 
		return auditPlanRestDao.getAuditTypeWiseAuditCategory(organization, orgDivision);
	}
	
	@RequestMapping(value = "/getInternalAuditorList", method = { RequestMethod.GET })
	public List<DropDownModel> getInternalAuditorList(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getInternalAuditorList starts");

		logger.info("Method : getInternalAuditorList end"); 
		return auditPlanRestDao.getInternalAuditorList(organization, orgDivision);
	}
	
	@RequestMapping(value = "/getExternalAuditorList", method = { RequestMethod.GET })
	public List<DropDownModel> getExternalAuditorList(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getExternalAuditorList starts");

		logger.info("Method : getExternalAuditorList end"); 
		return auditPlanRestDao.getExternalAuditorList(organization, orgDivision);
	} 
	
	
	@RequestMapping(value = "/rest-getAuditCategoryLists",method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAuditCategoryLists(@RequestParam String id) {
		logger.info("Method : getAuditCategoryLists starts");
		logger.info("Method : getAuditCategoryLists ends");
		return auditPlanRestDao.getAuditCategoryLists(id);
	}
	@RequestMapping(value = "/getPriorityListforAsset", method = { RequestMethod.GET })
	public List<DropDownModel> getPriorityList(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getPriorityList starts");

		logger.info("Method : getPriorityList ends");
		return auditPlanRestDao.getPriorityList(organization, orgDivision);
	}
	@RequestMapping(value = "/getUOMListforAsset", method = { RequestMethod.GET })
	public List<DropDownModel> getUOMListforAsset(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getUOMListforAsset starts");

		logger.info("Method : getUOMListforAsset ends");
		return auditPlanRestDao.getUOMListforAsset(organization, orgDivision);
	}
	
	//addAuditPlanSavedata
	@PostMapping(value = "rest-audit-plan-add")
	public ResponseEntity<JsonResponse<List<AuditPlanRestModel>>> addAuditPlan( @RequestBody List<AuditPlanRestModel> ap) {
		logger.info("Method : addAuditPlan starts");
		logger.info("Method : addAuditPlan ends");
		return auditPlanRestDao.addAuditPlan(ap);
	}
	@RequestMapping(value = "rest-audit-plan-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAuditPlan(@RequestParam String type, String orgName, String orgDivision) {
		logger.info("Method :viewAuditPlan start");

		logger.info("Method :viewAuditPlan endss");
		return auditPlanRestDao.viewAuditPlan(type,orgName, orgDivision);
	}
	@RequestMapping(value = "rest-audit-plan-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> auditPlanEdit(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :auditPlanEdit start");

		logger.info("Method :auditPlanEdit endss");
		return auditPlanRestDao.auditPlanEdit(id, orgName, orgDivision);
	}
	@RequestMapping(value = "rest-audit-plan-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAuditPlan(@RequestParam String id, String org, String div) {
		logger.info("Method : deleteAuditPlan starts");

		logger.info("Method : deleteAuditPlan ends");
		return auditPlanRestDao.deleteAuditPlan(id, org, div);
	}
	@RequestMapping(value = "rest-audit-plan-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveAuditPlan(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveAuditPlan starts");

		logger.info("Method : approveAuditPlan ends");
		return auditPlanRestDao.approveAuditPlan(id, org, orgDiv);

	}
	 
}
