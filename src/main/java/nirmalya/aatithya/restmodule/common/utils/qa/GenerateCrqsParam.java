package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;

import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;


public class GenerateCrqsParam {
	public static String getAddcrqs(List<QaCrqsRestModel> qp) {
		String s = "";
		String sitem = "";

		if (qp.get(0).getCrqsId() != null || qp.get(0).getCrqsId() != "") {
			s = s + "@p_CrqsId='" + qp.get(0).getCrqsId() + "',";
		}

		if (qp.get(0).getPdate() != null || qp.get(0).getPdate() != "") {
			s = s + "@p_pdate='" + qp.get(0).getPdate() + "',";
		}

		if (qp.get(0).getShift() != null || qp.get(0).getShift() != "") {
			s = s + "@p_shift='" + qp.get(0).getShift() + "',";
		}
		if (qp.get(0).getMcno() != null || qp.get(0).getMcno() != "") {
			s = s + "@p_mcno='" + qp.get(0).getMcno() + "',";
		}
		if (qp.get(0).getCategory() != null || qp.get(0).getCategory() != "") {
			s = s + "@p_category='" + qp.get(0).getCategory() + "',";
		}
		if (qp.get(0).getProduct() != null || qp.get(0).getProduct() != "") {
			s = s + "@p_product='" + qp.get(0).getProduct() + "',";
		}
		if (qp.get(0).getNameofsi() != null || qp.get(0).getNameofsi() != "") {
			s = s + "@p_Nameofsi='" + qp.get(0).getNameofsi() + "',";
		}
		if (qp.get(0).getPacksize() != null || qp.get(0).getPacksize() != "") {
			s = s + "@p_packsize='" + qp.get(0).getPacksize() + "',";
		}
		if (qp.get(0).getVariant() != null || qp.get(0).getVariant() != "") {
			s = s + "@p_variant='" + qp.get(0).getVariant() + "',";
		}
		if (qp.get(0).getFactory() != null || qp.get(0).getFactory() != "") {
			s = s + "@p_Factory='" + qp.get(0).getFactory() + "',";
		}
		if (qp.get(0).getPacktech() != null || qp.get(0).getPacktech() != "") {
			s = s + "@p_Packtech='" + qp.get(0).getPacktech() + "',";
		}
		if (qp.get(0).getSealwidth() != null || qp.get(0).getSealwidth() != "") {
			s = s + "@p_sealwidth='" + qp.get(0).getSealwidth() + "',";
		}
		if (qp.get(0).getHorizontal() != null || qp.get(0).getHorizontal() != "") {
			s = s + "@p_horizontal='" + qp.get(0).getHorizontal() + "',";
		}
		if (qp.get(0).getVertical() != null || qp.get(0).getVertical() != "") {
			s = s + "@p_vertical='" + qp.get(0).getVertical() + "',";
		}
		if (qp.get(0).getGap() != null || qp.get(0).getGap() != "") {
			s = s + "@p_gap='" + qp.get(0).getGap() + "',";
		}
		if (qp.get(0).getMrp() != null || qp.get(0).getMrp() != "") {
			s = s + "@p_mrp='" + qp.get(0).getMrp() + "',";
		}
		if (qp.get(0).getRemark() != null || qp.get(0).getRemark() != "") {
			s = s + "@p_remark='" + qp.get(0).getRemark() + "',";
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
		if (qp.get(0).getTotalsamplechecked1() != null && qp.get(0).getTotalsamplechecked1() != "" && qp.get(0).getTotalsamplechecked1() != "null") {
			s = s + "@p_Totalsamplechecked1='" + qp.get(0).getTotalsamplechecked1() + "',";
		}
		if (qp.get(0).getTotalsamplechecked2() != null && qp.get(0).getTotalsamplechecked2() != "" && qp.get(0).getTotalsamplechecked2() != "null") {
			s = s + "@p_Totalsamplechecked2='" + qp.get(0).getTotalsamplechecked2() + "',";
		}
		if (qp.get(0).getTotalsamplechecked3() != null && qp.get(0).getTotalsamplechecked3() != "" && qp.get(0).getTotalsamplechecked3() != "null") {
			s = s + "@p_Totalsamplechecked3='" + qp.get(0).getTotalsamplechecked3() + "',";
		}
		if (qp.get(0).getTotalsamplechecked4() != null && qp.get(0).getTotalsamplechecked4() != "" && qp.get(0).getTotalsamplechecked4() != "null") {
			s = s + "@p_Totalsamplechecked4='" + qp.get(0).getTotalsamplechecked4() + "',";
		}
		if (qp.get(0).getQcstatus1() != null || qp.get(0).getQcstatus1() != "") {
			s = s + "@p_Qcstatus1='" + qp.get(0).getQcstatus1() + "',";
		}
		if (qp.get(0).getQcstatus2() != null || qp.get(0).getQcstatus2() != "") {
			s = s + "@p_Qcstatus2='" + qp.get(0).getQcstatus2() + "',";
		}
		if (qp.get(0).getQcstatus3() != null || qp.get(0).getQcstatus3() != "") {
			s = s + "@p_Qcstatus3='" + qp.get(0).getQcstatus3() + "',";
		}
		if (qp.get(0).getQcstatus4() != null || qp.get(0).getQcstatus4() != "") {
			s = s + "@p_Qcstatus4='" + qp.get(0).getQcstatus4() + "',";
		}
		if (qp.get(0).getNodefectobserved1() != null && qp.get(0).getNodefectobserved1() != "" && qp.get(0).getNodefectobserved1() != "null") {
			s = s + "@p_Nodefectobserved1='" + qp.get(0).getNodefectobserved1() + "',";
		}
		if (qp.get(0).getNodefectobserved2() != null && qp.get(0).getNodefectobserved2() != "" && qp.get(0).getNodefectobserved2() != "null") {
			s = s + "@p_Nodefectobserved2='" + qp.get(0).getNodefectobserved2() + "',";
		}
		if (qp.get(0).getNodefectobserved3() != null && qp.get(0).getNodefectobserved3() != "" && qp.get(0).getNodefectobserved3() != "null") {
			s = s + "@p_Nodefectobserved3='" + qp.get(0).getNodefectobserved3() + "',";
		}
		if (qp.get(0).getNodefectobserved4() != null && qp.get(0).getNodefectobserved4() != "" && qp.get(0).getNodefectobserved4() != "null") {
			s = s + "@p_Nodefectobserved4='" + qp.get(0).getNodefectobserved4() + "',";
		}
		if (qp.get(0).getNodefectobserved5() != null && qp.get(0).getNodefectobserved5() != "" && qp.get(0).getNodefectobserved5() != "null") {
			s = s + "@p_Nodefectobserved5='" + qp.get(0).getNodefectobserved5() + "',";
		}
		if (qp.get(0).getNodefectobserved6() != null && qp.get(0).getNodefectobserved6() != "" && qp.get(0).getNodefectobserved6() != "null") {
			s = s + "@p_Nodefectobserved6='" + qp.get(0).getNodefectobserved6() + "',";
		}
		if (qp.get(0).getNodefectobserved7() != null && qp.get(0).getNodefectobserved7() != "" && qp.get(0).getNodefectobserved7() != "null") {
			s = s + "@p_Nodefectobserved7='" + qp.get(0).getNodefectobserved7() + "',";
		}
		if (qp.get(0).getNodefectobserved8() != null && qp.get(0).getNodefectobserved8() != "" && qp.get(0).getNodefectobserved8() != "null") {
			s = s + "@p_Nodefectobserved8='" + qp.get(0).getNodefectobserved8() + "',";
		}
		if (qp.get(0).getNodefectobserved9() != null && qp.get(0).getNodefectobserved9() != "" && qp.get(0).getNodefectobserved9() != "null") {
			s = s + "@p_Nodefectobserved9='" + qp.get(0).getNodefectobserved9() + "',";
		}
		if (qp.get(0).getNodefectobserved10() != null && qp.get(0).getNodefectobserved10() != "" && qp.get(0).getNodefectobserved10() != "null") {
			s = s + "@p_Nodefectobserved10='" + qp.get(0).getNodefectobserved10() + "',";
		}
		if (qp.get(0).getNodefectobserved11() != null && qp.get(0).getNodefectobserved11() != "" && qp.get(0).getNodefectobserved11() != "null") {
			s = s + "@p_Nodefectobserved11='" + qp.get(0).getNodefectobserved11() + "',";
		}
		if (qp.get(0).getNodefectobserved12() != null && qp.get(0).getNodefectobserved12() != "" && qp.get(0).getNodefectobserved12() != "null") {
			s = s + "@p_Nodefectobserved12='" + qp.get(0).getNodefectobserved12() + "',";
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
		if (qp.get(0).getDefectpercent11() != null || qp.get(0).getDefectpercent11() != "") {
			s = s + "@p_Defectpercent11='" + qp.get(0).getDefectpercent11() + "',";
		}
		if (qp.get(0).getDefectpercent12() != null || qp.get(0).getDefectpercent12() != "") {
			s = s + "@p_Defectpercent12='" + qp.get(0).getDefectpercent12() + "',";
		}
		if (qp.get(0).getSack() != null || qp.get(0).getSack() != "") {
			s = s + "@p_sack='" + qp.get(0).getSack() + "',";
		}
		if (qp.get(0).getPouch() != null || qp.get(0).getPouch() != "") {
			s = s + "@p_pouch='" + qp.get(0).getPouch() + "',";
		}
		if (qp.get(0).getMc() != null || qp.get(0).getMc() != "") {
			s = s + "@p_mc='" + qp.get(0).getMc() + "',";
		}

		for (QaCrqsRestModel m : qp) {

			sitem = sitem + "(@p_CrqsId,\"" + m.getS0()+ "\",\"" + m.getDefecttype()  + "\",\"" + m.getProperty() +"\",\"" + m.getQaissues() +"\",\"" + m.getRed1() +"\",\"" + m.getAmber1() +"\",\"" + m.getGreen1() +"\",\""+ m.getRed2() +"\",\"" + m.getAmber2() +"\",\"" + m.getGreen2()+"\",\""+ m.getRed3() +"\",\"" + m.getAmber3() +"\",\"" + m.getGreen3()+"\",\""+ m.getRed4() +"\",\"" + m.getAmber4() +"\",\"" + m.getGreen4() 
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
	public static String getAddcrqsInspect(List<QaCrqsRestModel> qp) {
		String s = "";
		String sitem = "";

		if (qp.get(0).getCrqsId() != null || qp.get(0).getCrqsId() != "") {
			s = s + "@p_CrqsId='" + qp.get(0).getCrqsId() + "',";
		}

		for (QaCrqsRestModel m : qp) {

			sitem = sitem + "(@p_CrqsId,\"" + m.getDefect()+ "\",\"" + m.getDesc()+ "\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);
		System.out.println("###########"+sitem);
		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
