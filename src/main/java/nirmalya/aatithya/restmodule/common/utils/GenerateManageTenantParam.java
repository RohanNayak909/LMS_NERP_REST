package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStakeholderTenantModel;

public class GenerateManageTenantParam {

	public static String addTenantParam(RestStakeholderTenantModel restManageTenantModel) {

		String s ="";
		if (restManageTenantModel.getTenantId() != null || restManageTenantModel.getTenantId() != "") {
			s = s + "@p_tenantId='" + restManageTenantModel.getTenantId() + "',";
		}
		
		if (restManageTenantModel.getPropId() != null || restManageTenantModel.getPropId() != "") {
			s = s + "@p_propId='" + restManageTenantModel.getPropId() + "',";
		}
		
		if (restManageTenantModel.getName() != null || restManageTenantModel.getName() != "") {
			s = s + "@p_name='" + restManageTenantModel.getName()+ "',";
		}
		if (restManageTenantModel.getAddress()!= null || restManageTenantModel.getAddress() != "") {
			s = s + "@p_address='" + restManageTenantModel.getAddress()+ "',";
		}
		if (restManageTenantModel.getMobile()!= null || restManageTenantModel.getMobile() != "") {
			s = s + "@p_mobile='" + restManageTenantModel.getMobile()+ "',";
		}
		if (restManageTenantModel.getEmail()!= null || restManageTenantModel.getEmail() != "") {
			s = s + "@p_email='" + restManageTenantModel.getEmail()+ "',";
		}
		
		if (restManageTenantModel.getRentAmount()!= null || restManageTenantModel.getRentAmount() != "") {
			s = s + "@p_rentAmount='" + restManageTenantModel.getRentAmount()+ "',";
		}
		if (restManageTenantModel.getDeposit()!= null || restManageTenantModel.getDeposit() != "") {
			s = s + "@p_deposit='" + restManageTenantModel.getDeposit()+ "',";
		}
		if (restManageTenantModel.getLatefee()!= null || restManageTenantModel.getLatefee() != "") {
			s = s + "@p_latefee='" + restManageTenantModel.getLatefee()+ "',";
		}
		
		if (restManageTenantModel.getDay()!= null || restManageTenantModel.getDay() != "") {
			s = s + "@p_day='" + restManageTenantModel.getDay()+ "',";
		}
		if (restManageTenantModel.getFromDate()!= null || restManageTenantModel.getFromDate() != "") {
			s = s + "@p_startdate='" + restManageTenantModel.getFromDate()+ "',";
		}
		if (restManageTenantModel.getToDate()!= null || restManageTenantModel.getToDate() != "") {
			s = s + "@p_enddate='" + restManageTenantModel.getToDate()+ "',";
		}
		if (restManageTenantModel.getPayment()!= null || restManageTenantModel.getPayment() != "") {
			s = s + "@p_payment='" + restManageTenantModel.getPayment()+ "',";
		}
		
		if (restManageTenantModel.getDocName()!= null || restManageTenantModel.getDocName() != "") {
			s = s + "@p_docname='" + restManageTenantModel.getDocName()+ "',";
		}
		if (restManageTenantModel.getInformation()!= null || restManageTenantModel.getInformation() != "") {
			s = s + "@p_information='" + restManageTenantModel.getInformation()+ "',";
		}
		if (restManageTenantModel.getCreatedBy() != null || restManageTenantModel.getCreatedBy() != "") {
			s = s + "@p_createdBy=" + restManageTenantModel.getCreatedBy()+ ",";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}
	

}
