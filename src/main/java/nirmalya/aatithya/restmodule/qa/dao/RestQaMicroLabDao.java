package nirmalya.aatithya.restmodule.qa.dao;

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

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateMicrobiologyLab;
import nirmalya.aatithya.restmodule.common.utils.qa.GeneratePcroCheckList;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.RestMicrobiologyLabratoryModel;
import nirmalya.aatithya.restmodule.qa.model.RestPcroCheckListModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestQaMicroLabDao {
	Logger logger = LoggerFactory.getLogger(RestQaMicroLabDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getMicroLabSlno(String orgName, String orgDivision) {
		logger.info("Method : getMicroLabSlno Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values---->>>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_microbiology_lab_routines")
					.setParameter("actionType", "getSlno").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getMicroLabSlno Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}
	
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMicrobiologyLabratoryModel>>> labTestID(String orgName, String orgDivision) {

	    JsonResponse<List<RestMicrobiologyLabratoryModel>> resp = new JsonResponse<List<RestMicrobiologyLabratoryModel>>();
	    List<RestMicrobiologyLabratoryModel> rs = new ArrayList<RestMicrobiologyLabratoryModel>();

	    try {
	        List<String> labIds = em.createNamedStoredProcedureQuery("qa_microbiology_lab_routines")
	                .setParameter("actionType", "getLabId")
	                .setParameter("actionValue", "")
	                .getResultList();

	        for (String labId : labIds) {
	            RestMicrobiologyLabratoryModel restPayroll = new RestMicrobiologyLabratoryModel(labId);
	            rs.add(restPayroll);
	        }

	        resp.setCode("Success");
	        resp.setMessage("Data Fetched Successfully");
	    } catch (Exception e) {
	        e.printStackTrace();
	        resp.setCode("Failed");
	        resp.setMessage(e.getMessage());
	    }

	    resp.setBody(rs);
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("MyResponseHeader", "MyValue");

	    ResponseEntity<JsonResponse<List<RestMicrobiologyLabratoryModel>>> response = new ResponseEntity<>(resp, responseHeaders, HttpStatus.CREATED);

	    logger.info("Method : labTestID ends" + response);
	    System.out.println(response);
	    return response;
	}

	
	// add 
	@SuppressWarnings("unchecked")
		public JsonResponse<Object> saveDataOne(List<RestMicrobiologyLabratoryModel> qc) {
			logger.info("Method : saveDataOne dao starts");
			System.out.println(qc);
			JsonResponse<Object> resp = new JsonResponse<Object>();

			String value = GenerateMicrobiologyLab.getSaveData(qc);
			System.out.println("value===" + value);
			System.out.println("Modify qc===" + qc.get(0).getLabId());
			try {

				if (qc.get(0).getLabId() != null && qc.get(0).getLabId() != "" && qc.get(0).getLabId() != "null") {

				
					 em.createNamedStoredProcedureQuery("qa_microbiology_lab_routines")
							.setParameter("actionType", "modifyLabTest").setParameter("actionValue", value).execute();
					
					
					resp.setCode("success");
					resp.setMessage("Data Modified successfully");

				} else {
					List<Object[]> result = em.createNamedStoredProcedureQuery("qa_microbiology_lab_routines")
							.setParameter("actionType", "addTestDetails").setParameter("actionValue", value).getResultList();
					resp.setBody(result.get(0));
					resp.setCode("success");
					resp.setMessage("Data Saved successfully");

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

			/*
			 * ResponseEntity<JsonResponse<List<RestMicrobiologyLabratoryModel>>> response =
			 * new ResponseEntity<JsonResponse<List<RestMicrobiologyLabratoryModel>>>( resp,
			 * HttpStatus.CREATED);
			 */
			 System.out.println("response===" + resp);
			logger.info("Method : saveDataOne dao ends");
			return resp;

		}
		
		
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getLabTestView(String orgName, String orgDivision) {
			logger.info("Method : getLabTestView Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values****************************" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_microbiology_lab_routines")
						.setParameter("actionType", "getLabTestView").setParameter("actionValue", value).getResultList();
				resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getLabTestView Dao ends");
			System.out.println("resp**************rrreessuulltt**************" + resp);
			return resp;

		}
		
		
		
		// editPcro
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> editLabTest(String id, String orgName, String orgDivision) {
			logger.info("Method : editLabTest Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_LabId='" + id + "';";
				System.out.println("values***" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_microbiology_lab_routines")
						.setParameter("actionType", "editLabView").setParameter("actionValue", value).getResultList();
				logger.info("test------"+x.toString());
				resp.setBody(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : editLabTest Dao ends");
			System.out.println("resp*" + resp);
			return resp;
		}
		
		
		// deletePcro
		public ResponseEntity<JsonResponse<Object>> deleteLabtest(String id, String orgName, String orgDivision) {
			logger.info("Method : deleteLabtest starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

				try {

					String value = "SET @p_LabId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("IDD---->" + value);
					em.createNamedStoredProcedureQuery("qa_microbiology_lab_routines")
							.setParameter("actionType", "deleteLabTest").setParameter("actionValue", value).execute();

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

			logger.info("Method : deleteLabtest ends");
			System.out.println("DELETEE" + response);
			return response;
		}
//
		//pdf
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> microLabPdf(String id,String orgName,String orgDivision) {
			logger.info("Method : microLabPdf Dao startsssss" + id );

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_LabId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				logger.info("values******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_microbiology_lab_routines")
						.setParameter("actionType", "pdfLabView").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("resp******" + resp);
			logger.info("Method : microLabPdf Dao ends");
			return resp;

		}
}
