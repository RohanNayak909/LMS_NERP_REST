/*
 * package nirmalya.aatithya.restmodule.hotel.dao;
 * 
 * import java.text.SimpleDateFormat; import java.util.Base64; import
 * java.util.Calendar; import java.util.Date; import java.util.List; import
 * java.util.Random;
 * 
 * import javax.persistence.EntityManager;
 * 
 * import org.json.JSONObject; import org.slf4j.Logger; import
 * org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.stereotype.Repository;
 * 
 * import nirmalya.aatithya.restmodule.common.MailService; import
 * nirmalya.aatithya.restmodule.common.ServerDao; import
 * nirmalya.aatithya.restmodule.common.utils.JsonResponse; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * @Repository public class OrganisationFreeTrialRegestrationDao {
 * 
 * Logger logger =
 * LoggerFactory.getLogger(OrganisationFreeTrialRegestrationDao.class);
 * 
 * @Autowired EntityManager em;
 * 
 * @Autowired ServerDao serverDao;
 * 
 * @Autowired MailService mailService;
 * 
 * @SuppressWarnings("unchecked") public ResponseEntity<JsonResponse<Object>>
 * freeTrailOrgRegistartion(String orgData) {
 * logger.info("method: freeTrailOrgRegistartion Dao Starts");
 * JsonResponse<Object> resp = new JsonResponse<>();
 * 
 * try { JSONObject jsonData = new JSONObject(orgData);
 * 
 * // Extract input values String zip = jsonData.optString("zip"); String
 * firstName = jsonData.optString("firstName"); String lastName =
 * jsonData.optString("lastName"); String country =
 * jsonData.optString("country"); String orgName =
 * jsonData.optString("orgName"); String city = jsonData.optString("city");
 * String street = jsonData.optString("street"); String mobile =
 * jsonData.optString("mobile"); String state = jsonData.optString("state");
 * String email = jsonData.optString("email");
 * 
 * // Generate strong password String password =
 * generateStrongPassword(firstName, lastName, orgName, mobile);
 * System.out.println("User Password:::"+password); PasswordEncoder
 * passwordEncoder = new BCryptPasswordEncoder(); String encodedPassword =
 * passwordEncoder.encode(password);
 * 
 * String safeEmail = email.replace("'", "''"); String safeState =
 * state.replace("'", "''"); String safeMobile = mobile.replace("'", "''");
 * String safeStreet = street.replace("'", "''"); String safeCity =
 * city.replace("'", "''"); String safeCountry = country.replace("'", "''");
 * String safeFirstName = firstName.replace("'", "''"); String safeLastName =
 * lastName.replace("'", "''"); String safeZip = zip.replace("'", "''"); String
 * safeOrgName = orgName.replace("'", "''"); String safePassword =
 * password.replace("'", "''");
 * 
 * String value = "SET @email='" + safeEmail + "'," + "@state='" + safeState +
 * "'," + "@mobile='" + safeMobile + "'," + "@street='" + safeStreet + "'," +
 * "@city='" + safeCity + "'," + "@country='" + safeCountry + "'," +
 * "@firstName='" + safeFirstName + "'," + "@lastName='" + safeLastName + "'," +
 * "@zip='" + safeZip + "'," + "@orgName='" + safeOrgName + "'," + "@password='"
 * + encodedPassword + "';";
 * 
 * logger.info("Procedure Params: " + value);
 * 
 * List<Object[]> resultList =
 * em.createNamedStoredProcedureQuery("hotel_free_trail_routines")
 * .setParameter("actionType", "save-free-trail-registartion")
 * .setParameter("actionValue", value) .getResultList();
 * 
 * String subject =
 * "Welcome to Sattkara - Your Organization Registration Details";
 * SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy, hh:mm a");
 * String regDate = dateFormat.format(new Date());
 * 
 * String message = "<html>" +
 * "<body style='font-family: Arial, sans-serif; line-height: 1.6; color: #333; margin: 0 auto;'>"
 * +
 * "<div style='background-color: #f8f9fa; padding: 20px; border-radius: 5px;'>"
 * + "<div style='text-align: center; margin-bottom: 20px;'>" +
 * "<h1 style='color: #6f42c1;'>Welcome to Sattkara</h1>" + "</div>" +
 * "<div style='background-color: white; padding: 25px; border-radius: 5px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);'>"
 * + "<p>Dear <strong>" + firstName +" "+ lastName +"</strong>,</p>" +
 * "<p>Thank you for registering your organization with Sattkara. Below are your login credentials and organization details:</p>"
 * +
 * "<div style='background-color: #f1f1f1; padding: 15px; border-radius: 5px; margin: 15px 0;'>"
 * + "<h3 style='margin-top: 0; color: #6f42c1;'>Login Credentials</h3>" +
 * "<p><strong>User ID:</strong> " + email + "</p>" +
 * "<p><strong>Password:</strong> " + password + "</p>" +
 * "<p style='font-style: italic; color: #dc3545;'>Please change your password after first login.</p>"
 * + "</div>" +
 * "<div style='background-color: #f1f1f1; padding: 15px; border-radius: 5px; margin: 15px 0;'>"
 * + "<h3 style='margin-top: 0; color: #6f42c1;'>Organization Details</h3>" +
 * "<p><strong>Organization Name:</strong> " + orgName + "</p>" +
 * "<p><strong>Registration Date:</strong> " + regDate + "</p>" + "</div>" +
 * "<p>You can now access your organization portal using the following link:</p>"
 * + "<div style='text-align: center; margin: 25px 0;'>" + "<a href='" +
 * "https://sattkara.nerp.in/" +
 * "' style='display: inline-block; padding: 12px 25px; background-color: #6f42c1; color: white; text-decoration: none; border-radius: 5px; font-weight: bold;'>Login to Your Account</a>"
 * + "</div>" +
 * "<p>If you have any questions or need assistance, please don't hesitate to contact our support team.</p>"
 * + "<p>Best regards,<br><strong>The Sattkara Team</strong></p>" + "</div>" +
 * "<div style='text-align: center; margin-top: 20px; color: #6c757d; font-size: 12px;'>"
 * + "<p>© " + Calendar.getInstance().get(Calendar.YEAR) +
 * " Sattkara. All rights reserved.</p>" + "</div>" + "</div>" + "</body>" +
 * "</html>";
 * 
 * mailService.sendHtmlEmail(email, subject, message);
 * 
 * if (!resultList.isEmpty()) { Object[] result = resultList.get(0);
 * resp.setMessage((String) result[0]); resp.setCode((String) result[1]); } else
 * { resp.setMessage("Unknown response from DB"); resp.setCode("Error"); }
 * 
 * } catch (Exception e) { logger.error("Error in freeTrail Org Registartion: ",
 * e); resp.setMessage("Error saving org data!"); resp.setCode("Error"); }
 * 
 * ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp,
 * HttpStatus.CREATED);
 * logger.info("method: freeTrailOrgRegistartion Dao Ends"); return response; }
 * 
 * private String generateStrongPassword(String firstName, String lastName,
 * String orgName, String mobile) { try { String baseString =
 * (firstName.length() >= 3 ? firstName.substring(0, 3) :
 * firstName).toLowerCase() + (lastName.length() >= 3 ? lastName.substring(0, 3)
 * : lastName).toLowerCase() + (orgName.length() >= 3 ? orgName.substring(0, 3)
 * : orgName).toLowerCase() + (mobile.length() >= 4 ?
 * mobile.substring(mobile.length() - 4) : mobile);
 * 
 * String chars =
 * "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
 * Random random = new Random(); StringBuilder password = new StringBuilder();
 * 
 * password.append(baseString);
 * 
 * for (int i = 0; i < 8; i++) {
 * password.append(chars.charAt(random.nextInt(chars.length()))); }
 * 
 * if (password.length() < 8) {
 * password.append("Ab1!").append(chars.charAt(random.nextInt(chars.length())));
 * }
 * 
 * char[] passwordArray = password.toString().toCharArray(); for (int i =
 * passwordArray.length - 1; i > 0; i--) { int j = random.nextInt(i + 1); char
 * temp = passwordArray[i]; passwordArray[i] = passwordArray[j];
 * passwordArray[j] = temp; }
 * 
 * return new String(passwordArray); } catch (Exception e) {
 * logger.error("Error generating password: ", e); Random random = new Random();
 * String chars =
 * "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
 * StringBuilder fallback = new StringBuilder(); for (int i = 0; i < 16; i++) {
 * fallback.append(chars.charAt(random.nextInt(chars.length()))); } return
 * fallback.toString(); } }
 * 
 * }
 */