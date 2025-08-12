package nirmalya.aatithya.restmodule.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

	
	
	@Repository
	public class RestaurantDao {

		Logger logger = LoggerFactory.getLogger(RestaurantDao.class);

		@Autowired
		EntityManager em;

		@Autowired
		ServerDao serverDao;
		
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getAllRestauranttItem(String org, String orgDiv) {
			logger.info("Method :getAllRestauranttItem starts");

			List<DropDownModel> itemList = new ArrayList<DropDownModel>();

			String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "';";
			System.out.println(value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_management_help_desk_routines")
						.setParameter("actionType", "getallItemRes").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					Object gstRate = "0.00";
					Object price = "0.00";

					if (m[5] != null) {
						gstRate = m[5].toString();
					}
					
					
					if (m[6] != null) {
						price = m[6].toString();
					}


					DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2], m[3], m[4], gstRate,price);
					itemList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("Method : getAllRestauranttItem ends"+itemList);
			return itemList;
		}
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> saveAllRestOrders(String orgName, String orgDivision, String userId, String data) {
			logger.info("Method : saveAllRestOrders Dao starts" + userId);

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_createdBy='" + userId
						+ "', @p_data='" + data + "';";

				logger.info("value for items for services===================>"+value);
				 em.createNamedStoredProcedureQuery("hotel_management_help_desk_routines")
						.setParameter("actionType", "saveAllRestOrders").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Services Added Successfully");

			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("Method : saveAllRestOrders Dao ends");
			return resp;
		}

}
