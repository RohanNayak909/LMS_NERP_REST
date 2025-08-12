package nirmalya.aatithya.restmodule.common.utils.grc;

import java.util.List;

import nirmalya.aatithya.restmodule.grc.model.dcaMonitoringRestModel;

public class GenerateDcaMonitorReportParam {

	
	public static String getAddDcaActivity(List<dcaMonitoringRestModel> av) {
	    String s = "";
	    String sitem1 = "";

	    if (av.get(0).getMonitorId() != null && !av.get(0).getMonitorId().isEmpty()) {
	        s = s + "@p_MonitorId='" + av.get(0).getMonitorId() + "',";
	    }
	    if (av.get(0).getMonth() != null && !av.get(0).getMonth().isEmpty()) {
	        s = s + "@p_month='" + av.get(0).getMonth() + "',";
	    }
	    
	    if (av.get(0).getInputDate() != null && !av.get(0).getInputDate().isEmpty()) {
	        s = s + "@p_inputDate='" + av.get(0).getInputDate() + "',";
	    }
	    if (av.get(0).getDate() != null && !av.get(0).getDate().isEmpty()) {
	        s = s + "@p_date='" + av.get(0).getDate() + "',";
	    }
	    if (av.get(0).getRemarks() != null && !av.get(0).getRemarks().isEmpty()) {
	        s = s + "@p_remarks='" + av.get(0).getRemarks() + "',";
	    }

	    if (av.get(0).getCreatedBy() != null && !av.get(0).getCreatedBy().isEmpty()) {
	        s = s + "@p_createdBy='" + av.get(0).getCreatedBy() + "',";
	    }
	    if (av.get(0).getOrganization() != null && !av.get(0).getOrganization().isEmpty()) {
	        s = s + "@p_org='" + av.get(0).getOrganization() + "',";
	    }
	    if (av.get(0).getOrgDivision() != null && !av.get(0).getOrgDivision().isEmpty()) {
	        s = s + "@p_orgDiv='" + av.get(0).getOrgDivision() + "',";
	    }

	    
	    for (dcaMonitoringRestModel m : av.get(0).getGrid1List()) {
	        sitem1 = sitem1 + "(@p_MonitorId, \"" + m.getEmpId() + "\", \"" + m.getDesignation() + "\", \"" 
	                 + m.getMonth1() + "\", \"" + m.getMonth2() + "\", \"" + m.getMonth3() + "\", \"" 
	                 + m.getMonth4() + "\", \"" + m.getMonth5() + "\", \"" + m.getMonth6() + "\", \"" 
	                 + m.getMonth7() + "\", \"" + m.getMonth8() + "\", \"" + m.getMonth9() + "\", \"" 
	                 + m.getMonth10() + "\", \"" + m.getMonth11() + "\", \"" + m.getMonth12() + "\", \"" 
	                 + m.getTotaldeepcompliance() + "\", \"" + m.getDeepcompliance() + "\", \"" + m.getCompliancestatus() + "\", "
	                 + "@p_org, @p_orgDiv),";
	    }


	    if (!sitem1.isEmpty()) {
	        sitem1 = sitem1.substring(0, sitem1.length() - 1); 
	    }

	    s = s + "@p_itemSubQuery1='" + sitem1 + "',";

	    
	 
	    if (!s.isEmpty()) {
	        s = s.substring(0, s.length() - 1); // Remove last comma from the final query
	        s = "SET " + s + ";";
	        System.out.println("-----------------" + s);
	    }

	    return s;
	}
}
