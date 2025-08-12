package nirmalya.aatithya.restmodule.common.utils.projects;

import nirmalya.aatithya.restmodule.projects.model.RestProjectCropModel;

public class GenerateProjectCropParameter {
	public static String getProjectCropParam(RestProjectCropModel category) {
		String s = "";

		if (category.getCropId() != null || category.getCropId() != "") {
			s = s + "@p_cropId='" + category.getCropId() + "',";
		}

		if (category.getCropName() != null || category.getCropName() != "") {
			s = s + "@p_cropName='" + category.getCropName() + "',";
		}

		if (category.getCropDescription() != null || category.getCropDescription() != "") {
			s = s + "@p_cropDescription='" + category.getCropDescription() + "',";
		}

		if (category.getCropStatus() != null || category.getCropStatus() != "") {
			s = s + "@p_cropStatus='" + category.getCropStatus() + "',";
		}

		if (category.getCreatedBy() != null || category.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.getCreatedBy() + "',";
		}

		if (category.getOrganizationName() != null || category.getOrganizationName() != "") {
			s = s + "@p_OrganizationName='" + category.getOrganizationName() + "',";
		}
		if (category.getOrganizationDivision() != null || category.getOrganizationDivision() != "") {
			s = s + "@p_OrganizationDivision='" + category.getOrganizationDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String getProjectCropProcessParam(RestProjectCropModel category) {
		String s = "";

		if (category.getCropId() != null || category.getCropId() != "") {
			s = s + "@p_cropId='" + category.getCropId() + "',";
		}

		if (category.getCropProcessId() != null || category.getCropProcessId() != "") {
			s = s + "@p_cropProcessId='" + category.getCropProcessId() + "',";
		}

		if (category.getActivityId() != null || category.getActivityId() != "") {
			s = s + "@p_activityId='" + category.getActivityId() + "',";
		}

		if (category.getTaskId() != null || category.getTaskId() != "") {
			s = s + "@p_taskId='" + category.getTaskId() + "',";
		}
		
		if (category.getVariantId() != null || category.getVariantId() != "") {
			s = s + "@p_variantId='" + category.getVariantId() + "',";
		}

		if (category.getQty() != null || category.getQty() != "") {
			s = s + "@p_qty=" + category.getQty() + ",";
		}

		if (category.getCropProcessDescription() != null || category.getCropProcessDescription() != "") {
			s = s + "@p_cropProcessDescription='" + category.getCropProcessDescription() + "',";
		}

		if (category.getAmount() != null || category.getAmount() != "") {
			s = s + "@p_amount=" + category.getAmount() + ",";
		}

		if (category.getDuration() != null || category.getDuration() != "") {
			s = s + "@p_duration='" + category.getDuration() + "',";
		}

		if (category.getUnit() != null || category.getUnit() != "") {
			s = s + "@p_unit='" + category.getUnit() + "',";
		}

		if (category.getCreatedBy() != null || category.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + category.getCreatedBy() + "',";
		}

		if (category.getOrganizationName() != null || category.getOrganizationName() != "") {
			s = s + "@p_OrganizationName='" + category.getOrganizationName() + "',";
		}
		if (category.getOrganizationDivision() != null || category.getOrganizationDivision() != "") {
			s = s + "@p_OrganizationDivision='" + category.getOrganizationDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
}
