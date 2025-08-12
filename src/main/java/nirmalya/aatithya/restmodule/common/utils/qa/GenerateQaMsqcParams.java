package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;

import nirmalya.aatithya.restmodule.qa.model.QaCrqsCheckRestModel;


public class GenerateQaMsqcParams {
	public static String getAddCrqsCheck(List<QaCrqsCheckRestModel> qp) {
		String s = "";
		String sitem = "";

		if (qp.get(0).getCrqscheckId() != null || qp.get(0).getCrqscheckId() != "") {
			s = s + "@p_MSQCId='" + qp.get(0).getCrqscheckId() + "',";
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
		if (qp.get(0).getTotalsamplechecked1() != null || qp.get(0).getTotalsamplechecked1() != "") {
			s = s + "@p_Totalsamplechecked1='" + qp.get(0).getTotalsamplechecked1() + "',";
		}
		if (qp.get(0).getTotalsamplechecked2() != null || qp.get(0).getTotalsamplechecked2() != "") {
			s = s + "@p_Totalsamplechecked2='" + qp.get(0).getTotalsamplechecked2() + "',";
		}
		if (qp.get(0).getTotalsamplechecked3() != null || qp.get(0).getTotalsamplechecked3() != "") {
			s = s + "@p_Totalsamplechecked3='" + qp.get(0).getTotalsamplechecked3() + "',";
		}
		if (qp.get(0).getTotalsamplechecked4() != null || qp.get(0).getTotalsamplechecked4() != "") {
			s = s + "@p_Totalsamplechecked4='" + qp.get(0).getTotalsamplechecked4() + "',";
		}
		if (qp.get(0).getTotalsamplechecked5() != null || qp.get(0).getTotalsamplechecked5() != "") {
			s = s + "@p_Totalsamplechecked5='" + qp.get(0).getTotalsamplechecked5() + "',";
		}
		if (qp.get(0).getQcstatus1() != null || qp.get(0).getQcstatus1() != "") {
			s = s + "@p_Qcstatus1='" + qp.get(0).getQcstatus1() + "',";
		}
		if (qp.get(0).getQcstatus2() != null || qp.get(0).getQcstatus2() != "") {
			s = s + "@p_Qcstatus2='" + qp.get(0).getQcstatus2() + "',";
		}
		if (qp.get(0).getNodefectobserved1() != null || qp.get(0).getNodefectobserved1() != "") {
			s = s + "@p_Nodefectobserved1='" + qp.get(0).getNodefectobserved1() + "',";
		}
		if (qp.get(0).getNodefectobserved2() != null || qp.get(0).getNodefectobserved2() != "") {
			s = s + "@p_Nodefectobserved2='" + qp.get(0).getNodefectobserved2() + "',";
		}
		if (qp.get(0).getNodefectobserved3() != null || qp.get(0).getNodefectobserved3() != "") {
			s = s + "@p_Nodefectobserved3='" + qp.get(0).getNodefectobserved3() + "',";
		}
		if (qp.get(0).getNodefectobserved4() != null || qp.get(0).getNodefectobserved4() != "") {
			s = s + "@p_Nodefectobserved4='" + qp.get(0).getNodefectobserved4() + "',";
		}
		if (qp.get(0).getNodefectobserved5() != null || qp.get(0).getNodefectobserved5() != "") {
			s = s + "@p_Nodefectobserved5='" + qp.get(0).getNodefectobserved5() + "',";
		}
		if (qp.get(0).getNodefectobserved6() != null || qp.get(0).getNodefectobserved6() != "") {
			s = s + "@p_Nodefectobserved6='" + qp.get(0).getNodefectobserved6() + "',";
		}
		if (qp.get(0).getNodefectobserved7() != null || qp.get(0).getNodefectobserved7() != "") {
			s = s + "@p_Nodefectobserved7='" + qp.get(0).getNodefectobserved7() + "',";
		}
		if (qp.get(0).getNodefectobserved8() != null || qp.get(0).getNodefectobserved8() != "") {
			s = s + "@p_Nodefectobserved8='" + qp.get(0).getNodefectobserved8() + "',";
		}
		if (qp.get(0).getNodefectobserved9() != null || qp.get(0).getNodefectobserved9() != "") {
			s = s + "@p_Nodefectobserved9='" + qp.get(0).getNodefectobserved9() + "',";
		}
		if (qp.get(0).getNodefectobserved10() != null || qp.get(0).getNodefectobserved10() != "") {
			s = s + "@p_Nodefectobserved10='" + qp.get(0).getNodefectobserved10() + "',";
		}
		if (qp.get(0).getDefectpercent1() != null || qp.get(0).getDefectpercent1() != "") {
			s = s + "@p_Defectpercent1='" + qp.get(0).getDefectpercent1() + "',";
		}
		if (qp.get(0).getDefectpercent2() != null || qp.get(0).getDefectpercent2() != "") {
			s = s + "@p_Defectpercent2='" + qp.get(0).getDefectpercent2() + "',";
		}
		if (qp.get(0).getDefectpercent3() != null || qp.get(0).getDefectpercent3() != "") {
			s = s + "@p_Defectpercent3='" + qp.get(0).getDefectpercent3() + "',";
		}
		if (qp.get(0).getDefectpercent4() != null || qp.get(0).getDefectpercent4() != "") {
			s = s + "@p_Defectpercent4='" + qp.get(0).getDefectpercent4() + "',";
		}
		if (qp.get(0).getDefectpercent5() != null || qp.get(0).getDefectpercent5() != "") {
			s = s + "@p_Defectpercent5='" + qp.get(0).getDefectpercent5() + "',";
		}
		if (qp.get(0).getDefectpercent6() != null || qp.get(0).getDefectpercent6() != "") {
			s = s + "@p_Defectpercent6='" + qp.get(0).getDefectpercent6() + "',";
		}
		if (qp.get(0).getDefectpercent7() != null || qp.get(0).getDefectpercent7() != "") {
			s = s + "@p_Defectpercent7='" + qp.get(0).getDefectpercent7() + "',";
		}
		if (qp.get(0).getDefectpercent8() != null || qp.get(0).getDefectpercent8() != "") {
			s = s + "@p_Defectpercent8='" + qp.get(0).getDefectpercent8() + "',";
		}
		if (qp.get(0).getDefectpercent9() != null || qp.get(0).getDefectpercent9() != "") {
			s = s + "@p_Defectpercent9='" + qp.get(0).getDefectpercent9() + "',";
		}
		if (qp.get(0).getDefectpercent10() != null || qp.get(0).getDefectpercent10() != "") {
			s = s + "@p_Defectpercent10='" + qp.get(0).getDefectpercent10() + "',";
		}
		if (qp.get(0).getTotaldefectvlta() != null || qp.get(0).getTotaldefectvlta() != "") {
			s = s + "@p_Totaldefectvlta='" + qp.get(0).getTotaldefectvlta() + "',";
		}
		if (qp.get(0).getTotalquantityvltb() != null || qp.get(0).getTotalquantityvltb() != "") {
			s = s + "@p_Totalquantityvltb='" + qp.get(0).getTotalquantityvltb() + "',";
		}
		if (qp.get(0).getRft() != null || qp.get(0).getRft() != "") {
			s = s + "@p_Rft='" + qp.get(0).getRft() + "',";
		}
		

		for (QaCrqsCheckRestModel m : qp) {

			sitem = sitem + "(@p_MSQCId,\"" + m.getType()+ "\",\"" + m.getSlno()+ "\",\"" + m.getFormtype()  + "\",\"" + m.getProperty() +"\",\"" + m.getRed1() +"\",\"" + m.getAmber1() +"\",\""+ m.getRed2() +"\",\"" + m.getAmber2() +"\",\"" + m.getRed3() +"\",\"" + m.getAmber3() +"\",\""+ m.getRed4() +"\",\"" + m.getAmber4() +"\",\""+ m.getRed5() +"\",\"" + m.getAmber5()  
					+ "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
					+ "\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("XXXXXXXXXXXXXYYYYYYYYYYYYYYYYYYZZZZZZZZZZZZS"+s);

		return s;
	}


}
