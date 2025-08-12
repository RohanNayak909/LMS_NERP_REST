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
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateSodiumParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateSulphuricAcidParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestEdtaSolutionModel;
import nirmalya.aatithya.restmodule.qa.model.SodiumHydroxideRestModel;
import nirmalya.aatithya.restmodule.qa.model.SulphuricAcidModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class SodiumHydrixideDao {
	Logger logger = LoggerFactory.getLogger(SodiumHydrixideDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	
	
	public ResponseEntity<JsonResponse<List<SodiumHydroxideRestModel>>> addSodium(List<SodiumHydroxideRestModel> qc) {
		logger.info("Method : addSodium dao starts");
		System.out.println(qc);
		JsonResponse<List<SodiumHydroxideRestModel>> resp = new JsonResponse<List<SodiumHydroxideRestModel>>();

		String value = GenerateSodiumParam.addSodium(qc);
		System.out.println("value===" + value);
		try {

			if (qc.get(0).getSodiumId() != null && qc.get(0).getSodiumId() != "") {

				em.createNamedStoredProcedureQuery("qa_sodium_routines")
						.setParameter("actionType", "modifySodium").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_sodium_routines")
						.setParameter("actionType", "addSodium").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<List<SodiumHydroxideRestModel>>> response = new ResponseEntity<JsonResponse<List<SodiumHydroxideRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addSodium dao ends");
		return response;

	}
	
	 @SuppressWarnings("unchecked")
		public JsonResponse<Object> viewSodium(String orgName, String orgDivision) {
			logger.info("Method : viewSodium Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_sodium_routines")
						.setParameter("actionType", "viewSodium").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewSodium Dao ends");
			System.out.println("resp**************rrreessuulltt**************" + resp);
			return resp; 

		}
	 
	 
	 @SuppressWarnings("unchecked")
		public JsonResponse<Object> editSodium(String sodiumId, String orgName, String orgDivision) {
			logger.info("Method : editSodium Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_sodiumId='" + sodiumId + "',@p_org='" + orgName + "',@p_orgDiv='"+orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_sodium_routines")
						.setParameter("actionType", "editSodium").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data saved successfully");

			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : editSodium Dao ends");
			System.out.println("resp**************EDIT**************" + resp);
			return resp;
		}
	 
	 public ResponseEntity<JsonResponse<Object>> deleteSodium(String id, String orgName, String orgDivision) {
			logger.info("Method : deleteSodium starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_sodiumId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("qa_sodium_routines")
							.setParameter("actionType", "deleteSodium").setParameter("actionValue", value).execute();
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

			logger.info("Method : deleteSodium ends");
			System.out.println("DELETEE" + response);
			return response;
		}
	 
	 
	 public ResponseEntity<JsonResponse<Object>> approveSodium(String id, String orgName, String orgDivision, String userId) {
			logger.info("Method : approveSodium starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_sodiumId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision +"', @p_approveBy='" + userId + "';";
					System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("qa_sodium_routines")
							.setParameter("actionType", "approveSodium").setParameter("actionValue", value).execute();
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

			logger.info("Method : approveSodium ends");
			return response;
		}
//PDF
	 @SuppressWarnings("unchecked")
		public JsonResponse<Object> sodiumHydroxidePdf(String id,String orgName, String orgDivision) {
			logger.info("Method : sodiumHydroxidePdf Dao startsssss" + id );

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_sodiumId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				logger.info("values******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_sodium_routines")
						.setParameter("actionType", "sodiumHydroxidePdf").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("resp******" + resp);
			logger.info("Method : sodiumHydroxidePdf Dao ends");
			return resp;

		}
	
}
