package nirmalya.aatithya.restmodule.training.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class YourTrainingDao {

	Logger logger = LoggerFactory.getLogger(YourTrainingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getAssignedEmployeeListDao(String organization, String orgDivision,String state ,String userId) {
		logger.info("Method : getAssignedEmployeeListDao starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision+ "',@p_state='" + state  + "',@p_userId='" + userId + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("manageTrainingRoutines")
					.setParameter("actionType", "viewASEmpList").setParameter("actionValue", value).getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("viewHrmsEmpPersonalDetails: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getAssignedEmployeeListDao ends");
		return resp;
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getCategoryDetails(String organization, String orgDivision,String id) {
		logger.info("Method : getCategoryDetails starts");

		String value = "SET @p_org='" + organization
				+ "',@p_orgDiv='" + orgDivision +"',@p_id='" + id + "';";
		
		JsonResponse resp = new JsonResponse();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("manageTrainingRoutines")
					.setParameter("actionType", "getCategoryDetails").setParameter("actionValue", value).getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("tttttttttttttttttttt"+resp);	
		logger.info("Method : getCategoryDetails ends");
		return resp;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getCategoryDocs(String organization, String orgDivision,String id) {
		logger.info("Method : getAssignedEmployeeDetails starts");

		String value = "SET @p_org='" + organization
				+ "',@p_orgDiv='" + orgDivision +"',@p_id='" + id + "';";
		
		JsonResponse resp = new JsonResponse();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("manageTrainingRoutines")
					.setParameter("actionType", "getCategoryDocs").setParameter("actionValue", value).getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAssignedEmployeeDetails ends");
		return resp;
	}
	
	@SuppressWarnings({"rawtypes" })
	public JsonResponse setStartingData(String organization, String orgDivision,String id) {
		logger.info("Method : setStartingData starts");

		String value = "SET @p_org='" + organization
				+ "',@p_orgDiv='" + orgDivision +"',@p_id='" + id + "';";
		JsonResponse resp = new JsonResponse();
		try {
			 em.createNamedStoredProcedureQuery("manageTrainingRoutines")
					.setParameter("actionType", "setStartingData").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : setStartingData ends");
		return resp;
	}
	
	@SuppressWarnings({"rawtypes" })
	public JsonResponse saveTrainingCount(String organization, String orgDivision,String count,String sId) {
		logger.info("Method : setStartingData starts");

		String value = "SET @p_org='" + organization
				+ "',@p_orgDiv='" + orgDivision +"',@p_count='" + count + "',@p_sId='" +sId+ "';";
		
		JsonResponse resp = new JsonResponse();
		try {
			 em.createNamedStoredProcedureQuery("manageTrainingRoutines")
					.setParameter("actionType", "setTrainingCount").
					setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : setStartingData ends");
		return resp;
	}
	
	@SuppressWarnings({"rawtypes" })
	public JsonResponse finishTraining(String organization, String orgDivision,String schId) {
		logger.info("Method : setStartingData starts");

		String value = "SET @p_org='" + organization
				+ "',@p_orgDiv='" + orgDivision + "',@p_sId='" +schId+ "';";
		
		JsonResponse resp = new JsonResponse();
		try {
			 em.createNamedStoredProcedureQuery("manageTrainingRoutines")
					.setParameter("actionType", "finishTraining").
					setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : setStartingData ends");
		return resp;
	}
}