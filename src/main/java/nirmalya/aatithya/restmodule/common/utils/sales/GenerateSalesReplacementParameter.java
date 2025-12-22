package nirmalya.aatithya.restmodule.common.utils.sales;

import java.util.List;

import nirmalya.aatithya.restmodule.sales.model.RestSalesReplacementModel;

public class GenerateSalesReplacementParameter {
	public static String getAddempParam(List<RestSalesReplacementModel> customer) {
		String s = "";
		
		
		String replacementId="";
		String custId="";
		String salesOrderId="";
		String resonForReturn="";
		String comments="";
        String qutCreatedBy="";
		for (RestSalesReplacementModel m : customer) {
			replacementId=m.getReplacementId();
			custId=m.getCustId();
			salesOrderId=m.getSalesOrderId();
			resonForReturn=m.getResonForReturn();
			comments=m.getComments();
			qutCreatedBy=m.getQutCreatedBy();
					
		}
		
		s = s + "@p_replacementId='" + replacementId + "',";
		s = s + "@p_custId='" + custId + "',";
		s = s + "@p_saleOrderId='" + salesOrderId + "',";
		s = s + "@p_returnreason='" + resonForReturn + "',";
		s = s + "@p_comment='" + comments + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
	
		
		System.out.println(customer);
		if(!customer.isEmpty()) {
			if(!customer.get(0).getReplacementId().contentEquals("1")) {
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
