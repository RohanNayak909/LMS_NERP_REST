package nirmalya.aatithya.restmodule.his.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.his.GenerateOpdTimeSlotParameters;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;
import nirmalya.aatithya.restmodule.his.model.HISTreatmentRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class HISOPDTreatmentDao {

	Logger logger = LoggerFactory.getLogger(HISOPDTreatmentDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager entityManager;

	@Autowired
	private EnvironmentVaribles env;

	// Medicine Name AutoSearch

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HISTreatmentRestModel>>> getMedicineAutoList(String id) {
		logger.info("Method : getMedicineAutoList starts");

		List<HISTreatmentRestModel> itemNameList = new ArrayList<HISTreatmentRestModel>();
		JsonResponse<List<HISTreatmentRestModel>> resp = new JsonResponse<List<HISTreatmentRestModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		System.out.println("value for search------------" + value);

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "getMedicineAutoList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				HISTreatmentRestModel viewdemo = new HISTreatmentRestModel(m[0], m[1], m[2]);

				itemNameList.add(viewdemo);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<HISTreatmentRestModel>>> response = new ResponseEntity<JsonResponse<List<HISTreatmentRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getMedicineAutoList ends" + response);
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addOpdTreatment(HISTreatmentRestModel restData) {
		logger.info("Method : Rest addOpdTreatment   starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ADDDDDDID" + restData);

		if (validity)
			try {
				String values = GenerateOpdTimeSlotParameters.getOpdTreatmentParam(restData);

				if (restData.getTreatMentId() == null || restData.getTreatMentId() == "") {
					System.out.println("addddd in daooooooooooo" + restData);
					entityManager.createNamedStoredProcedureQuery("his_patient_routines")
							.setParameter("actionType", "addOpdTreatment").setParameter("actionValue", values)
							.execute();

				}

				else {
					System.out.println("MODIFYYYYYYY  in daooooooooo " + restData);
					System.out.println("VALUEEEEE" + values);
					entityManager.createNamedStoredProcedureQuery("his_patient_routines")
							.setParameter("actionType", "modifyOpdTreatment").setParameter("actionValue", values)
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

		logger.info("Method : Rest addOpdTreatment Dao ends" + response);
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<HISTreatmentRestModel>>> getTestAutoList(String id) {
		logger.info("Method : getTestAutoList starts");

		List<HISTreatmentRestModel> itemNameList = new ArrayList<HISTreatmentRestModel>();
		JsonResponse<List<HISTreatmentRestModel>> resp = new JsonResponse<List<HISTreatmentRestModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		System.out.println("value for search------------" + value);

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "getTestAutoList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				HISTreatmentRestModel viewdemo = new HISTreatmentRestModel(m[0], m[1], null, null);

				itemNameList.add(viewdemo);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<HISTreatmentRestModel>>> response = new ResponseEntity<JsonResponse<List<HISTreatmentRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getTestAutoList ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewOpdTreatmentLists(String orgName, String orgDivision, String userId,
			String fromDate, String toDate) {
		logger.info("Method : viewOpdTreatmentLists Dao starts...");
		String currentDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId
					+ "',@p_fromDate='" + (fromDate != null ? fromDate : currentDate) + "',@p_toDate='"
					+ (toDate != null ? toDate : currentDate) + "';";
			logger.info(value, "string value ===");
			List<Object[]> list = entityManager.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "viewOpdTreatment").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("viewOpdTimeSlots ==== " + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewOpdTreatmentLists Dao ends...");
		return resp;
	}

	public ResponseEntity<JsonResponse<Object>> addOpdTest(HISTreatmentRestModel restData) {
		logger.info("Method : Rest addOpdTest   starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ADDDDDDID" + restData);

		if (validity)
			try {
				String values = GenerateOpdTimeSlotParameters.getOpdTreatmentParam(restData);

				if (restData.getTreatMentId() == null || restData.getTreatMentId() == "") {
					System.out.println("addddd in daooooooooooo" + restData);
					entityManager.createNamedStoredProcedureQuery("his_patient_routines")
							.setParameter("actionType", "addOpdTest").setParameter("actionValue", values).execute();

				}

				else {
					System.out.println("MODIFYYYYYYY  in daooooooooo " + restData);
					System.out.println("VALUEEEEE" + values);
					entityManager.createNamedStoredProcedureQuery("his_patient_routines")
							.setParameter("actionType", "modifyOpdTest").setParameter("actionValue", values).execute();
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

		logger.info("Method : Rest addOpdTest Dao ends" + response);
		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewOpdTestLists(String orgName, String orgDivision, String userId, String fromDate,
			String toDate) {
		logger.info("Method : viewOpdTestLists Dao starts...");
		String currentDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId
					+ "',@p_fromDate='" + (fromDate != null ? fromDate : currentDate) + "',@p_toDate='"
					+ (toDate != null ? toDate : currentDate) + "';";
			logger.info(value, "string value ===");
			List<Object[]> list = entityManager.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "viewOpdTestLists").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("viewOpdTestLists ==== " + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewOpdTestLists Dao ends...");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getTypeList(String id) {

		logger.info("Method : getTypeList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_testGroup='" + id + "';";
		System.out.println(value);
		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "getTypeList").setParameter("actionValue", value).getResultList();
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

		logger.info("Method : getTypeList ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> typeList() {

		logger.info("Method :typeList starts");

		List<DropDownModel> typeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = entityManager.createNamedStoredProcedureQuery("his_patient_routines")
					.setParameter("actionType", "typeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				typeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : typeList ends" + typeList);

		return typeList;
	}
}
