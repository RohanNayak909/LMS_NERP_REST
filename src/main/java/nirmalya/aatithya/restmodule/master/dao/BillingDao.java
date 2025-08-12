package nirmalya.aatithya.restmodule.master.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.DynamicQueryBuilder;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateAmbulanceBookingParameter;
import nirmalya.aatithya.restmodule.his.model.RestHisBookingAmbulanceModel;

@Repository
public class BillingDao {

	Logger logger = LoggerFactory.getLogger(BillingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getProductTypeWiseInMasterDao(String orgName, String orgDivision, String userId,
			String from,String deptId) {
		logger.info("Method : getProductTypeWiseInMasterDao Dao Starts" + userId);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_ORG='" + orgName + "',@P_ORG_DIV='" + orgDivision + "',@P_FROM='" + from
					+ "',@P_USER_ID='" + userId + "',@P_SUBCAT_ID='" + deptId + "';";
			System.out.println("================================================>"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("product_details")
					.setParameter("actionType", "getProductDetails").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getProductTypeWiseInMasterDao Dao Ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> userRegistrationWithProductBookingDao(
			RestHisBookingAmbulanceModel addBookingAmbulance) {
		logger.info("Method : userRegistrationWithProductBookingDao Dao Starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateAmbulanceBookingParameter.getAddAmbulanceBooking(addBookingAmbulance);
			
			System.out.println(values);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("product_details")
					.setParameter("actionType", "userRegistrationBooking").setParameter("actionValue", values)
					.getResultList();
			resp.setCode("Success");
			resp.setMessage("Registered Successfully !");
			resp.setBody(x);

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : userRegistrationWithProductBookingDao Dao Ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> ipduserRegistrationWithProductBookingRest(
			RestHisBookingAmbulanceModel addBookingAmbulance) {
		logger.info("Method : ipduserRegistrationWithProductBookingRest Dao Starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String values = GenerateAmbulanceBookingParameter.getAddAmbulanceBooking(addBookingAmbulance);
			
			System.out.println(values);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("product_details")
					.setParameter("actionType", "userRegistrationBooking_IPD").setParameter("actionValue", values)
					.getResultList();
			resp.setCode("Success");
			resp.setMessage("Registered Successfully !");
			resp.setBody(x);
			
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		
		logger.info("Method : ipduserRegistrationWithProductBookingRest Dao Ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> restChangeStatusOfBookedAmmbulanceDao(
			DropDownModel addBookingAmbulance) {
		logger.info("Method : restChangeStatusOfBookedAmmbulanceDao Dao Starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(addBookingAmbulance);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("product_details")
					.setParameter("actionType", "changeStatusBookedAmb").setParameter("actionValue", values)
					.getResultList();
			resp.setCode("success");
			resp.setMessage("Registered Successfully !");
			resp.setBody(x);
			
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		
		logger.info("Method : restChangeStatusOfBookedAmmbulanceDao Dao Ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> restdeletechilddata(
			DropDownModel addBookingAmbulance) {
		logger.info("Method : restdeletechilddata Dao Starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(addBookingAmbulance);
			System.out.println(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("product_details")
					.setParameter("actionType", "deleteCustDep").setParameter("actionValue", values)
					.getResultList();
			
			if(x.size() > 0) {
				resp.setCode("success");
				resp.setMessage("Deleted Successfully !");
				resp.setBody(x);
			} else {
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
			}
			
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		
		logger.info("Method : restdeletechilddata Dao Ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> restaddchilddata(
			DropDownModel addBookingAmbulance) {
		logger.info("Method : restaddchilddata Dao Starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(addBookingAmbulance);
			System.out.println(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("product_details")
					.setParameter("actionType", "addCustDep").setParameter("actionValue", values)
					.getResultList();
			
			if(x.size() > 0) {
				resp.setCode("success");
				resp.setMessage("Saved Successfully !");
				resp.setBody(x);
			} else {
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
			}
			
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		
		logger.info("Method : restaddchilddata Dao Ends");
		return response;
	}
}
