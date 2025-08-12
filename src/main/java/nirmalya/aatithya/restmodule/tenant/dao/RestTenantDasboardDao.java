package nirmalya.aatithya.restmodule.tenant.dao;

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
import nirmalya.aatithya.restmodule.property.stakeholder.dao.RestStakeholderManagePropertyDao;
import nirmalya.aatithya.restmodule.tenant.model.RestTenantDashboardModel;

@Repository
public class RestTenantDasboardDao {
	Logger logger = LoggerFactory.getLogger(RestStakeholderManagePropertyDao .class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestTenantDashboardModel>>>ViewPropertyType(String userid) {
		logger.info("Method : ViewPropertyType starts");

		JsonResponse<List<RestTenantDashboardModel>> resp = new JsonResponse<List<RestTenantDashboardModel>>();
		List<RestTenantDashboardModel> rs = new ArrayList<RestTenantDashboardModel>();

		try {
			
			String value = "SET @p_propId='" + userid + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("tenantDashboard").setParameter("actionType", "viewpropertyType")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestTenantDashboardModel reqemp = new RestTenantDashboardModel(m[0], m[1].toString(), m[2].toString());
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestTenantDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestTenantDashboardModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : ViewPropertyType ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestTenantDashboardModel>>>ViewMonthlyOS(String userid) {
		logger.info("Method : ViewPropertyType starts");

		JsonResponse<List<RestTenantDashboardModel>> resp = new JsonResponse<List<RestTenantDashboardModel>>();
		List<RestTenantDashboardModel> rs = new ArrayList<RestTenantDashboardModel>();

		try {
			
			String value = "SET @p_propId='" + userid + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("tenantDashboard").setParameter("actionType", "viewmonthlyOS")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestTenantDashboardModel reqemp = new RestTenantDashboardModel(m[0], m[1].toString());
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestTenantDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestTenantDashboardModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : ViewPropertyType end"+response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestTenantDashboardModel>>>viewdashboardLine(String userid) {
		logger.info("Method : ViewPropertyType starts");

		JsonResponse<List<RestTenantDashboardModel>> resp = new JsonResponse<List<RestTenantDashboardModel>>();
		List<RestTenantDashboardModel> rs = new ArrayList<RestTenantDashboardModel>();

		try {
			
			String value = "SET @p_propId='" + userid + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("tenantDashboard").setParameter("actionType", "dashboardline")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestTenantDashboardModel reqemp = new RestTenantDashboardModel(m[0].toString(), m[1].toString(),m[2].toString(), null);
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestTenantDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestTenantDashboardModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : ViewPropertyType endsssssssssssssssssssssssssss"+response);
		return response;
	}
	
	

}
