package nirmalya.aatithya.restmodule.productionplan.dao;

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
public class ProductionPlanRestDao {
	Logger logger = LoggerFactory.getLogger(ProductionPlanRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;


	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewProductionLog(String orgName, String orgDivision,String floorId) {
		logger.info("Method : viewProductionLog Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_floorId='" + floorId + "';";
			System.out.println("VALUE::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_manage_shopFloor_routines")
					.setParameter("actionType", "viewProductionLog").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewProductionLog Dao ends");
		return resp;

	}
}
