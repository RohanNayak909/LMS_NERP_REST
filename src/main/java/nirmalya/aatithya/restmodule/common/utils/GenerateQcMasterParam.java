package nirmalya.aatithya.restmodule.common.utils;

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

			sitem = sitem + "(@p_qcId,\"" + m.getParameterId() + "\",\"" + m.getMinRange() + "\",\"" + m.getMaxRange()
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
