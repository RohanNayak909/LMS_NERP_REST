package nirmalya.aatithya.restmodule.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class HotelConfigurationDao {
	Logger logger = LoggerFactory.getLogger(HotelConfigurationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	public ResponseEntity<JsonResponse<Object>> saveRatetypesData(String hotelData) {
		logger.info("method: saveRatetypesData Starts");
		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			JSONObject jsonObj = new JSONObject(hotelData);

			String ratetypesId = jsonObj.optString("ratetypesId");
			String propertyId = jsonObj.optString("propertyId");
			String ratetypes = jsonObj.optString("ratetypes");
			String roomtypes = jsonObj.optString("roomtypes");
			String ratepernight = jsonObj.optString("ratepernight");
			String charge = jsonObj.optString("charge");
			String bedtypesId = jsonObj.optString("bedtypesId");
			String createdBy = jsonObj.optString("userId");
			String org = jsonObj.optString("org");
			String orgDiv = jsonObj.optString("orgDiv");

			String value = "SET @p_ratetypesId='" + ratetypesId + "', @p_propertyId='" + propertyId + "', "
					+ "@p_ratetypes='" + ratetypes + "', @p_roomtypes='" + roomtypes + "', @p_ratepernight='"
					+ ratepernight + "', " + "@p_charge='" + charge + "'," + "@p_bedtypesId='" + bedtypesId + "',"
					+ "" + "@p_createdBy='" + createdBy + "'," + "@p_org='" + org + "'," + "@p_orgDiv='" + orgDiv + "';";
			
			System.out.println("value::::::"+value);
			
			em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
					.setParameter("actionType", "saveRatetypes").setParameter("actionValue", value).execute();
			resp.setMessage("Data saved successfully!");
			resp.setCode("Success");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in save-hotel-details: ", e);
			resp.setMessage("Error saving hotel details!");
			resp.setCode("Error");
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
		logger.info("method: saveRatetypesData Ends");
		return response;
	}

	// edit
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editRatetype(String id, String orgName, String orgDivision) {
		logger.info("Method : editRatetype Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_propertyId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
					.setParameter("actionType", "editHotel").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editRatetype Dao ends" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getRoomTypeData(String id, String orgName, String orgDivision) {
		logger.info("Method : getRoomTypeData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
					.setParameter("actionType", "getRoomTypeData").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRoomTypeData Dao ends" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getBedData(String id, String orgName, String orgDivision,String propertyId) {
		logger.info("Method : getBedData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @id='" + id + "',@propertyId='" + propertyId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
					.setParameter("actionType", "getBedData").setParameter("actionValue", value).getResultList();
			
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getBedData Dao ends" + resp);
		return resp;
	}

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRatetype(String orgName, String orgDivision, String id) {
		logger.info("Method : viewRatetype Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
			logger.info("Query: " + value);
			List<Object[]> result = em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
					.setParameter("actionType", "viewRatetype").setParameter("actionValue", value).getResultList();

			resp.setBody(result); // Send full list
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("error");
			resp.setMessage("Failed to fetch data");
		}
		logger.info("Method : viewRatetype Dao ends");
		return resp;
	}

	public ResponseEntity<JsonResponse<Object>> saveService(String studentData) {
		logger.info("method: saveService Starts");

		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			JSONObject jsonObj = new JSONObject(studentData);
			String serviceId = jsonObj.optString("serviceId");
			String locationId = jsonObj.optString("locationId");
			String serviceName = jsonObj.optString("serviceName");
			String roomTypeService = jsonObj.optString("roomTypeService");
			String availability = jsonObj.optString("availability");
			String startTime = jsonObj.optString("startTime");
			String endTime = jsonObj.optString("endTime");
			String parentCategory = jsonObj.optString("parentCategory");
			String subcategory = jsonObj.optString("subcategory");


			String value = "SET @serviceId='" + serviceId + "', " +
		               "@locationId='" + locationId + "', " +
		               "@serviceName='" + serviceName + "', " +
		               "@roomTypeService='" + roomTypeService + "', " +
		               "@availability='" + availability + "', " +
		               "@startTime='" + startTime + "', " +
		               "@parentCategory='" + parentCategory + "', " +
		               "@subcategory='" + subcategory + "', " +
		               "@endTime='" + endTime + "';";

			if (serviceId == null || serviceId.isEmpty()) {
				em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
						.setParameter("actionType", "saveServiceDetails").setParameter("actionValue", value).execute();

				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			} else {
			
				System.out.println("For Modify Service ---->>>>"+value);
				em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
						.setParameter("actionType", "modifyServiceType").setParameter("actionValue", value).execute();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in save-service-details: ", e);
			resp.setMessage("Error saving service details!");
			resp.setCode("Error");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: saveService Ends");
		return response;
	}

	// edit
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editServiceType(String id, String orgName, String orgDivision) {
		logger.info("Method : editServiceType Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_locId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
					.setParameter("actionType", "editServiceType").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editServiceType Dao ends");
		return resp;
	}

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewService(String orgName, String orgDivision,String id) {
		logger.info("Method : viewService Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
					.setParameter("actionType", "viewService").setParameter("actionValue", value)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");

		} catch (Exception e) {

			e.printStackTrace();

		}

		logger.info("Method : viewService Dao ends" + resp);

		return resp;

	}
	//=====================TAXTYPE DETAILS =========================================
	// Save 
		public ResponseEntity<JsonResponse<Object>> saveTaxDetails(String studentData) {
			logger.info("method: saveTaxDetails Starts");

			JsonResponse<Object> resp = new JsonResponse<>();

			try {
				JSONObject jsonObj = new JSONObject(studentData);
				System.out.println("value:::::::" + studentData);
				String taxtypeId = jsonObj.optString("taxtypeId");
				String locationId = jsonObj.optString("locationId");
				String service_Name = jsonObj.optString("service_Name");
				String tax = jsonObj.optString("tax");
				String hSN_Code = jsonObj.optString("hSN_Code");

				String value = "SET @taxtypeId='" + taxtypeId + "', " + "@locationId='" + locationId + "', "
						+ " @service_Name='" + service_Name + "', " + "@tax='" + tax + "', " + "@hSN_Code='" + hSN_Code
						+ "';";

				System.out.println("=====================>" + value);
				if (taxtypeId == null || taxtypeId.isEmpty()) {
					em.createNamedStoredProcedureQuery("hotel_configuration_Routines").setParameter("actionType", "saveTaxDetails")
							.setParameter("actionValue", value).execute();

					resp.setMessage("Taxtype saved successfully!");
					resp.setCode("Success");
				} else {
					em.createNamedStoredProcedureQuery("hotel_configuration_Routines").setParameter("actionType", "modifyTaxType")
							.setParameter("actionValue", value).execute();

					resp.setMessage("Taxtype modified successfully!");
					resp.setCode("Success");
				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error in save-taxtype-details: ", e);
				resp.setMessage("Error saving taxtype details!");
				resp.setCode("Error");
			}

			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

			logger.info("method: saveTaxDetails Ends");
			return response;
		}

		//edit 
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> editTaxType( String taxtypeId , String orgName, String orgDivision) {
				logger.info("Method : editTaxType Dao starts");

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					  String value = "SET @taxtypeId='" +taxtypeId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println(value);
					
					List<Object[]> list = em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
							.setParameter("actionType", "editTaxType").setParameter("actionValue", value).getResultList();
					resp.setBody(list);
					resp.setCode("Success");
					resp.setMessage("Data fetched Successfully");
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : editTaxType Dao ends");
				return resp;

			}

		
		// view 
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewTaxtype(String orgName, String orgDivision) {
			logger.info("Method : viewTaxtype Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				logger.info("values for Application view====================" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
						.setParameter("actionType", "viewTaxtype").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fetched successfully");
			} catch (Exception e) {

				e.printStackTrace();
			}
			logger.info("Method : viewTaxtype Dao ends" + resp);
			return resp;
		}
		//===========Restaurant Food Details===========
		// SaveFood detail-----------
				public ResponseEntity<JsonResponse<Object>> saveRestaurantFoodDetails(String resturantFoodLists) {
					logger.info("method: saveRestaurantFoodDetails Starts");

					JsonResponse<Object> resp = new JsonResponse<>();

					try {
						JSONObject jsonObj = new JSONObject(resturantFoodLists);
						System.out.println("value:::::::" + resturantFoodLists);
						String item_Code = jsonObj.optString("item_Code");
						String locationId = jsonObj.optString("locationId");
						String item_Name = jsonObj.optString("item_Name");
						String quantity = jsonObj.optString("quantity");
						String uom = jsonObj.optString("uom");
						String cost = jsonObj.optString("cost");
						String type = jsonObj.optString("type");
						String availability = jsonObj.optString("availability");

						String value = "SET @item_Code='" + item_Code + "', " + "@locationId='" + locationId + "', "
								+ " @item_Name='" + item_Name + "'," + "@quantity='" + quantity + "',"
										+ "" + "@uom='" + uom + "', "
										+ "" + "@cost='" + cost + "',"
												+ "" + "@type='" + type + "', " + "@availability='" + availability
								+ "';";

						System.out.println("=====================>" + value);
						if (item_Code == null || item_Code.isEmpty()) {
							em.createNamedStoredProcedureQuery("hotel_configuration_Routines").setParameter("actionType", "saveRestaurantFoodDetails")
									.setParameter("actionValue", value).execute();

							resp.setMessage("Food saved successfully!");
							resp.setCode("Success");
						} else {
							em.createNamedStoredProcedureQuery("hotel_configuration_Routines").setParameter("actionType", "modifyRestaurantFoodType")
									.setParameter("actionValue", value).execute();

							resp.setMessage("Food modified successfully!");
							resp.setCode("Success");
						}

					} catch (Exception e) {
						e.printStackTrace();
						logger.error("Error in save-restaurantfood-details: ", e);
						resp.setMessage("Error saving restaurant details!");
						resp.setCode("Error");
					}

					ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

					logger.info("method: saveRestaurantFoodDetails Ends");
					return response;
				}

				//editFood detail-----------

					@SuppressWarnings("unchecked")
					public JsonResponse<Object> editRestaurantFoodDetails( String item_Code , String orgName, String orgDivision) {
						logger.info("Method : editRestaurantFoodDetails Dao starts");

						JsonResponse<Object> resp = new JsonResponse<Object>();

						try {
							  String value = "SET @item_Code='" +item_Code + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
							System.out.println(value);
							
							List<Object[]> list = em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
									.setParameter("actionType", "editRestaurantFoodDetails").setParameter("actionValue", value).getResultList();
							resp.setBody(list);
							resp.setCode("Success");
							resp.setMessage("Data fetched Successfully");
						} catch (Exception e) {
							e.printStackTrace();
						}
						logger.info("Method : editRestaurantFoodDetails Dao ends");
						return resp;

					}

				
				// viewFood detail-----------
				@SuppressWarnings("unchecked")
				public JsonResponse<Object> viewRestaurantFoodDetails(String orgName, String orgDivision) {
					logger.info("Method : viewRestaurantFoodDetails Dao starts");
					JsonResponse<Object> resp = new JsonResponse<Object>();
					try {
						String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
						logger.info("values for Application view====================" + value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
								.setParameter("actionType", "viewRestaurantFoodDetails").setParameter("actionValue", value).getResultList();
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data Fetched successfully");
					} catch (Exception e) {

						e.printStackTrace();
					}
					logger.info("Method : viewRestaurantFoodDetails Dao ends" + resp);
					return resp;
				}
	//=============================================================================================
				// SaveTime detail-----------
				public ResponseEntity<JsonResponse<Object>> saveRestaurantFoodTime(String resturantFoodTimeLists) {
					logger.info("method: saveRestaurantFoodTime Starts");

					JsonResponse<Object> resp = new JsonResponse<>();
					

					try {
						JSONObject jsonObj = new JSONObject(resturantFoodTimeLists);
						System.out.println("value:::::::" + resturantFoodTimeLists);
						String tableId = jsonObj.optString("tableId");
						String locationId = jsonObj.optString("locationId");
						String availabilityfoodtime = jsonObj.optString("availabilityfoodtime");
						String startTime = jsonObj.optString("startTime");
						String endTime = jsonObj.optString("endTime");
						

						String value = "SET @tableId='" + tableId + "', " + "@locationId='" + locationId + "', "
								+ " @availabilityfoodtime='" + availabilityfoodtime + "'," + "@startTime='" + startTime + "',  " + "@endTime='" + endTime
								+ "';";

						System.out.println("=====================>" + value);
						if (tableId == null || tableId.isEmpty()) {
							em.createNamedStoredProcedureQuery("hotel_configuration_Routines").setParameter("actionType", "saveRestaurantFoodTime")
									.setParameter("actionValue", value).execute();

							resp.setMessage("Food saved successfully!");
							resp.setCode("Success");
						} else {
							em.createNamedStoredProcedureQuery("hotel_configuration_Routines").setParameter("actionType", "modifyRestaurantFoodTime")
									.setParameter("actionValue", value).execute();

							resp.setMessage("FoodTime modified successfully!");
							resp.setCode("Success");
						}

					} catch (Exception e) {
						e.printStackTrace();
						logger.error("Error in save-restaurantfoodtime-details: ", e);
						resp.setMessage("Error saving restaurant time details!");
						resp.setCode("Error");
					}

					ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

					logger.info("method: saveRestaurantFoodTime Ends");
					return response;
				}
				// viewTime detail-----------
				@SuppressWarnings("unchecked")
				public JsonResponse<Object> viewRestaurantFoodTime(String orgName, String orgDivision) {
					logger.info("Method : viewRestaurantFoodTime Dao starts");
					JsonResponse<Object> resp = new JsonResponse<Object>();
					try {
						String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
						logger.info("values for Application view====================" + value);
						List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
								.setParameter("actionType", "viewRestaurantFoodTime").setParameter("actionValue", value).getResultList();
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data Fetched successfully");
					} catch (Exception e) {

						e.printStackTrace();
					}
					logger.info("Method : viewRestaurantFoodTime Dao ends" + resp);
					return resp;
				}
				//editTime detail-----------

				@SuppressWarnings("unchecked")
				public JsonResponse<Object> editRestaurantTimeDetails( String tableId , String orgName, String orgDivision) {
					logger.info("Method : editRestaurantTimeDetails Dao starts");

					JsonResponse<Object> resp = new JsonResponse<Object>();

					try {
						  String value = "SET @tableId='" +tableId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
						System.out.println(value);
						
						List<Object[]> list = em.createNamedStoredProcedureQuery("hotel_configuration_Routines")
								.setParameter("actionType", "editRestaurantTimeDetails").setParameter("actionValue", value).getResultList();
						resp.setBody(list);
						resp.setCode("Success");
						resp.setMessage("Data fetched Successfully");
					} catch (Exception e) {
						e.printStackTrace();
					}
					logger.info("Method : editRestaurantTimeDetails Dao ends");
					return resp;

				}

				
		

		//get Category
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getProductCategoryList(String org, String orgDiv) {
		logger.info("Method : getProductCategoryList starts");

		List<DropDownModel> modeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getProductCategory").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				modeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getProductCategoryList ends");
		return modeList;
	}
	
	//get subCatagory _----------------------->>>>>
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> subcategory(String org, String orgDiv, String id) {
		logger.info("Method : subcategory starts");

		List<DropDownModel> stateList = new ArrayList<>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<>();

		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_id='" + id + "';";
		logger.info("Query parameters: " + value);

		try {
			List<Object[]> resultList = em.createNamedStoredProcedureQuery("productMasterRoutines")
					.setParameter("actionType", "getSubcategory").setParameter("actionValue", value).getResultList();

			for (Object[] result : resultList) {
				DropDownModel dropDownModel = new DropDownModel(result[0].toString(), result[1].toString());
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);
			resp.setMessage("success");
			resp.setCode(null);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Failed to fetch parent categories");
			resp.setCode("500");
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<>(resp, HttpStatus.OK);

		logger.info("Method : subcategory ends");
		return response;
	}

}
