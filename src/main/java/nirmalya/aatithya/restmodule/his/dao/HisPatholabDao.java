package nirmalya.aatithya.restmodule.his.dao;

import java.util.ArrayList;
import java.util.List;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateAmbulanceBookingParameter;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateHisPatholabParameter;
import nirmalya.aatithya.restmodule.his.model.HisPatholabRestModel;
import nirmalya.aatithya.restmodule.his.model.RestHisBookingAmbulanceModel;

@Repository
public class HisPatholabDao {
	Logger logger = LoggerFactory.getLogger(HisPatholabDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewIPDOPDlist(String orgName, String orgDivision, String userId, String type) {
		logger.info("Method : viewIPDOPDlist Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_UserId='" + userId
					+ "', @p_type='" + type + "'";
			System.out.println("value for patient view=================> " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patholab_routines")
					.setParameter("actionType", "viewIPDOPDlist").setParameter("actionValue", value).getResultList();

			if (x.size() > 0) {
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fetched successfully");
			} else {
				resp.setBody(null);
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : viewIPDOPDlist Dao ends" + resp);
		return resp;

	}

	// viewPatient
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewbloodtestName(String orgName, String orgDivision, String userId, String id,
			String type) {
		logger.info("Method : viewbloodtestName Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_UserId='" + userId
					+ "',@p_id='" + id + "' ";
			System.out.println("value for patient view=================> " + value);

			String actionName = "";

			if (type != null && type != "" && type.equals("PATH")) {
				actionName = "viewbloodtestName";
			} else {
				actionName = "getAllTestList";
			}

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patholab_routines")
					.setParameter("actionType", actionName).setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : viewbloodtestName Dao ends" + resp);
		return resp;

	}

	public ResponseEntity<JsonResponse<HisPatholabRestModel>> saveSampleTests(HisPatholabRestModel saveSampleTests) {

		logger.info("Method : saveSampleTests starts");

		JsonResponse<HisPatholabRestModel> resp = new JsonResponse<HisPatholabRestModel>();

		try {
			String values = GenerateHisPatholabParameter.getSaveBloodTests(saveSampleTests);

			if (saveSampleTests.getBloddSampleId() == null || saveSampleTests.getBloddSampleId() == "") {
				em.createNamedStoredProcedureQuery("his_patholab_routines").setParameter("actionType", "addSampleTests")
						.setParameter("actionValue", values).execute();

			} else {
				logger.info("ADDDDDDDDDDDDDDDDDDS#" + values);
				em.createNamedStoredProcedureQuery("his_patholab_routines")
						.setParameter("actionType", "modifySampleTests").setParameter("actionValue", values).execute();

			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		ResponseEntity<JsonResponse<HisPatholabRestModel>> response = new ResponseEntity<JsonResponse<HisPatholabRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveSampleTests ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> saveTestResult(DropDownModel data) {
		logger.info("Method : saveTestResult starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		if(data.getCode() != null) {
			data.setCode(null);
		}

		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(data);
			
			em.createNamedStoredProcedureQuery("his_patholab_routines").setParameter("actionType", "addRadiologyReport")
					.setParameter("actionValue", values).execute();
			
			resp.setCode("success");
			resp.setMessage("Result uploaded successfully");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveTestResult ends");
		return response;
	}
	
	public ResponseEntity<JsonResponse<Object>> approveTestResult(List<DropDownModel> data) {
		logger.info("Method : approveTestResult starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String values = "SET @p_dataset='"+data+"', @p_userId='" + data.get(0).getCreatedBy() + "';";
			
			em.createNamedStoredProcedureQuery("his_patholab_routines").setParameter("actionType", "approveTestReport")
			.setParameter("actionValue", values).execute();
			
			resp.setCode("success");
			resp.setMessage("Result approved successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("failed");
				resp.setMessage(err[1]);
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : approveTestResult ends");
		return response;
	}

	// view TestNames

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTestNameList(String orgName, String orgDivision, String userId, String id) {
		logger.info("Method : getTestNameList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_UserId='" + userId
					+ "',@p_id='" + id + "'";
			System.out.println("value for patient view=================> " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patholab_routines")
					.setParameter("actionType", "getTestNameList").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : getTestNameList Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewTestnmaelist(String orgName, String orgDivision, String userId, String id) {
		logger.info("Method : viewTestnmaelist Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_UserId='" + userId
					+ "',@p_id='" + id + "' ";
			System.out.println("value for patient view=================> " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patholab_routines")
					.setParameter("actionType", "viewTestnmaelist").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : viewTestnmaelist Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getLabTestReportDataDao(String orgName, String orgDivision, String userId, String id) {
		logger.info("Method : getLabTestReportDataDao Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_UserId='" + userId
					+ "',@p_id='" + id + "' ";
			System.out.println("value for patient view=================> " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patholab_routines")
					.setParameter("actionType", "getLabTestReport").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}

		logger.info("Method : getLabTestReportDataDao Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> testInvoice(String orgName, String orgDivision, String userId, String id) {
		logger.info("Method : testInvoice Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_UserId='" + userId
					+ "',@p_id='" + id + "' ";
			System.out.println("value for patient view=================> " + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patholab_routines")
					.setParameter("actionType", "testInvoice").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : testInvoice Dao ends" + resp);
		return resp;

	}

	public ResponseEntity<JsonResponse<List<HisPatholabRestModel>>> savetestNames(
			List<HisPatholabRestModel> savetestNames) {

		logger.info("Method : savetestNames starts");

		JsonResponse<List<HisPatholabRestModel>> resp = new JsonResponse<List<HisPatholabRestModel>>();
		List<HisPatholabRestModel> listData = new ArrayList<HisPatholabRestModel>();

		String values = "SET @p_dataset='" + savetestNames.get(0).getBloodDataList() + "';";

		System.out.println(values);

		try {

//			String values = GenerateHisPatholabParameter.getsavetestNames(savetestNames);
//			logger.info("ADDDDDDDDDDDDDDDDDDS#" + values);
//
			if (savetestNames.get(0).getBloddSampleId() == null || savetestNames.get(0).getBloddSampleId() == "") {
				em.createNamedStoredProcedureQuery("his_patholab_routines").setParameter("actionType", "addTestNames")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("his_patholab_routines")
						.setParameter("actionType", "modifyTestNames").setParameter("actionValue", values).execute();

			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<HisPatholabRestModel>>> response = new ResponseEntity<JsonResponse<List<HisPatholabRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : savetestNames ends");
		return response;
	}

	public ResponseEntity<JsonResponse<List<HisPatholabRestModel>>> saveActualValue(
			List<HisPatholabRestModel> saveActualValue) {

		logger.info("Method : saveActualValue starts");

		JsonResponse<List<HisPatholabRestModel>> resp = new JsonResponse<List<HisPatholabRestModel>>();
		List<HisPatholabRestModel> listData = new ArrayList<HisPatholabRestModel>();
		String values = "SET @p_dataset='" + saveActualValue.get(0).getBloodDataList() + "';";
		System.out.println(values);
		try {

			if (saveActualValue.get(0).getBloddSampleId() == null || saveActualValue.get(0).getBloddSampleId() == "") {
				em.createNamedStoredProcedureQuery("his_patholab_routines").setParameter("actionType", "addResults")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("his_patholab_routines").setParameter("actionType", "modifyREsults")
						.setParameter("actionValue", values).execute();

			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<HisPatholabRestModel>>> response = new ResponseEntity<JsonResponse<List<HisPatholabRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveActualValue ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> patientreportpdf(String id, String org, String orgDiv) {
		logger.info("Method : patientreportpdf Dao startssssssssssssssssssssss" + id);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_id='" + id + "',@p_org='" + org + "',@p_div='" + orgDiv + "';";

			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_patholab_routines")
					.setParameter("actionType", "patientreportpdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("resp******" + resp);
		logger.info("Method : patientreportpdf Dao ends");
		return resp;

	}
}
