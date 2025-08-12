package nirmalya.aatithya.restmodule.common.utils.qa;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.qa.model.ReatEvaluationOfOuterCartonsModel;


public class GenerateOuterCartonsParam {
	public static String getEvalOfOuterCartons(ReatEvaluationOfOuterCartonsModel qa) {
		String s = "";
		String listdata = "";
		String listGridData = "";
		System.out.println("gatepass====" + qa);
		if (qa.getEvalutionId() != null && qa.getEvalutionId() != "") {
			s = s + "@p_evalId='" + qa.getEvalutionId() + "',";
		}
		if (qa.getQaRequestedId() != null && qa.getQaRequestedId() != "") {
			s = s + "@p_qaId='" + qa.getQaRequestedId() + "',";
		}
		if (qa.getRefNo() != null && qa.getRefNo() != "") {
			s = s + "@p_refNo='" + qa.getRefNo() + "',";
		}
		if (qa.getIssueNo() != null && qa.getIssueNo() != "") {
			s = s + "@p_issueNo='" + qa.getIssueNo() + "',";
		}
		if (qa.getIssuedDate() != null && qa.getIssuedDate() != "") {
			s = s + "@p_issueDt='" + DateFormatter.getStringDate(qa.getIssuedDate()) + "',";
		}
		if (qa.getChallanNo() != null && qa.getChallanNo() != "") {
			s = s + "@p_challanNo='" + qa.getChallanNo() + "',";
		}
		if (qa.getReceiptDate() != null && qa.getReceiptDate() != "") {
			s = s + "@p_receptDt='" + DateFormatter.getStringDate(qa.getReceiptDate()) + "',";
		}
		if (qa.getSku() != null && qa.getSku() != "") {
			s = s + "@p_sku='" + qa.getSku() + "',";
		}
		if (qa.getProduct() != null && qa.getProduct() != "") {
			s = s + "@p_product='" + qa.getProduct() + "',";
		}
		if (qa.getSpecificationNo() != null && qa.getSpecificationNo() != "") {
			s = s + "@p_specNo='" + qa.getSpecificationNo() + "',";
		}
		if (qa.getGrrNo() != null && qa.getGrrNo() != "") {
			s = s + "@p_grrNo='" + qa.getGrrNo() + "',";
		}
		if (qa.getSamplingDate() != null && qa.getSamplingDate() != "") {
			s = s + "@p_samplingDt='" + DateFormatter.getStringDate(qa.getSamplingDate()) + "',";
		}
		if (qa.getSupplier() != null && qa.getSupplier() != "") {
			s = s + "@p_supplier='" + qa.getSupplier() + "',";
		}
		if (qa.getQuantityRcvd() != null && qa.getQuantityRcvd() != "") {
			s = s + "@p_quantRcved='" + qa.getQuantityRcvd() + "',";
		}
		if (qa.getCheckingDate() != null && qa.getCheckingDate() != "") {
			s = s + "@p_checkinDt='" + DateFormatter.getStringDate(qa.getCheckingDate()) + "',";
		}
		if (qa.getQuantityChkd() != null && qa.getQuantityChkd() != "") {
			s = s + "@p_quantChecked='" + qa.getQuantityChkd() + "',";
		}
		if (qa.getRemark() != null && qa.getRemark() != "") {
			s = s + "@p_remark='" + qa.getRemark() + "',";
		}
		if (qa.getCreatedBy() != null && qa.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + qa.getCreatedBy() + "',";
		}
		if (qa.getOrganization() != null && qa.getOrganization() != "") {
			s = s + "@p_org='" + qa.getOrganization() + "',";
		}
		if (qa.getOrgDivision() != null && qa.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + qa.getOrgDivision() + "',";
		}
		
		if (qa.getImgName() != null && qa.getImgName() != "") {
			s = s + "@p_imgName='" + qa.getImgName() + "',";
		}
		if (qa.getImgUrl() != null && qa.getImgUrl() != "") {
			s = s + "@p_imgUrl='" + qa.getImgUrl() + "',";
		}
		

		if (qa.getItemDtls() != null && !qa.getItemDtls().isEmpty()) {
			for (ReatEvaluationOfOuterCartonsModel m : qa.getItemDtls()) {
				listdata = listdata + "(@p_evalId,\""  + m.getParmId() + "\",\"" + m.getSubParam() + "\",\"" + m.getParam() + "\",\""+ m.getSpec()
				+ "\",\"" + m.getCol1() + "\",\"" + m.getCol2() + "\",\"" + m.getCol3() + "\",\"" + m.getCol4() + "\",\"" + m.getCol5() + "\",\""  + m.getAvg() 
				+ "\",\"" + qa.getCreatedBy() + "\",\"" + qa.getOrganization() + "\",\"" + qa.getOrgDivision() + "\"),";
				
				listGridData = listGridData + "(@p_sku,\""  + m.getParmId() + "\",\""+ m.getSpec() + "\",\""
				 + qa.getOrganization() + "\",\"" + qa.getOrgDivision() + "\"),";

			}
			listdata = listdata.substring(0, listdata.length() - 1);
			listGridData = listGridData.substring(0, listGridData.length() - 1);
			s = s + "@p_itemSubQuery='" + listdata + "',";
			s = s + "@p_gridSubQuery='" + listGridData + "',";
		} else {
			s = s + "@p_itemSubQuery='',";
			s = s + "@p_gridSubQuery='',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details>>>>>>>>>>>>>>>>>" + s);
		return s;
	}

}
