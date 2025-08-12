package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

public class GenerateWarehouseAllocationParameter {
	
	public static String saveAllocationParam(List<WirehouseRomeModel> master) {
		String s = "";

		String listdata = "";
		String listdata1 = "";
		String allocationId = "";
		String warehouseId = "";
		String zoneId = "";
		String categoryId = "";
		String itemName = "";
		Double quantity = 0.00;
		String batchNo = "";
		String manufactureDate = "";
		String manufacturePlace = "";
		String shift = "";
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
		String allocationStatus = "1";

		String batchNoType = "";
		String batchDate = "";
		String lineNo = "";
		String packingSite = "";
		String manufactureTime = "";
		String bestBeforeDate = "";
		String cldNo = "";
		String vreificationId = "";
		String unit = "";
		String oldBinId = "";

		for (WirehouseRomeModel m : master) {
			allocationId = m.getAllocationId();
			warehouseId = m.getWarehouseId();
			zoneId = m.getZoneId();
			categoryId = m.getCategoryId();
			itemName = m.getItemName();
			quantity = m.getQuantity();
			batchNo = m.getBatchNo();
			oldBinId = m.getOldBinId();
			if (m.getManufactureDate() != "" && m.getManufactureDate() != null) {
				manufactureDate = DateFormatter.getStringDate(m.getManufactureDate());
			} else {
				manufactureDate = null;
			}

			manufacturePlace = m.getManufacturePlace();
			shift = m.getShift();
			createdBy = m.getCreatedBy();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			batchNoType = m.getBatchNoType();
			if (m.getBatchDate() != null && m.getBatchDate() != "" && m.getBatchDate() != "null") {
				batchDate = DateFormatter.getStringDate(m.getBatchDate());
			}
			lineNo = m.getLineNo();
			packingSite = m.getPackingSite();
			manufactureTime = m.getManufactureTime();
			if (m.getBestBeforeDate() != "" && m.getBestBeforeDate() != null) {
				bestBeforeDate = DateFormatter.getStringDate(m.getBestBeforeDate());
			} else {
				bestBeforeDate = null;
			}
			cldNo = m.getCldNo();
			vreificationId = m.getVreificationId();
			unit = m.getUnit();
		}

		s = s + "@p_allocationId='" + allocationId + "',";
		s = s + "@p_oldBinId='" + oldBinId + "',";
		s = s + "@p_warehouseId='" + warehouseId + "',";
		s = s + "@p_zoneId='" + zoneId + "',";
		s = s + "@p_categoryId='" + categoryId + "',";
		s = s + "@p_itemName='" + itemName + "',";
		s = s + "@p_quantity='" + quantity + "',";
		s = s + "@p_batchNo='" + batchNo + "',";
		if (manufactureDate != null && !manufactureDate.equals("null") && manufactureDate != "") {
			s = s + "@p_manufactureDate='" + manufactureDate + "',";
		} else {
			s = s + "@p_manufactureDate=null,";
		}
		s = s + "@p_manufacturePlace='" + manufacturePlace + "',";
		s = s + "@p_shift='" + shift + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_allocationStatus='" + allocationStatus + "',";

		s = s + "@p_batchNoType='" + batchNoType + "',";
		if (batchDate != null && batchDate != "" && batchDate != "null") {
			s = s + "@p_batchDate='" + batchDate + "',";
		}
		s = s + "@p_lineNo='" + lineNo + "',";
		s = s + "@p_packingSite='" + packingSite + "',";
		s = s + "@p_manufactureTime='" + manufactureTime + "',";
		if (bestBeforeDate != null && !bestBeforeDate.equals("null") && bestBeforeDate != "") {
			s = s + "@p_bestBeforeDate='" + bestBeforeDate + "',";
		} else {
			s = s + "@p_bestBeforeDate=null,";
		}

		s = s + "@p_cldNo='" + cldNo + "',";
		s = s + "@p_vreificationId='" + vreificationId + "',";
		s = s + "@p_unit='" + unit + "',";

		if (!master.isEmpty()) {
			if (!master.get(0).getAllocationId().contentEquals("1")) {
				for (WirehouseRomeModel m : master) {

					listdata = listdata + "(@p_allocationId,\"" + m.getZoneId() + "\",\"" + m.getBinId()
							+ "\",@p_createdBy,@p_organization,@p_orgDivision,@p_allocationStatus," + m.getBinQuntity()
							+ ",\"" + m.getSlNoFrom() + "\",\"" + m.getSlNoTo() + "\",\"" + m.getBinRemark() + "\"),";
					listdata1 = listdata1 + "\"" + m.getBinId() + "\",";
				}
				listdata = listdata.substring(0, listdata.length() - 1);
				s = s + "@p_litemSubQuery='" + listdata + "',";
				listdata1 = listdata1.substring(0, listdata1.length() - 1);
				s = s + "@p_binSubQuery='(" + listdata1 + ")',";
				if (s != "") {
					s = s.substring(0, s.length() - 1);
					s = "SET " + s + ";";
				}
			}
		} else {
			System.out.println("master object is empty.");
		}

		return s;
	}

}
