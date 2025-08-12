package nirmalya.aatithya.restmodule.his.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.DynamicQueryBuilder;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateAddPatientParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;
import nirmalya.aatithya.restmodule.his.model.RegsPatientModel;

@Repository
public class HISPatientDao {
	Logger logger = LoggerFactory.getLogger(HISPatientDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> genderList() {

		logger.info("Method :genderList starts");

		List<DropDownModel> genderList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "genderList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				genderList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : genderList ends" + genderList);

		return genderList;
	}

	// maritalstatusList

	@SuppressWarnings("unchecked")
	public List<DropDownModel> maritalstatusList() {

		logger.info("Method :maritalstatusList starts");

		List<DropDownModel> genderList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "maritalstatusList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				genderList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : maritalstatusList ends" + genderList);

		return genderList;
	}

	// nationalityList

	@SuppressWarnings("unchecked")
	public List<DropDownModel> nationalityList() {

		logger.info("Method :nationalityList starts");

		List<DropDownModel> nationalityList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "nationalityList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nationalityList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : nationalityList ends" + nationalityList);

		return nationalityList;
	}

	// countryList

	@SuppressWarnings("unchecked")
	public List<DropDownModel> countryList() {

		logger.info("Method :countryList starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "countryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : countryList ends" + countryList);

		return countryList;
	}

	// getPatientSateList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPatientSateList(String id) {

		logger.info("Method : getPatientSateList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_country='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "getStateList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getPatientSateList ends");
		return response;
	}

	// districtList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> districtList(String id) {

		logger.info("Method : districtList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_state='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "district").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : districtList ends");
		return response;
	}

	// restAddPatient
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addPatient(HISPatientRestModel patientRestModel) {
		logger.info("Method : Rest Add Patient Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateAddPatientParameter.addPatientParam(patientRestModel);

			if (patientRestModel.getPatientId() != null && patientRestModel.getPatientId() != "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
						.setParameter("actionType", "modiFyPatient").setParameter("actionValue", values)
						.getResultList();

				resp.setCode("Success");
				resp.setMessage("Patient Details Modified Successfully !");
				resp.setBody(x);

			} else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
						.setParameter("actionType", "addPatient").setParameter("actionValue", values).getResultList();
				System.out.println("Last inserted id is coming==============> " + x);

				resp.setCode("Success");
				resp.setMessage("Patient Details Registered Successfully !");
				resp.setBody(x);
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

		logger.info("Method :  Rest Add Patient Dao ends" + response);

		return response;
	}

	// viewPatient
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPatient(String orgName, String orgDivision, String fromDate, String toDate,
			String from) {
		logger.info("Method : viewPatient Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_fromDate='" + fromDate + "'"
					+ ",@p_toDate='" + toDate + "', @p_from = '" + from + "';";
			System.out.println("value for patient view=================> " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "viewPatients").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : viewPatient Dao ends" + resp);
		return resp;

	}

	// editPatient
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editPatient(String id, String organization, String orgDivision) {
		logger.info("Method : editPatient Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_bookingId='" + id + "', @p_org='" + organization + "', @p_orgDiv='" + orgDivision
					+ "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "bookingDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
			resp.setCode("failed");
		}
		logger.info("Method : editPatient Dao ends" + resp);
		return resp;

	}

	// deletePatient
	public ResponseEntity<JsonResponse<Object>> deletePatient(String id) {

		logger.info("Method : deletePatient Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_patientId='" + id + "';";
			logger.info("it is for delete==========" + values);
			em.createNamedStoredProcedureQuery("his_patient_routines").setParameter("actionType", "deletePatient")
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

		logger.info("Method : deletePatient Dao ends");
		return response;
	}

	// getPatientList

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HISPatientRestModel>>> getPatientList(String id) {
		logger.info("Method : getPatientList Dao starts");

		List<HISPatientRestModel> itemNameList = new ArrayList<HISPatientRestModel>();
		JsonResponse<List<HISPatientRestModel>> resp = new JsonResponse<List<HISPatientRestModel>>();
		String value = "SET @p_searchValue='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "getPatient").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				HISPatientRestModel viewDemo = new HISPatientRestModel(m[0], m[1]);

				itemNameList.add(viewDemo);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<HISPatientRestModel>>> response = new ResponseEntity<JsonResponse<List<HISPatientRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getPatientList Dao ends" + resp);
		return response;
	}

	// getDepartmentList

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getDepartmentList() {

		logger.info("Method :getDepartmentList starts");

		List<DropDownModel> departmentList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "departmentList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departmentList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getDepartmentList ends" + departmentList);

		return departmentList;
	}

	// getDoctorList

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<DropDownModel>>> getDoctorList(String id) {
	 * 
	 * logger.info("Method : getDoctorList starts"); List<DropDownModel> doctorList
	 * = new ArrayList<DropDownModel>();
	 * 
	 * JsonResponse<List<DropDownModel>> resp = new
	 * JsonResponse<List<DropDownModel>>();
	 * 
	 * String value = "SET @p_department='" + id + "';";
	 * 
	 * logger.info(value);
	 * 
	 * try { List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("his_patient_routines")
	 * .setParameter("actionType", "getDoctorList").setParameter("actionValue",
	 * value).getResultList(); for (Object[] m : x) { DropDownModel dropDownModel =
	 * new DropDownModel(m[0], m[1]); doctorList.add(dropDownModel);
	 * 
	 * }
	 * 
	 * resp.setBody(doctorList);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * ResponseEntity<JsonResponse<List<DropDownModel>>> response = new
	 * ResponseEntity<JsonResponse<List<DropDownModel>>>( resp, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : getDoctorList ends"); return response;
	 * 
	 * }
	 */

	// feeList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> feeList(String id, String dateOfAppoints) {

		logger.info("Method : feeList starts");
		List<DropDownModel> feeList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_docId='" + id + "', @p_dateOfAppoints='" + dateOfAppoints + "';";

		logger.info("Doctor ID for feeList=====> " + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "feeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0].toString(), m[1]);
				feeList.add(dropDownModel);
			}

			resp.setBody(feeList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : feeList ends");
		return response;
	}

	// getPatientInvoiceDetails

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPatientInvoiceDetails(String pId) {
		logger.info("Method : getPatientInvoiceDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_pId='" + pId + "';";
			System.out.println("value for getPatientInvoiceDetails  view=================> " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "downloadInvoice").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : getPatientInvoiceDetails Dao ends" + resp);
		return resp;

	}

	// cityList

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> cityList(String id) {

		logger.info("Method : cityList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_dist='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "cityList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : cityList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> departmentList(String id, String org, String orgDiv) {

		logger.info("Method : department list starts");
		List<DropDownModel> departmentList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @P_BOOKFROM_TYPE='" + id + "',@P_ORG='" + org + "',@P_ORG_DIV='" + orgDiv + "';";

		System.out.println("Value for department list=====================> " + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("product_details")
					.setParameter("actionType", "getSubCatDetails").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				departmentList.add(dropDownModel);

			}

			resp.setBody(departmentList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : department list ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> patientRegistrationWithTestList(RegsPatientModel data) {
		logger.info("Method : patientRegistrationWithTestList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(data);
			
			List<Object[]> x = null;
			if(data.getType().equals("RECEPTION")) {
				x = em.createNamedStoredProcedureQuery("product_details")
						.setParameter("actionType", "regsWithTestByRecp").setParameter("actionValue", values).getResultList();
			} else {
				x = em.createNamedStoredProcedureQuery("product_details")
						.setParameter("actionType", "patientRegsWithTest").setParameter("actionValue", values).getResultList();
			}

			

			resp.setCode("success");
			resp.setMessage("Patient registered successfully !");
			resp.setBody(x);

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

		logger.info("Method :  patientRegistrationWithTestList Dao ends" + response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> patientDetailsWithTestList(String id,String type,String org,String orgDiv) {
		logger.info("Method : patientRegistrationWithTestList Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String values = "SET @p_testId='" + id + "', @p_type='" + type + "', @p_org='" + org + "', @p_orgDiv='" + orgDiv + "'";
			
			System.out.println(values);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("product_details")
					.setParameter("actionType", "patientDtlsWithTest").setParameter("actionValue", values).getResultList();
			
			if(x.size() > 0) {
				resp.setCode("success");
				resp.setMessage("Patient details found");
				resp.setBody(x);
			} else {
				resp.setCode("failed");
				resp.setMessage("Patient details not found");
				resp.setBody(null);
			}
			
			
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		
		logger.info("Method :  patientRegistrationWithTestList Dao ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> paymentProceed(DropDownModel data) {
		logger.info("Method : paymentProceed Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(data);
			System.out.println(values);

			em.createNamedStoredProcedureQuery("product_details")
					.setParameter("actionType", "paymentProceed").setParameter("actionValue", values).execute();

			resp.setCode("success");
			resp.setMessage("Payment proceeded successfully !");

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

		logger.info("Method :  paymentProceed Dao ends");
		return response;
	}

}
