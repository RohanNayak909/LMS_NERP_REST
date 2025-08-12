package nirmalya.aatithya.restmodule.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
				.authorizeRequests()
				.antMatchers(AUTH_WHITELIST).permitAll()
				//.antMatchers("/**").permitAll()
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
                

				.antMatchers("/grc/**").permitAll()
				.antMatchers("/maintenance/**").permitAll()
				.antMatchers("/meeting/**").permitAll()
				
				.antMatchers("/canteen/**").permitAll()
				.antMatchers("/appraisal/**").permitAll()
				.antMatchers("/patient/**").permitAll()
				.antMatchers("/hotel/**").permitAll()
				

                
                //.antMatchers("/api/get-departmentLists-api").permitAll()
				
				// all other requests need to be authenticated
				.anyRequest().authenticated().and().
				// make sure we use stateless session; session won't be used to
				// store user's state.
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	/**
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 *           http.csrf().disable().authorizeRequests()
	 *           .antMatchers("/**").permitAll()
	 *           .antMatchers("/swagger-ui.html").permitAll() ; }
	 */

}
