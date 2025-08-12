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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateEmpShiftdetails;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.RestEmployeeShiftSchedulingModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestEmployeeShiftSchedulingDao {

	Logger logger = LoggerFactory.getLogger(RestEmployeeShiftSchedulingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager entityManager;

	// Shift List.

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getShiftLists(String org, String orgDiv, String userId) {
		logger.info("Method : getShiftLists starts");
		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
					.setParameter("actionType", "getShiftLists").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getShiftLists ends");
		return getCollectionList;
	}

	// View Current Shift Data
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewShift(String orgName, String orgDivision) {
		logger.info("Method : viewShift Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
					.setParameter("actionType", "viewShift").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewShift Dao ends");
		return resp;

	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewShiftSchedulingData(String orgName, String orgDivision, String sec) {
		logger.info("Method : viewShiftSchedulingData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_shift='" + sec + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
					.setParameter("actionType", "viewShiftData").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewShiftSchedulingData Dao ends");
		return resp;

	}

	// View All Shift

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewShiftDiffGroupsData(String orgName, String orgDivision, String sec, String fromDate, String toDate) {
		logger.info("Method : viewShiftDiffGroupsData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_shift='" + sec 
					+  "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) 
					+  "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "';";
			System.err.println("value=="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
					.setParameter("actionType", "viewShiftDiffGroupsData").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewShiftDiffGroupsData Dao ends");
		return resp;

	}

	// Revised Shift.

	public ResponseEntity<JsonResponse<Object>> addRevisedShift(
			List<RestEmployeeShiftSchedulingModel> restEmployeeShiftSchedulingModel) {
		logger.info("Method : Rest addRevisedShift  Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {

				String values = GenerateEmpShiftdetails.getAddRevisedShiftParam(restEmployeeShiftSchedulingModel);
				System.err.println("values===="+values);
				em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
						.setParameter("actionType", "addRevisedShift").setParameter("actionValue", values).execute();
				
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);

			} catch (Exception e) {
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
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

		logger.info("Method : addRevisedShift  Dao ends");

		return response;
	}
	
	
	/*
	 * approve shift
	 * 
	 */
	
	public JsonResponse<Object> approveShift(String slNo, String flag, String orgName, String orgDivision, String userId) {
		logger.info("Method : approveShift Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		if("APPROVE".equals(flag)) {
			
			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId + "',@p_slNo='" + slNo + "';";
				System.out.println("value>>"+value);
				em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
						.setParameter("actionType", "approveShifts").setParameter("actionValue", value).execute();
				
				resp.setCode("success");
				resp.setMessage("Data Approved Successfully");
			} catch (Exception e) {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setMessage(err[1]);
				resp.setCode("failed");
				e.printStackTrace();
			}
		}else {
			System.out.println("Inside Delete");
			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId + "',@p_slNo='" + slNo + "';";
				em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
						.setParameter("actionType", "deleteShifts").setParameter("actionValue", value).execute();
				
				resp.setCode("success");
				resp.setMessage("Data Deleted Successfully");
			} catch (Exception e) {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setMessage(err[1]);
				resp.setCode("failed");
				e.printStackTrace();
			}
		}
		
		logger.info("Method : approveShift Dao ends");
		return resp;

	}
	
	// View All Employee

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewAllEmp(String orgName, String orgDivision) {
			logger.info("Method : viewAllEmp Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
						.setParameter("actionType", "viewAllEmployee").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : viewAllEmp Dao ends");
			return resp;

		}
		
		// View All Employee

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewEmployeeDropDown(String orgName, String orgDivision) {
			logger.info("Method : viewEmployeeDropDown Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
					.setParameter("actionType", "viewEmployeeDropDown").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("Method : viewEmployeeDropDown Dao ends");
			return resp;
		}
// View Current viewAllShiftData Data

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewAllShiftData(String orgName, String orgDivision, String sec) {
			logger.info("Method : viewShiftSchedulingData Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_org=\""+ orgName + "\", @p_orgDiv=\"" + orgDivision + "\", @p_shift=\"" + sec + "\";";
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
					.setParameter("actionType", "viewAllShiftData").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("Method : viewAllShiftData Dao ends");
			return resp;
		}

		// view Shift List Gatepass
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewShiftListGatepass(String orgName, String orgDivision, String sec) {
			logger.info("Method : viewShiftListGatepass Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_org=\""+ orgName + "\", @p_orgDiv=\"" + orgDivision + "\", @p_shift=\"" + sec + "\";";
				System.err.println("valuess for gatepass view==="+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
					.setParameter("actionType", "viewShiftListGatepass").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("Method : viewShiftListGatepass Dao ends");
			return resp;
		}

		public JsonResponse<Object> approveWrongShift(String slNo, String fromDate, String toDate, String orgName,
				String orgDivision, String userId) {
			logger.info("Method : approveWrongShift Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();
				try {
					String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_userId='" + userId 
							+ "',@p_slNo='" + slNo + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate)  + "';";
					
					
					System.err.println("value>>"+value);
					em.createNamedStoredProcedureQuery("hrmsemployeeShiftScheduling")
							.setParameter("actionType", "approveWrongShift").setParameter("actionValue", value).execute();
					
					resp.setCode("success");
					resp.setMessage("Data Approved Successfully");
				} catch (Exception e) {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setMessage(err[1]);
					resp.setCode("failed");
					e.printStackTrace();
				}
			
			logger.info("Method : approveWrongShift Dao ends");
			logger.info("resp APPROVE===="+resp);
			return resp;
		}
}