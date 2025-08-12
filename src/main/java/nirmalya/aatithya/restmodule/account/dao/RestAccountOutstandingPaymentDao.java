package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateInvoicePaymentParameter;
import nirmalya.aatithya.restmodule.account.model.RestSalesInvoicePaymentModel;

@Repository
public class RestAccountOutstandingPaymentDao {
	Logger logger = LoggerFactory.getLogger(RestAccountOutstandingPaymentDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@Autowired
	EnvironmentVaribles env;
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewOutstandingPayment(String orgName, String orgDivision,String fromDate,String toDate,String modOfSearch , String customerId) {
		logger.info("Method : viewOutstandingPayment Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_orgName='" + orgName + "',@P_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "',@P_mode='" + modOfSearch + "',@P_custId='" + customerId + "';";
			logger.info("values-->" + value);	
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
					.setParameter("actionType", "getPaymentVoucherDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewOutstandingPayment Dao ends");
		return resp;

	}
	
	//add payment
		public ResponseEntity<JsonResponse<Object>> addSendPaymentAccount(RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {

			logger.info("Method in Dao: addSendPaymentAccount starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();

			resp.setMessage("");
			resp.setCode("");
			try {
				// String values ="";//
				String values = GenerateInvoicePaymentParameter.addSendPaymentParam(restSalesInvoicePaymentModel);

				System.out.println("==============" + values);
				em.createNamedStoredProcedureQuery("inventory_payment_Routines").setParameter("actionType", "addSendPayment")
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

			logger.info("Method in Dao: addSendPaymentAccount ends");

			return response;
		}
	
		public JsonResponse<DropDownModel> paymentScheduleDate(String scheduledDate, String invoiceId) {
			logger.info("Method : paymentScheduleDate starts");

			JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
			try {
				String value = "SET @p_scheduledDate='" + DateFormatter.getStringDate(scheduledDate) + "',@p_invoiceId='(" + invoiceId + ")';";
				System.out.println("value===" + value);
				em.createNamedStoredProcedureQuery("inventory_payment_Routines").setParameter("actionType", "schedulePayDate")
						.setParameter("actionValue", value).execute();

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			logger.info("Method : paymentScheduleDate ends");
			return resp;
		}
		
	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<RestSalesInvoicePaymentModel>>>
	 * getDebitNoteList(String id) {
	 * logger.info("Method : getDebitNoteList starts");
	 * List<RestSalesInvoicePaymentModel> respList = new
	 * ArrayList<RestSalesInvoicePaymentModel>();
	 * JsonResponse<List<RestSalesInvoicePaymentModel>> resp = new
	 * JsonResponse<List<RestSalesInvoicePaymentModel>>(); String value =
	 * "SET @p_id='" + id + "';";
	 * 
	 * System.out.println(value); try { List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("inventory_payment_Routines")
	 * .setParameter("actionType", "debitNoteList").setParameter("actionValue",
	 * value).getResultList();
	 * 
	 * for (Object[] m : x) {
	 * 
	 * RestSalesInvoicePaymentModel restPayroll = new
	 * RestSalesInvoicePaymentModel(m[0], m[1], m[2],m[3]);
	 * respList.add(restPayroll);
	 * 
	 * } resp.setCode("Success"); resp.setMessage("Data Fetched Successfully"); }
	 * catch (Exception e) { e.printStackTrace(); resp.setCode("Failed");
	 * resp.setMessage(e.getMessage()); }
	 * 
	 * resp.setBody(respList);
	 * ResponseEntity<JsonResponse<List<RestSalesInvoicePaymentModel>>> response =
	 * new ResponseEntity<JsonResponse<List<RestSalesInvoicePaymentModel>>>( resp,
	 * HttpStatus.CREATED); logger.info("Method : getDebitNoteList ends="+
	 * response); return response;
	 * 
	 * }
	 */
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getVoucherPaymentVoucherDetails(String voucherId,String orgName,String orgDivision) {
			logger.info("Method : getVoucherPaymentVoucherDetails Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_voucherId='" + voucherId  + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				logger.info("values--->" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("purchaseRoutines")
						.setParameter("actionType", "getPurVoucherDetails").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getVoucherPaymentVoucherDetails Dao ends" + resp);
			return resp;

		}
		
}
