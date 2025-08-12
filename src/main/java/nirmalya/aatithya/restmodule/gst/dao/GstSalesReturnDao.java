package nirmalya.aatithya.restmodule.gst.dao;

import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.ManageEmployeeDao;
import nirmalya.aatithya.restmodule.gst.model.GstReportRestModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GstSalesReturnDao {

	Logger logger = LoggerFactory.getLogger(GstSalesReturnDao.class);

	@Autowired
	EntityManager em;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getSalesInvoiceData(String month, String year, String org, String orgDiv) {
		logger.info("Method : getSalesInvoiceData starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		List<Object[]> x = null;
		try {
			String value = "SET @P_month='" + month + "', @P_year='" + year + "', @org='" + org + "', @orgDiv='"
					+ orgDiv + "';";
			System.out.println(value);
			x = em.createNamedStoredProcedureQuery("gstReturnRoutines")
					.setParameter("actionType", "getSalesInvoiceData").setParameter("actionValue", value)
					.getResultList();
			jsonResponse.setBody(x);
			jsonResponse.setCode("Success");
			System.out.println("######GSTIN! DATA #####" + jsonResponse.getBody());

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonResponse);
		logger.info("Method : getSalesInvoiceData ends");
		return jsonResponse;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteGstSalesInvoiceItem(String invoiceNo, String itemId, String month, String year) {
		logger.info("Method : deleteGstSalesInvoiceItem starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		List<Object[]> x = null;
		try {
			String value = "SET @P_invoiceNo='" + invoiceNo + "', @P_itemId='" + itemId + "', @P_month='" + month
					+ "', @P_year='" + year + "';";
			System.out.println(value);
			x = em.createNamedStoredProcedureQuery("gstReturnRoutines")
					.setParameter("actionType", "deleteGstSalesInvoiceItem").setParameter("actionValue", value)
					.getResultList();

			System.out.println("MASTER DATA: " + x);
			jsonResponse.setBody(x);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonResponse);
		logger.info("Method : deleteGstSalesInvoiceItem ends");
		return jsonResponse;
	}

	// get
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPurchasesasperRecord(String month, String year, String org, String orgDiv) {
		logger.info("Method : getPurchasesasperRecord starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		List<Object[]> x = null;
		try {
			String value = "SET @p_month='" + month + "', @p_year='" + year + "', @org='" + org + "', @orgDiv='"
					+ orgDiv + "';";
			System.out.println(value);
			x = em.createNamedStoredProcedureQuery("gstReturnRoutines").setParameter("actionType", "gstnReturnPurchase")
					.setParameter("actionValue", value).getResultList();
			jsonResponse.setBody(x);
			jsonResponse.setCode("Success");
			System.out.println("######GSTIN! DATA Purchasesas #####" + jsonResponse.getBody());

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonResponse);
		logger.info("Method : getPurchasesasperRecord ends");
		return jsonResponse;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getInvoiceData(String month, String year) {
		logger.info("Method : getInvoiceData starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		List<Object[]> x = null;
		try {
			String value = "SET @P_month='" + month + "', @P_year='" + year + "';";
			System.out.println(value);
			x = em.createNamedStoredProcedureQuery("gstReturnRoutines").setParameter("actionType", "getInvoiceData")
					.setParameter("actionValue", value).getResultList();
			jsonResponse.setBody(x);
			jsonResponse.setCode("Success");
			System.out.println("######GSTIN! DATA #####" + jsonResponse.getBody());

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonResponse);
		logger.info("Method : getInvoiceData ends");
		return jsonResponse;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getHsnSales(String month, String year, String org, String orgDiv) {
		logger.info("Method : getHsnSales starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		List<Object[]> x = null;
		try {
			String value = "SET @P_month='" + month + "', @P_year='" + year + "', @org='" + org + "', @orgDiv='"
					+ orgDiv + "';";
			System.out.println(value);
			x = em.createNamedStoredProcedureQuery("gstReturnRoutines").setParameter("actionType", "getSalesItemData")
					.setParameter("actionValue", value).getResultList();
			jsonResponse.setBody(x);
			jsonResponse.setCode("Success");
			jsonResponse.setMessage("Successfully fetched HSN for sales!");
			System.out.println("######HSN! DATA #####" + jsonResponse.getBody());

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonResponse);
		logger.info("Method : getHsnSales ends");
		return jsonResponse;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getHsnPurchase(String month, String year, String org, String orgDiv) {
		logger.info("Method : getHsnPurchase starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		List<Object[]> x = null;
		try {
			String value = "SET @P_month='" + month + "', @P_year='" + year + "', @org='" + org + "', @orgDiv='"
					+ orgDiv + "';";
			System.out.println(value);
			x = em.createNamedStoredProcedureQuery("gstReturnRoutines")
					.setParameter("actionType", "getPurchaseItemData").setParameter("actionValue", value)
					.getResultList();
			jsonResponse.setBody(x);
			jsonResponse.setCode("Success");
			jsonResponse.setMessage("Successfully fetched HSN for purchase!");
			System.out.println("######HSN! DATA #####" + jsonResponse.getBody());

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonResponse);
		logger.info("Method : getHsnPurchase ends");
		return jsonResponse;
	}

	// for 3B

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewGst3BList(String month, String year, String org, String orgDiv) {
		logger.info("Method : viewGst3BList starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		List<Object[]> x = null;
		try {
			String value = "SET @p_month='" + month + "', @p_year='" + year + "', @org='" + org + "', @orgDiv='"
					+ orgDiv + "';";
			System.out.println(value);
			x = em.createNamedStoredProcedureQuery("gstReturnRoutines").setParameter("actionType", "viewGst3BList")
					.setParameter("actionValue", value).getResultList();
			jsonResponse.setBody(x);
			jsonResponse.setCode("Success");
			System.out.println("######GST3B! DATA #####" + jsonResponse.getBody());

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonResponse);
		logger.info("Method : viewGst3BList ends");
		return jsonResponse;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<GstReportRestModel>>> gst3BPdfReport(String years, String months) {
		logger.info("Method : gst3BPdfReport starts");

		JsonResponse<List<GstReportRestModel>> resp = new JsonResponse<List<GstReportRestModel>>();
		List<GstReportRestModel> rs = new ArrayList<GstReportRestModel>();
		// String value = "SET @p_dealerId='" + id + "';";
		String value = "SET @p_years='" + years + "',@p_months='" + months + "';";

		System.out.println("value====" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("gstReturnRoutines")
					.setParameter("actionType", "gst3BPdfReport").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				if (m[9] == null) {
					m[9] = "";
				}

				if (m[10] == null) {
					m[10] = "";
				}

				GstReportRestModel restPayroll = new GstReportRestModel(m[0].toString(), m[1].toString(),
						m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(), m[6].toString(),
						m[7].toString(), m[8].toString(), null, m[9].toString(), null, null, null, m[10].toString(),
						m[11].toString(), m[12].toString(), m[13].toString(), m[14].toString(), m[15].toString(),
						m[16].toString(), m[17].toString());

				rs.add(restPayroll);
			}

			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<GstReportRestModel>>> response = new ResponseEntity<JsonResponse<List<GstReportRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : gst3BPdfReport ends" + response);
		System.out.println(response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getHsn3B(String month, String year, String org, String orgDiv) {
		logger.info("Method : getHsn3B starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();

		List<Object[]> x = null;
		try {
			String value = "SET @P_month='" + month + "', @P_year='" + year + "', @org='" + org + "', @orgDiv='"
					+ orgDiv + "';";
			System.out.println(value);
			x = em.createNamedStoredProcedureQuery("gstReturnRoutines")
					.setParameter("actionType", "getHsn3B").setParameter("actionValue", value)
					.getResultList();
			jsonResponse.setBody(x);
			jsonResponse.setCode("Success");
			jsonResponse.setMessage("Successfully fetched HSN for purchase!");
			System.out.println("######HSN! DATA #####" + jsonResponse.getBody());

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonResponse);
		logger.info("Method : getHsn3B ends");
		return jsonResponse;
	}

}
