package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.CostCenterModel;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;

public class GenerateCostCenterParameter {
public static String saveCostCenter(CostCenterModel costCenterModel) {
		
		String s = "";
		
		if(costCenterModel.getCcId()!=null && costCenterModel.getCcId()!="") {
			s = s + "@p_ccId='" + costCenterModel.getCcId() + "',";
		}
		if(costCenterModel.getCcName()!=null && costCenterModel.getCcName()!="") {
			s = s + "@p_ccName='" + costCenterModel.getCcName() + "',";
		}
		if(costCenterModel.getCcCode()!=null && costCenterModel.getCcCode()!="") {
			s = s + "@p_ccCode='" + costCenterModel.getCcCode() + "',";
		}
		if(costCenterModel.getCreatedBy()!=null && costCenterModel.getCreatedBy()!="") {
			s = s + "@p_createdBy='" + costCenterModel.getCreatedBy() + "',";
		}
		if(costCenterModel.getCcrProfitStatus()!=null && costCenterModel.getCcrProfitStatus()!="") {
			s = s + "@p_isProfitActive='" + costCenterModel.getCcrProfitStatus() + "',";
		} else {
			s = s + "@p_isProfitActive='" + 0 + "',";
		}
		if(costCenterModel.getCcNature()!=null && costCenterModel.getCcNature()!="") {
			s = s + "@p_ccNature='" + costCenterModel.getCcNature() + "',";
		}
		if(costCenterModel.getParentId()!=null && costCenterModel.getParentId()!="") {
			s = s + "@p_parentId='" + costCenterModel.getParentId() + "',";
		}
		if(costCenterModel.getCcLabourType()!=null && costCenterModel.getCcLabourType()!="") {
			s = s + "@p_ccLabourType='" + costCenterModel.getCcLabourType() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}
}
