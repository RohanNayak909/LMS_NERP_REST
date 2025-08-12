package nirmalya.aatithya.restmodule.api.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.model.ApiUserModel;
import nirmalya.aatithya.restmodule.api.model.AttendanceModel;
import nirmalya.aatithya.restmodule.api.model.EmployeeProfileApiModel;
import nirmalya.aatithya.restmodule.api.model.MobileVersionApiModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.MailService;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAttendanceManagementParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateParamEmployeeProfileParameter;
import nirmalya.aatithya.restmodule.common.utils.GenerateemployeemasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeAddressRestModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.security.config.JwtTokenUtil;
import nirmalya.aatithya.restmodule.service.JwtUserDetailsService;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.PushNotification;
import nirmalya.aatithya.restmodule.util.StringUtil;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class SignUpLogInDao {

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	PasswordEncoder passEncoder;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	EnvironmentVaribles env;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@Autowired
	EntityManager entityManager;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	JavaMailSender  javaMailSender ;

	
	PushNotification pushNotification = new PushNotification();

	Logger logger = LoggerFactory.getLogger(SignUpLogInDao.class);

	public static String generateRandom(int length) {
		Random random = new Random();
		char[] digits = new char[length];
		digits[0] = (char) (random.nextInt(9) + '1');
		for (int i = 1; i < length; i++) {
			digits[i] = (char) (random.nextInt(10) + '0');
		}
		return new String(digits);
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<ApiUserModel> getLoginMultipleUserDetails(String mobileNo, String password) {
		logger.info("Method : getLoginMultipleUserDetails starts");

		JsonResponse<ApiUserModel> jsonResponse = new JsonResponse<ApiUserModel>();
		jsonResponse.setCode("");
		jsonResponse.setMessage("");

		List<ApiUserModel> userArray = new ArrayList<ApiUserModel>();
		List<String> userRole = new ArrayList<String>();

		String value = "SET @p_userName='" + mobileNo + "';";
		logger.info("value===mob===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("userRoutines")
					.setParameter("actionType", "getByName-mob").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				logger.info("Amar===========" + Arrays.toString(m));
				String role = (String) m[6];

				if (role != null && role.length() > 0) {
					String[] roles = role.split(",");
					userRole = Arrays.asList(roles);
				}

				Boolean boolean1 = false;
				if (m[5].toString() != null) {
					String data = m[5].toString();
					if (data.contentEquals("1")) {
						boolean1 = true;
					} else {
						boolean1 = false;
					}
				}
				String orglogo = null;
				if (m[16] != null && m[16] != "" && m[16] != " " && !m[16].toString().equals(" ")
						&& !m[16].toString().equals(null) && !m[16].toString().equals("")) {
					orglogo = env.getMobileView() + "document/document/" + m[16].toString();
				} else {
					orglogo = "";
				}
				ApiUserModel user = new ApiUserModel(m[0].toString(), m[1], m[2], m[3], m[4], null, null, null, null,
						null, null, boolean1, null, null, userRole, m[7], m[8], m[9], m[10], m[11], null, m[13], m[14],
						m[15], orglogo, null,null,null,null);
				userArray.add(user);
			}

			String encodePassword = userArray.get(0).getUserPassword();

			logger.info("Method : getLoginMultipleUserDetails ends");
			if (userArray.size() > 0) {

				final UserDetails userDetails = userDetailsService.loadUserByUsername(userArray.get(0).getUser());
				userArray.get(0).setToken("Bearer " + jwtTokenUtil.generateToken(userDetails));
				userArray.get(0).setImeiNo("null");
				logger.info("User Array aaa =====" + userArray);
				if (passEncoder.matches(password, encodePassword)) {

					Util.setJsonResponse(jsonResponse, userArray.get(0), ResponseStatus.success,
							ApiResponseMessage.DATA_FETCH_SUCCESS);
				} else {

					List<String> blankArray = new ArrayList<String>();
					Util.setJsonResponse(jsonResponse, blankArray, ResponseStatus.failed,
							ApiResponseMessage.PASSWORD_INCORRECT);
					return jsonResponse;
				}

			}

		} catch (Exception e) {
			List<String> blankArray = new ArrayList<String>();
			Util.setJsonResponse(jsonResponse, blankArray, ResponseStatus.failed, ApiResponseMessage.LOGIN_FAILED);
		}

		logger.info("Method : getLoginMultipleUserDetails ends");
		return jsonResponse;

	}
	//login api
		@SuppressWarnings("unchecked")
		public JsonResponse<ApiUserModel> getLoginApi(String userName, String password, String imeiNo) {
			logger.info("Method : getLoginApi starts");

			JsonResponse<ApiUserModel> jsonResponse = new JsonResponse<ApiUserModel>();
			jsonResponse.setCode("");
			jsonResponse.setMessage("");
			Boolean validity = true;
			logger.info("password==="+password);
			if (password == null || password == "" || password.contentEquals("")) {
				jsonResponse.setCode("failed");
				jsonResponse.setMessage("Password required");
				validity = false;
			}
			if (userName == null || userName == "" || userName.contentEquals("")) {
				jsonResponse.setCode("failed");
				jsonResponse.setMessage("User Name required");
				validity = false;
			}
			logger.info("validity==="+validity);

			List<ApiUserModel> userArray = new ArrayList<ApiUserModel>();
			List<String> userRole = new ArrayList<String>();

			String value = "SET @p_userName='" + userName + "',@p_imeiNo='" + imeiNo+ "';";
			logger.info("value for api login ===" + value);
			if (validity) {
				Boolean empidVal = checkDuplicateDao.isValidUserName(userName);
				if (empidVal) {
							try {
								List<Object[]> x = em.createNamedStoredProcedureQuery("userRoutines")
										.setParameter("actionType", "loginThroughMobileApi").setParameter("actionValue", value)
										.getResultList();
								for (Object[] m : x) {
									logger.info("Amar===========" + Arrays.toString(m));
									String role = (String) m[6];

									if (role != null && role.length() > 0) {
										String[] roles = role.split(",");
										userRole = Arrays.asList(roles);
									}

									Boolean boolean1 = false;
									if (m[5].toString() != null) {
										String data = m[5].toString();
										if (data.contentEquals("1")) {
											boolean1 = true;
										} else {
											boolean1 = false;
										}
									}
									String orglogo = null;
									if (m[16] != null && m[16] != "" && m[16] != " " && !m[16].toString().equals(" ")
											&& !m[16].toString().equals(null) && !m[16].toString().equals("")) {
										orglogo = env.getMobileView() + "document/document/" + m[16].toString();
									} else {
										orglogo = "";
									}
									String prfileImg = null;
									if (m[17] != null && m[17] != "" && m[17] != " " && !m[17].toString().equals(" ")
											&& !m[17].toString().equals(null) && !m[17].toString().equals("")) {
										prfileImg = env.getMobileView() + "document/employee/" + m[17].toString();
									} else {
										prfileImg = "";
									}
									ApiUserModel user = new ApiUserModel(m[0].toString(), m[1], m[2], m[3], m[4], null,
											null, null, null, null, null, boolean1, null, null, userRole, m[7], m[8], m[9],
											m[10], m[11], null, m[13], m[14], m[15], orglogo, prfileImg, m[18], m[19],
											m[20]);
									userArray.add(user);
								}
								String encodePassword = userArray.get(0).getUserPassword();
								String imei = userArray.get(0).getImeiNo();
								if (imei.contentEquals(imeiNo)) {
									final UserDetails userDetails = userDetailsService.loadUserByUsername(userArray.get(0).getUser());
									logger.info("userArray.get(0)====" + userArray.get(0).getProfileImg());
									userArray.get(0).setToken("Bearer " + jwtTokenUtil.generateToken(userDetails));
									logger.info("User Array aaa =====" + userArray);
									if (passEncoder.matches(password, encodePassword)) {
										Util.setJsonResponse(jsonResponse, userArray.get(0), ResponseStatus.success,
												ApiResponseMessage.DATA_FETCH_SUCCESS);
									} else {
										List<String> blankArray = new ArrayList<String>();
										Util.setJsonResponse(jsonResponse, blankArray, ResponseStatus.failed,
												ApiResponseMessage.PASSWORD_INCORRECT);
										return jsonResponse;
									}
								} else {
									List<String> blankArray = new ArrayList<String>();
									Util.setJsonResponse(jsonResponse, blankArray, ResponseStatus.failed,
											ApiResponseMessage.LOGIN_FAILED1);
								}

							} catch (Exception e) {
								List<String> blankArray = new ArrayList<String>();
								Util.setJsonResponse(jsonResponse, blankArray, ResponseStatus.failed,
										ApiResponseMessage.DATA_FECTH_FAILED);
							}

				} else {
					jsonResponse.setCode("failed");
					jsonResponse.setMessage("Invalid User Name");
				}

			}

			logger.info("Method : getLoginApi ends");
			return jsonResponse;
		}
	@SuppressWarnings("unchecked")
	public JsonResponse<ApiUserModel> getLoginMultipleUserMobile(String mobileNo, String employeeId, String imeiNo) {
		logger.info("Method : getLoginMultipleUserMobile starts");

		JsonResponse<ApiUserModel> jsonResponse = new JsonResponse<ApiUserModel>();
		Boolean validity = true;
		if (employeeId == null || employeeId == "") {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage("Employee number required");
			validity = false;
		}

		if (mobileNo == null || mobileNo == "") {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage("Mobile number required");
			validity = false;
		}

		
		jsonResponse.setCode("");
		jsonResponse.setMessage("");

		List<ApiUserModel> userArray = new ArrayList<ApiUserModel>();
		List<String> userRole = new ArrayList<String>();

		String value = "SET @p_mobileNo='" + mobileNo + "',@p_employeeId='" + employeeId + "',@p_imeiNo='" + imeiNo
				+ "';";
		logger.info("value===mob===" + value);
		if (validity) {
			Boolean empidVal=checkDuplicateDao.isValidEmployeeNumber(employeeId);
			if(empidVal) {
			try {
				Boolean empMobVal=checkDuplicateDao.isValidEmployeeMobileNumber(employeeId,mobileNo);
				if (empMobVal){
						try {
							List<Object[]> x = em.createNamedStoredProcedureQuery("userRoutines")
									.setParameter("actionType", "loginThroughMobile").setParameter("actionValue", value)
									.getResultList();

							for (Object[] m : x) {
								logger.info("Amar===========" + Arrays.toString(m));
								String role = (String) m[6];

								if (role != null && role.length() > 0) {
									String[] roles = role.split(",");
									userRole = Arrays.asList(roles);
								}

								Boolean boolean1 = false;
								if (m[5].toString() != null) {
									String data = m[5].toString();
									if (data.contentEquals("1")) {
										boolean1 = true;
									} else {
										boolean1 = false;
									}
								}
								String orglogo = null;
								if (m[16] != null && m[16] != "" && m[16] != " " && !m[16].toString().equals(" ")
										&& !m[16].toString().equals(null) && !m[16].toString().equals("")) {
									orglogo = env.getMobileView() + "document/document/" + m[16].toString();
								} else {
									orglogo = "";
								}
								String prfileImg = null;
								if (m[17] != null && m[17] != "" && m[17] != " " && !m[17].toString().equals(" ")
										&& !m[17].toString().equals(null) && !m[17].toString().equals("")) {
									prfileImg = env.getMobileView() + "document/employee/" + m[17].toString();
								} else {
									prfileImg = "";
								}
								ApiUserModel user = new ApiUserModel(m[0].toString(), m[1], m[2], m[3], m[4], null, null, null, null,
										null, null, boolean1, null, null, userRole, m[7], m[8], m[9], m[10], m[11], null, m[13], m[14],
										m[15], orglogo, prfileImg, m[18],m[19],m[20]);
								userArray.add(user);
							}

							logger.info("Method : getLoginMultipleUserDetails ends");
							if (userArray.size() > 0) {
								final UserDetails userDetails = userDetailsService.loadUserByUsername(userArray.get(0).getUser());
								logger.info("userArray.get(0)====" + userArray.get(0).getProfileImg());
								userArray.get(0).setToken("Bearer " + jwtTokenUtil.generateToken(userDetails));
								logger.info("User Array aaa =====" + userArray);
								Util.setJsonResponse(jsonResponse, userArray.get(0), ResponseStatus.success,
										ApiResponseMessage.DATA_FETCH_SUCCESS);
							} else {
								List<String> blankArray = new ArrayList<String>();
								Util.setJsonResponse(jsonResponse, blankArray, ResponseStatus.failed,
										ApiResponseMessage.LOGIN_FAILED1);
							}

						} catch (Exception e) {
							List<String> blankArray = new ArrayList<String>();
							Util.setJsonResponse(jsonResponse, blankArray, ResponseStatus.failed, ApiResponseMessage.DATA_FECTH_FAILED);
						}
					 }else {
						 jsonResponse.setCode("failed");
						 jsonResponse.setMessage("Invalid Mobile Number"); 
						
					 }
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			}else {
				 jsonResponse.setCode("failed");
				 jsonResponse.setMessage("Invalid Employee Number"); 
			}
			
		
	}
		

		logger.info("Method : getLoginMultipleUserMobile ends");
		return jsonResponse;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getOTPForFOrgotPassword(DropDownModel data) {
		logger.info("Method : getOTPForFOrgotPassword Dao starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		Boolean validity = true;
		if (data.getKey() == null || data.getKey() == "") {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage("Employee Number Required");
			validity = false;
		}

		logger.info(jsonResponse.toString());
		if (validity) {
			try {
				String value = "SET @p_userid='" + data.getKey() + "';";
logger.info("value==="+value);
				if (data.getKey() != null && data.getKey() != "") {
					List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist")
							.setParameter("actionType", "getUserByEmployeeNo").setParameter("actionValue", value)
							.getResultList();

					if (x.size() > 0) {
						logger.info("x==="+x.get(0)[1].toString());
						 if(x.get(0)[1].toString()==null || x.get(0)[1].toString()=="" 
								 || x.get(0)[1].toString().equals(null) || x.get(0)[1].toString().equals("") ) {
							 jsonResponse.setCode("failed");
							 jsonResponse.setMessage("Your Email does not exist! Please Update Your Email"); 
						 }else {
								String otp = generateRandom(4);
								DropDownModel dd = new DropDownModel();
								dd.setKey(x.get(0)[1].toString());
								dd.setCode(otp);
								String to = x.get(0)[1].toString();
								String username=x.get(0)[0].toString();
								String sub = "One Time Password (OTP) for Forgot Password Recovery on NERP";
								String msg  = "Hi  "+username+","+ System.lineSeparator()+System.lineSeparator()+
										"Your One Time Password for Forgot Password recovery on NERP is "+otp+"."+ System.lineSeparator()+System.lineSeparator()+
										"Note, This OTP is valid only for mentioned transaction and cannot be used for any other transaction.\r\n"
										+ "Please do not share this One Time Password with anyone.";
								
								logger.info("TOOOOO"+to);
								logger.info("sub"+sub);
								logger.info("msg"+msg);
								
								if(otp != null) {
									mailService.sendEmail(to,sub,msg); 
									jsonResponse.setBody(dd);
									
									jsonResponse.setCode("success");
									jsonResponse.setMessage("OTP sent successfully");
								}
								else {
									jsonResponse.setCode("faild");
									jsonResponse.setMessage("OTP sent unsuccess");
								}
						 }
				 
					} else {
						jsonResponse.setCode("failed");
						jsonResponse.setMessage("Employee number does not exist");
					}

				} else {
					jsonResponse.setCode("failed");
					jsonResponse.setMessage("Employee number required");
				}
			} catch (Exception e) {
				e.printStackTrace();
				jsonResponse.setCode("failed");
				jsonResponse.setMessage("Something went wrong");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(jsonResponse,
				HttpStatus.OK);
		logger.info("Method : getOTPForFOrgotPassword Dao ends");
		return response;
	}

// change password
	public ResponseEntity<JsonResponse<Object>> changePassword(DropDownModel data) {
		logger.info("Method : changePassword Dao starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		Boolean validity = true;
		if (data.getKey() == null || data.getKey() == "") {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage("Mobile No. required");
			validity = false;
		}

		if (validity) {

			try {
				if (data.getKey() != null && data.getKey() != "") {

					String password = null;
					if (data.getCode() != null && data.getCode() != "") {
						password = passEncoder.encode(data.getCode());
					}

					String value = "SET @p_userMobile='" + data.getKey() + "',@p_password='" + password + "';";

					logger.info(data.getKey());
					logger.info(password);

					boolean x = em.createNamedStoredProcedureQuery("check_userid_exist")
							.setParameter("actionType", "change_password").setParameter("actionValue", value).execute();

					// if (x.size() > 0) {
					jsonResponse.setCode("success");
					jsonResponse.setMessage("Password updated successfully");

					/*
					 * } else { jsonResponse.setCode("failed");
					 * jsonResponse.setMessage("Password not updated"); }
					 */

				} else {
					jsonResponse.setCode("failed");
					jsonResponse.setMessage("Mobile No. required");
				}
			} catch (Exception e) {
				e.printStackTrace();
				jsonResponse.setCode("failed");
				jsonResponse.setMessage("Password not updated");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(jsonResponse,
				HttpStatus.OK);

		logger.info("Method : changePassword Dao ends");
		return response;
	}

//Save New Password
	public ResponseEntity<JsonResponse<Object>> saveNewPassword(DropDownModel data) {
		logger.info("Method : saveNewPassword Dao starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		Boolean validity = true;
		if (data.getKey() == null || data.getKey() == "") {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage("Employee No. required");
			validity = false;
		}

		if (validity) {

			try {
				if (data.getKey() != null && data.getKey() != "") {

					String password = null;
					if (data.getCode() != null && data.getCode() != "") {
						password = passEncoder.encode(data.getCode());
					}

					String value = "SET @p_userid='" + data.getKey() + "',@p_imeiNo='" + data.getName()
							+ "',@p_password='" + password + "';";

					logger.info(data.getKey());
					logger.info(password);

					boolean x = em.createNamedStoredProcedureQuery("check_userid_exist")
							.setParameter("actionType", "save_new_password").setParameter("actionValue", value)
							.execute();

					// if (x.size() > 0) {
					jsonResponse.setCode("success");
					jsonResponse.setMessage("Password save successfully");

				} else {
					jsonResponse.setCode("failed");
					jsonResponse.setMessage("Employee No. required");
				}
			} catch (Exception e) {
				e.printStackTrace();
				jsonResponse.setCode("failed");
				jsonResponse.setMessage("Unable to save password");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(jsonResponse,
				HttpStatus.OK);

		logger.info("Method : saveNewPassword Dao ends");
		return response;
	}

// Login Match Password
	public ResponseEntity<JsonResponse<Object>> loginMatchPassword(DropDownModel data) {
		logger.info("Method : loginMatchPassword Dao starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		Boolean validity = true;
		if (data.getKey() == null || data.getKey() == "") {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage("Employee number required");
			validity = false;
		}
		if (data.getName() == null || data.getName() == "") {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage("Imei Number required");
			validity = false;
		}
		if (data.getCode() == null || data.getCode() == "") {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage("Password required");
			validity = false;
		}

		if (validity) {
			try {
				String encodePassword = checkDuplicateDao.getUserPassword(data.getKey());
				Boolean status = passEncoder.matches(data.getCode(), encodePassword);
				if (status) {
					jsonResponse.setCode("success");
					jsonResponse.setMessage("Login successfully");

				} else {
					jsonResponse.setCode("failed");
					jsonResponse.setMessage("Password is incorrect");
				}
			} catch (Exception e) {
				e.printStackTrace();
				jsonResponse.setCode("failed");
				jsonResponse.setMessage("Login failed");
			}
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(jsonResponse,
				HttpStatus.OK);

		logger.info("Method : loginMatchPassword Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AttendanceModel>>> attendanceByOrganization(String userid,
			String tAttndncDate) {
		logger.info("Method : attendanceByOrganization Dao starts");

		List<AttendanceModel> attendanceList = new ArrayList<AttendanceModel>();
		JsonResponse<List<AttendanceModel>> jsonResponse = new JsonResponse<List<AttendanceModel>>();
		try {

			String value = "SET @p_userName='" + userid + "',@p_date='" + tAttndncDate + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist")
					.setParameter("actionType", "getUserAttendance").setParameter("actionValue", value).getResultList();

			if (x.size() == 0) {
				AttendanceModel dropDownModel = new AttendanceModel(null, null, null, null, null, null,null);
				attendanceList.add(dropDownModel);
			}

			else
				for (Object[] m : x) {

					if (m[3] == null) {
						m[3] = "";
					}

					Boolean boolean1 = false;
					if (m[4].toString() != null) {
						String data = m[4].toString();
						if (data.contentEquals("1")) {
							boolean1 = true;
						} else {
							boolean1 = false;
						}
					}

					Boolean boolean2 = false;
					if (m[5].toString() != null) {
						String data = m[5].toString();
						if (data.contentEquals("1")) {
							boolean2 = true;
						} else {
							boolean2 = false;
						}
					}

					AttendanceModel dropDownModel = new AttendanceModel(m[0], m[1], m[2], m[3], boolean1, boolean2,null);
					attendanceList.add(dropDownModel);

				}

			jsonResponse.setBody(attendanceList);
			jsonResponse.setCode("success");
			jsonResponse.setMessage(ApiResponseMessage.DATA_FETCH_SUCCESS);

			if (attendanceList.size() > 0) {
				jsonResponse.setCode("success");
				jsonResponse.setMessage(ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				jsonResponse.setBody(attendanceList);
				jsonResponse.setCode("success");
				jsonResponse.setMessage("No Data Found");
			}
		} catch (Exception e) {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<List<AttendanceModel>>> response = new ResponseEntity<JsonResponse<List<AttendanceModel>>>(
				jsonResponse, HttpStatus.OK);

		logger.info("Method : attendanceByOrganization Dao ends");
		logger.info("rereee" + response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AttendanceModel>>> getAttendanceStatus(String userid,
			String tAttndncDate,String org,String orgDiv) {
		logger.info("Method : getAttendanceStatus Dao starts");

		List<AttendanceModel> attendanceList = new ArrayList<AttendanceModel>();
		JsonResponse<List<AttendanceModel>> jsonResponse = new JsonResponse<List<AttendanceModel>>();
		try {
			String value = "SET @p_userName='" + userid + "',@p_date='" + tAttndncDate + "',@p_org='" + org +"',@p_orgDiv='" + orgDiv +"';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist")
					.setParameter("actionType", "getUserAttendanceStatus").setParameter("actionValue", value).getResultList();
			if (x.size() == 0) {
				AttendanceModel dropDownModel = new AttendanceModel(null, null, null, null, null, null,null);
				attendanceList.add(dropDownModel);
			}
			else
				for (Object[] m : x) {

					if (m[3] == null) {
						m[3] = "";
					}

					Boolean boolean1 = false;
					if (m[4].toString() != null) {
						String data = m[4].toString();
						if (data.contentEquals("1")) {
							boolean1 = true;
						} else {
							boolean1 = false;
						}
					}

					Boolean boolean2 = false;
					if (m[5].toString() != null) {
						String data = m[5].toString();
						if (data.contentEquals("1")) {
							boolean2 = true;
						} else {
							boolean2 = false;
						}
					}

					AttendanceModel dropDownModel = new AttendanceModel(m[0], m[1], m[2], m[3], boolean1, boolean2,m[6]);
					attendanceList.add(dropDownModel);

				}

			jsonResponse.setBody(attendanceList);
			jsonResponse.setCode("success");
			jsonResponse.setMessage(ApiResponseMessage.DATA_FETCH_SUCCESS);

			if (attendanceList.size() > 0) {
				jsonResponse.setCode("success");
				jsonResponse.setMessage(ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				jsonResponse.setBody(attendanceList);
				jsonResponse.setCode("success");
				jsonResponse.setMessage("No Data Found");
			}
		} catch (Exception e) {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<List<AttendanceModel>>> response = new ResponseEntity<JsonResponse<List<AttendanceModel>>>(
				jsonResponse, HttpStatus.OK);

		logger.info("Method : getAttendanceStatus Dao ends");
		return response;
	}
	public ResponseEntity<JsonResponse<Object>> changePasswordUserWiseAfterLogIn(DropDownModel data) {
		logger.info("Method : changePasswordUserWiseAfterLogIn Dao starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		Boolean validity = true;
		if (data.getKey() == null || data.getKey() == "") {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage("Employee number required");
			validity = false;
		}

		if (!StringUtil.isNull(data.getName()) && !StringUtil.isNull(data.getCode())) {
			if (data.getName().equals(data.getCode())) {
				Util.setJsonResponse(jsonResponse, null, ResponseStatus.failed,
						"New password can't be same as old password");
				validity = false;
			}
		}

		if (validity) {
			try {
				if (data.getKey() != null && data.getKey() != "") {

					String password = null;

					logger.info(data.getKey());
					logger.info(data.getCode());

					if (data.getCode() != null && data.getCode() != "") {
						password = passEncoder.encode(data.getCode());
					}

					if (data.getName() != null && data.getName() != "" && data.getCode() != null
							&& data.getCode() != "") {

						String encodePassword = checkDuplicateDao.getUserPassword(data.getKey());
						Boolean status = passEncoder.matches(data.getName(), encodePassword);
						if (status) {
							password = passEncoder.encode(data.getCode());
							String value = "SET @p_userid='" + data.getKey() + "',@p_password='" + password + "';";
							logger.info(value);
							boolean x = em.createNamedStoredProcedureQuery("check_userid_exist")
									.setParameter("actionType", "change_password").setParameter("actionValue", value)
									.execute();

							jsonResponse.setCode("success");
							jsonResponse.setMessage("Password changed successfully");

						} else {
							jsonResponse.setCode("failed");
							jsonResponse.setMessage("Old password does not match");
						}

					} else {
						jsonResponse.setCode("failed");
						jsonResponse.setMessage("Current password does not match");
					}

				} else {
					jsonResponse.setCode("failed");
					jsonResponse.setMessage("Employee number required");
				}
			} catch (Exception e) {
				e.printStackTrace();
				jsonResponse.setCode("failed");
				jsonResponse.setMessage("Password not changed");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(jsonResponse,
				HttpStatus.OK);

		logger.info("Method : changePasswordUserWiseAfterLogIn Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<AttendanceModel>> addAttendance(AttendanceModel attendanceByOrganization) {
		logger.info("Method : attendanceByOrganization dao starts");
		logger.info("atten=========="+attendanceByOrganization);
		JsonResponse<AttendanceModel> resp = new JsonResponse<AttendanceModel>();

		String value = GenerateAttendanceManagementParam.getAttendanceParam(attendanceByOrganization);

		try {

			logger.info("addddddddd" + value);
 
			if (attendanceByOrganization.gettAttndncPunchOut() != null
					&& attendanceByOrganization.gettAttndncPunchOut() != "") {
				logger.info("Update");
				em.createNamedStoredProcedureQuery("check_userid_exist").setParameter("actionType", "Update_Attendance")
						.setParameter("actionValue", value).execute();
				
				resp.setMessage("Saved successfully");
				resp.setCode("success");
			} else {
				logger.info("Add");
				List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist").setParameter("actionType", "Add_Attendance")
						.setParameter("actionValue", value).getResultList();

				if (x.size() > 0) {
					logger.info("x==="+x.get(0)[1].toString()+"===x.get(0)[1].toString()="+x.get(0)[0].toString());
					 if((x.get(0)[1].toString()).contentEquals("1")) {
							String msg="You are late for the office today";
							logger.info("msg==="+msg);
							try {
								String msgId = pushNotification.pushFCMNotificationForLate(x.get(0)[0].toString(),msg);
							} catch (Exception e) {
								e.printStackTrace(); 
							}
					 }else {
		
					 }
						resp.setMessage("Saved successfully");
						resp.setCode("success");
				} else {
					resp.setCode("Failed");
					resp.setMessage("Unsuccess");
				}
			}
	

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Failed");
			resp.setCode("Unsuccess");
		}

		ResponseEntity<JsonResponse<AttendanceModel>> response = new ResponseEntity<JsonResponse<AttendanceModel>>(resp,
				HttpStatus.OK);

		logger.info("Resp" + response);
		logger.info("Method : attendanceByOrganization dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getReimbursementList() {
		logger.info("Method : getReimbursementList Dao starts");

		List<DropDownModel> travellingList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> jsonResponse = new JsonResponse<List<DropDownModel>>();
		try {
			logger.info("got it");

			List<Object[]> x = em.createNamedStoredProcedureQuery("reimbursementRoutine")
					.setParameter("actionType", "getReimbTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				travellingList.add(dropDownModel);
			}
			jsonResponse.setBody(travellingList);
			jsonResponse.setCode("success");
			jsonResponse.setMessage("Data Fetched Successfully");
		} catch (Exception e) {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				jsonResponse, HttpStatus.OK);
		logger.info("Method : getReimbursementList Dao ends");

		return response;
	}

	public ResponseEntity<JsonResponse<ManageEmployeeAddressRestModel>> postEmployeeAddressApiDao(
			List<ManageEmployeeAddressRestModel> manageEmployeeAddressRestModel) {
		logger.info("Method : postEmployeeAddressApiDao starts");

		JsonResponse<ManageEmployeeAddressRestModel> resp = new JsonResponse<ManageEmployeeAddressRestModel>();
		try {
			String values = GenerateemployeemasterParameter.saveempaddApi(manageEmployeeAddressRestModel);
			logger.info("values" + values);

			em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "addEmpAddressApi")
					.setParameter("actionValue", values).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[0]);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);

		}
		ResponseEntity<JsonResponse<ManageEmployeeAddressRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeAddressRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : postEmployeeAddressApiDao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> profileDataUploadDao(EmployeeProfileApiModel data) {
		logger.info("Method : profileDataUploadDao Dao starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		try {
			String values = GenerateParamEmployeeProfileParameter.getprofileImageUploadAPIParam(data);
			logger.info("values==="+values);
			em.createNamedStoredProcedureQuery("employeeMasterRoutines").setParameter("actionType", "addEmpDocApi")
					.setParameter("actionValue", values).execute();
			Util.setJsonResponse(jsonResponse, null, ResponseStatus.success, ApiResponseMessage.DOCUMENT_UPLOADED);

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);

				if (err[1] != "294" && err[1] != "294" && !err[1].equals("294")) {
					Util.setJsonResponse(jsonResponse, null, ResponseStatus.failed,
							ApiResponseMessage.NO_AUTHORIZATION_TYPE);
				}

			} catch (Exception e1) {
				e1.printStackTrace();
				Util.setJsonResponse(jsonResponse, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_FAILURE);
			}

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(jsonResponse,
				HttpStatus.OK);

		logger.info("Method : profileDataUploadDao Dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getUploadProfileDetailsApiDao(String empId, String organization,String orgDivision) {
		logger.info("Method : getUploadProfileDetailsApiDao Dao starts");

		List<DropDownModel> profileDetailsList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> jsonResponse = new JsonResponse<List<DropDownModel>>();
		try {

			String value = "SET @p_userName='" + empId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
					.setParameter("actionType", "getUploadDocumentApi").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				String imgName = null;
				if (m[2] != null && m[2] != "" && m[2] != " " && !m[2].toString().equals(" ")
						&& !m[2].toString().equals(null) && !m[2].toString().equals("")) {
					imgName = env.getMobileView() + "document/employee/" + m[2].toString();
				} else {
					imgName = "";
				}

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], imgName);
				profileDetailsList.add(dropDownModel);

			}

			if (profileDetailsList.size() > 0) {

				Util.setJsonResponse(jsonResponse, profileDetailsList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(jsonResponse, profileDetailsList, ResponseStatus.success,
						ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			Util.setJsonResponse(jsonResponse, null, ResponseStatus.failed, ApiResponseMessage.NO_DATA_FOUND);
		}

		logger.info("Method : getUploadProfileDetailsApiDao Dao ends");
		logger.info("getUploadProfileDetailsApiDao" + jsonResponse);
		return jsonResponse;
	}
 
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<MobileVersionApiModel>>getMobileVersion() {
		logger.info("Method : getMobileVersion starts");

		MobileVersionApiModel version = new MobileVersionApiModel();
		JsonResponse<MobileVersionApiModel> resp = new JsonResponse<MobileVersionApiModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist")
					.setParameter("actionType", "getMobileVersion").setParameter("actionValue", "").getResultList();
			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.failed, ApiResponseMessage.NO_DATA_FOUND);
			}
			for (Object[] m : x) {
				Object CREATEDON = null;
				if (m[6] != null) {
					CREATEDON  = DateFormatter.returnStringDate(m[6]);
				}
				Object UPDATEDON = null;
				if (m[7] != null) {
					CREATEDON  = DateFormatter.returnStringDate(m[7]);
				}
				MobileVersionApiModel dropDownModel = new MobileVersionApiModel(m[0].toString(), m[1],m[2],m[3],m[4],m[5],CREATEDON,UPDATEDON);
				version = dropDownModel;
				
				if (dropDownModel.equals("")) {
					resp.setBody(dropDownModel);
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setBody(dropDownModel);
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
					
				}
			}

			
			 resp.setBody(version);
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("getMobileVersion: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(version);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<MobileVersionApiModel>> response = new ResponseEntity<JsonResponse<MobileVersionApiModel>>(resp,
				responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getMobileVersion ends");
		return response;
	}
	//check payslip eligible
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>>checkPayslipEligibleApi(String empId, String organization,String orgDivision) {
		logger.info("Method : checkPayslipEligibleApi starts");

		DropDownModel pf = new DropDownModel();
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		String value = "SET @p_userName='" + empId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision+ "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist")
					.setParameter("actionType", "checkPayslipEligible").setParameter("actionValue",value).getResultList();
			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.failed, ApiResponseMessage.NO_DATA_FOUND);
			}
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				pf = dropDownModel;
				
				if (dropDownModel.equals("")) {
					resp.setBody(dropDownModel);
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setBody(dropDownModel);
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			 resp.setBody(pf);
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("checkPayslipEligibleApi: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(pf);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
				responseHeaders, HttpStatus.CREATED);
		logger.info("Method : checkPayslipEligibleApi ends");
		return response;
	}
	//get attendance Report
	public JsonResponse<Object> getAttendanceReportApi(String empId,String fromDate,String toDate,String organization,String orgDivision) {
		logger.info("Method : getAttendanceReportApi Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		fromDate = (fromDate != null && !fromDate.isEmpty()) ? DateFormatter.getStringDate(fromDate) : fromDate;
		toDate = (toDate != null && !toDate.isEmpty()) ? DateFormatter.getStringDate(toDate) : toDate;
		String value = "SET @p_empId='" + empId + "',@p_fromDate='" + fromDate + "',@p_toDate='"
				+ toDate + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
		
		logger.info("value>>>>>>>===="+value);
		
		try {
			Object x = em.createNamedStoredProcedureQuery("check_userid_exist")
					.setParameter("actionType", "getAttendanceReport").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getAttendanceReportApi Dao ends");
		return resp;
	}
	public ResponseEntity<JsonResponse<List<AttendanceModel>>> getBiometricAttendanceApi(String attendanceDate,String organization,String orgDivision) {
		logger.info("Method : getBiometricAttendanceApi Dao starts");

		JsonResponse<List<AttendanceModel>> jsonResponse = new JsonResponse<List<AttendanceModel>>();
		try {
			  URL oracle = new URL("http://14.99.213.154:8080/conn_access/emp.php?flag="+"QXR0ZW5kYW5jZUxvZ3M"+"&date="+attendanceDate); // URL to Parse
	            URLConnection yc = oracle.openConnection();
	            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	            String inputLine;
	            while ((inputLine = in.readLine()) != null) {
	            	JSONArray array = new JSONArray(inputLine); 
	            	logger.info("array==="+array);
	            	String s = "";
	            	String value = "";
	            	String attendata = "";
	            	String attendataEmp = "";
	            	for(int i=0; i < array.length(); i++) {  
	            		JSONObject object = array.getJSONObject(i);
	            		if(!(object.getString("InTime")).equals("00:00")) {
	            			attendataEmp=attendataEmp+"\""+object.getString("EmployeeCode")+"\",";
		            		attendata = attendata + "(\""+object.getString("EmployeeCode")+"\",\""+object.getString("AttendanceDate")+"\","
		            				+ "\""+object.getString("InTimeDateTime")+"\",\""+object.getString("OutTimeDateTime")+"\"),";
	            		} 
	            	}
	        		if (!attendata.isEmpty()) {  
	        			attendata = attendata.substring(0, attendata.length() - 1);
	        			attendataEmp = attendataEmp.substring(0, attendataEmp.length() - 1);
	        			s = s + "@p_attenQuery='" + attendata + "',";
	        			s = s + "@p_attenQueryDate='" + DateFormatter.getStringDate(attendanceDate) + "',";
	        			s = s + "@p_attenQueryEmployee='" +"("+attendataEmp+")" + "',";
	        		}

	        		if (s != "") {
	        			s = s.substring(0, s.length() - 1);

	        			value = "SET " + s + ";";
	        		}
	            	logger.info("value==="+value);
	            	if (value != "") {
		            	try {
		        			em.createNamedStoredProcedureQuery("check_userid_exist").setParameter("actionType", "addBiometricAttendance")
							.setParameter("actionValue", value).execute();
		        			jsonResponse.setMessage("Data Save Successfully");
		        			jsonResponse.setCode("success");

						} catch (Exception e) {
							logger.error("Error " + e.getMessage());
							Util.setJsonResponse(jsonResponse, null, ResponseStatus.failed,
									ApiResponseMessage.UNKNOWN_EXCEPTION);
							jsonResponse.setCode("failed");
						}
	            	}else {
	        			jsonResponse.setMessage("No Data Available To Save");
	        			jsonResponse.setCode("failed");
	            	}
	            }
		} catch (Exception e) {
			jsonResponse.setCode("failed");
			jsonResponse.setMessage("the site can't be reached");
		}
		ResponseEntity<JsonResponse<List<AttendanceModel>>> response = new ResponseEntity<JsonResponse<List<AttendanceModel>>>(
				jsonResponse, HttpStatus.OK);
		logger.info("Method : getBiometricAttendanceApi Dao ends");
		return response;
	}
	
	//check user eligible
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<DropDownModel>>checkUserEligibleApi(String empId, String organization,String orgDivision) {
		logger.info("Method : checkUserEligibleApi starts");

		DropDownModel pf = new DropDownModel();
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		String value = "SET @p_userName='" + empId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision+ "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("check_userid_exist")
					.setParameter("actionType", "checkUserEligibleApi").setParameter("actionValue",value).getResultList();
			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.failed, ApiResponseMessage.NO_DATA_FOUND);
			}
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString(),m[2].toString());
				pf = dropDownModel;
				
				if (dropDownModel.equals("")) {
					resp.setBody(dropDownModel);
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setBody(dropDownModel);
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			 resp.setBody(pf);
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("checkUserEligibleApi: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(pf);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<DropDownModel>> response = new ResponseEntity<JsonResponse<DropDownModel>>(resp,
				responseHeaders, HttpStatus.CREATED);
		logger.info("Method : checkUserEligibleApi ends");
		return response;
	}
////get user menu
		public JsonResponse<Object> getUserMenuApi(String userId, String userRole, String organization,String orgDivision) {
			logger.info("Method : getUserMenuApi Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			String value = "SET @p_empId=\"" + userId + "\",@p_userRole='(" + userRole + ")',@p_org=\"" + organization
					+ "\",@p_orgDiv=\"" + orgDivision + "\";";
			
			logger.info("value>>>>>>>===="+value);
			
			try {
				Object x = em.createNamedStoredProcedureQuery("userRoutines")
						.setParameter("actionType", "user_menu_api").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} catch (Exception e) {
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("Method : getUserMenuApi Dao ends");
			return resp;
		}
}
