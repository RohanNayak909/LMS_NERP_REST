package nirmalya.aatithya.restmodule.qa.dao;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateCrqsParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateEdtaSolutionParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateSulphuricAcidParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestEdtaSolutionModel;
import nirmalya.aatithya.restmodule.qa.model.SulphuricAcidModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestEdtaCalciumDao {

	Logger logger = LoggerFactory.getLogger(RestEdtaCalciumDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	//
	public ResponseEntity<JsonResponse<List<RestEdtaSolutionModel>>> addCalcium(List<RestEdtaSolutionModel> qc) {
		logger.info("Method : addCalcium dao starts");
		System.out.println(qc);
		JsonResponse<List<RestEdtaSolutionModel>> resp = new JsonResponse<List<RestEdtaSolutionModel>>();

		String value = GenerateEdtaSolutionParam.addCalcium(qc);
		System.out.println("value===" + value);
		System.out.println("aooo==================" + qc.get(0).getEdtacalciumId());
		try {

			if (qc.get(0).getEdtacalciumId() != null && qc.get(0).getEdtacalciumId() != "") {

				em.createNamedStoredProcedureQuery("qa_calcium_routines")
						.setParameter("actionType", "modifyCalcium").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_calcium_routines")
						.setParameter("actionType", "addCalcium").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data saved successfully");

			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestEdtaSolutionModel>>> response = new ResponseEntity<JsonResponse<List<RestEdtaSolutionModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addCalcium dao ends");
		return response;

	}
	
	 @SuppressWarnings("unchecked")
	public JsonResponse<Object> viewCalcium(String orgName, String orgDivision) {
		logger.info("Method : viewCalcium Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_calcium_routines")
					.setParameter("actionType", "viewCalcium").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewCalcium Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp; 

	}
	
	 
	 @SuppressWarnings("unchecked")
		public JsonResponse<Object> editCalcium(String edtacalciumId, String orgName, String orgDivision) {
			logger.info("Method : editCalcium Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_edtaCalciumId='" + edtacalciumId + "',@p_org='" + orgName + "',@p_orgDiv='"+orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_calcium_routines")
						.setParameter("actionType", "editCalcium").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data saved successfully");

			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : editCalcium Dao ends");
			System.out.println("resp**************EDIT**************" + resp);
			return resp;
		}
	 

	 
	 
	 public ResponseEntity<JsonResponse<Object>> deleteCalcium(String id, String orgName, String orgDivision) {
			logger.info("Method : deleteCalcium starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_edtaCalciumId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("qa_calcium_routines")
							.setParameter("actionType", "deleteCalcium").setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Data deleted successfully");
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

			logger.info("Method : deleteCalcium ends");
			System.out.println("DELETEE" + response);
			return response;
		}
	 
	 public ResponseEntity<JsonResponse<Object>> approveCalcium(String id, String orgName, String orgDivision, String userId) {
			logger.info("Method : approveCalcium starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_edtaCalciumId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision +"', @p_approveBy='" + userId + "';";
					System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("qa_calcium_routines")
							.setParameter("actionType", "approveCalcium").setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Approved successfully");
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

			logger.info("Method : approveCalcium ends");
			return response;
		}
//
	 @SuppressWarnings("unchecked")
		public JsonResponse<Object> edtaCalPdf(String id,String orgName, String orgDivision) {
			logger.info("Method : edtaCalPdf Dao startsssss" + id );

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_edtacalciumId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				logger.info("values******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_calcium_routines")
						.setParameter("actionType", "edtaCalPdf").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("resp******" + resp);
			logger.info("Method : edtaCalPdf Dao ends");
			return resp;

		}
}
