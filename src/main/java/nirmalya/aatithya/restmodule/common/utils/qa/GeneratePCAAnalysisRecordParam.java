package nirmalya.aatithya.restmodule.common.utils.qa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;
import nirmalya.aatithya.restmodule.qa.model.PACAnalysisRecordRestModel;

public class GeneratePCAAnalysisRecordParam {
	public static String getRecordParam( PACAnalysisRecordRestModel  model) {

		String s = "";
 
		String pcaAnalysisId = model.getPcaAnalysisId();
		String	date = model.getDate();
		String	nEDTA = model.getnEDTA();
		String nh2So4 = model.getNh2So4(); 
		String	ml = model.getMl();
		String	rsts = model.getrStatus();
		String	productTypeField = model.getProductTypeField();
		
		String	createdBy = model.getCreatedBy();
		String organization=model.getOrganization(); 
		String orgDivision=model.getOrgDivision();
		
		String product1 = model.getProduct1();
		String	batchNo1 = model.getBatchNo1();
		String	netWtG1 = model.getNetWtG1();
		String h2so4ml1 = model.getH2so4ml1(); 
		String	pCal1 = model.getpCal1();
		
		String product2 = model.getProduct2();
		String	batchNo2 = model.getBatchNo2();
		String	netWtG2 = model.getNetWtG2();
		String h2so4ml2 = model.getH2so4ml2(); 
		String	pCal2 = model.getpCal2();
		
		
		String product3 = model.getProduct3();
		String	batchNo3 = model.getBatchNo3();
		String	netWtG3 = model.getNetWtG3();
		String h2so4ml3 = model.getH2so4ml3(); 
		String	pCal3 = model.getpCal3();
		
		
		String product4 = model.getProduct4();
		String	batchNo4 = model.getBatchNo4();
		String	netWtG4 = model.getNetWtG4();
		String h2so4ml4 = model.getH2so4ml4(); 
		String	pCal4 = model.getpCal4();
		
		String product5 = model.getProduct5();
		String	batchNo5 = model.getBatchNo5();
		String	netWtG5 = model.getNetWtG5();
		String h2so4ml5 = model.getH2so4ml5(); 
		String	pCal5 = model.getpCal5();
		
		
		String product6 = model.getProduct6();
		String	batchNo6 = model.getBatchNo6();
		String	netWtG6 = model.getNetWtG6();
		String h2so4ml6 = model.getH2so4ml6(); 
		String	pCal6 = model.getpCal6();
		
		
	 
		s = s + "@p_pcaAnalysisId='" + pcaAnalysisId + "',";
		s = s + "@p_date='" + date + "',";
		s = s + "@p_nEDTA='" + nEDTA + "',";
		s = s + "@p_nh2So4='" + nh2So4 + "',";
		s = s + "@p_ml='" + ml + "',";
		s = s + "@p_rsts='" + rsts + "',";
		s = s + "@p_productTypeField='" + productTypeField + "',";
		
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";
		
		
		s = s + "@p_product1='" + product1 + "',";
		s = s + "@p_batchNo1='" + batchNo1 + "',";
		s = s + "@p_netWtG1='" + netWtG1 + "',";
		s = s + "@p_h2so4ml1='" + h2so4ml1 + "',";
		s = s + "@p_pCal1='" + pCal1 + "',";
		
		s = s + "@p_product2='" + product2 + "',";
		s = s + "@p_batchNo2='" + batchNo2 + "',";
		s = s + "@p_netWtG2='" + netWtG2 + "',";
		s = s + "@p_h2so4ml2='" + h2so4ml2 + "',";
		s = s + "@p_pCal2='" + pCal2 + "',";
		
		s = s + "@p_product3='" + product3 + "',";
		s = s + "@p_batchNo3='" + batchNo3 + "',";
		s = s + "@p_netWtG3='" + netWtG3 + "',";
		s = s + "@p_h2so4ml3='" + h2so4ml3 + "',";
		s = s + "@p_pCal3='" + pCal3 + "',";
		
		s = s + "@p_product4='" + product4 + "',";
		s = s + "@p_batchNo4='" + batchNo4 + "',";
		s = s + "@p_netWtG4='" + netWtG4 + "',";
		s = s + "@p_h2so4ml4='" + h2so4ml4 + "',";
		s = s + "@p_pCal4='" + pCal4 + "',";
		
		s = s + "@p_product5='" + product5 + "',";
		s = s + "@p_batchNo5='" + batchNo5 + "',";
		s = s + "@p_netWtG5='" + netWtG5 + "',";
		s = s + "@p_h2so4ml5='" + h2so4ml5 + "',";
		s = s + "@p_pCal5='" + pCal5 + "',";
		
		s = s + "@p_product6='" + product6 + "',";
		s = s + "@p_batchNo6='" + batchNo6 + "',";
		s = s + "@p_netWtG6='" + netWtG6 + "',";
		s = s + "@p_h2so4ml6='" + h2so4ml6 + "',";
		s = s + "@p_pCal6='" + pCal6 + "',";
 
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Generate Parameter"+s);

		return s;
	}
	
	
	public static String getProcessApproveParam( RestAdvanceManagementModel  advance) {

		String s = "";
		String pdata = "";
		
		String advanceId = advance.getAdvanceId();
		s = s + "@p_advanceId='" + advanceId + "',";
		
		
		int ten=Integer.parseInt(advance.getTernure());		
		
		for (int i = 1; i <= ten ; i++) {
			LocalDate futureDate = LocalDate.now().plusMonths(i);
			int m=futureDate.getMonthValue();
			int y=futureDate.getYear();
			String duedate=y+"-"+m+"-"+"01";
		 
			pdata = pdata + "(\"" +advance.getAdvanceId()+"\",\""+advance.getEmpID()+"\",\""+duedate+"\",\""+advance.getLoanamt()+"\",\""+advance.getTernure()+"\",\""+advance.getIntrestRate()+"\",\""+advance.getEmi()+"\",\""+advance.getTotalInterest()+"\",\""+ advance.getCreatedBy() +"\"),";
		}
		if (pdata != "") {
			pdata = pdata.substring(0, pdata.length() - 1);
			pdata = pdata+"";
		}
		s =s+"@P_subQuery='"+pdata+"'," ;
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Generate Parameter"+s);

		return s;
	}	
	
}