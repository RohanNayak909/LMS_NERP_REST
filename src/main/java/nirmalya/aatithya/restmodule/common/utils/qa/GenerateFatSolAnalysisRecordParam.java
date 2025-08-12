package nirmalya.aatithya.restmodule.common.utils.qa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;
import nirmalya.aatithya.restmodule.qa.model.PACAnalysisRecordRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestFatSolAnalysisModel;

public class GenerateFatSolAnalysisRecordParam {
	public static String getRecordParam(RestFatSolAnalysisModel model) {

		String s = "";

		String fatSolAnalysisId = model.getFatSolAnalysisId();
		String date = model.getDate();
		String rsts = model.getrStatus();

		String createdBy = model.getCreatedBy();
		String organization = model.getOrganization();
		String orgDivision = model.getOrgDivision();

		String product1 = model.getProduct1();
		String batchNo1 = model.getBatchNo1();
		String netWtG1 = model.getNetWtG1();
		String tWtCFlsk1 = model.gettWtCFlsk1();
		String gWtCFlsk1 = model.getgWtCFlsk1();
		String netWeightG1 = model.getNetWeightG1();
		String gWtCFlskOven1 = model.getgWtCFlskOven1();
		String fatSlAIA1 = model.getFatSlAIA1();

		String product2 = model.getProduct2();
		String batchNo2 = model.getBatchNo2();
		String netWtG2 = model.getNetWtG2();
		String tWtCFlsk2 = model.gettWtCFlsk2();
		String gWtCFlsk2 = model.getgWtCFlsk2();
		String netWeightG2 = model.getNetWeightG2();
		String gWtCFlskOven2 = model.getgWtCFlskOven2();
		String fatSlAIA2 = model.getFatSlAIA2();

		String product3 = model.getProduct3();
		String batchNo3 = model.getBatchNo3();
		String netWtG3 = model.getNetWtG3();
		String tWtCFlsk3 = model.gettWtCFlsk3();
		String gWtCFlsk3 = model.getgWtCFlsk3();
		String netWeightG3 = model.getNetWeightG3();
		String gWtCFlskOven3 = model.getgWtCFlskOven3();
		String fatSlAIA3 = model.getFatSlAIA3();

		String product4 = model.getProduct4();
		String batchNo4 = model.getBatchNo4();
		String netWtG4 = model.getNetWtG4();
		String tWtCFlsk4 = model.gettWtCFlsk4();
		String gWtCFlsk4 = model.getgWtCFlsk4();
		String netWeightG4 = model.getNetWeightG4();
		String gWtCFlskOven4 = model.getgWtCFlskOven4();
		String fatSlAIA4 = model.getFatSlAIA4();
		
		String refNo = model.getRefNo();
		String issueNo = model.getIssueNo();
		String dateOfIssue = model.getDateOfIssue();
		String recordType1 = model.getRecordType1();
		String recordType2 = model.getRecordType2();
		String recordType3 = model.getRecordType3();
		String recordType4 = model.getRecordType4();
		String productTypeField = model.getProductTypeField();

		s = s + "@p_fatSolAnalysisId='" + fatSolAnalysisId + "',";
		s = s + "@p_date='" + date + "',";
		s = s + "@p_rsts='" + rsts + "',";

		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";

		s = s + "@p_product1='" + product1 + "',";
		s = s + "@p_batchNo1='" + batchNo1 + "',";
		s = s + "@p_netWtG1='" + netWtG1 + "',";
		s = s + "@p_tWtCFlsk1='" + tWtCFlsk1 + "',";
		s = s + "@p_gWtCFlsk1='" + gWtCFlsk1 + "',";
		s = s + "@p_netWeightG1='" + netWeightG1 + "',";
		s = s + "@p_gWtCFlskOven1='" + gWtCFlskOven1 + "',";
		s = s + "@p_fatSlAIA1='" + fatSlAIA1 + "',";

		s = s + "@p_product2='" + product2 + "',";
		s = s + "@p_batchNo2='" + batchNo2 + "',";
		s = s + "@p_netWtG2='" + netWtG2 + "',";
		s = s + "@p_tWtCFlsk2='" + tWtCFlsk2 + "',";
		s = s + "@p_gWtCFlsk2='" + gWtCFlsk2 + "',";
		s = s + "@p_netWeightG2='" + netWeightG2 + "',";
		s = s + "@p_gWtCFlskOven2='" + gWtCFlskOven2 + "',";
		s = s + "@p_fatSlAIA2='" + fatSlAIA2 + "',";

		s = s + "@p_product3='" + product3 + "',";
		s = s + "@p_batchNo3='" + batchNo3 + "',";
		s = s + "@p_netWtG3='" + netWtG3 + "',";
		s = s + "@p_tWtCFlsk3='" + tWtCFlsk3 + "',";
		s = s + "@p_gWtCFlsk3='" + gWtCFlsk3 + "',";
		s = s + "@p_netWeightG3='" + netWeightG3 + "',";
		s = s + "@p_gWtCFlskOven3='" + gWtCFlskOven3 + "',";
		s = s + "@p_fatSlAIA3='" + fatSlAIA3 + "',";

		s = s + "@p_product4='" + product4 + "',";
		s = s + "@p_batchNo4='" + batchNo4 + "',";
		s = s + "@p_netWtG4='" + netWtG4 + "',";
		s = s + "@p_tWtCFlsk4='" + tWtCFlsk4 + "',";
		s = s + "@p_gWtCFlsk4='" + gWtCFlsk4 + "',";
		s = s + "@p_netWeightG4='" + netWeightG4 + "',";
		s = s + "@p_gWtCFlskOven4='" + gWtCFlskOven4 + "',";
		s = s + "@p_fatSlAIA4='" + fatSlAIA4 + "',";
		
		s = s + "@p_refNo='" + refNo + "',";
		s = s + "@p_issueNo='" + issueNo + "',";
		s = s + "@p_dateOfIssue='" + dateOfIssue + "',";
		s = s + "@p_recordType1='" + recordType1 + "',";
		s = s + "@p_recordType2='" + recordType2 + "',";
		s = s + "@p_recordType3='" + recordType3 + "',";
		s = s + "@p_recordType4='" + recordType4 + "',";
		s = s + "@p_productTypeField='" + productTypeField + "',";

		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Generate Parameter" + s);

		return s;
	}

	public static String getProcessApproveParam(RestAdvanceManagementModel advance) {

		String s = "";
		String pdata = "";

		String advanceId = advance.getAdvanceId();
		s = s + "@p_advanceId='" + advanceId + "',";

		int ten = Integer.parseInt(advance.getTernure());

		for (int i = 1; i <= ten; i++) {
			LocalDate futureDate = LocalDate.now().plusMonths(i);
			int m = futureDate.getMonthValue();
			int y = futureDate.getYear();
			String duedate = y + "-" + m + "-" + "01";

			pdata = pdata + "(\"" + advance.getAdvanceId() + "\",\"" + advance.getEmpID() + "\",\"" + duedate + "\",\""
					+ advance.getLoanamt() + "\",\"" + advance.getTernure() + "\",\"" + advance.getIntrestRate()
					+ "\",\"" + advance.getEmi() + "\",\"" + advance.getTotalInterest() + "\",\""
					+ advance.getCreatedBy() + "\"),";
		}
		if (pdata != "") {
			pdata = pdata.substring(0, pdata.length() - 1);
			pdata = pdata + "";
		}
		s = s + "@P_subQuery='" + pdata + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Generate Parameter" + s);

		return s;
	}

}