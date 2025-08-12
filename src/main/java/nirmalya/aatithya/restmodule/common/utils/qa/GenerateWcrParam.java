package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;


import nirmalya.aatithya.restmodule.qa.model.QaWcrRestModel;

public class GenerateWcrParam {
	
	public static String getAddwrc(List<QaWcrRestModel> qp) {
		
		String s = "";
		String sitem = "";
		
		if (qp.get(0).getWcrId() != null || qp.get(0).getWcrId() != "") {
			s = s + "@p_WcrId='" + qp.get(0).getWcrId() + "',";
		}
		if (qp.get(0).getPdate() != null || qp.get(0).getPdate() != "") {
			s = s + "@p_Pdate='" + qp.get(0).getPdate() + "',";
		}
		if (qp.get(0).getShift() != null || qp.get(0).getShift() != "") {
			s = s + "@p_Shift='" + qp.get(0).getShift() + "',";
		}
		if (qp.get(0).getProduction() != null || qp.get(0).getProduction() != "") {
			s = s + "@p_Production='" + qp.get(0).getProduction() + "',";
		}
		if (qp.get(0).getPacking() != null || qp.get(0).getPacking() != "") {
			s = s + "@p_Packing='" + qp.get(0).getPacking() + "',";
		}
		if (qp.get(0).getMinwt() != null || qp.get(0).getMinwt() != "") {
			s = s + "@p_Minwt='" + qp.get(0).getMinwt() + "',";
		}
		if (qp.get(0).getMaxwt() != null || qp.get(0).getMaxwt() != "") {
			s = s + "@p_Maxwt='" + qp.get(0).getMaxwt() + "',";
		}
		if (qp.get(0).getAvgwt() != null || qp.get(0).getAvgwt() != "") {
			s = s + "@p_Avgwt='" + qp.get(0).getAvgwt() + "',";
		}
		if (qp.get(0).getSd() != null || qp.get(0).getSd() != "") {
			s = s + "@p_Sd='" + qp.get(0).getSd() + "',";
		}
		
		
		if (qp.get(0).getLeakers1() != null || qp.get(0).getLeakers1() != "") {
			s = s + "@p_leakers1='" + qp.get(0).getLeakers1() + "',";
		}
		if (qp.get(0).getLeakers2() != null || qp.get(0).getLeakers2() != "") {
			s = s + "@p_leakers2='" + qp.get(0).getLeakers2() + "',";
		}
		if (qp.get(0).getLeakers3() != null || qp.get(0).getLeakers3() != "") {
			s = s + "@p_leakers3='" + qp.get(0).getLeakers3() + "',";
		}
		if (qp.get(0).getLeakers4() != null || qp.get(0).getLeakers4() != "") {
			s = s + "@p_leakers4='" + qp.get(0).getLeakers4() + "',";
		}
		if (qp.get(0).getLeakers5() != null || qp.get(0).getLeakers5() != "") {
			s = s + "@p_leakers5='" + qp.get(0).getLeakers5() + "',";
		}
		if (qp.get(0).getLeakers6() != null || qp.get(0).getLeakers6() != "") {
			s = s + "@p_leakers6='" + qp.get(0).getLeakers6() + "',";
		}
		if (qp.get(0).getLeakers7() != null || qp.get(0).getLeakers7() != "") {
			s = s + "@p_leakers7='" + qp.get(0).getLeakers7() + "',";
		}
		if (qp.get(0).getLeakers8() != null || qp.get(0).getLeakers8() != "") {
			s = s + "@p_leakers8='" + qp.get(0).getLeakers8() + "',";
		}
		if (qp.get(0).getLeakers9() != null || qp.get(0).getLeakers9() != "") {
			s = s + "@p_leakers9='" + qp.get(0).getLeakers9() + "',";
		}
		if (qp.get(0).getLeakers10() != null || qp.get(0).getLeakers10() != "") {
			s = s + "@p_leakers10='" + qp.get(0).getLeakers10() + "',";
		}
		
		
		if (qp.get(0).getNoOfPouch1() != null || qp.get(0).getNoOfPouch1() != "") {
			s = s + "@p_noOfPouch1='" + qp.get(0).getNoOfPouch1() + "',";
		}
		if (qp.get(0).getNoOfPouch2() != null || qp.get(0).getNoOfPouch2() != "") {
			s = s + "@p_noOfPouch2='" + qp.get(0).getNoOfPouch2() + "',";
		}
		if (qp.get(0).getNoOfPouch3() != null || qp.get(0).getNoOfPouch3() != "") {
			s = s + "@p_noOfPouch3='" + qp.get(0).getNoOfPouch3() + "',";
		}
		if (qp.get(0).getNoOfPouch4() != null || qp.get(0).getNoOfPouch4() != "") {
			s = s + "@p_noOfPouch4='" + qp.get(0).getNoOfPouch4() + "',";
		}
		if (qp.get(0).getNoOfPouch5() != null || qp.get(0).getNoOfPouch5() != "") {
			s = s + "@p_noOfPouch5='" + qp.get(0).getNoOfPouch5() + "',";
		}
		if (qp.get(0).getNoOfPouch6() != null || qp.get(0).getNoOfPouch6() != "") {
			s = s + "@p_noOfPouch6='" + qp.get(0).getNoOfPouch6() + "',";
		}
		if (qp.get(0).getNoOfPouch7() != null || qp.get(0).getNoOfPouch7() != "") {
			s = s + "@p_noOfPouch7='" + qp.get(0).getNoOfPouch7() + "',";
		}
		if (qp.get(0).getNoOfPouch8() != null || qp.get(0).getNoOfPouch8() != "") {
			s = s + "@p_noOfPouch8='" + qp.get(0).getNoOfPouch8() + "',";
		}
		if (qp.get(0).getNoOfPouch9() != null || qp.get(0).getNoOfPouch9() != "") {
			s = s + "@p_noOfPouch9='" + qp.get(0).getNoOfPouch9() + "',";
		}
		if (qp.get(0).getNoOfPouch10() != null || qp.get(0).getNoOfPouch10() != "") {
			s = s + "@p_noOfPouch10='" + qp.get(0).getNoOfPouch10() + "',";
		}
		
		
		if (qp.get(0).getSampleSizePouch() != null || qp.get(0).getSampleSizePouch() != "") {
			s = s + "@p_sampleSizePouch='" + qp.get(0).getSampleSizePouch() + "',";
		}
		if (qp.get(0).getSampleSizePowder() != null || qp.get(0).getSampleSizePowder() != "") {
			s = s + "@p_sampleSizePowder='" + qp.get(0).getSampleSizePowder() + "',";
		}
		
		
		if (qp.get(0).getStt() != null || qp.get(0).getStt() != "") {
			s = s + "@p_stt='" + qp.get(0).getStt() + "',";
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
		
		for (QaWcrRestModel m : qp) {

			sitem = sitem + "(@p_WcrId,\"" + m.getType() + "\",\"" + m.getDetails() + "\",\"" +  m.getS0() + "\",\"" +  m.getS2() +"\",\"" + m.getS3() +"\",\"" + m.getS4() +"\",\"" + m.getS5() +"\",\"" + m.getS6() +"\",\"" + m.getS7() + "\",\"" + m.getS8()
			+"\",\"" + m.getS9() +"\",\"" + m.getS10() +"\",\"" + m.getS11() +"\",\"" + m.getRed() +"\",\"" + m.getAmber() + "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
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
