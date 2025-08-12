package nirmalya.aatithya.restmodule.common.utils.qa;
import java.util.List;

import nirmalya.aatithya.restmodule.qa.model.SodiumHydroxideRestModel;
public class GenerateSodiumParam {

	public static String addSodium(List<SodiumHydroxideRestModel> qp) {
		String s = "";
		String sitem = "";

		if (qp.get(0).getSodiumId() != null || qp.get(0).getSodiumId() != "") {
			s = s + "@p_sodiumId='" + qp.get(0).getSodiumId() + "',";
		}
		if (qp.get(0).getIssueDate() != null || qp.get(0).getIssueDate() != "") {
			s = s + "@p_dateIssue='" + qp.get(0).getIssueDate() + "',";
		}
		if (qp.get(0).getRevisionNumber() != null || qp.get(0).getRevisionNumber() != "") {
			s = s + "@p_revisionNumber='" + qp.get(0).getRevisionNumber() + "',";
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
		
		for (SodiumHydroxideRestModel m : qp) {

			sitem = sitem + "(@p_sodiumId,\""+ m.getDateOfIssue() +"\",\""+ m.getWtofkhp() +"\",\"" + m.getVolsodium() +"\",\"" + m.getCalculation() 
			+"\",\"" + m.getAverage() +"\",\"" + m.getDateOfPreparation() 
			+"\",\"" + m.getDateOfph()+"\",\""+ m.getSignature() + "\",@p_createdBy,@p_org,@p_orgDiv,\"" + m.getType() + "\",\"" + m.getP() + "\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("-------------------------------------"+s);

		return s;
	}
}
