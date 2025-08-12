package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;

import nirmalya.aatithya.restmodule.qa.model.RestPcroCheckListModel;

public class GeneratePcroCheckList {
	
	public static String getAddpcro(List<RestPcroCheckListModel> qp) {
		String s = "";
		String sitem = "";
		
		if (qp.get(0).getPcroCheckListId() != null || qp.get(0).getPcroCheckListId() != "") {
			s = s + "@p_pcroCheckListId='" + qp.get(0).getPcroCheckListId() + "',";
		}
		
		if (qp.get(0).getPackingDate() != null || qp.get(0).getPackingDate() != "") {
			s = s + "@p_packingDate='" + qp.get(0).getPackingDate() + "',";
		}
		
		if (qp.get(0).getShift() != null || qp.get(0).getShift() != "") {
			s = s + "@p_shift='" + qp.get(0).getShift() + "',";
		}
		
		if (qp.get(0).getProduct() != null || qp.get(0).getProduct() != "") {
			s = s + "@p_product='" + qp.get(0).getProduct() + "',";
		}
		
		if (qp.get(0).getLineNo() != null || qp.get(0).getLineNo() != "") {
			s = s + "@p_lineno='" + qp.get(0).getLineNo() + "',";
		}
		
		if (qp.get(0).getBatchNo() != null || qp.get(0).getBatchNo() != "") {
			s = s + "@p_batchno='" + qp.get(0).getBatchNo() + "',";
		}
		
		if (qp.get(0).getSachet() != null || qp.get(0).getSachet() != "") {
			s = s + "@p_sachet='" + qp.get(0).getSachet() + "',";
		}
		
		if (qp.get(0).getBib_csp() != null || qp.get(0).getBib_csp() != "") {
			s = s + "@p_bib_csp='" + qp.get(0).getBib_csp() + "',";
		}
		
		if (qp.get(0).getNetWeight() != null || qp.get(0).getNetWeight() != "") {
			s = s + "@p_netWeight='" + qp.get(0).getNetWeight() + "',";
		}
		
		if (qp.get(0).getLsl() != null || qp.get(0).getLsl() != "") {
			s = s + "@p_lsl='" + qp.get(0).getLsl() + "',";
		}
		
		
		if (qp.get(0).getUsl() != null || qp.get(0).getUsl() != "") {
			s = s + "@p_usl='" + qp.get(0).getUsl() + "',";
		}
		
		if (qp.get(0).getRefNo() != null || qp.get(0).getRefNo() != "") {
			s = s + "@p_refNo='" + qp.get(0).getRefNo() + "',";
		}
		if (qp.get(0).getIssueDate() != null || qp.get(0).getIssueDate() != "") {
			s = s + "@p_issueDate='" + qp.get(0).getIssueDate() + "',";
		}
		if (qp.get(0).getIssueNo() != null || qp.get(0).getIssueNo() != "") {
			s = s + "@p_issueNo='" + qp.get(0).getIssueNo() + "',";
		}
		
		if (qp.get(0).getCreatedBy() != null || qp.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + qp.get(0).getCreatedBy() + "',";
		}
		
		if (qp.get(0).getOrganization() != null || qp.get(0).getOrganization() != "") {
			s = s + "@p_organization='" + qp.get(0).getOrganization() + "',";
		}
		
		if (qp.get(0).getOrgDivision() != null || qp.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + qp.get(0).getOrgDivision() + "',";
		}
		
		
		
		for (RestPcroCheckListModel m : qp) {

			sitem = sitem + "(@p_pcroCheckListId,\""+ m.getSlNo()+"\",\""  + m.getV1() + "\",\"" + m.getV2() +"\",\"" + m.getV3() +"\",\"" + m.getV4() +"\",\"" + m.getV5() +"\",\"" + m.getV6() +"\",\"" + m.getV7() +"\",\"" 
			+ m.getV8() + "\",\"" + m.getV9()+ "\",\"" +m.getV10() +  "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()+ "\"),";
		}
		
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";
		
		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		
		
		return s;
		
	}

}
