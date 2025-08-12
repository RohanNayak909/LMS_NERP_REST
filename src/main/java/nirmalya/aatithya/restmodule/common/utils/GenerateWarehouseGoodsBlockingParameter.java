package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.warehouse.model.WirehouseRomeModel;

public class GenerateWarehouseGoodsBlockingParameter {

	public static String blockParam(List<WirehouseRomeModel> master) {
		String s = "";

		String listdata = "";
		String blockId = "";
		String requestId = "";
		String remarks = "";
		String warehouseId = "";
		String rackId = "";
		String categoryId = "";
		String itemName = "";
		Double quantity = 0.00;
		String blockingBy = "";
		String organization = "";
		String orgDivision = "";
		String blockStatus = "1";
		String unit = "";

		for (WirehouseRomeModel m : master) {

			blockId = m.getBlockId();
			requestId = m.getRequestId();
			remarks = m.getRemarks();
			warehouseId = m.getWarehouseId();
			rackId = m.getRackId();

			categoryId = m.getCategoryId();
			itemName = m.getItemName();
			quantity = m.getQuantity();
			blockingBy = m.getBlockingBy();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			unit = m.getUnit();
		}

		if (blockId != null && blockId != "")
			s = s + "@p_blockId='" + blockId + "',";
		else
			s = s + "@p_blockId=null,";
		s = s + "@p_requestId='" + requestId + "',";
		s = s + "@p_remarks='" + remarks + "',";
		s = s + "@p_warehouseId='" + warehouseId + "',";
		s = s + "@p_rackId='" + rackId + "',";

		s = s + "@p_categoryId='" + categoryId + "',";
		s = s + "@p_itemName='" + itemName + "',";
		s = s + "@p_quantity='" + quantity + "',";
		s = s + "@p_blockingBy='" + blockingBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_unit='" + unit + "',";
		s = s + "@p_blockStatus='" + blockStatus + "',";

		System.out.println(master);
		if (master.size() > 0) {
				for (WirehouseRomeModel m : master) {

					listdata = listdata + "(@p_blockId,\"" + m.getAllocationId() + "\",\"" + m.getBinId()
							+ "\",@p_blockingBy,@p_organization,@p_orgDivision,@p_blockStatus," + m.getBlockQuntity()
							+ ",\"" + m.getSlNoFrom() + "\",\"" + m.getSlNoTo() + "\",\"" + m.getBinBlockRemark()
							+ "\"),";
				}
				listdata = listdata.substring(0, listdata.length() - 1);
				s = s + "@p_litemSubQuery='" + listdata + "',";
				if (s != "") {
					s = s.substring(0, s.length() - 1);
					s = "SET " + s + ";";
				}
		} else {
			System.out.println("master object is empty.");
		}

		return s;
	}

}
