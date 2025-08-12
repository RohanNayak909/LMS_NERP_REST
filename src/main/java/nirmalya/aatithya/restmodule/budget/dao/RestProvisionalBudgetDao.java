package nirmalya.aatithya.restmodule.budget.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.budget.model.RestAssignDeptBudgetModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestProvisionalBudgetDao {
	
	Logger logger = LoggerFactory.getLogger(RestProvisionalBudgetDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	//allDeptIncomExpenseData

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> allProvDeptIncomExpenseData(String fyId,String orgName,String orgDivision) {
			logger.info("Method : allDeptIncomExpenseData starts");
			List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

			//String value = "SET @p_fyId='" + fyId + "';";
			// System.out.println("===>>>"+value);
			String value = "SET @p_fyId='" + fyId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";
			
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("assign_provisional_budget")
						.setParameter("actionType", "provIncmExpData").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {

					RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0].toString(), m[1].toString(),
							m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(), m[6].toString(),
							m[7].toString(), m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString());
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);

			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : allDeptIncomExpenseData ends");
			return response;

		}
		
		//provisionalFyCurrInflationDataByFy

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> provisionalFyCurrInflationDataByFy(
				String fyId) {
			logger.info("Method : provisionalFyCurrInflationDataByFy starts");
			List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

			String value = "SET @p_fyId='" + fyId + "';";

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("assign_provisional_budget")
						.setParameter("actionType", "prvFyInfltnCrnByFy").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {

					RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1], m[2], m[3], m[4],
							m[5]);
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);

			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : provisionalFyCurrInflationDataByFy ends");
			return response;

		}
		
		//viewProvisionalIncomeDtlsForAllDept

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> viewProvisionalIncomeDtlsForAllDept(String fyId, String orgName, String orgDivision) {
			logger.info("Method : viewProvisionalIncomeDtlsForAllDept starts");
			List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

			//String value = "SET @p_fyId='" + fyId + "';";
			String value = "SET @p_fyId='" + fyId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";
			
			try {
				System.out.println("dept dao--------------------------------------" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("assign_provisional_budget")
						.setParameter("actionType", "getProvIncmAllDept").setParameter("actionValue", value)
						.getResultList();

				for (Object[] m : x) {
					
					if (m[8] == null || m[8] == "") {
						m[8] = "";
					}
					
					if (m[10] == null || m[10] == "") {
						m[10] = "";
					}

					RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1], m[2].toString(),
							m[3].toString(), m[4].toString(),m[5],m[6],m[7],m[8].toString(),m[9],m[10].toString());
							respList.add(restPayroll);

				}

				System.out.println("VIEW" + respList);

			} catch (Exception e) {

				e.printStackTrace();

			}

			JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			logger.info("Method : viewProvisionalIncomeDtlsForAllDept ends");

			System.out.println("VIEWWWWWWWW" + respList);
			return response;

		}
		
		//viewExpenseDtlsForAllDept

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> viewProvisionalExpenseDtlsForAllDept(String fyId,String orgName,String orgDivision) {
			logger.info("Method : viewProvisionalExpenseDtlsForAllDept starts");
			List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

			//String value = "SET @p_fyId='" + fyId + "';";
			String value = "SET @p_fyId='" + fyId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";
			
			try {
				System.out.println("dept dao--------------------------------------" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("assign_provisional_budget")
						.setParameter("actionType", "getProvExpnsAllDept").setParameter("actionValue", value)
						.getResultList();

				for (Object[] m : x) {
					
					if (m[8] == null || m[8] == "") {
						m[8] = "";
					}
					
					if (m[10] == null || m[10] == "") {
						m[10] = "";
					}

					RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1], m[2].toString(),
							m[3].toString(), m[4].toString(),m[5],m[6],m[7],m[8].toString(),m[9],m[10].toString());
							respList.add(restPayroll);

				}

				System.out.println("VIEW" + respList);

			} catch (Exception e) {

				e.printStackTrace();

			}

			JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			logger.info("Method : viewProvisionalExpenseDtlsForAllDept ends");

			System.out.println("VIEWWWWWWWW" + respList);
			return response;

		}
		
		//prvFyCurrInflationData

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> prvFyCurrInflationData(String fyId,String orgName,String orgDivision) {
			logger.info("Method : prvFyCurrInflationData starts");
			List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();
			String value = "SET @p_fyId='" + fyId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";
			
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("assign_provisional_budget")
						.setParameter("actionType", "prvInfltnCrncy").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {

					RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1], m[2], m[3], m[4],
							m[5]);
					respList.add(restPayroll);
				}
				System.out.println("VIEW" + respList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);

			if (resp.getMessage() == null) {
				resp.setMessage("View successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("Success");
			}
			logger.info("Method : prvFyCurrInflationData ends");
			return response;

		}

}
