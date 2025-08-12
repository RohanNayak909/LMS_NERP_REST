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
import nirmalya.aatithya.restmodule.master.model.TemplatesMasterModel;

/**
 * @author NirmalyaLabs
 *
 */
@Repository
public class TemplatesMasterDao {

	Logger logger = LoggerFactory.getLogger(TemplatesMasterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<TemplatesMasterModel> getTemplatesList() {
		logger.info("Method : getTemplatesList starts");

		List<TemplatesMasterModel> tempList = new ArrayList<TemplatesMasterModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("templatesRoutines")
					.setParameter("actionType", "getTemplatesList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				TemplatesMasterModel dropDownModel = new TemplatesMasterModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				tempList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTemplatesList ends");
		return tempList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<TemplatesMasterModel>> saveReportDocument(TemplatesMasterModel tempDtls) {
		logger.info("Method : saveReportDocument starts");

		Boolean validity = true;
		JsonResponse<TemplatesMasterModel> resp = new JsonResponse<TemplatesMasterModel>();
		resp.setMessage("");
		resp.setCode("");

		List<TemplatesMasterModel> newLoc = new ArrayList<TemplatesMasterModel>();

		if (validity)
			try {

				String value = "SET @P_TempId='" + tempDtls.getTempId() + "', @P_CreatedBy='" + tempDtls.getCreatedBy() + "', @P_Attachments='" + tempDtls.getFileName()  + "';";

				List<Object[]> x = em.createNamedStoredProcedureQuery("templatesRoutines")
						.setParameter("actionType", "saveReportDocument").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {

					TemplatesMasterModel item = new TemplatesMasterModel(m[0], m[1], m[2], m[3], m[4], m[5]);
					newLoc.add(item);
				}
				resp.setBody(newLoc.get(0));

			} catch (Exception e) {
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<TemplatesMasterModel>> response = new ResponseEntity<JsonResponse<TemplatesMasterModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveReportDocument ends");
		return response;
	}
}
