package nirmalya.aatithya.restmodule.projects.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateManageProjectCategoryParameter;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProjectNfaParameter;
import nirmalya.aatithya.restmodule.projects.model.ProjectCreationRestModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;
@Repository
public class ProjectNfaDao {
	Logger logger = LoggerFactory.getLogger(ProjectNfaDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	public ResponseEntity<JsonResponse<Object>> nfaAddDao(ProjectCreationRestModel saveCategory) {
		logger.info("Method : nfaAdd Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateProjectNfaParameter.getProjectNfa(saveCategory);

			System.out.println("valuessss" + values);

			if (saveCategory.getNfaId() == null || saveCategory.getNfaId() == "") {

				em.createNamedStoredProcedureQuery("project_nfa_routines")
						.setParameter("actionType", "nfaAdd").setParameter("actionValue", values)
						.execute();
				System.out.println("if");
			} else {

				em.createNamedStoredProcedureQuery("project_nfa_routines")
						.setParameter("actionType", "nfaModify").setParameter("actionValue", values)
						.execute();
				System.out.println("else");
			}

		} catch

		(Exception e) {
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

		logger.info("Method : nfaAdd Dao ends"+response);
		return response;
	}
	
	@SuppressWarnings("unchecked")

	public JsonResponse<Object> nfaviewDao(String userid,String id ,String id2,String org,
			String div) {

		logger.info("Method : nfaviewDao Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_id='" + id + "',@p_typeid='"+id2+"',@p_org='" + org + "',@p_orgDiv='" + div + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("project_nfa_routines")
					.setParameter("actionType", "viewNfa").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : nfaviewDao Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
}
