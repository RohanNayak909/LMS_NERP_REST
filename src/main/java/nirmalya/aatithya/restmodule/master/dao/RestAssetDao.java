package nirmalya.aatithya.restmodule.master.dao;

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
import nirmalya.aatithya.restmodule.common.utils.GenerateAssetClassificationParameter;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestAssetModel;


@Repository
public class RestAssetDao {
	Logger logger = LoggerFactory.getLogger(RestAssetDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	public ResponseEntity<JsonResponse<RestAssetModel>> saveAssetClassification(RestAssetModel classification) {
		logger.info("Method : saveDemoCategory saveAssetClassification");

		Boolean validity = true;
		JsonResponse<RestAssetModel> resp = new JsonResponse<RestAssetModel>();
		resp.setMessage("");
		resp.setCode("");

		List<RestAssetModel> newLoc = new ArrayList<RestAssetModel>();

		if (classification.getAssetName() == null || classification.getAssetName() == "") {
			resp.setMessage("Asset Name Required");
			validity = false;
		} else if (classification.getAssetDesc() == null || classification.getAssetDesc() == "") {
			resp.setMessage("Asset Description Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateAssetClassificationParameter.saveAssetClassification(classification);

				if (classification.getAssetId() != null && classification.getAssetId() != "") {

					em.createNamedStoredProcedureQuery("assetRoutines").setParameter("actionType", "modifyAsset")
							.setParameter("actionValue", values).getResultList();

				} else {

					em.createNamedStoredProcedureQuery("assetRoutines")
							.setParameter("actionType", "addAssetClassification").setParameter("actionValue", values)
							.getResultList();

				}

// resp.setBody(newLoc.get(0));
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

		ResponseEntity<JsonResponse<RestAssetModel>> response = new ResponseEntity<JsonResponse<RestAssetModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveAssetClassification ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAssetModel>>> getAllAssetList() {
		logger.info("Method : getAllAssetList starts");

		JsonResponse<List<RestAssetModel>> resp = new JsonResponse<List<RestAssetModel>>();
		List<RestAssetModel> newLoc = new ArrayList<RestAssetModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("assetRoutines")
					.setParameter("actionType", "getAssetView").setParameter("actionValue", "").getResultList();
			for (Object[] m : x) {

				RestAssetModel item = new RestAssetModel(m[0], m[1], null, null, m[2], null, m[3], m[4], m[5]);
				newLoc.add(item);
			}

			resp.setBody(newLoc);
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

		ResponseEntity<JsonResponse<List<RestAssetModel>>> response = new ResponseEntity<JsonResponse<List<RestAssetModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAllAssetList ends");
		return response;
	}

	public ResponseEntity<JsonResponse<RestAssetModel>> saveAssetSubCategory(RestAssetModel category) {
		logger.info("Method : saveAssetSubCategory starts");

		Boolean validity = true;
		JsonResponse<RestAssetModel> resp = new JsonResponse<RestAssetModel>();
		resp.setMessage("");
		resp.setCode("");

		if (category.getAssetName() == null || category.getAssetName() == "") {
			resp.setMessage("Asset Name Required");
			validity = false;
		} else if (category.getAssetDesc() == null || category.getAssetDesc() == "") {
			resp.setMessage("Asset Description Required");
			validity = false;
		}

		if (validity)
			try {
				String values = GenerateAssetClassificationParameter.saveAssetClassification(category);

				if (category.getAssetId() != null && category.getAssetId() != "") {

					em.createNamedStoredProcedureQuery("assetRoutines").setParameter("actionType", "modifyAsset")
							.setParameter("actionValue", values).execute();

				} else {

					em.createNamedStoredProcedureQuery("assetRoutines").setParameter("actionType", "addSubAsset")
							.setParameter("actionValue", values).execute();

				}

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

		ResponseEntity<JsonResponse<RestAssetModel>> response = new ResponseEntity<JsonResponse<RestAssetModel>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : saveAssetSubCategory ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<RestAssetModel>> getAssetById(String id) {
		logger.info("Method : getAssetById starts");
		logger.info(id);
		JsonResponse<RestAssetModel> resp = new JsonResponse<RestAssetModel>();
		List<RestAssetModel> newLoc = new ArrayList<RestAssetModel>();

		try {
			String value = "SET @P_Asset='" + id + "';";

			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetRoutines")
					.setParameter("actionType", "getEditAssetById").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestAssetModel item = new RestAssetModel(m[0], m[1], m[2], m[3], m[4], null, m[5], m[6], null);
				newLoc.add(item);
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

		ResponseEntity<JsonResponse<RestAssetModel>> response = new ResponseEntity<JsonResponse<RestAssetModel>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : getAssetById ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteAsset(String id, String createdBy) {
		logger.info("Method : deleteAsset starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @P_PAsset='" + id + "', @P_ModifiedBy='" + createdBy + "';";
			em.createNamedStoredProcedureQuery("assetRoutines").setParameter("actionType", "deleteAsset")
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
		logger.info("Method : deleteAsset ends");
		return response;
	}
}
