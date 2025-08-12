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
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateCrqsParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateRCFTMParam;
import nirmalya.aatithya.restmodule.common.utils.GenerateProductMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.ProductMasterModel;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class QaRCFTMDao {
	Logger logger = LoggerFactory.getLogger(QaRCFTMDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// getAggridDet
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAggridDataForrcftm(String orgName, String orgDivision) {
		logger.info("Method : getAggridDataForrcftm Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_rcftm_routines")
					.setParameter("actionType", "getAggridDataForrcftm").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAggridDataForrcftm Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	// addCrqs
	public ResponseEntity<JsonResponse<List<QaRCFTMRestModel>>> addRCFTM(List<QaRCFTMRestModel> qc) {
		logger.info("Method : addRCFTM dao starts");
		System.out.println(qc);
		JsonResponse<List<QaRCFTMRestModel>> resp = new JsonResponse<List<QaRCFTMRestModel>>();

		String value = GenerateRCFTMParam.getAddRCFTM(qc);
		System.out.println("value===" + value);
		System.out.println("Modify qc===" + qc.get(0).getRunChartId());
		try {

			if (qc.get(0).getRunChartId() != null && qc.get(0).getRunChartId() != "") {

				System.out.println("modifuuuu===" + qc.get(0).getRunChartId());
				em.createNamedStoredProcedureQuery("qa_rcftm_routines").setParameter("actionType", "modifyRCFTM")
						.setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				System.out.println("addd===" + qc.get(0).getRunChartId());
				em.createNamedStoredProcedureQuery("qa_rcftm_routines").setParameter("actionType", "addRCFTM")
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

		ResponseEntity<JsonResponse<List<QaRCFTMRestModel>>> response = new ResponseEntity<JsonResponse<List<QaRCFTMRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addRCFTM dao ends");
		return response;

	}

	// getTotalCrqsView
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTotalRCFTMViewView(String orgName, String orgDivision) {
		logger.info("Method : getTotalRCFTMViewView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_rcftm_routines")
					.setParameter("actionType", "getRCFTMView").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalRCFTMViewView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	// editCrqs
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editCodeRCFTM(String id, String orgName, String orgDivision) {
		logger.info("Method : editCodeRCFTM Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_rcftmId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_rcftm_routines")
					.setParameter("actionType", "editCodeRCFTM").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editCodeRCFTM Dao ends");
		return resp;
	}

	// downloadCrqs
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> downloadCrqs(String id, String orgName, String orgDivision) {
		logger.info("Method : downloadCrqs Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_crqsId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_rcftm_routines")
					.setParameter("actionType", "downloadCrqs").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : downloadCrqs Dao ends");
		return resp;
	}

	// deleteCrqs
	public ResponseEntity<JsonResponse<Object>> deleteRCFTM(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteRCFTM starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_RCFTMId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("qa_rcftm_routines").setParameter("actionType", "deleteRCFTM")
						.setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteRCFTM ends");
		System.out.println("DELETEE" + response);
		return response;
	}

	// approveCrqs
	public ResponseEntity<JsonResponse<Object>> restapproveRCFTM(String id, String orgName, String orgDivision) {
		logger.info("Method : restapproveRCFTM starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_RCFTMId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("qa_rcftm_routines").setParameter("actionType", "approveRCFTM")
						.setParameter("actionValue", value).execute();

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

		logger.info("Method : restapproveRCFTM ends");
		return response;
	}

	// CrqsInspectView
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> crqsInspectView(String id, String orgName, String orgDivision) {
		logger.info("Method : crqsInspectView Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_crqsId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_rcftm_routines")
					.setParameter("actionType", "crqsInspectView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : crqsInspectView Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}

	// addCrqs
	public ResponseEntity<JsonResponse<List<QaCrqsRestModel>>> addingCrqsInspect(List<QaCrqsRestModel> qc) {
		logger.info("Method : addingCrqsInspect dao starts");
		System.out.println(qc);
		JsonResponse<List<QaCrqsRestModel>> resp = new JsonResponse<List<QaCrqsRestModel>>();

		String value = GenerateCrqsParam.getAddcrqsInspect(qc);
		System.out.println("value===" + value);
		System.out.println("Modify qc===" + qc.get(0).getCrqsId());
		try {

			if (qc.get(0).getCrqsId() != null && qc.get(0).getCrqsId() != "") {

				em.createNamedStoredProcedureQuery("qa_rcftm_routines").setParameter("actionType", "addCrqsInspect")
						.setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Saved successfully");

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

		ResponseEntity<JsonResponse<List<QaCrqsRestModel>>> response = new ResponseEntity<JsonResponse<List<QaCrqsRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addingCrqsInspect dao ends");
		return response;

	}

	// CrqsInspectDownload
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> CrqsInspectDownload(String id, String orgName, String orgDivision) {
		logger.info("Method : CrqsInspectDownload Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_crqsId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_rcftm_routines")
					.setParameter("actionType", "CrqsInspectDownload").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : CrqsInspectDownload Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<QaRCFTMRestModel>> saveMasterDetails(QaRCFTMRestModel product) {
		logger.info("Method : saveMasterDetails starts");

		Boolean validity = true;
		JsonResponse<QaRCFTMRestModel> resp = new JsonResponse<QaRCFTMRestModel>();
		resp.setMessage("");
		//resp.setCode("");
		List<QaRCFTMRestModel> newProduct = new ArrayList<QaRCFTMRestModel>();
		if (validity)
			try {
				String values = GenerateRCFTMParam.saveMasterDetails(product);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_rcftm_routines")
						.setParameter("actionType", "saveMasterDetails").setParameter("actionValue", values)
						.getResultList();
				
				for (Object[] m : x) {

					QaRCFTMRestModel item = new QaRCFTMRestModel(m[0], m[1], m[2], m[3]);
					newProduct.add(item);
				}

				resp.setBody(newProduct.get(0));
				//resp.setCode("");
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
		logger.info("resp.getCode()"+resp.getCode());
		/*
		 * if (resp.getCode() == null) { resp.setCode("Success"); }
		 */
		ResponseEntity<JsonResponse<QaRCFTMRestModel>> response = new ResponseEntity<JsonResponse<QaRCFTMRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveMasterDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<QaRCFTMRestModel>> saveItemDetails(QaRCFTMRestModel product) {
		logger.info("Method : saveItemDetails starts");

		Boolean validity = true;
		JsonResponse<QaRCFTMRestModel> resp = new JsonResponse<QaRCFTMRestModel>();
		resp.setMessage("");
		resp.setCode("");
		List<QaRCFTMRestModel> newProduct = new ArrayList<QaRCFTMRestModel>();
		if (validity)
			try {
				String values = GenerateRCFTMParam.saveItemDetails(product);
				
				if (product.getSlNo() != null && product.getSlNo() != "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_rcftm_routines")
						.setParameter("actionType", "modifyItemDetails").setParameter("actionValue", values)
						.getResultList();

				for (Object[] m : x) {

					QaRCFTMRestModel item = new QaRCFTMRestModel(m[0], m[1], m[2], m[3]);
					newProduct.add(item);
				}
			} 
				else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("qa_rcftm_routines")
							.setParameter("actionType", "saveItemDetails").setParameter("actionValue", values)
							.getResultList();

					for (Object[] m : x) {

						QaRCFTMRestModel item = new QaRCFTMRestModel(m[0], m[1], m[2], m[3]);
						newProduct.add(item);
					}
				}
				

				resp.setBody(newProduct.get(0));
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

		ResponseEntity<JsonResponse<QaRCFTMRestModel>> response = new ResponseEntity<JsonResponse<QaRCFTMRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveItemDetails ends");
		return response;
	}

	// getTotalCrqsView
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTotalChildView(String runId,String orgName, String orgDivision) {
		logger.info("Method : getTotalChildView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_runId='" + runId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_rcftm_routines")
					.setParameter("actionType", "getTotalChildView").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalChildView Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editCodeForChildRCFTM(String id, String runChartId,String orgName, String orgDivision) {
		logger.info("Method : editCodeForChildRCFTM Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_slNo='" + id + "',@p_runChartId='" + runChartId + "', @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_rcftm_routines")
					.setParameter("actionType", "editCodeForChildRCFTM").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editCodeForChildRCFTM Dao ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteRCFTMChild(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteRCFTMChild starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_slNo='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("qa_rcftm_routines").setParameter("actionType", "deleteRCFTMChild")
						.setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteRCFTMChild ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> detailsForGraphs(String id,String orgName, String orgDivision, String userId) {

		logger.info("Method : detailsForGraphs Dao startssssssssssssssssssssss");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_rcftm_routines")
					.setParameter("actionType", "detailsForGraphs").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : detailsForGraphs Dao ends" + resp);
		return resp;

	}
}