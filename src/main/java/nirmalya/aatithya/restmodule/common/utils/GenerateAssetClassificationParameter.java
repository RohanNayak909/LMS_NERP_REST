package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestAssetModel;

public class GenerateAssetClassificationParameter {
	public static String saveAssetClassification(RestAssetModel classification) {

		String s = "";

		if (classification.getAssetId() != null && classification.getAssetId() != "") {
			s = s + "@p_assetId='" + classification.getAssetId() + "',";
		}
		if (classification.getAssetName() != null && classification.getAssetName() != "") {
			s = s + "@p_assetName='" + classification.getAssetName() + "',";
		}
		if (classification.getAssetDesc() != null && classification.getAssetDesc() != "") {
			s = s + "@p_assetDesc='" + classification.getAssetDesc() + "',";
		}
		if (classification.getParentId() != null && classification.getParentId() != "") {
			s = s + "@p_parentId='" + classification.getParentId() + "',";
		}
		if (classification.getCreatedBy() != null && classification.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + classification.getCreatedBy() + "',";
		}
		if (classification.getAssetStatus() != null && classification.getAssetStatus() != "") {
			s = s + "@p_isActive='" + classification.getAssetStatus() + "',";
		} else {
			s = s + "@p_isActive='" + 0 + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
}