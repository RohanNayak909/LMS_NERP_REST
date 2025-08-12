package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;


import nirmalya.aatithya.restmodule.master.model.AccountMappingModel;

public class GenerateAccountMappingParameter {
	public static String accountMappingSave(List<AccountMappingModel> accountMappingModel) {
		String s = "";
		String mapping = "";
		/*if (accountMappingModel.get(0).getMappingId() != "" && accountMappingModel.get(0).getMappingId() != null) {
			s = s + "@p_mappingId='" + accountMappingModel.get(0).getMappingId() + "',";
		}
		*/
		if (accountMappingModel.get(0).getCostCenterId() != null) {
			s = s + "@P_costId='" + accountMappingModel.get(0).getCostCenterId() + "',";
		}
		for (AccountMappingModel m : accountMappingModel) {
			mapping = mapping + "(\"" + m.getChartOfAcId() + "\",\"" + m.getCostCenterId()+ "\",\""
					+ m.getCreatedBy() + "\"),";
		}

		mapping = mapping.substring(0, mapping.length() - 1);

		s = s + "@p_gPassSubQuery='" + mapping + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
