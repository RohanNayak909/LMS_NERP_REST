package nirmalya.aatithya.restmodule.ticket.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RsetManageDashboardDao {
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;

	Logger logger = LoggerFactory.getLogger(RsetManageDashboardDao.class);

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> ticketHeadData(String fromDate, String toDate, String location, String organization,
			String division) {
		logger.info("Method : ticketHeadData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate
					+ "', @p_location='" + location + "',@p_division='" + division + "';";
			logger.info("ticketHeadData Value--------------------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "ticketHeadData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : ticketHeadData Dao ends" + resp);
		return resp;

	}

	// ticketListData

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> operationalAgGridData(String organization, String division, String id, String fromDate,
			String location, String toDate) {
		logger.info("Method : operationalAgGridData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + division + "',@p_id='" + id
					+ "',@p_fromDate='" + fromDate + "',@p_location='" + location + "',@p_toDate='" + toDate + "';";
			System.out.println("operationalAgGridData Value-------->" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "ticketListData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : operationalAgGridData Dao ends" + resp);
		return resp;

	}

	// ticketByType

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> ticketByType(String orgName, String orgDivision) {
		logger.info("Method : ticketByType Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "ticketByType").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : ticketByType Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> ticketByCategory(String orgName, String orgDivision) {
		logger.info("Method : ticketByCategory Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "ticketByCategory").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : ticketByCategory Dao ends" + resp);
		return resp;

	}

	// getOrganization
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOrganization(String orgName) {
		logger.info("Method : getOrganization starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "getOrganization").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getOrganization ends");
		return getCollectionList;
	}

	// getDivision

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDivision(String orgName) {
		logger.info("Method : getDivision starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_dashboard_maintainance_Routines")
					.setParameter("actionType", "orgDivision").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : orgDivision ends");
		return getCollectionList;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> operationalHeadData(String fromDate, String toDate, String location,
			String organization, String division) {
		logger.info("Method : operationalHeadData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_fromDate='" + fromDate + "', @p_toDate='" + toDate
					+ "', @p_location='" + location + "',@p_division='" + division + "';";
			logger.info("operationalHeadData value------------->" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_dashboardRoutines")
					.setParameter("actionType", "operationalData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : operationalHeadData Dao ends =======================>  " + resp);
		return resp;

	}

}
