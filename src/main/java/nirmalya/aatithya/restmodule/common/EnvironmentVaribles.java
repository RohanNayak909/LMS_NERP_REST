package nirmalya.aatithya.restmodule.common;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Nirmalya Labs
 *
 */
public class EnvironmentVaribles {

	@Value("${service.url.baseURL}")
	private String baseURL;

	@Value("${service.url.mobileView}")
	private String mobileView;

	@Value("${service.url.uploadEmployee}")
	private String fileUploadEmployee;

	@Value("${service.url.uploadReimbursement}")
	private String fileUploadReimbursement;

	@Value("${service.url.uploadImageCrm}")
	private String fileUploadCRM;

	@Value("${service.url.uploadProfile}")
	private String fileUploadProfile;

	@Value("${service.url.mobileDocView}")
	private String mobileDocView;

	@Value("${service.url.fileUpload-document}")
	private String fileUploadDocumenttUrl;

	@Value("${service.url.fileUpload-taskdocument}")
	private String fileUploadtaskdocumentUrl;

	@Value("${service.url.fileUpload-communication}")
	private String fileUploadCommDocUrl;

	@Value("${service.url.assetDocUrl}")
	private String assetDocUrl;

	@Value("${service.url.fileUpload-ticket}")
	private String fileUploadticketUrl;

	@Value("${service.url.grcDocUrl}")
	private String grcDocUrl;

	@Value("${service.url.fileUpload-notice-policy}")
	private String fileUploadnoticeUrl;

	@Value("${service.url.fileUpload-resignation}")
	private String fileUploadResignationUrl;

	public EnvironmentVaribles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBaseURL() {
		return baseURL;
	}

	public String getFileUploadResignationUrl() {
		return fileUploadResignationUrl;
	}

	public String getFileUploadnoticeUrl() {
		return fileUploadnoticeUrl;
	}

	public String getFileUploadCommDocUrl() {
		return fileUploadCommDocUrl;
	}

	public String getMobileView() {
		return mobileView;
	}

	public String getFileUploadEmployee() {
		return fileUploadEmployee;
	}

	public String getFileUploadReimbursement() {
		return fileUploadReimbursement;
	}

	public String getFileUploadProfile() {
		return fileUploadProfile;
	}

	public String getFileUploadDocumenttUrl() {
		return fileUploadDocumenttUrl;
	}

	public String getBaseUrl() {
		return baseURL;
	}

	public String getMobileDocView() {
		return mobileDocView;
	}

	public String getFileUploadCRM() {
		return fileUploadCRM;
	}

	public String getAssetDocUrl() {
		return assetDocUrl;
	}

	public void setAssetDocUrl(String assetDocUrl) {
		this.assetDocUrl = assetDocUrl;
	}

	public String getFileUploadticketUrl() {
		return fileUploadticketUrl;
	}

	public void setFileUploadticketUrl(String fileUploadticketUrl) {
		this.fileUploadticketUrl = fileUploadticketUrl;
	}

	public String getFileUploadtaskdocumentUrl() {
		return fileUploadtaskdocumentUrl;
	}

	public String getGrcDocUrl() {
		return grcDocUrl;
	}

	public void setGrcDocUrl(String grcDocUrl) {
		this.grcDocUrl = grcDocUrl;
	}
}
