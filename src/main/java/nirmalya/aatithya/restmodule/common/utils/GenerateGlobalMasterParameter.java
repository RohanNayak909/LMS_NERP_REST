package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.GlobalMasterRestModel;

public class GenerateGlobalMasterParameter {

	public static String Country(GlobalMasterRestModel country) {

		String s = "";

		if (country.getGlobalId() != null && country.getGlobalId() != "") {
			s = s + "@p_globalId='" + country.getGlobalId() + "',";
		}

		if (country.getCountryOrderId() != null && country.getCountryOrderId() != "") {
			s = s + "@p_countryId='" + country.getCountryOrderId() + "',";
		}
		if (country.getCountryName() != null && country.getCountryName() != "") {
			s = s + "@p_countryName='" + country.getCountryName() + "',";
		}
		if (country.getCountryCode() != null && country.getCountryCode() != "") {
			s = s + "@p_countrycode='" + country.getCountryCode() + "',";
		}
		if (country.getCountryStatus() != null && country.getCountryStatus() != "") {
			s = s + "@p_countrystatus='" + country.getCountryStatus() + "',";
		}
		if (country.getCreatedBy() != null && country.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + country.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String State(GlobalMasterRestModel state) {

		String s = "";

		if (state.getStateId() != null && state.getStateId() != "") {
			s = s + "@p_stateId='" + state.getStateId() + "',";
		}

		if (state.getGlobalId() != null && state.getGlobalId() != "") {
			s = s + "@p_globalId='" + state.getGlobalId() + "',";
		}

		if (state.getStateOrderId() != null && state.getStateOrderId() != "") {
			s = s + "@p_stateorderId='" + state.getStateOrderId() + "',";
		}

		if (state.getStateCode() != null && state.getStateCode() != "") {
			s = s + "@p_statecode='" + state.getStateCode() + "',";
		}
		if (state.getStateName() != null && state.getStateName() != "") {
			s = s + "@p_stateName='" + state.getStateName() + "',";
		}
		if (state.getStateStatus() != null && state.getStateStatus() != "") {
			s = s + "@p_statestatus='" + state.getStateStatus() + "',";
		}
		if (state.getStateCreatedBy() != null && state.getStateCreatedBy() != "") {
			s = s + "@p_statecreatedBy='" + state.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String District(GlobalMasterRestModel state) {

		String s = "";

		if (state.getDistrictId() != null && state.getDistrictId() != "") {
			s = s + "@p_districtId='" + state.getDistrictId() + "',";
		}

		if (state.getStateId() != null && state.getStateId() != "") {
			s = s + "@p_stateId='" + state.getStateId() + "',";
		}

		if (state.getDistrictOrderId() != null && state.getDistrictOrderId() != "") {
			s = s + "@p_orderId='" + state.getDistrictOrderId() + "',";
		}

		if (state.getDistrictCode() != null && state.getDistrictCode() != "") {
			s = s + "@p_code='" + state.getDistrictCode() + "',";
		}
		if (state.getDistrictName() != null && state.getDistrictName() != "") {
			s = s + "@p_name='" + state.getDistrictName() + "',";
		}
		if (state.getDistrictStatus() != null && state.getDistrictStatus() != "") {
			s = s + "@p_status='" + state.getDistrictStatus() + "',";
		}
		if (state.getCreatedBy() != null && state.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + state.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String City(GlobalMasterRestModel city) {

		String s = "";

		if (city.getCityId() != null && city.getCityId() != "") {
			s = s + "@p_cityId='" + city.getCityId() + "',";
		}

		if (city.getGlobalId() != null && city.getGlobalId() != "") {
			s = s + "@p_globalId='" + city.getGlobalId() + "',";
		}

		if (city.getStateId() != null && city.getStateId() != "") {
			s = s + "@p_stateId='" + city.getStateId() + "',";
		}

		if (city.getDistrictId() != null && city.getDistrictId() != "") {
			s = s + "@p_districtId='" + city.getDistrictId() + "',";
		}

		if (city.getCityOrderId() != null && city.getCityOrderId() != "") {
			s = s + "@p_cityorderId='" + city.getCityOrderId() + "',";
		}

		if (city.getCityCode() != null && city.getCityCode() != "") {
			s = s + "@p_citycode='" + city.getCityCode() + "',";
		}
		if (city.getCityName() != null && city.getCityName() != "") {
			s = s + "@p_cityName='" + city.getCityName() + "',";
		}
		if (city.getCityStatus() != null && city.getCityStatus() != "") {
			s = s + "@p_citystatus='" + city.getCityStatus() + "',";
		}
		if (city.getCreatedBy() != null && city.getCreatedBy() != "") {
			s = s + "@p_citycreatedBy='" + city.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	/*
	 * Generate Parameter for city list
	 */

	public static String getCityList(List<GlobalMasterRestModel> globalMasterRestModelList) {

		String s = "";

		String asp = "";

		for (GlobalMasterRestModel a : globalMasterRestModelList) {
			asp = asp + "(FN_MASTER_PK_GEN(\"city\")" + ",\"" + a.getGlobalId() + "\",\"" + a.getStateId() + "\",\""
					+ a.getDistrictId() + "\",\"" + a.getCityOrderId() + "\"," + a.getCityStatus() + ",\""
					+ a.getCityName() + "\",\"" + a.getCreatedBy() + "\"),";
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_multipleInsert='" + asp + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	/*
	 * Generate Parameter for country list
	 */

	public static String getCountryList(List<GlobalMasterRestModel> globalMasterRestModelList) {

		String s = "";

		String asp = "";

		for (GlobalMasterRestModel a : globalMasterRestModelList) {
			asp = asp + "(FN_MASTER_PK_GEN(\"country\")" + ",\"" + a.getCountryOrderId() + "\",\"" + a.getCountryCode()
					+ "\",\"" + a.getCountryName() + "\"," + a.getCountryStatus() + ",\"" + a.getCreatedBy() + "\"),";
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_multipleInsertCountry='" + asp + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
	/*
	 * Generate Parameter for country list
	 */

	public static String getStateList(List<GlobalMasterRestModel> globalMasterRestModelList) {

		String s = "";

		String asp = "";

		for (GlobalMasterRestModel a : globalMasterRestModelList) {
			asp = asp + "(FN_MASTER_PK_GEN(\"state\")" + ",\"" + a.getGlobalId() + "\",\"" + a.getStateCode() + "\",\""
					+ a.getStateOrderId() + "\",\"" + a.getStateName() + "\"," + a.getStateStatus() + ",\""
					+ a.getCreatedBy() + "\"),";
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_multipleInsertCountry='" + asp + "',";
		if (globalMasterRestModelList != null) {
			s = s + "@p_country='" + globalMasterRestModelList.get(0).getGlobalId() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String getDistList(List<GlobalMasterRestModel> globalMasterRestModelList) {

		String s = "";

		String asp = "";

		for (GlobalMasterRestModel a : globalMasterRestModelList) {
			asp = asp + "(FN_MASTER_PK_GEN(\"dist\")" + ",\"" + a.getStateId() + "\",\"" + a.getDistrictCode()
					+ "\",\"" + a.getDistrictOrderId() + "\",\"" + a.getDistrictName() + "\"," + a.getDistrictStatus()
					+ ",\"" + a.getCreatedBy() + "\"),";
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_multipleInsertCountry='" + asp + "',";
		if (globalMasterRestModelList != null) {
			s = s + "@p_stateId='" + globalMasterRestModelList.get(0).getStateId() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
