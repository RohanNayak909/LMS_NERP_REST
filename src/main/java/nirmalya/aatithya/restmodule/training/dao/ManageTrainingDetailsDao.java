package nirmalya.aatithya.restmodule.training.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.training.GenerateTrainingCategoryParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.training.model.ManageTrainingRestModel;
import nirmalya.aatithya.restmodule.util.StringUtil;

@Repository
public class ManageTrainingDetailsDao {
	Logger logger = LoggerFactory.getLogger(ManageTrainingDetailsDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * this method is used to add and modify category details
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ManageTrainingRestModel>> saveTrainingCategoryDao(
			ManageTrainingRestModel category) {
		logger.info("Method : saveTrainingCategory starts");

		Boolean validity = true;
		JsonResponse<ManageTrainingRestModel> resp = new JsonResponse<ManageTrainingRestModel>();
		resp.setMessage("");
		resp.setCode("");

		List<ManageTrainingRestModel> trainingDetails = new ArrayList<ManageTrainingRestModel>();

		if (StringUtil.isNull(category.getCategoryName())) {
			resp.setMessage("Category Name Required");
			validity = false;
		} else if (StringUtil.isNull(category.getCategoryDesc())) {
			resp.setMessage("Category Description Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateTrainingCategoryParameter.saveTrainingCategory(category);

				if (category.getCategoryId() != null && category.getCategoryId() != "") {
					List<Object[]> x = em.createNamedStoredProcedureQuery("manageTrainingRoutines")
							.setParameter("actionType", "modifyTrainingCategory").setParameter("actionValue", values)
							.getResultList();

					for (Object[] m : x) {

						ManageTrainingRestModel item = new ManageTrainingRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
								m[6], null, null);
						trainingDetails.add(item);
					}

				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("manageTrainingRoutines")
							.setParameter("actionType", "addTrainingCategory").setParameter("actionValue", values)
							.getResultList();

					for (Object[] m : x) {

						ManageTrainingRestModel item = new ManageTrainingRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
								m[6], null, null);
						trainingDetails.add(item);
					}

				}

				resp.setBody(trainingDetails.get(0));
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

		ResponseEntity<JsonResponse<ManageTrainingRestModel>> response = new ResponseEntity<JsonResponse<ManageTrainingRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveTrainingCategory ends");
		return response;
	}

	/*
	 * get all Training Category List in assign Modal
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageTrainingRestModel>>> getTrainingCategoryDataListModal(
			String organization, String orgDivision) {
		logger.info("Method : getTrainingCategoryDataListModal starts");

		JsonResponse<List<ManageTrainingRestModel>> resp = new JsonResponse<List<ManageTrainingRestModel>>();
		List<ManageTrainingRestModel> categoryDetails = new ArrayList<ManageTrainingRestModel>();

		try {
			if (!StringUtil.isNull(organization) && !StringUtil.isNull(orgDivision)) {
				String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("manageTrainingRoutines")
						.setParameter("actionType", "getTCategoryList").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					System.out.println(Arrays.toString(m));
					ManageTrainingRestModel item = new ManageTrainingRestModel(m[0], m[1], m[2], m[3], m[4], m[5],m[6],m[7]);
					categoryDetails.add(item);

				}
				resp.setBody(categoryDetails);
			} else {
				logger.info("Organization Details not present");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ManageTrainingRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageTrainingRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getTrainingCategoryDataListModal ends");
		return response;
	}

	/*
	 * Post method to save sub-category of training
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ManageTrainingRestModel>> saveTrainingSubCategory(
			ManageTrainingRestModel category) {
		logger.info("Method : saveTrainingSubCategory starts");

		Boolean validity = true;
		JsonResponse<ManageTrainingRestModel> resp = new JsonResponse<ManageTrainingRestModel>();
		resp.setMessage("");
		resp.setCode("");

		List<ManageTrainingRestModel> newLoc = new ArrayList<ManageTrainingRestModel>();

		if (category.getCategoryName() == null || category.getCategoryName() == "") {
			resp.setMessage("Sub-Category Name Required");
			validity = false;
		} else if (category.getCategoryDesc() == null || category.getCategoryDesc() == "") {
			resp.setMessage("Sub-Category Description Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateTrainingCategoryParameter.saveTrainingCategory(category);

				if (category.getCategoryId() != null && category.getCategoryId() != "") {

					List<Object[]> x = em.createNamedStoredProcedureQuery("manageTrainingRoutines")
							.setParameter("actionType", "modifyTrainingCategory").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ManageTrainingRestModel item = new ManageTrainingRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
								m[6], null, null);
						newLoc.add(item);
					}
				} else {

					List<Object[]> x = em.createNamedStoredProcedureQuery("manageTrainingRoutines")
							.setParameter("actionType", "addSubCategory").setParameter("actionValue", values)
							.getResultList();
					for (Object[] m : x) {

						ManageTrainingRestModel item = new ManageTrainingRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
								m[6], null, null);
						newLoc.add(item);
					}

				}

				resp.setBody(newLoc.get(0));
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

		ResponseEntity<JsonResponse<ManageTrainingRestModel>> response = new ResponseEntity<JsonResponse<ManageTrainingRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : saveTrainingSubCategory ends");
		return response;
	}

	/*
	 * This method to delete categories of training
	 * 
	 */
	public ResponseEntity<JsonResponse<Object>> deleteTrainingCategory(String id, String createdBy) {
		logger.info("Method : deleteTrainingCategory starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_TCat='" + id + "', @P_ModifiedBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("manageTrainingRoutines")
					.setParameter("actionType", "deleteTrainingCategory").setParameter("actionValue", value).execute();
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
		logger.info("Method : deleteTrainingCategory ends");
		return response;
	}

	/*
	 * This method is used to fetch categories data for edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<ManageTrainingRestModel>> getTrainingCategoryById(String id, String organization,
			String orgDivision) {
		logger.info("Method : getTrainingCategoryById starts");

		JsonResponse<ManageTrainingRestModel> resp = new JsonResponse<ManageTrainingRestModel>();
		List<ManageTrainingRestModel> data = new ArrayList<ManageTrainingRestModel>();

		if (!StringUtil.isNull(id)) {
			try {

				String value = "SET @P_TCategory='" + id + "',@P_organization='" + organization + "',@P_orgDivision='"
						+ orgDivision + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("manageTrainingRoutines")
						.setParameter("actionType", "getTrainingCategoryById").setParameter("actionValue", value)
						.getResultList();

				for (Object[] m : x) {
					ManageTrainingRestModel details = new ManageTrainingRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
							m[6], m[7], null);
					data.add(details);
				}

				resp.setBody(data.get(0));
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

		} else {
			logger.info("Please provide an ID to edit");
		}

		ResponseEntity<JsonResponse<ManageTrainingRestModel>> response = new ResponseEntity<JsonResponse<ManageTrainingRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getTrainingCategoryById ends");
		return response;
	}

	public ResponseEntity<JsonResponse<ManageTrainingRestModel>> saveTrainingStudyMaterial(
			List<ManageTrainingRestModel> category) {
		logger.info("Method : saveTrainingStudyMaterial starts");

		Boolean validity = true;
		JsonResponse<ManageTrainingRestModel> resp = new JsonResponse<ManageTrainingRestModel>();
		resp.setMessage("");
		resp.setCode("");

		if (StringUtil.isNull(category.get(0).getCategoryId())) {
			resp.setMessage("Category Id Required");
			validity = false;
		} else if (StringUtil.isNull(category.get(0).getTimeSpent())) {
			resp.setMessage("Total Time For Study Material Must Be Specified");
			validity = false;
		} else if (StringUtil.isNull(category.get(0).getStudyMaterialType())) {
			resp.setMessage("Study Material Type Required");
			validity = false;
		}
		if (validity)
			try {
				String values = GenerateTrainingCategoryParameter.saveTrainingStudyMaterial(category);
				em.createNamedStoredProcedureQuery("manageTrainingRoutines")
						.setParameter("actionType", "addStudyMaterial").setParameter("actionValue", values).execute();

				
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
		ResponseEntity<JsonResponse<ManageTrainingRestModel>> response = new ResponseEntity<JsonResponse<ManageTrainingRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : saveTrainingStudyMaterial ends");
		return response;
	}

}
