package nirmalya.aatithya.restmodule.recruitment.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateHireActionParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.recruitment.model.ActionEmployeeDetailsModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateDetailsModel;
import nirmalya.aatithya.restmodule.recruitment.model.HireActionModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Repository
public class HireActionDao {

	Logger logger = LoggerFactory.getLogger(HireActionDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/* Function for get Employee lists */
	@SuppressWarnings("unchecked")
	public List<ActionEmployeeDetailsModel> EmployeeFullList(String org,String orgDiv) {
		logger.info("Method : jobTypeList Dao starts");

		List<ActionEmployeeDetailsModel> jobList = new ArrayList<ActionEmployeeDetailsModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv +"';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
					.setParameter("actionType", "employeeDetails").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				ActionEmployeeDetailsModel dropDownModel = new ActionEmployeeDetailsModel(m[0], m[1], m[2]);
				jobList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : jobTypeList Dao ends");

		return jobList;
	}

	/* Function for get Candidate From Requisition */
	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<CandidateDetailsModel>>>
	 * getCandidateFromRequisition(String id) {
	 * 
	 * logger.info("Method : getCandidateFromRequisition starts"); String values =
	 * "SET @p_reqId=\"" + id + "\";"; List<CandidateDetailsModel> countryList = new
	 * ArrayList<CandidateDetailsModel>();
	 * 
	 * 
	 * try {
	 * 
	 * List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
	 * .setParameter("actionType", "viewCandidates").setParameter("actionValue",
	 * values).getResultList();
	 * 
	 * for (Object[] m : x) {
	 * 
	 * String sDate = null; if (m[4] != null) { sDate = m[4].toString(); }
	 * 
	 * String date = null; if (m[2] != null) { date = m[2].toString(); }
	 * 
	 * CandidateDetailsModel dropDownModel = new CandidateDetailsModel(m[0], m[1],
	 * null, null, date, null, null, null, null, null, null, m[3], null, null,
	 * sDate, m[5], null, m[6], m[7], m[8].toString(), m[9], m[10], m[11]);
	 * countryList.add(dropDownModel); } } catch (Exception e) {
	 * e.printStackTrace(); } JsonResponse<List<CandidateDetailsModel>> resp = new
	 * JsonResponse<List<CandidateDetailsModel>>(); resp.setBody(countryList);
	 * 
	 * HttpHeaders responseHeaders = new HttpHeaders();
	 * responseHeaders.set("MyResponseHeader", "MyValue");
	 * ResponseEntity<JsonResponse<List<CandidateDetailsModel>>> response = new
	 * ResponseEntity<JsonResponse<List<CandidateDetailsModel>>>( resp,
	 * responseHeaders, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : getCandidateFromRequisition ends"); return response;
	 * 
	 * }
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CandidateDetailsModel>>> getCandidateFromRequisition(String id) {

		logger.info("Method : getCandidateFromRequisition starts");

		List<CandidateDetailsModel> countryList = new ArrayList<CandidateDetailsModel>();
		String values = "SET @p_reqId=\"" + id + "\";";
	//	System.err.println("reqID===="+values);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
					.setParameter("actionType", "viewCandidates").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				String sDate = null;
				if (m[4] != null) {
					sDate = m[4].toString();
				}

				String date = null;
				if (m[2] != null) {
					date = m[2].toString();
				}
				String jdate = null;
				if (m[12] != null) {
					jdate = m[12].toString();
				}
				String exp = null;
				if (m[14] != null) {
					exp = m[14].toString();
				}else {
					exp ="0";
				}
				CandidateDetailsModel dropDownModel = new CandidateDetailsModel(m[0], m[1], null, null, date, null,
						null, null, null, null, null,
						m[3], 
						null, null,
						sDate, m[5], 
						null, 
						m[6], m[7], m[8].toString(),
						m[9], m[10], m[11],jdate,m[13],exp,m[15],m[16],null,null,null
						/*m[17],
						m[18],m[19]*/);
				countryList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<CandidateDetailsModel>> resp = new JsonResponse<List<CandidateDetailsModel>>();
		resp.setBody(countryList);

//		System.err.println("list candidate ======= "+countryList);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<CandidateDetailsModel>>> response = new ResponseEntity<JsonResponse<List<CandidateDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : getCandidateFromRequisition ends");
		return response;

	}

	/* Function for schedule Interview */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> scheduleInterview(HireActionModel action) {

		logger.info("Method : scheduleInterview starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String values = GenerateHireActionParameter.scheduleInterview(action);
		List<DropDownModel> candId = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
					.setParameter("actionType", "checkSchedule").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				DropDownModel d = new DropDownModel(m[0], m[1]);
				candId.add(d);
			}
			if (candId.size() > 0) {
				resp.setMessage("Unsuccess");
				resp.setBody(candId);
			} else {
				em.createNamedStoredProcedureQuery("hireActionRoutines").setParameter("actionType", "viewSchedule")
						.setParameter("actionValue", values).execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : scheduleInterview ends");
		return response;

	}

	/* Function for get Schedule Details */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HireActionModel>>> getScheduleDetails(String id) {

		logger.info("Method : getScheduleDetails starts");

		List<HireActionModel> list = new ArrayList<HireActionModel>();
		String values = "SET @p_reqId='" + id + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
					.setParameter("actionType", "getScheduleDetails").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				String sDate = null;
				if (m[3] != null) {
					sDate = m[3].toString();
				}

				String date = null;
				if (m[2] != null) {
					date = m[2].toString();
				}

				HireActionModel dropDownModel = new HireActionModel(m[0], m[1], date, sDate, m[4], m[5], m[6], m[7],
						m[8], m[9], m[10], null, null, null, m[11], m[12], m[13], m[14]);
				list.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HireActionModel>> resp = new JsonResponse<List<HireActionModel>>();
		resp.setBody(list);

	//	System.err.println("list schedule ======= "+list);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HireActionModel>>> response = new ResponseEntity<JsonResponse<List<HireActionModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : getScheduleDetails ends");
		return response;

	}

	/* Function for edit Schedule Interview */
	public ResponseEntity<JsonResponse<Object>> editScheduleInterview(HireActionModel action) {

		logger.info("Method : editScheduleInterview starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String values = GenerateHireActionParameter.editScheduleInterview(action);

		try {

			em.createNamedStoredProcedureQuery("hireActionRoutines").setParameter("actionType", "editSchedule")
					.setParameter("actionValue", values).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : editScheduleInterview ends");
		return response;

	}

	/* For shortList Candidate */
	public ResponseEntity<JsonResponse<Object>> shortListCandidate(String id, String reqId, String status) {

		logger.info("Method : shortListCandidate starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String values = "SET @p_candId=\"" + id + "\",@p_reqId=\"" + reqId +"\",@p_status=\""+status+ "\";";
		try {

			em.createNamedStoredProcedureQuery("hireActionRoutines").setParameter("actionType", "shortListCandidate")
					.setParameter("actionValue", values).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : shortListCandidate ends");
		return response;

	}

	public ResponseEntity<JsonResponse<Object>> shortListCandidateHireDao(String id, String reqId, String bandid,
	        String finalCtc, String createdBy, String joiningdate, String orgName, String orgDivision, String salaryData) {

	    logger.info("Method : shortListCandidateHireDao starts");

	    JsonResponse<Object> resp = new JsonResponse<Object>();

	    StringBuilder valuesBuilder = new StringBuilder();
	    valuesBuilder.append("SET @p_candId=\"").append(id)
	            .append("\",@p_reqId=\"").append(reqId)
	            .append("\",@p_band=\"").append(bandid)
	            .append("\",@p_createdBy=\"").append(createdBy)
	            .append("\",@p_salary=\"").append(finalCtc)
	            .append("\",@p_salaryJsonData='").append(salaryData.replace("'", "\\'")) // Escape single quotes
	            .append("',@p_joiningdate=\"").append(DateFormatter.getStringDate(joiningdate))
	            .append("\",@p_orgName=\"").append(orgName)
	            .append("\",@p_orgDiv=\"").append(orgDivision)
	            .append("\"");

	    // Parse salaryData JSON and add separate SET parameters
	    try {
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode salaryJson = mapper.readTree(salaryData);

	        if (salaryJson != null) {
	            salaryJson.fields().forEachRemaining(entry -> {
	                String key = entry.getKey();
	                String value = entry.getValue().asText();
	                valuesBuilder.append(",@p_").append(key).append("=\"").append(value).append("\"");
	            });
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    String values = valuesBuilder.toString();
	    logger.info("values: " + values);

	    try {
	        em.createNamedStoredProcedureQuery("hireActionRoutines")
	            .setParameter("actionType", "candidateHire")
	            .setParameter("actionValue", values)
	            .execute();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("MyResponseHeader", "MyValue");
	    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders, HttpStatus.CREATED);

	    logger.info("Method : shortListCandidateHireDao ends");
	    return response;
	}

	/**
	 * Function for Get Rating Category For Drop Down
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRatingCategoryList() {
		logger.info("Method : getRatingCategoryListDao starts");

		List<DropDownModel> cat = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
					.setParameter("actionType", "getRatingCatList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				cat.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getRatingCategoryListDao ends");
		return cat;

	}

	/*
	 * Function for get Rating type
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRatingTypeDao(String category) {

		logger.info("Method in Dao: getRatingTypeDao starts");

		List<DropDownModel> typeModelList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_categoryId='" + category + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
					.setParameter("actionType", "getRatingType").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				DropDownModel typeModel = new DropDownModel(m[0], m[1]);
				typeModelList.add(typeModel);

			}
			resp.setBody(typeModelList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method in Dao: getRatingTypeDao ends");

		return response;
	}

	/*
	 * Function for add FeedBack
	 */
	public ResponseEntity<JsonResponse<List<HireActionModel>>> addFeedbackDao(List<HireActionModel> feedBackModel) {

		logger.info("Method : addFeedbackDao starts");

		JsonResponse<List<HireActionModel>> resp = new JsonResponse<List<HireActionModel>>();
		List<HireActionModel> listData = new ArrayList<HireActionModel>();

		try {
			String values = GenerateHireActionParameter.addFeedback(feedBackModel);
			
			if(feedBackModel.get(0).getFeedbackId()=="" || feedBackModel.get(0).getFeedbackId()=="null" || feedBackModel.get(0).getFeedbackId()==null) {
				logger.info("feedback id-->" + feedBackModel.get(0).getFeedbackId());
				logger.info("add values===="+values);
				em.createNamedStoredProcedureQuery("hireActionRoutines").setParameter("actionType", "addFeedback")
				.setParameter("actionValue", values).execute();
				resp.setCode("Success");
				resp.setMessage("feedback saved successfully");
			}else {
				logger.info("modify values===="+values);
				logger.info("feedback id-->" + feedBackModel.get(0).getFeedbackId());

				em.createNamedStoredProcedureQuery("hireActionRoutines").setParameter("actionType", "modifyFeedback")
				.setParameter("actionValue", values).execute();
				resp.setCode("Success");
				resp.setMessage("feedback modify successfully");	
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				if(err[0].contentEquals("1062")) {
					resp.setCode("Unsuccess");
					resp.setMessage("your are already given feedback!");
				}else {
					resp.setCode("Unsuccess");
					resp.setMessage("something went wrong please try after sometime!");
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<HireActionModel>>> response = new ResponseEntity<JsonResponse<List<HireActionModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addFeedbackDao ends");
		return response;
	}

//Function for View FeedBack
	@SuppressWarnings("unchecked")
	public JsonResponse<List<HireActionModel>> getFeedbackDetails(String id) {

		logger.info("Method : getFeedbackDetails starts");

		List<HireActionModel> list = new ArrayList<HireActionModel>();

		String values = "SET @p_reqId='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
					.setParameter("actionType", "viewFeedbackDetails").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				HireActionModel feedback = new HireActionModel(m[0], m[1], m[2], null, null, m[3], null, m[4], null,
						null, null, null, null, null, null, null, null, m[5], null, m[6], null);
				list.add(feedback);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<HireActionModel>> resp = new JsonResponse<List<HireActionModel>>();
		resp.setBody(list);
	//	System.err.println("list feedback ======= "+list);
		logger.info("Method : getFeedbackDetails ends");
		return resp;

	}

	/*
	 * Function for edit Feedback
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<HireActionModel>> editFeedbackDao(String feedId, String candId) {
		logger.info("Method : editFeedbackDao starts");

		JsonResponse<List<HireActionModel>> resp = new JsonResponse<List<HireActionModel>>();
		List<HireActionModel> feedbackList = new ArrayList<HireActionModel>();

		try {
			String values = "SET @p_feedbackId='" + feedId + "', @p_candId='" + candId + "';";
			logger.info("values==="+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
					.setParameter("actionType", "editFeedback").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				Object DATE = null;
				if (m[4] != null) {
					DATE = m[4].toString();
				}

				HireActionModel feedback = new HireActionModel(m[0], m[1], m[2], null, null, m[3], null, m[4], null,
						null, null, null, null, null, null, null, null, m[5], null, m[6], null);
				feedbackList.add(feedback);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(feedbackList);
		logger.info("resp==="+resp);
		logger.info("Method : editFeedbackDao ends");
		return resp;
	}
	/* Function for joining status update */
	public ResponseEntity<JsonResponse<Object>> joinStatusUpdateDao(String candId, String reqId, String status) {

		logger.info("Method : joinStatusUpdateDao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String values = "SET @p_candId='" + candId + "',@p_reqId='" + reqId + "',@p_status='" + status + "';";
		try {
			em.createNamedStoredProcedureQuery("hireActionRoutines").setParameter("actionType", "joinStatusUpdate")
					.setParameter("actionValue", values).execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp, responseHeaders,
				HttpStatus.CREATED);

		logger.info("Method : joinStatusUpdateDao ends");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<DropDownModel> getPosition(String id) {

		logger.info("Method : getPosition dao starts");
		DropDownModel req = new DropDownModel();
		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();

		String value = "SET @p_requisitionid='" + id + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hireActionRoutines")
					.setParameter("actionType", "getjobposition").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel restaddress = new DropDownModel(m[0], m[1], m[2], m[3]);
				req = restaddress;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPosition dao ends" + resp);
		return resp;
	}
	
	
}
