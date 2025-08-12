package nirmalya.aatithya.restmodule.patient.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class PatientAppointmentDao {
	Logger logger = LoggerFactory.getLogger(PatientAppointmentDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	// ADD DISCHARGE DATA
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addAppointmentData(Map<String, Object> jsonAppointmentData) {
		logger.info("Method : addPatientDischargeData starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			System.out.println("All Appointment Data---------->" + jsonAppointmentData);
			String appointmentId = (String) jsonAppointmentData.get("appointmentId");
			String appointmentType = (String) jsonAppointmentData.get("appointmentType");
			System.out.println("Appointment Id---------->" + appointmentId);

			String actionType;
			String value;

			actionType = (appointmentId == null || appointmentId.isEmpty()) ? "addappointmentData"
					: "modifyAppointmentData";
			String selectedProduct = null;
			String ambulanceJsonData = null;

			if ("Ambulance".equalsIgnoreCase(appointmentType)) {
				List<Map<String, Object>> ambulanceList = (List<Map<String, Object>>) jsonAppointmentData
						.get("ambulanceData");
				if (ambulanceList != null && !ambulanceList.isEmpty()) {
					Map<String, Object> ambulanceItem = ambulanceList.get(0);
					ambulanceJsonData = objectMapper.writeValueAsString(ambulanceItem);
					selectedProduct = (String) ambulanceItem.get("item_name");
				}
			} else if ("OPD".equalsIgnoreCase(appointmentType)) {
				selectedProduct = (String) jsonAppointmentData.get("doctor");
			}
			String allAppointmentData = objectMapper.writeValueAsString(jsonAppointmentData);
			value = "SET @appointmentData='" + allAppointmentData + "', " + "@ambulanceJsonData='" + ambulanceJsonData
					+ "', " + "@p_selected_product='" + selectedProduct + "',@p_appointmenttype='" + appointmentType
					+ "';";

			logger.info("value" + value);

			Object result = em.createNamedStoredProcedureQuery("patient_appointment_routines")
					.setParameter("actionType", actionType).setParameter("actionValue", value).execute();

			resp.setBody(result.toString());
			resp.setCode("success");
			resp.setMessage(actionType.equals("addappointmentData") ? "Appointment Data added successfully."
					: "Appointment Data updated successfully.");
			logger.info(actionType.equals("addappointmentData") ? "Adding new Discharge Data."
					: "Updating Discharge for Discharge Id: " + appointmentId);

		} catch (Exception e) {
			resp.setCode("Failed");
			resp.setMessage("Error during Add Discharge Data operation.");
			logger.error("Error in addPatientDischargeData: ", e);
		}

		logger.info("Method : addPatientDischargeData ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllAppointmentData(String orgName, String orgDiv, String userId) {
		logger.info("Method : getAllAppointmentData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
			System.out.println("getAllAppointmentData========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("patient_appointment_routines")
					.setParameter("actionType", "getAllAppointmentData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllAppointmentData Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTheAppointmentData(String orgName, String orgDiv, String userId, String bookingId,
			String bookingType) {
		logger.info("Method : getTheAppointmentData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId
					+ "',@p_bookingId='" + bookingId + "',@p_bookingType='" + bookingType + "';";
			System.out.println("getAllAppointmentData========>" + value);
			logger.info("Alert Data Value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("patient_appointment_routines")
					.setParameter("actionType", "getTheAppointmentData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getTheAppointmentData Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteAppointment(String appointmentId, String orgName, String orgDiv, String userId,String appointmentType) {
		logger.info("Method : deleteAppointment Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_appointmentId='"
					+ appointmentId + "',@p_userId='" + userId + "',@p_appointmentType='"+appointmentType+"';";
			System.out.println("deleteAppointment========>" + value);

			List<String> x = em.createNamedStoredProcedureQuery("patient_appointment_routines")
					.setParameter("actionType", "delete-appointment").setParameter("actionValue", value)
					.getResultList();
			Object result = x.get(0);
			System.out.println("Class of result: " + result.getClass().getName());
			System.out.println("Result value: " + result);


			if (!x.isEmpty()) {
			    String message = x.get(0);
			    System.out.println("Message For Delete----------->" + message);

			    if (message.contains("not allowed")) {
			        resp.setCode("error");
			        resp.setMessage(message);
			    } else {
			        resp.setCode("success");
			        resp.setMessage(message);
			    }

			    resp.setBody(null);  
			} else {
			    resp.setCode("error");
			    resp.setMessage("No response received from stored procedure.");
			}


		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : deleteAppointment Dao ends" + resp);
		return resp;
	}

}
