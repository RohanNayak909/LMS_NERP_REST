package nirmalya.aatithya.restmodule.common.utils.grc;

import java.util.List;

import nirmalya.aatithya.restmodule.grc.model.AuditMasterRestModel;
import nirmalya.aatithya.restmodule.grc.model.AuditPlanRestModel;
import nirmalya.aatithya.restmodule.grc.model.AuditRecordRestModel;
import nirmalya.aatithya.restmodule.grc.model.AuditScheduleRestModel;
import nirmalya.aatithya.restmodule.grc.model.ScheduledAuditPlanRestModel;
import nirmalya.aatithya.restmodule.maintenance.model.AllotedMaintenanceRestModel;

public class GenerateAuditMasterParam {

	public static String getAddQuotParam(AuditMasterRestModel model) {
		String s = "";
			if (model.getAuditorId() != null && model.getAuditorId() != "") {
				s = s + "@p_auditid='" + model.getAuditorId() + "',";
			}
			if (model.getInspectionorId() != null && model.getInspectionorId() != "") {
				s = s + "@p_inspectionid='" + model.getInspectionorId() + "',";
			}
			if (model.getAuditTypeId() != null && model.getAuditTypeId() != "") {
				s = s + "@p_auditor_type='" + model.getAuditTypeId() + "',";
			}
			if (model.getAgencyId() != null && model.getAgencyId() != "") {
				s = s + "@p_auditor_agency='" + model.getAgencyId() + "',";
			}
			if (model.getAuditorName() != null && model.getAuditorName() != "") {
				s = s + "@p_auditor_name='" + model.getAuditorName() + "',";
			}
			if (model.getSpecialization() != null && model.getSpecialization() != "") {
				s = s + "@p_auditor_specialisation='" + model.getSpecialization() + "',";
			}
			if (model.getStartDate() != null && model.getStartDate() != "") {
				s = s + "@p_auditor_startDate='" + model.getStartDate() + "',";
			}
			if (model.getExperience() != null && model.getExperience() != "") {
				s = s + "@p_auditor_exp='" + model.getExperience() + "',";
			}
			if (model.getMobileno() != null && model.getMobileno() != "") {
				s = s + "@p_auditor_mobile='" + model.getMobileno() + "',";
			}			
			if (model.getEmail() != null && model.getEmail() != "") {
				s = s + "@p_auditor_email='" + model.getEmail() + "',";
			}
			if (model.getAddress() != null && model.getAddress() != "") {
				s = s + "@p_auditor_address='" + model.getAddress() + "',";
			}
			if (model.getUploadedBillDiv() != null && model.getUploadedBillDiv() != "") {
				s = s + "@p_auditor_attchment='" + model.getUploadedBillDiv() + "',";
			}
			if (model.getCreatedBy() != null && model.getCreatedBy() != "") {
				s = s + "@p_auditor_createdby='" + model.getCreatedBy() + "',";
			}
			if (model.getOrganizationName() != null && model.getOrganizationName() != "") {
				s = s + "@p_org='" + model.getOrganizationName() + "',";
			}
			if (model.getOrganizationDivision() != null && model.getOrganizationDivision() != "") {
				s = s + "@p_orgDiv='" + model.getOrganizationDivision() + "',";
			}

			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
			return s;
	}

	public static String getAddAuditCategoryParam(AuditMasterRestModel model) {
		String s = "";
		
			if (model.getAudit_category_id() != null && model.getAudit_category_id() != "") {
				s = s + "@p_audit_category_id='" + model.getAudit_category_id() + "',";
			}
			if (model.getAuditor_type() != null && model.getAuditor_type() != "") {
				s = s + "@p_auditor_type='" + model.getAuditor_type() + "',";
			}
			/*if (model.getAudit_category_code() != null && model.getAudit_category_code() != "") {
				s = s + "@p_audit_category_code='" + model.getAudit_category_code() + "',";
			}*/
			if (model.getAudit_category_name() != null && model.getAudit_category_name() != "") {
				s = s + "@p_audit_category_name='" + model.getAudit_category_name() + "',";
			}
			if (model.getAudit_category_objective() != null && model.getAudit_category_objective() != "") {
				s = s + "@p_audit_category_objective='" + model.getAudit_category_objective() + "',";
			}
			if (model.getAudit_category_status() != null && model.getAudit_category_status() != "") {
				s = s + "@p_audit_category_status='" + model.getAudit_category_status() + "',";
			}
			if (model.getCreatedBy() != null && model.getCreatedBy() != "") {
				s = s + "@p_audit_category_createdby='" + model.getCreatedBy() + "',";
			}
			if (model.getOrganizationName() != null && model.getOrganizationName() != "") {
				s = s + "@p_org='" + model.getOrganizationName() + "',";
			}
			if (model.getOrganizationDivision() != null && model.getOrganizationDivision() != "") {
				s = s + "@p_orgDiv='" + model.getOrganizationDivision() + "',";
			}
			
			if (s != "") {
				s = s.substring(0, s.length() - 1);

				s = "SET " + s + ";";
			}
		return s;
	}

	public static String getAddAuditPlanParam(List<AuditPlanRestModel> ap) {
		String s = ""; 	
		String sitem = "";
			if (ap.get(0).getPlanId() != null && ap.get(0).getPlanId() != "") {
				s = s + "@p_planId='" + ap.get(0).getPlanId() + "',";
			}
			if (ap.get(0).getAuditTypeId() != null && ap.get(0).getAuditTypeId() != "") {
				s = s + "@p_auditTypeId='" + ap.get(0).getAuditTypeId() + "',";
			} 
			if (ap.get(0).getCatid() != null && ap.get(0).getCatid() != "") {
				s = s + "@p_catId='" + ap.get(0).getCatid() + "',";
			} 
			if (ap.get(0).getAuditLocation() != null && ap.get(0).getAuditLocation() != "") {
				s = s + "@p_auditLocation='" + ap.get(0).getAuditLocation() + "',";
			} 
			if (ap.get(0).getStartDate() != null && ap.get(0).getStartDate() != "") {
				s = s + "@p_startDate='" + ap.get(0).getStartDate() + "',";
			} 
			if (ap.get(0).getEndDate() != null && ap.get(0).getEndDate() != "") {
				s = s + "@p_endDate='" + ap.get(0).getEndDate() + "',";
			} 
			if (ap.get(0).getFrequency() != null && ap.get(0).getFrequency() != "") {
				s = s + "@p_frequency='" + ap.get(0).getFrequency() + "',";
			}
			if (ap.get(0).getAssignDate() != null && ap.get(0).getAssignDate() != "") {
				s = s + "@p_assignDate='" + ap.get(0).getAssignDate() + "',";
			}
			if (ap.get(0).getRemark() != null && ap.get(0).getRemark() != "") {
				s = s + "@p_remark=\"" + ap.get(0).getRemark().replace("'", "\\'") + "\",";
			}
			if (ap.get(0).getCreatedBy() != null && ap.get(0).getCreatedBy() != "") {
				s = s + "@p_createdBy='" + ap.get(0).getCreatedBy() + "',";
			}
			if (ap.get(0).getOrganization() != null && ap.get(0).getOrganization() != "") {
				s = s + "@p_org='" + ap.get(0).getOrganization() + "',";
			}
			if (ap.get(0).getOrgDivision() != null && ap.get(0).getOrgDivision() != "") {
				s = s + "@p_orgDiv='" + ap.get(0).getOrgDivision() + "',";
			}
			
			/*
			 * for (AuditPlanRestModel m : ap.get(0).getCheckList()) { sitem = sitem +
			 * "(@p_planId,\"" + m.getTaskName() + "\",\"" + m.getTaskPriority() + "\",\"" +
			 * m.getTaskDescription().replace("'", "\\'") + "\",\"" + m.getRecord() +
			 * "\",\"" + m.getReference() + "\",@p_org,@p_orgDiv),"; } sitem =
			 * sitem.substring(0, sitem.length() - 1);
			 * 
			 * s = s + "@p_itemSubQuery='" + sitem + "',"; if (s != "") { s = s.substring(0,
			 * s.length() - 1);
			 * 
			 * s = "SET " + s + ";"; }
			 */
			
			for (AuditPlanRestModel m : ap.get(0).getCheckList()) {
			    sitem = sitem + "(@p_planId,\"" + m.getTaskName() + "\",\"" + m.getTaskType() + "\",\"" 
			                  + m.getTaskPriority() + "\",\"" + m.getTaskDescription().replace("'", "\\'") + "\",\"" 
			                  + m.getTaskUOM() + "\",\"" + m.getMinRange() + "\",\"" + m.getMaxRange() + "\",@p_org,@p_orgDiv),";
			}
			sitem = sitem.substring(0, sitem.length() - 1); 
			s = s + "@p_itemSubQuery='" + sitem + "',";
			if (!s.isEmpty()) {
			    s = s.substring(0, s.length() - 1); 
			    s = "SET " + s + ";";
			}
		return s;
	}

	public static String getAddAuditScheduleParam(AuditScheduleRestModel model) {
		String s = ""; 		
			if (model.getAuditScheduleId() != null && model.getAuditScheduleId() != "") {
				s = s + "@p_auditScheduleId='" + model.getAuditScheduleId() + "',";
			}
			if (model.getPlanId() != null && model.getPlanId() != "") {
				s = s + "@p_planId='" + model.getPlanId() + "',";
			} 
			if (model.getAuditType() != null && model.getAuditType() != "") {
				s = s + "@p_auditType='" + model.getAuditType() + "',";
			}
			if (model.getAuditCategory() != null && model.getAuditCategory() != "") {
				s = s + "@p_auditCategory='" + model.getAuditCategory() + "',";
			}
			if (model.getAuditLocation() != null && model.getAuditLocation() != "") {
				s = s + "@p_auditLocation='" + model.getAuditLocation() + "',";
			}
			if (model.getAuditorId() != null && model.getAuditorId() != "") {
				s = s + "@p_auditorId='" + model.getAuditorId() + "',";
			}
			if (model.getAgencyAuditorName() != null && model.getAgencyAuditorName() != "") {
				s = s + "@p_agencyAuditorName='" + model.getAgencyAuditorName() + "',";
			}
			if (model.getAssigndate() != null && model.getAssigndate() != "") {
				s = s + "@p_assigndate='" + model.getAssigndate() + "',";
			}
			if (model.getAuditFrequency() != null && model.getAuditFrequency() != "") {
				s = s + "@p_auditFrequency='" + model.getAuditFrequency() + "',";
			}
			if (model.getCreatedBy() != null && model.getCreatedBy() != "") {
				s = s + "@p_createdBy='" + model.getCreatedBy() + "',";
			}
			if (model.getOrganization() != null && model.getOrganization() != "") {
				s = s + "@p_org='" + model.getOrganization() + "',";
			}
			if (model.getOrgDivision() != null && model.getOrgDivision() != "") {
				s = s + "@p_orgDiv='" + model.getOrgDivision() + "',";
			}
			
			if (s != "") {
				s = s.substring(0, s.length() - 1);
	
				s = "SET " + s + ";";
			}
		return s;
	}

	public static String getScheduleAuditProgressList(List<ScheduledAuditPlanRestModel> sap) {
		String s = ""; 		
		String sitem = ""; 		
		    if (sap.get(0).getScheduledId() != null && sap.get(0).getScheduledId() != "") {
				s = s + "@p_scheduledId='" + sap.get(0).getScheduledId() + "',";
			}
			if (sap.get(0).getPlanId() != null && sap.get(0).getPlanId() != "") {
				s = s + "@p_planId='" + sap.get(0).getPlanId() + "',";
			} 
			if (sap.get(0).getTaskName() != null && sap.get(0).getTaskName() != "") {
				s = s + "@p_taskName='" + sap.get(0).getTaskName() + "',";
			}
			if (sap.get(0).getTaskType() != null && sap.get(0).getTaskType() != "") {
				s = s + "@p_taskType='" + sap.get(0).getTaskType() + "',";
			}
			if (sap.get(0).getTaskPriority() != null && sap.get(0).getTaskPriority() != "") {
				s = s + "@p_taskPriority='" + sap.get(0).getTaskPriority() + "',";
			}
			if (sap.get(0).getDescription() != null && sap.get(0).getDescription() != "") {
				s = s + "@p_description='" + sap.get(0).getDescription() + "',";
			}
			if (sap.get(0).getStatus() != null && sap.get(0).getStatus() != "") {
				s = s + "@p_status='" + sap.get(0).getStatus() + "',";
			}
			if (sap.get(0).getTaskUom() != null && sap.get(0).getTaskUom() != "") {
				s = s + "@p_taskUom='" + sap.get(0).getTaskUom() + "',";
			}
			if (sap.get(0).getMaxRange() != null && sap.get(0).getMaxRange() != "") {
				s = s + "@p_maxRange='" + sap.get(0).getMaxRange() + "',";
			} 
			if (sap.get(0).getMinRange() != null && sap.get(0).getMinRange() != "") {
				s = s + "@p_minRange='" + sap.get(0).getMinRange() + "',";
			} 
			if (sap.get(0).getCreatedBy() != null && sap.get(0).getCreatedBy() != "") {
				s = s + "@p_createdBy='" + sap.get(0).getCreatedBy() + "',";
			}
			if (sap.get(0).getResult() != null && sap.get(0).getResult() != "") {
				s = s + "@p_result='" + sap.get(0).getResult() + "',";
			}
			if (sap.get(0).getOrgName() != null && sap.get(0).getOrgName() != "") {
				s = s + "@p_orgName='" + sap.get(0).getOrgName() + "',";
			}
			if (sap.get(0).getOrgDivision() != null && sap.get(0).getOrgDivision() != "") {
				s = s + "@p_orgDivision='" + sap.get(0).getOrgDivision() + "',";
			}
			if (sap.get(0).getDocumentUrl() != null && sap.get(0).getDocumentUrl() != "") {
				s = s + "@p_documentUrl='" + sap.get(0).getDocumentUrl() + "',";
			}
			if (sap.get(0).getInstanceId() != null && sap.get(0).getInstanceId() != "") {
				s = s + "@p_instanceId='" + sap.get(0).getInstanceId() + "',";
			}
			
			
				 
			for (ScheduledAuditPlanRestModel m : sap) {

				sitem = sitem + "(@p_scheduledId,\"" + m.getPlanId() + "\",\"" + m.getTaskName() + "\",\"" + m.getTaskType()+ "\",\"" + m.getTaskPriority() + "\",\"" + m.getStatus() + "\",\"" + m.getDescription()+ "\",\"" + m.getDate()+ "\",\""+ m.getTaskUom()+ "\",\""+ m.getRecord()+ "\",\""+ m.getReference()+ "\",\"" + m.getCreatedBy() + "\",\""+ m.getResult() + "\",\"" + m.getOrgName() + "\",\"" + m.getOrgDivision()
				+ "\",\""+ m.getDocumentUrl()+ "\",\""+ m.getInstanceId()+ "\",\""+ m.getRemark()+ "\",\""+ m.getActionPlan()+ "\"),";
			}
			sitem = sitem.substring(0, sitem.length() - 1);
			
			
			if (s != "") {
				s = s.substring(0, s.length() - 1);
	
				s = "SET " + s + ",@p_itemSubQuery='" + sitem +"';";
			}
		return s;
	}
	
	
	public static String getScheduleReviewed(List<ScheduledAuditPlanRestModel> sap) {
		String s = ""; 				
		    if (sap.get(0).getScheduledId() != null && sap.get(0).getScheduledId() != "") {
				s = s + "@p_scheduledId='" + sap.get(0).getScheduledId() + "',";
			}
			if (sap.get(0).getCreatedBy() != null && sap.get(0).getCreatedBy() != "") {
				s = s + "@p_createdBy='" + sap.get(0).getCreatedBy() + "',";
			}
			if (sap.get(0).getResult() != null && sap.get(0).getResult() != "") {
				s = s + "@p_result='" + sap.get(0).getResult() + "',";
			}
			if (sap.get(0).getOrgName() != null && sap.get(0).getOrgName() != "") {
				s = s + "@p_orgName='" + sap.get(0).getOrgName() + "',";
			}
			if (sap.get(0).getOrgDivision() != null && sap.get(0).getOrgDivision() != "") {
				s = s + "@p_orgDivision='" + sap.get(0).getOrgDivision() + "',";
			}
			if (sap.get(0).getInstanceId() != null && sap.get(0).getInstanceId() != "") {
				s = s + "@p_instanceId='" + sap.get(0).getInstanceId() + "',";
			}
			if (sap.get(0).getRemark() != null && sap.get(0).getRemark() != "") {
				s = s + "@p_remarks='" + sap.get(0).getRemark() + "',";
			}
				 
			
			if (s != "") {
				s = s.substring(0, s.length() - 1);
	
				s = "SET " + s +";";
			}
		return s;
	}

}
