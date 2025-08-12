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
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeDocumentRestModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.recruitment.dao.CandidateDao;
import nirmalya.aatithya.restmodule.recruitment.model.AddRecruitentModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateAddressModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateApplyRequisitionModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateAwardsModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateDetailsModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateDocumentModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateEducationModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateReferenceModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateSkillsModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateSourceModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateWorkExperienceModel;
import nirmalya.aatithya.restmodule.recruitment.model.candidateBankAccountDetailsRestModel;

@RestController
@RequestMapping("recruitment/")
public class CandidateRestController {

	Logger logger = LoggerFactory.getLogger(CandidateRestController.class);

	@Autowired
	CandidateDao candidateDao;
	
	@PostMapping(value="addCandidate")
	public ResponseEntity<JsonResponse<CandidateDetailsModel>> addCandidate(@RequestBody CandidateDetailsModel candidate){
		logger.info("Method : addCandidate starts");
		
		logger.info("Method : addCandidate ends");
		return candidateDao.addCandidate(candidate);
	}
	
	@RequestMapping(value = "viewCandidates", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CandidateDetailsModel>>> viewCandidates() {
		logger.info("Method : viewCandidates starts");

		logger.info("Method : viewCandidates ends");
		return candidateDao.viewCandidates();
	}
	
	@RequestMapping(value = "editCandidates", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CandidateDetailsModel>>> editCandidates(@RequestParam String id) {
		logger.info("Method : editCandidates starts");

		logger.info("Method : editCandidates ends");
		return candidateDao.editCandidates(id);
	}
	
	@PostMapping(value="addAddress")
	public ResponseEntity<JsonResponse<Object>> addAddress(@RequestBody CandidateAddressModel candidate){
		logger.info("Method : addAddress starts");
		
		logger.info("Method : addAddress ends");
		return candidateDao.addAddress(candidate);
	}
	
	@RequestMapping(value = "viewAddress", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CandidateAddressModel>>> viewAddress(@RequestParam String id) {
		logger.info("Method : viewAddress starts");

		logger.info("Method : viewAddress ends");
		return candidateDao.viewAddress(id);
	}
	
	@PostMapping(value="addEducation")
	public ResponseEntity<JsonResponse<Object>> addEducation(@RequestBody CandidateEducationModel candidate){
		logger.info("Method : addEducation starts");
		
		logger.info("Method : addEducation ends");
		return candidateDao.addEducation(candidate);
	}
	
	@RequestMapping(value = "viewEducation", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CandidateEducationModel>>> viewEducation(@RequestParam String id) {
		logger.info("Method : viewEducation starts");

		logger.info("Method : viewEducation ends");
		return candidateDao.viewEducation(id);
	}
	
	@PostMapping(value="addSkills")
	public ResponseEntity<JsonResponse<Object>> addSkills(@RequestBody CandidateSkillsModel candidate){
		logger.info("Method : addSkills starts");
		
		logger.info("Method : addSkills ends");
		return candidateDao.addSkills(candidate);
	}
	
	@RequestMapping(value = "viewSkills", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CandidateSkillsModel>>> viewSkills(@RequestParam String id) {
		logger.info("Method : viewSkills starts");

		logger.info("Method : viewSkills ends");
		return candidateDao.viewSkills(id);
	}
	
	@PostMapping(value="addWorkExperience")
	public ResponseEntity<JsonResponse<Object>> addWorkExperience(@RequestBody CandidateWorkExperienceModel candidate){
		logger.info("Method : addWorkExperience starts");
		
		logger.info("Method : addWorkExperience ends");
		return candidateDao.addWorkExperience(candidate);
	}
	
	@RequestMapping(value = "viewWorkExperience", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CandidateWorkExperienceModel>>> viewWorkExperience(@RequestParam String id) {
		logger.info("Method : viewWorkExperience starts");

		logger.info("Method : viewWorkExperience ends");
		return candidateDao.viewWorkExperience(id);
	}
	
/* edit work */
	
	@RequestMapping(value = "rest-editWorkDetails", method = { RequestMethod.GET })
	public JsonResponse<CandidateWorkExperienceModel> editWorkDetails(@RequestParam String workId) {
		logger.info("Method : editWorkDetails rest starts");

		logger.info("Method :editWorkDetails rest ends");
		return candidateDao.editWorkDetails(workId);
	}
	
	@PostMapping(value="addAward")
	public ResponseEntity<JsonResponse<Object>> addAward(@RequestBody CandidateAwardsModel candidate){
		logger.info("Method : addAward starts");
		
		logger.info("Method : addAward ends");
		return candidateDao.addAward(candidate);
	}
	
	@RequestMapping(value = "viewAward", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CandidateAwardsModel>>> viewAward(@RequestParam String id) {
		logger.info("Method : viewAward starts");
		
		logger.info("Method : viewAward ends");
		return candidateDao.viewAward(id);
	}
	
	@PostMapping(value="addReference")
	public ResponseEntity<JsonResponse<Object>> addReference(@RequestBody CandidateReferenceModel candidate){
		logger.info("Method : addReference starts");
		
		logger.info("Method : addReference ends");
		return candidateDao.addReference(candidate);
	}
	
	@RequestMapping(value = "viewReference", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CandidateReferenceModel>>> viewReference(@RequestParam String id) {
		logger.info("Method : viewReference starts");
		
		logger.info("Method : viewReference ends");
		return candidateDao.viewReference(id);
	}
	
	@PostMapping(value="addSource")
	public ResponseEntity<JsonResponse<Object>> addSource(@RequestBody CandidateSourceModel candidate){
		logger.info("Method : addSource starts");
		
		logger.info("Method : addSource ends");
		return candidateDao.addSource(candidate);
	}
	
	@RequestMapping(value = "viewSource", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CandidateSourceModel>>> viewSource(@RequestParam String id) {
		logger.info("Method : viewSource starts");
		
		logger.info("Method : viewSource ends");
		return candidateDao.viewSource(id);
	}
	
	@GetMapping(value="deleteAddress")
	public ResponseEntity<JsonResponse<Object>> deleteAddress(@RequestParam String id){
		logger.info("Method : deleteAddress starts");
		
		logger.info("Method : deleteAddress ends");
		return candidateDao.deleteAddress(id);
	}
	
	@GetMapping(value="deleteEducation")
	public ResponseEntity<JsonResponse<Object>> deleteEducation(@RequestParam String id){
		logger.info("Method : deleteEducation starts");
		
		logger.info("Method : deleteEducation ends");
		return candidateDao.deleteEducation(id);
	}
	
	@GetMapping(value="deleteSkill")
	public ResponseEntity<JsonResponse<Object>> deleteSkill(@RequestParam String id){
		logger.info("Method : deleteSkill starts");
		
		logger.info("Method : deleteSkill ends");
		return candidateDao.deleteSkill(id);
	}
	
	@GetMapping(value="deleteWorkExperience")
	public ResponseEntity<JsonResponse<Object>> deleteWorkExperience(@RequestParam String id){
		logger.info("Method : deleteWorkExperience starts");
		
		logger.info("Method : deleteWorkExperience ends");
		return candidateDao.deleteWorkExperience(id);
	}
	
	@GetMapping(value="deleteAward")
	public ResponseEntity<JsonResponse<Object>> deleteAward(@RequestParam String id){
		logger.info("Method : deleteAward starts");
		
		logger.info("Method : deleteAward ends");
		return candidateDao.deleteAward(id);
	}
	
	@GetMapping(value="deleteReference")
	public ResponseEntity<JsonResponse<Object>> deleteReference(@RequestParam String id){
		logger.info("Method : deleteReference starts");
		
		logger.info("Method : deleteReference ends");
		return candidateDao.deleteReference(id);
	}
	
	@GetMapping(value="deleteSource")
	public ResponseEntity<JsonResponse<Object>> deleteSource(@RequestParam String id){
		logger.info("Method : deleteSource starts");
		
		logger.info("Method : deleteSource ends");
		return candidateDao.deleteSource(id);
	}
	
	@PostMapping(value="applyRequisition")
	public ResponseEntity<JsonResponse<Object>> applyRequisition(@RequestBody CandidateApplyRequisitionModel applyReq){
		logger.info("Method : applyRequisition starts");
		
		logger.info("Method : applyRequisition ends");
		return candidateDao.applyRequisition(applyReq);
	}
	
	/*
	 * @GetMapping(value="getRequisitionOfCandidate") public
	 * ResponseEntity<JsonResponse<List<AddRecruitentModel>>>
	 * getRequisitionOfCandidate(@RequestParam String id){
	 * logger.info("Method : getRequisitionOfCandidate starts");
	 * 
	 * logger.info("Method : getRequisitionOfCandidate ends"); return
	 * candidateDao.getRequisitionOfCandidate(id); }
	 */
	
	@RequestMapping(value = "getRequisitionOfCandidate", method = { RequestMethod.GET })
	public JsonResponse<Object> getRequisitionOfCandidate(@RequestParam String id) {
		logger.info("Method :rest getRequisitionOfCandidate start");
		logger.info("Method :rest getRequisitionOfCandidate endss");
		return candidateDao.getRequisitionOfCandidate(id);
	}
	
	@RequestMapping(value="/addDocumentList" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addShortListCandidate(@RequestBody CandidateDocumentModel candidate) {
		logger.info("Method : addShortListCandidate for rest controller starts");
		logger.info("Method : addShortListCandidate for rest controller ends");
		return candidateDao.addShortListCandidate(candidate);
	}
	
	@GetMapping(value = "viewCandidateDocEdit")
	public List<InventoryVendorDocumentModel> viewCandidateDocEdit(@RequestParam String id) {
		logger.info("Method : viewCandidateDocEdit starts");
		logger.info("Method : viewCandidateDocEdit endss");
		return candidateDao.viewCandidateDocEdit(id);
	}
	
	
	
	/* Candidate Document section */
	@RequestMapping(value = "rest-addCandidateDocument", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>> addCandidateDocument(
			@RequestBody ManageEmployeeDocumentRestModel docModel) {
		logger.info("Method : addCandidateDocument starts");

		logger.info("Method : addCandidateDocument ends");
		return candidateDao.addCandidateDocument(docModel);
	}
	@RequestMapping(value = "/viewCandidatedocument", method = { RequestMethod.GET })
	ResponseEntity<JsonResponse<List<ManageEmployeeDocumentRestModel>>> viewCandidatedocument(
			@RequestParam("id") String id,@RequestParam String organization,@RequestParam String orgDivision) {
		logger.info("Method : viewCandidatedocument start");

		logger.info("Method : viewCandidatedocument ends");

		return candidateDao.viewCandidatedocument(id,organization,orgDivision);
	}

	@GetMapping(value = "deleteCandidateDoc")
	public ResponseEntity<JsonResponse<Object>> deleteCandidateDoc(@RequestParam String docType,String empid,String organization, String orgDivision) {
		logger.info("Method : deleteCandidateDoc starts");
		
		logger.info("Method : deleteCandidateDoc ends");
		return candidateDao.deleteCandidateDoc(docType,empid, organization, orgDivision);
	}
	@RequestMapping(value = "rest-editDocumentDetails", method = { RequestMethod.GET })
	public JsonResponse<ManageEmployeeDocumentRestModel> editDocumentDetails(@RequestParam String docType,String empid,String organization, String orgDivision) {
		logger.info("Method : editDocumentDetails rest starts");

		logger.info("Method :editDocumentDetails rest ends");
		return candidateDao.editDocumentDetails(docType,empid, organization, orgDivision);
	}
	// get doctype 

	@GetMapping(value = "get-getDocumentTypeList")
	public JsonResponse<List<DropDownModel>> getDocumentTypeList(@RequestParam String empid,String orgName,String orgDivision) {
		logger.info("Method : getDocumentTypeList starts");

		logger.info("Method : getDocumentTypeList ends");
		return candidateDao.getDocumentTypeList(empid,orgName,orgDivision);
	}	
	
	//get pdf details for candidate resume
	@GetMapping(value = "get-candidate-pdfDetails")
	public JsonResponse<Object> getCandidateResumeDetails(@RequestParam String id,String organization,String orgDivision,String userId) {
		logger.info("Method : getCandidateResumeDetails starts");

		logger.info("Method : getCandidateResumeDetails ends");
		return candidateDao.getCandidateResumeDetails(id, organization, orgDivision,userId);
	}
/* edit address */
	
	@RequestMapping(value = "rest-editAddressDetails", method = { RequestMethod.GET })
	public JsonResponse<CandidateAddressModel> editAddressDetails(@RequestParam String addressId,String addressType) {
		logger.info("Method : editAddressDetails rest starts");

		logger.info("Method :editAddressDetails rest ends");
		return candidateDao.editAddressDetails(addressId,addressType);
	}
	/* edit education */
	
	@RequestMapping(value = "rest-editEducationDetails", method = { RequestMethod.GET })
	public JsonResponse<CandidateEducationModel> editEducation(@RequestParam String educationId) {
		logger.info("Method : editEducation rest starts");

		logger.info("Method :editEducation rest ends");
		return candidateDao.editEducation(educationId);
	}
	/* edit skills */
	
	@RequestMapping(value = "rest-editSkilssDetails", method = { RequestMethod.GET })
	public JsonResponse<CandidateSkillsModel> editSkill(@RequestParam String skillId) {
		logger.info("Method : editSkill rest starts");

		logger.info("Method :editSkill rest ends");
		return candidateDao.editSkill(skillId);
	}
	
	
	/* edit award */
	
	@RequestMapping(value = "rest-editAwardDetails", method = { RequestMethod.GET })
	public JsonResponse<CandidateAwardsModel> editAwardDetails(@RequestParam String awardId) {
		logger.info("Method : editAwardDetails rest starts");

		logger.info("Method :editAwardDetails rest ends");
		return candidateDao.editAwardDetails(awardId);
	}
	
	/* edit reference */
	@RequestMapping(value = "rest-editReference", method = { RequestMethod.GET })
	public JsonResponse<CandidateReferenceModel> editReference(@RequestParam String refId) {
		logger.info("Method : editReference rest starts");

		logger.info("Method :editReference rest ends");
		return candidateDao.editReference(refId);
	}
	
	/* edit source */
	
	@RequestMapping(value = "rest-editSourceDetails", method = { RequestMethod.GET })
	public JsonResponse<CandidateSourceModel> editSourceDetails(@RequestParam String sourceId) {
		logger.info("Method : editSourceDetails rest starts");

		logger.info("Method :editSourceDetails rest ends");
		return candidateDao.editSourceDetails(sourceId);
	}
/*addNewDocInfo*/
	@RequestMapping(value = "rest-addNewDocInfo", method = { RequestMethod.GET })
	public JsonResponse<Object> addNewDocInfo(@RequestParam String newDocName,String newDocDesc,String userId) {
		logger.info("Method : addNewDocInfo rest starts");

		logger.info("Method :addNewDocInfo rest ends");
		return candidateDao.addNewDocInfo(newDocName,newDocDesc,userId);
	}
	@GetMapping("rest-education-list-candidate")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEducationDetails(){
		logger.info("Method: getEducationDetails  Start");

		logger.info("Method: getEducationDetails ends");
		
		return candidateDao.getEducationDetails();
	}
	
	
	@PostMapping("rest-add-bankDetails")
	public ResponseEntity<JsonResponse<Object>> addBankDetails(@RequestBody candidateBankAccountDetailsRestModel candidate,@RequestParam String orgName,@RequestParam String orgDiv){
		logger.info("Method : addBankDetails starts");
		
		logger.info("Method : addBankDetails ends");
		return candidateDao.addBankDetails(candidate,orgName,orgDiv);
	}
	
	@RequestMapping(value = "rest-viewBankDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<candidateBankAccountDetailsRestModel>>> viewBankDetails(@RequestParam String orgName, @RequestParam String orgDivision,@RequestParam String id) {
		logger.info("Method :viewBankDetails start");

		logger.info("Method :viewBankDetails endss");
		return candidateDao.viewBankDetails(orgName, orgDivision,id);

	}
	
	@RequestMapping(value = "rest-editBankDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> editBankDetails(@RequestParam String orgName, @RequestParam String orgDivision,@RequestParam String id) {
		logger.info("Method :editBankDetails start");

		logger.info("Method :editBankDetails endss");
		return candidateDao.editBankDetails(orgName, orgDivision,id);

	}
	
	@RequestMapping(value = "rest-addNewQualiInfo", method = { RequestMethod.GET })
	public JsonResponse<Object> addNewQualiFication(@RequestParam String newQualName,String newQualDesc,String userId,String orgName,String orgDivision) {
		logger.info("Method : addNewQualiFication rest starts");

		logger.info("Method :addNewQualiFication rest ends");
		return candidateDao.addNewQualiFication(newQualName,newQualDesc,userId,orgName,orgDivision);
	}

	// offer letter data
	@RequestMapping(value = "getCandDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<CandidateDetailsModel>>> getCandDetails(@RequestParam String id) {
		logger.info("Method : getCandDetails starts");
		logger.info("getCandidateId>>>>>>>>>>>" + id);

		logger.info("Method : getCandDetails ends");
		return candidateDao.getCandDetails(id)
;
	}
	
}
