package nirmalya.aatithya.restmodule.grc.dao;

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
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateInspectionGenerateParam;
import nirmalya.aatithya.restmodule.grc.model.InspectionGenerateRestModel;
import nirmalya.aatithya.restmodule.grc.model.InspectionGenerateRestSubModel;

@Repository
public class InspectionGenerateRestDao {
	Logger logger = LoggerFactory.getLogger(InspectionGenerateRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// viewChecklist
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InspectionGenerateRestSubModel>>> viewChecklist(String id, String org,
			String orgDiv) {
		logger.info("Method : viewChecklist starts");
		List<InspectionGenerateRestSubModel> respList = new ArrayList<InspectionGenerateRestSubModel>();
		try {
			String values = "SET @p_createdBy='" + id + "',@p_orgname='" + org + "',@p_orgdiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_creation_routines")
					.setParameter("actionType", "viewChecklist").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				InspectionGenerateRestSubModel restPayroll = new InspectionGenerateRestSubModel(m[0], m[1], m[2], m[3]);
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<InspectionGenerateRestSubModel>> resp = new JsonResponse<List<InspectionGenerateRestSubModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<InspectionGenerateRestSubModel>>> response = new ResponseEntity<JsonResponse<List<InspectionGenerateRestSubModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewChecklist ends" + respList);
		return response;
	}

	// add safety
	public ResponseEntity<JsonResponse<InspectionGenerateRestModel>> addInspectionGenerate(
			InspectionGenerateRestModel model) {
		logger.info("Method : addSafetyIdentification starts" + model.getInspectionId());

		JsonResponse<InspectionGenerateRestModel> resp = new JsonResponse<InspectionGenerateRestModel>();
		InspectionGenerateRestModel listData = new InspectionGenerateRestModel();

		try {
			String values = GenerateInspectionGenerateParam.getAddQuotParam(model);
			if (model.getInspectionId() == "" || model.getInspectionId() == null) {

				em.createNamedStoredProcedureQuery("inspection_creation_routines").setParameter("actionType", "addData")
						.setParameter("actionValue", values).execute();
			} else {
				logger.info("Modify" + model.getInspectionId());
				values = GenerateInspectionGenerateParam.getAddQuotParamMod(model);
				em.createNamedStoredProcedureQuery("inspection_creation_routines").setParameter("actionType", "modData")
						.setParameter("actionValue", values).execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<InspectionGenerateRestModel>> response = new ResponseEntity<JsonResponse<InspectionGenerateRestModel>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addSafetyIdentification ends" + response);
		return response;
	}

	// viewInspection
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InspectionGenerateRestModel>>> viewInspection(String id, String uId,
			String org, String orgDiv) {
		logger.info("Method : viewInspection starts");
		List<InspectionGenerateRestModel> respList = new ArrayList<InspectionGenerateRestModel>();
		try {
			String values = "SET @p_projectId='" + id + "',@p_createdBy='" + uId + "',@p_orgname='" + org
					+ "',@p_orgdiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_creation_routines")
					.setParameter("actionType", "viewInspection").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				InspectionGenerateRestModel restPayroll = new InspectionGenerateRestModel(m[0], m[1], m[2],
						m[3].toString());
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<InspectionGenerateRestModel>> resp = new JsonResponse<List<InspectionGenerateRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<InspectionGenerateRestModel>>> response = new ResponseEntity<JsonResponse<List<InspectionGenerateRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewInspection ends" + respList);
		return response;
	}

	// viewInspection
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InspectionGenerateRestModel>>> editInspection(String id, String type,
			String org, String orgDiv) {
		logger.info("Method : viewInspection starts");
		JsonResponse<List<InspectionGenerateRestModel>> resp = new JsonResponse<List<InspectionGenerateRestModel>>();
		List<InspectionGenerateRestModel> respList = new ArrayList<InspectionGenerateRestModel>();
		// List<InspectionGenerateRestSubModel> sublist = new
		// ArrayList<InspectionGenerateRestSubModel>();
		try {
			String values = "SET @p_inspectionId='" + id + "',@p_type='" + type + "',@p_orgname='" + org
					+ "',@p_orgdiv='" + orgDiv + "';";
			logger.info("values" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_creation_routines")
					.setParameter("actionType", "editInspection").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				InspectionGenerateRestModel List = new InspectionGenerateRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11]);
				respList.add(List);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<InspectionGenerateRestModel>>> response = new ResponseEntity<JsonResponse<List<InspectionGenerateRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewInspection ends" + respList);
		return response;
	}

	// auto search

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorAutoSearchList(String id) {
		logger.info("Method : getVendorAutoSearchList dao starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_creation_routines")
					.setParameter("actionType", "getVendor").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getVendorAutoSearchList dao ends");
		return response;
	}

	// add addAssignedTo
	public ResponseEntity<JsonResponse<List<InspectionGenerateRestSubModel>>> addAssignedTo(
			List<InspectionGenerateRestSubModel> model) {
		logger.info("Method : addAssignedTo starts" + model);

		JsonResponse<List<InspectionGenerateRestSubModel>> resp = new JsonResponse<List<InspectionGenerateRestSubModel>>();
		List<InspectionGenerateRestSubModel> listData = new ArrayList<InspectionGenerateRestSubModel>();

		try {
			String values = GenerateInspectionGenerateParam.getAddAssignParam(model);
			em.createNamedStoredProcedureQuery("inspection_creation_routines")
					.setParameter("actionType", "addAssignedTo").setParameter("actionValue", values).execute();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<InspectionGenerateRestSubModel>>> response = new ResponseEntity<JsonResponse<List<InspectionGenerateRestSubModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addAssignedTo ends" + response);
		return response;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteinspectionDetails(String id, String organization,
			String orgDivision) {
		logger.info("Method : deleteinspectionDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_inspctId='" + id + "'," + "@p_organization='" + organization
						+ "',@p_orgDivision='" + orgDivision + "';";
				logger.info("IDD" + value);
				em.createNamedStoredProcedureQuery("inspection_creation_routines")
						.setParameter("actionType", "deleteinspectionDetails").setParameter("actionValue", value)
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteinspectionDetails ends"+response);
		return response;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deletecheckListDetails(String id, String checkId, String organization,
			String orgDivision) {
		logger.info("Method : deletecheckListDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_inspctId='" + id + "' ,@p_checkId='" + checkId + "'," + "@p_organization='"
						+ organization + "',@p_orgDivision='" + orgDivision + "';";
				logger.info("IDD" + value);
				em.createNamedStoredProcedureQuery("inspection_creation_routines")
						.setParameter("actionType", "deletecheckListDetails").setParameter("actionValue", value)
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deletecheckListDetails ends");
		logger.info("DELETEE" + response);
		return response;
	}
}
