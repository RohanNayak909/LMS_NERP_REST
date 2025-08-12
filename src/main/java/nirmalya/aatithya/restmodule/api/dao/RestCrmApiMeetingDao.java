package nirmalya.aatithya.restmodule.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.model.RestCrmApiMeetingModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCrmVisitApiParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class RestCrmApiMeetingDao {
	Logger logger = LoggerFactory.getLogger(RestCrmApiMeetingDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getLeadContactList() {
		// TODO Auto-generated method stub
		logger.info("Method : getLeadContactList starts");
		List<DropDownModel> list = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_MeetingApi_Details")
					.setParameter("actionType", "getLeadContactList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1].toString());
				list.add(dropDownModel);

				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getLeadContactList end");
		return list;

	}

	/**
	 * DAO Function to Add
	 *
	 */
	public ResponseEntity<JsonResponse<Object>> addCrmMeetingMaster(RestCrmApiMeetingModel restMeeting) {
		logger.info("Method : Rest addCrmMeetingMaster  Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {

				String values = GenerateCrmVisitApiParam.getMeetingMasterParam(restMeeting);
				logger.info("VALUES" + values);
				logger.info("IDDDD" + restMeeting.getMeetingId());
				if (restMeeting.getMeetingId() == null || restMeeting.getMeetingId() == "") {

					em.createNamedStoredProcedureQuery("crm_MeetingApi_Details")
							.setParameter("actionType", "addCrmMeetingMaster").setParameter("actionValue", values)
							.execute();

				} else {

					em.createNamedStoredProcedureQuery("crm_MeetingApi_Details")
							.setParameter("actionType", "modifyCrmMeetingMaster").setParameter("actionValue", values)
							.execute();
				}
				resp.setCode("Success");
				resp.setMessage("Data Saved Successfully");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("Failed");
				resp.setMessage(e.getLocalizedMessage());

			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Rest addCrmMeetingMaster  Dao ends");

		logger.info("ADDDDDDDDDDD" + response);

		return response;
	}

	// View

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmApiMeetingModel>> viewCrmMeetingMaster(String createdBy, String organization,
			String orgDivision) {
		logger.info("Method : viewCrmMeetingMaster Dao starts");

		List<RestCrmApiMeetingModel> viewMaster = new ArrayList<RestCrmApiMeetingModel>();
		JsonResponse<List<RestCrmApiMeetingModel>> resp = new JsonResponse<List<RestCrmApiMeetingModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='"
					+ orgDivision + "';";
			System.out.println("VALUE FOR MEETING VIEW----->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_MeetingApi_Details")
					.setParameter("actionType", "viewCrmMeetingMaster").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestCrmApiMeetingModel restStudentModel = new RestCrmApiMeetingModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], null, null,
						null, null, m[18], m[19].toString());
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}

			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmMeetingMaster Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// check in

	public ResponseEntity<JsonResponse<Object>> checkInCrmMeetingMaster(RestCrmApiMeetingModel restMeeting) {
		logger.info("Method : Rest checkInCrmMeetingMaster  Dao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {

				String values = GenerateCrmVisitApiParam.getMeetingMasterCheckinParam(restMeeting);
				logger.info("VALUES" + values);
				logger.info("IDDDD" + restMeeting.getMeetingId());
				if (restMeeting.getMeetingId() != null || restMeeting.getMeetingId() != "") {
					em.createNamedStoredProcedureQuery("crm_MeetingApi_Details")
							.setParameter("actionType", "checkInCrmMeetingMaster").setParameter("actionValue", values)
							.execute();

				}
				resp.setCode("Success");
				resp.setMessage("Data Saved Successfully");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("Failed");
				resp.setMessage(e.getLocalizedMessage());
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Rest checkInCrmMeetingMaster  Dao ends");

		logger.info("ADDDDDDDDDDD" + response);

		return response;
	}

	// View check in history
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmApiMeetingModel>> viewCrmMeetingvisitHistory(String createdBy, String organization,
			String orgDivision) {
		logger.info("Method : viewCrmMeetingvisitHistory Dao starts");

		List<RestCrmApiMeetingModel> viewMaster = new ArrayList<RestCrmApiMeetingModel>();
		JsonResponse<List<RestCrmApiMeetingModel>> resp = new JsonResponse<List<RestCrmApiMeetingModel>>();
		try {
			String value = "SET @p_createdBy='" + createdBy + "',@p_org='" + organization + "',@p_orgDiv='"
					+ orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_MeetingApi_Details")
					.setParameter("actionType", "viewCrmMeetingvisitHistory").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object date = null;
				if (m[18] != null) {
					date = DateFormatter.returnStringDate(m[18]);
				}
				RestCrmApiMeetingModel restStudentModel = new RestCrmApiMeetingModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], date, m[19],
						m[20], m[21], null, null);
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmMeetingvisitHistory Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// View check in history Report
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmApiMeetingModel>> viewCrmMeetingvisitHistoryReport(String userId,
			String organization, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : viewCrmMeetingvisitHistoryReport Dao starts");

		List<RestCrmApiMeetingModel> viewMaster = new ArrayList<RestCrmApiMeetingModel>();
		JsonResponse<List<RestCrmApiMeetingModel>> resp = new JsonResponse<List<RestCrmApiMeetingModel>>();
		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='"
					+ DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate)
					+ "',@p_user='" + userId + "';";
			logger.info("value111===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_MeetingApi_Details")
					.setParameter("actionType", "viewCrmMeetingvisitHistoryReport").setParameter("actionValue", value)
					.getResultList();
			logger.info("Result list size: {}", x.size());
			for (Object[] row : x) {
				System.out.println("Row:");
				for (int i = 0; i < row.length; i++) {
					System.out.println("  Column " + i + ": " + row[i]);
				}
			}

			for (Object[] m : x) {
				Object date = null;
				if (m[18] != null) {
					date = DateFormatter.returnStringDate(m[18]);
				}
				RestCrmApiMeetingModel restStudentModel = new RestCrmApiMeetingModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], date, m[19],
						m[20], m[21], null, null);
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			logger.error("Error in viewCrmMeetingvisitHistoryReport", e);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmMeetingvisitHistoryReport Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// View check in history Report search
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestCrmApiMeetingModel>> viewCrmMeetingvisitHistoryReportSearch(String userId,
			String organization, String orgDivision, String fromDate, String toDate, String customer, String saleTeam) {
		logger.info("Method : viewCrmMeetingvisitHistoryReportSearch Dao starts");

		List<RestCrmApiMeetingModel> viewMaster = new ArrayList<RestCrmApiMeetingModel>();
		JsonResponse<List<RestCrmApiMeetingModel>> resp = new JsonResponse<List<RestCrmApiMeetingModel>>();
		try {
			String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='"
					+ DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate)
					+ "'," + "@p_user='" + userId + "',@p_customer='" + customer + "',@p_saleTeam='" + saleTeam + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("crm_MeetingApi_Details")
					.setParameter("actionType", "viewCrmMeetingvisitHistoryReportSearch")
					.setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				Object date = null;
				if (m[18] != null) {
					date = DateFormatter.returnStringDate(m[18]);
				}
				RestCrmApiMeetingModel restStudentModel = new RestCrmApiMeetingModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], date, m[19],
						m[20], m[21], null, null);
				viewMaster.add(restStudentModel);

				if (restStudentModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}
			if (viewMaster.isEmpty()) {
				resp.setCode("success");
				resp.setMessage("Data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(viewMaster);
		logger.info("Method : viewCrmMeetingvisitHistoryReportSearch Dao ends");
		logger.info("VIEWWWWW" + resp);
		return resp;
	}

	// delete meeting
	public ResponseEntity<JsonResponse<Object>> deleteCrmMeetingMaster(String meetingid, String organization,
			String orgDivision) {
		logger.info("Method : deleteCrmMeetingMaster starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_meetingid='" + meetingid + "',@p_org='" + organization + "',@p_orgDiv='"
					+ orgDivision + "';";
			logger.info("value====" + value);
			em.createNamedStoredProcedureQuery("crm_MeetingApi_Details")
					.setParameter("actionType", "deleteCrmMeetingMaster").setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
		} catch

		(Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteCrmMeetingMaster ends");
		return response;
	}
}
