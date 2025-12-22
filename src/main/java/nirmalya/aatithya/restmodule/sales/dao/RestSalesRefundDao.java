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
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateSalesRefundParameter;
import nirmalya.aatithya.restmodule.sales.model.RestSalesRefundModel;
@Repository
public class RestSalesRefundDao {
	Logger logger = LoggerFactory.getLogger(RestSalesRefundDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesorderListt(String id,String type) {

		logger.info("Method : getSalesorderListt starts");
		List<DropDownModel> salesInvoiceList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_customerId='" + id + "',@p_type='" + type + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesRefund")
					.setParameter("actionType", "getSalesorderListt").setParameter("actionValue", value)
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
		logger.info("Method : getSalesorderListt ends");
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPaymentModeLists() {
		logger.info("Method : getPaymentModeLists starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesRefund")
					.setParameter("actionType", "getPaymentModeLists").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPaymentModeLists ends");
		return getCollectionList;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRefundInsertedId() {
		logger.info("Method : getRefundInsertedId starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesRefund")
					.setParameter("actionType", "getRefundInsertedId").setParameter("actionValue", "")
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
		logger.info("Method : getRefundInsertedId ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesRefundModel>>> addrefundnew(
			List<RestSalesRefundModel> restSalesRefundModel) {

		logger.info("Method : addrefundnew starts");

		JsonResponse<List<RestSalesRefundModel>> resp = new JsonResponse<List<RestSalesRefundModel>>();
		List<RestSalesRefundModel> listData = new ArrayList<RestSalesRefundModel>();

		logger.info("=====>>>>>"+restSalesRefundModel);
		
		try {
			String values = GenerateSalesRefundParameter.getAddempParam(restSalesRefundModel);

			if (restSalesRefundModel.get(0).getRefundId() == null
					|| restSalesRefundModel.get(0).getRefundId() == "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery("salesRefund")
						.setParameter("actionType", "addrefundnew").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {
						/*
						 * Object DATE = null; if (m[4] != null) { DATE = m[4].toString(); }
						 */

						RestSalesRefundModel dropDownModel = new RestSalesRefundModel(m[0],null,m[1], null, 
								null,m[2], null, m[3],null, m[4], m[5], m[6], null, null);
						
						
						
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				logger.info("@addd" + listData);
			} else {
				logger.info("@modify" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesRefund")
						.setParameter("actionType", "modifyrefundnew").setParameter("actionValue", values)
						.getResultList();

				try {
					for (Object[] m : x) {
						/*
						 * Object DATE = null; if (m[4] != null) { DATE = m[4].toString(); }
						 */

						RestSalesRefundModel dropDownModel = new RestSalesRefundModel(m[0],null,m[1], null, 
								null,m[2], null, m[3],null, m[4], m[5], m[6], null, null);
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				logger.info("print in modify block" + listData);
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
		ResponseEntity<JsonResponse<List<RestSalesRefundModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesRefundModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addrefundnew ends");
		return response;
	}

	
	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesRefundModel>>> viewsalesRefund() {
		logger.info("Method : viewsalesRefund Dao startssssssssssssssssssssss");

		List<RestSalesRefundModel> getAllemployee = new ArrayList<RestSalesRefundModel>();
		JsonResponse<List<RestSalesRefundModel>> resp = new JsonResponse<List<RestSalesRefundModel>>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesRefund")
					.setParameter("actionType", "viewsalesRefund").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {

				Object createdOn = null;
				if (m[4] != null) {
					createdOn = m[4].toString();
				}

				RestSalesRefundModel viewdemo = new RestSalesRefundModel(m[0],m[1],
						m[2], m[3], createdOn, m[5], m[6] );
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestSalesRefundModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesRefundModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewsalesRefund Dao ends");
		logger.info("resp****************************" + response);
		return response;

	}
	
	
	//Edit 

		@SuppressWarnings("unchecked")
		public List<RestSalesRefundModel> viewRefundEdit(String id) {
			logger.info("Method : viewRefundEdit starts");
			logger.info("restSalesRefundModel" + id);
			// JsonResponse<List<RestQuotationNewModel>> resp = new
			// JsonResponse<List<RestQuotationNewModel>>();
			List<RestSalesRefundModel> getRequisitionTypeList = new ArrayList<RestSalesRefundModel>();

			try {
				String values = "SET @p_refundId='" + id + "';";
				logger.info(values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesRefund")
						.setParameter("actionType", "viewRefundEdit").setParameter("actionValue", values).getResultList();
				try {
					for (Object[] m : x) {

						
						 Object DATE = null; 
						 if (m[4] != null) 
						 {
							 DATE = m[4].toString();
						 }
						 
						 RestSalesRefundModel dropDownModel = new RestSalesRefundModel(m[0],null,m[1], null, 
									null,m[2], m[3],null,DATE, m[5], m[6], m[7], null, null,m[8],m[9],m[10],m[11],m[12],m[13],
											m[14],m[15],m[16],m[17],m[18],m[19],m[20],m[21],m[22],m[23],m[24],m[25],m[26]);
						 
						
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
			logger.info("Method : viewRefundEdit ends");
			return getRequisitionTypeList;
		}
		
		public ResponseEntity<JsonResponse<Object>> deletRefund(String id) {
			logger.info("Method : deletRefund starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_refundId='" + id + "';";

					em.createNamedStoredProcedureQuery("salesRefund").setParameter("actionType", "deletRefund")
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

			logger.info("Method : deletRefund ends");
			logger.info("DELETEE" + response);
			return response;
		}


	
}
