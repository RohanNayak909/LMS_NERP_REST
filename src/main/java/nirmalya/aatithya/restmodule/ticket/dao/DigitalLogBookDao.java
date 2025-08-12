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
import nirmalya.aatithya.restmodule.asset.dao.AssetPolicyDao;
import nirmalya.aatithya.restmodule.asset.model.AssetPoilcyRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateAssetPolicyParams;
import nirmalya.aatithya.restmodule.common.utils.ticket.GenerateTicketDigitalLogBookParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.ticket.model.DigitalLogBookRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class DigitalLogBookDao {
	Logger logger = LoggerFactory.getLogger(DigitalLogBookDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// add
	public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addLogBook(List<AssetPoilcyRestModel> av) {
		logger.info("Method : addLogBook dao starts");
		JsonResponse<List<AssetPoilcyRestModel>> resp = new JsonResponse<List<AssetPoilcyRestModel>>();

		String value = GenerateAssetPolicyParams.getAddLogBook(av);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + value);
		try {

			if (av.get(0).getLogbookId() != null && av.get(0).getLogbookId() != "") {

				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "modifyLogbook").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "addLogBook").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data saved successfully");

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

		ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> response = new ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addLogBook dao ends");
		return response;

	}

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewLogBook(String orgName, String orgDivision) {
		logger.info("Method : viewLogBook Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
					.setParameter("actionType", "viewLogBook").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewLogBook Dao ends");
		return resp;

	}

	// edit
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editLogbook(String id, String orgName, String orgDivision) {
		logger.info("Method : editLogbook Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_logbookId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("edit----------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
					.setParameter("actionType", "editLogbook").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editLogbook Dao ends" + resp);
		return resp;
	}

	// delete
	public ResponseEntity<JsonResponse<Object>> deleteLogbook(String id, String orgName, String orgDiv) {
		logger.info("Method : deleteLogbook starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_logbookId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("DELETE---------------------" + value);
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "deleteLogbook").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
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

		logger.info("Method : deleteLogbook ends");
		return response;
	}

	// approve
	public ResponseEntity<JsonResponse<Object>> approveLogbook(String id, String orgName, String orgDiv) {
		logger.info("Method : approveLogbook starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_logbookId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("APPROVE------------------------" + value);
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "approveLogbook").setParameter("actionValue", value).execute();
				resp.setMessage("Data Approved Successfully");
				resp.setCode("success");
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
		logger.info("Method : approveLogbook ends");
		return response;
	}

// ELCB LOGBOOK //
	// drop down
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> elcbTypeList(String org, String orgDiv) {
		logger.info("Method : elcbTypeList starts");

		List<DropDownModel> elcbTypeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		System.err.println("value====="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
					.setParameter("actionType", "elcbTypeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString(), m[2].toString());
				elcbTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : elcbTypeList ends");
		return elcbTypeList;
	}
	
	// add
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	public ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>> addelcblogBook(
			List<DigitalLogBookRestModel> av) {
		logger.info("Method : elcblogBook dao starts");
		JsonResponse<List<DigitalLogBookRestModel>> resp = new JsonResponse<List<DigitalLogBookRestModel>>();

		String value = GenerateTicketDigitalLogBookParam.getAddElcbLogBook(av);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + value);
		try {

			if (av.get(0).getElcbId() != null && av.get(0).getElcbId() != "") {

				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "modifyElcblogBook").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				List<String> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
	                     .setParameter("actionType", "addElcblogBook")
	                     .setParameter("actionValue", value)
	                     .getResultList();

				System.err.println("dataaaa====" + x.get(0));
			
				String message = "Cannot insert: ELCB type";
				String data = x.get(0);

				if (data != null && data != "" && !data.isEmpty()) {
					System.err.println("dataaaaDATS====" + data);
					if (data.contains(message)) {
						System.err.println("if  dataaaa====" + data);
					    resp.setCode("unsuccess1");
					    resp.setMessage(data);
					} else {
						System.err.println("else  dataaaa====" + data);
						resp.setCode("success");
					    resp.setMessage("Data saved successfully");
					}
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

		ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>> response = new ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addLogBook dao ends");
		return response;

	}

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewelcblogBook(String orgName, String orgDivision) {
		logger.info("Method : viewelcblogBook Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
					.setParameter("actionType", "viewelcblogBook").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewelcblogBook Dao ends");
		return resp;

	}

	// edit
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editelcblogBook(String id, String orgName, String orgDivision) {
		logger.info("Method : editelcblogBook Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_elcbId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("edit----------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
					.setParameter("actionType", "editelcblogBook").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editelcblogBook Dao ends");
		return resp;
	}

	//
	// delete
	public ResponseEntity<JsonResponse<Object>> deleteElcb(String id, String orgName, String orgDiv) {
		logger.info("Method : deleteElcb starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_elcbId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("DELETE---------------------" + value);
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "deleteElcb").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
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

		logger.info("Method : deleteElcb ends");
		return response;
	}

	// approve
	public ResponseEntity<JsonResponse<Object>> approveElcb(String id, String orgName, String orgDiv) {
		logger.info("Method : approveElcb starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_elcbId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("APPROVE------------------------" + value);
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "approveElcb").setParameter("actionValue", value).execute();
				resp.setMessage("Data Approved Successfully");
				resp.setCode("success");
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
		logger.info("Method : approveElcb ends");
		return response;
	}

// WASTE OIL TRACKING RECORD //
	// add
	public ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>> addOilTrack(List<DigitalLogBookRestModel> av) {
		logger.info("Method : addOilTrack dao starts");
		JsonResponse<List<DigitalLogBookRestModel>> resp = new JsonResponse<List<DigitalLogBookRestModel>>();

		String value = GenerateTicketDigitalLogBookParam.getAddOilTrack(av);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + value);
		try {

			if (av.get(0).getTrackId() != null && av.get(0).getTrackId() != "") {

				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "modifyOilTrack").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "addOilTrack").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data saved successfully");

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

		ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>> response = new ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addOilTrack dao ends");
		return response;

	}

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewOilTrack(String orgName, String orgDivision) {
		logger.info("Method : viewOilTrack Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
					.setParameter("actionType", "viewOilTrack").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewOilTrack Dao ends");
		return resp;

	}

	// edit
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editOilTrack(String id, String orgName, String orgDivision) {
		logger.info("Method : editOilTrack Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_trackId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("edit----------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
					.setParameter("actionType", "editOilTrack").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editOilTrack Dao ends");
		return resp;
	}

	//
	// delete
	public ResponseEntity<JsonResponse<Object>> deleteOilTracking(String id, String orgName, String orgDiv) {
		logger.info("Method : deleteOilTracking starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_oilTrackId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("DELETE---------------------" + value);
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "deleteOilTracking").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
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

		logger.info("Method : deleteOilTracking ends");
		return response;
	}

	// approve
	public ResponseEntity<JsonResponse<Object>> approveOilTracking(String id, String orgName, String orgDiv,
			String userId) {
		logger.info("Method : approveOilTracking starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_oilTrackId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv
						+ "',@p_userId='" + userId + "';";
				System.out.println("APPROVE------------------------" + value);
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "approveOilTracking").setParameter("actionValue", value).execute();
				resp.setMessage("Data Approved Successfully");
				resp.setCode("success");
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
		logger.info("Method : approveOilTracking ends");
		return response;
	}
// INITIATION/COMPLETION OF NON-ROUTINE ACTIVITY

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewActivity1(String orgName, String orgDivision) {
		logger.info("Method : viewActivity1 Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
					.setParameter("actionType", "viewActivity1").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewActivity1 Dao ends" + resp);
		return resp;

	}

//
	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewActivity2(String orgName, String orgDivision) {
		logger.info("Method : viewActivity2 Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
					.setParameter("actionType", "viewActivity2").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewActivity2 Dao ends" + resp);
		return resp;

	}

//
	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewcomplitionRoutine(String orgName, String orgDivision) {
		logger.info("Method : viewcomplitionRoutine Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
					.setParameter("actionType", "viewcomplitionRoutine").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewcomplitionRoutine Dao ends" + resp);
		return resp;

	}

//
	// add
	public ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>> activityAdd(List<DigitalLogBookRestModel> av) {
		logger.info("Method : activityAdd dao starts");
		JsonResponse<List<DigitalLogBookRestModel>> resp = new JsonResponse<List<DigitalLogBookRestModel>>();

		String value = GenerateTicketDigitalLogBookParam.getAddCompilationActivity(av);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + value);
		try {

			if (av.get(0).getCompletionId() != null && av.get(0).getCompletionId() != "") {

				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "modifyActivity").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "activityAdd").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data saved successfully");

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

		ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>> response = new ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : activityAdd dao ends");
		return response;

	}

//
	// edit
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editActivity(String id, String orgName, String orgDivision) {
		logger.info("Method : editActivity Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_completionId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("edit----------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
					.setParameter("actionType", "editActivity").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editActivity Dao ends");
		return resp;
	}

	//
	// delete
	public ResponseEntity<JsonResponse<Object>> deleteActivity(String id, String orgName, String orgDiv) {
		logger.info("Method : deleteActivity starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_completionId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("DELETE---------------------" + value);
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "deleteActivity").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
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

		logger.info("Method : deleteActivity ends");
		return response;
	}

	// approve
	public ResponseEntity<JsonResponse<Object>> approveActivity(String id, String orgName, String orgDiv) {
		logger.info("Method : approveActivity starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_completionId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("APPROVE------------------------" + value);
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "approveActivity").setParameter("actionValue", value).execute();
				resp.setMessage("Data Approved Successfully");
				resp.setCode("success");
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
		logger.info("Method : approveActivity ends");
		return response;
	}

///////////////////////////////RW and BR LOGBOOK///////////////////////////////////

	// add
	public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addRWandBRLogBook(List<AssetPoilcyRestModel> av) {
		logger.info("Method : addRWandBRLogBook dao starts");
		JsonResponse<List<AssetPoilcyRestModel>> resp = new JsonResponse<List<AssetPoilcyRestModel>>();

		String value = GenerateAssetPolicyParams.addRWandBRLogBook(av);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + value);
		try {

			if (av.get(0).getLogbookId() != null && av.get(0).getLogbookId() != "") {

				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "modifyRWandBR").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "addRWandBR").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data saved successfully");

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

		ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> response = new ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addRWandBRLogBook dao ends");
		return response;

	}

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRWandBRLogBook(String orgName, String orgDivision) {
		logger.info("Method : viewRWandBRLogBook Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
					.setParameter("actionType", "viewRWandBRLog").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewRWandBRLogBook Dao ends");
		return resp;

	}

	// delete
	public ResponseEntity<JsonResponse<Object>> deleteRWandBRLogbook(String id, String orgName, String orgDiv) {
		logger.info("Method : deleteRWandBRLogbook starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_logbookId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("DELETE---------------------" + value);
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "deleteRWandBRLog").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
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

		logger.info("Method : deleteRWandBRLogbook ends");
		return response;
	}

	// approve
	public ResponseEntity<JsonResponse<Object>> approveRWandBRLogbook(String id, String orgName, String orgDiv) {
		logger.info("Method : approveRWandBRLogbook starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_logbookId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("APPROVE------------------------" + value);
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "approveRWandBRLog").setParameter("actionValue", value).execute();
				resp.setMessage("Data Approved Successfully");
				resp.setCode("success");
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
		logger.info("Method : approveRWandBRLogbook ends");
		return response;
	}

///////////////////////////////WATER READING RECORD LOGBOOK///////////////////////////////////

// add
	public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addWRRLogBook(List<AssetPoilcyRestModel> av) {
		logger.info("Method : addWRRLogBook dao starts");
		JsonResponse<List<AssetPoilcyRestModel>> resp = new JsonResponse<List<AssetPoilcyRestModel>>();

		String value = GenerateAssetPolicyParams.addWRRLogBook(av);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + value);
		try {

			if (av.get(0).getLogbookId() != null && av.get(0).getLogbookId() != "") {

				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "modifyWRR").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("logbook_management_Routines").setParameter("actionType", "addWRR")
						.setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data saved successfully");

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

		ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> response = new ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addWRRLogBook dao ends");
		return response;

	}

// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewWRRLogBook(String orgName, String orgDivision) {
		logger.info("Method : viewWRRLogBook Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
					.setParameter("actionType", "viewWRRLog").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
			System.out.println("RESULT VIEW::::::::::" + resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewWRRLogBook Dao ends");
		return resp;

	}

// delete
	public ResponseEntity<JsonResponse<Object>> deleteWRRLogbook(String id, String orgName, String orgDiv) {
		logger.info("Method : deleteWRRLogbook starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_logbookId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("DELETE---------------------" + value);
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "deleteWRRLog").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
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

		logger.info("Method : deleteWRRLogbook ends");
		return response;
	}

// approve
	public ResponseEntity<JsonResponse<Object>> approveWRRLogbook(String id, String orgName, String orgDiv) {
		logger.info("Method : approveWRRLogbook starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_logbookId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("APPROVE------------------------" + value);
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "approveWRRLog").setParameter("actionValue", value).execute();
				resp.setMessage("Data Approved Successfully");
				resp.setCode("success");
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
		logger.info("Method : approveWRRLogbook ends");
		return response;
	}

///////////////////////////////EB LOGBOOK///////////////////////////////////

//add
	public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addEBReadingLogBook(List<AssetPoilcyRestModel> av) {
		logger.info("Method : addEBReadingLogBook dao starts");
		JsonResponse<List<AssetPoilcyRestModel>> resp = new JsonResponse<List<AssetPoilcyRestModel>>();

		String value = GenerateAssetPolicyParams.addEBReading(av);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + value);
		try {

			if (av.get(0).getLogbookId() != null && av.get(0).getLogbookId() != "") {

				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "modifyEBReading").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "addEBReading").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data saved successfully");

			}
		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				System.err.println(err[0]);
				System.err.println(err[1]);
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.DUPLICATE_DATA_FOUND);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> response = new ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addEBReadingLogBook dao ends"+response);
		return response;

	}

//view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEBReadingLogBook(String orgName, String orgDivision) {
		logger.info("Method : viewEBReadingLogBook Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
					.setParameter("actionType", "viewEBReading").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
			System.out.println("RESULT VIEW::::::::::" + resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewEBReadingLogBook Dao ends");
		return resp;

	}

//delete
	public ResponseEntity<JsonResponse<Object>> deleteEBReadingLogbook(String id, String orgName, String orgDiv) {
		logger.info("Method : deleteEBReadingLogbook starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_logbookId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("DELETE---------------------" + value);
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "deleteEBReading").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
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

		logger.info("Method : deleteEBReadingLogbook ends");
		return response;
	}

//approve
	public ResponseEntity<JsonResponse<Object>> approveEBReadingLogbook(String id, String orgName, String orgDiv) {
		logger.info("Method : approveEBReadingLogbook starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_logbookId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("APPROVE------------------------" + value);
				em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "approveEBReading").setParameter("actionValue", value).execute();
				resp.setMessage("Data Approved Successfully");
				resp.setCode("success");
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
		logger.info("Method : approveEBReadingLogbook ends");
		return response;
	}
//
	// view
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewIlluminationData(String orgName, String orgDivision) {
			logger.info("Method : viewIlluminationData Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "viewIlluminationData").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewIlluminationData Dao ends" + resp);
			return resp;

		}
//
		// add
		public ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>> illuminationAdd(List<DigitalLogBookRestModel> av) {
			logger.info("Method : illuminationAdd dao starts");
			JsonResponse<List<DigitalLogBookRestModel>> resp = new JsonResponse<List<DigitalLogBookRestModel>>();

			String value = GenerateTicketDigitalLogBookParam.getAddIllumination(av);
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + value);
			try {

				if (av.get(0).getIlluminationId() != null && av.get(0).getIlluminationId() != "") {

					em.createNamedStoredProcedureQuery("logbook_management_Routines")
							.setParameter("actionType", "modifyIllumination").setParameter("actionValue", value).execute();

					resp.setCode("success");
					resp.setMessage("Data Modified successfully");

				} else {
					em.createNamedStoredProcedureQuery("logbook_management_Routines")
							.setParameter("actionType", "illuminationAdd").setParameter("actionValue", value).execute();

					resp.setCode("success");
					resp.setMessage("Data saved successfully");

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

			ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>> response = new ResponseEntity<JsonResponse<List<DigitalLogBookRestModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : illuminationAdd dao ends");
			return response;

		}
		// view
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewIllumination(String orgName, String orgDivision) {
			logger.info("Method : viewIllumination Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "viewIllumination").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewIllumination Dao ends" + resp);
			return resp;

		}
		
		// edit
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> editIllumination(String id, String orgName, String orgDivision) {
			logger.info("Method : editIllumination Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_illuminationId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("edit----------------" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("logbook_management_Routines")
						.setParameter("actionType", "editIllumination").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : editIllumination Dao ends");
			return resp;
		}
		
		// delete
		public ResponseEntity<JsonResponse<Object>> deleteIllumination(String id, String orgName, String orgDiv) {
			logger.info("Method : deleteIllumination starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {
					String value = "SET @p_illuminationId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
					System.out.println("DELETE---------------------" + value);
					em.createNamedStoredProcedureQuery("logbook_management_Routines")
							.setParameter("actionType", "deleteIllumination").setParameter("actionValue", value).execute();
					resp.setCode("success");
					resp.setMessage("Data Deleted successfully");
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

			logger.info("Method : deleteIllumination ends");
			return response;
		}

		// approve
		public ResponseEntity<JsonResponse<Object>> approveIllumination(String id, String orgName, String orgDiv) {
			logger.info("Method : approveIllumination starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {

					String value = "SET @p_illuminationId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
					System.out.println("APPROVE------------------------" + value);
					em.createNamedStoredProcedureQuery("logbook_management_Routines")
							.setParameter("actionType", "approveIllumination").setParameter("actionValue", value).execute();
					resp.setMessage("Data Approved Successfully");
					resp.setCode("success");
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
			logger.info("Method : approveIllumination ends");
			return response;
		}
}