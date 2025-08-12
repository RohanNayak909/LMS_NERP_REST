package nirmalya.aatithya.restmodule.common.utils.productionplan;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.productionplan.model.ProductionLogBookOfRestModel;


public class GenerateProductionLogBookOfParam {
	
	public static String getProductionLogBook(ProductionLogBookOfRestModel qa) {
		String s = "";
		String listdata1 = "";
		//String listGridData1 = "";
		String listdata2 = "";
		//String listGridData2 = "";
		System.out.println("gatepass====" + qa);
		if (qa.getLogId() != null && qa.getLogId() != "") {
			s = s + "@p_logId='" + qa.getLogId() + "',";
		}
		if (qa.getDate() != null && qa.getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(qa.getDate()) + "',";
		}
		if (qa.getShift() != null && qa.getShift() != "") {
			s = s + "@p_shift='" + qa.getShift() + "',";
		}
		if (qa.getFloorSweep() != null && qa.getFloorSweep() != "") {
			s = s + "@p_floorSweep='" + qa.getFloorSweep() + "',";
		}
		if (qa.getAsmGenerator() != null && qa.getAsmGenerator() != "") {
			s = s + "@p_asmGenerator='" + qa.getAsmGenerator() + "',";
		}
		if (qa.getTotalQuantity1() != null && qa.getTotalQuantity1() != "") {
			s = s + "@p_totalQuantity1='" + qa.getTotalQuantity1() + "',";
		}
		if (qa.getRemark1() != null && qa.getRemark1() != "") {
			s = s + "@p_remark1='" + qa.getRemark1() + "',";
		}
		if (qa.getLamStarpac() != null && qa.getLamStarpac() != "") {
			s = s + "@p_lamStarpac='" + qa.getLamStarpac() + "',";
		}
		if (qa.getLamSyntegon() != null && qa.getLamSyntegon() != "") {
			s = s + "@p_lamSynteogon='" + qa.getLamSyntegon() + "',";
		}
		if (qa.getTotalQuantity2() != null && qa.getTotalQuantity2() != "") {
			s = s + "@p_totalQuantity2='" + qa.getTotalQuantity2() + "',";
		}
		if (qa.getRemark2() != null && qa.getRemark2() != "") {
			s = s + "@p_remark2='" + qa.getRemark2() + "',";
		}
		if (qa.getRewgStarpac() != null && qa.getRewgStarpac() != "") {
			s = s + "@p_rewgStarpac='" + qa.getRewgStarpac() + "',";
		}
		if (qa.getRewgSyntegon() != null && qa.getRewgSyntegon() != "") {
			s = s + "@p_rewgSyntehon='" + qa.getRewgSyntegon() + "',";
		}
		if (qa.getCommunication() != null && qa.getCommunication() != "") {
			s = s + "@p_communication='" + qa.getCommunication() + "',";
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
		
		

		if (qa.getGrid1Dtls() != null && !qa.getGrid1Dtls().isEmpty()) {
			for (ProductionLogBookOfRestModel m : qa.getGrid1Dtls()) {
			if(m.getVariant() != null && m.getVariant() != "") {
				listdata1 = listdata1 + "(@p_logId,\"" + m.getGridNo() + "\",\"" + m.getSlno() + "\",\""+ m.getVariant() + "\",\""+ m.getJumboBagSize() + "\",\""+ m.getBatchNo()
				+ "\",\"" + m.getNoOfBags() + "\",\"" + m.getRewQtyAdd() + "\",\"" + m.getTotal() + "\",\"" + m.getTotalQty() + "\",\"" + m.getRemark()  
				+ "\",\"" + qa.getOrganization() + "\",\"" + qa.getOrgDivision() + "\"),";
				
				
				/*
				 * listGridData1 = listGridData1 + "(\"" + m.getGridNo() + "\",\"" + m.getSlno()
				 * + "\",\""+ m.getVariant() + "\",\"" + qa.getOrganization() + "\",\"" +
				 * qa.getOrgDivision() + "\"),";
				 */
				}
			}
			listdata1 = listdata1.substring(0, listdata1.length() - 1);
			/* listGridData1 = listGridData1.substring(0, listGridData1.length() - 1); */
			s = s + "@p_itemSubQuery1='" + listdata1 + "',";
			/* s = s + "@p_gridSubQuery1='" + listGridData1 + "',"; */
		} else {
			s = s + "@p_itemSubQuery1='',";
			/* s = s + "@p_gridSubQuery1='',"; */
		}
		
		if (qa.getGrid2Dtls() != null && !qa.getGrid2Dtls().isEmpty()) {
			for (ProductionLogBookOfRestModel m : qa.getGrid2Dtls()) {
				if(m.getL3Prod()== null || m.getL3Prod().isEmpty() || m.getL3Prod() == "null") {
					m.setL3Prod("");
				}
			if(m.getSku() != null && m.getSku() != "") {
				listdata2 = listdata2 + "(@p_logId,\"" + m.getGridNo() + "\",\"" + m.getSlno() + "\",\""+ m.getSku()  + "\",\""+ m.getSkuType() + "\",\"" + m.getCldWt()
				+ "\",\"" + m.getL1Prod() + "\",\"" + m.getL2Prod() + "\",\"" + m.getTotalCld() + "\",\"" + m.getProdQty() + "\",\"" + m.getDewrappedLami() + "\",\"" + m.getDewrapConst() + "\",\"" + m.getDewrapCalc() + "\",\"" + m.getSapBooking() + "\",\"" + m.getQualityHold()
				+ "\",\"" + m.getRemark()  
				+ "\",\"" + qa.getOrganization() + "\",\"" + qa.getOrgDivision() + "\",\"" + m.getL3Prod() + "\"),";
				
				
				/*
				 * listGridData2 = listGridData2 + "(\"" + m.getGridNo() + "\",\"" + m.getSlno()
				 * + "\",\""+ m.getSku() + "\",\"" + qa.getOrganization() + "\",\"" +
				 * qa.getOrgDivision() + "\"),";
				 */
				}
			}
			listdata2 = listdata2.substring(0, listdata2.length() - 1);
			/* listGridData2 = listGridData2.substring(0, listGridData2.length() - 1); */
			s = s + "@p_itemSubQuery2='" + listdata2 + "',";
			/* s = s + "@p_gridSubQuery2='" + listGridData2 + "',"; */
		} else {
			s = s + "@p_itemSubQuery2='',";
			/* s = s + "@p_gridSubQuery2='',"; */
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Item Details>>>>>>>>>>>>>>>>>" + s);
		return s;
	}

}
