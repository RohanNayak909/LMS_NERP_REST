package nirmalya.aatithya.restmodule.serviceprovider.dao;

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
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStakeholderRentLedgerModel;

@Repository
public class RestServiceProviderLedgerDao {
	Logger logger = LoggerFactory.getLogger(RestServiceProviderLedgerDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;
	
////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>> ViewRentLedger(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : ViewRentLedger starts");
		List<RestStakeholderRentLedgerModel> respList = new ArrayList<RestStakeholderRentLedgerModel>();
		
		String value=	 "SET @p_userid='" + userid + "',@p_fromDate='" + fromDate +"',@p_toDate='" + toDate + "';";
		logger.info(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("serviceRentledger").setParameter("actionType", "viewView")
					.setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestStakeholderRentLedgerModel restPayroll = new RestStakeholderRentLedgerModel(m[0], m[1], m[2], m[3], m[4], m[5],m[6],m[7],m[8],m[9],m[10],m[11],m[12],m[13],null,null);
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<RestStakeholderRentLedgerModel>> resp = new JsonResponse<List<RestStakeholderRentLedgerModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderRentLedgerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : ViewProperty ends");

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}

}
