package nirmalya.aatithya.restmodule.store.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.warehouse.dao.RestAwaitingGoodsBlockingDao;

@Repository
public class StoreAwaitingGoodsBlockingDao {
	Logger logger = LoggerFactory.getLogger(StoreAwaitingGoodsBlockingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> awaitingStoreBlockingView(String orgName, String orgDivision) {
		logger.info("Method : awaitingStoreBlockingView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("awaiting_store_blocking_routines")
					.setParameter("actionType", "awaitingStoreBlockingView").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			e.printStackTrace();
		}
		logger.info("Method : awaitingStoreBlockingView Dao ends");
		return resp;

  }
}
