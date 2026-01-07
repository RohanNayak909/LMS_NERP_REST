package nirmalya.aatithya.restmodule.pipeline.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateCRMQuoteParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmLeadsModel;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmQuoteModel;

@Repository
public class RestQuoteDao {
	
	Logger logger = LoggerFactory.getLogger(RestCrmDealDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	//getItemQuoteAutoSearchList


@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmQuoteModel>>> getItemQuoteAutoSearchList(String id) {
		logger.info("Method : getItemQuoteAutoSearchList starts");
		List<RestCrmQuoteModel> itemNameList = new ArrayList<RestCrmQuoteModel>();
		JsonResponse<List<RestCrmQuoteModel>> resp = new JsonResponse<List<RestCrmQuoteModel>>();
		String value = "SET @p_searchValue='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmquotationRotines")
					.setParameter("actionType", "getitemquotationList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				RestCrmQuoteModel dropDownModel = new RestCrmQuoteModel(m[0], m[1], m[2], m[3]);
				itemNameList.add(dropDownModel);
			}
			logger.info("getAllItemList" + itemNameList);
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestCrmQuoteModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmQuoteModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemQuoteAutoSearchList ends");
		return response;
	}

	//getAllCRMQuotation

@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmQuoteModel>> getAllCRMQuotation() {
		logger.info("Method : All getAllCRMQuotation Dao starts");

		List<RestCrmQuoteModel> getAllemployee = new ArrayList<RestCrmQuoteModel>();
		JsonResponse<List<RestCrmQuoteModel>> resp = new JsonResponse<List<RestCrmQuoteModel>>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmquotationRotines")
					.setParameter("actionType", "viewquotation").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				Object DATE = null;
				if (m[7] != null) {
					DATE = m[7].toString();
				}
				
				logger.info("getAllemployee" + getAllemployee);
				RestCrmQuoteModel viewdemo = new RestCrmQuoteModel(m[0], m[1], m[2], m[3], 
						m[4], m[5], m[6], DATE);
				getAllemployee.add(viewdemo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setBody(getAllemployee);
		logger.info("Method : getAllCRMQuotation Dao ends");

		return resp;

	}

	//deleteCRMItemQuotation


/*
	 * delete
	 */

	public ResponseEntity<JsonResponse<Object>> deleteCRMItemQuotation(RestCrmQuoteModel deleteItemQuotation) {
		logger.info("Method : deleteCRMItemQuotation starts");
		logger.info("restQuotationNewModel" + deleteItemQuotation);
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GenerateCRMQuoteParameter.getDeleteParam(deleteItemQuotation);
			logger.info(value);
			em.createNamedStoredProcedureQuery("crmquotationRotines")
					.setParameter("actionType", "deleteQuotationItem").setParameter("actionValue", value).execute();
			logger.info("print block" + deleteItemQuotation);
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
		logger.info("@@@@@@@@@@@@@@@@" + deleteItemQuotation);
		logger.info("Method : deleteCRMItemQuotation ends");
		return response;
	}
	
	//viewCRMQuotationEdit
	

@SuppressWarnings("unchecked")
	public List<RestCrmQuoteModel> viewCRMQuotationEdit(String id) {
		logger.info("Method : viewCRMQuotationEdit starts");
		logger.info("restQuotationNewModel" + id);
		// JsonResponse<List<RestQuotationNewModel>> resp = new
		// JsonResponse<List<RestQuotationNewModel>>();
		List<RestCrmQuoteModel> getRequisitionTypeList = new ArrayList<RestCrmQuoteModel>();

		try {
			String values = "SET @p_quotationId='" + id + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crmquotationRotines")
					.setParameter("actionType", "getQuotationEdit").setParameter("actionValue", values).getResultList();
			try {
				for (Object[] m : x) {

					Object DATE = null;
					if (m[4] != null) {
						DATE = m[4].toString();
					}
					RestCrmQuoteModel dropDownModel = new RestCrmQuoteModel(m[0], m[1], m[2], m[3], 
							DATE, m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], 
							m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
							m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
							m[35],m[36], m[37], m[38], m[39],  m[40], m[41],m[42]);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("quotation edit--------------------------------------" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// resp.setBody(getRequisitionTypeList);
		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		logger.info("Method : viewCRMQuotationEdit ends");
		return getRequisitionTypeList;
	}

//addCRMQuotation
@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmQuoteModel>>> addCRMQuotation(
			List<RestCrmQuoteModel> restCrmQuoteModel) {
	logger.info("rest controller--------------DAO------------------addCRMQuotation");
		logger.info("Method : addCRMQuotation starts");

		JsonResponse<List<RestCrmQuoteModel>> resp = new JsonResponse<List<RestCrmQuoteModel>>();
		List<RestCrmQuoteModel> listData = new ArrayList<RestCrmQuoteModel>();

		try {
			//String values = GenerateQuotationNewParameter.getAddempParam(restCrmQuoteModel);
			String values = GenerateCRMQuoteParameter.getAddParam(restCrmQuoteModel);
			logger.info("rest controller--------------DAO-------values-----------addCRMQuotation"+values);
			if (restCrmQuoteModel.get(0).getQuotationId() == null
					|| restCrmQuoteModel.get(0).getQuotationId() == "") { 

				List<Object[]> x = em.createNamedStoredProcedureQuery("crmquotationRotines")
						.setParameter("actionType", "addquote").setParameter("actionValue", values)
						.getResultList();
				logger.info("hello add for quotation-----------------------------------addquote");
				try {
					for (Object[] m : x) {
						Object DATE = null;
						if (m[4] != null) {
							DATE = m[4].toString();
						}

						RestCrmQuoteModel dropDownModel = new RestCrmQuoteModel(m[0], m[1], m[2], m[3], 
								DATE, m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], 
								m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
								m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
								m[35],m[36], m[37], m[38], m[39],  m[40], m[41],m[42]);
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				logger.info("@addd" + listData);
			} else {
				logger.info("@modify----------------------------------------------------------" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("crmquotationRotines")
						.setParameter("actionType", "modifyquote").setParameter("actionValue", values)
						.getResultList();

				try {
					for (Object[] m : x) {
						Object DATE = null;
						if (m[4] != null) {
							DATE = m[4].toString();
						}

						RestCrmQuoteModel dropDownModel = new RestCrmQuoteModel(m[0], m[1], m[2], m[3], 
								DATE, m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], 
								m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
								m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
								m[35],m[36], m[37], m[38], m[39],  m[40], m[41],m[42]);
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
		ResponseEntity<JsonResponse<List<RestCrmQuoteModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmQuoteModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addCRMQuotation ends");
		return response;
	}

//viewQuoteInfo

@SuppressWarnings("unchecked")
public ResponseEntity<JsonResponse<List<RestCrmQuoteModel>>>viewQuoteInfo(String id) {
	logger.info("Method : viewQuoteInfo starts");

	JsonResponse<List<RestCrmQuoteModel>> resp = new JsonResponse<List<RestCrmQuoteModel>>();
	List<RestCrmQuoteModel> rs = new ArrayList<RestCrmQuoteModel>();

	try {

		String value = "SET @p_quotationId='" + id + "';";
		logger.info(value);

		List<Object[]> x = em.createNamedStoredProcedureQuery("crmquotationRotines")
				.setParameter("actionType", "viewQuoteDetailInfo").setParameter("actionValue", value).getResultList();
		logger.info("asdfasdf"+x);
       
		for (Object[] m : x) {
			Object DATE = null;
			if (m[4] != null) {
				DATE = m[4].toString();
			}

			RestCrmQuoteModel assignSkill = new RestCrmQuoteModel(m[0], m[1], m[2], m[3], 
					DATE, m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], 
					m[15],m[16], m[17], m[18], m[19],  m[20], m[21], m[22], m[23], m[24], 
					m[25],m[26], m[27], m[28], m[29],  m[30], m[31], m[32], m[33], m[34],
					m[35],m[36], m[37], m[38], m[39],  m[40], m[41],m[42]);
			rs.add(assignSkill);
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
resp.setBody(rs);
	HttpHeaders responseHeaders = new HttpHeaders();
	responseHeaders.set("MyResponseHeader", "MyValue");

	ResponseEntity<JsonResponse<List<RestCrmQuoteModel>>> response = new ResponseEntity<JsonResponse<List<RestCrmQuoteModel>>>(resp,responseHeaders,
			HttpStatus.CREATED);

	logger.info("Method : viewQuoteInfo ends");
	return response;
}

//viewQuoteMailInfo


@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestCrmLeadsModel>>>viewQuoteMailInfo(String id) {
		logger.info("Method : viewQuoteMailInfo starts----------------------------");
		logger.info("note-----123------------------------------------------------------------");
		JsonResponse<List<RestCrmLeadsModel>> resp = new JsonResponse<List<RestCrmLeadsModel>>();
		List<RestCrmLeadsModel> rs = new ArrayList<RestCrmLeadsModel>();

		try {

			String value = "SET @p_quoteId='" + id +"';";
			logger.info("rest quote-----------"+value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("crmquotationRotines")
					.setParameter("actionType", "viewQuoteMailInfo").setParameter("actionValue", value).getResultList();
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

		logger.info("Method : viewQuoteMailInfo ends");
		return response;
	}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public JsonResponse viewQuotes(String id) {
			logger.info("Method : viewQuotes starts");
			JsonResponse  jsonResp = new JsonResponse();	
			
			String value = "SET @p_id='" + id + "';";
			try {
				List<Object> x = em.createNamedStoredProcedureQuery("crm_contact")
						.setParameter("actionType", "viewCrmQuotes").setParameter("actionValue", value).getResultList();
				jsonResp.setMessage("Quotations View Sucessfully");
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
			
			
			
			logger.info("Method : viewQuotes ends");
			return jsonResp;
		}



}
