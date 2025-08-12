package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.RestPayrollApprovalModel;

public class GeneratePayrollApproveParam {
	public static String getPayrollApproveParam(List<RestPayrollApprovalModel> data) {
 
		String s = ""; 
		String datalist = ""; 
 
		if (data.get(0).getFromDate() != null || data.get(0).getFromDate()!= "") {
			s = s + "@p_fromdate='" + DateFormatter.getStringDate(data.get(0).getFromDate()) + "',";
		}
		if (data.get(data.size()-1).getEmplist() != null || data.get(data.size()-1).getEmplist()!= "") {
			String edata=data.get(data.size()-1).getEmplist();
			s = s + "@p_emplist='(" + edata.replaceAll("\"\"","\",\"" ) + ")',";
		}
		if (data.get(data.size()-1).getRoleid() != null || data.get(data.size()-1).getRoleid()!= "") {
			s = s + "@p_roleid='(" + data.get(data.size()-1).getRoleid()+ ")',";
		}
		if (data.get(0).getApprovedBy() != null || data.get(0).getApprovedBy()!= "") {
			s = s + "@p_approvedBy='" + data.get(0).getApprovedBy() + "',";
		}
		if (data.size() > 0) {
			for (RestPayrollApprovalModel m : data) {
				if(m.getToDate()!=null) {
					datalist = datalist + "(@p_status,@p_stage,\"" + m.getEmpId() + "\",\"" + m.getBandId() + "\",\"" + m.getDesig() +"\",\"" + m.getDept() + "\",\"" + m.getSubDept() + "\",\"" + m.getComponetId() + "\",\"" + m.getAmount()
						+ "\", \"" + DateFormatter.getStringDate(m.getFromDate()) + "\"," + "\""
						+ DateFormatter.getStringDate(m.getToDate()) + "\",\""+ m.getApprovedBy() + "\",\""+m.getFinancialYr()+"\",\""+m.getOrganization()+"\",\""+m.getOrgDivision()+"\"),";
			}
		}
		}
	
		if(!datalist.isEmpty()) {
			datalist = datalist.substring(0, datalist.length() - 1);
			s = s + "@P_EmpSubQuery='" + datalist + "',";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
		
	}
}