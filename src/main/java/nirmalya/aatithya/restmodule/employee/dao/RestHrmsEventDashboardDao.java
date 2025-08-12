package nirmalya.aatithya.restmodule.employee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsEventDashboardModel;

@Repository

public class RestHrmsEventDashboardDao {
	Logger logger = LoggerFactory.getLogger(RestHrmsEventDashboardDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// About Organization

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsEventDashboardModel>> viewAboutOrganization(String organization,
			String orgDivision) {
		logger.info("Method : viewAboutOrganizationDao starts");

		List<RestHrmsEventDashboardModel> getAllemployee = new ArrayList<RestHrmsEventDashboardModel>();
		JsonResponse<List<RestHrmsEventDashboardModel>> resp = new JsonResponse<List<RestHrmsEventDashboardModel>>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("dashboardEventRoutines")
					.setParameter("actionType", "aboutOrganization").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {

				RestHrmsEventDashboardModel reqEdit = new RestHrmsEventDashboardModel(m[0], null, null, null, null,
						null, null, null, null, null, null, null, null);

				getAllemployee.add(reqEdit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(getAllemployee);
		logger.info("Method : viewAboutOrganizationDao ends" + resp);
		return resp;
	}

	/*
	 * Birthdays
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsEventDashboardModel>> getTotalBirthdayDao(String organization,
			String orgDivision) {
		logger.info("Method : getTotalBirthday Dao starts");

		List<RestHrmsEventDashboardModel> req = new ArrayList<RestHrmsEventDashboardModel>();
		JsonResponse<List<RestHrmsEventDashboardModel>> resp = new JsonResponse<List<RestHrmsEventDashboardModel>>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("dashboardEventRoutines")
					.setParameter("actionType", "totalBirdays").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {

				RestHrmsEventDashboardModel reqEdit = new RestHrmsEventDashboardModel(null, m[0], m[1], m[2], null,
						null, null, null, null, null, null, null, null);

				req.add(reqEdit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(req);
		logger.info("Method : getTotalBirthday Dao ends");
		return resp;
	}

//Marriage Anniversary
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsEventDashboardModel>> getTotalMrgAnniversary(String organization,
			String orgDivision) {
		logger.info("Method : getTotalMrgAnniversary Dao starts");

		List<RestHrmsEventDashboardModel> req = new ArrayList<RestHrmsEventDashboardModel>();
		JsonResponse<List<RestHrmsEventDashboardModel>> resp = new JsonResponse<List<RestHrmsEventDashboardModel>>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("dashboardEventRoutines")
					.setParameter("actionType", "totalMarraigeAnniversary").setParameter("actionValue",value)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsEventDashboardModel reqEdit = new RestHrmsEventDashboardModel(null, null, null, null, m[0],
						m[1], m[2], null, null, null, null, null, null);

				req.add(reqEdit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(req);
		logger.info("Method : getTotalMrgAnniversary Dao ends");
		return resp;
	}

	// Service Anniversary

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsEventDashboardModel>> getTotalServiceAnniversary(String organization,
			String orgDivision) {
		logger.info("Method : getTotalServiceAnniversary Dao starts");

		List<RestHrmsEventDashboardModel> req = new ArrayList<RestHrmsEventDashboardModel>();
		JsonResponse<List<RestHrmsEventDashboardModel>> resp = new JsonResponse<List<RestHrmsEventDashboardModel>>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("dashboardEventRoutines")
					.setParameter("actionType", "totalServiceAnniversary").setParameter("actionValue",value)
					.getResultList();

			for (Object[] m : x) {

				RestHrmsEventDashboardModel reqEdit = new RestHrmsEventDashboardModel(null, null, null, null, null,
						null, null, m[0], m[1].toString(), m[2], null, null, null);

				req.add(reqEdit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(req);
		logger.info("Method : getTotalServiceAnniversary Dao ends");
		return resp;
	}

	// Announcement
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsEventDashboardModel>> getTotalAnnouncement(String organization,
			String orgDivision) {
		logger.info("Method : getTotalAnnouncement Dao starts");

		List<RestHrmsEventDashboardModel> req = new ArrayList<RestHrmsEventDashboardModel>();
		JsonResponse<List<RestHrmsEventDashboardModel>> resp = new JsonResponse<List<RestHrmsEventDashboardModel>>();
		String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("dashboardEventRoutines")
					.setParameter("actionType", "totalAnnouncement").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {

				RestHrmsEventDashboardModel reqEdit = new RestHrmsEventDashboardModel(null, null, null, null, null,
						null, null, null, null, null, m[0], m[1], m[2]);

				req.add(reqEdit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(req);
		logger.info("Method : getTotalAnnouncement Dao ends");
		return resp;
	}

	// Public Holiday
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsEventDashboardModel>> getTotalPublicHoliday(String organization,
			String orgDivision) {
		logger.info("Method : getTotalPublicHoliday Dao starts");

		List<RestHrmsEventDashboardModel> req = new ArrayList<RestHrmsEventDashboardModel>();
		JsonResponse<List<RestHrmsEventDashboardModel>> resp = new JsonResponse<List<RestHrmsEventDashboardModel>>();
		String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("dashboardEventRoutines")
					.setParameter("actionType", "publicHolidaylist").setParameter("actionValue",value).getResultList();
			for (Object[] m : x) {

				RestHrmsEventDashboardModel hlist = new RestHrmsEventDashboardModel(m[0], m[1].toString(),
						m[2].toString(), m[3]);
				req.add(hlist);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(req);
		logger.info("Method : getTotalPublicHoliday Dao ends");
		return resp;
	}

	// Leave Eligibility

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsEventDashboardModel>> viewLeaveEligibility(String organization,
			String orgDivision) {
		logger.info("Method :viewLeaveEligibilityDao starts");

		List<RestHrmsEventDashboardModel> getAllemployee = new ArrayList<RestHrmsEventDashboardModel>();
		JsonResponse<List<RestHrmsEventDashboardModel>> resp = new JsonResponse<List<RestHrmsEventDashboardModel>>();
		String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("dashboardEventRoutines")
					.setParameter("actionType", "leaveEligibility").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {

				RestHrmsEventDashboardModel reqEdit = new RestHrmsEventDashboardModel(m[0], null, null);

				getAllemployee.add(reqEdit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(getAllemployee);
		logger.info("Method :viewLeaveEligibilityDao ends" + resp);
		return resp;
	}

	// Public Open position
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsEventDashboardModel>> getOpenPositionListDao(String organization,
			String orgDivision) {
		logger.info("Method : getOpenPositionListDao Dao starts");

		List<RestHrmsEventDashboardModel> req = new ArrayList<RestHrmsEventDashboardModel>();
		JsonResponse<List<RestHrmsEventDashboardModel>> resp = new JsonResponse<List<RestHrmsEventDashboardModel>>();
		String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("dashboardEventRoutines")
					.setParameter("actionType", "getOpenPositionList").setParameter("actionValue",value).getResultList();
			for (Object[] m : x) {

				RestHrmsEventDashboardModel oplist = new RestHrmsEventDashboardModel(m[0], m[1], m[2], m[3],
						m[4].toString());
				req.add(oplist);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(req);
		logger.info("Method : getOpenPositionListDao Dao ends");
		return resp;
	}

	// Leave Policy
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestHrmsEventDashboardModel>> getLeavePolicyListDao(String organization,
			String orgDivision) {
		logger.info("Method : getLeavePolicyListDao Dao starts");

		List<RestHrmsEventDashboardModel> req = new ArrayList<RestHrmsEventDashboardModel>();
		JsonResponse<List<RestHrmsEventDashboardModel>> resp = new JsonResponse<List<RestHrmsEventDashboardModel>>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("dashboardEventRoutines")
					.setParameter("actionType", "getLeavePolicyList").setParameter("actionValue",value).getResultList();
			for (Object[] m : x) {

				RestHrmsEventDashboardModel lplist = new RestHrmsEventDashboardModel(m[0], m[1].toString(),
						m[2].toString());
				req.add(lplist);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(req);
		logger.info("Method : getLeavePolicyListDao Dao ends");
		return resp;
	}

}
