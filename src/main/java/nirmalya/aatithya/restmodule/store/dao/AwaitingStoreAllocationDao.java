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

@Repository
public class AwaitingStoreAllocationDao {

	Logger logger = LoggerFactory.getLogger(AwaitingStoreAllocationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> awaitingStockAllocationView(String orgName, String orgDivision) {
		logger.info("Method : awaitingStockAllocationView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("store_awaiting_allocation_routines")
					.setParameter("actionType", "awaitingStockAllocationView").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			e.printStackTrace();
		}
		logger.info("Method : awaitingStockAllocationView Dao ends");
		System.out.println("DFScs"+resp);
		return resp;

	}
}
