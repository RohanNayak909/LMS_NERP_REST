package nirmalya.aatithya.restmodule.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


	
	@Repository
	public class HotelBillingDao {

		Logger logger = LoggerFactory.getLogger(HotelBillingDao.class);

		@Autowired
		EntityManager em;

		@Autowired
		ServerDao serverDao;
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getAllCustDetails(String orgName, String orgDivision, String userid, String id) {
			logger.info("Method : getAllCustDetails Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {

				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userid='" + userid
						+ "',@p_id='" + id + "';";
				System.out.println("Value for getAllCustDetails----------------"+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_management_help_desk_routines")
						.setParameter("actionType", "getAllCustDetails").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x);

				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getAllCustDetails Dao ends");

			return resp;

		}
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getAllBalanceSheet(String id, String organization, String orgDivision) {
			logger.info("Method : getAllBalanceSheet Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_booking_id='" + id + "', @p_org='" + organization + "', @p_orgDiv='" + orgDivision
						+ "';";

				logger.info("vvvv" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_management_help_desk_routines")
						.setParameter("actionType", "getHotelBalanceSheet").setParameter("actionValue", value).getResultList();

				if (x.size() > 0) {
					resp.setBody(x);
					resp.setCode("success");
					resp.setMessage("Data Fetched Successfully");
				} else {
					resp.setBody(null);
					resp.setCode("failed");
					resp.setMessage("Data Not Found");
				}

			} catch (Exception e) {
				e.printStackTrace();
				resp.setMessage("Something Went Wrong !");
			}

			logger.info("Method : getAllBalanceSheet Dao ends");
			return resp;

		}

}
