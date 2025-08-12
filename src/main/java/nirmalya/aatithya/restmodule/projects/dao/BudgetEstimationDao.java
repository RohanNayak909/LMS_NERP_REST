package nirmalya.aatithya.restmodule.projects.dao;

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

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateEstimateBudgetParam;
import nirmalya.aatithya.restmodule.common.utils.purchase.GeneratePurchaseOrderParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.model.BudgetEstimationRestModel;
import nirmalya.aatithya.restmodule.projects.model.BudgetEstimationRestSubModel;
import nirmalya.aatithya.restmodule.projects.model.RestExtraExpenseModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseQuotationModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;
import nirmalya.aatithya.restmodule.employee.dao.ReimbursementRestDao;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.projects.model.BudgetEstimationRestModel;

@Repository
public class BudgetEstimationDao {

	Logger logger = LoggerFactory.getLogger(BudgetEstimationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> budgetCategoryListDao() {
		logger.info("Method : getBudgetCategoryList starts");

		List<DropDownModel> getBudgetCategoryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("budget_estimation_routines")
					.setParameter("actionType", "getBudgetCategoryList").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getBudgetCategoryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getBudgetCategoryList ends");

		return getBudgetCategoryList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getProjectListDao() {
		logger.info("Method : getProjectListDao starts");

		List<DropDownModel> getProjectList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("budget_estimation_routines")
					.setParameter("actionType", "getProjectList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel1 = new DropDownModel(m[0], m[1]);
				getProjectList.add(dropDownModel1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getProjectListDao ends");

		return getProjectList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> budgetSubCategoryListDao(String id, String org,
			String orgDiv) {
		logger.info("Method : getProjectListDao starts");

		List<DropDownModel> subCatList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_category='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("budget_estimation_routines")
					.setParameter("actionType", "budgetSubCategoryList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				subCatList.add(dropDownModel);
			}
			resp.setBody(subCatList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : budgetSubCategoryList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> budgetVariantListDao(String id, String org,
			String orgDiv) {
		logger.info("Method : budgetVariantListDao starts");

		List<DropDownModel> variantList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_subcategory='" + id + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("budget_estimation_routines")
					.setParameter("actionType", "budgetVariantList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				variantList.add(dropDownModel);
			}
			resp.setBody(variantList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : budgetVariantListDao ends");
		return response;
	}

//
	public ResponseEntity<JsonResponse<Object>> estimateBudgetAddDao(BudgetEstimationRestModel employee) {

		logger.info("Method in Dao: estimateBudgetAddDao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		// resp.setMessage("");
		// resp.setCode("");
		try {
			// String values ="";
			String values = GenerateEstimateBudgetParam.getAddBudgetParam(employee);
			System.out.println(values);
			if (employee.getBudgetId() == "" || employee.getBudgetId() == null) {

				em.createNamedStoredProcedureQuery("budget_estimation_routines").setParameter("actionType", "addbudget")
						.setParameter("actionValue", values).execute();
			} else {
				System.out.println("else" + values);
				em.createNamedStoredProcedureQuery("budget_estimation_routines")
						.setParameter("actionType", "modifybudget").setParameter("actionValue", values).execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		if (resp.getMessage() == null) {
			resp.setMessage("Saved successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method in Dao: estimateBudgetAddDao ends");

		return response;
	}

	// view budget

	@SuppressWarnings("unchecked")

	public JsonResponse<Object> estimateBudgetViewDao(String userid, String org, String div, String id) {

		logger.info("Method : estimateBudgetView Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "' ,@p_pid='" + id
					+ "' ;";
			logger.info("values****************************" + value);
			List<Object> x = em.createNamedStoredProcedureQuery("budget_estimation_routines")
					.setParameter("actionType", "viewBudget").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : estimateBudgetView Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	// edit estimateBudget
	@SuppressWarnings("unchecked")

	public JsonResponse<Object> estimateBudgetEditDao(String userid, String org, String div, String id, String id2) {

		logger.info("Method : estimateBudgetView Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "' ,@p_id='" + id
					+ "' ,@p_id2='" + id2 + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("budget_estimation_routines")
					.setParameter("actionType", "editbudget").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : estimateBudgetView Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	// delete estimateBudget

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> estimateBudgetDeleteDao(String id) {
		logger.info("Method : estimateBudgetDeleteDao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {

				String value = "SET @p_budgetId='" + id + "';";

				em.createNamedStoredProcedureQuery("budget_estimation_routines")
						.setParameter("actionType", "deleteBudget").setParameter("actionValue", value).execute();

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

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method :  estimateBudgetDeleteDao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<List<BudgetEstimationRestModel>>> estimateBudgetViewDataDao(String id) {
		logger.info("Method : estimateBudgetViewDataDao starts");
		List<BudgetEstimationRestModel> respList = new ArrayList<BudgetEstimationRestModel>();

		try {
			String value = "SET @p_projectId='" + id + "';";

			@SuppressWarnings("unchecked")
			List<Object[]> x = em.createNamedStoredProcedureQuery("budget_estimation_routines")
					.setParameter("actionType", "ViewBudgetData").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				BudgetEstimationRestModel cusData = new BudgetEstimationRestModel(m[0], m[1], m[2], m[3]);
				respList.add(cusData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<BudgetEstimationRestModel>> resp = new JsonResponse<List<BudgetEstimationRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<BudgetEstimationRestModel>>> response = new ResponseEntity<JsonResponse<List<BudgetEstimationRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : estimateBudgetViewDataDao ends");
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<BudgetEstimationRestModel>>> addBudgetDataDao(
			List<BudgetEstimationRestModel> model) {
		logger.info("Method : addBudgetDataDao starts");

		JsonResponse<List<BudgetEstimationRestModel>> resp = new JsonResponse<List<BudgetEstimationRestModel>>();
		List<BudgetEstimationRestModel> listData = new ArrayList<BudgetEstimationRestModel>();

		try {
			String values = GenerateEstimateBudgetParam.getAddQuotParam(model);
			if (model.get(0).getBudgetId() == "" || model.get(0).getBudgetId() == null) {

				em.createNamedStoredProcedureQuery("budget_estimation_routines")
						.setParameter("actionType", "addBudgetData").setParameter("actionValue", values).execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<BudgetEstimationRestModel>>> response = new ResponseEntity<JsonResponse<List<BudgetEstimationRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addBudgetDataDao ends");
		return response;
	}

//
	//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addExpenses(RestExtraExpenseModel restExtraExpenseModel) {

		logger.info("Method : addExpenses starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateEstimateBudgetParam.getExtraExpensesAdd(restExtraExpenseModel);
			if (restExtraExpenseModel.getExpenseId() == null || restExtraExpenseModel.getExpenseId() == "") {
				em.createNamedStoredProcedureQuery("budget_estimation_routines")
						.setParameter("actionType", "addExpenses").setParameter("actionValue", values).execute();

			}

			else {

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

		logger.info("Method : addExpenses ends" + resp);
		return resp;
	}

	// get extra expense

	@SuppressWarnings("unchecked")

	public JsonResponse<Object> getExpenseForProject(String id) {

		logger.info("Method : getExpenseForProject Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_item='" + id + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("budget_estimation_routines")
					.setParameter("actionType", "getextraExpense").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getExpenseForProject Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	//
	// project sate list on edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getExpenseList(String id) {

		logger.info("Method : getExpenseList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_item='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("budget_estimation_routines")
					.setParameter("actionType", "getExpenseListEdit").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getExpenseList ends" + response);
		return response;
	}

	//
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> budgetExtraExp(String id) {
		logger.info("Method : budgetExtraExp starts");
		List<DropDownModel> subCatList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_item='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("budget_estimation_routines")
					.setParameter("actionType", "getExpenseListDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				subCatList.add(dropDownModel);
			}
			resp.setBody(subCatList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : budgetExtraExp ends" + response);
		return response;
	}
}
