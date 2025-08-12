package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.TravelRequisitionRestModel;
import nirmalya.aatithya.restmodule.employee.model.TravelServiceRestModel;

public class GenerateTravelManagementParam {

	public static String getTravelRequisitionParam(TravelRequisitionRestModel travelModel) {

		String s = "";
		String sitem = "";

		if (travelModel.getTravelingReqId() != null || travelModel.getTravelingReqId() != "") {
			s = s + "@p_travelId='" + travelModel.getTravelingReqId() + "',";
		}
		
		
		if (travelModel.getPlaceName() != null || travelModel.getPlaceName() != "") {
			s = s + "@p_placeName='" + travelModel.getPlaceName() + "',";
		}
		
		if (travelModel.getPurpose() != null || travelModel.getPurpose() != "") {
			s = s + "@p_purposeName='" + travelModel.getPurpose() + "',";
		}
		
		if (travelModel.getAdvanceReq() != null || travelModel.getAdvanceReq() != "") {
			/*
			 * s = s + "@p_advanceRequi=0,"; }else {
			 */
			s = s + "@p_advanceRequi='" + travelModel.getAdvanceReq() + "',";
		}
		
		if (travelModel.getAdvanceAmount() != null) {
			s = s + "@p_advanceAmount='" + travelModel.getAdvanceAmount() + "',";
		}

		if (travelModel.getFromDate() != null || travelModel.getFromDate() != "") {
			s = s + "@p_fromdate='" + DateFormatter.getStringDate(travelModel.getFromDate()) + "',";
		}
		
		if (travelModel.getToDate() != null || travelModel.getToDate() != "") {
			s = s + "@p_todate='" +DateFormatter.getStringDate(travelModel.getToDate())+ "',";
		}
		
		if (travelModel.getCreatedBy() != null || travelModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + travelModel.getCreatedBy() + "',";
		}

		if(travelModel.getOrganization() != null || travelModel.getOrganization() != "") {
			s = s + "@p_org='" + travelModel.getOrganization() + "',";
		}
		if(travelModel.getOrgDivision() != null || travelModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + travelModel.getOrgDivision() + "',";
		}
		
		
		if(travelModel.getEmpName() != null || travelModel.getEmpName() != "") {
			s = s + "@p_empName='" + travelModel.getEmpName() + "',";
		}
		if(travelModel.getEmpId() != null || travelModel.getEmpId() != "") {
			s = s + "@p_empId='" + travelModel.getEmpId() + "',";
		}
		if(travelModel.getDesignation() != null || travelModel.getDesignation() != "") {
			s = s + "@p_desig='" + travelModel.getDesignation() + "',";
		}
		if(travelModel.getTravelFrom() != null || travelModel.getTravelFrom() != "") {
			s = s + "@p_travelFrom='" + travelModel.getTravelFrom() + "',";
		}
		if(travelModel.getRemark().replace("'", "\\'") != null || travelModel.getRemark().replace("'", "\\'") != "") {
			s = s + "@p_remark='" + travelModel.getRemark().replace("'", "\\'") + "',";
		}


		System.out.println(travelModel.getServicedtls());
		if(travelModel.getServicedtls().size()>0) {
			for (TravelServiceRestModel m : travelModel.getServicedtls()) {

				sitem = sitem + "(@p_travelId,\"" + m.getServiceId() + "\",\"" +DateFormatter.getStringDate(m.getDate()) + "\",\"" + m.getTime() + "\",\"" + m.getDescription().replace("'", "\\'").replace("\"", "\\\\\"")+ "\",\"" +travelModel.getOrganization() +"\",\"" +travelModel.getOrgDivision() +"\",\""+DateFormatter.getStringDate(m.getTodate())+"\",\""+m.getTotime()+"\"),";
			
			}
			sitem = sitem.substring(0, sitem.length() - 1);
			s = s + "@p_itemSubQuery='" + sitem + "',"; 
		}
		
		
		//s = s + "@p_serviceId='" + travelModel.get(0).getServiceId() +"',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+s);

		return s;
	}
	
	// delete schedule param
	
	public static String getDeleteParam(TravelRequisitionRestModel resttravelModel) {
		String[] travelIds = resttravelModel.getTravelingReqId().split(",");
		String s = "";
		String sitem = "";
		/* String act = ""; */ 
		for (String a : travelIds) {
			sitem = sitem + "\"" + a + "\",";
		}
		sitem = sitem.substring(0, sitem.length() - 1);
		sitem = "(" + sitem + ")";
		s = s + "@p_reqIds='" + sitem + "',";

		
		  /*for (String a : userIds) {
		  
		  act = act + "(\"" + resttravelModel.getModuleId() + "\",\"" +
		  resttravelModel.getComponentId() + "\",\"" +
		  resttravelModel.getSubComponentId() + "\",\"" + a + "\",\"" +
		  "Delete Requisition" + "\",\"" + resttravelModel.getCreatedBy() + "\"),";
		  
		  }*/
		 
		/*
		 * act = act.substring(0, act.length() - 1);
		 * 
		 * s = s + "@p_actSubQuery='" + act + "',";
		 */
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		System.out.println("generated"+sitem);

		return s;
	}

}
