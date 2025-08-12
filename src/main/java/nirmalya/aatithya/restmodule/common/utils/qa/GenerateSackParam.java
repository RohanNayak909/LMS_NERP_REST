package nirmalya.aatithya.restmodule.common.utils.qa;
import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.qa.model.QaSackRestModel;
public class GenerateSackParam {
	
	public static String getAddsack(List<QaSackRestModel> qp) {
		String s = "";
		String sitem = "";

		
		if (qp.get(0).getSackId() != null || qp.get(0).getSackId() != "") {
			s = s + "@p_sackId='" + qp.get(0).getSackId() + "',";
		}
		
		if (qp.get(0).getPpbag() != null || qp.get(0).getPpbag() != "") {
			s = s + "@p_ppBag='" + qp.get(0).getPpbag() + "',";
		}
		
		if (qp.get(0).getPdate() != null || qp.get(0).getPdate() != "") {
			s = s + "@p_pDate='" +  DateFormatter.getStringDate(qp.get(0).getPdate()) + "',";
		}
		
		if (qp.get(0).getSupplier() != null || qp.get(0).getSupplier() != "") {
			s = s + "@p_supplier='" + qp.get(0).getSupplier() + "',";
		}

		if (qp.get(0).getInvoice() != null || qp.get(0).getInvoice() != "") {
			s = s + "@p_invoice='" + qp.get(0).getInvoice() + "',";
		}
		
		if (qp.get(0).getGrnno() != null || qp.get(0).getGrnno() != "") {
			s = s + "@p_grnno='" + qp.get(0).getGrnno() + "',";
		}
			
		if (qp.get(0).getInvoice1() != null || qp.get(0).getInvoice1() != "") {
			s = s + "@p_invoice1='" + qp.get(0).getInvoice1() + "',";
		}
		if (qp.get(0).getDroptest() != null || qp.get(0).getDroptest() != "") {
			s = s + "@p_dropTest='" + qp.get(0).getDroptest() + "',";
		}
		if (qp.get(0).getAlkalitest() != null || qp.get(0).getAlkalitest() != "") {
			s = s + "@p_alkaliTest='" + qp.get(0).getAlkalitest() + "',";
		}
		
		if (qp.get(0).getInktest() != null || qp.get(0).getInktest() != "") {
			s = s + "@p_inkTest='" + qp.get(0).getInktest() + "',";
		}
		if (qp.get(0).getThreadwarp() != null || qp.get(0).getThreadwarp() != "") {
			s = s + "@p_threadWarp='" + qp.get(0).getThreadwarp() + "',";
		}
		
		if (qp.get(0).getThreadweft() != null || qp.get(0).getThreadweft() != "") {
			s = s + "@p_threadWeft='" + qp.get(0).getThreadweft() + "',";
		}
		
		if (qp.get(0).getLength() != null || qp.get(0).getLength() != "") {
			s = s + "@p_length='" + qp.get(0).getLength() + "',";
		}
		if (qp.get(0).getWidth() != null || qp.get(0).getWidth() != "") {
			s = s + "@p_width='" + qp.get(0).getWidth() + "',";
		}
		if (qp.get(0).getGsm() != null || qp.get(0).getGsm() != "") {
			s = s + "@p_gsm='" + qp.get(0).getGsm() + "',";
		}
		if (qp.get(0).getWeight() != null || qp.get(0).getWeight() != "") {
			s = s + "@p_weight='" + qp.get(0).getWeight() + "',";
		}
		if (qp.get(0).getRejectionqa() != null || qp.get(0).getRejectionqa() != "") {
			s = s + "@p_rejectionQa='" + qp.get(0).getRejectionqa() + "',";
		}
		if (qp.get(0).getRemarks() != null || qp.get(0).getRemarks() != "") {
			s = s + "@p_remarks='" + qp.get(0).getRemarks() + "',";
		}
		if (qp.get(0).getCreatedBy() != null || qp.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + qp.get(0).getCreatedBy() + "',";
		}

		if (qp.get(0).getOrganization() != null || qp.get(0).getOrganization() != "") {
			s = s + "@p_org='" + qp.get(0).getOrganization() + "',";
		}
		if (qp.get(0).getOrgDivision() != null || qp.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + qp.get(0).getOrgDivision() + "',";
		}
		
		
		if (qp.get(0).getReqid() != null || qp.get(0).getReqid() != "") {
			s = s + "@p_reqId='" + qp.get(0).getReqid() + "',";
		}
		
		if (qp.get(0).getSku() != null || qp.get(0).getSku() != "") {
			s = s + "@p_skuId='" + qp.get(0).getSku() + "',";
		}
		
		if (qp.get(0).getTestRes() != null || qp.get(0).getTestRes() != "") {
			s = s + "@p_testRes='" + qp.get(0).getTestRes() + "',";
		}
		

		for (QaSackRestModel m : qp) {

			sitem = sitem + "(@p_sackId,\"" + m.getReqid() + "\",\"" + m.getSlNo() +"\",\"" + m.getLength1() +"\",\"" + m.getWidth1() +"\",\"" +m.getWeight1()
			 +"\",\"" + m.getGsm1() +"\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()+ "\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;

	}
}
