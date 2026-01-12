package nirmalya.aatithya.restmodule.sales.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
@Repository
public class RestDebitNoteDao {
	Logger logger = LoggerFactory.getLogger(RestDebitNoteDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	
	/*
	 * view Product ItemData
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewdebitNoteData(String orgName, String orgDivision) {
		logger.info("Method : viewdebitNoteData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("view_debitNoteData_Routines")
					.setParameter("actionType", "viewdebitNoteData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewdebitNoteData Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

}
