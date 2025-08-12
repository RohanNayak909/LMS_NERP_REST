package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestTDSModel;

public class GenerateEmployeeTDSParameters {
	public static String getTDSMasterParam(RestTDSModel restTDSModel) {

		String s = "";

		if (restTDSModel.getTdsId() != null ||  restTDSModel.getTdsId() != "") {
			s = s + "@p_tdsId='" + restTDSModel.getTdsId() + "',";
		}
		if (restTDSModel.getEmpId() != null ||  restTDSModel.getEmpId() != "") {
			s = s + "@p_empId='" + restTDSModel.getEmpId() + "',";
		}
 
		if (restTDSModel.getYear() != null ||  restTDSModel.getYear() != "") {
			s = s + "@p_year='" + restTDSModel.getYear() + "',";
		}
		if (restTDSModel.getMonth()!= null ||  restTDSModel.getMonth() != "") {
			s = s + "@p_month='" + restTDSModel.getMonth() + "',";
		}
		if (DateFormatter.getStringDate(restTDSModel.getFromDate()) != null || DateFormatter.getStringDate(restTDSModel.getFromDate()) != "") {
			s = s + "@p_fromDate='" + DateFormatter.getStringDate(restTDSModel.getFromDate()) + "',";
		}
		if (DateFormatter.getStringDate(restTDSModel.getToDate()) != null ||  DateFormatter.getStringDate(restTDSModel.getToDate()) != "") {
			s = s + "@p_toDate='" + DateFormatter.getStringDate(restTDSModel.getToDate()) + "',";
		}
		if (restTDSModel.getFyear() != null ||  restTDSModel.getFyear() != "") {
			s = s + "@p_fyear='" + restTDSModel.getFyear() + "',";
		}
		if (restTDSModel.getTdsAmnt() != null ||  restTDSModel.getTdsAmnt() != "") {
			s = s + "@p_tdsAmt='" + restTDSModel.getTdsAmnt() + "',";
		}
		if (restTDSModel.getCreatedBy() != null ||  restTDSModel.getCreatedBy() != "") {
			s = s + "@p_createdby='" + restTDSModel.getCreatedBy() + "',";
		}
		if (restTDSModel.getOrgName() != null ||  restTDSModel.getOrgName() != "") {
			s = s + "@p_orgName='" + restTDSModel.getOrgName() + "',";
		}
		if (restTDSModel.getOrgDivision()!= null ||  restTDSModel.getOrgDivision() != "") {
			s = s + "@p_orgDivision='" + restTDSModel.getOrgDivision() + "',";
		}
	
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
}
