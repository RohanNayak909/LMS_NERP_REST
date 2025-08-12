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
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateCrqsCheckParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateCrqsParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateQaMsqcParams;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsCheckRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class QaMsqcDao {
	Logger logger = LoggerFactory.getLogger(QaMsqcDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;


	// addCrqs
	public ResponseEntity<JsonResponse<List<QaCrqsCheckRestModel>>> addCrqsCheck(List<QaCrqsCheckRestModel> qc) {
		logger.info("Method : addQc dao starts");
		System.out.println(qc);
		JsonResponse<List<QaCrqsCheckRestModel>> resp = new JsonResponse<List<QaCrqsCheckRestModel>>();

		String value = GenerateQaMsqcParams.getAddCrqsCheck(qc);
		System.out.println("value===" + value);
		System.out.println("Modify qc===" + qc.get(0).getCrqscheckId());
		try {

			if (qc.get(0).getCrqscheckId() != null && qc.get(0).getCrqscheckId() != "") {

				em.createNamedStoredProcedureQuery("qa_msqc_routines")
						.setParameter("actionType", "modifyCrqs").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_msqc_routines")
						.setParameter("actionType", "addCrqs").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<List<QaCrqsCheckRestModel>>> response = new ResponseEntity<JsonResponse<List<QaCrqsCheckRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addQc dao ends");
		return response;

	}

	// getTotalCrqsView
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTotalCrqsView(String orgName, String orgDivision) {
		logger.info("Method : getTotalCrqsView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_msqc_routines")
					.setParameter("actionType", "getCrqsView").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalCrqsView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}
	
	// editCrqs
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> editCrqs(String id, String orgName, String orgDivision) {
				logger.info("Method : editCrqs Dao starts");
				JsonResponse<Object> resp = new JsonResponse<Object>();
				try {
					String value = "SET @p_MSQCId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("values****************************" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("qa_msqc_routines")
							.setParameter("actionType", "editCrqs").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : editCrqs Dao ends");
				System.out.println("resp**************EDIT**************" + resp);
				return resp;
			}
			
			// downloadCrqs
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> downloadCrqs(String id, String orgName, String orgDivision) {
				logger.info("Method : downloadCrqs Dao starts");
				JsonResponse<Object> resp = new JsonResponse<Object>();
				try {
					String value = "SET @p_MSQCId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("values****************************" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("qa_msqc_routines")
							.setParameter("actionType", "downloadCrqs").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : downloadCrqs Dao ends");
				System.out.println("resp**************EDIT**************" + resp);
				return resp;
			}
			
			
			// deleteCrqs
			public ResponseEntity<JsonResponse<Object>> deleteCrqs(String id, String orgName, String orgDivision) {
				logger.info("Method : deleteCrqs starts");

				Boolean validity = true;
				JsonResponse<Object> resp = new JsonResponse<Object>();
				resp.setMessage("");
				resp.setCode("");

				if (validity)
					try {

						String value = "SET @p_MSQCId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
						System.out.println("IDD" + value);
						em.createNamedStoredProcedureQuery("qa_msqc_routines")
								.setParameter("actionType", "deleteCrqs").setParameter("actionValue", value).execute();

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

				logger.info("Method : deleteCrqs ends");
				System.out.println("DELETEE" + response);
				return response;
			}
			
			// approveCrqs
			public ResponseEntity<JsonResponse<Object>> approveCrqs(String id, String orgName, String orgDivision) {
				logger.info("Method : approveCrqs starts");

				Boolean validity = true;
				JsonResponse<Object> resp = new JsonResponse<Object>();
				resp.setMessage("");
				resp.setCode("");

				if (validity)
					try {

						String value = "SET @p_MSQCId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
						System.out.println("IDD" + value);
						em.createNamedStoredProcedureQuery("qa_msqc_routines")
								.setParameter("actionType", "approveCrqs").setParameter("actionValue", value).execute();

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

				logger.info("Method : approveCrqs ends");
				return response;
			}

}
