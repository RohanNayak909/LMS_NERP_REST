package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterGoalAssign;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestGoalAssignModel;

@Repository
public class RestGoalAssignDao {
	Logger logger = LoggerFactory.getLogger(RestGoalAssignDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * get name list
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getName(String id) {
		logger.info("Method : getNameLists Dao starts");

		List<DropDownModel> getNameList = new ArrayList<DropDownModel>();
		String value = "SET @p_empId='" + id + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowGoalAssign")
					.setParameter("actionType", "getNameList").setParameter("actionValue",value).getResultList();
		for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				getNameList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getNameLists Dao ends");

		return getNameList;
	}

	/*
	 * get designation list
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getDesignation(String id) {
		
		
			logger.info("Method : getDesignationList starts");
			List<DropDownModel> jobList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			String value = "SET @p_tGuestName='" + id + "';";
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowGoalAssign")
						.setParameter("actionType", "getDeginationList").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {

					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					jobList.add(dropDownModel);
				}

				resp.setBody(jobList);

			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getDesignationList ends");
			logger.info("VIEW"+resp);
			return resp;
		}
		/*
		 * view explore data
		 */
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestGoalAssignModel>>> viewExploreData() {
			logger.info("Method : viewJobType starts");

			List<RestGoalAssignModel> jobList = new ArrayList<RestGoalAssignModel>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowGoalAssign")
						.setParameter("actionType", "viewExploreData").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {				
					RestGoalAssignModel dropDownModel = new RestGoalAssignModel(m[0], m[1], m[2], m[3]);
					jobList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			JsonResponse<List<RestGoalAssignModel>> resp = new JsonResponse<List<RestGoalAssignModel>>();
			resp.setBody(jobList);

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");
			ResponseEntity<JsonResponse<List<RestGoalAssignModel>>> response = new ResponseEntity<JsonResponse<List<RestGoalAssignModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);

			logger.info("Method : viewJobType ends");
			return response;
		}
		/*
		 * add goal to assigned table 
		 */
		public ResponseEntity<JsonResponse<List<RestGoalAssignModel>>> addGoalAssign(List<RestGoalAssignModel> restaddGoalAssign) {
			logger.info("Method : addGoalAssign Dao starts");
		
			JsonResponse<List<RestGoalAssignModel>> resp = new JsonResponse<List<RestGoalAssignModel>>();
			List<RestGoalAssignModel> listData = new ArrayList<RestGoalAssignModel>();
			
				try {
					String values = GenerateMasterGoalAssign.generateGoalAssign(restaddGoalAssign);
					logger.info("ADDDDASSIGN"+values);
						em.createNamedStoredProcedureQuery("hrmsGrowGoalAssign").setParameter("actionType", "addGoalAssign")
								.setParameter("actionValue", values).execute();
			
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
				resp.setBody(listData);
				ResponseEntity<JsonResponse<List<RestGoalAssignModel>>>  response = new ResponseEntity<JsonResponse<List<RestGoalAssignModel>>> (resp,
					HttpStatus.CREATED);

			logger.info("Method : addGoalAssign Dao ends");

			return response;
		}
		
		/*
		 * view assigned data
		 */
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestGoalAssignModel>>> viewAssignedData(String name) {
			logger.info("Method : viewAssignedData starts");

			List<RestGoalAssignModel> jobList = new ArrayList<RestGoalAssignModel>();
			
			String value = "SET @p_empName='" + name + "';";
			
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowGoalAssign")
						.setParameter("actionType", "viewAssignedData").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {	
					RestGoalAssignModel dropDownModel = new RestGoalAssignModel(m[0].toString(), m[1], m[2], m[3]);
					jobList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			JsonResponse<List<RestGoalAssignModel>> resp = new JsonResponse<List<RestGoalAssignModel>>();
			resp.setBody(jobList);

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");
			ResponseEntity<JsonResponse<List<RestGoalAssignModel>>> response = new ResponseEntity<JsonResponse<List<RestGoalAssignModel>>>(
					resp, responseHeaders, HttpStatus.CREATED);
			/* logger.info("111111111111"+response); */
			logger.info("Method : viewAssignedData ends");
			return response;
		}

	}

	
	
	


