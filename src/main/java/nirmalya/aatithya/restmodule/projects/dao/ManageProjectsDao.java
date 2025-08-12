package nirmalya.aatithya.restmodule.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateProjectsParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.projects.model.ManageProjectMasterModel;
import nirmalya.aatithya.restmodule.projects.model.NonResourcePlanModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectsChartOfAccountModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectsCostCenterModel;
import nirmalya.aatithya.restmodule.projects.model.ProjectsTeamPlanModel;

@Repository
public class ManageProjectsDao {

	Logger logger = LoggerFactory.getLogger(ManageProjectsDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> projectTypeList() {
		logger.info("Method : projectTypeList Dao starts");

		List<DropDownModel> projectTypeList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectsRoutines")
					.setParameter("actionType", "projectTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				projectTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : projectTypeList Dao ends");

		return projectTypeList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> priorityList() {
		logger.info("Method : priorityList Dao starts");

		List<DropDownModel> priorityList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectsRoutines")
					.setParameter("actionType", "priorityList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				priorityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : priorityList Dao ends");

		return priorityList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> EmployeeList() {
		logger.info("Method : EmployeeList Dao starts");

		List<DropDownModel> priorityList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectsRoutines")
					.setParameter("actionType", "EmployeeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				priorityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : EmployeeList Dao ends");

		return priorityList;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ManageProjectMasterModel>> addProjects(ManageProjectMasterModel req) {
		logger.info("Method : addProjects starts");

		JsonResponse<ManageProjectMasterModel> resp = new JsonResponse<ManageProjectMasterModel>();
	
			try {
				String values = GenerateProjectsParameter.addProjectsDetails(req);
					System.out.println(values);
				if (req.getProjectId() != null && req.getProjectId() != "") {
					em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter("actionType", "modifyProjects")
					.setParameter("actionValue", values).execute();
				} else {
					List<Object> x = em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter("actionType", "addProjects")
					.setParameter("actionValue", values).getResultList();
					
					ManageProjectMasterModel candidate = new ManageProjectMasterModel(x.get(0),null,null,null,null,null,null,null,null,null,
							null,null,null,null,null,null);
					resp.setBody(candidate);
				}
				
			} catch

			(Exception e) {
				
				e.printStackTrace();

			}

		ResponseEntity<JsonResponse<ManageProjectMasterModel>> response = new ResponseEntity<JsonResponse<ManageProjectMasterModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addProjects ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageProjectMasterModel>>> viewProjects() {
		logger.info("Method : viewProjects starts");

		List<ManageProjectMasterModel> countryList = new ArrayList<ManageProjectMasterModel>();

		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter("actionType", "viewProjects")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				
				Object sDate = null;
				if (m[13] != null) {
					sDate = m[13].toString();
				}
						
				Object date = null;
				if (m[10] != null) {
					date = m[10].toString();
				}
				
				Object date1 = null;
				if (m[9] != null) {
					date1 = m[9].toString();
				}
				
				ManageProjectMasterModel dropDownModel = new ManageProjectMasterModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],date1
						,date,m[11],m[12],null,null,sDate);
				countryList.add(dropDownModel);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<ManageProjectMasterModel>> resp = new JsonResponse<List<ManageProjectMasterModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ManageProjectMasterModel>>> response = new ResponseEntity<JsonResponse<List<ManageProjectMasterModel>>>(
		resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : viewProjects ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteProjects(String id) {
		logger.info("Method : deleteProjects starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = "SET  @p_projectId='(" + id + ")';";
			System.out.println("DELETE "+value);

			em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter("actionType", "deleteProjects")
					.setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
			String[] err = serverDao.errorProcedureCall(e);
			resp.setCode(err[0]);
			resp.setMessage(err[1]);
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : deleteProjects ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageProjectMasterModel>>> editProjects(String id) {
		logger.info("Method : editProjects starts");
		
	
		List<ManageProjectMasterModel> req = new ArrayList<ManageProjectMasterModel>();
		JsonResponse<List<ManageProjectMasterModel>> resp = new JsonResponse<List<ManageProjectMasterModel>>();

		try {

			String value = "SET @p_projectId='" + id +"';";
			System.out.println(value);
		
			List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectsRoutines")
					.setParameter("actionType", "editProjects")
					.setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				
				Object sDate = null;
				if (m[14] != null) {
					sDate = m[14].toString();
				}
						
				Object date = null;
				if (m[10] != null) {
					date = m[10].toString();
				}
				
				Object date1 = null;
				if (m[9] != null) {
					date1 = m[9].toString();
				}
				
				ManageProjectMasterModel dropDownModel = new ManageProjectMasterModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],date1
						,date,m[11],m[12],m[13],null,sDate);
				req.add(dropDownModel);
				
			}
			
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<ManageProjectMasterModel>>> response = new ResponseEntity<JsonResponse<List<ManageProjectMasterModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : editProjects ends");
		System.out.println(response);
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> addTeamPlan(ProjectsTeamPlanModel req) {
		logger.info("Method : addTeamPlan starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
	
			try {
				String values = GenerateProjectsParameter.addTeamPlan(req);
				System.out.println(values);
				if(req.getTeamPlanId() == null || req.getTeamPlanId() == "") {
					
					em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter("actionType", "addTeamPlan")
					.setParameter("actionValue", values).execute();
					 } else {
						 em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter( "actionType", "modifyTeamPlan")
						 .setParameter("actionValue", values).execute(); 
					}
					 
				
			} catch

			(Exception e) {
				e.printStackTrace();

			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addTeamPlan ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProjectsTeamPlanModel>>> viewTeamPlan(String id) {
		logger.info("Method : viewProjects starts");

		List<ProjectsTeamPlanModel> countryList = new ArrayList<ProjectsTeamPlanModel>();

		String values = "SET @p_projectId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter("actionType", "viewTeamPlan")
					.setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				
				Object sDate = null;
				if (m[13] != null) {
					sDate = DateFormatter.returnStringDate(m[13]);
				}
				
				ProjectsTeamPlanModel dropDownModel = new ProjectsTeamPlanModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],m[11],m[12],sDate);
				countryList.add(dropDownModel);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<ProjectsTeamPlanModel>> resp = new JsonResponse<List<ProjectsTeamPlanModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProjectsTeamPlanModel>>> response = new ResponseEntity<JsonResponse<List<ProjectsTeamPlanModel>>>(
		resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : viewProjects ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteTeamPlan(String id) {
		logger.info("Method : deleteTeamPlan starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
	
			try {
				String values = "SET @p_id='(" + id + ")'";
				
					em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter("actionType", "deleteTeamPlan")
					.setParameter("actionValue", values).execute();
					
					
			} catch

			(Exception e) {
				e.printStackTrace();

			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteTeamPlan ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> addNonResource(NonResourcePlanModel req) {
		logger.info("Method : addNonResource starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
	
			try {
				String values = GenerateProjectsParameter.addNonResource(req);
				System.out.println(values);
				if(req.getNonResourceId() == null || req.getNonResourceId() == "") {
					
					em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter("actionType", "addNonResource")
					.setParameter("actionValue", values).execute();
					 } else {
						 em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter( "actionType", "modifyNonResource")
						 .setParameter("actionValue", values).execute(); 
					}
					 
				
			} catch

			(Exception e) {
				e.printStackTrace();

			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addNonResource ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<NonResourcePlanModel>>> viewNonResource(String id) {
		logger.info("Method : viewNonResource starts");

		List<NonResourcePlanModel> countryList = new ArrayList<NonResourcePlanModel>();

		String values = "SET @p_projectId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter("actionType", "viewNonResource")
					.setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				
				Object sDate = null;
				if (m[9] != null) {
					sDate = DateFormatter.returnStringDate(m[9]);
				}
						
				
				NonResourcePlanModel dropDownModel = new NonResourcePlanModel(m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8],sDate,m[10],m[11],m[12]);
				countryList.add(dropDownModel);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<NonResourcePlanModel>> resp = new JsonResponse<List<NonResourcePlanModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<NonResourcePlanModel>>> response = new ResponseEntity<JsonResponse<List<NonResourcePlanModel>>>(
		resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : viewNonResource ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> deleteNonResource(String id) {
		logger.info("Method : deleteNonResource starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
	
			try {
				String values = "SET @p_id='(" + id + ")'";
				
					em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter("actionType", "deleteNonResource")
					.setParameter("actionValue", values).execute();
					
					
			} catch

			(Exception e) {
				e.printStackTrace();

			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteNonResource ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProjectsChartOfAccountModel>>> viewChartAccount() {
		logger.info("Method : viewChartAccount starts");

		List<ProjectsChartOfAccountModel> countryList = new ArrayList<ProjectsChartOfAccountModel>();
		
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter("actionType", "viewChartAccount")
					.setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				
				ProjectsChartOfAccountModel dropDownModel = new ProjectsChartOfAccountModel(m[0],m[1],m[2],m[3],m[4].toString());
				countryList.add(dropDownModel);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<ProjectsChartOfAccountModel>> resp = new JsonResponse<List<ProjectsChartOfAccountModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProjectsChartOfAccountModel>>> response = new ResponseEntity<JsonResponse<List<ProjectsChartOfAccountModel>>>(
		resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : viewChartAccount ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProjectsChartOfAccountModel>>> viewChartAccountAutoComplete(String search) {
		logger.info("Method : viewChartAccountAutoComplete starts");

		List<ProjectsChartOfAccountModel> countryList = new ArrayList<ProjectsChartOfAccountModel>();
		
		String value = "SET @p_search='" + search + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter("actionType", "caAutoComplete")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				ProjectsChartOfAccountModel dropDownModel = new ProjectsChartOfAccountModel(m[0],null,null,m[1],null);
				countryList.add(dropDownModel);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<ProjectsChartOfAccountModel>> resp = new JsonResponse<List<ProjectsChartOfAccountModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProjectsChartOfAccountModel>>> response = new ResponseEntity<JsonResponse<List<ProjectsChartOfAccountModel>>>(
		resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : viewChartAccountAutoComplete ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProjectsCostCenterModel>>> viewCostCenterAutoComplete(String search) {
		logger.info("Method : viewCostCenterAutoComplete starts");

		List<ProjectsCostCenterModel> countryList = new ArrayList<ProjectsCostCenterModel>();
		
		String value = "SET @p_search='" + search + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ProjectsRoutines").setParameter("actionType", "ccAutoComplete")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				ProjectsCostCenterModel dropDownModel = new ProjectsCostCenterModel(m[0],null,null,m[1],null);
				countryList.add(dropDownModel);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonResponse<List<ProjectsCostCenterModel>> resp = new JsonResponse<List<ProjectsCostCenterModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ProjectsCostCenterModel>>> response = new ResponseEntity<JsonResponse<List<ProjectsCostCenterModel>>>(
		resp, responseHeaders, HttpStatus.CREATED);
		
		logger.info("Method : viewCostCenterAutoComplete ends");
		return response;
	}
	
}
