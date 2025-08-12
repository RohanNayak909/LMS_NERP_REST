package nirmalya.aatithya.restmodule.common.utils.grc;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.grc.model.InspectionGenerateRestModel;
import nirmalya.aatithya.restmodule.grc.model.InspectionGenerateRestSubModel;
import nirmalya.aatithya.restmodule.grc.model.SafetyIdentificationRestModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPhysicalVarificationModel;

public class GenerateInspectionGenerateParam {

	public static String getAddQuotParam(InspectionGenerateRestModel model) {
		String s = "";
		String listdata = "";
		
		
		s = s + "@p_inspectionId='" + model.getInspectionId() + "',";
		s = s + "@p_projectId='" +model.getProjectId() + "',";
		s = s + "@p_projectName='" + model.getProjectName() + "',";
		s = s + "@p_site='" +model.getSite() + "',";
		s = s + "@p_createdBy='" + model.getCreatedBy() + "',";
		s = s + "@p_org='" +model.getOrganizationName() + "',";
		s = s + "@p_orgDiv='" +model.getOrganizationDivision() + "',";
		
		for (InspectionGenerateRestSubModel a : model.getSubModel()) {

			listdata = listdata + "(gen_checklist_Id(),@p_inspectionId,@p_projectId,\""  +a.getCategoryId() + "\",\"" + 
			  a.getSubCategoryId() + "\",\"" + a.getCreatedBy() + "\",\"" + a.getOrganizationName() +  "\",\"" 
					+ a.getOrganizationDivision() + "\"),";

		}
		listdata = listdata.substring(0, listdata.length() - 1);

		
		s = s + "@p_litemSubQuery='" + listdata + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	
	
	public static String getAddQuotParamMod(InspectionGenerateRestModel model) {
		String s = "";
		String listdata = "";
		
		
		s = s + "@p_inspectionId='" + model.getInspectionId() + "',";
		s = s + "@p_projectId='" +model.getProjectId() + "',";
		s = s + "@p_projectName='" + model.getProjectName() + "',";
		s = s + "@p_site='" +model.getSite() + "',";
		s = s + "@p_createdBy='" + model.getCreatedBy() + "',";
		s = s + "@p_org='" +model.getOrganizationName() + "',";
		s = s + "@p_orgDiv='" +model.getOrganizationDivision() + "',";
		s = s + "@p_checkId='" +model.getSerialNo() + "',";
		for (InspectionGenerateRestSubModel a : model.getSubModel()) {

			listdata = listdata + "(\""  +a.getSerialNo() + "\",@p_inspectionId,@p_projectId,\""  +a.getCategoryId() + "\",\"" + 
			  a.getSubCategoryId() + "\",\"" + a.getCreatedBy() + "\",\"" + a.getOrganizationName() +  "\",\"" 
					+ a.getOrganizationDivision() + "\",\""  +a.getType() + "\",\""  +a.getAssignedTo() + "\" ,"
							+ "\""  +a.getStartDate() + "\",\""  +a.getEndDate() +"\"),";

		}
		listdata = listdata.substring(0, listdata.length() - 1);

		
		s = s + "@p_litemSubQuery='" + listdata + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
	public static String getAddAssignParam(List<InspectionGenerateRestSubModel> model) {
		String listdata = "";
		String s = "";
		
		String type = "";
		String assignTo = "";
		String startDate = "";
		String endDate = "";
		String organization = "";
		String orgDivision = "";
		String inspectionId = "";
		for (InspectionGenerateRestSubModel m : model) {
			type = m.getType();
			assignTo = m.getAssignedTo();
			startDate = m.getStartDate();
			endDate = m.getEndDate();
			organization = m.getOrganizationName();
			orgDivision = m.getOrganizationDivision();
			inspectionId=m.getInspectionId();
		}
		
		s = s + "@p_type='" + type + "',";
		s = s + "@p_assignTo='" + assignTo + "',";
		s = s + "@p_startDate='" + DateFormatter.getStringDate(startDate) + "',";
		s = s + "@p_endDate='" + DateFormatter.getStringDate(endDate) + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_inspectionId='" + inspectionId + "',";

		for (InspectionGenerateRestSubModel a : model) {
			listdata = listdata + "\""  +a.getSerialNo() + "\",";
		}
		listdata = listdata.substring(0, listdata.length() - 1);

		
		s = s + "@p_litemSubQuery='(" + listdata + ")',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

}
