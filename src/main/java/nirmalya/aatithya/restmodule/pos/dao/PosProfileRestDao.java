/*
 * package nirmalya.aatithya.restmodule.pos.dao;
 * 
 * import java.util.ArrayList; import java.util.List; import java.util.Random;
 * 
 * import javax.persistence.EntityManager;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.client.RestClientException;
 * 
 * import nirmalya.aatithya.restmodule.pos.model.StorePosRestModel; import
 * nirmalya.aatithya.restmodule.common.EnvironmentVaribles; import
 * nirmalya.aatithya.restmodule.common.MailService; import
 * nirmalya.aatithya.restmodule.common.ServerDao; import
 * nirmalya.aatithya.restmodule.common.utils.DropDownModel; import
 * nirmalya.aatithya.restmodule.common.utils.ecommerce.
 * GeneratePosProfileParameter; import
 * nirmalya.aatithya.restmodule.common.utils.JsonResponse;
 * 
 * @RestController
 * 
 * @RequestMapping(value = { "ecommerce" }) public class PosProfileRestDao {
 * 
 * Logger logger = LoggerFactory.getLogger(PosProfileRestDao.class);
 * 
 * @Autowired EntityManager em;
 * 
 * @Autowired ServerDao serverDao;
 * 
 * @Autowired EnvironmentVaribles env;
 * 
 * @Autowired PasswordEncoder passwordEncoder;
 * 
 * @Autowired MailService mailService;
 * 
 * @SuppressWarnings("unchecked") public
 * ResponseEntity<JsonResponse<List<StorePosRestModel>>> viewPosProfile(String
 * id) { logger.info("Method : viewPosProfile starts");
 * 
 * JsonResponse<List<StorePosRestModel>> resp = new
 * JsonResponse<List<StorePosRestModel>>(); List<StorePosRestModel> rs = new
 * ArrayList<StorePosRestModel>();
 * 
 * try {
 * 
 * String value = "SET @p_opId='" + id + "';"; List<Object[]> x =
 * em.createNamedStoredProcedureQuery("ecommerce_store")
 * .setParameter("actionType", "editPosProfile").setParameter("actionValue",
 * value).getResultList(); for (Object[] m : x) {
 * 
 * StorePosRestModel restPayroll = new StorePosRestModel(m[0], m[1], m[2], m[3],
 * m[4]);
 * 
 * rs.add(restPayroll);
 * 
 * } resp.setCode("Success"); resp.setMessage("Data Fetched Successfully"); }
 * catch (Exception e) { resp.setCode("Failed");
 * resp.setMessage(e.getMessage()); } resp.setBody(rs);
 * ResponseEntity<JsonResponse<List<StorePosRestModel>>> response = new
 * ResponseEntity<JsonResponse<List<StorePosRestModel>>>( resp,
 * HttpStatus.CREATED);
 * 
 * logger.info("Method : viewPosProfile ends"); return response; }
 * 
 * public ResponseEntity<JsonResponse<Object>>
 * addProfilePosCounter(StorePosRestModel storePosRestModel) {
 * 
 * logger.info("Method in Dao: addProfilePosCounter starts");
 * 
 * JsonResponse<Object> resp = new JsonResponse<Object>(); resp.setMessage("");
 * resp.setCode(""); try { String values =
 * GeneratePosProfileParameter.addProfilePosCounter(storePosRestModel); if
 * (storePosRestModel.getOpId() == "" || storePosRestModel.getOpId() == null) {
 * 
 * em.createNamedStoredProcedureQuery("ecommerce_store").setParameter(
 * "actionType", "addPosCounter") .setParameter("actionValue",
 * values).execute();
 * 
 * } else { em.createNamedStoredProcedureQuery("ecommerce_store").setParameter(
 * "actionType", "modifyPosCounter") .setParameter("actionValue",
 * values).execute(); } resp.setCode("Success");
 * resp.setMessage("Factory manager added successfully"); } catch (Exception e)
 * { resp.setCode("Failed"); resp.setMessage(e.getLocalizedMessage());
 * e.printStackTrace(); try { String[] err = serverDao.errorProcedureCall(e);
 * resp.setCode(err[0]); resp.setMessage(err[1]); } catch (Exception e1) {
 * e1.printStackTrace(); } }
 * 
 * ResponseEntity<JsonResponse<Object>> response = new
 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
 * 
 * logger.info("Method in Dao: addProfilePosCounter ends"); return response; }
 * 
 * // ----------------------------------------------Otp by
 * bulet-----------------------------------------------------------------
 * 
 * public ResponseEntity<JsonResponse<Object>>
 * updateposCounterPassword(StorePosRestModel storePosRestModel) {
 * 
 * logger.info("Method in Dao: updateposCounterPassword starts");
 * 
 * JsonResponse<Object> resp = new JsonResponse<Object>(); resp.setMessage("");
 * resp.setCode(""); try {
 * 
 * String values = "";
 * GeneratePosProfileParameter.addProfilePosCounter(storePosRestModel);
 * 
 * if (storePosRestModel.getOpId() == "" || storePosRestModel.getOpId() == null)
 * {
 * 
 * em.createNamedStoredProcedureQuery("ecommerce_store").setParameter(
 * "actionType", "addPosCounter") .setParameter("actionValue",
 * values).execute();
 * 
 * } else { em.createNamedStoredProcedureQuery("ecommerce_store").setParameter(
 * "actionType", "updatePosPassword") .setParameter("actionValue",
 * values).execute(); } resp.setCode("Success");
 * resp.setMessage("Password Modified Succesfully"); } catch (Exception e) {
 * e.printStackTrace(); resp.setCode("Failed"); resp.setMessage(e.getMessage());
 * try { String[] err = serverDao.errorProcedureCall(e); resp.setCode(err[0]);
 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); } }
 * 
 * ResponseEntity<JsonResponse<Object>> response = new
 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
 * 
 * logger.info("Method in Dao: updateposCounterPassword ends");
 * 
 * return response; }
 * 
 * // otp
 * 
 * @SuppressWarnings("unchecked") public JsonResponse<DropDownModel>
 * getposOTP(String userId) { logger.info("Method : getDealerOTP starts" +
 * userId);
 * 
 * DropDownModel req = new DropDownModel(); JsonResponse<DropDownModel> resp =
 * new JsonResponse<DropDownModel>(); List<StorePosRestModel> posModel = new
 * ArrayList<StorePosRestModel>();
 * 
 * try { String value = "SET @p_userId='" + userId + "';"; List<Object[]> x =
 * em.createNamedStoredProcedureQuery("ecommerce_store")
 * .setParameter("actionType", "getposOTP").setParameter("actionValue",
 * value).getResultList(); for (Object[] m : x) {
 * 
 * StorePosRestModel restPayroll = new StorePosRestModel(m[0], m[1], m[2]);
 * posModel.add(restPayroll);
 * 
 * }
 * 
 * String emailpos = posModel.get(0).getOpEmail(); String newline =
 * System.lineSeparator();
 * 
 * Random random = new Random(); String otp = String.format("%04d",
 * random.nextInt(10000)); req.setKey(otp);
 * 
 * String to = ""; String sub = ""; String body = ""; to = emailpos; sub =
 * "Shoukeen Account"; body =
 * "OTP(One Time Password) For Your Shoukeen Account Password Update is " + otp
 * + " .Please Do Not Share With Anyone." + newline + "" + newline + "Regards,"
 * + newline + " Shoukeen Mattress."; try { mailService.sendEmail(to, sub,
 * body); resp.setCode("success"); resp.setMessage("Otp Sent successfully"); }
 * 
 * catch (RestClientException e) { e.printStackTrace();
 * resp.setCode("Unsuccess"); }
 * 
 * resp.setBody(req);
 * 
 * } catch (Exception e) {
 * 
 * e.printStackTrace(); } logger.info("Method : getDealerOTP ends"); return
 * resp; }
 * 
 * }
 */