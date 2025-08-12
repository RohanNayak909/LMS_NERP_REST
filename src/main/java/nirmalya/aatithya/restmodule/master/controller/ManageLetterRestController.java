package nirmalya.aatithya.restmodule.master.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.ManageLetterDao;
import nirmalya.aatithya.restmodule.master.model.ManageNoticeRestModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master/")
public class ManageLetterRestController {
	
	Logger logger = LoggerFactory.getLogger(ManagePolicyRestController.class);

	@Autowired
	ManageLetterDao manageLetterDao;


	@GetMapping(value = "rest-get-elg-employee")
	public JsonResponse<Object> getEmployeeList(@RequestParam String userId, @RequestParam String org,@RequestParam String orgDiv, String type) {
		logger.info("Method : getEmployeeList starts");

		logger.info("Method : getEmployeeList ends");
		return manageLetterDao.getEmployeeList(org, orgDiv, userId, type);
	}
	
	@GetMapping(value = "get-all-notice-type")
	public List<DropDownModel> dropDownshift(@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : dropDownshift starts");

		logger.info("Method : dropDownshift ends");
		return manageLetterDao.getNoticeType(organization, orgDivision);
	}
	
	// Auto Search Employee.
	
		@GetMapping(value = "get-all-employee-list")
		public JsonResponse<Object> employeeAutoSearch(
				@RequestParam String id,String org,String orgDiv) {
			logger.info("Method : EmployeeAutoSearch starts");

			logger.info("Method :EmployeeAutoSearch endss");
			return manageLetterDao.employeeAutoSearch(id,org,orgDiv);
		}

		@GetMapping(value = "rest-get-notice-content")
		public JsonResponse<Object> getNoticeContent(@RequestParam String org, @RequestParam String orgDiv,
				@RequestParam String id) {
			logger.info("Method : getNoticeContent starts");

			logger.info("Method : getNoticeContent ends");
			return manageLetterDao.getNoticeContent(org, orgDiv, id);
		}
	
	@GetMapping(value = "rest-notice-edit-fetch")
	public  JsonResponse<Object> getNoticeEdit(@RequestParam String org, @RequestParam String orgDiv, @RequestParam String id) {
		logger.info("Method : getNoticeEdit starts");
		
		logger.info("Method : getNoticeEdit ends");
		return manageLetterDao.getNoticeEdit(org, orgDiv, id);
	}
	
	// Add Notice Against Eligible Employee

		@PostMapping(value = "rest-add-notice-dtls")
		public ResponseEntity<JsonResponse<ManageNoticeRestModel>> saveNoticeDetails(
				@RequestBody ManageNoticeRestModel data) {
			logger.info("Method : saveNoticeDetails starts");

			logger.info("Method : saveNoticeDetails ends");
			return manageLetterDao.saveNoticeDetails(data);
		}
		
		
		@GetMapping(value = "get-notice-pdfDetails")
		public JsonResponse<Object> getNoticePdfDetails(@RequestParam String id,String organization,String orgDivision,String userId) {
			logger.info("Method : getNoticePdfDetails starts");

			logger.info("Method : getNoticePdfDetails ends");
			return manageLetterDao.getNoticePdfDetails(id, organization, orgDivision,userId);
		}
		
		//Save mail details
		@GetMapping(value = "send-email-notice")
		public JsonResponse<Object> sendEmailNotice(
				@RequestParam String noticeId, String emailTo, String emailCc, String emailBody, String organization,
				String orgDivision, String userId) {
			logger.info("Method : sendEmailNotice starts");

			logger.info("Method : sendEmailNotice ends");
			return manageLetterDao.sendEmailNotice(noticeId, emailTo, emailCc, emailBody, organization, orgDivision, userId);
		}

		//Save offline notice details
		@GetMapping(value = "rest-notice-offline")
		public JsonResponse<Object> sendOfflineNotice(@RequestParam String org, String orgDiv, String userId, String id) {
			logger.info("Method : sendOfflineNotice starts");
			
			logger.info("Method : sendOfflineNotice ends");
			return manageLetterDao.sendOfflineNotice(org, orgDiv, userId, id);
		}
		 
		//Delete Letter
		@GetMapping(value = "rest-delete-letter")
		public JsonResponse<Object> deleteLetter(@RequestParam String org, String orgDiv, String userId, String id) {
			logger.info("Method : deleteLetter starts");
			
			logger.info("Method : deleteLetter ends");
			return manageLetterDao.deleteLetter(org, orgDiv, userId, id);
		}
		
		// employee response upload by HR
		@PostMapping(value = "rest-response-add")
		public ResponseEntity<JsonResponse<ManageNoticeRestModel>> uploadEmployeeResponse(

				@RequestBody ManageNoticeRestModel data) {
			logger.info("Method : uploadEmployeeResponse starts");
			
			logger.info("Method : uploadEmployeeResponse ends");
			return manageLetterDao.uploadEmployeeResponse(data);
		}

		@GetMapping(value = "rest-attacment-view")
		public  JsonResponse<Object> attachmentView(@RequestParam String org, String orgDiv,String userId, String id) {
			logger.info("Method : attachmentView starts");
			
			logger.info("Method : attachmentView ends");
			return manageLetterDao.attachmentView(org, orgDiv,userId, id);
		}
		
		@GetMapping(value = "rest-viewAllNoticeLetter")
		public  JsonResponse<Object> viewAllNoticeLetter(@RequestParam String org, String orgDiv,String userId) {
			logger.info("Method : viewAllNoticeLetter starts");
			System.err.println(org +"  @@@@  "+ orgDiv +"  @@@@  "+ userId );
			logger.info("Method : viewAllNoticeLetter ends");
			return manageLetterDao.viewAllNoticeLetter(org, orgDiv,userId);
		}
}
