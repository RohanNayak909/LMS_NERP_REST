package nirmalya.aatithya.restmodule.training.dao;

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
import nirmalya.aatithya.restmodule.common.utils.training.GenerateTrainingCategoryParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.training.model.ViewStudyMaterialsRestModel;

@Repository
public class ViewStudyMaterialsDao {

	Logger logger = LoggerFactory.getLogger(ViewStudyMaterialsDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EnvironmentVaribles env;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getEmployeeListDao(String organization, String orgDivision) {
		logger.info("Method : getEmployeeListDao starts");
		JsonResponse resp = new JsonResponse();
		String value = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("manageTrainingRoutines")
					.setParameter("actionType", "viewEmpList").setParameter("actionValue", value).getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("viewHrmsEmpPersonalDetails: " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getEmployeeListDao ends");
		return resp;
	}

	// get Training by category id

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ViewStudyMaterialsRestModel>>> getStudyMaterialByCat(String catId,
			String organization, String orgDivision) {
		logger.info("Method : getStudyMaterialByCat Dao starts");

		List<ViewStudyMaterialsRestModel> materialList = new ArrayList<ViewStudyMaterialsRestModel>();
		JsonResponse<List<ViewStudyMaterialsRestModel>> resp = new JsonResponse<List<ViewStudyMaterialsRestModel>>();
		try {

			String value = GenerateTrainingCategoryParameter.getCategory(catId);
			List<Object[]> x = em.createNamedStoredProcedureQuery("manageTrainingRoutines")
					.setParameter("actionType", "getStudyuMaterialByCat").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				ViewStudyMaterialsRestModel dropDownModel = new ViewStudyMaterialsRestModel(m[0], m[1], m[2], m[3],
						m[4], m[5], null);
				materialList.add(dropDownModel);
			}
			resp.setBody(materialList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ViewStudyMaterialsRestModel>>> response = new ResponseEntity<JsonResponse<List<ViewStudyMaterialsRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getStudyMaterialByCat Dao ends");
		return response;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getEmployeeDetailsList(String date1, String date2, String organization, String orgDivision) {
		logger.info("Method : getEmployeeListDao starts");

		String value = "SET @p_date1='" + date1 + "', @p_date2='" + date2 + "',@p_org='" + organization
				+ "',@p_orgDiv='" + orgDivision + "';";
		JsonResponse resp = new JsonResponse();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("manageTrainingRoutines")
					.setParameter("actionType", "getEmployeeByDt").setParameter("actionValue", value).getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEmployeeListDao ends");
		return resp;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getAssignedEmployeeDetails(String organization, String orgDivision) {
		logger.info("Method : getAssignedEmployeeDetails starts");

		String value = "SET @p_org='" + organization
				+ "',@p_orgDiv='" + orgDivision + "';";
		
		JsonResponse resp = new JsonResponse();
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("manageTrainingRoutines")
					.setParameter("actionType", "getAssignedEmployeeList").setParameter("actionValue", value).getResultList();

			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAssignedEmployeeDetails ends");
		return resp;
	}

	public ResponseEntity<JsonResponse<ViewStudyMaterialsRestModel>> assignStudyMaterialToEmpDao(
			List<ViewStudyMaterialsRestModel> allData) {
		logger.info("Method : assignStudyMaterialToEmpDao starts");

		Boolean validity = true;
		JsonResponse<ViewStudyMaterialsRestModel> resp = new JsonResponse<ViewStudyMaterialsRestModel>();

		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String values = GenerateTrainingCategoryParameter.saveTrainingOnDraft(allData);

				em.createNamedStoredProcedureQuery("manageTrainingRoutines")
						.setParameter("actionType", "postAssignedTraining").setParameter("actionValue", values)
						.execute();
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

		ResponseEntity<JsonResponse<ViewStudyMaterialsRestModel>> response = new ResponseEntity<JsonResponse<ViewStudyMaterialsRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : assignStudyMaterialToEmpDao ends");
		return response;
	}

	public ResponseEntity<JsonResponse<ViewStudyMaterialsRestModel>> scheduleStudyMaterialToEmpDao(
			List<ViewStudyMaterialsRestModel> allData) {
		logger.info("Method : scheduleStudyMaterialToEmpDao starts");

		Boolean validity = true;
		JsonResponse<ViewStudyMaterialsRestModel> resp = new JsonResponse<ViewStudyMaterialsRestModel>();

		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String values = GenerateTrainingCategoryParameter.saveScheduleTraining(allData);

				em.createNamedStoredProcedureQuery("manageTrainingRoutines")
						.setParameter("actionType", "postScheduledTraining").setParameter("actionValue", values)
						.execute();
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

		ResponseEntity<JsonResponse<ViewStudyMaterialsRestModel>> response = new ResponseEntity<JsonResponse<ViewStudyMaterialsRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : scheduleStudyMaterialToEmpDao ends");
		return response;
	}

}