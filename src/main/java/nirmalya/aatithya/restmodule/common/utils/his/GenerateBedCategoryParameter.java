package nirmalya.aatithya.restmodule.common.utils.his;

import nirmalya.aatithya.restmodule.his.model.RestHISConfigurationModel;

public class GenerateBedCategoryParameter {

	public static String getAddempParam(RestHISConfigurationModel employee) {

		String s = "";

		if (employee.getBedcat() != null || employee.getBedcat() != "") {
			s = s + "@p_bedcat='" + employee.getBedcat() + "',";
		}
		if (employee.getName4() != null || employee.getName4() != "") {
			s = s + "@p_name4='" + employee.getName4() + "',";
		}

		if (employee.getDescription4() != null || employee.getDescription4() != "") {
			s = s + "@p_description4='" + employee.getDescription4() + "',";
		}

		if (employee.getStatus4() != null || employee.getStatus4() != "") {
			s = s + "@p_status4='" + employee.getStatus4() + "',";
		}
		if (employee.getOrg4() != null || employee.getOrg4() != "") {
			s = s + "@p_orgName='" + employee.getOrg4() + "',";
		}
		if (employee.getDiv4() != null || employee.getDiv4() != "") {
			s = s + "@p_orgDiv='" + employee.getDiv4() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("--------" + s);
		return s;

	}

	public static String getAdddischarge(RestHISConfigurationModel restHISConfigurationModel) {

		String s = "";

		if (restHISConfigurationModel.getDistype() != null || restHISConfigurationModel.getDistype() != "") {
			s = s + "@p_Distype='" + restHISConfigurationModel.getDistype() + "',";
		}

		if (restHISConfigurationModel.getDisname() != null || restHISConfigurationModel.getDisname() != "") {
			s = s + "@p_DisName='" + restHISConfigurationModel.getDisname() + "',";
		}
		if (restHISConfigurationModel.getDisdescription() != null
				|| restHISConfigurationModel.getDisdescription() != "") {
			s = s + "@p_DisDescription='" + restHISConfigurationModel.getDisdescription() + "',";
		}

		if (restHISConfigurationModel.getDisstatus() != null || restHISConfigurationModel.getDisstatus() != "") {
			s = s + "@p_Disstatus='" + restHISConfigurationModel.getDisstatus() + "',";
		}

		if (restHISConfigurationModel.getOrg2() != null || restHISConfigurationModel.getOrg2() != "") {
			s = s + "@p_orgName2='" + restHISConfigurationModel.getOrg2() + "',";
		}
		if (restHISConfigurationModel.getDiv2() != null || restHISConfigurationModel.getDiv2() != "") {
			s = s + "@p_orgDiv2='" + restHISConfigurationModel.getDiv2() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("ssssssssssssssssssssssss" + s);
		return s;
	}

	
	
	public static String getDisDesParam(RestHISConfigurationModel discharge) {

		String s = "";

		if (discharge.getDisDes() != null || discharge.getDisDes() != "") {
			s = s + "@p_disDes='" + discharge.getDisDes() + "',";
		}
		if (discharge.getDesName() != null || discharge.getDesName() != "") {
			s = s + "@p_desName='" + discharge.getDesName() + "',";
		}

		if (discharge.getDesDescription() != null || discharge.getDesDescription() != "") {
			s = s + "@p_desDes='" + discharge.getDesDescription() + "',";
		}

		if (discharge.getDesSatus() != null || discharge.getDesSatus() != "") {
			s = s + "@p_desStatus='" + discharge.getDesSatus() + "',";
		}
		if (discharge.getOrg3() != null || discharge.getOrg3() != "") {
			s = s + "@p_orgName3='" + discharge.getOrg3() + "',";
		}
		if (discharge.getDiv3() != null || discharge.getDiv3() != "") {
			s = s + "@p_orgDiv3='" + discharge.getDiv3() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("--------" + s);
		return s;

	}
	
	
	public static String getConcessionParam(RestHISConfigurationModel concession) {

		String s = "";

		if (concession.getConCat() != null || concession.getConCat() != "") {
			s = s + "@p_concat='" + concession.getConCat() + "',";
		}
		if (concession.getConName() != null || concession.getConName() != "") {
			s = s + "@p_conName='" + concession.getConName() + "',";
		}

		if (concession.getConDescription() != null || concession.getConDescription() != "") {
			s = s + "@p_conDes='" + concession.getConDescription() + "',";
		}

		if (concession.getConStatus() != null || concession.getConStatus() != "") {
			s = s + "@p_conStatus='" + concession.getConStatus() + "',";
		}
		if (concession.getOrg1() != null || concession.getOrg1() != "") {
			s = s + "@p_orgName1='" + concession.getOrg1() + "',";
		}
		if (concession.getDiv1() != null || concession.getDiv1() != "") {
			s = s + "@p_orgDiv1='" + concession.getDiv1() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("--------" + s);
		return s;

	}
	
	public static String getPathologyParam(RestHISConfigurationModel pathology) {

		String s = "";

		if (pathology.getTestType() != null || pathology.getTestType() != "") {
			s = s + "@p_testType='" + pathology.getTestType() + "',";
		}
		if (pathology.getPathName() != null || pathology.getPathName() != "") {
			s = s + "@p_pathName='" + pathology.getPathName() + "',";
		}

		if (pathology.getPathDes() != null || pathology.getPathDes() != "") {
			s = s + "@p_pathDes='" + pathology.getPathDes() + "',";
		}

		if (pathology.getPathStatus() != null || pathology.getPathStatus() != "") {
			s = s + "@p_pathStatus='" + pathology.getPathStatus() + "',";
		}
		if (pathology.getOrg5() != null || pathology.getOrg5() != "") {
			s = s + "@p_orgName5='" + pathology.getOrg5() + "',";
		}
		if (pathology.getDiv5() != null || pathology.getDiv5() != "") {
			s = s + "@p_orgDiv5='" + pathology.getDiv5() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("--------" + s);
		return s;

	}
	
	
	public static String getGroupMstr(RestHISConfigurationModel group) {

		String s = "";

		if (group.getGroup() != null || group.getGroup() != "") {
			s = s + "@p_group='" + group.getGroup() + "',";
		}
		if (group.getGroupName() != null || group.getGroupName() != "") {
			s = s + "@p_groupName='" + group.getGroupName() + "',";
		}

		if (group.getGroupDes() != null || group.getGroupDes() != "") {
			s = s + "@p_groupDes='" + group.getGroupDes() + "',";
		}

		if (group.getGroupStatus() != null || group.getGroupStatus() != "") {
			s = s + "@p_groupStatus='" + group.getGroupStatus() + "',";
		}
		if (group.getOrg6() != null || group.getOrg6() != "") {
			s = s + "@p_orgName6='" + group.getOrg6() + "',";
		}
		if (group.getDiv6() != null || group.getDiv6() != "") {
			s = s + "@p_orgDiv6='" + group.getDiv6() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("--------" + s);
		return s;

	}
	
	
	public static String getSubGroupMstr(RestHISConfigurationModel subgroup) {

		String s = "";

		if (subgroup.getSubGroup() != null || subgroup.getSubGroup() != "") {
			s = s + "@p_subgroup='" + subgroup.getSubGroup() + "',";
		}
		
		if (subgroup.getGroupId() != null || subgroup.getGroupId() != "") {
			s = s + "@p_groupId='" + subgroup.getGroupId() + "',";
		}
		if (subgroup.getSubName() != null || subgroup.getSubName() != "") {
			s = s + "@p_subName='" + subgroup.getSubName() + "',";
		}

		if (subgroup.getSubDes() != null || subgroup.getSubDes() != "") {
			s = s + "@p_subDes='" + subgroup.getSubDes() + "',";
		}

		if (subgroup.getSubStatus() != null || subgroup.getSubStatus() != "") {
			s = s + "@p_subStatus='" + subgroup.getSubStatus() + "',";
		}
		if (subgroup.getOrg7() != null || subgroup.getOrg7() != "") {
			s = s + "@p_orgName7='" + subgroup.getOrg7() + "',";
		}
		if (subgroup.getDiv7() != null || subgroup.getDiv7() != "") {
			s = s + "@p_orgDiv7='" + subgroup.getDiv7() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("--------" + s);
		return s;

	}
	
	
	
public static String getSurgeryParam(RestHISConfigurationModel surgery) {
		
		String s = "";
		
		if (surgery.getSurgeryId() != null || surgery.getSurgeryId() != "") {
			s = s + "@p_surgeryId='" + surgery.getSurgeryId() + "',";
		}
		if (surgery.getSurgeryName() != null || surgery.getSurgeryName() != "") {
			s = s + "@p_surgeryName='" + surgery.getSurgeryName() + "',";
		}
		
		if (surgery.getSurgeryDes() != null || surgery.getSurgeryDes() != "") {
			s = s + "@p_surgeryDes='" + surgery.getSurgeryDes() + "',";
		}
		
		if (surgery.getSurgeryStatus() != null || surgery.getSurgeryStatus() != "") {
			s = s + "@p_surgeryStatus='" + surgery.getSurgeryStatus() + "',";
		}
		if (surgery.getOrg8() != null || surgery.getOrg8() != "") {
			s = s + "@p_orgName8='" + surgery.getOrg8() + "',";
		}
		if (surgery.getDiv8() != null || surgery.getDiv8() != "") {
			s = s + "@p_orgDiv8='" + surgery.getDiv8() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			
			s = "SET " + s + ";";
		}
		
		System.out.println("--------" + s);
		return s;
		
	}
}
