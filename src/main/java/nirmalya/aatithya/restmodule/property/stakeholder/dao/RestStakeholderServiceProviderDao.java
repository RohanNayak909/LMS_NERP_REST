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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateManageServiceProvidersParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStakeholderServiceProviderModel;


@Repository
public class RestStakeholderServiceProviderDao {
	Logger logger = LoggerFactory.getLogger(RestStakeholderServiceProviderDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

////add
	public ResponseEntity<JsonResponse<Object>> saveServiceProviders(
			RestStakeholderServiceProviderModel restPayroll) {

		logger.info("Method : Rest saveServiceProviders  Dao starts"+restPayroll);
		logger.info("restPayroll" + restPayroll);
		JsonResponse<Object> resp = new JsonResponse<Object>();

		logger.info("restPayroll.getId() ====" + restPayroll.getVndrid());

		try {

			String values = GenerateManageServiceProvidersParameter.addServiceProvidersParam(restPayroll);

			if (restPayroll.getVndrid() == null || restPayroll.getVndrid() == "") {

				logger.info("values IN ADD" + values);
				em.createNamedStoredProcedureQuery("viewServiceProviders").setParameter("actionType", "adddetails")
						.setParameter("actionValue", values).execute();

			} else {

				logger.info("values in modify");
				em.createNamedStoredProcedureQuery("viewServiceProviders").setParameter("actionType", "modifystddetails")
						.setParameter("actionValue", values).execute();

			}

		}

		catch (Exception e) {
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

		logger.info("Method : Rest saveServiceProviders Dao ends");

		return response;
	}
////view
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderServiceProviderModel>>> ViewServiceProviders(String userid, String fromDate, String toDate) {
		logger.info("Method : ViewServiceProviders starts");
		List<RestStakeholderServiceProviderModel> respList = new ArrayList<RestStakeholderServiceProviderModel>();

		try {
			String value=	 "SET @p_userid='" + userid + "',@p_fromDate='" + fromDate +"',@p_toDate='" + toDate + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewServiceProviders").setParameter("actionType", "viewView")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestStakeholderServiceProviderModel restPayroll = new RestStakeholderServiceProviderModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10],m[11]);
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestStakeholderServiceProviderModel>> resp = new JsonResponse<List<RestStakeholderServiceProviderModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestStakeholderServiceProviderModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderServiceProviderModel>>>(
				resp, HttpStatus.CREATED);
		//logger.info("response" + response);
		logger.info("Method : ViewServiceProviders ends");

		//logger.info("VIEWWWWWWWW" + respList);
		return response;


}
////edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderServiceProviderModel>>>editServiceProviders(String id) {
		logger.info("Method : editServiceProviders starts");

		JsonResponse<List<RestStakeholderServiceProviderModel>> resp = new JsonResponse<List<RestStakeholderServiceProviderModel>>();
		List<RestStakeholderServiceProviderModel> rs = new ArrayList<RestStakeholderServiceProviderModel>();

		try {

			String value = "SET @p_vendorId='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("viewServiceProviders").setParameter("actionType", "viewEdit")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestStakeholderServiceProviderModel reqemp = new RestStakeholderServiceProviderModel(m[0], m[1], m[2], m[3],m[4],m[5],m[6],m[7],m[8],m[9],m[10],null);
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestStakeholderServiceProviderModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderServiceProviderModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : editServiceProviders ends");
		return response;
	}
	//delete
		public ResponseEntity<JsonResponse<Object>> deleteServiceProviders(String id) {
			logger.info("Method : deleteServiceProviders starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			logger.info("ID...."+id);
			if (validity)
				try {

					String value = "SET @p_vendorId='" + id + "';";
					logger.info(value);

					em.createNamedStoredProcedureQuery("viewServiceProviders")
							.setParameter("actionType", "viewDelete").setParameter("actionValue", value).execute();

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

			logger.info("Method :  deleteServiceProviders ends");
			logger.info("DELETEE" + response);
			return response;
		}
}
