package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.sales.model.RestQuotationNewModel;

public class GeneratePoNoNewParameter {
	
public static String getAddempParam(RestQuotationNewModel customer) {
		
		String s = "";

		if (customer.getQuotationId() != null && customer.getQuotationId() != "") {
			s = s + "@p_quotationId='" + customer.getQuotationId() + "',";
		}
		if (customer.getPoNo() != null && customer.getPoNo() != "") {
			s = s + "@p_poNo='" + customer.getPoNo() + "',";
		}
		if (customer.getPoDate() != null && customer.getPoDate() != "") {
			s = s + "@p_poDate='" + customer.getPoDate() + "',";
		}
		if (customer.getFilePoSale()!= null && customer.getFilePoSale() != "") {
			s = s + "@p_filePosale='" + customer.getFilePoSale() + "',";
		}
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println("s"+s);
		}

		return s;
	}


}
