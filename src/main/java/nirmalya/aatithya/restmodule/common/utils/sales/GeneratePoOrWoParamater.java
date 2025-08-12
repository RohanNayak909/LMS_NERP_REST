package nirmalya.aatithya.restmodule.common.utils.sales;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.sales.model.RestPoOrWoModel;

public class GeneratePoOrWoParamater {
	public static String getAddPoParam(List<RestPoOrWoModel> customer) {
		String s = "";

		String listdata = "";
		String referenceId = "";
		String quotationId = "";
		String poNo = "";
		String poDate="";
		String custId = "";
		String qutDescription = "";
		Double subTotal = 0.00;
		Double qIGST = 0.00;
		Double qCGST = 0.00;
		Double qSGST = 0.00;
		Double grandTotal = 0.00;
		Boolean taxType = null;
	    String expectedShipmentDate = "";
		String paymentTermId = "";
		String deliveryMethodId = "";
		String salesPerson = "";
		String tcs = "";
		String terms = "";
		//String multidocument = "";
		String reference = "";
		Double tcsAmount = 0.00;
		String orderType = "";
		String organization = "";
		String orgDivision = "";
		String qutCreatedBy = "";
		String version = "";
		String shippingHiddenId = "";
		String advance = "";
		String project = "";
		String poRef = "";
		String endCustomerName = null;
		Boolean isUpdateSo = false;
		for (RestPoOrWoModel m : customer) {
			referenceId = m.getReferenceId();
			quotationId = m.getQuotationId();
			poNo = m.getPoNo();
			poDate = m.getPoDate();
			custId = m.getCustId();
			qutDescription = m.getQutDescription();
			
			qutCreatedBy = m.getQutCreatedBy();
			if (m.getSubTotal() != null) {
				subTotal = m.getSubTotal();
			}
			if (m.getqIGST() != null) {
				qIGST = m.getqIGST();
			}
			if (m.getqCGST() != null) {
				qCGST = m.getqCGST();
			}
			if (m.getqSGST() != null) {
				qSGST = m.getqSGST();
			}
			if (m.getGrandTotal() != null) {
				grandTotal = m.getGrandTotal();
			}
			grandTotal = m.getGrandTotal();
			taxType = m.getTaxType();
		

			expectedShipmentDate = m.getExpectedShipmentDate();
			paymentTermId = m.getPaymentTermId();
			deliveryMethodId = m.getDeliveryMethodId();
			salesPerson = m.getSalesPerson();
			terms = m.getTerms();
			reference = m.getReference();
		
			tcs = m.getTcs();
			if (m.getTcsAmount() != null) {
				tcsAmount = m.getTcsAmount();
			}
			orderType = m.getOrderType();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			version = m.getVersion();
			shippingHiddenId = m.getShippingHiddenId();
			advance = m.getAdvance();
			project = m.getProject();
			poRef = m.getPoRef();
			isUpdateSo = m.getIsUpdateSo();
			endCustomerName = m.getEndCustomerName();
		}
		s = s + "@p_referenceId='" + referenceId + "',";
		s = s + "@p_quotationId='" + quotationId + "',";
		s = s + "@p_poNo='" + poNo + "',";
		s = s + "@p_poDate='" + poDate + "',";
		s = s + "@p_custId='" + custId + "',";
		s = s + "@p_qutDescription='" + qutDescription + "',";
		
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_qutSubTotal=" + subTotal + ",";
		s = s + "@p_qutIGST=" + qIGST + ",";
		s = s + "@p_qutCGST=" + qCGST + ",";
		s = s + "@p_qutSGST=" + qSGST + ",";
		s = s + "@p_qutGrandTotal=" + grandTotal + ",";
		s = s + "@p_taxType=" + taxType + ",";
	    s = s + "@p_expectedDate='" + expectedShipmentDate + "',";
		s = s + "@p_paymentterm='" + paymentTermId + "',";
		s = s + "@p_deliveryMethod='" + deliveryMethodId + "',";
		s = s + "@p_salesperson='" + salesPerson + "',";
		s = s + "@p_tcsAmount=" + tcsAmount + ",";
		s = s + "@p_tcs='" + tcs + "',";
		s = s + "@p_terms='" + terms + "',";
		s = s + "@p_reference='" + reference + "',";
		s = s + "@p_orderType='" + orderType + "',";
		s = s + "@p_orgName='" + organization + "',";
		s = s + "@p_orgDiv='" + orgDivision + "',";
		s = s + "@p_version='" + version + "',";
		s = s + "@p_shippingHiddenId='" + shippingHiddenId + "',";
		s = s + "@p_advance='" + advance + "',";
		s = s + "@p_project='" + project + "',";
		s = s + "@p_poRef='" + poRef + "',";
		s = s + "@p_endCustomerName='" + endCustomerName + "',";
		s = s + "@p_isUpdateSo=" + isUpdateSo + ",";
		if (!customer.get(0).getReferenceId().contentEquals("1")) {
			for (RestPoOrWoModel m : customer) {

				listdata = listdata + "(@p_referenceId,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\""
                        + m.getQuantity() + "\",\"" + m.getUnit() + "\",\"" + m.getUnitPrice() + "\",\""
                        + m.getDiscount() + "\",\"" + m.getGstRate() + "\",\"" + m.getLineTotal() + "\",\""
                        + m.getHsnCode() + "\",\"" + m.getSizeInMM() +"\",\""
                        + m.getThicknessInMM() + "\",\"" + m.getItemDesc().replace("\"", "\"\"").replace("'", "''") + "\",\"" 
                        + m.getSku() + "\"," + m.getItemIgst() + "," + m.getItemCgst() + ","
                        + m.getItemSgst() + "," + m.getTaxableAmt() + ",@p_orgName,@p_orgDiv),";

			}
			listdata = listdata.substring(0, listdata.length() - 1);
			s = s + "@p_litemSubQuery='" + listdata + "',";
			String multidocument = "";
			List<InventoryVendorDocumentModel> item2 = customer.get(0).getDocumentList();
			if (customer.get(0).getDocumentList().size() > 0) {
				for (InventoryVendorDocumentModel a : item2) {
					if (!a.getDocumnentName().contentEquals("") && !a.getDocumnentName().contentEquals("null") 
							&& item2.get(0).getFileName() != "" && item2.get(0).getFileName() != null) {
					multidocument = multidocument + "(@p_referenceId,\"" + a.getDocumnentName() + "\",\""
							+ a.getFileName() + "\",@p_qutCreatedBy,@p_orgName,@p_orgDiv),";
				    }
				}
				if(multidocument != null && multidocument != "" && item2.get(0).getDocumnentName() != "" && item2.get(0).getDocumnentName() != null
						&& item2.get(0).getFileName() != "" && item2.get(0).getFileName() != null) {
					multidocument=multidocument.substring(0,multidocument.length()-1);
				}
			}else {
				multidocument="";
			}
			
			s = s + "@p_vendorDocuments='" + multidocument + "',";
			
			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		return s;
	}
	
	public static String getDeleteSalesPo(RestPoOrWoModel customer) {
		String[] userIds = customer.getReferenceId().split(",");
		String s = "";
		String litem = "";
		if (customer.getOrganization() != null && customer.getOrganization() != "") {
			s = s + "@p_orgName='" + customer.getOrganization() + "',";
		}
		if (customer.getOrgDivision() != null && customer.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + customer.getOrgDivision() + "',";
		}
		
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_poId='" + litem + "',";

		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

}
