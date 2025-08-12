package nirmalya.aatithya.restmodule.common.utils.qa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;
import nirmalya.aatithya.restmodule.qa.model.PACAnalysisRecordRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestAshAnalysisRawDataModel;
import nirmalya.aatithya.restmodule.qa.model.RestFatSolAnalysisModel;

public class GenerateAshAnalysisRawDataRecordParam {
	public static String getAnalysisRecordParam(RestAshAnalysisRawDataModel model) {

		String s = "";

		String ashAnalysisRawId = model.getAshAnalysisRawId();
		String date = model.getDate();
		String rsts = model.getrStatus();

		String createdBy = model.getCreatedBy();
		String organization = model.getOrganization();
		String orgDivision = model.getOrgDivision();

		String product1 = model.getProduct1();
		String batchNo1 = model.getBatchNo1();
		String moisture1 = model.getMoisture1();
		String tWtCrubical1 = model.gettWtCrubical1();
		String gWtCrubical1 = model.getgWtCrubical1();
		String netWeightG1 = model.getNetWeightG1();
		String wtafterAsh1 = model.getWtafterAsh1();
		String ashAs1 = model.getAshAs1();
		String ashODB1 = model.getAshODB1();

		String product2 = model.getProduct2();
		String batchNo2 = model.getBatchNo2();
		String moisture2 = model.getMoisture2();
		String tWtCrubical2 = model.gettWtCrubical2();
		String gWtCrubical2 = model.getgWtCrubical2();
		String netWeightG2 = model.getNetWeightG2();
		String wtafterAsh2 = model.getWtafterAsh2();
		String ashAs2 = model.getAshAs2();
		String ashODB2 = model.getAshODB2();

		String product3 = model.getProduct3();
		String batchNo3 = model.getBatchNo3();
		String moisture3 = model.getMoisture3();
		String tWtCrubical3 = model.gettWtCrubical3();
		String gWtCrubical3 = model.getgWtCrubical3();
		String netWeightG3 = model.getNetWeightG3();
		String wtafterAsh3 = model.getWtafterAsh3();
		String ashAs3 = model.getAshAs3();
		String ashODB3 = model.getAshODB3();

		String product4 = model.getProduct4();
		String batchNo4 = model.getBatchNo4();
		String moisture4 = model.getMoisture4();
		String tWtCrubical4 = model.gettWtCrubical4();
		String gWtCrubical4 = model.getgWtCrubical4();
		String netWeightG4 = model.getNetWeightG4();
		String wtafterAsh4 = model.getWtafterAsh4();
		String ashAs4 = model.getAshAs4();
		String ashODB4 = model.getAshODB4();

		String product5 = model.getProduct5();
		String batchNo5 = model.getBatchNo5();
		String moisture5 = model.getMoisture5();
		String tWtCrubical5 = model.gettWtCrubical5();
		String gWtCrubical5 = model.getgWtCrubical5();
		String netWeightG5 = model.getNetWeightG5();
		String wtafterAsh5 = model.getWtafterAsh5();
		String ashAs5 = model.getAshAs5();
		String ashODB5 = model.getAshODB5();

		String product6 = model.getProduct6();
		String batchNo6 = model.getBatchNo6();
		String moisture6 = model.getMoisture6();
		String tWtCrubical6 = model.gettWtCrubical6();
		String gWtCrubical6 = model.getgWtCrubical6();
		String netWeightG6 = model.getNetWeightG6();
		String wtafterAsh6 = model.getWtafterAsh6();
		String ashAs6 = model.getAshAs6();
		String ashODB6 = model.getAshODB6();
		
		String refNo = model.getRefNo();
		String issueNo = model.getIssueNo();
		String dateOfIssue = model.getDateOfIssue();
		
		String sku1 = model.getSku1();
		String sku2 = model.getSku2();
		String sku3 = model.getSku3();
		String sku4 = model.getSku4();
		String sku5 = model.getSku5();
		String sku6 = model.getSku6();
		
		String productTypeField = model.getProductTypeField();
		

		s = s + "@p_ashAnalysisRawId='" + ashAnalysisRawId + "',";
		s = s + "@p_date='" + date + "',";
		s = s + "@p_rsts='" + rsts + "',";

		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";

		s = s + "@p_product1='" + product1 + "',";
		s = s + "@p_batchNo1='" + batchNo1 + "',";
		s = s + "@p_moisture1='" + moisture1 + "',";
		s = s + "@p_tWtCrubical1='" + tWtCrubical1 + "',";
		s = s + "@p_gWtCrubical1='" + gWtCrubical1 + "',";
		s = s + "@p_netWeightG1='" + netWeightG1 + "',";
		s = s + "@p_wtafterAsh1='" + wtafterAsh1 + "',";
		s = s + "@p_ashAs1='" + ashAs1 + "',";
		s = s + "@p_ashODB1='" + ashODB1 + "',";

		s = s + "@p_product2='" + product2 + "',";
		s = s + "@p_batchNo2='" + batchNo2 + "',";
		s = s + "@p_moisture2='" + moisture2 + "',";
		s = s + "@p_tWtCrubical2='" + tWtCrubical2 + "',";
		s = s + "@p_gWtCrubical2='" + gWtCrubical2 + "',";
		s = s + "@p_netWeightG2='" + netWeightG2 + "',";
		s = s + "@p_wtafterAsh2='" + wtafterAsh2 + "',";
		s = s + "@p_ashAs2='" + ashAs2 + "',";
		s = s + "@p_ashODB2='" + ashODB2 + "',";

		s = s + "@p_product3='" + product3 + "',";
		s = s + "@p_batchNo3='" + batchNo3 + "',";
		s = s + "@p_moisture3='" + moisture3 + "',";
		s = s + "@p_tWtCrubical3='" + tWtCrubical3 + "',";
		s = s + "@p_gWtCrubical3='" + gWtCrubical3 + "',";
		s = s + "@p_netWeightG3='" + netWeightG3 + "',";
		s = s + "@p_wtafterAsh3='" + wtafterAsh3 + "',";
		s = s + "@p_ashAs3='" + ashAs3 + "',";
		s = s + "@p_ashODB3='" + ashODB3 + "',";

		s = s + "@p_product4='" + product4 + "',";
		s = s + "@p_batchNo4='" + batchNo4 + "',";
		s = s + "@p_moisture4='" + moisture4 + "',";
		s = s + "@p_tWtCrubical4='" + tWtCrubical4 + "',";
		s = s + "@p_gWtCrubical4='" + gWtCrubical4 + "',";
		s = s + "@p_netWeightG4='" + netWeightG4 + "',";
		s = s + "@p_wtafterAsh4='" + wtafterAsh4 + "',";
		s = s + "@p_ashAs4='" + ashAs4 + "',";
		s = s + "@p_ashODB4='" + ashODB4 + "',";

		s = s + "@p_product5='" + product5 + "',";
		s = s + "@p_batchNo5='" + batchNo5 + "',";
		s = s + "@p_moisture5='" + moisture5 + "',";
		s = s + "@p_tWtCrubical5='" + tWtCrubical5 + "',";
		s = s + "@p_gWtCrubical5='" + gWtCrubical5 + "',";
		s = s + "@p_netWeightG5='" + netWeightG5 + "',";
		s = s + "@p_wtafterAsh5='" + wtafterAsh5 + "',";
		s = s + "@p_ashAs5='" + ashAs5 + "',";
		s = s + "@p_ashODB5='" + ashODB5 + "',";

		s = s + "@p_product6='" + product6 + "',";
		s = s + "@p_batchNo6='" + batchNo6 + "',";
		s = s + "@p_moisture6='" + moisture6 + "',";
		s = s + "@p_tWtCrubical6='" + tWtCrubical6 + "',";
		s = s + "@p_gWtCrubical6='" + gWtCrubical6 + "',";
		s = s + "@p_netWeightG6='" + netWeightG6 + "',";
		s = s + "@p_wtafterAsh6='" + wtafterAsh6 + "',";
		s = s + "@p_ashAs6='" + ashAs6 + "',";
		s = s + "@p_ashODB6='" + ashODB6 + "',";
		
		s = s + "@p_refNo='" + refNo + "',";
		s = s + "@p_issueNo='" + issueNo + "',";
		s = s + "@p_dateOfIssue='" + dateOfIssue + "',";
		
		s = s + "@p_sku1='" + sku1 + "',";
		s = s + "@p_sku2='" + sku2 + "',";
		s = s + "@p_sku3='" + sku3 + "',";
		s = s + "@p_sku4='" + sku4 + "',";
		s = s + "@p_sku5='" + sku5 + "',";
		s = s + "@p_sku6='" + sku6 + "',";
		
		s = s + "@p_productTypeField='" + productTypeField + "',";

		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Generate Parameter" + s);

		return s;
	}

	
}