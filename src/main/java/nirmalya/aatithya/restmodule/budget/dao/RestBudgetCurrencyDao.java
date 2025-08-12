package nirmalya.aatithya.restmodule.budget.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.model.RestManageCurrencyModel;
import nirmalya.aatithya.restmodule.budget.model.RestBudgetCurrencyModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
//import nirmalya.aatithya.restmodule.common.utils.GenerateMangeCurrencyParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.budget.GenerateBudgetCurrencyParam;

@RestController
@RequestMapping(value = { "/budget" })
public class RestBudgetCurrencyDao {

	Logger logger = LoggerFactory.getLogger(RestBudgetCurrencyDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	// Add
	public ResponseEntity<JsonResponse<Object>> addManageCurrency(RestBudgetCurrencyModel manageCurrencyt) {

		logger.info("Method in Dao: addincentivedao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateBudgetCurrencyParam.addbudgetcurrencyParam(manageCurrencyt);
			System.out.println(values);
			if (manageCurrencyt.getCurrencyid() == "" || manageCurrencyt.getCurrencyid() == null) {

				em.createNamedStoredProcedureQuery("budget_manageCurrency").setParameter("actionType", "addCurrency")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("budget_manageCurrency").setParameter("actionType", "modifyCurrency")
						.setParameter("actionValue", values).execute();
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

		logger.info("Method in Dao: addclubmemberdao ends" + response);

		return response;
	}

	// viewQc
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewBudgetCurrency(String orgName,String orgDivision) {
		logger.info("Method : viewBudgetCurrency Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

			 System.out.println("values viewCurrency****************************" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("budget_manageCurrency")
					.setParameter("actionType", "viewCurrency").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewBudgetCurrency Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// Edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestBudgetCurrencyModel>>> editCurrency(String id) {
		logger.info("Method : editmanageLeadgerInfo starts");

		JsonResponse<List<RestBudgetCurrencyModel>> resp = new JsonResponse<List<RestBudgetCurrencyModel>>();
		List<RestBudgetCurrencyModel> rs = new ArrayList<RestBudgetCurrencyModel>();

		try {

			String value = "SET @p_currencyId='" + id + "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("budget_manageCurrency")
					.setParameter("actionType", "editCurrency").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestBudgetCurrencyModel restPayroll = new RestBudgetCurrencyModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8]);

				rs.add(restPayroll);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestBudgetCurrencyModel>>> response = new ResponseEntity<JsonResponse<List<RestBudgetCurrencyModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editmanageLeadgerInfo ends");
		System.out.println("hello" + response);
		return response;
	}

	// delete
	public ResponseEntity<JsonResponse<Object>> deletecurrencyMemberDetails(String id) {
		logger.info("Method : deletecurrencyMemberDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		System.out.println("ID...." + id);
		if (validity)
			try {

				String value = "SET @p_currencyId=" + id + ";";
				System.out.println("value------------------" + value);

				em.createNamedStoredProcedureQuery("budget_manageCurrency").setParameter("actionType", "deleteCurrency")
						.setParameter("actionValue", value).execute();

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

		logger.info("Method :  deletecurrencyMemberDetails ends");
		System.out.println("DELETE" + response);
		return response;
	}

}
