package nirmalya.aatithya.restmodule.projects.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DynamicQueryBuilder;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.productionplan.GenerateParamRmPmRequisition;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.MasterWarehouseModel;
import nirmalya.aatithya.restmodule.productionplan.model.RmPmRequisitionRestModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectPlanningRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ProjectPlanningDao {
	Logger logger = LoggerFactory.getLogger(ProjectPlanningDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// getProjectTypeList
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPriorityList() {
		logger.info("Method : getPriorityList starts");

		List<DropDownModel> priorityList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("project_planning_routines_v1")
					.setParameter("actionType", "getPriorityList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				priorityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPriorityList ends");
		return priorityList;
	}

	/* restAddProjectPlanning */
	public ResponseEntity<JsonResponse<Object>> restAddProjectPlanning(List<ProjectPlanningRestModel> projectPlanning) {

		logger.info("Method in Dao: restAddProjectPlanning starts" + projectPlanning);

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {

			String values = DynamicQueryBuilder.buildDynamicQuery(projectPlanning.get(0));
			logger.info("values for project planning=================>"+values);
			if (projectPlanning.get(0).getParentId() != "" && projectPlanning.get(0).getParentId() != null) {
				em.createNamedStoredProcedureQuery("project_planning_routines_v1")
						.setParameter("actionType", "modifyProjectPlanning").setParameter("actionValue", values)
						.execute();
				resp.setCode("Success");
				resp.setMessage("Task Modified Successfully");

			} else {
				em.createNamedStoredProcedureQuery("project_planning_routines_v1")
						.setParameter("actionType", "addProjectPlanning").setParameter("actionValue", values).execute();
				resp.setCode("Success");
				resp.setMessage("Task Added Successfully");

			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: restAddProjectPlanning ends");

		return response;
	}

	// getAssignedToAutoSearchList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAssignedToAutoSearchList(String id) {
		logger.info("Method : getAssignedToAutoSearchList dao starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("project_planning_routines_v1")
					.setParameter("actionType", "getAssignedTo").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (itemNameList.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
			resp.setBody(itemNameList);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAssignedToAutoSearchList dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllTaskByProjectId(String orgName, String orgDivision, String id) {
		logger.info("Method : getAllPrigetAllTaskByProjectIdojectById Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("project_planning_routines_v1")
					.setParameter("actionType", "getAlllTask").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAllTaskByProjectId Dao ends");
		return resp;

	}

	/* editTaskParentDetails */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editTaskParentDetails(String orgName, String orgDivision, String id) {
		logger.info("Method : editTaskParentDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("project_planning_routines_v1")
					.setParameter("actionType", "getAlllTaskEdit").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editTaskParentDetails Dao ends");
		return resp;

	}

	/* addChildProjectPlanning */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addChildProjectPlanning(
			List<ProjectPlanningRestModel> projectPlanning) {

		logger.info("Method in Dao: addChildProjectPlanning starts" + projectPlanning);

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {

			String values = DynamicQueryBuilder.buildDynamicQuery(projectPlanning.get(0));
			if (projectPlanning.get(0).getParentId() != "" && projectPlanning.get(0).getParentId() != null
					&& projectPlanning.get(0).getPlanChildId() != null
					&& projectPlanning.get(0).getPlanChildId() != "") {
				em.createNamedStoredProcedureQuery("project_planning_routines_v1")
						.setParameter("actionType", "ModifyProjectChildTask").setParameter("actionValue", values)
						.execute();

				resp.setCode("Success");
				resp.setMessage("Child Task Modified Successfully");

			} else {
				em.createNamedStoredProcedureQuery("project_planning_routines_v1")
						.setParameter("actionType", "addProjectChildTask").setParameter("actionValue", values)
						.execute();
				resp.setCode("Success");
				resp.setMessage("Child Task Added Successfully");

			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addChildProjectPlanning ends");

		return response;
	}

	/* taskVersionDetails */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> taskVersionDetails(String orgName, String orgDivision, String id) {
		logger.info("Method : taskVersionDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("project_planning_routines_v1")
					.setParameter("actionType", "getAllVersion").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setCode("Success");
			resp.setMessage("Version Fetched SuccessFully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : taskVersionDetails Dao ends");
		return resp;

	}

	/* addRmPmRequisition */
	public ResponseEntity<JsonResponse<RmPmRequisitionRestModel>> addRmPmRequisition(RmPmRequisitionRestModel qc) {
		logger.info("Method : addRmPmRequisition dao starts");
		System.out.println(qc);
		JsonResponse<RmPmRequisitionRestModel> resp = new JsonResponse<RmPmRequisitionRestModel>();

		try {
			String value = GenerateParamRmPmRequisition.getRmPmRequisition(qc);

			if (qc.getReqId() != null && qc.getReqId() != "") {

				em.createNamedStoredProcedureQuery("project_planning_routines_v1")
						.setParameter("actionType", "modifyRmPmRequisition").setParameter("actionValue", value)
						.execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				System.out.println("value for add requsition====> " + value);
				em.createNamedStoredProcedureQuery("project_planning_routines_v1")
						.setParameter("actionType", "addRmPmRequisition").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<RmPmRequisitionRestModel>> response = new ResponseEntity<JsonResponse<RmPmRequisitionRestModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addRmPmRequisition dao ends");
		return response;

	}

	/* getAllRequisitionById */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllRequisitionById(String orgName, String orgDivision, String id) {
		logger.info("Method : getAllRequisitionById Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("project_planning_routines_v1")
					.setParameter("actionType", "getAllRequisition").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAllRequisitionById Dao ends");
		return resp;

	}

	public ResponseEntity<JsonResponse<Object>> saveDprDetails(ProjectPlanningRestModel data) {
		logger.info("Method : saveDprDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(data);

			System.out.println("Value is coming---------------> " + values);
			if (data.getDrpId() != null && data.getDrpId() != "") {
				em.createNamedStoredProcedureQuery("project_execution_routines_v1")
						.setParameter("actionType", "modifyDpr").setParameter("actionValue", values).execute();

				resp.setMessage("Data updated successfully");
			} else {

				em.createNamedStoredProcedureQuery("project_execution_routines_v1").setParameter("actionType", "addDpr")
						.setParameter("actionValue", values).execute();
				resp.setMessage("Data saved successfully");
			}
			resp.setCode("success");
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveDprDetails ends");
		return response;
	}

	/* getAllTAskDpr */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllTAskDpr(String orgName, String orgDivision, String id) {
		logger.info("Method : getAllTAskDpr Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("project_execution_routines_v1")
					.setParameter("actionType", "getAllTAskDpr").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAllTAskDpr Dao ends");
		return resp;

	}
}