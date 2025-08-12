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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestStakeholderDashboardModel;
@Repository
public class RestStakeholderDashboardDao {
	Logger logger = LoggerFactory.getLogger(RestStakeholderManagePropertyDao .class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;
////edit
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>>ViewPropertyType(String userid) {
		logger.info("Method : ViewPropertyType starts");

		JsonResponse<List<RestStakeholderDashboardModel>> resp = new JsonResponse<List<RestStakeholderDashboardModel>>();
		List<RestStakeholderDashboardModel> rs = new ArrayList<RestStakeholderDashboardModel>();

		try {
			
			String value = "SET @p_propId='" + userid + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("stakeHolderDashboard").setParameter("actionType", "viewpropertyType")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestStakeholderDashboardModel reqemp = new RestStakeholderDashboardModel(m[0], m[1].toString());
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : ViewPropertyType ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>>viewDistrictPropertyType(String userid) {
		logger.info("Method : viewDistrictPropertyType starts");

		JsonResponse<List<RestStakeholderDashboardModel>> resp = new JsonResponse<List<RestStakeholderDashboardModel>>();
		List<RestStakeholderDashboardModel> rs = new ArrayList<RestStakeholderDashboardModel>();

		try {

			String value = "SET @p_propId='" + userid + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("stakeHolderDashboard").setParameter("actionType", "districtPropertyCategory")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestStakeholderDashboardModel reqemp = new RestStakeholderDashboardModel(m[0], m[1], m[2].toString());
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : viewDistrictPropertyType ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>>propertyCategoriseReturnPie(String userid) {
		logger.info("Method : propertyCategoriseReturnPie starts");

		JsonResponse<List<RestStakeholderDashboardModel>> resp = new JsonResponse<List<RestStakeholderDashboardModel>>();
		List<RestStakeholderDashboardModel> rs = new ArrayList<RestStakeholderDashboardModel>();

		try {

			String value = "SET @p_propId='" + userid + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("stakeHolderDashboard").setParameter("actionType", "districtProperty")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestStakeholderDashboardModel reqemp = new RestStakeholderDashboardModel(m[0], m[1], m[2].toString());
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : propertyCategoriseReturnPie ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>>categoryWiseReturnOS(String userid) {
		logger.info("Method : categoryWiseReturnOS starts");

		JsonResponse<List<RestStakeholderDashboardModel>> resp = new JsonResponse<List<RestStakeholderDashboardModel>>();
		List<RestStakeholderDashboardModel> rs = new ArrayList<RestStakeholderDashboardModel>();

		try {
			
			String value = "SET @p_propId='" + userid + "';";
			logger.info("rentos"+value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("stakeHolderDashboard").setParameter("actionType", "rentledgerosCategory")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestStakeholderDashboardModel reqemp = new RestStakeholderDashboardModel(m[0], m[1].toString());
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : categoryWiseReturnOS ends"+response);
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>>categoryWiseMaintainanceBar(String userid) {
		logger.info("Method : categoryWiseMaintainanceBar starts");

		JsonResponse<List<RestStakeholderDashboardModel>> resp = new JsonResponse<List<RestStakeholderDashboardModel>>();
		List<RestStakeholderDashboardModel> rs = new ArrayList<RestStakeholderDashboardModel>();

		try {

			String value = "SET @p_propId='" + userid + "';";
			logger.info("maintainance"+value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("stakeHolderDashboard").setParameter("actionType", "maintainanceCatagory")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestStakeholderDashboardModel reqemp = new RestStakeholderDashboardModel(m[0], m[1].toString());
				rs.add(reqemp);
			}

			resp.setBody(rs);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : categoryWiseMaintainanceBar endsssssssssssss"+response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>>categoryWiseLateFeeBar(String userid) {
		logger.info("Method : categoryWiseLateFeeBar starts");

		JsonResponse<List<RestStakeholderDashboardModel>> resp = new JsonResponse<List<RestStakeholderDashboardModel>>();
		List<RestStakeholderDashboardModel> rs = new ArrayList<RestStakeholderDashboardModel>();

		try {

			String value = "SET @p_propId='" + userid + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("stakeHolderDashboard").setParameter("actionType", "maintainanceCatagory")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestStakeholderDashboardModel reqemp = new RestStakeholderDashboardModel(m[0], m[1].toString());
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : categoryWiseLateFeeBar ends"+response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>>viewdashboardLine(String userid) {
		logger.info("Method : ViewPropertyType starts");

		JsonResponse<List<RestStakeholderDashboardModel>> resp = new JsonResponse<List<RestStakeholderDashboardModel>>();
		List<RestStakeholderDashboardModel> rs = new ArrayList<RestStakeholderDashboardModel>();

		try {
			
			String value = "SET @p_propId='" + userid + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("stakeHolderDashboard").setParameter("actionType", "dashboardline")
					.setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				
				RestStakeholderDashboardModel reqemp = new RestStakeholderDashboardModel(m[0].toString(), m[1].toString(),m[2].toString(), m[3].toString());
				rs.add(reqemp);
			}

			resp.setBody(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>> response = new ResponseEntity<JsonResponse<List<RestStakeholderDashboardModel>>>(resp,HttpStatus.CREATED);

		logger.info("Method : ViewPropertyType endsssssssssssssssssssssssssss"+response);
		return response;
	}
	
	

}
