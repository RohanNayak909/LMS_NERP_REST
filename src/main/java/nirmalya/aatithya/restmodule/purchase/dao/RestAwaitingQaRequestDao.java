package nirmalya.aatithya.restmodule.purchase.dao;

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
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateQaRequestParam;
import nirmalya.aatithya.restmodule.purchase.model.RestQaRequestModel;

@Repository
public class RestAwaitingQaRequestDao {
	
	Logger logger = LoggerFactory.getLogger(RestAwaitingQaRequestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> awaitingQaRequestData(String orgName, String orgDivision) {
		logger.info("Method : awaitingQaRequestData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("awaiting_quality_assurance_routines")
					.setParameter("actionType", "viewAwaitingQaData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : awaitingQaRequestData Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	// Save// Add
	
	public ResponseEntity<JsonResponse<List<RestQaRequestModel>>> saveQaRequest(
			List<RestQaRequestModel> data) {
		logger.info("Method : saveQaRequest dao starts");
		JsonResponse<List<RestQaRequestModel>> resp = new JsonResponse<List<RestQaRequestModel>>();
		List<RestQaRequestModel> listData = new ArrayList<RestQaRequestModel>();

		logger.info("=====>>>>>" + data);
		logger.info("listData=====>>>>>" + listData);

		try {
			String values = GenerateQaRequestParam.addQaRequestParam(data);
			 em.createNamedStoredProcedureQuery("awaiting_quality_assurance_routines")
						.setParameter("actionType", "saveQaRequest").setParameter("actionValue", values)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data Saved Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		logger.info("list Data IS======== "+listData);
		ResponseEntity<JsonResponse<List<RestQaRequestModel>>> response = new ResponseEntity<JsonResponse<List<RestQaRequestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : saveQaRequest dao ends");
		return response;
	}

}
