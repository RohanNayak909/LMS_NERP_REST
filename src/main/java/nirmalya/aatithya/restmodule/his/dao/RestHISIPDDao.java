package nirmalya.aatithya.restmodule.his.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import nirmalya.aatithya.restmodule.canteen.model.RestMenuModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateAddPatientParameter;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateIpdDietDetailsParameter;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateIpdOtDetailsParameter;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateIpdParameter;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateIpdVitalParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

@Repository
public class RestHISIPDDao {

	Logger logger = LoggerFactory.getLogger(RestHISIPDDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HISPatientRestModel>>> getPatientDataList(String id) {
		logger.info("Method : getPatientDataList Dao starts");

		List<HISPatientRestModel> itemNameList = new ArrayList<HISPatientRestModel>();
		JsonResponse<List<HISPatientRestModel>> resp = new JsonResponse<List<HISPatientRestModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		System.out.println("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ipd_routines")
					.setParameter("actionType", "getPatientDataList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				HISPatientRestModel viewDemo = new HISPatientRestModel(m[0], m[1], m[2], m[3], m[4], null, null);

				itemNameList.add(viewDemo);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<HISPatientRestModel>>> response = new ResponseEntity<JsonResponse<List<HISPatientRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getPatientDataList Dao ends" + resp);
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addIpd(HISPatientRestModel patientRestModel) {
		logger.info("Method : Rest Add addIpd Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateIpdParameter.addPatientIPDParam(patientRestModel);

			if (patientRestModel.getPatientId() != null && patientRestModel.getPatientId() != "") {

				em.createNamedStoredProcedureQuery("his_ipd_routines").setParameter("actionType", "modiFyIpd")
						.setParameter("actionValue", values).execute();
				System.out.println("modify" + values);
			} else {
				em.createNamedStoredProcedureQuery("his_ipd_routines").setParameter("actionType", "addIpd")
						.setParameter("actionValue", values).execute();
				System.out.println("add" + values);
			}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :  Rest Add addIpd Dao ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> bedList() {

		logger.info("Method :bedList starts");

		List<DropDownModel> bedList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "bedList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bedList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : bedList ends" + bedList);

		return bedList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> wardList() {

		logger.info("Method :wardList starts");

		List<DropDownModel> wardList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "wardList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				wardList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : wardList ends" + wardList);

		return wardList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> procedureList() {

		logger.info("Method :procedureList starts");

		List<DropDownModel> procedureList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "procedureList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				procedureList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : procedureList ends" + procedureList);

		return procedureList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HISPatientRestModel>>> viewIpd(String organization, String orgDiv) {
		logger.info("Method : viewIpd dao starts==========");

		List<HISPatientRestModel> patientList = new ArrayList<HISPatientRestModel>();

		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDiv + "';";

			logger.info("for patient views====" + values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ipd_routines")
					.setParameter("actionType", "viewIpd").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				HISPatientRestModel dropDownModel = new HISPatientRestModel(m[0], m[1], m[2], m[3], m[4], m[5], null,
						null, null);
				patientList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<HISPatientRestModel>> resp = new JsonResponse<List<HISPatientRestModel>>();
		resp.setBody(patientList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<HISPatientRestModel>>> response = new ResponseEntity<JsonResponse<List<HISPatientRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewIpd dao ends =======" + resp);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewIpd(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewIpd Dao starts" + userId);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";

			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "viewIPDPatients").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewIpd Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editIpd(String id, String orgName, String orgDivision, String userId) {
		logger.info("Method : editIpd Dao starts" + userId);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_bookingId='" + id + "', @p_org='" + orgName + "', @p_orgDiv='" + orgDivision + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "bookingDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editIpd Dao ends" + resp);
		return resp;
	}

	public ResponseEntity<JsonResponse<Object>> deleteIpd(String id) {

		logger.info("Method : deleteIpd Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_patientId='" + id + "';";
			logger.info("it is for delete==========" + values);
			em.createNamedStoredProcedureQuery("his_ipd_routines").setParameter("actionType", "deleteIpd")
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteIpd Dao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addIpdPatient(HISPatientRestModel patientRestModel) {
		logger.info("Method : addIpdPatient Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateAddPatientParameter.addPatientModalParam(patientRestModel);

			if (patientRestModel.getPatientId() != null && patientRestModel.getPatientId() != "") {

				em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "modiFyPatient")
						.setParameter("actionValue", values).execute();
				System.out.println("modify" + values);
			} else {
				em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "addPatient")
						.setParameter("actionValue", values).execute();
				System.out.println("add" + values);
			}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :  addIpdPatient Dao ends");

		return response;
	}

	// getPatientBedList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPatientBedList(String id) {

		logger.info("Method : getPatientBedList starts");
		List<DropDownModel> bedList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_word='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "getBedList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				bedList.add(dropDownModel);
			}

			resp.setBody(bedList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPatientBedList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> doctordepartmentList() {

		logger.info("Method :doctordepartmentList starts");

		List<DropDownModel> doctordepartmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ipd_routines")
					.setParameter("actionType", "doctordepartmentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				doctordepartmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : wardList ends" + doctordepartmentList);

		return doctordepartmentList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getRelationList() {

		logger.info("Method :getRelationList starts");

		List<DropDownModel> getRelationList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ipd_routines")
					.setParameter("actionType", "relationList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getRelationList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getRelationList ends" + getRelationList);

		return getRelationList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getinsuranceList() {

		logger.info("Method :getinsuranceList starts");

		List<DropDownModel> getinsuranceList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ipd_routines")
					.setParameter("actionType", "insuranceList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getinsuranceList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getinsuranceList ends" + getinsuranceList);

		return getinsuranceList;
	}


	//getDietMenu
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getDietMenu(String organization, String orgDivision) {
			logger.info("Method : getDietMenu Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";

				logger.info("valuesssss" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("his_ipd_routines")
						.setParameter("actionType", "getDietMenu").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getDietMenu Dao ends");
			return resp;
		}
		//viewAllDetailsByIPDID
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewAllDetailsByIPDID(String organization, String orgDivision, String userId, String patientId,String ipdId) {
			logger.info("Method : viewAllDetailsByIPDID Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId
						+ "',@p_patientId='" + patientId + "',@p_ipdId='" + ipdId +"';";
				
				logger.info("valuesssss" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("his_ipd_routines")
						.setParameter("actionType", "viewAllDetailsByIPDID").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewAllDetailsByIPDID Dao ends");
			return resp;
		}
		// save vital
		public ResponseEntity<JsonResponse<Object>> saveVitalDetails(HISPatientRestModel patientRestModel) {
			logger.info("Method : Rest Add saveVitalDetails Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String values = GenerateIpdVitalParameter.addIpdVitalParam(patientRestModel);
				if (patientRestModel.getVitalId() != null && patientRestModel.getVitalId() != "") {
					em.createNamedStoredProcedureQuery("his_ipd_routines").setParameter("actionType", "modifyVital")
							.setParameter("actionValue", values).execute();
							resp.setCode("success");
							resp.setMessage("Vital modify successfully");
				} else {
					em.createNamedStoredProcedureQuery("his_ipd_routines").setParameter("actionType", "addVital")
							.setParameter("actionValue", values).execute();
						resp.setCode("success");
						resp.setMessage("Vital saved successfully");
				}

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);

			logger.info("Method :  Rest Add saveVitalDetails Dao ends");

			return response;
		}

		// vital edit
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> editVital(String Id, String organization, String orgDivision) {
			logger.info("Method : editVital Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_vitalId='" + Id + "';";

				logger.info("vvvv" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("his_ipd_routines")
						.setParameter("actionType", "editVital").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setMessage("Something Went Wrong !");
			}
			logger.info("Method : editVital Dao ends" + resp);
			return resp;

		}
	// save treatment
	@Transactional
	public ResponseEntity<JsonResponse<Object>> saveTreatmentDetails(
	        List<Map<String, Object>> treatmentDataList, String userId, String org, String orgDiv) {
	    logger.info("method: saveTreatmentDetails Starts"+treatmentDataList);

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
	            em.createNamedStoredProcedureQuery("his_ipd_routines")
	                    .setParameter("actionType", "saveTreatment")
	                    .setParameter("actionValue", value)
	                    .execute();

	            resp.setMessage("Data saved successfully!");
	            resp.setCode("Success");
	        } else {
	            em.createNamedStoredProcedureQuery("his_ipd_routines")
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

	    logger.info("method: saveTreatmentDetails Ends"+response);
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
				em.createNamedStoredProcedureQuery("his_ipd_routines").setParameter("actionType", "saveTestDetails")
						.setParameter("actionValue", value).execute();
				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			} else {
				System.out.println("modify ");
				em.createNamedStoredProcedureQuery("his_ipd_routines")
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
 

	// save diet
		@Transactional
		public ResponseEntity<JsonResponse<Object>> saveDietDetails(
		        List<Map<String, Object>> dietDataList, String userId, String org, String orgDiv) {
		    logger.info("method: saveDietDetails Starts");

		    JsonResponse<Object> resp = new JsonResponse<>();
		    try {
		        String value = "SET @diet='" + new Gson().toJson(dietDataList) + "', @p_createdBy='" + userId
		                + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
System.out.println("value=="+value);
		        String dietId = "";

		        // 🔹 Loop through the list to check for a valid treatmentId
		        for (Map<String, Object> dietData : dietDataList) {
		            if (dietData.containsKey("dietId")) {
		                Object id = dietData.get("dietId");
		                if (id != null) {
		                	dietId = id.toString();
		                    break;  // Stop checking after the first valid ID
		                }
		            }
		        }

		        if (dietId == null || dietId.isEmpty()) {
		            em.createNamedStoredProcedureQuery("his_ipd_routines")
		                    .setParameter("actionType", "saveDiet")
		                    .setParameter("actionValue", value)
		                    .execute();

		            resp.setMessage("Diet saved successfully!");
		            resp.setCode("Success");
		        } else {
		            em.createNamedStoredProcedureQuery("his_ipd_routines")
		                    .setParameter("actionType", "modifyDiet")
		                    .setParameter("actionValue", value)
		                    .execute();

		            resp.setMessage("Diet modified successfully!");
		            resp.setCode("Success");
		        }
		    } catch (Exception e) {
		        logger.error("Error in saveDietDetails: ", e);
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
		    logger.info("method: saveDietDetails Ends");
		    return response;
}
 
	// edit diet
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editDiet(String id, String organization, String orgDivision) {
		logger.info("Method : editDiet Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_ipdId='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ipd_routines")
					.setParameter("actionType", "editDiet").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : editDiet Dao ends" + resp);
		return resp;

	}

 
	// saveIpdOt
			@Transactional
			public ResponseEntity<JsonResponse<Object>> saveIpdOt(String otData, String userId, String org, String orgDiv) {
				logger.info("method: saveIpdOt Dao Starts");

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
						em.createNamedStoredProcedureQuery("his_ipd_routines").setParameter("actionType", "saveOpdOt")
								.setParameter("actionValue", value).execute();

						resp.setMessage("Data saved successfully!");
						resp.setCode("Success");
					} else {
						System.out.println("modify");
						em.createNamedStoredProcedureQuery("his_ipd_routines")
								.setParameter("actionType", "modifyOpdOt").setParameter("actionValue", value).execute();

						resp.setMessage("Data modified successfully!");
						resp.setCode("Success");
					}
				} catch (Exception e) {
					logger.error("Error in ot details: ", e);
				}

				ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

				logger.info("method: saveIpdOt Dao Ends");
				return response;
			}
 
 
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> restGetBedLists(String org, String orgDiv) {
		logger.info("Method : restGetBedLists Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ipd_routines")
					.setParameter("actionType", "getAllBedList").setParameter("actionValue", value).getResultList();
			
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : editOt Dao ends" + resp);
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
				em.createNamedStoredProcedureQuery("his_ipd_routines").setParameter("actionType", "saveSymps")
						.setParameter("actionValue", value).execute();

				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			} else {
				em.createNamedStoredProcedureQuery("his_ipd_routines").setParameter("actionType", "modifySymps")
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
					List<Object[]> list = em.createNamedStoredProcedureQuery("his_ipd_routines")
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
			
			
			/* viewTreatmentHistory */
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> viewTreatmentHistory(String orgName, String orgDivision, String patientId, String ipdId) {
				logger.info("Method : viewTreatmentHistory Dao starts");

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_patientId='" + patientId
							+ "',@ipdId='" + ipdId + "';";
					System.out.println("value==="+value);
					List<Object[]> list = em.createNamedStoredProcedureQuery("his_ipd_routines")
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
			public JsonResponse<Object> viewTestHistory(String orgName, String orgDivision, String patientId, String ipdId) {
				logger.info("Method : viewTestHistory Dao starts");

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_patientId='" + patientId
							+ "',@ipdId='" + ipdId + "';";
					System.out.println("value==="+value);
					List<Object[]> list = em.createNamedStoredProcedureQuery("his_ipd_routines")
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
}
