package nirmalya.aatithya.restmodule.master.dao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
import nirmalya.aatithya.restmodule.common.utils.GenerateEntryPassParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.ManagePassRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ManageGatePassDao {

	Logger logger = LoggerFactory.getLogger(ManageGatePassDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	// Auto Search Employee

			@SuppressWarnings("unchecked")
			public JsonResponse<Object> employeeAutoSearch(String id, String org, String orgDiv) {
				logger.info("Method : autoSearch Dao starts");

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_searchValue='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
					
					List<Object[]> x = em.createNamedStoredProcedureQuery("masterEntryPass")
							.setParameter("actionType", "employeeAutoSearch").setParameter("actionValue", value)
							.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data Fetched successfully");
				} catch (Exception e) {
					e.printStackTrace();
					resp.setCode("failed");
					resp.setMessage("Data Fetched Failed");
				}
				logger.info("Method : autoSearch Dao ends");
				return resp;

			}

	// Add Gate Pass Details
	public ResponseEntity<JsonResponse<ManagePassRestModel>> restAddPass(ManagePassRestModel data) {
		logger.info("Method : restAddPass starts");

		Boolean validity = true;
		JsonResponse<ManagePassRestModel> resp = new JsonResponse<ManagePassRestModel>();

		resp.setMessage("");
		resp.setCode("");

		String values = GenerateEntryPassParameter.savePassDetails(data);
		
		System.out.println("values>>>>>>>>>>"+values);

			try {
				if (data.getPassId() != null && data.getPassId() != "") {
					em.createNamedStoredProcedureQuery("masterEntryPass").setParameter("actionType", "modifyGatePass")
							.setParameter("actionValue", values).execute();

					//Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.MODIFIED_SUCCESSFULLY);
					resp.setMessage("Employee Pass Modified Successfully");
					resp.setCode("Success");
				
				} else {

					em.createNamedStoredProcedureQuery("masterEntryPass").setParameter("actionType", "addEntryPass")
							.setParameter("actionValue", values).execute();
					
					resp.setMessage("Employee Pass Saved Successfully");
					resp.setCode("Success");
					
				}
				
//	Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
				

			} 
			catch (Exception e) {
			    try {
			        String[] err = serverDao.errorProcedureCall(e);
			        resp.setCode(err[0]);

			        // Log the error message and code for debugging
			        System.err.println("Error Code: " + err[0]);
			        System.err.println("Error Message: " + err[1]);

			        if (err[1].toString().equals("Cannot insert: Overlapping date and time range detected.")) {
			            Util.setJsonResponse(resp, null, ResponseStatus.failed, "This employee already has a pass within the same date and time.");
			        } else {
			            Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			        }

			    } catch (Exception e1) {
			        e1.printStackTrace();
			    }
			    e.printStackTrace();
			}

		ResponseEntity<JsonResponse<ManagePassRestModel>> response = new ResponseEntity<JsonResponse<ManagePassRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : restAddPass ends");
		return response;
	}

	// get all employee pass
	public JsonResponse<Object> getAllEntries(String organization, String orgDivision, String userId, String module,String type) {
		logger.info("Method : getAllEntries Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId+ "',@p_module='" + module+ "',@p_type='" + type+ "';";
			
			System.out.println("value Entry passs"+value);
			Object x = em.createNamedStoredProcedureQuery("masterEntryPass")
					.setParameter("actionType", "getAllEmployeePass").setParameter("actionValue", value)
					.getResultList();

			if (x != null) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, "success");
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllEntries Dao ends");

		return resp;
	}
	// get employee pass by ID
	public JsonResponse<Object> getEntryByID(String organization, String orgDivision, String userId, String id) {
		logger.info("Method : getEntryByID Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId
					+ "',@p_passId='" + id + "';";

			Object x = em.createNamedStoredProcedureQuery("masterEntryPass")
					.setParameter("actionType", "getEmployeePassByID").setParameter("actionValue", value)
					.getResultList();

			if (x != null) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, "success");
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getEntryByID Dao ends");

		return resp;
	}

	// Allow employee pass by ID
	public JsonResponse<Object> updatePass(String organization, String orgDivision, String userId, String id) {
		logger.info("Method : updatePass Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId
					+ "',@p_passId='" + id + "';";
			
			System.out.println("value???"+value);

			em.createNamedStoredProcedureQuery("masterEntryPass").setParameter("actionType", "updatePassStatus")
					.setParameter("actionValue", value).execute();

			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.UPDATED_SUCCESSFULLY);

		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : updatePass Dao ends");

		return resp;
	}
	// Allow employee at GATE
	public JsonResponse<Object> allowPass(String organization, String orgDivision, String userId, String id) {
		logger.info("Method : allowPass Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();

	        LocalDateTime currentDateTime = LocalDateTime.now();

	        DateTimeFormatter fullFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	        String formattedDateTime = currentDateTime.format(fullFormatter);

		try {
			
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId+ "',@p_allowedOn='" + formattedDateTime
					+ "',@p_passId='" + id + "';";
			
			  em.createNamedStoredProcedureQuery("masterEntryPass").setParameter(
			  "actionType", "allowGate") .setParameter("actionValue", value).execute();
			 
			Util.setJsonResponse(resp, null, ResponseStatus.success, "Allowed Successfully");
			
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			System.err.println(err[0]);
			System.err.println(err[1]);
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("Method : allowPass Dao ends");
		
		return resp;
	}

	// Delete employee pass by ID
	public JsonResponse<Object> deletePass(String organization, String orgDivision, String userId, String id) {
		logger.info("Method : deletePass Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId
					+ "',@p_passId='" + id + "';";
			
			System.out.println("value delete>>"+value);

			em.createNamedStoredProcedureQuery("masterEntryPass").setParameter("actionType", "deletePass")
					.setParameter("actionValue", value).execute();

			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);

		} 
			catch (Exception e) {
				e.printStackTrace();
				String[] err = serverDao.errorProcedureCall(e);
				System.err.println(err[0]);
				System.err.println(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);

		}

		logger.info("Method : deletePass Dao ends");

		return resp;
	}

}
