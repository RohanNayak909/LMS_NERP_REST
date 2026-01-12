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
import nirmalya.aatithya.restmodule.common.utils.GenerateCRMSalesOrderParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmSalesOrderModel;

@Repository
public class RestSalesOrderDao {
	
	Logger logger = LoggerFactory.getLogger(RestCrmDealDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	//addCRMSalesOrder
	@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestCrmSalesOrderModel>>> addCRMSalesOrder(
				List<RestCrmSalesOrderModel> restCrmSalesOrderModel) {
		logger.info("rest controller--------------DAO------------------addCRMSalesOrder");
			logger.info("Method : addCRMQuotation starts");

			JsonResponse<List<RestCrmSalesOrderModel>> resp = new JsonResponse<List<RestCrmSalesOrderModel>>();
			List<RestCrmSalesOrderModel> listData = new ArrayList<RestCrmSalesOrderModel>();

			try {
				//String values = "";
				String values = GenerateCRMSalesOrderParameter.getAddParam(restCrmSalesOrderModel);
				logger.info("rest controller--------------DAO-------values-----------addCRMSalesOrder"+values);
				if (restCrmSalesOrderModel.get(0).getSoId() == null
						|| restCrmSalesOrderModel.get(0).getSoId() == "") { 

					List<Object[]> x = em.createNamedStoredProcedureQuery("crmSalesOrderRoutines")
							.setParameter("actionType", "addsalesorder").setParameter("actionValue", values)
							.getResultList();
					logger.info("hello add for quotation-----------------------------------addquote");
					try {
						for (Object[] m : x) {
							Object DueDate = null;
							if (m[6] != null) {
								DueDate = m[6].toString();
							}

							RestCrmSalesOrderModel dropDownModel = new RestCrmSalesOrderModel(m[0], m[1], m[2], m[3], 
							m[4], m[5], DueDate, m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], 
							m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
							m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
							m[35],m[36], m[37], m[38], m[39],  m[40], m[41], m[42], m[43],  m[44], m[45],
							m[46],m[47],m[48]);
							listData.add(dropDownModel);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					logger.info("@addd" + listData);
				} else {
					logger.info("@modify----------------------------------------------------------" + values);
					List<Object[]> x = em.createNamedStoredProcedureQuery("crmSalesOrderRoutines")
							.setParameter("actionType", "modifysalesorder").setParameter("actionValue", values)
							.getResultList();

					try {
						for (Object[] m : x) {
							Object DueDate = null;
							if (m[6] != null) {
								DueDate = m[6].toString();
							}

							RestCrmSalesOrderModel dropDownModel = new RestCrmSalesOrderModel(m[0], m[1], m[2], m[3], 
							m[4], m[5], DueDate, m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], 
							m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
							m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
							m[35],m[36], m[37], m[38], m[39],  m[40], m[41], m[42], m[43],  m[44],
							m[45],m[46],m[47],m[48]);
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
			ResponseEntity<JsonResponse<List<RestCrmSalesOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmSalesOrderModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("response data is" + response);
			logger.info("Method : addCRMSalesOrder ends");
			return response;
		}
	
	
	//getAllCRMSalesOrder

	@SuppressWarnings("unchecked")
		public JsonResponse<List<RestCrmSalesOrderModel>> getAllCRMSalesOrder() {
			logger.info("Method : All getAllCRMSalesOrder Dao starts");

			List<RestCrmSalesOrderModel> getAllemployee = new ArrayList<RestCrmSalesOrderModel>();
			JsonResponse<List<RestCrmSalesOrderModel>> resp = new JsonResponse<List<RestCrmSalesOrderModel>>();

			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("crmSalesOrderRoutines")
						.setParameter("actionType", "viewSalesOrder").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					Object DATE = null;
					if (m[8] != null) {
						DATE = m[8].toString();
					}
					
					RestCrmSalesOrderModel viewdemo = new RestCrmSalesOrderModel(m[0], m[1], m[2], m[3], 
							m[4], m[5], m[6], m[7], DATE);
					getAllemployee.add(viewdemo);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			resp.setBody(getAllemployee);
			logger.info("Method : getAllCRMSalesOrder Dao ends");

			return resp;

		}
		
	//viewCRMSalesOrderEdit
	

@SuppressWarnings("unchecked")
	public List<RestCrmSalesOrderModel> viewCRMSalesOrderEdit(String id) {
		logger.info("Method : viewCRMSalesOrderEdit starts");
		logger.info("restQuotationNewModel" + id);
		// JsonResponse<List<RestQuotationNewModel>> resp = new
		// JsonResponse<List<RestQuotationNewModel>>();
		List<RestCrmSalesOrderModel> getRequisitionTypeList = new ArrayList<RestCrmSalesOrderModel>();

		try {
			String values = "SET @p_soId='" + id + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmSalesOrderRoutines")
					.setParameter("actionType", "getSalesOrderEdit").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {

					Object DueDate = null;
					if (m[6] != null) {
						DueDate = m[6].toString();
					}
					RestCrmSalesOrderModel dropDownModel = new RestCrmSalesOrderModel(m[0], m[1], m[2], m[3], 
							m[4], m[5], DueDate, m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], 
							m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
							m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
							m[35],m[36], m[37], m[38], m[39],  m[40], m[41], m[42], m[43],  m[44], 
							m[45],m[46],m[47],m[48]);
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
		logger.info("Method : viewCRMSalesOrderEdit ends");
		return getRequisitionTypeList;
	}



/*
	 * delete deleteCRMSalesOrder
	 */

public ResponseEntity<JsonResponse<Object>> deleteCRMSalesOrder(RestCrmSalesOrderModel restCrmSalesOrderModel) {
	logger.info("Method : deleteCRMSalesOrder starts");
	JsonResponse<Object> resp = new JsonResponse<Object>();
	resp.setMessage("");
	resp.setCode("");
    
	try {
		//String value = GenerateCRMQuoteParameter.getDeleteParam(restCrmSalesOrderModel);
		String value = GenerateCRMSalesOrderParameter.getDeleteParam(restCrmSalesOrderModel);
		logger.info(value);
		em.createNamedStoredProcedureQuery("crmSalesOrderRoutines")
				.setParameter("actionType", "deleteSalesOrder").setParameter("actionValue", value).execute();
		logger.info("print block" + restCrmSalesOrderModel);
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
	logger.info("@@@@@@@@@@@@@@@@" + restCrmSalesOrderModel);
	logger.info("Method : deleteCRMSalesOrder ends");
	return response;
}


//viewSOInfo


@SuppressWarnings("unchecked")
public ResponseEntity<JsonResponse<List<RestCrmSalesOrderModel>>>viewSOInfo(String id) {
	logger.info("Method : viewSOInfo starts");

	JsonResponse<List<RestCrmSalesOrderModel>> resp = new JsonResponse<List<RestCrmSalesOrderModel>>();
	List<RestCrmSalesOrderModel> rs = new ArrayList<RestCrmSalesOrderModel>();

	try {

		String value = "SET @p_soId='" + id + "';";
		logger.info(value);

		List<Object[]> x = em.createNamedStoredProcedureQuery("crmSalesOrderRoutines")
				.setParameter("actionType", "viewSOInfo").setParameter("actionValue", value).getResultList();
		logger.info("asdfasdf"+x);
       
		for (Object[] m : x) {
			Object DueDate = null;
			if (m[6] != null) {
				DueDate = m[6].toString();
			}

			RestCrmSalesOrderModel assignSkill = new RestCrmSalesOrderModel(m[0], m[1], m[2], m[3], 
					m[4], m[5], DueDate, m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], 
					m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
					m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
					m[35],m[36], m[37], m[38], m[39],  m[40], m[41], m[42], m[43],  m[44], m[45],m[46],m[47],m[48]);
			rs.add(assignSkill);
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
resp.setBody(rs);
	HttpHeaders responseHeaders = new HttpHeaders();
	responseHeaders.set("MyResponseHeader", "MyValue");

	ResponseEntity<JsonResponse<List<RestCrmSalesOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmSalesOrderModel>>>(resp,responseHeaders,
			HttpStatus.CREATED);

	logger.info("Method : viewSOInfo ends");
	return response;
}

//viewSOMailInfo


@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>viewSOMailInfo(String id) {
		logger.info("Method : viewSOMailInfo starts----------------------------");
		logger.info("note-----------------------------------------------------------------");
		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();

		try {

			String value = "SET @p_soId='" + id +"';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmSalesOrderRoutines")
					.setParameter("actionType", "viewSOMailInfo").setParameter("actionValue", value).getResultList();
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

		logger.info("Method : viewLeadMailInfo ends");
		return response;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse viewCrmSalesOrderDetails(String id) {
		logger.info("Method : viewCrmSalesOrderDetails starts");
		JsonResponse  jsonResp = new JsonResponse();	
		
		String value = "SET @p_id='" + id + "';";
		try {
		
			List<Object> x = em.createNamedStoredProcedureQuery("crm_contact")
					.setParameter("actionType", "viewCrmSalesOrder").setParameter("actionValue", value).getResultList();
			
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
		
		logger.info("Method : viewCrmSalesOrderDetails ends");
		return jsonResp;
	}

}
