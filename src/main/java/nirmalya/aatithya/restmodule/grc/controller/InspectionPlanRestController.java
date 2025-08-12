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
import nirmalya.aatithya.restmodule.grc.dao.InspectionPlanRestDao;
import nirmalya.aatithya.restmodule.grc.model.AuditPlanRestModel;

@RestController
@RequestMapping(value = "grc/")
public class InspectionPlanRestController {

	Logger logger = LoggerFactory.getLogger(InspectionPlanRestController.class);

	@Autowired
	InspectionPlanRestDao inspectionPlanRestDao;

	/*
	 * @GetMapping(value = "viewInspectionPlanData") public
	 * JsonResponse<List<AuditPlanRestModel>> getInspectionPlanData(@RequestParam
	 * String organization, String orgDivision) {
	 * logger.info("Method : getInspectionPlanData starts");
	 * 
	 * logger.info("Method : getInspectionPlanData ends"); return
	 * inspectionPlanRestDao.getInspectionPlanData(organization, orgDivision); }
	 */
	@RequestMapping(value = "/rest-getInspectCategoryLists", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInspectCategoryLists(@RequestParam String id) {
		logger.info("Method : getInspectCategoryLists starts");
		logger.info("Method : getInspectCategoryLists ends");
		return inspectionPlanRestDao.getInspectCategoryLists(id);
	}

	/*
	 * @PostMapping(value = "addInspectionPlanSavedata") public
	 * ResponseEntity<JsonResponse<Object>> addInspectionPlanSavedata(@RequestBody
	 * AuditPlanRestModel model) {
	 * logger.info("Method :addInspectionPlanSavedata starts");
	 * logger.info("Method :addInspectionPlanSavedata endss"); return
	 * inspectionPlanRestDao.addInspectionPlanSavedata(model); }
	 */
	
	@RequestMapping(value = "/getInternalInspectionList", method = { RequestMethod.GET })
	public List<DropDownModel> getInternalInspectionList(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getInternalInspectionList starts");

		logger.info("Method : getInternalInspectionList end"); 
		return inspectionPlanRestDao.getInternalInspectionList(organization, orgDivision);
	}
	
	@RequestMapping(value = "/getExternalInspectionList", method = { RequestMethod.GET })
	public List<DropDownModel> getExternalInspectionList(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getExternalInspectionList starts");

		logger.info("Method : getExternalInspectionList end"); 
		return inspectionPlanRestDao.getExternalInspectionList(organization, orgDivision);
	} 
	
	/*
	 * @RequestMapping(value = "rest-inspection-plan-edit", method = {
	 * RequestMethod.GET }) public JsonResponse<AuditPlanRestModel>
	 * inspectionPlanEdit(@RequestParam String id, String orgName, String
	 * orgDivision, String uId) {
	 * logger.info("Method : inspectionPlanEdit rest starts");
	 * 
	 * logger.info("Method :inspectionPlanEdit rest ends"); return
	 * inspectionPlanRestDao.inspectionPlanEdit(id,orgName, orgDivision, uId); }
	 */
	
	@RequestMapping(value = "inspection-plan-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteInspectionPlan(@RequestParam String id) {
		logger.info("Method : deleteInspectionPlan starts");

		logger.info("Method : deleteInspectionPlan ends"); 
		return inspectionPlanRestDao.deleteInspectionPlan(id);
	}
	
	@RequestMapping(value = "/getInspectionTypeWiseAuditCategory", method = { RequestMethod.GET })
	public List<DropDownModel> getInspectionTypeWiseAuditCategory(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getInspectionTypeWiseAuditCategory starts");

		logger.info("Method : getInspectionTypeWiseAuditCategory end"); 
		return inspectionPlanRestDao.getInspectionTypeWiseAuditCategory(organization, orgDivision);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "rest-inspection-plan-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewInspection(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewInspection start");

		logger.info("Method :viewInspection endss");
		return inspectionPlanRestDao.viewInspection(orgName, orgDivision);
	}
	
	@RequestMapping(value = "/getInspectionTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getInspectionType(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getInspectionType starts");

		logger.info("Method : getInspectionType end"); 
		return inspectionPlanRestDao.getInspectionType(organization, orgDivision);
	}
	
	@RequestMapping(value = "/getInspectionCategoryList", method = { RequestMethod.GET })
	public List<DropDownModel> getInspectionCategory(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getInspectionCategory starts");

		logger.info("Method : getInspectionCategory end"); 
		return inspectionPlanRestDao.getInspectionCategory(organization, orgDivision);
	}
	
	@RequestMapping(value = "/getInspectionCategoryListEx", method = { RequestMethod.GET })
	public List<DropDownModel> getInspectionCategoryEx(@RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method : getInspectionCategoryEx starts");

		logger.info("Method : getInspectionCategoryEx end"); 
		return inspectionPlanRestDao.getInspectionCategoryEx(organization, orgDivision);
	}
	
	@PostMapping(value = "rest-inspection-plan-add")
	public ResponseEntity<JsonResponse<List<AuditPlanRestModel>>> addInspectionPlan( @RequestBody List<AuditPlanRestModel> ap) {
		logger.info("Method : addInspectionPlan starts");
		logger.info("Method : addInspectionPlan ends");
		return inspectionPlanRestDao.addInspectionPlan(ap);
	}
	
	@RequestMapping(value = "rest-inspection-plan-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> inspectionPlanEdit(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :inspectionPlanEdit start");

		logger.info("Method :inspectionPlanEdit endss");
		return inspectionPlanRestDao.inspectionPlanEdit(id, orgName, orgDivision);
	}
	@RequestMapping(value = "rest-inspection-plan-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteInspectionPlan(@RequestParam String id, String org, String div) {
		logger.info("Method : deleteInspectionPlan starts");

		logger.info("Method : deleteInspectionPlan ends");
		return inspectionPlanRestDao.deleteInspectionPlan(id, org, div);
	}
	@RequestMapping(value = "rest-inspection-plan-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveInspectionPlan(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveInspectionPlan starts");

		logger.info("Method : approveInspectionPlan ends");
		return inspectionPlanRestDao.approveInspectionPlan(id, org, orgDiv);

	}
	
	@RequestMapping(value = "rest-addNewCategory", method = { RequestMethod.GET })
	public JsonResponse<Object> addNewCategory(@RequestParam String name,String type,String userId,String orgName,String orgDivision) {
		logger.info("Method : addNewCategory rest starts");

		logger.info("Method :addNewCategory rest ends");
		return inspectionPlanRestDao.addNewCategory(name,type,userId,orgName,orgDivision);
	}
	
	@GetMapping("rest-getCategory")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCategory(@RequestParam String orgName,@RequestParam String orgDiv,@RequestParam String type){
		logger.info("Method: getCategory  Start");

		logger.info("Method: getCategory ends");
		
		return inspectionPlanRestDao.getCategory(orgName,orgDiv,type);
	}

}
