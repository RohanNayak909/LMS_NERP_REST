package nirmalya.aatithya.restmodule.meeting.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.internal.build.AllowSysOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class MeetingDao {
	Logger logger = LoggerFactory.getLogger(MeetingDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEmployeeLists(String orgName, String orgDivision, String managerId, String userId) {
		logger.info("Method : getEmployeeLists starts");

		List<DropDownModel> emplist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org=\"" + orgName + "\",@p_orgDiv=\"" + orgDivision + "\"" + ",@p_managerId='"
					+ managerId + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", "getEmployeeList").setParameter("actionValue", value)
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

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addMeetingInCalendar(Map<String, Object> meetingJsonData) {
		logger.info("Method : addMeetingInCalendar starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			String jsonData = objectMapper.writeValueAsString(meetingJsonData);
			jsonData = jsonData.replace("'", "\\'");
			String meetingId = (String) meetingJsonData.get("meetingId");
			String meetingType = (String) meetingJsonData.get("type");
			String fromDate = (String) meetingJsonData.get("fromDate");
			String toDate = (String) meetingJsonData.get("toDate");
			String daysFilter = (String) meetingJsonData.get("daysFilter");
			String monthlyDates = (String) meetingJsonData.get("monthlyDates");
			String frequency = (String) meetingJsonData.get("frequency");
			List<Map<String, Object>> dataList = (List<Map<String, Object>>) meetingJsonData.get("allmeetings");

			String allmeetingJson = objectMapper.writeValueAsString(dataList);

			List<Map<String, String>> sectionDiscussPoint = (List<Map<String, String>>) meetingJsonData
					.get("sectionDiscussPoint");

			String sectionDiscussPointJson = objectMapper.writeValueAsString(sectionDiscussPoint);
			String actionType;
			String value;

			if ("meetingDetailsSection".equals(meetingType)) {
				String meetingNote = (String) meetingJsonData.get("meetingNote");
				meetingNote = meetingNote.replace("'", "\\'");
				actionType = "modifyDetailsSection";
				value = "SET @p_meetingNote='" + meetingNote + "',@p_meetingId='" + meetingId + "',@p_discussPoint='"
						+ sectionDiscussPointJson + "';";
			} else {
				actionType = (meetingId == null || meetingId.isEmpty()) ? "addMeeting" : "modifyMeeting";
				
				value = "SET @meetingJsonData='" + jsonData + "',@p_allmeetingJson='" + allmeetingJson + "',"
						+ "@fromDate='" + fromDate + "',@toDate='" + toDate + "',@daysFilter='" + daysFilter + "',"
								+ "@monthlyDates='" + monthlyDates + "',@frequency='" + frequency + "';";
			}
			
			logger.info("value"+value);
			
			Object result = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", actionType).setParameter("actionValue", value).execute();

			resp.setBody(result.toString());
			resp.setCode("success");
			resp.setMessage(
					actionType.equals("addMeeting") ? "Meeting added successfully." : "Meeting updated successfully.");
			logger.info(actionType.equals("addMeeting") ? "Adding new meeting."
					: "Updating meeting for meetingId: " + meetingId);

		} catch (Exception e) {
			resp.setCode("Failed");
			resp.setMessage("Error during Add Meeting operation.");
			logger.error("Error in addMeetingInCalendar: ", e);
		}

		logger.info("Method : addMeetingInCalendar ends");
		return resp;
	}

	// VIEW MEETING
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewMeetingCalendar(String orgName, String orgDiv, String userId,
			String meetingStatus) {
		logger.info("Method : viewMeetingCalendar Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId
					+ "',@p_meetingStatus='" + meetingStatus + "';";
			System.out.println("viewMeetingCalendar========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", "viewMeetingCalendar").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewMeetingCalendar Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllMeeting(String orgName, String orgDiv, String userId) {
		logger.info("Method : getAllMeeting Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId+ "';";
			System.out.println("getAllMeeting========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", "getAllMeeting").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllMeeting Dao ends" + resp);
		return resp;

	}

	// EDIT MEETING
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editMeetingCalendar(String orgName, String orgDiv, String userId, String meetingId) {
		logger.info("Method : editMeetingCalendar Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId
					+ "',@p_meetingId='" + meetingId + "';";
			System.out.println("editMeetingCalendar========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", "editMeetingCalendar").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : editMeetingCalendar Dao ends" + resp);
		return resp;

	}

	// DELETE MEETING
	public JsonResponse<Object> deleteMeetingCalendar(String meetingId, String orgName, String orgDiv) {
		logger.info("Method : deleteMeetingCalendar Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_meetingId='" + meetingId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv
					+ "';";
			System.out.println("deleteMeetingCalendar========>" + value);

			Object x = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", "deleteMeetingCalendar").setParameter("actionValue", value)
					.getSingleResult();
			System.out.println("value of x ------->>>>> " + x.toString());
			if (Integer.parseInt(x.toString()) > 0) {
				resp.setCode("success");
				resp.setMessage("Meeting Deleted successfully");
			}

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : deleteMeetingCalendar Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getvitalMeeting(String orgName, String orgDiv, String userId, String currentDate,
			String currentTime) {
		logger.info("Method : getvitalMeeting Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId
					+ "',@p_currenDate='" + currentDate + "',@p_currentTime='" + currentTime + "';";
			System.out.println("getvitalMeeting========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", "getvitalMeeting").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getvitalMeeting Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> issueRaisedEmployeeList(String meetingId, String orgName, String orgDiv) {
		logger.info("Method : issueRaisedEmployeeList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_meetingId='" + meetingId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv
					+ "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", "issue-raised-emp").setParameter("actionValue", value).getResultList();
			System.out.println(x);
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : issueRaisedEmployeeList Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveMomDetails(Map<String, Object> momJsonData) {
	    logger.info("Method : saveMomDetails starts");

	    JsonResponse<Object> resp = new JsonResponse<>();
	    
	    System.out.println(momJsonData);

	    try {
	        String orgName = (String) momJsonData.get("orgName");
	        String orgDiv = (String) momJsonData.get("orgDiv");
	        String createdById = (String) momJsonData.get("createdById");
	        List<Map<String, Object>> momDataList = (List<Map<String, Object>>) momJsonData.get("momData");
   
	        List<Map<String, Object>> saveList = new ArrayList<>();
	        List<Map<String, Object>> updateList = new ArrayList<>();

	        for (Map<String, Object> item : momDataList) {
	        	 if (item.containsKey("issue")) {
        	        item.put("issue", item.get("issue").toString().replace("'", "").replace("\"", ""));
        	    }
        	    if (item.containsKey("momTopic")) {
        	        item.put("momTopic", item.get("momTopic").toString().replace("'", "").replace("\"", ""));
        	    }
        	    if (item.containsKey("curAction")) {
        	        item.put("curAction", item.get("curAction").toString().replace("'", "").replace("\"", ""));
        	    }
	            String pendingIssueId = (String) item.get("pendingIssueId");
	            if (pendingIssueId == null || pendingIssueId.isEmpty()) {
	                saveList.add(item);
	            } else {
	                updateList.add(item);
	            }
	        }

	        ObjectMapper objectMapper = new ObjectMapper();

	        if (!saveList.isEmpty()) {
	            String saveMomDataJson = objectMapper.writeValueAsString(saveList);
	            System.out.println(saveMomDataJson);


	            String saveValue = "SET @momDataJson='" + saveMomDataJson + "'," 
	                    + "@orgName='" + orgName + "'," 
	                    + "@orgDiv='" + orgDiv + "'," 
	                    + "@userId='" + createdById + "';";

	            em.createNamedStoredProcedureQuery("meeting_calendar_routines")
	              .setParameter("actionType", "saveMomDetails")
	              .setParameter("actionValue", saveValue)
	              .execute();
	            
	        }

	        // Handle updateMom
	        if (!updateList.isEmpty()) {
	        	
	        	for (Map<String, Object> updateItem : updateList) {
	        	    StringBuilder updateValueBuilder = new StringBuilder("SET ");
	        	    
	        	    for (Map.Entry<String, Object> entry : updateItem.entrySet()) {
	        	        String key = entry.getKey();
	        	        Object value = entry.getValue();
	        	        
	        	        updateValueBuilder.append("@").append(key).append("='")
	        	                          .append(value == null ? "" : value.toString().replace("'", "\\'"))
	        	                          .append("',");
	        	    }
	        	    
	        	    updateValueBuilder.append("@orgName='").append(orgName.replace("'", "\\'")).append("',")
	        	                      .append("@orgDiv='").append(orgDiv.replace("'", "\\'")).append("',")
	        	                      .append("@userId='").append(createdById.replace("'", "\\'")).append("';");
	        	    
	        	    String updateValue = updateValueBuilder.toString();

	        	    em.createNamedStoredProcedureQuery("meeting_calendar_routines")
	        	      .setParameter("actionType", "updateMom")
	        	      .setParameter("actionValue", updateValue)
	        	      .execute();
	        	}

	        }

	        resp.setCode("success");
	        resp.setMessage("Mom Saved Successfully!");

	    } catch (Exception e) {
	        resp.setCode("Failed");
	        resp.setMessage("Error during Save/Update Mom operation.");
	        logger.error("Error in saveMomDetails: ", e);
	    }

	    logger.info("Method : saveMomDetails ends");
	    return resp;
	}


	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getMomsList(String meetingId, String orgName, String orgDiv, String userId, String fromDate, String toDate) {
		logger.info("Method : getMomsList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_meetingId='" + meetingId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv
					+ "',@p_userId='" + userId + "',@fromDate='" + fromDate + "',@toDate='" + toDate + "';";
            System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", "get-moms-list").setParameter("actionValue", value).getResultList();
			System.out.println(x);
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getMomsList Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getMomsDetails(String meetingId, String momDate, String orgName, String orgDiv,
			String userId) {
		logger.info("Method : getMomsDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_meetingId='" + meetingId + "',@p_momDate='" + momDate + "',@p_orgName='" + orgName
					+ "',@p_orgDivision='" + orgDiv + "',@p_userId='" + userId + "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", "get-moms-details").setParameter("actionValue", value).getResultList();
			System.out.println(x);
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getMomsDetails Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getOpenIssues(String meetingId, String orgName, String orgDiv, String userId) {
		logger.info("Method : getOpenIssues Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_meetingId='" + meetingId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv
					+ "',@p_userId='" + userId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", "get-pending-issues").setParameter("actionValue", value)
					.getResultList();
			System.out.println(x);
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getOpenIssues Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllMeetingsForCalenders(String startDate, String endtDate, String orgName,
			String orgDiv, String userId) {
		logger.info("Method : getAllMeetingsForCalenders Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_startDate='" + startDate + "',@p_endtDate='" + endtDate + "',@p_orgName='" + orgName
					+ "',@p_orgDivision='" + orgDiv + "',@p_userId='" + userId + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", "get-calenders-meetings").setParameter("actionValue", value)
					.getResultList();
			System.out.println(x);
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllMeetingsForCalenders Dao ends" + resp);
		return resp;
	}

	public JsonResponse<Object> reoveOpenIssues(String issueId, String orgName, String orgDiv, String userId) {
		logger.info("Method : reoveOpenIssues Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_issueId='" + issueId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv
					+ "',@p_userId='" + userId + "';";
			System.out.println(value);
			Object x = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", "remove-pending-issue").setParameter("actionValue", value)
					.getSingleResult();
			if (Integer.parseInt(x.toString()) > 0) {
				resp.setCode("success");
				resp.setMessage("Issue Removed From The Lists");
			}

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : reoveOpenIssues Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getCalendarMeetingDetails(String id, String orgName, String orgDiv, String userId) {
		logger.info("Method : getCalendarMeetingDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_id='" + id + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv
					+ "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", "calendar-each-meeting-details").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getCalendarMeetingDetails Dao ends" + resp);
		return resp;
	}
	
	public JsonResponse<Object> saveMeetingChanges(Map<String, Object> meetingJsonData) {
		logger.info("Method : saveMeetingChanges starts");
		
		System.out.println(meetingJsonData);

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String id = (String) meetingJsonData.get("id");
			String remark = (String) meetingJsonData.get("remark");
			String date = (String) meetingJsonData.get("date");
			String start = (String) meetingJsonData.get("start");
			String end = (String) meetingJsonData.get("end");
			String type = (String) meetingJsonData.get("type");
			String discussPoints = (String) meetingJsonData.get("discussPoints");
			String discussPointsType = (String) meetingJsonData.get("discussPointsType");
			String frequency = (String) meetingJsonData.get("frequency");
			String meetingId = (String) meetingJsonData.get("meetingId");
			String currentDate = (String) meetingJsonData.get("currentDate");
 
			if(discussPointsType.equals("true")) {
				String value = "SET @id='" + id + "',@discussPoints='" + discussPoints + "';";
				
				 em.createNamedStoredProcedureQuery("meeting_calendar_routines")
						.setParameter("actionType", "saveDiscussionPointChanges").setParameter("actionValue", value).execute();
			} 
			
			String value = "SET @id='" + id + "',@remark='" + remark + "',@date='" + date
					+ "',@start='" + start + "',@end='" + end + "',@type='" + type + "',@frequency='"+frequency+"',@meetingId='"+meetingId+"';";

			
			Object result = em.createNamedStoredProcedureQuery("meeting_calendar_routines")
					.setParameter("actionType", "saveMeetingChanges").setParameter("actionValue", value).execute();

			resp.setBody(result.toString());
			resp.setCode("success");
			resp.setMessage("Meeting "+type+" Successfully!");
			

		} catch (Exception e) {
			resp.setCode("Failed");
			resp.setMessage("Error during save Meeting.");
			logger.error("Error in addMeetingInCalendar: ", e);
		}

		logger.info("Method : addMeetingInCalendar ends");
		return resp;
	}
}
