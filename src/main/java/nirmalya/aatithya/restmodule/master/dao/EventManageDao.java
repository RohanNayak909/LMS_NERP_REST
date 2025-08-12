package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.HrmsGenerateEventManagement;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.RestEventManagementModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.PushNotification;
import nirmalya.aatithya.restmodule.util.StringUtil;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class EventManageDao {
	Logger logger = LoggerFactory.getLogger(EventManageDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	PushNotification pushNotification = new PushNotification();

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getOrganiserListDao() {
		logger.info("Method : getOrganiserListDao starts");
		List<DropDownModel> orginesList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "getOrganiserList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				orginesList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getOrganiserListDao ends");
		return orginesList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEventTypeListDao() {
		logger.info("Method : getEventTypeListDao starts");
		List<DropDownModel> eventTypeList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "eventTypeList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				eventTypeList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEventTypeListDao ends");
		return eventTypeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getResponsibleListDao() {
		logger.info("Method : getEventTypeListDao starts");
		List<DropDownModel> responsibleList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "responsibleList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				responsibleList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEventTypeListDao ends");
		return responsibleList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getVanueListDao() {
		logger.info("Method : getVanueListDao starts");
		List<DropDownModel> vanueList = new ArrayList<DropDownModel>();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "vanueList").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				vanueList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getVanueListDao ends");
		return vanueList;
	}

	// view

	/*
	 * @SuppressWarnings("unchecked") public
	 * JsonResponse<List<RestEventManagementModel>> viewEventManagement(String
	 * userId, String userRole,String organization, String orgDivision) {
	 * logger.info("Method : viewEventManagement starts");
	 * JsonResponse<List<RestEventManagementModel>> resp = new
	 * JsonResponse<List<RestEventManagementModel>>();
	 * List<RestEventManagementModel> event = new
	 * ArrayList<RestEventManagementModel>(); try { String value = "SET @p_empId=\""
	 * + userId + "\",@p_userRole='(" + userRole + ")', @p_org=\"" + organization +
	 * "\", @p_orgDiv=\"" + orgDivision + "\";"; logger.info("value===="+value);
	 * List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
	 * .setParameter("actionType",
	 * "viewEventManagement").setParameter("actionValue", "").getResultList();
	 * if(x.size()>0) { Util.setJsonResponse(resp, x,
	 * ResponseStatus.success,ApiResponseMessage.DATA_FETCH_SUCCESS); }else {
	 * Util.setJsonResponse(resp, x,
	 * ResponseStatus.success,ApiResponseMessage.NO_DATA_FOUND); } for (Object[] m :
	 * x) { Object DATE = null; if (m[6] != null) { DATE = m[6].toString(); } Object
	 * CREATEDON = null; if (m[7] != null) { CREATEDON = m[7].toString(); } Object
	 * ApproveDate = null; if (m[12] != null) { ApproveDate = m[12].toString(); }
	 * RestEventManagementModel adv = new RestEventManagementModel(m[0], m[1], m[2],
	 * m[3], m[4], m[5], DATE, CREATEDON); event.add(adv); } if (event.size() > 0) {
	 * resp.setBody(event); resp.setCode("success");
	 * resp.setMessage("Data fetched successfully"); } else { resp.setBody(event);
	 * resp.setCode("failed"); resp.setMessage("Data not found"); } } catch
	 * (Exception e) {
	 * 
	 * Util.setJsonResponse(resp, null,
	 * ResponseStatus.failed,ApiResponseMessage.UNKNOWN_EXCEPTION);
	 * logger.error("viewReimbursement: " + e.getMessage()); e.printStackTrace();
	 * 
	 * resp.setBody(event); resp.setCode("failed"); resp.setMessage(e.getMessage());
	 * } resp.setBody(event); logger.info("VIEWSW"+event);
	 * logger.info("Method : viewEventManagement ends"); return resp; }
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestEventManagementModel>>> viewEventManagement(String userId,
			String userRole, String organization, String orgDivision) {
		logger.info("Method : viewEventManagement starts");
		List<RestEventManagementModel> respList = new ArrayList<RestEventManagementModel>();

		try {
			String value = "SET @p_empId=\"" + userId + "\",@p_userRole='(" + userRole + ")', @p_org=\"" + organization
					+ "\", @p_orgDiv=\"" + orgDivision + "\";";
			logger.info("value====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "viewEventManagement").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				Object date1 = null;
				if (m[2] != null) {
					date = m[2].toString();
				}
				if (m[3] != null) {
					date1 = m[3].toString();
				}
				Object DATE = null;
				if (m[6] != null) {
					DATE = m[6].toString();
				}
				Object CREATEDON = null;
				if (m[7] != null) {
					CREATEDON = m[7].toString();
				}
				Object CREATEDON1 = null;
				if (m[14] != null) {
					CREATEDON1 = m[14].toString();
				}

				RestEventManagementModel restPayroll = new RestEventManagementModel(m[0].toString(), m[1], date, date1,
						m[4], m[5], DATE, CREATEDON, m[8], m[9], m[10], m[11], m[12], m[13], CREATEDON1);
				respList.add(restPayroll);

			}

			logger.info("respList" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestEventManagementModel>> resp = new JsonResponse<List<RestEventManagementModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestEventManagementModel>>> response = new ResponseEntity<JsonResponse<List<RestEventManagementModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : viewEventManagement ends");
		return response;

	}

	public JsonResponse<Object> addEvantDao(RestEventManagementModel eventManagementModel) {
		// TODO Auto-generated method stub
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {

				if (eventManagementModel.getEventId() == null || eventManagementModel.getEventId() == "") {
					String values = HrmsGenerateEventManagement.addEvent(eventManagementModel);
					logger.info("Model  :" + eventManagementModel);
					logger.info("ADDDDDDDDDDD: " + values);
					em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
							.setParameter("actionType", "addEvent").setParameter("actionValue", values).execute();
				} else {
					String values = HrmsGenerateEventManagement.modifyEvent(eventManagementModel);
					logger.info("Model  :" + eventManagementModel);
					logger.info("MODIFYY: " + values);
					em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
							.setParameter("actionType", "modifyEvent").setParameter("actionValue", values).execute();
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
		return resp;
	}

	// approve

	public JsonResponse<RestEventManagementModel> approveEventManagement(String id, String name, String comment,
			String roleid) {
		logger.info("Method : approveEventManagement starts");

		RestEventManagementModel req = new RestEventManagementModel();
		JsonResponse<RestEventManagementModel> resp = new JsonResponse<RestEventManagementModel>();

		try {

			String value = "SET @p_eventId='" + id + "',@p_approveBy='" + name + "',@p_comment='" + comment
					+ "',@p_userRole='(" + roleid + ")';";

			em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "approveEventManagement").setParameter("actionValue", value).execute();
			resp.setBody(req);
			List<DropDownModel> managerByUesr = checkDuplicateDao.getUserByRequisitionId(id, name);
			for (DropDownModel m : managerByUesr) {
				String msg = m.getName() + " approved your Advance";
				try {
					String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			logger.error("approveEventManagement: " + e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : approveEventManagement ends");
		return resp;
	}

	// reject

	public JsonResponse<RestEventManagementModel> rejectEventManagement(String id, String name, String comment) {
		logger.info("Method : rejectEventManagement starts");

		RestEventManagementModel req = new RestEventManagementModel();
		JsonResponse<RestEventManagementModel> resp = new JsonResponse<RestEventManagementModel>();
		try {
			String value = "SET @p_eventId='" + id + "',@p_rejectBy='" + name + "',@p_comment='" + comment + "';";
			em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "rejectEventManagement").setParameter("actionValue", value).execute();
			resp.setBody(req);
			List<DropDownModel> managerByUesr = checkDuplicateDao.getUserByRequisitionId(id, name);
			for (DropDownModel m : managerByUesr) {
				String msg = m.getName() + " rejected your Advance";
				try {
					String msgId = pushNotification.pushFCMNotification(m.getKey(), msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			logger.error("rejectEventManagement: " + e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : rejectEventManagement ends");
		return resp;
	}

	// edit

	/*
	 * @SuppressWarnings("unchecked") public JsonResponse<RestEventManagementModel>
	 * editEventManagement(String id) {
	 * logger.info("Method : editEventManagement dao starts");
	 * 
	 * RestEventManagementModel req = new RestEventManagementModel();
	 * JsonResponse<RestEventManagementModel> resp = new
	 * JsonResponse<RestEventManagementModel>(); try { String value =
	 * "SET @p_eventId='" + id + "';"; logger.info(value); List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
	 * .setParameter("actionType",
	 * "editEventManagement").setParameter("actionValue", value).getResultList();
	 * for (Object[] m : x) {
	 * 
	 * Object FROMDATE = null; if (m[2] != null) { FROMDATE
	 * =DateFormatter.returnStringDate(m[2]); } Object TODATE = null; if (m[3] !=
	 * null) { TODATE = DateFormatter.returnStringDate(m[3]); } Object DATE = null;
	 * if (m[8] != null) { DATE =DateFormatter.returnStringDate(m[8]); } Object
	 * DATE1 = null; if (m[9] != null) { DATE1 =
	 * DateFormatter.returnStringDate(m[9]); }
	 * 
	 * Object APPROVE = null; if (m[11] != null) { APPROVE =
	 * DateFormatter.returnStringDate(m[11]); } Object REJECT = null; if (m[12] !=
	 * null) { REJECT = DateFormatter.returnStringDate(m[12]); }
	 * 
	 * RestEventManagementModel reqEdit = new
	 * RestEventManagementModel(m[0].toString(), m[1], FROMDATE, TODATE, m[4],
	 * m[5],m[6],m[7],DATE,DATE1,m[10],m[11]
	 * ,m[12].toString(),m[13].toString(),m[14].toString(),m[15],m[16],m[17],m[18],m
	 * [19],m[20],m[21],m[22]); req = reqEdit; } resp.setBody(req); } catch
	 * (Exception e) { e.printStackTrace(); }
	 * 
	 * logger.info("Method : editEventManagement dao ends");
	 * logger.info("EDIT"+resp); return resp; }
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestEventManagementModel>>> editEventManagement(String id,
			String organization, String orgDivision) {
		logger.info("Method : editEventManagement starts");
		List<RestEventManagementModel> respList = new ArrayList<RestEventManagementModel>();

		try {
			String value = "SET @p_eventId='" + id + "';";
			logger.info("value====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "editEventManagement").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				Object FROMDATE = null;
				if (m[2] != null) {
					FROMDATE = DateFormatter.returnStringDate(m[2]);
				}
				Object TODATE = null;
				if (m[3] != null) {
					TODATE = DateFormatter.returnStringDate(m[3]);
				}
				Object DATE = null;
				if (m[8] != null) {
					DATE = DateFormatter.returnStringDate(m[8]);
				}
				Object DATE1 = null;
				if (m[9] != null) {
					DATE1 = DateFormatter.returnStringDate(m[9]);
				}

				Object DATE2 = null;
				if (m[13] != null) {
					DATE2 = DateFormatter.returnStringDate(m[13]);
				}
				/*
				 * Object REJECT = null; if (m[12] != null) { REJECT =
				 * DateFormatter.returnStringDate(m[12]); }
				 */

				RestEventManagementModel reqEdit = new RestEventManagementModel(m[0].toString(), m[1], FROMDATE, TODATE,
						m[4], m[5], m[6], m[7], DATE, DATE1, m[10], m[11], m[12], DATE2, m[14].toString(),
						m[15].toString(), m[16], m[17], m[18], m[19], m[20], m[21], m[22], m[23]);
				respList.add(reqEdit);

			}

			logger.info("respList" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestEventManagementModel>> resp = new JsonResponse<List<RestEventManagementModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestEventManagementModel>>> response = new ResponseEntity<JsonResponse<List<RestEventManagementModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("EDITT" + response);
		logger.info("Method : editEventManagement ends");
		return response;

	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteEventManagement(String id) {
		logger.info("Method : deleteEventManagement starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_eventId='" + id + "';";
				em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
						.setParameter("actionType", "deleteEventManagement").setParameter("actionValue", value)
						.execute();

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

		logger.info("Method : deleteEventManagement ends");
		logger.info("DELETEE" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getEventEmpName(String id, String orgName, String orgDiv) {
		logger.info("Method : getEventEmpName Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_Id='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "getEventEmpName").setParameter("actionValue", value).getResultList();
			resp.setBody(x.toString());
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getEventEmpName Dao ends" + resp);
		return resp;

	}

	public ResponseEntity<JsonResponse<Object>> addEventDtls(String itm, String eventId, String eventType) {
		logger.info("Method : addEventDtls dao starts" + itm);
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			if (eventType.equalsIgnoreCase("Meeting")) {
				if (!StringUtil.isNull(eventId)) {
					String value = "SET @eventId='" + eventId + "',@itm='" + itm + "';";
					logger.info("value" + value);
					em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
							.setParameter("actionType", "modifyMeeting").setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Event Updated successfully");

				} else {
					String value = "SET @p_eventId='" + eventId + "',@itm='" + itm + "';";
					logger.info("value" + value);
					em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
							.setParameter("actionType", "addMeeting").setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Event Added successfully");
				}
			} else {
				System.out.println("else");
				if (!StringUtil.isNull(eventId)) {
					String value = "SET @eventId='" + eventId + "',@itm='" + itm + "';";
					em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
							.setParameter("actionType", "modifyEvents").setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Event Updated successfully");

				} else {
					String value = "SET @p_eventId='" + eventId + "',@itm='" + itm + "';";
					em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
							.setParameter("actionType", "addEventDtls").setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Event Added successfully");
				}
			}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addEventDtls dao ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getEventviewDtls(String id, String orgName, String orgDiv) {
		logger.info("Method : getEventviewDtls Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_Id='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "getEventviewDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x.toString());
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getEventviewDtls Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editeventList(String id, String orgName, String orgDivision, String userId) {
		logger.info("Method : editeventList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_eventId='" + id + "',@p_org='" + orgName + "'" + ",@p_orgDiv='" + orgDivision
					+ "',@p_userId='" + userId + "';";
			logger.info("value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "editeventList").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editeventList Dao ends" + resp);
		return resp;
	}

	public ResponseEntity<JsonResponse<Object>> addExecution(String itm, String eventId) {
		logger.info("Method : addExecution dao starts" + itm);
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @eventId='" + eventId + "',@itm='" + itm + "';";
			em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines").setParameter("actionType", "addExecution")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Data Updated successfully");

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addExecution dao ends");
		return response;

	}

	// view Training
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewTrainging(String orgName, String orgDivision, String userId, String fromDate,
			String toDate) {
		logger.info("Method : viewTrainging Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'"
					+ ",@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";

			System.out.println("value" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "viewTraining").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewTrainging Dao ends" + resp);
		return resp;

	}

	// pdf
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> eventTrainingPdf(String eventId, String trainingId, String orgName, String orgDivision,
			String userId) {
		logger.info("Method : eventTrainingPdf Dao startsssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_eventId='" + eventId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "'"
					+ ",@p_trainingId='" + trainingId + "',@p_userId='" + userId + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "trainingPdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("resp******" + resp);
		logger.info("Method : eventTrainingPdf Dao ends");
		return resp;

	}

	// employee list
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeLists(String orgName, String orgDivision, String managerId, String userId) {
		logger.info("Method : getEmployeeLists starts");

		List<DropDownModel> emplist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org=\"" + orgName + "\",@p_orgDiv=\"" + orgDivision + "\"" + ",@p_managerId='"
					+ managerId + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "getEventEmployeeList").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2]);
				emplist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getEmployeeLists ends");
		return emplist;
	}

	// employee list
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getTrainingList(String orgName, String orgDivision) {
		logger.info("Method : getTrainingList starts");

		List<DropDownModel> emplist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org=\"" + orgName + "\",@p_orgDiv=\"" + orgDivision + "\"" + ";";
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "getTrainingLists").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], null);
				emplist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getTrainingList ends");
		return emplist;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPrevMeetingList(String meetingDate, String type, String userId, String orgName,
			String orgDivision, String fromDate, String toDate) {
		logger.info("Method : getPrevMeetingList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_meetingDate='" + meetingDate + "',@p_type='" + type + "'" + ",@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "'" + ",@p_fromDate='" + fromDate
					+ "',@p_toDate='" + toDate + "';";
			logger.info("value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "prevMeetingDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPrevMeetingList Dao ends" + resp);
		return resp;
	}

	// pdf
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> eventMeetingPdf(String eventId, String orgName, String orgDivision, String userId,
			String startDate) {
		logger.info("Method : eventMeetingPdf Dao startsssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_eventId='" + eventId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "'"
					+ ",@p_userId='" + userId + "',@p_startDate='" + startDate + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
					.setParameter("actionType", "meetingPdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("resp******" + resp);
		logger.info("Method : eventMeetingPdf Dao ends");
		return resp;

	}

	// Approve Event

		public ResponseEntity<JsonResponse<Object>> approveEvent(String id,String userId,String organization,String orgDivision) {
			logger.info("Method : approveEvent starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			
				try {
					String value = "SET @p_eventId='" + id + "',@p_userId='"+userId+"',@p_organization='"+organization+"',@p_orgDivision='"+orgDivision+"';";
					System.out.println("value"+value);
					em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
							.setParameter("actionType", "approveEvent").setParameter("actionValue", value)
							.execute();

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

			logger.info("Method : approveEvent ends");
			logger.info("approve" + response);
			return response;
		}
		
		
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<DropDownModel>>> getEvenetId(String orgName, String orgDivision) {
			logger.info("Method : getEvenetId starts");
			List<DropDownModel> respList = new ArrayList<DropDownModel>();
			JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
			try {
				String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				logger.info("get getEventNumber  -->" + values);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsEventManagementRoutines")
						.setParameter("actionType", "getEventNumber").setParameter("actionValue", values).getResultList();
				Object jobId = x.get(0);
				
				DropDownModel dropDownModel = new DropDownModel(jobId,null);
				respList.add(dropDownModel);
				resp.setBody(respList);
				resp.setMessage("Success");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setMessage("Unsuccess");
			}
			ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response" + response);
			logger.info("Method : getEvenetId ends");
			System.out.println("VIEWWWWWWWW" + respList);
			return response;

		}
}
