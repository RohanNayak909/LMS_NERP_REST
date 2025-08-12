package nirmalya.aatithya.restmodule.common.utils.grc;
import java.util.ArrayList;
import java.util.List;

import nirmalya.aatithya.restmodule.grc.model.SafetyIdentificationRestModel;
public class GenerateSafetyIdentificationParam {
	public static String getAddQuotParam(List<SafetyIdentificationRestModel> model) {

		String s = "";
		String vendorParam = "";

		for (SafetyIdentificationRestModel a : model) {

			vendorParam = vendorParam + "(gen_safety_id(),\"" + a.getCategoryId() + "\",\"" + 
			a.getCategoryCode() +  "\",\"" + a.getProjectId() + "\",\"" + a.getCreatedBy() + 
			"\",\"" + a.getOrganizationName() +  "\",\"" + a.getOrganizationDivision() + "\"),";

		}
		vendorParam = vendorParam.substring(0, vendorParam.length() - 1);


		s = s + "@p_vendorParamSubQuery='" + vendorParam + "',";
	

		if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
		}
		
		return s;
	}
}
