package nirmalya.aatithya.restmodule.user.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
@Repository
public class UserAllTaskDao {
	Logger logger = LoggerFactory.getLogger(UserAllTaskDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;
	//allTasksView
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> allTasksView(String orgName, String orgDivision, String userId) {
			logger.info("Method : allTasksView Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("user_all_task_routines")
						.setParameter("actionType", "viewAllTasks").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : allTasksView Dao ends");
			return resp;
		}	
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getTaskForCalendars(String startDate, String endtDate, String orgName,
				String orgDiv, String userId) {
			logger.info("Method : getTaskForCalendars Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_startDate='" + startDate + "',@p_endtDate='" + endtDate + "',@p_orgName='" + orgName
						+ "',@p_orgDivision='" + orgDiv + "',@p_userId='" + userId + "';";
				System.out.println(value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("user_all_task_routines")
						.setParameter("actionType", "getTaskForCalendars").setParameter("actionValue", value)
						.getResultList();
				System.out.println(x);
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");

			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getTaskForCalendars Dao ends");
			return resp;
		}
}
