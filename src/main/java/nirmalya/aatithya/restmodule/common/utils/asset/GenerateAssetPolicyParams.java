package nirmalya.aatithya.restmodule.common.utils.asset;

import java.util.List;

import nirmalya.aatithya.restmodule.asset.model.AssetPoilcyRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;


public class GenerateAssetPolicyParams {
	public static String getAddAssetPolicy(List<AssetPoilcyRestModel> av) {
		String s = "";
		String sitem = "";

		if (av.get(0).getPolicyid() != null || av.get(0).getPolicyid() != "") {
			s = s + "@p_policyid='" + av.get(0).getPolicyid() + "',";
		}
		if (av.get(0).getCatid() != null || av.get(0).getCatid() != "") {
			s = s + "@p_catid='" + av.get(0).getCatid() + "',";
		}
		if (av.get(0).getAssetsubcat() != null || av.get(0).getAssetsubcat() != "") {
			s = s + "@p_assetsubcat='" + av.get(0).getAssetsubcat() + "',";
		}
		if (av.get(0).getFrequency() != null || av.get(0).getFrequency() != "") {
			s = s + "@p_frequency='" + av.get(0).getFrequency() + "',";
		}
		if (av.get(0).getAssigndate() != null || av.get(0).getAssigndate() != "") {
			s = s + "@p_assigndate='" + av.get(0).getAssigndate() + "',";
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
		if (av.get(0).getPolicyName().replace("'", "\\'") != null || av.get(0).getPolicyName().replace("'", "\\'") != "") {
			s = s + "@p_PolicyName='" + av.get(0).getPolicyName().replace("'", "\\'") + "',";
		}
//
//		if (av.get(0).getOccRate() != null || av.get(0).getOccRate() != "") {
//			s = s + "@p_occRate='" + av.get(0).getOccRate() + "',";
//		}else if(av.get(0).getOccRate() == null || av.get(0).getOccRate().isEmpty()){
//			s = s + "@p_occRate='1',";
//		}else {
//			s = s + "@p_occRate='',";
//		}
		String occRate = av.get(0).getOccRate();
		s = s + "@p_occRate='" + (occRate == null || occRate.isEmpty() ? "1" : occRate) + "',";
		if (av.get(0).getOccSdate() != null || av.get(0).getOccSdate() != "") {
			s = s + "@p_occSdate='" + av.get(0).getOccSdate() + "',";
		}
		if (av.get(0).getOccEdate() != null || av.get(0).getOccEdate() != "") {
			s = s + "@p_occEdate='" + av.get(0).getOccEdate() + "',";
		}
		if (av.get(0).getType() != null || av.get(0).getType() != "") {
			s = s + "@p_type='" + av.get(0).getType() + "',";
		}

		for (AssetPoilcyRestModel m : av.get(0).getPolicyList()) {
			sitem = sitem + "(@p_policyid,\"" + m.getPolicyName() + "\",\"" + m.getPriority() + "\",\"" + m.getDescription() +
					"\",\"" + m.getTaskType() + "\",\"" + m.getTaskUOM() + "\",\"" + m.getMinRange() + "\",\"" + m.getMaxRange() +
					"\",@p_org,@p_orgDiv,\""+m.getChildType()+"\"),";
		}
		sitem = sitem.substring(0, sitem.length() - 1);

		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println("-----------------------"+s);
		}
		return s;
	}
	
	
	public static String getAddAssetGrouping(List<AssetPoilcyRestModel> av) {
		String s = "";
		String sitem = "";

		if (av.get(0).getGroupid() != null || av.get(0).getGroupid() != "") {
			s = s + "@p_groupid='" + av.get(0).getGroupid() + "',";
		}
		if (av.get(0).getCatid() != null || av.get(0).getCatid() != "") {
			s = s + "@p_catid='" + av.get(0).getCatid() + "',";
		}
		if (av.get(0).getAssetsubcat() != null || av.get(0).getAssetsubcat() != "") {
			s = s + "@p_assetsubcat='" + av.get(0).getAssetsubcat() + "',";
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
		if (av.get(0).getGroupName().replace("'", "\\'") != null || av.get(0).getGroupName().replace("'", "\\'") != "") {
			s = s + "@p_groupName='" + av.get(0).getGroupName().replace("'", "\\'") + "',";
		}
		if (av.get(0).getAssetList() != null || av.get(0).getAssetList() != "") {
			s = s + "@p_assetList='" + av.get(0).getAssetList() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
//
	public static String getAddPropertyGrouping(List<AssetPoilcyRestModel> av) {
		String s = "";
		String sitem = "";

		if (av.get(0).getGroupid() != null || av.get(0).getGroupid() != "") {
			s = s + "@p_groupid='" + av.get(0).getGroupid() + "',";
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
		if (av.get(0).getGroupName().replace("'", "\\'") != null || av.get(0).getGroupName().replace("'", "\\'") != "") {
			s = s + "@p_groupName='" + av.get(0).getGroupName().replace("'", "\\'") + "',";
		}
		if (av.get(0).getAssetList() != null || av.get(0).getAssetList() != "") {
			s = s + "@p_assetList='" + av.get(0).getAssetList() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
//
	public static String getAddLogBook(List<AssetPoilcyRestModel> av) {
		String s = "";

		if (av.get(0).getLogbookId() != null || av.get(0).getLogbookId() != "") {
			s = s + "@p_logbookId='" + av.get(0).getLogbookId() + "',";
		}
		if (av.get(0).getDate() != null || av.get(0).getDate() != "") {
			s = s + "@p_date='" + av.get(0).getDate() + "',";
		}
		if (av.get(0).getShift() != null || av.get(0).getShift() != "") {
			s = s + "@p_shift='" + av.get(0).getShift() + "',";
		}
		
		if (av.get(0).getDghour1().replace("'", "\\'") != null || av.get(0).getDghour1().replace("'", "\\'") != "") {
			s = s + "@p_dgHour1='" + av.get(0).getDghour1().replace("'", "\\'") + "',";
		}
		if (av.get(0).getMtReading1().replace("'", "\\'") != null || av.get(0).getMtReading1().replace("'", "\\'") != "") {
			s = s + "@p_mtReading1='" + av.get(0).getMtReading1().replace("'", "\\'") + "',";
		}
		if (av.get(0).getDghour2().replace("'", "\\'") != null || av.get(0).getDghour2().replace("'", "\\'") != "") {
			s = s + "@p_dgHour2='" + av.get(0).getDghour2().replace("'", "\\'") + "',";
		}
		if (av.get(0).getMtReading2().replace("'", "\\'") != null || av.get(0).getMtReading2().replace("'", "\\'") != "") {
			s = s + "@p_mtReading2='" + av.get(0).getMtReading2().replace("'", "\\'") + "',";
		}
		if (av.get(0).getStock() != null || av.get(0).getStock() != "") {
			s = s + "@p_stock='" + av.get(0).getStock() + "',";
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
		if (av.get(0).getRemark().replace("'", "\\'") != null || av.get(0).getRemark().replace("'", "\\'") != "") {
			s = s + "@p_remark='" + av.get(0).getRemark().replace("'", "\\'") + "',";
		}
		if (av.get(0).getFromtime().replace("'", "\\'") != null || av.get(0).getFromtime().replace("'", "\\'") != "") {
			s = s + "@p_fromTime='" + av.get(0).getFromtime().replace("'", "\\'") + "',";
		}
		if (av.get(0).getTotime().replace("'", "\\'") != null || av.get(0).getTotime().replace("'", "\\'") != "") {
			s = s + "@p_toTime='" + av.get(0).getTotime().replace("'", "\\'") + "',";
		}
		
		if (av.get(0).getUploadBy() != null || av.get(0).getUploadBy() != "") {
			s = s + "@p_uploadBy='" + av.get(0).getUploadBy() + "',";
		}
	
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println("----------@@@@@-----------"+s);
		}
		return s;
	}
	
	public static String addRWandBRLogBook(List<AssetPoilcyRestModel> av) {
		String s = "";

		if (av.get(0).getLogbookId() != null || av.get(0).getLogbookId() != "") {
			s = s + "@p_logbookId='" + av.get(0).getLogbookId() + "',";
		}
		if (av.get(0).getDate() != null || av.get(0).getDate() != "") {
			s = s + "@p_date='" + av.get(0).getDate() + "',";
		}
		if (av.get(0).getSaltconsumption() != null || av.get(0).getSaltconsumption() != "") {
			s = s + "@p_saltconsumption='" + av.get(0).getSaltconsumption() + "',";
		}
		if (av.get(0).getFromtime() != null || av.get(0).getFromtime().replace("'", "\\'") != "") {
			s = s + "@p_fromTime='" + av.get(0).getFromtime().replace("'", "\\'") + "',";
		}
		if (av.get(0).getTotime() != null || av.get(0).getTotime() != "") {
			s = s + "@p_toTime='" + av.get(0).getTotime() + "',";
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
		if (av.get(0).getUploadBy() != null || av.get(0).getUploadBy() != "") {
			s = s + "@p_uploadBy='" + av.get(0).getUploadBy() + "',";
		}
	
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println("----------@@@@@-----------"+s);
		}
		return s;
	}
	
	public static String addWRRLogBook(List<AssetPoilcyRestModel> av) {
		String s = "";

		if (av.get(0).getLogbookId() != null || av.get(0).getLogbookId() != "") {
			s = s + "@p_logbookId='" + av.get(0).getLogbookId() + "',";
		}
		if (av.get(0).getDate() != null || av.get(0).getDate() != "") {
			s = s + "@p_date='" + av.get(0).getDate() + "',";
		}
		if (av.get(0).getWaterreading() != null || av.get(0).getWaterreading() != "") {
			s = s + "@p_waterreading='" + av.get(0).getWaterreading() + "',";
		}
		if (av.get(0).getFromtime() != null || av.get(0).getFromtime() != "") {
			s = s + "@p_fromTime='" + av.get(0).getFromtime() + "',";
		}
		if (av.get(0).getShift() != null || av.get(0).getShift() != "") {
			s = s + "@p_shift='" + av.get(0).getShift() + "',";
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
		if (av.get(0).getUploadBy() != null || av.get(0).getUploadBy() != "") {
			s = s + "@p_uploadBy='" + av.get(0).getUploadBy() + "',";
		}
	
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println("----------@@@addWRRLogBook@@@-----------"+s);
		}
		return s;
	}
	
	
	
	public static String addEBReading(List<AssetPoilcyRestModel> av) {
		String s = "";

		if (av.get(0).getLogbookId() != null || av.get(0).getLogbookId() != "") {
			s = s + "@p_logbookId='" + av.get(0).getLogbookId() + "',";
		}
		if (av.get(0).getDate() != null || av.get(0).getDate() != "") {
			s = s + "@p_date='" + av.get(0).getDate() + "',";
		}
		if (av.get(0).getKwh() != null || av.get(0).getKwh() != "") {
			s = s + "@p_kwh='" + av.get(0).getKwh() + "',";
		}
		if (av.get(0).getKvah() != null || av.get(0).getKvah() != "") {
			s = s + "@p_kvah='" + av.get(0).getKvah() + "',";
		}
		if (av.get(0).getShift() != null || av.get(0).getShift() != "") {
			s = s + "@p_shift='" + av.get(0).getShift() + "',";
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
		if (av.get(0).getUploadBy() != null || av.get(0).getUploadBy() != "") {
			s = s + "@p_uploadBy='" + av.get(0).getUploadBy() + "',";
		}
	
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println("----------@@@addWRRLogBook@@@-----------"+s);
		}
		return s;
	}

	public static String addAssetPolicyData(AssetPoilcyRestModel av) {
		String s = "";

		if (av.getPolicyid() != null || av.getPolicyid() != "") {
			s = s + "@p_policyid='" + av.getPolicyid() + "',";
		}
		if (av.getCatid() != null || av.getCatid() != "") {
			s = s + "@p_catid='" + av.getCatid() + "',";
		}
		if (av.getAssetsubcat() != null || av.getAssetsubcat() != "") {
			s = s + "@p_assetsubcat='" + av.getAssetsubcat() + "',";
		}
		if (av.getFrequency() != null || av.getFrequency() != "") {
			s = s + "@p_frequency='" + av.getFrequency() + "',";
		}
		if (av.getAssigndate() != null || av.getAssigndate() != "") {
			s = s + "@p_assigndate='" + av.getAssigndate() + "',";
		}
		if (av.getCreatedBy() != null || av.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + av.getCreatedBy() + "',";
		}

		if (av.getOrganization() != null || av.getOrganization() != "") {
			s = s + "@p_org='" + av.getOrganization() + "',";
		}
		if (av.getOrgDivision() != null || av.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + av.getOrgDivision() + "',";
		}
		if (av.getPolicyName().replace("'", "\\'") != null || av.getPolicyName().replace("'", "\\'") != "") {
			s = s + "@p_PolicyName='" + av.getPolicyName().replace("'", "\\'") + "',";
		}
		String occRate = av.getOccRate();
		s = s + "@p_occRate='" + (occRate == null || occRate.isEmpty() ? "1" : occRate) + "',";
		if (av.getOccSdate() != null || av.getOccSdate() != "") {
			s = s + "@p_occSdate='" + av.getOccSdate() + "',";
		}
		if (av.getOccEdate() != null || av.getOccEdate() != "") {
			s = s + "@p_occEdate='" + av.getOccEdate() + "',";
		}
		if (av.getType() != null || av.getType() != "") {
			s = s + "@p_type='" + av.getType() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.err.println("-----------------------"+s);
		}
		return s;
	}


	public static String addPolicyCheckListData(AssetPoilcyRestModel av) {

			String s = "";

			if (av.getPolicyid() != null || av.getPolicyid() != "") {
				s = s + "@p_policyid='" + av.getPolicyid() + "',";
			}
			if (av.getTaskId() != null || av.getTaskId() != "") {
				s = s + "@p_taskid='" + av.getTaskId() + "',";
			}
			if (av.getPolicyName().replace("'", "\\'") != null || av.getPolicyName().replace("'", "\\'") != "") {
				s = s + "@p_PolicyName='" + av.getPolicyName().replace("'", "\\'") + "',";
			}
			if (av.getPriority() != null || av.getPriority() != "") {
				s = s + "@p_priority='" + av.getPriority() + "',";
			}
			if (av.getDescription() != null || av.getDescription() != "") {
				s = s + "@p_desc='" + av.getDescription() + "',";
			}
			if (av.getTaskType() != null || av.getTaskType() != "") {
				s = s + "@p_taskType='" + av.getTaskType() + "',";
			}
			if (av.getTaskUOM() != null || av.getTaskUOM() != "") {
				s = s + "@p_taskUOM='" + av.getTaskUOM() + "',";
			}else {
				s = s + "@p_taskUOM='',";
			}
			if (av.getMinRange() != null || av.getMinRange() != "") {
				s = s + "@p_minRange='" + av.getMinRange() + "',";
			}else {
				s = s + "@p_minRange='',";
			}
			if (av.getMaxRange() != null || av.getMaxRange() != "") {
				s = s + "@p_maxRange='" + av.getMaxRange() + "',";
			}else {
				s = s + "@p_maxRange='',";
			}
			if (av.getChildType() != null || av.getChildType() != "") {
				s = s + "@p_childType='" + av.getChildType() + "',";
			}
			if (av.getCreatedBy() != null || av.getCreatedBy() != "") {
				s = s + "@p_createdBy='" + av.getCreatedBy() + "',";
			}
			if (av.getOrganization() != null || av.getOrganization() != "") {
				s = s + "@p_org='" + av.getOrganization() + "',";
			}
			if (av.getOrgDivision() != null || av.getOrgDivision() != "") {
				s = s + "@p_orgDiv='" + av.getOrgDivision() + "',";
			}
			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
				System.err.println("-----------------------"+s);
			}
			return s;
	}
	
}
