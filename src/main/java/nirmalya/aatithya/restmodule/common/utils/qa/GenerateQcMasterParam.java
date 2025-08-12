package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;

import nirmalya.aatithya.restmodule.qa.model.QcMasterRestModel;

public class GenerateQcMasterParam {
	public static String getAddqc(List<QcMasterRestModel> qc) {
		String s = "";
		String sitem = "";

		if (qc.get(0).getQcId() != null || qc.get(0).getQcId() != "") {
			s = s + "@p_qcId='" + qc.get(0).getQcId() + "',";
		}

		if (qc.get(0).getItemid() != null || qc.get(0).getItemid() != "") {
			s = s + "@p_itemid='" + qc.get(0).getItemid() + "',";
		}

		if (qc.get(0).getDescription() != null || qc.get(0).getDescription() != "") {
			s = s + "@p_description='" + qc.get(0).getDescription() + "',";
		}

		if (qc.get(0).getCreatedBy() != null || qc.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + qc.get(0).getCreatedBy() + "',";
		}

		if (qc.get(0).getOrganization() != null || qc.get(0).getOrganization() != "") {
			s = s + "@p_org='" + qc.get(0).getOrganization() + "',";
		}
		if (qc.get(0).getOrgDivision() != null || qc.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + qc.get(0).getOrgDivision() + "',";
		}

		for (QcMasterRestModel m : qc) {
//String a="(((parseFloat($(#sample_wt).val()))-(parseFloat($('#agno3_factor').val())))+100)";
			sitem = sitem + "(@p_qcId,\"" + m.getSlno() + "\",\"" + m.getParameterId() + "\",\"" + m.getMinRange() + "\",\"" + m.getMaxRange() + "\",\"" + m.getRefKey() + "\",\"" + m.getFormula() + "\",\"" + m.getFormulaJs()
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
	
	
	public static String getAddNewParameter(List<QcMasterRestModel> qc) {
		
		String s1 = "";
		
		
		if (qc.get(0).getNewParameterName() != null || qc.get(0).getNewParameterName() != "") {
			s1 = s1 + "@p_newPName='" + qc.get(0).getNewParameterName() + "',";
		}

		if (qc.get(0).getParameterDesc() != null || qc.get(0).getParameterDesc() != "") {
			s1 = s1 + "@p_newPDesc='" + qc.get(0).getParameterDesc() + "',";
		}

		if (qc.get(0).getCreatedBy() != null || qc.get(0).getCreatedBy() != "") {
			s1 = s1 + "@p_createdBy='" + qc.get(0).getCreatedBy() + "',";
		}

		if (qc.get(0).getOrganization() != null || qc.get(0).getOrganization() != "") {
			s1 = s1 + "@p_org='" + qc.get(0).getOrganization() + "',";
		}
		if (qc.get(0).getOrgDivision() != null || qc.get(0).getOrgDivision() != "") {
			s1 = s1 + "@p_orgDiv='" + qc.get(0).getOrgDivision() + "',";
		}
		
		if (s1 != "") {
			s1 = s1.substring(0, s1.length() - 1);

			s1 = "SET " + s1 + ";";
		}

		System.out.println(s1);
		
		return s1;
		
	}
	
	/*
	 * public static String getAddNewFormula(List<QcMasterRestModel> qc) {
	 * 
	 * String s2 = "";
	 * 
	 * 
	 * if (qc.get(0).getQcId() != null || qc.get(0).getQcId() != "") { s2 = s2 +
	 * "@p_qcId='" + qc.get(0).getQcId() + "',"; }
	 * 
	 * if (qc.get(0).getPrmId() != null || qc.get(0).getPrmId() != "") { s2 = s2 +
	 * "@p_prmId='" + qc.get(0).getPrmId() + "',"; }
	 * 
	 * if (qc.get(0).getFldName() != null || qc.get(0).getFldName() != "") { s2 = s2
	 * + "@p_refKey='" + qc.get(0).getFldName() + "',"; }
	 * 
	 * if (qc.get(0).getFrmValue() != null || qc.get(0).getFrmValue() != "") { s2 =
	 * s2 + "@p_formula_js='" + qc.get(0).getFrmValue() + "',"; }
	 * 
	 * 
	 * if (qc.get(0).getFrmDesc() != null || qc.get(0).getFrmDesc() != "") { s2 = s2
	 * + "@p_formula='" + qc.get(0).getFrmDesc() + "',"; }
	 * 
	 * if (qc.get(0).getOrganization() != null || qc.get(0).getOrganization() != "")
	 * { s2 = s2 + "@p_org='" + qc.get(0).getOrganization() + "',"; } if
	 * (qc.get(0).getOrgDivision() != null || qc.get(0).getOrgDivision() != "") { s2
	 * = s2 + "@p_orgDiv='" + qc.get(0).getOrgDivision() + "',"; }
	 * 
	 * if (s2 != "") { s2 = s2.substring(0, s2.length() - 1);
	 * 
	 * s2 = "SET " + s2 + ";"; }
	 * 
	 * System.out.println(s2);
	 * 
	 * return s2;
	 * 
	 * }
	 */

}
