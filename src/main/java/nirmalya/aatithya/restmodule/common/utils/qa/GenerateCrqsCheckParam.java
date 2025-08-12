package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;

import nirmalya.aatithya.restmodule.qa.model.QaCrqsCheckRestModel;


public class GenerateCrqsCheckParam {
	public static String getAddCrqsCheck(List<QaCrqsCheckRestModel> qp) {
		String s = "";
		String sitem = "";

		if (qp.get(0).getCrqscheckId() != null || qp.get(0).getCrqscheckId() != "") {
			s = s + "@p_CrqsCheckId='" + qp.get(0).getCrqscheckId() + "',";
		}

		if (qp.get(0).getFormtype() != null || qp.get(0).getFormtype() != "") {
			s = s + "@p_formtype='" + qp.get(0).getFormtype() + "',";
		}

		if (qp.get(0).getRefno() != null || qp.get(0).getRefno() != "") {
			s = s + "@p_refno='" + qp.get(0).getRefno() + "',";
		}
		if (qp.get(0).getIssueno() != null || qp.get(0).getIssueno() != "") {
			s = s + "@p_issueno='" + qp.get(0).getIssueno() + "',";
		}
		if (qp.get(0).getIssuedate() != null || qp.get(0).getIssuedate() != "") {
			s = s + "@p_issuedate='" + qp.get(0).getIssuedate() + "',";
		}
		if (qp.get(0).getDop() != null || qp.get(0).getDop() != "") {
			s = s + "@p_dop='" + qp.get(0).getDop() + "',";
		}
		if (qp.get(0).getSku() != null || qp.get(0).getSku() != "") {
			s = s + "@p_sku='" + qp.get(0).getSku() + "',";
		}
		if (qp.get(0).getLineno() != null || qp.get(0).getLineno() != "") {
			s = s + "@p_lineno='" + qp.get(0).getLineno() + "',";
		}
		if (qp.get(0).getBatchno() != null || qp.get(0).getBatchno() != "") {
			s = s + "@p_batchno='" + qp.get(0).getBatchno() + "',";
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

		

		for (QaCrqsCheckRestModel m : qp) {

			sitem = sitem + "(@p_CrqsId,\"" + m.getType()+ "\",\"" + m.getSlno()+ "\",\"" + m.getFormtype()  + "\",\"" + m.getProperty() +"\",\"" + m.getRed1() +"\",\"" + m.getAmber1() +"\",\""+ m.getRed2() +"\",\"" + m.getAmber2() +"\",\"" + m.getRed3() +"\",\"" + m.getAmber3() +"\",\""+ m.getRed4() +"\",\"" + m.getAmber4() +"\",\""+ m.getRed5() +"\",\"" + m.getAmber5()  
					+ "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
					+ "\"),";
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
