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

public class AuditMasterRestDao {

	Logger logger = LoggerFactory.getLogger(AuditMasterRestDao.class);

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditType(String organization, String orgDivision) {
		// TODO Auto-generated method stub
		logger.info("Method : getAuditType starts");
		List<DropDownModel> getAuditType = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("Valueee------>>>"+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getAuditTypes").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAuditType.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAuditType end"+getAuditType);
		return getAuditType;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAgencyList(String organization, String orgDivision) {
		// TODO Auto-generated method stub
		logger.info("Method : getAgencyList starts");
		List<DropDownModel> getAgencyList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getAgencyList").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAgencyList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAgencyList end");
		return getAgencyList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditorList(String organization, String orgDivision) {
		logger.info("Method : getAuditorList starts");
		List<DropDownModel> getAuditorList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getAuditorList").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAuditorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAuditorList end");
		return getAuditorList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getIAuditorList(String organization, String orgDivision) {
		logger.info("Method : getIAuditorList starts");
		List<DropDownModel> getAuditorList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getInternalAuditorList").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAuditorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getIAuditorList end");
		return getAuditorList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getEAuditorList(String organization, String orgDivision) {
		logger.info("Method : getEAuditorList starts");
		List<DropDownModel> getAuditorList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getExternalAuditorList").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAuditorList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getEAuditorList end");
		return getAuditorList;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getAuditorSpecialisationList(String organization, String orgDivision) {
		logger.info("Method : getAuditorSpecialisationList starts");
		List<DropDownModel> getAuditorSpecialisationList = new ArrayList<DropDownModel>();
		try {
			String values = "SET @p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "getAuditorSpecialisationList").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getAuditorSpecialisationList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAuditorSpecialisationList end");
		return getAuditorSpecialisationList;
	}

	// add addAuditMasterData
	public ResponseEntity<JsonResponse<Object>> addAuditMasterData(AuditMasterRestModel model) {
		logger.info("Method : addAuditMasterData starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateAuditMasterParam.getAddQuotParam(model);
			if (model.getAuditorId() == "" || model.getAuditorId() == null) {
				em.createNamedStoredProcedureQuery("auditmaster_routines").setParameter("actionType", "addAuditMaster")
						.setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("auditmaster_routines")
						.setParameter("actionType", "modifyAuditMaster").setParameter("actionValue", values).execute();
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

		logger.info("Method in Dao: addAuditMasterData ends" + response);

		return response;
	}

	// getInternalAuditorData
	@SuppressWarnings("unchecked")
	public JsonResponse<List<AuditMasterRestModel>> getInternalAuditorData(String organization, String orgDivision) {
		logger.info("Method : getInternalAuditorData Dao starts");
		Integer total = 0;
		List<AuditMasterRestModel> req = new ArrayList<AuditMasterRestModel>();
		JsonResponse<List<AuditMasterRestModel>> resp = new JsonResponse<List<AuditMasterRestModel>>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "get_internal_auditMaster").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				AuditMasterRestModel reqEdit = new AuditMasterRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6]);

				req.add(reqEdit);
				total = total + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(req);
		resp.setTotal(total);
		logger.info("Method : getInternalAuditorData Dao ends");
		return resp;
	}

	// getExternalAuditorData
	@SuppressWarnings("unchecked")
	public JsonResponse<List<AuditMasterRestModel>> getExternalAuditorData(String organization, String orgDivision) {
		// TODO Auto-generated method stub
		logger.info("Method : getExternalAuditorData Dao starts");
		List<AuditMasterRestModel> req = new ArrayList<AuditMasterRestModel>();
		JsonResponse<List<AuditMasterRestModel>> resp = new JsonResponse<List<AuditMasterRestModel>>();
		Integer total = 0;
		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "get_external_auditMaster").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				AuditMasterRestModel reqEdit = new AuditMasterRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7],
						m[8], m[9]);

				req.add(reqEdit);
				total = total + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(req);
		resp.setTotal(total);
		logger.info("Method : getExternalAuditorData Dao ends");
		return resp;
	}

	// add addAuditCategorySavedata
	public ResponseEntity<JsonResponse<Object>> addAuditCategorySavedata(AuditMasterRestModel model) {
		logger.info("Method : addAuditCategorySavedata starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateAuditMasterParam.getAddAuditCategoryParam(model);
			if (model.getAudit_category_id() == "" || model.getAudit_category_id() == null) {
				em.createNamedStoredProcedureQuery("auditmaster_routines")
						.setParameter("actionType", "addAuditCategoryMaster").setParameter("actionValue", values)
						.execute();
			} else {
				em.createNamedStoredProcedureQuery("auditmaster_routines")
						.setParameter("actionType", "modifyAuditCategoryMaster").setParameter("actionValue", values)
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

		logger.info("Method in Dao: addAuditCategorySavedata ends" + response);

		return response;
	}

	// getViewAuditCategoryData
	@SuppressWarnings("unchecked")
	public JsonResponse<List<AuditMasterRestModel>> getViewAuditCategoryData(String organization, String orgDivision) {
		// TODO Auto-generated method stub
		logger.info("Method : getViewAuditCategoryData Dao starts");
		Integer total = 0;
		List<AuditMasterRestModel> req = new ArrayList<AuditMasterRestModel>();
		JsonResponse<List<AuditMasterRestModel>> resp = new JsonResponse<List<AuditMasterRestModel>>();

		try {
			String value = "SET @P_organization='" + organization + "',@P_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "get_ViewAuditCategory_Data").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				AuditMasterRestModel reqEdit = new AuditMasterRestModel(m[0], m[1], m[2], m[3], m[4]);

				req.add(reqEdit);
				total = total + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(req);
		resp.setTotal(total);
		logger.info("Method : getViewAuditCategoryData Dao ends");
		return resp;
	}

	/* delete deleteAuditCategoryMasterRecord */

	public ResponseEntity<JsonResponse<Object>> deleteAuditCategoryMasterRecord(String id) {
		logger.info("Method : deleteAuditCategoryMasterRecord starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_audit_category_id='" + id + "';";

				em.createNamedStoredProcedureQuery("auditmaster_routines")
						.setParameter("actionType", "deleteAuditCategoryMasterRecord")
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

		logger.info("Method : deleteAuditCategoryMasterRecord ends");
		return response;
	}

	/* delete deleteAuditInternalMasterDelete */

	public ResponseEntity<JsonResponse<Object>> deleteAuditInternalMasterDelete(String id) {
		logger.info("Method : deleteAuditInternalMasterDelete starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_auditor_id='" + id + "';";

				em.createNamedStoredProcedureQuery("auditmaster_routines")
						.setParameter("actionType", "deleteAuditInternalMasterDelete")
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

		logger.info("Method : deleteAuditInternalMasterDelete ends");
		return response;
	}

	/* delete deleteAuditExternalMasterDelete */
	public ResponseEntity<JsonResponse<Object>> deleteAuditExternalMasterDelete(String id) {
		logger.info("Method : deleteAuditExternalMasterDelete check starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_auditor_id='" + id + "';";

				em.createNamedStoredProcedureQuery("auditmaster_routines")
						.setParameter("actionType", "deleteAuditExternalMasterDelete")
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

		logger.info("Method : deleteAuditExternalMasterDelete check ends");
		return response;
	}

	/* editAuditMasterCategoryData */
	@SuppressWarnings("unchecked")
	public JsonResponse<AuditMasterRestModel> editAuditMasterCategoryData(String id, String orgName, String orgDivision,
			String uId) {
		logger.info("Method : editAuditMasterCategoryData Dao starts");
		AuditMasterRestModel req = new AuditMasterRestModel();
		JsonResponse<AuditMasterRestModel> resp = new JsonResponse<AuditMasterRestModel>();
		try {
			String value = "SET @p_audit_category_id='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "editAuditMasterCategoryDataGet").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				AuditMasterRestModel restDaata = new AuditMasterRestModel(m[0], m[1], m[2], m[3], m[4]);
				req = restDaata;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editAuditMasterCategoryData Dao ends");
		return resp;
	}

	/* editAuditMasterData */
	@SuppressWarnings("unchecked")
	public JsonResponse<AuditMasterRestModel> editAuditMasterData(String id, String orgName, String orgDivision,
			String uId) {
		logger.info("Method : editAuditMasterData Dao starts");
		AuditMasterRestModel req = new AuditMasterRestModel();
		JsonResponse<AuditMasterRestModel> resp = new JsonResponse<AuditMasterRestModel>();
		try {
			String value = "SET @p_auditor_id='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("auditmaster_routines")
					.setParameter("actionType", "editAuditMasterDataGet").setParameter("actionValue", value)
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
		logger.info("Method : editAuditMasterData Dao ends");
		return resp;
	}

}
