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
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateQaRequestParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateSackParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.LaminateModel;
import nirmalya.aatithya.restmodule.qa.model.QaSackRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestQaRequestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestQaRequestDao {

	Logger logger = LoggerFactory.getLogger(RestQaRequestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewQaRequestData(String orgName, String orgDivision) {
		logger.info("Method : viewQaRequestData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "viewQaRequestData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewQaRequestData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qaRequestDtls(String id, String orgName, String orgDivision) {
		logger.info("Method : qaRequestDtls Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_reqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "qaRequestDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("Success");
			resp.setMessage("Child Data");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : qaRequestDtls Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qaRequestChangeStatus(String id, String QrCode, String orgName, String orgDivision) {
		logger.info("Method : qaRequestChangeStatus Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_reqId='" + id + "',@p_qrCode='" + QrCode + "',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDivision + "';";
			System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "qaRequestChangeStatus").setParameter("actionValue", value).execute();

			resp.setCode("success");
			resp.setMessage("Sample Requested");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : qaRequestChangeStatus Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// Test Dtls
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qaRequestTestDtls(String rid, String id, String sampleAmt, String orgName,
			String orgDivision) {
		logger.info("Method : qaRequestTestDtls Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_reqId='" + rid + "',@p_skuId='" + id + "',@p_sampleAmt='" + sampleAmt + "',@p_org='"
					+ orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "qaRequestTestDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));

			resp.setCode("success");
			resp.setMessage("Sample Requested");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : qaRequestTestDtls Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// For Lami.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qaRequestTestDtlsLami(String rid, String id, String sampleAmt, String orgName,
			String orgDivision) {
		logger.info("Method : qaRequestTestDtlsLami Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_reqId='" + rid + "',@p_skuId='" + id + "',@p_sampleAmt='" + sampleAmt + "',@p_org='"
					+ orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "qaRequestTestDtlsLami").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));

			resp.setCode("success");
			resp.setMessage("Sample Requested");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : qaRequestTestDtlsLami Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// For Sack.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qaRequestTestDtlsSack(String rid, String id, String sampleAmt, String orgName,
			String orgDivision) {
		logger.info("Method : qaRequestTestDtlsSack Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_reqId='" + rid + "',@p_skuId='" + id + "',@p_sampleAmt='" + sampleAmt + "',@p_org='"
					+ orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "qaRequestTestDtlsSack").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));

			resp.setCode("success");
			resp.setMessage("Sample Requested");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : qaRequestTestDtlsSack Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// Test Result Submit.

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> qaTestResultSubmit(RestQaRequestModel data) {
		logger.info("Method : qaTestResultSubmit Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = GenerateQaRequestParam.getQaSampleTestParam(data);
			System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("qa_requested_routines").setParameter("actionType", "testResultSubmit")
					.setParameter("actionValue", value).execute();
			resp.setCode("Success");
			resp.setMessage("Data Ok");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : qaTestResultSubmit Dao ends");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		System.out.println("resp**************chiiiild**************" + response);
		return response;

	}

	// Test Result For Lami.

	public ResponseEntity<JsonResponse<List<LaminateModel>>> qaTestResultForLamiSubmit(List<LaminateModel> qc) {
		logger.info("Method : qaTestResultForLamiSubmit dao starts");
		System.out.println(qc);
		JsonResponse<List<LaminateModel>> resp = new JsonResponse<List<LaminateModel>>();

		String value = GenerateLaminateParameter.getAddLaminate(qc);
		System.out.println("value===" + value);
		System.out.println("Modify qc===" + qc.get(0).getLaminateId());
		try {

			if (qc.get(0).getLaminateId() != null && qc.get(0).getLaminateId() != "") {

				em.createNamedStoredProcedureQuery("qa_requested_routines")
						.setParameter("actionType", "ModifyQaTestResultForLami").setParameter("actionValue", value)
						.execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_requested_routines")
						.setParameter("actionType", "addQaTestResultForLami").setParameter("actionValue", value)
						.execute();

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
		logger.info("Method : qaTestResultForLamiSubmit dao ends");
		return response;

	}

	// Test Result For Sack.

	public ResponseEntity<JsonResponse<List<QaSackRestModel>>> qaTestResultForSackSubmit(List<QaSackRestModel> qc) {
		logger.info("Method : qaTestResultForSackSubmit dao starts");
		System.out.println(qc);
		JsonResponse<List<QaSackRestModel>> resp = new JsonResponse<List<QaSackRestModel>>();

		String value = GenerateSackParam.getAddsack(qc);
		System.out.println("value===" + value);
		System.out.println("Modify qc===" + qc.get(0).getSackId());
		try {

			if (qc.get(0).getSackId() != null && qc.get(0).getSackId() != "") {

				em.createNamedStoredProcedureQuery("qa_requested_routines").setParameter("actionType", "modifysack")
						.setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_requested_routines").setParameter("actionType", "addSack")
						.setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<List<QaSackRestModel>>> response = new ResponseEntity<JsonResponse<List<QaSackRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : qaTestResultForSackSubmit dao ends");
		return response;

	}
	
	// Download Pdf.
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> downloadQaTestResult(String id, String orgName, String orgDivision) {
		logger.info("Method : downloadQaTestResult Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "dloadTestResult").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : downloadQaTestResult Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}
	
	// Pdf Lami.
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> downloadQaTestResultLami(String id, String orgName, String orgDivision) {
		logger.info("Method : downloadQaTestResultLami Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "dloadTestResultLami").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : downloadQaTestResultLami Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}
	
	
	// Pdf Sack.
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> downloadQaTestResultSack(String id, String orgName, String orgDivision) {
		logger.info("Method : downloadQaTestResultSack Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "dloadTestResultSack").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : downloadQaTestResultSack Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}
	
	

	// Search

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qaRequestSearch(String orgName, String orgDivision,
			String searchValue) {
		logger.info("Method : qaRequestSearch Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "',@p_Svalue='" + searchValue + "';";
			System.out.println("value>>>-----" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "qaRequestSearch").setParameter("actionValue", value)
					.getResultList();
			System.out.println("x.get(0)--->>>>>>-----" + x.get(0));
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : qaRequestSearch Dao ends");
		return resp;

	}

}
