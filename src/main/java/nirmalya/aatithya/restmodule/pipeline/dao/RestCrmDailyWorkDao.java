package nirmalya.aatithya.restmodule.pipeline.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateDailyWorkParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmDailyWorkModel;

@Repository
public class RestCrmDailyWorkDao {
	
	Logger logger = LoggerFactory.getLogger(RestCrmDealDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	//addTask
	
	/**
	 * DAO Function to add pipeline
	 *
	 */

	public JsonResponse<Object> addDailyWork(RestCrmDailyWorkModel dailyWork) {
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values =GenerateDailyWorkParameter.getAddDailyWorkParam(dailyWork);
				logger.info("Values for add Daily Work----------------------"+values);
				if (dailyWork.getActivityId() == null || dailyWork.getActivityId() == "") {
					logger.info("add============="+dailyWork.getActivityId());

					
						em.createNamedStoredProcedureQuery("crm_dailyWork").setParameter("actionType", "addDailyWork")
						.setParameter("actionValue", values).execute();
				
					

				} else {
					logger.info("update=============");
					em.createNamedStoredProcedureQuery("crm_dailyWork").setParameter("actionType", "modifyDailyWork")
							.setParameter("actionValue", values).execute();

				}
			} catch

			(Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		logger.info("ADDDDD@@@@@" + resp);

		logger.info("Method : addCampaign ends");
		return resp;
	}
	
	
	///restViewTaskdetails
	


////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmDailyWorkModel>>> restviewCrmDailyAjax() {
		logger.info("Method : restviewCrmDailyAjax starts");
		List<RestCrmDailyWorkModel> respList = new ArrayList<RestCrmDailyWorkModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dailyWork").setParameter("actionType", "getDailyDetails")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				
				RestCrmDailyWorkModel restPayroll = new RestCrmDailyWorkModel(m[0].toString(), m[1], m[2], m[3],
						m[4].toString(), m[5], m[6], m[7].toString());
				respList.add(restPayroll); 
				

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestCrmDailyWorkModel>> resp = new JsonResponse<List<RestCrmDailyWorkModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCrmDailyWorkModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmDailyWorkModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : restviewCrmDailyAjax ends");

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}
	
	//getLeadNameList
	
	
	/**
	 * for getLeadNameList list
	 * @return
	 */
/*	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLeadNameList() {
		
		logger.info("Method : getLeadNameList starts");
		
		List<DropDownModel> employmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_task")
					.setParameter("actionType", "getLeadNameList")
					.setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getLeadNameList ends"+employmentList);
		
		return employmentList;
	}*/
	

	///editCampaignsInfo   
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestCrmDailyWorkModel>>>editDailyWork(String id) {
			logger.info("Method : editDailyWork starts");

			JsonResponse<List<RestCrmDailyWorkModel>> resp = new JsonResponse<List<RestCrmDailyWorkModel>>();
			List<RestCrmDailyWorkModel> rs = new ArrayList<RestCrmDailyWorkModel>();

			try {

				String value = "SET @p_activityId='" + id +"';";
				logger.info(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dailyWork")
						.setParameter("actionType", "editDailyWork").setParameter("actionValue", value).getResultList();
				logger.info("asdfasdf"+x);
	           
				for (Object[] m : x) {
					RestCrmDailyWorkModel restPayroll = new RestCrmDailyWorkModel(m[0].toString(), m[1], m[2], m[3],
							m[4].toString(), m[5], m[6], m[7].toString());
					
					
					
					
					rs.add(restPayroll);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	resp.setBody(rs);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<List<RestCrmDailyWorkModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmDailyWorkModel>>>(resp,responseHeaders,
					HttpStatus.CREATED);

			logger.info("Method : editDailyWork ends");
			return response;
		}

	//deleteCampaignDetails
		
		/*
		 * delete
		 */

	public ResponseEntity<JsonResponse<Object>> deleteCrmDailyWork(String id) {
			logger.info("Method : deleteCrmDailyWork starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			logger.info("ID...."+id);
			if (validity)
				try {

					//String value = "SET @p_taskId='" + id + "';";
					String value = "SET  @p_activityId='(" + id + ")';";
					logger.info("value for set campaign-------------------------"+value);

					em.createNamedStoredProcedureQuery("crm_dailyWork")
							.setParameter("actionType", "deleteDailyActy").setParameter("actionValue", value).execute();

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

			logger.info("Method :  deleteCrmDailyWork ends");
			logger.info("DELETE" + response);
			return response;
		}
		

}
