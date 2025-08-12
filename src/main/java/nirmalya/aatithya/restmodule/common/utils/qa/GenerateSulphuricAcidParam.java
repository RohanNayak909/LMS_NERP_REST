package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;

import nirmalya.aatithya.restmodule.qa.model.AlcoholicNaohModel;
import nirmalya.aatithya.restmodule.qa.model.RestDichlorophenolIndophenolModel;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.SulphuricAcidModel;

public class GenerateSulphuricAcidParam {
	
	public static String addSulphuric(List<SulphuricAcidModel> qp) {
		String s = "";
		String sitem = "";

		if (qp.get(0).getSulphuricAcidId() != null || qp.get(0).getSulphuricAcidId() != "") {
			s = s + "@p_sulphuricAcidId='" + qp.get(0).getSulphuricAcidId() + "',";
		}

		if (qp.get(0).getIssueDate() != null || qp.get(0).getIssueDate() != "") {
			s = s + "@p_issueDate='" + qp.get(0).getIssueDate() + "',";
		}

		if (qp.get(0).getRevisedDate() != null || qp.get(0).getRevisedDate() != "") {
			s = s + "@p_revisedDate='" + qp.get(0).getRevisedDate() + "',";
		}
		if (qp.get(0).getRevisionDate() != null || qp.get(0).getRevisionDate() != "") {
			s = s + "@p_revisionDate='" + qp.get(0).getRevisionDate() + "',";
		}
		if (qp.get(0).getAnnecxure() != null || qp.get(0).getAnnecxure() != "") {
			s = s + "@p_annecxure='" + qp.get(0).getAnnecxure() + "',";
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
		
		for (SulphuricAcidModel m : qp) {

			sitem = sitem + "(@p_sulphuricAcidId,\"" + m.getSlNo()  + "\",\"" + m.getType()  + "\",\"" + m.getDateOfIssue() +"\",\"" + m.getNormalityOfNaoh() +"\",\"" + m.getVolNh2so4() +"\",\"" + m.getVolNnaoh() +"\",\"" + m.getCalculation() +"\",\""+ m.getAverage() +"\",\"" + m.getDateOfPreparation() +"\",\"" + m.getDateOfph()+"\",\""+ m.getSignature()  
					+ "\",@p_createdBy,@p_org,@p_orgDiv),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

	
	public static String addAlcoholicNaoh(List<AlcoholicNaohModel> an) {
		String s = "";
		String sitem = "";

		if (an.get(0).getAlcoholicNaohId() != null || an.get(0).getAlcoholicNaohId() != "") {
			s = s + "@p_alcoholicNaoh='" + an.get(0).getAlcoholicNaohId() + "',";
		}

		if (an.get(0).getIssueDate() != null || an.get(0).getIssueDate() != "") {
			s = s + "@p_issueDate='" + an.get(0).getIssueDate() + "',";
		}

		if (an.get(0).getRevisedDate() != null || an.get(0).getRevisedDate() != "") {
			s = s + "@p_revisedDate='" + an.get(0).getRevisedDate() + "',";
		}
		if (an.get(0).getRevisionDate() != null || an.get(0).getRevisionDate() != "") {
			s = s + "@p_revisionDate='" + an.get(0).getRevisionDate() + "',";
		}
		if (an.get(0).getAnnecxure() != null || an.get(0).getAnnecxure() != "") {
			s = s + "@p_annecxure='" + an.get(0).getAnnecxure() + "',";
		}

		if (an.get(0).getCreatedBy() != null || an.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + an.get(0).getCreatedBy() + "',";
		}

		if (an.get(0).getOrganization() != null || an.get(0).getOrganization() != "") {
			s = s + "@p_org='" + an.get(0).getOrganization() + "',";
		}
		if (an.get(0).getOrgDivision() != null || an.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + an.get(0).getOrgDivision() + "',";
		}
		
		for (AlcoholicNaohModel m : an) {

			sitem = sitem + "(@p_alcoholicNaoh,\"" + m.getSlNo()  + "\",\"" + m.getType()  + "\",\"" + m.getDateOfIssue() +"\",\"" + m.getWeightOfBa() +"\",\"" + m.getVolAlcoholicNnaoh() +"\",\"" + m.getCalculation() +"\",\""+ m.getAverage() +"\",\"" + m.getDateOfPreparation() +"\",\"" + m.getDateOfph()+"\",\""+ m.getSignature()  
					+ "\",@p_createdBy,@p_org,@p_orgDiv),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
	
	public static String addDcip(List<RestDichlorophenolIndophenolModel> di) {
		String s = "";
		String sitem = "";

		if (di.get(0).getDcpipId() != null || di.get(0).getDcpipId() != "") {
			s = s + "@p_dcpipId='" + di.get(0).getDcpipId() + "',";
		}

		if (di.get(0).getIssueDate() != null || di.get(0).getIssueDate() != "") {
			s = s + "@p_issueDate='" + di.get(0).getIssueDate() + "',";
		}

		if (di.get(0).getRevisedDate() != null || di.get(0).getRevisedDate() != "") {
			s = s + "@p_revisedDate='" + di.get(0).getRevisedDate() + "',";
		}
		if (di.get(0).getRevisionDate() != null || di.get(0).getRevisionDate() != "") {
			s = s + "@p_revisionDate='" + di.get(0).getRevisionDate() + "',";
		}
		if (di.get(0).getAnnecxure() != null || di.get(0).getAnnecxure() != "") {
			s = s + "@p_annecxure='" + di.get(0).getAnnecxure() + "',";
		}

		if (di.get(0).getCreatedBy() != null || di.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + di.get(0).getCreatedBy() + "',";
		}

		if (di.get(0).getOrganization() != null || di.get(0).getOrganization() != "") {
			s = s + "@p_org='" + di.get(0).getOrganization() + "',";
		}
		if (di.get(0).getOrgDivision() != null || di.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + di.get(0).getOrgDivision() + "',";
		}
		
		for (RestDichlorophenolIndophenolModel m : di) {

			sitem = sitem + "(@p_dcpipId,\"" + m.getSlNo()  + "\",\"" + m.getType()  + "\",\"" + m.getDateOfIssue() +"\",\"" + m.getWeightOfAscorbicAcid() +"\",\"" + m.getVolWorkingStandard() +"\",\"" + m.getDilutionD() +"\",\"" + m.getV1() +"\",\"" + m.getTv() +"\",\"" + m.getBlank() +"\",\"" + m.getDyeEquivalent() +"\",\""+ m.getAverage() +"\",\"" + m.getDateOfPreparation() +"\",\"" + m.getDateOfph()+"\",\""+ m.getSignature()  
					+ "\",@p_createdBy,@p_org,@p_orgDiv),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
}
