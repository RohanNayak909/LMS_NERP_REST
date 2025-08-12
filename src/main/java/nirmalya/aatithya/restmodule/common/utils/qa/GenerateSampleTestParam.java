package nirmalya.aatithya.restmodule.common.utils.qa;


import nirmalya.aatithya.restmodule.qa.model.RestSampleTestModel;

public class GenerateSampleTestParam {
	
	public static String getSampleTestParam(RestSampleTestModel data) {

		String s = "";


		if (data.getId() != null ||  data.getId() != "") {
			s = s + "@p_reqId='" + data.getId() + "',";
		}else {
			s = s + "@p_reqId='"+""+"',";
		}
		if (data.getTestRes() != null ||  data.getTestRes() != "") {
			s = s + "@p_testres='" + data.getTestRes() + "',";
		}else {
			s = s + "@p_testres='" + "" + "',";
		}
		if (data.getParamid() != null || data.getParamid() != "") {
			s = s + "@p_param='" + data.getParamid() + "',";
		}else {
			s = s + "@p_param='" + "" + "',";
		}
		if (data.getTask() != null ||  data.getTask() != "") {
			s = s + "@p_task='" + data.getTask() + "',";
		}else {
			s = s + "@p_task='" + "" + "',";
		}
		if (data.getSku() != null ||  data.getSku() != "") {
			s = s + "@p_sku='" + data.getSku() + "',";
		}else {
			s = s + "@p_sku='" + "" + "',";
		}
		if (data.getStatus() != null ||  data.getStatus() != "") {
			s = s + "@p_status='" + data.getStatus() + "',";
		}else {
			s = s + "@p_status='" + "" + "',";
		}
		if (data.getRefObjData() != null ||  data.getRefObjData() != "") {
			s = s + "@p_refObjData='" + data.getRefObjData() + "',";
		}else {
			s = s + "@p_refObjData='" + "" + "',";
		}
		if (data.getCreatedBy() != null ||  data.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + data.getCreatedBy() + "',";
		}else {
			s = s + "@p_createdBy='" + "" + "',";
		}
		if (data.getOrgName() != null ||  data.getOrgName() != "") {
			s = s + "@p_org='" + data.getOrgName() + "',";
		}else {
			s = s + "@p_org='" + "" + "',";
		}
		if (data.getOrgDiv() != null ||  data.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + data.getOrgDiv() + "',";
		}else {
			s = s + "@p_orgDiv='" + "" + "',";
		}


		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("SSSSS>>>-----"+s);
		return s;

	}

}
