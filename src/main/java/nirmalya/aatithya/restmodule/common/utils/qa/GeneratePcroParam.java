package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;

import nirmalya.aatithya.restmodule.qa.model.QaPcroRestModel;


public class GeneratePcroParam {
	public static String getAddpcro(List<QaPcroRestModel> qp) {
		String s = "";
		String sitem = "";

		if (qp.get(0).getPcroId() != null || qp.get(0).getPcroId() != "") {
			s = s + "@p_pcroId='" + qp.get(0).getPcroId() + "',";
		}

		if (qp.get(0).getPdate() != null || qp.get(0).getPdate() != "") {
			s = s + "@p_pdate='" + qp.get(0).getPdate() + "',";
		}

		if (qp.get(0).getShift() != null || qp.get(0).getShift() != "") {
			s = s + "@p_shift='" + qp.get(0).getShift() + "',";
		}
		if (qp.get(0).getMcname() != null || qp.get(0).getMcname() != "") {
			s = s + "@p_mcname='" + qp.get(0).getMcname() + "',";
		}
		if (qp.get(0).getMcno() != null || qp.get(0).getMcno() != "") {
			s = s + "@p_mcno='" + qp.get(0).getMcno() + "',";
		}
		if (qp.get(0).getShiftincharge() != null || qp.get(0).getShiftincharge() != "") {
			s = s + "@p_shiftincharge='" + qp.get(0).getShiftincharge() + "',";
		}
		if (qp.get(0).getProduct() != null || qp.get(0).getProduct() != "") {
			s = s + "@p_product='" + qp.get(0).getProduct() + "',";
		}
		if (qp.get(0).getFormulation() != null || qp.get(0).getFormulation() != "") {
			s = s + "@p_formulation='" + qp.get(0).getFormulation() + "',";
		}
		if (qp.get(0).getPacksize() != null || qp.get(0).getPacksize() != "") {
			s = s + "@p_packsize='" + qp.get(0).getPacksize() + "',";
		}
		if (qp.get(0).getMrp() != null || qp.get(0).getMrp() != "") {
			s = s + "@p_mrp='" + qp.get(0).getMrp() + "',";
		}
		if (qp.get(0).getVariant() != null || qp.get(0).getVariant() != "") {
			s = s + "@p_variant='" + qp.get(0).getVariant() + "',";
		}
		if (qp.get(0).getPcrocompliance() != null || qp.get(0).getPcrocompliance() != "") {
			s = s + "@p_Pcrocompliance='" + qp.get(0).getPcrocompliance() + "',";
		}
		if (qp.get(0).getBagstickerpresent() != null || qp.get(0).getBagstickerpresent() != "") {
			s = s + "@p_Bagstickerpresent='" + qp.get(0).getBagstickerpresent() + "',";
		}
		if (qp.get(0).getBagcondition() != null || qp.get(0).getBagcondition() != "") {
			s = s + "@p_Bagcondition='" + qp.get(0).getBagcondition() + "',";
		}
		if (qp.get(0).getBagsealing() != null || qp.get(0).getBagsealing() != "") {
			s = s + "@p_Bagsealing='" + qp.get(0).getBagsealing() + "',";
		}
		if (qp.get(0).getCorrfactor() != null || qp.get(0).getCorrfactor() != "") {
			s = s + "@p_Corrfactor='" + qp.get(0).getCorrfactor() + "',";
		}
		if (qp.get(0).getAvg5pouch() != null || qp.get(0).getAvg5pouch() != "") {
			s = s + "@p_Avg5pouch='" + qp.get(0).getAvg5pouch() + "',";
		}
		if (qp.get(0).getMpe() != null || qp.get(0).getMpe() != "") {
			s = s + "@p_Mpe='" + qp.get(0).getMpe() + "',";
		}
		if (qp.get(0).getWeight() != null || qp.get(0).getWeight() != "") {
			s = s + "@p_Weight='" + qp.get(0).getWeight() + "',";
		}
		if (qp.get(0).getAllowlimit() != null || qp.get(0).getAllowlimit() != "") {
			s = s + "@p_Allowlimit='" + qp.get(0).getAllowlimit() + "',";
		}
		if (qp.get(0).getMinwt() != null || qp.get(0).getMinwt() != "") {
			s = s + "@p_Minwt='" + qp.get(0).getMinwt() + "',";
		}
		if (qp.get(0).getMaxwt() != null || qp.get(0).getMaxwt() != "") {
			s = s + "@p_Maxwt='" + qp.get(0).getMaxwt() + "',";
		}
		if (qp.get(0).getAvgwt() != null || qp.get(0).getAvgwt() != "") {
			s = s + "@p_Avgwt='" + qp.get(0).getAvgwt() + "',";
		}
		if (qp.get(0).getCavgwt() != null || qp.get(0).getCavgwt() != "") {
			s = s + "@p_Cavgwt='" + qp.get(0).getCavgwt() + "',";
		}
		if (qp.get(0).getSd() != null || qp.get(0).getSd() != "") {
			s = s + "@p_Sd='" + qp.get(0).getSd() + "',";
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

		for (QaPcroRestModel m : qp) {

			sitem = sitem + "(@p_pcroId,\"" + m.getS0() + "\",\"" + m.getS1() +"\",\"" + m.getS2() +"\",\"" + m.getS3() +"\",\"" + m.getS4() +"\",\"" + m.getS5() +"\",\"" + m.getS6() +"\",\"" + m.getS7() + "\",\"" + m.getS8()
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
