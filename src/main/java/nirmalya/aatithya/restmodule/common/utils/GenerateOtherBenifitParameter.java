package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestOtherBenifitsModel;

public class GenerateOtherBenifitParameter {
	
	public static String saveOtherBanifitsParam( RestOtherBenifitsModel  restOtherBenifitsModel) {

		String s = "";
 
		String benifitId = restOtherBenifitsModel.getBenifitId();
		String empid = restOtherBenifitsModel.getEmpid();
		String categoryId = restOtherBenifitsModel.getCategoryId();
		String benifit = restOtherBenifitsModel.getBenifit(); 
		//String effectiveDate = restOtherBenifitsModel.getEffectiveDate();
		String effectiveDate = DateFormatter.getStringDate( restOtherBenifitsModel.getEffectiveDate());
		String remark = restOtherBenifitsModel.getRemark();
		String frequency = restOtherBenifitsModel.getFreqencyob();
		String createdBy = restOtherBenifitsModel.getCreatedBy();
		String organization=restOtherBenifitsModel.getOrganization(); 
		String orgDivision=restOtherBenifitsModel.getOrgDivision();
	 
		s = s + "@p_benifitId='" + benifitId + "',";
		s = s + "@p_empid='" + empid + "',";
		s = s + "@p_categoryId='" + categoryId + "',";
		s = s + "@p_benifit='" + benifit + "',";
		s = s + "@p_effectiveDate='" + effectiveDate + "',";
		s = s + "@p_remark='" + remark + "',";
		s = s + "@p_frequency='" + frequency + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";
		
 
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Generate Parameter"+s);

		return s;
	}
	

}
