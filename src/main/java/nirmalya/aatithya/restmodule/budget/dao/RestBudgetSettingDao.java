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

import nirmalya.aatithya.restmodule.budget.model.RestBudgetSettingModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.budget.GenerateSettingBudgetParam;


@RestController
@RequestMapping(value = { "/budget" })
public class RestBudgetSettingDao {
	
	Logger logger = LoggerFactory.getLogger(RestBudgetSettingDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	//getFiscalYear
	
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getBudgetFiscalYear() {

			logger.info("Method :getBudgetFiscalYear starts");

			List<DropDownModel> deptList = new ArrayList<DropDownModel>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("budgetSetting")
						.setParameter("actionType", "getBudgetFiscalYear").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					deptList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getBudgetFiscalYear ends" + deptList);

			return deptList;
		}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestBudgetSettingModel>>> viewBudgetSet(String id) {
		logger.info("Method : viewBudgetSetting starts");

		JsonResponse<List<RestBudgetSettingModel>> resp = new JsonResponse<List<RestBudgetSettingModel>>();
		List<RestBudgetSettingModel> rs = new ArrayList<RestBudgetSettingModel>();

		try {

			String value = "SET @p_budgetSetId='" + id + "';";
			System.out.println("--------------------------------------------"+value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("budgetSetting")
					.setParameter("actionType", "viewBudgetSetting").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf" + x);

			for (Object[] m : x) {

				RestBudgetSettingModel restPayroll = new RestBudgetSettingModel(m[0], m[1], m[2], m[3]);

				rs.add(restPayroll);

			}
			
			resp.setBody(rs);
			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully");
		} catch (Exception e) {
			resp.setCode("Failed");
			resp.setMessage(e.getMessage());
		}
		//resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		/*
		 * ResponseEntity<JsonResponse<List<RestBudgetSettingModel>>> response = new
		 * ResponseEntity<JsonResponse<List<RestBudgetSettingModel>>>( resp,
		 * HttpStatus.CREATED);
		 */
		ResponseEntity<JsonResponse<List<RestBudgetSettingModel>>> response = new ResponseEntity<JsonResponse<List<RestBudgetSettingModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewBudgetSetting ends-------------"+resp);
		System.out.println(response);
		return response;
	}
	
	/*----------------------------------Update Budget------------------------------------------------------------*/

	public ResponseEntity<JsonResponse<Object>> updateBudgetSet(RestBudgetSettingModel restBudgetSettingModel) {

		logger.info("Method in Dao: updateBudgetSet starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateSettingBudgetParam.addBudgetSettingParam(restBudgetSettingModel);

			System.out.println("save for dealer-----------------------------------" + values);
			if (restBudgetSettingModel.getBudgetSetId() == "" || restBudgetSettingModel.getBudgetSetId() == null) {

				em.createNamedStoredProcedureQuery("budgetSetting").setParameter("actionType", "addBudget")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("budgetSetting").setParameter("actionType", "modifyBudget")
						.setParameter("actionValue", values).execute();
			}
			resp.setCode("Success");
			resp.setMessage("Factory manager added successfully");
		} catch (Exception e) {
			resp.setCode("Failed");
			resp.setMessage(e.getLocalizedMessage());
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

		logger.info("Method in Dao: updateBudgetSet ends");
		System.out.println(response);
		return response;
	}

}
