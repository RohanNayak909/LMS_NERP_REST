package nirmalya.aatithya.restmodule.user.dao;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.StringUtil;
import nirmalya.aatithya.restmodule.util.Util;
/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class RestEmployeePasswordResetDao {

	Logger logger = LoggerFactory.getLogger(RestEmployeePasswordResetDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	@Autowired
	PasswordEncoder passEncoder;
	
	@Autowired
	EnvironmentVaribles env;
	public ResponseEntity<JsonResponse<Object>> resetEmployeePasswordDao(DropDownModel data) {
		logger.info("Method : resetEmployeePasswordDao Dao starts");

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
					logger.info(data.getName());
					logger.info(data.getCode());

					if (data.getCode() != null && data.getCode() != "") {
						password = passEncoder.encode(data.getCode());
					}

					if (data.getName() != null && data.getName() != "" && data.getCode() != null
							&& data.getCode() != "") {

						String encodePassword = checkDuplicateDao.getUserPassword(data.getKey());
						logger.info("encodePassword==="+encodePassword);
						Boolean status = passEncoder.matches(data.getName(),encodePassword);
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

		logger.info("Method : resetEmployeePasswordDao Dao ends");
		return response;
	}

}
