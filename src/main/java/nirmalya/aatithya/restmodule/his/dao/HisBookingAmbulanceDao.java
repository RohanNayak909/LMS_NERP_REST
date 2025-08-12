package nirmalya.aatithya.restmodule.his.dao;

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
import nirmalya.aatithya.restmodule.common.utils.his.GenerateAmbulanceBookingParameter;
import nirmalya.aatithya.restmodule.his.model.RestHisBookingAmbulanceModel;

@Repository
public class HisBookingAmbulanceDao {
	Logger logger = LoggerFactory.getLogger(HisBookingAmbulanceDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAmbulanceList(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewAmbulanceList Dao starts" + userId);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
					.setParameter("actionType", "viewAmbulanceList").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAmbulanceList Dao ends" + resp);
		return resp;
	}

//Add

//	@SuppressWarnings("unused")
//	public ResponseEntity<JsonResponse<List<RestHisBookingAmbulanceModel>>> addBookingAmbulance(
//			RestHisBookingAmbulanceModel addBookingAmbulance) {
//
//		logger.info("Method : addBookingAmbulance starts");
//
//		JsonResponse<List<RestHisBookingAmbulanceModel>> resp = new JsonResponse<List<RestHisBookingAmbulanceModel>>();
//		List<RestHisBookingAmbulanceModel> listData = new ArrayList<RestHisBookingAmbulanceModel>();
//
//		try {
//			String values = GenerateAmbulanceBookingParameter.getAddAmbulanceBooking(addBookingAmbulance);
//			logger.info("ADDDDDDDDDDDDDDDDDDS#" + values);
//
//			if (addBookingAmbulance.getBookingId() == null || addBookingAmbulance.getBookingId() == "") {
//				List resultList = em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
//						.setParameter("actionType", "addBookingAmbulance").setParameter("actionValue", values)
//						.getResultList();
//				System.out.println("Booking id is coming like this==================> "+resultList);
//			} else {
//				em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
//						.setParameter("actionType", "modifyBookingAmbulance").setParameter("actionValue", values)
//						.execute();
//			}
//
//		} catch (Exception e) {	
//			e.printStackTrace();
//			try {
//				String[] err = serverDao.errorProcedureCall(e);
//				resp.setCode(err[0]);
//				resp.setMessage(err[1]);
//
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		}
//		resp.setBody(listData);
//		ResponseEntity<JsonResponse<List<RestHisBookingAmbulanceModel>>> response = new ResponseEntity<JsonResponse<List<RestHisBookingAmbulanceModel>>>(
//				resp, HttpStatus.CREATED);
//		logger.info("Method : addBookingAmbulance ends");
//		return response;
//	}

	// addBookingAmbulance
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addBookingAmbulance(RestHisBookingAmbulanceModel addBookingAmbulance) {
		logger.info("Method : Rest Add Booking Ambulance Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateAmbulanceBookingParameter.getAddAmbulanceBooking(addBookingAmbulance);
			
			System.out.println(values);

			if (addBookingAmbulance.getBookingId() != null && addBookingAmbulance.getBookingId() != "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
						.setParameter("actionType", "modifyBookingAmbulance").setParameter("actionValue", values)
						.getResultList();

				resp.setCode("Success");
				resp.setMessage("Ambulance Booking Modified Successfully !");
				resp.setBody(x);

			} else {
				List<Object[]> x = em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
						.setParameter("actionType", "addBookingAmbulance").setParameter("actionValue", values)
						.getResultList();
				System.out.println("Last inserted id is coming==============> " + x);

				resp.setCode("Success");
				resp.setMessage("Ambulance Booked Successfully !");
				resp.setBody(x);
			}

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method :  Rest Add Booking Ambulance Dao ends" + response);

		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewAmbulanceBookingList(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewAmbulanceBookingList Dao starts" + userId);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";

			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
					.setParameter("actionType", "viewAmbulanceBookingList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewAmbulanceBookingList Dao ends" + resp);
		return resp;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteAmbulance(String id) {

		logger.info("Method : deleteAmbulance Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_bookingId='" + id + "';";
			logger.info("it is for delete==========" + values);
			em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
					.setParameter("actionType", "deleteAmbulance").setParameter("actionValue", values).execute();

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteAmbulance Dao ends");
		return response;
	}

	public JsonResponse<RestHisBookingAmbulanceModel> approvalStatus(String approval, String bookingId) {
		logger.info("Method : approvalStatus starts");

		RestHisBookingAmbulanceModel req = new RestHisBookingAmbulanceModel();
		JsonResponse<RestHisBookingAmbulanceModel> resp = new JsonResponse<RestHisBookingAmbulanceModel>();
		try {

			String value = "SET @p_approval='" + approval + "',@p_bookingId='" + bookingId + "';";
			System.out.println("value===" + value);
			em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
					.setParameter("actionType", "approvalStatus").setParameter("actionValue", value).execute();
			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Status changed successfully");

		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("resp===" + resp);
		logger.info("Method : approvalStatus ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAmbulanceTypeList() {

		logger.info("Method :getAmbulanceTypeList starts");

		List<DropDownModel> ambulanceTypeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
					.setParameter("actionType", "ambulanceTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ambulanceTypeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAmbulanceTypeList ends" + ambulanceTypeList);

		return ambulanceTypeList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAmbulanceRequirement() {

		logger.info("Method :getAmbulanceRequirement starts");

		List<DropDownModel> ambulanceRequirement = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
					.setParameter("actionType", "ambulanceRequirement").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				ambulanceRequirement.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getAmbulanceRequirement ends" + ambulanceRequirement);

		return ambulanceRequirement;
	}

	// cityList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> cityList(String id) {

		logger.info("Method : cityList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_dist='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
					.setParameter("actionType", "cityList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : cityList ends");
		return response;
	}

	public JsonResponse<RestHisBookingAmbulanceModel> approvePatientSts(String approval, String bookingId) {
		logger.info("Method : approvePatientSts starts");

		RestHisBookingAmbulanceModel req = new RestHisBookingAmbulanceModel();
		JsonResponse<RestHisBookingAmbulanceModel> resp = new JsonResponse<RestHisBookingAmbulanceModel>();
		try {

			String value = "SET @p_approval='" + approval + "',@p_bookingId='" + bookingId + "';";
			System.out.println("value===" + value);
			em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
					.setParameter("actionType", "approvePatientSts").setParameter("actionValue", value).execute();
			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Status changed successfully");

		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("resp===" + resp);
		logger.info("Method : approvePatientSts ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPaymentDetails(String orgName, String orgDivision, String id) {
		logger.info("Method : viewPaymentDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_bookingId='" + id + "';";
			System.out.println("value for paymentDetails==============> " + value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
					.setParameter("actionType", "viewPayemntDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(list);
			logger.info("hhhhhhhhhhhhhhhhh" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPaymentDetails Dao ends");
		return resp;

	}

	//getAllPatientList
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAllPatientList(String orgName,String orgDivision) {
		logger.info("Method :getAllPatientList starts");

		List<DropDownModel> getAllPatientList = new ArrayList<DropDownModel>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("getAllPatientList ==============> " + value);			
			List<Object[]> x = em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
					.setParameter("actionType", "getAllPatientList").setParameter("actionValue",value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAllPatientList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAllPatientList ends");
		return getAllPatientList;
	}
//getPatientDetailsById
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPatientDetailsById(String orgName, String orgDivision, String id) {
		logger.info("Method : getPatientDetailsById Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_patientId='" + id + "';";
			System.out.println("value for getPatientDetailsById==============> " + value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("his_ambulance_booking_routines")
					.setParameter("actionType", "getPatientDetailsById").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(list.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetch successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPatientDetailsById Dao ends");
		return resp;
		
	}
}
