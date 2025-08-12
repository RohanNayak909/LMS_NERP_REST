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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.serviceprovider.model.RestServiceProviderDashboardModel;

@Repository
public class RestServiceProviderDashboardDao {
	Logger logger = LoggerFactory.getLogger(RestServiceProviderDashboardDao .class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;
////edit
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestServiceProviderDashboardModel>>>ViewPropertyType(String userid) {
		logger.info("Method : ViewPropertyType starts");

		JsonResponse<List<RestServiceProviderDashboardModel>> resp = new JsonResponse<List<RestServiceProviderDashboardModel>>();
		List<RestServiceProviderDashboardModel> rs = new ArrayList<RestServiceProviderDashboardModel>();

		try {
			
			String value = "SET @p_propId='" + userid + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("serviceProviderDashboard").setParameter("actionType", "viewpropertyType")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestServiceProviderDashboardModel reqemp = new RestServiceProviderDashboardModel(m[0], m[1].toString(),m[2].toString());
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestServiceProviderDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestServiceProviderDashboardModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : ViewPropertyType ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestServiceProviderDashboardModel>>>ViewserviceOS(String userid) {
		logger.info("Method : ViewPropertyType starts");

		JsonResponse<List<RestServiceProviderDashboardModel>> resp = new JsonResponse<List<RestServiceProviderDashboardModel>>();
		List<RestServiceProviderDashboardModel> rs = new ArrayList<RestServiceProviderDashboardModel>();

		try {
			
			String value = "SET @p_propId='" + userid + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("serviceProviderDashboard").setParameter("actionType", "viewmonthlyOS")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestServiceProviderDashboardModel reqemp = new RestServiceProviderDashboardModel(m[0], m[1].toString());
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestServiceProviderDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestServiceProviderDashboardModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : ViewPropertyType ends");
		return response;
	}
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestServiceProviderDashboardModel>>>viewdashboardLine(String userid) {
			logger.info("Method : ViewPropertyType starts");

			JsonResponse<List<RestServiceProviderDashboardModel>> resp = new JsonResponse<List<RestServiceProviderDashboardModel>>();
			List<RestServiceProviderDashboardModel> rs = new ArrayList<RestServiceProviderDashboardModel>();

			try {
				
				String value = "SET @p_propId='" + userid + "';";
				logger.info(value);

				List<Object[]> x = em.createNamedStoredProcedureQuery("serviceProviderDashboard").setParameter("actionType", "dashboardline")
						.setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					
					RestServiceProviderDashboardModel reqemp = new RestServiceProviderDashboardModel(m[0].toString(), m[1].toString(),m[2].toString(), null);
					rs.add(reqemp);
				}

				resp.setBody(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}

		
			ResponseEntity<JsonResponse<List<RestServiceProviderDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestServiceProviderDashboardModel>>>(resp,HttpStatus.CREATED);

			logger.info("Method : ViewPropertyType endsssssssssssssssssssssssssss"+response);
			return response;
		}
	

}
