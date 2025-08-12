package nirmalya.aatithya.restmodule.qa.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateIncidentMasterParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.RestIncidentRegisterModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestIncidentRegisterDao {
	
	Logger logger = LoggerFactory.getLogger(RestIncidentRegisterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;


	
	public ResponseEntity<JsonResponse<List<RestIncidentRegisterModel>>> addIncident(List<RestIncidentRegisterModel> restIncidentRegisterModel) {
		logger.info("Method : addIncident dao starts");
		System.out.println(restIncidentRegisterModel);
		JsonResponse<List<RestIncidentRegisterModel>> resp = new JsonResponse<List<RestIncidentRegisterModel>>();

		String value = GenerateIncidentMasterParam.getAddIncident(restIncidentRegisterModel);
		System.out.println("value===" + value);
		try {

			if (restIncidentRegisterModel.get(0).getIncidentId() != null && restIncidentRegisterModel.get(0).getIncidentId() != "") {

				em.createNamedStoredProcedureQuery("qa_incident_routines")
						.setParameter("actionType", "modifyIncident").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_incident_routines")
						.setParameter("actionType", "addIncident").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data saved successfully");

			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestIncidentRegisterModel>>> response = new ResponseEntity<JsonResponse<List<RestIncidentRegisterModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addIncident dao ends");
		return response;

	}
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewIncident(String orgName,String orgDiv) {
		logger.info("Method : viewIncident starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_incident_routines")
					.setParameter("actionType", "viewIncident").setParameter("actionValue", values).getResultList();
			
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {

			e.printStackTrace();

		}

		System.out.println("resp>>view>>>---"+resp);
		logger.info("Method : viewIncident ends");
		return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editIncident(String incidentId, String orgName, String orgDivision) {
		logger.info("Method : editIncident Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_incidentId='" + incidentId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_incident_routines")
					.setParameter("actionType", "editIncident").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editIncident Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}

	
	 public ResponseEntity<JsonResponse<Object>> deleteIncident(String id, String orgName, String orgDivision) {
			logger.info("Method : deleteIncident starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_incidentId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					//System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("qa_incident_routines")
							.setParameter("actionType", "deleteIncident").setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Data deleted successfully");
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

			logger.info("Method : deleteIncident ends");
			System.out.println("DELETEE" + response);
			return response;
		}

	 public ResponseEntity<JsonResponse<Object>> approveIncident(String id, String orgName, String orgDivision, String userId) {
			logger.info("Method : approveIncident starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_incidentId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision +"', @p_approveBy='" + userId + "';";
					System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("qa_incident_routines")
							.setParameter("actionType", "approveIncident").setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Approved successfully");
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

			logger.info("Method : approveIncident ends");
			return response;
		}
	 
	 
	 //incedientRegisterPdf
	 @SuppressWarnings("unchecked")
		public JsonResponse<Object> incedientRegisterPdf(String id, String orgName, String orgDivision) {
			logger.info("Method : incedientRegisterPdf Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_incRegId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_incident_routines")
						.setParameter("actionType", "incRegPdf").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("Success");
				resp.setMessage("Pdf generated successfully");
				
			} catch (Exception e) {
				resp.setCode("Unsuccess");
				resp.setMessage("Something went wrong while generating pdf");
				e.printStackTrace();
			}
			logger.info("Method : incedientRegisterPdf Dao ends");
			return resp;
		}
			
}
