package nirmalya.aatithya.restmodule.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class HelpDeskDao {

	Logger logger = LoggerFactory.getLogger(HelpDeskDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAllUserLists(String org, String orgDiv) {
		logger.info("Method : getAllUserLists starts");

		List<DropDownModel> getTicketTypeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_management_help_desk_routines")
					.setParameter("actionType", "getAllUserLists").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getTicketTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAllUserLists ends");
		return getTicketTypeList;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAllTicketById(String orgName, String orgDivision, String userid, String id) {
		logger.info("Method : viewAllTicketById Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userid='" + userid
					+ "',@p_id='" + id + "';";
			System.out.println("Value for viewAllTicketById----------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_management_help_desk_routines")
					.setParameter("actionType", "viewAllTicketById").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewAllTicketById Dao ends");

		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAllHotelsRoomDetails(String org, String orgDiv, String userId) {
		logger.info("Method : getAllHotelsRoomDetails starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_management_help_desk_routines")
					.setParameter("actionType", "getAllRoomDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2],m[3]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAllHotelsRoomDetails ends"+getCollectionList);
		return getCollectionList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAllServiceCategory(String org, String orgDiv) {
		logger.info("Method : getAllServiceCategory starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_management_help_desk_routines")
					.setParameter("actionType", "getAllServiceCategory").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAllServiceCategory ends");
		return getCollectionList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAllServiceCategoryAme(String org, String orgDiv) {
		logger.info("Method : getAllServiceCategoryAme starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_management_help_desk_routines")
					.setParameter("actionType", "getAllServiceCategoryAme").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAllServiceCategoryAme ends");
		return getCollectionList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAllItemList(String org, String orgDiv,String id) {
		logger.info("Method :getAllItemList starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();

		String value = "SET @p_org='" + org + "', @p_orgDiv='" + orgDiv + "',@p_cat_id='"+id+"';";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_management_help_desk_routines")
					.setParameter("actionType", "getAllItemList").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : getAllItemList ends"+itemList);
		return itemList;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllRoomDetails(String org,
			String orgDiv) {
		logger.info("Method : getAllRoomDetails starts");

		List<DropDownModel> getTicketCategoryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_management_help_desk_routines")
					.setParameter("actionType", "getAllRoomDetails").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2],m[3]);
				getTicketCategoryList.add(dropDownModel);
			}
			if (getTicketCategoryList.size() > 0) {
				Util.setJsonResponse(resp, getTicketCategoryList, ResponseStatus.success,
						ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, getTicketCategoryList, ResponseStatus.success,
						ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllRoomDetails ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveHotelService(String orgName, String orgDivision, String userId, String data) {
		logger.info("Method : dispatchMedicine Dao starts" + userId);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_createdBy='" + userId
					+ "', @p_data='" + data + "';";

			logger.info("value for items for services===================>"+value);
			 em.createNamedStoredProcedureQuery("hotel_management_help_desk_routines")
					.setParameter("actionType", "saveHotelService").setParameter("actionValue", value).execute();

			resp.setCode("success");
			resp.setMessage("Services Added Successfully");

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : saveHotelService Dao ends");
		return resp;
	}

	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAllServicesTypes(String orgName, String orgDivision, String userid, String id,String tabId) {
		logger.info("Method : viewAllServicesTypes Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userid='" + userid
					+ "',@p_id='" + id + "',@ptabId='" + tabId + "';";
			System.out.println("Value for viewAllServicesTypes----------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_management_help_desk_routines")
					.setParameter("actionType", "viewAllServicesTypes").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewAllServicesTypes Dao ends");

		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAllServicesTypesById(String orgName, String orgDivision, String userid, String id) {
		logger.info("Method : viewAllServicesTypesById Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userid='" + userid
					+ "',@p_id='" + id + "';";
			System.out.println("Value for viewAllServicesTypes----------------"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_management_help_desk_routines")
					.setParameter("actionType", "viewAllServicesTypesById").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);

			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewAllServicesTypesById Dao ends");

		return resp;

	}

}