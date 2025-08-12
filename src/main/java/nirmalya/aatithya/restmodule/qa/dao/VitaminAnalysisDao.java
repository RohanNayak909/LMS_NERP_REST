package nirmalya.aatithya.restmodule.qa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.CommonUsed;
import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.gatePass.GenerateGatePassEntryPAram;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateMicroTestingParameter;
import nirmalya.aatithya.restmodule.gatepass.model.RestGatePassDetailsModel;
import nirmalya.aatithya.restmodule.qa.model.RestVbarModel;
import nirmalya.aatithya.restmodule.qa.model.RestVitAModel;

import org.springframework.stereotype.Repository;

@Repository
public class VitaminAnalysisDao {
	Logger logger = LoggerFactory.getLogger(RestVbarDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestVitAModel>>> saveVitAData(List<RestVitAModel> vitamin) {
		logger.info("Method : saveVitAData starts");

		JsonResponse<List<RestVitAModel>> resp = new JsonResponse<List<RestVitAModel>>();
		List<RestVitAModel> listData = new ArrayList<RestVitAModel>();
		String values = GenerateMicroTestingParameter.getVitAParam(vitamin);
		System.out.println("valuess to add---"+values);
		try {

			System.out.println("values add >>>>>>>" + values);
			if (vitamin.get(0).getVitAId() == ""
					|| vitamin.get(0).getVitAId() == null) {

			em.createNamedStoredProcedureQuery(ProcedureNameConstants.VitA_ROUTINES)
						.setParameter("actionType", "saveVitAData").setParameter("actionValue", values).execute();
			}

			else {
				System.out.println("values edit >>>>>>>" + values);
				em.createNamedStoredProcedureQuery(ProcedureNameConstants.VitA_ROUTINES)
				.setParameter("actionType", "modifyVitAData").setParameter("actionValue", values).execute();

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
		ResponseEntity<JsonResponse<List<RestVitAModel>>> response = new ResponseEntity<JsonResponse<List<RestVitAModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveVitAData ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewVitAData(String orgName, String orgDivision) {
		logger.info("Method : viewVitAData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.VitA_ROUTINES)
					.setParameter("actionType", "viewVitAData").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewVitAData Dao ends");
		return resp;

	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editVitAData(String id, String orgName, String orgDivision) {
		logger.info("Method : editVitAData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_vitAId='" + id +"',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values>>>>>>>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.VitA_ROUTINES)
					.setParameter("actionType", "editVitAData").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					logger.info(" editVitAData ------ "+x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editVitAData Dao ends");
		return resp;

	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approvevitAata(String vitAData, String org, String orgDiv) {
		logger.info("Method : approvevitAata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_vitAData='" + vitAData + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values>>>>>>>" + value);
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.VitA_ROUTINES, "approvevitAata", value, em);
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Approved successfully");
			} catch (Exception e) {
				resp.setCode("500");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : approvevitAata Dao ends");
		return resp;
	}
	public JsonResponse<Object> deleteVitAData(String vitAData, String org, String orgDiv) {
		logger.info("Method : deleteVitAData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_vitAData='" + vitAData + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values>>>>>>>" + value);
			CommonUsed.executeQuery(ProcedureNameConstants.VitA_ROUTINES, "deleteVitAData", value, em);
			//resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Deleted successfully");
			} catch (Exception e) {
				resp.setCode("500");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : deleteVitAData Dao ends"+resp);
		return resp;
	}
//
	//pdf
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> vitAanalysisRecordPdf(String id,String orgName, String orgDivision) {
		logger.info("Method : vitAanalysisRecordPdf Dao startsssss" + id );

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_vitAId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.VitA_ROUTINES)
					.setParameter("actionType", "vitAanalysisRecordPdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("resp******" + resp);
		logger.info("Method : vitAanalysisRecordPdf Dao ends");
		return resp;

	}
}
