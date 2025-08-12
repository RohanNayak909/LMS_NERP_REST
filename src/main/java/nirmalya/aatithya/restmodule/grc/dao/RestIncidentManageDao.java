package nirmalya.aatithya.restmodule.grc.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.grc.model.RestIncidentManageModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateIncidentManageParameters;

@Repository
public class RestIncidentManageDao {

	Logger logger = LoggerFactory.getLogger(RestIncidentManageDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/* DAO Add */

	public ResponseEntity<JsonResponse<Object>> addManageDao(RestIncidentManageModel restData) {
		logger.info("Method : Rest addManageDao   starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {
				String values = GenerateIncidentManageParameters.getIncidentManageParam(restData);

				if (restData.getAssignNo() == null || restData.getAssignNo() == "") {
					em.createNamedStoredProcedureQuery("goalIncidentManageMaster")
							.setParameter("actionType", "addIncidentManage").setParameter("actionValue", values)
							.execute();
				} else {
					em.createNamedStoredProcedureQuery("goalIncidentManageMaster")
							.setParameter("actionType", "modifyIncidentManage").setParameter("actionValue", values)
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

		logger.info("Method : Rest addManage Dao ends");
		return response;

	}

	/* Auto SearchList */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAssignToAutoSearchList(String id) {
		logger.info("Method : getAssignToAutoSearchList dao starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goalIncidentManageMaster")
					.setParameter("actionType", "getAssignToAutoSearchList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAssignToAutoSearchList dao ends");
		return response;
	}

	/* view */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestIncidentManageModel>> viewManageDao(String id, String uId, String orgName,
			String orgDivision) {
		logger.info("Method : viewManageDao starts");

		List<RestIncidentManageModel> viewManageData = new ArrayList<RestIncidentManageModel>();
		JsonResponse<List<RestIncidentManageModel>> resp = new JsonResponse<List<RestIncidentManageModel>>();
		try {
			String values = "SET @p_createdBy='" + uId + "',@p_organization='" + orgName + "',@p_orgDivision='"
					+ orgDivision + "',@p_incidentNo='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goalIncidentManageMaster")
					.setParameter("actionType", "viewIncidentManage").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				RestIncidentManageModel restManageData = new RestIncidentManageModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9]);
				viewManageData.add(restManageData);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(viewManageData);
		logger.info("Method : viewManage Dao ends");
		return resp;
	}

	/* edit */

	@SuppressWarnings("unchecked")
	public JsonResponse<RestIncidentManageModel> editManageDao(String id, String uId, String orgName,
			String orgDivision) {
		logger.info("Method : editManage Dao starts");
		RestIncidentManageModel req = new RestIncidentManageModel();
		JsonResponse<RestIncidentManageModel> resp = new JsonResponse<RestIncidentManageModel>();
		try {
			String value = "SET @p_assignNo='" + id + "',@p_createdBy='" + uId + "',@p_organization='" + orgName
					+ "',@p_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goalIncidentManageMaster")
					.setParameter("actionType", "editIncidentManage").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestIncidentManageModel restDaata = new RestIncidentManageModel(m[0], null, null, m[1], m[2], m[3],
						m[4], null, null, null);
				req = restDaata;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editManage Dao ends");
		return resp;
	}

	/* delete */

	public ResponseEntity<JsonResponse<Object>> deleteManageDao(String id, String uId, String orgName,
			String orgDivision) {
		logger.info("Method : deleteManageDao starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assignNo='" + id + "',@p_createdBy='" + uId + "',@p_organization='" + orgName
						+ "',@p_orgDivision='" + orgDivision + "';";

				em.createNamedStoredProcedureQuery("goalIncidentManageMaster")
						.setParameter("actionType", "deleteIncidentManage").setParameter("actionValue", value)
						.execute();

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

		logger.info("Method : deleteManageDao ends");
		return response;
	}

}
