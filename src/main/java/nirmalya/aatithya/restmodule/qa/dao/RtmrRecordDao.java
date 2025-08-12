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
import nirmalya.aatithya.restmodule.qa.model.RtmrRecordModel;

@Repository
public class RtmrRecordDao {

	Logger logger = LoggerFactory.getLogger(RtmrRecordDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RtmrRecordModel>>> saveRtmrData(List<RtmrRecordModel> rtmrRecordModel) {

		logger.info("Method : saveRtmrData starts");

		JsonResponse<List<RtmrRecordModel>> resp = new JsonResponse<List<RtmrRecordModel>>();
		List<RtmrRecordModel> listData = new ArrayList<RtmrRecordModel>();
		String values = GenerateMicroTestingParameter.getRtmrParam(rtmrRecordModel);
		System.out.println("values>>>" + values);

		try {
			if (rtmrRecordModel.get(0).getRtmrId() == null || rtmrRecordModel.get(0).getRtmrId() == "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.RTMR_ROUTINES)
						.setParameter("actionType", "saveRtmrData").setParameter("actionValue", values).getResultList();
				try {
					for (Object[] m : x) {
						RtmrRecordModel dropDownModel = new RtmrRecordModel(m[0], m[1], null, null);
						listData.add(dropDownModel);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.RTMR_ROUTINES)
						.setParameter("actionType", "modifyAllRtmrData").setParameter("actionValue", values)
						.getResultList();
				try {
					for (Object[] m : x) {
						RtmrRecordModel dropDownModel = new RtmrRecordModel(m[0], m[1], null, null);
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
		ResponseEntity<JsonResponse<List<RtmrRecordModel>>> response = new ResponseEntity<JsonResponse<List<RtmrRecordModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveRtmrData ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRtmrData(String orgName, String orgDivision, String type) {
		logger.info("Method : viewRtmrData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_type='" + type + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.RTMR_ROUTINES)
					.setParameter("actionType", "viewRtmrData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewRtmrData Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editRtmrData(String rtmrId, String orgName, String orgDiv) {
		logger.info("Method : editRtmrData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_rtmrId='" + rtmrId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.RTMR_ROUTINES, "editRtmrData", value,
					em);
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("500");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : editRtmrData Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteRtmrdata(String rtmrId, String orgName, String orgDiv) {
		logger.info("Method : deleteRtmrdata Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_rtmrId='" + rtmrId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value" + value);

			em.createNamedStoredProcedureQuery(ProcedureNameConstants.RTMR_ROUTINES)
					.setParameter("actionType", "deleteRtmrdata").setParameter("actionValue", value).execute();

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
		logger.info("Method : deleteRtmrdata Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveRtmrdata(String rtmrId, String orgName, String orgDiv) {
		logger.info("Method : approveRtmrdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_rtmrId='" + rtmrId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.RTMR_ROUTINES, "approveRtmrdata", value,
					em);
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Approved successfully");
		} catch (Exception e) {
			resp.setCode("500");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : approveRtmrdata Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// pdf.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> pdfRtmrPdf(String id, String orgName, String orgDivision) {
		logger.info("Method : pdfRtmrPdf Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.RTMR_ROUTINES)
					.setParameter("actionType", "pdfRtmrPdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : pdfRtmrPdf Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}

}
