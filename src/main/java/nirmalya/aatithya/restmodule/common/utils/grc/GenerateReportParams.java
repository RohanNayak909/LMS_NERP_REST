package nirmalya.aatithya.restmodule.common.utils.grc;

import java.util.List;

import nirmalya.aatithya.restmodule.grc.model.GRCReportRestModel;
import nirmalya.aatithya.restmodule.maintenance.model.AllotedMaintenanceRestModel;


public class GenerateReportParams {
	@SuppressWarnings("unused")
	public static String getMonthlyEmpList(List<GRCReportRestModel> av) {
		String s = "";
		String sitem = "";

		if (av.get(0).getReportId() != null || av.get(0).getReportId() != "") {
			s = s + "@p_reportid='" + av.get(0).getReportId() + "',";
		}
		if (av.get(0).getYear() != null || av.get(0).getYear() != "") {
			s = s + "@p_year='" + av.get(0).getYear() + "',";
		}
		if (av.get(0).getMonth() != null || av.get(0).getMonth() != "") {
			s = s + "@p_month='" + av.get(0).getMonth() + "',";
		}
		if (av.get(0).getSbo() != null || av.get(0).getSbo() != "") {
			s = s + "@p_sbo='" + av.get(0).getSbo() + "',";
		}
		if (av.get(0).getHi() != null || av.get(0).getHi() != "") {
			s = s + "@p_hi='" + av.get(0).getHi() + "',";
		}
		if (av.get(0).getEmpId() != null || av.get(0).getEmpId() != "") {
			s = s + "@p_createdBy='" + av.get(0).getEmpId() + "',";
		}
		if (av.get(0).getCreatedBy() != null || av.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + av.get(0).getCreatedBy() + "',";
		}
		if (av.get(0).getOrganization() != null || av.get(0).getOrganization() != "") {
			s = s + "@p_org='" + av.get(0).getOrganization() + "',";
		}
		if (av.get(0).getOrgDivision() != null || av.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + av.get(0).getOrgDivision() + "',";
		}

		for (GRCReportRestModel m : av) {

			sitem = sitem + "(@p_reportid,@p_financialYr,\"" + m.getYear() + "\",\"" + m.getMonth() + "\",\"" + m.getSbo() 
			+ "\",\"" + m.getHi()+ "\",\"" + m.getEmpId() + "\",\"" + m.getCreatedBy()  + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()+"\"),";
			
		}
		sitem = sitem.substring(0, sitem.length() - 1);
		
		

		s = s + "@p_itemSubQuery='" + sitem+ "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("GENERATE PARAM"+s);
		return s;
	}

	@SuppressWarnings("unused")
	public static String getMasterChecklistParam(List<GRCReportRestModel> av) {
		String s = "";
		String sitem = "";

		if (av.get(0).getReportId() != null || av.get(0).getReportId() != "") {
			s = s + "@p_reportid='" + av.get(0).getReportId() + "',";
		}
		if (av.get(0).getYear() != null || av.get(0).getYear() != "") {
			s = s + "@p_year='" + av.get(0).getYear() + "',";
		}
		if (av.get(0).getMonth() != null || av.get(0).getMonth() != "") {
			s = s + "@p_month='" + av.get(0).getMonth() + "',";
		}
		if (av.get(0).getEmpId() != null || av.get(0).getEmpId() != "") {
			s = s + "@p_createdBy='" + av.get(0).getEmpId() + "',";
		}
		if (av.get(0).getCreatedBy() != null || av.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + av.get(0).getCreatedBy() + "',";
		}
		if (av.get(0).getOrganization() != null || av.get(0).getOrganization() != "") {
			s = s + "@p_org='" + av.get(0).getOrganization() + "',";
		}
		if (av.get(0).getOrgDivision() != null || av.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + av.get(0).getOrgDivision() + "',";
		}

		for (GRCReportRestModel m : av) {

			sitem = sitem + "(@p_reportid,\"" + m.getYear() + "\",\"" + m.getMonth() + "\"," + m.getSl_no() 
			+ ",\"" + m.getItems()+ "\",\"" + m.getFrequency()+ "\",\"" + m.getValid()+ "\",\"" + m.getStatus()+ "\",\"" + m.getCreatedBy()  + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()+"\"),";
			
		}
		sitem = sitem.substring(0, sitem.length() - 1);
		
		

		s = s + "@p_itemSubQuery='" + sitem+ "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("GENERATE PARAM"+s);
		return s;
	}

}
