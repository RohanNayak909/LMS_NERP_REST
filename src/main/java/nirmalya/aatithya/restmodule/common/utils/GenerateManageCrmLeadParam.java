package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;

public class GenerateManageCrmLeadParam {

	public static String addCRMProduct(List<RestCrmLeadsModel> leadTask) {

		// Added By Pankaj
		String s = "";
		String data = "";
		String setDate = "";

		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();

		HashSet<String> productId = new HashSet<>();
		HashSet<String> leadId = new HashSet<>();
		HashSet<String> contactId = new HashSet<>();
		HashSet<String> createdBy = new HashSet<>();
		HashSet<String> createdDate = new HashSet<>();
		HashSet<String> organization = new HashSet<>();
		HashSet<String> orgDivision = new HashSet<>();
		HashSet<String> currentDate = new HashSet<>();

		for (RestCrmLeadsModel m : leadTask) {
			data = data + "(\"" + m.getProductId() + "\",\"" + m.getLeadId() + "\",\"" + m.getContactId() + "\",\""
					+ m.getCreatedBy() + "\",\"" + DateFormatter.getStringDate(m.getCreatedDate()) + "\",\""
					+ m.getOrganization() + "\",\"" + m.getOrgDivision() + "\",\"" + dateString + "\"),";
			productId.add(m.getProductId());
			leadId.add(m.getLeadId());
			contactId.add(m.getContactId());
			createdBy.add(m.getCreatedBy());
			createdDate.add(DateFormatter.getStringDate(m.getCreatedDate()));
			organization.add(m.getOrganization());
			orgDivision.add(m.getOrgDivision());
			currentDate.add(dateString);
		}

		if (hashSetToCommaSeparatedString(leadId) != null && hashSetToCommaSeparatedString(leadId) != "") {
			s = s + "@p_leadId='" + hashSetToCommaSeparatedString(leadId) + "',";
		}
		if (hashSetToCommaSeparatedString(contactId) != null && hashSetToCommaSeparatedString(contactId) != "") {
			s = s + "@p_contactId='" + hashSetToCommaSeparatedString(contactId) + "',";
		}
		if (hashSetToCommaSeparatedString(createdBy) != null && hashSetToCommaSeparatedString(createdBy) != "") {
			s = s + "@p_createdBy='" + hashSetToCommaSeparatedString(createdBy) + "',";
		}
		if (hashSetToCommaSeparatedString(organization) != null && hashSetToCommaSeparatedString(organization) != "") {
			s = s + "@p_org='" + hashSetToCommaSeparatedString(organization) + "',";
		}
		if (hashSetToCommaSeparatedString(orgDivision) != null && hashSetToCommaSeparatedString(orgDivision) != "") {
			s = s + "@p_orgDiv='" + hashSetToCommaSeparatedString(orgDivision) + "',";
		}

		setDate = setDate + "(\"" + hashSetToCommaSeparatedString(productId) + "\",\""
				+ hashSetToCommaSeparatedString(leadId) + "\",\"" + hashSetToCommaSeparatedString(contactId) + "\",\""
				+ hashSetToCommaSeparatedString(createdBy) + "\",\"" + hashSetToCommaSeparatedString(createdDate)
				+ "\",\"" + hashSetToCommaSeparatedString(organization) + "\",\""
				+ hashSetToCommaSeparatedString(orgDivision) + "\",\"" + hashSetToCommaSeparatedString(currentDate)
				+ "\",\"" + "Product Added" + "\"),";

		if (setDate != null)
			setDate = setDate.substring(0, setDate.length() - 1);
		if (data != null)
			data = data.substring(0, data.length() - 1);

		s = s + "@p_itemSubQuery='" + data + "',@p_itemProductSubQuery='" + setDate + "';";

		if (s != "") {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}

		return s;
	}

	public static String hashSetToCommaSeparatedString(HashSet<String> set) {
		StringBuilder result = new StringBuilder();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			result.append(iterator.next());
			if (iterator.hasNext()) {
				result.append(", ");
			}
		}
		return result.toString();
	}
}
