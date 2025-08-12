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

import nirmalya.aatithya.restmodule.budget.model.RestFinancialYearModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.budget.GenerateFinancialYearParam;

@RestController
@RequestMapping(value = { "budget" })
public class RestFinancialYearDao {
	Logger logger = LoggerFactory.getLogger(RestFinancialYearDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	// =============================================================

	// Add
	public ResponseEntity<JsonResponse<Object>> addFinancialYearInfo(RestFinancialYearModel restFinancialYearModel) {

		logger.info("Method in Dao: addDepartmentInfo starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateFinancialYearParam.addFinancialYearInfo(restFinancialYearModel);
			// System.out.println("values---------------------------------"+values);
			if (restFinancialYearModel.getFinancialYearId() == ""
					|| restFinancialYearModel.getFinancialYearId() == null) {
				System.out.println("values for if block---------------------------------" + values);
				em.createNamedStoredProcedureQuery("managefinancialYear")
						.setParameter("actionType", "addFinancialYear").setParameter("actionValue", values).execute();

			} else {
				System.out.println("values for else---------------------------------" + values);
				em.createNamedStoredProcedureQuery("managefinancialYear").setParameter("actionType", "modifyFinancial")
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

		logger.info("Method in Dao: addFinancialInfo ends" + response);

		return response;
	}


	// view financiaYear through json

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> restViewFinancialYear(String orgName, String orgDivision) {
		logger.info("Method : restViewFinancialYear Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			 System.out.println("values viewFinancial****************************" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("managefinancialYear")
					.setParameter("actionType", "viewFinancial").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : restViewFinancialYear Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// Edit

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestFinancialYearModel>>> editFinancialYearInfo(String id) {
		logger.info("Method : editFinancialYearInfo starts");

		JsonResponse<List<RestFinancialYearModel>> resp = new JsonResponse<List<RestFinancialYearModel>>();
		List<RestFinancialYearModel> rs = new ArrayList<RestFinancialYearModel>();

		resp.setMessage("Success");
		resp.setCode("success");
		try {

			String value = "SET @p_financialYearId='" + id + "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("managefinancialYear")
					.setParameter("actionType", "editFinancial").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				RestFinancialYearModel restPayroll = new RestFinancialYearModel(m[0], m[1], m[2], m[3], m[4]);

				rs.add(restPayroll);

			}

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
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestFinancialYearModel>>> response = new ResponseEntity<JsonResponse<List<RestFinancialYearModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editFinancialYearInfo ends");
		System.out.println(response);
		return response;
	}

//	
//	//Delete
//	
//	
	public ResponseEntity<JsonResponse<Object>> deletefinancialInfo(String id) {
		logger.info("Method : deletefinancialInfo starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		System.out.println("ID...." + id);
		if (validity)
			try {

				String value = "SET  @p_financialYearId='(" + id + ")';";

				System.out.println("value------------------" + value);

				em.createNamedStoredProcedureQuery("managefinancialYear")
						.setParameter("actionType", "deleteFinancialYear").setParameter("actionValue", value).execute();

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

		logger.info("Method :  deletefinancialInfo ends");
		System.out.println("DELETE" + response);
		return response;
	}

}
