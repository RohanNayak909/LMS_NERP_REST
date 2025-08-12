package nirmalya.aatithya.restmodule.recruitment.controller;

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
import nirmalya.aatithya.restmodule.master.model.LeaveApplyRestModel;
import nirmalya.aatithya.restmodule.recruitment.dao.RequistionDao;
import nirmalya.aatithya.restmodule.recruitment.model.AddRecruitentModel;
import nirmalya.aatithya.restmodule.recruitment.model.RequisitionActivityModel;
import nirmalya.aatithya.restmodule.recruitment.model.RequisitionVendorModel;
import nirmalya.aatithya.restmodule.recruitment.model.RestRequisitonVendorAllocationModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("recruitment/")
public class RequistionRestController {

	Logger logger = LoggerFactory.getLogger(RequistionRestController.class);

	@Autowired
	RequistionDao requistionDao;

	@RequestMapping(value = "jobTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> jobTypeList() {
		logger.info("Method : jobTypeList starts");

		logger.info("Method : jobTypeList ends");
		return requistionDao.jobTypeList();
	}
	
	@RequestMapping(value = "jobLocationList", method = { RequestMethod.GET })
	public List<DropDownModel> jobLocationList(@RequestParam String orgName, String orgDivision) {
		logger.info("Method : jobLocationList starts");

		logger.info("Method : jobLocationList ends");
		return requistionDao.jobLocationList(orgName,orgDivision);
	}
	
	@RequestMapping(value = "jobList", method = { RequestMethod.GET })
	public List<DropDownModel> jobReqList(@RequestParam String orgName, String orgDivision) {
		logger.info("Method : jobReqList starts");

		logger.info("Method : jobReqList ends");
		return requistionDao.jobReqList(orgName,orgDivision);
	}
	
	@RequestMapping(value = "candidatesList", method = { RequestMethod.GET })
	public List<DropDownModel> candidatesList(@RequestParam String orgName, String orgDivision, String requisitionId) {
		logger.info("Method : candidatesList starts");

		logger.info("Method : candidatesList ends");
		return requistionDao.candidatesList(orgName,orgDivision,requisitionId);
	}
	
	@RequestMapping(value = "DepartmentList", method = { RequestMethod.GET })
	public List<DropDownModel> DepartmentList() {
		logger.info("Method : DepartmentList starts");

		logger.info("Method : DepartmentList ends");
		return requistionDao.DepartmentList();
	}
	
	@RequestMapping(value = "managerList", method = { RequestMethod.GET })
	public List<DropDownModel> managerList() {
		logger.info("Method : managerList starts");

		logger.info("Method : managerList ends");
		return requistionDao.managerList();
	}
	
	@RequestMapping(value = "bandList", method = { RequestMethod.GET })
	public List<DropDownModel> bandList(@RequestParam String organization,String orgDivision) {
		logger.info("Method : bandList starts");

		logger.info("Method : bandList ends");
		return requistionDao.bandList(organization,orgDivision);
	}
	
	@RequestMapping(value = "designationLists", method = { RequestMethod.GET })
	public List<DropDownModel> designationLists() {
		logger.info("Method : designationLists starts");

		logger.info("Method : designationLists ends");
		return requistionDao.designationLists();
	}
	
	@RequestMapping(value = "educationList", method = { RequestMethod.GET })
	public List<DropDownModel> educationList() {
		logger.info("Method : educationList starts");

		logger.info("Method : educationList ends");
		return requistionDao.educationList();
	}
	
	@RequestMapping(value = "workHourList", method = { RequestMethod.GET })
	public List<DropDownModel> workHourList() {
		logger.info("Method : workHourList starts");

		logger.info("Method : workHourList ends");
		return requistionDao.workHourList();
	}
	
	@RequestMapping(value = "benefitsList", method = { RequestMethod.GET })
	public List<DropDownModel> benefitsList() {
		logger.info("Method : benefitsList starts");

		logger.info("Method : benefitsList ends");
		return requistionDao.benefitsList();
	}
	
	@RequestMapping(value = "aboutCompany", method = { RequestMethod.GET })
	public List<DropDownModel> aboutCompany() {
		logger.info("Method : aboutCompany starts");

		logger.info("Method : aboutCompany ends");
		return requistionDao.aboutCompany();
	}
	
	@RequestMapping(value = "addressTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> addressTypeList() {
	logger.info("Method : addressTypeList starts");

	logger.info("Method : addressTypeList ends");
	return requistionDao.addressTypeList();
	}
	@RequestMapping(value = "addressTypeList-hire", method = { RequestMethod.GET })
	public List<DropDownModel> addressTypeListHire() {
		logger.info("Method : addressTypeListHire starts");
		
		logger.info("Method : addressTypeListHire ends");
		return requistionDao.addressTypeListHire();
	}
	
	@PostMapping(value="addRequisition")
	public ResponseEntity<JsonResponse<Object>> addRequisition(@RequestBody AddRecruitentModel requisition){
		logger.info("Method : addRequisition starts");
		
		logger.info("Method : addRequisition ends");
		return requistionDao.addRequisition(requisition);
	}
	
	@RequestMapping(value = "/viewRequistion", method = {RequestMethod.GET})
	ResponseEntity<JsonResponse<List<AddRecruitentModel>>> getRequistionview()
	{
		logger.info("Method : getRequistionview start");
		
		
		logger.info("Method : getRequistionview ends");
		
		return requistionDao.viewRequistion();
	}
	
	@RequestMapping(value = "/deleteRequistion", method = { RequestMethod.GET})
	 public ResponseEntity<JsonResponse<Object>> deleteRequistionById(@RequestParam String id) {
		logger.info("Method : deleteRequistionById starts");

		logger.info("Method : deleteRequistionById ends");
		return requistionDao.deleteRequistionById(id); 
	}

	@RequestMapping(value = "/editRequisition", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AddRecruitentModel>>> editRequisition(@RequestParam String id) {
		logger.info("Method : editRequisition starts");

		logger.info("Method :editRequisition ends");
		return requistionDao.editRequisition(id);
	}
	
	@RequestMapping(value = "/activityRequisition", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RequisitionActivityModel>>> activityRequisition(@RequestParam String id) {
		logger.info("Method : activityRequisition starts");

		logger.info("Method :activityRequisition ends");
		return requistionDao.activityRequisition(id);
	}

	
	@PostMapping(value="addRequisitionVendorAllocation")
	public ResponseEntity<JsonResponse<Object>> addRequisitionVendorAllocation(@RequestBody RestRequisitonVendorAllocationModel requisition){
		logger.info("Method : rest addRequisitionVendorAllocation starts");
		
		logger.info("Method : rest addRequisitionVendorAllocation ends");
		return requistionDao.addRequisitionVendorAllocation(requisition);
	}
	
	@RequestMapping(value = "get-vendor-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RequisitionVendorModel>>> viewRequisitionVendorList(@RequestParam String orgName,@RequestParam String orgDiv) {
		logger.info("Method : viewRequisitionVendorList starts");

		logger.info("Method : viewRequisitionVendorList ends");
		return requistionDao.viewRequisitionVendorList(orgName,orgDiv);
	}
	// dropdown for address type
	@RequestMapping(value = "addressTypeListapi", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> addressTypeListApi() {
		logger.info("Method : addressTypeListApi starts");

		logger.info("Method : addressTypeListApi ends");
		return requistionDao.addressTypeListApiDao();
	}
	
	
	//approve details
	
		@GetMapping(value="approveRequisitionapply")
		public JsonResponse<AddRecruitentModel> approveRequisitionapply(@RequestParam String id,String name,String comment,
				String userRole,String status){
			logger.info("Method : approveRequisitionapply starts");
			
			logger.info("Method : approveRequisitionapply ends");
			return requistionDao.approveRequisitionapply(id,name,comment,userRole,status);
		}
		
		//reject leave
		
		@GetMapping(value="rejectRequisitionapply")
		public JsonResponse<AddRecruitentModel> rejectRequisitionapply(@RequestParam String id,String name,String comment){
			logger.info("Method : rejectRequisitionapply starts");
			
			logger.info("Method : rejectRequisitionapply ends");
			return requistionDao.rejectRequisitionapply(id,name,comment);
		}
		
		@GetMapping("rest-get-reqSkill")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getSkillsList(){
			logger.info("Method: getSkillsList  Start");

			logger.info("Method: getSkillsList ends");
			
			return requistionDao.getSkillsList();
		}

		
		@RequestMapping(value = "restEditRequsition", method = { RequestMethod.GET })
		public JsonResponse<Object> restEditRequsition(@RequestParam String orgName, @RequestParam String orgDivision, String reqId) {
			logger.info("Method :restEditRequsition start");

			logger.info("Method :restEditRequsition endss");
			return requistionDao.restEditRequsition(orgName, orgDivision, reqId);

		}
		
		@RequestMapping(value = "rest-get-requsition-info-details", method = { RequestMethod.GET })
		public JsonResponse<Object> getRequsitionInfoDetails(@RequestParam String orgName, @RequestParam String orgDivision, String reqId) {
			logger.info("Method :getRequsitionInfoDetails start");

			logger.info("Method :getRequsitionInfoDetails endss");
			return requistionDao.getRequsitionInfoDetails(orgName, orgDivision, reqId);

		}
		
		
}
