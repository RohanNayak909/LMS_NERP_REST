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
import nirmalya.aatithya.restmodule.common.utils.GenerateCRMInvoiceParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmInvoiceModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;

@Repository
public class RestCrmInvoiceDao {
	
	Logger logger = LoggerFactory.getLogger(RestCrmDealDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	//addCRMInvoice   
		@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<RestCrmInvoiceModel>>> addCRMInvoice(
					List<RestCrmInvoiceModel> restCrmInvoiceModel) {
			logger.info("rest controller--------------DAO------------------addCRMInvoice");
				logger.info("Method : addCRMInvoice starts");

				JsonResponse<List<RestCrmInvoiceModel>> resp = new JsonResponse<List<RestCrmInvoiceModel>>();
				List<RestCrmInvoiceModel> listData = new ArrayList<RestCrmInvoiceModel>();

				try {
					//String values = "";
					String values = GenerateCRMInvoiceParameter.getAddParam(restCrmInvoiceModel);
					logger.info("rest controller--------------DAO-------values-----------addCRMPurchaseOrder"+values);
					if (restCrmInvoiceModel.get(0).getInvoiceId() == null
							|| restCrmInvoiceModel.get(0).getInvoiceId() == "") { 

						List<Object[]> x = em.createNamedStoredProcedureQuery("crmInvoiceRoutines")
								.setParameter("actionType", "addInvoice").setParameter("actionValue", values)
								.getResultList();
						try {
							for (Object[] m : x) {

								Object invDate = null;
								if (m[5] != null) {
									invDate = m[5].toString();
								}
								
								Object DueDate = null;
								if (m[7] != null) {
									DueDate = m[7].toString();
								}
								RestCrmInvoiceModel dropDownModel = new RestCrmInvoiceModel(m[0], m[1], m[2], m[3], 
										m[4], invDate,m[6], DueDate, m[8], m[9], m[10], m[11], m[12], m[13], m[14], 
										m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
										m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
										m[35],m[36], m[37], m[38], m[39],  m[40], m[41], m[42],m[43]);
								listData.add(dropDownModel);
								logger.info("salesOrder edit--------------------------------------" + listData);

							}
						} catch (Exception e) {
							e.printStackTrace();
						}

						logger.info("@addd" + listData);
					} else {
						logger.info("@modify----------------------------------------------------------" + values);
						List<Object[]> x = em.createNamedStoredProcedureQuery("crmInvoiceRoutines")
								.setParameter("actionType", "modifyInvoice").setParameter("actionValue", values)
								.getResultList();

						try {
							for (Object[] m : x) {

								Object invDate = null;
								if (m[5] != null) {
									invDate = m[5].toString();
								}
								
								Object DueDate = null;
								if (m[7] != null) {
									DueDate = m[7].toString();
								}
								RestCrmInvoiceModel dropDownModel = new RestCrmInvoiceModel(m[0], m[1], m[2], m[3], 
										m[4], invDate,m[6], DueDate, m[8], m[9], m[10], m[11], m[12], m[13], m[14], 
										m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
										m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
										m[35],m[36], m[37], m[38], m[39],  m[40], m[41], m[42],m[43]);
								listData.add(dropDownModel);
								logger.info("salesOrder edit--------------------------------------" + listData);

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
				ResponseEntity<JsonResponse<List<RestCrmInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmInvoiceModel>>>(
						resp, HttpStatus.CREATED);
				logger.info("response data is" + response);
				logger.info("Method : addCRMInvoice ends");
				return response;
			}
		

		
		//viewCRMInvoice
		

		@SuppressWarnings("unchecked")
			public JsonResponse<List<RestCrmInvoiceModel>> viewCRMInvoice() {
				logger.info("Method : All viewCRMInvoice Dao starts");

				List<RestCrmInvoiceModel> getAllemployee = new ArrayList<RestCrmInvoiceModel>();
				JsonResponse<List<RestCrmInvoiceModel>> resp = new JsonResponse<List<RestCrmInvoiceModel>>();

				try {

					List<Object[]> x = em.createNamedStoredProcedureQuery("crmInvoiceRoutines")
							.setParameter("actionType", "viewInvoice").setParameter("actionValue", "").getResultList();

					for (Object[] m : x) {
						Object INVDATE = null;
						if (m[2] != null) {
							INVDATE = m[2].toString();
						}
						
						Object DATE = null;
						if (m[7] != null) {
							DATE = m[7].toString();
						}
						
						RestCrmInvoiceModel viewdemo = new RestCrmInvoiceModel(m[0], m[1],INVDATE, m[3], 
								m[4], m[5], m[6],  DATE, m[8]);
						getAllemployee.add(viewdemo);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				resp.setBody(getAllemployee);
				logger.info("Method : viewCRMInvoice Dao ends");

				return resp;

			}
		
		//viewCRMInvoiceEdit
		

@SuppressWarnings("unchecked")
	public List<RestCrmInvoiceModel> viewCRMInvoiceEdit(String id) {
		logger.info("Method : viewCRMInvoiceEdit starts");
		List<RestCrmInvoiceModel> getRequisitionTypeList = new ArrayList<RestCrmInvoiceModel>();

		try {
			String values = "SET @p_invoiceId='" + id + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmInvoiceRoutines")
					.setParameter("actionType", "getInvoiceEdit").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {

					Object invDate = null;
					if (m[5] != null) {
						invDate = m[5].toString();
					}
					
					Object DueDate = null;
					if (m[7] != null) {
						DueDate = m[7].toString();
					}
					RestCrmInvoiceModel dropDownModel = new RestCrmInvoiceModel(m[0], m[1], m[2], m[3], 
							m[4], invDate,m[6], DueDate, m[8], m[9], m[10], m[11], m[12], m[13], m[14], 
							m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
							m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
							m[35],m[36], m[37], m[38], m[39],  m[40], m[41], m[42],m[43]);
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
		logger.info("Method : viewCRMInvoiceEdit ends");
		return getRequisitionTypeList;
	}


/*
 * delete deleteCRMInvoice
 */

	public ResponseEntity<JsonResponse<Object>> deleteCRMInvoice(RestCrmInvoiceModel restCrmInvoiceModel) {
		logger.info("Method : deleteCRMInvoice starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		
		try {
			//String value = GenerateCRMQuoteParameter.getDeleteParam(restCrmSalesOrderModel);
			String value = GenerateCRMInvoiceParameter.getDeleteParam(restCrmInvoiceModel);
			logger.info(value);
			em.createNamedStoredProcedureQuery("crmInvoiceRoutines")
					.setParameter("actionType", "deleteCRMInvoice").setParameter("actionValue", value).execute();
			logger.info("print block" + restCrmInvoiceModel);
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
		logger.info("@@@@@@@@@@@@@@@@" + restCrmInvoiceModel);
		logger.info("Method : deleteCRMInvoice ends");
		return response;
	}
	
	//viewInvoiceInfo

@SuppressWarnings("unchecked")
public ResponseEntity<JsonResponse<List<RestCrmInvoiceModel>>>viewInvoiceInfo(String id) {
	logger.info("Method : viewInvoiceInfo starts");

	JsonResponse<List<RestCrmInvoiceModel>> resp = new JsonResponse<List<RestCrmInvoiceModel>>();
	List<RestCrmInvoiceModel> rs = new ArrayList<RestCrmInvoiceModel>();

	try {

		String value = "SET @p_invoiceId='" + id + "';";
		logger.info(value);

		List<Object[]> x = em.createNamedStoredProcedureQuery("crmInvoiceRoutines")
				.setParameter("actionType", "viewInvoiceInfo").setParameter("actionValue", value).getResultList();
		logger.info("asdfasdf"+x);
       
		for (Object[] m : x) {
			Object invDate = null;
			if (m[5] != null) {
				invDate = m[5].toString();
			}
			
			Object DueDate = null;
			if (m[7] != null) {
				DueDate = m[7].toString();
			}
			RestCrmInvoiceModel assignSkill = new RestCrmInvoiceModel(m[0], m[1], m[2], m[3], 
					m[4], invDate,m[6], DueDate, m[8], m[9], m[10], m[11], m[12], m[13], m[14], 
					m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
					m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
					m[35],m[36], m[37], m[38], m[39],  m[40], m[41], m[42],m[43]);
			
			rs.add(assignSkill);
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
resp.setBody(rs);
	HttpHeaders responseHeaders = new HttpHeaders();
	responseHeaders.set("MyResponseHeader", "MyValue");

	ResponseEntity<JsonResponse<List<RestCrmInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmInvoiceModel>>>(resp,responseHeaders,
			HttpStatus.CREATED);

	logger.info("Method : viewInvoiceInfo ends");
	return response;
}

////viewInvoiceMailInfo


@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>viewInvoiceMailInfo(String id) {
		logger.info("Method : viewInvoiceMailInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();

		try {

			String value = "SET @p_invoiceId='" + id +"';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmInvoiceRoutines")
					.setParameter("actionType", "viewInvoiceMailInfo").setParameter("actionValue", value).getResultList();
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

		logger.info("Method : viewInvoiceMailInfo ends");
		return response;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse viewCrmInvoices(String id) {
		logger.info("Method : viewCrmInvoices starts");
		JsonResponse  jsonResp = new JsonResponse();	
		
		String value = "SET @p_id='" + id + "';";
		try {
		
			List<Object> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewCrmInvoices").setParameter("actionValue", value).getResultList();
			
			jsonResp.setMessage("Invoice View Sucessfully");
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
		
		logger.info("Method : viewCrmInvoices ends");
		return jsonResp;
	}

}
