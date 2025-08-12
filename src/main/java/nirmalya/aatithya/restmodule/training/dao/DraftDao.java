package nirmalya.aatithya.restmodule.training.dao;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class DraftDao {
	Logger logger = LoggerFactory.getLogger(DraftDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	
		// viewDraft
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewDraft(String orgName, String orgDivision) {
			logger.info("Method : viewDraft Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("manageTrainingRoutines")
						.setParameter("actionType", "viewdraft").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewDraft Dao ends");
			System.out.println("resp****************************" + resp);
			return resp;

		}
		
		
		// deleteDraft
		public ResponseEntity<JsonResponse<Object>> deleteDraft(String id,String categoryName, String orgName, String orgDivision) {
			logger.info("Method : deleteDraft starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_assignId='" + id + "',@p_categoryName='" + categoryName+ "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("manageTrainingRoutines")
							.setParameter("actionType", "deleteDraftAs").setParameter("actionValue", value).execute();

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

			logger.info("Method : deleteDraft ends");
			System.out.println("DELETEE" + response);
			return response;
		}


		// deleteDraftSc
		public ResponseEntity<JsonResponse<Object>> deleteDraftSc(String id, String orgName, String orgDivision) {
			logger.info("Method : deleteDraft starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_scheduleId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("IDD" + value);
					em.createNamedStoredProcedureQuery("manageTrainingRoutines")
							.setParameter("actionType", "deleteDraftSc").setParameter("actionValue", value).execute();

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

			logger.info("Method : deleteDraft ends");
			System.out.println("DELETEE" + response);
			return response;
		}

}
