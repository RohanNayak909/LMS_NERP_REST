package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

public class GenerateWarehouseBatchCreationParameter {
	public static String saveBatchParam(List<WirehouseRomeModel> master) {
		String s = "";
		
		
		String batchId="";
		String batchNo="";
		String manufactureDate="";
		String manufacturePlace="";
		 String shift="";
		String createdBy="";
		String organization="";
		String orgDivision="";
	    String batchNoType="";
		String batchDate="";
		String lineNo="";
		String packingSite="";
		String manufactureTime="";
		String bestBeforeDate="";
		
		/*
		 * Double binQuntity=0.00; String slNoFrom=""; String slNoTo=""; String
		 * binRemark="";
		 */
		
		for (WirehouseRomeModel m : master) {
			batchId=m.getBatchId();
			batchNo=m.getBatchNo();
			manufactureDate = DateFormatter.getStringDate(m.getManufactureDate());
			manufacturePlace=m.getManufacturePlace();
			shift=m.getShift();
			createdBy=m.getCreatedBy();
			organization=m.getOrganization();
			orgDivision=m.getOrgDivision();
			batchNoType=m.getBatchNoType();
			if(m.getBatchDate()!=null && m.getBatchDate()!="" && m.getBatchDate()!="null") {
				batchDate = DateFormatter.getStringDate(m.getBatchDate());
			}
			lineNo=m.getLineNo();
			packingSite=m.getPackingSite();
			manufactureTime=m.getManufactureTime();
			bestBeforeDate = DateFormatter.getStringDate(m.getBestBeforeDate());
			
		
			
			
		}
		
		s = s + "@p_batchId='" + batchId + "',";
	    s = s + "@p_batchNo='" + batchNo + "',";
		s = s + "@p_manufactureDate='" + manufactureDate + "',";
		s = s + "@p_manufacturePlace='" + manufacturePlace + "',";
		s = s + "@p_shift='" + shift + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_batchNoType='" + batchNoType + "',";
		if(batchDate!=null && batchDate!="" && batchDate!="null") {
			s = s + "@p_batchDate='" + batchDate + "',";
		}
		s = s + "@p_lineNo='" + lineNo + "',";
		s = s + "@p_packingSite='" + packingSite + "',";
		s = s + "@p_manufactureTime='" + manufactureTime + "',";
		s = s + "@p_bestBeforeDate='" + bestBeforeDate + "',";
		
		
		
		System.out.println(master);
		if(!master.isEmpty()) {
			if(!master.get(0).getBatchId().contentEquals("1")) {
				if (s != "") {
					s = s.substring(0, s.length() - 1);
					s = "SET " + s + ";";
					}
				}
		}else {
			System.out.println("master object is empty.");
		}
		
		
		return s;
	}
}
