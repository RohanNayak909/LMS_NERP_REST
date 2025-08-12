package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.api.model.AdvanceManagementApiModel;

public class GenerateAdvanceManagementParamApi {
	public static String getAdvManageParamApi( AdvanceManagementApiModel  advance) {

		String s = "";
 
		String advanceId = advance.getAdvanceId();
		String	reqPolicyId = advance.getReqPolicyId();
		String	empID = advance.getEmpID();	
		Double loanamt = advance.getLoanamt(); 
		String	reason = advance.getReason();
		String	createdBy = advance.getCreatedBy();
	 
		s = s + "@p_advanceId='" + advanceId + "',";
		s = s + "@p_reqPolicyId='" + reqPolicyId + "',";
		s = s + "@p_empId='" + empID + "',";
		s = s + "@p_loanamt='" + loanamt + "',";
		s = s + "@p_reason='" + reason + "',";
		s = s + "@p_createdBy='" + createdBy + "',";		
		
 
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Generate Parameter"+s);

		return s;
	}
}
