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
import nirmalya.aatithya.restmodule.common.utils.GenerateFeedBackParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestRequestFeedBackModel;

@Repository
public class RequestFeedBackRestDao {

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	Logger logger = LoggerFactory.getLogger(RequestFeedBackRestDao.class);

	////

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestRequestFeedBackModel>>> getEmployeeNameList() {
		logger.info("Method : getEmployeeNameList starts");

		JsonResponse<List<RestRequestFeedBackModel>> resp = new JsonResponse<List<RestRequestFeedBackModel>>();
		resp.setMessage("");
		resp.setCode("");
		List<RestRequestFeedBackModel> roleList = new ArrayList<RestRequestFeedBackModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("EmployeeroleRoutines")
					.setParameter("actionType", "getEmployeeNameList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestRequestFeedBackModel dropDownModel = new RestRequestFeedBackModel(m[0], m[1]);
				roleList.add(dropDownModel);
			}
			resp.setBody(roleList);
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

		ResponseEntity<JsonResponse<List<RestRequestFeedBackModel>>> response = new ResponseEntity<JsonResponse<List<RestRequestFeedBackModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response====" + response);
		logger.info("Method : getEmployeeNameList ends");

		return response;
	}

	// add

	public ResponseEntity<JsonResponse<Object>> addEmployeeFeedBack(RestRequestFeedBackModel id) {
		logger.info("Method : addEmployeeFeedBack starts");
		logger.info("ADDDDDDD" + id);
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String values = GenerateFeedBackParam.saveFeedBackRequest(id);
			if (id.getAddId() != null && id.getAddId() != "") {
				logger.info("if");
				em.createNamedStoredProcedureQuery("EmployeeroleRoutines")
				.setParameter("actionType", "modifyEmployeeFeedBack").setParameter("actionValue", values)
				.execute();
			} else {

				logger.info("else");
				em.createNamedStoredProcedureQuery("EmployeeroleRoutines")
						.setParameter("actionType", "addEmployeeFeedBack").setParameter("actionValue", values)
						.execute();
			}

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

		logger.info("Method : addEmployeeFeedBack ends");
		return response;
	}

	/*
	 * // Add addEmployeeFeedBack
	 * 
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<RestRequestFeedBackModel>>>
	 * addEmployeeFeedBack( List<RestRequestFeedBackModel> restRequestFeedBackModel)
	 * { logger.info("Method : addEmployeeFeedBack starts");
	 * JsonResponse<List<RestRequestFeedBackModel>> resp = new
	 * JsonResponse<List<RestRequestFeedBackModel>>();
	 * List<RestRequestFeedBackModel> listData = new
	 * ArrayList<RestRequestFeedBackModel>(); try { String values =
	 * GenerateFeedBackParam.saveFeedBackRequest(restRequestFeedBackModel);
	 * 
	 * if (restRequestFeedBackModel.get(0).getAddId() == null ||
	 * restRequestFeedBackModel.get(0).getAddId() == "") {
	 * em.createNamedStoredProcedureQuery("EmployeeroleRoutines")
	 * .setParameter("actionType",
	 * "addEmployeeFeedBack").setParameter("actionValue", values) .execute(); } else
	 * { em.createNamedStoredProcedureQuery("EmployeeroleRoutines")
	 * .setParameter("actionType",
	 * "modifyEmployeeFeedBack").setParameter("actionValue", values) .execute(); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]);
	 * 
	 * } catch (Exception e1) { e1.printStackTrace(); } } resp.setBody(listData);
	 * ResponseEntity<JsonResponse<List<RestRequestFeedBackModel>>> response = new
	 * ResponseEntity<JsonResponse<List<RestRequestFeedBackModel>>>( resp,
	 * HttpStatus.CREATED); logger.info("Method : addEmployeeFeedBack ends"); return
	 * response; }
	 */
}
