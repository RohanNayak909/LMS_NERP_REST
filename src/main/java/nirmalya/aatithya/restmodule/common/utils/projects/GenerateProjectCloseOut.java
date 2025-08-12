package nirmalya.aatithya.restmodule.common.utils.projects;

import java.util.List;

import nirmalya.aatithya.restmodule.projects.model.CloseOutRestModel;

public class GenerateProjectCloseOut {
	
	public static String getPrjCreateParam(CloseOutRestModel prjCloseOut) {
		String s = "";
	
		if (prjCloseOut.getProjectId() != null || prjCloseOut.getProjectId() != "") {
			s = s + "@p_getProjectId='" + prjCloseOut.getProjectId() + "',";
		}
		
		if (prjCloseOut.getCloseOutId() != null || prjCloseOut.getCloseOutId() != "") {
			s = s + "@p_getCloseOutId='" + prjCloseOut.getCloseOutId() + "',";
		}
		
		if (prjCloseOut.getWinorissue() != null || prjCloseOut.getWinorissue() != "") {
			s = s + "@p_getWinorissue='" + prjCloseOut.getWinorissue() + "',";
		}
		
		if (prjCloseOut.getDescription() != null || prjCloseOut.getDescription() != "") {
			s = s + "@p_getDescription='" + prjCloseOut.getDescription() + "',";
		}

		if (prjCloseOut.getImpact() != null || prjCloseOut.getImpact() != "") {
			s = s + "@p_getImpact='" + prjCloseOut.getImpact() + "',";
		}
		if (prjCloseOut.getFutureproject() != null || prjCloseOut.getFutureproject() != "") {
			s = s + "@p_getFutureproject='" + prjCloseOut.getFutureproject() + "',";
		}

		if (prjCloseOut.getAction() != null || prjCloseOut.getAction() != "") {
			s = s + "@p_getAction='" + prjCloseOut.getAction() + "',";
		}

		
		if (prjCloseOut.getStatus() != null || prjCloseOut.getStatus() != "") {
			s = s + "@p_getStatus='" + prjCloseOut.getStatus() + "',";
		}
		
		if (prjCloseOut.getCreatedBy() != null || prjCloseOut.getCreatedBy() != "") {
			s = s + "@p_getCreatedBy='" + prjCloseOut.getCreatedBy() + "',";
		}
		
		if (prjCloseOut.getOrganizationName() != null || prjCloseOut.getOrganizationName() != "") {
			s = s + "@p_getOrganizationName='" + prjCloseOut.getOrganizationName() + "',";
		}
		
		if (prjCloseOut.getOrganizationDivision() != null || prjCloseOut.getOrganizationDivision() != "") {
			s = s + "@p_getOrganizationDivision='" + prjCloseOut.getOrganizationDivision() + "',";
		}
		
		
		
		/*
		 * if (prjCloseOut.getCreatedOn() != null || prjCloseOut.getCreatedOn() != "") {
		 * s = s + "@p_getCreatedOn='" + prjCloseOut.getCreatedOn() + "',"; }
		 * 
		 * if (prjCloseOut.getUpdatedBy() != null || prjCloseOut.getUpdatedBy() != "") {
		 * s = s + "@p_getUpdatedBy='" + prjCloseOut.getUpdatedBy() + "',"; }
		 * 
		 * if (prjCloseOut.getUpdatedOn() != null || prjCloseOut.getUpdatedOn() != "") {
		 * s = s + "@p_getUpdatedOn='" + prjCloseOut.getUpdatedOn() + "',"; }
		 */
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

	public static String getAddQuotParam(List<CloseOutRestModel> model) {

		String s = "";
		String vendorParam = "";
	
		for (CloseOutRestModel a : model) {

			vendorParam = vendorParam + "(gen_closeout_id(),\"" + a.getProjectId() + "\",\"" + a.getWinorissue()+"\",\""+a.getDescription()+"\",\""+a.getImpact()+"\",\""+a.getFutureproject()+"\",\""+a.getAction()+"\"),";

		}
		vendorParam = vendorParam.substring(0, vendorParam.length() - 1);


		s = s + "@p_vendorParamSubQuery='" + vendorParam + "',";
	

		if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
		}
		
		return s;
	}
}
