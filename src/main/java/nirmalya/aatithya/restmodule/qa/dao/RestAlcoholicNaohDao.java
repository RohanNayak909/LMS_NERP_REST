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
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateSulphuricAcidParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.AlcoholicNaohModel;
import nirmalya.aatithya.restmodule.qa.model.SulphuricAcidModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestAlcoholicNaohDao {
	Logger logger = LoggerFactory.getLogger(RestSulphuricAcidDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	public ResponseEntity<JsonResponse<List<AlcoholicNaohModel>>> addAlcoholicNaoh(List<AlcoholicNaohModel> qc) {
		logger.info("Method : addAlcoholicNaoh dao starts");
		System.out.println(qc);
		JsonResponse<List<AlcoholicNaohModel>> resp = new JsonResponse<List<AlcoholicNaohModel>>();

		String value = GenerateSulphuricAcidParam.addAlcoholicNaoh(qc);
		System.out.println("value===" + value);
		try {

			if (qc.get(0).getAlcoholicNaohId() != null && qc.get(0).getAlcoholicNaohId() != "") {

				em.createNamedStoredProcedureQuery("qa_alcholic_naoh_routines")
						.setParameter("actionType", "modifyAlcoholicNaoh").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_alcholic_naoh_routines")
						.setParameter("actionType", "addAlcoholicNaoh").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<List<AlcoholicNaohModel>>> response = new ResponseEntity<JsonResponse<List<AlcoholicNaohModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addAlcoholicNaoh dao ends");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAlcoholicNaohView(String orgName, String orgDivision) {
		logger.info("Method : getAlcoholicNaohView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_alcholic_naoh_routines")
					.setParameter("actionType", "getAlcoholicNaohView").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAlcoholicNaohView Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editAlcoholicNaoh(String alcoholicNaohId, String orgName, String orgDivision) {
		logger.info("Method : editAlcoholicNaoh Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_alcoholicNaohId='" + alcoholicNaohId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_alcholic_naoh_routines")
					.setParameter("actionType", "editAlcoholicNaoh").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editAlcoholicNaoh Dao ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteAlcoholicNaoh(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteAlcoholicNaoh starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_alcoholicNaohId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("qa_alcholic_naoh_routines")
						.setParameter("actionType", "deleteAlcoholicNaoh").setParameter("actionValue", value).execute();
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

		logger.info("Method : deleteAlcoholicNaoh ends");
		System.out.println("DELETEE" + response);
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> approveAlcoholicNaoh(String id, String orgName, String orgDivision) {
		logger.info("Method : approveAlcoholicNaoh starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_alcoholicNaohId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("qa_alcholic_naoh_routines")
						.setParameter("actionType", "approveAlcoholicNaoh").setParameter("actionValue", value).execute();
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

		logger.info("Method : approveAlcoholicNaoh ends");
		return response;
	}
	//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> alcohlicNaohPdf(String id,String orgName, String orgDivision) {
		logger.info("Method : alcohlicNaohPdf Dao startsssss" + id );

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_alcoholicNaohId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_alcholic_naoh_routines")
					.setParameter("actionType", "alcohlicNaohPdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("resp******" + resp);
		logger.info("Method : alcohlicNaohPdf Dao ends");
		return resp;

	}
}
