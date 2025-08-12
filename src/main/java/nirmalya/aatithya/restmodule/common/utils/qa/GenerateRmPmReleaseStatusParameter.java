package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;

import nirmalya.aatithya.restmodule.qa.model.HorlicksAnalysisRestModel;
import nirmalya.aatithya.restmodule.qa.model.MediaDecontaminationRecordModel;
import nirmalya.aatithya.restmodule.qa.model.RestPhMeterCallibrationRecordModel;
import nirmalya.aatithya.restmodule.qa.model.RestRmPmReleaseStatusModel;
import nirmalya.aatithya.restmodule.util.StringUtil;

public class GenerateRmPmReleaseStatusParameter {
	public static String getRmPm(List<RestRmPmReleaseStatusModel> rmpm) {
		String s = "";
		String sitem = "";
		

		if (rmpm.get(0).getRmPmId() != null || rmpm.get(0).getRmPmId() != "") {
			s = s + "@p_rmPmId='" + rmpm.get(0).getRmPmId() + "',";
		}
		
		if (rmpm.get(0).getProductTypeField() != null || rmpm.get(0).getProductTypeField() != "") {
			s = s + "@p_productTypeField='" + rmpm.get(0).getProductTypeField() + "',";
		}

		if (rmpm.get(0).getRefNo() != null || rmpm.get(0).getRefNo() != "") {
			s = s + "@p_refNo='" + rmpm.get(0).getRefNo() + "',";
		}

		if (rmpm.get(0).getIssueNo() != null || rmpm.get(0).getIssueNo() != "") {
			s = s + "@p_issueNo='" + rmpm.get(0).getIssueNo() + "',";
		}
		if (rmpm.get(0).getIssuedDate() != null || rmpm.get(0).getIssuedDate() != "") {
			s = s + "@p_issuedDate='" + rmpm.get(0).getIssuedDate() + "',";
		}
		if (rmpm.get(0).getVerifiedBy() != null || rmpm.get(0).getVerifiedBy() != "") {
			s = s + "@p_verifiedBy='" + rmpm.get(0).getVerifiedBy() + "',";
		}
		
		
		if (rmpm.get(0).getCreatedBy() != null || rmpm.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + rmpm.get(0).getCreatedBy() + "',";
		}

		if (rmpm.get(0).getOrganization() != null || rmpm.get(0).getOrganization() != "") {
			s = s + "@p_org='" + rmpm.get(0).getOrganization() + "',";
		}
		if (rmpm.get(0).getOrgDivision() != null || rmpm.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + rmpm.get(0).getOrgDivision() + "',";
		}

	for (RestRmPmReleaseStatusModel m : rmpm) {
		//if(m.getDateOfReceipt()!="null" || m.getDateOfReceipt()!=null || m.getDateOfReceipt()!="") {
			if(!StringUtil.isNull(m.getDateOfReceipt())&&!StringUtil.isNull(m.getSerialNo())) {
			sitem = sitem + "(@p_rmPmId,\"" + m.getNum() + "\",\"" + m.getDateOfReceipt() + "\",\""
					+ m.getMaterial() + "\",\"" + m.getSupplier() + "\",\"" + m.getInvoiceNo() + "\",\""
					+ m.getInvoiceDated() + "\",\"" + m.getQuantityReceived() + "\",\"" + m.getGrrNo() + "\",\""
					+ m.getMaterialCode() + "\",\"" + m.getDateOfMfg() + "\",\"" + m.getSampleQty() + "\",\""
					+ m.getSamplerName() + "\",\"" + m.getDisposeOffPostAnalysis() + "\",\"" + m.getAnalysisStatus() + "\",\""
					+ m.getDateOfRelease() + "\",\"" + m.getApprovedBy() + "\",@p_createdBy,@p_org,@p_orgDiv,\""+m.getSerialNo()+"\"),";
				
		}
			

			}
		
			if (!sitem.isEmpty()) {
				sitem = sitem.substring(0, sitem.length() - 1);
				s = s + "@p_litemSubQuery='" + sitem + "',";
			}
		

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		

		System.out.println(s);

		return s;
	} 
	
	public static String getPhMeter(List<RestPhMeterCallibrationRecordModel> ph) {
		String s = "";
		String sitem = "";
		

		if (ph.get(0).getPhId() != null || ph.get(0).getPhId() != "") {
			s = s + "@p_phId='" + ph.get(0).getPhId() + "',";
		}
		
		if (ph.get(0).getProductTypeField() != null || ph.get(0).getProductTypeField() != "") {
			s = s + "@p_productTypeField='" + ph.get(0).getProductTypeField() + "',";
		}


		if (ph.get(0).getRefNo() != null || ph.get(0).getRefNo() != "") {
			s = s + "@p_refNo='" + ph.get(0).getRefNo() + "',";
		}

		if (ph.get(0).getIssueNo() != null || ph.get(0).getIssueNo() != "") {
			s = s + "@p_issueNo='" + ph.get(0).getIssueNo() + "',";
		}
		if (ph.get(0).getIssuedDate() != null || ph.get(0).getIssuedDate() != "") {
			s = s + "@p_issuedDate='" + ph.get(0).getIssuedDate() + "',";
		}
		if (ph.get(0).getVerifiedBy() != null || ph.get(0).getVerifiedBy() != "") {
			s = s + "@p_verifiedBy='" + ph.get(0).getVerifiedBy() + "',";
		}
		
		if (ph.get(0).getFrequency() != null || ph.get(0).getFrequency() != "") {
			s = s + "@p_frequency='" + ph.get(0).getFrequency() + "',";
		}
		
		if (ph.get(0).getTolerance() != null || ph.get(0).getTolerance() != "") {
			s = s + "@p_tolerance='" + ph.get(0).getTolerance() + "',";
		}
		if (ph.get(0).getRemarks() != null || ph.get(0).getRemarks() != "") {
			s = s + "@p_remark='" + ph.get(0).getRemarks() + "',";
		}
		
		if (ph.get(0).getCreatedBy() != null || ph.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + ph.get(0).getCreatedBy() + "',";
		}

		if (ph.get(0).getOrganization() != null || ph.get(0).getOrganization() != "") {
			s = s + "@p_org='" + ph.get(0).getOrganization() + "',";
		}
		if (ph.get(0).getOrgDivision() != null || ph.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + ph.get(0).getOrgDivision() + "',";
		}

	for (RestPhMeterCallibrationRecordModel m : ph) {
				sitem = sitem + "(@p_phId,\"" + m.getNum() + "\",\"" + m.getDate() + "\",\""
						+ m.getEquipmentId() + "\",\"" + m.getStandardValue() + "\",\"" + m.getActualValue() + "\",\""
						+ m.getError() + "\",\"" + m.getTemp() + "\",\"" + m.getSignature() + "\",@p_createdBy,@p_org,@p_orgDiv),";

			}
		
			if (!sitem.isEmpty()) {
				sitem = sitem.substring(0, sitem.length() - 1);
				s = s + "@p_litemSubQuery='" + sitem + "',";
			}
		

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		

		System.out.println(s);

		return s;
	} 
	
	public static String getMedia(List<MediaDecontaminationRecordModel> md) {
		String s = "";
		String sitem = "";
		

		if (md.get(0).getMediaId() != null || md.get(0).getMediaId() != "") {
			s = s + "@p_mediaId='" + md.get(0).getMediaId() + "',";
		}
		if (md.get(0).getYear() != null || md.get(0).getYear() != "") {
			s = s + "@p_year='" + md.get(0).getYear() + "',";
		}
		if (md.get(0).getRefNo() != null || md.get(0).getRefNo() != "") {
			s = s + "@p_refNo='" + md.get(0).getRefNo() + "',";
		}

		if (md.get(0).getIssueNo() != null || md.get(0).getIssueNo() != "") {
			s = s + "@p_issueNo='" + md.get(0).getIssueNo() + "',";
		}
		if (md.get(0).getIssuedDate() != null || md.get(0).getIssuedDate() != "") {
			s = s + "@p_issuedDate='" + md.get(0).getIssuedDate() + "',";
		}
		
		if (md.get(0).getCreatedBy() != null || md.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + md.get(0).getCreatedBy() + "',";
		}

		if (md.get(0).getOrganization() != null || md.get(0).getOrganization() != "") {
			s = s + "@p_org='" + md.get(0).getOrganization() + "',";
		}
		if (md.get(0).getOrgDivision() != null || md.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + md.get(0).getOrgDivision() + "',";
		}

	for (MediaDecontaminationRecordModel m : md) {
				sitem = sitem + "(@p_mediaId,\"" + m.getNum() + "\",\"" + m.getDate() + "\",\""
						+ m.getStartTimeOfAutoclave() + "\",\"" + m.getTimeOfReached() + "\",\"" + m.getCycleOverTime() + "\",\""
						+ m.getFileUpload() + "\",\"" + m.getQuantityOfMedia() + "\",\"" + m.getSignatureOfMicrobiologist() + "\",\"" + m.getQaManager() + "\",@p_createdBy,@p_org,@p_orgDiv),";

			}
		
			if (!sitem.isEmpty()) {
				sitem = sitem.substring(0, sitem.length() - 1);
				s = s + "@p_litemSubQuery='" + sitem + "',";
			}
		

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		

		System.out.println(s);

		return s;
	} 
//Horlics Analysis Record
	public static String getHorlicks(List<HorlicksAnalysisRestModel> horlicks) {
		String s = "";
		String sitem = "";
		String sitem1 = "";
		

		if (horlicks.get(0).getHorlicksId()!= null || horlicks.get(0).getHorlicksId() != "") {
			s = s + "@p_horlicksId='" + horlicks.get(0).getHorlicksId() + "',";
		}
		
		if (horlicks.get(0).getProductTypeField() != null || horlicks.get(0).getProductTypeField() != "") {
			s = s + "@p_productTypeField='" + horlicks.get(0).getProductTypeField() + "',";
		}

		if (horlicks.get(0).getRefNo() != null || horlicks.get(0).getRefNo() != "") {
			s = s + "@p_refNo='" + horlicks.get(0).getRefNo() + "',";
		}

		if (horlicks.get(0).getIssueNo() != null || horlicks.get(0).getIssueNo() != "") {
			s = s + "@p_issueNo='" + horlicks.get(0).getIssueNo() + "',";
		}
		if (horlicks.get(0).getIssuedDate() != null || horlicks.get(0).getIssuedDate() != "") {
			s = s + "@p_issuedDate='" + horlicks.get(0).getIssuedDate() + "',";
		}
		
		if (horlicks.get(0).getCreatedBy() != null || horlicks.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + horlicks.get(0).getCreatedBy() + "',";
		}

		if (horlicks.get(0).getOrganization() != null || horlicks.get(0).getOrganization() != "") {
			s = s + "@p_org='" + horlicks.get(0).getOrganization() + "',";
		}
		if (horlicks.get(0).getOrgDivision() != null || horlicks.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + horlicks.get(0).getOrgDivision() + "',";
		}

	for (HorlicksAnalysisRestModel m : horlicks) {
		if(!StringUtil.isNull(m.getIronCont())) {
			sitem = sitem + "(@p_horlicksId,\"" + m.getIronCont() + "\",\"" + m.getBno1() + "\",\""
					+ m.getTo1() + "\",\"" + m.getBno2() + "\",\"" + m.getSpec1() + "\",\""
					+ m.getBlank1() + "\",\"" + m.getParam() + "\",\"" + m.getBno3() + "\",\""
					+ m.getRessult1() + "\",@p_createdBy,@p_org,@p_orgDiv),";
		}
			
				
		}
			

			
	for (HorlicksAnalysisRestModel m : horlicks) {
		if(!StringUtil.isNull(m.getSerialNo())) {
			sitem1 = sitem1 + "(@p_horlicksId,\"" + m.getDate()+ "\",\"" + m.getSlNo()+ "\",\"" + m.getSku() + "\",\""
					+ m.getSignatureOfMicrobiologist() + "\",\"" + m.getAppearance() + "\",\"" + m.getTasteFlavour() + "\",\""
					+ m.getOdourClean() + "\",\"" + m.getConsistency() + "\",\"" + m.getSingleMpiece() + "\",\""
					+ m.getBdSpecification() + "\",\"" + m.getPhSpecification() + "\",\"" + m.getTotalProtin() + "\",\""
					+ m.getMoistureSpecification()+ "\",\"" + m.getVitaminResults() + "\",\"" + m.getSign() + 
					"\",@p_createdBy,@p_org,@p_orgDiv),";
			//,\""+m.getSerialNo()+"\"
				
		}
			

			}
		
			if (sitem != null && !sitem.isEmpty()) {
				sitem = sitem.replace("null", " ");
				sitem = sitem.substring(0, sitem.length() - 1);
				
				s = s + "@p_litemSubQuery='" + sitem + "',";
				System.out.println("sitem================="+s);
			}
		
			if (sitem1 != null && !sitem1.isEmpty()) {
				sitem1 = sitem1.replace("null", " ");
				sitem1 = sitem1.substring(0, sitem1.length() - 1);
				
				s = s + "@p_litemSubQuery1='" + sitem1 + "',";
				System.out.println("sitem1------------"+s);
			}
			
			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		

		System.out.println("DATAAAAAAAAAAAAAAAAAAAAAAA"+s);

		return s;
	} 
}
