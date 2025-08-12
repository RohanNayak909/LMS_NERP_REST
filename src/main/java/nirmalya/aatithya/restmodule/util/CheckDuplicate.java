package nirmalya.aatithya.restmodule.util;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.user.dao.UserDao;

@Repository
public class CheckDuplicate {

	Logger logger = LoggerFactory.getLogger(UserDao.class);
 
	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public Integer ifDataIsDuplicate(String type, String data, String id) {
		logger.info("Method : ifDataIsDuplicate starts");
		
		Integer statusCode = null;

		try {
			String value = "SET @json_input = '" + data + "', @cust_id='" + id + "'";
			List<BigInteger> x = em.createNamedStoredProcedureQuery("checkDuplicateData")
					.setParameter("actionType", type).setParameter("actionValue", value).getResultList();
			
			if (!x.isEmpty()) {
	            statusCode = x.get(0).intValue();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : ifDataIsDuplicate starts");
		return statusCode;
	}
}
