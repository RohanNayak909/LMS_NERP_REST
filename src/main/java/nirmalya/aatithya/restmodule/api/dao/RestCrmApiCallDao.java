package nirmalya.aatithya.restmodule.api.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import nirmalya.aatithya.restmodule.api.model.RestCrmApiCallModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GenerateCrmVisitApiParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class RestCrmApiCallDao {
	Logger logger = LoggerFactory.getLogger(RestCrmApiCallDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;
	
	
	/**
	 * DAO Function to Add
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addCrmCallMaster(RestCrmApiCallModel restCall) {
		logger.info("Method : Rest checkInCrmCallMaster  Dao starts");
		logger.info("restCall===="+restCall);
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {

				String values = GenerateCrmVisitApiParam.getCallMasterParam(restCall);
				logger.info("VALUES" + values);
				if (restCall.getCallId() == null || restCall.getCallId() == "") {

					em.createNamedStoredProcedureQuery("crm_CallApi_Details")
							.setParameter("actionType", "addCrmCallMaster").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("crm_CallApi_Details")
							.setParameter("actionType", "modifyCrmCallMaster").setParameter("actionValue", values)
							.execute();
				}
				resp.setCode("Success");
				resp.setMessage("Data Saved Successfully");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("Failed");
				resp.setMessage(e.getLocalizedMessage());

			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Rest addCrmCallMaster  Dao ends");

		logger.info("ADDDDDDDDDDD" + response);

		return response;
	}

	// View

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmApiCallModel>> viewCrmCallMaster(String createdBy,String organization, String orgDivision) {
		logger.info("Method : viewCrmCallMaster Dao starts");

		List<RestCrmApiCallModel> viewMaster = new ArrayList<RestCrmApiCallModel>();
		JsonResponse<List<RestCrmApiCallModel>> resp = new JsonResponse<List<RestCrmApiCallModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("VALUE FOR CALL VIEW------>"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_CallApi_Details")
					.setParameter("actionType", "viewCrmCallMaster").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestCrmApiCallModel restStudentModel = new RestCrmApiCallModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9],m[10],m[11],m[12],null,null,null,null,m[13],m[14].toString());
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}

			}
			if(viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmCallMaster Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}
	/**
	 * DAO 
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> checkInCrmCallMaster(RestCrmApiCallModel restCall) {
		logger.info("Method : Rest checkInCrmCallMaster  Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {

				String values = GenerateCrmVisitApiParam.getCallMasterCheckinParam(restCall);
				logger.info("VALUES" + values);
				logger.info("IDDDD" + restCall.getCallId());
				if (restCall.getCallId() != null || restCall.getCallId() != "") {
					
					logger.info("ADDDDDDDCKKKK" + restCall.getCallId());

					em.createNamedStoredProcedureQuery("crm_CallApi_Details")
					.setParameter("actionType", "checkInCrmCallMaster").setParameter("actionValue", values)
					.execute();

				} 
				resp.setCode("Success");
				resp.setMessage("Data Saved Successfully");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("Failed");
				resp.setMessage(e.getLocalizedMessage());

			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Rest checkInCrmCallMaster  Dao ends");

		logger.info("ADDDDDDDDDDD" + response);

		return response;
	}
	
	// View

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmApiCallModel>> viewCrmCallvisitHistory(String createdBy,String organization, String orgDivision) {
		logger.info("Method : viewCrmCallvisitHistory Dao starts");

		List<RestCrmApiCallModel> viewMaster = new ArrayList<RestCrmApiCallModel>();
		JsonResponse<List<RestCrmApiCallModel>> resp = new JsonResponse<List<RestCrmApiCallModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_CallApi_Details")
					.setParameter("actionType", "viewCrmCallvisitHistory").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[13] != null) {
					date  =DateFormatter.returnStringDate(m[13]);
				}
				RestCrmApiCallModel restStudentModel = new RestCrmApiCallModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9],m[10],m[11],m[12],date,m[14],m[15],m[16],null,null);
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}

			}
			if(viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmCallvisitHistory Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}
	// View call history report
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmApiCallModel>> viewCrmCallvisitHistoryReport(String userId,String organization, String orgDivision,
			String fromDate,String toDate) {
		logger.info("Method : viewCrmCallvisitHistoryReport Dao starts");
		
		List<RestCrmApiCallModel> viewMaster = new ArrayList<RestCrmApiCallModel>();
		JsonResponse<List<RestCrmApiCallModel>> resp = new JsonResponse<List<RestCrmApiCallModel>>();
		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "',@p_user='" + userId + "';";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_CallApi_Details")
					.setParameter("actionType", "viewCrmCallvisitHistoryReport").setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {
				Object date = null;
				if (m[13] != null) {
					date  =DateFormatter.returnStringDate(m[13]);
				}
				RestCrmApiCallModel restStudentModel = new RestCrmApiCallModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9],m[10],m[11],m[12],date,m[14],m[15],m[16],null,null);
				viewMaster.add(restStudentModel);
				
				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if(viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmCallvisitHistoryReport Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}
	// View call history report search
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmApiCallModel>> viewCrmCallvisitHistoryReportSearch(String userId,String organization, String orgDivision,
			String fromDate,String toDate,String customer,String saleTeam) {
		logger.info("Method : viewCrmCallvisitHistoryReportSearch Dao starts");
		
		List<RestCrmApiCallModel> viewMaster = new ArrayList<RestCrmApiCallModel>();
		JsonResponse<List<RestCrmApiCallModel>> resp = new JsonResponse<List<RestCrmApiCallModel>>();
		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "',"
					+ "@p_user='" + userId + "',@p_customer='" + customer + "',@p_saleTeam='" + saleTeam + "';";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_CallApi_Details")
					.setParameter("actionType", "viewCrmCallvisitHistoryReportSearch").setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {
				Object date = null;
				if (m[13] != null) {
					date  =DateFormatter.returnStringDate(m[13]);
				}
				RestCrmApiCallModel restStudentModel = new RestCrmApiCallModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9],m[10],m[11],m[12],date,m[14],m[15],m[16],null,null);
				viewMaster.add(restStudentModel);
				
				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if(viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmCallvisitHistoryReportSearch Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}
	//delete call
		public ResponseEntity<JsonResponse<Object>> deleteCrmCallMaster(String callid,String organization, String orgDivision) {
			logger.info("Method : deleteCrmCallMaster starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_callid='" + callid + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
				logger.info("value===="+value);
				em.createNamedStoredProcedureQuery("crm_CallApi_Details").setParameter("actionType", "deleteCrmCallMaster")
						.setParameter("actionValue", value).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
			} catch

			(Exception e) {
				String[] err = serverDao.errorProcedureCall(e);
				logger.error("Error " + err[1]);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);
			logger.info("Method : deleteCrmCallMaster ends");
			return response;
		}
}
