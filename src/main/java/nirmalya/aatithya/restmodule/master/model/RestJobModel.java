package nirmalya.aatithya.restmodule.master.model;

public class RestJobModel {
	private String jobId;
	private String jobName;
	private String jobUrl;

	private String jobDesc;
	private String status;
	private String createdBy;

	public RestJobModel() {
		super();
// TODO Auto-generated constructor stub
	}

	public RestJobModel(Object jobId, Object jobName, Object jobUrl, Object jobDesc, Object status, Object createdBy) {
		super();
		this.jobId = (String) jobId;
		this.jobName = (String) jobName;
		this.jobUrl = (String) jobUrl;
		this.jobDesc = (String) jobDesc;
		this.status = (String) status;
		this.createdBy = (String) createdBy;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobUrl() {
		return jobUrl;
	}

	public void setJobUrl(String jobUrl) {
		this.jobUrl = jobUrl;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}