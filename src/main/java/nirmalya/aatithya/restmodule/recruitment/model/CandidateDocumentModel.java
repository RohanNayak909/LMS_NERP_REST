package nirmalya.aatithya.restmodule.recruitment.model;

import java.util.List;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;


public class CandidateDocumentModel {

	private List<InventoryVendorDocumentModel> documentList;
	private String candidateId;
	private String createdBy;
	public List<InventoryVendorDocumentModel> getDocumentList() {
		return documentList;
	}
	public void setDocumentList(List<InventoryVendorDocumentModel> documentList) {
		this.documentList = documentList;
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public CandidateDocumentModel(List<InventoryVendorDocumentModel> documentList, String candidateId,
			String createdBy) {
		super();
		this.documentList = documentList;
		this.candidateId = candidateId;
		this.createdBy = createdBy;
	}
	
	
	
}
