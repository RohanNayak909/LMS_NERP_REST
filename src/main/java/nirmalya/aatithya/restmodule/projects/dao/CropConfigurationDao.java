package nirmalya.aatithya.restmodule.projects.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateManageProjectCategoryParameter;
import nirmalya.aatithya.restmodule.common.utils.projects.GenerateProjectCropParameter;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCategoryModel;
import nirmalya.aatithya.restmodule.projects.model.RestProjectCropModel;

@Repository
public class CropConfigurationDao {
	Logger logger = LoggerFactory.getLogger(CropConfigurationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// FOR PROJECT Crop DAO VIEW STARTS
	@SuppressWarnings("unchecked")

	public JsonResponse<Object> restviewCropDao(String userid, String org, String div) {

		logger.info("Method : restviewCrop Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("project_crop_routines")
					.setParameter("actionType", "viewCrop").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : restviewCrop Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}

	public ResponseEntity<JsonResponse<Object>> saveCropDao(RestProjectCropModel category) {
		logger.info("Method : saveCrop Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateProjectCropParameter.getProjectCropParam(category);
			logger.info("values====================" + values);
			if (category.getCropId() == null || category.getCropId() == "") {

				em.createNamedStoredProcedureQuery("project_crop_routines").setParameter("actionType", "addCrop")
						.setParameter("actionValue", values).execute();
			} else {

				em.createNamedStoredProcedureQuery("project_crop_routines").setParameter("actionType", "modifyCrop")
						.setParameter("actionValue", values).execute();
			}

		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveCropDao Dao ends");
		return response;
	}

	// FOR Category DELETE

	public ResponseEntity<JsonResponse<Object>> deleteCropDao(String id) {
		logger.info("Method : deleteCrop  starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_cropId='" + id + "';";
				em.createNamedStoredProcedureQuery("project_crop_routines").setParameter("actionType", "deleteCrop")
						.setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteCrop  ends");
		return response;
	}

	// FOR PROJECT Crop Process DAO VIEW STARTS
	@SuppressWarnings("unchecked")

	public JsonResponse<Object> cropProcessViewDao(String userid, String org, String div, String id) {

		logger.info("Method : cropProcessView Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + userid + "',@p_org='" + org + "',@p_orgDiv='" + div + "',@p_id='" + id + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("project_crop_routines")
					.setParameter("actionType", "processView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : cropProcessView Dao ends");
		logger.info("resp****************************" + resp);
		return resp;

	}
	
	public ResponseEntity<JsonResponse<Object>> saveCropProcessDao(RestProjectCropModel category) {
		logger.info("Method : saveCropProcess Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateProjectCropParameter.getProjectCropProcessParam(category);
			
			System.out.println(values);

			if (category.getCropProcessId() == null || category.getCropProcessId() == "") {

				em.createNamedStoredProcedureQuery("project_crop_routines").setParameter("actionType", "addCropProcess")
						.setParameter("actionValue", values).execute();
			} else {

				em.createNamedStoredProcedureQuery("project_crop_routines").setParameter("actionType", "modifyCropProcess")
						.setParameter("actionValue", values).execute();
			}

		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveCropProcess Dao ends");
		return response;
	}
	
	// FOR Crop Process DELETE

		public ResponseEntity<JsonResponse<Object>> deleteCropProcessDao(String id) {
			logger.info("Method : deleteCropProcess Dao  starts");

			Boolean validity = true;
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");

			if (validity)
				try {
					String value = "SET @p_cropProcessId='" + id + "';";
					logger.info(value);
					em.createNamedStoredProcedureQuery("project_crop_routines").setParameter("actionType", "deleteCropProcess")
							.setParameter("actionValue", value).execute();

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

			logger.info("Method : deleteCropProcess Dao  ends");
			return response;
		}

}
