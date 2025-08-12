package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.ScheduleManagementModel;

public class GenerateScheduleManagementParam {
  
	/**
	 * add parameter set for schedule management
	 *
	 **/
	public static String getScheduleRequisitionParam(List<ScheduleManagementModel> scheduleModel) {

		String s = "";
		String sitem = "";

		if (scheduleModel.get(0).getShiftScheduleId() != null || scheduleModel.get(0).getShiftScheduleId() != "") {
			s = s + "@p_shiftScheduleId='" + scheduleModel.get(0).getShiftScheduleId() + "',";
		}
		
		if (scheduleModel.get(0).getEmpId() != null || scheduleModel.get(0).getEmpId() != "") {
			s = s + "@p_firstName='" + scheduleModel.get(0).getEmpId() + "',";
		}

		if (scheduleModel.get(0).getFromDate() != null || scheduleModel.get(0).getFromDate() != "") {
			s = s + "@p_fromdate='" + scheduleModel.get(0).getFromDate() + "',";
		}

		if (scheduleModel.get(0).getScheduleId() != null || scheduleModel.get(0).getScheduleId() != "") {
			s = s + "@p_schedule='" + scheduleModel.get(0).getScheduleId() + "',";
		}
		if (scheduleModel.get(0).getSectionId() != null || scheduleModel.get(0).getSectionId() != "") {
			s = s + "@p_section='" + scheduleModel.get(0).getSectionId() + "',";
		}

		if (scheduleModel.get(0).getToDate() != null || scheduleModel.get(0).getToDate() != "") {
			s = s + "@p_todate='" + scheduleModel.get(0).getToDate() + "',";
		}

		if (scheduleModel.get(0).getDepartmantId() != null || scheduleModel.get(0).getDepartmantId() != "") {
			s = s + "@p_departmant='" + scheduleModel.get(0).getDepartmantId() + "',";
		}

		if (scheduleModel.get(0).getCreatedBy() != null || scheduleModel.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + scheduleModel.get(0).getCreatedBy() + "',";
		}
		if(scheduleModel.get(0).getOrganization() != null || scheduleModel.get(0).getOrganization() != "") {
			s = s + "@p_org='" + scheduleModel.get(0).getOrganization() + "',";
		}
		if(scheduleModel.get(0).getOrgDivision() != null || scheduleModel.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + scheduleModel.get(0).getOrgDivision() + "',";
		}


		for (ScheduleManagementModel m : scheduleModel) {

			sitem = sitem + "(@p_shiftScheduleId,\"" + m.getShiftId() + "\",\"" + m.getEmpId() + "\",\"" + m.getRemark() + "\"),";
		
		}
		
		s = s + "@p_shiftId='" + scheduleModel.get(0).getShiftId() +"',";
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
	
	// delete schedule param
	
	public static String getDeleteParam(ScheduleManagementModel restScheduleModel) {
		String[] shiftIds = restScheduleModel.getShiftScheduleId().split(",");
		String s = "";
		String sitem = "";
		/* String act = ""; */
		for (String a : shiftIds) {
			sitem = sitem + "\"" + a + "\",";
		}
		sitem = sitem.substring(0, sitem.length() - 1);
		sitem = "(" + sitem + ")";
		s = s + "@p_reqIds='" + sitem + "',";

		
		  /*for (String a : userIds) {
		  
		  act = act + "(\"" + restScheduleModel.getModuleId() + "\",\"" +
		  restScheduleModel.getComponentId() + "\",\"" +
		  restScheduleModel.getSubComponentId() + "\",\"" + a + "\",\"" +
		  "Delete Requisition" + "\",\"" + restScheduleModel.getCreatedBy() + "\"),";
		  
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
