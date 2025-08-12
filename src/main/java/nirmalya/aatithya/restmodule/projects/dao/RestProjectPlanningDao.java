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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

import nirmalya.aatithya.restmodule.common.utils.projects.GenerateParameterSavePlannSchedule;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.projects.model.ProjectPlanningSchedulingRestModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.StringUtil;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestProjectPlanningDao {
	Logger logger = LoggerFactory.getLogger(RestProjectPlanningDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	
	
	public JsonResponse<Object> getFirstProjectNmDetail(String id,String userid, String org,
			String div) {

		logger.info("Method : getFirstProjectNmDetail Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_projectId='" + id + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
					.setParameter("actionType", "getPlanningFirstNameDtls").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getFirstProjectNmDetail Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> parentPlanningData(
			List<ProjectPlanningSchedulingRestModel> empDetaails) {
		logger.info("Method : parentPlanningData dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<ProjectPlanningSchedulingRestModel> listData = new ArrayList<ProjectPlanningSchedulingRestModel>();

		try {
			String values = GenerateParameterSavePlannSchedule.getsaveparentData(empDetaails);
			
			if ((empDetaails.get(0).getProplanid() == null && empDetaails.get(0).getPlaaningMainId() == null)
					|| (empDetaails.get(0).getProplanid() == "" && empDetaails.get(0).getPlaaningMainId() == "")) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
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
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
						.setParameter("actionType", "addSecondParentData").setParameter("actionValue", values)
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
			else {
				String valuesModify = GenerateParameterSavePlannSchedule.modifyParentPlanning(empDetaails);
				logger.info("modifyvalues====="+valuesModify);
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
						.setParameter("actionType", "modifyParentData").setParameter("actionValue", valuesModify)
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
	     resp.setBody(listData);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : parentPlanningData dao ends"+response);
		return response;
	}
 
/*	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> getParentDataDtls(String id,String id2,String userid, String org,
			String div) {

		logger.info("Method : getParentDataDtls Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			String value = "SET @p_projectIds='" + id + "',@planIds='" + id2 + "',@p_userId='"+ userid +"',@p_org='"+ org +"',@p_orgDiv='"+ div +"';";
			
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
					.setParameter("actionType", "getplanningParentData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getParentDataDtls Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}*/
	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> getParentDataDtls(String id,String userid, String org,
			String div) {

		logger.info("Method : getParentDataDtls Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			String value = "SET @p_projectIds='" + id + "',@planIds='"+ userid +"',@p_org='"+ org +"',@p_orgDiv='"+ div +"';";
			logger.info(value);	
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
					.setParameter("actionType", "getplanningParentData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getParentDataDtls Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	
	/*
	 * @SuppressWarnings({ "unchecked", "unused" }) public
	 * ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>>
	 * getParentDataDtls(String id, String id2) {
	 * logger.info("Method : getParentDataDtls starts");
	 * 
	 * JsonResponse<List<ProjectPlanningSchedulingRestModel>> resp = new
	 * JsonResponse<List<ProjectPlanningSchedulingRestModel>>();
	 * List<ProjectPlanningSchedulingRestModel> newLoc = new
	 * ArrayList<ProjectPlanningSchedulingRestModel>();
	 * 
	 * try {
	 * 
	 * String value = "SET @p_projectIds='" + id + "',@planIds='" + id2 + "';";
	 * System.out.println("value"+value); List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("projectplanningroutines")
	 * .setParameter("actionType",
	 * "getplanningParentData").setParameter("actionValue", value) .getResultList();
	 * for (Object[] m : x) {
	 * 
	 * ProjectPlanningSchedulingRestModel item = new
	 * ProjectPlanningSchedulingRestModel(m[0], m[1], m[2], m[3].toString(), m[4],
	 * m[5].toString(), m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14],
	 * m[15], m[16],m[17]); newLoc.add(item); System.out.println("VIEW"); }
	 * 
	 * resp.setBody(newLoc); } catch (Exception e) { try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); }
	 * e.printStackTrace(); }
	 * 
	 * ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>>
	 * response = new
	 * ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>>( resp,
	 * HttpStatus.CREATED);
	 * 
	 * logger.info("Method : getParentDataDtls ends" + response); return response; }
	 */

	// Edit Parent Details
	
	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> getParentEdits(String id,String userid, String org,
			String div) {

		logger.info("Method : getParentEdits Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			String value = "SET @p_catId='" + id + "',@p_userId='"+ userid +"',@p_org='"+ org +"',@p_orgDiv='"+ div +"';";
			
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
					.setParameter("actionType", "getParentEditData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getParentEdits Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> childDataPlanning(
			List<ProjectPlanningSchedulingRestModel> empDetaails) {
		logger.info("Method : childDataPlanning dao starts"+empDetaails);

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<ProjectPlanningSchedulingRestModel> listData = new ArrayList<ProjectPlanningSchedulingRestModel>();

		try {
			String values = GenerateParameterSavePlannSchedule.getsavechildData(empDetaails);
			if ((empDetaails.get(0).getProplanid() != null && empDetaails.get(0).getPlaaningMainId() == null)
					|| (empDetaails.get(0).getProplanid() != "" && empDetaails.get(0).getPlaaningMainId() == "")) {

				String valueChildData = GenerateParameterSavePlannSchedule.getsavechildData(empDetaails);
				logger.info("in iff valueChildData-------------" + valueChildData);
				logger.info("ADD");
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
						.setParameter("actionType", "addChildDataPlanning").setParameter("actionValue", valueChildData)
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
				logger.info("MODIFY");
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
						.setParameter("actionType", "modifyChildDataPlanning").setParameter("actionValue", values)
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

		logger.info("Method : childDataPlanning dao ends"+response);
		return response;
	}

	// Edit Child Planning Details
	
	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> editChildPlanning(String id,String userid, String org,
			String div) {

		logger.info("Method : editChildPlanning Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			String value = "SET @p_catId='" + id + "',@p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div
					+ "';";

			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
					.setParameter("actionType", "getChildEditPlanning").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : editChildPlanning Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	// getprojectNamelist

	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getProjectPriority(String userId,String org,String div) {
		logger.info("Method : getProjectPriority dao starts");

		List<DropDownModel> projectNamelist = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String value = "SET @p_userId='" + userId + "',@p_org='" + org + "',@p_orgDiv='" + div
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
					.setParameter("actionType", "getProjectPriority").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				projectNamelist.add(dropDownModel);
			}
			if (projectNamelist.size() > 0) {
				resp.setBody(projectNamelist);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(projectNamelist);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("getDepartmentListApi: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(projectNamelist);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(projectNamelist);
		logger.info("Method : getProjectPriority dao ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> saveMasterDataPlanning(ProjectPlanningSchedulingRestModel empDetaails) {
		logger.info("Method : saveParentData dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<ProjectPlanningSchedulingRestModel> listData = new ArrayList<ProjectPlanningSchedulingRestModel>();

		try {
			String values = GenerateParameterSavePlannSchedule.getAddParamParent(empDetaails);
			
			if (empDetaails.getProplanid() == null || empDetaails.getProplanid() == "") {

				em.createNamedStoredProcedureQuery("projectplanningroutines")
						.setParameter("actionType", "addplanparentdata").setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("projectplanningroutines")
						.setParameter("actionType", "modifyplanmasterDataPlanning").setParameter("actionValue", values).execute();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveParentData dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>> getcategoryDataPlanning(String id) {
		logger.info("Method : getcategoryDataPlanning dao starts");
		List<ProjectPlanningSchedulingRestModel> itemNameList = new ArrayList<ProjectPlanningSchedulingRestModel>();
		JsonResponse<List<ProjectPlanningSchedulingRestModel>> resp = new JsonResponse<List<ProjectPlanningSchedulingRestModel>>();
		String value = "SET @p_planningId='" + id + "';";
		logger.info("valu"+value);	
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
					.setParameter("actionType", "getcategoryDataPlanning").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				ProjectPlanningSchedulingRestModel dropDownModel = new ProjectPlanningSchedulingRestModel(m[0], m[1],m[2],m[3]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>> response = new ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getcategoryDataPlanning dao ends");
		return response;
	}
	
	
	//planningStatus
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getPlanningStatus(String userId,String org,String div) {
		logger.info("Method : getPlanningStatus dao starts");

		List<DropDownModel> projectNamelist = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			String value = "SET @p_userId='" + userId + "',@p_org='" + org + "',@p_orgDiv='" + div
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
					.setParameter("actionType", "getPlanningStatus").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				projectNamelist.add(dropDownModel);
			}
			if (projectNamelist.size() > 0) {
				resp.setBody(projectNamelist);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(projectNamelist);
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			logger.error("getDepartmentListApi: " + e.getMessage());
			e.printStackTrace();
			resp.setBody(projectNamelist);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(projectNamelist);
		logger.info("Method : getPlanningStatus dao ends");
		return resp;
	}
	
	
	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> calculationdatetimeDAo(String startDt,String endDt) {

		logger.info("Method : calculationdatetime Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			String value = "SET @startdate='" + DateFormatter.getStringDateTimeWithoutTime(startDt) + "',@p_enddate='" + DateFormatter.getStringDateTimeWithoutTime(endDt)
					+ "';";

			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
					.setParameter("actionType", "getCalculationdatetime").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			logger.info("Method : calculationdatetime Dao ends"+x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : calculationdatetime Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	
	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> planningCategoryListDao(String userid) {

		logger.info("Method : planningCategoryList Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			String value = "SET @p_projectId='" + userid + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
					.setParameter("actionType", "getProjectCategoryList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			logger.info("Method : planningCategoryList Dao ends"+x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : planningCategoryList Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> palnningSubCategoryListDao(String id,String pjId) {

		logger.info("Method : palnningSubCategoryList Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			String value = "SET @p_projectId='" + pjId + "',@p_subBudgetId='"+id+"';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
					.setParameter("actionType", "getPalnningSubCategoryList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			logger.info("Method : planningCategoryList Dao ends"+x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : palnningSubCategoryList Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	

	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> SubCategoryListEditDao(String id,String planIdd) {

		logger.info("Method : SubCategoryListEditDao Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			String value = "SET @p_planId='" + planIdd + "',@p_subBudgetId='"+id+"';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
					.setParameter("actionType", "getSubCategoryListEdit").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			logger.info("Method : SubCategoryListEditDao Dao ends"+x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : SubCategoryListEditDao Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	// auto search

		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getPrecedAutoSearchListPlanning(String id,
				String projectId,String userId,String org,String div) {
			logger.info("Method : getPrecedAutoSearchListPlanning dao starts");
			List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
			String value = "SET @p_searchValue='" + id + "',@p_projectId='" + projectId + "';";
			logger.info("value================================="+value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("projectplanningroutines")
						.setParameter("actionType", "getPrecedAutosearch").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					itemNameList.add(dropDownModel);
				}
				resp.setBody(itemNameList);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : getPrecedAutoSearchListPlanning dao ends" + response);
			return response;
		}
}
