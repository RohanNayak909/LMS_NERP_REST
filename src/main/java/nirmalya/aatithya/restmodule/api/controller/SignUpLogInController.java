package nirmalya.aatithya.restmodule.api.controller;

import java.io.IOException;
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

import nirmalya.aatithya.restmodule.api.dao.SignUpLogInDao;
import nirmalya.aatithya.restmodule.api.model.ApiUserModel;
import nirmalya.aatithya.restmodule.api.model.AttendanceModel;
import nirmalya.aatithya.restmodule.api.model.EmployeeProfileApiModel;
import nirmalya.aatithya.restmodule.api.model.MobileVersionApiModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeAddressRestModel;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.util.DocumentUpload;

@RestController
@RequestMapping(value = "api")
public class SignUpLogInController {

	@Autowired
	SignUpLogInDao sigUpLogInDao;

	@Autowired
	EnvironmentVaribles env;

	@Autowired
	DocumentUpload documentUpload;

	Logger logger = LoggerFactory.getLogger(SignUpLogInController.class);

	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public JsonResponse<ApiUserModel> getLoginMultipleUser(@RequestParam String mobileNo,
			@RequestParam String password) {
		logger.info("Method : getLoginMultipleUser starts");
		logger.info("Method : getLoginMultipleUser ends");
		return sigUpLogInDao.getLoginMultipleUserDetails(mobileNo, password);
	}
	//mobile login api 
	@RequestMapping(value = "/login-api", method = { RequestMethod.GET })
	public JsonResponse<ApiUserModel> getLoginApi(@RequestParam String userName,String password,String imeiNo) {
		logger.info("Method : getLoginApi starts");
		logger.info("Method : getLoginApi ends");
		return sigUpLogInDao.getLoginApi(userName, password,imeiNo);
	}
	@RequestMapping(value = "/login-mobile", method = { RequestMethod.GET })
	public JsonResponse<ApiUserModel> getLoginMultipleUserMobile(@RequestParam String mobileNo,
			@RequestParam String employeeId, @RequestParam String imeiNo) {
		logger.info("Method : getLoginMultipleUserMobile starts");
		logger.info("Method : getLoginMultipleUserMobile ends");
		return sigUpLogInDao.getLoginMultipleUserMobile(mobileNo, employeeId, imeiNo);
	}

	@PostMapping(value = "/forgot-password-get-otp")
	public ResponseEntity<JsonResponse<Object>> getOTPForFOrgotPassword(@RequestBody DropDownModel data) {
		logger.info("Method : getOTPForFOrgotPassword starts");

		logger.info("Method : getOTPForFOrgotPassword ends");
		return sigUpLogInDao.getOTPForFOrgotPassword(data);
	}

	@PostMapping(value = "/change-password")
	public ResponseEntity<JsonResponse<Object>> changePassword(@RequestBody DropDownModel data) {
		logger.info("Method : changePassword starts");

		logger.info("Method : changePassword ends");
		return sigUpLogInDao.changePassword(data);
	}

	@PostMapping(value = "/login-match-password")
	public ResponseEntity<JsonResponse<Object>> loginMatchPassword(@RequestBody DropDownModel data) {
		logger.info("Method : loginMatchPassword starts");

		logger.info("Method : loginMatchPassword ends");
		return sigUpLogInDao.loginMatchPassword(data);
	}

	@PostMapping(value = "/save-new-password")
	public ResponseEntity<JsonResponse<Object>> saveNewPassword(@RequestBody DropDownModel data) {
		logger.info("Method : saveNewPassword starts");

		logger.info("Method : saveNewPassword ends");
		return sigUpLogInDao.saveNewPassword(data);
	}

	@GetMapping(value = "/get-attendance-list")
	public ResponseEntity<JsonResponse<List<AttendanceModel>>> attendanceByOrganization(@RequestParam String userid,
			@RequestParam String tAttndncDate) {
		logger.info("Method : attendanceByOrganization starts");

		logger.info("Method : attendanceByOrganization ends");
		return sigUpLogInDao.attendanceByOrganization(userid, tAttndncDate);
	}
	@GetMapping(value = "/get-attendance-status")
	public ResponseEntity<JsonResponse<List<AttendanceModel>>> getAttendanceStatus(@RequestParam String userid,
			String tAttndncDate,String org,String orgDiv) {
		logger.info("Method : getAttendanceStatus starts");

		logger.info("Method : getAttendanceStatus ends");
		return sigUpLogInDao.getAttendanceStatus(userid, tAttndncDate,org,orgDiv);
	}
	@PostMapping(value = "/change-password-user-wise")
	public ResponseEntity<JsonResponse<Object>> changePasswordUserWiseAfterLogIn(@RequestBody DropDownModel data) {
		logger.info("Method : changePasswordUserWiseAfterLogIn starts");

		logger.info("Method : changePasswordUserWiseAfterLogIn ends");
		return sigUpLogInDao.changePasswordUserWiseAfterLogIn(data);
	}

	@PostMapping(value = "/add-attendance-list")
	public ResponseEntity<JsonResponse<AttendanceModel>> addAttendance(@RequestBody AttendanceModel attendanceModel) {
		logger.info("Method : addAttendance starts");
		logger.info("Method : addAttendance ends");
		return sigUpLogInDao.addAttendance(attendanceModel);
	}

	@GetMapping(value = "/get-reimbursement-list-api")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getReimbursementList() {
		logger.info("Method : getReimbursementList starts");

		logger.info("Method : getReimbursementList ends");
		return sigUpLogInDao.getReimbursementList();
	}

	@RequestMapping(value = "save-employee-address-api", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ManageEmployeeAddressRestModel>> postEmployeeAddressApi(
			@RequestBody List<ManageEmployeeAddressRestModel> data) {
		logger.info("Method : postEmployeeAddressApi starts");

		logger.info("Method : postEmployeeAddressApi ends");
		return sigUpLogInDao.postEmployeeAddressApiDao(data);
	}

	@PostMapping(value = "post-upload-document-profile-api", headers = "content-type=multipart/*", consumes = {
			"application/*" })
	public ResponseEntity<JsonResponse<Object>> profileDataUpload(EmployeeProfileApiModel employeeProfileApiModel) {
		logger.info("Method : profileDataUpload starts");

		MultipartFile x = employeeProfileApiModel.getMulFile();
		String fileName = null;
		if (x != null) {
			byte[] bytes = null;
			try {
				bytes = x.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileName = documentUpload.saveAllTypeDocument(bytes, employeeProfileApiModel.getExtension(),
					employeeProfileApiModel.getEmpId(), "UPLOADDOCUMENT");

		}

		employeeProfileApiModel.setDocName(fileName);

		logger.info("Method : profileDataUpload ends");
		return sigUpLogInDao.profileDataUploadDao(employeeProfileApiModel);
	}

	@GetMapping(value = "/get-upload-document-profile-api")
	public JsonResponse<List<DropDownModel>> getUploadProfileDetailsApi(@RequestParam String empId,
			@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : getUploadProfileDetailsApi starts");

		logger.info("Method : getUploadProfileDetailsApi ends");
		return sigUpLogInDao.getUploadProfileDetailsApiDao(empId, organization, orgDivision);
	}

//get mobile version
	@GetMapping(value = "/get-mobile-version")
	public ResponseEntity<JsonResponse<MobileVersionApiModel>> getMobileVersion() {
		logger.info("Method : getMobileVersion starts");

		logger.info("Method : getMobileVersion ends");
		return sigUpLogInDao.getMobileVersion();
	}

	// check payslip eligible
	@GetMapping(value = "/check-payslip-eligible-api")
	public ResponseEntity<JsonResponse<DropDownModel>> checkPayslipEligibleApi(@RequestParam String empId,
			@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : checkPayslipEligibleApi starts");

		logger.info("Method : checkPayslipEligibleApi ends");
		return sigUpLogInDao.checkPayslipEligibleApi(empId, organization, orgDivision);
	}

	// get attendance Report
	@GetMapping(value = "/get-attendance-report-api")
	public JsonResponse<Object> getAttendanceReportApi(@RequestParam String empId, String fromDate, String toDate,
			String organization, String orgDivision) {
		logger.info("Method : getAttendanceReportApi starts");

		logger.info("Method : getAttendanceReportApi ends");
		return sigUpLogInDao.getAttendanceReportApi(empId, fromDate, toDate, organization, orgDivision);
	}

	// get biometric attendance
	@GetMapping(value = "/get-biometric-attendance-api")
	public ResponseEntity<JsonResponse<List<AttendanceModel>>> getBiometricAttendanceApi(
			@RequestParam String attendanceDate, String organization, String orgDivision) {
		logger.info("Method : getBiometricAttendanceApi starts");

		logger.info("Method : getBiometricAttendanceApi ends");
		return sigUpLogInDao.getBiometricAttendanceApi(attendanceDate, organization, orgDivision);
	}

	// check user eligible
	@GetMapping(value = "/check-user-eligible-api")
	public ResponseEntity<JsonResponse<DropDownModel>> checkUserEligibleApi(@RequestParam String empId,
			@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : checkUserEligibleApi starts");

		logger.info("Method : checkUserEligibleApi ends");
		return sigUpLogInDao.checkUserEligibleApi(empId, organization, orgDivision);
	}
	// get user menu
		@PostMapping(value = "/get-user-menu-api")
		public JsonResponse<Object> getUserMenuApi(@RequestBody EmpRoleModel empModel) {
			logger.info("Method : getUserMenuApi starts");
			String userId = empModel.getUserId();
			String organization = empModel.getOrganization();
			String orgDivision = empModel.getOrgDivision();
			List<String> roleList = empModel.getUserRole();
			String userRole = "";
			if (roleList.size() > 0) {
				for (String m : roleList) {
					userRole = userRole + "\"" + m + "\",";
				}
			}

			if (userRole != null && userRole != "") {
				userRole = userRole.substring(0, userRole.length() - 1);
			}
			logger.info("Method : getUserMenuApi ends");
			return sigUpLogInDao.getUserMenuApi(userId,userRole,organization,orgDivision);
		}
}
