package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.WorkflowProcessRestModal;
import nirmalya.aatithya.restmodule.recruitment.model.AddRecruitentModel;

/**
 * @author Pankaj Kumar
 *
 */
@Repository
public class WorkflowProcessDao {

	Logger logger = LoggerFactory.getLogger(WorkflowProcessDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	public ResponseEntity<JsonResponse<Object>> saveWorkflowProcessData(WorkflowProcessRestModal workflowProcessRestModal) {
		logger.info("Method : saveWorkflowProcessData starts"+workflowProcessRestModal);
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_workflowData=" + workflowProcessRestModal.getWorkflowData() + ","
					+ "@userId =" + workflowProcessRestModal.getUserId() + ",@org =" + workflowProcessRestModal.getOrganization() + ","
							+ "@orgDiv =" + workflowProcessRestModal.getOrgDivision() + ";";
			em.createNamedStoredProcedureQuery("workflow_process_Routines").setParameter("actionType", "save-workflow")
			.setParameter("actionValue", value).execute();
			
			resp.setMessage("Workflow Save Successfully");
			resp.setCode("success");
			
		} catch (Exception e) {
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

		logger.info("Method : saveWorkflowProcessData ends");
		return response;
	}

}
