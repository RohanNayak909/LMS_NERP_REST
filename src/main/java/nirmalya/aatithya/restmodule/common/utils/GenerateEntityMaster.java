package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestEntityMasterModel;

public class GenerateEntityMaster {

	public static String addCostNatureParam(RestEntityMasterModel restEntityMasterModel) {

		String s = "";
		if(restEntityMasterModel.getOrganization() != null || restEntityMasterModel.getOrganization() != "") {
			s = s + "@p_org='" + restEntityMasterModel.getOrganization() + "',";
		}
		if(restEntityMasterModel.getOrgDivision() != null || restEntityMasterModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restEntityMasterModel.getOrgDivision() + "',";
		}

		if (restEntityMasterModel.getCostnatureId() != null || restEntityMasterModel.getCostnatureId() != "") {
			s = s + "@p_costNatureId='" + restEntityMasterModel.getCostnatureId() + "',";
		}
		if (restEntityMasterModel.getCostnatureName() != null || restEntityMasterModel.getCostnatureName() != "") {
			s = s + "@p_costNatureName='" + restEntityMasterModel.getCostnatureName() + "',";
		}
		if (restEntityMasterModel.getCostnatureDesc() != null || restEntityMasterModel.getCostnatureDesc() != "") {
			s = s + "@p_costNatureDesc='" + restEntityMasterModel.getCostnatureDesc() + "',";
		}
		if (restEntityMasterModel.getCostnatureStatus() != null || restEntityMasterModel.getCostnatureStatus() != "") {
			s = s + "@p_costNatureStatus='" + restEntityMasterModel.getCostnatureStatus() + "',";
		}
		if (restEntityMasterModel.getCostnatureCreatedBy() != null
				|| restEntityMasterModel.getCostnatureCreatedBy() != "") {
			s = s + "@p_costNatureCreatedBy='" + restEntityMasterModel.getCostnatureCreatedBy() + "',";
		}
		if (restEntityMasterModel.getCostnatureModifiedBy() != null
				|| restEntityMasterModel.getCostnatureModifiedBy() != "") {
			s = s + "@p_costNatureModifiedBy='" + restEntityMasterModel.getCostnatureModifiedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	public static String addCostLabourParam(RestEntityMasterModel restEntityMasterModel) {

		String s = "";
		if(restEntityMasterModel.getOrganization() != null || restEntityMasterModel.getOrganization() != "") {
			s = s + "@p_org='" + restEntityMasterModel.getOrganization() + "',";
		}
		if(restEntityMasterModel.getOrgDivision() != null || restEntityMasterModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restEntityMasterModel.getOrgDivision() + "',";
		}

		if (restEntityMasterModel.getCostLabourId() != null || restEntityMasterModel.getCostLabourId() != "") {
			s = s + "@p_costLabourId='" + restEntityMasterModel.getCostLabourId() + "',";
		}
		if (restEntityMasterModel.getCostLabourName() != null || restEntityMasterModel.getCostLabourName() != "") {
			s = s + "@p_costLabourName='" + restEntityMasterModel.getCostLabourName() + "',";
		}
		if (restEntityMasterModel.getCostLabourDesc() != null || restEntityMasterModel.getCostLabourDesc() != "") {
			s = s + "@p_costLabourDesc='" + restEntityMasterModel.getCostLabourDesc() + "',";
		}
		if (restEntityMasterModel.getCostLabourStatus() != null || restEntityMasterModel.getCostLabourStatus() != "") {
			s = s + "@p_costLabourStatus='" + restEntityMasterModel.getCostLabourStatus() + "',";
		}
		if (restEntityMasterModel.getCostLabourCreatedBy() != null
				|| restEntityMasterModel.getCostLabourCreatedBy() != "") {
			s = s + "@p_costLabourCreatedBy='" + restEntityMasterModel.getCostLabourCreatedBy() + "',";
		}
		if (restEntityMasterModel.getCostLabourModifiedBy() != null
				|| restEntityMasterModel.getCostLabourModifiedBy() != "") {
			s = s + "@p_costLabourModifiedBy='" + restEntityMasterModel.getCostLabourModifiedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	// Vendor Type Master

	public static String addVendorCategoryParam(RestEntityMasterModel restEntityMasterModel) {

		String s = "";
		if(restEntityMasterModel.getOrganization() != null || restEntityMasterModel.getOrganization() != "") {
			s = s + "@p_org='" + restEntityMasterModel.getOrganization() + "',";
		}
		if(restEntityMasterModel.getOrgDivision() != null || restEntityMasterModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restEntityMasterModel.getOrgDivision() + "',";
		}

		if (restEntityMasterModel.getVendorCategoryId() != null || restEntityMasterModel.getVendorCategoryId() != "") {
			s = s + "@p_vendorCategoryId='" + restEntityMasterModel.getVendorCategoryId() + "',";
		}
		if (restEntityMasterModel.getVendorCategoryName() != null
				|| restEntityMasterModel.getVendorCategoryName() != "") {
			s = s + "@p_vendorCategoryName='" + restEntityMasterModel.getVendorCategoryName() + "',";
		}
		if (restEntityMasterModel.getVendorCategoryDesc() != null
				|| restEntityMasterModel.getVendorCategoryDesc() != "") {
			s = s + "@p_vendorCategoryDesc='" + restEntityMasterModel.getVendorCategoryDesc() + "',";
		}
		if (restEntityMasterModel.getVendorCategoryStatus() != null
				|| restEntityMasterModel.getVendorCategoryStatus() != "") {
			s = s + "@p_vendorCategoryStatus='" + restEntityMasterModel.getVendorCategoryStatus() + "',";
		}
		if (restEntityMasterModel.getVendorCategoryCreatedBy() != null
				|| restEntityMasterModel.getVendorCategoryCreatedBy() != "") {
			s = s + "@p_vendorCategoryCreatedBy='" + restEntityMasterModel.getVendorCategoryCreatedBy() + "',";
		}
		if (restEntityMasterModel.getVendorCategoryModifiedBy() != null
				|| restEntityMasterModel.getVendorCategoryModifiedBy() != "") {
			s = s + "@p_vendorCategoryModifiedBy='" + restEntityMasterModel.getVendorCategoryModifiedBy() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	// Location Type Master

	public static String addLocationTypeParam(RestEntityMasterModel restEntityMasterModel) {

		String s = "";
		if(restEntityMasterModel.getOrganization() != null || restEntityMasterModel.getOrganization() != "") {
			s = s + "@p_org='" + restEntityMasterModel.getOrganization() + "',";
		}
		if(restEntityMasterModel.getOrgDivision() != null || restEntityMasterModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restEntityMasterModel.getOrgDivision() + "',";
		}

		if (restEntityMasterModel.getLocationTypeId() != null || restEntityMasterModel.getLocationTypeId() != "") {
			s = s + "@p_locationTypeId='" + restEntityMasterModel.getLocationTypeId() + "',";
		}
		if (restEntityMasterModel.getLocationTypeName() != null || restEntityMasterModel.getLocationTypeName() != "") {
			s = s + "@p_locationTypeName='" + restEntityMasterModel.getLocationTypeName() + "',";
		}
		if (restEntityMasterModel.getLocationTypeDesc() != null || restEntityMasterModel.getLocationTypeDesc() != "") {
			s = s + "@p_locationTypeDesc='" + restEntityMasterModel.getLocationTypeDesc() + "',";
		}
		if (restEntityMasterModel.getLocationTypeStatus() != null
				|| restEntityMasterModel.getLocationTypeStatus() != "") {
			s = s + "@p_locationTypeStatus='" + restEntityMasterModel.getLocationTypeStatus() + "',";
		}
		if (restEntityMasterModel.getLocationTypeCreatedBy() != null
				|| restEntityMasterModel.getLocationTypeCreatedBy() != "") {
			s = s + "@p_locationTypeCreatedBy='" + restEntityMasterModel.getLocationTypeCreatedBy() + "',";
		}
		if (restEntityMasterModel.getLocationTypeModifiedBy() != null
				|| restEntityMasterModel.getLocationTypeModifiedBy() != "") {
			s = s + "@p_locationTypeModifiedBy='" + restEntityMasterModel.getLocationTypeModifiedBy() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	// Room Type Master

	public static String addRoomTypeParam(RestEntityMasterModel restEntityMasterModel) {

		String s = "";
		if(restEntityMasterModel.getOrganization() != null || restEntityMasterModel.getOrganization() != "") {
			s = s + "@p_org='" + restEntityMasterModel.getOrganization() + "',";
		}
		if(restEntityMasterModel.getOrgDivision() != null || restEntityMasterModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restEntityMasterModel.getOrgDivision() + "',";
		}

		if (restEntityMasterModel.getRoomTypeId() != null || restEntityMasterModel.getRoomTypeId() != "") {
			s = s + "@p_roomTypeId='" + restEntityMasterModel.getRoomTypeId() + "',";
		}
		if (restEntityMasterModel.getRoomTypeName() != null || restEntityMasterModel.getRoomTypeName() != "") {
			s = s + "@p_roomTypeName='" + restEntityMasterModel.getRoomTypeName() + "',";
		}
		if (restEntityMasterModel.getRoomTypeDesc() != null || restEntityMasterModel.getRoomTypeDesc() != "") {
			s = s + "@p_roomTypeDesc='" + restEntityMasterModel.getRoomTypeDesc() + "',";
		}
		if (restEntityMasterModel.getRoomTypeStatus() != null || restEntityMasterModel.getRoomTypeStatus() != "") {
			s = s + "@p_roomTypeStatus='" + restEntityMasterModel.getRoomTypeStatus() + "',";
		}
		if (restEntityMasterModel.getRoomTypeCreatedBy() != null
				|| restEntityMasterModel.getRoomTypeCreatedBy() != "") {
			s = s + "@p_roomTypeCreatedBy='" + restEntityMasterModel.getRoomTypeCreatedBy() + "',";
		}
		if (restEntityMasterModel.getRoomTypeModifiedBy() != null
				|| restEntityMasterModel.getRoomTypeModifiedBy() != "") {
			s = s + "@p_roomTypeModifiedBy='" + restEntityMasterModel.getRoomTypeModifiedBy() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}

	// Vendor Type Master

	public static String addVendorTypeParam(RestEntityMasterModel restEntityMasterModel) {

		String s = "";
		if(restEntityMasterModel.getOrganization() != null || restEntityMasterModel.getOrganization() != "") {
			s = s + "@p_org='" + restEntityMasterModel.getOrganization() + "',";
		}
		if(restEntityMasterModel.getOrgDivision() != null || restEntityMasterModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restEntityMasterModel.getOrgDivision() + "',";
		}

		if (restEntityMasterModel.getVendorTypeId() != null || restEntityMasterModel.getVendorTypeId() != "") {
			s = s + "@p_vendorTypeId='" + restEntityMasterModel.getVendorTypeId() + "',";
		}
		if (restEntityMasterModel.getVendorCategoryTypeId() != null
				|| restEntityMasterModel.getVendorCategoryTypeId() != "") {
			s = s + "@p_vendorCategoryTypeId='" + restEntityMasterModel.getVendorCategoryTypeId() + "',";
		}
		if (restEntityMasterModel.getVendorCategoryTypeName() != null
				|| restEntityMasterModel.getVendorCategoryTypeName() != "") {
			s = s + "@p_vendorCategoryTypeName='" + restEntityMasterModel.getVendorCategoryTypeName() + "',";
		}
		if (restEntityMasterModel.getVendorTypeName() != null || restEntityMasterModel.getVendorTypeName() != "") {
			s = s + "@p_vendorTypeName='" + restEntityMasterModel.getVendorTypeName() + "',";
		}
		if (restEntityMasterModel.getVendorTypeDesc() != null || restEntityMasterModel.getVendorTypeDesc() != "") {
			s = s + "@p_vendorTypeDesc='" + restEntityMasterModel.getVendorTypeDesc() + "',";
		}
		if (restEntityMasterModel.getVendorTypeStatus() != null || restEntityMasterModel.getVendorTypeStatus() != "") {
			s = s + "@p_vendorTypeStatus='" + restEntityMasterModel.getVendorTypeStatus() + "',";
		}
		if (restEntityMasterModel.getVendorTypeCreatedBy() != null
				|| restEntityMasterModel.getVendorTypeCreatedBy() != "") {
			s = s + "@p_vendorTypeCreatedBy='" + restEntityMasterModel.getVendorTypeCreatedBy() + "',";
		}
		if (restEntityMasterModel.getVendorTypeModifiedBy() != null
				|| restEntityMasterModel.getVendorTypeModifiedBy() != "") {
			s = s + "@p_vendorTypeModifiedBy='" + restEntityMasterModel.getVendorTypeModifiedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}
}