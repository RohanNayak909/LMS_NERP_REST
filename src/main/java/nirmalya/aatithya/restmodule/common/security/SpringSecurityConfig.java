package nirmalya.aatithya.restmodule.common.security;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


import nirmalya.aatithya.restmodule.security.config.JwtAuthenticationEntryPoint;
import nirmalya.aatithya.restmodule.security.config.JwtRequestFilter;

/**
 * @author Jinesh
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	private static final String[] AUTH_WHITELIST = {
	        "/swagger-resources/**",
	        "/swagger-ui.html",
	        "/v2/api-docs",
	        "/webjars/**"
	};

	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.csrf().disable()
				// dont authenticate this particular request
				.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
				.antMatchers("/**").permitAll()
				.antMatchers("/account/**").permitAll()
				.antMatchers("/training/**").permitAll()
				.antMatchers("/production/**").permitAll()
				.antMatchers("/qa/**").permitAll()
				.antMatchers("/audit/**").permitAll()
				.antMatchers("/pipeline/**").permitAll()
				.antMatchers("/customer/**").permitAll()
				.antMatchers("/projects/**").permitAll()
				.antMatchers("/asset/**").permitAll()
				.antMatchers("/inventory/**").permitAll()
				.antMatchers("/ticket/**").permitAll()
				.antMatchers("/ticket-system/**").permitAll()
				.antMatchers("/master/**").permitAll()
				.antMatchers("/gatepass/**").permitAll()
				.antMatchers("/employee/**").permitAll()
				.antMatchers("/recruitment/**").permitAll()
				.antMatchers("/user/**").permitAll()
				.antMatchers("/property/**").permitAll()
				.antMatchers("/api/**").permitAll()
				.antMatchers("/user/**").permitAll()
				.antMatchers("/warehouse/**").permitAll()
				.antMatchers("/trial/**").permitAll()
				.antMatchers("/sales/**").permitAll()
				.antMatchers("/transport/**").permitAll()
				.antMatchers("/weight/**").permitAll()
				.antMatchers("/budget/**").permitAll()
				.antMatchers("/communication/**").permitAll()
				.antMatchers("/his/**").permitAll()

				.antMatchers("/api/login-mobile").permitAll()
				.antMatchers("/api/login-match-password").permitAll()
				.antMatchers("/api/login").permitAll()
				.antMatchers("/api/login-with-otp").permitAll()
				.antMatchers("/api/forgot-password-get-otp").permitAll()
				.antMatchers("/api/change-password").permitAll()

				.antMatchers("/api/forgot-userid-get-otp").permitAll()
				.antMatchers("/api/forgot-userid-send-sms").permitAll()
				.antMatchers("/api/login-multiple-user").permitAll()
				.antMatchers("/api/login-multiple-user-with-otp").permitAll()
			    .antMatchers("/api/get-reimbursement-list-api").permitAll()
			    .antMatchers("/api/get-advance-policy-list-api").permitAll()
			    
				.antMatchers("/master/rest-viewpaySlipPersonal").permitAll()

				.antMatchers("/employee/getbloodgroupListApi").permitAll()
				.antMatchers("/employee/getgenderListApi").permitAll()
				.antMatchers("/employee/getCountryListApi").permitAll()
				.antMatchers("/employee/getNationalityListApi").permitAll()
                .antMatchers("/employee/get-reimbursement-list-api").permitAll()
                .antMatchers("/employee/get-getDocumentTypeList").permitAll()
                .antMatchers("/employee/deleteEmpDoc").permitAll()
                .antMatchers("/employee/rest-checkEditAvailable").permitAll()
                
                .antMatchers("/master/getStateListForLoc").permitAll()
				
                .antMatchers("/api/get-upload-document-profile-api").permitAll()
                .antMatchers("/api/get-mobile-version").permitAll()
                .antMatchers("/api/check-payslip-eligible-api").permitAll()
                .antMatchers("/api/check-user-eligible-api").permitAll()
                .antMatchers("/api/get-biometric-attendance-api").permitAll()
                
                .antMatchers("/gstreturn/**").permitAll()
				.antMatchers("/gst/**").permitAll()
				.antMatchers("/otp/**").permitAll()

                
                .antMatchers("/api/getClientDetails").permitAll()
                .antMatchers("/api/getClientDetailsByPagination").permitAll()
                .antMatchers("/api/addClientDetails").permitAll()
                .antMatchers("/api/modifyDecisionMaker").permitAll()
                .antMatchers("/api/getClientDetailsEdit").permitAll()
                .antMatchers("/api/getLeadList").permitAll()
                .antMatchers("/api/getDecisionMakerList").permitAll()
                .antMatchers("/api/getClientDetailsSearch").permitAll()
                .antMatchers("/api/getClientDetailsSearchByExecutive").permitAll()
                .antMatchers("/api/upload-customer-profileImg-api").permitAll()
                
                .antMatchers("/api/addCrmTaskMaster").permitAll()
                .antMatchers("/api/viewCrmTaskMaster").permitAll()
                .antMatchers("/api/checkInCrmTaskMaster").permitAll()
                .antMatchers("/api/checkInCrmTaskMaster-api").permitAll()
                .antMatchers("/api/viewCrmTask-visitHistory").permitAll()
                .antMatchers("/api/delete-crmTaskMaster").permitAll()
                
                .antMatchers("/api/getLeadContactList").permitAll()
                .antMatchers("/api/addCrmMeetingMaster").permitAll()
                .antMatchers("/api/viewCrmMeetingMaster").permitAll()
                .antMatchers("/api/checkInCrmMeetingMaster").permitAll()
                .antMatchers("/api/viewCrmMeeting-visitHistory").permitAll()
                .antMatchers("/api/delete-crmMeetingMaster").permitAll()
                
                .antMatchers("/api/addCrmCallMaster").permitAll()
                .antMatchers("/api/viewCrmCallMaster").permitAll()
                .antMatchers("/api/checkInCrmCallMaster").permitAll()
                .antMatchers("/api/viewCrmCall-visitHistory").permitAll()
                .antMatchers("/api/delete-crmCallMaster").permitAll()
                
                .antMatchers("/api/post-deal-final-api").permitAll()
                .antMatchers("/api/viewDealDetails").permitAll()
                .antMatchers("/api/viewDealStatus").permitAll()
                .antMatchers("/api/viewDealDetailsSearch").permitAll()
                .antMatchers("/api/viewDealStatusSearch").permitAll()
                
                .antMatchers("/api/viewCrmCall-visitHistoryReport").permitAll()
                .antMatchers("/api/viewCrmMeeting-visitHistoryReport").permitAll()
                .antMatchers("/api/viewCrmTask-visitHistoryReport").permitAll()
                
                .antMatchers("/api/viewCrmCall-visitHistoryReportSearch").permitAll()
                .antMatchers("/api/viewCrmMeeting-visitHistoryReportSearch").permitAll()
                .antMatchers("/api/viewCrmTask-visitHistoryReportSearch").permitAll()
                .antMatchers("/api/getSalesManagerList").permitAll()
                
                .antMatchers("/api/addClassifiedBillApi").permitAll()
                .antMatchers("/api/viewClassifiedBillApi").permitAll()
                .antMatchers("/api/viewClassifiedBillSearchApi").permitAll()
                .antMatchers("/purchase/**").permitAll()
                .antMatchers("/edms/**").permitAll()
				.antMatchers("/master/payment/**").permitAll()

				.antMatchers("/grc/**").permitAll()
				.antMatchers("/maintenance/**").permitAll()
				.antMatchers("/meeting/**").permitAll()
				.antMatchers("/master/mail/**").permitAll()
				.antMatchers("/canteen/**").permitAll()
				.antMatchers("/appraisal/**").permitAll()
				.antMatchers("/patient/**").permitAll()
				.antMatchers("/hotel/**").permitAll()
				.antMatchers("/his/rest-editCourseDetails").permitAll()
				.antMatchers("/his/rest-editCourseTrainingDetails").permitAll()
				
				.antMatchers("/his/rest-getAllUserTraining").permitAll()
				
				.antMatchers("/his/rest-viewPublicBatches").permitAll()
				
				.antMatchers("/user/getUserByUsernameLMS").permitAll()
				
                
                .antMatchers("/master/rest-save-enrollment-data").permitAll()
                
                .antMatchers("/his/rest-getAllOperationalRecord").permitAll()
                
                .antMatchers("/master/rest-save-user-details-lms").permitAll()
                
                .antMatchers("/his/rest-academic-course-duration-add").permitAll()

                .antMatchers("/master/rest-viewEnrollCourses").permitAll()
				.antMatchers("/his/getCourseList").permitAll()
				.antMatchers("/his/lms-getCountryList").permitAll()
				.antMatchers("/his/lms-contactList").permitAll()



				.antMatchers("/his/lms-getCountryList").permitAll()
				.antMatchers("/his/lms-contactList").permitAll()


				

				

				
				
    // ---- add ALL exam routes here ----
        // list quizzes mapped to product, quiz headers
        .antMatchers("/master/rest-product-quizzes").permitAll()
        .antMatchers("/master/rest-quiz-list").permitAll()

        // runtime (user flows)
              // ===== Runtime – Exam flow =====
			  .antMatchers("/master/rest-exam-eligibilitys").permitAll()      // legacy alias
			  .antMatchers("/master/rest-exam-eligibility").permitAll()
			  .antMatchers("/master/rest-exam-retake-status").permitAll()
	  
			  .antMatchers( "/master/rest-exam-start").permitAll()
			  .antMatchers(  "/master/rest-exam-get-question").permitAll()
			  .antMatchers( "/master/rest-exam-answer").permitAll()
			  .antMatchers( "/master/rest-exam-flag").permitAll()
			  .antMatchers( "/master/rest-exam-submit").permitAll()
			  .antMatchers( "/master/rest-exam-palette").permitAll()
			  .antMatchers(  "/master/rest-exam-attempt-summary").permitAll()
			  .antMatchers(  "/master/rest-exam-result-header").permitAll()
			  .antMatchers(  "/master/rest-exam-result-breakdown").permitAll()
			  .antMatchers( "/master/rest-exam-result-answers").permitAll()
			  .antMatchers("/master/rest-exam-abort").permitAll()
	  
			  // ===== Product outline / questions =====
			  .antMatchers( "/master/rest-product-outline").permitAll()
			  .antMatchers( "/master/rest-product-questions").permitAll()
	  
			  // ===== Retakes (payments/credits) =====
			  .antMatchers( "/master/rest-exam-retake-create-order").permitAll()
			  .antMatchers( "/master/rest-exam-retake-grant-credit").permitAll()
	  
			  // ===== Admin quiz-config JSON (open for now; lock down later) =====
			  .antMatchers( "/master/rest-quiz-config-add").permitAll()
			  .antMatchers(  "/master/rest-viewQuizConfig").permitAll()
			  .antMatchers(  "/master/rest-editQuizConfig").permitAll()
	  
			  // ===== Reports (optional) =====
			  .antMatchers("/master/rest-report-attempts-30d").permitAll()
			  .antMatchers("/master/rest-report-user-history").permitAll()
			  .antMatchers("/master/rest-report-leaderboard").permitAll()
	  
			  // ===== Diagnostics (optional; remove/tighten in prod) =====
			  .antMatchers("/master/rest-exam-ping").permitAll()


			  .antMatchers("/master/mail/send").permitAll()

			  .antMatchers("/master/mail/send-bulk").permitAll()

			  .antMatchers("/master/mail/preview").permitAll()


			
			  .antMatchers("/master/payment/retake/create").permitAll()

			  .antMatchers("/master/payment/retake/confirm").permitAll()

			  .antMatchers("/his/rest-course-progress-save").permitAll()

			  .antMatchers("/his/rest-course-progress-map").permitAll()

			  .antMatchers("/his/rest-course-progress-resume").permitAll()

			  .antMatchers("/his/rest-course-progress-reset").permitAll()

			  .antMatchers("/otp/request").permitAll()

			  .antMatchers("/otp/verify").permitAll()
			  .antMatchers("/diag/**").permitAll()


        // .antMatchers("/master/rest-exam-eligibility", "/diag/**").permitAll()


		

                
				// all other requests need to be authenticated
				.anyRequest().authenticated().and().
				// make sure we use stateless session; session won't be used to
				// store user's state.
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "OPTION", "PUT", "DELETE"));
		configuration.addAllowedHeader("Authorization");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}