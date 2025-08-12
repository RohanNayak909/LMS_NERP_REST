package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;


public class GenerateRCFTMParam {
	public static String getAddRCFTM(List<QaRCFTMRestModel> qp) {
		String s = "";
		String sitem = "";
		String sitem1 = "";
		String sitem2 = "";

		if (qp.get(0).getRunChartId() != null || qp.get(0).getRunChartId() != "") {
			s = s + "@p_RunChartId='" + qp.get(0).getRunChartId() + "',";
		}

		if (qp.get(0).getrDate() != null || qp.get(0).getrDate() != "") {
			s = s + "@p_rDate='" + qp.get(0).getrDate() + "',";
		}

		if (qp.get(0).getrChart() != null || qp.get(0).getrChart() != "") {
			s = s + "@p_rChart='" + qp.get(0).getrChart() + "',";
		}
		if (qp.get(0).getrId() != null || qp.get(0).getrId() != "") {
			s = s + "@p_rId='" + qp.get(0).getrId() + "',";
		}
		
		if (qp.get(0).getCreatedBy() != null || qp.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + qp.get(0).getCreatedBy() + "',";
		}

		if (qp.get(0).getOrganization() != null || qp.get(0).getOrganization() != "") {
			s = s + "@p_org='" + qp.get(0).getOrganization() + "',";
		}
		if (qp.get(0).getOrgDivision() != null || qp.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + qp.get(0).getOrgDivision() + "',";
		}

		for (QaRCFTMRestModel m : qp) {
			
			 if ("1st".equals(m.getType())) {
				 sitem = sitem + "(@p_RunChartId,\"" + m.getNum()+ "\",\"" + m.getNum1()+ "\",\"" + m.getNum2()  + "\",\"" + m.getNum3() +"\",\"" + m.getNum4() +"\",\"" + m.getNum5() +"\",\"" + m.getNum6() +"\",\"" + m.getNum7() +"\",\""+ m.getNum8() +"\",\"" + m.getNum9() +"\",\"" + m.getNum10()+"\",\""+ m.getNum11() +"\",\"" + m.getNum12() +"\",\"" + m.getNum13()+"\",\""+ m.getNum14() +"\",\"" + m.getNum15() +"\",\"" + m.getNum16() 
					+ "\",\"" + m.getNum17() + "\",\"" + m.getNum18() + "\",\"" + m.getNum19()
					+ "\",\"" + m.getNum20() + "\",\"" + m.getNum21() + "\",\"" + m.getNum22()
					+ "\",\"" + m.getNum23() + "\",\"" + m.getNum24() + "\",\"" + m.getNum25()
					+ "\",\"" + m.getNum26() + "\",\"" + m.getNum27() + "\",\"" + m.getNum28()
					+ "\",\"" + m.getNum29() + "\",\"" + m.getNum30() + "\",\"" + m.getNum31()
					+ "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
							+ "\"),";
		}
		}
		sitem = sitem.substring(0, sitem.length() - 1);  // Remove the trailing comma
		s = s + "@p_itemSubQuery='" + sitem + "',";
		
		for (QaRCFTMRestModel m : qp) {
			
			 if ("second".equals(m.getType())) {
			sitem1 = sitem1 + "(@p_RunChartId,\"" + m.getNums()+ "\",\"" + m.getNums1()+ "\",\"" + m.getNums2()  + "\",\"" + m.getNums3() +"\",\"" + m.getNums4() +"\",\"" + m.getNums5() +"\",\"" + m.getNums6() +"\",\"" + m.getNums7() +"\",\""+ m.getNums8() +"\",\"" + m.getNums9() +"\",\"" + m.getNums10()+"\",\""+ m.getNums11() +"\",\"" + m.getNums12() +"\",\"" + m.getNums13()+"\",\""+ m.getNums14() +"\",\"" + m.getNums15() +"\",\"" + m.getNums16() 
			+ "\",\"" + m.getNums17() + "\",\"" + m.getNums18() + "\",\"" + m.getNums19()
			+ "\",\"" + m.getNums20() + "\",\"" + m.getNums21() + "\",\"" + m.getNums22()
			+ "\",\"" + m.getNums23() + "\",\"" + m.getNums24() + "\",\"" + m.getNums25()
			+ "\",\"" + m.getNums26() + "\",\"" + m.getNums27() + "\",\"" + m.getNums28()
			+ "\",\"" + m.getNums29() + "\",\"" + m.getNums30() + "\",\"" + m.getNums31()
			+ "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
					+ "\"),";
		}
		}
		sitem1 = sitem1.substring(0, sitem1.length() - 1);  // Remove the trailing comma
		s = s + "@p_itemSubQuery1='" + sitem1 + "',";
		
		 
		for (QaRCFTMRestModel m : qp) {
			
			System.out.println("getNumCat"+m.getNumCat()); 
			
			 if ("third".equals(m.getType())) {
			sitem2 = sitem2 + "(@p_RunChartId,\"" + m.getNumCat()+ "\",\"" + m.getNumt()+ "\", \"" + m.getNumt1()+ "\",\"" + m.getNumt2()  + "\",\"" + m.getNumt3() +"\",\"" + m.getNumt4() +"\",\"" + m.getNumt5() +"\",\"" + m.getNumt6() +"\",\"" + m.getNumt7() +"\",\""+ m.getNumt8() +"\",\"" + m.getNumt9() +"\",\"" + m.getNumt10()+"\",\""+ m.getNumt11() +"\",\"" + m.getNumt12() +"\",\"" + m.getNumt13()+"\",\""+ m.getNumt14() +"\",\"" + m.getNumt15() +"\",\"" + m.getNumt16() 
			+ "\",\"" + m.getNumt17() + "\",\"" + m.getNumt18() + "\",\"" + m.getNumt19()
			+ "\",\"" + m.getNumt20() + "\",\"" + m.getNumt21() + "\",\"" + m.getNumt22()
			+ "\",\"" + m.getNumt23() + "\",\"" + m.getNumt24() + "\",\"" + m.getNumt25()
			+ "\",\"" + m.getNumt26() + "\",\"" + m.getNumt27() + "\",\"" + m.getNumt28()
			+ "\",\"" + m.getNumt29() + "\",\"" + m.getNumt30() + "\",\"" + m.getNumt31()
			+ "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
					+ "\"),";
		}
		}
		
		sitem2 = sitem2.substring(0, sitem2.length() - 1);  // Remove the trailing comma
		s = s + "@p_itemSubQuery2='" + sitem2 + "',";
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	} 
	
	public static String getAddcrqsInspect(List<QaCrqsRestModel> qp) {
		String s = "";
		String sitem = "";

		if (qp.get(0).getCrqsId() != null || qp.get(0).getCrqsId() != "") {
			s = s + "@p_CrqsId='" + qp.get(0).getCrqsId() + "',";
		}

		for (QaCrqsRestModel m : qp) {

			sitem = sitem + "(@p_CrqsId,\"" + m.getDefect()+ "\",\"" + m.getDesc()+ "\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);
		System.out.println("###########"+sitem);
		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
public static String saveMasterDetails(QaRCFTMRestModel product) {
		
		String s = "";
		
		
		if (product.getRunChartId() != null ||product.getRunChartId() != "") {
			s = s + "@p_RunChartId='" + product.getRunChartId() + "',";
		}

		if (product.getYearDropdown() != null || product.getYearDropdown() != "") {
			s = s + "@p_year='" + product.getYearDropdown() + "',";
		}

		if (product.getMonthDropdown() != null || product.getMonthDropdown() != "") {
			s = s + "@p_month='" + product.getMonthDropdown() + "',";
		}
		if (product.getRemarks() != null || product.getRemarks() != "") {
			s = s + "@p_remarks='" + product.getRemarks() + "',";
		}
		
		if (product.getCreatedBy() != null ||product.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + product.getCreatedBy() + "',";
		}

		if (product.getOrganization() != null || product.getOrganization() != "") {
			s = s + "@p_org='" + product.getOrganization() + "',";
		}
		if (product.getOrgDivision() != null || product.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + product.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
}

public static String saveItemDetails(QaRCFTMRestModel product) {
	
	String s = "";
	
	if (product.getSlNo() != null ||product.getSlNo() != "") {
		s = s + "@p_SlNo='" + product.getSlNo() + "',";
	}
	if (product.getRunChartId() != null ||product.getRunChartId() != "") {
		s = s + "@p_RunChartId='" + product.getRunChartId() + "',";
	}

	if (product.getDate() != null || product.getDate() != "") {
		s = s + "@p_date='" + product.getDate() + "',";
	}

	if (product.getTime() != null || product.getTime() != "") {
		s = s + "@p_time='" + product.getTime() + "',";
	}
	if (product.getTempDisplay() != null || product.getTempDisplay() != "") {
		s = s + "@p_tempDisplay='" + product.getTempDisplay() + "',";
	}
	if (product.getTempThermometer() != null || product.getTempThermometer() != "") {
		s = s + "@p_tempThermometer='" + product.getTempThermometer() + "',";
	}
	
	if (product.getCreatedBy() != null ||product.getCreatedBy() != "") {
		s = s + "@p_createdBy='" + product.getCreatedBy() + "',";
	}

	if (product.getOrganization() != null || product.getOrganization() != "") {
		s = s + "@p_org='" + product.getOrganization() + "',";
	}
	if (product.getOrgDivision() != null || product.getOrgDivision() != "") {
		s = s + "@p_orgDiv='" + product.getOrgDivision() + "',";
	}
	if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
	}

	System.out.println(s);
	
	return s;
}
}
