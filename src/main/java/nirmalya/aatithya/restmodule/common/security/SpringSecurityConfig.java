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
				.antMatchers("/his/rest-editCourseDetails").permitAll()
				
				.antMatchers("/user/getUserByUsernameLMS").permitAll()
				
				.antMatchers("/user/getUserByUsernameLMS").permitAll()
                
                .antMatchers("/master/rest-save-enrollment-data").permitAll()
                
                .antMatchers("/his/rest-getAllOperationalRecord").permitAll()
                
                .antMatchers("/master/rest-save-user-details-lms").permitAll()
                
                .antMatchers("/his/rest-academic-course-duration-add").permitAll()

                .antMatchers("/master/rest-viewEnrollCourses").permitAll()

    // ---- add ALL exam routes here ----
        // list quizzes mapped to product, quiz headers
        .antMatchers("/master/rest-product-quizzes").permitAll()
        .antMatchers("/master/rest-quiz-list").permitAll()

        // runtime (user flows)
        .antMatchers("/master/rest-exam-start").permitAll()
        .antMatchers("/master/rest-exam-get-question").permitAll()
        .antMatchers("/master/rest-exam-answer").permitAll()
        .antMatchers("/master/rest-exam-submit").permitAll()
        .antMatchers("/master/rest-exam-result-header").permitAll()
        .antMatchers("/master/rest-exam-result-breakdown").permitAll()
        .antMatchers("/master/rest-product-outline").permitAll()
        .antMatchers("/master/rest-product-questions").permitAll()

        // reports (optional)
        .antMatchers("/master/rest-report-attempts-30d").permitAll()
        .antMatchers("/master/rest-report-user-history").permitAll()
        .antMatchers("/master/rest-report-leaderboard").permitAll()
        .antMatchers("/master/rest-exam-eligibilitys").permitAll()

        // diagnostic (optional; remove in prod)
        .antMatchers("/master/rest-exam-ping", "/diag/**").permitAll()
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
// DELIMITER $$

// DROP PROCEDURE IF EXISTS lms_exam_routines $$
// CREATE DEFINER=`nirmalyastg`@`%` PROCEDURE `lms_exam_routines`(
//   IN actionType VARCHAR(64),
//   IN actionValue LONGTEXT
// )
// BEGIN
//   /* ---- MySQL 5.7: locals first ---- */
//   DECLARE v_seed  INT DEFAULT 0;
//   DECLARE v_mode  VARCHAR(8) DEFAULT 'MOCK';
//   DECLARE v_qno   INT DEFAULT 1;
//   DECLARE v_limit INT DEFAULT 100;

//   /* ---- Hydrate @p_* ---- */
//   IF actionValue IS NOT NULL AND LENGTH(TRIM(actionValue)) > 0 THEN
//     SET @dyn := actionValue;
//     PREPARE s1 FROM @dyn; EXECUTE s1; DEALLOCATE PREPARE s1;
//   END IF;

//   /* ---- Copy to locals ---- */
//   SET v_seed  = IFNULL(@p_seed, 0);
//   SET v_mode  = UPPER(IFNULL(@p_mode, 'MOCK'));
//   SET v_qno   = IFNULL(@p_qno, 1);
//   SET v_limit = IFNULL(@p_limit, 100);

//   /* ======================= RUNTIME ======================= */

//   /* ---------- Eligibility ---------- */
//   IF actionType = 'eligibility' THEN
//   BEGIN
//     DECLARE v_quiz_code VARCHAR(120);
//     DECLARE v_allowed INT DEFAULT 2;
//     DECLARE v_used INT DEFAULT 0;

//     SELECT quiz_code INTO v_quiz_code
//     FROM v_product_quiz_one
//     WHERE product_id = @p_product_id
//     LIMIT 1;

//     IF v_quiz_code IS NULL THEN
//       SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='No ACTIVE quiz mapped to this product_id';
//     END IF;

//     IF v_mode = 'CERT' THEN
//       SELECT LEAST(IFNULL(q.max_attempts,5), 2) INTO v_allowed
//       FROM lms_stg_quiz q WHERE q.quiz_code=v_quiz_code;

//       SELECT IFNULL(MAX(attempt_no),0) INTO v_used
//       FROM lms_quiz_attempt
//       WHERE user_id=@p_user_id AND product_id=@p_product_id AND mode='CERT';
//     ELSE
//       /* MOCK capped at 2 */
//       SELECT LEAST(IFNULL(q.max_attempts,2), 2) INTO v_allowed
//       FROM lms_stg_quiz q WHERE q.quiz_code=v_quiz_code;

//       SELECT IFNULL(MAX(attempt_no),0) INTO v_used
//       FROM lms_quiz_attempt
//       WHERE user_id=@p_user_id AND product_id=@p_product_id AND mode='MOCK';
//     END IF;

//     SELECT
//       v_quiz_code AS quiz_code,
//       v_mode AS mode,
//       v_allowed AS attempts_allowed,
//       v_used AS attempts_used,
//       GREATEST(v_allowed - v_used, 0) AS attempts_remaining;
//   END;

//   ELSEIF actionType = 'productStart' THEN
//     productStartBlock: BEGIN
//       DECLARE v_quiz_code VARCHAR(120);
//       DECLARE v_attempt_no INT;
//       DECLARE v_time_limit INT;
//       DECLARE v_per_q_sec INT DEFAULT 60;
//       DECLARE v_pass_percent DECIMAL(5,2) DEFAULT 60.00;
//       DECLARE v_attempt_id BIGINT;
//       DECLARE v_max_attempts INT;

//       SELECT quiz_code INTO v_quiz_code
//       FROM v_product_quiz_one
//       WHERE product_id = @p_product_id
//       LIMIT 1;

//       IF v_quiz_code IS NULL THEN
//         SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='No ACTIVE quiz mapped to this product_id';
//       END IF;

//       SELECT
//         q.duration_sec,
//         IFNULL(q.total_marks,0),
//         60.00,
//         CASE
//           WHEN v_mode = 'MOCK' THEN LEAST(IFNULL(q.max_attempts,2), 2)
//           ELSE LEAST(IFNULL(q.max_attempts, 5), 2)
//         END
//       INTO v_time_limit, @v_dummy_total, v_pass_percent, v_max_attempts
//       FROM lms_stg_quiz q
//       WHERE q.quiz_code = v_quiz_code;

//       /* >>> NO PER-QUESTION TIMER FOR MOCK <<< */
//       IF v_mode = 'MOCK' THEN
//         SET v_per_q_sec = 0;
//       END IF;

//       SELECT IFNULL(MAX(attempt_no),0)+1 INTO v_attempt_no
//       FROM lms_quiz_attempt
//       WHERE user_id=@p_user_id AND product_id=@p_product_id AND mode=v_mode;

//       IF v_attempt_no > v_max_attempts THEN
//         /* Do not SIGNAL; return a structured row so the DAO can reply 409 */
//         SELECT
//           'ATTEMPT_LIMIT' AS code,
//           CONCAT('You have used all ', v_max_attempts, ' attempts for this test.') AS message,
//           v_max_attempts AS attempts_allowed,
//           (v_attempt_no - 1) AS attempts_used,
//           @p_product_id AS product_id,
//           v_quiz_code   AS quiz_code;
//         LEAVE productStartBlock;
//       END IF;

//       INSERT INTO lms_quiz_attempt(
//         user_id, product_id, quiz_code, mode, attempt_no,
//         quiz_time_limit_sec, per_q_timer_sec, shuffle_q, shuffle_opt,
//         pass_percent, seed, meta_json, needs_manual_review, status
//       ) VALUES (
//         @p_user_id, @p_product_id, v_quiz_code, v_mode, v_attempt_no,
//         v_time_limit, v_per_q_sec, 1, 1,
//         v_pass_percent, v_seed,
//         CASE
//           WHEN @p_meta_json IS NULL OR TRIM(@p_meta_json) = '' THEN NULL
//           WHEN JSON_VALID(@p_meta_json) THEN CAST(@p_meta_json AS JSON)
//           ELSE JSON_OBJECT('raw', @p_meta_json)
//         END,
//         0, 'STARTED'
//       );

//       SET v_attempt_id = LAST_INSERT_ID();
//       SET @qrow := 0;

//       INSERT INTO lms_quiz_attempt_question (
//         attempt_id, quiz_code, section_title, qno, qtype, stem_html,
//         marks, negative_marks, opt_json, opt_order_json, correct_opt_no
//       )
//       SELECT
//         v_attempt_id,
//         t.quiz_code,
//         t.section_title,
//         (@qrow := @qrow + 1) AS qno,
//         'MCQ_SINGLE',
//         t.question_text,
//         1.00,
//         0.00,
//         CAST(
//           CONCAT(
//             '[',
//             (SELECT GROUP_CONCAT(
//                       CONCAT(
//                         '{\"opt_no\":', o.opt_no,
//                         ',\"label\":', JSON_QUOTE(o.label),
//                         ',\"is_correct\":', IF(o.is_correct,'true','false'),
//                         '}'
//                       )
//                       ORDER BY o.order_key SEPARATOR ','
//                     )
//              FROM (
//                SELECT 1 AS opt_no, t.option_a AS label, (UPPER(TRIM(t.right_answer))='A') AS is_correct,
//                       MD5(CONCAT(v_seed, ':O:', LPAD(t.s_no,6,'0'), ':1')) AS order_key
//                UNION ALL
//                SELECT 2, t.option_b, (UPPER(TRIM(t.right_answer))='B'),
//                       MD5(CONCAT(v_seed, ':O:', LPAD(t.s_no,6,'0'), ':2'))
//                UNION ALL
//                SELECT 3, t.option_c, (UPPER(TRIM(t.right_answer))='C'),
//                       MD5(CONCAT(v_seed, ':O:', LPAD(t.s_no,6,'0'), ':3'))
//                UNION ALL
//                SELECT 4, t.option_d, (UPPER(TRIM(t.right_answer))='D'),
//                       MD5(CONCAT(v_seed, ':O:', LPAD(t.s_no,6,'0'), ':4'))
//              ) o
//             ),
//             ']'
//           ) AS JSON
//         ) AS opt_json,
//         CAST(
//           CONCAT(
//             '[',
//             (SELECT GROUP_CONCAT(o.opt_no ORDER BY o.order_key SEPARATOR ',')
//              FROM (
//                SELECT 1 AS opt_no, MD5(CONCAT(v_seed, ':O:', LPAD(t.s_no,6,'0'), ':1')) AS order_key
//                UNION ALL
//                SELECT 2, MD5(CONCAT(v_seed, ':O:', LPAD(t.s_no,6,'0'), ':2'))
//                UNION ALL
//                SELECT 3, MD5(CONCAT(v_seed, ':O:', LPAD(t.s_no,6,'0'), ':3'))
//                UNION ALL
//                SELECT 4, MD5(CONCAT(v_seed, ':O:', LPAD(t.s_no,6,'0'), ':4'))
//              ) o
//             ),
//             ']'
//           ) AS JSON
//         ) AS opt_order_json,
//         CASE UPPER(TRIM(t.right_answer))
//           WHEN 'A' THEN 1
//           WHEN 'B' THEN 2
//           WHEN 'C' THEN 3
//           WHEN 'D' THEN 4
//           ELSE NULL
//         END AS correct_opt_no
//       FROM (
//         SELECT s.*
//         FROM lms_stg_question_simple s
//         WHERE s.quiz_code = v_quiz_code
//         ORDER BY MD5(CONCAT(v_seed, ':Q:', LPAD(s.s_no,6,'0')))
//       ) AS t;

//       INSERT INTO lms_quiz_attempt_event (attempt_id, evt_type, details_json)
//       VALUES (v_attempt_id, 'START',
//               JSON_OBJECT('product_id', @p_product_id, 'quiz_code', v_quiz_code, 'mode', v_mode));

//       SELECT v_attempt_id AS attemptId;
//     END;

//   ELSEIF actionType = 'productGetQuestion' THEN
//     BEGIN
//       DECLARE v_attempt_id BIGINT;
//       SELECT id INTO v_attempt_id
//       FROM lms_quiz_attempt
//       WHERE user_id=@p_user_id AND product_id=@p_product_id
//       ORDER BY id DESC LIMIT 1;

//       IF v_attempt_id IS NULL THEN
//         SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='No attempt found. Start first.';
//       END IF;

//       SELECT
//         aq.id            AS attempt_question_id,
//         aq.qno,
//         aq.qtype,
//         aq.section_title,
//         aq.stem_html,
//         aq.marks,
//         aq.negative_marks,
//         aq.opt_json,
//         aq.opt_order_json,
//         aq.chosen_opt_json,
//         aq.subjective_text,
//         aq.time_spent_sec,
//         a.per_q_timer_sec,
//         a.quiz_time_limit_sec,
//         a.started_at,
//         aq.is_flagged
//       FROM lms_quiz_attempt_question aq
//       JOIN lms_quiz_attempt a ON a.id = aq.attempt_id
//       WHERE aq.attempt_id = v_attempt_id
//         AND aq.qno = v_qno;
//     END;

//   ELSEIF actionType = 'productAnswer' THEN
//     BEGIN
//       DECLARE v_attempt_id BIGINT;
//       DECLARE v_aq_id BIGINT;
//       DECLARE v_qtype VARCHAR(32);
//       DECLARE v_marks DECIMAL(10,2);
//       DECLARE v_neg DECIMAL(10,2);
//       DECLARE v_correct_no INT;
//       DECLARE v_sel_no INT;
//       DECLARE v_is_correct TINYINT;
//       DECLARE v_awarded DECIMAL(10,2);

//       SELECT id INTO v_attempt_id
//       FROM lms_quiz_attempt
//       WHERE user_id=@p_user_id AND product_id=@p_product_id
//       ORDER BY id DESC LIMIT 1;

//       IF v_attempt_id IS NULL THEN
//         SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='No attempt found. Start first.';
//       END IF;

//       SELECT id, qtype, marks, negative_marks, correct_opt_no
//       INTO v_aq_id, v_qtype, v_marks, v_neg, v_correct_no
//       FROM lms_quiz_attempt_question
//       WHERE attempt_id=v_attempt_id AND qno=v_qno
//       FOR UPDATE;

//       IF v_aq_id IS NULL THEN
//         SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='Question not found for attempt';
//       END IF;

//       SET v_sel_no = NULL;
//       IF @p_selected IS NOT NULL AND LENGTH(TRIM(@p_selected))>0 THEN
//         SET @sel_txt := REPLACE(REPLACE(REPLACE(TRIM(@p_selected),'[',''),']',''),' ','');
//         SET @sel_txt := IF(LOCATE(',', @sel_txt)>0, LEFT(@sel_txt, LOCATE(',',@sel_txt)-1), @sel_txt);
//         SET v_sel_no := CAST(@sel_txt AS UNSIGNED);
//       END IF;

//       IF v_qtype='MCQ_SINGLE' THEN
//         SET v_is_correct := IF(v_sel_no IS NOT NULL AND v_sel_no=v_correct_no, 1, 0);
//         SET v_awarded    := IF(v_is_correct=1, v_marks, IF(v_neg>0, -v_neg, 0));

//         UPDATE lms_quiz_attempt_question
//         SET chosen_opt_json = CASE
//                                 WHEN @p_selected IS NULL OR TRIM(@p_selected) = '' THEN NULL
//                                 WHEN JSON_VALID(@p_selected) THEN CAST(@p_selected AS JSON)
//                                 ELSE NULL
//                               END,
//             is_correct       = v_is_correct,
//             awarded_marks    = v_awarded,
//             time_spent_sec   = IFNULL(time_spent_sec,0) + IFNULL(@p_time_spent_sec,0),
//             answered_at      = CURRENT_TIMESTAMP
//         WHERE id = v_aq_id;
//       ELSE
//         UPDATE lms_quiz_attempt_question
//         SET subjective_text = @p_subjective,
//             is_correct      = NULL,
//             awarded_marks   = NULL,
//             time_spent_sec  = IFNULL(time_spent_sec,0) + IFNULL(@p_time_spent_sec,0),
//             answered_at     = CURRENT_TIMESTAMP
//         WHERE id = v_aq_id;
//       END IF;

//       INSERT INTO lms_quiz_attempt_event (attempt_id, evt_type, details_json)
//       VALUES (v_attempt_id, 'ANSWER', JSON_OBJECT('qno', v_qno));

//       SELECT 'OK' AS status;
//     END;

//   ELSEIF actionType = 'productFlag' THEN
//     BEGIN
//       DECLARE v_attempt_id BIGINT;
//       DECLARE v_aq_id BIGINT;
//       DECLARE v_flag TINYINT;

//       SET v_flag := IFNULL(@p_flagged, 1);

//       SELECT id INTO v_attempt_id
//       FROM lms_quiz_attempt
//       WHERE user_id=@p_user_id AND product_id=@p_product_id
//       ORDER BY id DESC LIMIT 1;

//       IF v_attempt_id IS NULL THEN
//         SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='No attempt found. Start first.';
//       END IF;

//       SELECT id INTO v_aq_id
//       FROM lms_quiz_attempt_question
//       WHERE attempt_id=v_attempt_id AND qno=v_qno
//       FOR UPDATE;

//       IF v_aq_id IS NULL THEN
//         SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='Question not found for attempt';
//       END IF;

//       UPDATE lms_quiz_attempt_question
//       SET is_flagged = v_flag
//       WHERE id = v_aq_id;

//       INSERT INTO lms_quiz_attempt_event (attempt_id, evt_type, details_json)
//       VALUES (v_attempt_id, 'FLAG', JSON_OBJECT('qno', v_qno, 'flagged', v_flag));

//       SELECT 'OK' AS status, v_flag AS flagged;
//     END;

//   ELSEIF actionType = 'productSubmit' THEN
//     BEGIN
//       DECLARE v_attempt_id BIGINT;
//       DECLARE v_pass_percent DECIMAL(5,2);
//       DECLARE v_total_marks DECIMAL(10,2);
//       DECLARE v_has_subjective INT;
//       DECLARE v_total_score DECIMAL(10,2) DEFAULT 0.00;
//       DECLARE v_passed TINYINT DEFAULT 0;

//       SELECT id INTO v_attempt_id
//       FROM lms_quiz_attempt
//       WHERE user_id=@p_user_id AND product_id=@p_product_id
//       ORDER BY id DESC LIMIT 1;

//       IF v_attempt_id IS NULL THEN
//         SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='No attempt found. Start first.';
//       END IF;

//       SELECT
//         a.pass_percent,
//         (SELECT IFNULL(SUM(aq.marks),0) FROM lms_quiz_attempt_question aq WHERE aq.attempt_id=a.id),
//         (SELECT COUNT(*) FROM lms_quiz_attempt_question aq WHERE aq.attempt_id=a.id AND aq.qtype='SUBJECTIVE')
//       INTO v_pass_percent, v_total_marks, v_has_subjective
//       FROM lms_quiz_attempt a
//       WHERE a.id = v_attempt_id
//       FOR UPDATE;

//       SELECT IFNULL(SUM(awarded_marks),0) INTO v_total_score
//       FROM lms_quiz_attempt_question
//       WHERE attempt_id = v_attempt_id;

//       SET v_passed = CASE
//         WHEN v_total_marks = 0 THEN 0
//         WHEN (v_total_score / v_total_marks * 100.0) >= v_pass_percent THEN 1
//         ELSE 0
//       END;

//       UPDATE lms_quiz_attempt
//       SET total_score = v_total_score,
//           passed = v_passed,
//           status = CASE WHEN v_has_subjective>0 THEN 'NEEDS_REVIEW' ELSE 'SUBMITTED' END,
//           submitted_at = CURRENT_TIMESTAMP,
//           duration_sec = TIMESTAMPDIFF(SECOND, started_at, CURRENT_TIMESTAMP)
//       WHERE id = v_attempt_id;

//       INSERT INTO lms_quiz_attempt_event (attempt_id, evt_type, details_json)
//       VALUES (v_attempt_id, 'SUBMIT', JSON_OBJECT('total_score', v_total_score, 'passed', v_passed));

//       SELECT v_total_score AS totalScore, v_passed AS passed;
//     END;

//   ELSEIF actionType = 'productPalette' THEN
//     BEGIN
//       DECLARE v_attempt_id3 BIGINT;
//       SELECT id INTO v_attempt_id3
//       FROM lms_quiz_attempt
//       WHERE user_id=@p_user_id AND product_id=@p_product_id
//       ORDER BY id DESC LIMIT 1;

//       IF v_attempt_id3 IS NULL THEN
//         SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='No attempt found.';
//       END IF;

//       SELECT
//         aq.qno,
//         (aq.chosen_opt_json IS NOT NULL OR (aq.subjective_text IS NOT NULL AND subjective_text <> '')) AS is_answered,
//         aq.is_flagged,
//         aq.is_correct,
//         aq.answered_at IS NOT NULL AS was_viewed
//       FROM lms_quiz_attempt_question aq
//       WHERE aq.attempt_id = v_attempt_id3
//       ORDER BY aq.qno;
//     END;

//   ELSEIF actionType = 'productAttemptSummary' THEN
//     BEGIN
//       DECLARE v_attempt_id4 BIGINT;
//       DECLARE v_total INT; DECLARE v_answered INT; DECLARE v_flagged INT; DECLARE v_viewed INT;
//       DECLARE v_correct INT; DECLARE v_incorrect INT;
//       DECLARE v_started DATETIME; DECLARE v_time_limit INT;

//       SELECT id, started_at, quiz_time_limit_sec
//         INTO v_attempt_id4, v_started, v_time_limit
//       FROM lms_quiz_attempt
//       WHERE user_id=@p_user_id AND product_id=@p_product_id
//       ORDER BY id DESC LIMIT 1;

//       IF v_attempt_id4 IS NULL THEN
//         SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='No attempt found.';
//       END IF;

//       SELECT COUNT(*) INTO v_total
//       FROM lms_quiz_attempt_question WHERE attempt_id=v_attempt_id4;

//       SELECT COUNT(*) INTO v_answered
//       FROM lms_quiz_attempt_question
//       WHERE attempt_id=v_attempt_id4 AND
//             (chosen_opt_json IS NOT NULL OR (subjective_text IS NOT NULL AND subjective_text <> ''));

//       SELECT COUNT(*) INTO v_flagged
//       FROM lms_quiz_attempt_question
//       WHERE attempt_id=v_attempt_id4 AND is_flagged=1;

//       SELECT COUNT(*) INTO v_viewed
//       FROM lms_quiz_attempt_question
//       WHERE attempt_id=v_attempt_id4 AND answered_at IS NOT NULL;

//       SELECT COUNT(*) INTO v_correct
//       FROM lms_quiz_attempt_question
//       WHERE attempt_id=v_attempt_id4 AND IFNULL(is_correct,0)=1;

//       SELECT COUNT(*) INTO v_incorrect
//       FROM lms_quiz_attempt_question
//       WHERE attempt_id=v_attempt_id4 AND IFNULL(is_correct,0)=0
//             AND chosen_opt_json IS NOT NULL;

//       SELECT
//         v_total            AS total_questions,
//         v_answered         AS answered_count,
//         (v_total - v_answered) AS not_answered_count,
//         v_flagged          AS flagged_count,
//         v_viewed           AS viewed_count,
//         v_correct          AS correct_count,
//         v_incorrect        AS incorrect_count,
//         TIMESTAMPDIFF(SECOND, v_started, NOW()) AS elapsed_sec,
//         GREATEST(0, IFNULL(v_time_limit,0) - TIMESTAMPDIFF(SECOND, v_started, NOW())) AS remaining_sec;
//     END;

//   /* ======================= RESULTS & REPORTS ======================= */

//   ELSEIF actionType = 'resultHeader' THEN
//     SELECT *
//     FROM lms_quiz_attempt
//     WHERE user_id=@p_user_id AND product_id=@p_product_id
//     ORDER BY id DESC LIMIT 1;

//   ELSEIF actionType = 'resultBreakdown' THEN
//     BEGIN
//       DECLARE v_attempt_id2 BIGINT;
//       SELECT id INTO v_attempt_id2
//       FROM lms_quiz_attempt
//       WHERE user_id=@p_user_id AND product_id=@p_product_id
//       ORDER BY id DESC LIMIT 1;

//       IF v_attempt_id2 IS NULL THEN
//         SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='No attempt found.';
//       END IF;

//       SELECT
//         aq.qno, aq.qtype, aq.section_title,
//         aq.marks, aq.negative_marks, aq.is_correct, aq.awarded_marks,
//         aq.opt_json, aq.chosen_opt_json, aq.subjective_text,
//         aq.is_flagged
//       FROM lms_quiz_attempt_question aq
//       WHERE aq.attempt_id = v_attempt_id2
//       ORDER BY aq.qno;
//     END;

//   ELSEIF actionType = 'resultAnswers' THEN
//   BEGIN
//     DECLARE v_attempt_id5 BIGINT;

//     SELECT id INTO v_attempt_id5
//     FROM lms_quiz_attempt
//     WHERE user_id=@p_user_id AND product_id=@p_product_id
//     ORDER BY id DESC LIMIT 1;

//     IF v_attempt_id5 IS NULL THEN
//       SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='No attempt found.';
//     END IF;

//     SELECT
//       aq.qno,
//       aq.section_title,
//       CAST(aq.stem_html AS CHAR)       AS question_text,
//       CAST(aq.opt_json AS CHAR)        AS opt_json,
//       CAST(aq.chosen_opt_json AS CHAR) AS chosen_opt_json,
//       aq.correct_opt_no,
//       CASE aq.correct_opt_no WHEN 1 THEN 'A' WHEN 2 THEN 'B' WHEN 3 THEN 'C' WHEN 4 THEN 'D' END AS correct_letter,
//       aq.is_correct,
//       aq.awarded_marks,
//       CAST(NULLIF(JSON_UNQUOTE(JSON_EXTRACT(aq.chosen_opt_json, '$[0]')), '') AS UNSIGNED) AS selected_opt_no,
//       CASE CAST(NULLIF(JSON_UNQUOTE(JSON_EXTRACT(aq.chosen_opt_json, '$[0]')), '') AS UNSIGNED)
//         WHEN 1 THEN 'A' WHEN 2 THEN 'B' WHEN 3 THEN 'C' WHEN 4 THEN 'D' END AS selected_letter,
//       CASE aq.correct_opt_no
//         WHEN 1 THEN qs.rationale_a WHEN 2 THEN qs.rationale_b WHEN 3 THEN qs.rationale_c WHEN 4 THEN qs.rationale_d
//       END AS rationale_correct,
//       CASE CAST(NULLIF(JSON_UNQUOTE(JSON_EXTRACT(aq.chosen_opt_json, '$[0]')), '') AS UNSIGNED)
//         WHEN 1 THEN qs.rationale_a WHEN 2 THEN qs.rationale_b WHEN 3 THEN qs.rationale_c WHEN 4 THEN qs.rationale_d
//       END AS rationale_selected,
//       CAST(JSON_OBJECT('1',qs.rationale_a,'2',qs.rationale_b,'3',qs.rationale_c,'4',qs.rationale_d) AS CHAR) AS rationale_map_json,
//       CASE
//         WHEN aq.chosen_opt_json IS NULL OR JSON_LENGTH(aq.chosen_opt_json) = 0 THEN
//           CONCAT('You did not answer. The correct answer is ',
//                  CASE aq.correct_opt_no WHEN 1 THEN 'A' WHEN 2 THEN 'B' WHEN 3 THEN 'C' WHEN 4 THEN 'D' END)
//         WHEN aq.is_correct = 1 THEN 'Correct.'
//         ELSE CONCAT('Your answer ',
//                     CASE CAST(JSON_UNQUOTE(JSON_EXTRACT(aq.chosen_opt_json,'$[0]')) AS UNSIGNED)
//                       WHEN 1 THEN 'A' WHEN 2 THEN 'B' WHEN 3 THEN 'C' WHEN 4 THEN 'D' END,
//                     ' is incorrect. Correct is ',
//                     CASE aq.correct_opt_no WHEN 1 THEN 'A' WHEN 2 THEN 'B' WHEN 3 THEN 'C' WHEN 4 THEN 'D' END)
//       END AS analysis_text,
//       aq.is_flagged
//     FROM lms_quiz_attempt_question aq
//     JOIN lms_quiz_attempt a ON a.id = aq.attempt_id
//     LEFT JOIN lms_stg_question_simple qs
//       ON qs.quiz_code = aq.quiz_code
//      AND TRIM(LEFT(qs.question_text,80)) = TRIM(LEFT(aq.stem_html,80))
//     WHERE aq.attempt_id = v_attempt_id5
//     ORDER BY aq.qno;
//   END;

//   ELSEIF actionType = 'outline' THEN
//     BEGIN
//       SELECT
//         q.quiz_code, q.quiz_title, q.quiz_description,
//         q.duration_sec, q.total_marks,
//         LEAST(IFNULL(q.max_attempts, 5), 2) AS max_attempts,
//         q.status
//       FROM lms_stg_quiz q
//       JOIN v_product_quiz_one m ON m.quiz_code=q.quiz_code
//       WHERE m.product_id = @p_product_id;

//       SELECT s.section_title, COUNT(*) AS question_count
//       FROM lms_stg_question_simple s
//       JOIN v_product_quiz_one m ON m.quiz_code=s.quiz_code
//       WHERE m.product_id = @p_product_id
//       GROUP BY s.section_title
//       ORDER BY s.section_title;
//     END;

//   ELSEIF actionType = 'questionList' THEN
//     SELECT s.quiz_code, s.section_title, s.s_no AS source_qno,
//            LEFT(s.question_text, 180) AS stem_preview
//     FROM lms_stg_question_simple s
//     JOIN v_product_quiz_one m ON m.quiz_code=s.quiz_code
//     WHERE m.product_id = @p_product_id
//     ORDER BY s.section_title, s.s_no;

//   /* ======================= ADMIN / LISTS ======================= */

//   ELSEIF actionType = 'quizList' THEN
//     BEGIN
//       IF @p_status IS NULL OR @p_status = '' THEN
//         SELECT * FROM lms_stg_quiz ORDER BY quiz_code;
//       ELSE
//         SELECT * FROM lms_stg_quiz WHERE status=@p_status ORDER BY quiz_code;
//       END IF;
//     END;

//   ELSEIF actionType = 'productQuizzes' THEN
//     BEGIN
//       IF @p_product_id IS NULL OR @p_product_id = '' THEN
//         SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='productQuizzes needs @p_product_id';
//       END IF;

//       SELECT
//         m.course_product_id AS product_id,
//         m.quiz_code,
//         m.is_primary,
//         m.status AS map_status,
//         q.quiz_title,
//         q.status AS quiz_status
//       FROM lms_stg_course_quiz_map m
//       LEFT JOIN lms_stg_quiz q ON q.quiz_code = m.quiz_code
//       WHERE m.course_product_id=@p_product_id
//       ORDER BY m.is_primary DESC, m.quiz_code;
//     END;

//   /* ======================= REPORTS ======================= */

//   ELSEIF actionType = 'reportAttempts30d' THEN
//     SELECT
//       a.product_id,
//       (SELECT quiz_title FROM lms_stg_quiz q
//         JOIN v_product_quiz_one m ON m.quiz_code=q.quiz_code
//         WHERE m.product_id=a.product_id LIMIT 1) AS product_quiz_title,
//       COUNT(a.id) attempts,
//       SUM(a.passed) passes,
//       ROUND(AVG(a.total_score),2) avg_score,
//       MIN(a.started_at) first_attempt,
//       MAX(a.submitted_at) last_attempt
//     FROM lms_quiz_attempt a
//     WHERE a.started_at >= NOW() - INTERVAL 30 DAY
//     GROUP BY a.product_id
//     ORDER BY attempts DESC;

//   ELSEIF actionType = 'reportUserHistory' THEN
//     SELECT
//       a.user_id, a.product_id, a.mode, a.attempt_no,
//       a.total_score, a.passed, a.status,
//       a.started_at, a.submitted_at, a.duration_sec
//     FROM lms_quiz_attempt a
//     WHERE a.user_id = @p_user_id
//     ORDER BY a.started_at DESC;

//   ELSEIF actionType = 'reportLeaderboard' THEN
//     SELECT a.user_id, a.product_id, MAX(a.total_score) AS best_score
//     FROM lms_quiz_attempt a
//     WHERE a.product_id = @p_product_id AND a.status IN ('SUBMITTED','NEEDS_REVIEW')
//     GROUP BY a.product_id, a.user_id
//     ORDER BY best_score DESC
//     LIMIT v_limit;

//   /* ======================= ADMIN: QUIZ + MAPPING ======================= */

//   ELSEIF actionType = 'quizUpsert' THEN
//     BEGIN
//       INSERT INTO lms_stg_quiz(
//         quiz_code, quiz_title, quiz_description, author_name,
//         duration_sec, total_marks, max_attempts, status
//       ) VALUES (
//         @p_quiz_code, @p_quiz_title, @p_quiz_description, @p_author_name,
//         @p_duration_sec, @p_total_marks, @p_max_attempts, COALESCE(@p_status,'DRAFT')
//       )
//       ON DUPLICATE KEY UPDATE
//         quiz_title       = VALUES(quiz_title),
//         quiz_description = VALUES(quiz_description),
//         author_name      = VALUES(author_name),
//         duration_sec     = VALUES(duration_sec),
//         total_marks      = VALUES(total_marks),
//         max_attempts     = VALUES(max_attempts),
//         status           = VALUES(status);

//       SELECT 'OK' AS status, @p_quiz_code AS quiz_code;
//     END;

//   ELSEIF actionType = 'quizPublish' THEN
//     BEGIN
//       UPDATE lms_stg_quiz SET status='PUBLISHED'
//       WHERE quiz_code=@p_quiz_code;

//       IF @p_product_id IS NOT NULL THEN
//         INSERT INTO lms_stg_course_quiz_map(quiz_code, course_product_id, is_primary, status)
//         VALUES (@p_quiz_code, @p_product_id, IFNULL(@p_is_primary,1), COALESCE(@p_map_status,'ACTIVE'))
//         ON DUPLICATE KEY UPDATE
//           is_primary = VALUES(is_primary),
//           status     = VALUES(status);
//       END IF;

//       SELECT 'OK' AS status, @p_quiz_code AS quiz_code, @p_product_id AS product_id;
//     END;

//   ELSEIF actionType = 'quizArchive' THEN
//     BEGIN
//       UPDATE lms_stg_quiz SET status='ARCHIVED' WHERE quiz_code=@p_quiz_code;
//       SELECT 'OK' AS status, @p_quiz_code AS quiz_code;
//     END;

//   ELSEIF actionType = 'quizRestore' THEN
//     BEGIN
//       UPDATE lms_stg_quiz
//       SET status = COALESCE(@p_to_status,'DRAFT')
//       WHERE quiz_code=@p_quiz_code;
//       SELECT 'OK' AS status, @p_quiz_code AS quiz_code, COALESCE(@p_to_status,'DRAFT') AS status_set;
//     END;

//   ELSEIF actionType = 'mapAdd' THEN
//     BEGIN
//       INSERT INTO lms_stg_course_quiz_map(quiz_code, course_product_id, is_primary, status)
//       VALUES (@p_quiz_code, @p_product_id, IFNULL(@p_is_primary,0), COALESCE(@p_status,'ACTIVE'))
//       ON DUPLICATE KEY UPDATE
//         is_primary = VALUES(is_primary),
//         status     = VALUES(status);
//       SELECT 'OK' AS status, @p_product_id AS product_id, @p_quiz_code AS quiz_code;
//     END;

//   ELSEIF actionType = 'mapRemove' THEN
//     BEGIN
//       DELETE FROM lms_stg_course_quiz_map
//       WHERE course_product_id=@p_product_id AND quiz_code=@p_quiz_code;
//       SELECT 'OK' AS status, @p_product_id AS product_id, @p_quiz_code AS quiz_code;
//     END;

//   ELSEIF actionType = 'mapSetPrimary' THEN
//     BEGIN
//       UPDATE lms_stg_course_quiz_map
//       SET is_primary=0
//       WHERE course_product_id=@p_product_id;

//       UPDATE lms_stg_course_quiz_map
//       SET is_primary=1, status=COALESCE(@p_status,'ACTIVE')
//       WHERE course_product_id=@p_product_id AND quiz_code=@p_quiz_code;

//       SELECT 'OK' AS status, @p_product_id AS product_id, @p_quiz_code AS quiz_code;
//     END;

//   ELSEIF actionType = 'mapBulkStatus' THEN
//     BEGIN
//       UPDATE lms_stg_course_quiz_map
//       SET status=@p_status
//       WHERE course_product_id=@p_product_id;

//       SELECT 'OK' AS status, @p_product_id AS product_id, @p_status AS status_set;
//     END;

//   /* ======================= ADMIN: QUESTIONS ======================= */
//   ELSEIF actionType = 'questionUpsertSimple' THEN
//     BEGIN
//       /* Single MCQ row insert/update for lms_stg_question_simple */
//       INSERT INTO lms_stg_question_simple (
//         quiz_code, section_title, s_no, question_text,
//         option_a, option_b, option_c, option_d, right_answer,
//         rationale_a, rationale_b, rationale_c, rationale_d
//       ) VALUES (
//         @p_quiz_code, @p_section_title, @p_s_no, @p_question_text,
//         @p_option_a, @p_option_b, @p_option_c, @p_option_d, @p_right_answer,
//         @p_rationale_a, @p_rationale_b, @p_rationale_c, @p_rationale_d
//       )
//       ON DUPLICATE KEY UPDATE
//         section_title = VALUES(section_title),
//         question_text = VALUES(question_text),
//         option_a = VALUES(option_a),
//         option_b = VALUES(option_b),
//         option_c = VALUES(option_c),
//         option_d = VALUES(option_d),
//         right_answer = VALUES(right_answer),
//         rationale_a = VALUES(rationale_a),
//         rationale_b = VALUES(rationale_b),
//         rationale_c = VALUES(rationale_c),
//         rationale_d = VALUES(rationale_d);

//       SELECT 'OK' AS status;
//     END;

//   ELSEIF actionType = 'questionBulkImportSimple' THEN
//     BEGIN
//       /* Expect @p_bulk_json as JSON array of rows with columns matching questionUpsertSimple */
//       IF @p_bulk_json IS NULL OR JSON_VALID(@p_bulk_json) = 0 THEN
//         SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='Bulk JSON missing or invalid';
//       END IF;

//       SET @i := 0;
//       SET @n := JSON_LENGTH(@p_bulk_json);
//       WHILE @i < @n DO
//         SET @row := JSON_EXTRACT(@p_bulk_json, CONCAT('$[', @i, ']'));
//         INSERT INTO lms_stg_question_simple(
//           quiz_code, section_title, s_no, question_text,
//           option_a, option_b, option_c, option_d, right_answer,
//           rationale_a, rationale_b, rationale_c, rationale_d
//         )
//         VALUES(
//           JSON_UNQUOTE(JSON_EXTRACT(@row,'$.quiz_code')),
//           JSON_UNQUOTE(JSON_EXTRACT(@row,'$.section_title')),
//           CAST(JSON_UNQUOTE(JSON_EXTRACT(@row,'$.s_no')) AS UNSIGNED),
//           JSON_UNQUOTE(JSON_EXTRACT(@row,'$.question_text')),
//           JSON_UNQUOTE(JSON_EXTRACT(@row,'$.option_a')),
//           JSON_UNQUOTE(JSON_EXTRACT(@row,'$.option_b')),
//           JSON_UNQUOTE(JSON_EXTRACT(@row,'$.option_c')),
//           JSON_UNQUOTE(JSON_EXTRACT(@row,'$.option_d')),
//           JSON_UNQUOTE(JSON_EXTRACT(@row,'$.right_answer')),
//           JSON_UNQUOTE(JSON_EXTRACT(@row,'$.rationale_a')),
//           JSON_UNQUOTE(JSON_EXTRACT(@row,'$.rationale_b')),
//           JSON_UNQUOTE(JSON_EXTRACT(@row,'$.rationale_c')),
//           JSON_UNQUOTE(JSON_EXTRACT(@row,'$.rationale_d'))
//         )
//         ON DUPLICATE KEY UPDATE
//           section_title = VALUES(section_title),
//           question_text = VALUES(question_text),
//           option_a = VALUES(option_a),
//           option_b = VALUES(option_b),
//           option_c = VALUES(option_c),
//           option_d = VALUES(option_d),
//           right_answer = VALUES(right_answer),
//           rationale_a = VALUES(rationale_a),
//           rationale_b = VALUES(rationale_b),
//           rationale_c = VALUES(rationale_c),
//           rationale_d = VALUES(rationale_d);

//         SET @i := @i + 1;
//       END WHILE;

//       SELECT 'OK' AS status, @n AS rows_processed;
//     END;

//   ELSE
//     BEGIN
//       SET @msg := CONCAT('Unknown actionType: ', actionType);
//       SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @msg;
//     END;
//   END IF;
// END $$

// DELIMITER ;
