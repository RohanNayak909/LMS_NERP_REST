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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateManageProjectCategoryParameter;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProjectCreationParameter;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProjectDocumentUploadParameter;
import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;

@Repository
public class ProjectDocumentUploadDao {
	Logger logger = LoggerFactory.getLogger(ProjectDocumentUploadDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> projectdocumenttypeDao(String id) {
		logger.info("Method : projectdocumenttypeDao starts");

		List<DropDownModel> projectdocumenttypeList = new ArrayList<DropDownModel>();
		String value = "SET @p_typeId='" + id + "';";
		logger.info(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectdocumentuploadroutines")
					.setParameter("actionType", "projectdocumenttypeList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2]);
				projectdocumenttypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : projectdocumenttypeDao ends"+projectdocumenttypeList);

		return projectdocumenttypeList;
	}
	
	
	public ResponseEntity<JsonResponse<Object>> addDocumentTpeUploadDao(List<ProjectCreationRestModel> documentUploaad) {

		logger.info("Method in Dao: addDocumentTpeUploadDao starts"+documentUploaad);


		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {

			String values = GenerateProjectDocumentUploadParameter.getDocumentParamSave(documentUploaad);
			
			if (documentUploaad.get(0).getPrjDocumentId() != "" && documentUploaad.get(0).getPrjDocumentId() != null) {

				em.createNamedStoredProcedureQuery("projectdocumentuploadroutines")
						.setParameter("actionType", "modifyDocumentUpload").setParameter("actionValue", values)
						.execute();

			} else {
				logger.info("values***************************"+values);
				em.createNamedStoredProcedureQuery("projectdocumentuploadroutines")
						.setParameter("actionType", "addDocumentUpload").setParameter("actionValue", values).execute();

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

		logger.info("Method in Dao: addDocumentTpeUploadDao ends");

		return response;
	}
	
	
	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> getAlldocumentView(String id,String id2,String userid, String org,
			String div) {

		logger.info("Method : getAlldocumentView Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			String value = "SET @p_projectIds='" + id + "',@p_id='" + id2 + "',@p_userId='"+ userid +"',@p_org='"+ org +"',@p_orgDiv='"+ div +"';";
			
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectdocumentuploadroutines")
					.setParameter("actionType", "getAlldocumentView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAlldocumentView Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	/*
	 * public ResponseEntity<JsonResponse<Object>>
	 * saveTemplateDao(ProjectCreationRestModel template) {
	 * logger.info("Method : saveTemplate Dao starts");
	 * 
	 * JsonResponse<Object> resp = new JsonResponse<Object>(); try { String values =
	 * GenerateProjectDocumentUploadParameter.getProjectTempalteParam(template);
	 * 
	 * System.out.println("valuessss" + values);
	 * 
	 * if (template.getDocumentTypeId() != null || template.getDocumentTypeId() !=
	 * "") {
	 * 
	 * em.createNamedStoredProcedureQuery("projectdocumentuploadroutines")
	 * .setParameter("actionType", "addTemplate").setParameter("actionValue",
	 * values) .execute(); System.out.println("if");
	 * 
	 * } else {
	 * 
	 * em.createNamedStoredProcedureQuery("projectdocumentuploadroutines")
	 * .setParameter("actionType", "modifyTemplatew").setParameter("actionValue",
	 * values) .execute(); System.out.println("else"); }
	 * 
	 * } catch
	 * 
	 * (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
	 * resp.setCode(err[0]); resp.setMessage(err[1]);
	 * 
	 * } catch (Exception e1) { e1.printStackTrace(); }
	 * 
	 * }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : saveTemplate Dao ends"+response); return response; }
	 */
	
	@SuppressWarnings("unchecked")

	public JsonResponse<Object> viewtemplate(String userid, String org,
			String div,String id) {

		logger.info("Method : viewtemplate Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_id = '" + id + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectdocumentuploadroutines")
					.setParameter("actionType", "viewtemplate").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewtemplate Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	public ResponseEntity<JsonResponse<Object>> addTemplateUploadDao(List<ProjectCreationRestModel> documentUploaad) {

		logger.info("Method in Dao: addTemplateUploadDao starts"+documentUploaad);


		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {

			String values = GenerateProjectDocumentUploadParameter.getDocumentParamTemplate(documentUploaad);
			logger.info("values==============================="+values);
			if (documentUploaad.get(0).getDocumentTypeId() != "" && documentUploaad.get(0).getDocumentTypeId() != null) {

				em.createNamedStoredProcedureQuery("projectdocumentuploadroutines")
						.setParameter("actionType", "addTemplateUpload").setParameter("actionValue", values)
						.execute();

			} else {
				logger.info("values***************************"+values);
				em.createNamedStoredProcedureQuery("projectdocumentuploadroutines")
						.setParameter("actionType", "modifyTemplateUpload").setParameter("actionValue", values).execute();

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

		logger.info("Method in Dao: addTemplateUploadDao ends");

		return response;
	}
	
	
	@SuppressWarnings({ "unchecked" })
	public JsonResponse<Object> getAlltemplateView(String id,String userid, String org,
			String div) {

		logger.info("Method : getAlltemplateView Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			String value = "SET @p_id='" + id + "',@p_userId='"+ userid +"',@p_org='"+ org +"',@p_orgDiv='"+ div +"';";
			
			logger.info("valuesTemp" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("projectdocumentuploadroutines")
					.setParameter("actionType", "getAlltemplateView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAlltemplateView Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

}
