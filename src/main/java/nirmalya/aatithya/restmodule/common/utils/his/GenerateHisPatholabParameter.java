package nirmalya.aatithya.restmodule.common.utils.his;

import java.util.ArrayList;
import java.util.List;

import nirmalya.aatithya.restmodule.his.model.HisPatholabRestModel;

public class GenerateHisPatholabParameter {

	
	public static String getSaveBloodTests(HisPatholabRestModel sample) {
		String s = "";
			
			if (sample.getBloddSampleId() != null && sample.getBloddSampleId() != "") {
				s = s + "@p_bookingId='" + sample.getBloddSampleId() + "',";
			}
			

			if (sample.getOrderId() != null && sample.getOrderId() != "") {
				s = s + "@p_OrderStatus='" + sample.getOrderId() + "',";
			}
			
			if (sample.getQrCode() != null && sample.getQrCode() != "") {
				s = s + "@p_qrcode='" + sample.getQrCode() + "',";
			}
			
			
			if (sample.getCreatedBy() != null && sample.getCreatedBy() != "") {
				s = s + "@p_createdby='" + sample.getCreatedBy() + "',";
			}
			

			if (sample.getOrg() != null && sample.getOrg() != "") {
				s = s + "@p_Org='" + sample.getOrg() + "',";
			}
			
			if (sample.getDiv() != null && sample.getDiv() != "") {
				s = s + "@p_Div='" + sample.getDiv() + "',";
			}
		
		if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
		}
		System.out.println("ssssss====="+s);
		return s;
	}
	
	
	/*
	 * public static String getsavetestNames(List<HisPatholabRestModel> sample) {
	 * String s = ""; String sampleParam = ""; String sampleParam1 = "";
	 * 
	 * System.out.println("ambulance====="+sample);
	 * 
	 * List<HisPatholabRestModel> sample1 = new ArrayList<HisPatholabRestModel>();
	 * 
	 * sample1 = sample.get(0).getBloodDataList();
	 * 
	 * for (HisPatholabRestModel a : sample1) {
	 * 
	 * sampleParam = sampleParam + "\"" + a.getQrCode() + "\",";
	 * 
	 * 
	 * } sampleParam = sampleParam.substring(0, sampleParam.length() - 1); s = s +
	 * "@p_sampleQuery='(" + sampleParam + ")',";
	 * 
	 * 
	 * for (HisPatholabRestModel a : sample1) {
	 * 
	 * sampleParam1 = sampleParam1 + "\"" + a.getBloddSampleId() + "\",";
	 * 
	 * } sampleParam1 = sampleParam1.substring(0, sampleParam1.length() - 1); s = s
	 * + "@p_sampleQuery1='(" + sampleParam1 + ")',";
	 * 
	 * 
	 * 
	 * if (s != "") { s = s.substring(0, s.length() - 1);
	 * 
	 * s = "SET " + s + ";"; }
	 * 
	 * return s; }
	 */
	
	
	public static String getsavetestNames(List<HisPatholabRestModel> sample) {
		String s = "";
		String sampleParam = "";
		
		System.out.println("ambulance====="+sample);
		
		List<HisPatholabRestModel> sample1 = new ArrayList<HisPatholabRestModel>();
		
		if (sample.get(0).getBloddSampleId() != null && sample.get(0).getBloddSampleId() != "") {
			s = s + "@p_bookingId='" + sample.get(0).getBloddSampleId() + "',";
		}
		
		sample1 = sample.get(0).getBloodDataList();
		System.out.println("sample1:::::::"+sample1);
		
		
		for(HisPatholabRestModel hs  : sample1) {
			String[] userIds = hs.getSkuId().split(",");
			String[] userNames = hs.getSkuName().split(",");
			for (int i = 0; i < userIds.length; i++) {
				  String skuId = userIds[i];
			      String skuName = userNames[i];
			    
			    sampleParam = sampleParam + "(\"" + hs.getTestId() + "\",\""
		                + sample.get(0).getCreatedBy() + "\",\""
		                + sample.get(0).getOrg() + "\",\""
		                + sample.get(0).getDiv() + "\",\""
		                + hs.getPatientId() + "\",\""
		                + hs.getBloddSampleId() + "\",\""
		                + skuId + "\",\""
		                + skuName + "\",\"" + hs.getQrCode() + "\"),";
			
			}
		}
		

		System.out.println("Final query: " + sampleParam);
		
		sampleParam = sampleParam.substring(0, sampleParam.length() - 1);

		s = s + "@p_sampleQuery='" + sampleParam + "',";
	

		if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
		}
		
		return s;
	}
	
	
	
	public static String saveActualValue(List<HisPatholabRestModel> sample) {
		String s = "";
		String sampleParam = "";
		
		System.out.println("ambulance====="+sample);
		
		List<HisPatholabRestModel> sample1 = new ArrayList<HisPatholabRestModel>();
		
		sample1 = sample.get(0).getBloodDataList();
		
		for (HisPatholabRestModel a : sample1) {
			
			if (sample.get(0).getBloddSampleId() != null && sample.get(0).getBloddSampleId() != "") {
				s = s + "@p_bookingId='" + sample.get(0).getBloddSampleId() + "',";
			}
			
			sampleParam = sampleParam + "(@p_bookingId,\"" + a.getTestId() + "\",\""
					+ sample.get(0).getOrg() + "\", \"" + sample.get(0).getDiv() + "\",\""
					+ sample.get(0).getPatientId() + "\",\"" + a.getGrpID() + "\",\""
					+ a.getActualValue() + "\",\"" + a.getRange() + "\",\""
					+ sample.get(0).getCustomerId() + "\",\"" + a.getOrderId() + "\",\""
					+ sample.get(0).getDoctNotes() + "\" ),";

		}
		sampleParam = sampleParam.substring(0, sampleParam.length() - 1);

		s = s + "@p_sampleQuery='" + sampleParam + "',";
	

		if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
		}
		
		return s;
	}
	
}
