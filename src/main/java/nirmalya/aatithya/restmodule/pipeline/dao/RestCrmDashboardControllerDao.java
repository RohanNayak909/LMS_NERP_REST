package nirmalya.aatithya.restmodule.pipeline.dao;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestCrmDashboardControllerDao {

	Logger logger = LoggerFactory.getLogger(RestCrmDashboardControllerDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOrganization(String orgName) {
		logger.info("Method : getOrganization starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
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

	//

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDivision(String orgName) {
		logger.info("Method : getDivision starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
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
	
	//getAllRecordOperational
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllRecordOperational(String orgName, String orgDivision, String fromDate,
			String toDate, String id, String loc, String allKeyRoles) {
		logger.info("Method : getAllRecordOperational Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
	                + "',@p_toDate='" + toDate + "',@p_id='" + id + "',@p_loc='" + loc + "', @p_allKeyRoles=\"" + allKeyRoles + "\";";

			logger.info("getAllOperational--value----------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
					.setParameter("actionType", "getAllOperational").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllRecordOperational Dao ends" + resp);
		return resp;

	}
	
	
		//getAllRecordOperationalExecutive
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getAllRecordOperationalExecutive(String orgName, String orgDivision, String fromDate,
				String toDate, String id, String loc, String executive) {
			logger.info("Method : getAllRecordOperationalExecutive Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {				
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate
		                + "',@p_toDate='" + toDate + "',@p_id='" + id + "',@p_loc='" + loc +
		                "',@p_executive='" + executive + "';";

				logger.info("getAllOperational------------" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "getAllOprtnalExctv").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getAllRecordOperationalExecutive Dao ends" + resp);
			return resp;

		}
	

		
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllCRMHeadCount(String orgName, String orgDivision, String fromDate, String toDate,
			String loc, String allKeyRoles) {
		logger.info("Method : getAllCRMHeadCount Dao starts");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();
				
		logger.info("getAllCRMHeadCount-----allKeyRoles-------" + allKeyRoles);

		try {
			
			String value = "SET @p_org='" + orgName + "', @p_orgDiv='" + div + "', @p_fromDate='" + fromDate
		               + "', @p_toDate='" + toDate + "', @p_loc='" + loc + "', @p_allKeyRoles=\"" + allKeyRoles + "\";";
			
			logger.info("getAllCRMHeadCount---value---------" + value);      
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
					.setParameter("actionType", "getAllHeadCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllCRMHeadCount Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllCRMCityList(String id) {

		logger.info("Method : getAllCRMCityList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_division='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
					.setParameter("actionType", "getAllCityList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getAllCRMCityList ends");
		return response;
	}

	
	//getAllCRMHeadCountExecutive
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllCRMHeadCountExecutive(String orgName, String orgDivision, String fromDate, String toDate,
			String loc, String executive) {
		logger.info("Method : getAllCRMHeadCountExecutive Dao starts");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
	                + "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_executive ='" + executive 
	                + "';";
			System.out.println("getAllCRMHeadCountExecutive  value----------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
					.setParameter("actionType", "getAllHeadCntExctv").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllCRMHeadCountExecutive Dao ends" + resp);
		return resp;

	}
	
	//getTop5SalesExecutive
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTop5SalesExecutive(String orgName, String orgDivision, String fromDate, String toDate,
			String loc,String executive, String allKeyRoles) {
		logger.info("Method : getTop5SalesExecutive Dao starts");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_executive ='" + executive + "', @p_allKeyRoles=\"" + allKeyRoles + "\";";
			
			String allExecutive = "All";
			if(executive.equalsIgnoreCase(allExecutive)) {
				System.out.println("getTop5SalesExecutive  value1----------"+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "top5salesExctv").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				System.out.println("getTop5SalesExecutive  value2----------"+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "top5SalesExtWise").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
			
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getTop5SalesExecutive Dao ends" + resp);
		return resp;

	}
	
	//getAllCountForLeadRatios
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllCountForLeadRatios(String orgName, String orgDivision, String fromDate, String toDate,
			String loc, String executive, String allKeyRoles) {
		logger.info("Method : getAllCountForLeadRatios Dao starts");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_executive ='" + executive + "', @p_allKeyRoles=\"" + allKeyRoles + "\";";
			
			System.out.println("getAllCountForLeadRatios value-----------"+value);
			
			String allExecutive = "All";
			if(executive.equalsIgnoreCase(allExecutive)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "leadRatiosCount").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "leadRtoCntExtWise").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllCountForLeadRatios Dao ends" + resp);
		return resp;

	}
	
	//getCRMSalesTargetLength
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getCRMSalesTargetLength(String orgName, String orgDivision, String fromDate, String toDate,
			String loc, String executive, String allKeyRoles) {
		logger.info("Method : getCRMSalesTargetLength Dao starts");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_executive ='" + executive + "', @p_allKeyRoles=\"" + allKeyRoles + "\";";
			logger.info("Method : getCRMSalesTargetLength value" + value);
			String allExecutive = "All";
			if(executive.equalsIgnoreCase(allExecutive)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "cyclAvgSaleLgnth").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "cyclAvgSaleLgnth").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getCRMSalesTargetLength Dao ends" + resp);
		return resp;

	}
	
	
	//getAllConvertedLeadCountInLast30Days
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllConvertedLeadCountInLast30Days(String orgName, String orgDivision, String fromDate, String toDate,
			String loc, String executive, String allKeyRoles) {
		logger.info("Method : getAllConvertedLeadCountInLast30Days Dao starts");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_executive ='" + executive + "', @p_allKeyRoles=\"" + allKeyRoles + "\";";
			
			logger.info("Method : getAllConvertedLeadCountInLast30Days value" + value);
			String allExecutive = "All";
			if(executive.equalsIgnoreCase(allExecutive)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "leadCnvrtLAst30Days").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "leadCnvtLst30DysExt").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllConvertedLeadCountInLast30Days Dao ends" + resp);
		return resp;

	}
	//getAllConvertedCountFunnelAndAvgDays
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllConvertedCountFunnelAndAvgDays(String orgName, String orgDivision, String fromDate, String toDate,
			String loc, String executive, String allKeyRoles) {
		logger.info("Method : getAllConvertedCountFunnelAndAvgDays Dao starts");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_executive ='" + executive + "', @p_allKeyRoles=\"" + allKeyRoles + "\";";
			
			logger.info("Method : getAllConvertedCountFunnelAndAvgDays value" + value);
			String allExecutive = "All";
			if(executive.equalsIgnoreCase(allExecutive)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "countFunnelAvgDays").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "cntFunlAvgDysExct").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllConvertedCountFunnelAndAvgDays Dao ends" + resp);
		return resp;

	}

	//getActivitiesCountHead
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getActivitiesCountHead(String orgName, String orgDivision, String fromDate, String toDate,
			String loc, String executive, String allKeyRoles) {
		logger.info("Method : getActivitiesCountHead Dao starts");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_executive ='" + executive + "', @p_allKeyRoles=\"" + allKeyRoles + "\";";
			System.out.println("getActivitiesCountHead value-----------"+value);
			String allExecutive = "All";
			if(executive.equalsIgnoreCase(allExecutive)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "countActivitiesHead").setParameter("actionValue", value).getResultList();
			
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				System.out.println("getActivitiesCountHead value2-----------"+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "cntActyHeadExct").setParameter("actionValue", value).getResultList();
			
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
				
			}
			
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getActivitiesCountHead Dao ends" + resp);
		return resp;

	}
	
	
	
	
	//getActivitiesLeadCalls
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getActivitiesLeadCalls(String orgName, String orgDivision, String fromDate, String toDate,
			String loc, String executive, String allKeyRoles) {
		logger.info("Method : getActivitiesLeadCalls Dao starts");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_executive ='" + executive + "', @p_allKeyRoles=\"" + allKeyRoles + "\";";
			
			logger.info("Method : getActivitiesLeadCalls value" + value);
			String allExecutive = "All";
			if(executive.equalsIgnoreCase(allExecutive)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "activityLeadCall").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "activityLeadCallExc").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
				
			}
			
			
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getActivitiesLeadCalls Dao ends" + resp);
		return resp;

	}
	
	
	//getActivitiesLeadMeetings
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getActivitiesLeadMeetings(String orgName, String orgDivision, String fromDate, String toDate,
			String loc, String executive, String allKeyRoles) {
		logger.info("Method : getActivitiesLeadMeetings Dao starts");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_executive ='" + executive + "', @p_allKeyRoles=\"" + allKeyRoles + "\";";
			System.out.println("getActivitiesLeadMeetings value-----------"+value);
			String allExecutive = "All";
			if(executive.equalsIgnoreCase(allExecutive)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "activityLeadMeetings").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "activityLeadMeetExct").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
				
			}
			
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getActivitiesLeadMeetings Dao ends" + resp);
		return resp;

	}
	
	
	//getActivitiesLeadTasks
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getActivitiesLeadTasks(String orgName, String orgDivision, String fromDate, String toDate,
			String loc, String executive, String allKeyRoles) {
		logger.info("Method : getActivitiesLeadTasks Dao starts");

		String div = orgDivision.trim();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + div + "',@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "' , @p_loc ='" + loc + "' , @p_executive ='" + executive + "', @p_allKeyRoles=\"" + allKeyRoles + "\";";
			System.out.println("getActivitiesLeadTasks value-----------"+value);
			String allExecutive = "All";
			if(executive.equalsIgnoreCase(allExecutive)) {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "activityLeadTask").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("CRM_DashBoardRoutines")
						.setParameter("actionType", "activityLeadTaskExct").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
				
			}
			
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getActivitiesLeadTasks Dao ends" + resp);
		return resp;

	}

	
}
