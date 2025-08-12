package nirmalya.aatithya.restmodule.account.dao;

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
import nirmalya.aatithya.restmodule.account.model.RestManageLeadgerModel;
import nirmalya.aatithya.restmodule.common.ServerDao;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateMangeCurrencyParam;



@RestController
@RequestMapping(value = { "shoukeen" })
public class RestManageCurrencyDao {

	Logger logger = LoggerFactory.getLogger(RestManageCurrencyDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	// Add
		public ResponseEntity<JsonResponse<Object>> addManageCurrency(RestManageCurrencyModel manageCurrencyt) {

			logger.info("Method in Dao: addincentivedao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			resp.setMessage("");
			resp.setCode("");
			try {
				// String values ="";//
				String values = GenerateMangeCurrencyParam.addmanagecurrencyParam(manageCurrencyt);
				System.out.println(values);
				if (manageCurrencyt.getCurrencyid() == "" || manageCurrencyt.getCurrencyid() == null) {

					em.createNamedStoredProcedureQuery("account_manageCurrency").setParameter("actionType", "addCurrency")
							.setParameter("actionValue", values).execute();

				} else {
					em.createNamedStoredProcedureQuery("account_manageCurrency").setParameter("actionType", "modifyCurrency")
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


	//// view
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestManageCurrencyModel>>> viewCurrency() {
			logger.info("Method : viewcurrencydao starts");
			List<RestManageCurrencyModel> respList = new ArrayList<RestManageCurrencyModel>();

			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("account_manageCurrency")
						.setParameter("actionType", "viewsCurrency").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {

					RestManageCurrencyModel restPayroll = new RestManageCurrencyModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7],m[8]);
					respList.add(restPayroll);

				}

				System.out.println("VIEW" + respList);

			} catch (Exception e) {

				e.printStackTrace();

			}

			JsonResponse<List<RestManageCurrencyModel>> resp = new JsonResponse<List<RestManageCurrencyModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestManageCurrencyModel>>> response = new ResponseEntity<JsonResponse<List<RestManageCurrencyModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			logger.info("Method : viewcurrencydao ends");

			System.out.println("VIEWWWWWWWW" + respList);
			return response;

		}
		
		//Edit
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestManageCurrencyModel>>>editCurrency(String id) {
			logger.info("Method : editmanageLeadgerInfo starts");

			JsonResponse<List<RestManageCurrencyModel>> resp = new JsonResponse<List<RestManageCurrencyModel>>();
			List<RestManageCurrencyModel> rs = new ArrayList<RestManageCurrencyModel>();

			try {

				String value = "SET @p_currencyId='" + id +"';";
				System.out.println(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("account_manageCurrency")
						.setParameter("actionType", "editCurrency").setParameter("actionValue", value).getResultList();
				
		     
				for (Object[] m : x) {
					RestManageCurrencyModel restPayroll = new RestManageCurrencyModel(m[0], m[1], m[2], m[3], m[4],
							m[5], m[6], m[7],m[8]);
				
					rs.add(restPayroll);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		  resp.setBody(rs);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");

			ResponseEntity<JsonResponse<List<RestManageCurrencyModel>>> response = new ResponseEntity<JsonResponse<List<RestManageCurrencyModel>>>(resp,responseHeaders,
					HttpStatus.CREATED);

			logger.info("Method : editmanageLeadgerInfo ends");
			System.out.println("hello"+response);
			return response;
		}
		
		

		//delete
		public ResponseEntity<JsonResponse<Object>> deletecurrencyMemberDetails(String id) {
			logger.info("Method : deletecurrencyMemberDetails starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			System.out.println("ID...."+id);
			if (validity)
				try {

					String value = "SET @p_currencyId=" + id + ";";
					System.out.println("value------------------"+value);
					

					em.createNamedStoredProcedureQuery("account_manageCurrency")
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

			logger.info("Method :  deletecurrencyMemberDetails ends");
			System.out.println("DELETE" + response);
			return response;
		}


}
