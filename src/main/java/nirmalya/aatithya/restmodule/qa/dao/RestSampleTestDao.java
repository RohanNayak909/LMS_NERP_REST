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
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateSampleTestParam;
import nirmalya.aatithya.restmodule.qa.model.RestSampleTestModel;

@Repository
public class RestSampleTestDao {
	
	
	Logger logger = LoggerFactory.getLogger(RestSampleTestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qaTestDtls(String orgName, String orgDivision) {
		logger.info("Method : qaTestDtls Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "qaTestDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			 resp.setCode("Success");
			resp.setMessage("Requested Data");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : qaTestDtls Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> qaRequestDtls(String rid,String id, String orgName, String orgDivision) {
		logger.info("Method : qaRequestDtls Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET  @p_reqId='" + rid + "',@p_skuId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "qaChildDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("Success");
			resp.setMessage("Data Ok");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : qaRequestDtls Dao ends");
		System.out.println("resp**************chiiiild**************" + resp);
		return resp;

	}
	
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> testResultSubmit(RestSampleTestModel data) {
		logger.info("Method : testResultSubmit Dao startssssssssssssssssssssss");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = GenerateSampleTestParam.getSampleTestParam(data);
			System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "testResultSubmit").setParameter("actionValue", value).execute();
			resp.setCode("Success");
			resp.setMessage("Data Ok");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : testResultSubmit Dao ends");
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		System.out.println("resp**************chiiiild**************" + response);
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> testApproveSet(String id, String sku) {
		logger.info("Method : testApproveSet Dao startssssssssssssssssssssss");
		System.out.println("tttt"+id);
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET  @p_reqId='" + id + "',@p_sku='" + sku  + "';";
			System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "testApproveSet").setParameter("actionValue", value).execute();
			resp.setCode("Success");
			resp.setMessage("Data Ok");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : testApproveSet Dao ends");
		System.out.println("resp**************chiiiild**************" + resp);
		return resp;

	}
	
	
}
