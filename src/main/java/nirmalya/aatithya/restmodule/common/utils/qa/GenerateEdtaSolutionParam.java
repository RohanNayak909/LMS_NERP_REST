package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;

import nirmalya.aatithya.restmodule.qa.model.RestEdtaSolutionModel;

public class GenerateEdtaSolutionParam {

	
	public static String addCalcium(List<RestEdtaSolutionModel> qp) {
		String s = "";
		String sitem = "";

		if (qp.get(0).getEdtacalciumId() != null || qp.get(0).getEdtacalciumId() != "") {
			s = s + "@p_edtaCalciumId='" + qp.get(0).getEdtacalciumId() + "',";
		}
		if (qp.get(0).getIssueDate() != null || qp.get(0).getIssueDate() != "") {
			s = s + "@p_dateIssue='" + qp.get(0).getIssueDate() + "',";
		}
		if (qp.get(0).getRevisionNumber() != null || qp.get(0).getRevisionNumber() != "") {
			s = s + "@p_revisionNumber='" + qp.get(0).getRevisionNumber() + "',";
		}
		if (qp.get(0).getApstatus() != null || qp.get(0).getApstatus() != "") {
			s = s + "@p_apStatus='" + qp.get(0).getApstatus() + "',";
		}
		
		if (qp.get(0).getApproveby() != null || qp.get(0).getApproveby() != "") {
			s = s + "@p_approveBy='" + qp.get(0).getApproveby() + "',";
		}

		if (qp.get(0).getCreatedBy() != null || qp.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + qp.get(0).getCreatedBy() + "',";
		}

		if (qp.get(0).getOrganization() != null || qp.get(0).getOrganization() != "") {
			s = s + "@p_org='" + qp.get(0).getOrganization() + "',";
		}
		if (qp.get(0).getOrgDivision() != null || qp.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + qp.get(0).getOrgDivision() + "',";
		}
		
		for (RestEdtaSolutionModel m : qp) {

			sitem = sitem + "(@p_edtaCalciumId,\""+ m.getDateOfIssue() +"\",\""+ m.getWtofcaco3g() +"\",\"" + m.getVolIntitration() +"\",\"" + m.getCalculation() 
			+"\",\"" + m.getAverage() +"\",\"" + m.getDateOfPreparation() 
			+"\",\"" + m.getDateOfph()+"\",\""+ m.getSignature()  
					+ "\",@p_createdBy,@p_org,@p_orgDiv,\""+m.getType()+"\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("----------------DATA---------------------"+s);

		return s;
	}
}
