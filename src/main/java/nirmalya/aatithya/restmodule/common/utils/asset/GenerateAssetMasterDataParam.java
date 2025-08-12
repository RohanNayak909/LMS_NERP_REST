package nirmalya.aatithya.restmodule.common.utils.asset;

import nirmalya.aatithya.restmodule.asset.model.AssetMasterDataRestModel;

public class GenerateAssetMasterDataParam {
	//@SuppressWarnings("null")
	public static String addAssetData(AssetMasterDataRestModel assetMaster){
		
		
	String s = "";
	
	if (assetMaster.getAssetId() != null || assetMaster.getAssetId() != "") {
		s = s + "@p_assetId='" + assetMaster.getAssetId() + "',";
	}
	if (assetMaster.getAssetName() != null || assetMaster.getAssetName() != "") {
		s = s + "@p_assetName='" + assetMaster.getAssetName() + "',";
		
	}
	if (assetMaster.getAssetInfoStatus() != null || assetMaster.getAssetInfoStatus() != "") {
		s = s + "@p_assetInfoStatus='" + assetMaster.getAssetInfoStatus() + "',";
		
	}
	
	
	if (assetMaster.getCategoryId() != null || assetMaster.getCategoryId() != "") {
		s = s + "@p_categoryId='" + assetMaster.getCategoryId() + "',";
		
	}
	if (assetMaster.getAssetCategory() != null && !assetMaster.getAssetCategory().isEmpty()) {
        s = s + "@p_assetCategory='" + assetMaster.getAssetCategory().replace("'", "''") + "',";
    }
	if (assetMaster.getAssetCatStatus() != null || assetMaster.getAssetCatStatus() != "") {
		s = s + "@p_assetCatStatus='" + assetMaster.getAssetCatStatus() + "',";
		
	}
	if (assetMaster.getDummyId() != null || assetMaster.getDummyId() != "") {
		s = s + "@p_dummyId='" + assetMaster.getDummyId() + "',";
		
	}
	if (assetMaster.getDummyAsset() != null || assetMaster.getDummyAsset() != "") {
		s = s + "@p_dummyAsset='" + assetMaster.getDummyAsset() + "',";
		
	}
	if (assetMaster.getDummyAssetStatus() != null || assetMaster.getDummyAssetStatus() != "") {
		s = s + "@p_dummyAssetStatus='" + assetMaster.getDummyAssetStatus() + "',";
		
	}
	if (assetMaster.getOwnershipId() != null || assetMaster.getOwnershipId() != "") {
		s = s + "@p_ownershipId='" + assetMaster.getOwnershipId() + "',";
		
	}
	if (assetMaster.getOwnerName() != null || assetMaster.getOwnerName() != "") {
		s = s + "@p_ownerName='" + assetMaster.getOwnerName() + "',";
		
	}
	if (assetMaster.getOwnerAssetStatus() != null || assetMaster.getOwnerAssetStatus() != "") {
		s = s + "@p_ownerAssetStatus='" + assetMaster.getOwnerAssetStatus() + "',";
		
	}
	
	if (assetMaster.getAssetSubCatId() != null || assetMaster.getAssetSubCatId() != "") {
		s = s + "@p_assetSubCatId='" + assetMaster.getAssetSubCatId() + "',";
		
	}
	if (assetMaster.getAssetCat() != null || assetMaster.getAssetCat() != "") {
		s = s + "@p_assetCat='" + assetMaster.getAssetCat() + "',";
		
	}
	 
	if (assetMaster.getAssetsubCatName() != null && !assetMaster.getAssetsubCatName().isEmpty()) {
        s = s + "@p_assetsubCatName='" + assetMaster.getAssetsubCatName().replace("'", "''") + "',";
    }
	if (assetMaster.getAssetSubCatStatus() != null || assetMaster.getAssetSubCatStatus() != "") {
		s = s + "@p_assetSubCatStatus='" + assetMaster.getAssetSubCatStatus() + "',";
		
	}
	
	
	if (assetMaster.getAssetSpId() != null || assetMaster.getAssetSpId() != "") {
		s = s + "@p_assetSpId='" + assetMaster.getAssetSpId() + "',";
		
	}
	if (assetMaster.getAssetSpCatName() != null && !assetMaster.getAssetSpCatName().isEmpty()) {
        s = s + "@p_assetSpCatName='" + assetMaster.getAssetSpCatName().replace("'", "''") + "',";
    }
	
	if (assetMaster.getAssetSpCatStatus() != null || assetMaster.getAssetSpCatStatus() != "") {
		s = s + "@p_assetSpCatStatus='" + assetMaster.getAssetSpCatStatus() + "',";
		
	}
	if (assetMaster.getSpSubCatId() != null || assetMaster.getSpSubCatId() != "") {
		s = s + "@p_spSubCatId='" + assetMaster.getSpSubCatId() + "',";
		
	}
	if (assetMaster.getSpCatName() != null || assetMaster.getSpCatName() != "") {
		s = s + "@p_spCatName='" + assetMaster.getSpCatName() + "',";
		
	}
	if (assetMaster.getSpSubCatName() != null && !assetMaster.getSpSubCatName().isEmpty()) {
        s = s + "@p_spSubCatName='" + assetMaster.getSpSubCatName().replace("'", "''") + "',";
    }
	if (assetMaster.getSpSubCatStatus() != null || assetMaster.getSpSubCatStatus() != "") {
		s = s + "@p_spSubCatStatus='" + assetMaster.getSpSubCatStatus() + "',";
		
	}
	
	
	
	if (assetMaster.getOrgName() != null || assetMaster.getOrgName() != "") {
		s = s + "@p_orgName='" + assetMaster.getOrgName() + "',";
	}
	if (assetMaster.getOrgDiv() != null || assetMaster.getOrgDiv() != "") {
		s = s + "@p_orgDiv='" + assetMaster.getOrgDiv() + "',";
	}
	if (assetMaster.getCreatedBy() != null || assetMaster.getCreatedBy() != "") {
		s = s + "@p_createdBy='" + assetMaster.getCreatedBy() + "',";
	}
	
	if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
	}
	
	return s;
}
}
