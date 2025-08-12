package nirmalya.aatithya.restmodule.hotel.dao;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class FrontdeskDao {
	Logger logger = LoggerFactory.getLogger(FrontdeskDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveCorporateData(String corporateData) {
		logger.info("method: saveCorporateData Starts");

		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			JSONObject jsonObj = new JSONObject(corporateData);

			String custId = jsonObj.optString("custId");
			String custType = jsonObj.optString("custType");
			String guestType = jsonObj.optString("guestType");
			String name = jsonObj.optString("name");
			String fullName = jsonObj.optString("fullName");
			String fName = jsonObj.optString("fName");
			String lName = jsonObj.optString("lName");
			String finalName = jsonObj.optString("finalName");
			String tax = jsonObj.optString("tax");
			String email = jsonObj.optString("email");
			String phone = jsonObj.optString("phone");
			String address1 = jsonObj.optString("address1");
			String address2 = jsonObj.optString("address2");
			String country = jsonObj.optString("country");
			String state = jsonObj.optString("state");
			String city = jsonObj.optString("city");
			String postalCode = jsonObj.optString("postalCode");
			String corporate = jsonObj.optString("corporate");
			String idProof = jsonObj.optString("idProof");
			String empId = jsonObj.optString("empId");
			String nextReminder = jsonObj.optString("nextReminder");
			String pf = jsonObj.optString("pf");
			String status = jsonObj.optString("status");
			String idName = jsonObj.optString("photoName");
			String userId = jsonObj.optString("userId");
			String orgName = jsonObj.optString("orgName");
			String orgDivision = jsonObj.optString("orgDivision");

			String value = "";
			if ("Corporate".equalsIgnoreCase(guestType)) {

				value = "SET @custId='" + custId + "', @custName='" + name + "' ,@custCompName='" + name + "', "
						+ "@custDisplayName='" + name + "', @custType='" + custType + "', @custEmail='" + email + "', "
						+ "@custMobile='" + phone + "', @custStreet1='" + address1 + "', @custStreet2='" + address2
						+ "'," + "@custCountry='" + country + "',@custState='" + state + "',@custCity='" + city
						+ "',@custZip='" + postalCode + "',@custStatus='" + status + "',@custFirstName='" + null
						+ "',@custLastName='" + null + "'," + "@custGst='" + null + "',@custPaymentTerms='" + pf
						+ "',@idProof='" + null + "',@idName='" + null + "',@paymentReminder='" + nextReminder + "',"
						+ "@empId='" + null + "',@userId='" + userId + "',@orgName='" + orgName + "',@orgDivision='"
						+ orgDivision + "';";

			} else if ("Corporate Guest".equalsIgnoreCase(guestType)) {

				value = "SET @custId='" + custId + "', @custName='" + fullName + "' ,@custCompName='" + corporate
						+ "', " + "@custDisplayName='" + fullName + "', @custType='" + custType + "', @custEmail='"
						+ email + "', " + "@custMobile='" + phone + "', @custStreet1='" + address1 + "', @custStreet2='"
						+ address2 + "'," + "@custCountry='" + country + "',@custState='" + state + "',@custCity='"
						+ city + "',@custZip='" + postalCode + "',@custStatus='" + status + "',@custFirstName='" + fName
						+ "',@custLastName='" + lName + "'," + "@custGst='" + null + "',@custPaymentTerms='" + null
						+ "',@idProof='" + idProof + "',@idName='" + idName + "',@paymentReminder='" + null + "',"
						+ "@empId='" + empId + "',@userId='" + userId + "',@orgName='" + orgName + "',@orgDivision='"
						+ orgDivision + "';";

			} else if ("Other Guest".equalsIgnoreCase(guestType)) {

				value = "SET @custId='" + custId + "', @custName='" + fullName + "' ,@custCompName='" + fullName + "', "
						+ "@custDisplayName='" + fullName + "', @custType='" + custType + "', @custEmail='" + email
						+ "', " + "@custMobile='" + phone + "', @custStreet1='" + address1 + "', @custStreet2='"
						+ address2 + "'," + "@custCountry='" + country + "',@custState='" + state + "',@custCity='"
						+ city + "',@custZip='" + postalCode + "',@custStatus='" + status + "',@custFirstName='" + fName
						+ "',@custLastName='" + lName + "'," + "@custGst='" + null + "',@custPaymentTerms='" + null
						+ "',@idProof='" + idProof + "',@idName='" + idName + "',@paymentReminder='" + null + "',"
						+ "@empId='" + null + "',@userId='" + userId + "',@custOrgName='" + orgName
						+ "',@custOrgDivision='" + orgDivision + "';";

			}

			System.out.println("calling hotel_frontdesk_routine");
			if (custId == null || custId.isEmpty()) {
				em.createNamedStoredProcedureQuery("hotel_frontdesk_routine").setParameter("actionType", "saveCustomerDetails")
						.setParameter("actionValue", value).execute();

				resp.setMessage("CorporateData saved successfully!");
				resp.setCode("Success");
			} else {
				em.createNamedStoredProcedureQuery("hotel_frontdesk_routine").setParameter("actionType", "modifyCustomerDetails")
						.setParameter("actionValue", value).execute();

				resp.setMessage("CorporateData modified successfully!");
				resp.setCode("Success");
			}
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in saveCorporateData ", e);
			resp.setMessage("Error saveCorporateData");
			resp.setCode("Error");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: saveCorporateData Ends");
		return response;
	}

	// countryList
	@SuppressWarnings("unchecked")
	public List<DropDownModel> countryList() {

		logger.info("Method :countryList starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_frontdesk_routine")
					.setParameter("actionType", "countryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : countryList ends" + countryList);

		return countryList;
	}

	// countryList
	@SuppressWarnings("unchecked")
	public List<DropDownModel> roomList() {

		logger.info("Method :roomList starts");

		List<DropDownModel> roomList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_frontdesk_routine")
					.setParameter("actionType", "roomList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				roomList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : roomList ends" + roomList);

		return roomList;
	}

	// View CorporateDetails ->>
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewCorporate(String orgName, String orgDivision, String type) {
		logger.info("Method : viewCorporate Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_guestType='" + type + "';";

			logger.info("values for Petient view====================" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_frontdesk_routine")
					.setParameter("actionType", "viewCorporateDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewCorporate Dao ends" + resp);
		return resp;
	}

	// Edit CorporateDetails -->>>>>>>
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editCorporateDetails(String id) {
		logger.info("Method : editCorporateDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_custId='" + id + "'";

			logger.info("values for Application edit====================" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_frontdesk_routine")
					.setParameter("actionType", "editCorporateDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editCorporateDetails Dao ends" + resp);
		return resp;
	}

	// Reservation Tab's Dao Start Here --->>>>

	public ResponseEntity<JsonResponse<Object>> saveReservation(String reservationdata) {
		logger.info("method: saveReservation Starts");

		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			JSONObject jsonObj = new JSONObject(reservationdata);

			String bookingId = jsonObj.optString("bookingId");
			String customerId = jsonObj.optString("customerId");
			String guestType = jsonObj.optString("guestType");
			String mobileNo = jsonObj.optString("mobileNo");
			String custName = jsonObj.optString("custName");
			String noofRooms = jsonObj.optString("noofRooms");
			String noofAdults = jsonObj.optString("noofAdults");
			String noofChildren = jsonObj.optString("noofChildren");
			String noOfNights = jsonObj.optString("noOfNights");
			String reservationType = jsonObj.optString("reservationType");
			String roomTypeData = jsonObj.optString("roomTypeData");
			String reservationRemarks = jsonObj.optString("reservationRemarks");
			String totalAmount = jsonObj.optString("totalAmount");
			String advanceAmount = jsonObj.optString("advanceAmount");
			String source = jsonObj.optString("source");
			String status = jsonObj.optString("status");
			String idProofType = jsonObj.optString("idProofType");
			String idProofNumber = jsonObj.optString("idProofNumber");

			String value = "SET " + "@bookingId='" + bookingId + "', " + "@customerId='" + customerId + "', "
					+ "@noOfNights='" + noOfNights + "', " + "@reservationType='" + reservationType + "', " + "@guestType='"
					+ guestType + "', " + "@mobileNo='" + mobileNo + "', " + "@custName='" + custName + "', "
					+ "@roomTypeData='" + roomTypeData + "', " + "@noofRooms='" + noofRooms + "', " + "@noofAdults='"
					+ noofAdults + "', " + "@noofChildren='" + noofChildren + "', " + "@totalAmount='" + totalAmount
					+ "', " + "@advanceAmount='" + advanceAmount + "', " + "@source='" + source + "', " + "@status='"
					+ status + "'," +"@reservationRemarks='"  + reservationRemarks + "'," +"@idProofType='"  + idProofType + "'," +"@idProofNumber='"  + idProofNumber + "';";

			System.out.println("value:::::::::::::"+value);
			
			  em.createNamedStoredProcedureQuery("hotel_frontdesk_routine")
			 .setParameter("actionType",
			 "saveReservationHotel").setParameter("actionValue", value).execute();
			 

			resp.setMessage("Data saved successfully!");
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in saveReservationHotel: ", e);
			resp.setMessage("Error saveReservationHotel!");
			resp.setCode("Error");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: savedetails Ends");
		return response;
	}

	// view Application-Dao

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewReservation(String orgName, String orgDivision) {
		logger.info("Method : viewReservation Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_frontdesk_routine")
					.setParameter("actionType", "viewHotelReservation").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewReservation Dao ends" + resp);
		return resp;
	}

	// Edit Application -->>>>>>>

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editReservation(String bookingId) {

		logger.info("Method : editReservation Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_bookingId='" + bookingId + "'";

			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_frontdesk_routine")
					.setParameter("actionType", "editReservation").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {

			e.printStackTrace();
		}
		logger.info("Method : editReservation Dao ends" + resp);
		return resp;
	}

	// Check-in Data Handle Here ---->>>>
	// Save Check-in Data
	public ResponseEntity<JsonResponse<Object>> saveCheckinHotel(String checkinData) {
		logger.info("method: saveCheckinHotel Starts");

		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			JSONObject jsonObj = new JSONObject(checkinData);

			String checkinId = jsonObj.optString("checkinId");
			String bookingId = jsonObj.optString("bookingId");
			String customerId = jsonObj.optString("customerId");
			String chkReservationType = jsonObj.optString("chkReservationType");
			String guestType = jsonObj.optString("guestType");
			String chkContactName = jsonObj.optString("chkContactName");
			String chkContactPhone = jsonObj.optString("chkContactPhone");
			String chkIdProofType = jsonObj.optString("chkIdProofType");
			String chkIdProofNumber = jsonObj.optString("chkIdProofNumber");
			String chktotalAmt = jsonObj.optString("chktotalAmt");
			String chkPaidAmt = jsonObj.optString("chkPaidAmt");
			String chkPendingAmt = jsonObj.optString("chkPendingAmt");
			String paymentStatus = jsonObj.optString("paymentStatus");
			String paymentAmount = jsonObj.optString("paymentAmount");
			String checkedInBy = jsonObj.optString("checkedInBy");
			String checkInRemarks = jsonObj.optString("checkInRemarks");
			String roomDataList = jsonObj.optString("roomDataList");
			String status = jsonObj.optString("status");

			String value = "SET " +
				    "@checkinId='" + checkinId + "', " +
				    "@bookingId='" + bookingId + "', " +
				    "@customerId='" + customerId + "', " +
				    "@chkReservationType='" + chkReservationType + "', " +
				    "@guestType='" + guestType + "', " +
				    "@chkContactName='" + chkContactName + "', " +
				    "@chkContactPhone='" + chkContactPhone + "', " +
				    "@chkIdProofType='" + chkIdProofType + "', " +
				    "@chkIdProofNumber='" + chkIdProofNumber + "', " +
				    "@chktotalAmt='" + chktotalAmt + "', " +
				    "@chkPaidAmt='" + chkPaidAmt + "', " +
				    "@chkPendingAmt='" + chkPendingAmt + "', " +
				    "@paymentStatus='" + paymentStatus + "', " +
				    "@paymentAmount='" + paymentAmount + "', " +
				    "@checkedInBy='" + checkedInBy + "', " +
				    "@checkInRemarks='" + checkInRemarks + "', " +
				    "@checkStatus='" + status + "', " +
				    "@roomDataList='" + roomDataList + "'"; 
			
			System.out.println(value);


			// Call stored procedure for saving check-in data
			em.createNamedStoredProcedureQuery("hotel_frontdesk_routine").setParameter("actionType", "saveCheckinHotel")
					.setParameter("actionValue", value).execute();

			resp.setMessage("Check-in data saved successfully!");
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in saveCheckinHotel: ", e);
			resp.setMessage("Error in saving check-in data!");
			resp.setCode("Error");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: saveCheckinHotel Ends");
		return response;
	}

	// Room Number List
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getroomNumberOfLists() {
		logger.info("Method : getroomNumberOfLists Dao starts");

		List<DropDownModel> getroomNumberOfLists = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("hotel_frontdesk_routine")
					.setParameter("actionType", "getroomNumberOfLists").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getroomNumberOfLists.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getroomNumberOfLists Dao ends");

		return getroomNumberOfLists;
	}

}
