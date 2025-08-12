package nirmalya.aatithya.restmodule.common.utils.purchase;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.dao.RestPurchaseOrderrDao;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseIndentModel;
import nirmalya.aatithya.restmodule.purchase.model.VendorDeliveryChallanModel;


public class GenerateVendorDeliveryChallanParam {
	public static String getAddChallanParam(List<VendorDeliveryChallanModel> vendor) {
		
	//	Logger logger = LoggerFactory.getLogger(GenerateVendorDeliveryChallanParam.class);
		
		String s = "";
		String listdata = "";
		String listdata1 = "";
		String vendorDeliveryChallan = "";
		String poId = "";
		String qutActive = null;
		String qutCreatedBy = "";
		Double subTotal = 0.00;
		Double qIGST = 0.00;
		Double qCGST = 0.00;
		Double qSGST = 0.00;
		Double grandTotal = 0.00;
		Boolean taxType = null;
		String vendorId = "";
		String organization = "";
		String orgDivision = "";
		Double adjustment = 0.00;
		String challanType = "";
		String ebillNo = "";
		String ebillDate = "";
		String tMode = "";
		String freigt = "";
		Double freigtCharge = 0.00;
		Double freigtTaxRate = 0.00;
		Double total = 0.00;
		String vehicleNo = "";
		String transporterId = "";
		String transporterName = "";
		String lrNumber = "";
		String carrier = "";
		String paymentTermId = "";
		String project = "";
		Double tcsAmount = 0.00;
		String tcs = "";
		String tcstype = "";
		Double tdsAmount = 0.00;
		String tds = "";
		String tdstype = "";
		String multidocument = "";
		String challanNo = "";
		String createdBy = "";
		String terms = "";
		for (VendorDeliveryChallanModel m : vendor) {
			vendorDeliveryChallan = m.getVendorDeliveryChallan();
			poId = m.getPoId();
			qutActive = m.getQutActive();
			qutCreatedBy = m.getQutCreatedBy();
			subTotal = m.getSubTotal();
			qIGST = m.getqIGST();
			qCGST = m.getqCGST();
			qSGST = m.getqSGST();
			grandTotal = m.getGrandTotal();
			taxType = m.getTaxType();
			vendorId = m.getVendorId();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			adjustment = m.getAdjustment();
			challanType = m.getChallanType();
			ebillNo = m.getEbillNo();
			ebillDate = m.getEbillDate();
			tMode = m.gettMode();
			freigt = m.getFreight();
			challanNo=m.getChallanNo();
			createdBy=m.getQutCreatedBy();
			
			if (m.getFreigtCharge() != null) {
				freigtCharge = m.getFreigtCharge();
			}
			if (m.getFreigtTaxRate() != null) {
				freigtTaxRate = m.getFreigtTaxRate();
			}
			if (m.getTotal() != null) {
				total = m.getTotal();
			}
			vehicleNo = m.getVehicleNo();
			transporterId = m.getTransporterId();
			transporterName = m.getTransporterName();
			lrNumber = m.getLrNumber();
			carrier= m.getCarrier();
			paymentTermId= m.getPaymentTermId();
			project = m.getProject();
			if (m.getTcsAmount() != null) {
				tcsAmount = m.getTcsAmount();
			}
			tcs = m.getTcs();
			tcstype = m.getTcstype();
			if (m.getTdsAmount() != null && m.getTdsAmount() != "") {
				tdsAmount = Double.valueOf(m.getTdsAmount());
			}
			tds = m.getTds();
			tdstype = m.getTdstype();
			terms = m.getTerms();
			
		}
		s = s + "@p_vendorDeliveryChallan='" + vendorDeliveryChallan + "',";
		s = s + "@p_poId='" + poId + "',";
		s = s + "@p_qutActive='" + qutActive + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_qutSubTotal=" + subTotal + ",";
		s = s + "@p_qutIGST=" + qIGST + ",";
		s = s + "@p_qutCGST=" + qCGST + ",";
		s = s + "@p_qutSGST=" + qSGST + ",";
		s = s + "@p_qutGrandTotal=" + grandTotal + ",";
		s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_vendorId='" + vendorId + "',";
		s = s + "@p_org='" + organization + "',";
		s = s + "@p_div='" + orgDivision + "',";
		s = s + "@p_adjustment='" + adjustment + "',";
		s = s + "@p_tcsAmount=" + tcsAmount + ",";
		s = s + "@p_tcs='" + tcs + "',";
		s = s + "@p_tcstype='" + tcstype + "',";
		s = s + "@p_tdsAmount=" + tdsAmount + ",";
		s = s + "@p_tds='" + tds + "',";
		s = s + "@p_tdstype='" + tdstype + "',";
		s = s + "@p_challanType='" + challanType + "',";
		s = s + "@p_ebillNo='" + ebillNo + "',";
	   s = s + "@p_terms='" + terms + "',";
		if (ebillDate != "") {
			s = s + "@p_ebillDate='" + ebillDate + "',";
		}
		s = s + "@p_tMode='" + tMode + "',";
		s = s + "@p_freigt='" + freigt + "',";
		s = s + "@p_freigtCharge='" + freigtCharge + "',";
		s = s + "@p_freigtTaxRate='" + freigtTaxRate + "',";
		s = s + "@p_total='" + total + "',";
		s = s + "@p_vehicleNo='" + vehicleNo + "',";
		s = s + "@p_transporterId='" + transporterId + "',";
		s = s + "@p_transporterName='" + transporterName + "',";
		s = s + "@p_lrNumber='" + lrNumber + "',";
		s = s + "@p_carrier='" + carrier + "',";
		s = s + "@p_paymentTermId='" + paymentTermId + "',";
		s = s + "@p_project='" + project + "',";
		s = s + "@p_challanNo='" + challanNo + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
	//	if (!vendor.get(0).getVendorDeliveryChallan().contentEquals("1")) {
			for (VendorDeliveryChallanModel m : vendor) {
				Double pending = 0.00;
	            if(m.getPendingQuantity()!=null) {
	            	pending=m.getPendingQuantity();
	            }
	        	Double receiving = 0.00;
	            if(m.getReceivingQuantity()!=null) {
	            	
	            	receiving=m.getReceivingQuantity();
	            	
	            }
	        	Double received = 0.00;
	            if(m.getReceivedQuantity()!=null) {
	            	received=m.getReceivedQuantity();
	            }
				listdata = listdata + "(@p_vendorDeliveryChallan,@p_poId,@p_vendorId,\"" + m.getItemId() + "\",\"" + m.getItemName()
						+ "\",\"" + m.getQuantity() + "\",\"" + m.getUnitPrice() + "\",\""
						+ m.getGstRate() + "\",\"" + m.getLineTotal() + "\",\"" + m.getSku() + "\"," + m.getItemIgst()
						+ "," + m.getItemCgst() + "," + m.getItemSgst() + ",\"" + m.getHsnCode() + "\",\"" + m.getUnit()
						+ "\"," + m.getTaxableAmt() + "," + pending + "," + receiving + ", " +received + ",@p_org,@p_div),";
			}
			listdata = listdata.substring(0, listdata.length() - 1);

			s = s + "@p_litemSubQuery='" + listdata + "',";

			for (VendorDeliveryChallanModel m : vendor) {						
				listdata1 = listdata1 + "\"" + m.getSku() + "\",";
			}
			listdata1 = listdata1.substring(0, listdata1.length() - 1);
			s = s + "@p_sku='(" + listdata1 + ")',";
			
			
			
			for (InventoryVendorDocumentModel a : vendor.get(0).getDocumentList()) {
				if (!a.getDocumnentName().contentEquals("") && !a.getDocumnentName().contentEquals("null")) {
					multidocument = multidocument + "(@p_vendorDeliveryChallan,\"" + a.getDocumnentName() + "\",\""
							+ a.getFileName() + "\",@p_createdBy,@p_org,@p_div),";
				}

			}
			if (!multidocument.isEmpty()) {
				multidocument = multidocument.substring(0, multidocument.length() - 1);
				s = s + "@p_vendorDocuments='" + multidocument + "',";
			}
			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
//	}
		return s;
	}

	public static String getDeleteParamnew(VendorDeliveryChallanModel customer) {
		String[] userIds = customer.getVendorDeliveryChallan().split(",");
		String s = "";
		String litem = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_vendorDeliveryChallan='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
	
}
