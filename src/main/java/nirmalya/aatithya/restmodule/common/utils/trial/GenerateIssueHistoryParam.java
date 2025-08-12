package nirmalya.aatithya.restmodule.common.utils.trial;
import nirmalya.aatithya.restmodule.trial.model.IssueHistoryRestModel;

public class GenerateIssueHistoryParam {
	
	public static String addvehicleparam(IssueHistoryRestModel issueHistoryRestModel) {

		String s = ""; 
		
		if (issueHistoryRestModel.getIssuergnumber() != null || issueHistoryRestModel.getIssuergnumber() != "") {
			s = s + "@p_issuergnumber='" + issueHistoryRestModel.getIssuergnumber() + "',";
		}
		
		if (issueHistoryRestModel.getIssuergname() != null || issueHistoryRestModel.getIssuergname() != "") {
			s = s + "@p_issuergname='" + issueHistoryRestModel.getIssuergname() + "',";
		}
		
		if (issueHistoryRestModel.getDescription() != null || issueHistoryRestModel.getDescription() != "") {
			s = s + "@p_description='" + issueHistoryRestModel.getDescription() + "',";
		} 
		
		if (issueHistoryRestModel.getTicketname() != null || issueHistoryRestModel.getTicketname() != "") {
			s = s + "@p_ticketname='" + issueHistoryRestModel.getTicketname() + "',";
		}
		
		if (issueHistoryRestModel.getVehiclename() != null || issueHistoryRestModel.getVehiclename() != "") {
			s = s + "@p_vehiclename='" + issueHistoryRestModel.getVehiclename() + "',";
		}
				
		if (issueHistoryRestModel.getFromDate() != null || issueHistoryRestModel.getFromDate() != "") {
			s = s + "@p_fromdate='" + issueHistoryRestModel.getFromDate() + "',";
		}
		
		if (issueHistoryRestModel.getDocName() != null || issueHistoryRestModel.getDocName() != "") {
			s = s + "@p_docname='" + issueHistoryRestModel.getDocName() + "',";
		}
		
		if (issueHistoryRestModel.getPhonenumber() != null || issueHistoryRestModel.getPhonenumber() != "") {
			s = s + "@p_phonenumber='" + issueHistoryRestModel.getPhonenumber() + "',";
		}
		
		if (issueHistoryRestModel.getVendorname() != null || issueHistoryRestModel.getVendorname() != "") {
			s = s + "@p_vendorname='" + issueHistoryRestModel.getVendorname() + "',";
		}
		
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("output= " +s);
		return s;
	}
}
