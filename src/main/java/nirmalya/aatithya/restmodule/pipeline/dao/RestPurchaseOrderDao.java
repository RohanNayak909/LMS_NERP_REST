package nirmalya.aatithya.restmodule.pipeline.dao;

import java.util.ArrayList;
import java.util.Arrays;
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
import nirmalya.aatithya.restmodule.common.utils.GenerateCRMPurchaseOrderParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmPurchaseOrderModel;

@Repository
public class RestPurchaseOrderDao {
	
	Logger logger = LoggerFactory.getLogger(RestCrmDealDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	//addCRMPurchaseOrder   
		@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<RestCrmPurchaseOrderModel>>> addCRMPurchaseOrder(
					List<RestCrmPurchaseOrderModel> restCrmPurchaseOrderModel) {
			logger.info("rest controller--------------DAO------------------addCRMPurchaseOrder");
				logger.info("Method : addCRMPurchaseOrder starts");

				JsonResponse<List<RestCrmPurchaseOrderModel>> resp = new JsonResponse<List<RestCrmPurchaseOrderModel>>();
				List<RestCrmPurchaseOrderModel> listData = new ArrayList<RestCrmPurchaseOrderModel>();

				try {
					//String values = "";
					String values = GenerateCRMPurchaseOrderParameter.getAddParam(restCrmPurchaseOrderModel);
					logger.info("rest controller--------------DAO-------values-----------addCRMPurchaseOrder"+values);
					if (restCrmPurchaseOrderModel.get(0).getPoId() == null
							|| restCrmPurchaseOrderModel.get(0).getPoId() == "") { 

						List<Object[]> x = em.createNamedStoredProcedureQuery("crmPurchaseOrderRoutines")
								.setParameter("actionType", "addPurchaseOrder").setParameter("actionValue", values)
								.getResultList();
						try {
							for (Object[] m : x) {

								Object poDate = null;
								if (m[10] != null) {
									poDate = m[10].toString();
								}
								
								Object DueDate = null;
								if (m[11] != null) {
									DueDate = m[11].toString();
								}
								RestCrmPurchaseOrderModel dropDownModel = new RestCrmPurchaseOrderModel(m[0], m[1], m[2], m[3], 
										m[4], m[5], m[6], m[7], m[8], m[9], poDate, DueDate, m[12], m[13], m[14], 
										m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
										m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
										m[35],m[36], m[37], m[38], m[39],  m[40], m[41], m[42], m[43],  m[44], m[45]);
								listData.add(dropDownModel);
								logger.info("purchaseOrder edit--------------------------------------" + listData);

							}
						} catch (Exception e) {
							e.printStackTrace();
						}

						logger.info("@addd" + listData);
					} else {
						logger.info("@modify----------------------------------------------------------" + values);
						List<Object[]> x = em.createNamedStoredProcedureQuery("crmPurchaseOrderRoutines")
								.setParameter("actionType", "modifyPurchaseOrder").setParameter("actionValue", values)
								.getResultList();

						

						try {
							for (Object[] m : x) {

								Object poDate = null;
								if (m[10] != null) {
									poDate = m[10].toString();
								}
								
								Object DueDate = null;
								if (m[11] != null) {
									DueDate = m[11].toString();
								}
								RestCrmPurchaseOrderModel dropDownModel = new RestCrmPurchaseOrderModel(m[0], m[1], m[2], m[3], 
										m[4], m[5], m[6], m[7], m[8], m[9], poDate, DueDate, m[12], m[13], m[14], 
										m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
										m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
										m[35],m[36], m[37], m[38], m[39],  m[40], m[41], m[42], m[43],  m[44], m[45]);
								listData.add(dropDownModel);
								logger.info("purchaseOrder edit--------------------------------------" + listData);

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
				ResponseEntity<JsonResponse<List<RestCrmPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmPurchaseOrderModel>>>(
						resp, HttpStatus.CREATED);
				logger.info("response data is" + response);
				logger.info("Method : addCRMPurchaseOrder ends");
				return response;
			}
		
		
		
		//viewCRMPurchaseOrder

		@SuppressWarnings("unchecked")
			public JsonResponse<List<RestCrmPurchaseOrderModel>> viewCRMPurchaseOrder() {
				logger.info("Method : All viewCRMPurchaseOrder Dao starts");

				List<RestCrmPurchaseOrderModel> getAllemployee = new ArrayList<RestCrmPurchaseOrderModel>();
				JsonResponse<List<RestCrmPurchaseOrderModel>> resp = new JsonResponse<List<RestCrmPurchaseOrderModel>>();

				try {

					List<Object[]> x = em.createNamedStoredProcedureQuery("crmPurchaseOrderRoutines")
							.setParameter("actionType", "viewPurchaseOrder").setParameter("actionValue", "").getResultList();

					for (Object[] m : x) {
						Object DATE = null;
						if (m[7] != null) {
							DATE = m[7].toString();
						}
						
						RestCrmPurchaseOrderModel viewdemo = new RestCrmPurchaseOrderModel(m[0], m[1], m[2], m[3], 
								m[4], m[5], m[6],  DATE);
						getAllemployee.add(viewdemo);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				resp.setBody(getAllemployee);
				logger.info("Method : viewCRMPurchaseOrder Dao ends");

				return resp;

			}
		
		
		
		/*
		 * delete deleteCRMPurchaseOrder
		 */

	public ResponseEntity<JsonResponse<Object>> deleteCRMPurchaseOrder(RestCrmPurchaseOrderModel restCrmPurchaseOrderModel) {
		logger.info("Method : deleteCRMPurchaseOrder starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
	    
		try {
			//String value = GenerateCRMQuoteParameter.getDeleteParam(restCrmSalesOrderModel);
			String value = GenerateCRMPurchaseOrderParameter.getDeleteParam(restCrmPurchaseOrderModel);
			logger.info(value);
			em.createNamedStoredProcedureQuery("crmPurchaseOrderRoutines")
					.setParameter("actionType", "deletePurchaseOrder").setParameter("actionValue", value).execute();
			logger.info("print block" + restCrmPurchaseOrderModel);
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
		logger.info("@@@@@@@@@@@@@@@@" + restCrmPurchaseOrderModel);
		logger.info("Method : deleteCRMPurchaseOrder ends");
		return response;
	}
	
	//viewCRMProductOrderEdit
	

@SuppressWarnings("unchecked")
	public List<RestCrmPurchaseOrderModel> viewCRMProductOrderEdit(String id) {
		logger.info("Method : viewCRMProductOrderEdit starts");
		List<RestCrmPurchaseOrderModel> getRequisitionTypeList = new ArrayList<RestCrmPurchaseOrderModel>();

		try {
			String values = "SET @p_poId='" + id + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmPurchaseOrderRoutines")
					.setParameter("actionType", "getPurchaseOrderEdit").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {

					Object poDate = null;
					if (m[10] != null) {
						poDate = m[10].toString();
					}
					
					Object DueDate = null;
					if (m[11] != null) {
						DueDate = m[11].toString();
					}
					RestCrmPurchaseOrderModel dropDownModel = new RestCrmPurchaseOrderModel(m[0], m[1], m[2], m[3], 
							m[4], m[5], m[6], m[7], m[8], m[9], poDate, DueDate, m[12], m[13], m[14], 
							m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
							m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
							m[35],m[36], m[37], m[38], m[39],  m[40], m[41], m[42], m[43],  m[44], m[45]);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("salesOrder edit--------------------------------------" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// resp.setBody(getRequisitionTypeList);
		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		logger.info("Method : viewCRMProductOrderEdit ends");
		return getRequisitionTypeList;
	}

//viewPOInfo


@SuppressWarnings("unchecked")
public ResponseEntity<JsonResponse<List<RestCrmPurchaseOrderModel>>>viewPOInfo(String id) {
	logger.info("Method : viewPOInfo starts");

	JsonResponse<List<RestCrmPurchaseOrderModel>> resp = new JsonResponse<List<RestCrmPurchaseOrderModel>>();
	List<RestCrmPurchaseOrderModel> rs = new ArrayList<RestCrmPurchaseOrderModel>();

	try {

		String value = "SET @p_poId='" + id + "';";
		logger.info(value);

		List<Object[]> x = em.createNamedStoredProcedureQuery("crmPurchaseOrderRoutines")
				.setParameter("actionType", "viewPOInfo").setParameter("actionValue", value).getResultList();
		logger.info("asdfasdf"+x);
       
		for (Object[] m : x) {
			Object poDate = null;
			if (m[10] != null) {
				poDate = m[10].toString();
			}
			
			Object DueDate = null;
			if (m[11] != null) {
				DueDate = m[11].toString();
			}
			RestCrmPurchaseOrderModel assignSkill = new RestCrmPurchaseOrderModel(m[0], m[1], m[2], m[3], 
					m[4], m[5], m[6], m[7], m[8], m[9], poDate, DueDate, m[12], m[13], m[14], 
					m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
					m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
					m[35],m[36], m[37], m[38], m[39],  m[40], m[41], m[42], m[43],  m[44], m[45]);
			rs.add(assignSkill);
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
resp.setBody(rs);
	HttpHeaders responseHeaders = new HttpHeaders();
	responseHeaders.set("MyResponseHeader", "MyValue");

	ResponseEntity<JsonResponse<List<RestCrmPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmPurchaseOrderModel>>>(resp,responseHeaders,
			HttpStatus.CREATED);

	logger.info("Method : viewPOInfo ends");
	return response;
}

///viewPOMailInfo


@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>viewPOMailInfo(String id) {
		logger.info("Method : viewPOMailInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();

		try {

			String value = "SET @p_poId='" + id +"';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmPurchaseOrderRoutines")
					.setParameter("actionType", "viewPOMailInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf"+x);
           
			for (Object[] m : x) {
							
				RestCrmLeadsModel assignSkill = new RestCrmLeadsModel(m[0].toString(), m[1], m[2], m[3], m[4], m[5], 
						m[6], m[7], m[8], m[9].toString(), m[10].toString(), m[11],null,null);
				rs.add(assignSkill);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
         resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>(resp,responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : viewPOMailInfo ends");
		return response;
	}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public JsonResponse viewCrmPoDetails(String id) {
			logger.info("Method : viewCrmPoDetails starts");
			JsonResponse  jsonResp = new JsonResponse();	
			
			String value = "SET @p_id='" + id + "';";
			try {
			
				List<Object> x = em.createNamedStoredProcedureQuery("crm_contact")
						.setParameter("actionType", "viewCrmPo").setParameter("actionValue", value).getResultList();
				
				jsonResp.setMessage("Po View Sucessfully");
				jsonResp.setCode("Success");
				jsonResp.setBody(x.get(0) != null ? new ArrayList(Arrays.asList(x.get(0))) : new ArrayList());
			
			}catch(Exception e){
				try {
					String[] err = serverDao.errorProcedureCall(e);
					jsonResp.setCode("Failed");
					jsonResp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			
			logger.info("Method : viewCrmPoDetails ends");
			return jsonResp;
		}

	
}
