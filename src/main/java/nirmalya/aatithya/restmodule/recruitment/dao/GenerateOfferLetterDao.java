package nirmalya.aatithya.restmodule.recruitment.dao;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.recruitment.model.RestGenerateOfferLetterModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class GenerateOfferLetterDao {

	Logger logger = LoggerFactory.getLogger(GenerateOfferLetterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> createOfferLetter(String candId,String bandid,String offerLetterId,String org,String orgDiv) {
		// TODO Auto-generated method stub
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "Set @p_candId=\""+candId+"\",@p_bandid=\""+bandid+"\",@p_offerLetterId=\""+offerLetterId+"\",@p_org=\""+org+"\",@p_orgDiv=\""+orgDiv+"\";";
		logger.info("value===="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
					.setParameter("actionType", "viewOfferLeterPdf").setParameter("actionValue", value)
					.getResultList();

			if (x.size() > 0) {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		logger.info("resp==="+resp);
		return resp;
	}
	
	

}
