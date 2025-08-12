package nirmalya.aatithya.restmodule.sales.dao;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestInvoiceDao {
	Logger logger = LoggerFactory.getLogger(RestInvoiceDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	@Autowired
	EnvironmentVaribles env;
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceNewInsertedId() {
		logger.info("Method : getInvoiceNewInsertedId starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("invoice_New_Routine")
					.setParameter("actionType", "getInvoiceNewInsertedId").setParameter("actionValue", "")
					.getResultList();

			Object jobId = x.get(0);
			logger.info("job id--------" + jobId);
			

			DropDownModel dropDownModel = new DropDownModel(jobId,null);

			itemList.add(dropDownModel);
			resp.setBody(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		//logger.info("response for getting job card id -------" + response);
		logger.info("Method : getInvoiceNewInsertedId ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse getChildData(String orgName, String orgDiv) {
		logger.info("Method : getChildData Dao starts");

		JsonResponse resp = new JsonResponse();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("invoice_New_Routine")
					.setParameter("actionType", "getChildData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		logger.info("Method : getChildData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
}
