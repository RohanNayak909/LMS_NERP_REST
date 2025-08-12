package nirmalya.aatithya.restmodule.ticket.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ticket.GenerateTicketAddManagementParm;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class DepartmentViewDao {

	Logger logger = LoggerFactory.getLogger(DepartmentViewDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// Priority List.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deptViewPriorityList(String orgName, String orgDivision, String userId, String modName) {
		logger.info("Method : deptViewPriorityList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userid='" + userId + "',@p_modName='" + modName + "';";
			System.out.println("@@@@@@@@@@@@@@@@111111111111111111"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "deptViewPriorityList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : deptViewPriorityList Dao ends");
		return resp;

	}

	// Get All Department List(MOBILE)

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllDeptListMobile(String org, String orgDiv) {
		logger.info("Method : getAllDeptListMobile starts");

		List<DropDownModel> deptList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getAllDeptList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				deptList.add(dropDownModel);
			}
			if (deptList.size() > 0) {
				Util.setJsonResponse(resp, deptList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, deptList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllDeptListMobile ends");
		return response;

	}

	// Get All Department List.

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAllDeptList(String org, String orgDiv,String userId) {
		logger.info("Method : getTicketTypeList starts");

		List<DropDownModel> deptList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv+ "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getAllDeptList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				deptList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTicketTypeList ends");
		return deptList;
	}

	// All Department List

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deptViewTicketList(String orgName, String orgDivision, String userid, String id, String pageno, String activity) {
		logger.info("Method : deptViewTicketList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userid='" + userid
					+ "',@p_id='" + id + "',@p_pageno='" + pageno + "',@p_activity='" + activity + "';";
			System.out.println("Value for deptViewTicketList----------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "deptViewTicketList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
			System.out.println("Result for deptViewTicketList----------------"+resp);
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : deptViewTicketList Dao ends");

		return resp;

	}

	// All Department List Search

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deptViewTicketListSerach(String orgName, String orgDivision, String userid, String id, String search, String activity, String date) {
		logger.info("Method : deptViewTicketListSerach Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userid='" + userid
					+ "',@p_id='" +id+ "',@p_Svalue='" + search+ "',@p_activity='" + activity+ "',@p_date='" + date + "';";
			System.out.println("Result for deptViewTicketList----------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "deptViewTicketList-Search").setParameter("actionValue", value)
					.getResultList();

			Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : deptViewTicketListSerach Dao ends");

		return resp;

	}

	// All Employee List

	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getAllEmployeeList(String deptid, String org, String orgDiv) {
		logger.info("Method : getTicketTypeList starts");

		List<DropDownModel> deptList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_deptid='" + deptid + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				deptList.add(dropDownModel);
			}
			if (deptList.size() > 0) {
				Util.setJsonResponse(resp, deptList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, deptList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTicketTypeList ends");
		return resp;
	}

	// Add Ticket.

	public ResponseEntity<JsonResponse<TicketManagementRestModel>> saveAgentDtls(TicketManagementRestModel category) {
		logger.info("Method : saveAgentDtls starts");

		Boolean validity = true;
		JsonResponse<TicketManagementRestModel> resp = new JsonResponse<TicketManagementRestModel>();
		resp.setMessage("");
		resp.setCode("");

		String values = GenerateTicketAddManagementParm.saveAgentDetails(category);
		if (validity)
			try {

				em.createNamedStoredProcedureQuery("ticket_management_Routines")
						.setParameter("actionType", "saveAgentDtls").setParameter("actionValue", values).execute();

				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
			} catch (Exception e) {

				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
					Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				} catch (Exception e1) {
					e1.printStackTrace();
					Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				}
				e.printStackTrace();

			}
		ResponseEntity<JsonResponse<TicketManagementRestModel>> response = new ResponseEntity<JsonResponse<TicketManagementRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveAgentDtls ends");
		return response;
	}

	// All Ticket History.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTicketHistoryDao(String id, String orgName, String orgDivision) {
		logger.info("Method : getTicketHistoryDao Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_ticketno='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getTicketHistory").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getTicketHistoryDao Dao ends");

		return resp;

	}


	// Add Ticket.

	public ResponseEntity<JsonResponse<TicketManagementRestModel>> saveAgentActionDtls(
			TicketManagementRestModel category) {
		logger.info("Method : saveAgentActionDtls starts"+category);

		Boolean validity = true;
		JsonResponse<TicketManagementRestModel> resp = new JsonResponse<TicketManagementRestModel>();
		resp.setMessage("");
		resp.setCode(""); 

		String values = GenerateTicketAddManagementParm.saveAgentDetails(category);

		if (validity)
			try {
				em.createNamedStoredProcedureQuery("ticket_management_Routines")
						.setParameter("actionType", "saveAgentDtls").setParameter("actionValue", values).execute();

				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);

			} catch (Exception e) {

				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
					Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				} catch (Exception e1) {
					e1.printStackTrace();
					Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				}
				e.printStackTrace();

			}
		ResponseEntity<JsonResponse<TicketManagementRestModel>> response = new ResponseEntity<JsonResponse<TicketManagementRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveAgentActionDtls ends"+response);
		return response;
	}

	// Get All vendor List.

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllVendorListMobile(String org, String orgDiv) {
		logger.info("Method : getAllVendorListMobile starts");

		List<DropDownModel> vendorList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getAllVendorList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendorList.add(dropDownModel);
			}

			if (vendorList.size() > 0) {
				Util.setJsonResponse(resp, vendorList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, vendorList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllVendorListMobile ends");
		return response;
	}

	// Get All vendor List.

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAllVendorListDao(String org, String orgDiv) {
		logger.info("Method : getAllVendorListDao starts");

		List<DropDownModel> vendorList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getAllVendorList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAllVendorListDao ends");
		return vendorList;
	}

	// Assigned History
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> historyAssigned(String id, String orgName, String orgDivision, String userId) {
		logger.info("Method : historyAssigned Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_ticketId='" + id + "',@p_userId='" + userId + "',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("AAAAAAAAAAAA"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "historyAssigned").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : historyAssigned Dao ends");
		return resp;
	}

	
	// Close Ticket By admin
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> closeTicketByAdmin(String id, String orgName, String orgDivision,String userId) {
		logger.info("Method : closeTicketByAdmin Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_ticketno='" + id + "',@p_userId='" + userId + "';";
			
		em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "close_ticket_byAdmin").setParameter("actionValue", value).execute();
			//resp.setBody(x.get(0));
			
			resp.setCode("success");
			resp.setMessage("Ticket Closed Successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("Method : closeTicketByAdmin Dao ends"+resp);
		return resp;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> holdTicketByAdmin(String id, String orgName, String orgDivision,String userId) {
		logger.info("Method : holdTicketByAdmin Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_ticketno='" + id + "',@p_userId='" + userId + "';";
			System.out.println("VALUE::::::::::"+value);
			em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "hold_ticket_byAdmin").setParameter("actionValue", value).execute();
			//resp.setBody(x.get(0));
			
			resp.setCode("success");
			resp.setMessage("Ticket Closed Successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : holdTicketByAdmin Dao ends");
		return resp;
		
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> releaseTicketByAdmin(String id, String orgName, String orgDivision,String userId) {
		logger.info("Method : releaseTicketByAdmin Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_ticketno='" + id + "',@p_userId='" + userId + "';";
			
		em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "release_ticket_byAdmin").setParameter("actionValue", value).execute();
			//resp.setBody(x.get(0));
			
			resp.setCode("success");
			resp.setMessage("Ticket Closed Successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : releaseTicketByAdmin Dao ends");
		return resp;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVendorServices(String org, String orgDiv) {
		logger.info("Method : getVendorServices starts");

		List<DropDownModel> deptList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getVendorServices").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				deptList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVendorServices ends");
		return deptList;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getVendorDetailsOnService(String serviceId, String org, String orgDiv) {
		logger.info("Method : getTicketTypeList starts");

		List<DropDownModel> serviceList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_serviceId='" + serviceId + "';";
		System.out.println("SERVICE VALUE:::"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "vendorOnService").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				serviceList.add(dropDownModel);
			}
			if (serviceList.size() > 0) {
				Util.setJsonResponse(resp, serviceList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, serviceList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getVendorDetailsOnService ends");
		return resp;
	}
	

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPolicyList(String org, String orgDiv, String userId) {
		logger.info("Method : getPolicyList starts");

		List<DropDownModel> vendorList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv+ "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getPolicyList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vendorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPolicyList ends");
		return vendorList;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTicketPolicyWise(String orgName, String orgDivision, String userid, String id) {
		logger.info("Method : getTicketPolicyWise Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userid='" + userid
					+ "',@p_id='" + id + "';";
			System.out.println("Value for deptViewTicketList----------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getTicketPolicyWise").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getTicketPolicyWise Dao ends");

		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPolListDateWise(String aid, String pid, String orgName, String orgDivision, String shift) {
		logger.info("Method : getPolListDateWise Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String Date = DateFormatter.getStringDate(pid);
		try {
			String value = "SET @p_allotId='" + aid + "',@p_date='" + Date + "',@p_org='" + orgName + "',@p_orgDiv='"+ orgDivision + "',@p_shift='"+ shift+ "';";
			System.out.println("VALUE::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "getPolListDateWise").setParameter("actionValue", value).getResultList();
			Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getPolListDateWise Dao ends"+resp);
		return resp;
	}
}
