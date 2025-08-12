package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.ArrayList;
import java.util.List;

import nirmalya.aatithya.restmodule.qa.model.QaDarRestModel;

public class GenerateDarParam {

	public static String getAddDar(List<QaDarRestModel> qp) {

		String s = "";
		String sitem = "";
		String sitem1 = "";
		String sitem2 = "";
		String qItem = "";
		List<String> data = new ArrayList<>();
		data.addAll(qp.get(0).getMachineNumber());
		//System.out.println("data="+data);
		

		//System.out.println("machineNo>>>>>>---------------"+data);
		
		if(!data.isEmpty()) {
			for (int i =0; i < data.size() ; i++) {
				
				qItem = qItem + "(@p_DarId,\"" + data.get(i) + "\",\"" + qp.get(0).getOrganization()+ "\",\"" + qp.get(0).getOrgDivision() + "\"),";
				
				
			}
			qItem = qItem.substring(0, qItem.length() - 1);
		}else {
			
		}
		
		 

		if (qp.get(0).getDarId() != null || qp.get(0).getDarId() != "") {
			s = s + "@p_DarId='" + qp.get(0).getDarId() + "',";
		}
		if (qp.get(0).getDate() != null || qp.get(0).getDate() != "") {
			s = s + "@p_Date='" + qp.get(0).getDate() + "',";
		}
		if (qp.get(0).getShift() != null || qp.get(0).getShift() != "") {
			s = s + "@p_Shift='" + qp.get(0).getShift() + "',";
		}
		if (qp.get(0).getProduct1() != null || qp.get(0).getProduct1() != "") {
			s = s + "@p_Product='" + qp.get(0).getProduct1() + "',";
		}
		if (qp.get(0).getMolecularWeight() != null || qp.get(0).getMolecularWeight() != "") {
			s = s + "@p_MolecularWt='" + qp.get(0).getMolecularWeight() + "',";
		}
		if (qp.get(0).getMolarityHyamine() != null || qp.get(0).getMolarityHyamine() != "") {
			s = s + "@p_MolarityHymine='" + qp.get(0).getMolarityHyamine() + "',";
		}
		if (qp.get(0).getwInsoluble() != null || qp.get(0).getwInsoluble() != "") {
			s = s + "@p_wInsoluble='" + qp.get(0).getwInsoluble() + "',";
		}
		if (qp.get(0).getRetention12() != null || qp.get(0).getRetention12() != "") {
			s = s + "@p_retention12='" + qp.get(0).getRetention12() + "',";
		}
		if (qp.get(0).getRetention60() != null || qp.get(0).getRetention60() != "") {
			s = s + "@p_retention60='" + qp.get(0).getRetention60() + "',";
		}

		if (qp.get(0).getPassing85() != null || qp.get(0).getPassing85() != "") {
			s = s + "@p_passing85='" + qp.get(0).getPassing85() + "',";
		}
		if (qp.get(0).getVolHyamine11() != null || qp.get(0).getVolHyamine11() != "") {
			s = s + "@p_volHyamine11='" + qp.get(0).getVolHyamine11() + "',";
		}
		if (qp.get(0).getVolHyamine12() != null || qp.get(0).getVolHyamine12() != "") {
			s = s + "@p_volHyamine12='" + qp.get(0).getVolHyamine12() + "',";
		}
		if (qp.get(0).getVolHyamine13() != null || qp.get(0).getVolHyamine13() != "") {
			s = s + "@p_volHyamine13='" + qp.get(0).getVolHyamine13() + "',";
		}
		if (qp.get(0).getAd11() != null || qp.get(0).getAd11() != "") {
			s = s + "@p_ad11='" + qp.get(0).getAd11() + "',";
		}
		if (qp.get(0).getAd12() != null || qp.get(0).getAd12() != "") {
			s = s + "@p_ad12='" + qp.get(0).getAd12() + "',";
		}
		if (qp.get(0).getAd13() != null || qp.get(0).getAd13() != "") {
			s = s + "@p_ad13='" + qp.get(0).getAd13() + "',";
		}
		if (qp.get(0).getAvgAD1() != null || qp.get(0).getAvgAD1() != "") {
			s = s + "@p_avgAd1='" + qp.get(0).getAvgAD1() + "',";
		}
		if (qp.get(0).getTotalAD1() != null || qp.get(0).getTotalAD1() != "") {
			s = s + "@p_totalAd1='" + qp.get(0).getTotalAD1() + "',";
		}
		if (qp.get(0).getRod1() != null || qp.get(0).getRod1() != "") {
			s = s + "@p_rod1='" + qp.get(0).getRod1() + "',";
		}

		if (qp.get(0).getVolHyamine21() != null || qp.get(0).getVolHyamine21() != "") {
			s = s + "@p_volHyamine21='" + qp.get(0).getVolHyamine21() + "',";
		}
		if (qp.get(0).getVolHyamine22() != null || qp.get(0).getVolHyamine22() != "") {
			s = s + "@p_volHyamine22='" + qp.get(0).getVolHyamine22() + "',";
		}
		if (qp.get(0).getVolHyamine23() != null || qp.get(0).getVolHyamine23() != "") {
			s = s + "@p_volHyamine23='" + qp.get(0).getVolHyamine23() + "',";
		}
		if (qp.get(0).getAd21() != null || qp.get(0).getAd21() != "") {
			s = s + "@p_ad21='" + qp.get(0).getAd21() + "',";
		}
		if (qp.get(0).getAd22() != null || qp.get(0).getAd22() != "") {
			s = s + "@p_ad22='" + qp.get(0).getAd22() + "',";
		}
		if (qp.get(0).getAd23() != null || qp.get(0).getAd23() != "") {
			s = s + "@p_ad23='" + qp.get(0).getAd23() + "',";
		}
		if (qp.get(0).getAvgAD2() != null || qp.get(0).getAvgAD2() != "") {
			s = s + "@p_avgAd2='" + qp.get(0).getAvgAD2() + "',";
		}
		if (qp.get(0).getTotalAD2() != null || qp.get(0).getTotalAD2() != "") {
			s = s + "@p_totalAd2='" + qp.get(0).getTotalAD2() + "',";
		}
		if (qp.get(0).getRod2() != null || qp.get(0).getRod2() != "") {
			s = s + "@p_rod2='" + qp.get(0).getRod2() + "',";
		}
		if (qp.get(0).getSampleWt1() != null || qp.get(0).getSampleWt1() != "") {
			s = s + "@p_sampleWt1='" + qp.get(0).getSampleWt1() + "',";
		}

		if (qp.get(0).getSampleWt2() != null || qp.get(0).getSampleWt2() != "") {
			s = s + "@p_sampleWt2='" + qp.get(0).getSampleWt2() + "',";
		}
		/*
		 * if (qp.get(0).getSampleWt3() != null || qp.get(0).getSampleWt3() != "") { s =
		 * s + "@p_sampleWt3='" + qp.get(0).getSampleWt3() + "',"; }
		 * 
		 * if (qp.get(0).getSampleWt4() != null || qp.get(0).getSampleWt4() != "") { s =
		 * s + "@p_sampleWt4='" + qp.get(0).getSampleWt4() + "',"; }
		 */
		if (qp.get(0).getSku1() != null || qp.get(0).getSku1() != "") {
			s = s + "@p_sku1='" + qp.get(0).getSku1() + "',";
		}

		if (qp.get(0).getSku2() != null || qp.get(0).getSku2() != "") {
			s = s + "@p_sku2='" + qp.get(0).getSku2() + "',";
		}

		if (qp.get(0).getSku3() != null || qp.get(0).getSku3() != "") {
			s = s + "@p_sku3='" + qp.get(0).getSku3() + "',";
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

		if (qp.get(0).getMcNo() != null && qp.get(0).getMcNo() != "") {
			String mcNo = qp.get(0).getMcNo();
			s = s + "@p_mcNo='" + (mcNo.substring(0, mcNo.length() - 1)) + "',";
		}
		
		if (qp.get(0).getMcName() != null && qp.get(0).getMcName() != "") {
			String mcName = qp.get(0).getMcName();
			s = s + "@p_mcName='" + (mcName.substring(0, mcName.length() - 1)) + "',";
		}

		if (qp.get(0).getAlkalinity() != null && qp.get(0).getAlkalinity() != "") {

			s = s + "@p_alkalinity='" + qp.get(0).getAlkalinity() + "',";
		}

		if (qp.get(0).getZeolity() != null && qp.get(0).getZeolity() != "") {

			s = s + "@p_zeolity='" + qp.get(0).getZeolity() + "',";
		}

		if (qp.get(0).getAv50() != null && qp.get(0).getAv50() != "") {

			s = s + "@p_av50='" + qp.get(0).getAv50() + "',";
		}

		if (qp.get(0).getSlopeFactor() != null && qp.get(0).getSlopeFactor() != "") {

			s = s + "@p_slopeFactore='" + qp.get(0).getSlopeFactor() + "',";
		}

		if (qp.get(0).getSampleWt5() != null && qp.get(0).getSampleWt5() != "") {

			s = s + "@p_sampleWt5='" + qp.get(0).getSampleWt5() + "',";
		}

		if (qp.get(0).getAbs() != null && qp.get(0).getAbs() != "") {

			s = s + "@p_abs='" + qp.get(0).getAbs() + "',";
		}

		for (QaDarRestModel m : qp) {

			if (m.getType().contentEquals("details")) {

				sitem = sitem + "(@p_DarId,\"" + m.getTime() + "\",\"" + m.getVct() + "\",\"" + m.getDfr() + "\",\""
						+ m.getUct() + "\",\"" + m.getPh() + "\",\"" + m.getBd() + "\",\"" + m.getOrganization()
						+ "\",\"" + m.getOrgDivision() + "\"),";

			} else if (m.getType().contentEquals("sample")) {

				sitem1 = sitem1 + "(@p_DarId,\"" + m.getSampleWt3() + "\",\"" + m.getTime1() + "\",\"" + m.getBatchNo()
						+ "\",\"" + m.getSampleHymine() + "\",\"" + m.getSampleAd() + "\",\"" + m.getWeightOfDisc()
						+ "\",\"" + m.getWeightOfTotal() + "\",\"" + m.getSampleWtForMC() + "\",\"" + m.getWeightOfLoss() + "\",\"" + m.getSampleMc()
						+ "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision() + "\"),";

			}

			else if (m.getType().contentEquals("composite")) {

				sitem2 = sitem2 + "(@p_DarId,\"" + m.getSampleWt4() + "\",\"" + m.getCompositeHymine() + "\",\""
						+ m.getCompositeAd() + "\",\"" + m.getCompositeWeightOfDisc() + "\",\""
						+ m.getCompositeWeightOfTotal() + "\",\"" + m.getCompositeSampleWtForMC() + "\",\"" + m.getCompositeWeightLoss() + "\",\""
						+ m.getCompositeMc() + "\",\"" + m.getCompositeBd() + "\",\"" + m.getCompositeDfr() + "\",\""
						+ m.getCompositePh() + "\",\"" + m.getCompositeCompatibility() + "\",\""
						+ m.getCompositeRetention() + "\",\"" + m.getCompositeAppearance() + "\",\""
						+ m.getCompositeColour() + "\",\"" + m.getCompositeOdour() + "\",\"" + m.getCompositeVisualCue()
						+ "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision() + "\"),";

			}

		}

		System.out.println("sitem+======" + sitem);
		System.out.println("sitem1+======" + sitem1);
		System.out.println("sitem2+======" + sitem2);
		System.out.println("qItem+======" + qItem);
		
		if(sitem != "") {
			sitem = sitem.substring(0, sitem.length() - 1);
		}
		if(sitem1 != "") {
			sitem1 = sitem1.substring(0, sitem1.length() - 1);
		}
		if(sitem2 != "") {
			sitem2 = sitem2.substring(0, sitem2.length() - 1);
		}


		System.out.println("sitem++++++++++++======" + sitem);
		System.out.println("sitem1+++++++++++======" + sitem1);
		System.out.println("sitem2+++++++++++======" + sitem2);

		s = s + "@p_itemSubQuery='" + sitem + "',";
		s = s + "@p_itemSubQuery1='" + sitem1 + "',";
		s = s + "@p_itemSubQuery2='" + sitem2 + "',";
		s = s + "@p_mcData='" + qItem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
