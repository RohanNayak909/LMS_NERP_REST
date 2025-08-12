/**
 *  Defines the dummy entity  for Stored Procedure. 
 */
package nirmalya.aatithya.restmodule.common;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity

@NamedStoredProcedureQueries({
	
	@NamedStoredProcedureQuery(name = "blogs_report_routines", procedureName = "blogs_report_routines", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
	
	@NamedStoredProcedureQuery(name = "announcement_feedback_routines", procedureName = "announcement_feedback_routines", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
	
	@NamedStoredProcedureQuery(name = "coupon_management_Routines", procedureName = "coupon_management_Routines", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
	
	@NamedStoredProcedureQuery(name = "hrms_report_Routines", procedureName = "hrms_report_Routines", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * @NamedStoredProcedureQuery(name = "hrms_report_Routines", procedureName =
		 * "hrms_report_Routines", parameters = {
		 * 
		 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type
		 * = String.class),
		 * 
		 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type
		 * = String.class) }),
		 */

		@NamedStoredProcedureQuery(name = "scheduler_API_Routines", procedureName = "scheduler_API_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "requisitionReviewProcess", procedureName = "hrm_RequistionReviewRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "grc_dca_monitoring_report_routines", procedureName = "grc_dca_monitoring_report_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "grc_noise_monitoring_report_routines", procedureName = "grc_noise_monitoring_report_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "electricalReportRoutines", procedureName = "electricalReportRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "mechanical_report_routines", procedureName = "mechanical_report_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "utility_report_routines", procedureName = "utility_report_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = ProcedureNameConstants.Horlicks_Analysis_Routines, procedureName = "Horlicks_Analysis_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "logbook_management_Routines", procedureName = "logbook_management_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "hrmManagePolicy", procedureName = "hrm_manage_policy_notice", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "masterEntryPass", procedureName = "master_entry_pass", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "communicationMasterRoutines", procedureName = "communication_MasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "workPermitRoutines", procedureName = "workPermitRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "gatepassStaffregRoutines", procedureName = "gatepass_staff_reg_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "manageTrainingRoutines", procedureName = "hrm_ManageTrainingRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "nerp_production_orderSchedulingRoutines", procedureName = "nerp_production_orderSchedulingRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "nerp_production_patternRoutines", procedureName = "nerp_production_patternRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "nerp_production_moldRoutines", procedureName = "nerp_production_moldRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "shoukeen_dealer", procedureName = "shoukeen_dealerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// Over Time
		@NamedStoredProcedureQuery(name = "hrms_employee_overtimeRoutines", procedureName = "hrms_employee_overtimeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// Tax Declartion
		@NamedStoredProcedureQuery(name = "taxDeclaration", procedureName = "employee_tax_declaration_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// Weekoff
		@NamedStoredProcedureQuery(name = "shiftScheduleApiRoutine", procedureName = "shiftScheduleApi_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// event Dashboard
		@NamedStoredProcedureQuery(name = "dashboardEventRoutines", procedureName = "dashboardEvent_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "viewApprovalApi", procedureName = "hrms_viewApprovalApi", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "viewEmployeeReports", procedureName = "hrms_View_Employee_Report", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "gatePass_Routines", procedureName = "GatePass_Routiness", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * investmentRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "employeeassetassign", procedureName = "employee_asset_assign_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "insuranceAndNominee", procedureName = "hrms_insuranceAndNominee", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "crm_TaskApi_Details", procedureName = "crm_TaskApi_Details", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "crm_MeetingApi_Details", procedureName = "crm_MeetingApi_Details", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "crm_CallApi_Details", procedureName = "crm_CallApi_Details", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "crm_Client_Routines", procedureName = "crm_Client_Details", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "crm_dealFinal_Details", procedureName = "crm_dealFinal_Details", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "crm_classified_Billing", procedureName = "crm_classified_Billing", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Asset Assign routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "investmentRoutines", procedureName = "investment_declaration_details", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * resignation routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "resignationRoutines", procedureName = "resignation_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// procedures for mobile api
		/*
		 * * for login routines
		 */
		@NamedStoredProcedureQuery(name = "loginRestApi", procedureName = "user_login_rest_api_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "check_userid_exist", procedureName = "check_userid_exist", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "change_password", procedureName = "check_userid_exist", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "getUserAttendance", procedureName = "check_userid_exist", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "get_password", procedureName = "check_userid_exist", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class) }),

		@NamedStoredProcedureQuery(name = "Add_Attendance", procedureName = "check_userid_exist", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "Update_Attendance", procedureName = "check_userid_exist", parameters = {

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),

				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "vendorPoRoutines", procedureName = "inventory_vendor_po_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for REFERENCE__INCOMETAX
		 * 
		 */
		@NamedStoredProcedureQuery(name = "PayrollTaxCatagory", procedureName = "income_tax_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * FOR GROW MASTER ROUTINES
		 */
		@NamedStoredProcedureQuery(name = "hrmsGrowGoalAssign", procedureName = "hrms_grow_goalAssign", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "hrmsGrowSelfAppraisal", procedureName = "hrms_grow_selfAppraisal", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "hrmsGrowReview", procedureName = "hrms_grow_reviewRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "hrmsGrowfeedback", procedureName = "hrms_grow_feedbackRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "hrmsGrowOneToOne", procedureName = "hrms_grow_onetooneRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "hrmsGrowUpdate", procedureName = "hrms_grow_updateRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * masterOrgTypeRoutines Stored Procedure
		 */

		@NamedStoredProcedureQuery(name = "masterOrgTypeRoutines", procedureName = "masterOrgTypeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * masterOrgholidaysRoutines Stored Procedure
		 */

		@NamedStoredProcedureQuery(name = "masterOrgHolidaysRoutines", procedureName = "masterOrgHolidaysRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// Announcement Add

		@NamedStoredProcedureQuery(name = "masterAnnouncementRoutines", procedureName = "masterAnnouncementRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// emp shift details

		@NamedStoredProcedureQuery(name = "hrmsemployeeShiftScheduling", procedureName = "hrms_employee_shift_scheduling", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// Leave Policy Add

		@NamedStoredProcedureQuery(name = "masterLeavePolicyRoutines", procedureName = "masterLeavePolicyRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * organiserMaster
		 */
		@NamedStoredProcedureQuery(name = "organiserMasterRoutinesModel", procedureName = "organiserMasterRoutinesModel", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// quotation purchase

		@NamedStoredProcedureQuery(name = "QuotationDetails", procedureName = "Purchase_Quotation_Details", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Attendance Manage
		 */
		@NamedStoredProcedureQuery(name = "attendenceEmployeeRoutines", procedureName = "attendance_Type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * account section payment
		 * 
		 */
		@NamedStoredProcedureQuery(name = "hrmsaccountsectionroutines", procedureName = "hrms_Accountant_Section_PaymentDetails", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * account reports Soumya
		 * 
		 */

		@NamedStoredProcedureQuery(name = "account_reports_routines", procedureName = "account_reports_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * GST
		 * 
		 */
		@NamedStoredProcedureQuery(name = "gstReturnRoutines", procedureName = "gst_return_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * FOR HIRE ACTION ROUTINES
		 */
		@NamedStoredProcedureQuery(name = "hireActionRoutines", procedureName = "hrm_hireActionRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * FOR PROJECT MASTER ROUTINES
		 */
		@NamedStoredProcedureQuery(name = "ProjectsRoutines", procedureName = "hrm_projectsRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * * for kitchen manager routines
		 */
		@NamedStoredProcedureQuery(name = "kitchenApiRoutines", procedureName = "user_kitchen_api_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * * for kitchen staff routines
		 */
		@NamedStoredProcedureQuery(name = "kitchenApiStaffRoutines", procedureName = "user_kitchen_staff_api_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * FOR CANDIDATE MASTER ROUTINES
		 */
		@NamedStoredProcedureQuery(name = "candidateRoutines", procedureName = "hrm_candidateMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * * for menu item routines
		 */
		@NamedStoredProcedureQuery(name = "menuItem", procedureName = "user_menu_api_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * * for restaurant manager api routines
		 */
		@NamedStoredProcedureQuery(name = "restaurantManager", procedureName = "restaurant_manager_api_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "designationMaster", procedureName = "designationMaster", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// Department

		@NamedStoredProcedureQuery(name = "hrdepartmentMaster", procedureName = "hr_department_Master", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * bankadd Stored Procedure
		 */

		@NamedStoredProcedureQuery(name = "masterBankRoutines", procedureName = "masterBankRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * * for restaurant staff api routines
		 */
		@NamedStoredProcedureQuery(name = "restaurantStaff", procedureName = "restaurant_staff_api_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "userRoutines", procedureName = "user_userRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user Type Procedure definition for user type
		 */
		@NamedStoredProcedureQuery(name = "UserType", procedureName = "user_typeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "EmployeeroleRoutines", procedureName = "Employee_EmployeeFeedBackRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		//// deputization

		@NamedStoredProcedureQuery(name = "DeputizationRoutine", procedureName = "hrms_DeputizationRoutine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user_prefixManagementRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "userPrefixManagementRoutines", procedureName = "user_prefixManagementRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * sacCodeRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "sacCodeRoutines", procedureName = "user_sacCodeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user_ManageRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "userManageRoutines", procedureName = "user_ManageRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * user_processRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "processRoutines", procedureName = "user_processRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "customermaster", procedureName = "customer_masterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "quotationmasterRotines", procedureName = "quotation_masterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "salesPurchaseOrder", procedureName = "sales_purchase_order_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "salesOrderNew", procedureName = "sales_ordernew_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "salesInvoiceNew", procedureName = "sales_InvoiceNew_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "salesDeliveryChallanNew", procedureName = "sales_DeliveryChallan_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "salesPackagesNew", procedureName = "sales_packagenew_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "salesShipmentsNew", procedureName = "sales_shipment_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "salesPaymentreceivedRotines", procedureName = "sales_payment_received_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "salesReturn", procedureName = "sales_return_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "view_debitNoteData_Routines", procedureName = "view_debitNoteData_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "salesRefund", procedureName = "sales_refund_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "salesRepalcement", procedureName = "sales_replacement_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "salesInvoiceReturnNew", procedureName = "sales_InvoiceReturnNew_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "EmployeeWorkLocation", procedureName = "Employee_Work_Location", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user_guestDetailRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "guestRoutines", procedureName = "master_guestDetailRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * PropertyDashboardRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "PropertyDashboardRoutines", procedureName = "property_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * property_assignmentOfpropertyToStaff Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "assignPropertyToStaffRoutines", procedureName = "property_assignmentOfpropertyToStaff", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * property reservation Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "propertyReservation", procedureName = "property_reservationRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * comparePropertyRoutines Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "comparePropertyRoutines", procedureName = "user_comparePropertyRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * user_stateRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "stateRoutines", procedureName = "user_stateRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * userroleRoutines Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "userroleRoutines", procedureName = "user_userroleRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user rating Stored Procedure definition for user set authority
		 */
		@NamedStoredProcedureQuery(name = "UserSetAuthority", procedureName = "user_setauthorityRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user Authority dropdownRoutines Stored Procedure definition for user set
		 * authority drop down
		 */
		@NamedStoredProcedureQuery(name = "userAuthoritydropdown", procedureName = "user_authoritydropdownRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * user ApprovalAction Stored Procedure definition for user set authority drop
		 * down
		 */
		@NamedStoredProcedureQuery(name = "ApprovalAction", procedureName = "user_ApprovalAction", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user_districtRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "districtRoutines", procedureName = "user_districtRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * property category Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "propertyCategory", procedureName = "property_categoryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// property_assignAssetToStaffRoutines
		@NamedStoredProcedureQuery(name = "assignAssetToStaffRoutines", procedureName = "property_assignAssetToStaffRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * assignedConsumeItemsRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "assignedConsumeItemsRoutines", procedureName = "property_assignedConsumeItemsRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Property transaction routine Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "propertyTransactionRoutines", procedureName = "property_transactionRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * property master Stored Procedure definition for dropdown
		 */
		@NamedStoredProcedureQuery(name = "propertyMasterDropDown", procedureName = "property_masterDropdownRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user rating Stored Procedure definition for payment mode
		 */
		@NamedStoredProcedureQuery(name = "paymentModeRoutines", procedureName = "master_paymentModeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * user rating Stored Procedure definition for Account Group Master
		 */
		@NamedStoredProcedureQuery(name = "accountGroupRoutines", procedureName = "master_accGroupRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * propBookTypeRoutines Stored Procedure definition for dropdown
		 */
		@NamedStoredProcedureQuery(name = "propBookTypeRoutines", procedureName = "property_propBookTypeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * property master Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "propertyMaster", procedureName = "property_masterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * asset code drop down property Stored Procedure definition for drop down
		 */
		@NamedStoredProcedureQuery(name = "getItemName", procedureName = "property_assetcodedropdownRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// mano
		@NamedStoredProcedureQuery(name = "addPropertyType", procedureName = "property_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "getPropertyName", procedureName = "property_amenityRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "assetDashBoard", procedureName = "asset_dashBoard_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * @NamedStoredProcedureQuery( name = "add_Amenity", procedureName =
		 * "propert_Amenity_Routines", parameters = {
		 * 
		 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type
		 * = String.class),
		 * 
		 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type
		 * = String.class) }
		 * 
		 * ),
		 */

		@NamedStoredProcedureQuery(name = "add_Amenity", procedureName = "property_amenityRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * For Amenity Item
		 */
		@NamedStoredProcedureQuery(name = "AmenityItem", procedureName = "property_amenityItemRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// mano

		/**
		 * property Theme Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "propertyTheme", procedureName = "property_themeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * sitting plan Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "SittingPlan", procedureName = "property_seatingPlanRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * For Assignment of Seating Plan
		 */
		@NamedStoredProcedureQuery(name = "AssignmentOfSeatingPlan", procedureName = "property_assignmentOfSeatingPlan", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * property floor Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "propertyFloorRoutines", procedureName = "property_floorRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * property booking Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "propertyBooking", procedureName = "property_bookingRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * property booking Stored Procedure definition for dropdown
		 */
		@NamedStoredProcedureQuery(name = "propertyBookingDropDown", procedureName = "property_bookingDropdownRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * property hotel Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "hotelRoutines", procedureName = "property_hotelRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * hotel drop down property Stored Procedure definition for drop down
		 */
		@NamedStoredProcedureQuery(name = "hoteldropdownRoutines", procedureName = "property_hoteldropdownRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Maintenance Work order Dashboard routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "MaintenanceDashboardRoutines", procedureName = "maintenance_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * Maintenance Work order routine Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "maintenanceWorkOrderRoutines", procedureName = "maintenance_workOrderRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * maintenance_taskRoutines Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "maintenancetaskRoutines", procedureName = "maintenance_taskRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Maintenance_propertyTaskAssignRoutines Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "propertyTaskAssignRoutines", procedureName = "Maintenance_propertyTaskAssignRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * maintenance_AssignTaskToStaffRoutines Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "maintenanceAssignTaskToStaffRoutines", procedureName = "maintenance_AssignTaskToStaffRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * maintenance_MaidPropertyTaskAssignRoutines Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "maintenanceMaidPropertyTaskAssign", procedureName = "maintenance_MaidPropertyTaskAssign", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Request Quotation Routines for Select Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "reqSelectRFQRoutines", procedureName = "inventory_reqSelectRFQRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Request Quotation Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "requestQuotRoutines", procedureName = "inventory_requestQuotRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * RFQ Dlts Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "invRFQDtlsRoutines", procedureName = "inventory_rfqDtlstRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * RFQ PO Dlts Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "invPORFQDtlsRoutines", procedureName = "inventory_rfqPODtlstRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * inventoryItemCategoryRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "InventoryDashboardRoutines", procedureName = "inventory_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * inventory_inventoryStoreRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "inventoryStoreRoutines", procedureName = "inventory_inventoryStoreRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * inventoryItemCategoryRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "inventoryItemCategoryRoutines", procedureName = "inventory_inventoryItemCategoryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * inventoryItemSubCategoryRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "itemSubCatRoutines", procedureName = "inventory_itemSubCatRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * inventoryItemRoutines Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "inventoryItemRoutines", procedureName = "inventory_inventoryItemRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * inventoryItemServeTypeRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "itemServeTypeRoutines", procedureName = "inventory_itemServeTypeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * inventoryCostCenterRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "manageCostcenter", procedureName = "manage_costcenter", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * inventoryItemRequisitionRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "inventoryItemRequisitionRoutines", procedureName = "inventory_inventoryItemRequisitionRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * inventoryVendorRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "inventoryVendorRoutines", procedureName = "inventory_inventoryVendorRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * inventoryPurchaseOrderRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "inventoryPurchaseOrderRoutines", procedureName = "inventory_inventoryPurchaseOrderRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * inventorygoodsReturnInvoiceRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "goodsReceiveInvoiceRoutines", procedureName = "inventory_goodsReceiveInvoiceRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * Inventory goods return routine Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "inventoryGoodsReturnRoutines", procedureName = "inventory_goodsReturnRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * inventoryPurchaseOrderRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "inventoryIssueNoteRoutines", procedureName = "inventory_inventoryIssueNoteRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// master_acvtivityMasterRoutines
		@NamedStoredProcedureQuery(name = "activityRoutines", procedureName = "master_acvtivityMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// master_functionMasterRoutines
		@NamedStoredProcedureQuery(name = "functionRoutines", procedureName = "master_functionMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// master_moduleMasterRoutines
		@NamedStoredProcedureQuery(name = "moduleRoutines", procedureName = "master_moduleMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * housekeeping dashboard
		 */
		@NamedStoredProcedureQuery(name = "HousekeepingDashboardRoutines", procedureName = "housekeeping_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * housekeeping_taskRoutines
		 */
		@NamedStoredProcedureQuery(name = "taskRoutinesMaster", procedureName = "housekeeping_taskRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * housekeeping_taskRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "taskRoutines", procedureName = "housekeeping_propertyTaskRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * housekeeping_AssignStaffRoutines
		 */
		@NamedStoredProcedureQuery(name = "AssignStaffRoutines", procedureName = "housekeeping_AssignStaffRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * housekeeping_MaidPropertyTask
		 */

		@NamedStoredProcedureQuery(name = "MaidPropertyTask", procedureName = "housekeeping_MaidPropertyTask", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// DashBoard
		@NamedStoredProcedureQuery(name = "ProcurementDashboardRoutines", procedureName = "procurement_execute_Dashboard_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * housekeeping_maidTaskAssignRoutines
		 */
		@NamedStoredProcedureQuery(name = "maidTaskAssignRoutines", procedureName = "housekeeping_maidTaskAssignRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * housekeeping_guestConsumeRoutines
		 */
		@NamedStoredProcedureQuery(name = "guestConsumeRoutines", procedureName = "roomservice_guestConsumeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * assignKitchenToRestaurantRoutines
		 */

		@NamedStoredProcedureQuery(name = "assignKitchenToRestaurantRoutines", procedureName = "kitchen_assignKitchenToRestaurantRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * kitchen_foodOrderListRoutines
		 */
		@NamedStoredProcedureQuery(name = "foodOrderListRoutines", procedureName = "kitchen_foodOrderListRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * kitchen_kitchenManagerRoutines
		 */
		@NamedStoredProcedureQuery(name = "kitchenManagerRoutines", procedureName = "kitchen_kitchenManagerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * gym_lockermasterRoutines
		 */
		@NamedStoredProcedureQuery(name = "lockerRoutines", procedureName = "gym_lockermasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * gym_assign_lockerRoutines
		 */
		@NamedStoredProcedureQuery(name = "assignLocker", procedureName = "gym_assign_lockerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * gym_transaction_Routines
		 */
		@NamedStoredProcedureQuery(name = "gymTransaction", procedureName = "gym_transaction_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * roomservice_roomServiceTask
		 */
		@NamedStoredProcedureQuery(name = "roomServiceRoutines", procedureName = "roomservice_roomServiceTask", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * roomservice_RoomServiceTaskAssigned
		 */
		@NamedStoredProcedureQuery(name = "roomTaskAssignRoutines", procedureName = "roomservice_RoomServiceTaskAssigned", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * other_service_masterRoutines
		 */
		@NamedStoredProcedureQuery(name = "otherServiceRoutines", procedureName = "other_service_masterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * other_service_PriceRoutines
		 */
		@NamedStoredProcedureQuery(name = "otherServicePriceRoutines", procedureName = "other_service_PriceRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * routine Stored Procedure memberMstrRoutines
		 */
		@NamedStoredProcedureQuery(name = "memberMstrRoutines", procedureName = "user_memberMstrRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * routine Stored Procedure member registration
		 */
		@NamedStoredProcedureQuery(name = "userMemRegRoutines", procedureName = "user_userMemRegRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * routine Stored Procedure parking_resrveParkingRoutines
		 */
		@NamedStoredProcedureQuery(name = "resrveParkingRoutines", procedureName = "parking_resrveParkingRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * routine Stored Procedure parking_vehicleTypeRoutines
		 */
		@NamedStoredProcedureQuery(name = "vehicleTypeRoutines", procedureName = "parking_vehicleTypeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * routine Stored Procedure parking_parkingCapacityRoutines
		 */
		@NamedStoredProcedureQuery(name = "parkingCapacityRoutines", procedureName = "parking_parkingCapacityRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * routine Stored Procedure parking_entryVehicleRoutines
		 */
		@NamedStoredProcedureQuery(name = "entryVehicleRoutines", procedureName = "parking_entryVehicleRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * routine Stored Procedure parking_dashboardRoutines
		 */
		@NamedStoredProcedureQuery(name = "dashboardRoutines", procedureName = "parking_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * routine Stored Procedure sales_salesCustomerRoutines
		 */
		@NamedStoredProcedureQuery(name = "salesCustomerRoutines", procedureName = "sales_salesCustomerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * routine Stored Procedure sales_quotationRotines
		 */
		@NamedStoredProcedureQuery(name = "quotationRotines", procedureName = "sales_quotationRotines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * routine Stored Procedure sales_salesInvoiceRoutiness
		 */
		@NamedStoredProcedureQuery(name = "salesInvoiceRoutiness", procedureName = "sales_salesInvoiceRoutiness", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * master_masterCountryRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "masterCountryRoutines", procedureName = "master_masterCountryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * routine Stored Procedure sales_saleDashboardone
		 */
		@NamedStoredProcedureQuery(name = "salesDashboardoneRoutiness", procedureName = "sale_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * routine Stored Procedure account_bankRoutines
		 */
		@NamedStoredProcedureQuery(name = "AccountBankRoutines", procedureName = "account_bankRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * routine Stored Procedure account_bankBranchRoutines
		 */
		@NamedStoredProcedureQuery(name = "AccountBankBranchRoutines", procedureName = "account_bankBranchRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * routine Stored Procedure account_bankAccountRoutines
		 */
		@NamedStoredProcedureQuery(name = "AccountBankAccountRoutines", procedureName = "account_bankAccountRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "account_dashboard_Routines", procedureName = "account_dashboard_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "account_dashboard_af_Routines", procedureName = "account_dashboard_af_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "account_dashboard_bs_Routines", procedureName = "account_dashboard_bs_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "account_dashboard_per_Routines", procedureName = "account_dashboard_per_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "account_dashboard_Sub_Routines", procedureName = "account_dashboard_Sub_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "account_dashboard_pl_Routines", procedureName = "account_dashboard_pl_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * routine Stored Procedure account_Account LedgerRoutines
		 */
		@NamedStoredProcedureQuery(name = "accountLedgerRoutines", procedureName = "account_accountLedgerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * routine Stored Procedure logo
		 */
		@NamedStoredProcedureQuery(name = "logoImageRoutines", procedureName = "logo_logoImageRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for inventory purchase order
		@NamedStoredProcedureQuery(name = "purchasVoucher", procedureName = "inventory_purchase_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for inventory purchase order
		@NamedStoredProcedureQuery(name = "journalVoucher", procedureName = "account_journal_voucher_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for inventory account head type
		@NamedStoredProcedureQuery(name = "accountHead", procedureName = "account_head_type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// for inventory purchase order
		@NamedStoredProcedureQuery(name = "paymentVoucher", procedureName = "inventory_payment_voucher_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "salesInvReturnRoutines", procedureName = "sales_salesInvReturnRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "creditNoteRoutines", procedureName = "sales_creditNoteRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * inventory_debitNoteRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "debitNoteRoutines", procedureName = "inventory_debitNoteRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "contraVoucherRoutines", procedureName = "account_contraVoucherRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * routine Stored Procedure account_Credit LedgerRoutines
		 */
		@NamedStoredProcedureQuery(name = "creditLedgerRoutines", procedureName = "account_creditLedgerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * routine Stored Procedure account_Debit LedgerRoutines
		 */
		@NamedStoredProcedureQuery(name = "debitLedgerRoutines", procedureName = "account_debitLedgerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * for trial balance
		 */
		@NamedStoredProcedureQuery(name = "trialBalanceRoutines", procedureName = "account_trial_balance_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for cash book
		 */
		@NamedStoredProcedureQuery(name = "cashBookRoutines", procedureName = "account_cash_book_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * routine Stored Procedure Purchase Ledger Routines
		 */
		@NamedStoredProcedureQuery(name = "purchaseRoutines", procedureName = "account_purchaseLedgerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * routine Stored Procedure Purchase Ledger Routines
		 */
		@NamedStoredProcedureQuery(name = "incomeTaxRoutines", procedureName = "account_incomeTaxPayableRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * routine Stored Procedure Sales Ledger Routines
		 */
		@NamedStoredProcedureQuery(name = "salesRoutines", procedureName = "account_salesLedgerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "tableStatus", procedureName = "restaurant_tableStatusRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * for employment master
		 */
		@NamedStoredProcedureQuery(name = "EmploymentMaster", procedureName = "hrm_employment_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for job title master
		 */
		@NamedStoredProcedureQuery(name = "JobTypeMaster", procedureName = "hrm_jobType_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for department master
		 */
		@NamedStoredProcedureQuery(name = "departmentMaster", procedureName = "hrm_department_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for skill master
		 */
		@NamedStoredProcedureQuery(name = "skillMaster", procedureName = "hrm_skill_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for qualification master
		 */
		@NamedStoredProcedureQuery(name = "qualificationMaster", procedureName = "hrm_qualification_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for certification master
		 */
		@NamedStoredProcedureQuery(name = "certificationMaster", procedureName = "hrm_certification_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for language master
		 */
		@NamedStoredProcedureQuery(name = "languageMaster", procedureName = "hrm_language_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Employee
		 */
		@NamedStoredProcedureQuery(name = "Employee", procedureName = "hrm_employee_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Employee Skill assign
		 */
		@NamedStoredProcedureQuery(name = "EmployeeSkillAssign", procedureName = "hrm_employee_skill_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Employee Education assign
		 */
		@NamedStoredProcedureQuery(name = "EmployeeEducationAssign", procedureName = "hrm_employee_education_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Employee Education assign getAssignCertDetails
		 */
		@NamedStoredProcedureQuery(name = "EmployeecertificationAssign", procedureName = "hrm_employee_certification_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Employee Education assign getAssignCertDetails
		 */
		@NamedStoredProcedureQuery(name = "EmployeeLanguageAssign", procedureName = "hrm_employee_language_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Supervisor master
		 */
		@NamedStoredProcedureQuery(name = "supervisorMaster", procedureName = "hrm_supervisor_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for employee dependent
		 */
		@NamedStoredProcedureQuery(name = "EmployeedependentAssign", procedureName = "hrm_employee_dependent_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for emergency
		 */
		@NamedStoredProcedureQuery(name = "emergencyMaster", procedureName = "hrm_emergency_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * Leave Apply For HSRMS
		 */
		@NamedStoredProcedureQuery(name = "LeaveApply", procedureName = "master_leaveApply_Routies", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * for REFERENCE__HR__ JobType
		 * 
		 */
		@NamedStoredProcedureQuery(name = "HrReference", procedureName = "hr_Job_Type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "HrWorkHours", procedureName = "hr_Work_Hours_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "HrEducation", procedureName = "hr_education_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "HrJobBand", procedureName = "hr_JobBand_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "HrBenefit", procedureName = "hr_Benefit_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "HrAddress", procedureName = "hr_Address_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "HrBloodGroup", procedureName = "hr_BloodGroup_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "HrMarital", procedureName = "hr_Marital_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "HrDocument", procedureName = "hr_Document_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "HrmTimeSheet", procedureName = "hrm_TimeSheet_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "HrmEmpStatus", procedureName = "hrm_EmpStatus_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "HrmProjectType", procedureName = "hrm_Project_Type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "priorityMaster", procedureName = "hrm_Priority_Master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "GenderMaster", procedureName = "hrm_Gender_Master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "DepRelationshipMaster", procedureName = "hrm_Emp_Dependent_Relationship_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "dependentMaster", procedureName = "hrm_Emp_Dependent_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "insuranceMaster", procedureName = "hrm_Insurance_Company_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * for Department Job Title Assign
		 */
		@NamedStoredProcedureQuery(name = "JobTitleAssign", procedureName = "hrm_department_jobtitle_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * * for traveling claim
		 */
		@NamedStoredProcedureQuery(name = "travelClaimRoutines", procedureName = "hrms_travelClaimRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * * for BeautyDashboardRoutines sonam 0901
		 */
		@NamedStoredProcedureQuery(name = "BeautyDashboardRoutines", procedureName = "beautyparlour_BeautyParlourDashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * * for FrontdeskDashboardRoutines sonam 0901
		 */
		@NamedStoredProcedureQuery(name = "FrontdeskDashboardRoutines", procedureName = "frontdesk_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * * for GymDashboardRoutines sonam 0901
		 */
		@NamedStoredProcedureQuery(name = "GymDashboardRoutines", procedureName = "gym_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * * for KitchenDashboardRoutines sonam 0901
		 */
		@NamedStoredProcedureQuery(name = "KitchenDashboardRoutines", procedureName = "kitchen_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * * for laundryDashboardRoutines sonam 0901
		 */

		/*
		 * * for NightClubDashboardRoutines sonam 0901
		 */
		@NamedStoredProcedureQuery(name = "NightClubDashboardRoutines", procedureName = "nightclub_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * * for NightClubDashboardRoutines sonam 0901
		 */
		@NamedStoredProcedureQuery(name = "RestaurantStaffDashboardRoutines", procedureName = "restaurant_staffDashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * for spa Dashboard Routines sonam 0901
		 * 
		 */
		@NamedStoredProcedureQuery(name = "SpaDashboardRoutines", procedureName = "spa_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * for superadmin Dashboard Routines sonam 0901
		 * 
		 */
		@NamedStoredProcedureQuery(name = "userDashboardRoutines", procedureName = "user_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * for master_serviceRoutines Routines sagar 13012020
		 * 
		 */

		@NamedStoredProcedureQuery(name = "serviceRoutines", procedureName = "master_serviceRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * for restaurant_menuCourseRoutines Routines sagar 13012020
		 * 
		 */
		@NamedStoredProcedureQuery(name = "menuCourseRoutines", procedureName = "restaurant_menuCourseRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * sub group name Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "SubGroupName", procedureName = "SubGroupName_procedure", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * Store master routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "storeMasterRoutines", procedureName = "master_storeMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * Godown master routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "godownMasterRoutines", procedureName = "master_godownMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * employee routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "KRAMeasureRoutine", procedureName = "hrm_employee_KRAMeasureRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * for Employee Goal Master
		 */
		@NamedStoredProcedureQuery(name = "GoalMaster", procedureName = "hrm_goal_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Employee Appraisal Details
		 */
		@NamedStoredProcedureQuery(name = "EmployeeAppraisalDetails", procedureName = "hrm_employee_appraisal_review_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "gradeSalarynewRoutines", procedureName = "grade_salary_new_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * Appraisal Form routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "AppraisalFormApproval", procedureName = "hrm_appraisalFormApproval_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "documentRoutines", procedureName = "document_DocumentRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "masterCategoryRoutines", procedureName = "master_masterCategoryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "organizationCategoryRoutines", procedureName = "master_organizationCategoryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * view ticket Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "invjournalvoucherPaymentRoutines", procedureName = "account_journal_voucher_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "inventoryStockTransferRoutines", procedureName = "inventory_inventoryStockTransferRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "saleDelChallanRoutines", procedureName = "sales_saleDel_Maharaja_ChallanRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * inventoryDamagedItemRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "damagedItemRoutines", procedureName = "inventory_inventoryDamagedItemRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "entryRoutines", procedureName = "gatepass_entryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for delivery challan
		 */
		@NamedStoredProcedureQuery(name = "DeliverChallanRoutines", procedureName = "sales_delivery_challan_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "sandQualityControl", procedureName = "quality_control_sand_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * quality Production Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "QualityProduction", procedureName = "quality_control_production_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "productionPlanningRoutines", procedureName = "Production_Planning_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "productionPlanningTempRoutines", procedureName = "production_planningTempRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "productionGrade", procedureName = "production_GradeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * Mother Coil Slit Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "motherCoilRoutines", procedureName = "production_motherCoil_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * Mother Coil Slit Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "pipeProductionRoutines", procedureName = "production_pipeProduction_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * Mother Coil Slit Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "pipePolishingRoutines", procedureName = "production_pipePolishing_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * pipe packaging Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "pipePackagingRoutines", procedureName = "production_pipePackaging_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * pipe Scrap Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "pipeScrapRoutines", procedureName = "production_pipeScrap_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "batchCodeRoutines", procedureName = "inventory_batchCodeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "assignSlitWidth", procedureName = "production_assignSlitWidth", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "menuItemStockRoutines", procedureName = "restaurant_menuItemStockRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// sale order add
		@NamedStoredProcedureQuery(name = "SaleOrderRotines", procedureName = "sales_sale_order_Rotines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// sale order add
		@NamedStoredProcedureQuery(name = "salesCounterInvoiceRoutines", procedureName = "sales_salesCounterInvoiceRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// for customer item assign
		@NamedStoredProcedureQuery(name = "Customer_Item_Rutines", procedureName = "inventory_Customer_Item_Rutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// for assign stock price
		@NamedStoredProcedureQuery(name = "AssignStockPriceRutines", procedureName = "inventory_Assign_StockPrice_Rutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// for assign stock price
		@NamedStoredProcedureQuery(name = "vendor_Item_asgn_Rutines", procedureName = "inventory_vendor_Item_asgn_Rutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for multiple grn
		@NamedStoredProcedureQuery(name = "multipleGRNRoutines", procedureName = "inventory_multipleGRNRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for gocool production plan
		@NamedStoredProcedureQuery(name = "gocool-prod-planning", procedureName = "Production_Prod_Gocool_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// for gocool production add mix
		@NamedStoredProcedureQuery(name = "gocool-prod-add-mix", procedureName = "Production_Gocool_Mix_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for gocool production add packaging
		@NamedStoredProcedureQuery(name = "gocool-prod-packaging", procedureName = "Production_Prod_Pack_Gocool_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for gocool production
		@NamedStoredProcedureQuery(name = "Production_Routines", procedureName = "Production_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for batch details
		@NamedStoredProcedureQuery(name = "ProductItemRutines", procedureName = "inventory_Product_Item_Rutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/** SUB-INVENTORY **/
		@NamedStoredProcedureQuery(name = "subInventoryRoutines", procedureName = "inventory_subInventoryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/** WAREHOUSE **/
		@NamedStoredProcedureQuery(name = "warehouseRoutines", procedureName = "inventory_warehouseRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/** WAREHOUSE **/
		@NamedStoredProcedureQuery(name = "rackShelvesRoutines", procedureName = "inventory_rackShelvesRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// for batch details
		@NamedStoredProcedureQuery(name = "production_return", procedureName = "Production_Return_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * view advance payment Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "advancePaymentMasterRoutines", procedureName = "hrm_employee_advance_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "foodTracking", procedureName = "hrms_foodTrackingRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * for employee income tax
		 */
		@NamedStoredProcedureQuery(name = "emplyeeIncomeTaxRoutines", procedureName = "hrms_income_tax_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * trip bonous Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "tripBonousRoutines", procedureName = "hrm_employee_trip_bonous_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * trip bonous Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "dailyExcelUpload", procedureName = "hrm_daily_excel_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		//// salary revision

		@NamedStoredProcedureQuery(name = "SalaryRevisionPromotion", procedureName = "hrms_salaryRevision_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		//// advance policy

		@NamedStoredProcedureQuery(name = "hrmsadvancepolicyroutines", procedureName = "hrms_advancePolicy_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		//

		@NamedStoredProcedureQuery(name = "EmployeePayRoll", procedureName = "hrm_employeePayRoll_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "gradeSalaryRoutines", procedureName = "hrm_grade_salary_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "salaryComponentsMstrRoutines", procedureName = "hrm_salary_component_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "offerLetterRoutines", procedureName = "hrm_offerLetterDetails_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for salary details
		 */
		@NamedStoredProcedureQuery(name = "salary_routines", procedureName = "hrms_salary_details", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for leave details
		 */
		// hrms_leave_details
		@NamedStoredProcedureQuery(name = "leave_routines", procedureName = "hrm_employee_advance_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "jobCardRoutines", procedureName = "asset_add_job_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "employeeLeaveRoutine", procedureName = "employee_leave_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * for organization structure
		 */
		@NamedStoredProcedureQuery(name = "orgStructure", procedureName = "hrms_org_structure_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/** GRADE MASTER **/
		@NamedStoredProcedureQuery(name = "masterGradeRoutines", procedureName = "master_masterGradeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * for performance Goal
		 */
		@NamedStoredProcedureQuery(name = "OrganizationRoutine", procedureName = "hrm_organization_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * * for recruitment routines
		 */
		@NamedStoredProcedureQuery(name = "recruitment", procedureName = "hrms_jobtitle_routienes", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * * for requistionRoutines
		 */
		@NamedStoredProcedureQuery(name = "requistionRoutines", procedureName = "hrm_RequistionRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * * for specficTypeRoutines
		 */
		@NamedStoredProcedureQuery(name = "specficTypeRoutines", procedureName = "hrms_specficTypeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * * for questionTypeRoutines
		 */
		@NamedStoredProcedureQuery(name = "exitmanagement", procedureName = "exitManagement_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "exitInitiate", procedureName = "exitInitiate_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "exitFinance", procedureName = "exitFinance_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * Resource Routines
		 */
		@NamedStoredProcedureQuery(name = "resourceRoutines", procedureName = "recruitment_resource_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/** for shift management master **/
		@NamedStoredProcedureQuery(name = "rshiftRoutines", procedureName = "hrm_ShiftRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * * for trainingCreation routines
		 */
		@NamedStoredProcedureQuery(name = "trainingCreation", procedureName = "hrms_Training_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * * for trainingCreation routines
		 */
		@NamedStoredProcedureQuery(name = "gradeRevisionRoutines", procedureName = "grade_Revision_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * * for trainingCreation routines
		 */
		@NamedStoredProcedureQuery(name = "workSheetPlanningRoutines", procedureName = "work_sheet_planning_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "paymentTerms", procedureName = "account_paymentTermsRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * finance Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "financeRoutines", procedureName = "finance_mstr_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * tds Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "tdsRoutines", procedureName = "tds_mstr_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "payableRoutines", procedureName = "account_payableRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "reOrderItemRoutines", procedureName = "inventory_reOrderItemRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * for Question master routines
		 */
		@NamedStoredProcedureQuery(name = "questionRoutines", procedureName = "hrms_questionRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for shift scheduling routines
		 */
		@NamedStoredProcedureQuery(name = "addTrainingRoutines", procedureName = "hrm_TrainingPlanningRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "physicalVerification", procedureName = "physical_verification_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * for shift scheduling routines
		 */
		@NamedStoredProcedureQuery(name = "shiftScheduleRoutines", procedureName = "hrms_shiftScheduleRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "deliveryNoteRoutines", procedureName = "inventory_deliveryNoteRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "locationMasterRoutines", procedureName = "master_locationMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "productCategoryRoutines", procedureName = "master_productCategoryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "productMasterRoutines", procedureName = "master_productMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "mailConfigRoutines", procedureName = "master_mailConfigRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "budgetPlanRoutines", procedureName = "master_budgetPlanRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "templatesRoutines", procedureName = "master_templatesRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "userAuthorityRoutines", procedureName = "user_userAuthorityRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "warehouseRoutine", procedureName = "warehouse_new_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "warehouseBatchCreationRoutine", procedureName = "warehouse_BatchCreation_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "warehouseAllocationRoutine", procedureName = "warehouse_allocation_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "storeAllocationRoutine", procedureName = "store_allocation_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "view_creditNoteData_Routines", procedureName = "view_creditNoteData_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "warehouseGoodsBlockRoutine", procedureName = "warehouse_goods_blockRoutine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "storeGoodsBlockRoutine", procedureName = "store_goods_blockRoutine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "warehouseGoodsDispatchRoutine", procedureName = "warehouse_goods_dispatchRoutine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "storeGoodsDispatchRoutine", procedureName = "store_goods_dispatchRoutine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "warehouseStackingRoutine", procedureName = "warehouse_stacking_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "storeStackingRoutine", procedureName = "store_stacking_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "warehouseStockVerificationRoutine", procedureName = "warehouse_stockverification_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "storeStockVerificationRoutine", procedureName = "store_stockverification_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "inventoryStockRoutines", procedureName = "inventory_stock_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * for inventory requisition
		 */
		@NamedStoredProcedureQuery(name = "inventoryRequisitionRoutines", procedureName = "inventory_Requisition_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "Physical_Varification_Routines", procedureName = "Physical_Varification_ForGRN_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "requesteed_raw_material_Routine", procedureName = "requesteed_raw_material_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * for vendor master
		 */
		@NamedStoredProcedureQuery(name = "vendorMasterRoutines", procedureName = "master_vendorMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "travelRequisitionRoutines", procedureName = "hrms_travelRequisitionRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "vendormaster", procedureName = "vendor_masterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "purchaseDashboard", procedureName = "purchase_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * for manage employee
		 */
		@NamedStoredProcedureQuery(name = "employeeMasterRoutines", procedureName = "employee_mst_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "GlobalMasterRoutines", procedureName = "master_globalMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "master_appraisalkeyfactorroutines", procedureName = "master_appraisalkeyfactorroutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * for rfq
		 */
		@NamedStoredProcedureQuery(name = "RfqRoutines", procedureName = "inventory_rfq_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "Inventory_action_invoice_Return_Routines", procedureName = "Inventory_action_invoice_Return_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * po
		 */
		@NamedStoredProcedureQuery(name = "poRoutines", procedureName = "inventory_po_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * action rfq model
		 */
		@NamedStoredProcedureQuery(name = "ActionRfqRoutines", procedureName = "inventory_action_rfq_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * for REFERENCE__Procurement
		 * 
		 */

		@NamedStoredProcedureQuery(name = "MeasurementTypeReference", procedureName = "procure_Measure_Type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "RequisitionTypeReference", procedureName = "procure_Requisition_Type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "RequisitionPrioTypeReference", procedureName = "procure_Requisition_Prio_Type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "PaymentTermReference", procedureName = "procure_Payment_Term_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "LegalTermReference", procedureName = "procure_Legal_Term_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "PaymentStatusReference", procedureName = "procure_Payment_Status_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "DeliveryMethodReference", procedureName = "procure_Delivery_Method_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * for REFERENCE__Product
		 * 
		 */
		@NamedStoredProcedureQuery(name = "BrandTypeReference", procedureName = "product_Brand_Type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "ProductTypeReference", procedureName = "product_Type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "VariationTypeReference", procedureName = "variation_Type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * for REFERENCE__Entity
		 * 
		 */
		@NamedStoredProcedureQuery(name = "EntityCostNature", procedureName = "entity_Cost_Nature_Type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "EntityCostLabour", procedureName = "entity_cost_labour_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "EntityVendorCategory", procedureName = "entity_vendor_category_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "EntityLocationType", procedureName = "entity_location_type_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "EntityRoomType", procedureName = "entity_room_type_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "EntityVendorType", procedureName = "entity_vendor_type_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * for cost center master
		 */
		@NamedStoredProcedureQuery(name = "costCenterRoutines", procedureName = "master_costcenterMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * for chart of account master
		 */
		@NamedStoredProcedureQuery(name = "chartOfAcRoutines", procedureName = "master_chartofaccMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * Vendor rfq model
		 */
		@NamedStoredProcedureQuery(name = "VendorRfqRoutines", procedureName = "inventory_vendor_rfq_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * for account mapping
		 */
		@NamedStoredProcedureQuery(name = "accountMappingRoutines", procedureName = "master_accmappingMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * action invoice
		 */
		@NamedStoredProcedureQuery(name = "action_invoice_Routines", procedureName = "inventory_action_invoice_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "vendor_echallan_Routines", procedureName = "inventory_vendor_echallan_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * action grn
		 */
		@NamedStoredProcedureQuery(name = "execute_grn_Routines", procedureName = "inventory_execute_grn_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * action grn
		 */
		@NamedStoredProcedureQuery(name = "execute_grn_return_Routines", procedureName = "inventory_execute_grn_return_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * for account mapping
		 */
		@NamedStoredProcedureQuery(name = "masterTimeSheetRoutines", procedureName = "master_timeSheetMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "vendor_invoice_Routines", procedureName = "inventory_vendor_invoice_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "HrShift", procedureName = "hr_Shift_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * for ticket mapping
		 */

		@NamedStoredProcedureQuery(name = "ticketRoutines", procedureName = "callAgent_ticketRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "manageSupervisorRoutines", procedureName = "viewSupervisorTicket_procedure", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "viewCategory", procedureName = "Ticket_Category_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "statusRoutines", procedureName = "report_ticketRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * reimbursement
		 * 
		 */
		@NamedStoredProcedureQuery(name = "reimbursementRoutine", procedureName = "hrms_Reimbursement_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * for vendor grn return
		 */
		@NamedStoredProcedureQuery(name = "vendor_grn_return_Routines", procedureName = "inventory_vendor_grn_return_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "employeestatus", procedureName = "Employee_Status_Routies", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "questionTypeRoutines", procedureName = "hrms_questionTypeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "customerDashBoard", procedureName = "customer_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "wereHouseDashBoard", procedureName = "wereHouse_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "tickettDashBoard", procedureName = "ticket_dashboardRotunies", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "projectDashBoard", procedureName = "hrm_project_dashboardRotunies", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for Payroll routines----- By AMAR
		 */

		@NamedStoredProcedureQuery(name = "payrollRoutines", procedureName = "payRoll_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for Payroll routines----- By sagar
		 */

		@NamedStoredProcedureQuery(name = "payslip_attendance_routines", procedureName = "payslip_attendance_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for Payslip routines
		 */

		@NamedStoredProcedureQuery(name = "payslipRoutines", procedureName = "payroll_payslipRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// satabdee

		@NamedStoredProcedureQuery(name = "hrmsadvanceroutines", procedureName = "hrms_advanceManagement_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// satabdee

		@NamedStoredProcedureQuery(name = "payslipPdfRoutines", procedureName = "payslipPdf_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user_ManageRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "userRoleAssign", procedureName = "user_RoleAssign", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for Hrms Dashboard
		 */
		@NamedStoredProcedureQuery(name = "hrmsdashboardRoutiness", procedureName = "hrms_dashboardRoutiness", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "hrmsdashboardRoutiness2", procedureName = "hrms_dashboardRoutiness2", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "hrmsDashRecruitRoutine", procedureName = "hrms_DashRecruitRoutine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "recuitmentDashboardRoutines", procedureName = "dashboard_requirement_routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// Goal Master Routines

		@NamedStoredProcedureQuery(name = "goalRoutiness", procedureName = "goal_master_routiness", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/// hrms event management procedure
		@NamedStoredProcedureQuery(name = "hrmsEventManagementRoutines", procedureName = "hrms_event_management_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/// payroll master procedure-----By Susant
		@NamedStoredProcedureQuery(name = "payroleMasterRoutines", procedureName = "payrole_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for CrmMaster mapping
		 */
		@NamedStoredProcedureQuery(name = "Pipeline", procedureName = "new_pipelineRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "crmAccounts_routines", procedureName = "crm_Accounts_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "crmCustomer_routines", procedureName = "crm_Customer_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * for crm_meeting
		 */
		@NamedStoredProcedureQuery(name = "crm_meeting", procedureName = "CRM_MeetingRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for crm_call
		 */
		@NamedStoredProcedureQuery(name = "crm_call", procedureName = "CRM_CallRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for crm_campaign
		 */
		@NamedStoredProcedureQuery(name = "crm_campaign", procedureName = "CRM_CampaignRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for Crm Contact mapping
		 */
		@NamedStoredProcedureQuery(name = "crm_contact", procedureName = "CRM_ContactRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

//crm_deal

		/*
		 * for crm_deal mapping
		 */
		@NamedStoredProcedureQuery(name = "crm_deal", procedureName = "CRM_DealRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

//crmInvoiceRoutines

		@NamedStoredProcedureQuery(name = "crmInvoiceRoutines", procedureName = "crm_invoice_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

//crm_task

		/*
		 * for crm_task
		 */
		@NamedStoredProcedureQuery(name = "crm_task", procedureName = "CRM_TaskRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "crm_Owner_Routines", procedureName = "crm_Owner_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "crmLeads_routines", procedureName = "crm_Leads_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "crmVendors_routines", procedureName = "crm_Vendor_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "crmPurchaseOrderRoutines", procedureName = "crm_purchaseOrder_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "crmquotationRotines", procedureName = "crm_quotation_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "crmSalesOrderRoutines", procedureName = "crm_salesorder_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "crmProduct_routines", procedureName = "crm_Product_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/* Property Mgmt */
//View and edit Property Details
		@NamedStoredProcedureQuery(name = "propertydetails", procedureName = "propertydetails", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
//view profile details
		@NamedStoredProcedureQuery(name = "profiledetails", procedureName = "profiledetails", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// view Rent Ledger
		@NamedStoredProcedureQuery(name = "rentledger", procedureName = "rentledger", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// view workdetails
		@NamedStoredProcedureQuery(name = "workdetails", procedureName = "workdetails", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// view profile details
		@NamedStoredProcedureQuery(name = "profileserviceprovider", procedureName = "profileserviceprovider", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// view service provider ledger
		@NamedStoredProcedureQuery(name = "serviceRentledger", procedureName = "serviceRentledger", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// view service provider dashboard
		@NamedStoredProcedureQuery(name = "serviceProviderDashboard", procedureName = "serviceProviderDashboard", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// view tenant Dashboard
		@NamedStoredProcedureQuery(name = "tenantDashboard", procedureName = "tenantDashboard", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// view RentOS
		@NamedStoredProcedureQuery(name = "viewRentOS", procedureName = "rentos", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// view payos dues details
		@NamedStoredProcedureQuery(name = "payosdues", procedureName = "payosdues", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
//Stake holder manage property
		@NamedStoredProcedureQuery(name = "viewProperty", procedureName = "Properties_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
//Stake-holder Dashboard
		@NamedStoredProcedureQuery(name = "stakeHolderDashboard", procedureName = "stakeHolderDashboard_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "viewTenant", procedureName = "tenant_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "viewPropertyPerformance", procedureName = "Property_Performance_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "viewServiceProviders", procedureName = "Service_Providers_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "viewRentLedger", procedureName = "Rent_Ledger_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "viewMaintainence", procedureName = "Maintainence_Description_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "gate_pass_Routines", procedureName = "inventory_gate_pass_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "inventory_gate_passExit_Routines", procedureName = "inventory_gate_passExit_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "monthly_attendanceReport_routines", procedureName = "monthly_attendanceReport_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "production_plan_bom_routines", procedureName = "production_plan_bom_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "qa_master_routines", procedureName = "qa_master_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "asset_view_master_routines", procedureName = "asset_view_master_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "production_plan_Uploaded_routines", procedureName = "production_plan_Uploaded_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "view_credit_ledger_mstr", procedureName = "account_creditors_ledger_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "warehouse_awaiting_allocation_routines", procedureName = "warehouse_awaiting_allocation_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "store_awaiting_allocation_routines", procedureName = "store_awaiting_allocation_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "awaiting_blocking_routines", procedureName = "warehouse_awaiting_blocking_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "awaiting_store_blocking_routines", procedureName = "awaiting_store_blocking_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "storeRoutine", procedureName = "store_new_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "awaiting_quality_assurance_routines", procedureName = "awaiting_quality_assurance_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "qa_requested_routines", procedureName = "qa_requested_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "warehouse_report_routines", procedureName = "warehouse_report_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "store_report_routines", procedureName = "store_report_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "gate_received_routines", procedureName = "gate_received_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "purchase_report_routines", procedureName = "purchase_report_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "gate_pass_report_routines", procedureName = "gate_pass_report_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "gatePass_SecurityAssign_Routines", procedureName = "gatePass_SecurityAssign_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "emp_other_benifits_routines", procedureName = "emp_other_benifits_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "vendor_Qutation_Routines", procedureName = "vendor_Qutation_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "asset_assign_routines", procedureName = "asset_assign_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "vendor_DeliveryChallan_routines", procedureName = "vendor_DeliveryChallan_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "vendor_Invoice_routines", procedureName = "vendor_Invoice_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "vendor_creditNote_Routines", procedureName = "vendor_creditNote_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "purchaseProduct", procedureName = "purchase_Product_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "asset_mstr_policy_routines", procedureName = "asset_mstr_policy_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "asset_maintenance_routines", procedureName = "asset_maintenance_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "qa_wcr_routines", procedureName = "qa_wcr_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "qa_pcro_routines", procedureName = "qa_pcro_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "qa_pcro_checklist_routines", procedureName = "qa_pcro_checklist_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "qa_microbiology_lab_routines", procedureName = "qa_microbiology_lab_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "qa_crqs_routines", procedureName = "qa_crqs_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "production_plan_mfg_process_routines", procedureName = "production_plan_mfg_process_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "production_plan_pkt_dtls_routines", procedureName = "production_plan_pkt_dtls_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "planningproduction", procedureName = "production_plan_planningproductionRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "purchase_indent_Routines", procedureName = "purchase_indent_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "ticket_department_view_Routines", procedureName = "ticket_department_view_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "invoice_New_Routine", procedureName = "invoice_New_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "ticket_management_Routines", procedureName = "ticket_management_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "gatepass_final_report_routines", procedureName = "gatepass_final_report_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "qa_dar_routines", procedureName = "qa_dar_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "qa_spot_routines", procedureName = "qa_spot_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "gatepass_staff_register_routines", procedureName = "gatepass_staff_register_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "asset_report_routines", procedureName = "asset_report_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "weight_bridge_routines", procedureName = "weight_bridge_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "inventory_payment_Routines", procedureName = "inventory_action_payment_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "account_manageledger", procedureName = "account_manage_ledger", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "account_contra_routines", procedureName = "account_contraVoucherRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// for inventory purchase order
		@NamedStoredProcedureQuery(name = "journalvoucherRoutines", procedureName = "account_journal_voucher_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "account_payment_routines", procedureName = "account_payment_voucher_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "account_receipt_routines", procedureName = "account_receipt_voucher_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "account_voucher_type_routines", procedureName = "account_voucher_type_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "salesAccountRoutines", procedureName = "account_salesLedgerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * routine Stored Procedure credit_notes_routines
		 */
		@NamedStoredProcedureQuery(name = "credit_notes_routines", procedureName = "credit_notes_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * routine Stored Procedure debit_notes_routines
		 */
		@NamedStoredProcedureQuery(name = "debit_notes_routines", procedureName = "debit_notes_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "account_bank_routines", procedureName = "account_bankRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * routine Stored Procedure account_bankBranchRoutines
		 */
		@NamedStoredProcedureQuery(name = "account_bankBranchRoutines", procedureName = "account_bankBranchRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * routine Stored Procedure account_bankAccountRoutines
		 */
		@NamedStoredProcedureQuery(name = "account_bankAccountRoutines", procedureName = "account_bankAccountRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "staff_report_routines", procedureName = "staff_report_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "account_manageCurrency", procedureName = "account_manage_currency", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "qa_test_report_routines", procedureName = "qa_test_report_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "purchase_invoice_Routines", procedureName = "purchase_invoice_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/* BUDGET STARTS */

		@NamedStoredProcedureQuery(name = "assign_dept_budget", procedureName = "assign_dept_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/* BUDGET ENDS */

		@NamedStoredProcedureQuery(name = "store_material_issue_routines", procedureName = "store_material_issue_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "qa_microtesting_routines", procedureName = "qa_microtesting_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = ProcedureNameConstants.RTMR_ROUTINES, procedureName = "rtmr_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = ProcedureNameConstants.LTMR_ROUTINES, procedureName = "ltmr_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = ProcedureNameConstants.VBAR_ROUTINES, procedureName = "vbar_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "qa_rcftm_routines", procedureName = "qa_rcftm_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "qa_pcaanalysis_record_routines", procedureName = "qa_pcaanalysis_record_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = ProcedureNameConstants.RMPM_ROUTINES, procedureName = "qa_rmpm_release_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = ProcedureNameConstants.PH_METER_ROUTINES, procedureName = "ph_meter_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = ProcedureNameConstants.MEDIA_DECONTAMINATION_ROUTINES, procedureName = "media_decontamination_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "qa_fatsolanalysis_record_routines", procedureName = "qa_fatsolanalysis_record_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "qa_ashAnalysis_rawdatarecord_routines", procedureName = "qa_ashAnalysis_rawdatarecord_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "qa_evaluation_bopp_tape_routines", procedureName = "qa_evaluation_bopp_tape_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "qa_sample_receiving_routines", procedureName = "qa_sample_receiving_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "qa_media_preparation_routines", procedureName = "qa_media_preparation_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "qa_crqs_check_routines", procedureName = "qa_crqs_check_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "qa_msqc_routines", procedureName = "qa_msqc_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = ProcedureNameConstants.QA_EVALUATION_OF_LAMINATES_ROUTINES, procedureName = "qa_evaluation_of_laminates_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = ProcedureNameConstants.QA_EVALUATION_OF_POLYLINER_ROUTINES, procedureName = "qa_evaluation_of_polyliner_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = ProcedureNameConstants.QA_EVALUATION_OF_DISPLAY_CARTONS_ROUTINES, procedureName = "qa_evaluation_of_display_cartons_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = ProcedureNameConstants.QA_EVALUATION_OF_OUTER_CARTONS_ROUTINES, procedureName = "qa_evaluation_of_outer_cartons_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "monthlyWagePlusRoutiness", procedureName = "monthlyWagePlusRoutiness", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * For CRM Admin Routines
		 */
		@NamedStoredProcedureQuery(name = "crm_admin_routines", procedureName = "crm_admin_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * For CRM Invited Meetings Routines
		 */
		@NamedStoredProcedureQuery(name = "crm_invitedmeetings_routines", procedureName = "crm_invitedmeetings_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "qa_laminate_routines", procedureName = "qa_laminate_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "qa_calcium_routines", procedureName = "qa_calcium_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "qa_sack_routines", procedureName = "qa_sack_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = ProcedureNameConstants.VitA_ROUTINES, procedureName = "vitamin_A_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "qa_sulphuric_routines", procedureName = "qa_sulphuric_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "qa_alcholic_naoh_routines", procedureName = "qa_alcholic_naoh_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "qa_dcip_routines", procedureName = "qa_dcip_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "hrms_ccr_routines", procedureName = "hrms_ccr_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "hrms_attandance_by_dept_routines", procedureName = "hrms_attandance_by_dept_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "monthlyTDSRoutiness", procedureName = "monthlyTDSRoutiness", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "qa_sodium_routines", procedureName = "qa_sodium_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "qa_incident_routines", procedureName = "qa_incident_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = ProcedureNameConstants.QA_WBCR_ROUTINES, procedureName = "qa_wbcr_routins", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "sales_productConversionChart", procedureName = "sales_productConversionChart", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "hrms_el_manage_routines", procedureName = "hrms_el_manage_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/* Account Statutory Report Stored Procedure */
		@NamedStoredProcedureQuery(name = "account_statutoryReport", procedureName = "account_statutory_reports_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "hrms_off_days_routines", procedureName = "hrms_off_days_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/* production plan shopFloor_ Stored Procedure */
		@NamedStoredProcedureQuery(name = "production_plan_manage_shopFloor_routines", procedureName = "production_plan_manage_shopFloor_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/* shipment details Stored Procedure */
		@NamedStoredProcedureQuery(name = "shipment_details_Routines", procedureName = "shipment_details_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/////// GRC Module Starts////////

		// Risk Management Stored Procedure
		@NamedStoredProcedureQuery(name = "ehs_identification_Routines", procedureName = "grc_identification_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "ehs_analysis_Routines", procedureName = "grc_analysis_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "ehs_mitigation_Routines", procedureName = "grc_mitigation_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "ehs_monitoring_Routines", procedureName = "grc_monitoring_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "ehs_control_Routines", procedureName = "grc_control_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// Safety Management Stored Procedure
		@NamedStoredProcedureQuery(name = "ehs_safety_management_routines", procedureName = "grc_safety_management_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "ehs_safety_assesment_routines", procedureName = "grc_safety_assesment_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "ehs_safety_planning_routines", procedureName = "grc_safety_planning_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "ehs_safety_control_routines", procedureName = "grc_safety_control_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// Incident Management Stored Procedure
		@NamedStoredProcedureQuery(name = "goalIncidentMaster", procedureName = "grc_incident_master_routiness", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "goalIncidentReportingMaster", procedureName = "grc_incident_reporting_routiness", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "goalIncidentManageMaster", procedureName = "grc_incident_manage_routiness", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "goalIncidentCasualAnalysis", procedureName = "grc_incident_casual_analysis_routiness", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "goalIncidentCorrectiveAction", procedureName = "grc_incident_corrective_action_routiness", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// inspection Management Stored Procedure
		@NamedStoredProcedureQuery(name = "inspection_master_routines", procedureName = "inspection_master_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "inspection_creation_routines", procedureName = "inspection_creation_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "inspection_plan_routines", procedureName = "inspection_plan_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "Planning_And_ForcastingData_Routines", procedureName = "Planning_And_ForcastingData_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// Audit Management
		@NamedStoredProcedureQuery(name = "AuditType", procedureName = "audit_type", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "AgencyList", procedureName = "agency_List", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "AuditorList", procedureName = "auditor_List", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "auditmaster_routines", procedureName = "audit_master_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/////// GRC Module Ends////////

		/////// packing logbook ///////

		@NamedStoredProcedureQuery(name = "packing_logBook_routines", procedureName = "packing_logBook_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		//////////////////////////////////////////// ASSET AND
		//////////////////////////////////////////// PROPERTY///////////////////////////////////////////////////

		@NamedStoredProcedureQuery(name = "assetPropertyRoutines", procedureName = "assetPropertyRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "asset_execution_request_routines", procedureName = "asset_execution_request_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "assets_property_dropdown_routines", procedureName = "assets_property_dropdown_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "asset_profile_routines", procedureName = "asset_profile_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "asset_property_grouping_routines", procedureName = "asset_property_grouping_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/////// LMR Log ///////

		@NamedStoredProcedureQuery(name = "production_plan_lmrLog_routines", procedureName = "production_plan_lmrLog_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "account_inventory_stock_Routines", procedureName = "account_inventory_stock_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/////// Production Log Book Orifood ///////

		@NamedStoredProcedureQuery(name = "production_plan_productionLogOf_routines", procedureName = "production_plan_productionLogOf_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

/////// 	Production Manage Sack Configuration OriClean	 /////// 

		@NamedStoredProcedureQuery(name = "production_plan_sackConfiguration_routines", procedureName = "production_plan_sackConfiguration_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "asset_verification_routines", procedureName = "asset_verification_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "hrms_emp_bonusExgratia_routines", procedureName = "hrms_emp_bonusExgratia_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

//emp shift details

		@NamedStoredProcedureQuery(name = "hrms_employee_group_scheduling", procedureName = "hrms_employee_group_scheduling", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

// Purchase Shortage/Surplus Goods.

		@NamedStoredProcedureQuery(name = "purchase_shortage_surplus_routines", procedureName = "purchase_shortage_surplus_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "production_planning_rmpmRequisition_routines", procedureName = "production_planning_rmpmRequisition_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "inventory_rmpmRMaterialIssue_routines", procedureName = "inventory_rmpmRMaterialIssue_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "employee_transfer_routines", procedureName = "employee_transfer_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "grc_sbo_hi_routines", procedureName = "grc_sbo_hi_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "fe_checklist_routines", procedureName = "fe_checklist_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "maintenance_report_routines", procedureName = "maintenance_report_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// Perforation Blade Record
		@NamedStoredProcedureQuery(name = "perforation_record_routines", procedureName = "perforation_record_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// Sieve Status
		@NamedStoredProcedureQuery(name = "sieve_status_routines", procedureName = "sieve_status_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// Wet Clean Checklist
		@NamedStoredProcedureQuery(name = "wet_clean_checklist_routine", procedureName = "wet_clean_checklist_routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/* PROJECT MODULE */

		// project creation
		@NamedStoredProcedureQuery(name = "projectsprjcreationroutines", procedureName = "project_creation_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/* project Execution */
		@NamedStoredProcedureQuery(name = "projectExceutionRoutines", procedureName = "project_execution_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/* budget estimation */
		@NamedStoredProcedureQuery(name = "budget_estimation_routines", procedureName = "project_budget_estimation_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/* Jobcard estimation */
		@NamedStoredProcedureQuery(name = "jobcard_estimation_routines", procedureName = "jobcard_estimation_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/* project sub contractor */
		@NamedStoredProcedureQuery(name = "project_sub_contractor_routines", procedureName = "project_sub_contractor_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/* planning & scheduling */
		@NamedStoredProcedureQuery(name = "ProjectCategoryRoutines", procedureName = "master_projectCategoryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "projectplanningschedulingroutines", procedureName = "project_planning_scheduling_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "projectplanningroutines", procedureName = "project_planning_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "closeOutRoutines", procedureName = "project_closeOutRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "project_crop_routines", procedureName = "project_crop_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "project_category_routines", procedureName = "project_category_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// project monitoring
		@NamedStoredProcedureQuery(name = "project_monitoring_routines", procedureName = "project_monitoring_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/* project Document Upload */
		@NamedStoredProcedureQuery(name = "projectdocumentuploadroutines", procedureName = "project_document_upload_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/* project Billing Cycle */
		@NamedStoredProcedureQuery(name = "projectbillingroutines", procedureName = "project_billing_cycle_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/* NFA */

		@NamedStoredProcedureQuery(name = "project_nfa_routines", procedureName = "project_nfa_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// production planning
		@NamedStoredProcedureQuery(name = "productionplanningroutines", procedureName = "project_production_planning", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// health
		@NamedStoredProcedureQuery(name = "his_routines", procedureName = "his_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "hisBedMasterRoutines", procedureName = "his_bed_master_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "his_patient_routines", procedureName = "his_patient_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// HIS Store Procedure
		@NamedStoredProcedureQuery(name = "his_bed_routines", procedureName = "his_bed_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// ICU Store Procedure
		@NamedStoredProcedureQuery(name = "his_icu_routines", procedureName = "his_icu_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// PathoLab Store Procedure
		@NamedStoredProcedureQuery(name = "his_patholab_routines", procedureName = "his_patholab_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// Operation Theater Procedure
		@NamedStoredProcedureQuery(name = "his_ot_routines", procedureName = "his_ot_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// OPD Patient Procedure
		@NamedStoredProcedureQuery(name = "opd_patient_routines", procedureName = "opd_patient_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "his_ipd_routines", procedureName = "his_ipd_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// OT Procedure

		@NamedStoredProcedureQuery(name = "his_ot_reserve_routines", procedureName = "his_ot_reserve_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// Booking Ambulance

		@NamedStoredProcedureQuery(name = "his_ambulance_booking_routines", procedureName = "his_ambulance_booking_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// Canteen

		@NamedStoredProcedureQuery(name = "canteen-menu", procedureName = "canteen_menu_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "canteen-combo", procedureName = "canteen_combo_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "canteen-assign", procedureName = "canteen_assign_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// EDMS Workspace workspaceRoutines

		@NamedStoredProcedureQuery(name = "workspaceRoutines", procedureName = "Edms_Workspace_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "Edms_WorkFlow_Routines", procedureName = "Edms_WorkFlow_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "documentControlRoutines", procedureName = "Edms_DocumentControl_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "documentManageRoutines", procedureName = "Edms_DocumentManage_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// Pharmacy
		@NamedStoredProcedureQuery(name = "ipo_pharamcy_routine", procedureName = "ipo_pharamcy_routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// Meeting Calendar
		@NamedStoredProcedureQuery(name = "meeting_calendar_routines", procedureName = "meeting_calendar_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "his_ticket_management_Routines", procedureName = "his_ticket_management_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "warehouse_item_configuration_routines", procedureName = "warehouse_item_configuration_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * warehouse stock transfer routines
		 */
		@NamedStoredProcedureQuery(name = "warehouse_stock_transfer_routines", procedureName = "warehouse_stock_transfer_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "product_details", procedureName = "product_details", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "project_creation_routines_v1", procedureName = "project_creation_routines_v1", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "his_pharmacy_routines", procedureName = "his_pharmacy_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "his_ot_details_routines", procedureName = "his_ot_details_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "project_planning_routines_v1", procedureName = "project_planning_routines_v1", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "project_estimation_routines", procedureName = "project_estimation_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * user_all_task_routines
		 */
		@NamedStoredProcedureQuery(name = "user_all_task_routines", procedureName = "user_all_task_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "masterDataRoutines", procedureName = "configuration_masterDataRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "vms_tender_routines", procedureName = "vms_tender_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "vms_contract_routines", procedureName = "vms_contract_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "project_execution_routines_v1", procedureName = "project_execution_routines_v1", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "workflow_process_Routines", procedureName = "workflow_process_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "hrms_insurance_routines", procedureName = "hrms_insurance_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "product_sales_price_routine", procedureName = "product_sales_price_routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "hrms_attendance_routines", procedureName = "hrms_attendance_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "his_nurse_routines", procedureName = "his_nurse_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "otp_auth_service", procedureName = "otp_auth_service", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * for Insurance
		 * 
		 */
		@NamedStoredProcedureQuery(name = "InsuranceTypeReference", procedureName = "insurance_Type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "InsuranceProviderTypeReference", procedureName = "insurance_Provider_Type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "appraisal_routines", procedureName = "appraisal_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "self_appraisal_routines", procedureName = "self_appraisal_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "salesInvoiceProcedure", procedureName = "sales_invoice_new_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "TransportTypeReference", procedureName = "transport_Type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "his_discharge_routines", procedureName = "his_discharge_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "account_paymentScheduleAndProcess_routines", procedureName = "account_paymentScheduleAndProcess_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		
		@NamedStoredProcedureQuery(name = "account_receiptScheduleAndProcess_routines", procedureName = "account_receiptScheduleAndProcess_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "his_billing_routines", procedureName = "his_billing_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "appraisal_review_routines", procedureName = "appraisal_review_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "patient_appointment_routines", procedureName = "patient_appointment_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * for Assets Dashboard Routines
		 */

		@NamedStoredProcedureQuery(name = "asset_dashboard_maintainance_Routines", procedureName = "asset_dashboard_maintainance_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * for Assets Dashboard Routines
		 */

		@NamedStoredProcedureQuery(name = "asset_dashboard_asset_Routines", procedureName = "asset_dashboard_asset_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * for Assets Dashboard Routines
		 */

		@NamedStoredProcedureQuery(name = "asset_dashboard_performance_Routines", procedureName = "asset_dashboard_performance_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * for Assets Dashboard Routines
		 */

		@NamedStoredProcedureQuery(name = "asset_dashboard_valuation_Routines", procedureName = "asset_dashboard_valuation_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * for Assets Dashboard Routines
		 */

		@NamedStoredProcedureQuery(name = "asset_dashboard_analytics_reports_Routines", procedureName = "asset_dashboard_analytics_reports_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * for Ticket Dashboard Routines
		 */

		@NamedStoredProcedureQuery(name = "ticket_management_dashboardRoutines", procedureName = "ticket_management_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * for Production Dashboard Ist Routines
		 */

		@NamedStoredProcedureQuery(name = "production_dashboard_routines", procedureName = "production_dashboard_routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for Production Dashboard 2nd Routines
		 */

		@NamedStoredProcedureQuery(name = "production_dashboard_routines2", procedureName = "production_dashboard_routines2", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for Crm Dashboard
		 */
		@NamedStoredProcedureQuery(name = "CRM_DashBoardRoutines", procedureName = "CRM_DashBoardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

	@NamedStoredProcedureQuery(name = "sales_AllReport_routines", procedureName = "sales_AllReport_routines", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),	
	
	
		
	/*
	 * for hotel management
	 */
	
	@NamedStoredProcedureQuery(name = "hotel_free_trail_routines", procedureName = "hotel_free_trail_routines", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),	
	
	@NamedStoredProcedureQuery(name = "hotel_management_help_desk_routines", procedureName = "hotel_management_help_desk_routines", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
	
	@NamedStoredProcedureQuery(name = "academic_course_routines", procedureName = "academic_course_routines", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * for hotel management
		 */
		// Hotel-Sattkar Management
		@NamedStoredProcedureQuery(name = "hotel_frontdesk_routine", procedureName = "hotel_frontdesk_routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),@NamedStoredProcedureQuery(name = "hotel_configuration_Routines", procedureName = "hotel_configuration_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "hotel_org_packageConfiguration_routine", procedureName = "hotel_org_packageConfiguration_routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		
		
		@NamedStoredProcedureQuery(name = "lms_application_routine", procedureName = "lms_application_routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		})

/**
 * @author NirmalyaLabs
 *
 */
public class BaseEntityClass {

	@Id
	private Integer pKey;

	public BaseEntityClass() {
		super();
	}

	public Integer getpKey() {
		return pKey;
	}

	public void setpKey(Integer pKey) {
		this.pKey = pKey;
	}

	/**
	 * Overrides toString method for converting class to string and back
	 **/
	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;
	}
}
