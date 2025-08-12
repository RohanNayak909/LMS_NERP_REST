package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestDemoTreeModel;

public class GenerateDemoCategoryParameter {
	
	public static String saveDemoCategory(RestDemoTreeModel demo) {
		
		String s = "";
		
		if(demo.getDemoId()!=null && demo.getDemoId()!="") {
			s = s + "@p_demoId='" + demo.getDemoId() + "',";
		}
		if(demo.getDemoName()!=null && demo.getDemoName()!="") {
			s = s + "@p_demoName='" + demo.getDemoName() + "',";
		}
		if(demo.getDemoDesc()!=null && demo.getDemoDesc()!="") {
			s = s + "@p_demoDesc='" + demo.getDemoDesc() + "',";
		}
		if(demo.getParentId()!=null && demo.getParentId()!="") {
			s = s + "@p_parentId='" + demo.getParentId() + "',";
		}
		if(demo.getCreatedBy()!=null && demo.getCreatedBy()!="") {
			s = s + "@p_CreatedBy='" + demo.getCreatedBy() + "',";
		}
		if(demo.getDemoStatus()!=null  && demo.getDemoStatus()!="") {
			s = s + "@p_demoStatus='" + demo.getDemoStatus() + "',";
		}else {
			s = s + "@p_demoStatus='" + 0 + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		
		return s;
		
	}

}
