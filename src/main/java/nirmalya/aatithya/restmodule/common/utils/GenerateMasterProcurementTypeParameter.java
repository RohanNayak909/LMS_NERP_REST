package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.master.model.RestProcurementMasterModel;

public class GenerateMasterProcurementTypeParameter {

	public static String addMeasureTypeParam(RestProcurementMasterModel restProcurementMasterModel) {

		String s = "";

		if (restProcurementMasterModel.getMeasurementId() != null
				|| restProcurementMasterModel.getMeasurementId() != "") {
			s = s + "@p_measureId='" + restProcurementMasterModel.getMeasurementId() + "',";
		}
		if (restProcurementMasterModel.getMeasurementName() != null
				|| restProcurementMasterModel.getMeasurementName() != "") {
			s = s + "@p_measureName='" + restProcurementMasterModel.getMeasurementName() + "',";
		}
		if (restProcurementMasterModel.getMeasurementOrder() != null
				|| restProcurementMasterModel.getMeasurementOrder() != "") {
			s = s + "@p_measureOrder='" + restProcurementMasterModel.getMeasurementOrder() + "',";
		}
		if (restProcurementMasterModel.getMeasurementCode() != null
				|| restProcurementMasterModel.getMeasurementCode() != "") {
			s = s + "@p_measureCode='" + restProcurementMasterModel.getMeasurementCode() + "',";
		}
		if (restProcurementMasterModel.getMeasurementDesc() != null
				|| restProcurementMasterModel.getMeasurementDesc() != "") {
			s = s + "@p_measureDesc='" + restProcurementMasterModel.getMeasurementDesc() + "',";
		}
		if (restProcurementMasterModel.getMeasurementStatus() != null
				|| restProcurementMasterModel.getMeasurementStatus() != "") {
			s = s + "@p_measureStatus=" + restProcurementMasterModel.getMeasurementStatus() + ",";
		}
		if (restProcurementMasterModel.getMeasurementCreatedBy() != null
				|| restProcurementMasterModel.getMeasurementCreatedBy() != "") {
			s = s + "@p_measureCreatedBy='" + restProcurementMasterModel.getMeasurementCreatedBy() + "',";
		}
		if (restProcurementMasterModel.getOrg() != null || restProcurementMasterModel.getOrg() != "") {
			s = s + "@p_org='" + restProcurementMasterModel.getOrg() + "',";
		}
		if (restProcurementMasterModel.getOrgDiv() != null || restProcurementMasterModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + restProcurementMasterModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

	public static String addReqiTypeParam(RestProcurementMasterModel restProcurementMasterModel) {

		String s = "";

		if (restProcurementMasterModel.getRequisitionId() != null
				|| restProcurementMasterModel.getRequisitionId() != "") {
			s = s + "@p_reqiId='" + restProcurementMasterModel.getRequisitionId() + "',";
		}
		if (restProcurementMasterModel.getRequisitionName() != null
				|| restProcurementMasterModel.getRequisitionName() != "") {
			s = s + "@p_reqiName='" + restProcurementMasterModel.getRequisitionName() + "',";
		}
		if (restProcurementMasterModel.getRequisitionDesc() != null
				|| restProcurementMasterModel.getRequisitionDesc() != "") {
			s = s + "@p_reqiDesc='" + restProcurementMasterModel.getRequisitionDesc() + "',";
		}

		if (restProcurementMasterModel.getRequisitionStatus() != null
				|| restProcurementMasterModel.getRequisitionStatus() != "") {
			s = s + "@p_reqiStatus='" + restProcurementMasterModel.getRequisitionStatus() + "',";
		}
		if (restProcurementMasterModel.getRequisitionCreatedBy() != null
				|| restProcurementMasterModel.getRequisitionCreatedBy() != "") {
			s = s + "@p_reqiCreatedBy='" + restProcurementMasterModel.getRequisitionCreatedBy() + "',";
		}
		if (restProcurementMasterModel.getOrg() != null || restProcurementMasterModel.getOrg() != "") {
			s = s + "@p_org='" + restProcurementMasterModel.getOrg() + "',";
		}
		if (restProcurementMasterModel.getOrgDiv() != null || restProcurementMasterModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + restProcurementMasterModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		} 
		return s;

	}

	public static String addReqiPriorityTypeParam(RestProcurementMasterModel restProcurementMasterModel) {

		String s = "";

		if (restProcurementMasterModel.getRequiPriorityId() != null
				|| restProcurementMasterModel.getRequiPriorityId() != "") {
			s = s + "@p_reqiprioId='" + restProcurementMasterModel.getRequiPriorityId() + "',";
		}
		if (restProcurementMasterModel.getRequiPriorityName() != null
				|| restProcurementMasterModel.getRequiPriorityName() != "") {
			s = s + "@p_reqiprioName='" + restProcurementMasterModel.getRequiPriorityName() + "',";
		}
		if (restProcurementMasterModel.getRequiPriorityDesc() != null
				|| restProcurementMasterModel.getRequiPriorityDesc() != "") {
			s = s + "@p_reqiprioDesc='" + restProcurementMasterModel.getRequiPriorityDesc() + "',";
		}

		if (restProcurementMasterModel.getRequiPriorityStatus() != null
				|| restProcurementMasterModel.getRequiPriorityStatus() != "") {
			s = s + "@p_reqiprioStatus='" + restProcurementMasterModel.getRequiPriorityStatus() + "',";
		}
		if (restProcurementMasterModel.getRequiPriorityCreatedBy() != null
				|| restProcurementMasterModel.getRequiPriorityCreatedBy() != "") {
			s = s + "@p_reqiprioCreatedBy='" + restProcurementMasterModel.getRequiPriorityCreatedBy() + "',";
		}
		if (restProcurementMasterModel.getOrg() != null || restProcurementMasterModel.getOrg() != "") {
			s = s + "@p_org='" + restProcurementMasterModel.getOrg() + "',";
		}
		if (restProcurementMasterModel.getOrgDiv() != null || restProcurementMasterModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + restProcurementMasterModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		} 
		return s;

	}

	public static String addPaymentTermParam(RestProcurementMasterModel restProcurementMasterModel) {

		String s = "";

		if (restProcurementMasterModel.getPaymentTermId() != null
				|| restProcurementMasterModel.getPaymentTermId() != "") {
			s = s + "@p_payTermId='" + restProcurementMasterModel.getPaymentTermId() + "',";
		}
		if (restProcurementMasterModel.getPaymentTermName() != null
				|| restProcurementMasterModel.getPaymentTermName() != "") {
			s = s + "@p_payTermName='" + restProcurementMasterModel.getPaymentTermName() + "',";
		}
		if (restProcurementMasterModel.getPaymentTermDesc() != null
				|| restProcurementMasterModel.getPaymentTermDesc() != "") {
			s = s + "@p_payTermDesc='" + restProcurementMasterModel.getPaymentTermDesc() + "',";
		}

		if (restProcurementMasterModel.getPaymentTermStatus() != null
				|| restProcurementMasterModel.getPaymentTermStatus() != "") {
			s = s + "@p_payTermStatus='" + restProcurementMasterModel.getPaymentTermStatus() + "',";
		}
		if (restProcurementMasterModel.getPaymentTermCreatedBy() != null
				|| restProcurementMasterModel.getPaymentTermCreatedBy() != "") {
			s = s + "@p_payTermCreatedBy='" + restProcurementMasterModel.getPaymentTermCreatedBy() + "',";
		}

		if (restProcurementMasterModel.getPaymentTermUpdatedBy() != null
				|| restProcurementMasterModel.getPaymentTermUpdatedBy() != "") {
			s = s + "@p_payTermUpdatedBy='" + restProcurementMasterModel.getPaymentTermUpdatedBy() + "',";
		}
		if (restProcurementMasterModel.getOrg() != null || restProcurementMasterModel.getOrg() != "") {
			s = s + "@p_org='" + restProcurementMasterModel.getOrg() + "',";
		}
		if (restProcurementMasterModel.getOrgDiv() != null || restProcurementMasterModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + restProcurementMasterModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		} 
		return s;

	}

	public static String addLegalTermParam(RestProcurementMasterModel restProcurementMasterModel) {

		String s = "";

		if (restProcurementMasterModel.getLegalTermId() != null || restProcurementMasterModel.getLegalTermId() != "") {
			s = s + "@p_LegalTermId='" + restProcurementMasterModel.getLegalTermId() + "',";
		}
		if (restProcurementMasterModel.getLegalTermName() != null
				|| restProcurementMasterModel.getLegalTermName() != "") {
			s = s + "@p_LegalTermName='" + restProcurementMasterModel.getLegalTermName() + "',";
		}
		if (restProcurementMasterModel.getLegalTermDesc() != null
				|| restProcurementMasterModel.getLegalTermDesc() != "") {
			s = s + "@p_LegalTermDesc='" + restProcurementMasterModel.getLegalTermDesc() + "',";
		}

		if (restProcurementMasterModel.getLegalTermStatus() != null
				|| restProcurementMasterModel.getLegalTermStatus() != "") {
			s = s + "@p_LegalTermStatus='" + restProcurementMasterModel.getLegalTermStatus() + "',";
		}
		if (restProcurementMasterModel.getLegalTermCreatedBy() != null
				|| restProcurementMasterModel.getLegalTermCreatedBy() != "") {
			s = s + "@p_LegalTermCreatedBy='" + restProcurementMasterModel.getLegalTermCreatedBy() + "',";
		}

		if (restProcurementMasterModel.getLegalTermUpdatedBy() != null
				|| restProcurementMasterModel.getLegalTermUpdatedBy() != "") {
			s = s + "@p_LegalTermUpdatedBy='" + restProcurementMasterModel.getLegalTermUpdatedBy() + "',";
		}
		if (restProcurementMasterModel.getOrg() != null || restProcurementMasterModel.getOrg() != "") {
			s = s + "@p_org='" + restProcurementMasterModel.getOrg() + "',";
		}
		if (restProcurementMasterModel.getOrgDiv() != null || restProcurementMasterModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + restProcurementMasterModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

	public static String addPaymentStatusParam(RestProcurementMasterModel restProcurementMasterModel) {

		String s = "";

		if (restProcurementMasterModel.getPaymentStatusId() != null
				|| restProcurementMasterModel.getPaymentStatusId() != "") {
			s = s + "@p_payStatusId='" + restProcurementMasterModel.getPaymentStatusId() + "',";
		}
		if (restProcurementMasterModel.getPaymentStatusName() != null
				|| restProcurementMasterModel.getPaymentStatusName() != "") {
			s = s + "@p_payStatusName='" + restProcurementMasterModel.getPaymentStatusName() + "',";
		}
		if (restProcurementMasterModel.getPaymentStatusDesc() != null
				|| restProcurementMasterModel.getPaymentStatusDesc() != "") {
			s = s + "@p_payStatusDesc='" + restProcurementMasterModel.getPaymentStatusDesc() + "',";
		}

		if (restProcurementMasterModel.getPaymentStatusStatus() != null
				|| restProcurementMasterModel.getPaymentStatusStatus() != "") {
			s = s + "@p_payStatusStatus='" + restProcurementMasterModel.getPaymentStatusStatus() + "',";
		}
		if (restProcurementMasterModel.getPaymentStatusCreatedBy() != null
				|| restProcurementMasterModel.getPaymentStatusCreatedBy() != "") {
			s = s + "@p_payStatusCreatedBy='" + restProcurementMasterModel.getPaymentStatusCreatedBy() + "',";
		}

		if (restProcurementMasterModel.getPaymentStatusUpdatedBy() != null
				|| restProcurementMasterModel.getPaymentStatusUpdatedBy() != "") {
			s = s + "@p_payStatusUpdatedBy='" + restProcurementMasterModel.getPaymentStatusUpdatedBy() + "',";
		}
		if (restProcurementMasterModel.getOrg() != null || restProcurementMasterModel.getOrg() != "") {
			s = s + "@p_org='" + restProcurementMasterModel.getOrg() + "',";
		}
		if (restProcurementMasterModel.getOrgDiv() != null || restProcurementMasterModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + restProcurementMasterModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

	public static String addDeliveryMethodParam(RestProcurementMasterModel restProcurementMasterModel) {

		String s = "";

		if (restProcurementMasterModel.getDeliveryMethodId() != null
				|| restProcurementMasterModel.getDeliveryMethodId() != "") {
			s = s + "@p_deliveryId='" + restProcurementMasterModel.getDeliveryMethodId() + "',";
		}
		if (restProcurementMasterModel.getDeliveryMethodName() != null
				|| restProcurementMasterModel.getDeliveryMethodName() != "") {
			s = s + "@p_deliveryName='" + restProcurementMasterModel.getDeliveryMethodName() + "',";
		}
		if (restProcurementMasterModel.getDeliveryMethodDesc() != null
				|| restProcurementMasterModel.getDeliveryMethodDesc() != "") {
			s = s + "@p_deliveryDesc='" + restProcurementMasterModel.getDeliveryMethodDesc() + "',";
		}

		if (restProcurementMasterModel.getDeliveryMethodStatus() != null
				|| restProcurementMasterModel.getDeliveryMethodStatus() != "") {
			s = s + "@p_deliveryStatus='" + restProcurementMasterModel.getDeliveryMethodStatus() + "',";
		}
		if (restProcurementMasterModel.getDeliveryMethodCreatedBy() != null
				|| restProcurementMasterModel.getDeliveryMethodCreatedBy() != "") {
			s = s + "@p_deliveryCreatedBy='" + restProcurementMasterModel.getDeliveryMethodCreatedBy() + "',";
		}

		if (restProcurementMasterModel.getDeliveryMethodUpdatedBy() != null
				|| restProcurementMasterModel.getDeliveryMethodUpdatedBy() != "") {
			s = s + "@p_deliveryUpdatedBy='" + restProcurementMasterModel.getDeliveryMethodUpdatedBy() + "',";
		}
		if (restProcurementMasterModel.getOrg() != null
				|| restProcurementMasterModel.getOrg() != "") {
			s = s + "@p_org='" + restProcurementMasterModel.getOrg() + "',";
		}
		if (restProcurementMasterModel.getOrgDiv() != null
				|| restProcurementMasterModel.getOrgDiv() != "") {
			s = s + "@p_orgDiv='" + restProcurementMasterModel.getOrgDiv() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

	/**
	 * generate for req type param
	 * 
	 * @param globalMasterRestModelList
	 * @return
	 */
	public static String getReqTypeCsvList(List<RestProcurementMasterModel> restProcurementMasterModelList) {

		String s = "";

		String asp = "";

		for (RestProcurementMasterModel a : restProcurementMasterModelList) {
			asp = asp + "(FN_MASTER_PK_GEN(\"Req_Type\")" + ",\"" + a.getRequisitionName() + "\",\""
					+ a.getRequisitionDesc() + "\"," + a.getRequisitionStatus() + ",\"" + a.getRequisitionCreatedBy()
					+ "\"),";
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_multipleInsertCountry='" + asp + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	/**
	 * generate for req type param
	 * 
	 * @param globalMasterRestModelList
	 * @return
	 */
	public static String getReqPrioTypeCsvList(List<RestProcurementMasterModel> restProcurementMasterModelList) {

		String s = "";

		String asp = "";

		for (RestProcurementMasterModel a : restProcurementMasterModelList) {
			asp = asp + "(FN_MASTER_PK_GEN(\"Req_Prio\")" + ",\"" + a.getRequisitionName() + "\",\""
					+ a.getRequisitionDesc() + "\"," + a.getRequisitionStatus() + ",\"" + a.getRequisitionCreatedBy()
					+ "\"),";
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_multipleInsertCountry='" + asp + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
	public static String getPaymentTermCsvList(List<RestProcurementMasterModel> restProcurementMasterModelList) {
		
		String s = "";
		
		String asp = "";
		
		for (RestProcurementMasterModel a : restProcurementMasterModelList) {
			asp = asp + "(FN_MASTER_PK_GEN(\"Payment_Term\")" + ",\"" + a.getRequisitionName() + "\",\""
					+ a.getRequisitionDesc() + "\"," + a.getRequisitionStatus() + ",\"" + a.getRequisitionCreatedBy()
					+ "\"),";
		}
		asp = asp.substring(0, asp.length() - 1);
		
		s = s + "@p_multipleInsertCountry='" + asp + "',";
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			
			s = "SET " + s + ";";
		}
		return s;
	}
	public static String getLegalTermCsvList(List<RestProcurementMasterModel> restProcurementMasterModelList) {
		
		String s = "";
		
		String asp = "";
		
		for (RestProcurementMasterModel a : restProcurementMasterModelList) {
			asp = asp + "(FN_MASTER_PK_GEN(\"Legal_Term\")" + ",\"" + a.getRequisitionName() + "\",\""
					+ a.getRequisitionDesc() + "\"," + a.getRequisitionStatus() + ",\"" + a.getRequisitionCreatedBy()
					+ "\"),";
		}
		asp = asp.substring(0, asp.length() - 1);
		
		s = s + "@p_multipleInsertCountry='" + asp + "',";
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			
			s = "SET " + s + ";";
		}
		return s;
	}
	
	public static String getMeasureTypeCsvList(List<RestProcurementMasterModel> restProcurementMasterModelList) {
		
		String s = "";
		
		String asp = "";
		
		for (RestProcurementMasterModel a : restProcurementMasterModelList) {
			asp = asp + "(FN_MASTER_PK_GEN(\"Measure_Type\")" + ",\"" + a.getMeasurementOrder() + "\",\""+ a.getMeasurementCode() + "\",\""
					+ a.getMeasurementName() + "\"," + a.getMeasurementStatus() + ",\"" + a.getMeasurementCreatedBy()
					+ "\"),";
		}
		asp = asp.substring(0, asp.length() - 1);
		
		s = s + "@p_multipleInsertCountry='" + asp + "',";
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			
			s = "SET " + s + ";";
		}
		return s;
	}
	
}
