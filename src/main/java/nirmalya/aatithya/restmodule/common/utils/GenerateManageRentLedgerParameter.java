package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStakeholderRentLedgerModel;

public class GenerateManageRentLedgerParameter {
	
	public static String addRentLedgerParam(RestStakeholderRentLedgerModel restManageRentLedgerModel) {

		String s ="";
		if (restManageRentLedgerModel.getRentId() != null || restManageRentLedgerModel.getRentId() != "") {
			s = s + "@p_rentId='" + restManageRentLedgerModel.getRentId() + "',";
		}
		if (restManageRentLedgerModel.getPropNo() != null || restManageRentLedgerModel.getPropNo() != "") {
			s = s + "@p_propNo='" + restManageRentLedgerModel.getPropNo() + "',";
		}
		if (restManageRentLedgerModel.getPropName() != null || restManageRentLedgerModel.getPropName() != "") {
			s = s + "@p_propName='" + restManageRentLedgerModel.getPropName() + "',";
		}
		if (restManageRentLedgerModel.getTenantName() != null || restManageRentLedgerModel.getTenantName() != "") {
			s = s + "@p_tenantName='" + restManageRentLedgerModel.getTenantName() + "',";
		}
		if (restManageRentLedgerModel.getAddress() != null || restManageRentLedgerModel.getAddress() != "") {
			s = s + "@p_address='" + restManageRentLedgerModel.getAddress() + "',";
		}
		
		if (restManageRentLedgerModel.getOsamount() != null ||restManageRentLedgerModel.getOsamount() != "") {
			s = s + "@p_Osamount='" +restManageRentLedgerModel.getOsamount() + "',";
		}
		
		if (restManageRentLedgerModel.getMonth() != null ||restManageRentLedgerModel.getMonth() != "") {
			s = s + "@p_Month='" +restManageRentLedgerModel.getMonth()+ "',";
		}
		if (restManageRentLedgerModel.getDuerent()!= null ||restManageRentLedgerModel.getDuerent() != "") {
			s = s + "@p_duerent='" +restManageRentLedgerModel.getDuerent()+ "',";
		}
		if (restManageRentLedgerModel.getTotal()!= null ||restManageRentLedgerModel.getTotal() != "") {
			s = s + "@p_total='" +restManageRentLedgerModel.getTotal()+ "',";
		}
		if (restManageRentLedgerModel.getAmount()!= null ||restManageRentLedgerModel.getAmount() != "") {
			s = s + "@p_amount='" +restManageRentLedgerModel.getAmount()+ "',";
		}
		if (restManageRentLedgerModel.getBalance()!= null ||restManageRentLedgerModel.getBalance() != "") {
			s = s + "@p_balance='" +restManageRentLedgerModel.getBalance()+ "',";
		}
		if (restManageRentLedgerModel.getDate()!= null ||restManageRentLedgerModel.getDate() != "") {
			s = s + "@p_date='" +restManageRentLedgerModel.getDate()+ "',";
		}
		if (restManageRentLedgerModel.getCreatedby()!= null ||restManageRentLedgerModel.getCreatedby() != "") {
			s = s + "@p_createdby='" +restManageRentLedgerModel.getCreatedby()+ "',";
		}
		if (restManageRentLedgerModel.getCreatedOn()!= null ||restManageRentLedgerModel.getCreatedOn() != "") {
			s = s + "@p_createdOn='" +restManageRentLedgerModel.getCreatedOn()+ "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

}
