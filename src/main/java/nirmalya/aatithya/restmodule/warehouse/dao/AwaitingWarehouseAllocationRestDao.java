package nirmalya.aatithya.restmodule.warehouse.dao;

import javax.persistence.EntityManager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class AwaitingWarehouseAllocationRestDao {

	Logger logger = LoggerFactory.getLogger(AwaitingWarehouseAllocationRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAllocationData(String orgName, String orgDivision) {
		logger.info("Method : viewAllocationData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("warehouse_awaiting_allocation_routines")
					.setParameter("actionType", "viewAllocationData").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			e.printStackTrace();
		}
		logger.info("Method : viewAllocationData Dao ends");
		return resp;

	}

}
