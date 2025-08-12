package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateGoalMasterParameters;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestGoalMastersModel;
@Repository
public class RestGoalMasterDao {
	Logger logger = LoggerFactory.getLogger(RestGoalMasterDao.class);
	
	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EntityManager em;

	
	// View Goal Master

				@SuppressWarnings("unchecked")
				public JsonResponse<List<RestGoalMastersModel>> viewGoalMaster() {
						logger.info("Method : viewGoalMaster Dao starts");
			  
						List<RestGoalMastersModel> viewGoalMaster = new ArrayList<RestGoalMastersModel>();
							JsonResponse<List<RestGoalMastersModel>> resp = new JsonResponse<List<RestGoalMastersModel>>(); 
							try {
			  
								List<Object[]> x =em.createNamedStoredProcedureQuery("goalRoutiness") 
										.setParameter("actionType", "viewGoalMaster").setParameter("actionValue", "").getResultList();
			  
								for (Object[] m : x) {
								
								
									RestGoalMastersModel restStudentModel = new RestGoalMastersModel(m[0],m[1],m[2],m[3]);
									viewGoalMaster.add(restStudentModel);

								}

							} catch (Exception e) {
								e.printStackTrace();
							}
							resp.setBody(viewGoalMaster);
							logger.info("Method : viewGoalMaster Dao ends");
							logger.info("VIEWWWWW"+resp);
							return resp;
						}
				
			
				
				/**
				 * DAO Function to Add
				 *
				 */
				public ResponseEntity<JsonResponse<Object>> addGoalMaster(RestGoalMastersModel restPayroll) {
					logger.info("Method : Rest addGoalMaster  Dao starts");
					Boolean validity = true;
					JsonResponse<Object> resp = new JsonResponse<Object>();
		//	logger.info( "ADDDDDDID"+ restPayroll.getGoalIdAuto() );
					if (validity)
						try {

							String values = GenerateGoalMasterParameters.getGoalMasterParam(restPayroll);

							if (restPayroll.getGoalId() == null || restPayroll.getGoalId() == "") {

								em.createNamedStoredProcedureQuery("goalRoutiness")
										.setParameter("actionType", "addGoalMaster").setParameter("actionValue", values)
										.execute();

							} else {
			             logger.info("MODIFYYYYYYY"+restPayroll.getGoalId());
			             logger.info("VALUEEEEE"+values);
								em.createNamedStoredProcedureQuery("goalRoutiness")
										.setParameter("actionType", "modifygoal").setParameter("actionValue", values)
										.execute();
							}
							logger.info("VALUEEEEE"+values);
						} catch (Exception e) {
							try {
								String[] err = serverDao.errorProcedureCall(e);
								resp.setCode(err[0]);
								resp.setMessage(err[1]);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							e.printStackTrace();
						}

					ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
							HttpStatus.CREATED);

					logger.info("Method : Rest GoalMaster  Dao ends");

					logger.info("ADDDDDDDDDDD" + response);

					return response;
				}

	
	 
	
	// edit apply

	@SuppressWarnings("unchecked")
	public JsonResponse<RestGoalMastersModel> editGoalMaster(String id) {
		logger.info("Method : editGoalMaster dao starts");
		logger.info("Edit" + id);
		RestGoalMastersModel req = new RestGoalMastersModel();
		JsonResponse<RestGoalMastersModel> resp = new JsonResponse<RestGoalMastersModel>();
		try {
			String value = "SET @p_goalId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goalRoutiness")
					.setParameter("actionType", "editGoalMaster").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				

				RestGoalMastersModel restPayroll = new RestGoalMastersModel(m[0],m[1],m[2],m[3].toString());
				req = restPayroll;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("editGoalMaster" + resp);
		logger.info("Method : editGoalMaster dao ends");
		return resp;
	}
			
	
	// delete

	public ResponseEntity<JsonResponse<Object>> deleteGoalMaster(String id) {
		logger.info("Method : deleteGoalMaster starts");

		
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_goalId='" + id + "';";

				em.createNamedStoredProcedureQuery("goalRoutiness").setParameter("actionType", "deleteGoalMaster")
						.setParameter("actionValue", value).execute();

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteGoalMaster ends");
		logger.info("DELETEE" + response);
		return response;
	}
	 
}
