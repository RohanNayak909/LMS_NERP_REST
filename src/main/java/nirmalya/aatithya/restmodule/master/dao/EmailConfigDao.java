package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.EmailConfigModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class EmailConfigDao {

	Logger logger = LoggerFactory.getLogger(EmailConfigDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<EmailConfigModel>> saveEmailConfiguration(EmailConfigModel emailDtls) {
		logger.info("Method : saveEmailConfiguration starts");

		Boolean validity = true;
		JsonResponse<EmailConfigModel> resp = new JsonResponse<EmailConfigModel>();
		resp.setMessage("");
		resp.setCode("");

		List<EmailConfigModel> newLoc = new ArrayList<EmailConfigModel>();

		if (emailDtls.getEmailId() == null || emailDtls.getEmailId() == "") {
			resp.setMessage("Email Id Required");
			validity = false;
		} else if (emailDtls.getEmailPassword() == null || emailDtls.getEmailPassword() == "") {
			resp.setMessage("Email Password Required");
			validity = false;
		} else if (emailDtls.getHostUrl() == null || emailDtls.getHostUrl() == "") {
			resp.setMessage("Host URL Required");
			validity = false;
		} else if (emailDtls.getHostPort() == null || emailDtls.getHostPort() == "") {
			resp.setMessage("Host Port Required");
			validity = false;
		}

		if (validity)
			try {
				
				if(emailDtls.getConnectionId() == null || emailDtls.getConnectionId() == "") {
					String value = "SET @p_emailType='" + emailDtls.getEmailType() + "', @p_emailId='"
							+ emailDtls.getEmailId() + "', @p_emailPassword='" + emailDtls.getEmailPassword()
							+ "', @p_hostUrl='" + emailDtls.getHostUrl() + "', @p_hostPort='" + emailDtls.getHostPort()
							+ "', @p_createdBy='" + emailDtls.getCreatedBy() + "', @p_usageName='" + emailDtls.getUsageName() + "';";

					List<Object[]> x = em.createNamedStoredProcedureQuery("mailConfigRoutines")
							.setParameter("actionType", "addMailDtls").setParameter("actionValue", value).getResultList();
					for (Object[] m : x) {

						EmailConfigModel item = new EmailConfigModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7]);
						newLoc.add(item);
					}
					resp.setBody(newLoc.get(0));
				} else {
					String value = "SET @p_mailConfig='"+emailDtls.getConnectionId()+"', @p_emailType='" + emailDtls.getEmailType() + "', @p_emailId='"
							+ emailDtls.getEmailId() + "', @p_emailPassword='" + emailDtls.getEmailPassword()
							+ "', @p_hostUrl='" + emailDtls.getHostUrl() + "', @p_hostPort='" + emailDtls.getHostPort()
							+ "', @p_createdBy='" + emailDtls.getCreatedBy() + "', @p_usageName='" + emailDtls.getUsageName() + "';";

					List<Object[]> x = em.createNamedStoredProcedureQuery("mailConfigRoutines")
							.setParameter("actionType", "modifyMailDtls").setParameter("actionValue", value).getResultList();
					for (Object[] m : x) {

						EmailConfigModel item = new EmailConfigModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7]);
						newLoc.add(item);
					}
					resp.setBody(newLoc.get(0));
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<EmailConfigModel>> response = new ResponseEntity<JsonResponse<EmailConfigModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveEmailConfiguration ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<EmailConfigModel>> editEmailConfig(String id) {
		logger.info("Method : editEmailConfig starts");

		JsonResponse<EmailConfigModel> resp = new JsonResponse<EmailConfigModel>();

		List<EmailConfigModel> newLoc = new ArrayList<EmailConfigModel>();

		try {
			
			String value = "SET @P_Conn='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("mailConfigRoutines")
					.setParameter("actionType", "editViewMailDtls").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				EmailConfigModel item = new EmailConfigModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7]);
				newLoc.add(item);
			}
			resp.setBody(newLoc.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<EmailConfigModel>> response = new ResponseEntity<JsonResponse<EmailConfigModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : editEmailConfig ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteEmailConfig(String id) {
		logger.info("Method : deleteEmailConfig starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			
			String value = "SET @P_Conn='" + id + "';";
			
			em.createNamedStoredProcedureQuery("mailConfigRoutines")
					.setParameter("actionType", "deleteEmailConfig").setParameter("actionValue", value).execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : deleteEmailConfig ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<EmailConfigModel>>> getTotalMailConenction() {
		logger.info("Method : getTotalMailConenction starts");
		
		JsonResponse<List<EmailConfigModel>> resp = new JsonResponse<List<EmailConfigModel>>();

		List<EmailConfigModel> mailDtls = new ArrayList<EmailConfigModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("mailConfigRoutines")
					.setParameter("actionType", "getTotalMailConenction").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				EmailConfigModel item = new EmailConfigModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7]);
				mailDtls.add(item);
			}
			
			resp.setBody(mailDtls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<EmailConfigModel>>> response = new ResponseEntity<JsonResponse<List<EmailConfigModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getTotalMailConenction ends");
		return response;
	}
}
