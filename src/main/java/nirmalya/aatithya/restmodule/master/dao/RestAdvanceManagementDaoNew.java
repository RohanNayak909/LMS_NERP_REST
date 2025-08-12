package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAdvanceManagementParamNew;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModelNew;

@Repository
public class RestAdvanceManagementDaoNew {
	Logger logger = LoggerFactory.getLogger(RestAdvanceManagementDaoNew.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// private Object value;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRequisitionList() {
		logger.info("Method : getRequisitionList starts");

		List<DropDownModel> getRequisitionList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsadvancepolicyroutines")
					.setParameter("actionType", "getRequisitionList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRequisitionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getRequisitionList ends");

		return getRequisitionList;
	}

	// For add
	public ResponseEntity<JsonResponse<Object>> addAdvManagement(RestAdvanceManagementModelNew req) {
		logger.info("Method : addAdvancePolicy starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("ADDDDDDDDDDDDD" + req.getReqId());
		try {
			logger.info("ADDDDDDDDDDDDD" + req.getReqId());
			String values = GenerateAdvanceManagementParamNew.getAdvManageParam(req);

			if (req.getReqId() == null || req.getReqId() == "") {

				em.createNamedStoredProcedureQuery("hrmsadvancepolicyroutines")
						.setParameter("actionType", "addAdvancePolicy").setParameter("actionValue", values).execute();
			} else {

				em.createNamedStoredProcedureQuery("hrmsadvancepolicyroutines")
						.setParameter("actionType", "modifyPolicy").setParameter("actionValue", values).execute();
			}

		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		logger.info("respfvbnm" + resp);

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("respfvbnmcfggggggggggggggggggggggggf" + response);

		logger.info("Method : addAdvancePolicy ends");
		return response;
	}

	// View

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestAdvanceManagementModelNew>> viewAdvManagement(String org, String orgDiv) {
		logger.info("Method : viewAdvancePolicy  Dao starts");

		List<RestAdvanceManagementModelNew> viewReimbursementTravels = new ArrayList<RestAdvanceManagementModelNew>();

		JsonResponse<List<RestAdvanceManagementModelNew>> resp = new JsonResponse<List<RestAdvanceManagementModelNew>>();
		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='"+orgDiv +"';";
			

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsadvancepolicyroutines")
					.setParameter("actionType", "viewAdvPolicy").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				Object DATE = null;
				if (m[1] != null) {

					DATE = m[1].toString();
				}
				RestAdvanceManagementModelNew restStudentModel = new RestAdvanceManagementModelNew(m[0], DATE, m[2],
						(Double) m[3], m[4], m[5], m[6]);

				viewReimbursementTravels.add(restStudentModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// logger.info("viewAdvManagement" + resp);
		resp.setBody(viewReimbursementTravels);
		logger.info("Method : viewAdvancePolicy  Dao ends");
		return resp;
	}

	// edit

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAdvanceManagementModelNew>>> editPolicy(String id) {
		logger.info("Method : edit starts");

		JsonResponse<List<RestAdvanceManagementModelNew>> resp = new JsonResponse<List<RestAdvanceManagementModelNew>>();
		List<RestAdvanceManagementModelNew> newResp = new ArrayList<RestAdvanceManagementModelNew>();

		try {
			String value = "SET @p_getReqId='" + id + "';";
			logger.info("@@@@@@@@@@@@@@@@@@@" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsadvancepolicyroutines")
					.setParameter("actionType", "editPolicy").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				Object date = null;
				if (m[1] != null) {
					date = DateFormatter.returnStringDate(m[1]);
					date = date.toString();
					logger.info("DATEEE" + date);
				}
				RestAdvanceManagementModelNew restStudentModule = new RestAdvanceManagementModelNew(m[0], date, m[2],
						(Double) m[3], m[4], m[5], m[6]);
				newResp.add(restStudentModule);
				logger.info("RestStudentModel" + restStudentModule);
			}

			resp.setBody(newResp);
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

		ResponseEntity<JsonResponse<List<RestAdvanceManagementModelNew>>> response = new ResponseEntity<JsonResponse<List<RestAdvanceManagementModelNew>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : edit ends");
		return response;
	}

	/*
	 * delete
	 */

	public ResponseEntity<JsonResponse<Object>> deletePolicy(String id) {
		logger.info("Method : deletePolicy starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_getReqId='" + id + "';";

				em.createNamedStoredProcedureQuery("hrmsadvancepolicyroutines")
						.setParameter("actionType", "deletePolicy").setParameter("actionValue", value).execute();

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

		logger.info("Method : deletePolicy ends");
		logger.info("DELETEE" + response);
		return response;
	}

}
