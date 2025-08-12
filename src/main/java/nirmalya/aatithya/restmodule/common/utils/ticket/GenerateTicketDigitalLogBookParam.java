package nirmalya.aatithya.restmodule.common.utils.ticket;

import java.util.List;

import nirmalya.aatithya.restmodule.asset.model.AssetDocumentRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.qa.model.RestEdtaSolutionModel;
import nirmalya.aatithya.restmodule.ticket.model.DigitalLogBookRestModel;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;

public class GenerateTicketDigitalLogBookParam {

	public static String getAddElcbLogBook(List<DigitalLogBookRestModel> av) {
		String s = "";

		if (av.get(0).getElcbId() != null || av.get(0).getElcbId() != "") {
			s = s + "@p_elcbId='" + av.get(0).getElcbId() + "',";
		}
		if (av.get(0).getCheckinDate() != null || av.get(0).getCheckinDate() != "") {
			s = s + "@p_checkinDate='" + DateFormatter.getStringDate(av.get(0).getCheckinDate()) + "',";
		}
		if (av.get(0).getElcbRating().replace("'", "\\'") != null || av.get(0).getElcbRating().replace("'", "\\'") != "") {
			s = s + "@p_rating='" + av.get(0).getElcbRating().replace("'", "\\'") + "',";
		}
		if (av.get(0).getTripingTime().replace("'", "\\'") != null || av.get(0).getTripingTime().replace("'", "\\'") != "") {
			s = s + "@p_tripingTime='" + av.get(0).getTripingTime().replace("'", "\\'") + "',";
		}
		if (av.get(0).getDueDate() != null || av.get(0).getDueDate() != "") {
			s = s + "@p_dueDate='" + DateFormatter.getStringDate(av.get(0).getDueDate()) + "',";
		}
		if (av.get(0).getRemark().replace("'", "\\'") != null || av.get(0).getRemark().replace("'", "\\'") != "") {
			s = s + "@p_remark='" + av.get(0).getRemark().replace("'", "\\'") + "',";
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
		if (av.get(0).getEquiType() != null || av.get(0).getEquiType() != "") {
			s = s + "@p_equiType='" + av.get(0).getEquiType() + "',";
		}
		
		if (av.get(0).getEquiName() != null || av.get(0).getEquiName() != "") {
			s = s + "@p_equiName='" + av.get(0).getEquiName() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println("----------@@@@@-----------"+s);
		}
		return s;
	}
	
// Waste oil track
	
	public static String getAddOilTrack(List<DigitalLogBookRestModel> av) {
		String s = "";

		if (av.get(0).getTrackId() != null || av.get(0).getTrackId() != "") {
			s = s + "@p_trackId='" + av.get(0).getTrackId() + "',";
		}
		if (av.get(0).getDate() != null || av.get(0).getDate() != "") {
			s = s + "@p_date='" + av.get(0).getDate() + "',";
		}
		if (av.get(0).getSource().replace("'", "\\'") != null || av.get(0).getSource().replace("'", "\\'") != "") {
			s = s + "@p_source='" + av.get(0).getSource().replace("'", "\\'") + "',";
		}
		if (av.get(0).getSpentQnt() != null || av.get(0).getSpentQnt() != "") {
			s = s + "@p_spentQnt='" + av.get(0).getSpentQnt() + "',";
		}
		if (av.get(0).getOpeningStock() != null || av.get(0).getOpeningStock() != "") {
			s = s + "@p_openingStock='" + av.get(0).getOpeningStock() + "',";
		}
		if (av.get(0).getDisposedQnt() != null || av.get(0).getDisposedQnt() != "") {
			s = s + "@p_disposedQnt='" + av.get(0).getDisposedQnt() + "',";
		}
		if (av.get(0).getClosingStock() != null || av.get(0).getClosingStock() != "") {
			s = s + "@p_closingStock='" + av.get(0).getClosingStock() + "',";
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
//
	public static String getAddCompilationActivity(List<DigitalLogBookRestModel> av) {
		String s = "";
		String sitem1 = "";
		String sitem2 = "";

		if (av.get(0).getCompletionId() != null || av.get(0).getCompletionId() != "") {
			s = s + "@p_completionId='" + av.get(0).getCompletionId() + "',";
		}
		if (av.get(0).getDept() != null || av.get(0).getDept() != "") {
			s = s + "@p_dept='" + av.get(0).getDept() + "',";
		}
		if (av.get(0).getDate() != null || av.get(0).getDate() != "") {
			s = s + "@p_date='" + av.get(0).getDate() + "',";
		}
		if (av.get(0).getNonRoutineArea().replace("'", "\\'") != null || av.get(0).getNonRoutineArea().replace("'", "\\'") != "") {
			s = s + "@p_nonRoutineArea='" + av.get(0).getNonRoutineArea().replace("'", "\\'") + "',";
		}
		if (av.get(0).getType().replace("'", "\\'") != null || av.get(0).getType().replace("'", "\\'") != "") {
			s = s + "@p_type='" + av.get(0).getType().replace("'", "\\'") + "',";
		}
		if (av.get(0).getDuration().replace("'", "\\'") != null || av.get(0).getDuration().replace("'", "\\'") != "") {
			s = s + "@p_duration='" + av.get(0).getDuration().replace("'", "\\'") + "',";
		}
		if (av.get(0).getDescription().replace("'", "\\'") != null || av.get(0).getDescription().replace("'", "\\'") != "") {
			s = s + "@p_description='" + av.get(0).getDescription().replace("'", "\\'") + "',";
		}
		if (av.get(0).getActivityArea().replace("'", "\\'") != null || av.get(0).getActivityArea().replace("'", "\\'") != "") {
			s = s + "@p_activityArea='" + av.get(0).getActivityArea().replace("'", "\\'") + "',";
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
		if (av.get(0).getTime() != null || av.get(0).getTime() != "") {
			s = s + "@p_time='" + av.get(0).getTime() + "',";
		}
		
		if (av.get(0).getUploadBy() != null || av.get(0).getUploadBy() != "") {
			s = s + "@p_uploadBy='" + av.get(0).getUploadBy() + "',";
   		}
		for (DigitalLogBookRestModel m : av.get(0).getGrid1List()) {
			
			sitem1 = sitem1 + "(@p_completionId,\""+ m.getSlNo1() +"\",\""+ m.getDesc1() +"\",\"" + m.getRemark1() +"\",@p_org,@p_orgDiv),";
			
		}
		
		sitem1 = sitem1.substring(0, sitem1.length() - 1);

		s = s + "@p_itemSubQuery1='" + sitem1 + "',";

		for (DigitalLogBookRestModel m : av.get(0).getGrid2List()) {

			sitem2 = sitem2 + "(@p_completionId,\""+ m.getSlNo2() +"\",\""+ m.getDesc2() +"\",\"" + m.getRemark2() +"\",@p_org,@p_orgDiv),";
		}
		
		sitem2 = sitem2.substring(0, sitem2.length() - 1);

		s = s + "@p_itemSubQuery2='" + sitem2 + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println("-----------------"+s);
		}
		return s;
	}
//
//	public static String getComplianceData(TicketManagementRestModel av) {
//		String s = "";
//
//		if (av.getComplianceId() != null || av.getComplianceId() != "") {
//			s = s + "@p_complianceId='" + av.getComplianceId() + "',";
//		}
//		if (av.getAssetid()!= null || av.getAssetid() != "") {
//			s = s + "@p_assetId='" + av.getAssetid() + "',";
//		}
//		if (av.getSdate() != null || av.getSdate() != "") {
//			s = s + "@p_sDate='" + av.getSdate() + "',";
//		}
//		if (av.getRdate() != null || av.getRdate() != "") {
//			s = s + "@p_rDate='" + av.getRdate() + "',";
//		}
//		if (av.getImgName() != null && av.getImgName() != "") {
//			s = s + "@p_imgName='" + av.getImgName() + "',";
//		}
//		if (av.getImgUrl() != null && av.getImgUrl() != "") {
//			s = s + "@p_imgUrl='" + av.getImgUrl() + "',";
//		}
//		if (av.getCreatedBy() != null || av.getCreatedBy() != "") {
//			s = s + "@p_createdBy='" + av.getCreatedBy() + "',";
//		}
//		if (av.getOrganization() != null || av.getOrganization() != "") {
//			s = s + "@p_org='" + av.getOrganization() + "',";
//		}
//		if (av.getOrgDivision() != null || av.getOrgDivision() != "") {
//			s = s + "@p_orgDiv='" + av.getOrgDivision() + "',";
//		}
//		
//
//		if (s != "") {
//			s = s.substring(0, s.length() - 1);
//
//			s = "SET " + s + ";";
//			System.out.println("----------@@@@@-----------"+s);
//		}
//		return s;
//	}
//

		public static String getComplianceData(List<AssetViewMasterRestModel> av) {
			String s = "";
			String sitem = "";
			

			if (av.get(0).getComplianceId() != null || av.get(0).getComplianceId() != "") {
				s = s + "@p_complianceId='" + av.get(0).getComplianceId() + "',";
			}

			if (av.get(0).getAssetid() != null || av.get(0).getAssetid() != "") {
				s = s + "@p_assetId='" + av.get(0).getAssetid() + "',";
			}

			if (av.get(0).getCreatedBy() != null || av.get(0).getCreatedBy() != "") {
				s = s + "@p_createdBy='" + av.get(0).getCreatedBy() + "',";
			}
			
			if (av.get(0).getType() != null || av.get(0).getType() != "") {
				s = s + "@p_type='" + av.get(0).getType() + "',";
			}
			
			if (av.get(0).getOrganization() != null || av.get(0).getOrganization() != "") {
				s = s + "@p_org='" + av.get(0).getOrganization() + "',";
			}
			if (av.get(0).getOrgDivision() != null || av.get(0).getOrgDivision() != "") {
				s = s + "@p_orgDiv='" + av.get(0).getOrgDivision() + "',";
			}
			if (av.get(0).getAssetSts() != null || av.get(0).getAssetSts() != "") {
				s = s + "@p_addType='" + av.get(0).getAssetSts() + "',";
			}
			
			s = s + "@p_complianceId='" +""+ "',";
			
			for (AssetViewMasterRestModel m : av.get(0).getWarrantyList()) {
				sitem = sitem + "(@p_assetId,\"" + m.getSdate() + "\",\"" + m.getRdate() + "\",\"" + m.getDocName()
				+ "\",\"" + m.getDocumentURL()+ "\",\"" + m.getFileName() + "\",@p_org,@p_orgDiv,@p_type),";
			}
			if(sitem.length()>0) {
				sitem = sitem.substring(0, sitem.length() - 1);
			}
			s = s + "@p_itemSubQuery='" + sitem + "',";

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
			System.out.println("VALUES::::"+s);
			return s;
		}
//
		public static String getAddIllumination(List<DigitalLogBookRestModel> av) {
			String s = "";
			String sitem1 = "";
		

			if (av.get(0).getIlluminationId() != null || av.get(0).getIlluminationId() != "") {
				s = s + "@p_illuminationId='" + av.get(0).getIlluminationId() + "',";
			}
			
			if (av.get(0).getDate() != null || av.get(0).getDate() != "") {
				s = s + "@p_date='" + av.get(0).getDate() + "',";
			}
			
			if (av.get(0).getYear() != null || av.get(0).getYear() != "") {
				s = s + "@p_year='" + av.get(0).getYear() + "',";
			}
			if (av.get(0).getMonth() != null || av.get(0).getMonth() != "") {
				s = s + "@p_month='" + av.get(0).getMonth() + "',";
			}
			if (av.get(0).getNdate() != null || av.get(0).getNdate() != "") {
				s = s + "@p_ndate='" + av.get(0).getNdate() + "',";
			}
			if (av.get(0).getUploadBy() != null || av.get(0).getUploadBy() != "") {
				s = s + "@p_uploadBy='" + av.get(0).getUploadBy() + "',";
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
			
			
			for (DigitalLogBookRestModel m : av.get(0).getGrid1List()) {
				
				sitem1 = sitem1 + "(@p_illuminationId,\""+ m.getSlNo1() +"\",\""+ m.getDesc1() +"\",\"" + m.getLevelinlux() +"\",\""+ m.getCorrection() +"\",\""  
						+ m.getValueaftercorrection() +"\",\"" + m.getDateofCorrection() +"\",\"" + m.getElectricianSign() +"\",\"" 
						+ m.getIcSign() +"\",\"" + m.getRemark1() +"\",@p_org,@p_orgDiv),";
				
			}
			
			sitem1 = sitem1.substring(0, sitem1.length() - 1);

			s = s + "@p_itemSubQuery1='" + sitem1 + "',";

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
				System.out.println("-----------------"+s);
			}
			return s;
		}
}
