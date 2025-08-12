package nirmalya.aatithya.restmodule.his.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateOpdTimeSlotParameters;
import nirmalya.aatithya.restmodule.his.model.HISTreatmentRestModel;

@Repository
public class HISEmergenecyTreatmentDao {

	Logger logger = LoggerFactory.getLogger(HISEmergenecyTreatmentDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	@Autowired
	private EnvironmentVaribles env;
	
	public ResponseEntity<JsonResponse<Object>> addEmergencyTreatment(HISTreatmentRestModel restData) {
		logger.info("Method : Rest addEmergencyTreatment   starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ADDDDDDID" + restData);

		if (validity)
			try {
				String values = GenerateOpdTimeSlotParameters.getOpdTreatmentParam(restData);

				if (restData.getTreatMentId() == null || restData.getTreatMentId() == "") {
					System.out.println("addddd in daooooooooooo" + restData);
					entityManager.createNamedStoredProcedureQuery("his_patient_routines")
							.setParameter("actionType", "addEmergencyTreatment").setParameter("actionValue", values)
							.execute();

				}

				else {
					System.out.println("MODIFYYYYYYY  in daooooooooo " + restData);
					System.out.println("VALUEEEEE" + values);
					entityManager.createNamedStoredProcedureQuery("his_patient_routines")
							.setParameter("actionType", "modifyEmerTreatment").setParameter("actionValue", values)
							.execute();
				}
				System.out.println("VALLLLUUUUUUEEEEE" + values);
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

		logger.info("Method : Rest addEmergencyTreatment Dao ends" + response);
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEmergencyLists(String orgName, String orgDivision, String userId,
			String fromDate, String toDate) {
		logger.info("Method : viewEmergencyLists Dao starts...");
		String currentDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId
					+ "',@p_fromDate='" + (fromDate != null ? fromDate : currentDate) + "',@p_toDate='"
					+ (toDate != null ? toDate : currentDate) + "';";
			logger.info(value, "string value ===");
			List<Object[]> list = entityManager.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "viewEmergencyList").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("viewOpdTimeSlots ==== " + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewEmergencyLists Dao ends...");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> addEmergencyTest(HISTreatmentRestModel restData) {
		logger.info("Method : Rest addEmergencyTest   starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ADDDDDDID" + restData);

		if (validity)
			try {
				String values = GenerateOpdTimeSlotParameters.getOpdTreatmentParam(restData);

				if (restData.getTreatMentId() == null || restData.getTreatMentId() == "") {
					System.out.println("addddd in daooooooooooo" + restData);
					entityManager.createNamedStoredProcedureQuery("his_patient_routines")
							.setParameter("actionType", "addEmergencyTest").setParameter("actionValue", values).execute();

				}

				else {
					System.out.println("MODIFYYYYYYY  in daooooooooo " + restData);
					System.out.println("VALUEEEEE" + values);
					entityManager.createNamedStoredProcedureQuery("his_patient_routines")
							.setParameter("actionType", "modifyEmergencyTest").setParameter("actionValue", values).execute();
				}
				System.out.println("VALLLLUUUUUUEEEEE" + values);
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

		logger.info("Method : Rest addEmergencyTest Dao ends" + response);
		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEmergencyTestLists(String orgName, String orgDivision, String userId, String fromDate,
			String toDate) {
		logger.info("Method : viewEmergencyTestLists Dao starts...");
		String currentDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId
					+ "',@p_fromDate='" + (fromDate != null ? fromDate : currentDate) + "',@p_toDate='"
					+ (toDate != null ? toDate : currentDate) + "';";
			logger.info(value, "string value ===");
			List<Object[]> list = entityManager.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "viewEmergencyTestList").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("viewOpdTestLists ==== " + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewEmergencyTestLists Dao ends...");
		return resp;
	}
}
