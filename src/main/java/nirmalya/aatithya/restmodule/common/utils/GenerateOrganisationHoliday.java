package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestOrganisationTypeModel;

public class GenerateOrganisationHoliday {

	public static String addOrgTypeHoliday(RestOrganisationTypeModel restOrganisationTypeModel) {

		String s = "";
		
		if (restOrganisationTypeModel.getHolidayId() != null || restOrganisationTypeModel.getHolidayId() != "") {
			s = s + "@p_HolidayId=\"" + restOrganisationTypeModel.getHolidayId() + "\",";
		}
		
		if (restOrganisationTypeModel.getHolidayName() != null || restOrganisationTypeModel.getHolidayName() != "") {
			s = s + "@p_HolidayName=\"" + restOrganisationTypeModel.getHolidayName() + "\",";
		}
		if (restOrganisationTypeModel.getFromDate() != null || restOrganisationTypeModel.getFromDate() != "") {
			s = s + "@p_FromDate=\"" + restOrganisationTypeModel.getFromDate() + "\",";
		}
		
		
		if (restOrganisationTypeModel.getToDate() != null || restOrganisationTypeModel.getToDate() != "") {
			s = s + "@p_ToDate=\"" + restOrganisationTypeModel.getToDate() + "\",";
		}
		
		if (restOrganisationTypeModel.getTotalHoliday() != null || restOrganisationTypeModel.getTotalHoliday() != "") {
			s = s + "@p_TotalHoliday=\"" + restOrganisationTypeModel.getTotalHoliday() + "\",";
			}
	
		
		
	
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("ssssssssssssssssssssssss"+s);
		return s;
	}


}