
package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.gatepass.model.RestGatePassDetailsModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.gatepass.model.RestGatePassDetailsModel;


public class GenerateGatePassExitParam {
	public static String getGatepassExitParam(List<RestGatePassDetailsModel> gatepass) {
		String s = "";
		String listdata1 ="";
		String multidocument = "";
		
		
			s = s + "@p_exitid='" + gatepass.get(0).getGetPassExitId() + "',";
	
		if (gatepass.get(0).getGetPassEntryId() != null && gatepass.get(0).getGetPassEntryId() != "") {
			s = s + "@p_entryId='" + gatepass.get(0).getGetPassEntryId() + "',";
		}
		if (gatepass.get(0).getPoNumber() != null && gatepass.get(0).getPoNumber() != "") {
			s = s + "@p_poId='" + gatepass.get(0).getPoNumber() + "',";
		}
		if (gatepass.get(0).getType() != null && gatepass.get(0).getType() != "") {
			s = s + "@p_type='" + gatepass.get(0).getType() + "',";
		}
		if (gatepass.get(0).getExitDate() != null && gatepass.get(0).getExitDate() != "") {
			s = s + "@p_exitdate='" + DateFormatter.getStringDate(gatepass.get(0).getExitDate()) + "',";
		}
		if (gatepass.get(0).getExitTime() != null && gatepass.get(0).getExitTime() != "") {
			s = s + "@p_exittime='" + gatepass.get(0).getExitTime() + "',";
		}
		if (gatepass.get(0).getTransportName() != null && gatepass.get(0).getTransportName() != "") {
			s = s + "@p_transportName='" + gatepass.get(0).getTransportName() + "',";
		}
		if (gatepass.get(0).getLrNo() != null && gatepass.get(0).getLrNo() != "") {
			s = s + "@p_lrNo='" + gatepass.get(0).getLrNo() + "',";
		}
		if (gatepass.get(0).getVechileNo() != null && gatepass.get(0).getVechileNo() != "") {
			s = s + "@p_vechileno='" + gatepass.get(0).getVechileNo() + "',";
		}
		
		if (gatepass.get(0).getDriverName() != null && gatepass.get(0).getDriverName() != "") {
			s = s + "@p_drivername='" + gatepass.get(0).getDriverName() + "',";
		}
		if (gatepass.get(0).getDriverMobile() != null && gatepass.get(0).getDriverMobile() != "") {
			s = s + "@p_drivermob='" + gatepass.get(0).getDriverMobile() + "',";
		}
	
		if (gatepass.get(0).getNoOfWheel() != null && gatepass.get(0).getNoOfWheel() != "") {
			s = s + "@p_noOfWheel='" + gatepass.get(0).getNoOfWheel() + "',";
		}
		if (gatepass.get(0).getDlNo() != null && gatepass.get(0).getDlNo() != "") {
			s = s + "@p_dlNo='" + gatepass.get(0).getDlNo() + "',";
		}
		if (gatepass.get(0).getDepoName() != null && gatepass.get(0).getDepoName() != "") {
			s = s + "@p_depoName='" + gatepass.get(0).getDepoName() + "',";
		}
		
		if (gatepass.get(0).getTruckSeal() != null && gatepass.get(0).getTruckSeal() != "") {
			s = s + "@p_truckSeal='" + gatepass.get(0).getTruckSeal() + "',";
		}
		if (gatepass.get(0).getRoadTax() != null && gatepass.get(0).getRoadTax() != "") {
			s = s + "@p_roadTax='" + gatepass.get(0).getRoadTax() + "',";
		}
		if (gatepass.get(0).getInsuranceDate() != null && gatepass.get(0).getInsuranceDate() != "") {
			s = s + "@p_insuranceDate='" + DateFormatter.getStringDate(gatepass.get(0).getInsuranceDate()) + "',";
		}
		
		if (gatepass.get(0).getPolutionDate() != null && gatepass.get(0).getPolutionDate() != "") {
			s = s + "@p_polutionDate='" + DateFormatter.getStringDate(gatepass.get(0).getPolutionDate()) + "',";
		}
		if (gatepass.get(0).getFitnessDate() != null && gatepass.get(0).getFitnessDate() != "") {
			s = s + "@p_fitnessDate='" + DateFormatter.getStringDate(gatepass.get(0).getFitnessDate()) + "',";
		}
		if (gatepass.get(0).getDlDate() != null && gatepass.get(0).getDlDate() != "") {
			s = s + "@p_dlDate='" + DateFormatter.getStringDate(gatepass.get(0).getDlDate()) + "',";
		}
		if (gatepass.get(0).getCreatedBy() != null && gatepass.get(0).getCreatedBy() != "") {
			s = s + "@p_createdby='" + gatepass.get(0).getCreatedBy() + "',";
		}
		if (gatepass.get(0).getOrganizationName() != null && gatepass.get(0).getOrganizationName() != "") {
			s = s + "@p_orgName='" + gatepass.get(0).getOrganizationName() + "',";
		}
		if (gatepass.get(0).getOrganizationDivision() != null && gatepass.get(0).getOrganizationDivision() != "") {
			s = s + "@p_orgDiv='" + gatepass.get(0).getOrganizationDivision() + "',";
		}
		if (gatepass.get(0).getItemId() != null && gatepass.get(0).getItemId() != "") {
			s = s + "@p_itemId='" + gatepass.get(0).getItemId() + "',";
		}
		if (gatepass.get(0).getVisitingName() != null && gatepass.get(0).getVisitingName() != "") {
			s = s + "@p_visitingName='" + gatepass.get(0).getVisitingName() + "',";
		}
		if (gatepass.get(0).getVisitingAddress() != null && gatepass.get(0).getVisitingAddress() != "") {
			s = s + "@p_visitingAddress='" + gatepass.get(0).getVisitingAddress() + "',";
		}
		if (gatepass.get(0).getVisitingPurpose() != null && gatepass.get(0).getVisitingPurpose() != "") {
			s = s + "@p_visitingPurpose='" + gatepass.get(0).getVisitingPurpose() + "',";
		}
		if (gatepass.get(0).getVisitingTomeet() != null && gatepass.get(0).getVisitingTomeet() != "") {
			s = s + "@p_visitingTomeet='" + gatepass.get(0).getVisitingTomeet() + "',";
		}
		if (gatepass.get(0).getVisitingPassno() != null && gatepass.get(0).getVisitingPassno() != "") {
			s = s + "@p_visitingPassno='" + gatepass.get(0).getVisitingPassno() + "',";
		}
		if (gatepass.get(0).getVisitingMobile() != null && gatepass.get(0).getVisitingMobile() != "") {
			s = s + "@p_visitorMobile='" + gatepass.get(0).getVisitingMobile() + "',";
		}
		if (gatepass.get(0).getImage() != null && gatepass.get(0).getImage() != "") {
			s = s + "@p_image='" + gatepass.get(0).getImage() + "',";
		}
		if (gatepass.get(0).getInvoiceType() != null && gatepass.get(0).getInvoiceType() != "") {
			s = s + "@p_invoiceType='" + gatepass.get(0).getInvoiceType() + "',";
		}
		if (gatepass.get(0).getItemId() != null && gatepass.get(0).getItemId() != "") {
			for (RestGatePassDetailsModel m : gatepass) {
				Double pending = 0.00;
				if (m.getPendingQuantity() != null) {
					pending = m.getPendingQuantity();
				}
				System.out.println("pending " + pending);
				Double receiving = 0.00;
				if (m.getReceivingQuantity() != null) {

					receiving = m.getReceivingQuantity();

				}
				Double received = 0.00;
				if (m.getReceivedQuantity() != null) {
					received = m.getReceivedQuantity();
				}
				String cDate = "";
				if (m.getChallanDate() != null) {
					cDate = DateFormatter.getStringDate(m.getChallanDate());
				}
				System.out.println("cDate " + cDate);
				
				System.out.println("Noooo " + m.getChallanNo());
				listdata1 = listdata1 + "(@p_exitid,@p_poId,\"" + m.getItemId() + "\",\"" +
				  m.getItemName() + "\",\"" + m.getHsnCode() + "\"," + m.getQuantity() + "," +
				  m.getLineTotal() + ",\"" + m.getSku() + "\",\"" + m.getUnit() + "\"," +
				  pending + "," + receiving + "," +received+ ", \"" +cDate +"\", \"" + m.getChallanNo() +"\",\"" + m.getDescItem() +
				  "\"),";
		
				 
			}
			listdata1 = listdata1.substring(0, listdata1.length() - 1);
			s = s + "@p_litemSubQuery='" + listdata1 + "',";
		} else {
			s = s + "@p_litemSubQuery='',";
		}
		if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
		}
		
		System.out.println("Item Details"+s);
		return s;
	}

}
