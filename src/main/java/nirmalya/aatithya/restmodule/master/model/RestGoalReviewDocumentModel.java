package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestGoalReviewDocumentModel {
	private String documnentName;
	private String fileName;
	private String noticeId;
	private String draftNo;
	private List<String> documentFile = new ArrayList<String>();
	private String action;
	private String imageNameEdit;
	private String createdBy;
	private String meetingNo;
	public String getDocumnentName() {
		return documnentName;
	}
	public void setDocumnentName(String documnentName) {
		this.documnentName = documnentName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public String getDraftNo() {
		return draftNo;
	}
	public void setDraftNo(String draftNo) {
		this.draftNo = draftNo;
	}
	public List<String> getDocumentFile() {
		return documentFile;
	}
	public void setDocumentFile(List<String> documentFile) {
		this.documentFile = documentFile;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getImageNameEdit() {
		return imageNameEdit;
	}
	public void setImageNameEdit(String imageNameEdit) {
		this.imageNameEdit = imageNameEdit;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getMeetingNo() {
		return meetingNo;
	}
	public void setMeetingNo(String meetingNo) {
		this.meetingNo = meetingNo;
	}
	
	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;
	}
}
