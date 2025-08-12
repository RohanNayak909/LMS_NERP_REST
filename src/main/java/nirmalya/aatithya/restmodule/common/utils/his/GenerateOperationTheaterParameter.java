package nirmalya.aatithya.restmodule.common.utils.his;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nirmalya.aatithya.restmodule.his.model.RestHISOperationThearterModel;

public class GenerateOperationTheaterParameter {
	

	public static String addOperationTheaterParam(RestHISOperationThearterModel operationThearterModel) {
		Logger logger = LoggerFactory.getLogger(GenerateOperationTheaterParameter.class);
		String s = "";

		if (operationThearterModel.getOtId() != null || operationThearterModel.getOtId() != "") {
			s = s + "@p_otId='" + operationThearterModel.getOtId() + "',";
		}

		if (operationThearterModel.getOtName() != null || operationThearterModel.getOtName() != "") {
			s = s + "@p_otName='" + operationThearterModel.getOtName() + "',";
		}

		if (operationThearterModel.getFloor() != null || operationThearterModel.getFloor() != "") {
			s = s + "@p_floor='" + operationThearterModel.getFloor() + "',";
		}

		if (operationThearterModel.getDescription() != null || operationThearterModel.getDescription() != "") {
			s = s + "@p_description='" + operationThearterModel.getDescription() + "',";
		}
		if (operationThearterModel.getOtStatus() != null || operationThearterModel.getOtStatus() != "") {
			s = s + "@p_status='" + operationThearterModel.getOtStatus() + "',";
		}

		if (operationThearterModel.getCreatedBy() != null && operationThearterModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + operationThearterModel.getCreatedBy() + "',";
		}

		if (operationThearterModel.getOrganization() != null && operationThearterModel.getOrganization() != "") {
			s = s + "@p_org='" + operationThearterModel.getOrganization() + "',";
		}
		if (operationThearterModel.getOrgDivision() != null && operationThearterModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + operationThearterModel.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		logger.info("inParameter-------------" + s);
		return s;

	}

}
