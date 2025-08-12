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
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateAuditMasterParam;
import nirmalya.aatithya.restmodule.grc.model.AuditMasterRestModel;

@Repository
public class RestInspectionMasterDao {

	Logger logger = LoggerFactory.getLogger(RestInspectionMasterDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getInspectionType(String organization, String orgDivision) {
		// TODO Auto-generated method stub
		logger.info("Method : getInspectionType starts");
		List<DropDownModel> getAuditType = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "getInspectionType").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAuditType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getInspectionType end");
		return getAuditType;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<AuditMasterRestModel>> viewInternalInspectionData(String organization,
			String orgDivision) {
		logger.info("Method : viewInternalInspectionData Dao starts");
		Integer total = 0;
		List<AuditMasterRestModel> req = new ArrayList<AuditMasterRestModel>();
		JsonResponse<List<AuditMasterRestModel>> resp = new JsonResponse<List<AuditMasterRestModel>>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "viewInternalInspectData").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				AuditMasterRestModel reqEdit = new AuditMasterRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], null);

				req.add(reqEdit);
				total = total + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(req);
		resp.setTotal(total);
		logger.info("Method : viewInternalInspectionData Dao ends" + resp);
		return resp;
	}

	public ResponseEntity<JsonResponse<Object>> addInspectionData(AuditMasterRestModel model) {
		logger.info("Method : addInspectionData starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateAuditMasterParam.getAddQuotParam(model);
			System.out.println(values);
			if (model.getInspectionorId() == "" || model.getInspectionorId() == null) {
				em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "addInspectionData").setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "modifyInspectionData").setParameter("actionValue", values)
						.execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		if (resp.getMessage() == null) {
			resp.setMessage("Success");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method in Dao: addInspectionData ends" + response);

		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<AuditMasterRestModel>> viewInspectionCategory(String organization, String orgDivision) {
		// TODO Auto-generated method stub
		logger.info("Method : viewInspectionCategory Dao starts");
		Integer total = 0;
		List<AuditMasterRestModel> req = new ArrayList<AuditMasterRestModel>();
		JsonResponse<List<AuditMasterRestModel>> resp = new JsonResponse<List<AuditMasterRestModel>>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "viewInspectionCategory").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				AuditMasterRestModel reqEdit = new AuditMasterRestModel(m[0], m[1], m[2], null, m[3]);

				req.add(reqEdit);
				total = total + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(req);
		resp.setTotal(total);
		logger.info("Method : viewInspectionCategory Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<List<AuditMasterRestModel>> viewExternalInspectionData(String organization,
			String orgDivision) {
		// TODO Auto-generated method stub
		logger.info("Method : viewExternalInspectionData Dao starts");
		List<AuditMasterRestModel> req = new ArrayList<AuditMasterRestModel>();
		JsonResponse<List<AuditMasterRestModel>> resp = new JsonResponse<List<AuditMasterRestModel>>();
		Integer total = 0;
		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "get_external_inspection").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				AuditMasterRestModel reqEdit = new AuditMasterRestModel(m[0], null, m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], null);

				req.add(reqEdit);
				total = total + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(req);
		resp.setTotal(total);
		logger.info("Method : viewExternalInspectionData Dao ends");
		return resp;
	}

	// add addInspectCategorySavedata
	public ResponseEntity<JsonResponse<Object>> addInspectCategorySavedata(AuditMasterRestModel model) {
		logger.info("Method : addInspectCategorySavedata starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateAuditMasterParam.getAddAuditCategoryParam(model);
			if (model.getAudit_category_id() == "" || model.getAudit_category_id() == null) {
				em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "addInspectCategory").setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "modifyInspectCategory").setParameter("actionValue", values)
						.execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		if (resp.getMessage() == null) {
			resp.setMessage("Success");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method in Dao: addInspectCategorySavedata ends" + response);

		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<AuditMasterRestModel> editInspectionMasterCategory(String id, String orgName,
			String orgDivision, String uId) {
		logger.info("Method : editInspectionMasterCategory Dao starts");
		AuditMasterRestModel req = new AuditMasterRestModel();
		JsonResponse<AuditMasterRestModel> resp = new JsonResponse<AuditMasterRestModel>();
		try {
			String value = "SET @p_category_id='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "editInspectionMstrCat").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				AuditMasterRestModel restDaata = new AuditMasterRestModel(m[0], m[1], m[2], null, m[3]);
				req = restDaata;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editInspectionMasterCategory Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<AuditMasterRestModel> editInspectionMaster(String id, String orgName, String orgDivision,
			String uId) {
		logger.info("Method : editInspectionMaster Dao starts");
		AuditMasterRestModel req = new AuditMasterRestModel();
		JsonResponse<AuditMasterRestModel> resp = new JsonResponse<AuditMasterRestModel>();
		try {
			String value = "SET @p_inspection_id='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "editInspectionMaster").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				AuditMasterRestModel restDaata = new AuditMasterRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10]);
				req = restDaata;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editInspectionMaster Dao ends");
		return resp;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteIncCatMaster(String id) {
		logger.info("Method : deleteIncCatMaster starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_audit_category_id='" + id + "';";

				em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "deleteIncCatMaster").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteIncCatMaster ends");
		return response;
	}

	/* delete deleteAuditInternalMasterDelete */

	public ResponseEntity<JsonResponse<Object>> deleteIncInternalDelete(String id) {
		logger.info("Method : deleteIncInternalDelete starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_inspection_id='" + id + "';";

				em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "deleteIncInternalDelete").setParameter("actionValue", value)
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

		logger.info("Method : deleteIncInternalDelete ends");
		return response;
	}

	/* delete deleteAuditExternalMasterDelete */
	public ResponseEntity<JsonResponse<Object>> deleteIncExternalDelete(String id) {
		logger.info("Method : deleteIncExternalDelete check starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_inspection_id='" + id + "';";

				em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "deleteIncExternalDelete").setParameter("actionValue", value)
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

		logger.info("Method : deleteIncExternalDelete check ends");
		return response;
	}
}
