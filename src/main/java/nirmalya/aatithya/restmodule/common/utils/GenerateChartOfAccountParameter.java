package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.ChartOfAccountModel;


public class GenerateChartOfAccountParameter {

public static String saveChartOfAccountParam(ChartOfAccountModel chartOfAccountModel) {
		
		String s = "";
		
		if(chartOfAccountModel.getCcId()!=null && chartOfAccountModel.getCcId()!="") {
			s = s + "@p_ccId='" + chartOfAccountModel.getCcId() + "',";
		}
		if(chartOfAccountModel.getCcName()!=null && chartOfAccountModel.getCcName()!="") {
			s = s + "@p_ccName='" + chartOfAccountModel.getCcName() + "',";
		}
		if(chartOfAccountModel.getCcCode()!=null && chartOfAccountModel.getCcCode()!="") {
			s = s + "@p_ccCode='" + chartOfAccountModel.getCcCode() + "',";
		}
		if(chartOfAccountModel.getCreatedBy()!=null && chartOfAccountModel.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + chartOfAccountModel.getCreatedBy() + "',";
		}
		if(chartOfAccountModel.getChartAccCreditStatus()!=null && chartOfAccountModel.getChartAccCreditStatus()!="") {
			s = s + "@p_isCreditActive='" + chartOfAccountModel.getChartAccCreditStatus() + "',";
		} else {
			s = s + "@p_isCreditActive='" + 0 + "',";
		}
		if(chartOfAccountModel.getChartAccDebitStatus()!=null && chartOfAccountModel.getChartAccDebitStatus()!="") {
			s = s + "@p_debitStatus='" + chartOfAccountModel.getChartAccDebitStatus() + "',";
		} else {
			s = s + "@p_debitStatus='" + 0 + "',";
		}
		
		if(chartOfAccountModel.getParentId()!=null && chartOfAccountModel.getParentId()!="") {
			s = s + "@p_parentId='" + chartOfAccountModel.getParentId() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}

}
