package nirmalya.aatithya.restmodule.common.utils.his;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.his.model.HISOTReservationRestModel;
import nirmalya.aatithya.restmodule.user.model.UserAccessModel;

public class GenerateOTReserveParameters {

	public static String getOtReserveParam(HISOTReservationRestModel restMasterData) {

		String s = "";

		if (restMasterData.getOtReserveId() != null || restMasterData.getOtReserveId() != "") {
			s = s + "@p_reserveId='" + restMasterData.getOtReserveId() + "',";
		}
		if (restMasterData.getIpdId() != null || restMasterData.getIpdId() != "") {
			s = s + "@p_ipdId='" + restMasterData.getIpdId() + "',";
		}
		if (restMasterData.getPatientId() != null || restMasterData.getPatientId() != "") {
			s = s + "@p_patientId='" + restMasterData.getPatientId() + "',";
		}
		if (restMasterData.getDateOfOpe() != null || restMasterData.getDateOfOpe() != "") {
			s = s + "@p_dOpen='" + restMasterData.getDateOfOpe() + "',";
		}
		if (restMasterData.getDuration() != null || restMasterData.getDuration() != "") {
			s = s + "@p_duration='" + restMasterData.getDuration() + "',";
		}
		if (restMasterData.getGroup() != null || restMasterData.getGroup() != "") {
			s = s + "@p_group='" + restMasterData.getGroup() + "',";
		}
		if (restMasterData.getSubGroup() != null || restMasterData.getSubGroup() != "") {
			s = s + "@p_subGroup='" + restMasterData.getSubGroup() + "',";
		}
		if (restMasterData.getSurgery() != null || restMasterData.getSurgery() != "") {
			s = s + "@p_surgery='" + restMasterData.getSurgery() + "',";
		}
		if (restMasterData.getOtTable() != null || restMasterData.getOtTable() != "") {
			s = s + "@p_otTable='" + restMasterData.getOtTable() + "',";
		}

		if (restMasterData.getProcedure() != null || restMasterData.getProcedure() != "") {
			s = s + "@p_procedure='" + restMasterData.getProcedure() + "',";
		}
		if (restMasterData.getDepartment() != null || restMasterData.getDepartment() != "") {
			s = s + "@p_department='" + restMasterData.getDepartment() + "',";
		}

		if (restMasterData.getDoctor() != null || restMasterData.getDoctor() != "") {
			s = s + "@p_doctor='" + restMasterData.getDoctor() + "',";
		}

		if (restMasterData.getInstruction() != null || restMasterData.getInstruction() != "") {
			s = s + "@p_instruction='" + restMasterData.getInstruction() + "',";
		}

		if (restMasterData.getOrgName() != null || restMasterData.getOrgName() != "") {
			s = s + "@p_orgName='" + restMasterData.getOrgName() + "',";
		}

		if (restMasterData.getOrgDiv() != null || restMasterData.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + restMasterData.getOrgDiv() + "',";
		}
		if (restMasterData.getCreatedBy() != null || restMasterData.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restMasterData.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String saveOtReserve(HISOTReservationRestModel id) {
		String s = "";
		String data = "";

		if (id.getOtReserveId() != null || id.getOtReserveId() != "") {
			s = s + "@p_reserveId='" + id.getOtReserveId() + "',";
		}
		if (id.getIpdId() != null || id.getIpdId() != "") {
			s = s + "@p_ipdId='" + id.getIpdId() + "',";
		}
		if (id.getPatientId() != null || id.getPatientId() != "") {
			s = s + "@p_patientId='" + id.getPatientId() + "',";
		}
		if (id.getDateOfOpe() != null || id.getDateOfOpe() != "") {
			s = s + "@p_dOpen='" + id.getDateOfOpe() + "',";
		}
		if (id.getDuration() != null || id.getDuration() != "") {
			s = s + "@p_duration='" + id.getDuration() + "',";
		}
		if (id.getGroup() != null || id.getGroup() != "") {
			s = s + "@p_group='" + id.getGroup() + "',";
		}
		if (id.getSubGroup() != null || id.getSubGroup() != "") {
			s = s + "@p_subGroup='" + id.getSubGroup() + "',";
		}
		if (id.getSurgery() != null || id.getSurgery() != "") {
			s = s + "@p_surgery='" + id.getSurgery() + "',";
		}
		if (id.getOtTable() != null || id.getOtTable() != "") {
			s = s + "@p_otTable='" + id.getOtTable() + "',";
		}

		if (id.getProcedure() != null || id.getProcedure() != "") {
			s = s + "@p_procedure='" + id.getProcedure() + "',";
		}
		if (id.getDepartment() != null || id.getDepartment() != "") {
			s = s + "@p_department='" + id.getDepartment() + "',";
		}

		if (id.getDoctor() != null || id.getDoctor() != "") {
			s = s + "@p_doctor='" + id.getDoctor() + "',";
		}

		if (id.getInstruction() != null || id.getInstruction() != "") {
			s = s + "@p_instruction='" + id.getInstruction() + "',";
		}

		if (id.getOrgName() != null || id.getOrgName() != "") {
			s = s + "@p_orgName='" + id.getOrgName() + "',";
		}

		if (id.getOrgDiv() != null || id.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + id.getOrgDiv() + "',";
		}
		if (id.getCreatedBy() != null || id.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + id.getCreatedBy() + "',";
		}

		if (id.getRoleList().size() > 0) {
			for (String m : id.getRoleList()) {
				data = data + "(@p_reserveId,\"" + m + "\"),";
			}

			data = data.substring(0, data.length() - 1);
		}
		s = s + "@p_userRoleList='" + data + "';";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
	
public static String geOTIdList(List<DropDownModel> id) {
		
		String s = "";
		String a = "";
		String section = "";
		
		if(id.get(0).getName()!=null && id.get(0).getName()!="") {
			s = s + "@P_ModifiedBy='" + id.get(0).getName() + "',";
		}
		
		if(id.size() > 0) {
			for(DropDownModel m : id) {
				section = section + "\"" + m.getKey() + "\",";
			}
			
			section = section.substring(0, section.length() - 1);
		} else {
			s = s.substring(0, s.length() - 1);
		}
		
		a = "(" + section + ")";
		
		s = s + "@p_userListSubQuery='" + a + "';";
		
		s = "SET " + s ;
		
		System.out.println(s);
		
		return s;
	}

}
