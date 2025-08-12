package nirmalya.aatithya.restmodule.common.utils.budget;



import nirmalya.aatithya.restmodule.budget.model.RestManageDepartmentModel;


public class GenerateDepartmentBudgetParam {
	
	public static String addDepartmentInfo(RestManageDepartmentModel restManageDepartmentModel) {
		String s = "";
		if (restManageDepartmentModel.getDepartmentId() != null || restManageDepartmentModel.getDepartmentId() != "") {
			s = s + "@p_departmentId='"+ restManageDepartmentModel.getDepartmentId() + "',";
		}
		if (restManageDepartmentModel.getDepartmentName() != null || restManageDepartmentModel.getDepartmentName() != "") {
			s = s + "@p_departmentName='" + restManageDepartmentModel.getDepartmentName() + "',";
		}
	
		if (restManageDepartmentModel.getDeptMobile()!= null || restManageDepartmentModel.getDeptMobile() != "") {
			s = s + "@p_deptMobile='" + restManageDepartmentModel.getDeptMobile() + "',";
		}
		if (restManageDepartmentModel.getDeptEmail() != null || restManageDepartmentModel.getDeptEmail() != "") {
			s = s + "@p_deptEmail='" + restManageDepartmentModel.getDeptEmail() + "',";
		}
		if (restManageDepartmentModel.getDepartmentHODName() != null || restManageDepartmentModel.getDepartmentHODName() != "") {
			s = s + "@p_departmentHODName='" + restManageDepartmentModel.getDepartmentHODName() + "',";
		}
		if (restManageDepartmentModel.getDescription() != null || restManageDepartmentModel.getDescription() != "") {
			s = s + "@p_description='" + restManageDepartmentModel.getDescription() + "',";
		}
		if (restManageDepartmentModel.getPassword() != null || restManageDepartmentModel.getPassword() != "") {
			s = s + "@p_password='" + restManageDepartmentModel.getPassword() + "',";
		}
		if (restManageDepartmentModel.getCreatedBy() != null || restManageDepartmentModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restManageDepartmentModel.getCreatedBy() + "',";
		}
		if (restManageDepartmentModel.getOrgName() != null || restManageDepartmentModel.getOrgName() != "") {
			s = s + "@p_orgName='" + restManageDepartmentModel.getOrgName() + "',";
		}
		if (restManageDepartmentModel.getOrgDivision() != null || restManageDepartmentModel.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + restManageDepartmentModel.getOrgDivision() + "',";
		}

		if (s != "") { 
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s--------------------------" + s);
		return s;

	}

}
