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
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateSalesReturnParameter;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesReturnModel;

@Repository
public class RestSalesReturnDao {
	Logger logger = LoggerFactory.getLogger(RestSalesReturnDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesorderList1(String id,String type) {

		logger.info("Method : getSalesorderList1 starts");
		List<DropDownModel> salesOrderList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_customerId='" + id + "',@p_type='" + type + "';";
		logger.info("++++++++++++++++++++++++++"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesReturn")
					.setParameter("actionType", "getSalesorderList1").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				salesOrderList.add(dropDownModel);
				//logger.info("stateeeeeeeeeee"+dropDownModel);
			}

			resp.setBody(salesOrderList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		//logger.info("stateeeeeeeeeee"+response);
		logger.info("Method : getSalesorderList1 ends");
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getReturnList() {
		logger.info("Method : getReturnList starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesReturn")
					.setParameter("actionType", "getReturnList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getReturnList ends");
		return getCollectionList;
	}
	
	/*
	 * add
	 */
	public ResponseEntity<JsonResponse<List<RestSalesReturnModel>>> addsaleReturn(
			List<RestSalesReturnModel> restSalesReturnModel) {

		logger.info("Method : addsaleReturn starts");

		logger.info("RestSalesReturnModel" + restSalesReturnModel);
		JsonResponse<List<RestSalesReturnModel>> resp = new JsonResponse<List<RestSalesReturnModel>>();
		List<RestSalesReturnModel> listData = new ArrayList<RestSalesReturnModel>();

		try {
			String values = GenerateSalesReturnParameter.getAddSaleReturn(restSalesReturnModel);

			if (restSalesReturnModel.get(0).getSaleReturnId() == null
					|| restSalesReturnModel.get(0).getSaleReturnId() == "") {
				logger.info("ADDDDDDDDDDDDDDDDDDS#" + values);

				 em.createNamedStoredProcedureQuery("salesReturn")
						.setParameter("actionType", "addsaleReturn").setParameter("actionValue", values)
						.execute();
				

			} else {
				logger.info("@modifyyyyyyyyyyyyyy" + values);

			 em.createNamedStoredProcedureQuery("salesReturn")
						.setParameter("actionType", "modifysaleReturn").setParameter("actionValue", values)
						.execute();
                  //logger.info("modify printttttttttttttttttt" + listData);

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
		ResponseEntity<JsonResponse<List<RestSalesReturnModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesReturnModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data issssssssssssssssssssss" + response);
		logger.info("Method : addsaleReturn ends");
		return response;
	}
	
	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesReturnModel>>> viewsalesreturn() {
		logger.info("Method : viewsalesreturn Dao startssssssssssssssssssssss");

		List<RestSalesReturnModel> getAllemployee = new ArrayList<RestSalesReturnModel>();
		JsonResponse<List<RestSalesReturnModel>> resp = new JsonResponse<List<RestSalesReturnModel>>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesReturn")
					.setParameter("actionType", "viewsalesreturn").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {

				Object createdOn = null;
				if (m[4] != null) {
					createdOn = m[4].toString();
				}

				RestSalesReturnModel viewdemo = new RestSalesReturnModel(m[0], m[1], m[2], m[3], createdOn,
						m[5], m[6],m[7],m[8],m[9]);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestSalesReturnModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesReturnModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewsalesreturn Dao ends");
		logger.info("resp****************************" + response);
		return response;

	}
	
	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestSalesReturnModel> viewSalesreturnEdit(String id) {
		logger.info("Method : viewSalesreturnEdit starts");
		// logger.info("RestDeliveryChallanModel" + id);
		List<RestSalesReturnModel> getRequisitionTypeList = new ArrayList<RestSalesReturnModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_saleReturnId='" + id + "';";
			// logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesReturn")
					.setParameter("actionType", "viewSalesreturnEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					Object createdOn = null;
					if (m[4] != null) {
						createdOn = m[4].toString();
					}

					RestSalesReturnModel dropDownModel = new RestSalesReturnModel(m[0], m[1],
							m[2], m[3],createdOn, m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14],
							m[15], m[16], m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], null,
							m[26], m[27], m[28], m[29],null,m[30],m[31],m[32],m[33],null,m[34],m[35]);
					getRequisitionTypeList.add(dropDownModel);
					// logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_returnId='" + getRequisitionTypeList.get(0).getSaleReturnId()
						+ "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesReturn")
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
		logger.info("========================edit" + getRequisitionTypeList);
		logger.info("Method : viewSalesreturnEdit ends");
		return getRequisitionTypeList;
	}

	
	/*delete
	 * 	
	 */
	public JsonResponse<Object> deleteSalesReturn(String id,String orgName, String orgDiv) {
		logger.info("Method : deleteSalesReturn Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("values****************************" + value);
			 em.createNamedStoredProcedureQuery("salesReturn")
					.setParameter("actionType", "deleteSalesReturn").setParameter("actionValue", value)
					.execute();
			 resp.setCode("success");
			 resp.setMessage("Deleted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : deleteSalesReturn Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesReturntInsertedId() {
			logger.info("Method : getSalesReturntInsertedId starts");

			List<DropDownModel> itemList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("salesReturn")
						.setParameter("actionType", "getSalesReturntInsertedId").setParameter("actionValue", "")
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
			logger.info("Method : getSalesReturntInsertedId ends");
			return response;
		}
		/*
		 * approveSalesReturn
		 */

		public ResponseEntity<JsonResponse<Object>> approveSalesReturn(RestSalesReturnModel req) {
			logger.info("Method : approveSalesReturn starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();
			logger.info("ADDDDDDDDDDDDD" + req.getApproveStatus());
			try {
				String values = GenerateSalesReturnParameter.getApproveSalesReturnParam(req);
				logger.info("ADDDDDDDDDDDDD" + values);
				if (req.getApproveStatus() != null || req.getApproveStatus() != "") {

					em.createNamedStoredProcedureQuery("salesReturn")
							.setParameter("actionType", "approveSalesReturn").setParameter("actionValue", values)
							.execute();
				}

			} catch

			(Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
			//logger.info("approveSalesReturn" + resp);

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);
			logger.info("approveInvoiceReturn" + response);

			logger.info("Method : approveSalesReturn ends");
			return response;
		}
		
}
