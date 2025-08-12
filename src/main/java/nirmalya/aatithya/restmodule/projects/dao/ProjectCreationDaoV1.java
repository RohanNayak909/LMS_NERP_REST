	package nirmalya.aatithya.restmodule.projects.dao;
	
	import java.util.ArrayList;
	import java.util.List;
	
	import javax.persistence.EntityManager;

import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Repository;
	
	import nirmalya.aatithya.restmodule.common.ServerDao;
	import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
	import nirmalya.aatithya.restmodule.common.utils.DynamicQueryBuilder;
	import nirmalya.aatithya.restmodule.common.utils.GenerateProjectCreationParameterV1;
	import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
	import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProjectCreationParameter;
	import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModel;
	import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModelV1;
	
	@Repository
	public class ProjectCreationDaoV1 {
		Logger logger = LoggerFactory.getLogger(ProjectCreationDaoV1.class);
	
		@Autowired
		EntityManager em;
	
		@Autowired
		ServerDao serverDao;
	
		public ResponseEntity<JsonResponse<Object>> restaddPrjCreationDaoV1(List<ProjectCreationRestModelV1> prjCreation) {
	
			logger.info("Method in Dao: restaddPrjCreationDao starts" + prjCreation);
	
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			try {
	
				String values = GenerateProjectCreationParameterV1.getPrjCreateParamV1(prjCreation);
				if (prjCreation.get(0).getProjectId() != "" && prjCreation.get(0).getProjectId() != null) {
	
					em.createNamedStoredProcedureQuery("project_creation_routines_v1")
							.setParameter("actionType", "modifyProjectCreation1").setParameter("actionValue", values)
							.execute();
					resp.setCode("Success");
					resp.setMessage("Project Modified Successfully");
	
				} else {
	
					em.createNamedStoredProcedureQuery("project_creation_routines_v1")
							.setParameter("actionType", "addProjectCreation1").setParameter("actionValue", values)
							.execute();
					resp.setCode("Success");
					resp.setMessage("Project Added Successfully");
	
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
	
			logger.info("Method in Dao: restaddPrjCreationDao ends");
	
			return response;
		}
	
		// getAllProject
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getAllProject(String orgName, String orgDivision, String type) {
			logger.info("Method : getAllProject Dao starts");
	
			JsonResponse<Object> resp = new JsonResponse<Object>();
	
			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "', @p_type='" + type + "';";
				logger.info(value);
				List<Object[]> list = em.createNamedStoredProcedureQuery("project_creation_routines_v1")
						.setParameter("actionType", "getAllProject").setParameter("actionValue", value).getResultList();
				resp.setBody(list);
				resp.setMessage("Fetched Data SuccessFully");
				resp.setCode("Success");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("UnSuccess");
				resp.setMessage("Something went Wrong !");
			}
			logger.info("Method : getAllProject Dao ends");
			return resp;
		}
	
		// getAllPriojectById
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getAllPriojectById(String orgName, String orgDivision, String id) {
			logger.info("Method : getAllPriojectById Dao starts");
	
			JsonResponse<Object> resp = new JsonResponse<Object>();
	
			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
				logger.info(value);
				List<Object[]> list = em.createNamedStoredProcedureQuery("project_creation_routines_v1")
						.setParameter("actionType", "getAllProjectById").setParameter("actionValue", value).getResultList();
				resp.setBody(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getAllPriojectById Dao ends");
			return resp;
	
		}
	
	   //getProjectTypeList
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getProjectTypeList() {
			logger.info("Method : getProjectTypeList starts");
	
			List<DropDownModel> locationTypeList = new ArrayList<DropDownModel>();
	
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("project_creation_routines_v1")
						.setParameter("actionType", "getProjectTypeList").setParameter("actionValue", "").getResultList();
				
				System.out.println("project type is coming =================> "+x);
	
				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					locationTypeList.add(dropDownModel);
				}
	
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			logger.info("Method : getProjectTypeList ends");
			return locationTypeList;
		}
	}
