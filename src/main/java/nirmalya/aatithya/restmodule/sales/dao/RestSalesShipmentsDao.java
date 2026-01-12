package nirmalya.aatithya.restmodule.sales.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateSalesShipmentParameter;
import nirmalya.aatithya.restmodule.sales.model.RestDeliveryChallanModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesShipmentsModel;

@Repository
public class RestSalesShipmentsDao {
	Logger logger = LoggerFactory.getLogger(RestSalesShipmentsDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	
	public ResponseEntity<JsonResponse<List<RestSalesShipmentsModel>>> addShipments(
			List<RestSalesShipmentsModel> restSalesShipmentsModel) {

		logger.info("Method : addShipments starts");

		JsonResponse<List<RestSalesShipmentsModel>> resp = new JsonResponse<List<RestSalesShipmentsModel>>();
		List<RestSalesShipmentsModel> listData = new ArrayList<RestSalesShipmentsModel>();

		logger.info("=====>>>>>"+restSalesShipmentsModel);
		
		try {
			String values = GenerateSalesShipmentParameter.getAddShipmentParam(restSalesShipmentsModel);

			if (restSalesShipmentsModel.get(0).getSalesShipmentId() == null
					|| restSalesShipmentsModel.get(0).getSalesShipmentId() == "") {
				em.createNamedStoredProcedureQuery("salesShipmentsNew")
						.setParameter("actionType", "addShipments").setParameter("actionValue", values)
						.execute();
			} else {
				logger.info("@modify" + values);
				em.createNamedStoredProcedureQuery("salesShipmentsNew")
						.setParameter("actionType", "modifyshipments").setParameter("actionValue", values)
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
		ResponseEntity<JsonResponse<List<RestSalesShipmentsModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesShipmentsModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addShipments ends");
		return response;
	}
	
	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewsalesShipments(String orgName, String orgDivision, String pageno) {
		logger.info("Method : viewsalesShipments Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_pageno='" + pageno + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesShipmentsNew")
					.setParameter("actionType", "viewsalesShipments").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : viewsalesShipments Dao ends");
		return resp;

	}
	
	//Edit 

		@SuppressWarnings("unchecked")
		public List<RestSalesShipmentsModel> viewShipmentEdit(String id,String orgName, String orgDiv) {
			logger.info("Method : viewShipmentEdit starts");
			logger.info("restSalesShipmentsModel" + id);
			// JsonResponse<List<RestQuotationNewModel>> resp = new
			// JsonResponse<List<RestQuotationNewModel>>();
			List<RestSalesShipmentsModel> getRequisitionTypeList = new ArrayList<RestSalesShipmentsModel>();

			try {
				
				String values = "SET @p_shipmentId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				logger.info("valuessssssssssssssss"+values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesShipmentsNew")
						.setParameter("actionType", "viewShipmentEdit").setParameter("actionValue", values).getResultList();
				try {
					for (Object[] m : x) {

						
						 Object DATE = null; 
						 if (m[7] != null) 
						 {
							 DATE = m[7].toString();
						 }
						 
						 RestSalesShipmentsModel dropDownModel = new RestSalesShipmentsModel(m[0], m[1],m[2], null, 
								 m[3], m[4],  m[5],  m[6], DATE,  m[8], m[9],null,m[10], null, null,
									null, null, null, null, null,m[11],m[12] );
						getRequisitionTypeList.add(dropDownModel);
						logger.info("print edit" + getRequisitionTypeList);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			// resp.setBody(getRequisitionTypeList);
			logger.info("@@@@@@@@edit" + getRequisitionTypeList);
			logger.info("Method : viewShipmentEdit ends");
			return getRequisitionTypeList;
		}

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<Object>> deletShipments(String id,String orgName, String orgDiv) {
			logger.info("Method : deletShipments starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_shipmentId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
					logger.info("DELETEID" + value);
					em.createNamedStoredProcedureQuery("salesShipmentsNew").setParameter("actionType", "deletShipments")
							.setParameter("actionValue", value).execute();
					resp.setCode("success");
				}catch (Exception e) {
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

			logger.info("Method : deletShipments ends");
			logger.info("DELETEE" + response);
			return response;
		}
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getPackageId(String id,String orgName, String orgDiv) {

			logger.info("Method : getPackageId starts");
			List<DropDownModel> salespackageList = new ArrayList<DropDownModel>();

			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

			String value = "SET @p_salesOrderId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("++++++++++++++++++++++++++" + value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesShipmentsNew")
						.setParameter("actionType", "getPackageId").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					salespackageList.add(dropDownModel);
					// logger.info("stateeeeeeeeeee"+dropDownModel);
				}

				resp.setBody(salespackageList);

			} catch (Exception e) {
				e.printStackTrace();
			}
			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("stateeeeeeeeeee======"+response);
			logger.info("Method : getPackageId ends");
			return response;
		}
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getShipmentInsertedId() {
			logger.info("Method : getShipmentInsertedId starts");

			List<DropDownModel> itemList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("salesShipmentsNew")
						.setParameter("actionType", "getShipmentInsertedId").setParameter("actionValue", "")
						.getResultList();

				Object jobId = x.get(0);
				logger.info("job id--------" + jobId);
				

				DropDownModel dropDownModel = new DropDownModel(jobId,null);

				itemList.add(dropDownModel);
				resp.setBody(itemList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);
			//logger.info("response for getting job card id -------" + response);
			logger.info("Method : getShipmentInsertedId ends");
			return response;
		}

		@SuppressWarnings("unchecked")
		public List<DropDownModel> getCarrierList() {
			logger.info("Method : getCarrierList starts");
			List<DropDownModel> getRequisitionTypeList = new ArrayList<DropDownModel>();
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesShipmentsNew")
						.setParameter("actionType", "getCarrierList").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					getRequisitionTypeList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getCarrierList ends");
			return getRequisitionTypeList;
		}
		//Delivered Status
		public JsonResponse<RestSalesShipmentsModel> deliveryStatus(String shipmentStatus, String salesShipmentId,String orgName, String orgDiv) {
			logger.info("Method : deliveryStatus starts");

			RestSalesShipmentsModel req = new RestSalesShipmentsModel();
			JsonResponse<RestSalesShipmentsModel> resp = new JsonResponse<RestSalesShipmentsModel>();
			try {
				
				String value = "SET @p_shipmentStatus='" + shipmentStatus + "',@p_salesShipmentId='" + salesShipmentId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				logger.info("value==="+value);
				em.createNamedStoredProcedureQuery("salesShipmentsNew").setParameter("actionType", "deliveryStatus")
						.setParameter("actionValue", value).execute();
				resp.setBody(req);
				resp.setCode("success");
				resp.setMessage("Order Delivered successfully");
				
			
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			logger.info("resp==="+resp);
			logger.info("Method : approveSaleOrder ends");
			return resp;
		}
		
		/*
		 * @SuppressWarnings("unchecked") public
		 * ResponseEntity<JsonResponse<List<RestSalesShipmentsModel>>>
		 * viewsalesPOWiseShipment(String orgName, String orgDiv,String id) {
		 * logger.info("Method : viewsalesPOWiseShipment Dao starts");
		 * 
		 * List<RestSalesShipmentsModel> getAllemployee = new
		 * ArrayList<RestSalesShipmentsModel>();
		 * JsonResponse<List<RestSalesShipmentsModel>> resp = new
		 * JsonResponse<List<RestSalesShipmentsModel>>();
		 * 
		 * try { String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv +
		 * "',@p_poId='" + id + "';";
		 * logger.info("values****************************" + values);
		 * 
		 * List<Object[]> x = em.createNamedStoredProcedureQuery("salesShipmentsNew")
		 * .setParameter("actionType",
		 * "viewsalesPOWiseShipment").setParameter("actionValue", values)
		 * .getResultList();
		 * 
		 * for (Object[] m : x) {
		 * 
		 * Object createdOn = null; if (m[4] != null) { createdOn = m[4].toString(); }
		 * 
		 * RestSalesShipmentsModel viewdemo = new RestSalesShipmentsModel(m[0], m[1],
		 * m[2], m[3], createdOn, m[5], m[6], m[7],m[8],null,m[9],m[10]);
		 * getAllemployee.add(viewdemo); } resp.setBody(getAllemployee); } catch
		 * (Exception e) { e.printStackTrace(); }
		 * 
		 * ResponseEntity<JsonResponse<List<RestSalesShipmentsModel>>> response = new
		 * ResponseEntity<JsonResponse<List<RestSalesShipmentsModel>>>( resp,
		 * HttpStatus.CREATED);
		 * logger.info("Method : viewsalesPOWiseShipment Dao ends");
		 * logger.info("resp****************************" + response); return
		 * response;
		 * 
		 * }
		 */
		//Get Challan Data
		@SuppressWarnings("unchecked")
		public List<RestDeliveryChallanModel> viewsalesChallanData(String id,String orgName, String orgDiv) {
			logger.info("Method : viewsalesChallanData starts");
			logger.info("viewsalesChallanData" + id);
			// JsonResponse<List<RestQuotationNewModel>> resp = new
			// JsonResponse<List<RestQuotationNewModel>>();
			List<RestDeliveryChallanModel> getRequisitionTypeList = new ArrayList<RestDeliveryChallanModel>();

			try {
				
				String values = "SET @p_shipmentId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				logger.info("valuessssssssssssssss"+values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesShipmentsNew")
						.setParameter("actionType", "viewsalesChallanData").setParameter("actionValue", values).getResultList();
				try {
					for (Object[] m : x) {

						
						Object createdOn = null;
						if (m[26] != null) {
							createdOn = m[26].toString();
						}
						Object ebillDate = null;
						if (m[38] != null) {
							ebillDate = m[38].toString();
						}
						double rqty=0;
						if (m[53] != null) {
							rqty=Double.parseDouble(m[53].toString());
						}
						 RestDeliveryChallanModel dropDownModel = new RestDeliveryChallanModel(m[0], null, null, null, m[1],null,null, m[2], 
									null, m[3], null, m[4], m[5], m[6],
									 m[7], m[8], m[9], m[10], m[11],m[12], m[13], m[14], m[15],
									m[16], m[17], m[18], m[19], null, null, null, m[20], m[21],
									m[22], m[23], m[24], m[25],m[32], m[33], null, m[34], m[35],m[36], createdOn, m[27],null,m[28],null,m[29],m[30],
									m[31],m[37],ebillDate,m[39],null,null,m[40],m[41],m[42],m[43],null,null,null,m[44],m[45],m[46],m[47],m[48],null,null,m[49],m[50],m[51],m[52],
									rqty,m[54],m[55],null,null,null,null,null,null,null,null,null,null,null);
						getRequisitionTypeList.add(dropDownModel);
						logger.info("print edit" + getRequisitionTypeList);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			// resp.setBody(getRequisitionTypeList);
			logger.info("@@@@@@@@edit" + getRequisitionTypeList);
			logger.info("Method : viewsalesChallanData ends");
			return getRequisitionTypeList;
		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getChallanOnPo(String poId, String orgName, String orgDiv) {
			logger.info("Method : getChallanOnPo Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_poId='" + poId + "';";
				System.out.println("getPackageOnPo ========>" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesShipmentsNew")
						.setParameter("actionType", "getChallanOnPo").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getChallanOnPo Dao ends" + resp);
			return resp;

		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getPoOnCustomerChange(String custId, String orgName, String orgDiv) {
			logger.info("Method : getPoOnCustomerChange Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_custId='" + custId + "';";
				System.out.println("getPoOnCustomerChange ========>" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesShipmentsNew")
						.setParameter("actionType", "getPoForShipment").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getPoOnCustomerChange Dao ends" + resp);
			return resp;

		}
}
