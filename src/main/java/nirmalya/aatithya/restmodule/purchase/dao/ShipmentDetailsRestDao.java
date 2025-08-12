package nirmalya.aatithya.restmodule.purchase.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateShipmentEntryParam;
import nirmalya.aatithya.restmodule.gatepass.model.RestGatePassDetailsModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestShipmentDetailsVendorModel;

@Repository
public class ShipmentDetailsRestDao {

	Logger logger = LoggerFactory.getLogger(ShipmentDetailsRestDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestShipmentDetailsVendorModel>>> viewShipmentDetails(String userId,
			String organization, String orgDivision, String pageno) {
		logger.info("Method : viewShipmentDetails starts");
		List<RestShipmentDetailsVendorModel> respList = new ArrayList<RestShipmentDetailsVendorModel>();

		try {
			String value = "SET @p_empId=\"" + userId + "\", @p_org=\"" + organization + "\", @p_orgDiv=\""
					+ orgDivision + "\", @p_pageno=\"" + pageno + "\";";
			System.out.println("value>>>>>>>>--------------" + value);
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("shipment_details_Routines")
					.setParameter("actionType", "viewShipmentDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				Object createdOn = null;
				if (m[8] != null) {
					createdOn = m[8].toString();
				}
				RestShipmentDetailsVendorModel viewdemo = new RestShipmentDetailsVendorModel(m[0], m[1], m[2],
						m[3].toString(), m[4].toString(), m[5], m[6], m[7], createdOn, m[9], m[10], m[11], m[12],
						m[13],m[14],m[15],m[16],m[17]);
				respList.add(viewdemo);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestShipmentDetailsVendorModel>> resp = new JsonResponse<List<RestShipmentDetailsVendorModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestShipmentDetailsVendorModel>>> response = new ResponseEntity<JsonResponse<List<RestShipmentDetailsVendorModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewShipmentDetails ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getCustomerAutoSearchList(String id, String org, String orgDiv) {
		logger.info("Method : getCustomerAutoSearchList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_searchValue='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("shipment_details_Routines")
					.setParameter("actionType", "getCustomerAutoSearchList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCustomerAutoSearchList Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestShipmentDetailsVendorModel>>> addShipmentDetails(
			List<RestShipmentDetailsVendorModel> RestShipmentDetailsVendorModel) {

		logger.info("Method : addShipmentDetails starts");

		JsonResponse<List<RestShipmentDetailsVendorModel>> resp = new JsonResponse<List<RestShipmentDetailsVendorModel>>();
		List<RestShipmentDetailsVendorModel> listData = new ArrayList<RestShipmentDetailsVendorModel>();
		try {

			String values = GenerateShipmentEntryParam.getShipmentParam(RestShipmentDetailsVendorModel);
			if (RestShipmentDetailsVendorModel.get(0).getShippingId() == ""
					|| RestShipmentDetailsVendorModel.get(0).getShippingId() == null) {

				entityManager.createNamedStoredProcedureQuery("shipment_details_Routines")
						.setParameter("actionType", "addShipmentDetails").setParameter("actionValue", values).execute();
			}

			else {

				entityManager.createNamedStoredProcedureQuery("shipment_details_Routines")
						.setParameter("actionType", "modifyShipmentDetails").setParameter("actionValue", values)
						.execute();

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
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestShipmentDetailsVendorModel>>> response = new ResponseEntity<JsonResponse<List<RestShipmentDetailsVendorModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addGatepassEntry ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<RestShipmentDetailsVendorModel> editShipmentData(String shippingId, String organization,
			String orgDivision) {
		logger.info("Method : editShipmentData starts");
		List<RestShipmentDetailsVendorModel> getRequisitionTypeList = new ArrayList<RestShipmentDetailsVendorModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String value = "SET @p_shipmentId=\"" + shippingId + "\", @p_org=\"" + organization + "\", @p_orgDiv=\""
					+ orgDivision + "\";";

			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("shipment_details_Routines")
					.setParameter("actionType", "editShipmentData").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				Object date = null;
				if (m[9] != null) {
					date = DateFormatter.returnStringDate(m[9]);
				}
				Object date1 = null;
				if (m[11] != null) {
					date1 = DateFormatter.returnStringDate(m[11]);
				}
				

				RestShipmentDetailsVendorModel dropDownModel = new RestShipmentDetailsVendorModel(m[0], m[1], m[2],
						m[3].toString(), m[4], m[5], m[6], m[7], m[8], date, m[10], date1, m[12], m[13], m[14], m[15],
						m[16], m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25],m[26],m[27],m[28],m[29],
						m[30],m[31],m[32],m[33],m[34]);

				getRequisitionTypeList.add(dropDownModel);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("Method : editShipmentData ends" + getRequisitionTypeList);
		return getRequisitionTypeList;
	}

	public ResponseEntity<JsonResponse<Object>> deleteShipment(String id, String organization, String orgDivision) {
		logger.info("Method : deleteShipment starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_shipmentId='" + id + "', @p_org='" + organization + "',@p_orgDiv='" + orgDivision
						+ "';";
				entityManager.createNamedStoredProcedureQuery("shipment_details_Routines")
						.setParameter("actionType", "deleteShipment").setParameter("actionValue", value).execute();

				resp.setMessage("Success");
				resp.setCode("Ok");

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

		logger.info("Method : deleteShipment ends");
		return response;
	}
	

	public JsonResponse<DropDownModel> approveshipment(String approveStatus, String shippingId,
			String organization, String orgDivision) {
		logger.info("Method : approveshipment starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
		
			String value = "SET @p_approveStatus='" + approveStatus + "',@p_shippingId='" + shippingId + "', @p_org='"
					+ organization + "',@p_orgDiv='" + orgDivision + "';";
			entityManager.createNamedStoredProcedureQuery("shipment_details_Routines")
					.setParameter("actionType", "approveshipment").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : approveshipment ends");
		return resp;
	}
}
