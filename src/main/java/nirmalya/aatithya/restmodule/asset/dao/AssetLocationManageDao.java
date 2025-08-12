package nirmalya.aatithya.restmodule.asset.dao;

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
public class AssetLocationManageDao {
	Logger logger = LoggerFactory.getLogger(AssetLocationManageDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> locationManageView(String orgName, String orgDivision,String userId, String userRole) {
		logger.info("Method : locationManageView Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "',@p_userRole='" + userRole + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_assign_routines")
					.setParameter("actionType", "locationManageView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			resp.setCode("unsuccess");
			resp.setMessage("Data Could Not Fetched");
			e.printStackTrace();
		}
		logger.info("Method : locationManageView Dao ends");
		return resp;

	}
}
