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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateQcMasterParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.QcMasterRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class QcMasterDao {
	Logger logger = LoggerFactory.getLogger(QcMasterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// getparameterLists
	/*
	 * @SuppressWarnings("unchecked") public List<DropDownModel>
	 * getparameterLists(String org, String orgDiv) {
	 * logger.info("Method : getparameterLists Dao starts");
	 * 
	 * List<DropDownModel> itemList = new ArrayList<DropDownModel>();
	 * 
	 * try { String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
	 * List<Object[]> x = em.createNamedStoredProcedureQuery("qa_master_routines")
	 * .setParameter("actionType", "getparameterlists").setParameter("actionValue",
	 * value).getResultList();
	 * 
	 * for (Object[] m : x) { DropDownModel dropDownModel = new DropDownModel(m[0],
	 * m[1]); itemList.add(dropDownModel); } } catch (Exception e) {
	 * e.printStackTrace(); } logger.info("Method : getparameterLists Dao ends");
	 * return itemList; }
	 */

//getitemnameList
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getitemnameList(String org, String orgDiv) {
		logger.info("Method : getitemnameList Dao starts");
		List<DropDownModel> itemnamelist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_master_routines")
					.setParameter("actionType", "getitemnamelist").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemnamelist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getitemnamelist Dao ends");
		return itemnamelist;
	}

	// Get Parameter List.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getParameterList(String orgName, String orgDivision) {
		logger.info("Method : getParameterList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			// System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_master_routines")
					.setParameter("actionType", "getParameterList").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getParameterList Dao ends");
		// System.out.println("resp****************************" + resp);
		return resp;

	}

	// addQc
	public ResponseEntity<JsonResponse<List<QcMasterRestModel>>> addQc(List<QcMasterRestModel> qc) {
		logger.info("Method : addQc dao starts");
		// System.out.println(qc);
		JsonResponse<List<QcMasterRestModel>> resp = new JsonResponse<List<QcMasterRestModel>>();

		String value = GenerateQcMasterParam.getAddqc(qc);
		// System.out.println("value===" + value);
		// System.out.println("Modify qc===" + qc.get(0).getQcId());
		try {
			System.out.println("c.get(0).getQcId()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + qc.get(0).getQcId());
			System.out.println("value>>>>>>>>>>>-----------" + value);

			if (qc.get(0).getQcId() != null && qc.get(0).getQcId() != "") {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Modify>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("value>>>>>>>>>>>-----------" + value);
				em.createNamedStoredProcedureQuery("qa_master_routines").setParameter("actionType", "modifyqc")
						.setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Save>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				em.createNamedStoredProcedureQuery("qa_master_routines").setParameter("actionType", "addqc")
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

		ResponseEntity<JsonResponse<List<QcMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<QcMasterRestModel>>>(
				resp, HttpStatus.CREATED);
		// System.out.println("response===" + response);
		logger.info("Method : addQc dao ends");
		return response;

	}

	// viewQc
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewQc(String orgName, String orgDivision) {
		logger.info("Method : viewQc Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			// System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_master_routines")
					.setParameter("actionType", "viewQc").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewQc Dao ends");
		// System.out.println("resp****************************" + resp);
		return resp;

	}

	// editQc
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editQc(String id, String orgName, String orgDivision) {
		logger.info("Method : editQc Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_qcId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			// System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_master_routines")
					.setParameter("actionType", "editQc").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editQc Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}

	// deleteQc
	public ResponseEntity<JsonResponse<Object>> deleteQc(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteQc starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_qcId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				// System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("qa_master_routines").setParameter("actionType", "deleteQc")
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

		logger.info("Method : deleteQc ends");
		// System.out.println("DELETEE" + response);
		return response;
	}

	// Add New Parameter.

	public ResponseEntity<JsonResponse<List<QcMasterRestModel>>> addNewParameter(List<QcMasterRestModel> qc) {
		logger.info("Method : addNewParameter dao starts");
		// System.out.println(qc);
		JsonResponse<List<QcMasterRestModel>> resp = new JsonResponse<List<QcMasterRestModel>>();

		String value = GenerateQcMasterParam.getAddNewParameter(qc);
		// System.out.println("value===" + value);

		try {

			em.createNamedStoredProcedureQuery("qa_master_routines").setParameter("actionType", "addNewParameter")
					.setParameter("actionValue", value).execute();

			resp.setCode("Success");
			resp.setMessage("Data saved successfully");

		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				// Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<List<QcMasterRestModel>>> response = new ResponseEntity<JsonResponse<List<QcMasterRestModel>>>(
				resp, HttpStatus.CREATED);
		// System.out.println("response===" + response);
		logger.info("Method : addNewParameter dao ends");
		return response;

	}

	// Formula Column.

	// Field List.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getFieldList(String orgName, String orgDivision) {
		logger.info("Method : getFieldList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			// System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_master_routines")
					.setParameter("actionType", "getFieldList").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getFieldList Dao ends");
		// System.out.println("resp****************************" + resp);
		return resp;

	}

	// Parameter List For Calculation.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getParamFieldList(String orgName, String orgDivision) {
		logger.info("Method : getParamFieldList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			// System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_master_routines")
					.setParameter("actionType", "getParamFieldList").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getParamFieldList Dao ends");
		// System.out.println("resp****************************" + resp);
		return resp;

	}

	// Add Field

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addField(String orgName, String orgDivision, String userId, String fvalue) {
		logger.info("Method : addField Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId
					+ "',@p_value='" + fvalue + "';";
			// System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("qa_master_routines").setParameter("actionType", "addField")
					.setParameter("actionValue", value).execute();
			resp.setCode("Success");
			resp.setMessage("Saved Succesfully");
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();

		}
		logger.info("Method : addField Dao ends");
		// System.out.println("resp****************************" + resp);
		return resp;

	}

	// Add Formula.

	/*
	 * public ResponseEntity<JsonResponse<List<QcMasterRestModel>>>
	 * addNewFormula(List<QcMasterRestModel> qc) {
	 * logger.info("Method : addNewFormula dao starts"); //System.out.println(qc);
	 * JsonResponse<List<QcMasterRestModel>> resp = new
	 * JsonResponse<List<QcMasterRestModel>>();
	 * 
	 * String value = GenerateQcMasterParam.getAddNewFormula(qc);
	 * System.out.println("value===" + value);
	 * 
	 * try {
	 * 
	 * em.createNamedStoredProcedureQuery("qa_master_routines").setParameter(
	 * "actionType", "addNewFormula") .setParameter("actionValue", value).execute();
	 * 
	 * resp.setCode("Success"); resp.setMessage("Data saved successfully");
	 * 
	 * } catch (Exception e) {
	 * 
	 * try { String[] err = serverDao.errorProcedureCall(e); e.printStackTrace();
	 * resp.setCode(err[0]); resp.setMessage(err[1]); //Util.setJsonResponse(resp,
	 * null, ResponseStatus.failed, err[1]); } catch (Exception e1) {
	 * e1.printStackTrace(); e.printStackTrace(); Util.setJsonResponse(resp, null,
	 * ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION); }
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * ResponseEntity<JsonResponse<List<QcMasterRestModel>>> response = new
	 * ResponseEntity<JsonResponse<List<QcMasterRestModel>>>( resp,
	 * HttpStatus.CREATED); //System.out.println("response===" + response);
	 * logger.info("Method : addNewFormula dao ends"); return response;
	 * 
	 * }
	 */

}
