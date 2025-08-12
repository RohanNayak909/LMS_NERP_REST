package nirmalya.aatithya.restmodule.common.utils.qa;

import java.util.List;

import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaEvaluationBoppTapeModel;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;


public class GenerateEvaluationParam {
	public static String getAddEvaluation(List<QaEvaluationBoppTapeModel> qp) {
		String s = "";
		String sitem = "";
		String sitem1 = "";
		//String sitem2 = "";

		if (qp.get(0).getEvalutionId() != null || qp.get(0).getEvalutionId() != "") {
			s = s + "@p_evaluationId='" + qp.get(0).getEvalutionId() + "',";
		}

		if (qp.get(0).getRefNo() != null || qp.get(0).getRefNo() != "") {
			s = s + "@p_refNo='" + qp.get(0).getRefNo() + "',";
		}

		if (qp.get(0).getIssueNo() != null || qp.get(0).getIssueNo() != "") {
			s = s + "@p_issueNo='" + qp.get(0).getIssueNo() + "',";
		}
		
		if (qp.get(0).getIssuedDate() != null || qp.get(0).getIssuedDate() != "") {
			s = s + "@p_issuedDate='" + qp.get(0).getIssuedDate() + "',";
		}

		if (qp.get(0).getChallanNo() != null || qp.get(0).getChallanNo() != "") {
			s = s + "@p_challanNo='" + qp.get(0).getChallanNo() + "',";
		}

		if (qp.get(0).getReceiptDate() != null || qp.get(0).getReceiptDate() != "") {
			s = s + "@p_receiptDate='" + qp.get(0).getReceiptDate() + "',";
		}
		
		
		if (qp.get(0).getSku() != null || qp.get(0).getSku() != "") {
			s = s + "@p_sku='" + qp.get(0).getSku() + "',";
		}
		
		if (qp.get(0).getProduct() != null && qp.get(0).getProduct() != "") {
			s = s + "@p_product='" + qp.get(0).getProduct() + "',";
		}

		if (qp.get(0).getSpecificationNo() != null || qp.get(0).getSpecificationNo() != "") {
			s = s + "@p_specificationNo='" + qp.get(0).getSpecificationNo() + "',";
		}
		
		if (qp.get(0).getGrrNo() != null || qp.get(0).getGrrNo() != "") {
			s = s + "@p_grrNo='" + qp.get(0).getGrrNo() + "',";
		}

		if (qp.get(0).getSamplingDate() != null || qp.get(0).getSamplingDate() != "") {
			s = s + "@p_samplingDate='" + qp.get(0).getSamplingDate() + "',";
		}

		if (qp.get(0).getSupplier() != null || qp.get(0).getSupplier() != "") {
			s = s + "@p_supplier='" + qp.get(0).getSupplier() + "',";
		}
		
		
		if (qp.get(0).getQuantityRcvd() != null || qp.get(0).getQuantityRcvd() != "") {
			s = s + "@p_quantityRcvd='" + qp.get(0).getQuantityRcvd() + "',";
		}
		
		if (qp.get(0).getCheckingDate() != null || qp.get(0).getCheckingDate() != "") {
			s = s + "@p_checkingDate='" + qp.get(0).getCheckingDate() + "',";
		}
		
		
		if (qp.get(0).getQuantityChkd() != null || qp.get(0).getQuantityChkd() != "") {
			s = s + "@p_quantityChkd='" + qp.get(0).getQuantityChkd() + "',";
		}
		
		if (qp.get(0).getrStatus() != null || qp.get(0).getrStatus() != "") {
			s = s + "@p_rStatus='" + qp.get(0).getrStatus() + "',";
		}
		
		
		if (qp.get(0).getcCompliance() != null || qp.get(0).getcCompliance() != "") {
			s = s + "@p_cCompliance='" + qp.get(0).getcCompliance() + "',";
		}
		
		if (qp.get(0).getCreatedBy() != null || qp.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + qp.get(0).getCreatedBy() + "',";
		}

		if (qp.get(0).getOrganization() != null || qp.get(0).getOrganization() != "") {
			s = s + "@p_org='" + qp.get(0).getOrganization() + "',";
		}
		if (qp.get(0).getOrgDivision() != null || qp.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + qp.get(0).getOrgDivision() + "',";
		}
		
		if (qp.get(0).getImgName() != null && qp.get(0).getImgName() != "") {
			s = s + "@p_imgName='" + qp.get(0).getImgName() + "',";
		}
		if (qp.get(0).getImgUrl() != null && qp.get(0).getImgUrl() != "") {
			s = s + "@p_imgUrl='" + qp.get(0).getImgUrl() + "',";
		}

		for (QaEvaluationBoppTapeModel m : qp) {
				 
				 sitem = sitem + "(@p_evaluationId,\"" + m.getParameter()+ "\",\"" + m.getSpecification()+ "\",\"" + m.getNum()+ "\",\"" + m.getNum1()+ "\",\"" + m.getNum2()  + "\",\"" + m.getNum3() +"\",\"" + m.getNum4() +"\",\"" + m.getNum5() +"\",\"" + m.getAvg()
					+ "\",  \"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
							+ "\"),";
				 
				 sitem1 = sitem1 + "(\"" + m.getNum()+ "\",\"" + m.getParameter()+ "\",\"" + m.getSpecification() 
				 + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
							+ "\"),";
	
		}
		sitem = sitem.substring(0, sitem.length() - 1);  // Remove the trailing comma
		sitem1 = sitem1.substring(0, sitem1.length() - 1);  // Remove the trailing comma
		s = s + "@p_itemSubQuery='" + sitem + "',";
		s = s + "@p_gridSubQuery='" + sitem1 + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	} 
	
	
	public static String addSamplereceiving(List<QaEvaluationBoppTapeModel> qp) {
		String s = "";
		String sitem = "";
		String sitem1 = "";
		
		if (qp.get(0).getType() != null || qp.get(0).getType() != "") {
			s = s + "@p_type='" + qp.get(0).getType() + "',";
		}
		
		if (qp.get(0).getProductTypeField() != null || qp.get(0).getProductTypeField() != "") {
			s = s + "@p_productTypeField='" + qp.get(0).getProductTypeField() + "',";
		}else {
			s = s + "@p_productTypeField='" + "" + "',";
		}

		if (qp.get(0).getSampleId() != null || qp.get(0).getSampleId() != "") {
			s = s + "@p_sampleId='" + qp.get(0).getSampleId() + "',";
		}

		if (qp.get(0).getSampleDate() != null || qp.get(0).getSampleDate() != "") {
			s = s + "@p_sampleDate='" + qp.get(0).getSampleDate() + "',";
		}

		if (qp.get(0).getRemarks() != null || qp.get(0).getRemarks() != "") {
			s = s + "@p_remarks='" + qp.get(0).getRemarks() + "',";
		}
		
		if (qp.get(0).getReviewedBy() != null || qp.get(0).getReviewedBy() != "") {
			s = s + "@p_reviewedBy='" + qp.get(0).getReviewedBy() + "',";
		}
		if (qp.get(0).getAnalyzedBy() != null || qp.get(0).getAnalyzedBy() != "") {
			s = s + "@p_analyzedBy='" + qp.get(0).getAnalyzedBy() + "',";
		}
		if (qp.get(0).getResultBy() != null || qp.get(0).getResultBy() != "") {
			s = s + "@p_resultBy='" + qp.get(0).getResultBy() + "',";
		}
		if (qp.get(0).getCreatedBy() != null || qp.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + qp.get(0).getCreatedBy() + "',";
		}

		if (qp.get(0).getOrganization() != null || qp.get(0).getOrganization() != "") {
			s = s + "@p_org='" + qp.get(0).getOrganization() + "',";
		}
		if (qp.get(0).getOrgDivision() != null || qp.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + qp.get(0).getOrgDivision() + "',";
		}

		for (QaEvaluationBoppTapeModel m : qp) {
			
				 sitem = sitem + "(@p_sampleId,\"" + m.getGridSlNo() + "\",\"" + m.getParamSlNo() + "\",\"" + m.getParmName()
				 + "\",\"" + m.getCol1() + "\",\"" + m.getCol2() + "\",\"" + m.getCol3()
				 + "\",\"" + m.getCol4() + "\",\"" + m.getCol5() + "\",\"" + m.getCol6()	
				 + "\",\"" + m.getCtrNo() + "\",\"" + m.getCtr1()+ "\",\"" + m.getCtr2()+ "\",\"" + m.getCtr3()+ "\",\"" + m.getCtr4()  + "\",\"" + m.getCtr5() +"\",\"" + m.getCtr6() +"\",\"" + m.getCtr7() 
				 + "\",\"" + m.getCtr8() + "\",\"" + m.getCtr9() + "\",\"" + m.getCtr10()
				 + "\",\"" + m.getCtr11() + "\",\"" + m.getCtr12() + "\",\"" + m.getCtr13()
				 + "\",\"" + m.getCtr14() + "\",\"" + m.getCtr15() + "\",\"" + m.getCtr16()
				 + "\",\"" + m.getCtr17() + "\",\"" + m.getCtr18() + "\",\"" + m.getCtr19()
				 + "\",\"" + m.getCtr20() + "\",\"" + m.getCtr21() + "\",\"" + m.getCtr22()
				 + "\",\"" + m.getCtr23() + "\",\"" + m.getCtr24() + "\",\"" + m.getCtr25()
				 + "\",\"" + m.getCtr26() + "\",\"" + m.getCtr27() + "\",\"" + m.getCtr28()
				 + "\",\"" + m.getCtr29() 				 
				 + "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
							+ "\"),";
				 
			 if(m.getGridSlNo().contentEquals("1")) { 
				 sitem1 = sitem1 + "(\"" + m.getGridSlNo() + "\",\"" + m.getParamSlNo() + "\",\"" + m.getParmName()
				 + "\",\"" + m.getCol1() + "\",\"" + m.getCol2() + "\",\"" + m.getCol3()
				 + "\",\"" + m.getCol4() + "\",\"" + m.getCol5() + "\",\"" + m.getCol6()			 
							+ "\"),";
			}
	
		}
		sitem = sitem.substring(0, sitem.length() - 1);  // Remove the trailing comma
		sitem1 = sitem1.substring(0, sitem1.length() - 1);  // Remove the trailing comma
		s = s + "@p_itemSubQuery='" + sitem + "',";
		s = s + "@p_itemSubQuery1='" + sitem1 + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	} 
	
	public static String addMedia(List<QaEvaluationBoppTapeModel> qp) {
		String s = "";
		String sitem = "";
		

		if (qp.get(0).getMediaId() != null || qp.get(0).getMediaId() != "") {
			s = s + "@p_mediaId='" + qp.get(0).getMediaId() + "',";
		}

		if (qp.get(0).getMediaDate() != null || qp.get(0).getMediaDate() != "") {
			s = s + "@p_mediaDate='" + qp.get(0).getMediaDate() + "',";
		}

		if (qp.get(0).getRemarks() != null || qp.get(0).getRemarks() != "") {
			s = s + "@p_remarks='" + qp.get(0).getRemarks() + "',";
		}		
		if (qp.get(0).getCreatedBy() != null || qp.get(0).getCreatedBy() != "") {
			s = s + "@p_createdBy='" + qp.get(0).getCreatedBy() + "',";
		}

		if (qp.get(0).getOrganization() != null || qp.get(0).getOrganization() != "") {
			s = s + "@p_org='" + qp.get(0).getOrganization() + "',";
		}
		if (qp.get(0).getOrgDivision() != null || qp.get(0).getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + qp.get(0).getOrgDivision() + "',";
		}
		if (qp.get(0).getDocName() != null || qp.get(0).getDocName() != "") {
			s = s + "@p_docName='" + qp.get(0).getDocName() + "',";
		}

		for (QaEvaluationBoppTapeModel m : qp) {

				 sitem = sitem + "(@p_mediaId,\"" + m.getColNo()+ "\",\"" + m.getMedia()+ "\",\"" + m.getBatchCode()+ "\",\"" + m.getExpiryDate()+ "\",\"" + m.getQtyMedia()  + "\",\"" + m.getFinalpH() +"\",\"" + m.getBeforeAdj() +"\",\"" + m.getAfterAdj() 
				 + "\",\"" + m.getDisQty() + "\",\"" + m.getStartTime() + "\",\"" + m.getReachedTime()
				 + "\",\"" + m.getCycleTime() + "\",\"" + m.getSterilization() + "\",\"" + m.getFileUpload()
				 + "\",\"" + m.getCreatedBy() + "\",\"" + m.getOrganization() + "\",\"" + m.getOrgDivision()
							+ "\"),";
	
		}
		sitem = sitem.substring(0, sitem.length() - 1);  // Remove the trailing comma
		s = s + "@p_itemSubQuery='" + sitem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	} 
	
	

}
