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
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateInvoicePaymentParameter;
import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoicePaymentModel;

@Repository
public class RestAccountOutstatndingRecievedDao {
	Logger logger = LoggerFactory.getLogger(RestAccountOutstatndingRecievedDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	@Autowired
	EnvironmentVaribles env;
	
	/*
	 * @SuppressWarnings("unchecked") public
	 * JsonResponse<List<RestSalesInvoicePaymentModel>>
	 * getAllsalesInvoiceAccount(String userId, String organization, String
	 * orgDivision) { logger.info("Method : getAllsalesInvoiceAccount Dao starts");
	 * 
	 * List<RestSalesInvoicePaymentModel> invoiceList = new
	 * ArrayList<RestSalesInvoicePaymentModel>();
	 * JsonResponse<List<RestSalesInvoicePaymentModel>> resp = new
	 * JsonResponse<List<RestSalesInvoicePaymentModel>>();
	 * 
	 * try { String value = "SET @p_empId=\"" + userId + "\", @p_org=\"" +
	 * organization + "\", @p_orgDiv=\"" + orgDivision + "\";";
	 * logger.info("value====" + value); List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("salesInvoiceNew")
	 * .setParameter("actionType", "viewSalesLedger").setParameter("actionValue",
	 * "").getResultList();
	 * 
	 * for (Object[] m : x) {
	 * 
	 * Object invoiceDate = null; if (m[3] != null) { invoiceDate =
	 * DateFormatter.returnStringDate(m[3]); } Object dueDate = null; if (m[8] !=
	 * null) { dueDate = DateFormatter.returnStringDate(m[8]); } if (m[15] == null
	 * || m[15] == "") { m[15] = ""; } RestSalesInvoicePaymentModel viewdemo = new
	 * RestSalesInvoicePaymentModel(m[0], m[1], m[2], invoiceDate, m[4], m[5], m[6],
	 * m[7], dueDate, null,m[9], m[10], m[11], m[12], m[13], m[14].toString(), null,
	 * m[15].toString(),null); invoiceList.add(viewdemo);
	 * 
	 * }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } resp.setBody(invoiceList);
	 * logger.info("respGetAllsalesInvoice=====" + resp);
	 * logger.info("Method : getAllsalesInvoiceAccount Dao ends");
	 * 
	 * return resp;
	 * 
	 * }
	 */
	
	//add payment
	public ResponseEntity<JsonResponse<Object>> addPaymentInvoice(RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {

		logger.info("Method in Dao: addPaymentInvoice starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateInvoicePaymentParameter.addPaymentParam(restSalesInvoicePaymentModel);

			System.out.println("==============" + values);
			em.createNamedStoredProcedureQuery("salesInvoiceNew").setParameter("actionType", "addPayment")
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

		logger.info("Method in Dao: addPaymentInvoice ends");

		return response;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBankAccountList(String org, String orgDiv) {
		logger.info("Method : getBankAccountList starts");

		List<DropDownModel> bankList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("value==="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
					.setParameter("actionType", "getAccountList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bankList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getBankAccountList ends");
		return bankList;
	}
	
	public JsonResponse<DropDownModel> recievedScheduleDate(String scheduledDate, String invoiceId) {
		logger.info("Method : recievedScheduleDate starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_scheduledDate='" + DateFormatter.getStringDate(scheduledDate) + "',@p_invoiceId='(" + invoiceId + ")';";
			System.out.println("value===" + value);
			em.createNamedStoredProcedureQuery("salesInvoiceNew").setParameter("actionType", "scheduleRecievedDate")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Method : recievedScheduleDate ends");
		return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewOutstandingReceive(String orgName, String orgDivision, String fromDate, String toDate,String modOfSearch,String customerId) {
		logger.info("Method : viewOutstandingReceive Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET  @P_orgName='" + orgName + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate) + 
					"',@p_toDate='" + DateFormatter.getStringDate(toDate) + "',@P_orgDiv='" + orgDivision + "',@P_mode='" + modOfSearch + "',@P_custId='" + customerId + "';";
			
			logger.info("values----->"+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesAccountRoutines")
					.setParameter("actionType", "viewOutStandingData").setParameter("actionValue", values)
					.getResultList();
			
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewOutstandingReceive Dao ends"+resp);
		return resp;

	}
	
	
@SuppressWarnings("unchecked")
public JsonResponse<Object> getVoucherDetailsOutstandingRcv(String voucherId,String orgName,String orgDivision) {
	logger.info("Method : getVoucherDetailsOutstandingRcv Dao starts");

	JsonResponse<Object> resp = new JsonResponse<Object>();

	try {
		String value = "SET @p_voucherId='" + voucherId  + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info("values--->" + value);
		List<Object[]> x = em.createNamedStoredProcedureQuery("salesAccountRoutines")
				.setParameter("actionType", "getRcvVoucherDetails").setParameter("actionValue", value)
				.getResultList();
		resp.setBody(x.get(0));
		resp.setCode("success");
		resp.setMessage("Data fetched successfully");
	} catch (Exception e) {
		resp.setCode("failed");
		resp.setMessage(e.getMessage());
		e.printStackTrace();
	}

	logger.info("Method : getVoucherDetailsOutstandingRcv Dao ends" + resp);
	return resp;

}
	
}
