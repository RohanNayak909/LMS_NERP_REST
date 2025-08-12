package nirmalya.aatithya.restmodule.common.utils.productionplan;

import nirmalya.aatithya.restmodule.productionplan.model.PackingDetailsRestModel;



public class GeneratePackingProcessParameter {
	
	public static String getAddPackagingDetails(PackingDetailsRestModel addPackingDetails) {
		
			String s = "";
		
		if(addPackingDetails.getProcessId()!=null && addPackingDetails.getProcessId()!="") {
			s = s + "@p_processId='" + addPackingDetails.getProcessId() + "',";
		}
		if(addPackingDetails.getMixerNo()!=null && addPackingDetails.getMixerNo()!="") {
			s = s + "@p_mixerNo='" + addPackingDetails.getMixerNo() + "',";
		}
		if(addPackingDetails.getBrandNo()!=null && addPackingDetails.getBrandNo()!="") {
			s = s + "@p_brandNo='" + addPackingDetails.getBrandNo() + "',";
		}
		if(addPackingDetails.getMcId()!=null && addPackingDetails.getMcId()!="") {
			s = s + "@p_mcId='" + addPackingDetails.getMcId() + "',";
		}
		if(addPackingDetails.getItemsku()!=null && addPackingDetails.getItemsku()!="") {
			s = s + "@p_itemSku='" + addPackingDetails.getItemsku() + "',";
		}
		if(addPackingDetails.getItemName()!=null && addPackingDetails.getItemName()!="") {
			s = s + "@p_itemName='" + addPackingDetails.getItemName() + "',";
		}
		if(addPackingDetails.getpQtySack()!=null  && addPackingDetails.getpQtySack()!="") {
			s = s + "@p_pQtySack='" + addPackingDetails.getpQtySack() + "',";
		}
		if(addPackingDetails.getpQtyMt()!=null  && addPackingDetails.getpQtyMt()!="") {
			s = s + "@p_pQtyMt='" + addPackingDetails.getpQtyMt() + "',";
		}
		if(addPackingDetails.getSapBook()!=null  && addPackingDetails.getSapBook()!="") {
			s = s + "@p_sapBook='" + addPackingDetails.getSapBook() + "',";
		}
		if(addPackingDetails.getqHoldRQty()!=null  && addPackingDetails.getqHoldRQty()!="") {
			s = s + "@p_qHoldRQty='" + addPackingDetails.getqHoldRQty() + "',";
		}
		if(addPackingDetails.getPackingRemark()!=null  && addPackingDetails.getPackingRemark()!="") {
			s = s + "@p_packingRemark='" + addPackingDetails.getPackingRemark() + "',";
		}
		if(addPackingDetails.getOrganization()!=null  && addPackingDetails.getOrganization()!="") {
			s = s + "@p_Org='" + addPackingDetails.getOrganization() + "',";
		}
		if(addPackingDetails.getOrgDivision()!=null  && addPackingDetails.getOrgDivision()!="") {
			s = s + "@p_OrgDivision='" + addPackingDetails.getOrgDivision() + "',";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		
		return s;
		
		
	}

}
