package nirmalya.aatithya.restmodule.patient.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.patient.dao.PatientAppointmentDao;

@RestController
@RequestMapping("patient")
public class PatientAppointmentRestController {
	Logger logger = LoggerFactory.getLogger(PatientAppointmentRestController.class);
	@Autowired
	PatientAppointmentDao patientAppointmentDao;
	
	//ADD DISCHARGE DATA
		@PostMapping("rest-add-appointment-data")
		public JsonResponse<Object> addAppointmentData(@RequestBody Map<String, Object> jsonAppointmentData) {
			logger.info("Method : addAppointmentData starts");

			logger.info("Method : addAppointmentData ends");
			return patientAppointmentDao.addAppointmentData(jsonAppointmentData);
		}
   //GET ALL APPOINTMENT	
		@GetMapping("rest-get-all-appointment-data")
		public JsonResponse<Object> getAllAppointmentData(@RequestParam String orgName, @RequestParam String orgDiv,
				@RequestParam String userId) {
			logger.info("Method :getAllAppointmentData start");

			logger.info("Method :getAllAppointmentData ends");
			return patientAppointmentDao.getAllAppointmentData(orgName, orgDiv, userId);
		}
  //EDIT APPOINTMENT DATA
		@GetMapping("rest-get-appointment-data")
		public JsonResponse<Object> getTheAppointmentData(@RequestParam String orgName, @RequestParam String orgDiv,
				@RequestParam String userId,@RequestParam String bookingId,@RequestParam String bookingType) {
			logger.info("Method :getTheAppointmentData start");

			logger.info("Method :getTheAppointmentData ends");
			return patientAppointmentDao.getTheAppointmentData(orgName, orgDiv, userId,bookingId,bookingType);
		}
 //DELETE APPOINTMENT	
		@GetMapping("rest-delete-appointment")
		public JsonResponse<Object> deleteAppointment(@RequestParam String appointmentId,@RequestParam String orgName, @RequestParam String orgDiv ,@RequestParam String userId,@RequestParam String appointmentType) {
			logger.info("Method :deleteAppointment start");

			logger.info("Method :deleteAppointment ends");
			return patientAppointmentDao.deleteAppointment(appointmentId,orgName, orgDiv, userId,appointmentType);
		}
}
