package nirmalya.aatithya.restmodule.apprasial.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class NormalizationRestDao {

	Logger logger = LoggerFactory.getLogger(NormalizationRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllReviewedEmployee(String orgName, String orgDivision) {
		logger.info("Method : getAllReviewedEmployee Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("appraisal_review_routines")
					.setParameter("actionType", "getAllReviewedEmployee").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setMessage("Fetched Data SuccessFully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("UnSuccess");
			resp.setMessage("Something went Wrong !");
		}
		logger.info("Method : getAllReviewedEmployee Dao ends");
		return resp;
	}
}
