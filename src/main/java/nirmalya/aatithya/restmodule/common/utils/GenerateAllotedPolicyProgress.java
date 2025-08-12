package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.asset.model.AssetDocumentRestModel;
import nirmalya.aatithya.restmodule.maintenance.model.AllotedMaintenanceRestModel;


public class GenerateAllotedPolicyProgress {
	@SuppressWarnings("unused")
	public static String getPolicyProgressList(List<AllotedMaintenanceRestModel> av) {
		String s = "";
		String sitem = "";
		String slno = "(";
		String equipementParam = "";

		if (av.get(0).getTicketid() != null || av.get(0).getTicketid() != "") {
			s = s + "@p_ticketid='" + av.get(0).getTicketid() + "',";
		}
		if (av.get(0).getAllocid() != null || av.get(0).getAllocid() != "") {
			s = s + "@p_allocid='" + av.get(0).getAllocid() + "',";
		}
		if (av.get(0).getAllocationid() != null || av.get(0).getAllocationid() != "") {
			s = s + "@p_allocationid='" + av.get(0).getAllocationid() + "',";
		}
		if (av.get(0).getCreatedBy() != null || av.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + av.get(0).getCreatedBy() + "',";
		}
		if (av.get(0).getOrganization() != null || av.get(0).getOrganization() != "") {
			s = s + "@p_org='" + av.get(0).getOrganization() + "',";
		}
		if (av.get(0).getOrgDivision() != null || av.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + av.get(0).getOrgDivision() + "',";
		}
		
		/*
		 * for (AllotedMaintenanceRestModel a : av.get(0).getEquipementList()) {
		 * equipementParam = equipementParam + "(@p_requestId,\"" +
		 * av.get(0).getTicketid() + "\",\"" + a.getEquipementCatagory1() + "\",\"" +
		 * a.getEquipementScatagory1() + "\",\"" + a.getEquipementQty() + "\",\"" +
		 * a.getDescription() + "\",@p_createdBy,@p_org,@p_orgDiv),"; }
		 */

		for (AllotedMaintenanceRestModel m : av) {

			sitem = sitem + "(@p_allocationid,\"" + m.getPolicyid() + "\",\"" + m.getPolicyName() + "\",\"" + m.getPriority() + "\",\"" + m.getStatus() + "\",\"" + m.getDescription()+ "\",\"" + m.getCreatedBy()  + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
			+ "\",\""+ m.getTasktype()+ "\",\""+ m.getUom()+ "\",\""+ m.getMinrange()+ "\",\""+ m.getMaxrange()+ "\",\""+ m.getResult()+ "\",\""+ m.getAssignid()+ "\",\""+ m.getOccurancenop()+ "\",\""+ m.getOccurancestarts()+ "\",\""+ m.getOccuranceends()+ "\",\""+ m.getReviewSts()+ "\",\""+ m.getRemark()+ "\",\"COMPLETED\",\""+m.getAssignedDate()+"\",\""+m.getTicketid()+"\",\""+m.getShift()+"\",\""+m.getOccurancedate()+"\"),";
			
			slno=slno+m.getSlno()+",";
		}
		sitem = sitem.substring(0, sitem.length() - 1);
		slno = slno.substring(0, slno.length() - 1)+")";
		
		if (equipementParam == null || equipementParam.equals("")) {
			equipementParam="";
		}else {
			equipementParam = equipementParam.substring(0, equipementParam.length() - 1);
		}
		

		s = s + "@p_itemSubQuery='" + sitem+ "',@p_Equipe='" + equipementParam + "',@p_Slno='" + slno+ "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("GENERATE PARAM"+s);
		return s;
	}

}
