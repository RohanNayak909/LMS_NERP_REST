package nirmalya.aatithya.restmodule.ticket.dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.ticket.GenerateTicketAddManagementParm;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.ticket.model.TicketManagementRestModel;
import nirmalya.aatithya.restmodule.ticket.model.TicketRestDocumentManagementModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class TicketManagementDao {
	Logger logger = LoggerFactory.getLogger(TicketManagementDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	// Ticket Type List.

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTicketTypeList(String org, String orgDiv) {
		logger.info("Method : getTicketTypeList starts");

		List<DropDownModel> getTicketTypeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getTicketTypeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getTicketTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTicketTypeList ends");
		return getTicketTypeList;
	}
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeList(String org, String orgDiv) {
		logger.info("Method : getEmployeeList starts");
		
		List<DropDownModel> getTicketTypeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getAllEmployeeList").setParameter("actionValue", value).getResultList();
			
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getTicketTypeList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEmployeeList ends");
		return getTicketTypeList;
	}

	// Asset List.

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAssetList(String org, String orgDiv,String userId) {
		logger.info("Method : getAssetList starts");

		List<DropDownModel> getAssetList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv+ "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getAssetList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAssetList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAssetList ends");
		return getAssetList;
	}

	// Ticket Category List.

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getTicketCategoryDao(String id, String org,
			String orgDiv) {
		logger.info("Method : getTicketCategoryDao starts");

		List<DropDownModel> getTicketCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tid='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getTicketCategoryList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2]);
				getTicketCategoryList.add(dropDownModel);
			}
			if (getTicketCategoryList.size() > 0) {
				Util.setJsonResponse(resp, getTicketCategoryList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, getTicketCategoryList, ResponseStatus.success,
						ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getTicketCategoryDao ends");
		return response;
	}

	// Ticket Category List.

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getTicketSubCategoryDao(String id, String org,
			String orgDiv) {
		logger.info("Method : getTicketSubCategoryDao starts");

		List<DropDownModel> getTicketSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_tid='" + id + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getTicketSubCategoryList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getTicketSubCategoryList.add(dropDownModel);
			}
			if (getTicketSubCategoryList.size() > 0) {
				Util.setJsonResponse(resp, getTicketSubCategoryList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, getTicketSubCategoryList, ResponseStatus.success,
						ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getTicketSubCategoryDao ends");
		return response;
	}

	// Ticket Priority List.

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getPriorityList(String org, String orgDiv) {
		logger.info("Method : getPriorityList starts");

		List<DropDownModel> getPriorityList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getPriorityList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getPriorityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPriorityList ends");
		return getPriorityList;
	}

	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getSourceList(String org, String orgDiv) {
		logger.info("Method : getSourceList starts");

		List<DropDownModel> getPriorityList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getSourceList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getPriorityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getSourceList ends");
		return getPriorityList;
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getEmpListDao(String organization, String orgDivision, String userId) {
		logger.info("Method : getEmpListDao starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
		logger.info(value + "valuessssssssssss");

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "viewEmpList").setParameter("actionValue", value).getResultList();

			resp.setBody(x);

			logger.error("respppp: " + resp.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getEmpListDao: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getEmpListDao ends");
		return resp;
	}

	// Add Ticket.

	public ResponseEntity<JsonResponse<TicketManagementRestModel>> saveTicketDtls(
			List<TicketManagementRestModel> category) {
		logger.info("Method : saveTicketDtls starts");

		Boolean validity = true;
		JsonResponse<TicketManagementRestModel> resp = new JsonResponse<TicketManagementRestModel>();
		resp.setMessage("");
		resp.setCode("");
		JSONObject json = new JSONObject();
		
		if (category.get(0).getDocumentList().size() > 0) {
			for (TicketRestDocumentManagementModel a : category.get(0).getDocumentList()) {
				
				String[] x = a.getFileName().split("\\."); 
				String extension = x[x.length - 1];
				
				for (String s1 : a.getDocumentFile()) {
					if (s1 != null) {
						try {
							byte[] bytes = Base64.getDecoder().decode(s1);
							json = saveAllMediaDocuments(bytes, extension, category.get(0).getCreatedBy());

						} catch (Exception e) {
							e.printStackTrace();
						}
						a.setDocumentURL(json.getString("fileurl"));
					}
				}
			}
		}

		String values = GenerateTicketAddManagementParm.saveTicketDetails(category);

		if (validity)
			try {

				if (category.get(0).getTicketId() != null && category.get(0).getTicketId() != "") {
					System.out.println("modifiying=====================");
					em.createNamedStoredProcedureQuery("ticket_management_Routines")
							.setParameter("actionType","modifyTicketDtls").setParameter("actionValue", values).execute();
					resp.setMessage("Ticket modified successfully");
					resp.setCode("success");

				} else {
					em.createNamedStoredProcedureQuery("ticket_management_Routines")
							.setParameter("actionType", "addTicketDtls").setParameter("actionValue", values).execute();
					resp.setMessage("Ticket raised successfully");
					resp.setCode("success");

				}

			} catch (Exception e) {

				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
					Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();

			}
		ResponseEntity<JsonResponse<TicketManagementRestModel>> response = new ResponseEntity<JsonResponse<TicketManagementRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveTicketDtls ends");
		return response;
	}

	public JSONObject saveAllMediaDocuments(byte[] imageBytes, String ext, String user_id) {
		logger.info("Method : saveAllMedicalDocuments starts");
		String imageName = null;
		try {
			if (imageBytes != null) {
				long nowTime = new Date().getTime();

				/*
				 * if (filetype.equals("Video")) { ext = "mp4"; }
				 */
				if (ext.contentEquals("flv") || ext.contentEquals("avi") || ext.contentEquals("3gp")
						|| ext.contentEquals("mov") || ext.contentEquals("cda") || ext.contentEquals("wav")
						|| ext.contentEquals("mkv") || ext.contentEquals("wma") || ext.contentEquals("wpl")) {
					ext = "mp4";
				}
				if (ext.contentEquals("jpeg")) {
					imageName = user_id + "_" + nowTime + ".jpg";
				} else {
					imageName = user_id + "_" + nowTime + "." + ext;
				}
			}
			Path path = Paths.get(env.getFileUploadticketUrl() + imageName);
			if (imageBytes != null) {
				Files.write(path, imageBytes);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = env.getMobileView() + "document/ticketDocs/" + imageName;

		JSONObject json = new JSONObject();

		try {
			json.put("filename", imageName);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			json.put("fileurl", url);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("Method : saveAllMediaDocuments ends");
		return json;
	}

	// View Ticket.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewTicketData(String orgName, String orgDivision, String userId, String pageno) {
		logger.info("Method : viewTicketData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId
					+ "',@p_pageno='" + pageno + "';";
			System.out.println("viewTicketData  value-------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "viewTicketData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : viewTicketData Dao ends");
		return resp;

	}
	// View Ticket search

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewTicketDataSearch(String orgName, String orgDivision, String userId,
			String searchValue) {
		logger.info("Method : viewTicketDataSearch Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId
					+ "',@p_Svalue='" + searchValue + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "viewTicketDatasearch").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : viewTicketDataSearch Dao ends");
		return resp;

	}
	
	// Edit Ticket.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editTicket(String id, String orgName, String orgDivision) {
		logger.info("Method : editTicket Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_ticketId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "editTicket").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setMessage("Data Fetched Successfully");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : editTicket Dao ends");
		return resp;
	}

	// delete Ticket.

	public ResponseEntity<JsonResponse<Object>> deleteTicket(String id, String userId, String orgName,
			String orgDivision) {
		logger.info("Method : deleteTicket dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_ticketId='" + id + "',@p_userId='" + userId + "',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "';";
			em.createNamedStoredProcedureQuery("ticket_management_Routines").setParameter("actionType", "deleteTicket")
					.setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
			resp.setMessage("icket Deleted Successfully");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteTicket dao ends");
		return response;
	}

	// Ticket Category List.

	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getCurrentDepartmentDao(String userid, String org, String orgDiv) {
		logger.info("Method : getTicketSubCategoryDao starts");

		List<DropDownModel> getTicketSubCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_userid='" + userid + "', @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getCurrDepartment").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getTicketSubCategoryList.add(dropDownModel);
			}
			if (getTicketSubCategoryList.size() > 0) {
				Util.setJsonResponse(resp, getTicketSubCategoryList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, getTicketSubCategoryList, ResponseStatus.success,
						ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getTicketSubCategoryDao ends");
		return resp;
	}

	// Attachment View

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> attachemntDaoView(String id, String orgName, String orgDivision) {
		logger.info("Method : attachemntDaoView Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_ticketId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "attachemntView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setMessage("Data Fetched Succesfully");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}

		logger.info("Method : attachemntDaoView Dao ends");
		return resp;
	}

	// API SECTION

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getTicketTypeListApi(String org, String orgDiv) {
		logger.info("Method : getTicketTypeListApi starts");

		List<DropDownModel> getTicketTypeList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getTicketTypeList").setParameter("actionValue", value).getResultList();

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
		logger.info("Method : getTicketTypeListApi ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPriorityListApi(String org, String orgDiv) {
		logger.info("Method : getPriorityListApi starts");

		List<DropDownModel> getPriorityList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "getPriorityList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getPriorityList.add(dropDownModel);
			}
			if (getPriorityList.size() > 0) {
				Util.setJsonResponse(resp, getPriorityList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, getPriorityList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPriorityListApi ends");
		return response;
	}

	public JsonResponse<Object> saveTicketChatDtls(
			List<TicketManagementRestModel> category) {
		logger.info("Method : saveTicketChatDtls starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		JSONObject json = new JSONObject();

		String values = GenerateTicketAddManagementParm.saveTicketChatDetails(category);
		System.out.println("VALUE:::"+values);
		if (validity)
			try {
				@SuppressWarnings("unchecked")
				List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
						.setParameter("actionType", "saveChatDtls").setParameter("actionValue", values).getResultList();
				resp.setBody(x.get(0));
				resp.setMessage("Data Fetched Succesfully");
				resp.setCode("success");
					

			} catch (Exception e) {

				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
					Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();

			}
		logger.info("Method : saveTicketChatDtls ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewChatData(String id, String orgName, String orgDivision,String type) {
		logger.info("Method : viewChatData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_ticketId='" + id + "',@p_org='" + orgName + "',@p_type='" + type + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("VALUE:::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ticket_management_Routines")
					.setParameter("actionType", "viewChatData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setMessage("Data Fetched Succesfully");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}

		logger.info("Method : viewChatData Dao ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> saveRateDetails(String id,String rate, String userId, String orgName,
			String orgDivision) {
		logger.info("Method : saveRateDetails dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_ticketId='" + id + "',@p_userId='" + userId + "',@p_rate='" + rate + "',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "';";
			System.err.println("value==="+value);
			em.createNamedStoredProcedureQuery("ticket_management_Routines").setParameter("actionType", "saveRating")
					.setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
			resp.setMessage("Rating Submitted Successfully");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : saveRateDetails dao ends");
		return response;
	}
}
