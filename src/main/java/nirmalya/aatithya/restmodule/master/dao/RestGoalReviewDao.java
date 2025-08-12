package nirmalya.aatithya.restmodule.master.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateMasterGoalReview;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestGoalReviewModel;

@Repository
public class RestGoalReviewDao {
	Logger logger = LoggerFactory.getLogger(RestGoalReviewDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getempLists(String id) {
			logger.info("Method : getempListsMeetingDao starts");

			List<DropDownModel> dept = new ArrayList<DropDownModel>();
			String value = "SET @p_userId='" + id + "';";
			logger.info(value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowReview")
						.setParameter("actionType", "getEmployeeList").setParameter("actionValue",value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					dept.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("dept=="+dept);
			logger.info("Method : getempListsMeetingDao ends");
			return dept;
		}
		
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> viewEmployeeListDao(String userId) {
		logger.info("Method : viewSelfAppraisalData starts");

		List<RestGoalReviewModel> employeeList = new ArrayList<RestGoalReviewModel>();
		String value = "SET @p_userId='" + userId + "';";
		logger.info(value);
		try {
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowReview")
					.setParameter("actionType", "viewEmployeeList").setParameter("actionValue", value).getResultList();
		
			for (Object[] m : x) {
				Object DOB = null;
				if (m[3] != null) {
					DOB = DateFormatter.returnStringDate(m[3]);
				}
				RestGoalReviewModel dropDownModel = new RestGoalReviewModel(m[0], m[1], m[2], DOB,m[4], m[5],m[6]);
				employeeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestGoalReviewModel>> resp = new JsonResponse<List<RestGoalReviewModel>>();
		resp.setBody(employeeList);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> response = new ResponseEntity<JsonResponse<List<RestGoalReviewModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewSelfAppraisalData ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> viewEmployeeBandListDao(String id) {
		logger.info("Method : viewEmployeeBandListDao starts");

		List<RestGoalReviewModel> jobList = new ArrayList<RestGoalReviewModel>();
		
		String value = "SET @p_empid='" + id + "';";
		
		try {
			//logger.info("11111111111111"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowReview")
					.setParameter("actionType", "viewEmoloyeeDetails").setParameter("actionValue", value).getResultList();
		
			for (Object[] m : x) {				
				RestGoalReviewModel dropDownModel = new RestGoalReviewModel(m[0],m[1]);
				jobList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestGoalReviewModel>> resp = new JsonResponse<List<RestGoalReviewModel>>();
		resp.setBody(jobList);
		//logger.info("11111111111111"+resp);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> response = new ResponseEntity<JsonResponse<List<RestGoalReviewModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewEmployeeBandListDao ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> viewGoalListDao(String id) {
		logger.info("Method : viewEmployeeBandListDao starts");

		List<RestGoalReviewModel> jobList = new ArrayList<RestGoalReviewModel>();
		
		String value = "SET @p_empid='" + id + "';";
		
		try {
			//logger.info("11111111111111"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowReview")
					.setParameter("actionType", "viewAssignedGoalList").setParameter("actionValue", value).getResultList();
		
			for (Object[] m : x) {				
				RestGoalReviewModel dropDownModel = new RestGoalReviewModel(m[0],m[1],m[2],m[3],m[4],m[5].toString(),null,null);
				jobList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestGoalReviewModel>> resp = new JsonResponse<List<RestGoalReviewModel>>();
		resp.setBody(jobList);
		//logger.info("11111111111111"+resp);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> response = new ResponseEntity<JsonResponse<List<RestGoalReviewModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewEmployeeBandListDao ends");
		return response;
	}
	public ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> saveGoalReviewDao(RestGoalReviewModel restGoalReview) {
		logger.info("Method : saveGoalReviewDao dao starts");
		logger.info("Method : addGoalReview Dao starts");
		
		JsonResponse<List<RestGoalReviewModel>> resp = new JsonResponse<List<RestGoalReviewModel>>();
		List<RestGoalReviewModel> listData = new ArrayList<RestGoalReviewModel>();
		
			try {
				String values = GenerateMasterGoalReview.saveGoalReview(restGoalReview);

				
					logger.info("%%%%%%%%%%%%"+values);
					em.createNamedStoredProcedureQuery("hrmsGrowReview").setParameter("actionType", "saveGoalReview")
							.setParameter("actionValue", values).execute();
				
					
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
			resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> response = new ResponseEntity<JsonResponse<List<RestGoalReviewModel>>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addGoalReview Dao ends");

		return response;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> viewReviewListDao(String id) {
		logger.info("Method : viewEmployeeBandListDao starts");

		List<RestGoalReviewModel> jobList = new ArrayList<RestGoalReviewModel>();
		
		String value = "SET @p_empid='" + id + "';";
		
		try {
			//logger.info("11111111111111"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowReview")
					.setParameter("actionType", "viewReviewList").setParameter("actionValue", value).getResultList();
		
			for (Object[] m : x) {				
				RestGoalReviewModel dropDownModel = new RestGoalReviewModel(m[0],m[1],m[2],m[3],m[4],m[5]);
				jobList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestGoalReviewModel>> resp = new JsonResponse<List<RestGoalReviewModel>>();
		resp.setBody(jobList);
		//logger.info("11111111111111"+resp);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> response = new ResponseEntity<JsonResponse<List<RestGoalReviewModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewEmployeeBandListDao ends");
		return response;
	}
	public JsonResponse<RestGoalReviewModel> deleteReview(String id) {
		logger.info("Method : deleteReview starts");

		RestGoalReviewModel req = new RestGoalReviewModel();
		JsonResponse<RestGoalReviewModel> resp = new JsonResponse<RestGoalReviewModel>();

		try {
			String value = "SET @p_reviewId='" + id + "';";
			
			logger.info(value);
			em.createNamedStoredProcedureQuery("hrmsGrowReview").setParameter("actionType", "deleteReview")
					.setParameter("actionValue", value).execute();

			resp.setBody(req);
		} catch (Exception e) {
			logger.error("deleteReview: "+e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : deleteReview ends");
		return resp;
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> saveMeetingDetailsDao(
			List<RestGoalReviewModel> goalReviewModel) {
		logger.info("Method : addMeetingSceduleDao starts");
	
		logger.info("goalReviewModel==="+goalReviewModel);
		
		RestGoalReviewModel req = new RestGoalReviewModel();
		JsonResponse<List<RestGoalReviewModel>> resp = new JsonResponse<List<RestGoalReviewModel>>();

		List<RestGoalReviewModel> listData = new ArrayList<RestGoalReviewModel>();
		resp.setMessage("");
		resp.setCode("");
		
			try {
				String value = GenerateMasterGoalReview.getMeetingScheduleParam(goalReviewModel);
				
					List<Object[]> x =em.createNamedStoredProcedureQuery("hrmsGrowReview")
							.setParameter("actionType", "addMeetingScedule").setParameter("actionValue", value)
							.getResultList();

					for (Object[] m : x) {
						Object meetingDate = null;
						if (m[1] != null) {
							meetingDate = m[1].toString();

						}
						Object startTime = null;
						if (m[2] != null) {
							startTime = m[2].toString();
						}
						Object endTime = null;
						if (m[3] != null) {
							endTime = m[3].toString();

						}

						RestGoalReviewModel reqnotice = new RestGoalReviewModel(m[0],meetingDate, startTime,
								endTime,m[4], m[5], m[6], null,null);
						listData.add(reqnotice);
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
	

		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> response = new ResponseEntity<JsonResponse<List<RestGoalReviewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addMeetingSceduleDao ends");
		return response;

	}


	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> viewMeetingDetailsDao() {
		List<RestGoalReviewModel> employeeList = new ArrayList<RestGoalReviewModel>();
	
		try {
	
			List<Object[]> x = em.createNamedStoredProcedureQuery("hrmsGrowReview")
					.setParameter("actionType", "viewMeetingDetails").setParameter("actionValue", "").getResultList();
		
			for (Object[] m : x) {	
			
					Object meetingDate = null;
					if (m[0] != null) {
						meetingDate = m[0].toString();

					}
					Object startTime = null;
					if (m[1] != null) {
						startTime = m[1].toString();
					}
					Object endTime = null;
					if (m[2] != null) {
						endTime = m[2].toString();

					}
				RestGoalReviewModel dropDownModel = new RestGoalReviewModel(meetingDate, startTime, endTime, m[3],m[4]);
				employeeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<RestGoalReviewModel>> resp = new JsonResponse<List<RestGoalReviewModel>>();
		resp.setBody(employeeList);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<RestGoalReviewModel>>> response = new ResponseEntity<JsonResponse<List<RestGoalReviewModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewSelfAppraisalData ends");
		return response;
	}
	
}
	

