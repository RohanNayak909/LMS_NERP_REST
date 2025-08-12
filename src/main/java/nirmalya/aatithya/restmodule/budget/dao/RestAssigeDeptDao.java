
package nirmalya.aatithya.restmodule.budget.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.http.HttpStatus;
import nirmalya.aatithya.restmodule.budget.model.RestAssignDeptBudgetModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.budget.GenerateManageAssignDeptIncomeExpense;


@Repository
public class RestAssigeDeptDao {

	Logger logger = LoggerFactory.getLogger(RestAssigeDeptDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	// getDepartmentList

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList() {

		logger.info("Method :getDepartmentList starts");

		List<DropDownModel> deptList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "getDepartment").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				deptList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentList ends" + deptList);

		return deptList;
	}

	// getFiscalYear

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFiscalYear() {

		logger.info("Method :getFiscalYear starts");

		List<DropDownModel> deptList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "getFiscalYear").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				deptList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getFiscalYear ends" + deptList);

		return deptList;
	}
	// getCurrencyList

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCurrencyList() {

		logger.info("Method :getCurrencyList starts");

		List<DropDownModel> deptList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "getCurrency").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				deptList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCurrencyList ends" + deptList);

		return deptList;
	}

	// restViewAssignDept

////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> restAssignIncomeDept(String dept, String orgName, String orgDivision) {
		logger.info("Method : restAssignIncomeDept starts");
		List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();
		
		//String value = "SET @p_deptId='" + dept + "';";
		String value = "SET @p_deptId='" + dept + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

		
		
		System.out.println("-------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "getIncomeAssign").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				if (m[2] == null || m[2] == "") {
					m[2] = "";
				}
				
				if (m[3] == null || m[3] == "") {
					m[3] = "";
				}
				
				if (m[4] == null || m[4] == "") {
					m[4] = "";
				}

				RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7]);
				respList.add(restPayroll);

			}

			///System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : restAssignExpenseDept ends");

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

//restAssignedIncomeDept

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> restAssignedIncomeDept(String dept, String fyId,String orgName, String orgDivision) {
		logger.info("Method :----------------------------------------- restAssignedIncomeDept starts");
		List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

		//String value = "SET @p_deptId='" + dept + "';";
		String value1 = "SET @p_deptId='" + dept + "',@p_fyId='" + fyId + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

		System.out.println("dept dao value--------------------------------------" + value1);
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "getIncomeAssigned").setParameter("actionValue", value1).getResultList();

			for (Object[] m : x) {
				
				if (m[2] == null || m[2] == "") {
					m[2] = "";
				}
				
				if (m[3] == null || m[3] == "") {
					m[3] = "";
				}
				
				if (m[7] == null || m[7] == "") {
					m[7] = "";
				}
				
				if (m[8] == null || m[8] == "") {
					m[8] = "";
				}
				
				if (m[9] == null || m[9] == "") {
					m[9] = "No";
				}
				
			
				RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9].toString());
				respList.add(restPayroll);

			}

		//	System.out.println("VIEW response for assigned data--------------------------------------------------" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : restAssignedIncomeDept ends");

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

//restAssignedExpenseDept

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> restAssignedExpenseDept(String dept,String fyId,String orgName,String orgDivision) {
		logger.info("Method : restAssignedExpenseDept starts");
		List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();
	//	String value = "SET @p_deptId='" + dept + "',@p_fyId='" + fyId + "';";
		String value = "SET @p_deptId='" + dept + "',@p_fyId='" + fyId + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

		System.out.println("dept dao value--------------------------------------" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "getExpenseAssigned").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				
				if (m[2] == null || m[2] == "") {
					m[2] = "";
				}
				
				if (m[3] == null || m[3] == "") {
					m[3] = "";
				}
				
				if (m[7] == null || m[7] == "") {
					m[7] = "";
				}
				
				if (m[8] == null || m[8] == "") {
					m[8] = "";
				}
				
				if (m[9] == null || m[9] == "") {
					m[9] = "No";
				}

				RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9].toString());
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
		//System.out.println("response" + response);
		logger.info("Method : restAssignedExpenseDept ends");

		//System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

	// getExpensesAssign

	// restAssignExpenseDept

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> restAssignExpenseDept(String dept,String orgName,String orgDivision) {
		logger.info("Method : restAssignExpenseDept starts");
		List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();
		
		//String value = "SET @p_deptId='" + dept + "';";
		String value = "SET @p_deptId='" + dept + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		System.out.println("dept dao value--------------------------------------" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "getExpensesAssign").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				
				if (m[2] == null || m[2] == "") {
					m[2] = "";
				}
				
				if (m[3] == null || m[3] == "") {
					m[3] = "";
				}
				
				if (m[4] == null || m[4] == "") {
					m[4] = "";
				}

				RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7]);
				respList.add(restPayroll);

			}

			//System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
				resp, HttpStatus.CREATED);
		//System.out.println("response" + response);
		logger.info("Method : restAssignExpenseDept ends");

		//System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

	// departmentData

	/*@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> departmentData() {
		logger.info("Method : departmentDataById starts");
		List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "deptData").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1]);
				respList.add(restPayroll);
			}
		//	System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
				resp, HttpStatus.CREATED);
		//System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : departmentData ends");
		return response;

	}*/
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> departmentData(String orgName, String orgDivision) {
		logger.info("Method : departmentDataById Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {		
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

			
			System.out.println("values****************************");
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "deptData").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setMessage("Data fetched successfully");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : departmentDataById Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// departmentDataById
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> departmentDataById(String dept,String orgName, String orgDivision) {
		logger.info("Method : departmentDataById starts");
		List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

		//String value = "SET @p_deptId='" + dept + "';";
		String value = "SET @p_deptId='" + dept + "', @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		// System.out.println("===>>>"+value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "deptDataById").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1]);
				respList.add(restPayroll);
			}
			//System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
				resp, HttpStatus.CREATED);
		//System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : departmentDataById ends");
		return response;

	}

	// assignIncomeDept

	public ResponseEntity<JsonResponse<Object>> assignIncomeDept(RestAssignDeptBudgetModel restAssignDeptBudgetModel) {

		logger.info("Method in Dao: assignIncomeDept starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateManageAssignDeptIncomeExpense.assignIncomeDeptParam(restAssignDeptBudgetModel);

			//System.out.println("value===========================" + values);
			em.createNamedStoredProcedureQuery("assign_dept_budget").setParameter("actionType", "asgnDeptIncome")
					.setParameter("actionValue", values).execute();
			resp.setCode("success");
			resp.setMessage("Data saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				resp.setCode("failed");
				resp.setMessage("Something is wrong");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: assignIncomeDept ends");

		return response;
	}

	// assignExpenseDept

	public ResponseEntity<JsonResponse<Object>> assignExpenseDept(RestAssignDeptBudgetModel restAssignDeptBudgetModel) {

		logger.info("Method in Dao: assignExpenseDept starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateManageAssignDeptIncomeExpense.assignIncomeDeptParam(restAssignDeptBudgetModel);

		//	System.out.println("value===========================" + values);
			em.createNamedStoredProcedureQuery("assign_dept_budget").setParameter("actionType", "asgnDeptExpense")
					.setParameter("actionValue", values).execute();
			resp.setCode("success");
			resp.setMessage("Data saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				resp.setCode("failed");
				resp.setMessage("Something is wrong");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: assignExpenseDept ends");

		return response;

	}

	// viewIncomeDtlsbyId

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> viewIncomeDtlsbyId(String dept, String fyId,String orgName, String orgDivision) {
		logger.info("Method : viewIncomeDtlsbyId starts");
		List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

		String value = "SET @p_deptId='" + dept + "',@p_fyId='" + fyId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";	
		System.out.println("viewIncomeDtlsbyId dao--------------------------------------" + value);
		try {
			//System.out.println("dept dao--------------------------------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "getIncmAsgnDtls").setParameter("actionValue", value).getResultList();

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

			//System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
				resp, HttpStatus.CREATED);
	//	System.out.println("response" + response);
		logger.info("Method : viewIncomeDtlsbyId ends");

	//	System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

//viewExpnsDtlsbyId

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> viewExpnsDtlsbyId(String dept,String fyId,String orgName, String orgDivision) {
		logger.info("Method : viewExpnsDtlsbyId starts");
		List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

		//String value = "SET @p_deptId='" + dept + "';";
		String value = "SET @p_deptId='" + dept + "',@p_fyId='" + fyId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";
		try {
			//System.out.println("dept dao--------------------------------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "getExpnsAsgnDtls").setParameter("actionValue", value).getResultList();

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

			//System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
				resp, HttpStatus.CREATED);
		//System.out.println("response" + response);
		logger.info("Method : viewExpnsDtlsbyId ends");

		//System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

//deptByAllDataIncomExpense
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> deptByAllDataIncomExpense(String dept,String fyId,String orgName, String orgDivision) {
		logger.info("Method : deptByAllDataIncomExpense starts");
		List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

	//	String value = "SET @p_deptId='" + dept + "';";
		String value = "SET @p_deptId='" + dept + "',@p_fyId='" + fyId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";
		
		// System.out.println("===>>>"+value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "deptByAllIncmExpData").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0].toString(), m[1].toString(),
						m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(), m[6].toString(),
						m[7].toString(), m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString());
				respList.add(restPayroll);
			}
			//System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
				resp, HttpStatus.CREATED);
		//System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : deptByAllDataIncomExpense ends");
		return response;

	}

//aggregationFyCurrInflationData

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> aggregationFyCurrInflationData(String orgName,String orgDivision) {
		logger.info("Method : aggregationFyCurrInflationData starts");
		List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

		String value = "SET @p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";
		
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "agrFyInfltnCrncy").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1], m[2], m[3], m[4],
						m[5]);
				respList.add(restPayroll);
			}
			//System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
				resp, HttpStatus.CREATED);
		//System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : aggregationFyCurrInflationData ends");
		return response;

	}

//viewIncomeDtlsForAllDept

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> viewIncomeDtlsForAllDept(String fyId,String orgName,String orgDivision) {
		logger.info("Method : viewIncomeDtlsForAllDept starts");
		List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

		//String value = "SET @p_fyId='" + fyId + "';";
		String value = "SET @p_fyId='" + fyId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";
		try {
			System.out.println("dept dao--------------------------------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "getIncmDtlsAllDept").setParameter("actionValue", value)
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

			//System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
				resp, HttpStatus.CREATED);
		//System.out.println("response" + response);
		logger.info("Method : viewIncomeDtlsForAllDept ends");

		//System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

//viewExpenseDtlsForAllDept

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> viewExpenseDtlsForAllDept(String fyId,String orgName,String orgDivision) {
		logger.info("Method : viewExpenseDtlsForAllDept starts");
		List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

		//String value = "SET @p_fyId='" + fyId + "';";
		String value = "SET @p_fyId='" + fyId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";
		
		
		try {
			System.out.println("dept dao--------------------------------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "getExpnsDtlsAllDept").setParameter("actionValue", value)
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

			//System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
				resp, HttpStatus.CREATED);
		//System.out.println("response" + response);
		logger.info("Method : viewExpenseDtlsForAllDept ends");

		//System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

//allDeptIncomExpenseData

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> allDeptIncomExpenseData(String fyId,String orgName,String orgDivision) {
		logger.info("Method : allDeptIncomExpenseData starts");
		List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

		//String value = "SET @p_fyId='" + fyId + "';";
		String value = "SET @p_fyId='" + fyId + "', @p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "';";
		// System.out.println("===>>>"+value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "deptAllIncmExpData").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0].toString(), m[1].toString(),
						m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(), m[6].toString(),
						m[7].toString(), m[8].toString(), m[9].toString(), m[10].toString(), m[11].toString());
				respList.add(restPayroll);
			}
			//System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
				resp, HttpStatus.CREATED);
		//System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : allDeptIncomExpenseData ends");
		return response;

	}

//aggregationFyCurrInflationDataByFy

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> aggregationFyCurrInflationDataByFy(
			String fyId) {
		logger.info("Method : aggregationFyCurrInflationDataByFy starts");
		List<RestAssignDeptBudgetModel> respList = new ArrayList<RestAssignDeptBudgetModel>();

		String value = "SET @p_fyId='" + fyId + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "agrFyInfltnCrnByFy").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestAssignDeptBudgetModel restPayroll = new RestAssignDeptBudgetModel(m[0], m[1], m[2], m[3], m[4],
						m[5]);
				respList.add(restPayroll);
			}
			//System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssignDeptBudgetModel>>>(
				resp, HttpStatus.CREATED);
		//System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : aggregationFyCurrInflationDataByFy ends");
		return response;

	}

//------------------------------------Assign Duplicate Check By Pankaj----------------------------------------------------------------
/*
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestAssignDeptBudgetModel>> assignDuplicateChecks(String id) {
		logger.info("Method : assignDuplicateChecks starts");

		JsonResponse<List<RestAssignDeptBudgetModel>> resp = new JsonResponse<List<RestAssignDeptBudgetModel>>();
		List<RestAssignDeptBudgetModel> doc = new ArrayList<RestAssignDeptBudgetModel>();

		String value = "SET @p_id='" + id + "';";

		System.out.println("GroupId+++++++========" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
					.setParameter("actionType", "assignCheck").setParameter("actionValue", value).getResultList();

			
			 for (Object[] m : x) {
			 
			 RestAssignDeptBudgetModel viewdoc = new RestAssignDeptBudgetModel(m[0].toString());
			  
			 doc.add(viewdoc); }
			 
			


		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(doc);
		logger.info("Method : assignDuplicateChecks ends");
		System.out.println("response data is" + resp);
		return resp;

	}*/
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assignDuplicateIncomeCheck(String id,String deptId,String financialYear) {
	    logger.info("Method : assignDuplicateIncomeCheck starts");

	    JsonResponse<Object> resp = new JsonResponse<Object>();
	    List<RestAssignDeptBudgetModel> doc = new ArrayList<RestAssignDeptBudgetModel>();

	    String value = "SET @p_id='" + id + "',@p_deptId='" + deptId + "',@p_financialYear='" + financialYear + "';";

	    //System.out.println("useriddd========" + value);
	    try {

	        List<Object> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
	                .setParameter("actionType", "assignIncomeCheck")
	                .setParameter("actionValue", value)
	                .getResultList();
	        
	        //System.out.println(x.get(0).toString());
	      //  resp.setTotalCount(x.get(0).toString());
			/*
			 * for (Object[] m : x) { System.out.println(m.toString());
			 * RestAssignDeptBudgetModel viewdoc = new RestAssignDeptBudgetModel(m[0]);
			 * doc.add(viewdoc); }
			 */
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    
	    logger.info("Method : assignDuplicateIncomeCheck ends");
	   // System.out.println("response data is" + resp);
	    return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> assignDuplicateExpensesCheck(String id,String deptId,String financialYear) {
	    logger.info("Method : assignDuplicateExpensesCheck starts");

	    JsonResponse<Object> resp = new JsonResponse<Object>();
	    List<RestAssignDeptBudgetModel> doc = new ArrayList<RestAssignDeptBudgetModel>();

	    String value = "SET @p_id='" + id + "',@p_deptId='" + deptId + "',@p_financialYear='" + financialYear + "';";

	    //System.out.println("useriddd========" + value);
	    try {

	        List<Object> x = em.createNamedStoredProcedureQuery("assign_dept_budget")
	                .setParameter("actionType", "assignExpenseCheck")
	                .setParameter("actionValue", value)
	                .getResultList();
	        
	        System.out.println(x.get(0).toString());
	      //  resp.setTotalCount(x.get(0).toString());
			
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    
	    logger.info("Method : assignDuplicateExpensesCheck ends");
	    //System.out.println("response data is" + resp);
	    return resp;
	}


}
