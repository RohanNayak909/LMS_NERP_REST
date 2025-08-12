package nirmalya.aatithya.restmodule.qa.dao;

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
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateQaRequestParam;
import nirmalya.aatithya.restmodule.qa.model.RestQaRequestModel;

@Repository
public class QaRequestedOfDao {
	
	Logger logger = LoggerFactory.getLogger(QaRequestedOfDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	// View
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getQaRequstForOfView(String orgName, String orgDivision) {
		logger.info("Method : getQaRequstForOfView Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "viewQaRequestOfData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getQaRequstForOfView Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	// Add
	
	public ResponseEntity<JsonResponse<RestQaRequestModel>> addOfQaData(
			RestQaRequestModel qc) {
		logger.info("Method : addOfQaData dao starts");
		//System.out.println(qc);
		JsonResponse<RestQaRequestModel> resp = new JsonResponse<RestQaRequestModel>();
		

		try {
			
			String value = GenerateQaRequestParam.getQaDtlsParamForOf(qc);
			//System.out.println("value===" + value);
			
			em.createNamedStoredProcedureQuery("qa_requested_routines")
			.setParameter("actionType", "addQaRequestOfData").setParameter("actionValue", value)
			.execute();
			
			resp.setCode("success");
			resp.setMessage("Result Submitted Successfully");
			
			
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<RestQaRequestModel>> response = new ResponseEntity<JsonResponse<RestQaRequestModel>>(
				resp, HttpStatus.CREATED);
		//System.out.println("response===" + response);
		logger.info("Method : addOfQaData dao ends");
		return response;

	}

}
