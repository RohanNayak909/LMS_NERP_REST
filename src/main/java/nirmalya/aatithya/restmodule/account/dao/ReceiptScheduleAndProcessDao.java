package nirmalya.aatithya.restmodule.account.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class ReceiptScheduleAndProcessDao {
	Logger logger = LoggerFactory.getLogger(ReceiptScheduleAndProcessDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> receiptSecheduleView(String orgName, String orgDivision, String id) {
		logger.info("Method : receiptSecheduleView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_orgName ='" + orgName + "',@p_orgDiv ='" + orgDivision + "';";
			logger.info("Values are: {}", value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receiptScheduleAndProcess_routines")
					.setParameter("actionType", "receiptScheduleView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : receiptSecheduleView Dao ends");
		return resp;
	}
	
	public JsonResponse<Object> receiptScheduleSave(String invId, String scheduleDate, String orgName, String orgDiv,
			String userId,String type) {
		logger.info("Method : receiptScheduleSave Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_idlist='" + invId + "',@p_scheduleDate='" + DateFormatter.getStringDate(scheduleDate) + "',@p_userId='" + userId
					+ "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_type='" + type + "';";
			System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("account_receiptScheduleAndProcess_routines").setParameter("actionType", "receiptScheduleSave")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Payment Scheduled Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : receiptScheduleSave Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> receivableProcessView(String orgName, String orgDivision ,String id,String fromdate,String todate) {
		logger.info("Method : receivableProcessView Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			
			String value = "SET @p_orgName ='" + orgName + "',@p_orgDiv ='" + orgDivision + "',@p_fromdate ='" + fromdate + "',@p_todate ='" + todate + "';";
			logger.info("Values are: {}"+ value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receiptScheduleAndProcess_routines")
					.setParameter("actionType", "receiptProcessView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : receivableProcessView Dao ends");
		return resp;
	}
}
