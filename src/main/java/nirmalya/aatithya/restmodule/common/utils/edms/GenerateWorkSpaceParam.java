package nirmalya.aatithya.restmodule.common.utils.edms;

import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.edms.model.RestDocumentAccessModel;
import nirmalya.aatithya.restmodule.edms.model.RestDocumentManageAccessModel;
import nirmalya.aatithya.restmodule.edms.model.RestDocumentManageModel;
import nirmalya.aatithya.restmodule.edms.model.RestWorkSpaceChildModel;
import nirmalya.aatithya.restmodule.edms.model.RestWorkSpaceModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseIndentModel;

public class GenerateWorkSpaceParam {
	public static String getWorkspaceParam(RestWorkSpaceModel workModel) {

		String s = "";  
 
		s = s + "@p_workSpaceId='" + workModel.getWorkspaceId() + "',"; 

		if (workModel.getParentFolderName() != null && workModel.getParentFolderName() != "") {
			s = s + "@p_pFolder='" + workModel.getParentFolderName() + "',";
		}

		if (workModel.getNewFolderName() != null && workModel.getNewFolderName() != "") {
			s = s + "@p_nFolder='" + workModel.getNewFolderName() + "',";
		}
		if (workModel.getAccessType() != null && workModel.getAccessType() != "") {
			s = s + "@p_accessType='" + workModel.getAccessType() + "',";
		}
		if (workModel.getOwner() != null && workModel.getOwner() != " ") {
			s = s + "@p_owner='" + workModel.getOwner() + "',";
		}
		if (workModel.getDefaultTags() != null && workModel.getDefaultTags() != "") {
			s = s + "@p_defaultTags='" + workModel.getDefaultTags() + "',";
		}

		if (workModel.getDescription() != null && workModel.getDescription() != " ") {
			s = s + "@p_description='" + workModel.getDescription() + "',";
		}
		if (workModel.getOrganizationName() != null && workModel.getOrganizationName() != "") {
			s = s + "@p_orgName='" + workModel.getOrganizationName() + "',";
		}
		if (workModel.getOrganizationDivision() != null && workModel.getOrganizationDivision() != " ") {
			s = s + "@p_orgDiv='" + workModel.getOrganizationDivision() + "',";
		}

		String itemparam = "";
		List<RestWorkSpaceChildModel> items = workModel.getAccessControl();
		if (workModel.getAccessControl().size() > 0) {
			for (RestWorkSpaceChildModel m : items) {

				itemparam = itemparam + "(@p_workSpaceId,\"" + m.getActivityId() + "\",\"" + m.getActivityName()
						+ "\",\"" + m.getSiNo() + "\",\"" + m.getStatusName() + "\",\"" + m.getGroupName()
						+ "\",@p_orgName,@p_orgDiv),";
			}

			itemparam = itemparam.substring(0, itemparam.length() - 1);
		} else {
			itemparam = "";
		}
		s = s + "@p_itemParam='" + itemparam + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String getManageUserGroupParam(RestDocumentManageModel managemodel) {
		String s = "";
		String jsonString = "";
		if (managemodel.getGroupId() != null && managemodel.getGroupId() != "") {
			s = s + "@p_groupId='" + managemodel.getGroupId() + "',";
		}
		if (managemodel.getGroupName() != null && managemodel.getGroupName() != "") {
			s = s + "@p_groupName='" + managemodel.getGroupName() + "',";
		} 
		if (managemodel.getGroupDescription() != null && managemodel.getGroupDescription() != "") {
			s = s + "@p_desc='" + managemodel.getGroupDescription() + "',";
		}
		
		  if (managemodel.getUsers() != null) { Gson gson = new Gson(); jsonString =
		  gson.toJson(managemodel.getUsers()); s = s + "@p_users='" +jsonString + "',";
		  }
		 
		if (managemodel.getCreatedBy() != null && managemodel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + managemodel.getCreatedBy() + "',";
		}
		if (managemodel.getOrganization() != null && managemodel.getOrganization() != "") {
			s = s + "@p_organization='" + managemodel.getOrganization() + "',";
		}
		if (managemodel.getOrganizationDivision() != null && managemodel.getOrganizationDivision() != "") {
			s = s + "@p_orgDivision='" + managemodel.getOrganizationDivision() + "',";
		}	
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("managemodel"+s);
		return s;
	}

	public static String getManageUserAccess(List<RestDocumentManageAccessModel> restAccessModel) {
		System.out.println("restAccessModel USER ACCESS"+restAccessModel);
		String s = "";
		String listdata = "";
		String empName = "";
		String docId = "";
		String createdBy = "";
		String organisation = "";
		String orgDivision = "";
		for (RestDocumentManageAccessModel m : restAccessModel) {
			empName = m.getEmpName();
			docId = m.getDocument();
			createdBy = m.getCreatedBy();
			organisation = m.getOrganization();
			orgDivision = m.getOrgDivision();
		}
		s = s + "@p_empName='" + "Given access to "+empName + "',";
		s = s + "@p_docId='" + docId + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organisation='" + organisation + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
			for(RestDocumentManageAccessModel m : restAccessModel) {
				for (RestDocumentManageAccessModel ae : m.getAccessEmployee()) {
					System.out.println("ae"+ae);
					listdata = listdata + "(\""+ae.getEmployeeId() +"\","
						+ "\"" + m.getDocument() +"\",\"" + m.getAccessType()
						+ "\",\"" + m.getGroupId()+ "\",\"" +m.getReadStatus() +"\","
								+ "\"" + m.getWriteStatus() + "\",\""+ m.getDeleteStatus() + "\",\""+ m.getRemarks() + "\","
										+ "\""+ m.getCreatedBy() + "\",\""+ m.getOrganization() + "\",\""+ m.getOrgDivision() + "\",\""+m.getExpirationDate()+"\"),";
				}
				}
			listdata = listdata.substring(0, listdata.length() - 1);

			s = s + "@p_itemSubQuery='" + listdata + "',";
			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
			System.out.println("SSSSSSSSSSSSS"+s);
		
		return s;
	}
//	public static String modifyManageUserAccess(RestDocumentManageAccessModel restAccessModel) {
//		String s = "";
//		if(restAccessModel.getAccessId()!= null && restAccessModel.getAccessId()!= "") {
//			s = s + "@p_accessId='" + restAccessModel.getAccessId() + "',";
//		}
//		if(restAccessModel.getEmployeeId() != null && restAccessModel.getEmployeeId() != "") {
//			s = s + "@p_empId='" + restAccessModel.getEmployeeId() + "',";
//		}
//		if(restAccessModel.getDocument() != null && restAccessModel.getDocument()!= "") {
//			s = s + "@p_doc='" + restAccessModel.getDocument() + "',";
//		}
//		if(restAccessModel.getAccessType()!= null && restAccessModel.getAccessType() != "") {
//			s = s + "@p_accessType='" + restAccessModel.getAccessType() + "',";
//		}
//		if(restAccessModel.getGroupId()!= null && restAccessModel.getGroupId() != "") {
//			s = s + "@p_groupId='" + restAccessModel.getGroupId() + "',";
//		}
//		
//		if(restAccessModel.getReadStatus()!= null && restAccessModel.getReadStatus() != "") {
//			s = s + "@p_readStatus='" + restAccessModel.getReadStatus() + "',";
//		}
//		if(restAccessModel.getWriteStatus()!= null && restAccessModel.getWriteStatus()!= "") {
//			s = s + "@p_writeStatus='" + restAccessModel.getWriteStatus() + "',";
//		}
//		if(restAccessModel.getDeleteStatus()!= null && restAccessModel.getDeleteStatus()!= "") {
//			s = s + "@p_deleteStatus='" + restAccessModel.getDeleteStatus() + "',";
//		}
//		if(restAccessModel.getRemarks()!= null && restAccessModel.getRemarks()!= "") {
//			s = s + "@p_remarks='" + restAccessModel.getRemarks() + "',";
//		}
//		if (restAccessModel.getCreatedBy() != null && restAccessModel.getCreatedBy() != "") {
//			s = s + "@p_createdBy='" + restAccessModel.getCreatedBy() + "',";
//		}
//		if (restAccessModel.getOrganization() != null && restAccessModel.getOrganization() != "") {
//			s = s + "@p_organization='" + restAccessModel.getOrganization() + "',";
//		}
//		if (restAccessModel.getOrgDivision() != null && restAccessModel.getOrgDivision() != "") {
//			s = s + "@p_orgDivision='" + restAccessModel.getOrgDivision() + "',";
//		}
//		if (s != "") {
//			s = s.substring(0, s.length() - 1);
//
//			s = "SET " + s + ";";
//		}
//		System.out.println("restAccessModelGP======="+s);
//		return s;
//		
//	}
	
	public static String modifyManageUserAccess(List<RestDocumentManageAccessModel> restAccessModel) {
		System.out.println("restAccessModel"+restAccessModel);
		String s = "";
		String listdata = "";
		String empName = "";
		String docId = "";
		String createdBy = "";
		String organisation = "";
		String orgDivision = "";
		for (RestDocumentManageAccessModel m : restAccessModel) {
			empName = m.getEmpName();
			docId = m.getDocument();
			createdBy = m.getCreatedBy();
			organisation = m.getOrganization();
			orgDivision = m.getOrgDivision();
		}
		String deselcetUser = restAccessModel.get(0).getUserDeselect().stream()
	            .map(RestDocumentManageAccessModel::getEmployeeId)
	            .collect(Collectors.joining("\",\"", "(\"", "\")"));
		s = s + "@p_empName='" + "Given access Modified "+empName + "',";
		s = s + "@p_docId='" + docId + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organisation='" + organisation + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_deselcetUser='" + deselcetUser + "',";
			for(RestDocumentManageAccessModel m : restAccessModel) {
				for (RestDocumentManageAccessModel ae : m.getNewUsers()) {
					System.out.println("ae"+ae);
					listdata = listdata + "(\""+ae.getEmployeeId() +"\","
						+ "\"" + m.getDocument() +"\",\"" + m.getAccessType()
						+ "\",\"" + m.getGroupId()+ "\",\"" +m.getReadStatus() +"\","
								+ "\"" + m.getWriteStatus() + "\",\""+ m.getDeleteStatus() + "\",\""+ m.getRemarks() + "\","
										+ "\""+ m.getCreatedBy() + "\",\""+ m.getOrganization() + "\",\""+ m.getOrgDivision() + "\",\""+m.getExpirationDate()+"\"),";
				}
				}
			System.out.println("listdata"+listdata);
			listdata = listdata.substring(0, listdata.length() - 1);
			
			

			s = s + "@p_itemSubQuery='" + listdata + "',";
			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
			System.out.println("SSSSSSSSSSSSS"+s);
		
		return s;
	}

}
