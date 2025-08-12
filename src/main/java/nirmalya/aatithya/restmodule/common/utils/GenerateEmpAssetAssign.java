package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestEmployeeAssetAssignModel;

public class GenerateEmpAssetAssign {
	public static String getAddassetassignParam(RestEmployeeAssetAssignModel empAsset) {
		
		String s = "";


		if (empAsset.getEmpAssetId() != null && empAsset.getEmpAssetId() != "") {
			s = s + "@empasetasgnid='" + empAsset.getEmpAssetId() + "',";
		}
		
		if (empAsset.getEmpId() != null && empAsset.getEmpId() != "") {
			s = s + "@empId='" + empAsset.getEmpId() + "',";
		}
		if (empAsset.getDeptName() != null && empAsset.getDeptName() != "") {
			s = s + "@dept='" + empAsset.getDeptName() + "',";
		}
		if (empAsset.getSubDeptName() != null && empAsset.getSubDeptName() != "") {
			s = s + "@subDept='" + empAsset.getSubDeptName() + "',";
		}
		if (empAsset.getName() != null && empAsset.getName() != "") {
			s = s + "@empname='" + empAsset.getName() + "',";
		}
		
		if (empAsset.getAssignDate() != null && empAsset.getAssignDate() != "") {
			s = s + "@assigndate='" + empAsset.getAssignDate() + "',";
		}
		if (empAsset.getAssetid() != null && empAsset.getAssetid() != "") {
			s = s + "@assetname='" + empAsset.getAssetid() + "',";
		}
		if (empAsset.getCreatedby() != null && empAsset.getCreatedby() != "") {
			s = s + "@createdby='" + empAsset.getCreatedby() + "',";
		}
		if (empAsset.getOrganization() != null && empAsset.getOrganization() != "") {
			s = s + "@organization='" + empAsset.getOrganization() + "',";
		}
		if (empAsset.getOrgDivision() != null && empAsset.getOrgDivision() != "") {
			s = s + "@orgDiv='" + empAsset.getOrgDivision() + "',";
		}
		
		
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}


}
