package nirmalya.aatithya.restmodule.common.utils.training;

import java.util.List;
import java.util.UUID;

import nirmalya.aatithya.restmodule.training.model.ManageTrainingRestDocumentModel;
import nirmalya.aatithya.restmodule.training.model.ManageTrainingRestModel;
import nirmalya.aatithya.restmodule.training.model.ViewStudyMaterialsRestModel;

public class GenerateTrainingCategoryParameter {

	public static String saveTrainingCategory(ManageTrainingRestModel category) {

		String s = "";

		if (category.getCategoryId() != null && category.getCategoryId() != "") {
			s = s + "@p_categoryId='" + category.getCategoryId() + "',";
		}
		if (category.getCategoryName() != null && category.getCategoryName() != "") {
			s = s + "@p_categoryName='" + category.getCategoryName() + "',";
		}
		if (category.getCategoryDesc() != null && category.getCategoryDesc() != "") {
			s = s + "@p_categoryDesc='" + category.getCategoryDesc() + "',";
		}
		if (category.getParentId() != null && category.getParentId() != "") {
			s = s + "@p_parentId='" + category.getParentId() + "',";
		}
		if (category.getCreatedBy() != null && category.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.getCreatedBy() + "',";
		}
		if (category.getOrganization() != null && category.getOrganization() != "") {
			s = s + "@p_organization='" + category.getOrganization() + "',";
		}
		if (category.getOrgDivision() != null && category.getOrgDivision() != "") {
			s = s + "@p_orgdivision='" + category.getOrgDivision() + "',";
		}
		if (category.getCategoryStatus() != null && category.getCategoryStatus() != "") {
			s = s + "@p_isActive='" + category.getCategoryStatus() + "',";
		} else {
			s = s + "@p_isActive='" + 0 + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

//save training study material
	public static String saveTrainingStudyMaterial(List<ManageTrainingRestModel> category) {

		String s = "";

		if (category.get(0).getMaterialId() != null && category.get(0).getMaterialId() != "") {
			s = s + "@p_studyMaterialId='" + category.get(0).getMaterialId() + "',";
		}
		if (category.get(0).getCategoryId() != null && category.get(0).getCategoryId() != "") {
			s = s + "@p_categoryId='" + category.get(0).getCategoryId() + "',";
		}
		if (category.get(0).getTimeSpent() != null && category.get(0).getTimeSpent() != "") {
			s = s + "@p_timeSpent='" + category.get(0).getTimeSpent() + "',";
		}
		if (category.get(0).getTextHeading() != null && category.get(0).getTextHeading() != "") {
			s = s + "@p_materialHeading='" + category.get(0).getTextHeading() + "',";
		}
		if (category.get(0).getTextDescription() != null && category.get(0).getTextDescription() != "") {
			s = s + "@p_materialDescription='" + category.get(0).getTextDescription() + "',";
		}
		if (category.get(0).getTextContent() != null && category.get(0).getTextContent() != "") {
			s = s + "@p_materialContent='" + category.get(0).getTextContent() + "',";
		}
		if (category.get(0).getStudyMaterialType() != null && category.get(0).getStudyMaterialType() != "") {
			s = s + "@p_materialtype='" + category.get(0).getStudyMaterialType() + "',";
		}
		if (category.get(0).getCreatedBy() != null && category.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.get(0).getCreatedBy() + "',";
		}
		if (category.get(0).getOrganization() != null && category.get(0).getOrganization() != "") {
			s = s + "@p_organization='" + category.get(0).getOrganization() + "',";
		}
		if (category.get(0).getOrgDivision() != null && category.get(0).getOrgDivision() != "") {
			s = s + "@p_orgdivision='" + category.get(0).getOrgDivision() + "',";
		}
		if (category.get(0).getMaterialStatus() != null && category.get(0).getMaterialStatus() != "") {
			s = s + "@p_isActive=" + category.get(0).getMaterialStatus() + ",";
		} else {
			s = s + "@p_isActive=" + 0 + ",";
		}

		String document = "";
		for (ManageTrainingRestDocumentModel a : category.get(0).getDocumentList()) {
			document = document + "(@p_studyMaterialId,\"" + a.getDocumnentName() + "\",\""
					+ a.getFileName() + "\",\"" + a.getDocumentURL() + "\",@p_createdBy,@p_organization,@p_orgdivision),";
		}
		if (!document.isEmpty()) {
			document = document.substring(0, document.length() - 1);
			s = s + "@p_studyMaterialDocuments='" + document + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		return s;
	}

	/*
	 * get category ids
	 */
	@SuppressWarnings("unused")
	public static String getCategory(String items) {
		String[] productCatIds = items.split(",");
		String s = "";
		String litem = "";
		String act = "";
		for (String a : productCatIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_catIds='" + litem + "',";

		// act = act.substring(0, act.length() - 1);

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String saveTrainingOnDraft(List<ViewStudyMaterialsRestModel> allData) {

		String s = "";
		String data = "";
		for (ViewStudyMaterialsRestModel a : allData) {
			UUID uuid = UUID.randomUUID();
			data = data + "(\""+uuid.toString()+"\",\"" + a.getEmployeeId() + "\",\"" + a.getCategoryId() + "\",\"" + a.getStatus() + "\",\""
					+ a.getAssignedDate() + "\",\"" + a.getEmpName() + "\",\"" + a.getOrg() + "\",\"" + a.getOrgDiv()
					+ "\"),";
		}

		if (!data.isEmpty()) {
			data = data.substring(0, data.length() - 1);
			s = s + "@p_studyMaterialDetails='" + data + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	public static String saveScheduleTraining(List<ViewStudyMaterialsRestModel> allData) {

		String s = "";
		String data = "";
		
		for (ViewStudyMaterialsRestModel a : allData) {
			if(a.getScheduledHours()!=null && a.getScheduledHours()!="") {
				a.setScheduledHours(a.getScheduledHours()+":00:00");
				a.setScheduleCounter((a.getScheduledHours()));
			}
			
			UUID uuid = UUID.randomUUID();
			data = data + "(\""+uuid.toString()+"\",\""+a.getAssignId()+"\",\"" + a.getEmployeeId() + "\",\"" + a.getCategoryId() + "\",\"" + a.getStatus() + "\",\""
					+ a.getScheduledFromDate() + "\",\""+a.getScheduledToDate()+ "\",\"" + a.getEmpName() + "\",\""+a.getScheduledOn()+"\",\""+a.getScheduledHours()+"\",\""+a.getScheduleCounter()+"\",\"" + a.getOrg() + "\",\"" + a.getOrgDiv()
					+ "\"),";
		}
		if (!data.isEmpty()) {
			data = data.substring(0, data.length() - 1);
			s = s + "@p_studyMaterialDetails='" + data + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		return s;

	}
}
