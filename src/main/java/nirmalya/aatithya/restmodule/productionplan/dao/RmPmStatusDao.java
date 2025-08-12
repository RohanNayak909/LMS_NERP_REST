package nirmalya.aatithya.restmodule.productionplan.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RmPmStatusDao {

	Logger logger = LoggerFactory.getLogger(RmPmStatusDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> statusView(String orgName, String orgDivision, String state, String shift,
			String date) {
		logger.info("Method : statusView Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String Date = DateFormatter.getStringDate(date);

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_state='" + state
					+ "',@p_shift='" + shift + "',@p_date='" + Date + "';";
			System.out.println("value>>>------" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_mfg_process_routines")
					.setParameter("actionType", "rmpmStatus").setParameter("actionValue", value).getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : statusView Dao ends");

		return resp;

	}

}
