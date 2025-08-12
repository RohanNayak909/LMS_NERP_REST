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
import nirmalya.aatithya.restmodule.qa.model.RestVbarModel;

@Repository
public class RestVb2arDao {
	Logger logger = LoggerFactory.getLogger(RestVb2arDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestVbarModel>>> saveVb2arData(
			List<RestVbarModel> restVbarModel) {

		logger.info("Method : saveVb2arData starts");

		JsonResponse<List<RestVbarModel>> resp = new JsonResponse<List<RestVbarModel>>();
		List<RestVbarModel> listData = new ArrayList<RestVbarModel>();
		String values = GenerateMicroTestingParameter.getVbarParam(restVbarModel);
		try {
			if (restVbarModel.get(0).getVb1arId() == null
					|| restVbarModel.get(0).getVb1arId() == "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.VBAR_ROUTINES)
						.setParameter("actionType", "saveVb2arData").setParameter("actionValue", values)
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
						.setParameter("actionType", "modifyVb2arData").setParameter("actionValue", values)
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
		logger.info("Method : saveVb2arData ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewVb2arData(String orgName, String orgDivision) {
		logger.info("Method : viewVb2arData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.VBAR_ROUTINES)
					.setParameter("actionType", "viewVb2arData").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewVb2arData Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse <Object> editVb2arData(String vb1arId,String orgName, String orgDiv) {
		logger.info("Method : editVb2arData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_vb1arId='" + vb1arId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.VBAR_ROUTINES, "editVb2arData", value, em);
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
		logger.info("Method : editVb2arData Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approvevb2ardata(String vb1arId,String orgName,String orgDiv) {
		logger.info("Method : approvevb2ardata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_vb1arId='" + vb1arId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.VBAR_ROUTINES, "approvevb2ardata", value, em);
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Approved successfully");
			} catch (Exception e) {
				resp.setCode("500");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : approvevb2ardata Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse <Object> deletevb2ardata(String vb1arId,String orgName, String orgDiv) {
		logger.info("Method : deletevb2ardata Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_vb1arId='" + vb1arId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value"+value);
			
		 em.createNamedStoredProcedureQuery(ProcedureNameConstants.VBAR_ROUTINES).setParameter("actionType", "deletevb2ardata")
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
		logger.info("Method : deletevb2ardata Dao ends");
		return resp;

	}
//PDF

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> vitaminB2Pdf(String id,String orgName, String orgDivision) {
			logger.info("Method : vitaminB2Pdf Dao startsssss" + id );

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_vb1arId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				logger.info("values******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.VBAR_ROUTINES)
						.setParameter("actionType", "viewVitaminB2Pdf").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("resp******" + resp);
			logger.info("Method : vitaminB2Pdf Dao ends");
			return resp;

		}
}
