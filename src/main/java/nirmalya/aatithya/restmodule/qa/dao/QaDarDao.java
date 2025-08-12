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
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateDarParam;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.QaDarRestModel;

import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class QaDarDao {

	Logger logger = LoggerFactory.getLogger(QaDarDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> brandList(String org, String orgDiv) {
		logger.info("Method : brandList Dao starts");

		List<DropDownModel> brandList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_dar_routines")
					.setParameter("actionType", "brandList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				brandList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : brandList Dao ends");

		return brandList;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> machineList(String id, String orgName, String orgDivision) {
		logger.info("Method : machineList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_dar_routines")
					.setParameter("actionType", "machineList").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : machineList Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}

	// add

	public ResponseEntity<JsonResponse<List<QaDarRestModel>>> addDar(List<QaDarRestModel> qc) {
		logger.info("Method : addDar dao starts");
		System.out.println(qc);
		JsonResponse<List<QaDarRestModel>> resp = new JsonResponse<List<QaDarRestModel>>();

		String value = GenerateDarParam.getAddDar(qc);
		System.out.println("value===" + value);
		// System.out.println("Modify qc===" + qc.get(0).getWcrId());
		try {

			if (qc.get(0).getDarId() != null && qc.get(0).getDarId() != "") {

				em.createNamedStoredProcedureQuery("qa_dar_routines").setParameter("actionType", "modifyDar")
						.setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_dar_routines").setParameter("actionType", "addDar")
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

		ResponseEntity<JsonResponse<List<QaDarRestModel>>> response = new ResponseEntity<JsonResponse<List<QaDarRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addDar dao ends");
		return response;

	}

	// view

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> darView(String orgName, String orgDivision) {
		logger.info("Method : darView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_dar_routines")
					.setParameter("actionType", "darView").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : darView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	// edit

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editDar(String id, String orgName, String orgDivision) {
		logger.info("Method : editDar Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_DarId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_dar_routines")
					.setParameter("actionType", "editDar").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editDar Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}

	// approve

	public ResponseEntity<JsonResponse<Object>> approveDar(String id, String userId, String orgName,
			String orgDivision) {
		logger.info("Method : approveDar dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_darId='" + id + "',@p_userId='" + userId + "',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDivision + "';";
			System.out.println("value==" + value);
			em.createNamedStoredProcedureQuery("qa_dar_routines").setParameter("actionType", "approveDar")
					.setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
			resp.setMessage("Approved");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : approveDar dao ends");
		return response;
	}

	// Delete

	public ResponseEntity<JsonResponse<Object>> deleteDar(String id, String userId, String orgName,
			String orgDivision) {
		logger.info("Method : deleteDar dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_darId='" + id + "',@p_userId='" + userId + "',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDivision + "';";
			System.out.println("value==" + value);
			em.createNamedStoredProcedureQuery("qa_dar_routines").setParameter("actionType", "deleteDar")
					.setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
			resp.setMessage("Deleted");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteDar dao ends");
		return response;
	}

	// download Dar

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> downloadDar(String id, String orgName, String orgDivision) {
		logger.info("Method : downloadDar Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_DarId ='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_dar_routines")
					.setParameter("actionType", "downloadDar").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : downloadDar Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}

}
