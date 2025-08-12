package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestEventManagementModel;

@Repository
public class EventApplyDao {
	Logger logger = LoggerFactory.getLogger(EventApplyDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestEventManagementModel>> viewAllEventListDao(String organization, String orgDivision) {
		logger.info("Method : viewAllEventListDao starts");
		// TODO Auto-generated method stub
		List<RestEventManagementModel> list1 = new ArrayList<RestEventManagementModel>();
		JsonResponse<List<RestEventManagementModel>> resp = new JsonResponse<List<RestEventManagementModel>>();
		try {
			String value = "SET @p_org=\"" + organization + "\", @p_orgDiv=\"" + orgDivision + "\";";
			logger.info("value+++"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "eventLIst").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object o1 = null;
				Object o2 = null;
				Object o3 = null;
				Object o4 = null;
				if (m[2] != null) {
					o1 = m[2].toString();
				}
				if (m[3] != null) {
					o2 = m[3].toString();
				}
				

				if (m[6] != null) {
					o3 = m[6].toString();
				}
				
				
				if (m[7] != null) {
					o4 = m[7].toString();
					
				}
				RestEventManagementModel restEventManagementModel = new RestEventManagementModel(m[0].toString(), m[1],
						o1, o2, m[4], m[5], o3, o4,m[8].toString());
				// logger.info(restEventManagementModel);
				list1.add(restEventManagementModel);
			}
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

		logger.info("view=====" + list1);
		resp.setBody(list1);
		logger.info("Method : viewAllEventListDao ends");
		return resp;
	}

	public JsonResponse<Object> saveEventRequestDao(String eventId, String userId) {
		String value = "SET @p_eventId=\"" + eventId + "\", @p_userid=\"" + userId + "\";";
		// TODO Auto-generated method stub
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			logger.info("Generation Paaaa: " + value);
			em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines").setParameter("actionType", "requestEvent")
					.setParameter("actionValue", value).execute();
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			logger.error("saveEventRequestDao: " + e.getMessage());
		}
		
		return resp;
	}
}

