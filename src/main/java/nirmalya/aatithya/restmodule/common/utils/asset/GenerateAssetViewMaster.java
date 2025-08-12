package nirmalya.aatithya.restmodule.common.utils.asset;

import java.util.List;

import nirmalya.aatithya.restmodule.asset.model.AssetDocumentRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectPlanningSchedulingRestModel;
import nirmalya.aatithya.restmodule.training.model.ManageTrainingRestDocumentModel;

public class GenerateAssetViewMaster {
	public static String getAddasset(List<AssetViewMasterRestModel> av) {
		String s = "";
		String sitem = "";
		String sitem1 = "";
		String document = "";
		String sitem2 = "";

		if (av.get(0).getAssetId() != null || av.get(0).getAssetId() != "") {
			s = s + "@p_assetId='" + av.get(0).getAssetId() + "',";
		}

		if (av.get(0).getPdate() != null || av.get(0).getPdate() != "") {
			s = s + "@p_pdate='" + av.get(0).getPdate() + "',";
		}

		if (av.get(0).getAssetcat() != null || av.get(0).getAssetcat() != "") {
			s = s + "@p_assetcat='" + av.get(0).getAssetcat() + "',";
		}
		if (av.get(0).getAssetname() != null || av.get(0).getAssetname() != "") {
			s = s + "@p_assetname='" + av.get(0).getAssetname() + "',";
		}
		if (av.get(0).getAssetmodel() != null || av.get(0).getAssetmodel() != "") {
			s = s + "@p_assetmodel='" + av.get(0).getAssetmodel() + "',";
		}
		if (av.get(0).getAssetcode() != null || av.get(0).getAssetcode() != "") {
			s = s + "@p_assetcode='" + av.get(0).getAssetcode() + "',";
		}
		if (av.get(0).getAssetsubcat() != null || av.get(0).getAssetsubcat() != "") {
			s = s + "@p_assetsubcat='" + av.get(0).getAssetsubcat() + "',";
		}
		if (av.get(0).getAssettype() != null || av.get(0).getAssettype() != "") {
			s = s + "@p_assettype='" + av.get(0).getAssettype() + "',";
		}
		if (av.get(0).getLifespan() != null || av.get(0).getLifespan() != "") {
			s = s + "@p_lifespan='" + av.get(0).getLifespan() + "',";
		}
		if (av.get(0).getPurchaseno() != null || av.get(0).getPurchaseno() != "") {
			s = s + "@p_purchaseno='" + av.get(0).getPurchaseno() + "',";
		}
		if (av.get(0).getWstatus() != null || av.get(0).getWstatus() != "") {
			s = s + "@p_wstatus='" + av.get(0).getWstatus() + "',";
		}
		if (av.get(0).getCreatedBy() != null || av.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + av.get(0).getCreatedBy() + "',";
		}
		if (av.get(0).getAssetPrice() != null || av.get(0).getAssetPrice() != "") {
			s = s + "@p_assetPrice='" + av.get(0).getAssetPrice() + "',";
		}
		if (av.get(0).getAssetDescription() != null || av.get(0).getAssetDescription() != "") {
			s = s + "@p_assetDescription='" + av.get(0).getAssetDescription().replace("'", "\\'") + "',";
		}
		if (av.get(0).getType() != null || av.get(0).getType() != "") {
			s = s + "@p_type='" + av.get(0).getType() + "',";
		}
		if (av.get(0).getSpareterm() != null || av.get(0).getSpareterm() != "") {
			s = s + "@p_Spareterm='" + av.get(0).getSpareterm() + "',";
		} else {
			s = s + "@p_Spareterm='',";
		}
		if (av.get(0).getQtySpare() != null || av.get(0).getQtySpare() != "") {
			s = s + "@p_QtySpare='" + av.get(0).getQtySpare() + "',";
		} else {
			s = s + "@p_QtySpare='',";
		}
		if (av.get(0).getOrganization() != null || av.get(0).getOrganization() != "") {
			s = s + "@p_org='" + av.get(0).getOrganization() + "',";
		}
		if (av.get(0).getOrgDivision() != null || av.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + av.get(0).getOrgDivision() + "',";
		}
		if (av.get(0).getOwntype() != null || av.get(0).getOwntype() != "") {
			s = s + "@p_Owntype='" + av.get(0).getOwntype() + "',";
		}
		if (av.get(0).getRoomId() != null || av.get(0).getRoomId() != "") {
			s = s + "@p_RoomId='" + av.get(0).getRoomId() + "',";
		}
		if (av.get(0).getCapacity() != null || av.get(0).getCapacity() != "") {
			s = s + "@p_capacity='" + av.get(0).getCapacity() + "',";
		}
		if (av.get(0).getUnit() != null || av.get(0).getUnit() != "") {
			s = s + "@p_unit='" + av.get(0).getUnit() + "',";
		}

		if (av.get(0).getWarrantyList() != null) {
			for (AssetViewMasterRestModel m : av.get(0).getWarrantyList()) {
				sitem = sitem + "(@p_assetId,\"" + m.getWarrantyid() + "\",\"" + m.getSdate() + "\",\"" + m.getEdate()
						+ "\",\"" + m.getServiceprovider() + "\",\"" + m.getRemark() + "\",\"" + m.getDocumentURL()
						+ "\",\"" + m.getFileName() + "\",@p_org,@p_orgDiv),";
			}
		}
		if (av.get(0).getInsuranceList() != null) {
			for (AssetViewMasterRestModel m : av.get(0).getInsuranceList()) {
				sitem1 = sitem1 + "(@p_assetId,\"" + m.getInsuranceno() + "\",\"" + m.getInsurancename() + "\",\""
						+ m.getIsdate() + "\",\"" + m.getIedate() + "\",\"" + m.getDocumentURL() + "\",\""
						+ m.getFileName() + "\",@p_org,@p_orgDiv),";
			}
		}
		if (av.get(0).getDocumentList() != null) {
			for (AssetDocumentRestModel a : av.get(0).getDocumentList()) {
				document = document + "(@p_assetId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() + "\",\""
						+ a.getDocumentURL() + "\",\"" + a.getDocumnentNotes() + "\",@p_createdBy,@p_org,@p_orgDiv),";
			}
		}
		if (av.get(0).getComplianceList() != null) {
			for (AssetViewMasterRestModel m : av.get(0).getComplianceList()) {
				sitem2 = sitem2 + "(@p_assetId,\"" + m.getSdate() + "\",\"" + m.getRdate() + "\",\"" + m.getDocName()
						+ "\",\"" + m.getDocumentURL() + "\",\"" + m.getFileName()
						+ "\",@p_org,@p_orgDiv,\"Compliance\"),";
			}
		}
		if (sitem.length() != 0) {
			sitem = sitem.substring(0, sitem.length() - 1);
		}
		if (sitem1.length() != 0) {
			sitem1 = sitem1.substring(0, sitem1.length() - 1);
		}
		if (document.length() != 0) {
			document = document.substring(0, document.length() - 1);
		}
		if (sitem2.length() != 0) {
			sitem2 = sitem2.substring(0, sitem2.length() - 1);
		}

		s = s + "@p_itemSubQuery='" + sitem + "'," + "@p_itemSubQuery1='" + sitem1 + "'," + "@p_itemSubQuery2='"
				+ document + "'," + "@p_itemSubQuery3='" + sitem2 + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("VALUES::::" + s);
		return s;
	}

	public static String verifyParams(List<AssetViewMasterRestModel> av) {
		String s = "";

		if (av.get(0).getAssetId() != null || av.get(0).getAssetId() != "") {
			s = s + "@p_assetId='" + av.get(0).getAssetId() + "',";
		}
		if (av.get(0).getLocationSts() != null || av.get(0).getLocationSts() != "") {
			s = s + "@p_locationSts='" + av.get(0).getLocationSts() + "',";
		}
		if (av.get(0).getExistSts() != null || av.get(0).getExistSts() != "") {
			s = s + "@p_existSts='" + av.get(0).getExistSts() + "',";
		}
		if (av.get(0).getAllocationId() != null || av.get(0).getAllocationId() != "") {
			s = s + "@p_allocationId='" + av.get(0).getAllocationId() + "',";
		}
		if (av.get(0).getActiveId() != null || av.get(0).getActiveId() != "") {
			s = s + "@p_activeId='" + av.get(0).getActiveId() + "',";
		}
		if (av.get(0).getWstatus() != null || av.get(0).getWstatus() != "") {
			s = s + "@p_wstatus='" + av.get(0).getWstatus() + "',";
		}
		if (av.get(0).getRemark() != null || av.get(0).getRemark() != "") {
			s = s + "@p_remark='" + av.get(0).getRemark() + "',";
		}
		if (av.get(0).getAssetSts() != null || av.get(0).getAssetSts() != "") {
			s = s + "@p_assetSts='" + av.get(0).getAssetSts() + "',";
		}
		if (av.get(0).getCreatedBy() != null || av.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + av.get(0).getCreatedBy() + "',";
		}
		if (av.get(0).getOrganization() != null || av.get(0).getOrganization() != "") {
			s = s + "@p_org='" + av.get(0).getOrganization() + "',";
		}
		if (av.get(0).getOrgDivision() != null || av.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + av.get(0).getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("VALUES VERIFY::::" + s);
		return s;
	}

	public static String getAddAssetDetails(AssetViewMasterRestModel av) {
		String s = "";
		String warentyData = "";
		String insuranceData = "";
		String documentData = "";

		if (av.getAssetId() != null || av.getAssetId() != "") {
			s = s + "@p_assetId='" + av.getAssetId() + "',";
		}
		if (av.getOrganization() != null || av.getOrganization() != "") {
			s = s + "@p_org='" + av.getOrganization() + "',";
		}
		if (av.getOrgDivision() != null || av.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + av.getOrgDivision() + "',";
		}

		if (av.getWarId() != null || av.getWarId() != "") {
			s = s + "@p_assignedData='" + av.getWarId() + "',";
		}

		if (av.getSlNoId() != null || av.getSlNoId() != "") {
			s = s + "@p_assignedData1='" + av.getSlNoId() + "',";
		}
		if ("Warenty".equals(av.getCategory())) {
			warentyData = warentyData + "(@p_assignedData,@p_assetId,\"" + av.getWarrantyid() + "\",\"" + av.getSdate()
					+ "\",\"" + av.getEdate() + "\",\"" + av.getServiceprovider() + "\",\""
					+ av.getRemark().replace("'", "\\'") + "\",\"" + av.getDocumentURL() + "\",\"" + av.getFileName()
					+ "\",@p_org,@p_orgDiv),";
		}
		if ("Insurance".equals(av.getCategory())) {
			insuranceData = insuranceData + "(@p_assetId,\"" + av.getInsuranceno() + "\",\"" + av.getInsurancename()
					+ "\",\"" + av.getIsdate() + "\",\"" + av.getIedate() + "\",\"" + av.getDocumentURL() + "\",\""
					+ av.getFileName() + "\",@p_org,@p_orgDiv),";
		}
		if ("Compliance".equals(av.getCategory())) {
			documentData = documentData + "(@p_assignedData,@p_assetId,\"" + av.getSdate() + "\",\"" + av.getRdate()
					+ "\",\"" + av.getDocName() + "\",\"" + av.getDocumentURL() + "\",\"" + av.getFileName()
					+ "\",@p_org,@p_orgDiv,\"Compliance\"),";
		}
		if (warentyData.length() != 0) {
			warentyData = warentyData.substring(0, warentyData.length() - 1);
		}
		if (insuranceData.length() != 0) {
			insuranceData = insuranceData.substring(0, insuranceData.length() - 1);
		}
		if (documentData.length() != 0) {
			documentData = documentData.substring(0, documentData.length() - 1);
		}

		s = s + "@p_warrentList='" + warentyData + "'," + "@p_insList='" + insuranceData + "'," + "@p_compList='"
				+ documentData + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String getAddassetPolicy(List<AssetViewMasterRestModel> av) {
		String s = "";
		String itemparam = "";
		List<AssetViewMasterRestModel> items = av.get(0).getPolicyDataList();

		if (av.get(0).getAllocationId() == null || av.get(0).getAllocationId() == "") {
			s = s + "@p_allocationId='" + av.get(0).getAllocationId() + "',";
		}

		if (av.get(0).getType() == null || av.get(0).getType() == "") {
			s = s + "@p_type='" + av.get(0).getType() + "',";
		}

		if (av.get(0).getPolicyDataList().size() > 0) {
			for (AssetViewMasterRestModel m : items) {

				itemparam = itemparam + "(@p_allocationId,\"" + av.get(0).getAssetcat() + "\",\""
						+ av.get(0).getAssetsubcat() + "\",\"" + av.get(0).getAssetGrp() + "\",\"" + av.get(0).getType()
						+ "\",\"" + av.get(0).getAssetId() + "\",\""
						+ m.getPolicyId() + "\",\"" + av.get(0).getCreatedBy() + "\",\"" + av.get(0).getOrganization()
						+ "\",\"" + av.get(0).getOrgDivision() + "\"),";

			}

			itemparam = itemparam.substring(0, itemparam.length() - 1);
		} else {
			itemparam = "";
		}
		s = s + "@p_itemParam='" + itemparam + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}

}
