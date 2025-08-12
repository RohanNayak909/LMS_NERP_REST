package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.TravelClaimRestModel;

public class GenerateTravelClaimOtherParameter {

	public static String getTavelClaimData(TravelClaimRestModel travelClaimRestModel) {
		
		String s = "";
		if (travelClaimRestModel.getItemId() != null && travelClaimRestModel.getItemId() != "") {
			s = s + "@p_itemId='" + travelClaimRestModel.getItemId() + "',";
		}
		if (travelClaimRestModel.getTravelingReqId() != null && travelClaimRestModel.getTravelingReqId() != "") {
			s = s + "@p_getTravelReqId='" + travelClaimRestModel.getTravelingReqId() + "',";
		}
		if (travelClaimRestModel.getItem() != null && travelClaimRestModel.getItem() != "") {
			s = s + "@p_getItem='" + travelClaimRestModel.getItem() + "',";
		}
		if (travelClaimRestModel.getDestination() != null && travelClaimRestModel.getDestination() != "") {
			s = s + "@p_getDesignation='" + travelClaimRestModel.getDestination() + "',";
		}
		if (travelClaimRestModel.getDate() != null && travelClaimRestModel.getDate() != "") {
			s = s + "@p_getDate='" + DateFormatter.getStringDate(travelClaimRestModel.getDate()) + "',";
		}
		if (travelClaimRestModel.getTdate() != null && travelClaimRestModel.getTdate() != "") {
			s = s + "@p_toDate='" + DateFormatter.getStringDate(travelClaimRestModel.getTdate()) + "',";
		}
		if (travelClaimRestModel.getAmount() != null && travelClaimRestModel.getAmount() != "") {
			s = s + "@p_getAmount='" + travelClaimRestModel.getAmount() + "',";
		}		
		if (travelClaimRestModel.getDocName() != null || travelClaimRestModel.getDocName() != "") {
			s = s + "@p_docName='" + travelClaimRestModel.getDocName() + "',";
		}
		if (travelClaimRestModel.getCreatedBy() != null && travelClaimRestModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + travelClaimRestModel.getCreatedBy() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println("Generate Param==="+s);
		}
		return s;
	}

	public static String getTavelClaimStatus(TravelClaimRestModel travelClaimRestModel) {
		String s = "";
		if (travelClaimRestModel.getClaimStatus() != null && travelClaimRestModel.getClaimStatus() != "") {
			s = s + "@p_status='" + travelClaimRestModel.getClaimStatus() + "',";
		}
		if (travelClaimRestModel.getTravelingReqId() != null && travelClaimRestModel.getTravelingReqId() != "") {
			s = s + "@p_getTravelReqId='" + travelClaimRestModel.getTravelingReqId() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println("Generate Param==="+s);
		}
		return s;
	}

}
