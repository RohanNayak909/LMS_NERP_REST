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
import nirmalya.aatithya.restmodule.common.utils.qa.GeneratePcroParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateSackParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.QaPcroRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaSackRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;
@Repository
public class QcSackRestDao {
	
	Logger logger = LoggerFactory.getLogger(QcSackRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getShiftSlno(String orgName, String orgDivision) {
		logger.info("Method : getShiftSlno Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_sack_routines")
					.setParameter("actionType", "getSlno").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getShiftSlno Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}
	
	// addQc
			public ResponseEntity<JsonResponse<List<QaSackRestModel>>> addSack(List<QaSackRestModel> qc) {
				logger.info("Method : addSack dao starts");
				System.out.println(qc);
				JsonResponse<List<QaSackRestModel>> resp = new JsonResponse<List<QaSackRestModel>>();

				String value = GenerateSackParam.getAddsack(qc);
				System.out.println("value===" + value);
				System.out.println("Modify qc===" + qc.get(0).getSackId());
				try {

					if (qc.get(0).getSackId() != null && qc.get(0).getSackId() != "") {

						em.createNamedStoredProcedureQuery("qa_sack_routines")
								.setParameter("actionType", "modifysack").setParameter("actionValue", value).execute();

						resp.setCode("success");
						resp.setMessage("Data Modified successfully");

					} else {
						em.createNamedStoredProcedureQuery("qa_sack_routines")
								.setParameter("actionType", "addSack").setParameter("actionValue", value).execute();

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
				logger.info("Method : addSack dao ends");
				return response;

			}
			//view
			
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> viewSack(String orgName, String orgDivision) {
				logger.info("Method : viewSack Dao starts");

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("values****************************" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("qa_sack_routines")
							.setParameter("actionType", "viewSack").setParameter("actionValue", value).getResultList();
					resp.setBody(x);
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : viewSack Dao ends");
				System.out.println("resp**************rrreessuulltt**************" + resp);
				return resp;

			}
			
			// edit
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> editSack(String id, String orgName, String orgDivision) {
				logger.info("Method : editSack Dao starts");
				JsonResponse<Object> resp = new JsonResponse<Object>();
				try {
					String value = "SET @p_sackId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("values****************************" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("qa_sack_routines")
							.setParameter("actionType", "editSack").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : editSack Dao ends");
				System.out.println("resp**************EDIT**************" + resp);
				return resp;
			}
			
			
			// delete
			public ResponseEntity<JsonResponse<Object>> deleteSack(String id, String orgName, String orgDivision) {
				logger.info("Method : deleteSack starts");

				Boolean validity = true;
				JsonResponse<Object> resp = new JsonResponse<Object>();
				resp.setMessage("");
				resp.setCode("");

				if (validity)
					try {

						String value = "SET @p_sackId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
						System.out.println("IDD" + value);
						em.createNamedStoredProcedureQuery("qa_sack_routines")
								.setParameter("actionType", "deleteSack").setParameter("actionValue", value).execute();

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

				logger.info("Method : deleteSack ends");
				System.out.println("DELETEE" + response);
				return response;
			}
			
			
			
			// approve
			public ResponseEntity<JsonResponse<Object>> approveSack(String id, String orgName, String orgDivision) {
				logger.info("Method : approveSack starts");

				Boolean validity = true;
				JsonResponse<Object> resp = new JsonResponse<Object>();
				resp.setMessage("");
				resp.setCode("");

				if (validity)
					try {

						String value = "SET @p_sackId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
						System.out.println("IDDQQQQQQQQQQQQQQQ" + value);
						em.createNamedStoredProcedureQuery("qa_sack_routines")
								.setParameter("actionType", "approveSack").setParameter("actionValue", value).execute();

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

				logger.info("Method : approveSack ends");
				return response;
			}

}
