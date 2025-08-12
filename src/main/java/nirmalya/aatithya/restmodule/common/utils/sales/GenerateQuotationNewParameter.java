package nirmalya.aatithya.restmodule.common.utils.sales;

import java.util.ArrayList;
import java.util.List;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.BomMaster;
import nirmalya.aatithya.restmodule.sales.model.RestCustoomerNewModel;
import nirmalya.aatithya.restmodule.sales.model.RestQuotationNewModel;
import nirmalya.aatithya.restmodule.sales.model.ScopeMatrixRestModel;

public class GenerateQuotationNewParameter {

	@SuppressWarnings("null")
	public static String getAddempParam(List<RestQuotationNewModel> customer) {

		String s = "";
		String listdata = "";
		String quotationId = "";
		String draftId = "";
		String quoDate = "";
		String qutValidDate = "";
		String qutDescription = "";
		String qutSub = "";
		String qutCreatedBy = "";
		String reference = "";
		String termCondition = "";
		String scopematrix = "";
		String version = "";
		String orderType = "";
		String customerId = "";
		String endCustName = "";
		Double subTotal = 0.00;
		Double qIGST = 0.00;
		Double qCGST = 0.00;
		Double qSGST = 0.00;
		Double grandTotal = 0.00;
		Boolean taxType = null;
		String org = "";
		String div = "";
		String quotType = "";
		String shippingHiddenId = "";
		String project = "";
		// String quotationNo = "";
		String bomList = "";
		String itemDetails = "";

		List<BomMaster> bomDetails = new ArrayList<BomMaster>();

		for (RestQuotationNewModel m : customer) {
			quotationId = m.getQuotationId();
			if (m.getDraftId() != null && m.getDraftId() != "null" && m.getDraftId() != "") {
				draftId = m.getDraftId();
			}
			quoDate = m.getQuotationDate();
			qutValidDate = m.getQutValidDate();
			reference = m.getReference();
			qutSub = m.getSubject();
			qutCreatedBy = m.getQutCreatedBy();
			qutDescription = m.getQutDescription();
			termCondition = m.getTermCondition();
			org = m.getOrganization();
			div = m.getOrgDivision();
			version = m.getVersion();
			// orderType = m.getOrderType();
			customerId = m.getCustId();
			endCustName = m.getEndCustName();
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
			taxType = m.getTaxType();
			quotType = m.getQuotType();
			shippingHiddenId = m.getShippingHiddenId();
			project = m.getProject();

			if (m.getBomDetails() != null && m.getBomDetails().size() > 0) {
				bomDetails.addAll(m.getBomDetails());
			}

			if (m.getBomList() != null) {
				bomList = m.getBomList();
			}
			if (m.getItemDetails() != null) {
				itemDetails = m.getItemDetails();
			}

		}

		s = s + "@p_quotationId='" + quotationId + "',";
		s = s + "@p_draftId='" + draftId + "',";
		// s = s + "@p_orderType='" + orderType + "',";
		s = s + "@p_quoDate='" + quoDate + "',";
		s = s + "@p_qutValidDate='" + qutValidDate + "',";
		s = s + "@p_reference='" + reference + "',";
		s = s + "@p_qutSub='" + qutSub + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_qutDescription='" + qutDescription + "',";
		s = s + "@p_termCondition='" + termCondition + "',";
		s = s + "@p_org='" + org + "',";
		s = s + "@p_div='" + div + "',";
		s = s + "@p_version='" + version + "',";
		s = s + "@p_cId='" + customerId + "',";
		s = s + "@p_endCustName='" + endCustName + "',";
		s = s + "@p_qutSubTotal=" + subTotal + ",";
		s = s + "@p_qutIGST=" + qIGST + ",";
		s = s + "@p_qutCGST=" + qCGST + ",";
		s = s + "@p_qutSGST=" + qSGST + ",";
		s = s + "@p_qutGrandTotal=" + grandTotal + ",";
		s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_quotType='" + quotType + "',";
		s = s + "@p_shippingsddress='" + shippingHiddenId + "',";
		s = s + "@p_project='" + project + "',";
		s = s + "@p_bomList='" + bomList + "',";
		s = s + "@p_itemDetails='" + itemDetails + "',";
		// s = s + "@p_bomDetails='" + (bomDetails != null ? bomDetails.toString() : "")
		// + "',";

		if (!customer.get(0).getQuotationId().contentEquals("1")) {
			for (RestQuotationNewModel m : customer) {
				listdata = listdata + "(@p_quotationId,\"" + m.getParentItemId() + "\",\"" + m.getItemName() + "\",\""
						+ m.getQuantity() + "\",\"" + m.getUnitPrice() + "\",\"" + m.getSizeInMM() + "\",\""
						+ m.getUnit() + "\",\"" + m.getGstRate() + "\",\"" + m.getLineTotal() + "\"," + m.getItemIgst()
						+ "," + m.getItemCgst() + "," + m.getItemSgst() + "," + m.getTaxableAmt() + ",\"" + m.getItemId()
						+ "\",\"" + m.getThicknessInMM() + "\",\"" + m.getItemDesc().replace("'", "\\'").replace("\"", "\\\\\"") + "\",\"" + m.getHsnCode()
						+ "\",@p_org,@p_div),";

			}
			System.out.println(listdata);
			if (customer.get(0).getScopematrix().size() > 0) {
				for (ScopeMatrixRestModel a : customer.get(0).getScopematrix()) {

					scopematrix = scopematrix + "(@p_quotationId,\"" + a.getScopeMatrixSlNo() + "\",\""
							+ a.getMatrixSamudyam() + "\", \"" + a.getMatrixClient() + "\", \"" + a.getScopeMatrixDesc()
							+ "\", @p_qutCreatedBy,\"" + a.getScopeMatrixRemarks() + "\",@p_org,@p_div),";
				}
			} else {
				scopematrix = "";
			}

			if (!listdata.isEmpty()) {
				listdata = listdata.substring(0, listdata.length() - 1);
				s = s + "@p_litemSubQuery='" + listdata + "',";
			}
			if (!scopematrix.isEmpty()) {
				scopematrix = scopematrix.substring(0, scopematrix.length() - 1);
				s = s + "@p_litemSubQueryforscope='" + scopematrix + "',";
			}

			String multidocument = "";
			List<InventoryVendorDocumentModel> item2 = customer.get(0).getDocumentList();
			if (customer.get(0).getDocumentList().size() > 0) {
				for (InventoryVendorDocumentModel a : item2) {
					if (!a.getDocumnentName().contentEquals("") && !a.getDocumnentName().contentEquals("null")) {
						multidocument = multidocument + "(@p_quotationId,\"" + a.getDocumnentName().replace("'", "\\'").replace("\"", "\\\\\"") + "\",\""
								+ a.getFileName() + "\",@p_qutCreatedBy,@p_org,@p_div),";
					}
				}
				multidocument = multidocument.substring(0, multidocument.length() - 1);
			} else {
				multidocument = "";
			}
			s = s + "@p_vendorDocuments='" + multidocument + "',";

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		return s;

	}

	public static String getAddQuotationDraftParam(List<RestQuotationNewModel> customer) {

		String s = "";
		String listdata = "";
		String draftId = "";
		String quoDate = "";
		String qutValidDate = "";
		String qutDescription = "";
		String qutSub = "";
		String qutCreatedBy = "";
		// String quotationId="";
		String termCondition = "";
		// String scopematrix = "";
		String version = "";
		// String orderType = "";
		String customerId = "";
		String endCustName = "";
		Double subTotal = 0.00;
		Double qIGST = 0.00;
		Double qCGST = 0.00;
		Double qSGST = 0.00;
		Double grandTotal = 0.00;
		Boolean taxType = null;
		String org = "";
		String div = "";
		String quotType = "";
		String shippingHiddenId = "";
		String project = "";
		String bomList = "";
		String itemDetails = "";

		List<BomMaster> bomDetails = new ArrayList<BomMaster>();

		for (RestQuotationNewModel m : customer) {
			draftId = m.getDraftId();
			quoDate = m.getQuotationDate();
			qutValidDate = m.getQutValidDate();

			qutSub = m.getSubject();
			qutCreatedBy = m.getQutCreatedBy();
			qutDescription = m.getQutDescription();
			termCondition = m.getTermCondition();
			org = m.getOrganization();
			div = m.getOrgDivision();
			version = m.getVersion();
			// orderType = m.getOrderType();
			customerId = m.getCustId();
			endCustName = m.getEndCustName();
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
			taxType = m.getTaxType();
			quotType = m.getQuotType();
			shippingHiddenId = m.getShippingHiddenId();
			project = m.getProject();
			// quotationId=m.getQuotationId();

			if (m.getBomDetails() != null && m.getBomDetails().size() > 0) {
				bomDetails.addAll(m.getBomDetails());
			}

			if (m.getBomList() != null) {
				bomList = m.getBomList();
			}
			if (m.getItemDetails() != null) {
				itemDetails = m.getItemDetails();
			}
		}

		s = s + "@p_draftId='" + draftId + "',";
		// s = s + "@p_orderType='" + orderType + "',";
		s = s + "@p_quoDate='" + quoDate + "',";
		s = s + "@p_qutValidDate='" + qutValidDate + "',";
		// s = s + "@p_quotationId='" + quotationId + "',";
		s = s + "@p_qutSub='" + qutSub + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_qutDescription='" + qutDescription + "',";
		s = s + "@p_termCondition='" + termCondition + "',";
		s = s + "@p_org='" + org + "',";
		s = s + "@p_div='" + div + "',";
		s = s + "@p_version='" + version + "',";
		s = s + "@p_cId='" + customerId + "',";
		s = s + "@p_endCustName='" + endCustName + "',";
		s = s + "@p_qutSubTotal=" + subTotal + ",";
		s = s + "@p_qutIGST=" + qIGST + ",";
		s = s + "@p_qutCGST=" + qCGST + ",";
		s = s + "@p_qutSGST=" + qSGST + ",";
		s = s + "@p_qutGrandTotal=" + grandTotal + ",";
		s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_quotType='" + quotType + "',";
		s = s + "@p_shippingsddress='" + shippingHiddenId + "',";
		s = s + "@p_project='" + project + "',";
		s = s + "@p_bomList='" + bomList + "',";
		s = s + "@p_itemDetails='" + itemDetails + "',";
		// s = s + "@p_bomDetails='" + (bomDetails != null ? bomDetails.toString() : "")
		// + "',";

		if (!customer.get(0).getDraftId().contentEquals("1")) {
			for (RestQuotationNewModel m : customer) {
				listdata = listdata + "(@p_draftId,\"" + m.getParentItemId() + "\",\"" + m.getItemName() + "\",\""
						+ m.getQuantity() + "\",\"" + m.getUnitPrice() + "\",\"" + m.getSizeInMM() + "\",\""
						+ m.getUnit() + "\",\"" + m.getGstRate() + "\",\"" + m.getLineTotal() + "\"," + m.getItemIgst()
						+ "," + m.getItemCgst() + "," + m.getItemSgst() + "," + m.getTaxableAmt() + ",\"" + m.getItemId()
						+ "\",\"" + m.getThicknessInMM() + "\",\"" + m.getItemDesc().replace("'", "\\'").replace("\"", "\\\\\"") + "\",\"" + m.getHsnCode()
						+ "\",@p_org,@p_div),";

			}
			/*
			 * if (customer.get(0).getScopematrix().size() > 0) { for (ScopeMatrixRestModel
			 * a : customer.get(0).getScopematrix()) {
			 * 
			 * scopematrix = scopematrix + "(@p_draftId,\"" + a.getScopeMatrixSlNo() +
			 * "\",\"" + a.getMatrixSamudyam() + "\", \"" + a.getMatrixClient() + "\", \"" +
			 * a.getScopeMatrixDesc() + "\", @p_qutCreatedBy,\"" + a.getScopeMatrixRemarks()
			 * + "\"),";
			 * 
			 * } }else { scopematrix=""; }
			 */

			if (!listdata.isEmpty()) {
				listdata = listdata.substring(0, listdata.length() - 1);
				s = s + "@p_litemSubQuery='" + listdata + "',";
			}
			/*
			 * if (!scopematrix.isEmpty()) { scopematrix = scopematrix.substring(0,
			 * scopematrix.length() - 1); s = s + "@p_litemSubQueryforscope='" + scopematrix
			 * + "',"; }
			 */
			String multidocument = "";
			List<InventoryVendorDocumentModel> item2 = customer.get(0).getDocumentList();
			if (customer.get(0).getDocumentList().size() > 0) {
				for (InventoryVendorDocumentModel a : item2) {
					if (!a.getDocumnentName().contentEquals("") && !a.getDocumnentName().contentEquals("null")) {
						multidocument = multidocument + "(@p_draftId,\"" + a.getDocumnentName().replace("'", "\\'").replace("\"", "\\\\\"") + "\",\""
								+ a.getFileName() + "\",@p_qutCreatedBy),";
					}
				}
				multidocument = multidocument.substring(0, multidocument.length() - 1);
			} else {
				multidocument = "";
			}
			s = s + "@p_vendorDocuments='" + multidocument + "',";

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		return s;

	}

	public static String getDeleteParam(RestQuotationNewModel customer) {
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

	public static String getSalesPersonadd(RestQuotationNewModel restQuotationNewModel) {

		String s = "";

		// System.out.println("dddddddd"+s);
		// if (restQuotationNewModel.getSalespersonId() != null &&
		// restQuotationNewModel.getSalespersonId() != "") {
		s = s + "@p_spId='" + restQuotationNewModel.getSalespersonId() + "',";
		// }

		if (restQuotationNewModel.getSpName() != null && restQuotationNewModel.getSpName() != "") {
			s = s + "@p_spName='" + restQuotationNewModel.getSpName() + "',";
		}
		if (restQuotationNewModel.getSpGender() != null && restQuotationNewModel.getSpGender() != "") {
			s = s + "@p_genderId='" + restQuotationNewModel.getSpGender() + "',";
		}
		if (restQuotationNewModel.getDobid() != null && restQuotationNewModel.getDobid() != "") {
			s = s + "@p_dobId='" + restQuotationNewModel.getDobid() + "',";
		}
		if (restQuotationNewModel.getMobilenoid() != null && restQuotationNewModel.getMobilenoid() != "") {
			s = s + "@p_mobile='" + restQuotationNewModel.getMobilenoid() + "',";
		}
		if (restQuotationNewModel.getPersonalmailid() != null && restQuotationNewModel.getPersonalmailid() != "") {
			s = s + "@p_email='" + restQuotationNewModel.getPersonalmailid() + "',";
		}
		if (restQuotationNewModel.getAddressid_() != null && restQuotationNewModel.getAddressid_() != "") {
			s = s + "@p_address='" + restQuotationNewModel.getAddressid_() + "',";
		}

		if (restQuotationNewModel.getCreatedBy() != null && restQuotationNewModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restQuotationNewModel.getCreatedBy() + "',";
		}
		if (restQuotationNewModel.getOrganization() != null && restQuotationNewModel.getOrganization() != "") {
			s = s + "@p_org='" + restQuotationNewModel.getOrganization() + "',";
		}
		if (restQuotationNewModel.getOrgDivision() != null && restQuotationNewModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restQuotationNewModel.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}

	public static String getBillingaddressadd(RestCustoomerNewModel restCustoomerNewModel) {

		String s = "";

		// System.out.println("dddddddd"+s);
		// if (restQuotationNewModel.getSalespersonId() != null &&
		// restQuotationNewModel.getSalespersonId() != "") {
		s = s + "@p_custId='" + restCustoomerNewModel.getCustomerId() + "',";
		// }

		if (restCustoomerNewModel.getCountry() != null && restCustoomerNewModel.getCountry() != "") {
			s = s + "@p_bCountry='" + restCustoomerNewModel.getCountry() + "',";
		}
		if (restCustoomerNewModel.getStates() != null && restCustoomerNewModel.getStates() != "") {
			s = s + "@p_bstate='" + restCustoomerNewModel.getStates() + "',";
		}
		if (restCustoomerNewModel.getCity() != null && restCustoomerNewModel.getCity() != "") {
			s = s + "@p_bcity='" + restCustoomerNewModel.getCity() + "',";
		}
		if (restCustoomerNewModel.getStreet1() != null && restCustoomerNewModel.getStreet1() != "") {
			s = s + "@p_bstreet1='" + restCustoomerNewModel.getStreet1() + "',";
		}
		if (restCustoomerNewModel.getStreet2() != null && restCustoomerNewModel.getStreet2() != "") {
			s = s + "@p_bstreet2='" + restCustoomerNewModel.getStreet2() + "',";
		}
		if (restCustoomerNewModel.getZipCode() != null && restCustoomerNewModel.getZipCode() != "") {
			s = s + "@p_zipcode='" + restCustoomerNewModel.getZipCode() + "',";
		}

		if (restCustoomerNewModel.getPhone() != null && restCustoomerNewModel.getPhone() != "") {
			s = s + "@p_bphone='" + restCustoomerNewModel.getPhone() + "',";
		}
		if (restCustoomerNewModel.getFax() != null && restCustoomerNewModel.getFax() != "") {
			s = s + "@p_bfax='" + restCustoomerNewModel.getFax() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}

	public static String getShippingaddressadd(RestCustoomerNewModel restCustoomerNewModel) {

		String s = "";

		// System.out.println("dddddddd"+s);
		// if (restQuotationNewModel.getSalespersonId() != null &&
		// restQuotationNewModel.getSalespersonId() != "") {
		s = s + "@p_custId='" + restCustoomerNewModel.getCustomerId() + "',";
		// }

		if (restCustoomerNewModel.getCountry1() != null && restCustoomerNewModel.getCountry1() != "") {
			s = s + "@p_bCountry='" + restCustoomerNewModel.getCountry1() + "',";
		}
		if (restCustoomerNewModel.getStates1() != null && restCustoomerNewModel.getStates1() != "") {
			s = s + "@p_bstate='" + restCustoomerNewModel.getStates1() + "',";
		}
		if (restCustoomerNewModel.getCity1() != null && restCustoomerNewModel.getCity1() != "") {
			s = s + "@p_bcity='" + restCustoomerNewModel.getCity1() + "',";
		}
		if (restCustoomerNewModel.getStreet11() != null && restCustoomerNewModel.getStreet11() != "") {
			s = s + "@p_bstreet1='" + restCustoomerNewModel.getStreet11() + "',";
		}
		if (restCustoomerNewModel.getStreet21() != null && restCustoomerNewModel.getStreet21() != "") {
			s = s + "@p_bstreet2='" + restCustoomerNewModel.getStreet21() + "',";
		}
		if (restCustoomerNewModel.getZipCode1() != null && restCustoomerNewModel.getZipCode1() != "") {
			s = s + "@p_zipcode='" + restCustoomerNewModel.getZipCode1() + "',";
		}

		if (restCustoomerNewModel.getPhone1() != null && restCustoomerNewModel.getPhone1() != "") {
			s = s + "@p_bphone='" + restCustoomerNewModel.getPhone1() + "',";
		}
		if (restCustoomerNewModel.getFax1() != null && restCustoomerNewModel.getFax1() != "") {
			s = s + "@p_bfax='" + restCustoomerNewModel.getFax1() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}

	public static String getTcsadd(RestQuotationNewModel restQuotationNewModel) {

		String s = "";

		// System.out.println("dddddddd"+s);
		// if (restQuotationNewModel.getSalespersonId() != null &&
		// restQuotationNewModel.getSalespersonId() != "") {
		s = s + "@p_tcsId='" + restQuotationNewModel.getTcsId() + "',";
		// }

		if (restQuotationNewModel.getCollection() != null && restQuotationNewModel.getCollection() != "") {
			s = s + "@p_collId='" + restQuotationNewModel.getCollection() + "',";
		}
		if (restQuotationNewModel.getRateId() != null && restQuotationNewModel.getRateId() != "") {
			s = s + "@p_rateId='" + restQuotationNewModel.getRateId() + "',";
		}
		if (restQuotationNewModel.getTaxName() != null && restQuotationNewModel.getTaxName() != "") {
			s = s + "@p_taxname='" + restQuotationNewModel.getTaxName() + "',";
		}
		if (restQuotationNewModel.getCreatedBy() != null && restQuotationNewModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + restQuotationNewModel.getCreatedBy() + "',";
		}
		if (restQuotationNewModel.getOrganization() != null && restQuotationNewModel.getOrganization() != "") {
			s = s + "@p_org='" + restQuotationNewModel.getOrganization() + "',";
		}
		if (restQuotationNewModel.getOrgDivision() != null && restQuotationNewModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + restQuotationNewModel.getOrgDivision() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}

}
