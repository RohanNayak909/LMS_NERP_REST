package nirmalya.aatithya.restmodule.property.stakeholder.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStackholderRentOSModel;

@Repository
public class RestStackholderRentOSDao {
	
	Logger logger = LoggerFactory.getLogger(RestStackholderRentOSDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;
	
	
////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStackholderRentOSModel>>> ViewRentLedger(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : ViewRentLedger starts");
		List<RestStackholderRentOSModel> respList = new ArrayList<RestStackholderRentOSModel>();
		
		String value=	 "SET @p_userid='" + userid + "',@p_fromDate='" + fromDate +"',@p_toDate='" + toDate + "';";
		logger.info(value);
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewRentOS").setParameter("actionType", "getos")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestStackholderRentOSModel restPayroll = new RestStackholderRentOSModel(m[0], m[1], m[2], m[3], m[4].toString());
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestStackholderRentOSModel>> resp = new JsonResponse<List<RestStackholderRentOSModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestStackholderRentOSModel>>> response = new ResponseEntity<JsonResponse<List<RestStackholderRentOSModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : ViewProperty ends");

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}

}
