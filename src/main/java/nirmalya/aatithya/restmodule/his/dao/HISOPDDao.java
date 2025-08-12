package nirmalya.aatithya.restmodule.his.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateOpdTimeSlotParameters;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

@Repository
public class HISOPDDao {
	Logger logger = LoggerFactory.getLogger(HISOPDDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCategoryWiseItemList(String org, String orgDiv, String type) {
		logger.info("Method : getCategoryWiseItemList starts");

		List<DropDownModel> locationList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_type='" + type + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "getCategoryWiseItemList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2],m[3]);
				locationList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCategoryWiseItemList ends");
		return locationList;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewOpdDetails(String orgName, String orgDivision, String fromdate, String todate) {
		logger.info("Method : viewOpdDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromdate='" + fromdate
					+ "',@p_todate='" + todate + "' ;";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "viewOpd").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("hhhhhhhhhhhhhhhhh" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewOpdDetails Dao ends");
		return resp;

	}

	public JsonResponse<HISPatientRestModel> approvalStatus(String approval, String opdId, String approvedBy) {
		logger.info("Method : approvalStatus starts");

		HISPatientRestModel req = new HISPatientRestModel();
		JsonResponse<HISPatientRestModel> resp = new JsonResponse<HISPatientRestModel>();
		try {

			String value = "SET @p_approval='" + approval + "',@p_opdId='" + opdId + "',@p_approvedBy='" + approvedBy
					+ "';";
			em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "approvalStatus")
					.setParameter("actionValue", value).execute();
			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Status changed successfully");

		} catch (Exception e) {

			e.printStackTrace();
		}
		logger.info("Method : approvalStatus ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewOpdTimeSlots(String orgName, String orgDivision, String userId, String fromDate,
			String toDate) {
		logger.info("Method : viewOpdTimeSlots Dao starts...");
		String currentDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId
					+ "',@p_fromDate='" + (fromDate != null ? fromDate : currentDate) + "',@p_toDate='"
					+ (toDate != null ? toDate : currentDate) + "';";
			logger.info(value, "string value ===");
			List<Object[]> list = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "viewOpdTime").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("viewOpdTimeSlots ==== " + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewOpdTimeSlots Dao ends...");
		return resp;
	}

	/* DAO Function to Add */

	public ResponseEntity<JsonResponse<Object>> addOpdTime(HISPatientRestModel restData) {
		logger.info("Method : Rest addOpdTime   starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {
				String values = GenerateOpdTimeSlotParameters.getOpdTimeSlotParam(restData);

				if (restData.getDocOpdId() == null || restData.getDocOpdId() == "") {
					em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "addOpdTime")
							.setParameter("actionValue", values).execute();

				}

				else {
					em.createNamedStoredProcedureQuery("his_patient_routines")
							.setParameter("actionType", "modifyOpdTime").setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : Rest addOpdTime Dao ends" + response);
		return response;

	}

	// save vital details
	@Transactional
	public ResponseEntity<JsonResponse<Object>> saveOpdVitalDetails(String vitalData, String userId, String org,
			String orgDiv) {
		logger.info("method: saveVitalDetails Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @vitalData='" + vitalData + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";

			String vitalId = "";
			try {
				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(vitalData, JsonObject.class);
				if (jsonObject.has("vitalId")) {
					vitalId = jsonObject.get("vitalId").getAsString();
				}
			} catch (Exception parseException) {
				logger.error("Error parsing vitalData with Gson: ", parseException);
			}

			if (vitalId == null || vitalId.isEmpty()) {
				em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "saveVitalData")
						.setParameter("actionValue", value).execute();

				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			} else {
				em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "modifyVital")
						.setParameter("actionValue", value).execute();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");
			}
		} catch (Exception e) {
			logger.error("Error in saveVitalDetails: ", e);
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
			} catch (Exception nestedException) {
				logger.error("Error while handling exception: ", nestedException);
				resp.setCode("Failed");
				resp.setMessage("Oops! Something went wrong during error handling");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: saveVitalDetails Ends");
		return response;
	}

	// viewTypeDetails
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewTypeDetails(String orgName, String orgDivision, String types, String opdId) {
		logger.info("Method : viewTypeDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_types='" + types
					+ "',@p_opdId='" + opdId + "';";
			System.out.println("value==="+value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "viewTypesDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setCode("Success");
			resp.setMessage("Data fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewTypeDetails Dao ends"+resp);
		return resp;

	}

	// editVital

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editVital(String orgName, String orgDivision, String vitalId,String vitalIdSlNo) {
		logger.info("Method : editVital Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_vitalId='" + vitalId + "',@p_vitalIdSlNo='" + vitalIdSlNo + "';";
			List<Object[]> list = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "editVital").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setCode("Success");
			resp.setMessage("Data fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editVital Dao ends");
		return resp;

	}

	@Transactional
	public ResponseEntity<JsonResponse<Object>> saveTreatmentDetails(
	        List<Map<String, Object>> treatmentDataList, String userId, String org, String orgDiv) {
	    logger.info("method: saveTreatmentDetails Starts");

	    JsonResponse<Object> resp = new JsonResponse<>();
	    try {
	        String value = "SET @treatment='" + new Gson().toJson(treatmentDataList) + "', @p_userId='" + userId
	                + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";

	        String tratmentId = "";

	        // 🔹 Loop through the list to check for a valid treatmentId
	        for (Map<String, Object> treatmentData : treatmentDataList) {
	            if (treatmentData.containsKey("tratmentId")) {
	                Object id = treatmentData.get("tratmentId");
	                if (id != null) {
	                    tratmentId = id.toString();
	                    break;  // Stop checking after the first valid ID
	                }
	            }
	        }

	        if (tratmentId == null || tratmentId.isEmpty()) {
	            em.createNamedStoredProcedureQuery("his_patient_routines")
	                    .setParameter("actionType", "saveTreatment")
	                    .setParameter("actionValue", value)
	                    .execute();

	            resp.setMessage("Data saved successfully!");
	            resp.setCode("Success");
	        } else {
	            em.createNamedStoredProcedureQuery("his_patient_routines")
	                    .setParameter("actionType", "modifyTreatment")
	                    .setParameter("actionValue", value)
	                    .execute();

	            resp.setMessage("Data modified successfully!");
	            resp.setCode("Success");
	        }
	    } catch (Exception e) {
	        logger.error("Error in treatmentDetails: ", e);
	        try {
	            String[] err = serverDao.errorProcedureCall(e);
	            resp.setCode("Failed");
	            resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
	        } catch (Exception nestedException) {
	            logger.error("Error while handling exception: ", nestedException);
	            resp.setCode("Failed");
	            resp.setMessage("Oops! Something went wrong during error handling");
	        }
	    }

	    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

	    logger.info("method: saveTreatmentDetails Ends");
	    return response;
	}

 

	// saveTestDetails

	@Transactional
	public ResponseEntity<JsonResponse<Object>> saveTestDetails(List<Map<String, Object>> testDataList, String userId, String org,
			String orgDiv) {
		logger.info("method: saveTestDetails Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @test='" + new Gson().toJson(testDataList) + "', @p_userId='" + userId + "', @p_org='" + org + "', @p_orgDiv='"
					+ orgDiv + "';";
			System.out.println("value=="+value);
			String testId = "";

	        // 🔹 Loop through the list to check for a valid testId
	        for (Map<String, Object> testData : testDataList) {
	            if (testData.containsKey("testId")) {
	                Object id = testData.get("testId");
	                if (id != null) {
	                	testId = id.toString();
	                    break;  // Stop checking after the first valid ID
	                }
	            }
	        }
System.out.println("testId==="+testId);
			if (testId == null || testId == "" || testId.isEmpty()) {
				System.out.println("add ");
				em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "saveTestDetails")
						.setParameter("actionValue", value).execute();
				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			} else {
				System.out.println("modify ");
				em.createNamedStoredProcedureQuery("his_patient_routines")
						.setParameter("actionType", "modifyTestDetails").setParameter("actionValue", value).execute();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");
			}
		} catch (Exception e) {
			logger.error("Error in test details: ", e);
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
			} catch (Exception nestedException) {
				logger.error("Error while handling exception: ", nestedException);
				resp.setCode("Failed");
				resp.setMessage("Oops! Something went wrong during error handling");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: saveTestDetails Ends");
		return response;
	}

	// saveOpdDiet
	@Transactional
	public ResponseEntity<JsonResponse<Object>> saveOpdDiet(String dietData, String userId, String org, String orgDiv) {
		logger.info("method: saveOpdDiet Dao Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @diet='" + dietData + "', @p_userId='" + userId + "', @p_org='" + org + "', @p_orgDiv='"
					+ orgDiv + "';";
System.out.println("value=="+value);
			String dietId = "";
			try {
				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(dietData, JsonObject.class);
				if (jsonObject.has("dietId")) {
					dietId = jsonObject.get("dietId").getAsString();
				}
			} catch (Exception parseException) {
				logger.error("Error parsing treatmentData with Gson: ", parseException);
			}

			if (dietId == null || dietId.isEmpty()) {
				em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "saveDietDetails")
						.setParameter("actionValue", value).execute();

				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			} else {
				em.createNamedStoredProcedureQuery("his_patient_routines")
						.setParameter("actionType", "modifyDietDetails").setParameter("actionValue", value).execute();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");
			}
		} catch (Exception e) {
			logger.error("Error in deit details: ", e);
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: saveOpdDiet Dao Ends");
		return response;
	}

	// editOpdDiet
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editOpdDiet(String orgName, String orgDivision, String dietId,String dietSlNo) {
		logger.info("Method : editOpdDiet Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_dietId='" + dietId + "',@p_dietSlNo='" + dietSlNo +"';";
			System.out.println("value=="+value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "editDietDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setCode("Success");
			resp.setMessage("Data fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editOpdDiet Dao ends");
		return resp;

	}
	
	//deleteOpdDiet
	public JsonResponse<Object> deleteOpdDiet(String orgName, String orgDivision, String dietId) {
		logger.info("Method : deleteOpdDiet Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_dietId='" + dietId + "';";
			em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "deleteDiet")
					.setParameter("actionValue", value).execute();
			resp.setCode("Success");
			resp.setMessage("Data fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage("Opps Something went wrong!");
		}
		logger.info("Method : deleteOpdDiet Dao ends");
		return resp;

	}
   //saveOpdNotes
	@Transactional
	public ResponseEntity<JsonResponse<Object>> saveOpdNotes(String notesData, String userId, String org, String orgDiv) {
		logger.info("method: saveOpdNotes Dao Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @notesData='" + notesData + "', @p_userId='" + userId + "', @p_org='" + org + "', @p_orgDiv='"
					+ orgDiv + "';";
			System.out.println("value==="+value);

			String notesId = "";
			try {
				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(notesData, JsonObject.class);
				if (jsonObject.has("notesId")) {
					notesId = jsonObject.get("notesId").getAsString();
				}
			} catch (Exception parseException) {
				logger.error("Error parsing treatmentData with Gson: ", parseException);
			}

			if (notesId == null || notesId.isEmpty()) {
				em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "saveNotes")
						.setParameter("actionValue", value).execute();

				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			} else {
				em.createNamedStoredProcedureQuery("his_patient_routines")
						.setParameter("actionType", "modifyNotes").setParameter("actionValue", value).execute();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");
			}
		} catch (Exception e) {
			logger.error("Error in deit details: ", e);
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: saveOpdNotes Dao Ends");
		return response;
	}
	
	//editOpdNotes
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editOpdNotes(String orgName, String orgDivision, String noteId,String notesIdSlNo) {
		logger.info("Method : editOpdNotes Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_noteId='" + noteId + "',@p_notesIdSlNo='" + notesIdSlNo + "';";
			System.out.println("value=="+value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "editOpdNotes").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			resp.setCode("Success");
			resp.setMessage("Data fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editOpdNotes Dao ends");
		return resp;
	}
	
	//deleteOpdNote
	public JsonResponse<Object> deleteOpdNote(String orgName, String orgDivision, String noteId) {
		logger.info("Method : deleteOpdNote Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_noteId='" + noteId + "';";
			em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "deleteNote")
					.setParameter("actionValue", value).execute();
			resp.setCode("Success");
			resp.setMessage("Data fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage("Opps Something went wrong!");
		}
		logger.info("Method : deleteOpdNote Dao ends");
		return resp;

	}
	
	
	// saveOpdOt
		@Transactional
		public ResponseEntity<JsonResponse<Object>> saveOpdOt(String otData, String userId, String org, String orgDiv) {
			logger.info("method: saveOpdOt Dao Starts");

			JsonResponse<Object> resp = new JsonResponse<>();
			try {
				String value = "SET @otData='" + otData + "', @p_userId='" + userId + "', @p_org='" + org + "', @p_orgDiv='"
						+ orgDiv + "';";
				
				System.out.println("value for ot details============= >"+value);

				String otId = "";
				try {
					Gson gson = new Gson();
					JsonObject jsonObject = gson.fromJson(otData, JsonObject.class);
					if (jsonObject.has("otId")) {
						otId = jsonObject.get("otId").getAsString();
					}
				} catch (Exception parseException) {
					logger.error("Error parsing treatmentData with Gson: ", parseException);
				}

				if (otId == null || otId.isEmpty()) {
					System.out.println("add");
					em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "saveOpdOt")
							.setParameter("actionValue", value).execute();

					resp.setMessage("Data saved successfully!");
					resp.setCode("Success");
				} else {
					System.out.println("modify");
					em.createNamedStoredProcedureQuery("his_patient_routines")
							.setParameter("actionType", "modifyOpdOt").setParameter("actionValue", value).execute();

					resp.setMessage("Data modified successfully!");
					resp.setCode("Success");
				}
			} catch (Exception e) {
				logger.error("Error in ot details: ", e);
			}

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

			logger.info("method: saveOpdOt Dao Ends");
			return response;
		}
		
		
		// editOpdOt
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> editOpdOt(String orgName, String orgDivision, String opd,String pat) {
			logger.info("Method : editOpdOt Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_opd='" + opd + "',@p_pat='" + pat + "';";
				List<Object[]> list = em.createNamedStoredProcedureQuery("his_patient_routines")
						.setParameter("actionType", "editOpdOt").setParameter("actionValue", value).getResultList();
				resp.setBody(list);
				resp.setCode("Success");
				resp.setMessage("Data fetched Successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : editOpdOt Dao ends");
			return resp;

		}
		
		/* viewTreatmentHistory */
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewTreatmentHistory(String orgName, String orgDivision, String types, String patId, String bookingId) {
			logger.info("Method : viewTreatmentHistory Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_types='" + types
						+ "',@patientId='" + patId + "',@p_bookingId='" + bookingId + "';";
				System.out.println("value==="+value);
				List<Object[]> list = em.createNamedStoredProcedureQuery("his_patient_routines")
						.setParameter("actionType", "viewTreatmentHis").setParameter("actionValue", value).getResultList();
				resp.setBody(list);
				resp.setCode("Success");
				resp.setMessage("Data fetched Successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewTreatmentHistory Dao ends"+resp);
			return resp;

		}
		
		/* viewTestHistory */
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewTestHistory(String orgName, String orgDivision, String types, String patId) {
			logger.info("Method : viewTestHistory Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_types='" + types
						+ "',@patientId='" + patId + "';";
				System.out.println("value==="+value);
				List<Object[]> list = em.createNamedStoredProcedureQuery("his_patient_routines")
						.setParameter("actionType", "viewTestHistory").setParameter("actionValue", value).getResultList();
				resp.setBody(list);
				resp.setCode("Success");
				resp.setMessage("Data fetched Successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewTestHistory Dao ends"+resp);
			return resp;

		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewDietHistory(String orgName, String orgDivision, String types, String patId) {
			logger.info("Method : viewDietHistory Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_types='" + types
						+ "',@patientId='" + patId + "';";
				System.out.println("value==="+value);
				List<Object[]> list = em.createNamedStoredProcedureQuery("his_patient_routines")
						.setParameter("actionType", "viewDietHistory").setParameter("actionValue", value).getResultList();
				resp.setBody(list);
				resp.setCode("Success");
				resp.setMessage("Data fetched Successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewDietHistory Dao ends"+resp);
			return resp;

		}
		
		
		// save Symp details
		@Transactional
		public ResponseEntity<JsonResponse<Object>> saveSympsDetail(String sympData, String userId, String org,
				String orgDiv) {
			logger.info("method: saveSympsDetail Starts");

			JsonResponse<Object> resp = new JsonResponse<>();
			try {
				String value = "SET @sympData='" + sympData + "', @p_userId='" + userId + "', @p_org='" + org
						+ "', @p_orgDiv='" + orgDiv + "';";

				String symptomsId = "";
				try {
					Gson gson = new Gson();
					JsonObject jsonObject = gson.fromJson(sympData, JsonObject.class);
					if (jsonObject.has("symptomsId")) {
						symptomsId = jsonObject.get("symptomsId").getAsString();
					}
				} catch (Exception parseException) {
					logger.error("Error parsing sympData with Gson: ", parseException);
				}

				if (symptomsId == null || symptomsId.isEmpty()) {
					em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "saveSympsDetail")
							.setParameter("actionValue", value).execute();

					resp.setMessage("Data saved successfully!");
					resp.setCode("Success");
				} else {
					em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "modifySymps")
							.setParameter("actionValue", value).execute();

					resp.setMessage("Data modified successfully!");
					resp.setCode("Success");
				}
			} catch (Exception e) {
				logger.error("Error in saveSympsDetail: ", e);
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode("Failed");
					resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
				} catch (Exception nestedException) {
					logger.error("Error while handling exception: ", nestedException);
					resp.setCode("Failed");
					resp.setMessage("Oops! Something went wrong during error handling");
				}
			}

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

			logger.info("method: saveSympsDetail Ends");
			return response;
		}
		
		//editSympt
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> editSympt(String orgName, String orgDivision, String symptomsId) {
			logger.info("Method : editSympt Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_symptomsId='" + symptomsId + "';";
				System.out.println("value=="+value);
				List<Object[]> list = em.createNamedStoredProcedureQuery("his_patient_routines")
						.setParameter("actionType", "editSympt").setParameter("actionValue", value).getResultList();
				resp.setBody(list);
				resp.setCode("Success");
				resp.setMessage("Data fetched Successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : editSympt Dao ends");
			return resp;
		}

}