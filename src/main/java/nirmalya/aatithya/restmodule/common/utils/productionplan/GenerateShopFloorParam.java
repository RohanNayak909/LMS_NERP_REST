package nirmalya.aatithya.restmodule.common.utils.productionplan;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.productionplan.model.RestManageShopFloorModel;


public class GenerateShopFloorParam {
	
	public static String getShopFloorDtls(RestManageShopFloorModel qa) {
		String s = "";
		String listdata = "";
		
		if (qa.getFloorId() != null && qa.getFloorId() != "") {
			s = s + "@p_floorId='" + qa.getFloorId() + "',";
		}
		if (qa.getDate() != null && qa.getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(qa.getDate())  + "',";
		}
		if (qa.getShift() != null && qa.getShift() != "") {
			s = s + "@p_shift='" + qa.getShift() + "',";
		}
		if (qa.getRemark() != null && qa.getRemark() != "") {
			s = s + "@p_remark='" + qa.getRemark() + "',";
		}
		
		if (qa.getCreatedBy() != null && qa.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + qa.getCreatedBy() + "',";
		}
		if (qa.getOrganization() != null && qa.getOrganization() != "") {
			s = s + "@p_org='" + qa.getOrganization() + "',";
		}
		if (qa.getOrgDivision() != null && qa.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + qa.getOrgDivision() + "',";
		}
		
		
		
		
		

		if (qa.getItemDtls() != null && !qa.getItemDtls().isEmpty()) {
			for (RestManageShopFloorModel m : qa.getItemDtls()) {
				listdata = listdata + "(@p_floorId,\"" + m.getMcId() + "\",\"" + m.getSku() + "\",\""+ m.getPouchReading() + "\",\""+ m.getTrail() + "\",\""+ m.getLeaker() + "\",\""+ m.getDamage()
				
				+ "\",\"" + qa.getOrganization() + "\",\"" + qa.getOrgDivision() + "\"),";

			}
			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_itemSubQuery='" + listdata + "',";
		} else {
			s = s + "@p_itemSubQuery='',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details>>>>>>>>>>>>>>>>>" + s);
		return s;
	}
	
	
	public static String getBreakDownDtls(RestManageShopFloorModel qa) {
		String s = "";
		String listdata = "";

		if (qa.getFloorId() != null && qa.getFloorId() != "") {
			s = s + "@p_floorId='" + qa.getFloorId() + "',";
		}else {
			s = s + "@p_floorId='" + "" + "',";
		}
		if (qa.getDate() != null && qa.getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(qa.getDate())  + "',";
		}
		if (qa.getShift() != null && qa.getShift() != "") {
			s = s + "@p_shift='" + qa.getShift() + "',";
		}
		
		if (qa.getRemark() != null && qa.getRemark() != "") {
			s = s + "@p_remark='" + qa.getRemark() + "',";
		}
		
		if (qa.getBdMcId() != null && qa.getBdMcId() != "") {
			s = s + "@p_bdMcId='" + qa.getBdMcId() + "',";
		}
		
		if (qa.getBdSku() != null && qa.getBdSku() != "") {
			s = s + "@p_bdSku='" + qa.getBdSku() + "',";
		}
		
		if (qa.getBdFromDt() != null && qa.getBdFromDt() != "") {
			s = s + "@p_bdFromDt='" + DateFormatter.getStringDate(qa.getBdFromDt())  + "',";
		}
		
		if (qa.getBdFromTime() != null && qa.getBdFromTime() != "") {
			s = s + "@p_bdFromTime='" + qa.getBdFromTime() + "',";
		}
		
		if (qa.getBdToDt() != null && qa.getBdToDt() != "") {
			s = s + "@p_bdToDt='" + DateFormatter.getStringDate(qa.getBdToDt())  + "',";
		}
		
		if (qa.getBdToTime() != null && qa.getBdToTime() != "") {
			s = s + "@p_bdToTime='" + qa.getBdToTime() + "',";
		}
		
		if (qa.getBdDuration() != null && qa.getBdDuration() != "") {
			s = s + "@p_bdDuration='" + qa.getBdDuration() + "',";
		}
		if (qa.getMcRemark() != null && qa.getMcRemark() != "") {
			s = s + "@p_remark='" + qa.getMcRemark() + "',";
		}
		

		if (qa.getCreatedBy() != null && qa.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + qa.getCreatedBy() + "',";
		}
		if (qa.getOrganization() != null && qa.getOrganization() != "") {
			s = s + "@p_org='" + qa.getOrganization() + "',";
		}
		if (qa.getOrgDivision() != null && qa.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + qa.getOrgDivision() + "',";
		}
		
		
		
		
		

		if (qa.getItemDtls() != null && !qa.getItemDtls().isEmpty()) {
			for (RestManageShopFloorModel m : qa.getItemDtls()) {
				listdata = listdata + "(@p_floorId,\"" + m.getMcId() + "\",\"" + m.getSku() + "\",\""+ m.getPouchReading() + "\",\""+ m.getTrail() + "\",\""+ m.getLeaker() + "\",\""+ m.getDamage()
				
				+ "\",\"" + qa.getOrganization() + "\",\"" + qa.getOrgDivision() + "\"),";

			}
			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_itemSubQuery='" + listdata + "',";
		} else {
			s = s + "@p_itemSubQuery='',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details>>>>>>>>>>>>>>>>>" + s);
		return s;
	}
	
	
	

}
