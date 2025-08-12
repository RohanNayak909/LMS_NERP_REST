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
import nirmalya.aatithya.restmodule.common.utils.qa.GeneratePcroCheckList;
import nirmalya.aatithya.restmodule.common.utils.qa.GeneratePcroParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.QaPcroRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestPcroCheckListModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;
@Repository
public class RestQaPcroChecklistDao {
	Logger logger = LoggerFactory.getLogger(RestQaPcroChecklistDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPcroSlNo(String orgName, String orgDivision) {
		logger.info("Method : getShiftSlno Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values---->>>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_pcro_checklist_routines")
					.setParameter("actionType", "getSlno").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getShiftSlno Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}
	
	// add 
	
	public ResponseEntity<JsonResponse<List<RestPcroCheckListModel>>> addPcroCheckList(List<RestPcroCheckListModel> qc) {
		logger.info("Method : addPcroCheckList dao starts");
		System.out.println(qc);
		JsonResponse<List<RestPcroCheckListModel>> resp = new JsonResponse<List<RestPcroCheckListModel>>();

		String value = GeneratePcroCheckList.getAddpcro(qc);
		System.out.println("value===" + value);
		System.out.println("Modify qc===" + qc.get(0).getPcroCheckListId());
		try {

			if (qc.get(0).getPcroCheckListId() != null && qc.get(0).getPcroCheckListId() != "" && qc.get(0).getPcroCheckListId() != "null") {

				em.createNamedStoredProcedureQuery("qa_pcro_checklist_routines")
						.setParameter("actionType", "modifypcro").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_pcro_checklist_routines")
						.setParameter("actionType", "addpcro").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<List<RestPcroCheckListModel>>> response = new ResponseEntity<JsonResponse<List<RestPcroCheckListModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addQc dao ends");
		return response;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTotalPcroCheckListView(String orgName, String orgDivision) {
		logger.info("Method : getTotalPcroCheckListView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_pcro_checklist_routines")
					.setParameter("actionType", "getPcroView").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalPcroCheckListView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}
	
	
	// editPcro
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editCodePcroCheckList(String id, String orgName, String orgDivision) {
		logger.info("Method : editPcroView Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_pcroId='" + id + "';";
			System.out.println("values***" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_pcro_checklist_routines")
					.setParameter("actionType", "editPcroView").setParameter("actionValue", value).getResultList();
			logger.info("test------"+x.toString());
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editPcroView Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}
	
	
	
	// deletePcro
	public ResponseEntity<JsonResponse<Object>> deletePcroCheckList(String id, String orgName, String orgDivision) {
		logger.info("Method : deletePcroCheckList starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

			try {

				String value = "SET @p_pcroCheckListId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD---->" + value);
				em.createNamedStoredProcedureQuery("qa_pcro_checklist_routines")
						.setParameter("actionType", "deletePcroData").setParameter("actionValue", value).execute();

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

		logger.info("Method : deletePcroCheckList ends");
		System.out.println("DELETEE" + response);
		return response;
	}
}
