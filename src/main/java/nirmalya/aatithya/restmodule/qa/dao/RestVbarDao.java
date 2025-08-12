package nirmalya.aatithya.restmodule.qa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.CommonUsed;
import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateMicroTestingParameter;
import nirmalya.aatithya.restmodule.qa.model.LtmrRecordModel;
import nirmalya.aatithya.restmodule.qa.model.RestVbarModel;

@Repository
public class RestVbarDao {
	Logger logger = LoggerFactory.getLogger(RestVbarDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestVbarModel>>> saveVb1arData(
			List<RestVbarModel> restVbarModel) {

		logger.info("Method : saveVb1arData starts");

		JsonResponse<List<RestVbarModel>> resp = new JsonResponse<List<RestVbarModel>>();
		List<RestVbarModel> listData = new ArrayList<RestVbarModel>();
		String values = GenerateMicroTestingParameter.getVbarParam(restVbarModel);
		try {
			if (restVbarModel.get(0).getVb1arId() == null
					|| restVbarModel.get(0).getVb1arId() == "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.VBAR_ROUTINES)
						.setParameter("actionType", "saveVb1arData").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {
						RestVbarModel dropDownModel = new RestVbarModel(m[0], m[1], null,null);
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.VBAR_ROUTINES)
						.setParameter("actionType", "modifyVb1arData").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {
						RestVbarModel dropDownModel = new RestVbarModel(m[0], m[1], null,null);
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
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
		ResponseEntity<JsonResponse<List<RestVbarModel>>> response = new ResponseEntity<JsonResponse<List<RestVbarModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveVb1arData ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewVb1arData(String orgName, String orgDivision) {
		logger.info("Method : viewVb1arData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.VBAR_ROUTINES)
					.setParameter("actionType", "viewVb1arData").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewVb1arData Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse <Object> editVb1arData(String vb1arId,String orgName, String orgDiv) {
		logger.info("Method : editVb1arData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_vb1arId='" + vb1arId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.VBAR_ROUTINES, "editVb1arData", value, em);
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				/*
				 * resp.setCode("500"); resp.setMessage(e.getMessage());
				 */
				e.printStackTrace();
				CommonUsed.getErrorDetails(resp, e, serverDao);
			}
		logger.info("Method : editVb1arData Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approvevb1ardata(String vb1arId,String orgName,String orgDiv) {
		logger.info("Method : approvevb1ardata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_vb1arId='" + vb1arId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.VBAR_ROUTINES, "approvevb1ardata", value, em);
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Approved successfully");
			} catch (Exception e) {
				resp.setCode("500");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : approvevb1ardata Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse <Object> deletevb1ardata(String vb1arId,String orgName, String orgDiv) {
		logger.info("Method : deletevb1ardata Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_vb1arId='" + vb1arId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value"+value);
			
		 em.createNamedStoredProcedureQuery(ProcedureNameConstants.VBAR_ROUTINES).setParameter("actionType", "deletevb1ardata")
			.setParameter("actionValue", value).execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonUsed.getErrorDetails(resp, e, serverDao);
		}

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("200");
		}
		logger.info("Method : deletevb1ardata Dao ends");
		return resp;

	}
//pdf
	//pdf
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewVitaminb1Pdf(String id,String orgName, String orgDivision) {
			logger.info("Method : viewVitaminb1Pdf Dao startsssss" + id );

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_vb1arId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				logger.info("values******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.VBAR_ROUTINES)
						.setParameter("actionType", "viewVitaminb1Pdf").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("resp******" + resp);
			logger.info("Method : viewVitaminb1Pdf Dao ends");
			return resp;

		}
		
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> productList(String type, String orgName, String orgDivision) {
			logger.info("Method : productList Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_type='" + type + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.VBAR_ROUTINES)
						.setParameter("actionType", "getProductList").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("failed");
				resp.setMessage("Data fetched failed!");
			}
			logger.info("Method : productList Dao ends");
			System.out.println("resp**************EDIT**************" + resp);
			return resp;
		}
	
}
