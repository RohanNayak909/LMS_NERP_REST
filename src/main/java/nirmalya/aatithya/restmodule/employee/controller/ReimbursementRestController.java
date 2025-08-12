package nirmalya.aatithya.restmodule.employee.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.ReimbursementRestDao;
import nirmalya.aatithya.restmodule.employee.model.ReimbrusementPaymentModel;
import nirmalya.aatithya.restmodule.employee.model.ReimbursementModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;

@RestController
@RequestMapping(value = { "employee/" })
public class ReimbursementRestController {
	Logger logger = LoggerFactory.getLogger(ReimbursementRestController.class);

	@Autowired
	ReimbursementRestDao reimbursementRestDao;

	@Autowired
	EnvironmentVaribles env;

	@GetMapping(value = "get-reimbursement-type")
	public List<DropDownModel> getReimbursementType() {
		logger.info("Method : getReimbursementType starts");
		logger.info("Method : getReimbursementType endss");
		return reimbursementRestDao.getReimbursementTypeList();
	}

	/*
	 * 
	 * Get mapping for schedule
	 */
	@GetMapping(value = "get-policy-type")
	public List<DropDownModel> getPolicyType() {
		logger.info("Method : getPolicyType starts");
		logger.info("Method : getPolicyType endss");
		return reimbursementRestDao.getPolicyTypeList();
	}
	@RequestMapping(value = "getEmployeeListData1", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeList(@RequestParam String userId) {
		logger.info("Method : getEmployeeList starts");

		logger.info("Method : getEmployeeList ends");
		return reimbursementRestDao.getEmployeeList(userId);
	}

	// Gender dropdown
	@RequestMapping(value = "getRequisitionList", method = { RequestMethod.GET })
	public List<DropDownModel> getRequisitionList() {
		logger.info("Method : getRequisitionList starts");

		logger.info("Method : getRequisitionList ends");
		return reimbursementRestDao.getRequisitionList();
	}

	@PostMapping(value = "reimbursement-view")
	public JsonResponse<List<ReimbursementModel>> viewReimbursement(@RequestBody EmpRoleModel empModel) {
		logger.info("Method : viewReimbursement starts");

		String userId = empModel.getUserId();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		List<String> roleList = empModel.getUserRole();
		String type = empModel.getType();

		String userRole = "";
		if (roleList.size() > 0) {
			for (String m : roleList) {
				if (empModel.getType().equals("WEB")) {
					userRole = userRole + m + ",";
				} else {
					userRole = userRole + "\"" + m + "\",";
				}
			}
		}

		if (userRole != null && userRole != "") {
			userRole = userRole.substring(0, userRole.length() - 1);
		}

		logger.info("Method : viewReimbursement ends");
		return reimbursementRestDao.viewReimbursement(userId, userRole,organization,orgDivision,type,empModel.getSelfType());
	}

	/*
	 * Add Reimbursement rest
	 * 
	 */


	@PostMapping(value = "add-reimbursement")
	public ResponseEntity<JsonResponse<Object>> addReimbursement(@RequestBody ReimbursementModel employee) {
		logger.info("Method : addReimbursement starts");

		logger.info("Method : addReimbursement ends");
		return reimbursementRestDao.addReimbursementRestDao(employee);
	}

	/*
	 *
	 * Edit Reimbursement rest
	 *
	 */
	@RequestMapping(value = "edit-rest-reimbursement", method = { RequestMethod.GET })
	public JsonResponse<ReimbursementModel> editReimbursement(@RequestParam String id) {
		logger.info("Method : editReimbursement rest starts");

		logger.info("Method :editReimbursement rest ends");
		return reimbursementRestDao.editReimbursement(id);
	}

	/*
	 *
	 * Delete Reimbursement rest
	 *
	 */

	@RequestMapping(value = "deleteReimbursement", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePolicy(@RequestParam String id) {
		logger.info("Method : deleteReimbursement starts");

		logger.info("Method : deleteReimbursement ends");
		return reimbursementRestDao.deleteReimbursement(id);
	}


	@PostMapping(value = "add-reimbursement-travel-details")
	public ResponseEntity<JsonResponse<Object>> addReimbursementTravelDetails(
			@RequestBody ReimbursementModel reimbursementModel) {
		logger.info("Method : addReimbursementTravelDetails starts");

		logger.info("Method : addReimbursementTravelDetails ends");
		return reimbursementRestDao.addReimbursementTravelDetails(reimbursementModel);
	}
	// Post mapping foe view Reimbuseiment

	@GetMapping(value = "viewReimbursementTravels")
	public JsonResponse<List<ReimbursementModel>> viewReimbursementTravels() {
		logger.info("Method : viewReimbursementTravels");

		logger.info("Method : viewReimbursementTravels ends");
		return reimbursementRestDao.viewReimbursementTravels();
	}

	/*
	 *
	 * Delete Reimbursement rest
	 *
	 */
	@GetMapping(value = "deleteReimbursementTravels")
	public JsonResponse<ReimbursementModel> deleteReimbursementTravels(@RequestParam String id) {
		logger.info("Method : Delete deleteReimbursementTravels rest starts");

		logger.info("Method :Delete deleteReimbursementTravels rest ends");
		return reimbursementRestDao.deleteReimbursementTravels(id);
	}

	/*
	 *
	 * Edit Reimbursement rest
	 *
	 */
	@RequestMapping(value = "edit-rest-reimbursement-travels", method = { RequestMethod.GET })
	public JsonResponse<ReimbursementModel> editReimbursementTravel(@RequestParam String id) {
		logger.info("Method : editReimbursementTravel rest starts");

		logger.info("Method :editReimbursementTravel rest ends");
		return reimbursementRestDao.editReimbursementTravel(id);
	}

	/*
	 * for drop down for grt Pay Mode type
	 */
	@RequestMapping(value = "getPaymentMode", method = { RequestMethod.GET })
	public List<DropDownModel> getPaymentMode() {

		logger.info("Method in rest: getPaymentMode starts");

		logger.info("Method in rest: getPaymentMode ends");

		return reimbursementRestDao.getPaymentMode();
	}

	/*
	 * for drop down for grt Pay Mode type
	 */
	@RequestMapping(value = "getBankNamesPay", method = { RequestMethod.GET })
	public List<DropDownModel> getBankNamesPay() {

		logger.info("Method in rest: getBankNamesPay starts");

		logger.info("Method in rest: getBankNamesPay ends");

		return reimbursementRestDao.getBankNamesPay();
	}

	/*
	 * Add Reimbursement rest
	 * 
	 */

	@PostMapping(value = "add-reimbursement-payment")
	public JsonResponse<Object> addReimbursementPayment(@RequestBody ReimbrusementPaymentModel reimbursementModel) {
		logger.info("Method : addReimbursementPayment rest starts");

		logger.info("Method : addReimbursementPayment rest ends");
		return reimbursementRestDao.addReimbursementPayment(reimbursementModel);
	}

	@GetMapping(value = "get-activity-log-riemb")
	public List<ActivitylogModel> getActivityLog(@RequestParam String id) {
		logger.info("Method : getActivityLog starts");
		logger.info("Method : getActivityLog endss");
		return reimbursementRestDao.getActivityLog(id);
	}

	// approve Reimbursement details

	@GetMapping(value = "approvereimbursementApply")
	public JsonResponse<ReimbursementModel> approveReimbursementApply(@RequestParam String id, String name,
			String comment, String roleid) {
		logger.info("Method : approveReimbursementApply starts");

		logger.info("Method : approveReimbursementApply ends");

		return reimbursementRestDao.approveReimbursementApply(id, name, comment, roleid);
	}
	//approve Reimbursement details api
	@PostMapping(value="approvereimbursementApply-api")
	public JsonResponse<ReimbursementModel> approvereimbursementApplyApi(@RequestBody EmpRoleModel empModel){
		logger.info("Method : approvereimbursementApplyApi starts");
		logger.info("empModel===="+empModel);
		String id = empModel.getRequisitionName();
		String name = empModel.getUserId();
		String comment = empModel.getComment();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		List<String> roleList = empModel.getUserRole();
		String userRole = "";
		if(roleList.size() > 0) {
			for(String m : roleList) {
				if(empModel.getType().equals("WEB")) {
					userRole = userRole + m + ",";
				} else {
					userRole = userRole +"\"" + m + "\",";
				}
			}
		}
		if(userRole != null && userRole != "") {
			userRole = userRole.substring(0, userRole.length() - 1);
		}
		logger.info("User Id = "+id+ " *** userRole====="+userRole);
		logger.info("Method : approvereimbursementApplyApi ends");
		return reimbursementRestDao.approveReimbursementApply(id, name, comment, userRole);
	}
	// reject Reimbursement

	@GetMapping(value = "rejectreimbursementApply")
	public JsonResponse<ReimbursementModel> rejectAdvanceApply(@RequestParam String id, String name, String comment) {
		logger.info("Method : rejectAdvanceApply starts");

		logger.info("Method : rejectAdvanceApply ends");
		return reimbursementRestDao.rejectReimbursementApply(id, name, comment);
	}
	//reject Reimbursement details api
	@PostMapping(value="rejectreimbursementApply-api")
	public JsonResponse<ReimbursementModel> rejectreimbursementApplyApi(@RequestBody EmpRoleModel empModel){
		logger.info("Method : rejectreimbursementApplyApi starts");
		logger.info("empModel===="+empModel);
		String id = empModel.getRequisitionName();
		String name = empModel.getUserId();
		String comment = empModel.getComment();
		String organization=empModel.getOrganization(); 
		String orgDivision=empModel.getOrgDivision();
		List<String> roleList = empModel.getUserRole();
		String userRole = "";
		if(roleList.size() > 0) {
			for(String m : roleList) {
				if(empModel.getType().equals("WEB")) {
					userRole = userRole + m + ",";
				} else {
					userRole = userRole +"\"" + m + "\",";
				}
			}
		}
		if(userRole != null && userRole != "") {
			userRole = userRole.substring(0, userRole.length() - 1);
		}
		logger.info("User Id = "+id+ " *** userRole====="+userRole);
		logger.info("Method : rejectreimbursementApplyApi ends");
		return reimbursementRestDao.rejectReimbursementApply(id, name, comment);
	}
	@PostMapping(value = "post-reimbursement-dataupload-api", headers = "content-type=multipart/*", consumes = {
			"application/*" })
	public ResponseEntity<JsonResponse<Object>> reimbursementDataUpload(ReimbursementModel reimbursementModel) {
		logger.info("Method : reimbursementDataUpload starts");

		MultipartFile x = reimbursementModel.getMulFile();
		String fileName = null;
		if (x != null) {
			byte[] bytes = null;
			try {
				bytes = x.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileName = saveAllreimbursementDocuments(bytes, reimbursementModel.getExtension(),
					reimbursementModel.getCreatedBy(), reimbursementModel.getFiletype());
		}
		reimbursementModel.setDocName1(fileName);

		logger.info("Method : reimbursementDataUpload ends");
		return reimbursementRestDao.reimbursementDataUpload(reimbursementModel);
	}

	public String saveAllreimbursementDocuments(byte[] imageBytes, String ext, String pId, String filetype) {
		logger.info("Method : saveAllreimbursementDocuments starts");

		String imageName = null;
logger.info("ext==="+ext+"   filetype==="+filetype);
		try {

			if (imageBytes != null) {
				long nowTime = new Date().getTime();
 
				if (ext.contentEquals("jpeg") || ext.contentEquals("jpg")) {
					imageName = pId + "_" + nowTime + ".jpg";
				}else if (ext.contentEquals("png")) {
					imageName = pId + "_" + nowTime + ".png";
				} else {
					imageName = pId + "_" + nowTime + "." + ext;
				}
			}

			Path path = Paths.get(env.getFileUploadReimbursement() + imageName);
			if (imageBytes != null) {
				if (pId != null && pId != "") {
					Files.write(path, imageBytes);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : saveAllreimbursementDocuments ends");
		return imageName;
	}
	//reimbursement view api 
		@GetMapping(value = "reimbursement-view-api")
		public JsonResponse<List<ReimbursementModel>> viewReimbursementApi(@RequestParam String userId,String organization,String orgDivision) {
			logger.info("Method : viewReimbursementApi starts");
 
			logger.info("Method : viewReimbursementApi ends");
		return reimbursementRestDao.viewReimbursementApi(userId,organization,orgDivision);
	}
		
		@RequestMapping(value = "rest-reigetEmpData", method = { RequestMethod.GET })
		public JsonResponse<DropDownModel> getEmpData(@RequestParam String id) {
			logger.info("Method : getEmpData rest starts");

			logger.info("Method :getEmpData rest ends");
			return reimbursementRestDao.getEmpData(id);
		}
}
