package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.InvestDeclareSubModel;
import nirmalya.aatithya.restmodule.employee.model.RestInvestmentDeclarationModel;

public class GenerateInvestmentDeclarationParam {

	public static String getInvestmentDeclaration(List<RestInvestmentDeclarationModel> restInvestmentDeclarationModel) {
		String s = "";
		String listdata = "";
		String pkid = "";
		String docData = "";
		s = s + "@p_invest='" + pkid + "',";
		s = s + "@p_dept='" + "" + "',";
		s = s + "@p_subDept='" + "" + "',";
		s = s + "@p_empId='" +restInvestmentDeclarationModel.get(0).getEmpId() + "',";
		s = s + "@p_invest='" +restInvestmentDeclarationModel.get(0).getDeclarId() + "',";
		
		System.out.println("restInvestmentDeclarationModel%%%%%%%%%%%%%" + restInvestmentDeclarationModel);
		for (RestInvestmentDeclarationModel m : restInvestmentDeclarationModel) {

			List<InvestDeclareSubModel> investmentDetails = m.getInvestmentDetails();

			if(m.getDeclarId()==null ||m.getDeclarId()=="" || m.getDeclarId()=="null") {
				for (InvestDeclareSubModel a : investmentDetails) {
					String amt;
				if(a.getAmpount()==null || a.getAmpount()=="") {
					amt="0";
				}else {
					amt=a.getAmpount();
				}
					listdata = listdata + "(@p_invest,@p_dept,@p_subDept,\"" + m.getEmpId() + "\",\"" + m.getFinancialyr() + "\",\""
							+ m.getHeaderid() + "\",\"" + a.getSubheader() + "\"," +amt + ",\""
							+ a.getMaxPayment() + "\",\"" + DateFormatter.getStringDate(restInvestmentDeclarationModel.get(0).getFromDate()) + "\",\""
							+ DateFormatter.getStringDate(restInvestmentDeclarationModel.get(0).getToDate()) + "\",\"" + restInvestmentDeclarationModel.get(0).getOrganization() + "\",\"" + restInvestmentDeclarationModel.get(0).getOrgDiv() + "\"),";

				}
			}else {
				for (InvestDeclareSubModel a : investmentDetails) {
					String amt;
					String actamt;
					if(a.getAmpount()==null || a.getAmpount()=="") {
						amt="0";
					}else {
						amt=a.getAmpount();
					}
					if(a.getActualAmt()==null || a.getActualAmt()=="") {
						actamt="0";
					}else {
						actamt=a.getActualAmt();
					}
					listdata = listdata + "(\"" + m.getDeclarId() +"\",@p_dept,@p_subDept,\"" + m.getEmpId() + "\",\"" + m.getFinancialyr() + "\",\""
							+ m.getHeaderid() + "\",\"" + a.getSubheader() + "\"," +amt + "," + actamt+",\""
							+ a.getMaxPayment() + "\",\"" + DateFormatter.getStringDate(restInvestmentDeclarationModel.get(0).getFromDate()) + "\",\""
							+ DateFormatter.getStringDate(restInvestmentDeclarationModel.get(0).getToDate()) + "\",\"" + restInvestmentDeclarationModel.get(0).getOrganization() + "\",\"" + restInvestmentDeclarationModel.get(0).getOrgDiv() + "\"),";

				}
			}
System.out.println("m.getDocFile()==="+m.getDocFile());
			if(m.getDocFile()!="" && m.getDocFile()!=null && m.getDocFile()!="null" && m.getDocName()!="" && m.getDocName()!=null && m.getDocName()!="null") {
				docData = docData + "(@p_invest,\"" + m.getHeaderid()+ "\",\"" + m.getDocFile() + "\",\"" + m.getDocName() + "\",\"" + restInvestmentDeclarationModel.get(0).getOrganization() + "\",\"" + restInvestmentDeclarationModel.get(0).getOrgDiv() + "\"),";
			}

			System.out.println("docdata----------" + docData);

		}

		listdata = listdata.substring(0, listdata.length() - 1);
		if(!docData.isEmpty()) {
			docData = docData.substring(0, docData.length() - 1);
		}
		s = s + "@p_litemSubQuery='" + listdata + "',";
		s = s + "@p_doclist='" + docData + "',";

		// System.out.println("docData11111111111"+s);
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("2wwwwwwwwwwwww1"+s);
		return s;
	}

}