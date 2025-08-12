package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.pipeline.model.RestCrmQuoteModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryRequisitionModel;
import nirmalya.aatithya.restmodule.sales.model.RestQuotationNewModel;

public class GenerateCRMQuoteParameter {

	public static String getAddParam(List<RestCrmQuoteModel> customer) {

		String s = "";
		String listdata = "";
		String quotationId = "";
		String qutName = "";
		String custId = "";
		String qutValidDate = "";
		String qutDescription = "";
		String qutActive = null;
		String qutCreatedBy = "";
		Double subTotal = 0.00;
		Double qIGST = 0.00;
		Double qCGST = 0.00;
		Double qSGST = 0.00;
		Double grandTotal = 0.00;
		Boolean taxType = null;

		String quoteOwner = "";
		String dealId = "";
		String quoteDealName = "";
		String quoteSubject = "";
		String quoteValidUntil = "";
		String quoteStage = "";
		String quoteContactId = "";
		String quoteContactName = "";
		String quoteTeamName = "";

		String quoteAccountId = "";
		String quoteAccountName = "";
		String quoteCarrier = "";

		String billingStreet = "";
		String shippingStreet = "";
		String billingCity = "";
		String shippingCity = "";
		String billingCode = "";
		String shippingCode = "";
		String billingState = "";
		String shippingState = "";
		String billingCountry = "";
		String shippingCountry = "";

		String description = "";
		String termCondition = "";

		for (RestCrmQuoteModel m : customer) {
			quotationId = m.getQuotationId();
			qutName = m.getQutName();
			custId = m.getCustId();
			// qutValidDate=m.getQutValidDate();

			qutValidDate = m.getQuoteValidUntil();
			qutDescription = m.getQutDescription();
			qutActive = m.getQutActive();
			qutCreatedBy = m.getQutCreatedBy();
			subTotal = m.getSubTotal();
			qIGST = m.getqIGST();
			qCGST = m.getqCGST();
			qSGST = m.getqSGST();
			grandTotal = m.getGrandTotal();
			taxType = m.getTaxType();

			quoteOwner = m.getQuoteOwner();
			quoteDealName = m.getQuoteDealName();
			dealId = m.getDealId();
			quoteSubject = m.getQuoteSubject();
			quoteValidUntil = m.getQuoteValidUntil();
			quoteStage = m.getQuoteStage();
			quoteContactId = m.getQuoteContactId();
			quoteContactName = m.getQuoteContactName();
			quoteTeamName = m.getQuoteTeamName();
			quoteAccountId = m.getQuoteAccountId();
			quoteAccountName = m.getQuoteAccountName();
			quoteCarrier = m.getQuoteCarrier();

			billingStreet = m.getBillingStreet();
			shippingStreet = m.getShippingStreet();
			billingCity = m.getBillingCity();
			shippingCity = m.getShippingCity();
			billingCode = m.getBillingCode();
			shippingCode = m.getShippingCode();
			billingState = m.getBillingState();
			shippingState = m.getShippingState();
			billingCountry = m.getBillingCountry();
			shippingCountry = m.getShippingCountry();

			description = m.getDescription();
			termCondition = m.getTermCondition();

		}

		s = s + "@p_quotationId='" + quotationId + "',";
		s = s + "@p_qutName='" + qutName + "',";
		s = s + "@p_custId='" + custId + "',";
		s = s + "@p_qutValidDate='" + qutValidDate + "',";
		s = s + "@p_qutDescription='" + qutDescription + "',";
		s = s + "@p_qutActive='" + qutActive + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_qutSubTotal=" + subTotal + ",";
		s = s + "@p_qutIGST=" + qIGST + ",";
		s = s + "@p_qutCGST=" + qCGST + ",";
		s = s + "@p_qutSGST=" + qSGST + ",";
		s = s + "@p_qutGrandTotal=" + grandTotal + ",";
		s = s + "@p_taxType=" + taxType + ",";

		s = s + "@p_quoteOwner='" + quoteOwner + "',";

		s = s + "@p_dealId='" + dealId + "',";
		s = s + "@p_quoteDealName='" + quoteDealName + "',";

		s = s + "@p_quoteSubject='" + quoteSubject + "',";
		s = s + "@p_quoteValidUntil='" + quoteValidUntil + "',";
		s = s + "@p_quoteStage='" + quoteStage + "',";

		s = s + "@p_quoteContactId='" + quoteContactId + "',";
		s = s + "@p_quoteContactName='" + quoteContactName + "',";
		s = s + "@p_quoteTeamName='" + quoteTeamName + "',";

		s = s + "@p_quoteAccountId='" + quoteAccountId + "',";
		s = s + "@p_quoteAccountName='" + quoteAccountName + "',";
		s = s + "@p_quoteCarrier='" + quoteCarrier + "',";

		s = s + "@p_billingStreet='" + billingStreet + "',";
		s = s + "@p_shippingStreet='" + shippingStreet + "',";
		s = s + "@p_billingCity='" + billingCity + "',";

		s = s + "@p_shippingCity='" + shippingCity + "',";
		s = s + "@p_billingCode='" + billingCode + "',";
		s = s + "@p_shippingCode='" + shippingCode + "',";

		s = s + "@p_billingState='" + billingState + "',";
		s = s + "@p_shippingState='" + shippingState + "',";
		s = s + "@p_billingCountry='" + billingCountry + "',";

		s = s + "@p_shippingCountry='" + shippingCountry + "',";
		s = s + "@p_description='" + description + "',";
		s = s + "@p_termCondition='" + termCondition + "',";

		if (!customer.get(0).getQuotationId().contentEquals("1")) {
			for (RestCrmQuoteModel m : customer) {
				Double disc = 0.0;
				if (m.getDiscount() == null) {
					disc = 0.0;
				} else {
					disc = m.getDiscount();
				}

				listdata = listdata + "(@p_quotationId,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\""
						+ m.getQuantity() + "\",\"" + m.getUnitPrice() + "\",\"" + disc + "\",\"" + m.getGstRate()
						+ "\",\"" + m.getLineTotal() + "\",\"" + m.getqItmCode() + "\",\"" + m.getSku() + "\","
						+ m.getItemIgst() + "," + m.getItemCgst() + "," + m.getItemSgst() + "),";
			}
			listdata = listdata.substring(0, listdata.length() - 1);

			s = s + "@p_litemSubQuery='" + listdata + "',";

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		System.out.println("Item Details" + s);
		return s;

	}

	public static String getDeleteParam(RestCrmQuoteModel customer) {
		String[] userIds = customer.getQuotationId().split(",");
		String s = "";
		String litem = "";
		for (String a : userIds) {
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_quotationId='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
}
