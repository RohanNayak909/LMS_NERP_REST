package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStakeholderServiceProviderModel;

public class GenerateManageServiceProvidersParameter {
	public static String addServiceProvidersParam(RestStakeholderServiceProviderModel restManageServiceProvidersModel) {

		String s ="";
		if (restManageServiceProvidersModel.getPropid() != null || restManageServiceProvidersModel.getPropid() != "") {
			s = s + "@p_propId='" + restManageServiceProvidersModel.getPropid() + "',";
		}
		
		if (restManageServiceProvidersModel.getVndrid() != null || restManageServiceProvidersModel.getVndrid() != "") {
			s = s + "@p_vendorId='" + restManageServiceProvidersModel.getVndrid() + "',";
		}
		
		if (restManageServiceProvidersModel.getVndrname() != null || restManageServiceProvidersModel.getVndrname() != "") {
			s = s + "@p_VendorName='" + restManageServiceProvidersModel.getVndrname() + "',";
		}
		
		if (restManageServiceProvidersModel.getServicecategory() != null || restManageServiceProvidersModel.getServicecategory() != "") {
			s = s + "@p_ServiceCategory='" + restManageServiceProvidersModel.getServicecategory()+ "',";
		}
		if (restManageServiceProvidersModel.getGstin()!= null || restManageServiceProvidersModel.getGstin() != "") {
			s = s + "@p_gstn='" + restManageServiceProvidersModel.getGstin()+ "',";
		}
		if (restManageServiceProvidersModel.getAddress()!= null || restManageServiceProvidersModel.getAddress() != "") {
			s = s + "@p_address='" + restManageServiceProvidersModel.getAddress()+ "',";
		}
		if (restManageServiceProvidersModel.getEmail()!= null || restManageServiceProvidersModel.getEmail() != "") {
			s = s + "@p_email='" + restManageServiceProvidersModel.getEmail()+ "',";
		}
		if (restManageServiceProvidersModel.getContperson()!= null || restManageServiceProvidersModel.getContperson() != "") {
			s = s + "@p_person='" + restManageServiceProvidersModel.getContperson()+ "',";
		}
		if (restManageServiceProvidersModel.getMobileno()!= null || restManageServiceProvidersModel.getMobileno() != "") {
			s = s + "@p_mobile='" + restManageServiceProvidersModel.getMobileno()+ "',";
		}
		if (restManageServiceProvidersModel.getRemarks()!= null || restManageServiceProvidersModel.getRemarks() != "") {
			s = s + "@p_remarks='" + restManageServiceProvidersModel.getRemarks()+ "',";
		}
		
		if (restManageServiceProvidersModel.getCreatedby() != null || restManageServiceProvidersModel.getCreatedby() != "") {
			s = s + "@p_createdBy='" + restManageServiceProvidersModel.getCreatedby()+ "',";
		}
		
		if (restManageServiceProvidersModel.getCreatedOn() != null || restManageServiceProvidersModel.getCreatedOn() != "") {
			s = s + "@p_createdOn='" + restManageServiceProvidersModel.getCreatedOn()+ "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}


}
