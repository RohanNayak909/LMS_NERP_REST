package nirmalya.aatithya.restmodule.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.model.RestCrmApiTaskModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
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
public class RestApiCrmTaskDao {
	Logger logger = LoggerFactory.getLogger(RestApiCrmTaskDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLeadList(String organization, String orgDivision) {
		logger.info("Method : getLeadList starts");
		List<DropDownModel> list = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_TaskApi_Details")
					.setParameter("actionType", "getLeadList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString(),m[2]);
				list.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getLeadList end");
		return list;
	}

	// get Decision Maker List
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDecisionMakerList(String leadId, String organization, String orgDivision) {
		logger.info("Method : getDecisionMakerList starts");
		List<DropDownModel> list = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_leadId='" + leadId + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_TaskApi_Details")
					.setParameter("actionType", "getDecisionMakerList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				list.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDecisionMakerList end");
		return list;
	}

	/**
	 * DAO Function to Add
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addCrmTaskMaster(RestCrmApiTaskModel restTask) {
		logger.info("Method : Rest addCrmTaskMaster  Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {

				String values = GenerateCrmVisitApiParam.getTaskMasterParam(restTask);
				logger.info("VALUES" + values);
				logger.info("IDDDD" + restTask.getTaskId());
				if (restTask.getTaskId() == null || restTask.getTaskId() == "") {

					em.createNamedStoredProcedureQuery("crm_TaskApi_Details")
							.setParameter("actionType", "addCrmTaskMaster").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("crm_TaskApi_Details")
							.setParameter("actionType", "modifyCrmTaskMaster").setParameter("actionValue", values)
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

		logger.info("Method : Rest addCrmTaskMaster  Dao ends");

		logger.info("ADDDDDDDDDDD" + response);

		return response;
	}

	// View

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmApiTaskModel>> viewCrmTaskMaster(String createdBy,String organization, String orgDivision) {
		logger.info("Method : viewCrmTaskMaster Dao starts");

		List<RestCrmApiTaskModel> viewMaster = new ArrayList<RestCrmApiTaskModel>();
		JsonResponse<List<RestCrmApiTaskModel>> resp = new JsonResponse<List<RestCrmApiTaskModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_TaskApi_Details")
					.setParameter("actionType", "viewCrmTaskMaster").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestCrmApiTaskModel restStudentModel = new RestCrmApiTaskModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],null,null,null,null,m[16],m[17].toString());
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
		logger.info("Method : viewCrmTaskMaster Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}
	/**
	 * DAO
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> checkInCrmTaskMaster(RestCrmApiTaskModel restTask) {
		logger.info("Method : Rest checkInCrmTaskMaster  Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {
				String values = GenerateCrmVisitApiParam.getTaskMasterCheckinParam(restTask);
				logger.info("VALUES" + values);
				logger.info("IDDDD" + restTask.getTaskId());
				if (restTask.getTaskId() != null || restTask.getTaskId() != "") {
					em.createNamedStoredProcedureQuery("crm_TaskApi_Details")
							.setParameter("actionType", "checkInCrmTaskMaster").setParameter("actionValue", values)
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

		logger.info("Method : Rest checkInCrmTaskMaster  Dao ends");
		return response;
	}
	// View
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmApiTaskModel>> viewCrmTaskvisitHistory(String createdBy,String organization, String orgDivision) {
		logger.info("Method : viewCrmTaskvisitHistory Dao starts");
		
		List<RestCrmApiTaskModel> viewMaster = new ArrayList<RestCrmApiTaskModel>();
		JsonResponse<List<RestCrmApiTaskModel>> resp = new JsonResponse<List<RestCrmApiTaskModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_TaskApi_Details")
					.setParameter("actionType", "viewCrmTaskvisitHistory").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
				Object date = null;
				if (m[16] != null) {
					date  =DateFormatter.returnStringDate(m[16]);
				}
				RestCrmApiTaskModel restStudentModel = new RestCrmApiTaskModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],date,m[17],m[18],m[19],null,null);
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
		logger.info("Method : viewCrmTaskvisitHistory Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}
	// View check in history Report
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmApiTaskModel>> viewCrmTaskvisitHistoryReport(String userId,String organization, String orgDivision,
			String fromDate,String toDate) {
		logger.info("Method : viewCrmTaskvisitHistoryReport Dao starts");
		
		List<RestCrmApiTaskModel> viewMaster = new ArrayList<RestCrmApiTaskModel>();
		JsonResponse<List<RestCrmApiTaskModel>> resp = new JsonResponse<List<RestCrmApiTaskModel>>();
		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "',@p_user='" + userId + "';";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_TaskApi_Details")
					.setParameter("actionType", "viewCrmTaskvisitHistoryReport").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object date = null;
				if (m[16] != null) {
					date  =DateFormatter.returnStringDate(m[16]);
				}
				RestCrmApiTaskModel restStudentModel = new RestCrmApiTaskModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],date,m[17],m[18],m[19],null,null);
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
				resp.setMessage("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmTaskvisitHistoryReport Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}
	// View check in history Report search
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmApiTaskModel>> viewCrmTaskvisitHistoryReportSearch(String userId,String organization, String orgDivision,
			String fromDate,String toDate,String customer,String saleTeam) {
		logger.info("Method : viewCrmTaskvisitHistoryReportSearch Dao starts");
		
		List<RestCrmApiTaskModel> viewMaster = new ArrayList<RestCrmApiTaskModel>();
		JsonResponse<List<RestCrmApiTaskModel>> resp = new JsonResponse<List<RestCrmApiTaskModel>>();
		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "',"
					+ "@p_user='" + userId + "',@p_customer='" + customer + "',@p_saleTeam='" + saleTeam + "';";
			logger.info("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_TaskApi_Details")
					.setParameter("actionType", "viewCrmTaskvisitHistoryReportSearch").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				Object date = null;
				if (m[16] != null) {
					date  =DateFormatter.returnStringDate(m[16]);
				}
				RestCrmApiTaskModel restStudentModel = new RestCrmApiTaskModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],date,m[17],m[18],m[19],null,null);
				viewMaster.add(restStudentModel);
				
				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if(viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmTaskvisitHistoryReportSearch Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}
//delete task
	public ResponseEntity<JsonResponse<Object>> deleteCrmTaskMaster(String taskid,String organization, String orgDivision) {
		logger.info("Method : deleteCrmTaskMaster starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_taskid='" + taskid + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value===="+value);
			em.createNamedStoredProcedureQuery("crm_TaskApi_Details").setParameter("actionType", "deleteCrmTaskMaster")
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
		logger.info("Method : deleteCrmTaskMaster ends");
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmApiTaskModel>>>viewDealGraph(String salesTeam, String fdate, String tdate,String orgname,String orgdiv) {
		logger.info("Method : viewDealGraph starts");

		JsonResponse<List<RestCrmApiTaskModel>> resp = new JsonResponse<List<RestCrmApiTaskModel>>();
		List<RestCrmApiTaskModel> rs = new ArrayList<RestCrmApiTaskModel>();

		try {

			String value = "SET @p_saleteam='" + salesTeam + "', @p_fdate='"+DateFormatter.getStringDate(fdate)+"', @p_tdate='"+DateFormatter.getStringDate(tdate)+"', @p_orgname='"+orgname+"', @p_orgdiv='"+orgdiv+"';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_dealFinal_Details").setParameter("actionType", "dealgraph")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestCrmApiTaskModel reqemp = new RestCrmApiTaskModel(m[0], m[1].toString(),null, null,null, null, null,
						null, null, null, null, null, null, null, null, null,null,null,null,null,null,null);
				rs.add(reqemp);
			}
			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestCrmApiTaskModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmApiTaskModel>>>(resp,HttpStatus.CREATED);
		logger.info("Method : viewDealGraph ends");
		return response;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmApiTaskModel>>>viewHistory(String salesTeam, String fdate, String tdate,String orgname,String orgdiv) {
		logger.info("Method : viewHistory starts");

		JsonResponse<List<RestCrmApiTaskModel>> resp = new JsonResponse<List<RestCrmApiTaskModel>>();
		List<RestCrmApiTaskModel> rs = new ArrayList<RestCrmApiTaskModel>();

		try {

			String value = "SET @p_saleteam='" + salesTeam + "', @p_fdate='"+DateFormatter.getStringDate(fdate)+"', @p_tdate='"+DateFormatter.getStringDate(tdate)+"', @p_orgname='"+orgname+"', @p_orgdiv='"+orgdiv+"';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_Client_Routines").setParameter("actionType", "viewhistorybar")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestCrmApiTaskModel reqemp = new RestCrmApiTaskModel(m[0], m[1].toString(),null, null,null, null, null,
						null, null, null, null, null, null, null, null, null,null,null,null,null,null,null);
				rs.add(reqemp);
			}
			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestCrmApiTaskModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmApiTaskModel>>>(resp,HttpStatus.CREATED);
		logger.info("Method : viewHistory ends");
		return response;
	}
}
