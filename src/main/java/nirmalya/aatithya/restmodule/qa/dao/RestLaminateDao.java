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
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateLaminateParameter;
import nirmalya.aatithya.restmodule.common.utils.qa.GeneratePcroParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.LaminateModel;
import nirmalya.aatithya.restmodule.qa.model.QaPcroRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestLaminateDao {
	Logger logger = LoggerFactory.getLogger(RestLaminateDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	public ResponseEntity<JsonResponse<List<LaminateModel>>> addLaminate(List<LaminateModel> qc) {
		logger.info("Method : addLaminate dao starts");
		System.out.println(qc);
		JsonResponse<List<LaminateModel>> resp = new JsonResponse<List<LaminateModel>>();

		String value = GenerateLaminateParameter.getAddLaminate(qc);
		System.out.println("value===" + value);
		System.out.println("Modify qc===" + qc.get(0).getLaminateId());
		try {

			if (qc.get(0).getLaminateId() != null && qc.get(0).getLaminateId() != "") {

				em.createNamedStoredProcedureQuery("qa_laminate_routines")
						.setParameter("actionType", "modifyLaminate").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_laminate_routines")
						.setParameter("actionType", "addLaminate").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<List<LaminateModel>>> response = new ResponseEntity<JsonResponse<List<LaminateModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addLaminate dao ends");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getLaminateView(String orgName, String orgDivision) {
		logger.info("Method : getLaminateView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_laminate_routines")
					.setParameter("actionType", "getLaminateView").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getLaminateView Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editLaminate(String id, String orgName, String orgDivision) {
		logger.info("Method : editLaminate Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_laminateId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_laminate_routines")
					.setParameter("actionType", "editLaminate").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editLaminate Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteLaminate(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteLaminate starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_laminateId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("qa_laminate_routines")
						.setParameter("actionType", "deleteLaminate").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteLaminate ends");
		System.out.println("DELETEE" + response);
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> approveLaminate(String id, String orgName, String orgDivision) {
		logger.info("Method : approveLaminate starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_laminateId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("qa_laminate_routines")
						.setParameter("actionType", "approveLaminate").setParameter("actionValue", value).execute();

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

		logger.info("Method : approveLaminate ends");
		return response;
	}
	

}
