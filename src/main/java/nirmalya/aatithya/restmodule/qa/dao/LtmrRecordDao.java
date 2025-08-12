package nirmalya.aatithya.restmodule.qa.dao;

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
import nirmalya.aatithya.restmodule.common.CommonUsed;
import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateMicroTestingParameter;
import nirmalya.aatithya.restmodule.qa.model.LtmrRecordModel;
import nirmalya.aatithya.restmodule.qa.model.RtmrRecordModel;

@Repository
public class LtmrRecordDao {
	Logger logger = LoggerFactory.getLogger(LtmrRecordDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<LtmrRecordModel>>> saveLtmrData(
			List<LtmrRecordModel> ltmrRecordModel) {

		logger.info("Method : saveRtmrData starts");

		JsonResponse<List<LtmrRecordModel>> resp = new JsonResponse<List<LtmrRecordModel>>();
		List<LtmrRecordModel> listData = new ArrayList<LtmrRecordModel>();
		String values = GenerateMicroTestingParameter.getLtmrParam(ltmrRecordModel);
		try {
			if (ltmrRecordModel.get(0).getLtmrId() == null
					|| ltmrRecordModel.get(0).getLtmrId() == "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.LTMR_ROUTINES)
						.setParameter("actionType", "saveLtmrData").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {
						LtmrRecordModel dropDownModel = new LtmrRecordModel(m[0], m[1], null,null);
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.LTMR_ROUTINES)
						.setParameter("actionType", "modifyLtmrData").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {
						LtmrRecordModel dropDownModel = new LtmrRecordModel(m[0], m[1], null,null);
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
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
		ResponseEntity<JsonResponse<List<LtmrRecordModel>>> response = new ResponseEntity<JsonResponse<List<LtmrRecordModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveLtmrData ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewLtmrData(String orgName, String orgDivision, String type) {
		logger.info("Method : viewLtmrData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_type='" + type + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.LTMR_ROUTINES)
					.setParameter("actionType", "viewLtmrData").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewLtmrData Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse <Object> editLtmrData(String ltmrId,String orgName, String orgDiv) {
		logger.info("Method : editLtmrData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_ltmrId='" + ltmrId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.LTMR_ROUTINES, "editLtmrData", value, em);
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				/*
				 * resp.setCode("500"); resp.setMessage(e.getMessage());
				 */
				e.printStackTrace();
				CommonUsed.getErrorDetails(resp, e, serverDao);
			}
		logger.info("Method : editLtmrData Dao ends");
		return resp;

	}
	

	
		
	@SuppressWarnings("unchecked")
	public JsonResponse <Object> deleteLtmrdata(String ltmrId,String orgName, String orgDiv) {
		logger.info("Method : deleteRtmrdata Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_ltmrId='" + ltmrId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value"+value);
			
		 em.createNamedStoredProcedureQuery(ProcedureNameConstants.LTMR_ROUTINES).setParameter("actionType", "deleteLtmrdata")
			.setParameter("actionValue", value).execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			CommonUsed.getErrorDetails(resp, e, serverDao);
		}

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("200");
		}
		logger.info("Method : deleteLtmrdata Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveLtmrdata(String ltmrId,String orgName,String orgDiv) {
		logger.info("Method : approveLtmrdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_ltmrId='" + ltmrId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.LTMR_ROUTINES, "approveLtmrdata", value, em);
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Approved successfully");
			} catch (Exception e) {
				resp.setCode("500");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : approveLtmrdata Dao ends");
		return resp;

	}
	

	// pdf.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> pdfLtmrPdf(String id, String orgName, String orgDivision) {
		logger.info("Method : pdfLtmrPdf Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.LTMR_ROUTINES)
					.setParameter("actionType", "pdfLtmrPdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : pdfLtmrPdf Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}
	
}
