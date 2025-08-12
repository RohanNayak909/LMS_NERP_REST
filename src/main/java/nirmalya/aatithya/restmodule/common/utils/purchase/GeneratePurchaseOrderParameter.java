package nirmalya.aatithya.restmodule.common.utils.purchase;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.sales.model.RestCustoomerNewModel;
import nirmalya.aatithya.restmodule.sales.model.RestDeliveryChallanModel;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.master.model.RestAttendanceModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.purchase.model.RestVendorNewModel;

public class GeneratePurchaseOrderParameter {
	public static String getAddPo(List<RestPurchaseOrderModel> purchase) {
		String s = "";
		String listdata = "";
		String vendorId = "";
		String poId = "";
		String qutValidDate = "";
		String reference = "";
		String paymentTermId = "";
		String advance = "";
		String carrierId = "";
		String qutDescription = "";
		String itemDesc = "";
		String descWork = "";
		String termDelivery = "";
		String annextureId = "";
		String project = "";


		Double subTotal = 0.00;
		Double qIGST = 0.00;
		Double qCGST = 0.00;
		Double qSGST = 0.00;
		Double grandTotal = 0.00;

		Boolean taxType = null;
		Double adjustment = 0.00;
		Double tcsAmount = 0.00;
		String tcs = "";
		String terms = "";

		String createdBy = "";
		String organization = "";
		String orgDivision = "";
		String shippingDetails = "";
		String orgDetails = "";
		String custDetails = "";

		String multidocument = "";
		String quotationId = "";
		String sapPoId = "";

		for (RestPurchaseOrderModel m : purchase) {
			vendorId = m.getVendorId();
			poId = m.getPoId();
			annextureId = m.getAnnextureId();
			qutValidDate = m.getQutValidDate();
			reference = m.getReference();
			paymentTermId = m.getPaymentTermId();
			advance = m.getAdvance();
			carrierId = m.getCarrierId();
			qutDescription = m.getQutDescription();
			itemDesc = m.getItemDesc();
			descWork = m.getDescWork();
			termDelivery = m.getTermDelivery();
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
			/*
			 * subTotal = m.getSubTotal(); qIGST = m.getqIGST(); qCGST = m.getqCGST(); qSGST
			 * = m.getqSGST(); grandTotal = m.getGrandTotal();
			 */
			taxType = m.getTaxType();

			if (m.getAdjustment() != null) {
				adjustment = m.getAdjustment();
			}
			if (m.getTcsAmount() != null) {
				tcsAmount = m.getTcsAmount();
			}
			// adjustment = m.getAdjustment();
			// tcsAmount = m.getTcsAmount();
			tcs = m.getTcs();
			terms = m.getTerms();

			createdBy = m.getCreatedBy();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			shippingDetails = m.getShippingDetails();
			orgDetails = m.getOrgDetails();
			custDetails = m.getCustDetails();
			quotationId = m.getQuotationId();
			sapPoId = m.getSapPOId();
			project = m.getProject();
		}

		s = s + "@p_vendorId='" + vendorId + "',";
		s = s + "@p_poId='" + poId + "',";
		s = s + "@p_annextureId='" + annextureId + "',";
		s = s + "@p_qutValidDate='" + DateFormatter.getStringDate(qutValidDate) + "',";
		s = s + "@p_reference='" + reference + "',";
		s = s + "@p_paymentTermId='" + paymentTermId + "',";
		s = s + "@p_advance='" + advance + "',";
		s = s + "@p_carrierId='" + carrierId + "',";
		s = s + "@p_qutDescription='" + qutDescription + "',";
		s = s + "@p_subTotal=" + subTotal + ",";
		
		s = s + "@p_qIGST=" + qIGST + ",";
		s = s + "@p_qCGST=" + qCGST + ",";
		s = s + "@p_qSGST=" + qSGST + ",";

		s = s + "@p_grandTotal=" + grandTotal + ",";
		s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_adjustment=" + adjustment + ",";
		s = s + "@p_tcsAmount=" + tcsAmount + ",";
		s = s + "@p_tcs='" + tcs + "',";
		s = s + "@p_terms='"+ terms + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_shippingDetails='" + shippingDetails + "',";
		s = s + "@p_orgDetails='" + orgDetails + "',";
		s = s + "@p_custDetails='" + custDetails + "',";
		s = s + "@p_quotationId='" + quotationId + "',";
		s = s + "@p_sapPoId='" + sapPoId + "',";
		s = s + "@p_itemDesc='" + itemDesc + "',";
		s = s + "@p_descWork='" + descWork + "',";
		s = s + "@p_termDelivery='" + termDelivery + "',";
		s = s + "@p_project='" + project + "',";


		if (!purchase.get(0).getPoId().contentEquals("1")) {
			for (RestPurchaseOrderModel m : purchase) {

				listdata = listdata + "(@p_poId,\"" + m.getItemId() + "\",\"" + m.getItemName() + "\","
						+ m.getQuantity() + "," + m.getUnitPrice() + "," + m.getDiscount() + "," + m.getDiscountType() + "," + m.getGstRate() + ","
						+ m.getLineTotal() + ",\"" + m.getSku() + "\"," + m.getItemIgst() + "," + m.getItemCgst() + ","
						+ m.getItemSgst() + ",\"" + m.getHsnCode() + "\",\"" + m.getUnit() + "\"," + m.getTaxableAmt()
						+ ",\"" + m.getBrandName() + "\","
								+ "@p_organization,@p_orgDivision,\"" + m.getModelSize() +"\" ),";
			}
			listdata = listdata.substring(0, listdata.length() - 1);

			//s = s + "@p_litemSubQuery='" + listdata + "',";
			s = s + "@p_litemSubQuery='" + listdata + "',@p_headerList='"+purchase.get(0).getHeaderList()+"'"
					+ ",@p_itemList='"+purchase.get(0).getItemList()+"',@p_poId='"+purchase.get(0).getPoId()+"',@p_annextureId='"+purchase.get(0).getAnnextureId()+"',@p_annexureName='"+purchase.get(0).getAnnexureName()+"',";

			/*
			 * List<InventoryVendorDocumentModel> item2 = purchase.get(0).getDocumentList();
			 * if (purchase.get(0).getDocumentList().size() > 0) { for
			 * (InventoryVendorDocumentModel a : item2) { if
			 * (!a.getDocumnentName().contentEquals("") &&
			 * !a.getDocumnentName().contentEquals("null")) { multidocument = multidocument
			 * + "(@p_poId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() +
			 * "\",@p_createdBy,@p_organization,@p_orgDivision),"; } } multidocument =
			 * multidocument.substring(0, multidocument.length() - 1); } else {
			 * multidocument = ""; } s = s + "@p_vendorDocuments='" + multidocument + "',";
			 */

			if (purchase.get(0).getDocumentList() != null && !purchase.get(0).getDocumentList().isEmpty()) {
				for (InventoryVendorDocumentModel m : purchase.get(0).getDocumentList()) {
					multidocument = multidocument + "(@p_poId,\"" + m.getSlno() + "\",\"" + m.getDocName() + "\",\""
							+ m.getDocView() + "\",@p_createdby,@p_orgName,@p_orgDiv),"; 
				}
				multidocument = multidocument.substring(0, multidocument.length() - 1);
				s = s + "@p_vendorDocuments='" + multidocument + "',";
			} else {
				s = s + "@p_vendorDocuments='',";
			}

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		System.out.println("Item Details" + s);
		return s;
	}

	public static String getDeletePo(RestPurchaseOrderModel purchase) {
		String[] userIds = purchase.getPoId().split(",");
		System.out.println("purchase====" + purchase);

		String s = "";
		String litem = "";
		if (purchase.getOrganization() != null && purchase.getOrganization() != "") {
			s = s + "@p_orgName='" + purchase.getOrganization() + "',";
		}
		if (purchase.getOrgDivision() != null && purchase.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + purchase.getOrgDivision() + "',";
		}

		for (String a : userIds) {
			System.out.println("userIds====" + userIds);
			litem = litem + "\"" + a + "\",";
		}
		litem = litem.substring(0, litem.length() - 1);
		litem = "(" + litem + ")";
		s = s + "@p_poId='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("EE" + s);

		return s;
	}

	public static String getBillingaddressadd(RestVendorNewModel restVendorNewModel) {

		String s = "";

		s = s + "@p_vendorId='" + restVendorNewModel.getVendorId() + "',";

		if (restVendorNewModel.getCountry() != null && restVendorNewModel.getCountry() != "") {
			s = s + "@p_bCountry='" + restVendorNewModel.getCountry() + "',";
		}
		if (restVendorNewModel.getStates() != null && restVendorNewModel.getStates() != "") {
			s = s + "@p_bstate='" + restVendorNewModel.getStates() + "',";
		}
		if (restVendorNewModel.getCity() != null && restVendorNewModel.getCity() != "") {
			s = s + "@p_bcity='" + restVendorNewModel.getCity() + "',";
		}
		if (restVendorNewModel.getStreet1() != null && restVendorNewModel.getStreet1() != "") {
			s = s + "@p_bstreet1='" + restVendorNewModel.getStreet1() + "',";
		}
		if (restVendorNewModel.getStreet2() != null && restVendorNewModel.getStreet2() != "") {
			s = s + "@p_bstreet2='" + restVendorNewModel.getStreet2() + "',";
		}
		if (restVendorNewModel.getZipCode() != null && restVendorNewModel.getZipCode() != "") {
			s = s + "@p_zipcode='" + restVendorNewModel.getZipCode() + "',";
		}

		if (restVendorNewModel.getPhone() != null && restVendorNewModel.getPhone() != "") {
			s = s + "@p_bphone='" + restVendorNewModel.getPhone() + "',";
		}
		if (restVendorNewModel.getFax() != null && restVendorNewModel.getFax() != "") {
			s = s + "@p_bfax='" + restVendorNewModel.getFax() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}

	public static String getShippingaddressadd(RestVendorNewModel restVendorNewModel) {

		String s = "";

		s = s + "@p_custId='" + restVendorNewModel.getVendorId() + "',";

		if (restVendorNewModel.getCountry1() != null && restVendorNewModel.getCountry1() != "") {
			s = s + "@p_bCountry='" + restVendorNewModel.getCountry1() + "',";
		}
		if (restVendorNewModel.getStates1() != null && restVendorNewModel.getStates1() != "") {
			s = s + "@p_bstate='" + restVendorNewModel.getStates1() + "',";
		}
		if (restVendorNewModel.getCity1() != null && restVendorNewModel.getCity1() != "") {
			s = s + "@p_bcity='" + restVendorNewModel.getCity1() + "',";
		}
		if (restVendorNewModel.getStreet11() != null && restVendorNewModel.getStreet11() != "") {
			s = s + "@p_bstreet1='" + restVendorNewModel.getStreet11() + "',";
		}
		if (restVendorNewModel.getStreet21() != null && restVendorNewModel.getStreet21() != "") {
			s = s + "@p_bstreet2='" + restVendorNewModel.getStreet21() + "',";
		}
		if (restVendorNewModel.getZipCode1() != null && restVendorNewModel.getZipCode1() != "") {
			s = s + "@p_zipcode='" + restVendorNewModel.getZipCode1() + "',";
		}

		if (restVendorNewModel.getPhone1() != null && restVendorNewModel.getPhone1() != "") {
			s = s + "@p_bphone='" + restVendorNewModel.getPhone1() + "',";
		}
		if (restVendorNewModel.getFax1() != null && restVendorNewModel.getFax1() != "") {
			s = s + "@p_bfax='" + restVendorNewModel.getFax1() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}
	public static String getBrandAdd(ProductMasterModel productMasterModel) {

		String s = "";

		s = s + "@p_brandId='" + productMasterModel.getBrandId() + "',";

		if (productMasterModel.getBrandName() != null && productMasterModel.getBrandName() != "") {
			s = s + "@p_brandName='" + productMasterModel.getBrandName() + "',";
		}
		if (productMasterModel.getBrandDesc() != null && productMasterModel.getBrandDesc() != "") {
			s = s + "@p_brandDesc='" + productMasterModel.getBrandDesc() + "',";
		}
		if (productMasterModel.getCreatedBy() != null && productMasterModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + productMasterModel.getCreatedBy() + "',";
		}
		if (productMasterModel.getOrganizationName() != null && productMasterModel.getOrganizationName() != "") {
			s = s + "@p_org='" + productMasterModel.getOrganizationName() + "',";
		}
		if (productMasterModel.getOrganizationDivision() != null && productMasterModel.getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + productMasterModel.getOrganizationDivision() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}
	public static String getDeptAdd(ProductMasterModel productMasterModel) {

		String s = "";
		System.out.println("NAME" + productMasterModel.getDeptName());

		s = s + "@p_deptId='" + productMasterModel.getDeptId() + "',";

		if (productMasterModel.getDeptName() != null && productMasterModel.getDeptName() != "") {
			s = s + "@p_deptName='" + productMasterModel.getDeptName() + "',";
		}
		if (productMasterModel.getDeptDesc() != null && productMasterModel.getDeptDesc() != "") {
			s = s + "@p_deptDesc='" + productMasterModel.getDeptDesc() + "',";
		}
		if (productMasterModel.getCreatedBy() != null && productMasterModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + productMasterModel.getCreatedBy() + "',";
		}
		if (productMasterModel.getOrganizationName() != null && productMasterModel.getOrganizationName() != "") {
			s = s + "@p_org='" + productMasterModel.getOrganizationName() + "',";
		}
		if (productMasterModel.getOrganizationDivision() != null && productMasterModel.getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + productMasterModel.getOrganizationDivision() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}
	public static String addPOUploadDataParam(List<RestPurchaseOrderModel> data) {
		String s = "";
		// String emplist = "";
		String datalist = "";

		if (data.size() > 0) {
			for (RestPurchaseOrderModel m : data) {
				datalist = datalist + "(\"" + m.getPlant() + "\",\"" + m.getDocDate() + "\",\""
						+ m.getPurchaseDoc() + "\",\"" + m.getItem() + "\", \"" + m.getVendorORsupllyingPlant() + "\",\""
						+ m.getMaterial() + "\",\"" + m.getShortText() + "\",\"" + m.getoUnit() + "\","
						+ "\"" + m.getNetPrice() + "\", \"" + m.getOrderQuantity() + "\",\"" 
						+ m.getToBeDel() + "\",\"" + m.getAgreement() + "\",\""
						+ m.getItemQty() + "\",\"" + m.getPer() + "\",\""
						+ m.getRel() + "\",\""
						+ m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision() + "\"),";
			}

		}
		
		if (!datalist.isEmpty()) {
			datalist = datalist.substring(0, datalist.length() - 1);
			s = s + "@P_POSubQuery='" + datalist + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

}
