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
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateParameterSavePlannSchedule;
import nirmalya.aatithya.restmodule.common.utils.projects.GeneratePlanningScheduleParams;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.controller.ProjectCreationRestController;
import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectPlanningSchedulingRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestPlanningSchedulesubModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectExecutionModel;

@Repository

public class ProjectPlanningSchedulingDao {

	Logger logger = LoggerFactory.getLogger(ProjectPlanningSchedulingDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// getprojectNamelist

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getprojectNameList() {
		logger.info("Method : getprojectNamelist dao starts");

		List<DropDownModel> projectNamelist = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
					.setParameter("actionType", "getprojectNameList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				projectNamelist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getprojectNamelist dao ends");
		return projectNamelist;
	}

	@SuppressWarnings("unchecked")
	public List<ProjectPlanningSchedulingRestModel> getProjectNameDetails(String id, String id1) {
		logger.info("Method : getProjectNameDetails Dao starts" + id);
		List<ProjectPlanningSchedulingRestModel> getProjectTypeList = new ArrayList<ProjectPlanningSchedulingRestModel>();
		try {

			String values = "SET @p_getProjectId='" + id + "', @p_id='" + id1 + "';";
			logger.info("Method : getProjectNameDetails Dao starts" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
					.setParameter("actionType", "getProjectNameDetails").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					ProjectPlanningSchedulingRestModel dropDownModel = new ProjectPlanningSchedulingRestModel(m[0],
							m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8].toString());
					getProjectTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getProjectNameDetails Dao ends" + getProjectTypeList);

		return getProjectTypeList;
	}

	// for view project table planning scheduling

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>> viewPlanScheduling() {
		logger.info("Method : viewPlanSchedule starts");
		List<ProjectPlanningSchedulingRestModel> respList = new ArrayList<ProjectPlanningSchedulingRestModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
					.setParameter("actionType", "viewPlanSchedule").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				ProjectPlanningSchedulingRestModel cusData = new ProjectPlanningSchedulingRestModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], null, null, null,
						null, null, null);
				respList.add(cusData);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<ProjectPlanningSchedulingRestModel>> resp = new JsonResponse<List<ProjectPlanningSchedulingRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>> response = new ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewPlanSchedule ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<ProjectCreationRestModel>> getProjectList(String id, String orgName, String orgDiv) {
		logger.info("Method : getProjectList Dao starts" + id);

		List<ProjectCreationRestModel> purchaseOrder = new ArrayList<ProjectCreationRestModel>();
		JsonResponse<List<ProjectCreationRestModel>> resp = new JsonResponse<List<ProjectCreationRestModel>>();

		// String value = "SET @p_userId='" + bomid + "';";
		String value = "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
					.setParameter("actionType", "getprojectlist").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				ProjectCreationRestModel data = new ProjectCreationRestModel(m[0], m[1], null, null, null, null, null,
						null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null);
				purchaseOrder.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(purchaseOrder);

		logger.info("Method : getProjectList Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public List<ProjectPlanningSchedulingRestModel> copyprojectDetails(ProjectPlanningSchedulingRestModel model) {
		logger.info("Method : copyprojectDetails Dao starts" + model);
		List<ProjectPlanningSchedulingRestModel> getProjectTypeList = new ArrayList<ProjectPlanningSchedulingRestModel>();
		try {

			String values = GeneratePlanningScheduleParams.getAddPlan(model);
			logger.info("Method : getProjectNameDetails Dao starts" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
					.setParameter("actionType", "copyprojectDetails").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					ProjectPlanningSchedulingRestModel dropDownModel = new ProjectPlanningSchedulingRestModel(m[0],
							m[1], null, m[2], null, null, m[3], null, null, null, null, null, null, null, null, m[4],
							m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], null, null, null, null,
							null, null);
					getProjectTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : copyprojectDetails Dao ends" + getProjectTypeList);

		return getProjectTypeList;
	}

//
	@SuppressWarnings("unchecked")
	public List<ProjectPlanningSchedulingRestModel> getFirstProjectNmDetails(String id) {
		logger.info("Method : getFirstProjectNmDetails Dao starts" + id);
		List<ProjectPlanningSchedulingRestModel> getProjectTypeList = new ArrayList<ProjectPlanningSchedulingRestModel>();
		try {

			String values = "SET @p_projectId='" + id + "';";
			logger.info("Method : getProjectNameDetails Dao starts" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
					.setParameter("actionType", "getPFirstNameDtls").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

					ProjectPlanningSchedulingRestModel dropDownModel = new ProjectPlanningSchedulingRestModel(m[0],
							m[1], null, m[2], null, null, m[3], null, null, null, null, null, null, null, null, m[4],
							m[5], m[6], null, null, null, null, null, null, null, null, null, null, null, null, null,
							null);
					getProjectTypeList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getFirstProjectNmDetails Dao ends" + getProjectTypeList);

		return getProjectTypeList;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> getAllPlanningCategoryList(String id) {
		logger.info("Method : getAllPlanningCategoryList starts");

		JsonResponse<List<RestProjectCategoryModel>> resp = new JsonResponse<List<RestProjectCategoryModel>>();
		List<RestProjectCategoryModel> newLoc = new ArrayList<RestProjectCategoryModel>();

		try {
			String value = "SET @p_projectId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
					.setParameter("actionType", "getPlanningCategoryList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestProjectCategoryModel item = new RestProjectCategoryModel(m[0], m[1], null, null, m[2], null,
						m[3].toString(), m[4], m[5], m[6], m[7], null);
				newLoc.add(item);
			}

			resp.setBody(newLoc);
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

		ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>> response = new ResponseEntity<JsonResponse<List<RestProjectCategoryModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllPlanningCategoryList ends" + response);
		return response;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>> getAllPlanningSchDtls(String id,
			String id2) {
		logger.info("Method : getAllPlanningSchDtls starts");

		JsonResponse<List<ProjectPlanningSchedulingRestModel>> resp = new JsonResponse<List<ProjectPlanningSchedulingRestModel>>();
		List<ProjectPlanningSchedulingRestModel> newLoc = new ArrayList<ProjectPlanningSchedulingRestModel>();

		try {

			String value = "SET @p_projectIds='" + id + "',@planIds='" + id2 + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
					.setParameter("actionType", "getplanningschdtlsData").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				ProjectPlanningSchedulingRestModel item = new ProjectPlanningSchedulingRestModel(m[0], m[1], m[2],
						m[3].toString(), m[4], m[5].toString(), m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13],
						m[14], m[15], m[16], null);
				newLoc.add(item);
			}

			resp.setBody(newLoc);
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

		ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>> response = new ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllPlanningSchDtls ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> savePlanningScheduleBrowse(RestPlanningSchedulesubModel empDetaails) {
		logger.info("Method : savePlanschedule dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<RestPlanningSchedulesubModel> listData = new ArrayList<RestPlanningSchedulesubModel>();

		try {
			String values = GenerateParameterSavePlannSchedule.getAddParam(empDetaails);
			if (empDetaails.getPlanschid() == null || empDetaails.getPlanschid() == "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
						.setParameter("actionType", "addplanschdatabrowse").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {

						RestPlanningSchedulesubModel dropDownModel = new RestPlanningSchedulesubModel(m[0], m[1]);
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
						.setParameter("actionType", "modifyplanschdata").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {

						RestPlanningSchedulesubModel dropDownModel = new RestPlanningSchedulesubModel(m[0], m[1]);
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : savePlanschedule dao ends");
		return response;
	}

//
	@SuppressWarnings("unchecked")
	public JsonResponse<ProjectPlanningSchedulingRestModel> getPlannScheduleData(String id) {
		logger.info("Method : getPlannScheduleData Dao starts");

		ProjectPlanningSchedulingRestModel purchaseOrder = new ProjectPlanningSchedulingRestModel();
		JsonResponse<ProjectPlanningSchedulingRestModel> resp = new JsonResponse<ProjectPlanningSchedulingRestModel>();

		String value = "SET @p_catId='" + id + "';";
		logger.info("Method : getPlannScheduleData Dao starts" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
					.setParameter("actionType", "getplanschedulepcdata").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				purchaseOrder = new ProjectPlanningSchedulingRestModel(null, m[0], null, null, null, null, null, null,
						m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], null, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(purchaseOrder);
		if (resp.getBody() == null) {
			// resp.setSuccess(false);
			// resp.setCode(ResponseStatus.UNSUCCESS.getCode());
			// resp.setMessage(ResponseStatus.UNSUCCESS.getMessage());

		} else {
			// resp.setSuccess(true);
			// resp.setCode(ResponseStatus.SUCCESS.getCode());
			// resp.setMessage("Data fetched successfully");
		}
		logger.info("Method : getPlannScheduleData Dao ends");
		return resp;

	}

	public ResponseEntity<JsonResponse<Object>> modifyChildData(ProjectPlanningSchedulingRestModel empDetaails) {
		logger.info("Method : modifyChildData dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<ProjectPlanningSchedulingRestModel> listData = new ArrayList<ProjectPlanningSchedulingRestModel>();

		try {
			String values = GenerateParameterSavePlannSchedule.getChildParam(empDetaails);

			em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
					.setParameter("actionType", "modifychild").setParameter("actionValue", values).execute();

		} catch (Exception e) {

			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : modifyChildData dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>> getcategoryData(String id) {
		logger.info("Method : getcategoryData dao starts");
		List<ProjectPlanningSchedulingRestModel> itemNameList = new ArrayList<ProjectPlanningSchedulingRestModel>();
		JsonResponse<List<ProjectPlanningSchedulingRestModel>> resp = new JsonResponse<List<ProjectPlanningSchedulingRestModel>>();
		String value = "SET @p_planningId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
					.setParameter("actionType", "getcategoryData").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				ProjectPlanningSchedulingRestModel dropDownModel = new ProjectPlanningSchedulingRestModel(m[0], m[1],
						m[2], m[3]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>> response = new ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getcategoryData dao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> saveParentData(ProjectPlanningSchedulingRestModel empDetaails) {
		logger.info("Method : saveParentData dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<ProjectPlanningSchedulingRestModel> listData = new ArrayList<ProjectPlanningSchedulingRestModel>();

		try {
			String values = GenerateParameterSavePlannSchedule.getAddParamParent(empDetaails);

			if (empDetaails.getProplanid() == null || empDetaails.getProplanid() == "") {

				em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
						.setParameter("actionType", "addplanparentdata").setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
						.setParameter("actionType", "modifyplanmasterdata").setParameter("actionValue", values)
						.execute();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveParentData dao ends");
		return response;
	}

	//
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveparentDataSchedule(
			List<ProjectPlanningSchedulingRestModel> empDetaails) {
		logger.info("Method : saveparentDataSchedule dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<ProjectPlanningSchedulingRestModel> listData = new ArrayList<ProjectPlanningSchedulingRestModel>();

		try {
			String values = GenerateParameterSavePlannSchedule.getsaveparentData(empDetaails);
			if ((empDetaails.get(0).getProplanid() == null && empDetaails.get(0).getPlaaningMainId() == null)
					|| (empDetaails.get(0).getProplanid() == "" && empDetaails.get(0).getPlaaningMainId() == "")) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
						.setParameter("actionType", "addparentData").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {

						ProjectPlanningSchedulingRestModel dropDownModel = new ProjectPlanningSchedulingRestModel(m[0],
								m[1]);
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			else if ((empDetaails.get(0).getProplanid() != null && empDetaails.get(0).getPlaaningMainId() == null)
					|| (empDetaails.get(0).getProplanid() != "" && empDetaails.get(0).getPlaaningMainId() == "")) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
						.setParameter("actionType", "addsecondparentData").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {

						ProjectPlanningSchedulingRestModel dropDownModel = new ProjectPlanningSchedulingRestModel(m[0],
								m[1]);
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				String valuesModify = GenerateParameterSavePlannSchedule.modifyParentPlanning(empDetaails);
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
						.setParameter("actionType", "modifyparentDataPlanning")
						.setParameter("actionValue", valuesModify).getResultList();

				try {
					for (Object[] m : x) {

						ProjectPlanningSchedulingRestModel dropDownModel = new ProjectPlanningSchedulingRestModel(m[0],
								m[1]);
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveparentDataSchedule dao ends");
		return response;
	}

//	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> savechildDataSchedule(
			List<ProjectPlanningSchedulingRestModel> empDetaails) {
		logger.info("Method : saveparentDataSchedule dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<ProjectPlanningSchedulingRestModel> listData = new ArrayList<ProjectPlanningSchedulingRestModel>();

		try {
			String values = GenerateParameterSavePlannSchedule.getsavechildData(empDetaails);
			if ((empDetaails.get(0).getProplanid() != null && empDetaails.get(0).getPlaaningMainId() == null)
					|| (empDetaails.get(0).getProplanid() != "" && empDetaails.get(0).getPlaaningMainId() == "")) {

				String valueChildData = GenerateParameterSavePlannSchedule.getsavechildData(empDetaails);
				logger.info("in iff valueChildData-------------" + valueChildData);
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
						.setParameter("actionType", "addchilddata").setParameter("actionValue", valueChildData)
						.getResultList();

				try {
					for (Object[] m : x) {

						ProjectPlanningSchedulingRestModel dropDownModel = new ProjectPlanningSchedulingRestModel(m[0],
								m[1]);
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {

				logger.info("in else values-------------" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
						.setParameter("actionType", "modifychilddata").setParameter("actionValue", values)
						.getResultList();

				try {
					for (Object[] m : x) {

						ProjectPlanningSchedulingRestModel dropDownModel = new ProjectPlanningSchedulingRestModel(m[0],
								m[1]);
						listData.add(dropDownModel);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveparentDataSchedule dao ends");
		return response;
	}

	/*
	 * // auto search
	 * 
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<DropDownModel>>>
	 * getPrecedAutoSearchListPlanning(String id, String projectId) {
	 * logger.info("Method : getPrecedAutoSearchListPlanning dao starts");
	 * List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
	 * JsonResponse<List<DropDownModel>> resp = new
	 * JsonResponse<List<DropDownModel>>(); String value = "SET @p_searchValue='" +
	 * id + "',@p_projectId='" + projectId + "';"; System.out.println("value" +
	 * value); try { List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
	 * .setParameter("actionType",
	 * "getPrecedAutosearch").setParameter("actionValue", value) .getResultList();
	 * for (Object[] m : x) { DropDownModel dropDownModel = new DropDownModel(m[0],
	 * m[1]); itemNameList.add(dropDownModel); } resp.setBody(itemNameList); } catch
	 * (Exception e) { e.printStackTrace(); }
	 * ResponseEntity<JsonResponse<List<DropDownModel>>> response = new
	 * ResponseEntity<JsonResponse<List<DropDownModel>>>( resp, HttpStatus.CREATED);
	 * logger.info("Method : getPrecedAutoSearchListPlanning dao ends" + response);
	 * return response; }
	 */
//
	// FOR PROJECT planning DELETE

	public ResponseEntity<JsonResponse<Object>> deleteProjectPlan(String id, String exeId) {
		logger.info("Method : deleteProjectPlan starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_taskId='" + id + "',@p_planId='" + exeId + "';";
				em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
						.setParameter("actionType", "deleteProjectPlan").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteProjectPlan ends");
		return response;
	}
	//
	// FOR PROJECT planning DELETE

	public ResponseEntity<JsonResponse<Object>> deleteProjectPlanChild(String id, String pId, String proId) {
		logger.info("Method : deleteProjectPlanChild starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_taskId='" + id + "',@p_taskPId='" + pId + "',@p_projectId='" + proId + "';";
				em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
						.setParameter("actionType", "deleteProjectPlanChild").setParameter("actionValue", value)
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

		logger.info("Method : deleteProjectPlanChild ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> calculationdatetime(String startDt,String endDt) {
		logger.info("Method : calculationdatetime dao starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @startdate='" + startDt + "',@p_enddate='"+endDt+"';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningschedulingroutines")
					.setParameter("actionType", "getCalculationdatetime").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : calculationdatetime dao ends"+response);
		return response;
	}
}
