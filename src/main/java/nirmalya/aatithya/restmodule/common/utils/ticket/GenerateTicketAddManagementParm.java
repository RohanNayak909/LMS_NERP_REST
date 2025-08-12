package nirmalya.aatithya.restmodule.common.utils.ticket;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.maintenance.model.AllotedMaintenanceRestModel;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;
import nirmalya.aatithya.restmodule.ticket.model.TicketRestDocumentManagementModel;

public class GenerateTicketAddManagementParm {

	public static String saveTicketDetails(List<TicketManagementRestModel> category) {

		String s = "";

		if (category.get(0).getTicketId() != null && category.get(0).getTicketId() != "") {
			s = s + "@p_ticketId='" + category.get(0).getTicketId() + "',";
		} else {
			s = s + "@p_ticketId='" + "" + "',";
		}
		if (category.get(0).getEmpId() != null && category.get(0).getEmpId() != "") {
			s = s + "@p_empId='" + category.get(0).getEmpId() + "',";
		} else {
			s = s + "@p_empId='" + "" + "',";
		}
		if (category.get(0).getDate() != null && category.get(0).getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(category.get(0).getDate()) + "',";
		} else {
			s = s + "@p_date='" + "" + "',";
		}
		if (category.get(0).getEmpName() != null && category.get(0).getEmpName() != "") {
			s = s + "@p_empName='" + category.get(0).getEmpName() + "',";
		} else {
			s = s + "@p_empName='" + "" + "',";
		}
		if (category.get(0).getDept() != null && category.get(0).getDept() != "") {
			s = s + "@p_dept='" + category.get(0).getDept() + "',";
		} else {
			s = s + "@p_dept='" + "" + "',";
		}
		if (category.get(0).getTicketType() != null && category.get(0).getTicketType() != "") {
			s = s + "@p_tktType='" + category.get(0).getTicketType() + "',";
		} else {
			s = s + "@p_tktType='" + "" + "',";
		}
		if (category.get(0).getTicketCategory() != null && category.get(0).getTicketCategory() != "") {
			s = s + "@p_tktCatagory='" + category.get(0).getTicketCategory() + "',";
		} else {
			s = s + "@p_tktCatagory='" + "" + "',";
		}
		if (category.get(0).getTicketSubCategory() != null && category.get(0).getTicketSubCategory() != "") {
			s = s + "@p_tktSubCatagory='" + category.get(0).getTicketSubCategory() + "',";
		} else {
			s = s + "@p_tktSubCatagory='" + "" + "',";
		}
		if (category.get(0).getAssetList() != null && category.get(0).getAssetList() != "") {
			s = s + "@p_assetList='" + category.get(0).getAssetList() + "',";
		} else {
			s = s + "@p_assetList='" + "" + "',";
		}
		if (category.get(0).getTicketPriority() != null && category.get(0).getTicketPriority() != "") {
			s = s + "@p_tktPriority='" + category.get(0).getTicketPriority() + "',";
		} else {
			s = s + "@p_tktPriority='" + "" + "',";
		}
		if (category.get(0).getDescription() != null && category.get(0).getDescription() != "") {
			s = s + "@p_tktDesc=\"" + category.get(0).getDescription() + "\",";
		} else {
			s = s + "@p_tktDesc=\"" + "" + "\",";
		}
		if (category.get(0).getLocType() != null && category.get(0).getLocType() != "") {
			s = s + "@p_locType='" + category.get(0).getLocType() + "',";
		} else {
			s = s + "@p_locType='" + "" + "',";
		}
		if (category.get(0).getLatitude() != null && category.get(0).getLatitude() != "") {
			s = s + "@p_latitude='" + category.get(0).getLatitude() + "',";
		} else {
			s = s + "@p_latitude='" + "" + "',";
		}
		if (category.get(0).getLongitude() != null && category.get(0).getLongitude() != "") {
			s = s + "@p_longitude='" + category.get(0).getLongitude() + "',";
		} else {
			s = s + "@p_longitude='" + "" + "',";
		}
		if (category.get(0).getAddress() != null && category.get(0).getAddress() != "") {
			s = s + "@p_address='" + category.get(0).getAddress() + "',";
		} else {
			s = s + "@p_address='" + "" + "',";
		}
		if (category.get(0).getEmpAddress() != null && category.get(0).getEmpAddress() != "") {
			s = s + "@p_empAddress='" + category.get(0).getEmpAddress() + "',";
		} else {
			s = s + "@p_empAddress='" + "" + "',";
		}
		if (category.get(0).getTicketSource() != null && category.get(0).getTicketSource() != "") {
			s = s + "@p_ticketSource='" + category.get(0).getTicketSource() + "',";
		} else {
			s = s + "@p_ticketSource='" + "" + "',";
		}
		if (category.get(0).getCreatedBy() != null && category.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.get(0).getCreatedBy() + "',";
		} else {
			s = s + "@p_createdBy='" + "" + "',";
		}
		if (category.get(0).getOrganization() != null && category.get(0).getOrganization() != "") {
			s = s + "@p_organization='" + category.get(0).getOrganization() + "',";
		} else {
			s = s + "@p_organization='" + "" + "',";
		}
		if (category.get(0).getOrgDivision() != null && category.get(0).getOrgDivision() != "") {
			s = s + "@p_orgdivision='" + category.get(0).getOrgDivision() + "',";
		} else {
			s = s + "@p_orgdivision='" + "" + "',";
		}
		
		if (category.get(0).getActionTaken() != null && category.get(0).getActionTaken() != "") {
			s = s + "@p_actionTaken='" + category.get(0).getActionTaken() + "',";
		} else {
			s = s + "@p_actionTaken='" + "" + "',";
		}
		if (category.get(0).getAssignTo() != null && category.get(0).getAssignTo() != "") {
			s = s + "@p_assignTo='" + category.get(0).getAssignTo() + "',";
		} else {
			s = s + "@p_assignTo='" + "" + "',";
		}
		if (category.get(0).getCurrentTime() != null && category.get(0).getCurrentTime() != "") {
			s = s + "@p_time='" + category.get(0).getCurrentTime() + "',";
		} else {
			s = s + "@p_time='" + "" + "',";
		}


		String document = "";
		for (TicketRestDocumentManagementModel a : category.get(0).getDocumentList()) {
			document = document + "(@p_ticketId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() + "\",\""
					+ a.getDocumentURL() + "\",@p_createdBy,@p_organization,@p_orgdivision),";
		}
		if (!document.isEmpty()) {
			document = document.substring(0, document.length() - 1);
			s = s + "@p_tktDocuments='" + document + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println("data is coming for save =======================>"+s);
		}

		return s;
		
	}

	// add agent details
	public static String saveAgentDetails(TicketManagementRestModel category) {

		String s = "";

		if (category.getTicketId() != null && category.getTicketId() != "") {
			s = s + "@p_ticketId='" + category.getTicketId() + "',";
		} else {
			s = s + "@p_ticketId='',";
		}
		if (category.getEmpId() != null && category.getEmpId() != "") {
			s = s + "@p_empId='" + category.getEmpId() + "',";
		} else {
			s = s + "@p_empId='',";
		}
		if (category.getDate() != null && category.getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(category.getDate()) + "',";
		} else {
			s = s + "@p_date='',";
		}
		if (category.getTime() != null && category.getTime() != "") {
			s = s + "@p_time='" + category.getTime() + "',";
		} else {
			s = s + "@p_time='',";
		}

		if (category.getAssignType() != null && category.getAssignType() != "") {
			s = s + "@p_assignType='" + category.getAssignType() + "',";
		} else {
			s = s + "@p_assignType='',";
		}
		if (category.getDept() != null && category.getDept() != "") {
			s = s + "@p_dept='" + category.getDept() + "',";
		} else {
			s = s + "@p_dept='',";
		}
		if (category.getTicketPriority() != null && category.getTicketPriority() != "") {
			s = s + "@p_tktPriority='" + category.getTicketPriority() + "',";
		} else {
			s = s + "@p_tktPriority='',";
		}
		if (category.getCreatedBy() != null && category.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.getCreatedBy() + "',";
		} else {
			s = s + "@p_createdBy='',";
		}
		if (category.getOrganization() != null && category.getOrganization() != "") {
			s = s + "@p_organization='" + category.getOrganization() + "',";
		} else {
			s = s + "@p_organization='',";
		}
		if (category.getOrgDivision() != null && category.getOrgDivision() != "") {
			s = s + "@p_orgdivision='" + category.getOrgDivision() + "',";
		} else {
			s = s + "@p_orgdivision='',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	// Add action details
	public static String saveAgentActionDetails(TicketManagementRestModel category) {

		String s = "";

		if (category.getTicketId() != null && category.getTicketId() != "") {
			s = s + "@p_ticketId='" + category.getTicketId() + "',";
		} else {
			s = s + "@p_ticketId='" + "" + "',";
		}
		if (category.getEmpId() != null && category.getEmpId() != "") {
			s = s + "@p_empId='" + category.getEmpId() + "',";
		} else {
			s = s + "@p_empId='" + "" + "',";
		}
		if (category.getDate() != null && category.getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(category.getDate()) + "',";
		} else {
			s = s + "@p_date='" + "" + "',";
		}
		if (category.getTime() != null && category.getTime() != "") {
			s = s + "@p_time='" + category.getTime() + "',";
		} else {
			s = s + "@p_time='" + "" + "',";
		}
		if (category.getDept() != null && category.getDept() != "") {
			s = s + "@p_dept='" + category.getDept() + "',";
		} else {
			s = s + "@p_dept='" + "" + "',";
		}
		if (category.getTicketPriority() != null && category.getTicketPriority() != "") {
			s = s + "@p_tktPriority='" + category.getTicketPriority() + "',";
		} else {
			s = s + "@p_tktPriority='" + "" + "',";
		}
		if (category.getCreatedBy() != null && category.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.getCreatedBy() + "',";
		} else {
			s = s + "@p_createdBy='" + "" + "',";
		}
		if (category.getOrganization() != null && category.getOrganization() != "") {
			s = s + "@p_organization='" + category.getOrganization() + "',";
		} else {
			s = s + "@p_organization='" + "" + "',";
		}
		if (category.getOrgDivision() != null && category.getOrgDivision() != "") {
			s = s + "@p_orgdivision='" + category.getOrgDivision() + "',";
		} else {
			s = s + "@p_orgdivision='" + "" + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String saveResultStatus(TicketManagementRestModel category) {

		String s = "";

		JSONArray jsonArray = new JSONArray();
		for (TicketRestDocumentManagementModel a : category.getDocumentList()) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("documentName", a.getDocumnentName());
			jsonObject.put("fileName", a.getFileName());
			jsonArray.put(jsonObject);
		}
		String documentList = "";
		String equipementParam = "";
		if (category.getTicketId() != null && category.getTicketId() != "")

		{
			s = s + "@p_ticketId='" + category.getTicketId() + "',";
		} else {
			s = s + "@p_ticketId='',";
		}
		if (category.getStatus() != null && category.getStatus() != "") {
			s = s + "@p_resultStatus='" + category.getStatus() + "',";
		} else {
			s = s + "@p_resultStatus='',";
		}
		if (category.getAssignType() != null && category.getAssignType() != "") {
			s = s + "@p_assignType='" + category.getAssignType() + "',";
		} else {
			s = s + "@p_assignType='',";
		}
		if (category.getAssignTypeId() != null && category.getAssignTypeId() != "") {
			s = s + "@p_assignTypeId='" + category.getAssignTypeId() + "',";
		} else {
			s = s + "@p_assignTypeId='',";
		}
		if (category.getResultDescription() != null && category.getResultDescription() != "") {
			s = s + "@p_resultDesc=\"" + category.getResultDescription() + "\",";
		} else {
			s = s + "@p_resultDesc=\"" + "" + "\",";
		}
		if (category.getAssignId() != null && category.getAssignId() != "") {
			s = s + "@p_assignId=\"" + category.getAssignId() + "\",";
		} else {
			s = s + "@p_assignId=\"" + "" + "\",";
		}
		if (category.getCreatedBy() != null && category.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.getCreatedBy() + "',";
		} else {
			s = s + "@p_createdBy='',";
		}
		if (category.getOrganization() != null && category.getOrganization() != "") {
			s = s + "@p_organization='" + category.getOrganization() + "',";
		} else {
			s = s + "@p_organization='',";
		}
		if (category.getOrgDivision() != null && category.getOrgDivision() != "") {
			s = s + "@p_orgdivision='" + category.getOrgDivision() + "',";
		} else {
			s = s + "@p_orgdivision='',";
		}
		if (category.getActualDate() != null && category.getActualDate() != "") {
			s = s + "@p_actDate='" + category.getActualDate() + "',";
		} else {
			s = s + "@p_actDate='',";
		}
		if (category.getActualTime() != null && category.getActualTime() != "") {
			s = s + "@p_actTime='" + category.getActualTime() + "',";
		} else {
			s = s + "@p_actTime='',";
		}
		if (category.getActualCost() != null && category.getActualCost() != "") {
			s = s + "@p_actCost='" + category.getActualCost() + "',";
		} else {
			s = s + "@p_actCost='',";
		}

		String document = "";
		for (AllotedMaintenanceRestModel a : category.getEquipementList()) {
			equipementParam = equipementParam + "(@p_requestId,\"" + category.getTicketId() + "\",\""
					+ a.getEquipementCatId() + "\",\"" + a.getEquipementScatId() + "\",\"" + a.getEquipementQty() + "\",\"" + a.getDescription() + "\",@p_createdBy,@p_organization,@p_orgdivision),";
		}
		
		for (TicketRestDocumentManagementModel a : category.getDocumentList()) {
			if(a.getFileName()!=null && a.getFileName()!="" && a.getFileName()!="null") {
				document = document + "(@p_ticketassignId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() + "\",\""
						+ a.getDocumentURL() + "\",@p_createdBy,@p_organization,@p_orgdivision),";
			}
		}
		
		if (!document.isEmpty()) {
			document = document.substring(0, document.length() - 1);
			s = s + "@p_tktDocuments='" + document + "',";
		}else{
			s = s + "@p_tktDocuments='',";
		}
		if (!equipementParam.isEmpty()) {
			equipementParam = equipementParam.substring(0, equipementParam.length() - 1);
			s = s + "@p_equipe='" + equipementParam + "',";
		}else {
			s = s + "@p_equipe='',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println("ASSETTTTTTTTTTTTTTTTTTTT"+s);
		}
		
		return s;
	}
	
	public static String saveTicketChatDetails(List<TicketManagementRestModel> category) {

		String s = "";

		if (category.get(0).getTicketId() != null && category.get(0).getTicketId() != "") {
			s = s + "@p_ticketId='" + category.get(0).getTicketId() + "',";
		} else {
			s = s + "@p_ticketId='',";
		}
		if (category.get(0).getResultDescription() != null && category.get(0).getResultDescription() != "") {
			s = s + "@p_desc='" + category.get(0).getResultDescription() + "',";
		} else {
			s = s + "@p_desc='',";
		}
		if (category.get(0).getTicketType() != null && category.get(0).getTicketType() != "") {
			s = s + "@p_type='" + category.get(0).getTicketType() + "',";
		} else {
			s = s + "@p_type='',";
		}
		if (category.get(0).getCreatedBy() != null && category.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.get(0).getCreatedBy() + "',";
		} else {
			s = s + "@p_createdBy='',";
		}
		if (category.get(0).getOrganization() != null && category.get(0).getOrganization() != "") {
			s = s + "@p_organization='" + category.get(0).getOrganization() + "',";
		} else {
			s = s + "@p_organization='',";
		}
		if (category.get(0).getOrgDivision() != null && category.get(0).getOrgDivision() != "") {
			s = s + "@p_orgdivision='" + category.get(0).getOrgDivision() + "',";
		} else {
			s = s + "@p_orgdivision='',";
		}


		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
}
