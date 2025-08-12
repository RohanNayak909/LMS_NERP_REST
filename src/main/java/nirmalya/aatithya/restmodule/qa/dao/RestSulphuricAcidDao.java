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
import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateSulphuricAcidParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.SulphuricAcidModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestSulphuricAcidDao {
	Logger logger = LoggerFactory.getLogger(RestSulphuricAcidDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	public ResponseEntity<JsonResponse<List<SulphuricAcidModel>>> addSulphuric(List<SulphuricAcidModel> qc) {
		logger.info("Method : addSulphuric dao starts");
		System.out.println(qc);
		JsonResponse<List<SulphuricAcidModel>> resp = new JsonResponse<List<SulphuricAcidModel>>();

		String value = GenerateSulphuricAcidParam.addSulphuric(qc);
		System.out.println("value===" + value);
		try {

			if (qc.get(0).getSulphuricAcidId() != null && qc.get(0).getSulphuricAcidId() != "") {

				em.createNamedStoredProcedureQuery("qa_sulphuric_routines")
						.setParameter("actionType", "modifySulphuric").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_sulphuric_routines")
						.setParameter("actionType", "addSulphuric").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<List<SulphuricAcidModel>>> response = new ResponseEntity<JsonResponse<List<SulphuricAcidModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addSulphuric dao ends");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getSulphuricAcidView(String orgName, String orgDivision) {
		logger.info("Method : getSulphuricAcidView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_sulphuric_routines")
					.setParameter("actionType", "getSulphuricAcidView").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSulphuricAcidView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editSulphuricAcid(String sulphuricAcidId, String orgName, String orgDivision) {
		logger.info("Method : editSulphuricAcid Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_sulphuricAcidId='" + sulphuricAcidId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_sulphuric_routines")
					.setParameter("actionType", "editSulphuricAcid").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editSulphuricAcid Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteSulphuricAcid(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteSulphuricAcid starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_sulphuricAcidId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("qa_sulphuric_routines")
						.setParameter("actionType", "deleteSulphuricAcid").setParameter("actionValue", value).execute();
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

		logger.info("Method : deleteSulphuricAcid ends");
		System.out.println("DELETEE" + response);
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> approveSa(String id, String orgName, String orgDivision) {
		logger.info("Method : approveSa starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_sulphuricAcidId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("qa_sulphuric_routines")
						.setParameter("actionType", "approveSa").setParameter("actionValue", value).execute();
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

		logger.info("Method : approveSa ends");
		return response;
	}
//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> sulAcidPdf(String id,String orgName, String orgDivision) {
		logger.info("Method : sulAcidPdf Dao startsssss" + id );

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_sulphuricAcidId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_sulphuric_routines")
					.setParameter("actionType", "sulAcidPdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("resp******" + resp);
		logger.info("Method : sulAcidPdf Dao ends");
		return resp;

	}
}
