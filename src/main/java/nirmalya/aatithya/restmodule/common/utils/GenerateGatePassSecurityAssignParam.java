package nirmalya.aatithya.restmodule.common.utils;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import nirmalya.aatithya.restmodule.gatepass.model.RestSecurityAssignModel;
 

public class GenerateGatePassSecurityAssignParam {

	/**
	 * add parameter set for inventory itemRequisition class
	 *
	 **/
	public static String getAssignParam(List<RestSecurityAssignModel> restSecurityAssignModel) {
		String s = "";
		String litem = "";
		String assignId = "";
		String description = "";
		String assignDate = "";
		String shift = "";
		String createdBy = "";
		String orgName = "";
		String orgDivision = "";
		for (RestSecurityAssignModel m : restSecurityAssignModel) {
			assignId = m.getSecurityAssignId();
			description = m.getDesc();
//			expectedDate = DateFormatter.getStringDate(m.getReceiveDate());
			assignDate = m.getAssignDate();
			shift = m.getShift();
			createdBy = m.getCreatedBy();
			orgName=m.getOrganizationName();
			orgDivision=m.getOrganizationDivision();
		}
		s = s + "@p_assignId='" + assignId + "',";
		s = s + "@p_description='" + description + "',";
		s = s + "@p_assignDate='" + assignDate + "',";
		s = s + "@p_shift='" + shift + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_orgName='" + orgName + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";

		
		if(!restSecurityAssignModel.get(0).getSecurityAssignId().contentEquals("1")) {
			for (RestSecurityAssignModel m : restSecurityAssignModel) {

				/*l
					  item = litem + "( \"" + m.getSecurityAssignId() + "\",\"" + m.getSlNo() +
					 * "\", \"" + m.getSecurityName() + "\" ,\"" + m.getPostGateType() + "\", \"" +
					 * m.getInTime() + "\",\"" + m.getOutTime() + "\",\"" + m.getCreatedBy() +
					 * "\",\"" +m.getOrganizationName()+ "\",\""+m.getOrganizationDivision()+"\"),";
					 */
				
				litem = litem + "(@p_assignId,\"" + m.getSlNo() + "\",\"" + m.getSecurityNameId() + "\",\"" + m.getPostGateTypeId() + "\",\"" + m.getInTime() + "\", \"" + m.getOutTime() + "\", \"" + m.getCreatedBy()
						+ "\",@p_orgName,@p_orgDiv),";
				
		
			}
			litem = litem.substring(0, litem.length() - 1);


			s = s + "@p_litemSubQuery='" + litem + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
System.out.println(s);
		return s;
	}



}
