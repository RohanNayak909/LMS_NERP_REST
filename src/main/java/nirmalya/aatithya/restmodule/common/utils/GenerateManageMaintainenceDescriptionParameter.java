package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStackholderMaintenanceExpensesModel;

public class GenerateManageMaintainenceDescriptionParameter {
	public static String addMaintainenceDescriptionParam(RestStackholderMaintenanceExpensesModel restManageMaintainenceDescriptionModel) {

		String s ="";
		
		if (restManageMaintainenceDescriptionModel.getMainid() != null || restManageMaintainenceDescriptionModel.getMainid() != "") {
			s = s + "@p_mainid='" + restManageMaintainenceDescriptionModel.getMainid() + "',";
		}
		if (restManageMaintainenceDescriptionModel.getPropno() != null || restManageMaintainenceDescriptionModel.getPropno() != "") {
			s = s + "@p_propno='" + restManageMaintainenceDescriptionModel.getPropno() + "',";
		}
		
		if (restManageMaintainenceDescriptionModel.getMonth() != null || restManageMaintainenceDescriptionModel.getMonth() != "") {
			s = s + "@p_month='" + restManageMaintainenceDescriptionModel.getMonth() + "',";
		}
		
		if (restManageMaintainenceDescriptionModel.getMaintainence() != null || restManageMaintainenceDescriptionModel.getMaintainence() != "") {
			s = s + "@p_maintainence='" + restManageMaintainenceDescriptionModel.getMaintainence()+ "',";
		}
		if (restManageMaintainenceDescriptionModel.getRecptno() != null || restManageMaintainenceDescriptionModel.getRecptno() != "") {
			s = s + "@p_rcptno='" + restManageMaintainenceDescriptionModel.getRecptno()+ "',";
		}
		if (restManageMaintainenceDescriptionModel.getAmount()!= null || restManageMaintainenceDescriptionModel.getAmount() != "") {
			s = s + "@p_amount='" + restManageMaintainenceDescriptionModel.getAmount()+ "',";
		}
		
		if (restManageMaintainenceDescriptionModel.getCreatedby() != null || restManageMaintainenceDescriptionModel.getCreatedby() != "") {
			s = s + "@p_createdBy='" + restManageMaintainenceDescriptionModel.getCreatedby()+ "',";
		}
		
		if (restManageMaintainenceDescriptionModel.getCreatedOn() != null || restManageMaintainenceDescriptionModel.getCreatedOn() != "") {
			s = s + "@p_createdOn='" + restManageMaintainenceDescriptionModel.getCreatedOn()+ "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

}
