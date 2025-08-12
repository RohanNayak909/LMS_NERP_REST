package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.qa.model.LtmrRecordModel;
import nirmalya.aatithya.restmodule.qa.model.MicroTestingModel;
import nirmalya.aatithya.restmodule.qa.model.RestVbarModel;
import nirmalya.aatithya.restmodule.qa.model.RestVitAModel;
import nirmalya.aatithya.restmodule.qa.model.RtmrRecordModel;
import nirmalya.aatithya.restmodule.sales.model.RestQuotationNewModel;
import nirmalya.aatithya.restmodule.sales.model.ScopeMatrixRestModel;

public class GenerateMicroTestingParameter {

	public static String getMtParam(List<MicroTestingModel> qa) {

		String s = "";
		String listdata = "";
		String mictotestingId = "";
		//String monthYear = "";
		String maximunAllowedTime = "";
		String equipmentName = "";
		String equipmentId = "";
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
		String refNo = "";
		String issueNo = "";
		String dateOfIssue = "";
		String month = "";
		String year = "";
		
		for (MicroTestingModel m : qa) {
			mictotestingId = m.getMictotestingId();
		//	monthYear = m.getMonthYear();
			maximunAllowedTime = m.getMaximunAllowedTime();
			equipmentName = m.getEquipmentName();
			equipmentId = m.getEquipmentId();
			createdBy = m.getCreatedBy();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			refNo = m.getRefNo();
			issueNo = m.getIssueNo();
			dateOfIssue = m.getDateOfIssue();
			month = m.getMonth();
			year = m.getYear();
		}

		s = s + "@p_mictotestingId='" + mictotestingId + "',";
		//s = s + "@p_monthYear='" + monthYear + "',";
		s = s + "@p_maximunAllowedTime='" + maximunAllowedTime + "',";
		s = s + "@p_equipmentName='" + equipmentName + "',";
		s = s + "@p_equipmentId='" + equipmentId + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_refNo='" + refNo + "',";
		s = s + "@p_issueNo='" + issueNo + "',";
		s = s + "@p_dateOfIssue='" + dateOfIssue + "',";
		s = s + "@p_month='" + month + "',";
		s = s + "@p_year='" + year + "',";
		

		if (!qa.get(0).getMictotestingId().contentEquals("1")) {
			for (MicroTestingModel m : qa) {
				listdata = listdata + "(@p_mictotestingId,\"" + m.getDate() + "\",\"" + m.getLightOn() + "\",\""
						+ m.getLightOff() + "\",\"" + m.getWorkingHrs() + "\",\"" + m.getWorkingHrsTotal() + "\",\""
						+ m.getSign() + "\",@p_createdBy,@p_organization,@p_orgDivision),";

			}
		
			if (!listdata.isEmpty()) {
				listdata = listdata.substring(0, listdata.length() - 1);
				s = s + "@p_litemSubQuery='" + listdata + "',";
			}
		

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		System.out.println("Item Details" + s);
		return s;

	}
	
	public static String getRtmrParam(List<RtmrRecordModel> rtmr) {

		String s = "";
		String type = "";
		String listdata = "";
		String rtmrId = "";
		String month = "";
		String refNo = "";
		String issueNo = "";
		String dateOfIssue = "";
		String minTemp = "";
		String maxTemp = "";
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
		String productTypeField = "";

		
		for (RtmrRecordModel m : rtmr) {
			type = m.getType();
			rtmrId = m.getRtmrId();
			month = m.getMonth();
			refNo = m.getRefNo();
			issueNo = m.getIssueNo();
			dateOfIssue = m.getDateOfIssue();
			minTemp = m.getMinTemp();
			maxTemp = m.getMaxTemp();
			createdBy = m.getCreatedBy();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			productTypeField = m.getProductTypeField();
			
		}

		s = s + "@p_type='" + type + "',";
		s = s + "@p_rtmrId='" + rtmrId + "',";
		s = s + "@p_month='" + month + "',";
		s = s + "@p_refNo='" + refNo + "',";
		s = s + "@p_issueNo='" + issueNo + "',";
		s = s + "@p_dateOfIssue='" + dateOfIssue + "',";
		s = s + "@p_minTemp='" + minTemp + "',";
		s = s + "@p_maxTemp='" + maxTemp + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_productTypeField='" + productTypeField + "',";
		
		

		if (! rtmr.get(0).getRtmrId().contentEquals("1")) {
			for (RtmrRecordModel m : rtmr) {
				listdata = listdata + "(@p_rtmrId,\"" + m.getDate() + "\",\"" + m.getTime() + "\",\""
						+ m.getTemp() + "\",\""
						+ m.getSign() + "\",@p_createdBy,@p_organization,@p_orgDivision),";

			}
		
			if (!listdata.isEmpty()) {
				listdata = listdata.substring(0, listdata.length() - 1);
				s = s + "@p_litemSubQuery='" + listdata + "',";
			}
		

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		System.out.println("Item Details" + s);
		return s;

	}
	
	public static String getLtmrParam(List<LtmrRecordModel> ltmr) {

		String s = "";
		String type = "";
		String listdata = "";
		String ltmrId = "";
		String month = "";
		String dryBulbTemp = "";
		String rhId = "";
		String refNo = "";
		String issueNo = "";
		String dateOfIssue = "";
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
		String productTypeField = "";

		
		for (LtmrRecordModel m : ltmr) {
			type = m.getType();
			ltmrId = m.getLtmrId();
			month = m.getMonth();
			dryBulbTemp = m.getDryBulbTemp();
			rhId = m.getRhId();
			refNo = m.getRefNo();
			issueNo = m.getIssueNo();
			dateOfIssue = m.getDateOfIssue();
			createdBy = m.getCreatedBy();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			productTypeField = m.getProductTypeField();
			
		}

		s = s + "@p_type='" + type + "',";
		s = s + "@p_ltmrId='" + ltmrId + "',";
		s = s + "@p_month='" + month + "',";
		s = s + "@p_dryBulbTemp='" + dryBulbTemp + "',";
		s = s + "@p_rhId='" + rhId + "',";
		s = s + "@p_refNo='" + refNo + "',";
		s = s + "@p_issueNo='" + issueNo + "',";
		s = s + "@p_dateOfIssue='" + dateOfIssue + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_productTypeField='" + productTypeField + "',";
		
		

		if (!ltmr.get(0).getLtmrId().contentEquals("1")) {
			for (LtmrRecordModel m : ltmr) {
				listdata = listdata + "(@p_ltmrId,\"" + m.getDate() + "\",\"" + m.getTime() + "\",\""
						+ m.getRhPercent() + "\",\"" + m.getWetTemp() + "\",\"" + m.getDryTemp() + "\",\""
						+ m.getSign() + "\",@p_createdBy,@p_organization,@p_orgDivision),";

			}
		
			if (!listdata.isEmpty()) {
				listdata = listdata.substring(0, listdata.length() - 1);
				s = s + "@p_litemSubQuery='" + listdata + "',";
			}
		

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		return s;

	}
	
	public static String getVbarParam(List<RestVbarModel> vbar) {

		String s = "";
		String listdata = "";
		String vb1arId = "";
		String resultStatus = "";
		String nameSign = "";
		String verifiedBy = "";
		String refNo = "";
		String issueNo = "";
		String date = "";
		String dateOfIssue = "";
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
		String productTypeField = "";

		
		for (RestVbarModel m : vbar) {
			vb1arId = m.getVb1arId();
			resultStatus = m.getResultStatus();
			nameSign = m.getNameSign();
			verifiedBy = m.getVerifiedBy();
			refNo = m.getRefNo();
			issueNo = m.getIssueNo();
			date = m.getDate();
			dateOfIssue = m.getDateOfIssue();
			createdBy = m.getCreatedBy();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			productTypeField = m.getProductTypeField();
			
		}

		s = s + "@p_vb1arId='" + vb1arId + "',";
		s = s + "@p_resultStatus='" + resultStatus + "',";
		s = s + "@p_nameSign='" + nameSign + "',";
		s = s + "@p_verifiedBy='" + verifiedBy + "',";
		s = s + "@p_refNo='" + refNo + "',";
		s = s + "@p_issueNo='" + issueNo + "',";
		s = s + "@p_date='" + date + "',";
		s = s + "@p_dateOfIssue='" + dateOfIssue + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_productTypeField='" + productTypeField + "',";
		
		

		if (!vbar.get(0).getVb1arId().contentEquals("1")) {
			for (RestVbarModel m : vbar) {
				listdata = listdata + "(@p_vb1arId,\"" + m.getrId() + "\",\"" + m.getbId() + "\",\""
						+ m.getProduct() + "\",\"" + m.getBatchNo() + "\",\"" + m.getWeightofSample() + "\",\""
						+ m.getConstantReading() + "\",\"" + m.getCalculation() + "\",\"" + m.getResulsMg() + "\",@p_createdBy,@p_organization,@p_orgDivision),";

			}
		
			if (!listdata.isEmpty()) {
				listdata = listdata.substring(0, listdata.length() - 1);
				s = s + "@p_litemSubQuery='" + listdata + "',";
			}
		

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		return s;

	}
	
	
	public static String getVcarParam(List<RestVbarModel> vcar) {

		String s = "";
		String listdata = "";
		String vbcarId = "";
		String refNo = "";
		String issueNo = "";
		String dateOfIssue = "";
		String dateOfSampling = "";
		String dyeFactor = "";
		String dateOfAnalysis = "";
		String weightOfStandardUsed = "";
		String blank = "";
		String materialStatus = "";
		String nameSign = "";
		String verifiedBy = "";
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
		String productTypeField = "";

		
		for (RestVbarModel m : vcar) {
			vbcarId = m.getVbcarId();
			refNo = m.getRefNo();
			issueNo = m.getIssueNo();
			dateOfIssue = m.getDateOfIssue();
			dateOfSampling = m.getDateOfSampling();
			dyeFactor = m.getDyeFactor();
			dateOfAnalysis = m.getDateOfAnalysis();
			weightOfStandardUsed = m.getWeightOfStandardUsed();
			blank = m.getBlank();
			materialStatus = m.getMaterialStatus();
			nameSign = m.getNameSign();
			verifiedBy = m.getVerifiedBy();
			createdBy = m.getCreatedBy();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			productTypeField = m.getProductTypeField();
			
		}

		s = s + "@p_vbcarId='" + vbcarId + "',";
		s = s + "@p_refNo='" + refNo + "',";
		s = s + "@p_issueNo='" + issueNo + "',";
		s = s + "@p_dateOfIssue='" + dateOfIssue + "',";
		s = s + "@p_dateOfSampling='" + dateOfSampling + "',";
		s = s + "@p_dyeFactor='" + dyeFactor + "',";
		s = s + "@p_dateOfAnalysis='" + dateOfAnalysis + "',";
		s = s + "@p_weightOfStandardUsed='" + weightOfStandardUsed + "',";
		s = s + "@p_blank='" + blank + "',";
		s = s + "@p_materialStatus='" + materialStatus + "',";
		s = s + "@p_nameSign='" + nameSign + "',";
		s = s + "@p_verifiedBy='" + verifiedBy + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_productTypeField='" + productTypeField + "',";
		
		

		if (!vcar.get(0).getVbcarId().contentEquals("1")) {
			for (RestVbarModel m : vcar) {
				listdata = listdata + "(@p_vbcarId,\""
						+ m.getProduct() + "\",\"" + m.getBatchNo() + "\",\"" + m.getSampleWeight() + "\",\""
						+ m.getTitrationValue() + "\",\"" + m.getCalculation() + "\",\"" + m.getObservation() + "\",@p_createdBy,@p_organization,@p_orgDivision),";

			}
		
			if (!listdata.isEmpty()) {
				listdata = listdata.substring(0, listdata.length() - 1);
				s = s + "@p_litemSubQuery='" + listdata + "',";
			}
		

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		}
		return s;

	}

	public static String getVitAParam(List<RestVitAModel> vitamin) {
		String s = "";
		String listdata = "";
		String vitAId = "";
		String resultStatus = "";
//		String nameSign = "";
//		String verifiedBy = "";
		String refNo = "";
		String issueNo = "";
		String packingDate = "";
		String issueDate = "";
		String createdBy = "";
		String organization = "";
		String orgDivision = "";
		String productTypeField = "";

		
		for (RestVitAModel m : vitamin) {
			
			vitAId = m.getVitAId();
			resultStatus = m.getResultsMg();
			refNo = m.getRefNo();
			issueNo = m.getIssueNo();
			issueDate = m.getIssueDate();
			createdBy = m.getCreatedBy();
			organization = m.getOrganization();
			orgDivision = m.getOrgDivision();
			packingDate = m.getPackingDate();
			productTypeField = m.getProductTypeField();
			
		}

		if (vitAId != null && vitAId != "") {
			s = s + "@p_vitAId='" + vitAId + "',";
		}else {
			s = s + "@p_vitAId='',";
		}
		s = s + "@p_resultStatus='" + resultStatus + "',";
//		s = s + "@p_nameSign='" + nameSign + "',";
//		s = s + "@p_verifiedBy='" + verifiedBy + "',";
		s = s + "@p_refNo='" + refNo + "',";
		s = s + "@p_issueNo='" + issueNo + "',";
		s = s + "@p_packingDate='" + packingDate + "',";
		s = s + "@p_dateOfIssue='" + issueDate + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_organization='" + organization + "',";
		s = s + "@p_orgDivision='" + orgDivision + "',";
		s = s + "@p_productTypeField='" + productTypeField + "',";
		
		

	//	if (!vitamin.get(0).getVitAId().contentEquals("1")) {
			for (RestVitAModel m : vitamin) {
				listdata = listdata + "(@p_vitAId,\"" + m.getAid() + "\",\"" + m.getBid()+ "\",\"" + m.getCid()  + "\",\"" + m.getDid() + "\",\""
						+ m.getProduct() + "\",\"" + m.getSku() + "\",\"" + m.getBatchNo() + "\",\"" + m.getWeightofSample() + "\",\""
						 + m.getCalculation() + "\",\"" + m.getResultsMg() + "\",@p_createdBy,now(),@p_organization,@p_orgDivision),";

			}
		
			if (!listdata.isEmpty()) {
				listdata = listdata.substring(0, listdata.length() - 1);
				s = s + "@p_litemSubQuery='" + listdata + "',";
			}
		

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		//}
		return s;
	}
}
