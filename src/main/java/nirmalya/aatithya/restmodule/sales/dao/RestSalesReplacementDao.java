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
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateSalesReplacementParameter;
import nirmalya.aatithya.restmodule.sales.model.RestSalesReplacementModel;

@Repository
public class RestSalesReplacementDao {
	Logger logger = LoggerFactory.getLogger(RestSalesReplacementDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesorderListR(String id,String type) {

		logger.info("Method : getSalesorderListt starts");
		List<DropDownModel> salesOrderList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_customerId='" + id + "',@p_type='" + type + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesRepalcement")
					.setParameter("actionType", "getSalesorderListR").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				salesOrderList.add(dropDownModel);
				// logger.info("stateeeeeeeeeee"+dropDownModel);
			}

			resp.setBody(salesOrderList);

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
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getreplacementInsertedId() {
		logger.info("Method : getreplacementInsertedId starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesRepalcement")
					.setParameter("actionType", "getreplacementInsertedId").setParameter("actionValue", "")
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
		logger.info("Method : getreplacementInsertedId ends");
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesReplacementModel>>> addreplacementnew(
			List<RestSalesReplacementModel> restSalesReplacementModel) {

		logger.info("Method : addreplacementnew starts");

		JsonResponse<List<RestSalesReplacementModel>> resp = new JsonResponse<List<RestSalesReplacementModel>>();
		List<RestSalesReplacementModel> listData = new ArrayList<RestSalesReplacementModel>();

		logger.info("=====>>>>>"+restSalesReplacementModel);
		
		try {
			String values = GenerateSalesReplacementParameter.getAddempParam(restSalesReplacementModel);

			if (restSalesReplacementModel.get(0).getReplacementId() == null
					|| restSalesReplacementModel.get(0).getReplacementId() == "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery("salesRepalcement")
						.setParameter("actionType", "addreplacementnew").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {
						/*
						 * Object DATE = null; if (m[4] != null) { DATE = m[4].toString(); }
						 */

						RestSalesReplacementModel dropDownModel = new RestSalesReplacementModel(null,null,m[0], null, 
								m[1],m[2], null, null,m[3], m[4], m[5], null, null, null);
						
						
						
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				logger.info("@addd" + listData);
			} else {
				logger.info("@modify" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesRepalcement")
						.setParameter("actionType", "modifyreplacementnew").setParameter("actionValue", values)
						.getResultList();

				try {
					for (Object[] m : x) {
						/*
						 * Object DATE = null; if (m[4] != null) { DATE = m[4].toString(); }
						 */

						RestSalesReplacementModel dropDownModel = new RestSalesReplacementModel(null,null,m[0], null, 
								m[1],m[2], null, null,m[3], m[4], m[5], null, null, null);
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
		ResponseEntity<JsonResponse<List<RestSalesReplacementModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesReplacementModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addreplacementnew ends");
		return response;
	}
	
	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesReplacementModel>>> viewsalesReplacement() {
		logger.info("Method : viewsalesReplacement Dao startssssssssssssssssssssss");

		List<RestSalesReplacementModel> getAllemployee = new ArrayList<RestSalesReplacementModel>();
		JsonResponse<List<RestSalesReplacementModel>> resp = new JsonResponse<List<RestSalesReplacementModel>>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesRepalcement")
					.setParameter("actionType", "viewsalesReplacement").setParameter("actionValue", "")
					.getResultList();

			for (Object[] m : x) {

				Object createdOn = null;
				if (m[5] != null) {
					createdOn = m[5].toString();
				}

				RestSalesReplacementModel viewdemo = new RestSalesReplacementModel(null,null,m[0], null, 
						m[1],m[2], m[3], null,null,null, null, createdOn, null, null);
				getAllemployee.add(viewdemo);
			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestSalesReplacementModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesReplacementModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewsalesReplacement Dao ends");
		logger.info("resp****************************" + response);
		return response;

	}
	

	//Edit 

		@SuppressWarnings("unchecked")
		public List<RestSalesReplacementModel> viewReplacementEdit(String id) {
			logger.info("Method : viewReplacementEdit starts");
			logger.info("restSalesRefundModel" + id);
			// JsonResponse<List<RestQuotationNewModel>> resp = new
			// JsonResponse<List<RestQuotationNewModel>>();
			List<RestSalesReplacementModel> getRequisitionTypeList = new ArrayList<RestSalesReplacementModel>();

			try {
				String values = "SET @p_replacementId='" + id + "';";
				logger.info(values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesRepalcement")
						.setParameter("actionType", "viewReplacementEdit").setParameter("actionValue", values).getResultList();
				try {
					for (Object[] m : x) {

						
						 Object DATE = null; 
						 if (m[6] != null) 
						 {
							 DATE = m[6].toString();
						 }
						 
						 RestSalesReplacementModel dropDownModel = new RestSalesReplacementModel(null,null,m[0], null, 
									m[1],m[2], m[3], null,m[4], m[5],null, DATE, null, null,m[7],m[8],m[9],m[10],m[11],
											m[12],m[13],m[14],m[15],m[16],m[17],m[18],m[19],m[20],m[21],m[22],m[23],m[24],m[25]);
						 
						
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
			logger.info("Method : viewReplacementEdit ends");
			return getRequisitionTypeList;
		}
		
		
		public ResponseEntity<JsonResponse<Object>> deletReplacement(String id) {
			logger.info("Method : deletReplacement starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_replacementId='" + id + "';";

					em.createNamedStoredProcedureQuery("salesRepalcement").setParameter("actionType", "deletReplacement")
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

			logger.info("Method : deletReplacement ends");
			logger.info("DELETEE" + response);
			return response;
		}

	
}
