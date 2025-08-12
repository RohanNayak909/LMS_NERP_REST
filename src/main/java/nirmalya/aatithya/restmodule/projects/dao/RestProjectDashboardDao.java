package nirmalya.aatithya.restmodule.projects.dao;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestProjectDashboardDao {
	Logger logger = LoggerFactory.getLogger(RestProjectDashboardDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> projectHeadData(String orgName, String orgDivision) {
		logger.info("Method : projectHeadData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("project_dashboard_Routines")
					.setParameter("actionType", "projectHeadData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : projectHeadData Dao ends" + resp);
		return resp;

	}
	
	//===============================================
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> projectDashoardAllReport(String orgName, String orgDivision,String id) {
		logger.info("Method : projectDashoardAllReport Dao startssssssssssssssssssssss");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='"+id+"';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("project_dashboard_Routines")
					.setParameter("actionType", "getProjectReport").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("Method : projectDashoardAllReport Dao ends"+ resp);
		return resp;
		
	}
	
	
}