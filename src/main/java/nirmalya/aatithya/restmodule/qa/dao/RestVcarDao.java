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
public class RestVcarDao {
	Logger logger = LoggerFactory.getLogger(RestVcarDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestVbarModel>>> saveVcarData(
			List<RestVbarModel> restVbarModel) {

		logger.info("Method : saveVcarData starts");

		JsonResponse<List<RestVbarModel>> resp = new JsonResponse<List<RestVbarModel>>();
		List<RestVbarModel> listData = new ArrayList<RestVbarModel>();
		String values = GenerateMicroTestingParameter.getVcarParam(restVbarModel);
		try {
			if (restVbarModel.get(0).getVbcarId() == null
					|| restVbarModel.get(0).getVbcarId() == "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.VBAR_ROUTINES)
						.setParameter("actionType", "saveVcarData").setParameter("actionValue", values)
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
						.setParameter("actionType", "modifyVcarData").setParameter("actionValue", values)
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
		logger.info("Method : saveVcarData ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewVcarData(String orgName, String orgDivision) {
		logger.info("Method : viewVcarData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.VBAR_ROUTINES)
					.setParameter("actionType", "viewVcarData").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewVcarData Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse <Object> editVcarData(String vbcarId,String orgName, String orgDiv) {
		logger.info("Method : editVcarData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_vbcarId='" + vbcarId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.VBAR_ROUTINES, "editVcarData", value, em);
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
		logger.info("Method : editVcarData Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approvevcardata(String vbcarId,String orgName,String orgDiv) {
		logger.info("Method : approvevcardata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_vbcarId='" + vbcarId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.VBAR_ROUTINES, "approvevcardata", value, em);
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Approved successfully");
			} catch (Exception e) {
				resp.setCode("500");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : approvevcardata Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse <Object> deletevcardata(String vbcarId,String orgName, String orgDiv) {
		logger.info("Method : deletevcardata Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_vbcarId='" + vbcarId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value"+value);
			
		 em.createNamedStoredProcedureQuery(ProcedureNameConstants.VBAR_ROUTINES).setParameter("actionType", "deletevcardata")
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
		logger.info("Method : deletevcardata Dao ends");
		return resp;

	}
//PDF
	//pdf
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> viewVitaminCPdf(String id,String orgName, String orgDivision) {
				logger.info("Method : viewVitaminCPdf Dao startsssss" + id );

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_vbcarId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					logger.info("values******" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.VBAR_ROUTINES)
							.setParameter("actionType", "viewVitaminCPdf").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
					e.printStackTrace();
				}
				logger.info("resp******" + resp);
				logger.info("Method : viewVitaminCPdf Dao ends");
				return resp;

			}
}
