package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestIncomeTaxMasterModel;
import nirmalya.aatithya.restmodule.master.model.RestSalaryRevisionModel;

public class GenerateMasterReferenceIncomeTax {
	public static String addTaxCatagoryParam(RestIncomeTaxMasterModel restPayroll) {
		// TODO Auto-generated method stub
		String S = "";
		
		if(restPayroll.getOrganization() != null || restPayroll.getOrganization() != "") {
			S = S + "@p_org='" + restPayroll.getOrganization() + "',";
		}
		if(restPayroll.getOrgDivision() != null || restPayroll.getOrgDivision() != "") {
			S = S + "@p_orgDiv='" + restPayroll.getOrgDivision() + "',";
		}
		if(restPayroll.getIncomeId() != null || restPayroll.getIncomeId() != "") {
			S = S + "@p_incomeId='" + restPayroll.getIncomeId() + "',";
		}
		if(restPayroll.getIncomeName() != null || restPayroll.getIncomeName() != "") {
			S = S + "@p_incomeName='" + restPayroll.getIncomeName() + "',";
		}
		if(restPayroll.getIfyear() != null || restPayroll.getIfyear() != "") {
			S = S + "@p_ifyear='" + restPayroll.getIfyear() + "',";
		}
		if(restPayroll.getIminval() != null) {
			S = S + "@p_iminval='" + restPayroll.getIminval() + "',";
		}
		if(restPayroll.getImaxval() != null) {
			S = S + "@p_imaxval='" + restPayroll.getImaxval() + "',";
		}
		if(restPayroll.getItax() != null || restPayroll.getItax() != "") {
			S = S + "@p_itax='" + restPayroll.getItax() + "',";
		}
		
		if (S != "") {
			S = S.substring(0, S.length() - 1);

			S = "SET " + S + ";";
		}
		System.out.println(S);
		return S;
	}
	
	
	public static String addProfessionalTaxParam(RestIncomeTaxMasterModel restPayroll) {
		// TODO Auto-generated method stub
		String S = "";
		
		if(restPayroll.getOrganization() != null || restPayroll.getOrganization() != "") {
			S = S + "@p_org='" + restPayroll.getOrganization() + "',";
		}
		if(restPayroll.getOrgDivision() != null || restPayroll.getOrgDivision() != "") {
			S = S + "@p_orgDiv='" + restPayroll.getOrgDivision() + "',";
		}
		if(restPayroll.getPrId() != null || restPayroll.getPrId() != "") {
			S = S + "@p_prId='" + restPayroll.getPrId() + "',";
		}
		if(restPayroll.getpName() != null || restPayroll.getpName() != "") {
			S = S + "@p_pName='" + restPayroll.getpName() + "',";
		}
		if(restPayroll.getPyear() != null || restPayroll.getPyear() != "") {
			S = S + "@p_pyear='" + restPayroll.getPyear() + "',";
		}
		if(restPayroll.getPminval() != null) {
			S = S + "@p_pminval='" + restPayroll.getPminval() + "',";
		}
		if(restPayroll.getPmaxval() != null) {
			S = S + "@p_pmaxval='" + restPayroll.getPmaxval() + "',";
		}
		if(restPayroll.getPtax() != null) {
			S = S + "@p_ptax='" + restPayroll.getPtax() + "',";
		}
		
		if (S != "") {
			S = S.substring(0, S.length() - 1);

			S = "SET " + S + ";";
		}
		System.out.println(S);
		return S;
	}
	

	public static String addIncomeTaxParam(RestIncomeTaxMasterModel restPayroll) {
		String S = "";
		if(restPayroll.getOrganization() != null || restPayroll.getOrganization() != "") {
			S = S + "@p_org='" + restPayroll.getOrganization() + "',";
		}
		if(restPayroll.getOrgDivision() != null || restPayroll.getOrgDivision() != "") {
			S = S + "@p_orgDiv='" + restPayroll.getOrgDivision() + "',";
		}
		
		if(restPayroll.getsId() != null || restPayroll.getsId() != "") {
			S = S + "@p_sId='" + restPayroll.getsId() + "',";
		}
			
		if(restPayroll.getsName() != null || restPayroll.getsName() != "") {
				S = S + "@p_sName='" + restPayroll.getsName() + "',";
		}
		if(restPayroll.getSdesc() != null || restPayroll.getSdesc() != "") {
			S = S + "@p_sdesc='" + restPayroll.getSdesc() + "',";
		}
		if(restPayroll.getStatus() != null || restPayroll.getStatus() != "") {
			S = S + "@p_status='" + restPayroll.getStatus() + "',";
		}
		
		
			
			if (S != "") {
				S = S.substring(0, S.length() - 1);

				S = "SET " + S + ";";
			}
			System.out.println(S);
			return S;
		
	}


	

}
