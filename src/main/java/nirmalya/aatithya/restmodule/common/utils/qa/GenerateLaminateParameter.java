package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.qa.model.LaminateModel;

public class GenerateLaminateParameter {

	public static String getAddLaminate(List<LaminateModel> lm) {
		String s = "";
		String sitem = "";

		if (lm.get(0).getLaminateId() != null || lm.get(0).getLaminateId() != "") {
			s = s + "@p_laminateId='" + lm.get(0).getLaminateId() + "',";
		}

		if (lm.get(0).getPdate() != null || lm.get(0).getPdate() != "") {
			s = s + "@p_pdate='" + DateFormatter.getStringDate(lm.get(0).getPdate()) + "',";
		}

		if (lm.get(0).getMrp() != null || lm.get(0).getMrp() != "") {
			s = s + "@p_mrp='" + lm.get(0).getMrp() + "',";
		}
		if (lm.get(0).getPkd() != null || lm.get(0).getPkd() != "") {
			s = s + "@p_pkd='" + lm.get(0).getPkd() + "',";
		}
		if (lm.get(0).getInvoiceQty() != null || lm.get(0).getInvoiceQty() != "") {
			s = s + "@p_invoiceQty='" + lm.get(0).getInvoiceQty() + "',";
		}
		if (lm.get(0).getGrnNo() != null || lm.get(0).getGrnNo() != "") {
			s = s + "@p_grnNo='" + lm.get(0).getGrnNo() + "',";
		}
		if (lm.get(0).getSuppliers() != null || lm.get(0).getSuppliers() != "") {
			s = s + "@p_suppliers='" + lm.get(0).getSuppliers() + "',";
		}
		if (lm.get(0).getLamiFfsRoll() != null || lm.get(0).getLamiFfsRoll() != "") {
			s = s + "@p_lamiFfsRoll='" + lm.get(0).getLamiFfsRoll() + "',";
		}
		if (lm.get(0).getInvoiceDate() != null || lm.get(0).getInvoiceDate() != "") {
			s = s + "@p_invoiceDate='" + lm.get(0).getInvoiceDate() + "',";
		}
		if (lm.get(0).getPerformanceTest() != null || lm.get(0).getPerformanceTest() != "") {
			s = s + "@p_performanceTest='" + lm.get(0).getPerformanceTest() + "',";
		}
		if (lm.get(0).getPouchesTest() != null || lm.get(0).getPouchesTest() != "") {
			s = s + "@p_pouchesTest='" + lm.get(0).getPouchesTest() + "',";
		}
		if (lm.get(0).getLaminatationTest() != null || lm.get(0).getLaminatationTest() != "") {
			s = s + "@p_laminatationTest='" + lm.get(0).getLaminatationTest() + "',";
		}
		if (lm.get(0).getColourTest() != null || lm.get(0).getColourTest() != "") {
			s = s + "@p_colourTest='" + lm.get(0).getColourTest() + "',";
		}
		if (lm.get(0).getPrintQualityTest() != null || lm.get(0).getPrintQualityTest() != "") {
			s = s + "@p_printQualityTest='" + lm.get(0).getPrintQualityTest() + "',";
		}
		if (lm.get(0).getOdourinTest() != null || lm.get(0).getOdourinTest() != "") {
			s = s + "@p_odourinTest='" + lm.get(0).getOdourinTest() + "',";
		}
		if (lm.get(0).getHeatEnduranceTest() != null || lm.get(0).getHeatEnduranceTest() != "") {
			s = s + "@p_heatEnduranceTest='" + lm.get(0).getHeatEnduranceTest() + "',";
		}
		if (lm.get(0).getDartImpact() != null || lm.get(0).getDartImpact() != "") {
			s = s + "@p_dartImpact='" + lm.get(0).getDartImpact() + "',";
		}
		if (lm.get(0).getTearStrengthCd() != null || lm.get(0).getTearStrengthCd() != "") {
			s = s + "@p_tearStrengthCd='" + lm.get(0).getTearStrengthCd() + "',";
		}
		if (lm.get(0).getTearStrengthMd() != null || lm.get(0).getTearStrengthMd() != "") {
			s = s + "@p_tearStrengthMd='" + lm.get(0).getTearStrengthMd() + "',";
		}
		if (lm.get(0).getDynamicface() != null || lm.get(0).getDynamicface() != "") {
			s = s + "@p_dynamicFace='" + lm.get(0).getDynamicface() + "',";
		}
		if (lm.get(0).getDynamicreverse() != null || lm.get(0).getDynamicreverse() != "") {
			s = s + "@p_dynamicReverse='" + lm.get(0).getDynamicreverse() + "',";
		}
		if (lm.get(0).getCofstatic() != null || lm.get(0).getCofstatic() != "") {
			s = s + "@p_cofStatic='" + lm.get(0).getCofstatic() + "',";
		}
		if (lm.get(0).getStaticface() != null || lm.get(0).getStaticface() != "") {
			s = s + "@p_staticFace='" + lm.get(0).getStaticface() + "',";
		}
		if (lm.get(0).getTensilcd() != null || lm.get(0).getTensilcd() != "") {
			s = s + "@p_tensilCd='" + lm.get(0).getTensilcd() + "',";
		}
		if (lm.get(0).getStrengthmd() != null || lm.get(0).getStrengthmd() != "") {
			s = s + "@p_strengthMd='" + lm.get(0).getStrengthmd() + "',";
		}
		if (lm.get(0).getAfterpacking() != null || lm.get(0).getAfterpacking() != "") {
			s = s + "@p_afterPacking='" + lm.get(0).getAfterpacking() + "',";
		}
		
		if (lm.get(0).getSealStrength() != null || lm.get(0).getSealStrength() != "") {
			s = s + "@p_sealStrength='" + lm.get(0).getSealStrength() + "',";
		}
		if (lm.get(0).getLaminationStrengh() != null || lm.get(0).getLaminationStrengh() != "") {
			s = s + "@p_laminationStrengh='" + lm.get(0).getLaminationStrengh() + "',";
		}
		if (lm.get(0).getAvgLength() != null || lm.get(0).getAvgLength() != "") {
			s = s + "@p_avgLength='" + lm.get(0).getAvgLength() + "',";
		}
		if (lm.get(0).getAvgWidth() != null || lm.get(0).getAvgWidth() != "") {
			s = s + "@p_avgWidth='" + lm.get(0).getAvgWidth() + "',";
		}
		if (lm.get(0).getAvgThicknes() != null || lm.get(0).getAvgThicknes() != "") {
			s = s + "@p_avgThicknes='" + lm.get(0).getAvgThicknes() + "',";
		}
		if (lm.get(0).getAvgGsm() != null || lm.get(0).getAvgGsm() != "") {
			s = s + "@p_getAvgGsm='" + lm.get(0).getAvgGsm() + "',";
		}
		if (lm.get(0).getAvgWeight() != null || lm.get(0).getAvgWeight() != "") {
			s = s + "@p_avgWeight='" + lm.get(0).getAvgWeight() + "',";
		}
		if (lm.get(0).getRejection() != null || lm.get(0).getRejection() != "") {
			s = s + "@p_rejection='" + lm.get(0).getRejection() + "',";
		}
		
		if (lm.get(0).getRemarks() != null || lm.get(0).getRemarks() != "") {
			s = s + "@p_remark='" + lm.get(0).getRemarks() + "',";
		}
		
		if (lm.get(0).getCreatedBy() != null || lm.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + lm.get(0).getCreatedBy() + "',";
		}

		if (lm.get(0).getOrganization() != null || lm.get(0).getOrganization() != "") {
			s = s + "@p_org='" + lm.get(0).getOrganization() + "',";
		}
		if (lm.get(0).getOrgDivision() != null || lm.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + lm.get(0).getOrgDivision() + "',";
		}
		
		if (lm.get(0).getReqid() != null || lm.get(0).getReqid() != "") {
			s = s + "@p_reqId='" + lm.get(0).getReqid() + "',";
		}
		
		if (lm.get(0).getSku() != null || lm.get(0).getSku() != "") {
			s = s + "@p_skuId='" + lm.get(0).getSku() + "',";
		}
		
		if (lm.get(0).getTestRes() != null || lm.get(0).getTestRes() != "") {
			s = s + "@p_testRes='" + lm.get(0).getTestRes() + "',";
		}

		for (LaminateModel m : lm) {

			sitem = sitem + "(@p_laminateId,\"" + m.getReqid() + "\",\"" + m.getSlNo() + "\",\"" + m.getLengthmm() + "\",\"" + m.getWidthmm() +"\",\"" + m.getWeightgms() +"\",\"" + m.getGsmgm() +"\",\"" + m.getThicknessMicron() 
					+ "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
					+ "\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
}
