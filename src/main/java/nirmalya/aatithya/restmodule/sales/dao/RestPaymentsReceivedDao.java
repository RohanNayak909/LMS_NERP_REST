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
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateSalesPaymentsReceivedParameter;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.RestPaymentsReceivedModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoicePaymentModel;
@Repository
public class RestPaymentsReceivedDao {

	Logger logger = LoggerFactory.getLogger(RestPaymentsReceivedDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPaymentsReceivedModel>>> getAccountsByAutoSearch(String id) {
		logger.info("Method :getAccountsByAutoSearch starts");

		List<RestPaymentsReceivedModel> itemNameList = new ArrayList<RestPaymentsReceivedModel>();
		JsonResponse<List<RestPaymentsReceivedModel>> resp = new JsonResponse<List<RestPaymentsReceivedModel>>();
		String value = "SET @p_searchValue='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPaymentreceivedRotines")
					.setParameter("actionType", "getAccountsByAutoSearch").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestPaymentsReceivedModel dropDownModel = new RestPaymentsReceivedModel(m[0],m[1]); 
				logger.info("getAllcustomerrrrr" +dropDownModel);
				itemNameList.add(dropDownModel);
			}
			
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestPaymentsReceivedModel>>> response = new ResponseEntity<JsonResponse<List<RestPaymentsReceivedModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAccountsByAutoSearch ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesInvoiceList1(String id,String type) {

		logger.info("Method : getSalesInvoiceList1 starts");
		List<DropDownModel> salesInvoiceList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_customerId='" + id + "',@p_type='" + type + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPaymentreceivedRotines")
					.setParameter("actionType", "getSalesInvoiceList1").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				salesInvoiceList.add(dropDownModel);
				// logger.info("stateeeeeeeeeee"+dropDownModel);
			}

			resp.setBody(salesInvoiceList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("stateeeeeeeeeee======"+response);
		logger.info("Method : getSalesInvoiceList1 ends");
		return response;
	}
	/*
	 * add
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPaymentsReceivedModel>>> addpaymentsreceived(
			List<RestPaymentsReceivedModel> restPaymentsReceivedModel) {

		logger.info("Method : addpaymentsreceived starts");

		logger.info("RestPaymentsReceivedModel" + restPaymentsReceivedModel);
		JsonResponse<List<RestPaymentsReceivedModel>> resp = new JsonResponse<List<RestPaymentsReceivedModel>>();
		List<RestPaymentsReceivedModel> listData = new ArrayList<RestPaymentsReceivedModel>();

		try {
			String values = GenerateSalesPaymentsReceivedParameter.getAddParam(restPaymentsReceivedModel);

			if (restPaymentsReceivedModel.get(0).getPaymentId() == null
					|| restPaymentsReceivedModel.get(0).getPaymentId() == "") {
				logger.info("ADDDDDDDDDDDDDDDDDDS#" + values);

				List<Object[]> x = em.createNamedStoredProcedureQuery("salesPaymentreceivedRotines")
						.setParameter("actionType", "addpaymentsreceived").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {

						RestPaymentsReceivedModel dropDownModel = new RestPaymentsReceivedModel(null,null, m[0], m[1],
								null, m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], null,m[11],m[12]);
						
						
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				logger.info("@modifyyyyyyyyyyyyyy" + values);

				List<Object[]> x = em.createNamedStoredProcedureQuery("salesPaymentreceivedRotines")
						.setParameter("actionType", "modifypaymentsreceived").setParameter("actionValue", values)
						.getResultList();

				try {
					for (Object[] m : x) {

						RestPaymentsReceivedModel dropDownModel = new RestPaymentsReceivedModel(null,null, m[0], m[1],
								null, m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], null,m[11],m[12]);
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("modify printttttttttttttttttt" + listData);

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
		ResponseEntity<JsonResponse<List<RestPaymentsReceivedModel>>> response = new ResponseEntity<JsonResponse<List<RestPaymentsReceivedModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data issssssssssssssssssssss" + response);
		logger.info("Method : addpaymentsreceived ends");
		return response;
	}
	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesInvoicePaymentModel>>> viewsalespaymentsreceived(String orgName,String orgDiv,String fromdate,String todate) {
		logger.info("Method : viewsalespaymentsreceived Dao startssssssssssssssssssssss" + fromdate);

		List<RestSalesInvoicePaymentModel> getAllemployee = new ArrayList<RestSalesInvoicePaymentModel>();
		JsonResponse<List<RestSalesInvoicePaymentModel>> resp = new JsonResponse<List<RestSalesInvoicePaymentModel>>();
		
		String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_fromDate='" + fromdate + "',@p_toDate='" + todate + "';";
		System.out.println("value is coming for ==========================>"+value);
		logger.info(value);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesPaymentreceivedRotines")
					.setParameter("actionType", "viewsalespaymentsreceived").setParameter("actionValue", value)
					.getResultList();
			
			for (Object[] m : x) {

				Object createdOn = null;
				if (m[8] != null) {
					createdOn = m[8].toString();
				}

				RestSalesInvoicePaymentModel viewdemo = new RestSalesInvoicePaymentModel(m[0], m[1], m[2], m[3].toString(), m[4], m[5], m[6], m[7], m[8]);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestSalesInvoicePaymentModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesInvoicePaymentModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewsalespaymentsreceived Dao ends");
		logger.info("resp****************************" + response);
		return response;

	}
	
	//Edit 

		@SuppressWarnings("unchecked")
		public List<RestPaymentsReceivedModel> viewPaymentReceivedEdit(String id) {
			logger.info("Method : viewPaymentReceivedEdit starts");
			logger.info("restPaymentsReceivedModel" + id);
			// JsonResponse<List<RestQuotationNewModel>> resp = new
			// JsonResponse<List<RestQuotationNewModel>>();
			List<RestPaymentsReceivedModel> getRequisitionTypeList = new ArrayList<RestPaymentsReceivedModel>();
			List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
			try {
				String values = "SET @p_paymentId='" + id + "';";
				logger.info(values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesPaymentreceivedRotines")
						.setParameter("actionType", "viewPaymentReceivedEdit").setParameter("actionValue", values).getResultList();
				try {
					for (Object[] m : x) {

						
						 Object DATE = null; 
						 if (m[12] != null) 
						 {
							 DATE = m[12].toString();
						 }
						 
						 RestPaymentsReceivedModel dropDownModel = new RestPaymentsReceivedModel(null,m[0], m[1], m[2],
									m[3], m[4],m[5], m[6], m[7], m[8],m[9], m[10], m[11],null,DATE,m[13],m[14]);
						getRequisitionTypeList.add(dropDownModel);
						logger.info("print edit" + getRequisitionTypeList);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getPaymentId()
							+ "';";
					List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesPaymentreceivedRotines")
							.setParameter("actionType", "getVendorDocs").setParameter("actionValue", subValues)
							.getResultList();
					for (Object[] m : x1) {

						InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2]);
						docList.add(dropDownModel);
					}
				} catch (Exception e) {

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			getRequisitionTypeList.get(0).setDocumentList(docList);
			// resp.setBody(getRequisitionTypeList);
			logger.info("@@@@@@@@edit" + getRequisitionTypeList);
			logger.info("Method : viewPaymentReceivedEdit ends");
			return getRequisitionTypeList;
		}
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getpayment() {
			logger.info("Method : getpayment starts");

			List<DropDownModel> itemList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("salesPaymentreceivedRotines")
						.setParameter("actionType", "getpayment").setParameter("actionValue", "")
						.getResultList();

				Object jobId = x.get(0);
				logger.info("job id--------" + jobId);
				

				DropDownModel dropDownModel = new DropDownModel(jobId.toString(),null);

				itemList.add(dropDownModel);
				resp.setBody(itemList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);
			//logger.info("response for getting job card id -------" + response);
			logger.info("Method : getpayment ends");
			return response;
		}
	
		public ResponseEntity<JsonResponse<Object>> deletPayment(String id) {
			logger.info("Method : deletPayment starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_paymentId='" + id + "';";

					em.createNamedStoredProcedureQuery("salesPaymentreceivedRotines").setParameter("actionType", "deletPayment")
							.setParameter("actionValue", value).execute();

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

			logger.info("Method : deletPayment ends");
			logger.info("DELETEE" + response);
			return response;
		}

		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getPaymentInsertedId() {
			logger.info("Method : getPaymentInsertedId starts");

			List<DropDownModel> itemList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("salesPaymentreceivedRotines")
						.setParameter("actionType", "getPaymentInsertedId").setParameter("actionValue", "")
						.getResultList();

				Object jobId = x.get(0);
				logger.info("job id--------" + jobId);

				DropDownModel dropDownModel = new DropDownModel(jobId, null);

				itemList.add(dropDownModel);
				resp.setBody(itemList);
			} catch (Exception e) {
				e.printStackTrace();
			}

			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);
			// logger.info("response for getting job card id -------" + response);
			logger.info("Method : getPaymentInsertedId ends");
			return response;
		}
		
		public JsonResponse<RestSalesInvoicePaymentModel> saveBulkPayment(String userId, String bulkAmount, String orgName, String orgDivision) {
			logger.info("Method : saveBulkPayment starts");

			JsonResponse<RestSalesInvoicePaymentModel> resp = new JsonResponse<RestSalesInvoicePaymentModel>();
			try {

				String value = "SET @p_userId='" + userId + "',@p_orgName='" + orgName + "',@p_orgDiv='"
						+ orgDivision + "',@p_bulkAmount='" + bulkAmount + "';";
				System.out.println("value===" + value);
				em.createNamedStoredProcedureQuery("salesPaymentreceivedRotines").setParameter("actionType", "addBulkAmount")
						.setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Status rejected successfully");

			} catch (Exception e) {

				e.printStackTrace();
			}
			System.out.println("resp===" + resp);
			logger.info("Method : saveBulkPayment ends");
			return resp;
		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getReceiveDetailsModal(String paymentId,String orgName,String orgDivision) {
			logger.info("Method : getReceiveDetailsModal Dao startssssssssssssssssssssss");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String values = "SET @p_paymentId='" + paymentId + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println(values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesRoutines")
						.setParameter("actionType", "receivePayment").setParameter("actionValue", values)
						.getResultList();

				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getReceiveDetailsModal Dao ends" + resp);
			return resp;

		}
		
}
