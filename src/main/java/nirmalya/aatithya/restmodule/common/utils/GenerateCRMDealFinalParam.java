package nirmalya.aatithya.restmodule.common.utils;
import nirmalya.aatithya.restmodule.api.model.RestCrmDealFinalApiModel;
public class GenerateCRMDealFinalParam {
	public static String getdealParam(RestCrmDealFinalApiModel dealModel) {

		String s = "";

		if (dealModel.getDealId() != null && dealModel.getDealId() != "") {
			s = s + "@p_dealId='" + dealModel.getDealId() + "',";
		}
		if (dealModel.getDealPlanId() != null && dealModel.getDealPlanId() != "") {
			s = s + "@p_dealPlanId='" + dealModel.getDealPlanId() + "',";
		}
		if (dealModel.getLead() != null && dealModel.getLead() != "") {
			s = s + "@p_lead='" + dealModel.getLead() + "',";
		}
		if (dealModel.getDecisionMaker() != null && dealModel.getDecisionMaker() != "") {
			s = s + "@p_dmaker='" + dealModel.getDecisionMaker() + "',";
		}
		if (dealModel.getOrderRecived() != null && dealModel.getOrderRecived() != "") {
			s = s + "@p_oRecived='" + dealModel.getOrderRecived() + "',";
		}
		if (dealModel.getAmount() != null && dealModel.getAmount() != "") {
			s = s + "@p_amount='" + dealModel.getAmount() + "',";
		}
		if (dealModel.getDocName() != null && dealModel.getDocName() != "") {
			s = s + "@p_doc='" + dealModel.getDocName() + "',";
		}
		if (dealModel.getPcdCollected() != null && dealModel.getPcdCollected() != "") {
			s = s + "@p_pCollected='" + dealModel.getPcdCollected() + "',";
		}
		if (dealModel.getPcdAmount() != null && dealModel.getPcdAmount() != "" && !dealModel.getPcdDate().equals("")) {
			s = s + "@p_pcdAmount='" + dealModel.getPcdAmount() + "',";
		}
		if (dealModel.getPcdDate() != null && dealModel.getPcdDate() != "" && !dealModel.getPcdDate().equals("")) {
			s = s + "@p_pcdDate='" + dealModel.getPcdDate() + "',";
		}
		if (dealModel.getDealCreatedBy() != null && dealModel.getDealCreatedBy() != "") {
			s = s + "@p_createdBy='" + dealModel.getDealCreatedBy() + "',";
		}
		
		
		if (dealModel.getPaymentMode() != null && dealModel.getPaymentMode() != "") {
			s = s + "@p_pmode='" + dealModel.getPaymentMode() + "',";
		}
		if (dealModel.getBankName() != null && dealModel.getBankName() != "") {
			s = s + "@p_bankname='" + dealModel.getBankName() + "',";
		}
		if (dealModel.getBankBranch() != null && dealModel.getBankBranch() != "") {
			s = s + "@p_bankbranch='" + dealModel.getBankBranch() + "',";
		}
		if (dealModel.getAccountNo() != null && dealModel.getAccountNo() != "") {
			s = s + "@p_accountno='" + dealModel.getAccountNo() + "',";
		}
		if (dealModel.getChqNo() != null && dealModel.getChqNo() != "") {
			s = s + "@p_chqno='" + dealModel.getChqNo() + "',";
		}
		if (dealModel.getChqdate() != null && dealModel.getChqdate() != "" ) {
			s = s + "@p_chqdate='" +DateFormatter.getStringDate(dealModel.getChqdate()) + "',";
		}
		if(dealModel.getTransactionNo() != null && dealModel.getTransactionNo() != "") {
			s = s + "@p_transactionno='" + dealModel.getTransactionNo() + "',";
		}
		
		
		if(dealModel.getOrgName() != null && dealModel.getOrgName() != "") {
			s = s + "@p_org='" + dealModel.getOrgName() + "',";
		}
		if(dealModel.getOrgDiv() != null && dealModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + dealModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
}
