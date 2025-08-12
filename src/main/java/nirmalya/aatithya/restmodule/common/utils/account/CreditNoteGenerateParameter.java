package nirmalya.aatithya.restmodule.common.utils.account;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.account.model.AccountCreditNoteRestModel;
import nirmalya.aatithya.restmodule.account.model.ItemShoukeenModel;
import nirmalya.aatithya.restmodule.account.model.RestPurchaseItemModel;

public class CreditNoteGenerateParameter {

	public static String addCreditNote(List<AccountCreditNoteRestModel> creditNote) {

		String s = "";
		String listdata = "";
		if (creditNote.get(0).getCreditNoteId() != null && creditNote.get(0).getCreditNoteId() != "") {
			s = s + "@p_creditNoteId='" + creditNote.get(0).getCreditNoteId() + "',";
		}
		if (creditNote.get(0).getSalesLedgerId() != null && creditNote.get(0).getSalesLedgerId() != "") {
			s = s + "@p_salesLedgerId='" + creditNote.get(0).getSalesLedgerId() + "',";
		}
		if (creditNote.get(0).getPartyLedgerId() != null && creditNote.get(0).getPartyLedgerId() != "") {
			s = s + "@p_partyLedgerId='" + creditNote.get(0).getPartyLedgerId() + "',";
		}
		if (creditNote.get(0).getPrtyLedgerCurBal() != null && creditNote.get(0).getPrtyLedgerCurBal() != "") {
			s = s + "@p_partyCurrBal='" + creditNote.get(0).getPrtyLedgerCurBal() + "',";
		}
		if (creditNote.get(0).getSalesLedgerCurBal() != null && creditNote.get(0).getSalesLedgerCurBal() != "") {
			s = s + "@p_salesCurrBal='" + creditNote.get(0).getSalesLedgerCurBal() + "',";
		}
		if (creditNote.get(0).getCreditNoteDate() != null && creditNote.get(0).getCreditNoteDate() != "") {
			s = s + "@p_salesCreditDate='" + creditNote.get(0).getCreditNoteDate() + "',";
		}
		if (creditNote.get(0).getOrderNumber() != null && creditNote.get(0).getOrderNumber() != "") {
			s = s + "@p_orderNumber='" + creditNote.get(0).getOrderNumber() + "',";
		}
		if (creditNote.get(0).getSubTotal() != null) {
			s = s + "@p_subTotal=" + creditNote.get(0).getSubTotal() + ",";
		}
		if (creditNote.get(0).getqSGST() != null) {
			s = s + "@p_qSGST=" + creditNote.get(0).getqSGST() + ",";
		}
		if (creditNote.get(0).getqCGST() != null) {
			s = s + "@p_qCGST=" + creditNote.get(0).getqCGST() + ",";
		}
		if (creditNote.get(0).getqIGST() != null) {
			s = s + "@p_qIGST=" + creditNote.get(0).getqIGST() + ",";
		}
		if (creditNote.get(0).getGrandTotal() != null) {
			s = s + "@p_grandTotal=" + creditNote.get(0).getGrandTotal() + ",";
		}
		if (creditNote.get(0).getTotalItem() != null && creditNote.get(0).getTotalItem() != "") {
			s = s + "@p_totalItem='" + creditNote.get(0).getTotalItem() + "',";
		}
		if (creditNote.get(0).getCreatedBy() != null && creditNote.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + creditNote.get(0).getCreatedBy() + "',";
		}
		if (creditNote.get(0).getCostCenter() != null && creditNote.get(0).getCostCenter() != "") {
			s = s + "@p_costCenter='" + creditNote.get(0).getCostCenter() + "',";
		}
		if (creditNote.get(0).getDescription() != null && creditNote.get(0).getDescription() != "") {
			s = s + "@p_description='" + creditNote.get(0).getDescription() + "',";
		}
		
		if (creditNote.get(0).getOrganization() != null && creditNote.get(0).getOrganization() != "") {
			s = s + "@p_org='" + creditNote.get(0).getOrganization() + "',";
		}
		
		if (creditNote.get(0).getOrgDivision() != null && creditNote.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + creditNote.get(0).getOrgDivision() + "',";
		}
		
		for (ItemShoukeenModel m : creditNote.get(0).getItemattribute()) {
			listdata = listdata + "(@p_creditNoteId,@p_orderNumber,\"" + m.getCategoryId() + "\",\"" + m.getQuantity() + "\",\"" + m.getProductDimension() + "\"," + "\""
					+ m.getItemUnitPrice() + "\",\"" + m.getDiscount() + "\",\"" + m.getGstRate() + "\",\""
					+ m.getItemCgst() + "\",\"" + m.getItemSgst() + "\",\"" + m.getToggleRegularCustom() + "\",\""
					+ m.getLineTotal() + "\"," + "\"" + m.getDealerCode() + "\","+"\"" + m.getExtraDiscount() +"\",@p_org,@p_orgDiv),";

		}
		listdata = listdata.substring(0, listdata.length() - 1);
		s = s + "@p_litemSubQuery='" + listdata + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}
		System.out.println("Item Details" + s);
		return s;
	}
	
	
	
	public static String addDebitNote(AccountCreditNoteRestModel debitNote) {

		String s = "";
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	System.out.println("Current time in AM/PM: "+dateString);
    	s = s + "@p_createdTime='" + dateString + "',";

		
		if (debitNote.getCreditNoteId() != null) {
			s = s + "@p_debitNoteId='" + debitNote.getCreditNoteId() + "',";
		}
		if (debitNote.getSalesLedgerId() != null && debitNote.getSalesLedgerId() != "") {
			s = s + "@p_salesLedgerId='" + debitNote.getSalesLedgerId() + "',";
		}
		if (debitNote.getPartyLedgerId() != null && debitNote.getPartyLedgerId() != "") {
			s = s + "@p_partyLedgerId='" + debitNote.getPartyLedgerId() + "',";
		}
		if (debitNote.getPrtyLedgerCurBal() != null && debitNote.getPrtyLedgerCurBal() != "") {
			s = s + "@p_partyCurrBal='" + debitNote.getPrtyLedgerCurBal() + "',";
		}
		if (debitNote.getSalesLedgerCurBal() != null && debitNote.getSalesLedgerCurBal() != "") {
			s = s + "@p_salesCurrBal='" + debitNote.getSalesLedgerCurBal() + "',";
		}
		if (debitNote.getCreditNoteDate() != null && debitNote.getCreditNoteDate() != "") {
			s = s + "@p_salesCreditDate='" + debitNote.getCreditNoteDate() + "',";
		}
		if (debitNote.getOrderNumber() != null && debitNote.getOrderNumber() != "") {
			s = s + "@p_orderNumber='" + debitNote.getOrderNumber() + "',";
		}
		if (debitNote.getSubTotal() != null) {
			s = s + "@p_subTotal=" + debitNote.getSubTotal() + ",";
		}
		if (debitNote.getqSGST() != null) {
			s = s + "@p_qSGST=" + debitNote.getqSGST() + ",";
		}
		if (debitNote.getqCGST() != null) {
			s = s + "@p_qCGST=" + debitNote.getqCGST() + ",";
		}
		if (debitNote.getqIGST() != null) {
			s = s + "@p_qIGST=" + debitNote.getqIGST() + ",";
		}
		if (debitNote.getGrandTotal() != null) {
			s = s + "@p_grandTotal=" + debitNote.getGrandTotal() + ",";
		}
		if (debitNote.getTotalItem() != null && debitNote.getTotalItem() != "") {
			s = s + "@p_totalItem='" + debitNote.getTotalItem() + "',";
		}
		if (debitNote.getCreatedBy() != null && debitNote.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + debitNote.getCreatedBy() + "',";
		}
		if (debitNote.getCostCenter() != null && debitNote.getCostCenter() != "") {
			s = s + "@p_costCenter='" + debitNote.getCostCenter() + "',";
		}
		if (debitNote.getDescription() != null && debitNote.getDescription() != "") {
			s = s + "@p_description='" + debitNote.getDescription() + "',";
		}
		if (debitNote.getOrganization() != null && debitNote.getOrganization() != "") {
			s = s + "@p_org='" + debitNote.getOrganization() + "',";
		}
		
		if (debitNote.getOrgDivision() != null && debitNote.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + debitNote.getOrgDivision() + "',";
		}
		if (debitNote.getTaxType() != null) {
			s = s + "@p_taxType=" + debitNote.getTaxType() + ",";
		}
		
		if (debitNote.getAmount() != null && debitNote.getAmount() != "") {
			s = s + "@p_amt='" + debitNote.getAmount() + "',";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

}
