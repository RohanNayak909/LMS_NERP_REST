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
public class AssetReportDao {
	Logger logger = LoggerFactory.getLogger(AssetReportDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// viewAssetReport
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAssetReport(String orgName, String orgDivision) {
		logger.info("Method : viewAssetReport Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_report_routines")
					.setParameter("actionType", "viewAssetReport").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAssetReport Dao ends");
		return resp;

	}

	// ShowTotalAvailavle
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> showTotal(String type,String cat,String scat,String action, String orgName, String orgDivision) {
		logger.info("Method : showTotal Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_assetType='" + type + "',@p_assetCat='" + cat + "',@p_assetScat='" + scat + "',@p_action='" + action + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.err.println("value===="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_report_routines")
					.setParameter("actionType", "showTotal").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : showTotal Dao ends");
		return resp;
	}

}
