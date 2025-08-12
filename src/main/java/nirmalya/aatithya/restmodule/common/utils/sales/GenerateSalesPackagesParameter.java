package nirmalya.aatithya.restmodule.common.utils.sales;


import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.sales.model.RestSalesPackagesModel;



public class GenerateSalesPackagesParameter {
	
	public static String getAddPackageParam(List<RestSalesPackagesModel> customer) {
		String s = "";
		
		
		String salePackageId="";
		String packagingDate="";
		String custId="";
		String salesOrderId="";
		String poId="";
		String listdata="";
		String qutCreatedBy="";
		String packageSlip="";
		String internalNotes="";
		
		String org="";
		String div="";
		String shippingHiddenId="";
		
		for (RestSalesPackagesModel m : customer) {
			salePackageId=m.getSalePackageId();
			packagingDate=m.getPackagingDate();
			custId=m.getCustId();
			salesOrderId=m.getSalesOrderId();
			poId=m.getPoId();
			qutCreatedBy=m.getQutCreatedBy();
			packageSlip=m.getPackageSlip();
			internalNotes=m.getInternalNotes();
			
			org=m.getOrgName();
			div=m.getOrgDiv();
			shippingHiddenId=m.getShippingHiddenId();
			
			
		}
		
		s = s + "@p_packageId='" + salePackageId + "',";
		s = s + "@p_packagingDate='" + DateFormatter.getStringDate(packagingDate)+ "',";
		s = s + "@p_custId='" + custId + "',";
		s = s + "@p_salesOrderId='" + salesOrderId + "',";
		s = s + "@p_poId='" + poId + "',";
		s = s + "@p_qutCreatedBy='" + qutCreatedBy + "',";
		s = s + "@p_paySlip='" + packageSlip + "',";
		s = s + "@p_internalNotes='" + internalNotes + "',";
		
		s = s + "@p_org='" + org + "',";
		s = s + "@p_div='" + div + "',";
		s = s + "@p_shippingHiddenId='" + shippingHiddenId + "',";
		
		System.out.println(customer);
		if(!customer.isEmpty()) {
			if(!customer.get(0).getSalePackageId().contentEquals("1")) {
				for (RestSalesPackagesModel m : customer) {

					listdata = listdata + "(@p_packageId,\"" + m.getSalesOrderId() + "\",\"" + m.getItemId() + "\",\"" + m.getItemName() + "\",\""
							+ m.getQuantity() + "\",\"" + m.getUnit() + "\",\"" + m.getSku() + "\",\"" + m.getSkuName() + "\",\"" + m.getItemDesc() + "\",\"" + m.getHsnCode() + "\",\"" +m.getPackQut() +"\",\"" +m.getPackType() +"\" ,\"" +m.getPackDate() +"\",\"" +m.getPackDesc() +"\",\"" +m.getPackedQut() +"\",\"" +m.getPendingQut() +"\","+m.getNoOfItem()+",@p_org,@p_div),";
				}
				listdata = listdata.substring(0, listdata.length() - 1);
				s = s + "@p_litemSubQuery='" + listdata + "',";
				if (s != "") {
				s = s.substring(0, s.length() - 1);
				s = "SET " + s + ";";
				}
				}
		}else {
			System.out.println("customer object is empty.");
		}
		
		System.out.println("customer object is empty."+s);
		return s;
	}
	

	
	public static String getAddsalesParam(RestSalesPackagesModel customer) {
		String s = "";
		
		
		/*
		 * String salePackageId=""; String salesOrderId=""; //String listdata=""; String
		 * qutCreatedBy=""; String packItemName=""; String packTotalQut="";
		 * 
		 * String packUnit=""; String packQut=""; String packingQut=""; String
		 * packType=""; String packDate=""; String packDesc="";
		 */
		
		s = s + "@p_salePackageId='" + customer.getSalePackageId() + "',";
		s = s + "@p_salesOrderId='" + customer.getSalesOrderId() + "',";
		s = s + "@p_qutCreatedBy='" + customer.getQutCreatedBy() + "',";
		s = s + "@p_packItemName='" + customer.getPackItemName() + "',";
		s = s + "@p_packTotalQut='" + customer.getPackTotalQut() + "',";
		
		s = s + "@p_packUnit='" + customer.getPackUnit() + "',";
		s = s + "@p_packQut='" + customer.getPackQut() + "',";
		s = s + "@p_packingQut='" + customer.getPackingQut() + "',";
		s = s + "@p_packType='" + customer.getPackType() + "',";
		s = s + "@p_packDate='" + customer.getPackDate() + "',";
		s = s + "@p_packDesc='" + customer.getPackDesc() + "',";

		s = s + "@p_org='" + customer.getOrgName() + "',";
		s = s + "@p_div='" + customer.getOrgDiv() + "',";
		
		System.out.println(customer);
	
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("SET " +s );
		return s;
	}
}
		
		
	

