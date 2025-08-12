
package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.http.HttpStatus;

import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.account.model.RestCurrencyModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateManageCurrencyParameter;

import org.springframework.http.HttpHeaders;

@Repository
public class RestCurrencyDao {
	
	Logger logger = LoggerFactory.getLogger(RestCurrencyDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	

	/*
	 * for add new Currency
	 */
	public ResponseEntity<JsonResponse<Object>> addCurrency(RestCurrencyModel restCurrencyModel) {

		logger.info("Method in Dao: addCurrency starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		//resp.setMessage("");
		//resp.setCode("");
			try {
				//String values ="";
				String values = GenerateManageCurrencyParameter.getAddCurrencyParam(restCurrencyModel);
				System.out.println(values);
				if (restCurrencyModel.getCurrencyId() =="" || restCurrencyModel.getCurrencyId() ==null) {
			
					em.createNamedStoredProcedureQuery("account_cur_routines").setParameter("actionType", "addCurrency")
							.setParameter("actionValue", values).execute();
					
				} else {
					em.createNamedStoredProcedureQuery("account_cur_routines").setParameter("actionType", "modifyCurrency")
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
		if (resp.getMessage() == null) {
			resp.setMessage("Saved successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method in Dao: addCurrency ends");

		return response;
	}
	
	//restViewBankDetails
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCurrencyModel>>> restViewCurrencyDetails() {
		logger.info("Method : restViewCurrencyDetails starts");
		
		System.out.println("rest Currency Account-------------2222222222");
		List<RestCurrencyModel> respList = new ArrayList<RestCurrencyModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_cur_routines").setParameter("actionType", "getCurrencyDetails")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				
				
				RestCurrencyModel restPayroll = new RestCurrencyModel(m[0], m[1], m[2].toString(), m[3], m[4], m[5], m[6],
						m[7].toString());
				respList.add(restPayroll); 

			}

			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestCurrencyModel>> resp = new JsonResponse<List<RestCurrencyModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestCurrencyModel>>> response = new ResponseEntity<JsonResponse<List<RestCurrencyModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : restViewCurrencyDetails ends");
		
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}
	
	
	//deleteCurrencyDetails
	
	public ResponseEntity<JsonResponse<Object>> deleteCurrencyDetails(String id) {
		logger.info("Method : deleteCurrencyDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ID...."+id);
		if (validity)
			try {
				
				String value = "SET  @p_currencyId='(" + id + ")';";
				
				System.out.println("value------------------"+value);
				

				em.createNamedStoredProcedureQuery("account_cur_routines")
						.setParameter("actionType", "deleteCurrency").setParameter("actionValue", value).execute();

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

		logger.info("Method :  deleteCurrencyDetails ends");
		System.out.println("DELETE" + response);
		return response;
	}
	
	//editCurrencyInfo
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCurrencyModel>>>editCurrencyInfo(String id) {
		logger.info("Method : editCurrencyInfo starts");

		JsonResponse<List<RestCurrencyModel>> resp = new JsonResponse<List<RestCurrencyModel>>();
		List<RestCurrencyModel> rs = new ArrayList<RestCurrencyModel>();

		try {

			String value = "SET @p_currencyId='" + id +"';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_cur_routines")
					.setParameter("actionType", "editCurrencyInfo").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf"+x);
           
			for (Object[] m : x) {
				
				RestCurrencyModel restPayroll = new RestCurrencyModel(m[0], m[1], m[2].toString(), m[3], m[4], m[5], m[6],
						m[7].toString());
				rs.add(restPayroll);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCurrencyModel>>> response = new ResponseEntity<JsonResponse<List<RestCurrencyModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : editCurrencyInfo ends");
		
		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}
		
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		
		System.out.println(response);
		return response;
	}
	
	

}

