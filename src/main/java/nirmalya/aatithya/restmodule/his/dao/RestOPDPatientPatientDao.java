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

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;

@Repository
public class RestOPDPatientPatientDao {

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	Logger logger = LoggerFactory.getLogger(RestOPDPatientPatientDao.class);

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HISPatientRestModel>>> getListingPatientList(String userId) {
		logger.info("Method : getListingPatientList starts");
		List<HISPatientRestModel> respList = new ArrayList<HISPatientRestModel>();
		JsonResponse<List<HISPatientRestModel>> resp = new JsonResponse<List<HISPatientRestModel>>();
		String value = "SET @p_userId='" + userId + "';";

		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("opd_patient_routines")
					.setParameter("actionType", "getPatientList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				HISPatientRestModel restPayroll = new HISPatientRestModel(m[0], m[1].toString(), m[2].toString(), m[3],m[4]);
				respList.add(restPayroll);

			}

			System.out.println("ROLEASSIGN" + respList);

			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getMessage());
		}

		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<HISPatientRestModel>>> response = new ResponseEntity<JsonResponse<List<HISPatientRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getListingPatientList ends");
		System.out.println("VIEWWWW" + response);
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HISPatientRestModel>>> getEmergencyPatient(String userId) {
		logger.info("Method : getEmergencyPatient starts");
		List<HISPatientRestModel> respList = new ArrayList<HISPatientRestModel>();
		JsonResponse<List<HISPatientRestModel>> resp = new JsonResponse<List<HISPatientRestModel>>();
		String value = "SET @p_userId='" + userId + "';";

		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("opd_patient_routines")
					.setParameter("actionType", "getEmergencyPatient").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				HISPatientRestModel restPayroll = new HISPatientRestModel(m[0], m[1].toString(), m[2].toString(), m[3],m[4]);
				respList.add(restPayroll);

			}

			System.out.println("ROLEASSIGN" + respList);

			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getMessage());
		}

		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<HISPatientRestModel>>> response = new ResponseEntity<JsonResponse<List<HISPatientRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getEmergencyPatient ends");
		System.out.println("VIEWWWW" + response);
		return response;

	}
}
