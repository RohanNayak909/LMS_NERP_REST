package nirmalya.aatithya.restmodule.common.utils;


import nirmalya.aatithya.restmodule.master.model.RestSalaryRevisionModel;

public class GenerateSalaryRevisionPromotionParameter {
	
//	public static String addSalaryRevisionParam(RestSalaryRevisionModel restPayroll) {
//		// TODO Auto-generated method stub
//		String S = "";
//	
//		if(restPayroll.getEmpId() != null || restPayroll.getEmpId() != "") {
//			S = S + "@p_empId='" + restPayroll.getEmpId() + "',";
//		}
//		if(restPayroll.getName() != null || restPayroll.getName() != "") {
//			S = S + "@p_name='" + restPayroll.getName() + "',";
//		}
//		if(restPayroll.getPdesg() != null || restPayroll.getPdesg() != "") {
//			S = S + "@p_pdesg='" + restPayroll.getPdesg() + "',";
//		}
//		if(restPayroll.getNdesg() != null || restPayroll.getNdesg() != "") {
//			S = S + "@p_ndesg='" + restPayroll.getNdesg() + "',";
//		}
//		if(restPayroll.getEffectiveFromDate() != null || restPayroll.getEffectiveFromDate() != "") {
//			S = S + "@p_effectiveDate='" + restPayroll.getEffectiveFromDate() + "',";
//		}
//		if(restPayroll.getBand() != null || restPayroll.getBand() != "") {
//			S = S + "@p_band='" + restPayroll.getBand() + "',";
//		}
//		if(restPayroll.getBasic() != null || restPayroll.getBasic() != "") {
//			S = S + "@p_basic='" + restPayroll.getBasic() + "',";
//		}
//		if(restPayroll.getHra() != null || restPayroll.getHra() != "") {
//			S = S + "@p_hra='" + restPayroll.getHra() + "',";
//		}
//		if(restPayroll.getAddAllow() != null || restPayroll.getAddAllow() != "") {
//			S = S + "@p_addAllow='" + restPayroll.getAddAllow() + "',";
//		}
//		if(restPayroll.getConve() != null || restPayroll.getConve() != "") {
//			S = S + "@p_conve='" + restPayroll.getConve() + "',";
//		}
//		if(restPayroll.getLta() != null || restPayroll.getLta() != "") {
//			S = S + "@p_lta='" + restPayroll.getLta() + "',";
//		}
//		if(restPayroll.getMedical() != null || restPayroll.getMedical() != "") {
//			S = S + "@p_medical='" + restPayroll.getMedical() + "',";
//		}
//		if(restPayroll.getWashAllow() != null || restPayroll.getWashAllow() != "") {
//			S = S + "@p_washAllow='" + restPayroll.getWashAllow() + "',";
//		}
//		if(restPayroll.getSkillDev() != null || restPayroll.getSkillDev() != "") {
//			S = S + "@p_skillDev='" + restPayroll.getSkillDev() + "',";
//		}
//		if(restPayroll.getOther() != null || restPayroll.getOther() != "") {
//			S = S + "@p_other='" + restPayroll.getOther() + "',";
//		}
//		if(restPayroll.getCreatedBy() != null || restPayroll.getCreatedBy() != "") {
//			S = S + "@p_createdBy='" + restPayroll.getCreatedBy() + "',";
//		}
//		if(restPayroll.getEditId() != null || restPayroll.getEditId() != "") {
//			S = S + "@p_editId='" + restPayroll.getEditId() + "',";
//		}
//		if(restPayroll.getOrganization() != null || restPayroll.getOrganization() != "") {
//			S = S + "@p_org='" + restPayroll.getOrganization() + "',";
//		}
//		if(restPayroll.getOrgDivision() != null || restPayroll.getOrgDivision() != "") {
//			S = S + "@p_orgDiv='" + restPayroll.getOrgDivision() + "',";
//		}
//		if(restPayroll.getDept() != null || restPayroll.getDept() != "") {
//			S = S + "@p_dept='" + restPayroll.getDept() + "',";
//		}
//		if(restPayroll.getSubdept() != null || restPayroll.getSubdept() != "") {
//			S = S + "@p_subdept='" + restPayroll.getSubdept() + "',";
//		}
//		if(restPayroll.getCtc() != null || restPayroll.getCtc() != "") {
//			S = S + "@p_ctc='" + restPayroll.getCtc() + "',";
//		}
//		if(restPayroll.getSpecialallowance() != null || restPayroll.getSpecialallowance() != "") {
//			S = S + "@p_specialallowance='" + restPayroll.getSpecialallowance() + "',";
//		}
//		if (S != "") {
//			S = S.substring(0, S.length() - 1);
//
//			S = "SET " + S + ";";
//		}
//		System.out.println(S);
//		return S;
//	}
	public static String addSalaryRevisionParamNew(RestSalaryRevisionModel restPayroll) {
		// TODO Auto-generated method stub
		String S = "";

		if(restPayroll.getEditId() != null || restPayroll.getEditId() != "") {
			S = S + "@p_editId='" + restPayroll.getEditId() + "',";
		}
		if(restPayroll.getEmpId() != null || restPayroll.getEmpId() != "") {
			S = S + "@p_empId='" + restPayroll.getEmpId() + "',";
		}
		if(restPayroll.getName() != null || restPayroll.getName() != "") {
			S = S + "@p_name='" + restPayroll.getName() + "',";
		}
		if(restPayroll.getPdesg() != null || restPayroll.getPdesg() != "") {
			S = S + "@p_pdesg='" + restPayroll.getPdesg() + "',";
		}
		if(restPayroll.getNdesg() != null || restPayroll.getNdesg() != "") {
			S = S + "@p_ndesg='" + restPayroll.getNdesg() + "',";
		}
		if(restPayroll.getEffectiveFromDate() != null || restPayroll.getEffectiveFromDate() != "") {
			S = S + "@p_effectiveFromDate='" + restPayroll.getEffectiveFromDate() + "',";
		}
		if(restPayroll.getEffectiveToDate() != null || restPayroll.getEffectiveToDate() != "") {
			S = S + "@p_effectiveToDate='" + restPayroll.getEffectiveToDate() + "',";
		}
		if(restPayroll.getBand() != null || restPayroll.getBand() != "") {
			S = S + "@p_band='" + restPayroll.getBand() + "',";
		}
		if(restPayroll.getDept() != null || restPayroll.getDept() != "") {
			S = S + "@p_dept='" + restPayroll.getDept() + "',";
		}
		if(restPayroll.getSubdept() != null || restPayroll.getSubdept() != "") {
			S = S + "@p_subdept='" + restPayroll.getSubdept() + "',";
		}
		if(restPayroll.getCreatedBy() != null || restPayroll.getCreatedBy() != "") {
			S = S + "@p_createdBy='" + restPayroll.getCreatedBy() + "',";
		}
		if(restPayroll.getOrganization() != null || restPayroll.getOrganization() != "") {
			S = S + "@p_org='" + restPayroll.getOrganization() + "',";
		}
		if(restPayroll.getOrgDivision() != null || restPayroll.getOrgDivision() != "") {
			S = S + "@p_orgDiv='" + restPayroll.getOrgDivision() + "',";
		}
//		if(restPayroll.getCtc() != null || restPayroll.getCtc() != "") {
//			S = S + "@p_ctc='" + restPayroll.getCtc() + "',";
//		}
		if(restPayroll.getBasic() != null || restPayroll.getBasic() != "") {
			S = S + "@p_basic='" + restPayroll.getBasic() + "',";
		}
		if(restPayroll.getProvidentFund() != null || restPayroll.getProvidentFund() != "") {
			S = S + "@p_providentFund='" + restPayroll.getProvidentFund() + "',";
		}
//		if(restPayroll.getDa() != null || restPayroll.getDa() != "") {
//			S = S + "@p_da='" + restPayroll.getDa() + "',";
//		}
//		if(restPayroll.getTds() != null || restPayroll.getTds() != "") {
//			S = S + "@p_tds='" + restPayroll.getTds() + "',";
//		}
		if(restPayroll.getHra() != null || restPayroll.getHra() != "") {
			S = S + "@p_hra='" + restPayroll.getHra() + "',";
		}
		if(restPayroll.getEsi() != null || restPayroll.getEsi() != "") {
			S = S + "@p_esi='" + restPayroll.getEsi() + "',";
		}
		if(restPayroll.getConvAllow() != null || restPayroll.getConvAllow() != "") {
			S = S + "@p_convAllow='" + restPayroll.getConvAllow() + "',";
		}
		if(restPayroll.getpTax() != null || restPayroll.getpTax() != "") {
			S = S + "@p_pTax='" + restPayroll.getpTax() + "',";
		}
		if(restPayroll.getSpecialallowance() != null || restPayroll.getSpecialallowance() != "") {
			S = S + "@p_specialallowance='" + restPayroll.getSpecialallowance() + "',";
		}
//		if(restPayroll.getSalAdv() != null || restPayroll.getSalAdv() != "") {
//			S = S + "@p_salAdv='" + restPayroll.getSalAdv() + "',";
//		}
		if(restPayroll.getSkillDev() != null || restPayroll.getSkillDev() != "") {
			S = S + "@p_skillDev='" + restPayroll.getSkillDev() + "',";
		}
		
		if(restPayroll.getwFund() != null || restPayroll.getwFund() != "") {
			S = S + "@p_wFund='" + restPayroll.getwFund() + "',";
		}
		if(restPayroll.getMedAllow() != null || restPayroll.getMedAllow() != "") {
			S = S + "@p_medAllow='" + restPayroll.getMedAllow() + "',";
		}
		if(restPayroll.getInsAmt() != null || restPayroll.getInsAmt() != "") {
			S = S + "@p_insAmt='" + restPayroll.getInsAmt() + "',";
		}
		if(restPayroll.getWashAllow() != null || restPayroll.getWashAllow() != "") {
			S = S + "@p_washAllow='" + restPayroll.getWashAllow() + "',";
		}
		if(restPayroll.getLic() != null || restPayroll.getLic() != "") {
			S = S + "@p_lic='" + restPayroll.getLic() + "',";
		}
//		if(restPayroll.getBonus() != null || restPayroll.getBonus() != "") {
//			S = S + "@p_bonus='" + restPayroll.getBonus() + "',";
//		}
//		if(restPayroll.getSocy() != null || restPayroll.getSocy() != "") {
//			S = S + "@p_socy='" + restPayroll.getSocy() + "',";
//		}
//		if(restPayroll.getOverTime() != null || restPayroll.getOverTime() != "") {
//			S = S + "@p_overTime='" + restPayroll.getOverTime() + "',";
//		}
//		if(restPayroll.getFine() != null || restPayroll.getFine() != "") {
//			S = S + "@p_fine='" + restPayroll.getFine() + "',";
//		}
//		if(restPayroll.getMisc() != null || restPayroll.getMisc() != "") {
//			S = S + "@p_misc='" + restPayroll.getMisc() + "',";
//		}
//		if(restPayroll.getDamage() != null || restPayroll.getDamage() != "") {
//			S = S + "@p_damage='" + restPayroll.getDamage() + "',";
//		}
//		if(restPayroll.getOtherEarn() != null || restPayroll.getOtherEarn() != "") {
//			S = S + "@p_otherEarn='" + restPayroll.getOtherEarn() + "',";
//		}
//		if(restPayroll.getOtherDeduct() != null || restPayroll.getOtherDeduct() != "") {
//			S = S + "@p_otherDeduct='" + restPayroll.getOtherDeduct() + "',";
//		}
		
//		if(restPayroll.getmBonus() != null || restPayroll.getmBonus() != "") {
//			S = S + "@p_mBonus='" + restPayroll.getmBonus() + "',";
//		}
//		if(restPayroll.getPfWages() != null || restPayroll.getPfWages() != "") {
//			S = S + "@p_pfWages='" + restPayroll.getPfWages() + "',";
//		}
//		if(restPayroll.getPensionWage() != null || restPayroll.getPensionWage() != "") {
//			S = S + "@p_pensionWage='" + restPayroll.getPensionWage() + "',";
//		}
//		if(restPayroll.getWageChecking() != null || restPayroll.getWageChecking() != "") {
//			S = S + "@p_wageChecking='" + restPayroll.getWageChecking() + "',";
//		}
//		if(restPayroll.getPtwage() != null || restPayroll.getPtwage() != "") {
//			S = S + "@p_ptwage='" + restPayroll.getPtwage() + "',";
//		}
//		if(restPayroll.getEpsEmployer() != null || restPayroll.getEpsEmployer() != "") {
//			S = S + "@p_epsEmployer='" + restPayroll.getEpsEmployer() + "',";
//		}
//		if(restPayroll.getEdliWage() != null || restPayroll.getEdliWage() != "") {
//			S = S + "@p_edliWage='" + restPayroll.getEdliWage() + "',";
//		}
		if(restPayroll.getEsicWage() != null || restPayroll.getEsicWage() != "") {
			S = S + "@p_esicWage='" + restPayroll.getEsicWage() + "',";
		}
//		if(restPayroll.getyGratuity() != null || restPayroll.getyGratuity() != "") {
//			S = S + "@p_yGratuity='" + restPayroll.getyGratuity() + "',";
//		}
//		if(restPayroll.getmGratuity() != null || restPayroll.getmGratuity() != "") {
//			S = S + "@p_mGratuity='" + restPayroll.getmGratuity() + "',";
//		}
		if(restPayroll.getmEmployerPf() != null || restPayroll.getmEmployerPf() != "") {
			S = S + "@p_mEmployerPf='" + restPayroll.getmEmployerPf() + "',";
		}
		if(restPayroll.getTotalContribution() != null || restPayroll.getTotalContribution() != "") {
			S = S + "@p_totalContribution='" + restPayroll.getTotalContribution() + "',";
		}
		
		if(restPayroll.getTotalEarn() != null || restPayroll.getTotalEarn() != "") {
			S = S + "@p_totalEarn='" + restPayroll.getTotalEarn() + "',";
		}
		if(restPayroll.getTotalDeduct() != null || restPayroll.getTotalDeduct() != "") {
			S = S + "@p_totalDeduct='" + restPayroll.getTotalDeduct() + "',";
		}
		if(restPayroll.getNetPay() != null || restPayroll.getNetPay() != "") {
			S = S + "@p_netPay='" + restPayroll.getNetPay() + "',";
		}
		if (S != "") {
			S = S.substring(0, S.length() - 1);

			S = "SET " + S + ";";
		}
		System.out.println(S);
		return S;
	}
	
	

}
