package nirmalya.aatithya.restmodule.production.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
@Repository
public class ManageProductionDao {
	Logger logger = LoggerFactory.getLogger(ManageProductionDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getSalesOrderData(String org, String orgDiv) {
		logger.info("Method : getSalesOrderData  starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
			System.out.println("VALUE FOR GET SALES ORDER----------->"+values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("Production_Routines")
					.setParameter("actionType", "getSalesOrderData").setParameter("actionValue", values).getResultList();

			if (x.size() > 0) {
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : getSalesOrderData ends");
		return response;
	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getBomDetails(String id, String sku, String org, String orgDiv) {
		logger.info("Method : getBomDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_skuId='" + sku + "', @p_quotId='"
					+ id + "';";
			System.out.println("Value For Getting the product details------------>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("Production_Routines")
					.setParameter("actionType", "getBomDetails").setParameter("actionValue", value).getResultList();

			if (x.size() > 0) {
				resp.setBody(x);
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(null);
				resp.setCode("failed");
				resp.setMessage("Data not found");
			}

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getBomDetails Dao ends");
		return resp;

	}
	
}
