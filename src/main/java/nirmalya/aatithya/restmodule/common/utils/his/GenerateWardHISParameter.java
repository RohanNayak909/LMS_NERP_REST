package nirmalya.aatithya.restmodule.common.utils.his;

import nirmalya.aatithya.restmodule.his.model.RestHISWardModel;

public class GenerateWardHISParameter {

	public static String addWardParam(RestHISWardModel restHISWardModel) {

		String s = "";

		if (restHISWardModel.getWardId() != null || restHISWardModel.getWardId() != "") {
			s = s + "@p_wardId='" + restHISWardModel.getWardId() + "',";
		}

		if (restHISWardModel.getWardName() != null || restHISWardModel.getWardName() != "") {
			s = s + "@p_wardName='" + restHISWardModel.getWardName() + "',";
		}

		if (restHISWardModel.getFloor() != null || restHISWardModel.getFloor() != "") {
			s = s + "@p_floor='" + restHISWardModel.getFloor() + "',";
		}
		if (restHISWardModel.getDepartment() != null || restHISWardModel.getDepartment() != "") {
			s = s + "@p_department='" + restHISWardModel.getDepartment() + "',";
		}

		if (restHISWardModel.getDescription() != null || restHISWardModel.getDescription() != "") {
			s = s + "@p_description='" + restHISWardModel.getDescription() + "',";
		}
		if (restHISWardModel.getWardStatus() != null || restHISWardModel.getWardStatus() != "") {
			s = s + "@p_status='" + restHISWardModel.getWardStatus() + "',";
		}

		if (restHISWardModel.getCreatedBy() != null && restHISWardModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restHISWardModel.getCreatedBy() + "',";
		}

		if (restHISWardModel.getOrganization() != null && restHISWardModel.getOrganization() != "") {
			s = s + "@p_org='" + restHISWardModel.getOrganization() + "',";
		}
		if (restHISWardModel.getOrgDivision() != null && restHISWardModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restHISWardModel.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("inParameter-------------" + s);
		return s;

	}
}
