package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.procurment.model.DeliveryNoteModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;

public class GenerateDelNoteDtlsParameter {

	public static String saveDeliveryNoteDetails(List<DeliveryNoteModel> delNote) {
		
		String s = "";
		String delNoteDtls = "";
		String document = "";
//		String editDocument = "";
		
		if(delNote.get(0).getDelNote()!=null && delNote.get(0).getDelNote()!="") {
			s = s + "@P_DelNote='" + delNote.get(0).getDelNote() + "',";
		}
		if(delNote.get(0).getDispatchDate()!=null && delNote.get(0).getDispatchDate()!="") {
			s = s + "@P_DispatchDate='" + delNote.get(0).getDispatchDate() + "',";
		}
		if(delNote.get(0).getEstDeliveryDate()!=null && delNote.get(0).getEstDeliveryDate()!="") {
			s = s + "@P_EstDeliveryDate='" + delNote.get(0).getEstDeliveryDate() + "',";
		}
		if(delNote.get(0).getDeliveryMethod()!=null && delNote.get(0).getDeliveryMethod()!="") {
			s = s + "@P_DeliveryMethod='" + delNote.get(0).getDeliveryMethod() + "',";
		}
		if(delNote.get(0).getTrackingNumber()!=null && delNote.get(0).getTrackingNumber()!="") {
			s = s + "@P_TrackingNumber='" + delNote.get(0).getTrackingNumber() + "',";
		}
		if(delNote.get(0).getCreatedBy()!=null && delNote.get(0).getCreatedBy()!="") {
			s = s + "@P_CreatedBy='" + delNote.get(0).getCreatedBy() + "',";
		}
		if(delNote.get(0).getModuleId()!=null && delNote.get(0).getModuleId()!="") {
			s = s + "@P_Module='" + delNote.get(0).getModuleId() + "',";
		}
		if(delNote.get(0).getComponentId()!=null && delNote.get(0).getComponentId()!="") {
			s = s + "@P_Component='" + delNote.get(0).getComponentId() + "',";
		}
		if(delNote.get(0).getSubComponentId()!=null && delNote.get(0).getSubComponentId()!="") {
			s = s + "@P_SubComponent='" + delNote.get(0).getSubComponentId() + "',";
		}
		
		for(DeliveryNoteModel m : delNote) {
			delNoteDtls = delNoteDtls + "(\"" + delNote.get(0).getDelNote() + "\",\"" + m.getItemId() + "\",\"" + m.getSku() + 
					"\",\"" + m.getLocation() + "\"," + m.getQty() + ",\"" + m.getUom() + "\"," + m.getDelQty() + "," + m.getOutstandQty() + "),";
		}
		
		delNoteDtls = delNoteDtls.substring(0, delNoteDtls.length() - 1);

		s = s + "@p_delNoteDtlsSubQuery='" + delNoteDtls + "',";
		
		for (InventoryVendorDocumentModel a : delNote.get(0).getDocList()) {
			document = document + "(@P_DelNote,\"" + a.getDocumnentName() + "\",\"" + a.getFileName()
					+ "\",@P_CreatedBy),";
		}
		if (!document.isEmpty()) {
			document = document.substring(0, document.length() - 1);
			s = s + "@p_documents='" + document + "',";
		}
		
//		if(delNote.get(0).getEditDocList().size() > 0) {
//			for (String b : delNote.get(0).getEditDocList()) {
//				editDocument = editDocument + "(@P_DelNote,\"" + b + "\"),";
//			}
//			if (!editDocument.isEmpty()) {
//				editDocument = editDocument.substring(0, editDocument.length() - 1);
//				s = s + "@p_editDocument='" + editDocument + "',";
//			}
//		}
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		System.out.println(s);
		
		return s;
	}

}
