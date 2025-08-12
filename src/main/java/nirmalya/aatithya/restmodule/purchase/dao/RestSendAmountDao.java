package nirmalya.aatithya.restmodule.purchase.dao;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.purchase.model.RestManageSendAmountModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.sales.dao.SalesInvoiceNewDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateSendAmountGrnParam;

@Repository
public class RestSendAmountDao {
	Logger logger = LoggerFactory.getLogger(SalesInvoiceNewDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EnvironmentVaribles env;

	//view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageSendAmountModel>>> restViewSendAmount() {
		logger.info("Method : restViewSendAmount starts");
		List<RestManageSendAmountModel> respList = new ArrayList<RestManageSendAmountModel>();
		JsonResponse<List<RestManageSendAmountModel>> resp = new JsonResponse<List<RestManageSendAmountModel>>();

		//String value = "SET @p_dealerId='" + userId + "';";
		//System.out.println("====>>>" + value);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("inventory_payment_Routines")
					.setParameter("actionType", "viewSentAmount").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				

				RestManageSendAmountModel restPayroll = new RestManageSendAmountModel(m[0], m[1], m[2], m[3].toString(), m[4], m[5], m[6], m[7], m[8], m[9]);
				respList.add(restPayroll);
				resp.setBody(respList);
				resp.setMessage("Data fetched successfully");
				resp.setCode("Success");
			}

			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();
			resp.setMessage("Data not fetched successfully");
			resp.setCode("Failed");

		}

		ResponseEntity<JsonResponse<List<RestManageSendAmountModel>>> response = new ResponseEntity<JsonResponse<List<RestManageSendAmountModel>>>(
				resp, HttpStatus.CREATED);
		//System.out.println("response" + response);
		logger.info("Method : restViewSendAmount ends");

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}
	
	//get grn list
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGrnList(String id) {

		logger.info("Method : getGrnList starts");
		List<DropDownModel> salesInvoiceList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_vendorId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("inventory_payment_Routines")
					.setParameter("actionType", "getGrnList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1].toString());
				salesInvoiceList.add(dropDownModel);
			}

			resp.setBody(salesInvoiceList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("getGrnList======" + response);
		logger.info("Method : getGrnList ends");
		return response;
	}
	
	//Add
	public ResponseEntity<JsonResponse<Object>> restAddPaymentGrn(RestManageSendAmountModel sendAmountModel) {

		logger.info("Method in Dao: addincentivedao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateSendAmountGrnParam.addAmountParam(sendAmountModel);
			System.out.println(values);
			if (sendAmountModel.getPaymentId() == "" || sendAmountModel.getPaymentId() == null) {

				em.createNamedStoredProcedureQuery("inventory_payment_Routines").setParameter("actionType", "addPayment")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("inventory_payment_Routines").setParameter("actionType", "modifyPayment")
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
	
	//edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageSendAmountModel>>>restEditSendAmount(String id) {
		logger.info("Method : restEditSendAmount starts");

		JsonResponse<List<RestManageSendAmountModel>> resp = new JsonResponse<List<RestManageSendAmountModel>>();
		List<RestManageSendAmountModel> rs = new ArrayList<RestManageSendAmountModel>();

		try {

			String value = "SET @p_paymentId='" + id +"';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("inventory_payment_Routines")
					.setParameter("actionType", "editPayment").setParameter("actionValue", value).getResultList();
			
	     
			for (Object[] m : x) {
				RestManageSendAmountModel restPayroll = new RestManageSendAmountModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11]);
			
				rs.add(restPayroll);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	  resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestManageSendAmountModel>>> response = new ResponseEntity<JsonResponse<List<RestManageSendAmountModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : restEditSendAmount ends"+response);
		return response;
	}
	
	//delete
	public ResponseEntity<JsonResponse<Object>> deletePaymentDetails(String id) {
		logger.info("Method : deletePaymentDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		System.out.println("ID...."+id);
		if (validity)
			try {

				
				String value = "SET  @p_paymentId='(" + id + ")';";
				
				System.out.println("value------------------"+value);
				

				em.createNamedStoredProcedureQuery("inventory_payment_Routines")
					.setParameter("actionType", "deletePayment").setParameter("actionValue", value).execute();
				

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

		logger.info("Method :  deletePaymentDetails ends");
		System.out.println("DELETE" + response);
		return response;
	}

	//payment approval
	public JsonResponse<RestManageSendAmountModel> paymentApprovalAmount(String paymentId, String userId) {
		logger.info("Method : paymentApproval starts");

		JsonResponse<RestManageSendAmountModel> resp = new JsonResponse<RestManageSendAmountModel>();
		try {
			String value = "SET @p_commonPayId='" + paymentId + "',@p_userId='" + userId + "';";
			System.out.println("value===" + value);
			em.createNamedStoredProcedureQuery("inventory_payment_Routines").setParameter("actionType", "paymentApprove")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Payment approved successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("resp===" + resp);
		logger.info("Method : paymentApproval ends");
		return resp;
	}
}
