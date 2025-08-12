package nirmalya.aatithya.restmodule.pos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pos.model.POSCustomerDetailsRestModel;
import nirmalya.aatithya.restmodule.pos.model.POSProductDetailsRestModel;
import nirmalya.aatithya.restmodule.pos.model.PosInvoiceRestModel;

@Repository
public class POSOrderDao {
	Logger logger = LoggerFactory.getLogger(POSOrderDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<POSCustomerDetailsRestModel>>> viewPosOrder(String id, String pageno) {
		logger.info("Method : viewPosOrder starts");
		List<POSCustomerDetailsRestModel> respList = new ArrayList<POSCustomerDetailsRestModel>();
		JsonResponse<List<POSCustomerDetailsRestModel>> resp = new JsonResponse<List<POSCustomerDetailsRestModel>>();
		String value = "SET @u_Id='" + id + "',@u_pageno='" + pageno + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
					.setParameter("actionType", "getorderDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				POSCustomerDetailsRestModel orderdeatils = new POSCustomerDetailsRestModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7].toString(), m[8].toString(), m[9].toString());
				respList.add(orderdeatils);

			}

			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(respList);

		// JsonResponse<List<POSCustomerDetailsRestModel>> resp = new
		// JsonResponse<List<POSCustomerDetailsRestModel>>();
		ResponseEntity<JsonResponse<List<POSCustomerDetailsRestModel>>> response = new ResponseEntity<JsonResponse<List<POSCustomerDetailsRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewPosOrder ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<POSCustomerDetailsRestModel>> restViewInvoice(String id) {
		logger.info("Method : restViewInvoice starts");

		JsonResponse<POSCustomerDetailsRestModel> resp = new JsonResponse<POSCustomerDetailsRestModel>();
		List<POSCustomerDetailsRestModel> getShoukeenProduct = new ArrayList<POSCustomerDetailsRestModel>();
		List<POSProductDetailsRestModel> docList = new ArrayList<POSProductDetailsRestModel>();

		try {

			String value = "SET @p_orderId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
					.setParameter("actionType", "getorderInvoice").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				POSCustomerDetailsRestModel orderdeatils = new POSCustomerDetailsRestModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7].toString(), m[8], m[9], m[10], m[11], m[12], m[13]);
				getShoukeenProduct.add(orderdeatils);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (getShoukeenProduct.size() > 0) {
			try {
				String subValues = "SET @p_orderId='" + id + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("ecommerce_pos")
						.setParameter("actionType", "getProductDetails").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {

					POSProductDetailsRestModel dropDownModel = new POSProductDetailsRestModel(m[0], m[1], m[2], m[3],
							m[4], m[5], m[6], m[7]);
					docList.add(dropDownModel);
				}
				getShoukeenProduct.get(0).setPrdctDtls(docList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		resp.setBody(getShoukeenProduct.get(0));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		if (resp.getBody().getOrderId() != null) {
			resp.setCode("Success");
			resp.setMessage("Data fetched  succesfully");
		} else {
			resp.setCode("Failed");
			resp.setMessage("Data Not Found");
		}

		ResponseEntity<JsonResponse<POSCustomerDetailsRestModel>> response = new ResponseEntity<JsonResponse<POSCustomerDetailsRestModel>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : restViewInvoice ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<PosInvoiceRestModel>>> restViewInvoicePdf(String id) {
		logger.info("Method : restViewInvoicePdf starts");

		JsonResponse<List<PosInvoiceRestModel>> resp = new JsonResponse<List<PosInvoiceRestModel>>();
		List<PosInvoiceRestModel> rs = new ArrayList<PosInvoiceRestModel>();
		List<POSProductDetailsRestModel> productDetails = new ArrayList<POSProductDetailsRestModel>();
		try {

			String value = "SET @p_orderId='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ecommerce_pos")
					.setParameter("actionType", "getAllDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				PosInvoiceRestModel restPayroll = new PosInvoiceRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10].toString(), m[11].toString(), m[12].toString(), m[13].toString(),
						m[14].toString(), m[15].toString(), m[16].toString(), m[17].toString(), m[18].toString(), m[19],
						m[20], m[21], m[22], m[23], m[24].toString(), m[25], m[26], m[27], m[28], m[29], m[30], m[31],
						m[32], m[33], m[34], m[35], m[36], m[37]);

				rs.add(restPayroll);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (rs.size() > 0) {
			try {
				String subValues = "SET @p_orderId='" + id + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("ecommerce_pos")
						.setParameter("actionType", "getProductDtls").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {

					POSProductDetailsRestModel dropDownModel = new POSProductDetailsRestModel(m[0], m[1],
							m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(), m[6].toString(),
							m[7].toString());
					productDetails.add(dropDownModel);
				}
				rs.get(0).setPrdctDtls(productDetails);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		resp.setBody(rs);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<PosInvoiceRestModel>>> response = new ResponseEntity<JsonResponse<List<PosInvoiceRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : restViewInvoicePdf ends" + resp);
		return response;
	}

}
