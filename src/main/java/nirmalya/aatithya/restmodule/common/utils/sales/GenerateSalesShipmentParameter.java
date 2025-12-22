package nirmalya.aatithya.restmodule.common.utils.sales;

import java.util.List;

import nirmalya.aatithya.restmodule.sales.model.RestSalesShipmentsModel;

public class GenerateSalesShipmentParameter {
	public static String getAddShipmentParam(List<RestSalesShipmentsModel> customer) {
		String s = "";
		String salesShipmentId="";
		String custId="";
		String poId="";
		String saleDeliveryChallan="";
		String shipmentOrder="";
		String carrierId="";
		String trackingId="";
		String trackingUrlId="";
		
	   // Double shippingCharge=0.00;
	    String internalNotes="";
		//String qutActive=null;
		String qutCreatedBy="";
		String contactNo="";
		 String orgName="";
		 String orgDiv="";
		 String shippingHiddenId="";
		
		for (RestSalesShipmentsModel m : customer) {
			salesShipmentId=m.getSalesShipmentId();
			custId=m.getCustId();
			poId=m.getPoId();
			saleDeliveryChallan=m.getSaleDeliveryChallan();
			shipmentOrder=m.getShipmentOrder();
			carrierId=m.getCarrierId();
			trackingId=m.getTrackingId();
			trackingUrlId=m.getTrackingUrlId();
			/*
			 * if(m.getShippingCharge()!=null) { shippingCharge=m.getShippingCharge(); }
			 */
			internalNotes=m.getInternalNotes();
			qutCreatedBy=m.getQutCreatedBy();
			contactNo=m.getContactNo();
			orgName=m.getOrgName();
			orgDiv=m.getOrgDiv();
			shippingHiddenId=m.getShippingHiddenId();
			
			
					
		}
		
		s = s + "@p_shipmentId='" + salesShipmentId + "',";
		s = s + "@p_custId='" + custId + "',";
		s = s + "@p_poId='" + poId + "',";
		s = s + "@p_saleDeliveryChallan='" + saleDeliveryChallan + "',";
		s = s + "@p_shipmentOrder='" + shipmentOrder + "',";
		s = s + "@p_carrierId='" + carrierId + "',";
		s = s + "@p_trackingId='" + trackingId + "',";
		s = s + "@p_trackingUrlId='" + trackingUrlId + "',";
		//s = s + "@p_shippingCharge='" + shippingCharge + "',";
		s = s + "@p_internalNotes='" + internalNotes + "',";
		
		//s = s + "@p_qutActive='" + qutActive + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_contactNo='" + contactNo + "',";
		s = s + "@p_orgName='" + orgName + "',";
		s = s + "@p_orgDiv='" + orgDiv + "',";
		s = s + "@p_shippingHiddenId='" + shippingHiddenId + "',";
	
		System.out.println(customer);
		if(!customer.isEmpty()) {
			if(!customer.get(0).getSalesShipmentId().contentEquals("1")) {
				if (s != "") {
				s = s.substring(0, s.length() - 1);
				s = "SET " + s + ";";
				}
				}
		}else {
			System.out.println("customer object is empty.");
		}
		
		
		return s;
	}
}
