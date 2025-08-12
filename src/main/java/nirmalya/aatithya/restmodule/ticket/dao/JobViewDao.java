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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ticket.GenerateTicketAddManagementParm;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class JobViewDao {

	Logger logger = LoggerFactory.getLogger(JobViewDao.class);
	@Autowired
	ServerDao serverDao;

	@Autowired
	private EntityManager em;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// All Department List.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> jobList(String orgName, String orgDivision, String userid, String pageno, String option) {
		logger.info("Method : jobList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userid='" + userid
					+ "',@p_pageno='" + pageno + "',@p_option='" + option + "';";
			
			System.out.println("value for jobList-------------------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "jobViewAllData").setParameter("actionValue", value).getResultList();

			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : jobList Dao ends");

		return resp;

	}
	// All Department List search

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> jobListSearch(String orgName, String orgDivision, String userid, String search, String option, String date) {
		logger.info("Method : jobListSearch Dao starts"+option);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userid='" + userid
					+ "',@p_Svalue='" + search + "',@p_option='" + option+ "',@p_date='" + date + "';";
			System.out.println("value-----------------------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "jobViewAllData-search").setParameter("actionValue", value)
					.getResultList();

			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : jobListSearch Dao ends"+resp);

		return resp;

	}

	// Result status drop down

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getResultStatus(String org, String orgDiv) {
		logger.info("Method : getResultStatus starts");

		List<DropDownModel> getTicketTypeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getResultStatus").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getTicketTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getResultStatus ends");
		return getTicketTypeList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSparePartList(String org, String orgDiv) {
		logger.info("Method : getSparePartList starts");

		List<DropDownModel> getSparePartList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getSparePartList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2]);
				getSparePartList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSparePartList ends");
		return getSparePartList;
	}

	// Result status drop down(Mobile)

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getResultStatusMobile(String org, String orgDiv) {
		logger.info("Method : getResultStatusMobile starts");

		List<DropDownModel> getTicketTypeList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getResultStatus").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getTicketTypeList.add(dropDownModel);
			}
			if (getTicketTypeList.size() > 0) {
				Util.setJsonResponse(resp, getTicketTypeList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, getTicketTypeList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getResultStatusMobile ends");
		return response;
	}

	public ResponseEntity<JsonResponse<TicketManagementRestModel>> saveResultUpload(
			TicketManagementRestModel category) {
		logger.info("Method : saveResultUpload starts");

		Boolean validity = true;
		JsonResponse<TicketManagementRestModel> resp = new JsonResponse<TicketManagementRestModel>();
		resp.setMessage("");
		resp.setCode("");

		String values = GenerateTicketAddManagementParm.saveResultStatus(category);
		System.out.println("PARAM::::::"+values);
		if (validity)
			try {

				em.createNamedStoredProcedureQuery("ticket_management_Routines")
						.setParameter("actionType", "addResultDetails").setParameter("actionValue", values).execute();

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
		logger.info("Method : saveResultUpload ends");
		return response;
	}

	// acceptOperation
	public ResponseEntity<JsonResponse<Object>> acceptOperation(String id, String operation, String orgName,
			String orgDivision,String expectedDate,String expectedTime,String expectedCost) {
		logger.info("Method : acceptOperation starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_assignId='" + id + "',@p_operation='" + operation + "',@p_org='" + orgName
						+ "',@p_orgDiv='" + orgDivision + "',@p_exDate='" + expectedDate+ "',@p_exTime='" + expectedTime+ "',@p_exCost='" + expectedCost+ "';";
				System.out.println("Accept:::::"+value);
				
				em.createNamedStoredProcedureQuery("ticket_management_Routines")
						.setParameter("actionType", "acceptOperation").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Operation Successful");
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

		logger.info("Method : acceptOperation ends");
		return response;
	}

	public JsonResponse<Object> getResultView(String id, String orgName, String orgDivision) {
		logger.info("Method : getResultView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_assignId='" + id + "';";
			System.out.println("----------------"+value);
			Object x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getResultView").setParameter("actionValue", value).getResultList();
			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getResultView Dao ends");

		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getSubCategory(String id, String orgName, String orgDivision) {
		logger.info("Method : getSubCategory Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_catId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getSubCatSpare").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getSubCategory Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> JobTypeList(String orgName, String orgDivision, String userId) {
		logger.info("Method : JobTypeList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userid='" + userId  + "';";
			System.out.println("@@@@@@@@@@@----------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "JobTypeList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : JobTypeList Dao ends"+resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getJobsPolicyWise(String orgName, String orgDivision, String userid, String id, String date) {
		logger.info("Method : getJobsPolicyWise Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userid='" + userid
					+ "',@p_id='" + id + "',@p_date='" + date+ "';";
			System.out.println("Value for deptViewTicketList----------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_maintenance_routines")
					.setParameter("actionType", "getJobsPolicyWise").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getJobsPolicyWise Dao ends");

		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeListforJobview(String org, String orgDiv, String userId) {
		logger.info("Method : getEmployeeListforJobview starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getEmpListJob").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeListforJobview ends");
		return getCollectionList;
	}
}
