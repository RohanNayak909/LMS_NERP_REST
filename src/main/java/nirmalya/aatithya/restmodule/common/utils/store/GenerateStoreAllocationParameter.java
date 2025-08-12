package nirmalya.aatithya.restmodule.common.utils.store;


import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.store.model.StoreRomeModel;

public class GenerateStoreAllocationParameter {
	public static String saveStoreAllocationParam(List<StoreRomeModel> master) {
		String s = "";
		
		String listdata = "";
		String listdata1 = "";
		String allocationId="";
		String warehouseId="";
		String zoneId="";
		String categoryId="";
		String itemName="";
		Double quantity=0.00;
		String batchNo="";
		String manufactureDate="";
		//String manufacturePlace="";
		// String shift="";
		String createdBy="";
		String organization="";
		String orgDivision="";
		String allocationStatus="1";
		
		//String batchNoType="";
		//String batchDate="";
		//String lineNo="";
		//String packingSite="";
		//String manufactureTime="";
		String bestBeforeDate="";
		//String cldNo="";
		String vreificationId="";
		String unit="";
		//String batchId="";
		/*
		 * Double binQuntity=0.00; String slNoFrom=""; String slNoTo=""; String
		 * binRemark="";
		 */
		
		for (StoreRomeModel m : master) {
			allocationId=m.getAllocationId();
			warehouseId=m.getWarehouseId();
			zoneId=m.getZoneId();
			categoryId=m.getCategoryId();
			itemName=m.getItemName();
			quantity=m.getQuantity();
			batchNo=m.getBatchNo();
			//manufactureDate = DateFormatter.getStringDate(m.getManufactureDate());
			if(m.getManufactureDate()!=null && m.getManufactureDate()!="" && m.getManufactureDate()!="null") {
				manufactureDate = DateFormatter.getStringDate(m.getManufactureDate());
			}
			//manufacturePlace=m.getManufacturePlace();
			//shift=m.getShift();
			createdBy=m.getCreatedBy();
			organization=m.getOrganization();
			orgDivision=m.getOrgDivision();
			//batchNoType=m.getBatchNoType();
			/*
			 * if(m.getBatchDate()!=null && m.getBatchDate()!="" &&
			 * m.getBatchDate()!="null") { batchDate =
			 * DateFormatter.getStringDate(m.getBatchDate()); }
			 */
			//lineNo=m.getLineNo();
			//packingSite=m.getPackingSite();
			//manufactureTime=m.getManufactureTime();
			//bestBeforeDate=m.getBestBeforeDate();
			//bestBeforeDate = DateFormatter.getStringDate(m.getBestBeforeDate());
			if(m.getBestBeforeDate()!=null && m.getBestBeforeDate()!="" && m.getBestBeforeDate()!="null") {
				bestBeforeDate = DateFormatter.getStringDate(m.getBestBeforeDate());
			}
			//cldNo=m.getCldNo();
			vreificationId=m.getVreificationId();
			unit=m.getUnit();
			//batchId=m.getBatchId();
			/*
			 * binQuntity=m.getBinQuntity(); slNoFrom=m.getSlNoFrom(); slNoTo=m.getSlNoTo();
			 * binRemark=m.getBinRemark();
			 */
			
			
		}
		
		s = s + "@p_allocationId='" + allocationId + "',";
		s = s + "@p_warehouseId='" + warehouseId + "',";
		s = s + "@p_zoneId='" + zoneId + "',";
		s = s + "@p_categoryId='" + categoryId + "',";
		s = s + "@p_itemName='" + itemName + "',";
		s = s + "@p_quantity='" + quantity + "',";
		s = s + "@p_batchNo='" + batchNo + "',";
		
		//s = s + "@p_manufactureDate='" + manufactureDate + "',";
		if(manufactureDate!=null && manufactureDate!="" && manufactureDate!="null") {
			s = s + "@p_manufactureDate='" +  manufactureDate + "',";
		}
		//s = s + "@p_manufacturePlace='" + manufacturePlace + "',";
		//s = s + "@p_shift='" + shift + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_allocationStatus='" + allocationStatus + "',";
		
		//s = s + "@p_batchNoType='" + batchNoType + "',";
		/*
		 * if(batchDate!=null && batchDate!="" && batchDate!="null") { s = s +
		 * "@p_batchDate='" + batchDate + "',"; }
		 */
		//s = s + "@p_lineNo='" + lineNo + "',";
		//s = s + "@p_packingSite='" + packingSite + "',";
		//s = s + "@p_manufactureTime='" + manufactureTime + "',";
		//s = s + "@p_bestBeforeDate='" + bestBeforeDate + "',";
		
		if(bestBeforeDate!=null && bestBeforeDate!="" && bestBeforeDate!="null") {
			s = s + "@p_bestBeforeDate='" +  bestBeforeDate + "',";
		}
		//s = s + "@p_cldNo='" + cldNo + "',";
		s = s + "@p_vreificationId='" + vreificationId + "',";
		s = s + "@p_unit='" + unit + "',";
		//s = s + "@p_batchId='" + batchId + "',";
		
		/*
		 * s = s + "@p_binQuntity='" + binQuntity + "',"; s = s + "@p_slNoFrom='" +
		 * slNoFrom + "',"; s = s + "@p_slNoTo='" + slNoTo + "',"; s = s +
		 * "@p_binRemark='" + binRemark + "',";
		 */
		
		System.out.println(master);
		if(!master.isEmpty()) {
			if(!master.get(0).getAllocationId().contentEquals("1")) {
				for (StoreRomeModel m : master) {

					//listdata = listdata + "(@p_allocationId,\"" + m.getZoneId() + "\",\"" + m.getBinId() + "\",@p_createdBy,@p_organization,@p_orgDivision,@p_allocationStatus),";
					listdata = listdata + "(@p_allocationId,\"" + m.getZoneId() + "\",\"" + m.getBinId() + "\",@p_createdBy,@p_organization,@p_orgDivision,@p_allocationStatus," + m.getBinQuntity() + ",\"" + m.getSlNoFrom() + "\",\"" + m.getSlNoTo() + "\",\"" + m.getBinRemark() + "\"),";
					// listdata1 = listdata1 + "\"" + m.getBinId() + "\","; 
				}
				listdata = listdata.substring(0, listdata.length() - 1);
				s = s + "@p_litemSubQuery='" + listdata + "',";
				/*
				 * listdata1 = listdata1.substring(0, listdata1.length() - 1); s = s
				 * +"@p_binSubQuery='(" + listdata1 + ")',";
				 */
				if (s != "") {
				s = s.substring(0, s.length() - 1);
				s = "SET " + s + ";";
				System.out.println("sxdcfvbgnhjmnhgbfd"+s);
				}
				}
		}else {
			System.out.println("master object is empty.");
		}
		
		
		return s;
	}
}
