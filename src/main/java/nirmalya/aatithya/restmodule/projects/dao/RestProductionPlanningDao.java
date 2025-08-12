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

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProductionPlaningParameter;
import nirmalya.aatithya.restmodule.projects.model.ProjectPlanningSchedulingRestModel;

@Repository
public class RestProductionPlanningDao {
	Logger logger = LoggerFactory.getLogger(RestProductionPlanningDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getFirstProjectNmDetail(String id,String userid, String org,
			String div) {

		logger.info("Method : getFirstProjectNmDetail Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_projectId='" + id + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("productionplanningroutines")
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
	public ResponseEntity<JsonResponse<Object>> parentProductionPlanningData(
			List<ProjectPlanningSchedulingRestModel> empDetaails) {
		logger.info("Method : parentProductionPlanningData dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<ProjectPlanningSchedulingRestModel> listData = new ArrayList<ProjectPlanningSchedulingRestModel>();

		try {
			String values = GenerateProductionPlaningParameter.getsaveparentData(empDetaails);
			System.out.println("values" + values);
			if ((empDetaails.get(0).getProplanid() == null && empDetaails.get(0).getPlaaningMainId() == null)
					|| (empDetaails.get(0).getProplanid() == "" && empDetaails.get(0).getPlaaningMainId() == "")) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("productionplanningroutines")
						.setParameter("actionType", "addparentData").setParameter("actionValue", values)
						.getResultList();
				System.out.println("if");
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
				List<Object[]> x = em.createNamedStoredProcedureQuery("productionplanningroutines")
						.setParameter("actionType", "addSecondParentData").setParameter("actionValue", values)
						.getResultList();
				System.out.println("elseif");
				
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
				String valuesModify = GenerateProductionPlaningParameter.modifyParentPlanning(empDetaails);
				logger.info("modifyvalues====="+valuesModify);
				List<Object[]> x = em.createNamedStoredProcedureQuery("productionplanningroutines")
						.setParameter("actionType", "modifyParentData").setParameter("actionValue", valuesModify)
						.getResultList();
				System.out.println("else");
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

		logger.info("Method : parentProductionPlanningData dao ends"+response);
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> saveMasterDataPlanning(ProjectPlanningSchedulingRestModel empDetaails) {
		logger.info("Method : saveParentData dao starts"+empDetaails.getProplanid());

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<ProjectPlanningSchedulingRestModel> listData = new ArrayList<ProjectPlanningSchedulingRestModel>();

		try {
			String values = GenerateProductionPlaningParameter.getAddParamParent(empDetaails);
			
			logger.info("values============="+values);
			
			if (empDetaails.getProplanid() == null || empDetaails.getProplanid() == "") {

				em.createNamedStoredProcedureQuery("productionplanningroutines")
						.setParameter("actionType", "addplanparentdata").setParameter("actionValue", values).execute();
			} else {
				System.out.println("ELSE");
				em.createNamedStoredProcedureQuery("productionplanningroutines")
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
	
	
	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> getProductionParentDetails(String id,String id2,String userid, String org,
			String div) {

		logger.info("Method : getProductionParentDetails Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			String value = "SET @p_projectIds='" + id + "',@planIds='" + id2 + "',@p_userId='"+ userid +"',@p_org='"+ org +"',@p_orgDiv='"+ div +"';";
			
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("productionplanningroutines")
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

		logger.info("Method : getProductionParentDetails Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> getParentEdits(String id,String userid, String org,
			String div) {

		logger.info("Method : getParentEdits Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			String value = "SET @p_catId='" + id + "',@p_userId='"+ userid +"',@p_org='"+ org +"',@p_orgDiv='"+ div +"';";
			
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("productionplanningroutines")
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

	 // delete Planning

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> planningschedulingdeleteDao(String userid, String org,
			String div,String id,String id2) {
		logger.info("Method : planningschedulingdelete Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {

				String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_id='"+id+"',@p_pId='"+id2+"';";

				System.out.println("value------------------" + value);
				em.createNamedStoredProcedureQuery("productionplanningroutines")
						.setParameter("actionType", "deletePlanning").setParameter("actionValue", value).execute();

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

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method :  planningschedulingdelete Dao ends"+response);
		return response;
	} 
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> TaskCategoryDeleteDao(String userid, String org,
			String div,String id) {
		logger.info("Method : TaskCategoryDelete Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {

				String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_id='"+id+"';";

				System.out.println("value------------------" + value);
				em.createNamedStoredProcedureQuery("productionplanningroutines")
						.setParameter("actionType", "deleteTaskCatetegory").setParameter("actionValue", value).execute();

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

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method :  TaskCategoryDelete Dao ends"+response);
		return response;
	}
	
	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> calculationdatetimeDAo(String startDt,String endDt) {

		logger.info("Method : calculationdatetime Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			String value = "SET @startdate='" + DateFormatter.getStringDateTimeWithoutS(startDt) + "',@p_enddate='" + DateFormatter.getStringDateTimeWithoutS(endDt)
					+ "';";

			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("productionplanningroutines")
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
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProjectPlanningSchedulingRestModel>>> getcategoryDataPlanning(String id) {
		logger.info("Method : getcategoryDataPlanning dao starts");
		List<ProjectPlanningSchedulingRestModel> itemNameList = new ArrayList<ProjectPlanningSchedulingRestModel>();
		JsonResponse<List<ProjectPlanningSchedulingRestModel>> resp = new JsonResponse<List<ProjectPlanningSchedulingRestModel>>();
		String value = "SET @p_planningId='" + id + "';";
		logger.info("valu"+value);	
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productionplanningroutines")
					.setParameter("actionType", "getcategoryDataPlanning").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				ProjectPlanningSchedulingRestModel dropDownModel = new ProjectPlanningSchedulingRestModel(m[0], m[1],m[2],m[3],m[4],m[5]);
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
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> productionPlanningCategoryList() {
		logger.info("Method : productionPlanningCategoryList dao starts");

		List<DropDownModel> projectNamelist = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("productionplanningroutines")
					.setParameter("actionType", "getProductionPlanningCategoryList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				projectNamelist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : productionPlanningCategoryList dao ends");
		return projectNamelist;
	}
	

}
